package com.tencent.mm.pluginsdk.res.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.res.downloader.a.d;
import com.tencent.mm.pluginsdk.res.downloader.a.f;
import com.tencent.mm.pluginsdk.res.downloader.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Iterator;
import javax.net.ssl.SSLContext;

public final class j
{
  private static final Class[] XWE = { InterruptedException.class };
  private static final Class[] XWF = { UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, com.tencent.mm.pluginsdk.res.downloader.a.a.class, d.class, g.class };
  private static final Class[] XWG = { SocketException.class, SocketTimeoutException.class };
  private boolean XWD = false;
  
  /* Error */
  static l a(e parame)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokeinterface 65 1 0
    //   11: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   14: ifeq +48 -> 62
    //   17: ldc 73
    //   19: ldc 75
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: invokeinterface 78 1 0
    //   33: aastore
    //   34: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: ldc 53
    //   39: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: aload 4
    //   46: ifnull +16 -> 62
    //   49: aload 4
    //   51: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   54: invokevirtual 98	java/io/InputStream:close	()V
    //   57: aload 4
    //   59: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
    //   62: aload_0
    //   63: invokeinterface 105 1 0
    //   68: ifne +13 -> 81
    //   71: aload_0
    //   72: invokeinterface 65 1 0
    //   77: invokestatic 110	com/tencent/mm/pluginsdk/res/downloader/b/a:bqu	(Ljava/lang/String;)Z
    //   80: pop
    //   81: invokestatic 113	com/tencent/mm/pluginsdk/res/downloader/model/j:iJH	()V
    //   84: new 115	java/net/URL
    //   87: dup
    //   88: aload_0
    //   89: invokeinterface 118 1 0
    //   94: invokespecial 121	java/net/URL:<init>	(Ljava/lang/String;)V
    //   97: astore 4
    //   99: aload 4
    //   101: invokevirtual 125	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   104: checkcast 89	java/net/HttpURLConnection
    //   107: astore 6
    //   109: ldc 73
    //   111: ldc 127
    //   113: iconst_2
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_0
    //   120: invokeinterface 78 1 0
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload_0
    //   129: invokeinterface 118 1 0
    //   134: aastore
    //   135: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: invokestatic 113	com/tencent/mm/pluginsdk/res/downloader/model/j:iJH	()V
    //   141: aload_0
    //   142: aload 6
    //   144: invokestatic 132	com/tencent/mm/pluginsdk/res/downloader/model/j:a	(Lcom/tencent/mm/pluginsdk/res/downloader/model/e;Ljava/net/HttpURLConnection;)V
    //   147: invokestatic 113	com/tencent/mm/pluginsdk/res/downloader/model/j:iJH	()V
    //   150: aload_0
    //   151: invokeinterface 65 1 0
    //   156: invokestatic 136	com/tencent/mm/pluginsdk/res/downloader/b/a:jK	(Ljava/lang/String;)J
    //   159: lstore_1
    //   160: ldc 73
    //   162: ldc 138
    //   164: iconst_2
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_0
    //   171: invokeinterface 78 1 0
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: lload_1
    //   180: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   183: aastore
    //   184: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: lload_1
    //   188: lconst_0
    //   189: lcmp
    //   190: ifne +302 -> 492
    //   193: iconst_0
    //   194: istore_3
    //   195: ldc 73
    //   197: ldc 146
    //   199: iconst_2
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_0
    //   206: invokeinterface 78 1 0
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: iload_3
    //   215: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   218: aastore
    //   219: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: invokestatic 113	com/tencent/mm/pluginsdk/res/downloader/model/j:iJH	()V
    //   225: ldc 153
    //   227: aload 4
    //   229: invokevirtual 156	java/net/URL:getProtocol	()Ljava/lang/String;
    //   232: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   235: ifeq +76 -> 311
    //   238: aload 6
    //   240: checkcast 163	javax/net/ssl/HttpsURLConnection
    //   243: astore 7
    //   245: ldc 165
    //   247: invokestatic 169	com/tencent/mm/pluginsdk/res/downloader/model/j:bog	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   250: astore 5
    //   252: aload 5
    //   254: astore 4
    //   256: aload 5
    //   258: ifnonnull +24 -> 282
    //   261: ldc 171
    //   263: invokestatic 169	com/tencent/mm/pluginsdk/res/downloader/model/j:bog	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   266: astore 5
    //   268: aload 5
    //   270: astore 4
    //   272: aload 5
    //   274: ifnonnull +8 -> 282
    //   277: invokestatic 177	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   280: astore 4
    //   282: aload 4
    //   284: ifnull +243 -> 527
    //   287: aload 4
    //   289: aconst_null
    //   290: aconst_null
    //   291: new 179	java/security/SecureRandom
    //   294: dup
    //   295: invokespecial 180	java/security/SecureRandom:<init>	()V
    //   298: invokevirtual 184	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   301: aload 7
    //   303: aload 4
    //   305: invokevirtual 188	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   308: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   311: invokestatic 113	com/tencent/mm/pluginsdk/res/downloader/model/j:iJH	()V
    //   314: ldc 73
    //   316: ldc 194
    //   318: iconst_2
    //   319: anewarray 4	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: aload_0
    //   325: invokeinterface 78 1 0
    //   330: aastore
    //   331: dup
    //   332: iconst_1
    //   333: aload_0
    //   334: invokeinterface 197 1 0
    //   339: aastore
    //   340: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: ldc 202
    //   345: aload_0
    //   346: invokeinterface 197 1 0
    //   351: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   354: ifeq +76 -> 430
    //   357: aload_0
    //   358: invokeinterface 210 1 0
    //   363: astore 7
    //   365: aload 7
    //   367: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   370: ifne +60 -> 430
    //   373: aload 6
    //   375: iconst_1
    //   376: invokevirtual 217	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   379: aload 6
    //   381: ldc 219
    //   383: aload_0
    //   384: invokeinterface 222 1 0
    //   389: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload 6
    //   394: aload 7
    //   396: arraylength
    //   397: invokevirtual 229	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   400: new 231	java/io/DataOutputStream
    //   403: dup
    //   404: aload 6
    //   406: invokevirtual 235	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   409: invokespecial 238	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   412: astore 5
    //   414: aload 5
    //   416: astore 4
    //   418: aload 5
    //   420: aload 7
    //   422: invokevirtual 242	java/io/DataOutputStream:write	([B)V
    //   425: aload 5
    //   427: invokevirtual 243	java/io/DataOutputStream:close	()V
    //   430: invokestatic 113	com/tencent/mm/pluginsdk/res/downloader/model/j:iJH	()V
    //   433: aload_0
    //   434: aload 6
    //   436: iload_3
    //   437: invokestatic 246	com/tencent/mm/pluginsdk/res/downloader/model/j:a	(Lcom/tencent/mm/pluginsdk/res/downloader/model/e;Ljava/net/HttpURLConnection;Z)Lcom/tencent/mm/pluginsdk/res/downloader/model/l;
    //   440: astore 5
    //   442: aload 5
    //   444: astore 4
    //   446: aload 5
    //   448: ifnonnull +18 -> 466
    //   451: aload_0
    //   452: new 52	java/lang/Exception
    //   455: dup
    //   456: ldc 248
    //   458: invokespecial 249	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   461: invokestatic 252	com/tencent/mm/pluginsdk/res/downloader/model/j:a	(Lcom/tencent/mm/pluginsdk/res/downloader/model/e;Ljava/lang/Exception;)Lcom/tencent/mm/pluginsdk/res/downloader/model/l;
    //   464: astore 4
    //   466: aload 6
    //   468: ifnull +16 -> 484
    //   471: aload 6
    //   473: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   476: invokevirtual 98	java/io/InputStream:close	()V
    //   479: aload 6
    //   481: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
    //   484: ldc 53
    //   486: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   489: aload 4
    //   491: areturn
    //   492: aload 6
    //   494: ldc 254
    //   496: new 256	java/lang/StringBuilder
    //   499: dup
    //   500: ldc_w 258
    //   503: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   506: lload_1
    //   507: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: ldc_w 265
    //   513: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokevirtual 274	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: iconst_1
    //   523: istore_3
    //   524: goto -329 -> 195
    //   527: aload 7
    //   529: aload_0
    //   530: invokeinterface 278 1 0
    //   535: new 280	android/net/SSLSessionCache
    //   538: dup
    //   539: invokestatic 286	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   542: invokespecial 289	android/net/SSLSessionCache:<init>	(Landroid/content/Context;)V
    //   545: invokestatic 294	android/net/SSLCertificateSocketFactory:getDefault	(ILandroid/net/SSLSessionCache;)Ljavax/net/ssl/SSLSocketFactory;
    //   548: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   551: goto -240 -> 311
    //   554: astore 5
    //   556: aload 6
    //   558: astore 4
    //   560: aload_0
    //   561: aload 5
    //   563: invokestatic 297	com/tencent/mm/pluginsdk/res/downloader/model/j:b	(Lcom/tencent/mm/pluginsdk/res/downloader/model/e;Ljava/lang/Exception;)Lcom/tencent/mm/pluginsdk/res/downloader/model/l;
    //   566: astore 6
    //   568: aload 6
    //   570: ifnonnull +325 -> 895
    //   573: ldc 73
    //   575: ldc_w 299
    //   578: iconst_1
    //   579: anewarray 4	java/lang/Object
    //   582: dup
    //   583: iconst_0
    //   584: aload_0
    //   585: invokeinterface 78 1 0
    //   590: aastore
    //   591: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   594: aload_0
    //   595: invokeinterface 302 1 0
    //   600: ifne -556 -> 44
    //   603: ldc 73
    //   605: ldc_w 304
    //   608: iconst_1
    //   609: anewarray 4	java/lang/Object
    //   612: dup
    //   613: iconst_0
    //   614: aload_0
    //   615: invokeinterface 78 1 0
    //   620: aastore
    //   621: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   624: aload_0
    //   625: aload 5
    //   627: invokestatic 252	com/tencent/mm/pluginsdk/res/downloader/model/j:a	(Lcom/tencent/mm/pluginsdk/res/downloader/model/e;Ljava/lang/Exception;)Lcom/tencent/mm/pluginsdk/res/downloader/model/l;
    //   630: astore_0
    //   631: aload 4
    //   633: ifnull +16 -> 649
    //   636: aload 4
    //   638: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   641: invokevirtual 98	java/io/InputStream:close	()V
    //   644: aload 4
    //   646: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
    //   649: ldc 53
    //   651: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   654: aload_0
    //   655: areturn
    //   656: astore 4
    //   658: ldc 73
    //   660: ldc_w 306
    //   663: iconst_1
    //   664: anewarray 4	java/lang/Object
    //   667: dup
    //   668: iconst_0
    //   669: aload_0
    //   670: invokeinterface 78 1 0
    //   675: aastore
    //   676: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: ldc 73
    //   681: aload 4
    //   683: ldc_w 308
    //   686: iconst_0
    //   687: anewarray 4	java/lang/Object
    //   690: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   693: goto -263 -> 430
    //   696: astore_0
    //   697: aload 6
    //   699: astore 4
    //   701: aload 4
    //   703: ifnull +16 -> 719
    //   706: aload 4
    //   708: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   711: invokevirtual 98	java/io/InputStream:close	()V
    //   714: aload 4
    //   716: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
    //   719: ldc 53
    //   721: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   724: aload_0
    //   725: athrow
    //   726: astore 7
    //   728: aconst_null
    //   729: astore 5
    //   731: aload 5
    //   733: astore 4
    //   735: ldc 73
    //   737: ldc_w 314
    //   740: iconst_1
    //   741: anewarray 4	java/lang/Object
    //   744: dup
    //   745: iconst_0
    //   746: aload_0
    //   747: invokeinterface 78 1 0
    //   752: aastore
    //   753: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: aload 5
    //   758: astore 4
    //   760: ldc 73
    //   762: aload 7
    //   764: ldc_w 308
    //   767: iconst_0
    //   768: anewarray 4	java/lang/Object
    //   771: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   774: aload 5
    //   776: astore 4
    //   778: ldc 53
    //   780: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   783: aload 5
    //   785: astore 4
    //   787: aload 7
    //   789: athrow
    //   790: astore 7
    //   792: aload 4
    //   794: astore 5
    //   796: aload 7
    //   798: astore 4
    //   800: aload 5
    //   802: ifnull +8 -> 810
    //   805: aload 5
    //   807: invokevirtual 243	java/io/DataOutputStream:close	()V
    //   810: ldc 53
    //   812: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   815: aload 4
    //   817: athrow
    //   818: astore 5
    //   820: ldc 73
    //   822: ldc_w 306
    //   825: iconst_1
    //   826: anewarray 4	java/lang/Object
    //   829: dup
    //   830: iconst_0
    //   831: aload_0
    //   832: invokeinterface 78 1 0
    //   837: aastore
    //   838: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   841: ldc 73
    //   843: aload 5
    //   845: ldc_w 308
    //   848: iconst_0
    //   849: anewarray 4	java/lang/Object
    //   852: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   855: goto -45 -> 810
    //   858: astore_0
    //   859: ldc 73
    //   861: aload_0
    //   862: invokevirtual 317	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   865: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   868: goto -389 -> 479
    //   871: astore_0
    //   872: goto -388 -> 484
    //   875: astore 5
    //   877: ldc 73
    //   879: aload 5
    //   881: invokevirtual 317	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   884: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   887: goto -243 -> 644
    //   890: astore 4
    //   892: goto -243 -> 649
    //   895: aload 4
    //   897: ifnull +16 -> 913
    //   900: aload 4
    //   902: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   905: invokevirtual 98	java/io/InputStream:close	()V
    //   908: aload 4
    //   910: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
    //   913: ldc 53
    //   915: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   918: aload 6
    //   920: areturn
    //   921: astore_0
    //   922: ldc 73
    //   924: aload_0
    //   925: invokevirtual 317	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   928: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   931: goto -23 -> 908
    //   934: astore_0
    //   935: goto -22 -> 913
    //   938: astore 5
    //   940: ldc 73
    //   942: aload 5
    //   944: invokevirtual 317	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   947: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: goto -893 -> 57
    //   953: astore 4
    //   955: goto -893 -> 62
    //   958: astore 5
    //   960: ldc 73
    //   962: aload 5
    //   964: invokevirtual 317	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   967: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   970: goto -256 -> 714
    //   973: astore 4
    //   975: goto -256 -> 719
    //   978: astore 4
    //   980: aload 5
    //   982: astore 4
    //   984: goto -702 -> 282
    //   987: astore_0
    //   988: aconst_null
    //   989: astore 4
    //   991: goto -290 -> 701
    //   994: astore_0
    //   995: goto -294 -> 701
    //   998: astore 5
    //   1000: aconst_null
    //   1001: astore 4
    //   1003: goto -443 -> 560
    //   1006: astore 4
    //   1008: aconst_null
    //   1009: astore 5
    //   1011: goto -211 -> 800
    //   1014: astore 7
    //   1016: goto -285 -> 731
    //   1019: astore 4
    //   1021: goto -494 -> 527
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1024	0	parame	e
    //   159	348	1	l	long
    //   194	330	3	bool	boolean
    //   44	601	4	localObject1	Object
    //   656	26	4	localIOException1	IOException
    //   699	117	4	localObject2	Object
    //   890	19	4	localException1	Exception
    //   953	1	4	localException2	Exception
    //   973	1	4	localException3	Exception
    //   978	1	4	localException4	Exception
    //   982	20	4	localObject3	Object
    //   1006	1	4	localObject4	Object
    //   1019	1	4	localException5	Exception
    //   250	197	5	localObject5	Object
    //   554	72	5	localException6	Exception
    //   729	77	5	localObject6	Object
    //   818	26	5	localIOException2	IOException
    //   875	5	5	localException7	Exception
    //   938	5	5	localException8	Exception
    //   958	23	5	localException9	Exception
    //   998	1	5	localException10	Exception
    //   1009	1	5	localObject7	Object
    //   107	812	6	localObject8	Object
    //   243	285	7	localObject9	Object
    //   726	62	7	localIOException3	IOException
    //   790	7	7	localObject10	Object
    //   1014	1	7	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   109	187	554	java/lang/Exception
    //   195	252	554	java/lang/Exception
    //   261	268	554	java/lang/Exception
    //   311	400	554	java/lang/Exception
    //   425	430	554	java/lang/Exception
    //   430	442	554	java/lang/Exception
    //   451	466	554	java/lang/Exception
    //   492	522	554	java/lang/Exception
    //   527	551	554	java/lang/Exception
    //   658	693	554	java/lang/Exception
    //   805	810	554	java/lang/Exception
    //   810	818	554	java/lang/Exception
    //   820	855	554	java/lang/Exception
    //   425	430	656	java/io/IOException
    //   109	187	696	finally
    //   195	252	696	finally
    //   261	268	696	finally
    //   277	282	696	finally
    //   287	311	696	finally
    //   311	400	696	finally
    //   425	430	696	finally
    //   430	442	696	finally
    //   451	466	696	finally
    //   492	522	696	finally
    //   527	551	696	finally
    //   658	693	696	finally
    //   805	810	696	finally
    //   810	818	696	finally
    //   820	855	696	finally
    //   400	414	726	java/io/IOException
    //   418	425	790	finally
    //   735	756	790	finally
    //   760	774	790	finally
    //   778	783	790	finally
    //   787	790	790	finally
    //   805	810	818	java/io/IOException
    //   471	479	858	java/lang/Exception
    //   479	484	871	java/lang/Exception
    //   859	868	871	java/lang/Exception
    //   636	644	875	java/lang/Exception
    //   644	649	890	java/lang/Exception
    //   877	887	890	java/lang/Exception
    //   900	908	921	java/lang/Exception
    //   908	913	934	java/lang/Exception
    //   922	931	934	java/lang/Exception
    //   49	57	938	java/lang/Exception
    //   57	62	953	java/lang/Exception
    //   940	950	953	java/lang/Exception
    //   706	714	958	java/lang/Exception
    //   714	719	973	java/lang/Exception
    //   960	970	973	java/lang/Exception
    //   277	282	978	java/lang/Exception
    //   62	81	987	finally
    //   81	109	987	finally
    //   560	568	994	finally
    //   573	631	994	finally
    //   62	81	998	java/lang/Exception
    //   81	109	998	java/lang/Exception
    //   400	414	1006	finally
    //   418	425	1014	java/io/IOException
    //   287	311	1019	java/lang/Exception
  }
  
  private static l a(e parame, Exception paramException)
  {
    AppMethodBeat.i(152028);
    int i = -1;
    Object localObject = paramException;
    if ((paramException instanceof f))
    {
      i = ((f)paramException).httpStatusCode;
      localObject = ((f)paramException).XWq;
    }
    Log.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", new Object[] { parame.iJd(), localObject });
    parame = new l(parame, (Exception)localObject, i, 3);
    AppMethodBeat.o(152028);
    return parame;
  }
  
  /* Error */
  private static l a(e parame, HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 340
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 73
    //   8: ldc_w 342
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokeinterface 78 1 0
    //   23: aastore
    //   24: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aconst_null
    //   28: astore 34
    //   30: aconst_null
    //   31: astore 22
    //   33: aconst_null
    //   34: astore 30
    //   36: aconst_null
    //   37: astore 31
    //   39: aconst_null
    //   40: astore 32
    //   42: aconst_null
    //   43: astore 33
    //   45: aconst_null
    //   46: astore 28
    //   48: aconst_null
    //   49: astore 29
    //   51: iconst_m1
    //   52: istore_3
    //   53: aload_1
    //   54: invokevirtual 345	java/net/HttpURLConnection:getResponseCode	()I
    //   57: istore 11
    //   59: aload_1
    //   60: invokevirtual 348	java/net/HttpURLConnection:getContentLength	()I
    //   63: istore 12
    //   65: aload_1
    //   66: invokevirtual 351	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   69: astore 36
    //   71: aload_1
    //   72: invokevirtual 354	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   75: astore 35
    //   77: ldc_w 356
    //   80: aload_1
    //   81: ldc_w 358
    //   84: invokevirtual 362	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   87: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifeq +154 -> 244
    //   93: iconst_1
    //   94: istore 14
    //   96: ldc 73
    //   98: ldc_w 364
    //   101: bipush 7
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: invokeinterface 78 1 0
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: iload 11
    //   119: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: aastore
    //   123: dup
    //   124: iconst_2
    //   125: iload 12
    //   127: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: dup
    //   132: iconst_3
    //   133: aload 36
    //   135: aastore
    //   136: dup
    //   137: iconst_4
    //   138: aload 35
    //   140: aastore
    //   141: dup
    //   142: iconst_5
    //   143: iload 14
    //   145: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   148: aastore
    //   149: dup
    //   150: bipush 6
    //   152: aload_1
    //   153: invokevirtual 373	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   156: invokestatic 379	com/tencent/mm/pluginsdk/res/downloader/b/b:cw	(Ljava/util/Map;)Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_0
    //   164: invokeinterface 65 1 0
    //   169: invokestatic 136	com/tencent/mm/pluginsdk/res/downloader/b/a:jK	(Ljava/lang/String;)J
    //   172: lstore 16
    //   174: iload 12
    //   176: ifne +1750 -> 1926
    //   179: sipush 206
    //   182: iload 11
    //   184: if_icmpne +1742 -> 1926
    //   187: lload 16
    //   189: lconst_0
    //   190: lcmp
    //   191: ifle +1735 -> 1926
    //   194: ldc 73
    //   196: ldc_w 381
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_0
    //   206: invokeinterface 78 1 0
    //   211: aastore
    //   212: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: new 334	com/tencent/mm/pluginsdk/res/downloader/model/l
    //   218: dup
    //   219: aload_0
    //   220: lload 16
    //   222: aload 35
    //   224: invokespecial 384	com/tencent/mm/pluginsdk/res/downloader/model/l:<init>	(Lcom/tencent/mm/pluginsdk/res/downloader/model/e;JLjava/lang/String;)V
    //   227: astore_1
    //   228: aconst_null
    //   229: invokestatic 388	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   232: aconst_null
    //   233: invokestatic 388	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   236: ldc_w 340
    //   239: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload_1
    //   243: areturn
    //   244: aload_1
    //   245: ldc_w 390
    //   248: invokevirtual 362	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   251: astore 20
    //   253: aload 20
    //   255: ifnull +1665 -> 1920
    //   258: aload 20
    //   260: ldc_w 356
    //   263: invokevirtual 393	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   266: ifeq +1654 -> 1920
    //   269: iconst_1
    //   270: istore 14
    //   272: goto -176 -> 96
    //   275: aload_0
    //   276: invokeinterface 396 1 0
    //   281: ifne +119 -> 400
    //   284: ldc 73
    //   286: ldc_w 398
    //   289: iconst_1
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: aload_0
    //   296: invokeinterface 78 1 0
    //   301: aastore
    //   302: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: new 32	com/tencent/mm/pluginsdk/res/downloader/a/d
    //   308: dup
    //   309: invokespecial 399	com/tencent/mm/pluginsdk/res/downloader/a/d:<init>	()V
    //   312: astore_1
    //   313: ldc_w 340
    //   316: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: aload_1
    //   320: athrow
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_1
    //   324: aload 29
    //   326: astore 21
    //   328: iload_3
    //   329: istore 4
    //   331: aload 21
    //   333: astore 22
    //   335: aload_1
    //   336: astore 20
    //   338: ldc_w 340
    //   341: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: iload_3
    //   345: istore 4
    //   347: aload 21
    //   349: astore 22
    //   351: aload_1
    //   352: astore 20
    //   354: aload_0
    //   355: athrow
    //   356: astore_0
    //   357: aload 20
    //   359: astore_1
    //   360: iload 4
    //   362: istore_3
    //   363: aload_1
    //   364: invokestatic 388	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   367: aload 22
    //   369: invokestatic 388	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   372: iload_3
    //   373: ifle +19 -> 392
    //   376: getstatic 405	com/tencent/mm/model/az$a:okQ	Lcom/tencent/mm/model/az$e;
    //   379: ifnull +13 -> 392
    //   382: getstatic 405	com/tencent/mm/model/az$a:okQ	Lcom/tencent/mm/model/az$e;
    //   385: iload_3
    //   386: iconst_0
    //   387: invokeinterface 411 3 0
    //   392: ldc_w 340
    //   395: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   398: aload_0
    //   399: athrow
    //   400: iload 12
    //   402: ifne +54 -> 456
    //   405: new 34	com/tencent/mm/pluginsdk/res/downloader/a/g
    //   408: dup
    //   409: invokespecial 412	com/tencent/mm/pluginsdk/res/downloader/a/g:<init>	()V
    //   412: astore_1
    //   413: ldc_w 340
    //   416: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: aload_1
    //   420: athrow
    //   421: astore_0
    //   422: aconst_null
    //   423: astore_1
    //   424: aload 30
    //   426: astore 21
    //   428: iload_3
    //   429: istore 4
    //   431: aload 21
    //   433: astore 22
    //   435: aload_1
    //   436: astore 20
    //   438: ldc_w 340
    //   441: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   444: iload_3
    //   445: istore 4
    //   447: aload 21
    //   449: astore 22
    //   451: aload_1
    //   452: astore 20
    //   454: aload_0
    //   455: athrow
    //   456: aload_0
    //   457: invokeinterface 415 1 0
    //   462: ifne +116 -> 578
    //   465: iload 12
    //   467: ifge +111 -> 578
    //   470: new 38	java/net/SocketException
    //   473: dup
    //   474: invokespecial 416	java/net/SocketException:<init>	()V
    //   477: astore_1
    //   478: ldc_w 340
    //   481: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   484: aload_1
    //   485: athrow
    //   486: astore 21
    //   488: aconst_null
    //   489: astore_1
    //   490: aload 31
    //   492: astore 23
    //   494: iload_3
    //   495: istore 4
    //   497: aload 23
    //   499: astore 22
    //   501: aload_1
    //   502: astore 20
    //   504: ldc 73
    //   506: ldc_w 418
    //   509: iconst_1
    //   510: anewarray 4	java/lang/Object
    //   513: dup
    //   514: iconst_0
    //   515: aload_0
    //   516: invokeinterface 78 1 0
    //   521: aastore
    //   522: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   525: iload_3
    //   526: istore 4
    //   528: aload 23
    //   530: astore 22
    //   532: aload_1
    //   533: astore 20
    //   535: ldc 73
    //   537: aload 21
    //   539: ldc_w 308
    //   542: iconst_0
    //   543: anewarray 4	java/lang/Object
    //   546: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   549: iload_3
    //   550: istore 4
    //   552: aload 23
    //   554: astore 22
    //   556: aload_1
    //   557: astore 20
    //   559: ldc_w 340
    //   562: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: iload_3
    //   566: istore 4
    //   568: aload 23
    //   570: astore 22
    //   572: aload_1
    //   573: astore 20
    //   575: aload 21
    //   577: athrow
    //   578: iload 12
    //   580: ifle +120 -> 700
    //   583: iload 12
    //   585: i2l
    //   586: lstore 18
    //   588: aload_0
    //   589: lload 18
    //   591: invokeinterface 422 3 0
    //   596: ifne +104 -> 700
    //   599: new 30	com/tencent/mm/pluginsdk/res/downloader/a/a
    //   602: dup
    //   603: invokespecial 423	com/tencent/mm/pluginsdk/res/downloader/a/a:<init>	()V
    //   606: astore_1
    //   607: ldc_w 340
    //   610: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   613: aload_1
    //   614: athrow
    //   615: astore 21
    //   617: aconst_null
    //   618: astore_1
    //   619: aload 32
    //   621: astore 23
    //   623: iload_3
    //   624: istore 4
    //   626: aload 23
    //   628: astore 22
    //   630: aload_1
    //   631: astore 20
    //   633: ldc 73
    //   635: new 256	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   642: aload_0
    //   643: invokeinterface 78 1 0
    //   648: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: ldc_w 426
    //   654: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload 21
    //   659: invokevirtual 427	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   662: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: iload_3
    //   672: istore 4
    //   674: aload 23
    //   676: astore 22
    //   678: aload_1
    //   679: astore 20
    //   681: ldc_w 340
    //   684: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   687: iload_3
    //   688: istore 4
    //   690: aload 23
    //   692: astore 22
    //   694: aload_1
    //   695: astore 20
    //   697: aload 21
    //   699: athrow
    //   700: sipush 416
    //   703: iload 11
    //   705: if_icmpne +59 -> 764
    //   708: new 429	com/tencent/mm/pluginsdk/res/downloader/a/b
    //   711: dup
    //   712: iload 12
    //   714: i2l
    //   715: lload 16
    //   717: invokespecial 432	com/tencent/mm/pluginsdk/res/downloader/a/b:<init>	(JJ)V
    //   720: astore_1
    //   721: ldc_w 340
    //   724: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   727: aload_1
    //   728: athrow
    //   729: astore_0
    //   730: aconst_null
    //   731: astore_1
    //   732: aload 33
    //   734: astore 21
    //   736: iload_3
    //   737: istore 4
    //   739: aload 21
    //   741: astore 22
    //   743: aload_1
    //   744: astore 20
    //   746: ldc_w 340
    //   749: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   752: iload_3
    //   753: istore 4
    //   755: aload 21
    //   757: astore 22
    //   759: aload_1
    //   760: astore 20
    //   762: aload_0
    //   763: athrow
    //   764: new 434	java/io/BufferedInputStream
    //   767: dup
    //   768: aload_1
    //   769: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   772: invokespecial 437	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   775: astore 21
    //   777: iload_3
    //   778: istore 4
    //   780: aload 34
    //   782: astore 22
    //   784: aload 21
    //   786: astore 20
    //   788: aload 21
    //   790: astore_1
    //   791: aload 21
    //   793: astore 23
    //   795: aload 21
    //   797: astore 24
    //   799: aload 21
    //   801: astore 25
    //   803: aload 21
    //   805: astore 26
    //   807: aload 21
    //   809: astore 27
    //   811: aload 36
    //   813: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   816: ifne +89 -> 905
    //   819: iload_3
    //   820: istore 4
    //   822: aload 34
    //   824: astore 22
    //   826: aload 21
    //   828: astore 20
    //   830: aload 21
    //   832: astore_1
    //   833: aload 21
    //   835: astore 23
    //   837: aload 21
    //   839: astore 24
    //   841: aload 21
    //   843: astore 25
    //   845: aload 21
    //   847: astore 26
    //   849: aload 21
    //   851: astore 27
    //   853: aload 36
    //   855: ldc_w 439
    //   858: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   861: ifeq +44 -> 905
    //   864: iload_3
    //   865: istore 4
    //   867: aload 34
    //   869: astore 22
    //   871: aload 21
    //   873: astore 20
    //   875: aload 21
    //   877: astore 23
    //   879: aload 21
    //   881: astore 24
    //   883: aload 21
    //   885: astore 25
    //   887: aload 21
    //   889: astore 26
    //   891: aload 21
    //   893: astore 27
    //   895: new 441	java/util/zip/GZIPInputStream
    //   898: dup
    //   899: aload 21
    //   901: invokespecial 442	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   904: astore_1
    //   905: iload_3
    //   906: istore 4
    //   908: aload 34
    //   910: astore 22
    //   912: aload_1
    //   913: astore 20
    //   915: aload_1
    //   916: astore 23
    //   918: aload_1
    //   919: astore 24
    //   921: aload_1
    //   922: astore 25
    //   924: aload_1
    //   925: astore 26
    //   927: aload_1
    //   928: astore 27
    //   930: aload_0
    //   931: invokeinterface 65 1 0
    //   936: astore 21
    //   938: iload_3
    //   939: istore 4
    //   941: aload 34
    //   943: astore 22
    //   945: aload_1
    //   946: astore 20
    //   948: aload_1
    //   949: astore 23
    //   951: aload_1
    //   952: astore 24
    //   954: aload_1
    //   955: astore 25
    //   957: aload_1
    //   958: astore 26
    //   960: aload_1
    //   961: astore 27
    //   963: aload_0
    //   964: invokeinterface 78 1 0
    //   969: astore 36
    //   971: iload_2
    //   972: ifeq +984 -> 1956
    //   975: iload 14
    //   977: ifeq +979 -> 1956
    //   980: iconst_1
    //   981: istore 15
    //   983: iload_3
    //   984: istore 4
    //   986: aload 34
    //   988: astore 22
    //   990: aload_1
    //   991: astore 20
    //   993: aload_1
    //   994: astore 23
    //   996: aload_1
    //   997: astore 24
    //   999: aload_1
    //   1000: astore 25
    //   1002: aload_1
    //   1003: astore 26
    //   1005: aload_1
    //   1006: astore 27
    //   1008: ldc 73
    //   1010: ldc_w 444
    //   1013: iconst_2
    //   1014: anewarray 4	java/lang/Object
    //   1017: dup
    //   1018: iconst_0
    //   1019: aload 36
    //   1021: aastore
    //   1022: dup
    //   1023: iconst_1
    //   1024: aload 21
    //   1026: aastore
    //   1027: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1030: iload_3
    //   1031: istore 4
    //   1033: aload 34
    //   1035: astore 22
    //   1037: aload_1
    //   1038: astore 20
    //   1040: aload_1
    //   1041: astore 23
    //   1043: aload_1
    //   1044: astore 24
    //   1046: aload_1
    //   1047: astore 25
    //   1049: aload_1
    //   1050: astore 26
    //   1052: aload_1
    //   1053: astore 27
    //   1055: aload 21
    //   1057: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1060: ifeq +111 -> 1171
    //   1063: iload_3
    //   1064: istore 4
    //   1066: aload 34
    //   1068: astore 22
    //   1070: aload_1
    //   1071: astore 20
    //   1073: aload_1
    //   1074: astore 23
    //   1076: aload_1
    //   1077: astore 24
    //   1079: aload_1
    //   1080: astore 25
    //   1082: aload_1
    //   1083: astore 26
    //   1085: aload_1
    //   1086: astore 27
    //   1088: new 28	java/io/FileNotFoundException
    //   1091: dup
    //   1092: ldc_w 446
    //   1095: iconst_1
    //   1096: anewarray 4	java/lang/Object
    //   1099: dup
    //   1100: iconst_0
    //   1101: aload 36
    //   1103: aastore
    //   1104: invokestatic 450	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1107: invokespecial 451	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   1110: astore 21
    //   1112: iload_3
    //   1113: istore 4
    //   1115: aload 34
    //   1117: astore 22
    //   1119: aload_1
    //   1120: astore 20
    //   1122: aload_1
    //   1123: astore 23
    //   1125: aload_1
    //   1126: astore 24
    //   1128: aload_1
    //   1129: astore 25
    //   1131: aload_1
    //   1132: astore 26
    //   1134: aload_1
    //   1135: astore 27
    //   1137: ldc_w 340
    //   1140: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1143: iload_3
    //   1144: istore 4
    //   1146: aload 34
    //   1148: astore 22
    //   1150: aload_1
    //   1151: astore 20
    //   1153: aload_1
    //   1154: astore 23
    //   1156: aload_1
    //   1157: astore 24
    //   1159: aload_1
    //   1160: astore 25
    //   1162: aload_1
    //   1163: astore 26
    //   1165: aload_1
    //   1166: astore 27
    //   1168: aload 21
    //   1170: athrow
    //   1171: iload_3
    //   1172: istore 4
    //   1174: aload 34
    //   1176: astore 22
    //   1178: aload_1
    //   1179: astore 20
    //   1181: aload_1
    //   1182: astore 23
    //   1184: aload_1
    //   1185: astore 24
    //   1187: aload_1
    //   1188: astore 25
    //   1190: aload_1
    //   1191: astore 26
    //   1193: aload_1
    //   1194: astore 27
    //   1196: new 453	java/io/BufferedOutputStream
    //   1199: dup
    //   1200: aload 21
    //   1202: iload 15
    //   1204: invokestatic 459	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   1207: invokespecial 460	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1210: astore 21
    //   1212: iload_3
    //   1213: istore 4
    //   1215: iload_3
    //   1216: istore 5
    //   1218: iload_3
    //   1219: istore 6
    //   1221: iload_3
    //   1222: istore 7
    //   1224: iload_3
    //   1225: istore 8
    //   1227: iload_3
    //   1228: istore 9
    //   1230: iload_3
    //   1231: istore 10
    //   1233: ldc 73
    //   1235: ldc_w 462
    //   1238: iconst_3
    //   1239: anewarray 4	java/lang/Object
    //   1242: dup
    //   1243: iconst_0
    //   1244: aload_0
    //   1245: invokeinterface 78 1 0
    //   1250: aastore
    //   1251: dup
    //   1252: iconst_1
    //   1253: iload_2
    //   1254: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1257: aastore
    //   1258: dup
    //   1259: iconst_2
    //   1260: iload 14
    //   1262: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1265: aastore
    //   1266: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1269: iload_3
    //   1270: istore 4
    //   1272: iload_3
    //   1273: istore 5
    //   1275: iload_3
    //   1276: istore 6
    //   1278: iload_3
    //   1279: istore 7
    //   1281: iload_3
    //   1282: istore 8
    //   1284: iload_3
    //   1285: istore 9
    //   1287: iload_3
    //   1288: istore 10
    //   1290: sipush 16384
    //   1293: newarray byte
    //   1295: astore 20
    //   1297: iconst_0
    //   1298: istore_3
    //   1299: iload_3
    //   1300: istore 4
    //   1302: iload_3
    //   1303: istore 5
    //   1305: iload_3
    //   1306: istore 6
    //   1308: iload_3
    //   1309: istore 7
    //   1311: iload_3
    //   1312: istore 8
    //   1314: iload_3
    //   1315: istore 9
    //   1317: iload_3
    //   1318: istore 10
    //   1320: aload_1
    //   1321: aload 20
    //   1323: iconst_0
    //   1324: sipush 16384
    //   1327: invokevirtual 466	java/io/InputStream:read	([BII)I
    //   1330: istore 13
    //   1332: iload 13
    //   1334: iconst_m1
    //   1335: if_icmpeq +66 -> 1401
    //   1338: iload_3
    //   1339: istore 4
    //   1341: iload_3
    //   1342: istore 5
    //   1344: iload_3
    //   1345: istore 6
    //   1347: iload_3
    //   1348: istore 7
    //   1350: iload_3
    //   1351: istore 8
    //   1353: iload_3
    //   1354: istore 9
    //   1356: iload_3
    //   1357: istore 10
    //   1359: aload 21
    //   1361: aload 20
    //   1363: iconst_0
    //   1364: iload 13
    //   1366: invokevirtual 471	java/io/OutputStream:write	([BII)V
    //   1369: iload_3
    //   1370: iload 13
    //   1372: iadd
    //   1373: istore_3
    //   1374: iload_3
    //   1375: istore 4
    //   1377: iload_3
    //   1378: istore 5
    //   1380: iload_3
    //   1381: istore 6
    //   1383: iload_3
    //   1384: istore 7
    //   1386: iload_3
    //   1387: istore 8
    //   1389: iload_3
    //   1390: istore 9
    //   1392: iload_3
    //   1393: istore 10
    //   1395: invokestatic 113	com/tencent/mm/pluginsdk/res/downloader/model/j:iJH	()V
    //   1398: goto -99 -> 1299
    //   1401: iload_3
    //   1402: istore 4
    //   1404: iload_3
    //   1405: istore 5
    //   1407: iload_3
    //   1408: istore 6
    //   1410: iload_3
    //   1411: istore 7
    //   1413: iload_3
    //   1414: istore 8
    //   1416: iload_3
    //   1417: istore 9
    //   1419: iload_3
    //   1420: istore 10
    //   1422: ldc 73
    //   1424: ldc_w 473
    //   1427: iconst_2
    //   1428: anewarray 4	java/lang/Object
    //   1431: dup
    //   1432: iconst_0
    //   1433: aload_0
    //   1434: invokeinterface 78 1 0
    //   1439: aastore
    //   1440: dup
    //   1441: iconst_1
    //   1442: iload_3
    //   1443: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1446: aastore
    //   1447: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1450: iload_3
    //   1451: istore 4
    //   1453: iload_3
    //   1454: istore 5
    //   1456: iload_3
    //   1457: istore 6
    //   1459: iload_3
    //   1460: istore 7
    //   1462: iload_3
    //   1463: istore 8
    //   1465: iload_3
    //   1466: istore 9
    //   1468: iload_3
    //   1469: istore 10
    //   1471: aload 21
    //   1473: invokevirtual 476	java/io/OutputStream:flush	()V
    //   1476: iload_3
    //   1477: istore 4
    //   1479: iload_3
    //   1480: istore 5
    //   1482: iload_3
    //   1483: istore 6
    //   1485: iload_3
    //   1486: istore 7
    //   1488: iload_3
    //   1489: istore 8
    //   1491: iload_3
    //   1492: istore 9
    //   1494: iload_3
    //   1495: istore 10
    //   1497: ldc 73
    //   1499: ldc_w 478
    //   1502: iconst_1
    //   1503: anewarray 4	java/lang/Object
    //   1506: dup
    //   1507: iconst_0
    //   1508: aload_0
    //   1509: invokeinterface 78 1 0
    //   1514: aastore
    //   1515: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1518: iload_3
    //   1519: istore 4
    //   1521: iload_3
    //   1522: istore 5
    //   1524: iload_3
    //   1525: istore 6
    //   1527: iload_3
    //   1528: istore 7
    //   1530: iload_3
    //   1531: istore 8
    //   1533: iload_3
    //   1534: istore 9
    //   1536: iload_3
    //   1537: istore 10
    //   1539: aload_0
    //   1540: invokeinterface 415 1 0
    //   1545: ifeq +83 -> 1628
    //   1548: iload_3
    //   1549: istore 4
    //   1551: iload_3
    //   1552: istore 5
    //   1554: iload_3
    //   1555: istore 6
    //   1557: iload_3
    //   1558: istore 7
    //   1560: iload_3
    //   1561: istore 8
    //   1563: iload_3
    //   1564: istore 9
    //   1566: iload_3
    //   1567: istore 10
    //   1569: new 334	com/tencent/mm/pluginsdk/res/downloader/model/l
    //   1572: dup
    //   1573: aload_0
    //   1574: aload_0
    //   1575: invokeinterface 65 1 0
    //   1580: invokestatic 136	com/tencent/mm/pluginsdk/res/downloader/b/a:jK	(Ljava/lang/String;)J
    //   1583: aload 35
    //   1585: invokespecial 384	com/tencent/mm/pluginsdk/res/downloader/model/l:<init>	(Lcom/tencent/mm/pluginsdk/res/downloader/model/e;JLjava/lang/String;)V
    //   1588: astore 20
    //   1590: aload_1
    //   1591: invokestatic 388	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   1594: aload 21
    //   1596: invokestatic 388	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   1599: iload_3
    //   1600: ifle +19 -> 1619
    //   1603: getstatic 405	com/tencent/mm/model/az$a:okQ	Lcom/tencent/mm/model/az$e;
    //   1606: ifnull +13 -> 1619
    //   1609: getstatic 405	com/tencent/mm/model/az$a:okQ	Lcom/tencent/mm/model/az$e;
    //   1612: iload_3
    //   1613: iconst_0
    //   1614: invokeinterface 411 3 0
    //   1619: ldc_w 340
    //   1622: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1625: aload 20
    //   1627: areturn
    //   1628: iload_3
    //   1629: istore 4
    //   1631: iload_3
    //   1632: istore 5
    //   1634: iload_3
    //   1635: istore 6
    //   1637: iload_3
    //   1638: istore 7
    //   1640: iload_3
    //   1641: istore 8
    //   1643: iload_3
    //   1644: istore 9
    //   1646: iload_3
    //   1647: istore 10
    //   1649: new 334	com/tencent/mm/pluginsdk/res/downloader/model/l
    //   1652: dup
    //   1653: aload_0
    //   1654: iload 12
    //   1656: i2l
    //   1657: aload 35
    //   1659: invokespecial 384	com/tencent/mm/pluginsdk/res/downloader/model/l:<init>	(Lcom/tencent/mm/pluginsdk/res/downloader/model/e;JLjava/lang/String;)V
    //   1662: astore 20
    //   1664: aload_1
    //   1665: invokestatic 388	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   1668: aload 21
    //   1670: invokestatic 388	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   1673: iload_3
    //   1674: ifle +19 -> 1693
    //   1677: getstatic 405	com/tencent/mm/model/az$a:okQ	Lcom/tencent/mm/model/az$e;
    //   1680: ifnull +13 -> 1693
    //   1683: getstatic 405	com/tencent/mm/model/az$a:okQ	Lcom/tencent/mm/model/az$e;
    //   1686: iload_3
    //   1687: iconst_0
    //   1688: invokeinterface 411 3 0
    //   1693: ldc_w 340
    //   1696: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1699: aload 20
    //   1701: areturn
    //   1702: astore 20
    //   1704: iconst_m1
    //   1705: istore 11
    //   1707: aconst_null
    //   1708: astore_1
    //   1709: aload 28
    //   1711: astore 22
    //   1713: aload_1
    //   1714: invokestatic 388	com/tencent/mm/pluginsdk/res/downloader/b/a:c	(Ljava/io/Closeable;)V
    //   1717: ldc 73
    //   1719: ldc_w 480
    //   1722: iconst_2
    //   1723: anewarray 4	java/lang/Object
    //   1726: dup
    //   1727: iconst_0
    //   1728: aload_0
    //   1729: invokeinterface 78 1 0
    //   1734: aastore
    //   1735: dup
    //   1736: iconst_1
    //   1737: aload 20
    //   1739: aastore
    //   1740: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1743: new 322	com/tencent/mm/pluginsdk/res/downloader/a/f
    //   1746: dup
    //   1747: iload 11
    //   1749: aload 20
    //   1751: invokespecial 483	com/tencent/mm/pluginsdk/res/downloader/a/f:<init>	(ILjava/io/IOException;)V
    //   1754: astore_0
    //   1755: ldc_w 340
    //   1758: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1761: aload_0
    //   1762: athrow
    //   1763: astore_0
    //   1764: goto -1401 -> 363
    //   1767: astore_0
    //   1768: aconst_null
    //   1769: astore_1
    //   1770: goto -1407 -> 363
    //   1773: astore_0
    //   1774: iload 4
    //   1776: istore_3
    //   1777: aload 21
    //   1779: astore 22
    //   1781: goto -1418 -> 363
    //   1784: astore 20
    //   1786: aconst_null
    //   1787: astore_1
    //   1788: aload 28
    //   1790: astore 22
    //   1792: goto -79 -> 1713
    //   1795: astore 20
    //   1797: aload 21
    //   1799: astore_1
    //   1800: aload 28
    //   1802: astore 22
    //   1804: goto -91 -> 1713
    //   1807: astore 20
    //   1809: aload 28
    //   1811: astore 22
    //   1813: goto -100 -> 1713
    //   1816: astore 20
    //   1818: iload 5
    //   1820: istore_3
    //   1821: aload 21
    //   1823: astore 22
    //   1825: goto -112 -> 1713
    //   1828: astore_0
    //   1829: aload 33
    //   1831: astore 21
    //   1833: aload 23
    //   1835: astore_1
    //   1836: goto -1100 -> 736
    //   1839: astore_0
    //   1840: iload 6
    //   1842: istore_3
    //   1843: goto -1107 -> 736
    //   1846: astore 21
    //   1848: aload 32
    //   1850: astore 23
    //   1852: aload 24
    //   1854: astore_1
    //   1855: goto -1232 -> 623
    //   1858: astore 20
    //   1860: aload 21
    //   1862: astore 23
    //   1864: aload 20
    //   1866: astore 21
    //   1868: iload 7
    //   1870: istore_3
    //   1871: goto -1248 -> 623
    //   1874: astore 21
    //   1876: aload 31
    //   1878: astore 23
    //   1880: aload 25
    //   1882: astore_1
    //   1883: goto -1389 -> 494
    //   1886: astore 20
    //   1888: aload 21
    //   1890: astore 23
    //   1892: aload 20
    //   1894: astore 21
    //   1896: iload 8
    //   1898: istore_3
    //   1899: goto -1405 -> 494
    //   1902: astore_0
    //   1903: aload 30
    //   1905: astore 21
    //   1907: aload 26
    //   1909: astore_1
    //   1910: goto -1482 -> 428
    //   1913: astore_0
    //   1914: iload 9
    //   1916: istore_3
    //   1917: goto -1489 -> 428
    //   1920: iconst_0
    //   1921: istore 14
    //   1923: goto -1827 -> 96
    //   1926: sipush 301
    //   1929: iload 11
    //   1931: if_icmpeq -1656 -> 275
    //   1934: sipush 302
    //   1937: iload 11
    //   1939: if_icmpne -1539 -> 400
    //   1942: goto -1667 -> 275
    //   1945: astore_0
    //   1946: aload 29
    //   1948: astore 21
    //   1950: aload 27
    //   1952: astore_1
    //   1953: goto -1625 -> 328
    //   1956: iconst_0
    //   1957: istore 15
    //   1959: goto -976 -> 983
    //   1962: astore_0
    //   1963: iload 10
    //   1965: istore_3
    //   1966: goto -1638 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1969	0	parame	e
    //   0	1969	1	paramHttpURLConnection	HttpURLConnection
    //   0	1969	2	paramBoolean	boolean
    //   52	1914	3	i	int
    //   329	1446	4	j	int
    //   1216	603	5	k	int
    //   1219	622	6	m	int
    //   1222	647	7	n	int
    //   1225	672	8	i1	int
    //   1228	687	9	i2	int
    //   1231	733	10	i3	int
    //   57	1883	11	i4	int
    //   63	1592	12	i5	int
    //   1330	43	13	i6	int
    //   94	1828	14	bool1	boolean
    //   981	977	15	bool2	boolean
    //   172	544	16	l1	long
    //   586	4	18	l2	long
    //   251	1449	20	localObject1	Object
    //   1702	48	20	localIOException1	IOException
    //   1784	1	20	localIOException2	IOException
    //   1795	1	20	localIOException3	IOException
    //   1807	1	20	localIOException4	IOException
    //   1816	1	20	localIOException5	IOException
    //   1858	7	20	localSocketException1	SocketException
    //   1886	7	20	localSSLHandshakeException1	javax.net.ssl.SSLHandshakeException
    //   326	122	21	localObject2	Object
    //   486	90	21	localSSLHandshakeException2	javax.net.ssl.SSLHandshakeException
    //   615	83	21	localSocketException2	SocketException
    //   734	1098	21	localObject3	Object
    //   1846	15	21	localSocketException3	SocketException
    //   1866	1	21	localSocketException4	SocketException
    //   1874	15	21	localSSLHandshakeException3	javax.net.ssl.SSLHandshakeException
    //   1894	55	21	localObject4	Object
    //   31	1793	22	localObject5	Object
    //   492	1399	23	localObject6	Object
    //   797	1056	24	localObject7	Object
    //   801	1080	25	localObject8	Object
    //   805	1103	26	localObject9	Object
    //   809	1142	27	localObject10	Object
    //   46	1764	28	localObject11	Object
    //   49	1898	29	localObject12	Object
    //   34	1870	30	localObject13	Object
    //   37	1840	31	localObject14	Object
    //   40	1809	32	localObject15	Object
    //   43	1787	33	localObject16	Object
    //   28	1147	34	localObject17	Object
    //   75	1583	35	str1	String
    //   69	1033	36	str2	String
    // Exception table:
    //   from	to	target	type
    //   53	59	321	java/lang/InterruptedException
    //   59	93	321	java/lang/InterruptedException
    //   96	174	321	java/lang/InterruptedException
    //   194	228	321	java/lang/InterruptedException
    //   244	253	321	java/lang/InterruptedException
    //   258	269	321	java/lang/InterruptedException
    //   275	321	321	java/lang/InterruptedException
    //   405	421	321	java/lang/InterruptedException
    //   456	465	321	java/lang/InterruptedException
    //   470	486	321	java/lang/InterruptedException
    //   588	615	321	java/lang/InterruptedException
    //   708	729	321	java/lang/InterruptedException
    //   764	777	321	java/lang/InterruptedException
    //   338	344	356	finally
    //   354	356	356	finally
    //   438	444	356	finally
    //   454	456	356	finally
    //   504	525	356	finally
    //   535	549	356	finally
    //   559	565	356	finally
    //   575	578	356	finally
    //   633	671	356	finally
    //   681	687	356	finally
    //   697	700	356	finally
    //   746	752	356	finally
    //   762	764	356	finally
    //   811	819	356	finally
    //   853	864	356	finally
    //   895	905	356	finally
    //   930	938	356	finally
    //   963	971	356	finally
    //   1008	1030	356	finally
    //   1055	1063	356	finally
    //   1088	1112	356	finally
    //   1137	1143	356	finally
    //   1168	1171	356	finally
    //   1196	1212	356	finally
    //   53	59	421	java/net/UnknownHostException
    //   59	93	421	java/net/UnknownHostException
    //   96	174	421	java/net/UnknownHostException
    //   194	228	421	java/net/UnknownHostException
    //   244	253	421	java/net/UnknownHostException
    //   258	269	421	java/net/UnknownHostException
    //   275	321	421	java/net/UnknownHostException
    //   405	421	421	java/net/UnknownHostException
    //   456	465	421	java/net/UnknownHostException
    //   470	486	421	java/net/UnknownHostException
    //   588	615	421	java/net/UnknownHostException
    //   708	729	421	java/net/UnknownHostException
    //   764	777	421	java/net/UnknownHostException
    //   53	59	486	javax/net/ssl/SSLHandshakeException
    //   59	93	486	javax/net/ssl/SSLHandshakeException
    //   96	174	486	javax/net/ssl/SSLHandshakeException
    //   194	228	486	javax/net/ssl/SSLHandshakeException
    //   244	253	486	javax/net/ssl/SSLHandshakeException
    //   258	269	486	javax/net/ssl/SSLHandshakeException
    //   275	321	486	javax/net/ssl/SSLHandshakeException
    //   405	421	486	javax/net/ssl/SSLHandshakeException
    //   456	465	486	javax/net/ssl/SSLHandshakeException
    //   470	486	486	javax/net/ssl/SSLHandshakeException
    //   588	615	486	javax/net/ssl/SSLHandshakeException
    //   708	729	486	javax/net/ssl/SSLHandshakeException
    //   764	777	486	javax/net/ssl/SSLHandshakeException
    //   53	59	615	java/net/SocketException
    //   59	93	615	java/net/SocketException
    //   96	174	615	java/net/SocketException
    //   194	228	615	java/net/SocketException
    //   244	253	615	java/net/SocketException
    //   258	269	615	java/net/SocketException
    //   275	321	615	java/net/SocketException
    //   405	421	615	java/net/SocketException
    //   456	465	615	java/net/SocketException
    //   470	486	615	java/net/SocketException
    //   588	615	615	java/net/SocketException
    //   708	729	615	java/net/SocketException
    //   764	777	615	java/net/SocketException
    //   53	59	729	java/net/SocketTimeoutException
    //   59	93	729	java/net/SocketTimeoutException
    //   96	174	729	java/net/SocketTimeoutException
    //   194	228	729	java/net/SocketTimeoutException
    //   244	253	729	java/net/SocketTimeoutException
    //   258	269	729	java/net/SocketTimeoutException
    //   275	321	729	java/net/SocketTimeoutException
    //   405	421	729	java/net/SocketTimeoutException
    //   456	465	729	java/net/SocketTimeoutException
    //   470	486	729	java/net/SocketTimeoutException
    //   588	615	729	java/net/SocketTimeoutException
    //   708	729	729	java/net/SocketTimeoutException
    //   764	777	729	java/net/SocketTimeoutException
    //   53	59	1702	java/io/IOException
    //   1713	1763	1763	finally
    //   53	59	1767	finally
    //   59	93	1767	finally
    //   96	174	1767	finally
    //   194	228	1767	finally
    //   244	253	1767	finally
    //   258	269	1767	finally
    //   275	321	1767	finally
    //   405	421	1767	finally
    //   456	465	1767	finally
    //   470	486	1767	finally
    //   588	615	1767	finally
    //   708	729	1767	finally
    //   764	777	1767	finally
    //   1233	1269	1773	finally
    //   1290	1297	1773	finally
    //   1320	1332	1773	finally
    //   1359	1369	1773	finally
    //   1395	1398	1773	finally
    //   1422	1450	1773	finally
    //   1471	1476	1773	finally
    //   1497	1518	1773	finally
    //   1539	1548	1773	finally
    //   1569	1590	1773	finally
    //   1649	1664	1773	finally
    //   59	93	1784	java/io/IOException
    //   96	174	1784	java/io/IOException
    //   194	228	1784	java/io/IOException
    //   244	253	1784	java/io/IOException
    //   258	269	1784	java/io/IOException
    //   275	321	1784	java/io/IOException
    //   405	421	1784	java/io/IOException
    //   456	465	1784	java/io/IOException
    //   470	486	1784	java/io/IOException
    //   588	615	1784	java/io/IOException
    //   708	729	1784	java/io/IOException
    //   764	777	1784	java/io/IOException
    //   811	819	1795	java/io/IOException
    //   853	864	1795	java/io/IOException
    //   895	905	1795	java/io/IOException
    //   930	938	1807	java/io/IOException
    //   963	971	1807	java/io/IOException
    //   1008	1030	1807	java/io/IOException
    //   1055	1063	1807	java/io/IOException
    //   1088	1112	1807	java/io/IOException
    //   1137	1143	1807	java/io/IOException
    //   1168	1171	1807	java/io/IOException
    //   1196	1212	1807	java/io/IOException
    //   1233	1269	1816	java/io/IOException
    //   1290	1297	1816	java/io/IOException
    //   1320	1332	1816	java/io/IOException
    //   1359	1369	1816	java/io/IOException
    //   1395	1398	1816	java/io/IOException
    //   1422	1450	1816	java/io/IOException
    //   1471	1476	1816	java/io/IOException
    //   1497	1518	1816	java/io/IOException
    //   1539	1548	1816	java/io/IOException
    //   1569	1590	1816	java/io/IOException
    //   1649	1664	1816	java/io/IOException
    //   811	819	1828	java/net/SocketTimeoutException
    //   853	864	1828	java/net/SocketTimeoutException
    //   895	905	1828	java/net/SocketTimeoutException
    //   930	938	1828	java/net/SocketTimeoutException
    //   963	971	1828	java/net/SocketTimeoutException
    //   1008	1030	1828	java/net/SocketTimeoutException
    //   1055	1063	1828	java/net/SocketTimeoutException
    //   1088	1112	1828	java/net/SocketTimeoutException
    //   1137	1143	1828	java/net/SocketTimeoutException
    //   1168	1171	1828	java/net/SocketTimeoutException
    //   1196	1212	1828	java/net/SocketTimeoutException
    //   1233	1269	1839	java/net/SocketTimeoutException
    //   1290	1297	1839	java/net/SocketTimeoutException
    //   1320	1332	1839	java/net/SocketTimeoutException
    //   1359	1369	1839	java/net/SocketTimeoutException
    //   1395	1398	1839	java/net/SocketTimeoutException
    //   1422	1450	1839	java/net/SocketTimeoutException
    //   1471	1476	1839	java/net/SocketTimeoutException
    //   1497	1518	1839	java/net/SocketTimeoutException
    //   1539	1548	1839	java/net/SocketTimeoutException
    //   1569	1590	1839	java/net/SocketTimeoutException
    //   1649	1664	1839	java/net/SocketTimeoutException
    //   811	819	1846	java/net/SocketException
    //   853	864	1846	java/net/SocketException
    //   895	905	1846	java/net/SocketException
    //   930	938	1846	java/net/SocketException
    //   963	971	1846	java/net/SocketException
    //   1008	1030	1846	java/net/SocketException
    //   1055	1063	1846	java/net/SocketException
    //   1088	1112	1846	java/net/SocketException
    //   1137	1143	1846	java/net/SocketException
    //   1168	1171	1846	java/net/SocketException
    //   1196	1212	1846	java/net/SocketException
    //   1233	1269	1858	java/net/SocketException
    //   1290	1297	1858	java/net/SocketException
    //   1320	1332	1858	java/net/SocketException
    //   1359	1369	1858	java/net/SocketException
    //   1395	1398	1858	java/net/SocketException
    //   1422	1450	1858	java/net/SocketException
    //   1471	1476	1858	java/net/SocketException
    //   1497	1518	1858	java/net/SocketException
    //   1539	1548	1858	java/net/SocketException
    //   1569	1590	1858	java/net/SocketException
    //   1649	1664	1858	java/net/SocketException
    //   811	819	1874	javax/net/ssl/SSLHandshakeException
    //   853	864	1874	javax/net/ssl/SSLHandshakeException
    //   895	905	1874	javax/net/ssl/SSLHandshakeException
    //   930	938	1874	javax/net/ssl/SSLHandshakeException
    //   963	971	1874	javax/net/ssl/SSLHandshakeException
    //   1008	1030	1874	javax/net/ssl/SSLHandshakeException
    //   1055	1063	1874	javax/net/ssl/SSLHandshakeException
    //   1088	1112	1874	javax/net/ssl/SSLHandshakeException
    //   1137	1143	1874	javax/net/ssl/SSLHandshakeException
    //   1168	1171	1874	javax/net/ssl/SSLHandshakeException
    //   1196	1212	1874	javax/net/ssl/SSLHandshakeException
    //   1233	1269	1886	javax/net/ssl/SSLHandshakeException
    //   1290	1297	1886	javax/net/ssl/SSLHandshakeException
    //   1320	1332	1886	javax/net/ssl/SSLHandshakeException
    //   1359	1369	1886	javax/net/ssl/SSLHandshakeException
    //   1395	1398	1886	javax/net/ssl/SSLHandshakeException
    //   1422	1450	1886	javax/net/ssl/SSLHandshakeException
    //   1471	1476	1886	javax/net/ssl/SSLHandshakeException
    //   1497	1518	1886	javax/net/ssl/SSLHandshakeException
    //   1539	1548	1886	javax/net/ssl/SSLHandshakeException
    //   1569	1590	1886	javax/net/ssl/SSLHandshakeException
    //   1649	1664	1886	javax/net/ssl/SSLHandshakeException
    //   811	819	1902	java/net/UnknownHostException
    //   853	864	1902	java/net/UnknownHostException
    //   895	905	1902	java/net/UnknownHostException
    //   930	938	1902	java/net/UnknownHostException
    //   963	971	1902	java/net/UnknownHostException
    //   1008	1030	1902	java/net/UnknownHostException
    //   1055	1063	1902	java/net/UnknownHostException
    //   1088	1112	1902	java/net/UnknownHostException
    //   1137	1143	1902	java/net/UnknownHostException
    //   1168	1171	1902	java/net/UnknownHostException
    //   1196	1212	1902	java/net/UnknownHostException
    //   1233	1269	1913	java/net/UnknownHostException
    //   1290	1297	1913	java/net/UnknownHostException
    //   1320	1332	1913	java/net/UnknownHostException
    //   1359	1369	1913	java/net/UnknownHostException
    //   1395	1398	1913	java/net/UnknownHostException
    //   1422	1450	1913	java/net/UnknownHostException
    //   1471	1476	1913	java/net/UnknownHostException
    //   1497	1518	1913	java/net/UnknownHostException
    //   1539	1548	1913	java/net/UnknownHostException
    //   1569	1590	1913	java/net/UnknownHostException
    //   1649	1664	1913	java/net/UnknownHostException
    //   811	819	1945	java/lang/InterruptedException
    //   853	864	1945	java/lang/InterruptedException
    //   895	905	1945	java/lang/InterruptedException
    //   930	938	1945	java/lang/InterruptedException
    //   963	971	1945	java/lang/InterruptedException
    //   1008	1030	1945	java/lang/InterruptedException
    //   1055	1063	1945	java/lang/InterruptedException
    //   1088	1112	1945	java/lang/InterruptedException
    //   1137	1143	1945	java/lang/InterruptedException
    //   1168	1171	1945	java/lang/InterruptedException
    //   1196	1212	1945	java/lang/InterruptedException
    //   1233	1269	1962	java/lang/InterruptedException
    //   1290	1297	1962	java/lang/InterruptedException
    //   1320	1332	1962	java/lang/InterruptedException
    //   1359	1369	1962	java/lang/InterruptedException
    //   1395	1398	1962	java/lang/InterruptedException
    //   1422	1450	1962	java/lang/InterruptedException
    //   1471	1476	1962	java/lang/InterruptedException
    //   1497	1518	1962	java/lang/InterruptedException
    //   1539	1548	1962	java/lang/InterruptedException
    //   1569	1590	1962	java/lang/InterruptedException
    //   1649	1664	1962	java/lang/InterruptedException
  }
  
  private static void a(e parame, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(152025);
    Log.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", new Object[] { parame.iJd() });
    Object localObject = parame.iJB();
    if ((localObject != null) && (((Collection)localObject).size() > 0))
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        paramHttpURLConnection.addRequestProperty(localb.name, localb.value);
      }
    }
    paramHttpURLConnection.setRequestMethod(parame.iJA());
    if ("GET".equalsIgnoreCase(parame.iJA())) {
      paramHttpURLConnection.setDoOutput(false);
    }
    paramHttpURLConnection.setConnectTimeout(parame.iJC());
    paramHttpURLConnection.setReadTimeout(parame.iJD());
    paramHttpURLConnection.setUseCaches(false);
    if (parame.cgS()) {
      paramHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
    }
    for (;;)
    {
      localObject = System.getProperty("http.agent");
      if (!Util.isNullOrNil((String)localObject)) {
        paramHttpURLConnection.setRequestProperty("User-agent", (String)localObject);
      }
      if (!parame.cgW()) {
        break;
      }
      paramHttpURLConnection.setInstanceFollowRedirects(true);
      AppMethodBeat.o(152025);
      return;
      paramHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    paramHttpURLConnection.setInstanceFollowRedirects(false);
    AppMethodBeat.o(152025);
  }
  
  private static l b(e parame, Exception paramException)
  {
    AppMethodBeat.i(152029);
    if ((paramException instanceof ProtocolException))
    {
      Log.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", new Object[] { parame.iJd(), parame.iJA() });
      parame = a(parame, paramException);
      AppMethodBeat.o(152029);
      return parame;
    }
    if ((paramException instanceof com.tencent.mm.pluginsdk.res.downloader.a.b))
    {
      Log.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", new Object[] { parame.iJd(), paramException.getClass().getSimpleName(), paramException.getMessage() });
      com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(parame.getFilePath());
      AppMethodBeat.o(152029);
      return null;
    }
    Class[] arrayOfClass = XWE;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].equals(paramException.getClass()))
      {
        Log.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", new Object[] { parame.iJd(), paramException });
        parame = new l(parame, paramException, 4);
        AppMethodBeat.o(152029);
        return parame;
      }
      i += 1;
    }
    arrayOfClass = XWG;
    j = arrayOfClass.length;
    i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].equals(paramException.getClass()))
      {
        AppMethodBeat.o(152029);
        return null;
      }
      i += 1;
    }
    arrayOfClass = XWF;
    j = arrayOfClass.length;
    i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].equals(paramException.getClass()))
      {
        parame = a(parame, paramException);
        AppMethodBeat.o(152029);
        return parame;
      }
      i += 1;
    }
    parame = a(parame, paramException);
    AppMethodBeat.o(152029);
    return parame;
  }
  
  private static SSLContext bog(String paramString)
  {
    AppMethodBeat.i(152026);
    try
    {
      paramString = SSLContext.getInstance(paramString);
      AppMethodBeat.o(152026);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(152026);
    }
    return null;
  }
  
  private static void iJH()
  {
    AppMethodBeat.i(152024);
    if (Thread.interrupted())
    {
      InterruptedException localInterruptedException = new InterruptedException(Thread.currentThread().getName() + " has interrupted by someone!");
      AppMethodBeat.o(152024);
      throw localInterruptedException;
    }
    AppMethodBeat.o(152024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.j
 * JD-Core Version:    0.7.0.1
 */