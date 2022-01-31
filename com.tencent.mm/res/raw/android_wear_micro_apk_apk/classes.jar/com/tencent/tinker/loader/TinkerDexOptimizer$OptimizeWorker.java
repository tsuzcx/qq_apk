package com.tencent.tinker.loader;

import java.io.File;

class TinkerDexOptimizer$OptimizeWorker
{
  private static String akB = null;
  private final File akC;
  private final File akD;
  private final boolean akE;
  private final TinkerDexOptimizer.ResultCallback akF;
  
  TinkerDexOptimizer$OptimizeWorker(File paramFile1, File paramFile2, boolean paramBoolean, String paramString, TinkerDexOptimizer.ResultCallback paramResultCallback)
  {
    this.akC = paramFile1;
    this.akD = paramFile2;
    this.akE = true;
    this.akF = paramResultCallback;
    akB = paramString;
  }
  
  /* Error */
  public final boolean oe()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   4: invokestatic 44	com/tencent/tinker/loader/a/f:j	(Ljava/io/File;)Z
    //   7: ifne +59 -> 66
    //   10: aload_0
    //   11: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akF	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   14: ifnull +52 -> 66
    //   17: aload_0
    //   18: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akF	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   21: aload_0
    //   22: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   25: new 38	java/io/IOException
    //   28: dup
    //   29: new 46	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 48
    //   35: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   42: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 63
    //   50: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 67	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   59: invokeinterface 73 3 0
    //   64: iconst_0
    //   65: ireturn
    //   66: aload_0
    //   67: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akF	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   70: ifnull +16 -> 86
    //   73: aload_0
    //   74: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akF	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   77: aload_0
    //   78: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   81: invokeinterface 77 2 0
    //   86: aload_0
    //   87: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   90: aload_0
    //   91: getfield 26	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akD	Ljava/io/File;
    //   94: invokestatic 81	com/tencent/tinker/loader/a/f:c	(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;
    //   97: astore 4
    //   99: aload_0
    //   100: getfield 28	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akE	Z
    //   103: ifeq +512 -> 615
    //   106: aload_0
    //   107: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   110: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   113: astore 5
    //   115: new 53	java/io/File
    //   118: dup
    //   119: aload 4
    //   121: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual 85	java/io/File:exists	()Z
    //   129: ifne +11 -> 140
    //   132: aload_2
    //   133: invokevirtual 89	java/io/File:getParentFile	()Ljava/io/File;
    //   136: invokevirtual 92	java/io/File:mkdirs	()Z
    //   139: pop
    //   140: new 53	java/io/File
    //   143: dup
    //   144: aload_2
    //   145: invokevirtual 89	java/io/File:getParentFile	()Ljava/io/File;
    //   148: ldc 94
    //   150: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   153: astore_3
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_3
    //   157: invokestatic 103	com/tencent/tinker/loader/a/d:i	(Ljava/io/File;)Lcom/tencent/tinker/loader/a/d;
    //   160: astore_3
    //   161: aload_3
    //   162: astore_2
    //   163: new 105	java/util/ArrayList
    //   166: dup
    //   167: invokespecial 106	java/util/ArrayList:<init>	()V
    //   170: astore 6
    //   172: aload_3
    //   173: astore_2
    //   174: aload 6
    //   176: ldc 108
    //   178: invokeinterface 114 2 0
    //   183: pop
    //   184: aload_3
    //   185: astore_2
    //   186: getstatic 120	android/os/Build$VERSION:SDK_INT	I
    //   189: bipush 24
    //   191: if_icmplt +51 -> 242
    //   194: aload_3
    //   195: astore_2
    //   196: aload 6
    //   198: ldc 122
    //   200: invokeinterface 114 2 0
    //   205: pop
    //   206: aload_3
    //   207: astore_2
    //   208: aload 6
    //   210: ldc 124
    //   212: invokeinterface 114 2 0
    //   217: pop
    //   218: aload_3
    //   219: astore_2
    //   220: aload 6
    //   222: ldc 122
    //   224: invokeinterface 114 2 0
    //   229: pop
    //   230: aload_3
    //   231: astore_2
    //   232: aload 6
    //   234: ldc 126
    //   236: invokeinterface 114 2 0
    //   241: pop
    //   242: aload_3
    //   243: astore_2
    //   244: aload 6
    //   246: new 46	java/lang/StringBuilder
    //   249: dup
    //   250: ldc 128
    //   252: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 5
    //   257: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokeinterface 114 2 0
    //   268: pop
    //   269: aload_3
    //   270: astore_2
    //   271: aload 6
    //   273: new 46	java/lang/StringBuilder
    //   276: dup
    //   277: ldc 130
    //   279: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload 4
    //   284: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokeinterface 114 2 0
    //   295: pop
    //   296: aload_3
    //   297: astore_2
    //   298: aload 6
    //   300: new 46	java/lang/StringBuilder
    //   303: dup
    //   304: ldc 132
    //   306: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: getstatic 17	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akB	Ljava/lang/String;
    //   312: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokeinterface 114 2 0
    //   323: pop
    //   324: aload_3
    //   325: astore_2
    //   326: getstatic 120	android/os/Build$VERSION:SDK_INT	I
    //   329: bipush 25
    //   331: if_icmple +202 -> 533
    //   334: aload_3
    //   335: astore_2
    //   336: aload 6
    //   338: ldc 134
    //   340: invokeinterface 114 2 0
    //   345: pop
    //   346: aload_3
    //   347: astore_2
    //   348: new 136	java/lang/ProcessBuilder
    //   351: dup
    //   352: aload 6
    //   354: invokespecial 139	java/lang/ProcessBuilder:<init>	(Ljava/util/List;)V
    //   357: astore 5
    //   359: aload_3
    //   360: astore_2
    //   361: aload 5
    //   363: iconst_1
    //   364: invokevirtual 143	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   367: pop
    //   368: aload_3
    //   369: astore_2
    //   370: aload 5
    //   372: invokevirtual 147	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   375: astore 5
    //   377: aload_3
    //   378: astore_2
    //   379: aload 5
    //   381: invokevirtual 153	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   384: invokestatic 159	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer:d	(Ljava/io/InputStream;)V
    //   387: aload_3
    //   388: astore_2
    //   389: aload 5
    //   391: invokevirtual 162	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   394: invokestatic 159	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer:d	(Ljava/io/InputStream;)V
    //   397: aload_3
    //   398: astore_2
    //   399: aload 5
    //   401: invokevirtual 166	java/lang/Process:waitFor	()I
    //   404: istore_1
    //   405: iload_1
    //   406: ifeq +142 -> 548
    //   409: aload_3
    //   410: astore_2
    //   411: new 38	java/io/IOException
    //   414: dup
    //   415: new 46	java/lang/StringBuilder
    //   418: dup
    //   419: ldc 168
    //   421: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   424: iload_1
    //   425: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   428: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokespecial 67	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   434: athrow
    //   435: astore 4
    //   437: aload_3
    //   438: astore_2
    //   439: new 38	java/io/IOException
    //   442: dup
    //   443: new 46	java/lang/StringBuilder
    //   446: dup
    //   447: ldc 173
    //   449: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: aload 4
    //   454: invokevirtual 176	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   457: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: aload 4
    //   465: invokespecial 179	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   468: athrow
    //   469: astore_3
    //   470: aload_2
    //   471: ifnull +7 -> 478
    //   474: aload_2
    //   475: invokevirtual 182	com/tencent/tinker/loader/a/d:close	()V
    //   478: aload_3
    //   479: athrow
    //   480: astore_2
    //   481: ldc 184
    //   483: new 46	java/lang/StringBuilder
    //   486: dup
    //   487: ldc 186
    //   489: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   492: aload_0
    //   493: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   496: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   499: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: aload_2
    //   506: invokestatic 192	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   509: pop
    //   510: aload_0
    //   511: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akF	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   514: ifnull +118 -> 632
    //   517: aload_0
    //   518: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akF	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   521: aload_0
    //   522: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   525: aload_2
    //   526: invokeinterface 73 3 0
    //   531: iconst_0
    //   532: ireturn
    //   533: aload_3
    //   534: astore_2
    //   535: aload 6
    //   537: ldc 194
    //   539: invokeinterface 114 2 0
    //   544: pop
    //   545: goto -199 -> 346
    //   548: aload_3
    //   549: invokevirtual 182	com/tencent/tinker/loader/a/d:close	()V
    //   552: aload_0
    //   553: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akF	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   556: ifnull +76 -> 632
    //   559: aload_0
    //   560: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akF	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   563: astore_2
    //   564: aload_0
    //   565: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   568: astore_3
    //   569: new 53	java/io/File
    //   572: dup
    //   573: aload 4
    //   575: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   578: pop
    //   579: aload_2
    //   580: aload_3
    //   581: invokeinterface 197 2 0
    //   586: goto +46 -> 632
    //   589: astore_2
    //   590: ldc 184
    //   592: ldc 199
    //   594: aload_2
    //   595: invokestatic 202	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   598: pop
    //   599: goto -47 -> 552
    //   602: astore_2
    //   603: ldc 184
    //   605: ldc 199
    //   607: aload_2
    //   608: invokestatic 202	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   611: pop
    //   612: goto -134 -> 478
    //   615: aload_0
    //   616: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:akC	Ljava/io/File;
    //   619: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   622: aload 4
    //   624: iconst_0
    //   625: invokestatic 208	dalvik/system/DexFile:loadDex	(Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;
    //   628: pop
    //   629: goto -77 -> 552
    //   632: iconst_1
    //   633: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	this	OptimizeWorker
    //   404	21	1	i	int
    //   124	351	2	localObject1	Object
    //   480	46	2	localThrowable	java.lang.Throwable
    //   534	46	2	localObject2	Object
    //   589	6	2	localIOException1	java.io.IOException
    //   602	6	2	localIOException2	java.io.IOException
    //   153	285	3	localObject3	Object
    //   469	80	3	localObject4	Object
    //   568	13	3	localFile	File
    //   97	186	4	str	String
    //   435	188	4	localInterruptedException	java.lang.InterruptedException
    //   113	287	5	localObject5	Object
    //   170	366	6	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   399	405	435	java/lang/InterruptedException
    //   411	435	435	java/lang/InterruptedException
    //   156	161	469	finally
    //   163	172	469	finally
    //   174	184	469	finally
    //   186	194	469	finally
    //   196	206	469	finally
    //   208	218	469	finally
    //   220	230	469	finally
    //   232	242	469	finally
    //   244	269	469	finally
    //   271	296	469	finally
    //   298	324	469	finally
    //   326	334	469	finally
    //   336	346	469	finally
    //   348	359	469	finally
    //   361	368	469	finally
    //   370	377	469	finally
    //   379	387	469	finally
    //   389	397	469	finally
    //   399	405	469	finally
    //   411	435	469	finally
    //   439	469	469	finally
    //   535	545	469	finally
    //   0	64	480	java/lang/Throwable
    //   66	86	480	java/lang/Throwable
    //   86	140	480	java/lang/Throwable
    //   140	154	480	java/lang/Throwable
    //   474	478	480	java/lang/Throwable
    //   478	480	480	java/lang/Throwable
    //   548	552	480	java/lang/Throwable
    //   552	586	480	java/lang/Throwable
    //   590	599	480	java/lang/Throwable
    //   603	612	480	java/lang/Throwable
    //   615	629	480	java/lang/Throwable
    //   548	552	589	java/io/IOException
    //   474	478	602	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker
 * JD-Core Version:    0.7.0.1
 */