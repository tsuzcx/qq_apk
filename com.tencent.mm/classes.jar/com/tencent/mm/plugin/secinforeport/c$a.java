package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class c$a
{
  private static final Map<Integer, Long> nQn = new HashMap();
  
  static boolean M(int paramInt, long paramLong)
  {
    if (paramLong < 0L) {}
    for (;;)
    {
      boolean bool;
      try
      {
        y.w("MicroMsg.SecInfoReporterImpl", "bad interval: %s", new Object[] { Long.valueOf(paramLong) });
        bool = false;
        return bool;
      }
      finally {}
      if (!nQn.containsKey(Integer.valueOf(paramInt))) {
        mT();
      }
      Long localLong = (Long)nQn.get(Integer.valueOf(paramInt));
      long l = System.currentTimeMillis();
      if ((localLong == null) || (l < localLong.longValue()))
      {
        nQn.put(Integer.valueOf(paramInt), Long.valueOf(0L));
        save();
        bool = false;
      }
      else if (l - localLong.longValue() > paramLong)
      {
        nQn.put(Integer.valueOf(paramInt), Long.valueOf(l));
        save();
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  /* Error */
  private static void mT()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: new 76	java/io/File
    //   8: dup
    //   9: invokestatic 82	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   12: getfield 88	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   15: getstatic 94	com/tencent/mm/plugin/normsg/a/b:mGK	Lcom/tencent/mm/plugin/normsg/a/b;
    //   18: ldc 96
    //   20: invokevirtual 100	com/tencent/mm/plugin/normsg/a/b:Kd	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: astore 5
    //   28: new 105	java/io/DataInputStream
    //   31: dup
    //   32: new 107	java/io/FileInputStream
    //   35: dup
    //   36: aload 5
    //   38: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: invokespecial 113	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore 6
    //   46: aload 6
    //   48: astore 5
    //   50: aload 6
    //   52: invokevirtual 117	java/io/DataInputStream:readShort	()S
    //   55: sipush -774
    //   58: if_icmpeq +53 -> 111
    //   61: aload 6
    //   63: astore 5
    //   65: new 119	java/lang/IllegalStateException
    //   68: dup
    //   69: ldc 121
    //   71: invokespecial 124	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore 7
    //   77: aload 6
    //   79: astore 5
    //   81: ldc 24
    //   83: ldc 126
    //   85: iconst_1
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload 7
    //   93: aastore
    //   94: invokestatic 129	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload 6
    //   99: ifnull +8 -> 107
    //   102: aload 6
    //   104: invokevirtual 132	java/io/DataInputStream:close	()V
    //   107: ldc 2
    //   109: monitorexit
    //   110: return
    //   111: aload 6
    //   113: astore 5
    //   115: aload 6
    //   117: invokevirtual 117	java/io/DataInputStream:readShort	()S
    //   120: pop
    //   121: aload 6
    //   123: astore 5
    //   125: aload 6
    //   127: invokevirtual 136	java/io/DataInputStream:readInt	()I
    //   130: istore_1
    //   131: iload_1
    //   132: ifge +48 -> 180
    //   135: aload 6
    //   137: astore 5
    //   139: new 119	java/lang/IllegalStateException
    //   142: dup
    //   143: ldc 138
    //   145: invokespecial 124	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   148: athrow
    //   149: astore 7
    //   151: aload 5
    //   153: astore 6
    //   155: aload 7
    //   157: astore 5
    //   159: aload 6
    //   161: ifnull +8 -> 169
    //   164: aload 6
    //   166: invokevirtual 132	java/io/DataInputStream:close	()V
    //   169: aload 5
    //   171: athrow
    //   172: astore 5
    //   174: ldc 2
    //   176: monitorexit
    //   177: aload 5
    //   179: athrow
    //   180: iload_0
    //   181: iload_1
    //   182: if_icmpge +51 -> 233
    //   185: aload 6
    //   187: astore 5
    //   189: aload 6
    //   191: invokevirtual 136	java/io/DataInputStream:readInt	()I
    //   194: istore_2
    //   195: aload 6
    //   197: astore 5
    //   199: aload 6
    //   201: invokevirtual 141	java/io/DataInputStream:readLong	()J
    //   204: lstore_3
    //   205: aload 6
    //   207: astore 5
    //   209: getstatic 19	com/tencent/mm/plugin/secinforeport/c$a:nQn	Ljava/util/Map;
    //   212: iload_2
    //   213: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: lload_3
    //   217: invokestatic 32	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   220: invokeinterface 69 3 0
    //   225: pop
    //   226: iload_0
    //   227: iconst_1
    //   228: iadd
    //   229: istore_0
    //   230: goto -50 -> 180
    //   233: aload 6
    //   235: astore 5
    //   237: ldc 24
    //   239: ldc 143
    //   241: invokestatic 146	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 6
    //   246: invokevirtual 132	java/io/DataInputStream:close	()V
    //   249: goto -142 -> 107
    //   252: astore 5
    //   254: goto -147 -> 107
    //   257: astore 5
    //   259: goto -152 -> 107
    //   262: astore 6
    //   264: goto -95 -> 169
    //   267: astore 5
    //   269: aconst_null
    //   270: astore 6
    //   272: goto -113 -> 159
    //   275: astore 7
    //   277: aconst_null
    //   278: astore 6
    //   280: goto -203 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	229	0	i	int
    //   130	53	1	j	int
    //   194	19	2	k	int
    //   204	13	3	l	long
    //   26	144	5	localObject1	Object
    //   172	6	5	localObject2	Object
    //   187	49	5	localObject3	Object
    //   252	1	5	localException1	java.lang.Exception
    //   257	1	5	localException2	java.lang.Exception
    //   267	1	5	localObject4	Object
    //   44	201	6	localObject5	Object
    //   262	1	6	localException3	java.lang.Exception
    //   270	9	6	localObject6	Object
    //   75	17	7	localException4	java.lang.Exception
    //   149	7	7	localObject7	Object
    //   275	1	7	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   50	61	75	java/lang/Exception
    //   65	75	75	java/lang/Exception
    //   115	121	75	java/lang/Exception
    //   125	131	75	java/lang/Exception
    //   139	149	75	java/lang/Exception
    //   189	195	75	java/lang/Exception
    //   199	205	75	java/lang/Exception
    //   209	226	75	java/lang/Exception
    //   237	244	75	java/lang/Exception
    //   50	61	149	finally
    //   65	75	149	finally
    //   81	97	149	finally
    //   115	121	149	finally
    //   125	131	149	finally
    //   139	149	149	finally
    //   189	195	149	finally
    //   199	205	149	finally
    //   209	226	149	finally
    //   237	244	149	finally
    //   5	28	172	finally
    //   102	107	172	finally
    //   164	169	172	finally
    //   169	172	172	finally
    //   244	249	172	finally
    //   244	249	252	java/lang/Exception
    //   102	107	257	java/lang/Exception
    //   164	169	262	java/lang/Exception
    //   28	46	267	finally
    //   28	46	275	java/lang/Exception
  }
  
  /* Error */
  private static void save()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 76	java/io/File
    //   6: dup
    //   7: invokestatic 82	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   10: getfield 88	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   13: getstatic 94	com/tencent/mm/plugin/normsg/a/b:mGK	Lcom/tencent/mm/plugin/normsg/a/b;
    //   16: ldc 96
    //   18: invokevirtual 100	com/tencent/mm/plugin/normsg/a/b:Kd	(Ljava/lang/String;)Ljava/lang/String;
    //   21: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 150	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 154	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 157	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aconst_null
    //   41: astore_0
    //   42: new 159	java/io/DataOutputStream
    //   45: dup
    //   46: new 161	java/io/FileOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 162	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 165	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: astore_1
    //   58: aload_1
    //   59: sipush -774
    //   62: invokevirtual 169	java/io/DataOutputStream:writeShort	(I)V
    //   65: aload_1
    //   66: iconst_1
    //   67: invokevirtual 169	java/io/DataOutputStream:writeShort	(I)V
    //   70: aload_1
    //   71: getstatic 19	com/tencent/mm/plugin/secinforeport/c$a:nQn	Ljava/util/Map;
    //   74: invokeinterface 172 1 0
    //   79: invokevirtual 175	java/io/DataOutputStream:writeInt	(I)V
    //   82: getstatic 19	com/tencent/mm/plugin/secinforeport/c$a:nQn	Ljava/util/Map;
    //   85: invokeinterface 179 1 0
    //   90: invokeinterface 185 1 0
    //   95: astore_0
    //   96: aload_0
    //   97: invokeinterface 190 1 0
    //   102: ifeq +70 -> 172
    //   105: aload_0
    //   106: invokeinterface 194 1 0
    //   111: checkcast 196	java/util/Map$Entry
    //   114: astore_2
    //   115: aload_1
    //   116: aload_2
    //   117: invokeinterface 199 1 0
    //   122: checkcast 40	java/lang/Integer
    //   125: invokevirtual 202	java/lang/Integer:intValue	()I
    //   128: invokevirtual 175	java/io/DataOutputStream:writeInt	(I)V
    //   131: aload_1
    //   132: aload_2
    //   133: invokeinterface 205 1 0
    //   138: checkcast 28	java/lang/Long
    //   141: invokevirtual 65	java/lang/Long:longValue	()J
    //   144: invokevirtual 209	java/io/DataOutputStream:writeLong	(J)V
    //   147: goto -51 -> 96
    //   150: astore_0
    //   151: aload_1
    //   152: astore_0
    //   153: ldc 24
    //   155: ldc 211
    //   157: invokestatic 213	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 214	java/io/DataOutputStream:close	()V
    //   168: ldc 2
    //   170: monitorexit
    //   171: return
    //   172: ldc 24
    //   174: ldc 216
    //   176: invokestatic 146	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_1
    //   180: invokevirtual 214	java/io/DataOutputStream:close	()V
    //   183: goto -15 -> 168
    //   186: astore_0
    //   187: goto -19 -> 168
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_1
    //   194: ifnull +7 -> 201
    //   197: aload_1
    //   198: invokevirtual 214	java/io/DataOutputStream:close	()V
    //   201: aload_0
    //   202: athrow
    //   203: astore_0
    //   204: ldc 2
    //   206: monitorexit
    //   207: aload_0
    //   208: athrow
    //   209: astore_0
    //   210: goto -42 -> 168
    //   213: astore_1
    //   214: goto -13 -> 201
    //   217: astore_0
    //   218: goto -25 -> 193
    //   221: astore_2
    //   222: aload_0
    //   223: astore_1
    //   224: aload_2
    //   225: astore_0
    //   226: goto -33 -> 193
    //   229: astore_1
    //   230: goto -77 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	65	0	localIterator	java.util.Iterator
    //   150	1	0	localException1	java.lang.Exception
    //   152	13	0	localObject1	Object
    //   186	1	0	localException2	java.lang.Exception
    //   190	12	0	localObject2	Object
    //   203	5	0	localObject3	Object
    //   209	1	0	localException3	java.lang.Exception
    //   217	6	0	localObject4	Object
    //   225	1	0	localObject5	Object
    //   24	174	1	localObject6	Object
    //   213	1	1	localException4	java.lang.Exception
    //   223	1	1	localObject7	Object
    //   229	1	1	localException5	java.lang.Exception
    //   114	19	2	localEntry	java.util.Map.Entry
    //   221	4	2	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   58	96	150	java/lang/Exception
    //   96	147	150	java/lang/Exception
    //   172	179	150	java/lang/Exception
    //   179	183	186	java/lang/Exception
    //   42	58	190	finally
    //   3	40	203	finally
    //   164	168	203	finally
    //   179	183	203	finally
    //   197	201	203	finally
    //   201	203	203	finally
    //   164	168	209	java/lang/Exception
    //   197	201	213	java/lang/Exception
    //   58	96	217	finally
    //   96	147	217	finally
    //   172	179	217	finally
    //   153	160	221	finally
    //   42	58	229	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c.a
 * JD-Core Version:    0.7.0.1
 */