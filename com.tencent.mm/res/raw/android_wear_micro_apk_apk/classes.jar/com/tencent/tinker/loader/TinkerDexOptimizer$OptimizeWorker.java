package com.tencent.tinker.loader;

import java.io.File;

class TinkerDexOptimizer$OptimizeWorker
{
  private static String aob = null;
  private final File aoc;
  private final File aod;
  private final boolean aoe;
  private final TinkerDexOptimizer.ResultCallback aof;
  
  TinkerDexOptimizer$OptimizeWorker(File paramFile1, File paramFile2, boolean paramBoolean, String paramString, TinkerDexOptimizer.ResultCallback paramResultCallback)
  {
    this.aoc = paramFile1;
    this.aod = paramFile2;
    this.aoe = true;
    this.aof = paramResultCallback;
    aob = paramString;
  }
  
  /* Error */
  public final boolean oR()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
    //   4: invokestatic 44	com/tencent/tinker/loader/a/f:j	(Ljava/io/File;)Z
    //   7: ifne +59 -> 66
    //   10: aload_0
    //   11: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aof	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   14: ifnull +52 -> 66
    //   17: aload_0
    //   18: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aof	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   21: aload_0
    //   22: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
    //   25: new 38	java/io/IOException
    //   28: dup
    //   29: new 46	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 48
    //   35: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
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
    //   67: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aof	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   70: ifnull +16 -> 86
    //   73: aload_0
    //   74: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aof	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   77: aload_0
    //   78: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
    //   81: invokeinterface 77 2 0
    //   86: aload_0
    //   87: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
    //   90: aload_0
    //   91: getfield 26	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aod	Ljava/io/File;
    //   94: invokestatic 81	com/tencent/tinker/loader/a/f:c	(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;
    //   97: astore 4
    //   99: aload_0
    //   100: getfield 28	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoe	Z
    //   103: ifeq +491 -> 594
    //   106: aload_0
    //   107: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
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
    //   246: ldc 128
    //   248: aload 5
    //   250: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   253: invokevirtual 138	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokeinterface 114 2 0
    //   261: pop
    //   262: aload_3
    //   263: astore_2
    //   264: aload 6
    //   266: ldc 140
    //   268: aload 4
    //   270: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   273: invokevirtual 138	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   276: invokeinterface 114 2 0
    //   281: pop
    //   282: aload_3
    //   283: astore_2
    //   284: aload 6
    //   286: new 46	java/lang/StringBuilder
    //   289: dup
    //   290: ldc 142
    //   292: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   295: getstatic 17	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aob	Ljava/lang/String;
    //   298: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokeinterface 114 2 0
    //   309: pop
    //   310: aload_3
    //   311: astore_2
    //   312: getstatic 120	android/os/Build$VERSION:SDK_INT	I
    //   315: bipush 25
    //   317: if_icmple +195 -> 512
    //   320: aload_3
    //   321: astore_2
    //   322: aload 6
    //   324: ldc 144
    //   326: invokeinterface 114 2 0
    //   331: pop
    //   332: aload_3
    //   333: astore_2
    //   334: new 146	java/lang/ProcessBuilder
    //   337: dup
    //   338: aload 6
    //   340: invokespecial 149	java/lang/ProcessBuilder:<init>	(Ljava/util/List;)V
    //   343: astore 5
    //   345: aload_3
    //   346: astore_2
    //   347: aload 5
    //   349: iconst_1
    //   350: invokevirtual 153	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   353: pop
    //   354: aload_3
    //   355: astore_2
    //   356: aload 5
    //   358: invokevirtual 157	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   361: astore 5
    //   363: aload_3
    //   364: astore_2
    //   365: aload 5
    //   367: invokevirtual 163	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   370: invokestatic 169	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer:d	(Ljava/io/InputStream;)V
    //   373: aload_3
    //   374: astore_2
    //   375: aload 5
    //   377: invokevirtual 172	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   380: invokestatic 169	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer:d	(Ljava/io/InputStream;)V
    //   383: aload_3
    //   384: astore_2
    //   385: aload 5
    //   387: invokevirtual 176	java/lang/Process:waitFor	()I
    //   390: istore_1
    //   391: iload_1
    //   392: ifeq +135 -> 527
    //   395: aload_3
    //   396: astore_2
    //   397: new 38	java/io/IOException
    //   400: dup
    //   401: ldc 178
    //   403: iload_1
    //   404: invokestatic 181	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   407: invokevirtual 138	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokespecial 67	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   413: athrow
    //   414: astore 4
    //   416: aload_3
    //   417: astore_2
    //   418: new 38	java/io/IOException
    //   421: dup
    //   422: new 46	java/lang/StringBuilder
    //   425: dup
    //   426: ldc 183
    //   428: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   431: aload 4
    //   433: invokevirtual 186	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   436: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: aload 4
    //   444: invokespecial 189	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   447: athrow
    //   448: astore_3
    //   449: aload_2
    //   450: ifnull +7 -> 457
    //   453: aload_2
    //   454: invokevirtual 192	com/tencent/tinker/loader/a/d:close	()V
    //   457: aload_3
    //   458: athrow
    //   459: astore_2
    //   460: ldc 194
    //   462: new 46	java/lang/StringBuilder
    //   465: dup
    //   466: ldc 196
    //   468: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   471: aload_0
    //   472: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
    //   475: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   478: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: aload_2
    //   485: invokestatic 202	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   488: pop
    //   489: aload_0
    //   490: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aof	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   493: ifnull +118 -> 611
    //   496: aload_0
    //   497: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aof	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   500: aload_0
    //   501: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
    //   504: aload_2
    //   505: invokeinterface 73 3 0
    //   510: iconst_0
    //   511: ireturn
    //   512: aload_3
    //   513: astore_2
    //   514: aload 6
    //   516: ldc 204
    //   518: invokeinterface 114 2 0
    //   523: pop
    //   524: goto -192 -> 332
    //   527: aload_3
    //   528: invokevirtual 192	com/tencent/tinker/loader/a/d:close	()V
    //   531: aload_0
    //   532: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aof	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   535: ifnull +76 -> 611
    //   538: aload_0
    //   539: getfield 30	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aof	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
    //   542: astore_2
    //   543: aload_0
    //   544: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
    //   547: astore_3
    //   548: new 53	java/io/File
    //   551: dup
    //   552: aload 4
    //   554: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   557: pop
    //   558: aload_2
    //   559: aload_3
    //   560: invokeinterface 207 2 0
    //   565: goto +46 -> 611
    //   568: astore_2
    //   569: ldc 194
    //   571: ldc 209
    //   573: aload_2
    //   574: invokestatic 212	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   577: pop
    //   578: goto -47 -> 531
    //   581: astore_2
    //   582: ldc 194
    //   584: ldc 209
    //   586: aload_2
    //   587: invokestatic 212	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   590: pop
    //   591: goto -134 -> 457
    //   594: aload_0
    //   595: getfield 24	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:aoc	Ljava/io/File;
    //   598: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   601: aload 4
    //   603: iconst_0
    //   604: invokestatic 218	dalvik/system/DexFile:loadDex	(Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;
    //   607: pop
    //   608: goto -77 -> 531
    //   611: iconst_1
    //   612: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	OptimizeWorker
    //   390	14	1	i	int
    //   124	330	2	localObject1	Object
    //   459	46	2	localThrowable	java.lang.Throwable
    //   513	46	2	localObject2	Object
    //   568	6	2	localIOException1	java.io.IOException
    //   581	6	2	localIOException2	java.io.IOException
    //   153	264	3	localObject3	Object
    //   448	80	3	localObject4	Object
    //   547	13	3	localFile	File
    //   97	172	4	str	String
    //   414	188	4	localInterruptedException	java.lang.InterruptedException
    //   113	273	5	localObject5	Object
    //   170	345	6	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   385	391	414	java/lang/InterruptedException
    //   397	414	414	java/lang/InterruptedException
    //   156	161	448	finally
    //   163	172	448	finally
    //   174	184	448	finally
    //   186	194	448	finally
    //   196	206	448	finally
    //   208	218	448	finally
    //   220	230	448	finally
    //   232	242	448	finally
    //   244	262	448	finally
    //   264	282	448	finally
    //   284	310	448	finally
    //   312	320	448	finally
    //   322	332	448	finally
    //   334	345	448	finally
    //   347	354	448	finally
    //   356	363	448	finally
    //   365	373	448	finally
    //   375	383	448	finally
    //   385	391	448	finally
    //   397	414	448	finally
    //   418	448	448	finally
    //   514	524	448	finally
    //   0	64	459	java/lang/Throwable
    //   66	86	459	java/lang/Throwable
    //   86	140	459	java/lang/Throwable
    //   140	154	459	java/lang/Throwable
    //   453	457	459	java/lang/Throwable
    //   457	459	459	java/lang/Throwable
    //   527	531	459	java/lang/Throwable
    //   531	565	459	java/lang/Throwable
    //   569	578	459	java/lang/Throwable
    //   582	591	459	java/lang/Throwable
    //   594	608	459	java/lang/Throwable
    //   527	531	568	java/io/IOException
    //   453	457	581	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker
 * JD-Core Version:    0.7.0.1
 */