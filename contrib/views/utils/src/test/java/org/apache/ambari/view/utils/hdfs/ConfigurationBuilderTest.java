/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ambari.view.utils.hdfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationBuilderTest {
  @Test
  public void testAddProtocolMissing() throws Exception {
    String normalized = ConfigurationBuilder.addProtocolIfMissing("namenode.example.com:50070");
    assertEquals(normalized, "webhdfs://namenode.example.com:50070");
  }

  @Test
  public void testAddProtocolPresent() throws Exception {
    String normalized = ConfigurationBuilder.addProtocolIfMissing("webhdfs://namenode.example.com");
    assertEquals(normalized, "webhdfs://namenode.example.com");
  }

  @Test
  public void testAddPortMissing() throws Exception {
    String normalized = ConfigurationBuilder.addPortIfMissing("webhdfs://namenode.example.com");
    assertEquals(normalized, "webhdfs://namenode.example.com:50070");
  }

  @Test
  public void testAddPortPresent() throws Exception {
    String normalized = ConfigurationBuilder.addPortIfMissing("webhdfs://namenode.example.com:50070");
    assertEquals(normalized, "webhdfs://namenode.example.com:50070");
  }
}
