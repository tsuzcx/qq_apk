package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasHttpImageStreamFetcher;", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "()V", "connectionTimeoutMs", "", "readTimeoutMs", "accept", "", "obj", "", "fetch", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher$StreamFetchResult;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "getSourceTypeName", "", "toFileName", "Companion", "webview-sdk_release"})
public final class b
  implements com.github.henryye.nativeiv.b.b
{
  public static final b.a PtF;
  private int aKQ = 30000;
  private int aKR = 30000;
  
  static
  {
    AppMethodBeat.i(205673);
    PtF = new b.a((byte)0);
    AppMethodBeat.o(205673);
  }
  
  public final boolean V(Object paramObject)
  {
    AppMethodBeat.i(205666);
    p.k(paramObject, "obj");
    if (((paramObject instanceof String)) && ((n.M((String)paramObject, "http://", false)) || (n.M((String)paramObject, "https://", false))))
    {
      AppMethodBeat.o(205666);
      return true;
    }
    AppMethodBeat.o(205666);
    return false;
  }
  
  /* Error */
  public final com.github.henryye.nativeiv.b.b.a a(Object paramObject, com.github.henryye.nativeiv.ImageDecodeConfig paramImageDecodeConfig)
  {
    // Byte code:
    //   0: ldc 87
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 64
    //   8: invokestatic 70	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 88
    //   14: invokestatic 70	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_1
    //   18: checkcast 72	java/lang/String
    //   21: astore 7
    //   23: new 90	com/github/henryye/nativeiv/b/b$a
    //   26: dup
    //   27: invokespecial 91	com/github/henryye/nativeiv/b/b$a:<init>	()V
    //   30: astore 16
    //   32: new 93	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   39: astore_2
    //   40: getstatic 100	com/tencent/mm/plugin/webcanvas/m:PuL	Lcom/tencent/mm/plugin/webcanvas/m;
    //   43: astore 6
    //   45: aload_2
    //   46: invokestatic 104	com/tencent/mm/plugin/webcanvas/m:gPp	()Ljava/lang/String;
    //   49: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 110
    //   54: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 7
    //   59: invokestatic 116	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 17
    //   70: aload 17
    //   72: invokestatic 125	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   75: istore 5
    //   77: ldc 127
    //   79: new 93	java/lang/StringBuilder
    //   82: dup
    //   83: ldc 129
    //   85: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_1
    //   89: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: bipush 32
    //   94: invokevirtual 138	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   97: aload 17
    //   99: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 140
    //   104: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload 5
    //   109: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: iload 5
    //   120: ifeq +109 -> 229
    //   123: ldc 127
    //   125: ldc 150
    //   127: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 16
    //   132: new 155	java/io/BufferedInputStream
    //   135: dup
    //   136: aload 17
    //   138: invokestatic 159	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: invokespecial 162	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   144: checkcast 164	java/io/InputStream
    //   147: putfield 168	com/github/henryye/nativeiv/b/b$a:aFw	Ljava/io/InputStream;
    //   150: ldc 87
    //   152: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload 16
    //   157: areturn
    //   158: astore_1
    //   159: ldc 127
    //   161: aload_1
    //   162: checkcast 170	java/lang/Throwable
    //   165: ldc 171
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: getstatic 181	kotlin/g/b/af:aaBG	Lkotlin/g/b/af;
    //   177: astore_2
    //   178: invokestatic 187	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   181: getstatic 192	com/tencent/mm/plugin/ay/a$a:appbrand_game_image_stream_error_http_inner	I
    //   184: invokevirtual 198	android/content/Context:getString	(I)Ljava/lang/String;
    //   187: astore_2
    //   188: aload_2
    //   189: ldc 200
    //   191: invokestatic 203	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   194: aload_2
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_1
    //   202: invokevirtual 204	java/lang/Exception:toString	()Ljava/lang/String;
    //   205: aastore
    //   206: iconst_1
    //   207: invokestatic 210	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   210: invokestatic 214	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   213: astore_1
    //   214: aload_1
    //   215: ldc 216
    //   217: invokestatic 203	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   220: aload 16
    //   222: aload_1
    //   223: putfield 220	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   226: goto -76 -> 150
    //   229: new 222	kotlin/g/b/aa$d
    //   232: dup
    //   233: invokespecial 223	kotlin/g/b/aa$d:<init>	()V
    //   236: astore 18
    //   238: aload 18
    //   240: iconst_0
    //   241: putfield 226	kotlin/g/b/aa$d:aaBA	I
    //   244: aconst_null
    //   245: astore 6
    //   247: aconst_null
    //   248: astore_2
    //   249: aconst_null
    //   250: astore_1
    //   251: ldc 228
    //   253: invokestatic 234	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   256: checkcast 228	com/tencent/mm/plugin/expt/b/b
    //   259: getstatic 240	com/tencent/mm/plugin/expt/b/b$a:vUw	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   262: iconst_0
    //   263: invokeinterface 243 3 0
    //   268: istore 5
    //   270: new 245	com/tencent/mm/plugin/webcanvas/b$b
    //   273: dup
    //   274: aload 18
    //   276: invokespecial 248	com/tencent/mm/plugin/webcanvas/b$b:<init>	(Lkotlin/g/b/aa$d;)V
    //   279: astore 19
    //   281: iconst_0
    //   282: istore_3
    //   283: iload_3
    //   284: ifne +1304 -> 1588
    //   287: iload 5
    //   289: ifeq +105 -> 394
    //   292: aload_1
    //   293: astore 12
    //   295: aload_2
    //   296: astore 13
    //   298: aload 6
    //   300: astore 14
    //   302: aload 7
    //   304: astore 15
    //   306: aload_1
    //   307: astore 8
    //   309: aload_2
    //   310: astore 9
    //   312: aload 6
    //   314: astore 10
    //   316: aload 7
    //   318: invokestatic 254	com/tencent/mm/network/d:Zq	(Ljava/lang/String;)Lcom/tencent/mm/network/z;
    //   321: checkcast 256	com/tencent/mm/network/y
    //   324: astore_1
    //   325: aload_1
    //   326: checkcast 258	com/tencent/mm/network/z
    //   329: invokevirtual 261	com/tencent/mm/network/z:btB	()V
    //   332: aload_1
    //   333: ifnonnull +97 -> 430
    //   336: aload_1
    //   337: astore 12
    //   339: aload_2
    //   340: astore 13
    //   342: aload 6
    //   344: astore 14
    //   346: aload 7
    //   348: astore 15
    //   350: aload_1
    //   351: astore 8
    //   353: aload_2
    //   354: astore 9
    //   356: aload 6
    //   358: astore 10
    //   360: aload 16
    //   362: ldc_w 263
    //   365: putfield 220	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   368: aload_2
    //   369: ifnull +7 -> 376
    //   372: aload_2
    //   373: invokevirtual 268	java/io/OutputStream:close	()V
    //   376: aload 6
    //   378: ifnull +8 -> 386
    //   381: aload 6
    //   383: invokevirtual 269	java/io/InputStream:close	()V
    //   386: ldc 87
    //   388: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   391: aload 16
    //   393: areturn
    //   394: aload_1
    //   395: astore 12
    //   397: aload_2
    //   398: astore 13
    //   400: aload 6
    //   402: astore 14
    //   404: aload 7
    //   406: astore 15
    //   408: aload_1
    //   409: astore 8
    //   411: aload_2
    //   412: astore 9
    //   414: aload 6
    //   416: astore 10
    //   418: aload 7
    //   420: invokestatic 273	com/tencent/mm/network/d:Zp	(Ljava/lang/String;)Lcom/tencent/mm/network/x;
    //   423: checkcast 256	com/tencent/mm/network/y
    //   426: astore_1
    //   427: goto -95 -> 332
    //   430: aload_1
    //   431: astore 12
    //   433: aload_2
    //   434: astore 13
    //   436: aload 6
    //   438: astore 14
    //   440: aload 7
    //   442: astore 15
    //   444: aload_1
    //   445: astore 8
    //   447: aload_2
    //   448: astore 9
    //   450: aload 6
    //   452: astore 10
    //   454: invokestatic 279	com/tencent/mm/ay/t:bmq	()Z
    //   457: ifeq +140 -> 597
    //   460: aload_1
    //   461: astore 12
    //   463: aload_2
    //   464: astore 13
    //   466: aload 6
    //   468: astore 14
    //   470: aload 7
    //   472: astore 15
    //   474: aload_1
    //   475: astore 8
    //   477: aload_2
    //   478: astore 9
    //   480: aload 6
    //   482: astore 10
    //   484: aload 7
    //   486: invokestatic 282	com/tencent/mm/ay/t:fX	(Ljava/lang/String;)Z
    //   489: ifeq +108 -> 597
    //   492: aload_1
    //   493: astore 12
    //   495: aload_2
    //   496: astore 13
    //   498: aload 6
    //   500: astore 14
    //   502: aload 7
    //   504: astore 15
    //   506: aload_1
    //   507: astore 8
    //   509: aload_2
    //   510: astore 9
    //   512: aload 6
    //   514: astore 10
    //   516: getstatic 287	com/tencent/mm/protocal/d:RAD	I
    //   519: invokestatic 290	com/tencent/mm/ay/t:wt	(I)Ljava/lang/String;
    //   522: astore 11
    //   524: aload_1
    //   525: astore 12
    //   527: aload_2
    //   528: astore 13
    //   530: aload 6
    //   532: astore 14
    //   534: aload 7
    //   536: astore 15
    //   538: aload_1
    //   539: astore 8
    //   541: aload_2
    //   542: astore 9
    //   544: aload 6
    //   546: astore 10
    //   548: ldc 127
    //   550: ldc_w 292
    //   553: iconst_1
    //   554: anewarray 4	java/lang/Object
    //   557: dup
    //   558: iconst_0
    //   559: aload 11
    //   561: aastore
    //   562: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   565: aload_1
    //   566: astore 12
    //   568: aload_2
    //   569: astore 13
    //   571: aload 6
    //   573: astore 14
    //   575: aload 7
    //   577: astore 15
    //   579: aload_1
    //   580: astore 8
    //   582: aload_2
    //   583: astore 9
    //   585: aload 6
    //   587: astore 10
    //   589: aload_1
    //   590: aload 11
    //   592: invokeinterface 298 2 0
    //   597: aload_1
    //   598: astore 12
    //   600: aload_2
    //   601: astore 13
    //   603: aload 6
    //   605: astore 14
    //   607: aload 7
    //   609: astore 15
    //   611: aload_1
    //   612: astore 8
    //   614: aload_2
    //   615: astore 9
    //   617: aload 6
    //   619: astore 10
    //   621: aload_1
    //   622: iconst_1
    //   623: invokeinterface 302 2 0
    //   628: aload_1
    //   629: astore 12
    //   631: aload_2
    //   632: astore 13
    //   634: aload 6
    //   636: astore 14
    //   638: aload 7
    //   640: astore 15
    //   642: aload_1
    //   643: astore 8
    //   645: aload_2
    //   646: astore 9
    //   648: aload 6
    //   650: astore 10
    //   652: aload_1
    //   653: ldc_w 304
    //   656: invokeinterface 307 2 0
    //   661: aload_1
    //   662: astore 12
    //   664: aload_2
    //   665: astore 13
    //   667: aload 6
    //   669: astore 14
    //   671: aload 7
    //   673: astore 15
    //   675: aload_1
    //   676: astore 8
    //   678: aload_2
    //   679: astore 9
    //   681: aload 6
    //   683: astore 10
    //   685: aload_1
    //   686: aload_0
    //   687: getfield 58	com/tencent/mm/plugin/webcanvas/b:aKQ	I
    //   690: invokeinterface 310 2 0
    //   695: aload_1
    //   696: astore 12
    //   698: aload_2
    //   699: astore 13
    //   701: aload 6
    //   703: astore 14
    //   705: aload 7
    //   707: astore 15
    //   709: aload_1
    //   710: astore 8
    //   712: aload_2
    //   713: astore 9
    //   715: aload 6
    //   717: astore 10
    //   719: aload_1
    //   720: aload_0
    //   721: getfield 60	com/tencent/mm/plugin/webcanvas/b:aKR	I
    //   724: invokeinterface 313 2 0
    //   729: aload_1
    //   730: astore 12
    //   732: aload_2
    //   733: astore 13
    //   735: aload 6
    //   737: astore 14
    //   739: aload 7
    //   741: astore 15
    //   743: aload_1
    //   744: astore 8
    //   746: aload_2
    //   747: astore 9
    //   749: aload 6
    //   751: astore 10
    //   753: aload 19
    //   755: aload_1
    //   756: invokeinterface 317 1 0
    //   761: invokevirtual 321	com/tencent/mm/plugin/webcanvas/b$b:Hi	(I)Z
    //   764: ifeq +549 -> 1313
    //   767: aload_1
    //   768: astore 12
    //   770: aload_2
    //   771: astore 13
    //   773: aload 6
    //   775: astore 14
    //   777: aload 7
    //   779: astore 15
    //   781: aload_1
    //   782: astore 8
    //   784: aload_2
    //   785: astore 9
    //   787: aload 6
    //   789: astore 10
    //   791: aload_1
    //   792: ldc_w 323
    //   795: invokeinterface 326 2 0
    //   800: astore 11
    //   802: aload_1
    //   803: astore 12
    //   805: aload_2
    //   806: astore 13
    //   808: aload 6
    //   810: astore 14
    //   812: aload 7
    //   814: astore 15
    //   816: aload_1
    //   817: astore 8
    //   819: aload_2
    //   820: astore 9
    //   822: aload 6
    //   824: astore 10
    //   826: aload 11
    //   828: ldc_w 328
    //   831: invokestatic 203	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   834: aload_1
    //   835: astore 8
    //   837: aload_2
    //   838: astore 9
    //   840: aload 6
    //   842: astore 10
    //   844: aload 18
    //   846: aload 18
    //   848: getfield 226	kotlin/g/b/aa$d:aaBA	I
    //   851: iconst_1
    //   852: iadd
    //   853: putfield 226	kotlin/g/b/aa$d:aaBA	I
    //   856: aload_1
    //   857: astore 8
    //   859: aload_2
    //   860: astore 9
    //   862: aload 6
    //   864: astore 10
    //   866: aload 18
    //   868: getfield 226	kotlin/g/b/aa$d:aaBA	I
    //   871: istore_3
    //   872: iload_3
    //   873: bipush 15
    //   875: if_icmpge +45 -> 920
    //   878: iconst_0
    //   879: istore_3
    //   880: aload_2
    //   881: ifnull +7 -> 888
    //   884: aload_2
    //   885: invokevirtual 268	java/io/OutputStream:close	()V
    //   888: aload 6
    //   890: ifnull +8 -> 898
    //   893: aload 6
    //   895: invokevirtual 269	java/io/InputStream:close	()V
    //   898: aload_1
    //   899: invokeinterface 331 1 0
    //   904: aload 11
    //   906: astore 7
    //   908: goto -625 -> 283
    //   911: astore 7
    //   913: aload 11
    //   915: astore 7
    //   917: goto -634 -> 283
    //   920: aload_1
    //   921: astore 8
    //   923: aload_2
    //   924: astore 9
    //   926: aload 6
    //   928: astore 10
    //   930: aload 18
    //   932: iconst_0
    //   933: putfield 226	kotlin/g/b/aa$d:aaBA	I
    //   936: aload 11
    //   938: astore 7
    //   940: iconst_1
    //   941: istore 4
    //   943: aload_1
    //   944: astore 12
    //   946: aload_2
    //   947: astore 13
    //   949: aload 6
    //   951: astore 14
    //   953: aload 7
    //   955: astore 15
    //   957: aload_1
    //   958: astore 8
    //   960: aload_2
    //   961: astore 9
    //   963: aload 6
    //   965: astore 10
    //   967: sipush 1024
    //   970: newarray byte
    //   972: astore 11
    //   974: iconst_0
    //   975: istore_3
    //   976: aload_1
    //   977: astore 12
    //   979: aload_2
    //   980: astore 13
    //   982: aload 6
    //   984: astore 14
    //   986: aload 7
    //   988: astore 15
    //   990: aload_1
    //   991: astore 8
    //   993: aload_2
    //   994: astore 9
    //   996: aload 6
    //   998: astore 10
    //   1000: new 93	java/lang/StringBuilder
    //   1003: dup
    //   1004: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1007: aload 17
    //   1009: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: ldc_w 333
    //   1015: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: invokestatic 337	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   1024: astore_2
    //   1025: aload 6
    //   1027: ifnull +40 -> 1067
    //   1030: aload_1
    //   1031: astore 12
    //   1033: aload_2
    //   1034: astore 13
    //   1036: aload 6
    //   1038: astore 14
    //   1040: aload 7
    //   1042: astore 15
    //   1044: aload_1
    //   1045: astore 8
    //   1047: aload_2
    //   1048: astore 9
    //   1050: aload 6
    //   1052: astore 10
    //   1054: aload 6
    //   1056: aload 11
    //   1058: invokevirtual 341	java/io/InputStream:read	([B)I
    //   1061: istore_3
    //   1062: iload_3
    //   1063: iconst_m1
    //   1064: if_icmpeq +290 -> 1354
    //   1067: aload_1
    //   1068: astore 12
    //   1070: aload_2
    //   1071: astore 13
    //   1073: aload 6
    //   1075: astore 14
    //   1077: aload 7
    //   1079: astore 15
    //   1081: aload_1
    //   1082: astore 8
    //   1084: aload_2
    //   1085: astore 9
    //   1087: aload 6
    //   1089: astore 10
    //   1091: aload_2
    //   1092: aload 11
    //   1094: iconst_0
    //   1095: iload_3
    //   1096: invokevirtual 345	java/io/OutputStream:write	([BII)V
    //   1099: goto -74 -> 1025
    //   1102: astore 11
    //   1104: aload 15
    //   1106: astore 7
    //   1108: aload 14
    //   1110: astore 6
    //   1112: aload 13
    //   1114: astore_2
    //   1115: aload 12
    //   1117: astore_1
    //   1118: aload_1
    //   1119: astore 8
    //   1121: aload_2
    //   1122: astore 9
    //   1124: aload 6
    //   1126: astore 10
    //   1128: aload 18
    //   1130: iconst_0
    //   1131: putfield 226	kotlin/g/b/aa$d:aaBA	I
    //   1134: aload_1
    //   1135: astore 8
    //   1137: aload_2
    //   1138: astore 9
    //   1140: aload 6
    //   1142: astore 10
    //   1144: getstatic 181	kotlin/g/b/af:aaBG	Lkotlin/g/b/af;
    //   1147: astore 12
    //   1149: aload_1
    //   1150: astore 8
    //   1152: aload_2
    //   1153: astore 9
    //   1155: aload 6
    //   1157: astore 10
    //   1159: invokestatic 187	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1162: getstatic 192	com/tencent/mm/plugin/ay/a$a:appbrand_game_image_stream_error_http_inner	I
    //   1165: invokevirtual 198	android/content/Context:getString	(I)Ljava/lang/String;
    //   1168: astore 12
    //   1170: aload_1
    //   1171: astore 8
    //   1173: aload_2
    //   1174: astore 9
    //   1176: aload 6
    //   1178: astore 10
    //   1180: aload 12
    //   1182: ldc 200
    //   1184: invokestatic 203	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1187: aload_1
    //   1188: astore 8
    //   1190: aload_2
    //   1191: astore 9
    //   1193: aload 6
    //   1195: astore 10
    //   1197: aload 12
    //   1199: iconst_1
    //   1200: anewarray 4	java/lang/Object
    //   1203: dup
    //   1204: iconst_0
    //   1205: aload 11
    //   1207: invokevirtual 204	java/lang/Exception:toString	()Ljava/lang/String;
    //   1210: aastore
    //   1211: iconst_1
    //   1212: invokestatic 210	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   1215: invokestatic 214	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1218: astore 12
    //   1220: aload_1
    //   1221: astore 8
    //   1223: aload_2
    //   1224: astore 9
    //   1226: aload 6
    //   1228: astore 10
    //   1230: aload 12
    //   1232: ldc 216
    //   1234: invokestatic 203	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1237: aload_1
    //   1238: astore 8
    //   1240: aload_2
    //   1241: astore 9
    //   1243: aload 6
    //   1245: astore 10
    //   1247: aload 16
    //   1249: aload 12
    //   1251: putfield 220	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   1254: aload_1
    //   1255: astore 8
    //   1257: aload_2
    //   1258: astore 9
    //   1260: aload 6
    //   1262: astore 10
    //   1264: ldc 127
    //   1266: aload 11
    //   1268: checkcast 170	java/lang/Throwable
    //   1271: ldc 171
    //   1273: iconst_0
    //   1274: anewarray 4	java/lang/Object
    //   1277: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1280: aload_2
    //   1281: ifnull +7 -> 1288
    //   1284: aload_2
    //   1285: invokevirtual 268	java/io/OutputStream:close	()V
    //   1288: aload 6
    //   1290: ifnull +8 -> 1298
    //   1293: aload 6
    //   1295: invokevirtual 269	java/io/InputStream:close	()V
    //   1298: aload_1
    //   1299: ifnull +229 -> 1528
    //   1302: aload_1
    //   1303: invokeinterface 331 1 0
    //   1308: iconst_1
    //   1309: istore_3
    //   1310: goto -1027 -> 283
    //   1313: aload_1
    //   1314: astore 12
    //   1316: aload_2
    //   1317: astore 13
    //   1319: aload 6
    //   1321: astore 14
    //   1323: aload 7
    //   1325: astore 15
    //   1327: aload_1
    //   1328: astore 8
    //   1330: aload_2
    //   1331: astore 9
    //   1333: aload 6
    //   1335: astore 10
    //   1337: aload_1
    //   1338: invokeinterface 349 1 0
    //   1343: astore 6
    //   1345: aload 18
    //   1347: iconst_0
    //   1348: putfield 226	kotlin/g/b/aa$d:aaBA	I
    //   1351: goto -411 -> 940
    //   1354: aload_1
    //   1355: astore 12
    //   1357: aload_2
    //   1358: astore 13
    //   1360: aload 6
    //   1362: astore 14
    //   1364: aload 7
    //   1366: astore 15
    //   1368: aload_1
    //   1369: astore 8
    //   1371: aload_2
    //   1372: astore 9
    //   1374: aload 6
    //   1376: astore 10
    //   1378: new 351	com/tencent/mm/vfs/q
    //   1381: dup
    //   1382: new 93	java/lang/StringBuilder
    //   1385: dup
    //   1386: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   1389: aload 17
    //   1391: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: ldc_w 333
    //   1397: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokespecial 352	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   1406: new 351	com/tencent/mm/vfs/q
    //   1409: dup
    //   1410: aload 17
    //   1412: invokespecial 352	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   1415: invokevirtual 356	com/tencent/mm/vfs/q:aj	(Lcom/tencent/mm/vfs/q;)Z
    //   1418: pop
    //   1419: aload_1
    //   1420: astore 12
    //   1422: aload_2
    //   1423: astore 13
    //   1425: aload 6
    //   1427: astore 14
    //   1429: aload 7
    //   1431: astore 15
    //   1433: aload_1
    //   1434: astore 8
    //   1436: aload_2
    //   1437: astore 9
    //   1439: aload 6
    //   1441: astore 10
    //   1443: aload 16
    //   1445: new 155	java/io/BufferedInputStream
    //   1448: dup
    //   1449: aload 17
    //   1451: invokestatic 159	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1454: invokespecial 162	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1457: checkcast 164	java/io/InputStream
    //   1460: putfield 168	com/github/henryye/nativeiv/b/b$a:aFw	Ljava/io/InputStream;
    //   1463: aload_1
    //   1464: astore 12
    //   1466: aload_2
    //   1467: astore 13
    //   1469: aload 6
    //   1471: astore 14
    //   1473: aload 7
    //   1475: astore 15
    //   1477: aload_1
    //   1478: astore 8
    //   1480: aload_2
    //   1481: astore 9
    //   1483: aload 6
    //   1485: astore 10
    //   1487: ldc 127
    //   1489: ldc_w 358
    //   1492: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1495: aload_2
    //   1496: ifnull +7 -> 1503
    //   1499: aload_2
    //   1500: invokevirtual 268	java/io/OutputStream:close	()V
    //   1503: aload 6
    //   1505: invokevirtual 269	java/io/InputStream:close	()V
    //   1508: aload_1
    //   1509: invokeinterface 331 1 0
    //   1514: iload 4
    //   1516: istore_3
    //   1517: goto -1234 -> 283
    //   1520: astore 8
    //   1522: iload 4
    //   1524: istore_3
    //   1525: goto -1242 -> 283
    //   1528: iconst_1
    //   1529: istore_3
    //   1530: goto -1247 -> 283
    //   1533: astore 8
    //   1535: iconst_1
    //   1536: istore_3
    //   1537: goto -1254 -> 283
    //   1540: astore 7
    //   1542: aload 10
    //   1544: astore 6
    //   1546: aload 9
    //   1548: astore_2
    //   1549: aload 8
    //   1551: astore_1
    //   1552: aload_2
    //   1553: ifnull +7 -> 1560
    //   1556: aload_2
    //   1557: invokevirtual 268	java/io/OutputStream:close	()V
    //   1560: aload 6
    //   1562: ifnull +8 -> 1570
    //   1565: aload 6
    //   1567: invokevirtual 269	java/io/InputStream:close	()V
    //   1570: aload_1
    //   1571: ifnull +9 -> 1580
    //   1574: aload_1
    //   1575: invokeinterface 331 1 0
    //   1580: ldc 87
    //   1582: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1585: aload 7
    //   1587: athrow
    //   1588: ldc 87
    //   1590: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1593: aload 16
    //   1595: areturn
    //   1596: astore_1
    //   1597: goto -17 -> 1580
    //   1600: astore 7
    //   1602: goto -50 -> 1552
    //   1605: astore 7
    //   1607: goto -55 -> 1552
    //   1610: astore 11
    //   1612: goto -494 -> 1118
    //   1615: astore 8
    //   1617: aload 11
    //   1619: astore 7
    //   1621: aload 8
    //   1623: astore 11
    //   1625: goto -507 -> 1118
    //   1628: astore 11
    //   1630: goto -512 -> 1118
    //   1633: astore_1
    //   1634: goto -1248 -> 386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1637	0	this	b
    //   0	1637	1	paramObject	Object
    //   0	1637	2	paramImageDecodeConfig	com.github.henryye.nativeiv.ImageDecodeConfig
    //   282	1255	3	i	int
    //   941	582	4	j	int
    //   75	213	5	bool	boolean
    //   43	1523	6	localObject1	Object
    //   21	886	7	localObject2	Object
    //   911	1	7	localException1	java.lang.Exception
    //   915	559	7	localObject3	Object
    //   1540	46	7	localObject4	Object
    //   1600	1	7	localObject5	Object
    //   1605	1	7	localObject6	Object
    //   1619	1	7	localObject7	Object
    //   307	1172	8	localObject8	Object
    //   1520	1	8	localException2	java.lang.Exception
    //   1533	17	8	localException3	java.lang.Exception
    //   1615	7	8	localException4	java.lang.Exception
    //   310	1237	9	localImageDecodeConfig1	com.github.henryye.nativeiv.ImageDecodeConfig
    //   314	1229	10	localObject9	Object
    //   522	571	11	localObject10	Object
    //   1102	165	11	localException5	java.lang.Exception
    //   1610	8	11	localException6	java.lang.Exception
    //   1623	1	11	localException7	java.lang.Exception
    //   1628	1	11	localException8	java.lang.Exception
    //   293	1172	12	localObject11	Object
    //   296	1172	13	localImageDecodeConfig2	com.github.henryye.nativeiv.ImageDecodeConfig
    //   300	1172	14	localObject12	Object
    //   304	1172	15	localObject13	Object
    //   30	1564	16	locala	com.github.henryye.nativeiv.b.b.a
    //   68	1382	17	str	String
    //   236	1110	18	locald	kotlin.g.b.aa.d
    //   279	475	19	localb	b.b
    // Exception table:
    //   from	to	target	type
    //   123	150	158	java/lang/Exception
    //   884	888	911	java/lang/Exception
    //   893	898	911	java/lang/Exception
    //   898	904	911	java/lang/Exception
    //   316	325	1102	java/lang/Exception
    //   360	368	1102	java/lang/Exception
    //   418	427	1102	java/lang/Exception
    //   454	460	1102	java/lang/Exception
    //   484	492	1102	java/lang/Exception
    //   516	524	1102	java/lang/Exception
    //   548	565	1102	java/lang/Exception
    //   589	597	1102	java/lang/Exception
    //   621	628	1102	java/lang/Exception
    //   652	661	1102	java/lang/Exception
    //   685	695	1102	java/lang/Exception
    //   719	729	1102	java/lang/Exception
    //   753	767	1102	java/lang/Exception
    //   791	802	1102	java/lang/Exception
    //   826	834	1102	java/lang/Exception
    //   967	974	1102	java/lang/Exception
    //   1000	1025	1102	java/lang/Exception
    //   1054	1062	1102	java/lang/Exception
    //   1091	1099	1102	java/lang/Exception
    //   1337	1345	1102	java/lang/Exception
    //   1378	1419	1102	java/lang/Exception
    //   1443	1463	1102	java/lang/Exception
    //   1487	1495	1102	java/lang/Exception
    //   1499	1503	1520	java/lang/Exception
    //   1503	1514	1520	java/lang/Exception
    //   1284	1288	1533	java/lang/Exception
    //   1293	1298	1533	java/lang/Exception
    //   1302	1308	1533	java/lang/Exception
    //   316	325	1540	finally
    //   360	368	1540	finally
    //   418	427	1540	finally
    //   454	460	1540	finally
    //   484	492	1540	finally
    //   516	524	1540	finally
    //   548	565	1540	finally
    //   589	597	1540	finally
    //   621	628	1540	finally
    //   652	661	1540	finally
    //   685	695	1540	finally
    //   719	729	1540	finally
    //   753	767	1540	finally
    //   791	802	1540	finally
    //   826	834	1540	finally
    //   844	856	1540	finally
    //   866	872	1540	finally
    //   930	936	1540	finally
    //   967	974	1540	finally
    //   1000	1025	1540	finally
    //   1054	1062	1540	finally
    //   1091	1099	1540	finally
    //   1128	1134	1540	finally
    //   1144	1149	1540	finally
    //   1159	1170	1540	finally
    //   1180	1187	1540	finally
    //   1197	1220	1540	finally
    //   1230	1237	1540	finally
    //   1247	1254	1540	finally
    //   1264	1280	1540	finally
    //   1337	1345	1540	finally
    //   1378	1419	1540	finally
    //   1443	1463	1540	finally
    //   1487	1495	1540	finally
    //   1556	1560	1596	java/lang/Exception
    //   1565	1570	1596	java/lang/Exception
    //   1574	1580	1596	java/lang/Exception
    //   325	332	1600	finally
    //   1345	1351	1605	finally
    //   325	332	1610	java/lang/Exception
    //   844	856	1615	java/lang/Exception
    //   866	872	1615	java/lang/Exception
    //   930	936	1615	java/lang/Exception
    //   1345	1351	1628	java/lang/Exception
    //   372	376	1633	java/lang/Exception
    //   381	386	1633	java/lang/Exception
  }
  
  public final String qG()
  {
    return "http";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b
 * JD-Core Version:    0.7.0.1
 */