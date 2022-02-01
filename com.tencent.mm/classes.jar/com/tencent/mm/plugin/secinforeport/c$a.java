package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class c$a
{
  private static final Map<Integer, Long> wcA;
  
  static
  {
    AppMethodBeat.i(89170);
    wcA = new HashMap();
    AppMethodBeat.o(89170);
  }
  
  /* Error */
  static boolean as(int paramInt, long paramLong)
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
    //   29: invokestatic 49	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: ldc 33
    //   34: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iconst_0
    //   38: istore 5
    //   40: ldc 2
    //   42: monitorexit
    //   43: iload 5
    //   45: ireturn
    //   46: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:wcA	Ljava/util/Map;
    //   49: iload_0
    //   50: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: invokeinterface 60 2 0
    //   58: ifne +6 -> 64
    //   61: invokestatic 63	com/tencent/mm/plugin/secinforeport/c$a:tP	()V
    //   64: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:wcA	Ljava/util/Map;
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
    //   97: ifge +50 -> 147
    //   100: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:wcA	Ljava/util/Map;
    //   103: iload_0
    //   104: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: lload_3
    //   108: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: invokeinterface 80 3 0
    //   116: pop
    //   117: invokestatic 83	com/tencent/mm/plugin/secinforeport/c$a:save	()V
    //   120: aload 6
    //   122: ifnonnull +14 -> 136
    //   125: ldc 33
    //   127: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: iconst_1
    //   131: istore 5
    //   133: goto -93 -> 40
    //   136: ldc 33
    //   138: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: iconst_0
    //   142: istore 5
    //   144: goto -104 -> 40
    //   147: lload_3
    //   148: aload 6
    //   150: invokevirtual 76	java/lang/Long:longValue	()J
    //   153: lsub
    //   154: lload_1
    //   155: lcmp
    //   156: ifle +34 -> 190
    //   159: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:wcA	Ljava/util/Map;
    //   162: iload_0
    //   163: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: lload_3
    //   167: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   170: invokeinterface 80 3 0
    //   175: pop
    //   176: invokestatic 83	com/tencent/mm/plugin/secinforeport/c$a:save	()V
    //   179: ldc 33
    //   181: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: iconst_1
    //   185: istore 5
    //   187: goto -147 -> 40
    //   190: ldc 33
    //   192: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: istore 5
    //   198: goto -158 -> 40
    //   201: astore 6
    //   203: ldc 2
    //   205: monitorexit
    //   206: aload 6
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramInt	int
    //   0	209	1	paramLong	long
    //   84	83	3	l	long
    //   38	159	5	bool	boolean
    //   79	70	6	localLong	Long
    //   201	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	8	201	finally
    //   14	37	201	finally
    //   46	64	201	finally
    //   64	85	201	finally
    //   90	100	201	finally
    //   100	120	201	finally
    //   125	130	201	finally
    //   136	141	201	finally
    //   147	184	201	finally
    //   190	195	201	finally
  }
  
  /* Error */
  private static void save()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 86
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 88	com/tencent/mm/vfs/e
    //   11: dup
    //   12: invokestatic 94	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   15: getfield 100	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   18: getstatic 106	com/tencent/mm/plugin/normsg/a/b:ufs	Lcom/tencent/mm/plugin/normsg/a/b;
    //   21: ldc 108
    //   23: invokevirtual 112	com/tencent/mm/plugin/normsg/a/b:ajp	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokespecial 115	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 119	com/tencent/mm/vfs/e:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_1
    //   38: invokevirtual 123	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   41: invokevirtual 126	com/tencent/mm/vfs/e:mkdirs	()Z
    //   44: pop
    //   45: aconst_null
    //   46: astore_0
    //   47: new 128	java/io/DataOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokestatic 134	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   55: invokespecial 137	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   58: astore_1
    //   59: aload_1
    //   60: sipush -774
    //   63: invokevirtual 140	java/io/DataOutputStream:writeShort	(I)V
    //   66: aload_1
    //   67: iconst_1
    //   68: invokevirtual 140	java/io/DataOutputStream:writeShort	(I)V
    //   71: aload_1
    //   72: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:wcA	Ljava/util/Map;
    //   75: invokeinterface 144 1 0
    //   80: invokevirtual 147	java/io/DataOutputStream:writeInt	(I)V
    //   83: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:wcA	Ljava/util/Map;
    //   86: invokeinterface 151 1 0
    //   91: invokeinterface 157 1 0
    //   96: astore_0
    //   97: aload_0
    //   98: invokeinterface 162 1 0
    //   103: ifeq +75 -> 178
    //   106: aload_0
    //   107: invokeinterface 166 1 0
    //   112: checkcast 168	java/util/Map$Entry
    //   115: astore_2
    //   116: aload_1
    //   117: aload_2
    //   118: invokeinterface 171 1 0
    //   123: checkcast 51	java/lang/Integer
    //   126: invokevirtual 174	java/lang/Integer:intValue	()I
    //   129: invokevirtual 147	java/io/DataOutputStream:writeInt	(I)V
    //   132: aload_1
    //   133: aload_2
    //   134: invokeinterface 177 1 0
    //   139: checkcast 39	java/lang/Long
    //   142: invokevirtual 76	java/lang/Long:longValue	()J
    //   145: invokevirtual 181	java/io/DataOutputStream:writeLong	(J)V
    //   148: goto -51 -> 97
    //   151: astore_0
    //   152: aload_1
    //   153: astore_0
    //   154: ldc 35
    //   156: ldc 183
    //   158: invokestatic 186	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_0
    //   162: ifnull +77 -> 239
    //   165: aload_0
    //   166: invokevirtual 189	java/io/DataOutputStream:close	()V
    //   169: ldc 86
    //   171: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: ldc 2
    //   176: monitorexit
    //   177: return
    //   178: ldc 35
    //   180: ldc 191
    //   182: invokestatic 193	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload_1
    //   186: invokevirtual 189	java/io/DataOutputStream:close	()V
    //   189: ldc 86
    //   191: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: goto -20 -> 174
    //   197: astore_0
    //   198: ldc 2
    //   200: monitorexit
    //   201: aload_0
    //   202: athrow
    //   203: astore_0
    //   204: ldc 86
    //   206: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: goto -35 -> 174
    //   212: astore_0
    //   213: ldc 86
    //   215: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: goto -44 -> 174
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_1
    //   224: aload_1
    //   225: ifnull +7 -> 232
    //   228: aload_1
    //   229: invokevirtual 189	java/io/DataOutputStream:close	()V
    //   232: ldc 86
    //   234: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_0
    //   238: athrow
    //   239: ldc 86
    //   241: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: goto -70 -> 174
    //   247: astore_1
    //   248: goto -16 -> 232
    //   251: astore_0
    //   252: goto -28 -> 224
    //   255: astore_2
    //   256: aload_0
    //   257: astore_1
    //   258: aload_2
    //   259: astore_0
    //   260: goto -36 -> 224
    //   263: astore_1
    //   264: goto -110 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	61	0	localIterator	java.util.Iterator
    //   151	1	0	localException1	java.lang.Exception
    //   153	13	0	localObject1	Object
    //   197	5	0	localObject2	Object
    //   203	1	0	localException2	java.lang.Exception
    //   212	1	0	localException3	java.lang.Exception
    //   221	17	0	localObject3	Object
    //   251	6	0	localObject4	Object
    //   259	1	0	localObject5	Object
    //   29	200	1	localObject6	Object
    //   247	1	1	localException4	java.lang.Exception
    //   257	1	1	localObject7	Object
    //   263	1	1	localException5	java.lang.Exception
    //   115	19	2	localEntry	java.util.Map.Entry
    //   255	4	2	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   59	97	151	java/lang/Exception
    //   97	148	151	java/lang/Exception
    //   178	185	151	java/lang/Exception
    //   3	45	197	finally
    //   165	169	197	finally
    //   169	174	197	finally
    //   185	189	197	finally
    //   189	194	197	finally
    //   204	209	197	finally
    //   213	218	197	finally
    //   228	232	197	finally
    //   232	239	197	finally
    //   239	244	197	finally
    //   185	189	203	java/lang/Exception
    //   165	169	212	java/lang/Exception
    //   47	59	221	finally
    //   228	232	247	java/lang/Exception
    //   59	97	251	finally
    //   97	148	251	finally
    //   178	185	251	finally
    //   154	161	255	finally
    //   47	59	263	java/lang/Exception
  }
  
  /* Error */
  private static void tP()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 194
    //   7: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 88	com/tencent/mm/vfs/e
    //   13: dup
    //   14: invokestatic 94	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   17: getfield 100	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   20: getstatic 106	com/tencent/mm/plugin/normsg/a/b:ufs	Lcom/tencent/mm/plugin/normsg/a/b;
    //   23: ldc 108
    //   25: invokevirtual 112	com/tencent/mm/plugin/normsg/a/b:ajp	(Ljava/lang/String;)Ljava/lang/String;
    //   28: invokespecial 115	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 5
    //   33: new 196	java/io/DataInputStream
    //   36: dup
    //   37: aload 5
    //   39: invokestatic 200	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   42: invokespecial 203	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore 6
    //   47: aload 6
    //   49: astore 5
    //   51: aload 6
    //   53: invokevirtual 207	java/io/DataInputStream:readShort	()S
    //   56: sipush -774
    //   59: if_icmpeq +75 -> 134
    //   62: aload 6
    //   64: astore 5
    //   66: new 209	java/lang/IllegalStateException
    //   69: dup
    //   70: ldc 211
    //   72: invokespecial 214	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   75: astore 7
    //   77: aload 6
    //   79: astore 5
    //   81: ldc 194
    //   83: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload 6
    //   88: astore 5
    //   90: aload 7
    //   92: athrow
    //   93: astore 7
    //   95: aload 6
    //   97: astore 5
    //   99: ldc 35
    //   101: ldc 216
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload 7
    //   111: aastore
    //   112: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: aload 6
    //   117: ifnull +205 -> 322
    //   120: aload 6
    //   122: invokevirtual 219	java/io/DataInputStream:close	()V
    //   125: ldc 194
    //   127: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: ldc 2
    //   132: monitorexit
    //   133: return
    //   134: aload 6
    //   136: astore 5
    //   138: aload 6
    //   140: invokevirtual 207	java/io/DataInputStream:readShort	()S
    //   143: pop
    //   144: aload 6
    //   146: astore 5
    //   148: aload 6
    //   150: invokevirtual 222	java/io/DataInputStream:readInt	()I
    //   153: istore_1
    //   154: iload_1
    //   155: ifge +70 -> 225
    //   158: aload 6
    //   160: astore 5
    //   162: new 209	java/lang/IllegalStateException
    //   165: dup
    //   166: ldc 224
    //   168: invokespecial 214	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   171: astore 7
    //   173: aload 6
    //   175: astore 5
    //   177: ldc 194
    //   179: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload 6
    //   184: astore 5
    //   186: aload 7
    //   188: athrow
    //   189: astore 7
    //   191: aload 5
    //   193: astore 6
    //   195: aload 7
    //   197: astore 5
    //   199: aload 6
    //   201: ifnull +8 -> 209
    //   204: aload 6
    //   206: invokevirtual 219	java/io/DataInputStream:close	()V
    //   209: ldc 194
    //   211: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload 5
    //   216: athrow
    //   217: astore 5
    //   219: ldc 2
    //   221: monitorexit
    //   222: aload 5
    //   224: athrow
    //   225: iload_0
    //   226: iload_1
    //   227: if_icmpge +51 -> 278
    //   230: aload 6
    //   232: astore 5
    //   234: aload 6
    //   236: invokevirtual 222	java/io/DataInputStream:readInt	()I
    //   239: istore_2
    //   240: aload 6
    //   242: astore 5
    //   244: aload 6
    //   246: invokevirtual 227	java/io/DataInputStream:readLong	()J
    //   249: lstore_3
    //   250: aload 6
    //   252: astore 5
    //   254: getstatic 26	com/tencent/mm/plugin/secinforeport/c$a:wcA	Ljava/util/Map;
    //   257: iload_2
    //   258: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: lload_3
    //   262: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   265: invokeinterface 80 3 0
    //   270: pop
    //   271: iload_0
    //   272: iconst_1
    //   273: iadd
    //   274: istore_0
    //   275: goto -50 -> 225
    //   278: aload 6
    //   280: astore 5
    //   282: ldc 35
    //   284: ldc 229
    //   286: invokestatic 193	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload 6
    //   291: invokevirtual 219	java/io/DataInputStream:close	()V
    //   294: ldc 194
    //   296: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: goto -169 -> 130
    //   302: astore 5
    //   304: ldc 194
    //   306: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: goto -179 -> 130
    //   312: astore 5
    //   314: ldc 194
    //   316: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: goto -189 -> 130
    //   322: ldc 194
    //   324: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: goto -197 -> 130
    //   330: astore 6
    //   332: goto -123 -> 209
    //   335: astore 5
    //   337: aconst_null
    //   338: astore 6
    //   340: goto -141 -> 199
    //   343: astore 7
    //   345: aconst_null
    //   346: astore 6
    //   348: goto -253 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	274	0	i	int
    //   153	75	1	j	int
    //   239	19	2	k	int
    //   249	13	3	l	long
    //   31	184	5	localObject1	Object
    //   217	6	5	localObject2	Object
    //   232	49	5	localObject3	Object
    //   302	1	5	localException1	java.lang.Exception
    //   312	1	5	localException2	java.lang.Exception
    //   335	1	5	localObject4	Object
    //   45	245	6	localObject5	Object
    //   330	1	6	localException3	java.lang.Exception
    //   338	9	6	localObject6	Object
    //   75	16	7	localIllegalStateException1	java.lang.IllegalStateException
    //   93	17	7	localException4	java.lang.Exception
    //   171	16	7	localIllegalStateException2	java.lang.IllegalStateException
    //   189	7	7	localObject7	Object
    //   343	1	7	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   51	62	93	java/lang/Exception
    //   66	77	93	java/lang/Exception
    //   81	86	93	java/lang/Exception
    //   90	93	93	java/lang/Exception
    //   138	144	93	java/lang/Exception
    //   148	154	93	java/lang/Exception
    //   162	173	93	java/lang/Exception
    //   177	182	93	java/lang/Exception
    //   186	189	93	java/lang/Exception
    //   234	240	93	java/lang/Exception
    //   244	250	93	java/lang/Exception
    //   254	271	93	java/lang/Exception
    //   282	289	93	java/lang/Exception
    //   51	62	189	finally
    //   66	77	189	finally
    //   81	86	189	finally
    //   90	93	189	finally
    //   99	115	189	finally
    //   138	144	189	finally
    //   148	154	189	finally
    //   162	173	189	finally
    //   177	182	189	finally
    //   186	189	189	finally
    //   234	240	189	finally
    //   244	250	189	finally
    //   254	271	189	finally
    //   282	289	189	finally
    //   5	33	217	finally
    //   120	125	217	finally
    //   125	130	217	finally
    //   204	209	217	finally
    //   209	217	217	finally
    //   289	294	217	finally
    //   294	299	217	finally
    //   304	309	217	finally
    //   314	319	217	finally
    //   322	327	217	finally
    //   289	294	302	java/lang/Exception
    //   120	125	312	java/lang/Exception
    //   204	209	330	java/lang/Exception
    //   33	47	335	finally
    //   33	47	343	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c.a
 * JD-Core Version:    0.7.0.1
 */