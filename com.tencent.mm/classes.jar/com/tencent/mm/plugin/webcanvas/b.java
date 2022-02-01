package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasHttpImageStreamFetcher;", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "()V", "connectionTimeoutMs", "", "readTimeoutMs", "accept", "", "obj", "", "fetch", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher$StreamFetchResult;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "getSourceTypeName", "", "toFileName", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.github.henryye.nativeiv.b.b
{
  public static final b.a Wkp;
  private int cEM = 30000;
  private int cEN = 30000;
  
  static
  {
    AppMethodBeat.i(261271);
    Wkp = new b.a((byte)0);
    AppMethodBeat.o(261271);
  }
  
  public final String Qj()
  {
    return "http";
  }
  
  /* Error */
  public final com.github.henryye.nativeiv.b.b.a a(Object paramObject, com.github.henryye.nativeiv.ImageDecodeConfig paramImageDecodeConfig)
  {
    // Byte code:
    //   0: ldc 72
    //   2: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 73
    //   8: invokestatic 79	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 80
    //   14: invokestatic 79	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_1
    //   18: checkcast 82	java/lang/String
    //   21: astore 9
    //   23: new 84	com/github/henryye/nativeiv/b/b$a
    //   26: dup
    //   27: invokespecial 85	com/github/henryye/nativeiv/b/b$a:<init>	()V
    //   30: astore 18
    //   32: new 87	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   39: astore_2
    //   40: getstatic 94	com/tencent/mm/plugin/webcanvas/k:WkZ	Lcom/tencent/mm/plugin/webcanvas/k;
    //   43: astore 8
    //   45: aload_2
    //   46: invokestatic 97	com/tencent/mm/plugin/webcanvas/k:ioK	()Ljava/lang/String;
    //   49: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 103
    //   54: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 9
    //   59: invokestatic 109	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 19
    //   70: aload 19
    //   72: invokestatic 121	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   75: istore 7
    //   77: ldc 123
    //   79: new 87	java/lang/StringBuilder
    //   82: dup
    //   83: ldc 125
    //   85: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_1
    //   89: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: bipush 32
    //   94: invokevirtual 131	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   97: aload 19
    //   99: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 133
    //   104: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload 7
    //   109: invokevirtual 136	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: iload 7
    //   120: ifeq +109 -> 229
    //   123: ldc 123
    //   125: ldc 143
    //   127: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 18
    //   132: new 148	java/io/BufferedInputStream
    //   135: dup
    //   136: aload 19
    //   138: invokestatic 152	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: invokespecial 155	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   144: checkcast 157	java/io/InputStream
    //   147: putfield 161	com/github/henryye/nativeiv/b/b$a:inputStream	Ljava/io/InputStream;
    //   150: ldc 72
    //   152: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload 18
    //   157: areturn
    //   158: astore_1
    //   159: ldc 123
    //   161: aload_1
    //   162: checkcast 163	java/lang/Throwable
    //   165: ldc 164
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: getstatic 174	kotlin/g/b/am:aixg	Lkotlin/g/b/am;
    //   177: astore_2
    //   178: invokestatic 180	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   181: getstatic 185	com/tencent/mm/plugin/ba/a$e:appbrand_game_image_stream_error_http_inner	I
    //   184: invokevirtual 191	android/content/Context:getString	(I)Ljava/lang/String;
    //   187: astore_2
    //   188: aload_2
    //   189: ldc 193
    //   191: invokestatic 196	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   194: aload_2
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_1
    //   202: invokevirtual 197	java/lang/Exception:toString	()Ljava/lang/String;
    //   205: aastore
    //   206: iconst_1
    //   207: invokestatic 203	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   210: invokestatic 207	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   213: astore_1
    //   214: aload_1
    //   215: ldc 209
    //   217: invokestatic 196	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   220: aload 18
    //   222: aload_1
    //   223: putfield 213	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   226: goto -76 -> 150
    //   229: new 215	kotlin/g/b/ah$d
    //   232: dup
    //   233: invokespecial 216	kotlin/g/b/ah$d:<init>	()V
    //   236: astore 20
    //   238: aconst_null
    //   239: astore 8
    //   241: aconst_null
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_1
    //   245: ldc 218
    //   247: invokestatic 224	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   250: checkcast 218	com/tencent/mm/plugin/expt/b/c
    //   253: getstatic 230	com/tencent/mm/plugin/expt/b/c$a:zmZ	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   256: iconst_0
    //   257: invokeinterface 233 3 0
    //   262: istore 7
    //   264: iconst_0
    //   265: istore_3
    //   266: iload_3
    //   267: ifne +1490 -> 1757
    //   270: iload 7
    //   272: ifeq +328 -> 600
    //   275: aload_1
    //   276: astore 10
    //   278: aload_2
    //   279: astore 11
    //   281: aload 8
    //   283: astore 12
    //   285: aload_1
    //   286: astore 17
    //   288: aload_2
    //   289: astore 16
    //   291: aload 8
    //   293: astore 15
    //   295: aload 9
    //   297: astore 14
    //   299: aload 9
    //   301: invokestatic 239	com/tencent/mm/network/d:Rt	(Ljava/lang/String;)Lcom/tencent/mm/network/aa;
    //   304: checkcast 241	com/tencent/mm/network/z
    //   307: astore_1
    //   308: aload_1
    //   309: ifnonnull +219 -> 528
    //   312: new 243	java/lang/NullPointerException
    //   315: dup
    //   316: ldc 245
    //   318: invokespecial 246	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   321: astore 10
    //   323: ldc 72
    //   325: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload 10
    //   330: athrow
    //   331: astore 13
    //   333: aload_1
    //   334: astore 10
    //   336: aload_2
    //   337: astore 11
    //   339: aload 8
    //   341: astore 12
    //   343: aload 20
    //   345: iconst_0
    //   346: putfield 249	kotlin/g/b/ah$d:aixb	I
    //   349: aload_1
    //   350: astore 10
    //   352: aload_2
    //   353: astore 11
    //   355: aload 8
    //   357: astore 12
    //   359: getstatic 174	kotlin/g/b/am:aixg	Lkotlin/g/b/am;
    //   362: astore 14
    //   364: aload_1
    //   365: astore 10
    //   367: aload_2
    //   368: astore 11
    //   370: aload 8
    //   372: astore 12
    //   374: invokestatic 180	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   377: getstatic 185	com/tencent/mm/plugin/ba/a$e:appbrand_game_image_stream_error_http_inner	I
    //   380: invokevirtual 191	android/content/Context:getString	(I)Ljava/lang/String;
    //   383: astore 14
    //   385: aload_1
    //   386: astore 10
    //   388: aload_2
    //   389: astore 11
    //   391: aload 8
    //   393: astore 12
    //   395: aload 14
    //   397: ldc 193
    //   399: invokestatic 196	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   402: aload_1
    //   403: astore 10
    //   405: aload_2
    //   406: astore 11
    //   408: aload 8
    //   410: astore 12
    //   412: aload 14
    //   414: iconst_1
    //   415: anewarray 4	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: aload 13
    //   422: invokevirtual 197	java/lang/Exception:toString	()Ljava/lang/String;
    //   425: aastore
    //   426: iconst_1
    //   427: invokestatic 203	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   430: invokestatic 207	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   433: astore 14
    //   435: aload_1
    //   436: astore 10
    //   438: aload_2
    //   439: astore 11
    //   441: aload 8
    //   443: astore 12
    //   445: aload 14
    //   447: ldc 209
    //   449: invokestatic 196	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   452: aload_1
    //   453: astore 10
    //   455: aload_2
    //   456: astore 11
    //   458: aload 8
    //   460: astore 12
    //   462: aload 18
    //   464: aload 14
    //   466: putfield 213	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   469: aload_1
    //   470: astore 10
    //   472: aload_2
    //   473: astore 11
    //   475: aload 8
    //   477: astore 12
    //   479: ldc 123
    //   481: aload 13
    //   483: checkcast 163	java/lang/Throwable
    //   486: ldc 164
    //   488: iconst_0
    //   489: anewarray 4	java/lang/Object
    //   492: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: aload_2
    //   496: ifnull +7 -> 503
    //   499: aload_2
    //   500: invokevirtual 254	java/io/OutputStream:close	()V
    //   503: aload 8
    //   505: ifnull +8 -> 513
    //   508: aload 8
    //   510: invokevirtual 255	java/io/InputStream:close	()V
    //   513: aload_1
    //   514: ifnull +1190 -> 1704
    //   517: aload_1
    //   518: invokeinterface 258 1 0
    //   523: iconst_1
    //   524: istore_3
    //   525: goto -259 -> 266
    //   528: aload_1
    //   529: checkcast 260	com/tencent/mm/network/aa
    //   532: sipush 1500
    //   535: putfield 263	com/tencent/mm/network/aa:pps	I
    //   538: aload_1
    //   539: ifnonnull +98 -> 637
    //   542: aload_1
    //   543: astore 10
    //   545: aload_2
    //   546: astore 11
    //   548: aload 8
    //   550: astore 12
    //   552: aload_1
    //   553: astore 17
    //   555: aload_2
    //   556: astore 16
    //   558: aload 8
    //   560: astore 15
    //   562: aload 9
    //   564: astore 14
    //   566: aload 18
    //   568: ldc_w 265
    //   571: putfield 213	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   574: aload_2
    //   575: ifnull +7 -> 582
    //   578: aload_2
    //   579: invokevirtual 254	java/io/OutputStream:close	()V
    //   582: aload 8
    //   584: ifnull +8 -> 592
    //   587: aload 8
    //   589: invokevirtual 255	java/io/InputStream:close	()V
    //   592: ldc 72
    //   594: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   597: aload 18
    //   599: areturn
    //   600: aload_1
    //   601: astore 10
    //   603: aload_2
    //   604: astore 11
    //   606: aload 8
    //   608: astore 12
    //   610: aload_1
    //   611: astore 17
    //   613: aload_2
    //   614: astore 16
    //   616: aload 8
    //   618: astore 15
    //   620: aload 9
    //   622: astore 14
    //   624: aload 9
    //   626: aconst_null
    //   627: invokestatic 268	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   630: checkcast 241	com/tencent/mm/network/z
    //   633: astore_1
    //   634: goto -96 -> 538
    //   637: aload_1
    //   638: astore 10
    //   640: aload_2
    //   641: astore 11
    //   643: aload 8
    //   645: astore 12
    //   647: aload_1
    //   648: astore 17
    //   650: aload_2
    //   651: astore 16
    //   653: aload 8
    //   655: astore 15
    //   657: aload 9
    //   659: astore 14
    //   661: invokestatic 274	com/tencent/mm/modelimage/u:bKj	()Z
    //   664: ifeq +140 -> 804
    //   667: aload_1
    //   668: astore 10
    //   670: aload_2
    //   671: astore 11
    //   673: aload 8
    //   675: astore 12
    //   677: aload_1
    //   678: astore 17
    //   680: aload_2
    //   681: astore 16
    //   683: aload 8
    //   685: astore 15
    //   687: aload 9
    //   689: astore 14
    //   691: aload 9
    //   693: invokestatic 277	com/tencent/mm/modelimage/u:hA	(Ljava/lang/String;)Z
    //   696: ifeq +108 -> 804
    //   699: aload_1
    //   700: astore 10
    //   702: aload_2
    //   703: astore 11
    //   705: aload 8
    //   707: astore 12
    //   709: aload_1
    //   710: astore 17
    //   712: aload_2
    //   713: astore 16
    //   715: aload 8
    //   717: astore 15
    //   719: aload 9
    //   721: astore 14
    //   723: getstatic 282	com/tencent/mm/protocal/d:Yxh	I
    //   726: invokestatic 285	com/tencent/mm/modelimage/u:wy	(I)Ljava/lang/String;
    //   729: astore 13
    //   731: aload_1
    //   732: astore 10
    //   734: aload_2
    //   735: astore 11
    //   737: aload 8
    //   739: astore 12
    //   741: aload_1
    //   742: astore 17
    //   744: aload_2
    //   745: astore 16
    //   747: aload 8
    //   749: astore 15
    //   751: aload 9
    //   753: astore 14
    //   755: ldc 123
    //   757: ldc_w 287
    //   760: iconst_1
    //   761: anewarray 4	java/lang/Object
    //   764: dup
    //   765: iconst_0
    //   766: aload 13
    //   768: aastore
    //   769: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   772: aload_1
    //   773: astore 10
    //   775: aload_2
    //   776: astore 11
    //   778: aload 8
    //   780: astore 12
    //   782: aload_1
    //   783: astore 17
    //   785: aload_2
    //   786: astore 16
    //   788: aload 8
    //   790: astore 15
    //   792: aload 9
    //   794: astore 14
    //   796: aload_1
    //   797: aload 13
    //   799: invokeinterface 293 2 0
    //   804: aload_1
    //   805: astore 10
    //   807: aload_2
    //   808: astore 11
    //   810: aload 8
    //   812: astore 12
    //   814: aload_1
    //   815: astore 17
    //   817: aload_2
    //   818: astore 16
    //   820: aload 8
    //   822: astore 15
    //   824: aload 9
    //   826: astore 14
    //   828: aload_1
    //   829: iconst_1
    //   830: invokeinterface 297 2 0
    //   835: aload_1
    //   836: astore 10
    //   838: aload_2
    //   839: astore 11
    //   841: aload 8
    //   843: astore 12
    //   845: aload_1
    //   846: astore 17
    //   848: aload_2
    //   849: astore 16
    //   851: aload 8
    //   853: astore 15
    //   855: aload 9
    //   857: astore 14
    //   859: aload_1
    //   860: ldc_w 299
    //   863: invokeinterface 302 2 0
    //   868: aload_1
    //   869: astore 10
    //   871: aload_2
    //   872: astore 11
    //   874: aload 8
    //   876: astore 12
    //   878: aload_1
    //   879: astore 17
    //   881: aload_2
    //   882: astore 16
    //   884: aload 8
    //   886: astore 15
    //   888: aload 9
    //   890: astore 14
    //   892: aload_1
    //   893: aload_0
    //   894: getfield 61	com/tencent/mm/plugin/webcanvas/b:cEM	I
    //   897: invokeinterface 305 2 0
    //   902: aload_1
    //   903: astore 10
    //   905: aload_2
    //   906: astore 11
    //   908: aload 8
    //   910: astore 12
    //   912: aload_1
    //   913: astore 17
    //   915: aload_2
    //   916: astore 16
    //   918: aload 8
    //   920: astore 15
    //   922: aload 9
    //   924: astore 14
    //   926: aload_1
    //   927: aload_0
    //   928: getfield 63	com/tencent/mm/plugin/webcanvas/b:cEN	I
    //   931: invokeinterface 308 2 0
    //   936: aload_1
    //   937: astore 10
    //   939: aload_2
    //   940: astore 11
    //   942: aload 8
    //   944: astore 12
    //   946: aload_1
    //   947: astore 17
    //   949: aload_2
    //   950: astore 16
    //   952: aload 8
    //   954: astore 15
    //   956: aload 9
    //   958: astore 14
    //   960: aload_1
    //   961: invokeinterface 312 1 0
    //   966: istore 4
    //   968: aload_1
    //   969: astore 10
    //   971: aload_2
    //   972: astore 11
    //   974: aload 8
    //   976: astore 12
    //   978: aload_1
    //   979: astore 17
    //   981: aload_2
    //   982: astore 16
    //   984: aload 8
    //   986: astore 15
    //   988: aload 9
    //   990: astore 14
    //   992: ldc 123
    //   994: ldc_w 314
    //   997: iload 4
    //   999: invokestatic 320	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1002: invokestatic 324	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1005: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1008: aload_1
    //   1009: astore 10
    //   1011: aload_2
    //   1012: astore 11
    //   1014: aload 8
    //   1016: astore 12
    //   1018: aload_1
    //   1019: astore 17
    //   1021: aload_2
    //   1022: astore 16
    //   1024: aload 8
    //   1026: astore 15
    //   1028: aload 9
    //   1030: astore 14
    //   1032: aload 20
    //   1034: getfield 249	kotlin/g/b/ah$d:aixb	I
    //   1037: bipush 15
    //   1039: if_icmpge +170 -> 1209
    //   1042: iload 4
    //   1044: sipush 301
    //   1047: if_icmpeq +758 -> 1805
    //   1050: iload 4
    //   1052: sipush 302
    //   1055: if_icmpne +154 -> 1209
    //   1058: goto +747 -> 1805
    //   1061: iload_3
    //   1062: ifeq +347 -> 1409
    //   1065: aload_1
    //   1066: astore 10
    //   1068: aload_2
    //   1069: astore 11
    //   1071: aload 8
    //   1073: astore 12
    //   1075: aload_1
    //   1076: astore 17
    //   1078: aload_2
    //   1079: astore 16
    //   1081: aload 8
    //   1083: astore 15
    //   1085: aload 9
    //   1087: astore 14
    //   1089: aload_1
    //   1090: ldc_w 326
    //   1093: invokeinterface 329 2 0
    //   1098: astore 13
    //   1100: aload_1
    //   1101: astore 10
    //   1103: aload_2
    //   1104: astore 11
    //   1106: aload 8
    //   1108: astore 12
    //   1110: aload_1
    //   1111: astore 17
    //   1113: aload_2
    //   1114: astore 16
    //   1116: aload 8
    //   1118: astore 15
    //   1120: aload 9
    //   1122: astore 14
    //   1124: aload 13
    //   1126: ldc_w 331
    //   1129: invokestatic 196	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1132: aload_1
    //   1133: astore 10
    //   1135: aload_2
    //   1136: astore 11
    //   1138: aload 8
    //   1140: astore 12
    //   1142: aload 20
    //   1144: aload 20
    //   1146: getfield 249	kotlin/g/b/ah$d:aixb	I
    //   1149: iconst_1
    //   1150: iadd
    //   1151: putfield 249	kotlin/g/b/ah$d:aixb	I
    //   1154: aload_1
    //   1155: astore 10
    //   1157: aload_2
    //   1158: astore 11
    //   1160: aload 8
    //   1162: astore 12
    //   1164: aload 20
    //   1166: getfield 249	kotlin/g/b/ah$d:aixb	I
    //   1169: istore_3
    //   1170: iload_3
    //   1171: bipush 15
    //   1173: if_icmpge +50 -> 1223
    //   1176: iconst_0
    //   1177: istore_3
    //   1178: aload_2
    //   1179: ifnull +7 -> 1186
    //   1182: aload_2
    //   1183: invokevirtual 254	java/io/OutputStream:close	()V
    //   1186: aload 8
    //   1188: ifnull +8 -> 1196
    //   1191: aload 8
    //   1193: invokevirtual 255	java/io/InputStream:close	()V
    //   1196: aload_1
    //   1197: invokeinterface 258 1 0
    //   1202: aload 13
    //   1204: astore 9
    //   1206: goto -940 -> 266
    //   1209: iconst_0
    //   1210: istore_3
    //   1211: goto -150 -> 1061
    //   1214: astore 9
    //   1216: aload 13
    //   1218: astore 9
    //   1220: goto -954 -> 266
    //   1223: aload_1
    //   1224: astore 10
    //   1226: aload_2
    //   1227: astore 11
    //   1229: aload 8
    //   1231: astore 12
    //   1233: aload 20
    //   1235: iconst_0
    //   1236: putfield 249	kotlin/g/b/ah$d:aixb	I
    //   1239: aload 13
    //   1241: astore 9
    //   1243: iconst_1
    //   1244: istore 6
    //   1246: aload_1
    //   1247: astore 10
    //   1249: aload_2
    //   1250: astore 11
    //   1252: aload 8
    //   1254: astore 12
    //   1256: aload_1
    //   1257: astore 17
    //   1259: aload_2
    //   1260: astore 16
    //   1262: aload 8
    //   1264: astore 15
    //   1266: aload 9
    //   1268: astore 14
    //   1270: sipush 1024
    //   1273: newarray byte
    //   1275: astore 13
    //   1277: iconst_0
    //   1278: istore_3
    //   1279: aload_1
    //   1280: astore 10
    //   1282: aload_2
    //   1283: astore 11
    //   1285: aload 8
    //   1287: astore 12
    //   1289: aload_1
    //   1290: astore 17
    //   1292: aload_2
    //   1293: astore 16
    //   1295: aload 8
    //   1297: astore 15
    //   1299: aload 9
    //   1301: astore 14
    //   1303: aload 19
    //   1305: ldc_w 333
    //   1308: invokestatic 324	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1311: iconst_0
    //   1312: invokestatic 337	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   1315: astore_2
    //   1316: aload 8
    //   1318: ifnull +212 -> 1530
    //   1321: aload_1
    //   1322: astore 10
    //   1324: aload_2
    //   1325: astore 11
    //   1327: aload 8
    //   1329: astore 12
    //   1331: aload_1
    //   1332: astore 17
    //   1334: aload_2
    //   1335: astore 16
    //   1337: aload 8
    //   1339: astore 15
    //   1341: aload 9
    //   1343: astore 14
    //   1345: aload 8
    //   1347: aload 13
    //   1349: invokevirtual 341	java/io/InputStream:read	([B)I
    //   1352: istore 4
    //   1354: iload 4
    //   1356: istore_3
    //   1357: iload 4
    //   1359: iconst_m1
    //   1360: if_icmpne +170 -> 1530
    //   1363: iconst_1
    //   1364: istore 5
    //   1366: iload 4
    //   1368: istore_3
    //   1369: iload 5
    //   1371: ifne +165 -> 1536
    //   1374: aload_1
    //   1375: astore 10
    //   1377: aload_2
    //   1378: astore 11
    //   1380: aload 8
    //   1382: astore 12
    //   1384: aload_1
    //   1385: astore 17
    //   1387: aload_2
    //   1388: astore 16
    //   1390: aload 8
    //   1392: astore 15
    //   1394: aload 9
    //   1396: astore 14
    //   1398: aload_2
    //   1399: aload 13
    //   1401: iconst_0
    //   1402: iload_3
    //   1403: invokevirtual 345	java/io/OutputStream:write	([BII)V
    //   1406: goto -90 -> 1316
    //   1409: iload 4
    //   1411: sipush 200
    //   1414: if_icmpeq +75 -> 1489
    //   1417: aload_1
    //   1418: astore 10
    //   1420: aload_2
    //   1421: astore 11
    //   1423: aload 8
    //   1425: astore 12
    //   1427: aload_1
    //   1428: astore 17
    //   1430: aload_2
    //   1431: astore 16
    //   1433: aload 8
    //   1435: astore 15
    //   1437: aload 9
    //   1439: astore 14
    //   1441: aload 18
    //   1443: ldc_w 347
    //   1446: iload 4
    //   1448: invokestatic 320	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1451: invokestatic 324	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1454: putfield 213	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   1457: aload_2
    //   1458: ifnull +7 -> 1465
    //   1461: aload_2
    //   1462: invokevirtual 254	java/io/OutputStream:close	()V
    //   1465: aload 8
    //   1467: ifnull +8 -> 1475
    //   1470: aload 8
    //   1472: invokevirtual 255	java/io/InputStream:close	()V
    //   1475: aload_1
    //   1476: invokeinterface 258 1 0
    //   1481: ldc 72
    //   1483: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1486: aload 18
    //   1488: areturn
    //   1489: aload_1
    //   1490: astore 10
    //   1492: aload_2
    //   1493: astore 11
    //   1495: aload 8
    //   1497: astore 12
    //   1499: aload_1
    //   1500: astore 17
    //   1502: aload_2
    //   1503: astore 16
    //   1505: aload 8
    //   1507: astore 15
    //   1509: aload 9
    //   1511: astore 14
    //   1513: aload_1
    //   1514: invokeinterface 351 1 0
    //   1519: astore 8
    //   1521: aload 20
    //   1523: iconst_0
    //   1524: putfield 249	kotlin/g/b/ah$d:aixb	I
    //   1527: goto -284 -> 1243
    //   1530: iconst_0
    //   1531: istore 5
    //   1533: goto -164 -> 1369
    //   1536: aload_1
    //   1537: astore 10
    //   1539: aload_2
    //   1540: astore 11
    //   1542: aload 8
    //   1544: astore 12
    //   1546: aload_1
    //   1547: astore 17
    //   1549: aload_2
    //   1550: astore 16
    //   1552: aload 8
    //   1554: astore 15
    //   1556: aload 9
    //   1558: astore 14
    //   1560: new 353	com/tencent/mm/vfs/u
    //   1563: dup
    //   1564: aload 19
    //   1566: ldc_w 333
    //   1569: invokestatic 324	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1572: invokespecial 354	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   1575: new 353	com/tencent/mm/vfs/u
    //   1578: dup
    //   1579: aload 19
    //   1581: invokespecial 354	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   1584: invokevirtual 358	com/tencent/mm/vfs/u:am	(Lcom/tencent/mm/vfs/u;)Z
    //   1587: pop
    //   1588: aload_1
    //   1589: astore 10
    //   1591: aload_2
    //   1592: astore 11
    //   1594: aload 8
    //   1596: astore 12
    //   1598: aload_1
    //   1599: astore 17
    //   1601: aload_2
    //   1602: astore 16
    //   1604: aload 8
    //   1606: astore 15
    //   1608: aload 9
    //   1610: astore 14
    //   1612: aload 18
    //   1614: new 148	java/io/BufferedInputStream
    //   1617: dup
    //   1618: aload 19
    //   1620: invokestatic 152	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1623: invokespecial 155	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1626: checkcast 157	java/io/InputStream
    //   1629: putfield 161	com/github/henryye/nativeiv/b/b$a:inputStream	Ljava/io/InputStream;
    //   1632: aload_1
    //   1633: astore 10
    //   1635: aload_2
    //   1636: astore 11
    //   1638: aload 8
    //   1640: astore 12
    //   1642: aload_1
    //   1643: astore 17
    //   1645: aload_2
    //   1646: astore 16
    //   1648: aload 8
    //   1650: astore 15
    //   1652: aload 9
    //   1654: astore 14
    //   1656: ldc 123
    //   1658: ldc_w 360
    //   1661: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1664: aload_2
    //   1665: ifnull +7 -> 1672
    //   1668: aload_2
    //   1669: invokevirtual 254	java/io/OutputStream:close	()V
    //   1672: aload 8
    //   1674: ifnull +8 -> 1682
    //   1677: aload 8
    //   1679: invokevirtual 255	java/io/InputStream:close	()V
    //   1682: aload_1
    //   1683: invokeinterface 258 1 0
    //   1688: iload 6
    //   1690: istore_3
    //   1691: goto -1425 -> 266
    //   1694: astore 10
    //   1696: iload 6
    //   1698: istore_3
    //   1699: goto -1433 -> 266
    //   1702: astore 10
    //   1704: iconst_1
    //   1705: istore_3
    //   1706: goto -1440 -> 266
    //   1709: astore 9
    //   1711: aload 12
    //   1713: astore 8
    //   1715: aload 11
    //   1717: astore_2
    //   1718: aload 10
    //   1720: astore_1
    //   1721: aload_2
    //   1722: ifnull +7 -> 1729
    //   1725: aload_2
    //   1726: invokevirtual 254	java/io/OutputStream:close	()V
    //   1729: aload 8
    //   1731: ifnull +8 -> 1739
    //   1734: aload 8
    //   1736: invokevirtual 255	java/io/InputStream:close	()V
    //   1739: aload_1
    //   1740: ifnull +9 -> 1749
    //   1743: aload_1
    //   1744: invokeinterface 258 1 0
    //   1749: ldc 72
    //   1751: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1754: aload 9
    //   1756: athrow
    //   1757: ldc 72
    //   1759: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1762: aload 18
    //   1764: areturn
    //   1765: astore_1
    //   1766: goto -17 -> 1749
    //   1769: astore 9
    //   1771: goto -50 -> 1721
    //   1774: astore 9
    //   1776: goto -55 -> 1721
    //   1779: astore 10
    //   1781: aload 13
    //   1783: astore 9
    //   1785: aload 10
    //   1787: astore 13
    //   1789: goto -1456 -> 333
    //   1792: astore 13
    //   1794: goto -1461 -> 333
    //   1797: astore_1
    //   1798: goto -317 -> 1481
    //   1801: astore_1
    //   1802: goto -1210 -> 592
    //   1805: iconst_1
    //   1806: istore_3
    //   1807: goto -746 -> 1061
    //   1810: astore 13
    //   1812: aload 17
    //   1814: astore_1
    //   1815: aload 16
    //   1817: astore_2
    //   1818: aload 15
    //   1820: astore 8
    //   1822: aload 14
    //   1824: astore 9
    //   1826: goto -1493 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1829	0	this	b
    //   0	1829	1	paramObject	Object
    //   0	1829	2	paramImageDecodeConfig	com.github.henryye.nativeiv.ImageDecodeConfig
    //   265	1542	3	i	int
    //   966	481	4	j	int
    //   1364	168	5	k	int
    //   1244	453	6	m	int
    //   75	196	7	bool	boolean
    //   43	1778	8	localObject1	Object
    //   21	1184	9	localObject2	Object
    //   1214	1	9	localException1	java.lang.Exception
    //   1218	435	9	localObject3	Object
    //   1709	46	9	localObject4	Object
    //   1769	1	9	localObject5	Object
    //   1774	1	9	localObject6	Object
    //   1783	42	9	localObject7	Object
    //   276	1358	10	localObject8	Object
    //   1694	1	10	localException2	java.lang.Exception
    //   1702	17	10	localException3	java.lang.Exception
    //   1779	7	10	localException4	java.lang.Exception
    //   279	1437	11	localImageDecodeConfig1	com.github.henryye.nativeiv.ImageDecodeConfig
    //   283	1429	12	localObject9	Object
    //   331	151	13	localException5	java.lang.Exception
    //   729	1059	13	localObject10	Object
    //   1792	1	13	localException6	java.lang.Exception
    //   1810	1	13	localException7	java.lang.Exception
    //   297	1526	14	localObject11	Object
    //   293	1526	15	localObject12	Object
    //   289	1527	16	localImageDecodeConfig2	com.github.henryye.nativeiv.ImageDecodeConfig
    //   286	1527	17	localObject13	Object
    //   30	1733	18	locala	com.github.henryye.nativeiv.b.b.a
    //   68	1551	19	str	String
    //   236	1286	20	locald	kotlin.g.b.ah.d
    // Exception table:
    //   from	to	target	type
    //   123	150	158	java/lang/Exception
    //   312	331	331	java/lang/Exception
    //   528	538	331	java/lang/Exception
    //   1182	1186	1214	java/lang/Exception
    //   1191	1196	1214	java/lang/Exception
    //   1196	1202	1214	java/lang/Exception
    //   1668	1672	1694	java/lang/Exception
    //   1677	1682	1694	java/lang/Exception
    //   1682	1688	1694	java/lang/Exception
    //   499	503	1702	java/lang/Exception
    //   508	513	1702	java/lang/Exception
    //   517	523	1702	java/lang/Exception
    //   299	308	1709	finally
    //   343	349	1709	finally
    //   359	364	1709	finally
    //   374	385	1709	finally
    //   395	402	1709	finally
    //   412	435	1709	finally
    //   445	452	1709	finally
    //   462	469	1709	finally
    //   479	495	1709	finally
    //   566	574	1709	finally
    //   624	634	1709	finally
    //   661	667	1709	finally
    //   691	699	1709	finally
    //   723	731	1709	finally
    //   755	772	1709	finally
    //   796	804	1709	finally
    //   828	835	1709	finally
    //   859	868	1709	finally
    //   892	902	1709	finally
    //   926	936	1709	finally
    //   960	968	1709	finally
    //   992	1008	1709	finally
    //   1032	1042	1709	finally
    //   1089	1100	1709	finally
    //   1124	1132	1709	finally
    //   1142	1154	1709	finally
    //   1164	1170	1709	finally
    //   1233	1239	1709	finally
    //   1270	1277	1709	finally
    //   1303	1316	1709	finally
    //   1345	1354	1709	finally
    //   1398	1406	1709	finally
    //   1441	1457	1709	finally
    //   1513	1521	1709	finally
    //   1560	1588	1709	finally
    //   1612	1632	1709	finally
    //   1656	1664	1709	finally
    //   1725	1729	1765	java/lang/Exception
    //   1734	1739	1765	java/lang/Exception
    //   1743	1749	1765	java/lang/Exception
    //   312	331	1769	finally
    //   528	538	1769	finally
    //   1521	1527	1774	finally
    //   1142	1154	1779	java/lang/Exception
    //   1164	1170	1779	java/lang/Exception
    //   1233	1239	1779	java/lang/Exception
    //   1521	1527	1792	java/lang/Exception
    //   1461	1465	1797	java/lang/Exception
    //   1470	1475	1797	java/lang/Exception
    //   1475	1481	1797	java/lang/Exception
    //   578	582	1801	java/lang/Exception
    //   587	592	1801	java/lang/Exception
    //   299	308	1810	java/lang/Exception
    //   566	574	1810	java/lang/Exception
    //   624	634	1810	java/lang/Exception
    //   661	667	1810	java/lang/Exception
    //   691	699	1810	java/lang/Exception
    //   723	731	1810	java/lang/Exception
    //   755	772	1810	java/lang/Exception
    //   796	804	1810	java/lang/Exception
    //   828	835	1810	java/lang/Exception
    //   859	868	1810	java/lang/Exception
    //   892	902	1810	java/lang/Exception
    //   926	936	1810	java/lang/Exception
    //   960	968	1810	java/lang/Exception
    //   992	1008	1810	java/lang/Exception
    //   1032	1042	1810	java/lang/Exception
    //   1089	1100	1810	java/lang/Exception
    //   1124	1132	1810	java/lang/Exception
    //   1270	1277	1810	java/lang/Exception
    //   1303	1316	1810	java/lang/Exception
    //   1345	1354	1810	java/lang/Exception
    //   1398	1406	1810	java/lang/Exception
    //   1441	1457	1810	java/lang/Exception
    //   1513	1521	1810	java/lang/Exception
    //   1560	1588	1810	java/lang/Exception
    //   1612	1632	1810	java/lang/Exception
    //   1656	1664	1810	java/lang/Exception
  }
  
  public final boolean be(Object paramObject)
  {
    AppMethodBeat.i(261277);
    s.u(paramObject, "obj");
    if (((paramObject instanceof String)) && ((n.U((String)paramObject, "http://", false)) || (n.U((String)paramObject, "https://", false))))
    {
      AppMethodBeat.o(261277);
      return true;
    }
    AppMethodBeat.o(261277);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b
 * JD-Core Version:    0.7.0.1
 */