package com.tencent.mm.plugin.traceroute.b;

import java.util.Set;

final class a$a
  implements Runnable
{
  private String ip;
  private Set<Integer> pIH;
  
  public a$a(String paramString, Set<Integer> paramSet)
  {
    this.ip = paramSet;
    Object localObject;
    this.pIH = localObject;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 39
    //   2: iconst_1
    //   3: anewarray 4	java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: aload_0
    //   9: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
    //   12: aastore
    //   13: invokestatic 45	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   16: astore 6
    //   18: aload_0
    //   19: getfield 20	com/tencent/mm/plugin/traceroute/b/a$a:pII	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   22: aload_0
    //   23: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
    //   26: aload 6
    //   28: iconst_1
    //   29: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokevirtual 54	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    //   35: aload_0
    //   36: getfield 27	com/tencent/mm/plugin/traceroute/b/a$a:pIH	Ljava/util/Set;
    //   39: invokeinterface 60 1 0
    //   44: astore 9
    //   46: aload 9
    //   48: invokeinterface 66 1 0
    //   53: ifeq +716 -> 769
    //   56: aload 9
    //   58: invokeinterface 70 1 0
    //   63: checkcast 47	java/lang/Integer
    //   66: astore 6
    //   68: aload_0
    //   69: getfield 20	com/tencent/mm/plugin/traceroute/b/a$a:pII	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   72: astore 10
    //   74: aload_0
    //   75: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
    //   78: astore 11
    //   80: aload 6
    //   82: invokevirtual 74	java/lang/Integer:intValue	()I
    //   85: istore_1
    //   86: new 76	java/net/Socket
    //   89: dup
    //   90: invokespecial 77	java/net/Socket:<init>	()V
    //   93: astore 7
    //   95: aload 7
    //   97: astore 6
    //   99: aload 7
    //   101: sipush 5000
    //   104: invokevirtual 81	java/net/Socket:setSoTimeout	(I)V
    //   107: aload 7
    //   109: astore 6
    //   111: invokestatic 87	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   114: lstore_2
    //   115: aload 7
    //   117: astore 6
    //   119: aload 7
    //   121: new 89	java/net/InetSocketAddress
    //   124: dup
    //   125: aload 11
    //   127: iload_1
    //   128: invokespecial 92	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   131: invokevirtual 96	java/net/Socket:connect	(Ljava/net/SocketAddress;)V
    //   134: aload 7
    //   136: astore 6
    //   138: invokestatic 87	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   141: lstore 4
    //   143: aload 7
    //   145: astore 6
    //   147: ldc 98
    //   149: new 100	java/lang/StringBuilder
    //   152: dup
    //   153: ldc 102
    //   155: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 11
    //   160: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 111
    //   165: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload_1
    //   169: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload 7
    //   180: astore 6
    //   182: aload 10
    //   184: aload 11
    //   186: ldc 126
    //   188: iconst_2
    //   189: anewarray 4	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: iload_1
    //   195: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: dup
    //   200: iconst_1
    //   201: lload 4
    //   203: lload_2
    //   204: lsub
    //   205: invokestatic 131	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   208: aastore
    //   209: invokestatic 45	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   212: iconst_1
    //   213: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: invokevirtual 54	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    //   219: aload 7
    //   221: invokevirtual 134	java/net/Socket:close	()V
    //   224: goto -178 -> 46
    //   227: astore 6
    //   229: ldc 98
    //   231: new 100	java/lang/StringBuilder
    //   234: dup
    //   235: ldc 136
    //   237: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload 6
    //   242: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   245: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: ldc 98
    //   256: aload 6
    //   258: ldc 144
    //   260: iconst_0
    //   261: anewarray 4	java/lang/Object
    //   264: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: goto -221 -> 46
    //   270: astore 8
    //   272: aconst_null
    //   273: astore 7
    //   275: aload 7
    //   277: astore 6
    //   279: aload 10
    //   281: aload 11
    //   283: ldc 150
    //   285: iconst_2
    //   286: anewarray 4	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: iload_1
    //   292: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: aastore
    //   296: dup
    //   297: iconst_1
    //   298: aload 8
    //   300: invokevirtual 151	java/net/UnknownHostException:toString	()Ljava/lang/String;
    //   303: aastore
    //   304: invokestatic 45	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   307: iconst_1
    //   308: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   311: invokevirtual 54	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    //   314: aload 7
    //   316: astore 6
    //   318: ldc 98
    //   320: new 100	java/lang/StringBuilder
    //   323: dup
    //   324: ldc 153
    //   326: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   329: aload 8
    //   331: invokevirtual 154	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   334: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload 7
    //   345: astore 6
    //   347: ldc 98
    //   349: aload 8
    //   351: ldc 144
    //   353: iconst_0
    //   354: anewarray 4	java/lang/Object
    //   357: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: aload 7
    //   362: ifnull -316 -> 46
    //   365: aload 7
    //   367: invokevirtual 134	java/net/Socket:close	()V
    //   370: goto -324 -> 46
    //   373: astore 6
    //   375: ldc 98
    //   377: new 100	java/lang/StringBuilder
    //   380: dup
    //   381: ldc 136
    //   383: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   386: aload 6
    //   388: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   391: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: ldc 98
    //   402: aload 6
    //   404: ldc 144
    //   406: iconst_0
    //   407: anewarray 4	java/lang/Object
    //   410: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   413: goto -367 -> 46
    //   416: astore 8
    //   418: aconst_null
    //   419: astore 7
    //   421: aload 7
    //   423: astore 6
    //   425: aload 10
    //   427: aload 11
    //   429: ldc 156
    //   431: iconst_2
    //   432: anewarray 4	java/lang/Object
    //   435: dup
    //   436: iconst_0
    //   437: iload_1
    //   438: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: aastore
    //   442: dup
    //   443: iconst_1
    //   444: aload 8
    //   446: invokevirtual 157	java/io/IOException:toString	()Ljava/lang/String;
    //   449: aastore
    //   450: invokestatic 45	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   453: iconst_1
    //   454: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: invokevirtual 54	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    //   460: aload 7
    //   462: astore 6
    //   464: ldc 98
    //   466: new 100	java/lang/StringBuilder
    //   469: dup
    //   470: ldc 159
    //   472: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   475: aload 8
    //   477: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   480: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload 7
    //   491: astore 6
    //   493: ldc 98
    //   495: aload 8
    //   497: ldc 144
    //   499: iconst_0
    //   500: anewarray 4	java/lang/Object
    //   503: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   506: aload 7
    //   508: ifnull -462 -> 46
    //   511: aload 7
    //   513: invokevirtual 134	java/net/Socket:close	()V
    //   516: goto -470 -> 46
    //   519: astore 6
    //   521: ldc 98
    //   523: new 100	java/lang/StringBuilder
    //   526: dup
    //   527: ldc 136
    //   529: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   532: aload 6
    //   534: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   537: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: ldc 98
    //   548: aload 6
    //   550: ldc 144
    //   552: iconst_0
    //   553: anewarray 4	java/lang/Object
    //   556: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   559: goto -513 -> 46
    //   562: astore 8
    //   564: aconst_null
    //   565: astore 7
    //   567: aload 7
    //   569: astore 6
    //   571: aload 10
    //   573: aload 11
    //   575: ldc 161
    //   577: iconst_2
    //   578: anewarray 4	java/lang/Object
    //   581: dup
    //   582: iconst_0
    //   583: iload_1
    //   584: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   587: aastore
    //   588: dup
    //   589: iconst_1
    //   590: aload 8
    //   592: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   595: aastore
    //   596: invokestatic 45	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   599: iconst_1
    //   600: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   603: invokevirtual 54	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    //   606: aload 7
    //   608: astore 6
    //   610: ldc 98
    //   612: new 100	java/lang/StringBuilder
    //   615: dup
    //   616: ldc 159
    //   618: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   621: aload 8
    //   623: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   626: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload 7
    //   637: astore 6
    //   639: ldc 98
    //   641: aload 8
    //   643: ldc 144
    //   645: iconst_0
    //   646: anewarray 4	java/lang/Object
    //   649: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   652: aload 7
    //   654: ifnull -608 -> 46
    //   657: aload 7
    //   659: invokevirtual 134	java/net/Socket:close	()V
    //   662: goto -616 -> 46
    //   665: astore 6
    //   667: ldc 98
    //   669: new 100	java/lang/StringBuilder
    //   672: dup
    //   673: ldc 136
    //   675: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   678: aload 6
    //   680: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   683: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: ldc 98
    //   694: aload 6
    //   696: ldc 144
    //   698: iconst_0
    //   699: anewarray 4	java/lang/Object
    //   702: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   705: goto -659 -> 46
    //   708: astore 7
    //   710: aconst_null
    //   711: astore 6
    //   713: aload 6
    //   715: ifnull +8 -> 723
    //   718: aload 6
    //   720: invokevirtual 134	java/net/Socket:close	()V
    //   723: aload 7
    //   725: athrow
    //   726: astore 6
    //   728: ldc 98
    //   730: new 100	java/lang/StringBuilder
    //   733: dup
    //   734: ldc 136
    //   736: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   739: aload 6
    //   741: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   744: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 142	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   753: ldc 98
    //   755: aload 6
    //   757: ldc 144
    //   759: iconst_0
    //   760: anewarray 4	java/lang/Object
    //   763: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   766: goto -43 -> 723
    //   769: aload_0
    //   770: getfield 20	com/tencent/mm/plugin/traceroute/b/a$a:pII	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   773: aload_0
    //   774: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
    //   777: ldc 164
    //   779: iconst_1
    //   780: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   783: invokevirtual 54	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    //   786: return
    //   787: astore 7
    //   789: goto -76 -> 713
    //   792: astore 8
    //   794: goto -227 -> 567
    //   797: astore 8
    //   799: goto -378 -> 421
    //   802: astore 8
    //   804: goto -529 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	807	0	this	a
    //   85	499	1	i	int
    //   114	90	2	l1	long
    //   141	61	4	l2	long
    //   16	165	6	localObject1	Object
    //   227	30	6	localIOException1	java.io.IOException
    //   277	69	6	localObject2	Object
    //   373	30	6	localIOException2	java.io.IOException
    //   423	69	6	localObject3	Object
    //   519	30	6	localIOException3	java.io.IOException
    //   569	69	6	localObject4	Object
    //   665	30	6	localIOException4	java.io.IOException
    //   711	8	6	localObject5	Object
    //   726	30	6	localIOException5	java.io.IOException
    //   93	565	7	localSocket	java.net.Socket
    //   708	16	7	localObject6	Object
    //   787	1	7	localObject7	Object
    //   270	80	8	localUnknownHostException1	java.net.UnknownHostException
    //   416	80	8	localIOException6	java.io.IOException
    //   562	80	8	localException1	java.lang.Exception
    //   792	1	8	localException2	java.lang.Exception
    //   797	1	8	localIOException7	java.io.IOException
    //   802	1	8	localUnknownHostException2	java.net.UnknownHostException
    //   44	13	9	localIterator	java.util.Iterator
    //   72	500	10	locala	a
    //   78	496	11	str	String
    // Exception table:
    //   from	to	target	type
    //   219	224	227	java/io/IOException
    //   86	95	270	java/net/UnknownHostException
    //   365	370	373	java/io/IOException
    //   86	95	416	java/io/IOException
    //   511	516	519	java/io/IOException
    //   86	95	562	java/lang/Exception
    //   657	662	665	java/io/IOException
    //   86	95	708	finally
    //   718	723	726	java/io/IOException
    //   99	107	787	finally
    //   111	115	787	finally
    //   119	134	787	finally
    //   138	143	787	finally
    //   147	178	787	finally
    //   182	219	787	finally
    //   279	314	787	finally
    //   318	343	787	finally
    //   347	360	787	finally
    //   425	460	787	finally
    //   464	489	787	finally
    //   493	506	787	finally
    //   571	606	787	finally
    //   610	635	787	finally
    //   639	652	787	finally
    //   99	107	792	java/lang/Exception
    //   111	115	792	java/lang/Exception
    //   119	134	792	java/lang/Exception
    //   138	143	792	java/lang/Exception
    //   147	178	792	java/lang/Exception
    //   182	219	792	java/lang/Exception
    //   99	107	797	java/io/IOException
    //   111	115	797	java/io/IOException
    //   119	134	797	java/io/IOException
    //   138	143	797	java/io/IOException
    //   147	178	797	java/io/IOException
    //   182	219	797	java/io/IOException
    //   99	107	802	java/net/UnknownHostException
    //   111	115	802	java/net/UnknownHostException
    //   119	134	802	java/net/UnknownHostException
    //   138	143	802	java/net/UnknownHostException
    //   147	178	802	java/net/UnknownHostException
    //   182	219	802	java/net/UnknownHostException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a.a
 * JD-Core Version:    0.7.0.1
 */