package com.tencent.mm.plugin.surface.c;

import com.github.henryye.nativeiv.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/render/HttpImageStreamFetcher;", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "connectionTimeoutMs", "", "readTimeoutMs", "accept", "", "obj", "", "fetch", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher$StreamFetchResult;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "getSourceTypeName", "toFileName", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements b
{
  public static final g.a SLs;
  private int cEM = 30000;
  private int cEN = 30000;
  
  static
  {
    AppMethodBeat.i(265039);
    SLs = new g.a((byte)0);
    AppMethodBeat.o(265039);
  }
  
  public final String Qj()
  {
    return "http";
  }
  
  /* Error */
  public final com.github.henryye.nativeiv.b.b.a a(Object paramObject, com.github.henryye.nativeiv.ImageDecodeConfig paramImageDecodeConfig)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 75
    //   8: invokestatic 81	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 82
    //   14: invokestatic 81	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_1
    //   18: checkcast 84	java/lang/String
    //   21: astore_2
    //   22: new 86	com/github/henryye/nativeiv/b/b$a
    //   25: dup
    //   26: invokespecial 87	com/github/henryye/nativeiv/b/b$a:<init>	()V
    //   29: astore 18
    //   31: iconst_0
    //   32: istore_3
    //   33: new 89	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   40: astore 8
    //   42: invokestatic 96	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   45: getfield 102	com/tencent/mm/kernel/f:mCJ	Ljava/lang/String;
    //   48: ldc 104
    //   50: invokestatic 108	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   53: astore 9
    //   55: aload 9
    //   57: invokestatic 114	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   60: ifne +9 -> 69
    //   63: aload 9
    //   65: invokestatic 117	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   68: pop
    //   69: aload 8
    //   71: aload 9
    //   73: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 123
    //   78: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_2
    //   82: invokestatic 129	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore 19
    //   93: aload 19
    //   95: invokestatic 114	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   98: istore 7
    //   100: ldc 137
    //   102: new 89	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 139
    //   108: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload_1
    //   112: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: bipush 32
    //   117: invokevirtual 145	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   120: aload 19
    //   122: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 147
    //   127: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload 7
    //   132: invokevirtual 150	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   135: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 155	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: iload 7
    //   143: ifeq +109 -> 252
    //   146: ldc 137
    //   148: ldc 157
    //   150: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 18
    //   155: new 162	java/io/BufferedInputStream
    //   158: dup
    //   159: aload 19
    //   161: invokestatic 166	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   164: invokespecial 169	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   167: checkcast 171	java/io/InputStream
    //   170: putfield 175	com/github/henryye/nativeiv/b/b$a:inputStream	Ljava/io/InputStream;
    //   173: ldc 74
    //   175: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload 18
    //   180: areturn
    //   181: astore_1
    //   182: ldc 137
    //   184: aload_1
    //   185: checkcast 177	java/lang/Throwable
    //   188: ldc 178
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: getstatic 188	kotlin/g/b/am:aixg	Lkotlin/g/b/am;
    //   200: astore_2
    //   201: invokestatic 194	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   204: getstatic 199	com/tencent/luggage/wxa/a/a$f:appbrand_game_image_stream_error_http_inner	I
    //   207: invokevirtual 205	android/content/Context:getString	(I)Ljava/lang/String;
    //   210: astore_2
    //   211: aload_2
    //   212: ldc 207
    //   214: invokestatic 210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   217: aload_2
    //   218: iconst_1
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_1
    //   225: invokevirtual 211	java/lang/Exception:toString	()Ljava/lang/String;
    //   228: aastore
    //   229: iconst_1
    //   230: invokestatic 217	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   233: invokestatic 221	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   236: astore_1
    //   237: aload_1
    //   238: ldc 223
    //   240: invokestatic 210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   243: aload 18
    //   245: aload_1
    //   246: putfield 226	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   249: goto -76 -> 173
    //   252: new 228	kotlin/g/b/ah$d
    //   255: dup
    //   256: invokespecial 229	kotlin/g/b/ah$d:<init>	()V
    //   259: astore 20
    //   261: aconst_null
    //   262: astore 9
    //   264: aconst_null
    //   265: astore 8
    //   267: ldc 231
    //   269: invokestatic 235	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   272: checkcast 231	com/tencent/mm/plugin/expt/b/c
    //   275: getstatic 241	com/tencent/mm/plugin/expt/b/c$a:zmZ	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   278: iconst_0
    //   279: invokeinterface 244 3 0
    //   284: istore 7
    //   286: aconst_null
    //   287: astore_1
    //   288: iload_3
    //   289: ifne +1537 -> 1826
    //   292: iload 7
    //   294: ifeq +460 -> 754
    //   297: aload_1
    //   298: astore 12
    //   300: aload 8
    //   302: astore 16
    //   304: aload 9
    //   306: astore 13
    //   308: aload_2
    //   309: astore 17
    //   311: aload_1
    //   312: astore 10
    //   314: aload 8
    //   316: astore 15
    //   318: aload 9
    //   320: astore 11
    //   322: aload_2
    //   323: invokestatic 250	com/tencent/mm/network/d:Rt	(Ljava/lang/String;)Lcom/tencent/mm/network/aa;
    //   326: checkcast 252	com/tencent/mm/network/z
    //   329: astore_1
    //   330: aload_1
    //   331: ifnonnull +323 -> 654
    //   334: aload_1
    //   335: astore 12
    //   337: aload 8
    //   339: astore 16
    //   341: aload 9
    //   343: astore 13
    //   345: aload_2
    //   346: astore 17
    //   348: aload_1
    //   349: astore 10
    //   351: aload 8
    //   353: astore 15
    //   355: aload 9
    //   357: astore 11
    //   359: new 254	java/lang/NullPointerException
    //   362: dup
    //   363: ldc_w 256
    //   366: invokespecial 257	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   369: astore 14
    //   371: aload_1
    //   372: astore 12
    //   374: aload 8
    //   376: astore 16
    //   378: aload 9
    //   380: astore 13
    //   382: aload_2
    //   383: astore 17
    //   385: aload_1
    //   386: astore 10
    //   388: aload 8
    //   390: astore 15
    //   392: aload 9
    //   394: astore 11
    //   396: ldc 74
    //   398: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: aload_1
    //   402: astore 12
    //   404: aload 8
    //   406: astore 16
    //   408: aload 9
    //   410: astore 13
    //   412: aload_2
    //   413: astore 17
    //   415: aload_1
    //   416: astore 10
    //   418: aload 8
    //   420: astore 15
    //   422: aload 9
    //   424: astore 11
    //   426: aload 14
    //   428: athrow
    //   429: astore 10
    //   431: aload 17
    //   433: astore_2
    //   434: aload 13
    //   436: astore 9
    //   438: aload 16
    //   440: astore 8
    //   442: aload 12
    //   444: astore_1
    //   445: aload 10
    //   447: astore 12
    //   449: aload_1
    //   450: astore 10
    //   452: aload 8
    //   454: astore 15
    //   456: aload 9
    //   458: astore 11
    //   460: aload 20
    //   462: iconst_0
    //   463: putfield 260	kotlin/g/b/ah$d:aixb	I
    //   466: aload_1
    //   467: astore 10
    //   469: aload 8
    //   471: astore 15
    //   473: aload 9
    //   475: astore 11
    //   477: getstatic 188	kotlin/g/b/am:aixg	Lkotlin/g/b/am;
    //   480: astore 13
    //   482: aload_1
    //   483: astore 10
    //   485: aload 8
    //   487: astore 15
    //   489: aload 9
    //   491: astore 11
    //   493: invokestatic 194	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   496: getstatic 199	com/tencent/luggage/wxa/a/a$f:appbrand_game_image_stream_error_http_inner	I
    //   499: invokevirtual 205	android/content/Context:getString	(I)Ljava/lang/String;
    //   502: astore 13
    //   504: aload_1
    //   505: astore 10
    //   507: aload 8
    //   509: astore 15
    //   511: aload 9
    //   513: astore 11
    //   515: aload 13
    //   517: ldc 207
    //   519: invokestatic 210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   522: aload_1
    //   523: astore 10
    //   525: aload 8
    //   527: astore 15
    //   529: aload 9
    //   531: astore 11
    //   533: aload 13
    //   535: iconst_1
    //   536: anewarray 4	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: aload 12
    //   543: invokevirtual 211	java/lang/Exception:toString	()Ljava/lang/String;
    //   546: aastore
    //   547: iconst_1
    //   548: invokestatic 217	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   551: invokestatic 221	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   554: astore 13
    //   556: aload_1
    //   557: astore 10
    //   559: aload 8
    //   561: astore 15
    //   563: aload 9
    //   565: astore 11
    //   567: aload 13
    //   569: ldc 223
    //   571: invokestatic 210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   574: aload_1
    //   575: astore 10
    //   577: aload 8
    //   579: astore 15
    //   581: aload 9
    //   583: astore 11
    //   585: aload 18
    //   587: aload 13
    //   589: putfield 226	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   592: aload_1
    //   593: astore 10
    //   595: aload 8
    //   597: astore 15
    //   599: aload 9
    //   601: astore 11
    //   603: ldc 137
    //   605: aload 12
    //   607: checkcast 177	java/lang/Throwable
    //   610: ldc 178
    //   612: iconst_0
    //   613: anewarray 4	java/lang/Object
    //   616: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   619: aload 8
    //   621: ifnull +8 -> 629
    //   624: aload 8
    //   626: invokevirtual 265	java/io/OutputStream:close	()V
    //   629: aload 9
    //   631: ifnull +8 -> 639
    //   634: aload 9
    //   636: invokevirtual 266	java/io/InputStream:close	()V
    //   639: aload_1
    //   640: ifnull +1181 -> 1821
    //   643: aload_1
    //   644: invokeinterface 269 1 0
    //   649: iconst_1
    //   650: istore_3
    //   651: goto -363 -> 288
    //   654: aload_1
    //   655: astore 12
    //   657: aload 8
    //   659: astore 16
    //   661: aload 9
    //   663: astore 13
    //   665: aload_2
    //   666: astore 17
    //   668: aload_1
    //   669: astore 10
    //   671: aload 8
    //   673: astore 15
    //   675: aload 9
    //   677: astore 11
    //   679: aload_1
    //   680: checkcast 271	com/tencent/mm/network/aa
    //   683: sipush 1500
    //   686: putfield 274	com/tencent/mm/network/aa:pps	I
    //   689: aload_1
    //   690: ifnonnull +101 -> 791
    //   693: aload_1
    //   694: astore 12
    //   696: aload 8
    //   698: astore 16
    //   700: aload 9
    //   702: astore 13
    //   704: aload_2
    //   705: astore 17
    //   707: aload_1
    //   708: astore 10
    //   710: aload 8
    //   712: astore 15
    //   714: aload 9
    //   716: astore 11
    //   718: aload 18
    //   720: ldc_w 276
    //   723: putfield 226	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   726: aload 8
    //   728: ifnull +8 -> 736
    //   731: aload 8
    //   733: invokevirtual 265	java/io/OutputStream:close	()V
    //   736: aload 9
    //   738: ifnull +8 -> 746
    //   741: aload 9
    //   743: invokevirtual 266	java/io/InputStream:close	()V
    //   746: ldc 74
    //   748: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   751: aload 18
    //   753: areturn
    //   754: aload_1
    //   755: astore 12
    //   757: aload 8
    //   759: astore 16
    //   761: aload 9
    //   763: astore 13
    //   765: aload_2
    //   766: astore 17
    //   768: aload_1
    //   769: astore 10
    //   771: aload 8
    //   773: astore 15
    //   775: aload 9
    //   777: astore 11
    //   779: aload_2
    //   780: aconst_null
    //   781: invokestatic 279	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   784: checkcast 252	com/tencent/mm/network/z
    //   787: astore_1
    //   788: goto -99 -> 689
    //   791: aload_1
    //   792: astore 12
    //   794: aload 8
    //   796: astore 16
    //   798: aload 9
    //   800: astore 13
    //   802: aload_2
    //   803: astore 17
    //   805: aload_1
    //   806: astore 10
    //   808: aload 8
    //   810: astore 15
    //   812: aload 9
    //   814: astore 11
    //   816: invokestatic 285	com/tencent/mm/modelimage/u:bKj	()Z
    //   819: ifeq +143 -> 962
    //   822: aload_1
    //   823: astore 12
    //   825: aload 8
    //   827: astore 16
    //   829: aload 9
    //   831: astore 13
    //   833: aload_2
    //   834: astore 17
    //   836: aload_1
    //   837: astore 10
    //   839: aload 8
    //   841: astore 15
    //   843: aload 9
    //   845: astore 11
    //   847: aload_2
    //   848: invokestatic 288	com/tencent/mm/modelimage/u:hA	(Ljava/lang/String;)Z
    //   851: ifeq +111 -> 962
    //   854: aload_1
    //   855: astore 12
    //   857: aload 8
    //   859: astore 16
    //   861: aload 9
    //   863: astore 13
    //   865: aload_2
    //   866: astore 17
    //   868: aload_1
    //   869: astore 10
    //   871: aload 8
    //   873: astore 15
    //   875: aload 9
    //   877: astore 11
    //   879: getstatic 293	com/tencent/mm/protocal/d:Yxh	I
    //   882: invokestatic 296	com/tencent/mm/modelimage/u:wy	(I)Ljava/lang/String;
    //   885: astore 14
    //   887: aload_1
    //   888: astore 12
    //   890: aload 8
    //   892: astore 16
    //   894: aload 9
    //   896: astore 13
    //   898: aload_2
    //   899: astore 17
    //   901: aload_1
    //   902: astore 10
    //   904: aload 8
    //   906: astore 15
    //   908: aload 9
    //   910: astore 11
    //   912: ldc 137
    //   914: ldc_w 298
    //   917: iconst_1
    //   918: anewarray 4	java/lang/Object
    //   921: dup
    //   922: iconst_0
    //   923: aload 14
    //   925: aastore
    //   926: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   929: aload_1
    //   930: astore 12
    //   932: aload 8
    //   934: astore 16
    //   936: aload 9
    //   938: astore 13
    //   940: aload_2
    //   941: astore 17
    //   943: aload_1
    //   944: astore 10
    //   946: aload 8
    //   948: astore 15
    //   950: aload 9
    //   952: astore 11
    //   954: aload_1
    //   955: aload 14
    //   957: invokeinterface 304 2 0
    //   962: aload_1
    //   963: astore 12
    //   965: aload 8
    //   967: astore 16
    //   969: aload 9
    //   971: astore 13
    //   973: aload_2
    //   974: astore 17
    //   976: aload_1
    //   977: astore 10
    //   979: aload 8
    //   981: astore 15
    //   983: aload 9
    //   985: astore 11
    //   987: aload_1
    //   988: iconst_1
    //   989: invokeinterface 308 2 0
    //   994: aload_1
    //   995: astore 12
    //   997: aload 8
    //   999: astore 16
    //   1001: aload 9
    //   1003: astore 13
    //   1005: aload_2
    //   1006: astore 17
    //   1008: aload_1
    //   1009: astore 10
    //   1011: aload 8
    //   1013: astore 15
    //   1015: aload 9
    //   1017: astore 11
    //   1019: aload_1
    //   1020: ldc_w 310
    //   1023: invokeinterface 313 2 0
    //   1028: aload_1
    //   1029: astore 12
    //   1031: aload 8
    //   1033: astore 16
    //   1035: aload 9
    //   1037: astore 13
    //   1039: aload_2
    //   1040: astore 17
    //   1042: aload_1
    //   1043: astore 10
    //   1045: aload 8
    //   1047: astore 15
    //   1049: aload 9
    //   1051: astore 11
    //   1053: aload_1
    //   1054: aload_0
    //   1055: getfield 64	com/tencent/mm/plugin/surface/c/g:cEM	I
    //   1058: invokeinterface 316 2 0
    //   1063: aload_1
    //   1064: astore 12
    //   1066: aload 8
    //   1068: astore 16
    //   1070: aload 9
    //   1072: astore 13
    //   1074: aload_2
    //   1075: astore 17
    //   1077: aload_1
    //   1078: astore 10
    //   1080: aload 8
    //   1082: astore 15
    //   1084: aload 9
    //   1086: astore 11
    //   1088: aload_1
    //   1089: aload_0
    //   1090: getfield 66	com/tencent/mm/plugin/surface/c/g:cEN	I
    //   1093: invokeinterface 319 2 0
    //   1098: aload_1
    //   1099: astore 12
    //   1101: aload 8
    //   1103: astore 16
    //   1105: aload 9
    //   1107: astore 13
    //   1109: aload_2
    //   1110: astore 17
    //   1112: aload_1
    //   1113: astore 10
    //   1115: aload 8
    //   1117: astore 15
    //   1119: aload 9
    //   1121: astore 11
    //   1123: aload_1
    //   1124: invokeinterface 323 1 0
    //   1129: istore_3
    //   1130: aload_1
    //   1131: astore 12
    //   1133: aload 8
    //   1135: astore 16
    //   1137: aload 9
    //   1139: astore 13
    //   1141: aload_2
    //   1142: astore 17
    //   1144: aload_1
    //   1145: astore 10
    //   1147: aload 8
    //   1149: astore 15
    //   1151: aload 9
    //   1153: astore 11
    //   1155: aload 20
    //   1157: getfield 260	kotlin/g/b/ah$d:aixb	I
    //   1160: bipush 15
    //   1162: if_icmpge +173 -> 1335
    //   1165: iload_3
    //   1166: sipush 301
    //   1169: if_icmpeq +688 -> 1857
    //   1172: iload_3
    //   1173: sipush 302
    //   1176: if_icmpne +159 -> 1335
    //   1179: goto +678 -> 1857
    //   1182: iload_3
    //   1183: ifeq +398 -> 1581
    //   1186: aload_1
    //   1187: astore 12
    //   1189: aload 8
    //   1191: astore 16
    //   1193: aload 9
    //   1195: astore 13
    //   1197: aload_2
    //   1198: astore 17
    //   1200: aload_1
    //   1201: astore 10
    //   1203: aload 8
    //   1205: astore 15
    //   1207: aload 9
    //   1209: astore 11
    //   1211: aload_1
    //   1212: ldc_w 325
    //   1215: invokeinterface 328 2 0
    //   1220: astore 14
    //   1222: aload_1
    //   1223: astore 12
    //   1225: aload 8
    //   1227: astore 16
    //   1229: aload 9
    //   1231: astore 13
    //   1233: aload_2
    //   1234: astore 17
    //   1236: aload_1
    //   1237: astore 10
    //   1239: aload 8
    //   1241: astore 15
    //   1243: aload 9
    //   1245: astore 11
    //   1247: aload 14
    //   1249: ldc_w 330
    //   1252: invokestatic 210	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1255: aload_1
    //   1256: astore 10
    //   1258: aload 8
    //   1260: astore 15
    //   1262: aload 9
    //   1264: astore 11
    //   1266: aload 20
    //   1268: aload 20
    //   1270: getfield 260	kotlin/g/b/ah$d:aixb	I
    //   1273: iconst_1
    //   1274: iadd
    //   1275: putfield 260	kotlin/g/b/ah$d:aixb	I
    //   1278: aload_1
    //   1279: astore 10
    //   1281: aload 8
    //   1283: astore 15
    //   1285: aload 9
    //   1287: astore 11
    //   1289: aload 20
    //   1291: getfield 260	kotlin/g/b/ah$d:aixb	I
    //   1294: istore_3
    //   1295: iload_3
    //   1296: bipush 15
    //   1298: if_icmpge +51 -> 1349
    //   1301: aload 8
    //   1303: ifnull +8 -> 1311
    //   1306: aload 8
    //   1308: invokevirtual 265	java/io/OutputStream:close	()V
    //   1311: aload 9
    //   1313: ifnull +8 -> 1321
    //   1316: aload 9
    //   1318: invokevirtual 266	java/io/InputStream:close	()V
    //   1321: aload_1
    //   1322: invokeinterface 269 1 0
    //   1327: iconst_0
    //   1328: istore_3
    //   1329: aload 14
    //   1331: astore_2
    //   1332: goto -1044 -> 288
    //   1335: iconst_0
    //   1336: istore_3
    //   1337: goto -155 -> 1182
    //   1340: astore_2
    //   1341: iconst_0
    //   1342: istore_3
    //   1343: aload 14
    //   1345: astore_2
    //   1346: goto -1058 -> 288
    //   1349: aload_1
    //   1350: astore 10
    //   1352: aload 8
    //   1354: astore 15
    //   1356: aload 9
    //   1358: astore 11
    //   1360: aload 20
    //   1362: iconst_0
    //   1363: putfield 260	kotlin/g/b/ah$d:aixb	I
    //   1366: aload 14
    //   1368: astore_2
    //   1369: iconst_1
    //   1370: istore 6
    //   1372: aload_1
    //   1373: astore 12
    //   1375: aload 8
    //   1377: astore 16
    //   1379: aload 9
    //   1381: astore 13
    //   1383: aload_2
    //   1384: astore 17
    //   1386: aload_1
    //   1387: astore 10
    //   1389: aload 8
    //   1391: astore 15
    //   1393: aload 9
    //   1395: astore 11
    //   1397: sipush 1024
    //   1400: newarray byte
    //   1402: astore 14
    //   1404: iconst_0
    //   1405: istore_3
    //   1406: aload_1
    //   1407: astore 12
    //   1409: aload 8
    //   1411: astore 16
    //   1413: aload 9
    //   1415: astore 13
    //   1417: aload_2
    //   1418: astore 17
    //   1420: aload_1
    //   1421: astore 10
    //   1423: aload 8
    //   1425: astore 15
    //   1427: aload 9
    //   1429: astore 11
    //   1431: aload 19
    //   1433: ldc_w 332
    //   1436: invokestatic 108	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1439: iconst_0
    //   1440: invokestatic 336	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   1443: astore 8
    //   1445: aload 9
    //   1447: ifnull +415 -> 1862
    //   1450: aload_1
    //   1451: astore 12
    //   1453: aload 8
    //   1455: astore 16
    //   1457: aload 9
    //   1459: astore 13
    //   1461: aload_2
    //   1462: astore 17
    //   1464: aload_1
    //   1465: astore 10
    //   1467: aload 8
    //   1469: astore 15
    //   1471: aload 9
    //   1473: astore 11
    //   1475: aload 9
    //   1477: aload 14
    //   1479: invokevirtual 340	java/io/InputStream:read	([B)I
    //   1482: istore 4
    //   1484: iload 4
    //   1486: istore_3
    //   1487: iload 4
    //   1489: iconst_m1
    //   1490: if_icmpne +372 -> 1862
    //   1493: iconst_1
    //   1494: istore 5
    //   1496: iload 4
    //   1498: istore_3
    //   1499: iload 5
    //   1501: ifne +147 -> 1648
    //   1504: aload_1
    //   1505: astore 12
    //   1507: aload 8
    //   1509: astore 16
    //   1511: aload 9
    //   1513: astore 13
    //   1515: aload_2
    //   1516: astore 17
    //   1518: aload_1
    //   1519: astore 10
    //   1521: aload 8
    //   1523: astore 15
    //   1525: aload 9
    //   1527: astore 11
    //   1529: aload 8
    //   1531: aload 14
    //   1533: iconst_0
    //   1534: iload_3
    //   1535: invokevirtual 344	java/io/OutputStream:write	([BII)V
    //   1538: goto -93 -> 1445
    //   1541: astore_1
    //   1542: aload 15
    //   1544: ifnull +8 -> 1552
    //   1547: aload 15
    //   1549: invokevirtual 265	java/io/OutputStream:close	()V
    //   1552: aload 11
    //   1554: ifnull +8 -> 1562
    //   1557: aload 11
    //   1559: invokevirtual 266	java/io/InputStream:close	()V
    //   1562: aload 10
    //   1564: ifnull +10 -> 1574
    //   1567: aload 10
    //   1569: invokeinterface 269 1 0
    //   1574: ldc 74
    //   1576: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1579: aload_1
    //   1580: athrow
    //   1581: aload_1
    //   1582: astore 12
    //   1584: aload 8
    //   1586: astore 16
    //   1588: aload 9
    //   1590: astore 13
    //   1592: aload_2
    //   1593: astore 17
    //   1595: aload_1
    //   1596: astore 10
    //   1598: aload 8
    //   1600: astore 15
    //   1602: aload 9
    //   1604: astore 11
    //   1606: aload_1
    //   1607: invokeinterface 348 1 0
    //   1612: astore 9
    //   1614: aload_1
    //   1615: astore 12
    //   1617: aload 8
    //   1619: astore 16
    //   1621: aload 9
    //   1623: astore 13
    //   1625: aload_2
    //   1626: astore 17
    //   1628: aload_1
    //   1629: astore 10
    //   1631: aload 8
    //   1633: astore 15
    //   1635: aload 9
    //   1637: astore 11
    //   1639: aload 20
    //   1641: iconst_0
    //   1642: putfield 260	kotlin/g/b/ah$d:aixb	I
    //   1645: goto -276 -> 1369
    //   1648: aload_1
    //   1649: astore 12
    //   1651: aload 8
    //   1653: astore 16
    //   1655: aload 9
    //   1657: astore 13
    //   1659: aload_2
    //   1660: astore 17
    //   1662: aload_1
    //   1663: astore 10
    //   1665: aload 8
    //   1667: astore 15
    //   1669: aload 9
    //   1671: astore 11
    //   1673: new 350	com/tencent/mm/vfs/u
    //   1676: dup
    //   1677: aload 19
    //   1679: ldc_w 332
    //   1682: invokestatic 108	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1685: invokespecial 351	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   1688: new 350	com/tencent/mm/vfs/u
    //   1691: dup
    //   1692: aload 19
    //   1694: invokespecial 351	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   1697: invokevirtual 355	com/tencent/mm/vfs/u:am	(Lcom/tencent/mm/vfs/u;)Z
    //   1700: pop
    //   1701: aload_1
    //   1702: astore 12
    //   1704: aload 8
    //   1706: astore 16
    //   1708: aload 9
    //   1710: astore 13
    //   1712: aload_2
    //   1713: astore 17
    //   1715: aload_1
    //   1716: astore 10
    //   1718: aload 8
    //   1720: astore 15
    //   1722: aload 9
    //   1724: astore 11
    //   1726: aload 18
    //   1728: new 162	java/io/BufferedInputStream
    //   1731: dup
    //   1732: aload 19
    //   1734: invokestatic 166	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1737: invokespecial 169	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1740: checkcast 171	java/io/InputStream
    //   1743: putfield 175	com/github/henryye/nativeiv/b/b$a:inputStream	Ljava/io/InputStream;
    //   1746: aload_1
    //   1747: astore 12
    //   1749: aload 8
    //   1751: astore 16
    //   1753: aload 9
    //   1755: astore 13
    //   1757: aload_2
    //   1758: astore 17
    //   1760: aload_1
    //   1761: astore 10
    //   1763: aload 8
    //   1765: astore 15
    //   1767: aload 9
    //   1769: astore 11
    //   1771: ldc 137
    //   1773: ldc_w 357
    //   1776: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1779: aload 8
    //   1781: ifnull +8 -> 1789
    //   1784: aload 8
    //   1786: invokevirtual 265	java/io/OutputStream:close	()V
    //   1789: aload 9
    //   1791: ifnull +8 -> 1799
    //   1794: aload 9
    //   1796: invokevirtual 266	java/io/InputStream:close	()V
    //   1799: aload_1
    //   1800: invokeinterface 269 1 0
    //   1805: iload 6
    //   1807: istore_3
    //   1808: goto -1520 -> 288
    //   1811: astore 10
    //   1813: iload 6
    //   1815: istore_3
    //   1816: goto -1528 -> 288
    //   1819: astore 10
    //   1821: iconst_1
    //   1822: istore_3
    //   1823: goto -1535 -> 288
    //   1826: ldc_w 359
    //   1829: invokestatic 235	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1832: pop
    //   1833: ldc 74
    //   1835: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1838: aload 18
    //   1840: areturn
    //   1841: astore_2
    //   1842: goto -268 -> 1574
    //   1845: astore 12
    //   1847: aload 14
    //   1849: astore_2
    //   1850: goto -1401 -> 449
    //   1853: astore_1
    //   1854: goto -1108 -> 746
    //   1857: iconst_1
    //   1858: istore_3
    //   1859: goto -677 -> 1182
    //   1862: iconst_0
    //   1863: istore 5
    //   1865: goto -366 -> 1499
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1868	0	this	g
    //   0	1868	1	paramObject	Object
    //   0	1868	2	paramImageDecodeConfig	com.github.henryye.nativeiv.ImageDecodeConfig
    //   32	1827	3	i	int
    //   1482	15	4	j	int
    //   1494	370	5	k	int
    //   1370	444	6	m	int
    //   98	195	7	bool	boolean
    //   40	1745	8	localObject1	Object
    //   53	1742	9	localObject2	Object
    //   312	105	10	localObject3	Object
    //   429	17	10	localException1	java.lang.Exception
    //   450	1312	10	localObject4	Object
    //   1811	1	10	localException2	java.lang.Exception
    //   1819	1	10	localException3	java.lang.Exception
    //   320	1450	11	localObject5	Object
    //   298	1450	12	localObject6	Object
    //   1845	1	12	localException4	java.lang.Exception
    //   306	1450	13	localObject7	Object
    //   369	1479	14	localObject8	Object
    //   316	1450	15	localObject9	Object
    //   302	1450	16	localObject10	Object
    //   309	1450	17	localImageDecodeConfig	com.github.henryye.nativeiv.ImageDecodeConfig
    //   29	1810	18	locala	com.github.henryye.nativeiv.b.b.a
    //   91	1642	19	str	String
    //   259	1381	20	locald	kotlin.g.b.ah.d
    // Exception table:
    //   from	to	target	type
    //   146	173	181	java/lang/Exception
    //   322	330	429	java/lang/Exception
    //   359	371	429	java/lang/Exception
    //   396	401	429	java/lang/Exception
    //   426	429	429	java/lang/Exception
    //   679	689	429	java/lang/Exception
    //   718	726	429	java/lang/Exception
    //   779	788	429	java/lang/Exception
    //   816	822	429	java/lang/Exception
    //   847	854	429	java/lang/Exception
    //   879	887	429	java/lang/Exception
    //   912	929	429	java/lang/Exception
    //   954	962	429	java/lang/Exception
    //   987	994	429	java/lang/Exception
    //   1019	1028	429	java/lang/Exception
    //   1053	1063	429	java/lang/Exception
    //   1088	1098	429	java/lang/Exception
    //   1123	1130	429	java/lang/Exception
    //   1155	1165	429	java/lang/Exception
    //   1211	1222	429	java/lang/Exception
    //   1247	1255	429	java/lang/Exception
    //   1397	1404	429	java/lang/Exception
    //   1431	1445	429	java/lang/Exception
    //   1475	1484	429	java/lang/Exception
    //   1529	1538	429	java/lang/Exception
    //   1606	1614	429	java/lang/Exception
    //   1639	1645	429	java/lang/Exception
    //   1673	1701	429	java/lang/Exception
    //   1726	1746	429	java/lang/Exception
    //   1771	1779	429	java/lang/Exception
    //   1306	1311	1340	java/lang/Exception
    //   1316	1321	1340	java/lang/Exception
    //   1321	1327	1340	java/lang/Exception
    //   322	330	1541	finally
    //   359	371	1541	finally
    //   396	401	1541	finally
    //   426	429	1541	finally
    //   460	466	1541	finally
    //   477	482	1541	finally
    //   493	504	1541	finally
    //   515	522	1541	finally
    //   533	556	1541	finally
    //   567	574	1541	finally
    //   585	592	1541	finally
    //   603	619	1541	finally
    //   679	689	1541	finally
    //   718	726	1541	finally
    //   779	788	1541	finally
    //   816	822	1541	finally
    //   847	854	1541	finally
    //   879	887	1541	finally
    //   912	929	1541	finally
    //   954	962	1541	finally
    //   987	994	1541	finally
    //   1019	1028	1541	finally
    //   1053	1063	1541	finally
    //   1088	1098	1541	finally
    //   1123	1130	1541	finally
    //   1155	1165	1541	finally
    //   1211	1222	1541	finally
    //   1247	1255	1541	finally
    //   1266	1278	1541	finally
    //   1289	1295	1541	finally
    //   1360	1366	1541	finally
    //   1397	1404	1541	finally
    //   1431	1445	1541	finally
    //   1475	1484	1541	finally
    //   1529	1538	1541	finally
    //   1606	1614	1541	finally
    //   1639	1645	1541	finally
    //   1673	1701	1541	finally
    //   1726	1746	1541	finally
    //   1771	1779	1541	finally
    //   1784	1789	1811	java/lang/Exception
    //   1794	1799	1811	java/lang/Exception
    //   1799	1805	1811	java/lang/Exception
    //   624	629	1819	java/lang/Exception
    //   634	639	1819	java/lang/Exception
    //   643	649	1819	java/lang/Exception
    //   1547	1552	1841	java/lang/Exception
    //   1557	1562	1841	java/lang/Exception
    //   1567	1574	1841	java/lang/Exception
    //   1266	1278	1845	java/lang/Exception
    //   1289	1295	1845	java/lang/Exception
    //   1360	1366	1845	java/lang/Exception
    //   731	736	1853	java/lang/Exception
    //   741	746	1853	java/lang/Exception
  }
  
  public final boolean be(Object paramObject)
  {
    AppMethodBeat.i(265048);
    s.u(paramObject, "obj");
    if (((paramObject instanceof String)) && ((n.U((String)paramObject, "http://", false)) || (n.U((String)paramObject, "https://", false))))
    {
      AppMethodBeat.o(265048);
      return true;
    }
    AppMethodBeat.o(265048);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.c.g
 * JD-Core Version:    0.7.0.1
 */