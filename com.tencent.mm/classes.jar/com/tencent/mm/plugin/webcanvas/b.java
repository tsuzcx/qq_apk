package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasHttpImageStreamFetcher;", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "()V", "connectionTimeoutMs", "", "readTimeoutMs", "accept", "", "obj", "", "fetch", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher$StreamFetchResult;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "getSourceTypeName", "", "toFileName", "Companion", "webview-sdk_release"})
public final class b
  implements com.github.henryye.nativeiv.b.b
{
  public static final b.a DPE;
  private int bbx = 30000;
  private int bby = 30000;
  
  static
  {
    AppMethodBeat.i(213863);
    DPE = new b.a((byte)0);
    AppMethodBeat.o(213863);
  }
  
  /* Error */
  public final com.github.henryye.nativeiv.b.b.a a(Object paramObject, com.github.henryye.nativeiv.ImageDecodeConfig paramImageDecodeConfig)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 66
    //   8: invokestatic 72	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 73
    //   14: invokestatic 72	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_1
    //   18: checkcast 75	java/lang/String
    //   21: astore 7
    //   23: new 77	com/github/henryye/nativeiv/b/b$a
    //   26: dup
    //   27: invokespecial 78	com/github/henryye/nativeiv/b/b$a:<init>	()V
    //   30: astore 16
    //   32: new 80	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   39: astore_2
    //   40: getstatic 87	com/tencent/mm/plugin/webcanvas/h:DQL	Lcom/tencent/mm/plugin/webcanvas/h;
    //   43: astore 6
    //   45: aload_2
    //   46: invokestatic 91	com/tencent/mm/plugin/webcanvas/h:eOX	()Ljava/lang/String;
    //   49: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 97
    //   54: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 7
    //   59: invokestatic 103	com/tencent/mm/sdk/platformtools/aj:ej	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 17
    //   70: aload 17
    //   72: invokestatic 112	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   75: istore 5
    //   77: ldc 114
    //   79: new 80	java/lang/StringBuilder
    //   82: dup
    //   83: ldc 116
    //   85: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_1
    //   89: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: bipush 32
    //   94: invokevirtual 125	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   97: aload 17
    //   99: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 127
    //   104: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload 5
    //   109: invokevirtual 130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 135	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: iload 5
    //   120: ifeq +108 -> 228
    //   123: ldc 114
    //   125: ldc 137
    //   127: invokestatic 140	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 16
    //   132: new 142	java/io/BufferedInputStream
    //   135: dup
    //   136: aload 17
    //   138: invokestatic 146	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: invokespecial 149	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   144: checkcast 151	java/io/InputStream
    //   147: putfield 155	com/github/henryye/nativeiv/b/b$a:inputStream	Ljava/io/InputStream;
    //   150: ldc 65
    //   152: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload 16
    //   157: areturn
    //   158: astore_1
    //   159: ldc 114
    //   161: aload_1
    //   162: checkcast 157	java/lang/Throwable
    //   165: ldc 158
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 162	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: getstatic 168	d/g/b/ad:Njc	Ld/g/b/ad;
    //   177: astore_2
    //   178: invokestatic 174	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   181: ldc 175
    //   183: invokevirtual 181	android/content/Context:getString	(I)Ljava/lang/String;
    //   186: astore_2
    //   187: aload_2
    //   188: ldc 183
    //   190: invokestatic 186	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   193: aload_2
    //   194: iconst_1
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload_1
    //   201: invokevirtual 187	java/lang/Exception:toString	()Ljava/lang/String;
    //   204: aastore
    //   205: iconst_1
    //   206: invokestatic 193	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   209: invokestatic 197	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   212: astore_1
    //   213: aload_1
    //   214: ldc 199
    //   216: invokestatic 186	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   219: aload 16
    //   221: aload_1
    //   222: putfield 203	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   225: goto -75 -> 150
    //   228: new 205	d/g/b/y$d
    //   231: dup
    //   232: invokespecial 206	d/g/b/y$d:<init>	()V
    //   235: astore 18
    //   237: aload 18
    //   239: iconst_0
    //   240: putfield 209	d/g/b/y$d:NiW	I
    //   243: aconst_null
    //   244: astore 6
    //   246: aconst_null
    //   247: astore_2
    //   248: aconst_null
    //   249: astore_1
    //   250: ldc 211
    //   252: invokestatic 217	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   255: checkcast 211	com/tencent/mm/plugin/expt/b/b
    //   258: getstatic 223	com/tencent/mm/plugin/expt/b/b$a:qNh	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   261: iconst_0
    //   262: invokeinterface 226 3 0
    //   267: istore 5
    //   269: new 228	com/tencent/mm/plugin/webcanvas/b$b
    //   272: dup
    //   273: aload 18
    //   275: invokespecial 231	com/tencent/mm/plugin/webcanvas/b$b:<init>	(Ld/g/b/y$d;)V
    //   278: astore 19
    //   280: iconst_0
    //   281: istore_3
    //   282: iload_3
    //   283: ifne +1302 -> 1585
    //   286: iload 5
    //   288: ifeq +104 -> 392
    //   291: aload_1
    //   292: astore 12
    //   294: aload_2
    //   295: astore 13
    //   297: aload 6
    //   299: astore 14
    //   301: aload 7
    //   303: astore 15
    //   305: aload_1
    //   306: astore 8
    //   308: aload_2
    //   309: astore 9
    //   311: aload 6
    //   313: astore 10
    //   315: aload 7
    //   317: invokestatic 237	com/tencent/mm/network/b:IT	(Ljava/lang/String;)Lcom/tencent/mm/network/x;
    //   320: checkcast 239	com/tencent/mm/network/w
    //   323: astore_1
    //   324: aload_1
    //   325: checkcast 241	com/tencent/mm/network/x
    //   328: invokevirtual 244	com/tencent/mm/network/x:aPt	()V
    //   331: aload_1
    //   332: ifnonnull +96 -> 428
    //   335: aload_1
    //   336: astore 12
    //   338: aload_2
    //   339: astore 13
    //   341: aload 6
    //   343: astore 14
    //   345: aload 7
    //   347: astore 15
    //   349: aload_1
    //   350: astore 8
    //   352: aload_2
    //   353: astore 9
    //   355: aload 6
    //   357: astore 10
    //   359: aload 16
    //   361: ldc 246
    //   363: putfield 203	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   366: aload_2
    //   367: ifnull +7 -> 374
    //   370: aload_2
    //   371: invokevirtual 251	java/io/OutputStream:close	()V
    //   374: aload 6
    //   376: ifnull +8 -> 384
    //   379: aload 6
    //   381: invokevirtual 252	java/io/InputStream:close	()V
    //   384: ldc 65
    //   386: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: aload 16
    //   391: areturn
    //   392: aload_1
    //   393: astore 12
    //   395: aload_2
    //   396: astore 13
    //   398: aload 6
    //   400: astore 14
    //   402: aload 7
    //   404: astore 15
    //   406: aload_1
    //   407: astore 8
    //   409: aload_2
    //   410: astore 9
    //   412: aload 6
    //   414: astore 10
    //   416: aload 7
    //   418: invokestatic 256	com/tencent/mm/network/b:IS	(Ljava/lang/String;)Lcom/tencent/mm/network/v;
    //   421: checkcast 239	com/tencent/mm/network/w
    //   424: astore_1
    //   425: goto -94 -> 331
    //   428: aload_1
    //   429: astore 12
    //   431: aload_2
    //   432: astore 13
    //   434: aload 6
    //   436: astore 14
    //   438: aload 7
    //   440: astore 15
    //   442: aload_1
    //   443: astore 8
    //   445: aload_2
    //   446: astore 9
    //   448: aload 6
    //   450: astore 10
    //   452: invokestatic 262	com/tencent/mm/av/t:aJf	()Z
    //   455: ifeq +140 -> 595
    //   458: aload_1
    //   459: astore 12
    //   461: aload_2
    //   462: astore 13
    //   464: aload 6
    //   466: astore 14
    //   468: aload 7
    //   470: astore 15
    //   472: aload_1
    //   473: astore 8
    //   475: aload_2
    //   476: astore 9
    //   478: aload 6
    //   480: astore 10
    //   482: aload 7
    //   484: invokestatic 265	com/tencent/mm/av/t:eA	(Ljava/lang/String;)Z
    //   487: ifeq +108 -> 595
    //   490: aload_1
    //   491: astore 12
    //   493: aload_2
    //   494: astore 13
    //   496: aload 6
    //   498: astore 14
    //   500: aload 7
    //   502: astore 15
    //   504: aload_1
    //   505: astore 8
    //   507: aload_2
    //   508: astore 9
    //   510: aload 6
    //   512: astore 10
    //   514: getstatic 270	com/tencent/mm/protocal/d:FFH	I
    //   517: invokestatic 273	com/tencent/mm/av/t:pF	(I)Ljava/lang/String;
    //   520: astore 11
    //   522: aload_1
    //   523: astore 12
    //   525: aload_2
    //   526: astore 13
    //   528: aload 6
    //   530: astore 14
    //   532: aload 7
    //   534: astore 15
    //   536: aload_1
    //   537: astore 8
    //   539: aload_2
    //   540: astore 9
    //   542: aload 6
    //   544: astore 10
    //   546: ldc 114
    //   548: ldc_w 275
    //   551: iconst_1
    //   552: anewarray 4	java/lang/Object
    //   555: dup
    //   556: iconst_0
    //   557: aload 11
    //   559: aastore
    //   560: invokestatic 278	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   563: aload_1
    //   564: astore 12
    //   566: aload_2
    //   567: astore 13
    //   569: aload 6
    //   571: astore 14
    //   573: aload 7
    //   575: astore 15
    //   577: aload_1
    //   578: astore 8
    //   580: aload_2
    //   581: astore 9
    //   583: aload 6
    //   585: astore 10
    //   587: aload_1
    //   588: aload 11
    //   590: invokeinterface 281 2 0
    //   595: aload_1
    //   596: astore 12
    //   598: aload_2
    //   599: astore 13
    //   601: aload 6
    //   603: astore 14
    //   605: aload 7
    //   607: astore 15
    //   609: aload_1
    //   610: astore 8
    //   612: aload_2
    //   613: astore 9
    //   615: aload 6
    //   617: astore 10
    //   619: aload_1
    //   620: iconst_1
    //   621: invokeinterface 285 2 0
    //   626: aload_1
    //   627: astore 12
    //   629: aload_2
    //   630: astore 13
    //   632: aload 6
    //   634: astore 14
    //   636: aload 7
    //   638: astore 15
    //   640: aload_1
    //   641: astore 8
    //   643: aload_2
    //   644: astore 9
    //   646: aload 6
    //   648: astore 10
    //   650: aload_1
    //   651: ldc_w 287
    //   654: invokeinterface 290 2 0
    //   659: aload_1
    //   660: astore 12
    //   662: aload_2
    //   663: astore 13
    //   665: aload 6
    //   667: astore 14
    //   669: aload 7
    //   671: astore 15
    //   673: aload_1
    //   674: astore 8
    //   676: aload_2
    //   677: astore 9
    //   679: aload 6
    //   681: astore 10
    //   683: aload_1
    //   684: aload_0
    //   685: getfield 58	com/tencent/mm/plugin/webcanvas/b:bbx	I
    //   688: invokeinterface 293 2 0
    //   693: aload_1
    //   694: astore 12
    //   696: aload_2
    //   697: astore 13
    //   699: aload 6
    //   701: astore 14
    //   703: aload 7
    //   705: astore 15
    //   707: aload_1
    //   708: astore 8
    //   710: aload_2
    //   711: astore 9
    //   713: aload 6
    //   715: astore 10
    //   717: aload_1
    //   718: aload_0
    //   719: getfield 60	com/tencent/mm/plugin/webcanvas/b:bby	I
    //   722: invokeinterface 296 2 0
    //   727: aload_1
    //   728: astore 12
    //   730: aload_2
    //   731: astore 13
    //   733: aload 6
    //   735: astore 14
    //   737: aload 7
    //   739: astore 15
    //   741: aload_1
    //   742: astore 8
    //   744: aload_2
    //   745: astore 9
    //   747: aload 6
    //   749: astore 10
    //   751: aload 19
    //   753: aload_1
    //   754: invokeinterface 300 1 0
    //   759: invokevirtual 304	com/tencent/mm/plugin/webcanvas/b$b:zT	(I)Z
    //   762: ifeq +548 -> 1310
    //   765: aload_1
    //   766: astore 12
    //   768: aload_2
    //   769: astore 13
    //   771: aload 6
    //   773: astore 14
    //   775: aload 7
    //   777: astore 15
    //   779: aload_1
    //   780: astore 8
    //   782: aload_2
    //   783: astore 9
    //   785: aload 6
    //   787: astore 10
    //   789: aload_1
    //   790: ldc_w 306
    //   793: invokeinterface 309 2 0
    //   798: astore 11
    //   800: aload_1
    //   801: astore 12
    //   803: aload_2
    //   804: astore 13
    //   806: aload 6
    //   808: astore 14
    //   810: aload 7
    //   812: astore 15
    //   814: aload_1
    //   815: astore 8
    //   817: aload_2
    //   818: astore 9
    //   820: aload 6
    //   822: astore 10
    //   824: aload 11
    //   826: ldc_w 311
    //   829: invokestatic 186	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   832: aload_1
    //   833: astore 8
    //   835: aload_2
    //   836: astore 9
    //   838: aload 6
    //   840: astore 10
    //   842: aload 18
    //   844: aload 18
    //   846: getfield 209	d/g/b/y$d:NiW	I
    //   849: iconst_1
    //   850: iadd
    //   851: putfield 209	d/g/b/y$d:NiW	I
    //   854: aload_1
    //   855: astore 8
    //   857: aload_2
    //   858: astore 9
    //   860: aload 6
    //   862: astore 10
    //   864: aload 18
    //   866: getfield 209	d/g/b/y$d:NiW	I
    //   869: istore_3
    //   870: iload_3
    //   871: bipush 15
    //   873: if_icmpge +45 -> 918
    //   876: iconst_0
    //   877: istore_3
    //   878: aload_2
    //   879: ifnull +7 -> 886
    //   882: aload_2
    //   883: invokevirtual 251	java/io/OutputStream:close	()V
    //   886: aload 6
    //   888: ifnull +8 -> 896
    //   891: aload 6
    //   893: invokevirtual 252	java/io/InputStream:close	()V
    //   896: aload_1
    //   897: invokeinterface 314 1 0
    //   902: aload 11
    //   904: astore 7
    //   906: goto -624 -> 282
    //   909: astore 7
    //   911: aload 11
    //   913: astore 7
    //   915: goto -633 -> 282
    //   918: aload_1
    //   919: astore 8
    //   921: aload_2
    //   922: astore 9
    //   924: aload 6
    //   926: astore 10
    //   928: aload 18
    //   930: iconst_0
    //   931: putfield 209	d/g/b/y$d:NiW	I
    //   934: aload 11
    //   936: astore 7
    //   938: iconst_1
    //   939: istore 4
    //   941: aload_1
    //   942: astore 12
    //   944: aload_2
    //   945: astore 13
    //   947: aload 6
    //   949: astore 14
    //   951: aload 7
    //   953: astore 15
    //   955: aload_1
    //   956: astore 8
    //   958: aload_2
    //   959: astore 9
    //   961: aload 6
    //   963: astore 10
    //   965: sipush 1024
    //   968: newarray byte
    //   970: astore 11
    //   972: iconst_0
    //   973: istore_3
    //   974: aload_1
    //   975: astore 12
    //   977: aload_2
    //   978: astore 13
    //   980: aload 6
    //   982: astore 14
    //   984: aload 7
    //   986: astore 15
    //   988: aload_1
    //   989: astore 8
    //   991: aload_2
    //   992: astore 9
    //   994: aload 6
    //   996: astore 10
    //   998: new 80	java/lang/StringBuilder
    //   1001: dup
    //   1002: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1005: aload 17
    //   1007: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: ldc_w 316
    //   1013: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1019: invokestatic 320	com/tencent/mm/vfs/o:Db	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   1022: astore_2
    //   1023: aload 6
    //   1025: ifnull +40 -> 1065
    //   1028: aload_1
    //   1029: astore 12
    //   1031: aload_2
    //   1032: astore 13
    //   1034: aload 6
    //   1036: astore 14
    //   1038: aload 7
    //   1040: astore 15
    //   1042: aload_1
    //   1043: astore 8
    //   1045: aload_2
    //   1046: astore 9
    //   1048: aload 6
    //   1050: astore 10
    //   1052: aload 6
    //   1054: aload 11
    //   1056: invokevirtual 324	java/io/InputStream:read	([B)I
    //   1059: istore_3
    //   1060: iload_3
    //   1061: iconst_m1
    //   1062: if_icmpeq +289 -> 1351
    //   1065: aload_1
    //   1066: astore 12
    //   1068: aload_2
    //   1069: astore 13
    //   1071: aload 6
    //   1073: astore 14
    //   1075: aload 7
    //   1077: astore 15
    //   1079: aload_1
    //   1080: astore 8
    //   1082: aload_2
    //   1083: astore 9
    //   1085: aload 6
    //   1087: astore 10
    //   1089: aload_2
    //   1090: aload 11
    //   1092: iconst_0
    //   1093: iload_3
    //   1094: invokevirtual 328	java/io/OutputStream:write	([BII)V
    //   1097: goto -74 -> 1023
    //   1100: astore 11
    //   1102: aload 15
    //   1104: astore 7
    //   1106: aload 14
    //   1108: astore 6
    //   1110: aload 13
    //   1112: astore_2
    //   1113: aload 12
    //   1115: astore_1
    //   1116: aload_1
    //   1117: astore 8
    //   1119: aload_2
    //   1120: astore 9
    //   1122: aload 6
    //   1124: astore 10
    //   1126: aload 18
    //   1128: iconst_0
    //   1129: putfield 209	d/g/b/y$d:NiW	I
    //   1132: aload_1
    //   1133: astore 8
    //   1135: aload_2
    //   1136: astore 9
    //   1138: aload 6
    //   1140: astore 10
    //   1142: getstatic 168	d/g/b/ad:Njc	Ld/g/b/ad;
    //   1145: astore 12
    //   1147: aload_1
    //   1148: astore 8
    //   1150: aload_2
    //   1151: astore 9
    //   1153: aload 6
    //   1155: astore 10
    //   1157: invokestatic 174	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   1160: ldc 175
    //   1162: invokevirtual 181	android/content/Context:getString	(I)Ljava/lang/String;
    //   1165: astore 12
    //   1167: aload_1
    //   1168: astore 8
    //   1170: aload_2
    //   1171: astore 9
    //   1173: aload 6
    //   1175: astore 10
    //   1177: aload 12
    //   1179: ldc 183
    //   1181: invokestatic 186	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1184: aload_1
    //   1185: astore 8
    //   1187: aload_2
    //   1188: astore 9
    //   1190: aload 6
    //   1192: astore 10
    //   1194: aload 12
    //   1196: iconst_1
    //   1197: anewarray 4	java/lang/Object
    //   1200: dup
    //   1201: iconst_0
    //   1202: aload 11
    //   1204: invokevirtual 187	java/lang/Exception:toString	()Ljava/lang/String;
    //   1207: aastore
    //   1208: iconst_1
    //   1209: invokestatic 193	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   1212: invokestatic 197	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1215: astore 12
    //   1217: aload_1
    //   1218: astore 8
    //   1220: aload_2
    //   1221: astore 9
    //   1223: aload 6
    //   1225: astore 10
    //   1227: aload 12
    //   1229: ldc 199
    //   1231: invokestatic 186	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1234: aload_1
    //   1235: astore 8
    //   1237: aload_2
    //   1238: astore 9
    //   1240: aload 6
    //   1242: astore 10
    //   1244: aload 16
    //   1246: aload 12
    //   1248: putfield 203	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   1251: aload_1
    //   1252: astore 8
    //   1254: aload_2
    //   1255: astore 9
    //   1257: aload 6
    //   1259: astore 10
    //   1261: ldc 114
    //   1263: aload 11
    //   1265: checkcast 157	java/lang/Throwable
    //   1268: ldc 158
    //   1270: iconst_0
    //   1271: anewarray 4	java/lang/Object
    //   1274: invokestatic 162	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1277: aload_2
    //   1278: ifnull +7 -> 1285
    //   1281: aload_2
    //   1282: invokevirtual 251	java/io/OutputStream:close	()V
    //   1285: aload 6
    //   1287: ifnull +8 -> 1295
    //   1290: aload 6
    //   1292: invokevirtual 252	java/io/InputStream:close	()V
    //   1295: aload_1
    //   1296: ifnull +229 -> 1525
    //   1299: aload_1
    //   1300: invokeinterface 314 1 0
    //   1305: iconst_1
    //   1306: istore_3
    //   1307: goto -1025 -> 282
    //   1310: aload_1
    //   1311: astore 12
    //   1313: aload_2
    //   1314: astore 13
    //   1316: aload 6
    //   1318: astore 14
    //   1320: aload 7
    //   1322: astore 15
    //   1324: aload_1
    //   1325: astore 8
    //   1327: aload_2
    //   1328: astore 9
    //   1330: aload 6
    //   1332: astore 10
    //   1334: aload_1
    //   1335: invokeinterface 332 1 0
    //   1340: astore 6
    //   1342: aload 18
    //   1344: iconst_0
    //   1345: putfield 209	d/g/b/y$d:NiW	I
    //   1348: goto -410 -> 938
    //   1351: aload_1
    //   1352: astore 12
    //   1354: aload_2
    //   1355: astore 13
    //   1357: aload 6
    //   1359: astore 14
    //   1361: aload 7
    //   1363: astore 15
    //   1365: aload_1
    //   1366: astore 8
    //   1368: aload_2
    //   1369: astore 9
    //   1371: aload 6
    //   1373: astore 10
    //   1375: new 334	com/tencent/mm/vfs/k
    //   1378: dup
    //   1379: new 80	java/lang/StringBuilder
    //   1382: dup
    //   1383: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1386: aload 17
    //   1388: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: ldc_w 316
    //   1394: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1400: invokespecial 335	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   1403: new 334	com/tencent/mm/vfs/k
    //   1406: dup
    //   1407: aload 17
    //   1409: invokespecial 335	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   1412: invokevirtual 339	com/tencent/mm/vfs/k:ag	(Lcom/tencent/mm/vfs/k;)Z
    //   1415: pop
    //   1416: aload_1
    //   1417: astore 12
    //   1419: aload_2
    //   1420: astore 13
    //   1422: aload 6
    //   1424: astore 14
    //   1426: aload 7
    //   1428: astore 15
    //   1430: aload_1
    //   1431: astore 8
    //   1433: aload_2
    //   1434: astore 9
    //   1436: aload 6
    //   1438: astore 10
    //   1440: aload 16
    //   1442: new 142	java/io/BufferedInputStream
    //   1445: dup
    //   1446: aload 17
    //   1448: invokestatic 146	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1451: invokespecial 149	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1454: checkcast 151	java/io/InputStream
    //   1457: putfield 155	com/github/henryye/nativeiv/b/b$a:inputStream	Ljava/io/InputStream;
    //   1460: aload_1
    //   1461: astore 12
    //   1463: aload_2
    //   1464: astore 13
    //   1466: aload 6
    //   1468: astore 14
    //   1470: aload 7
    //   1472: astore 15
    //   1474: aload_1
    //   1475: astore 8
    //   1477: aload_2
    //   1478: astore 9
    //   1480: aload 6
    //   1482: astore 10
    //   1484: ldc 114
    //   1486: ldc_w 341
    //   1489: invokestatic 140	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1492: aload_2
    //   1493: ifnull +7 -> 1500
    //   1496: aload_2
    //   1497: invokevirtual 251	java/io/OutputStream:close	()V
    //   1500: aload 6
    //   1502: invokevirtual 252	java/io/InputStream:close	()V
    //   1505: aload_1
    //   1506: invokeinterface 314 1 0
    //   1511: iload 4
    //   1513: istore_3
    //   1514: goto -1232 -> 282
    //   1517: astore 8
    //   1519: iload 4
    //   1521: istore_3
    //   1522: goto -1240 -> 282
    //   1525: iconst_1
    //   1526: istore_3
    //   1527: goto -1245 -> 282
    //   1530: astore 8
    //   1532: iconst_1
    //   1533: istore_3
    //   1534: goto -1252 -> 282
    //   1537: astore 7
    //   1539: aload 10
    //   1541: astore 6
    //   1543: aload 9
    //   1545: astore_2
    //   1546: aload 8
    //   1548: astore_1
    //   1549: aload_2
    //   1550: ifnull +7 -> 1557
    //   1553: aload_2
    //   1554: invokevirtual 251	java/io/OutputStream:close	()V
    //   1557: aload 6
    //   1559: ifnull +8 -> 1567
    //   1562: aload 6
    //   1564: invokevirtual 252	java/io/InputStream:close	()V
    //   1567: aload_1
    //   1568: ifnull +9 -> 1577
    //   1571: aload_1
    //   1572: invokeinterface 314 1 0
    //   1577: ldc 65
    //   1579: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1582: aload 7
    //   1584: athrow
    //   1585: ldc 65
    //   1587: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1590: aload 16
    //   1592: areturn
    //   1593: astore_1
    //   1594: goto -17 -> 1577
    //   1597: astore 7
    //   1599: goto -50 -> 1549
    //   1602: astore 7
    //   1604: goto -55 -> 1549
    //   1607: astore 11
    //   1609: goto -493 -> 1116
    //   1612: astore 8
    //   1614: aload 11
    //   1616: astore 7
    //   1618: aload 8
    //   1620: astore 11
    //   1622: goto -506 -> 1116
    //   1625: astore 11
    //   1627: goto -511 -> 1116
    //   1630: astore_1
    //   1631: goto -1247 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1634	0	this	b
    //   0	1634	1	paramObject	Object
    //   0	1634	2	paramImageDecodeConfig	com.github.henryye.nativeiv.ImageDecodeConfig
    //   281	1253	3	i	int
    //   939	581	4	j	int
    //   75	212	5	bool	boolean
    //   43	1520	6	localObject1	Object
    //   21	884	7	localObject2	Object
    //   909	1	7	localException1	java.lang.Exception
    //   913	558	7	localObject3	Object
    //   1537	46	7	localObject4	Object
    //   1597	1	7	localObject5	Object
    //   1602	1	7	localObject6	Object
    //   1616	1	7	localObject7	Object
    //   306	1170	8	localObject8	Object
    //   1517	1	8	localException2	java.lang.Exception
    //   1530	17	8	localException3	java.lang.Exception
    //   1612	7	8	localException4	java.lang.Exception
    //   309	1235	9	localImageDecodeConfig1	com.github.henryye.nativeiv.ImageDecodeConfig
    //   313	1227	10	localObject9	Object
    //   520	571	11	localObject10	Object
    //   1100	164	11	localException5	java.lang.Exception
    //   1607	8	11	localException6	java.lang.Exception
    //   1620	1	11	localException7	java.lang.Exception
    //   1625	1	11	localException8	java.lang.Exception
    //   292	1170	12	localObject11	Object
    //   295	1170	13	localImageDecodeConfig2	com.github.henryye.nativeiv.ImageDecodeConfig
    //   299	1170	14	localObject12	Object
    //   303	1170	15	localObject13	Object
    //   30	1561	16	locala	com.github.henryye.nativeiv.b.b.a
    //   68	1379	17	str	String
    //   235	1108	18	locald	d.g.b.y.d
    //   278	474	19	localb	b.b
    // Exception table:
    //   from	to	target	type
    //   123	150	158	java/lang/Exception
    //   882	886	909	java/lang/Exception
    //   891	896	909	java/lang/Exception
    //   896	902	909	java/lang/Exception
    //   315	324	1100	java/lang/Exception
    //   359	366	1100	java/lang/Exception
    //   416	425	1100	java/lang/Exception
    //   452	458	1100	java/lang/Exception
    //   482	490	1100	java/lang/Exception
    //   514	522	1100	java/lang/Exception
    //   546	563	1100	java/lang/Exception
    //   587	595	1100	java/lang/Exception
    //   619	626	1100	java/lang/Exception
    //   650	659	1100	java/lang/Exception
    //   683	693	1100	java/lang/Exception
    //   717	727	1100	java/lang/Exception
    //   751	765	1100	java/lang/Exception
    //   789	800	1100	java/lang/Exception
    //   824	832	1100	java/lang/Exception
    //   965	972	1100	java/lang/Exception
    //   998	1023	1100	java/lang/Exception
    //   1052	1060	1100	java/lang/Exception
    //   1089	1097	1100	java/lang/Exception
    //   1334	1342	1100	java/lang/Exception
    //   1375	1416	1100	java/lang/Exception
    //   1440	1460	1100	java/lang/Exception
    //   1484	1492	1100	java/lang/Exception
    //   1496	1500	1517	java/lang/Exception
    //   1500	1511	1517	java/lang/Exception
    //   1281	1285	1530	java/lang/Exception
    //   1290	1295	1530	java/lang/Exception
    //   1299	1305	1530	java/lang/Exception
    //   315	324	1537	finally
    //   359	366	1537	finally
    //   416	425	1537	finally
    //   452	458	1537	finally
    //   482	490	1537	finally
    //   514	522	1537	finally
    //   546	563	1537	finally
    //   587	595	1537	finally
    //   619	626	1537	finally
    //   650	659	1537	finally
    //   683	693	1537	finally
    //   717	727	1537	finally
    //   751	765	1537	finally
    //   789	800	1537	finally
    //   824	832	1537	finally
    //   842	854	1537	finally
    //   864	870	1537	finally
    //   928	934	1537	finally
    //   965	972	1537	finally
    //   998	1023	1537	finally
    //   1052	1060	1537	finally
    //   1089	1097	1537	finally
    //   1126	1132	1537	finally
    //   1142	1147	1537	finally
    //   1157	1167	1537	finally
    //   1177	1184	1537	finally
    //   1194	1217	1537	finally
    //   1227	1234	1537	finally
    //   1244	1251	1537	finally
    //   1261	1277	1537	finally
    //   1334	1342	1537	finally
    //   1375	1416	1537	finally
    //   1440	1460	1537	finally
    //   1484	1492	1537	finally
    //   1553	1557	1593	java/lang/Exception
    //   1562	1567	1593	java/lang/Exception
    //   1571	1577	1593	java/lang/Exception
    //   324	331	1597	finally
    //   1342	1348	1602	finally
    //   324	331	1607	java/lang/Exception
    //   842	854	1612	java/lang/Exception
    //   864	870	1612	java/lang/Exception
    //   928	934	1612	java/lang/Exception
    //   1342	1348	1625	java/lang/Exception
    //   370	374	1630	java/lang/Exception
    //   379	384	1630	java/lang/Exception
  }
  
  public final boolean accept(Object paramObject)
  {
    AppMethodBeat.i(213861);
    p.h(paramObject, "obj");
    if (((paramObject instanceof String)) && ((n.nF((String)paramObject, "http://")) || (n.nF((String)paramObject, "https://"))))
    {
      AppMethodBeat.o(213861);
      return true;
    }
    AppMethodBeat.o(213861);
    return false;
  }
  
  public final String sP()
  {
    return "http";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b
 * JD-Core Version:    0.7.0.1
 */