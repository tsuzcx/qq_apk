package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class c$a
{
  private static final Map<Integer, Long> qEk;
  
  static
  {
    AppMethodBeat.i(57493);
    qEk = new HashMap();
    AppMethodBeat.o(57493);
  }
  
  /* Error */
  static boolean ac(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 33
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: lload_1
    //   9: lconst_0
    //   10: lcmp
    //   11: ifge +35 -> 46
    //   14: ldc 35
    //   16: ldc 37
    //   18: iconst_1
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: lload_1
    //   25: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: aastore
    //   29: invokestatic 49	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: ldc 33
    //   34: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iconst_0
    //   38: istore 5
    //   40: ldc 2
    //   42: monitorexit
    //   43: iload 5
    //   45: ireturn
    //   46: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:qEk	Ljava/util/Map;
    //   49: iload_0
    //   50: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: invokeinterface 60 2 0
    //   58: ifne +6 -> 64
    //   61: invokestatic 63	com/tencent/mm/plugin/secinforeport/c$a:ph	()V
    //   64: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:qEk	Ljava/util/Map;
    //   67: iload_0
    //   68: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokeinterface 67 2 0
    //   76: checkcast 39	java/lang/Long
    //   79: astore 6
    //   81: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   84: lstore_3
    //   85: aload 6
    //   87: ifnull +13 -> 100
    //   90: lload_3
    //   91: aload 6
    //   93: invokevirtual 76	java/lang/Long:longValue	()J
    //   96: lcmp
    //   97: ifge +34 -> 131
    //   100: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:qEk	Ljava/util/Map;
    //   103: iload_0
    //   104: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: lconst_0
    //   108: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: invokeinterface 80 3 0
    //   116: pop
    //   117: invokestatic 83	com/tencent/mm/plugin/secinforeport/c$a:save	()V
    //   120: ldc 33
    //   122: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_0
    //   126: istore 5
    //   128: goto -88 -> 40
    //   131: lload_3
    //   132: aload 6
    //   134: invokevirtual 76	java/lang/Long:longValue	()J
    //   137: lsub
    //   138: lload_1
    //   139: lcmp
    //   140: ifle +34 -> 174
    //   143: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:qEk	Ljava/util/Map;
    //   146: iload_0
    //   147: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: lload_3
    //   151: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   154: invokeinterface 80 3 0
    //   159: pop
    //   160: invokestatic 83	com/tencent/mm/plugin/secinforeport/c$a:save	()V
    //   163: ldc 33
    //   165: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_1
    //   169: istore 5
    //   171: goto -131 -> 40
    //   174: ldc 33
    //   176: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iconst_0
    //   180: istore 5
    //   182: goto -142 -> 40
    //   185: astore 6
    //   187: ldc 2
    //   189: monitorexit
    //   190: aload 6
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramInt	int
    //   0	193	1	paramLong	long
    //   84	67	3	l	long
    //   38	143	5	bool	boolean
    //   79	54	6	localLong	Long
    //   185	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	8	185	finally
    //   14	37	185	finally
    //   46	64	185	finally
    //   64	85	185	finally
    //   90	100	185	finally
    //   100	125	185	finally
    //   131	168	185	finally
    //   174	179	185	finally
  }
  
  /* Error */
  private static void ph()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 86
    //   7: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 88	java/io/File
    //   13: dup
    //   14: invokestatic 94	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   17: getfield 100	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   20: getstatic 106	com/tencent/mm/plugin/normsg/a/b:pgQ	Lcom/tencent/mm/plugin/normsg/a/b;
    //   23: ldc 108
    //   25: invokevirtual 112	com/tencent/mm/plugin/normsg/a/b:Wd	(Ljava/lang/String;)Ljava/lang/String;
    //   28: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 5
    //   33: new 117	java/io/DataInputStream
    //   36: dup
    //   37: new 119	java/io/FileInputStream
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 125	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 6
    //   51: aload 6
    //   53: astore 5
    //   55: aload 6
    //   57: invokevirtual 129	java/io/DataInputStream:readShort	()S
    //   60: sipush -774
    //   63: if_icmpeq +75 -> 138
    //   66: aload 6
    //   68: astore 5
    //   70: new 131	java/lang/IllegalStateException
    //   73: dup
    //   74: ldc 133
    //   76: invokespecial 136	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   79: astore 7
    //   81: aload 6
    //   83: astore 5
    //   85: ldc 86
    //   87: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload 6
    //   92: astore 5
    //   94: aload 7
    //   96: athrow
    //   97: astore 7
    //   99: aload 6
    //   101: astore 5
    //   103: ldc 35
    //   105: ldc 138
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 7
    //   115: aastore
    //   116: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload 6
    //   121: ifnull +205 -> 326
    //   124: aload 6
    //   126: invokevirtual 144	java/io/DataInputStream:close	()V
    //   129: ldc 86
    //   131: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: ldc 2
    //   136: monitorexit
    //   137: return
    //   138: aload 6
    //   140: astore 5
    //   142: aload 6
    //   144: invokevirtual 129	java/io/DataInputStream:readShort	()S
    //   147: pop
    //   148: aload 6
    //   150: astore 5
    //   152: aload 6
    //   154: invokevirtual 148	java/io/DataInputStream:readInt	()I
    //   157: istore_1
    //   158: iload_1
    //   159: ifge +70 -> 229
    //   162: aload 6
    //   164: astore 5
    //   166: new 131	java/lang/IllegalStateException
    //   169: dup
    //   170: ldc 150
    //   172: invokespecial 136	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   175: astore 7
    //   177: aload 6
    //   179: astore 5
    //   181: ldc 86
    //   183: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload 6
    //   188: astore 5
    //   190: aload 7
    //   192: athrow
    //   193: astore 7
    //   195: aload 5
    //   197: astore 6
    //   199: aload 7
    //   201: astore 5
    //   203: aload 6
    //   205: ifnull +8 -> 213
    //   208: aload 6
    //   210: invokevirtual 144	java/io/DataInputStream:close	()V
    //   213: ldc 86
    //   215: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload 5
    //   220: athrow
    //   221: astore 5
    //   223: ldc 2
    //   225: monitorexit
    //   226: aload 5
    //   228: athrow
    //   229: iload_0
    //   230: iload_1
    //   231: if_icmpge +51 -> 282
    //   234: aload 6
    //   236: astore 5
    //   238: aload 6
    //   240: invokevirtual 148	java/io/DataInputStream:readInt	()I
    //   243: istore_2
    //   244: aload 6
    //   246: astore 5
    //   248: aload 6
    //   250: invokevirtual 153	java/io/DataInputStream:readLong	()J
    //   253: lstore_3
    //   254: aload 6
    //   256: astore 5
    //   258: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:qEk	Ljava/util/Map;
    //   261: iload_2
    //   262: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: lload_3
    //   266: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: invokeinterface 80 3 0
    //   274: pop
    //   275: iload_0
    //   276: iconst_1
    //   277: iadd
    //   278: istore_0
    //   279: goto -50 -> 229
    //   282: aload 6
    //   284: astore 5
    //   286: ldc 35
    //   288: ldc 155
    //   290: invokestatic 157	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload 6
    //   295: invokevirtual 144	java/io/DataInputStream:close	()V
    //   298: ldc 86
    //   300: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: goto -169 -> 134
    //   306: astore 5
    //   308: ldc 86
    //   310: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   313: goto -179 -> 134
    //   316: astore 5
    //   318: ldc 86
    //   320: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: goto -189 -> 134
    //   326: ldc 86
    //   328: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: goto -197 -> 134
    //   334: astore 6
    //   336: goto -123 -> 213
    //   339: astore 5
    //   341: aconst_null
    //   342: astore 6
    //   344: goto -141 -> 203
    //   347: astore 7
    //   349: aconst_null
    //   350: astore 6
    //   352: goto -253 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	278	0	i	int
    //   157	75	1	j	int
    //   243	19	2	k	int
    //   253	13	3	l	long
    //   31	188	5	localObject1	Object
    //   221	6	5	localObject2	Object
    //   236	49	5	localObject3	Object
    //   306	1	5	localException1	java.lang.Exception
    //   316	1	5	localException2	java.lang.Exception
    //   339	1	5	localObject4	Object
    //   49	245	6	localObject5	Object
    //   334	1	6	localException3	java.lang.Exception
    //   342	9	6	localObject6	Object
    //   79	16	7	localIllegalStateException1	java.lang.IllegalStateException
    //   97	17	7	localException4	java.lang.Exception
    //   175	16	7	localIllegalStateException2	java.lang.IllegalStateException
    //   193	7	7	localObject7	Object
    //   347	1	7	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   55	66	97	java/lang/Exception
    //   70	81	97	java/lang/Exception
    //   85	90	97	java/lang/Exception
    //   94	97	97	java/lang/Exception
    //   142	148	97	java/lang/Exception
    //   152	158	97	java/lang/Exception
    //   166	177	97	java/lang/Exception
    //   181	186	97	java/lang/Exception
    //   190	193	97	java/lang/Exception
    //   238	244	97	java/lang/Exception
    //   248	254	97	java/lang/Exception
    //   258	275	97	java/lang/Exception
    //   286	293	97	java/lang/Exception
    //   55	66	193	finally
    //   70	81	193	finally
    //   85	90	193	finally
    //   94	97	193	finally
    //   103	119	193	finally
    //   142	148	193	finally
    //   152	158	193	finally
    //   166	177	193	finally
    //   181	186	193	finally
    //   190	193	193	finally
    //   238	244	193	finally
    //   248	254	193	finally
    //   258	275	193	finally
    //   286	293	193	finally
    //   5	33	221	finally
    //   124	129	221	finally
    //   129	134	221	finally
    //   208	213	221	finally
    //   213	221	221	finally
    //   293	298	221	finally
    //   298	303	221	finally
    //   308	313	221	finally
    //   318	323	221	finally
    //   326	331	221	finally
    //   293	298	306	java/lang/Exception
    //   124	129	316	java/lang/Exception
    //   208	213	334	java/lang/Exception
    //   33	51	339	finally
    //   33	51	347	java/lang/Exception
  }
  
  /* Error */
  private static void save()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 158
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 88	java/io/File
    //   11: dup
    //   12: invokestatic 94	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   15: getfield 100	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   18: getstatic 106	com/tencent/mm/plugin/normsg/a/b:pgQ	Lcom/tencent/mm/plugin/normsg/a/b;
    //   21: ldc 108
    //   23: invokevirtual 112	com/tencent/mm/plugin/normsg/a/b:Wd	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 162	java/io/File:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_1
    //   38: invokevirtual 166	java/io/File:getParentFile	()Ljava/io/File;
    //   41: invokevirtual 169	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aconst_null
    //   46: astore_0
    //   47: new 171	java/io/DataOutputStream
    //   50: dup
    //   51: new 173	java/io/FileOutputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 177	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: astore_1
    //   63: aload_1
    //   64: sipush -774
    //   67: invokevirtual 180	java/io/DataOutputStream:writeShort	(I)V
    //   70: aload_1
    //   71: iconst_1
    //   72: invokevirtual 180	java/io/DataOutputStream:writeShort	(I)V
    //   75: aload_1
    //   76: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:qEk	Ljava/util/Map;
    //   79: invokeinterface 183 1 0
    //   84: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   87: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:qEk	Ljava/util/Map;
    //   90: invokeinterface 190 1 0
    //   95: invokeinterface 196 1 0
    //   100: astore_0
    //   101: aload_0
    //   102: invokeinterface 201 1 0
    //   107: ifeq +75 -> 182
    //   110: aload_0
    //   111: invokeinterface 205 1 0
    //   116: checkcast 207	java/util/Map$Entry
    //   119: astore_2
    //   120: aload_1
    //   121: aload_2
    //   122: invokeinterface 210 1 0
    //   127: checkcast 51	java/lang/Integer
    //   130: invokevirtual 213	java/lang/Integer:intValue	()I
    //   133: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   136: aload_1
    //   137: aload_2
    //   138: invokeinterface 216 1 0
    //   143: checkcast 39	java/lang/Long
    //   146: invokevirtual 76	java/lang/Long:longValue	()J
    //   149: invokevirtual 220	java/io/DataOutputStream:writeLong	(J)V
    //   152: goto -51 -> 101
    //   155: astore_0
    //   156: aload_1
    //   157: astore_0
    //   158: ldc 35
    //   160: ldc 222
    //   162: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: ifnull +77 -> 243
    //   169: aload_0
    //   170: invokevirtual 225	java/io/DataOutputStream:close	()V
    //   173: ldc 158
    //   175: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: ldc 2
    //   180: monitorexit
    //   181: return
    //   182: ldc 35
    //   184: ldc 227
    //   186: invokestatic 157	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_1
    //   190: invokevirtual 225	java/io/DataOutputStream:close	()V
    //   193: ldc 158
    //   195: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: goto -20 -> 178
    //   201: astore_0
    //   202: ldc 2
    //   204: monitorexit
    //   205: aload_0
    //   206: athrow
    //   207: astore_0
    //   208: ldc 158
    //   210: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: goto -35 -> 178
    //   216: astore_0
    //   217: ldc 158
    //   219: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: goto -44 -> 178
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_1
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 225	java/io/DataOutputStream:close	()V
    //   236: ldc 158
    //   238: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_0
    //   242: athrow
    //   243: ldc 158
    //   245: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: goto -70 -> 178
    //   251: astore_1
    //   252: goto -16 -> 236
    //   255: astore_0
    //   256: goto -28 -> 228
    //   259: astore_2
    //   260: aload_0
    //   261: astore_1
    //   262: aload_2
    //   263: astore_0
    //   264: goto -36 -> 228
    //   267: astore_1
    //   268: goto -110 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	65	0	localIterator	java.util.Iterator
    //   155	1	0	localException1	java.lang.Exception
    //   157	13	0	localObject1	Object
    //   201	5	0	localObject2	Object
    //   207	1	0	localException2	java.lang.Exception
    //   216	1	0	localException3	java.lang.Exception
    //   225	17	0	localObject3	Object
    //   255	6	0	localObject4	Object
    //   263	1	0	localObject5	Object
    //   29	204	1	localObject6	Object
    //   251	1	1	localException4	java.lang.Exception
    //   261	1	1	localObject7	Object
    //   267	1	1	localException5	java.lang.Exception
    //   119	19	2	localEntry	java.util.Map.Entry
    //   259	4	2	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   63	101	155	java/lang/Exception
    //   101	152	155	java/lang/Exception
    //   182	189	155	java/lang/Exception
    //   3	45	201	finally
    //   169	173	201	finally
    //   173	178	201	finally
    //   189	193	201	finally
    //   193	198	201	finally
    //   208	213	201	finally
    //   217	222	201	finally
    //   232	236	201	finally
    //   236	243	201	finally
    //   243	248	201	finally
    //   189	193	207	java/lang/Exception
    //   169	173	216	java/lang/Exception
    //   47	63	225	finally
    //   232	236	251	java/lang/Exception
    //   63	101	255	finally
    //   101	152	255	finally
    //   182	189	255	finally
    //   158	165	259	finally
    //   47	63	267	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c.a
 * JD-Core Version:    0.7.0.1
 */