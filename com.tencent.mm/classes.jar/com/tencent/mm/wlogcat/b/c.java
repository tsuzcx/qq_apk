package com.tencent.mm.wlogcat.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static c agWB;
  private String agWC;
  public Runnable agWp;
  
  static
  {
    AppMethodBeat.i(231314);
    agWB = new c();
    AppMethodBeat.o(231314);
  }
  
  private c()
  {
    AppMethodBeat.i(231298);
    this.agWp = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: bipush 100
        //   2: istore_1
        //   3: ldc 22
        //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 32	com/tencent/mm/wlogcat/b/c:jPV	()Ljava/lang/String;
        //   11: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   14: ifeq +16 -> 30
        //   17: ldc 40
        //   19: ldc 42
        //   21: invokestatic 48	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   24: ldc 22
        //   26: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   29: return
        //   30: invokestatic 32	com/tencent/mm/wlogcat/b/c:jPV	()Ljava/lang/String;
        //   33: invokestatic 57	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getSingleMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
        //   36: astore_3
        //   37: aload_0
        //   38: getfield 14	com/tencent/mm/wlogcat/b/c$1:agWD	Lcom/tencent/mm/wlogcat/b/c;
        //   41: aload_3
        //   42: ldc 59
        //   44: ldc 61
        //   46: invokevirtual 65	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   49: invokestatic 69	com/tencent/mm/wlogcat/b/c:a	(Lcom/tencent/mm/wlogcat/b/c;Ljava/lang/String;)Ljava/lang/String;
        //   52: pop
        //   53: aload_3
        //   54: ldc 59
        //   56: invokestatic 75	android/os/Process:myPid	()I
        //   59: invokestatic 81	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   62: invokevirtual 85	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
        //   65: pop
        //   66: aload_3
        //   67: invokevirtual 89	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:commit	()Z
        //   70: pop
        //   71: ldc 40
        //   73: new 91	java/lang/StringBuilder
        //   76: dup
        //   77: ldc 93
        //   79: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   82: aload_0
        //   83: getfield 14	com/tencent/mm/wlogcat/b/c$1:agWD	Lcom/tencent/mm/wlogcat/b/c;
        //   86: invokestatic 99	com/tencent/mm/wlogcat/b/c:a	(Lcom/tencent/mm/wlogcat/b/c;)Ljava/lang/String;
        //   89: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   92: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   95: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   98: aload_0
        //   99: getfield 14	com/tencent/mm/wlogcat/b/c$1:agWD	Lcom/tencent/mm/wlogcat/b/c;
        //   102: invokestatic 99	com/tencent/mm/wlogcat/b/c:a	(Lcom/tencent/mm/wlogcat/b/c;)Ljava/lang/String;
        //   105: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   108: ifeq +9 -> 117
        //   111: ldc 22
        //   113: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   116: return
        //   117: invokestatic 114	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
        //   120: ldc 116
        //   122: invokevirtual 120	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
        //   125: astore 4
        //   127: new 122	java/io/InputStreamReader
        //   130: dup
        //   131: aload 4
        //   133: invokevirtual 128	java/lang/Process:getInputStream	()Ljava/io/InputStream;
        //   136: invokespecial 131	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   139: astore 6
        //   141: new 133	java/io/BufferedReader
        //   144: dup
        //   145: aload 6
        //   147: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   150: astore_3
        //   151: aload_3
        //   152: astore 9
        //   154: aload 6
        //   156: astore 8
        //   158: aload 4
        //   160: astore 7
        //   162: new 138	java/util/ArrayList
        //   165: dup
        //   166: invokespecial 139	java/util/ArrayList:<init>	()V
        //   169: astore 5
        //   171: aload_3
        //   172: astore 9
        //   174: aload 6
        //   176: astore 8
        //   178: aload 4
        //   180: astore 7
        //   182: getstatic 145	com/tencent/mm/xlog/app/XLogSetup:isLogcatOpen	Ljava/lang/Boolean;
        //   185: invokevirtual 150	java/lang/Boolean:booleanValue	()Z
        //   188: ifne +135 -> 323
        //   191: aload_3
        //   192: astore 9
        //   194: aload 6
        //   196: astore 8
        //   198: aload 4
        //   200: astore 7
        //   202: aload_3
        //   203: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   206: astore 10
        //   208: aload 10
        //   210: ifnull +113 -> 323
        //   213: aload_3
        //   214: astore 9
        //   216: aload 6
        //   218: astore 8
        //   220: aload 4
        //   222: astore 7
        //   224: aload 10
        //   226: aload_0
        //   227: getfield 14	com/tencent/mm/wlogcat/b/c$1:agWD	Lcom/tencent/mm/wlogcat/b/c;
        //   230: invokestatic 99	com/tencent/mm/wlogcat/b/c:a	(Lcom/tencent/mm/wlogcat/b/c;)Ljava/lang/String;
        //   233: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   236: ifeq -65 -> 171
        //   239: aload_3
        //   240: astore 9
        //   242: aload 6
        //   244: astore 8
        //   246: aload 4
        //   248: astore 7
        //   250: aload 5
        //   252: aload 10
        //   254: invokeinterface 162 2 0
        //   259: pop
        //   260: goto -89 -> 171
        //   263: astore 5
        //   265: aload_3
        //   266: astore 9
        //   268: aload 6
        //   270: astore 8
        //   272: aload 4
        //   274: astore 7
        //   276: ldc 40
        //   278: aload 5
        //   280: ldc 61
        //   282: iconst_0
        //   283: anewarray 4	java/lang/Object
        //   286: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   289: aload 4
        //   291: ifnull +8 -> 299
        //   294: aload 4
        //   296: invokevirtual 169	java/lang/Process:destroy	()V
        //   299: aload 6
        //   301: ifnull +8 -> 309
        //   304: aload 6
        //   306: invokevirtual 172	java/io/InputStreamReader:close	()V
        //   309: aload_3
        //   310: ifnull +7 -> 317
        //   313: aload_3
        //   314: invokevirtual 173	java/io/BufferedReader:close	()V
        //   317: ldc 22
        //   319: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   322: return
        //   323: aload_3
        //   324: astore 9
        //   326: aload 6
        //   328: astore 8
        //   330: aload 4
        //   332: astore 7
        //   334: aload 5
        //   336: invokeinterface 176 1 0
        //   341: bipush 100
        //   343: if_icmplt +98 -> 441
        //   346: aload_3
        //   347: astore 9
        //   349: aload 6
        //   351: astore 8
        //   353: aload 4
        //   355: astore 7
        //   357: aload 5
        //   359: invokestatic 182	java/util/Collections:reverse	(Ljava/util/List;)V
        //   362: aload_3
        //   363: astore 9
        //   365: aload 6
        //   367: astore 8
        //   369: aload 4
        //   371: astore 7
        //   373: aload 5
        //   375: iconst_0
        //   376: iload_1
        //   377: invokeinterface 186 3 0
        //   382: astore 5
        //   384: aload_3
        //   385: astore 9
        //   387: aload 6
        //   389: astore 8
        //   391: aload 4
        //   393: astore 7
        //   395: aload 5
        //   397: invokestatic 182	java/util/Collections:reverse	(Ljava/util/List;)V
        //   400: iconst_0
        //   401: istore_2
        //   402: iload_2
        //   403: iload_1
        //   404: if_icmpge +59 -> 463
        //   407: aload_3
        //   408: astore 9
        //   410: aload 6
        //   412: astore 8
        //   414: aload 4
        //   416: astore 7
        //   418: ldc 40
        //   420: aload 5
        //   422: iload_2
        //   423: invokeinterface 190 2 0
        //   428: checkcast 77	java/lang/String
        //   431: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   434: iload_2
        //   435: iconst_1
        //   436: iadd
        //   437: istore_2
        //   438: goto -36 -> 402
        //   441: aload_3
        //   442: astore 9
        //   444: aload 6
        //   446: astore 8
        //   448: aload 4
        //   450: astore 7
        //   452: aload 5
        //   454: invokeinterface 176 1 0
        //   459: istore_1
        //   460: goto -114 -> 346
        //   463: aload_3
        //   464: astore 9
        //   466: aload 6
        //   468: astore 8
        //   470: aload 4
        //   472: astore 7
        //   474: ldc 40
        //   476: ldc 192
        //   478: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   481: aload 4
        //   483: ifnull +8 -> 491
        //   486: aload 4
        //   488: invokevirtual 169	java/lang/Process:destroy	()V
        //   491: aload 6
        //   493: invokevirtual 172	java/io/InputStreamReader:close	()V
        //   496: aload_3
        //   497: invokevirtual 173	java/io/BufferedReader:close	()V
        //   500: ldc 22
        //   502: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   505: return
        //   506: astore_3
        //   507: ldc 22
        //   509: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   512: return
        //   513: astore_3
        //   514: ldc 22
        //   516: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   519: return
        //   520: astore_3
        //   521: aconst_null
        //   522: astore 5
        //   524: aconst_null
        //   525: astore 6
        //   527: aconst_null
        //   528: astore 4
        //   530: aload 4
        //   532: ifnull +8 -> 540
        //   535: aload 4
        //   537: invokevirtual 169	java/lang/Process:destroy	()V
        //   540: aload 6
        //   542: ifnull +8 -> 550
        //   545: aload 6
        //   547: invokevirtual 172	java/io/InputStreamReader:close	()V
        //   550: aload 5
        //   552: ifnull +8 -> 560
        //   555: aload 5
        //   557: invokevirtual 173	java/io/BufferedReader:close	()V
        //   560: ldc 22
        //   562: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   565: aload_3
        //   566: athrow
        //   567: astore 4
        //   569: goto -9 -> 560
        //   572: astore_3
        //   573: aconst_null
        //   574: astore 5
        //   576: aconst_null
        //   577: astore 6
        //   579: goto -49 -> 530
        //   582: astore_3
        //   583: aconst_null
        //   584: astore 5
        //   586: goto -56 -> 530
        //   589: astore_3
        //   590: aload 9
        //   592: astore 5
        //   594: aload 8
        //   596: astore 6
        //   598: aload 7
        //   600: astore 4
        //   602: goto -72 -> 530
        //   605: astore 5
        //   607: aconst_null
        //   608: astore_3
        //   609: aconst_null
        //   610: astore 6
        //   612: aconst_null
        //   613: astore 4
        //   615: goto -350 -> 265
        //   618: astore 5
        //   620: aconst_null
        //   621: astore_3
        //   622: aconst_null
        //   623: astore 6
        //   625: goto -360 -> 265
        //   628: astore 5
        //   630: aconst_null
        //   631: astore_3
        //   632: goto -367 -> 265
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	635	0	this	1
        //   2	458	1	i	int
        //   401	37	2	j	int
        //   36	461	3	localObject1	Object
        //   506	1	3	localException1	java.lang.Exception
        //   513	1	3	localException2	java.lang.Exception
        //   520	46	3	localObject2	Object
        //   572	1	3	localObject3	Object
        //   582	1	3	localObject4	Object
        //   589	1	3	localObject5	Object
        //   608	24	3	localObject6	Object
        //   125	411	4	localProcess1	java.lang.Process
        //   567	1	4	localException3	java.lang.Exception
        //   600	14	4	localObject7	Object
        //   169	82	5	localArrayList	java.util.ArrayList
        //   263	111	5	localException4	java.lang.Exception
        //   382	211	5	localObject8	Object
        //   605	1	5	localException5	java.lang.Exception
        //   618	1	5	localException6	java.lang.Exception
        //   628	1	5	localException7	java.lang.Exception
        //   139	485	6	localObject9	Object
        //   160	439	7	localProcess2	java.lang.Process
        //   156	439	8	localObject10	Object
        //   152	439	9	localObject11	Object
        //   206	47	10	str	String
        // Exception table:
        //   from	to	target	type
        //   162	171	263	java/lang/Exception
        //   182	191	263	java/lang/Exception
        //   202	208	263	java/lang/Exception
        //   224	239	263	java/lang/Exception
        //   250	260	263	java/lang/Exception
        //   334	346	263	java/lang/Exception
        //   357	362	263	java/lang/Exception
        //   373	384	263	java/lang/Exception
        //   395	400	263	java/lang/Exception
        //   418	434	263	java/lang/Exception
        //   452	460	263	java/lang/Exception
        //   474	481	263	java/lang/Exception
        //   486	491	506	java/lang/Exception
        //   491	500	506	java/lang/Exception
        //   294	299	513	java/lang/Exception
        //   304	309	513	java/lang/Exception
        //   313	317	513	java/lang/Exception
        //   117	127	520	finally
        //   535	540	567	java/lang/Exception
        //   545	550	567	java/lang/Exception
        //   555	560	567	java/lang/Exception
        //   127	141	572	finally
        //   141	151	582	finally
        //   162	171	589	finally
        //   182	191	589	finally
        //   202	208	589	finally
        //   224	239	589	finally
        //   250	260	589	finally
        //   276	289	589	finally
        //   334	346	589	finally
        //   357	362	589	finally
        //   373	384	589	finally
        //   395	400	589	finally
        //   418	434	589	finally
        //   452	460	589	finally
        //   474	481	589	finally
        //   117	127	605	java/lang/Exception
        //   127	141	618	java/lang/Exception
        //   141	151	628	java/lang/Exception
      }
    };
    AppMethodBeat.o(231298);
  }
  
  public static c jPU()
  {
    return agWB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wlogcat.b.c
 * JD-Core Version:    0.7.0.1
 */