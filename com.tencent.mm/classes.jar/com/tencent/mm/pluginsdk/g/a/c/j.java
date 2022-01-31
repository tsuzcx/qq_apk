package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.b.d;
import com.tencent.mm.pluginsdk.g.a.b.f;
import com.tencent.mm.pluginsdk.g.a.b.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static final Class[] vOp = { InterruptedException.class };
  private static final Class[] vOq = { UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, com.tencent.mm.pluginsdk.g.a.b.a.class, d.class, g.class };
  private static final Class[] vOr = { SocketException.class, SocketTimeoutException.class };
  private boolean vOo = false;
  
  /* Error */
  static m a(e parame)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokeinterface 65 1 0
    //   11: invokestatic 71	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
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
    //   34: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   77: invokestatic 110	com/tencent/mm/pluginsdk/g/a/d/a:alT	(Ljava/lang/String;)Z
    //   80: pop
    //   81: invokestatic 113	com/tencent/mm/pluginsdk/g/a/c/j:dmx	()V
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
    //   135: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: invokestatic 113	com/tencent/mm/pluginsdk/g/a/c/j:dmx	()V
    //   141: aload_0
    //   142: aload 6
    //   144: invokestatic 132	com/tencent/mm/pluginsdk/g/a/c/j:a	(Lcom/tencent/mm/pluginsdk/g/a/c/e;Ljava/net/HttpURLConnection;)V
    //   147: invokestatic 113	com/tencent/mm/pluginsdk/g/a/c/j:dmx	()V
    //   150: aload_0
    //   151: invokeinterface 65 1 0
    //   156: invokestatic 136	com/tencent/mm/pluginsdk/g/a/d/a:eG	(Ljava/lang/String;)J
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
    //   184: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: lload_1
    //   188: lconst_0
    //   189: lcmp
    //   190: ifne +267 -> 457
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
    //   219: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: invokestatic 113	com/tencent/mm/pluginsdk/g/a/c/j:dmx	()V
    //   225: ldc 153
    //   227: aload 4
    //   229: invokevirtual 156	java/net/URL:getProtocol	()Ljava/lang/String;
    //   232: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   235: ifeq +76 -> 311
    //   238: aload 6
    //   240: checkcast 163	javax/net/ssl/HttpsURLConnection
    //   243: astore 7
    //   245: ldc 165
    //   247: invokestatic 169	com/tencent/mm/pluginsdk/g/a/c/j:aku	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   250: astore 5
    //   252: aload 5
    //   254: astore 4
    //   256: aload 5
    //   258: ifnonnull +24 -> 282
    //   261: ldc 171
    //   263: invokestatic 169	com/tencent/mm/pluginsdk/g/a/c/j:aku	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   266: astore 5
    //   268: aload 5
    //   270: astore 4
    //   272: aload 5
    //   274: ifnonnull +8 -> 282
    //   277: invokestatic 177	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   280: astore 4
    //   282: aload 4
    //   284: ifnull +207 -> 491
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
    //   311: invokestatic 113	com/tencent/mm/pluginsdk/g/a/c/j:dmx	()V
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
    //   340: invokestatic 200	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: ldc 202
    //   345: aload_0
    //   346: invokeinterface 197 1 0
    //   351: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   354: ifeq +65 -> 419
    //   357: aconst_null
    //   358: invokestatic 210	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   361: ifne +58 -> 419
    //   364: aload 6
    //   366: iconst_1
    //   367: invokevirtual 214	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   370: aload 6
    //   372: ldc 216
    //   374: aload_0
    //   375: invokeinterface 219 1 0
    //   380: invokevirtual 223	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 6
    //   385: aconst_null
    //   386: arraylength
    //   387: invokevirtual 226	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   390: new 228	java/io/DataOutputStream
    //   393: dup
    //   394: aload 6
    //   396: invokevirtual 232	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   399: invokespecial 235	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   402: astore 5
    //   404: aload 5
    //   406: astore 4
    //   408: aload 5
    //   410: aconst_null
    //   411: invokevirtual 239	java/io/DataOutputStream:write	([B)V
    //   414: aload 5
    //   416: invokevirtual 240	java/io/DataOutputStream:close	()V
    //   419: invokestatic 113	com/tencent/mm/pluginsdk/g/a/c/j:dmx	()V
    //   422: aload_0
    //   423: aload 6
    //   425: iload_3
    //   426: invokestatic 243	com/tencent/mm/pluginsdk/g/a/c/j:a	(Lcom/tencent/mm/pluginsdk/g/a/c/e;Ljava/net/HttpURLConnection;Z)Lcom/tencent/mm/pluginsdk/g/a/c/m;
    //   429: astore 4
    //   431: aload 6
    //   433: ifnull +16 -> 449
    //   436: aload 6
    //   438: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   441: invokevirtual 98	java/io/InputStream:close	()V
    //   444: aload 6
    //   446: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
    //   449: ldc 53
    //   451: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   454: aload 4
    //   456: areturn
    //   457: aload 6
    //   459: ldc 245
    //   461: new 247	java/lang/StringBuilder
    //   464: dup
    //   465: ldc 249
    //   467: invokespecial 250	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: lload_1
    //   471: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   474: ldc_w 256
    //   477: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokevirtual 265	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: iconst_1
    //   487: istore_3
    //   488: goto -293 -> 195
    //   491: aload 7
    //   493: aload_0
    //   494: invokeinterface 269 1 0
    //   499: new 271	android/net/SSLSessionCache
    //   502: dup
    //   503: invokestatic 277	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   506: invokespecial 280	android/net/SSLSessionCache:<init>	(Landroid/content/Context;)V
    //   509: invokestatic 285	android/net/SSLCertificateSocketFactory:getDefault	(ILandroid/net/SSLSessionCache;)Ljavax/net/ssl/SSLSocketFactory;
    //   512: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   515: goto -204 -> 311
    //   518: astore 5
    //   520: aload 6
    //   522: astore 4
    //   524: aload_0
    //   525: aload 5
    //   527: invokestatic 289	com/tencent/mm/pluginsdk/g/a/c/j:b	(Lcom/tencent/mm/pluginsdk/g/a/c/e;Ljava/lang/Exception;)Lcom/tencent/mm/pluginsdk/g/a/c/m;
    //   530: astore 6
    //   532: aload 6
    //   534: ifnonnull +325 -> 859
    //   537: ldc 73
    //   539: ldc_w 291
    //   542: iconst_1
    //   543: anewarray 4	java/lang/Object
    //   546: dup
    //   547: iconst_0
    //   548: aload_0
    //   549: invokeinterface 78 1 0
    //   554: aastore
    //   555: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   558: aload_0
    //   559: invokeinterface 294 1 0
    //   564: ifne -520 -> 44
    //   567: ldc 73
    //   569: ldc_w 296
    //   572: iconst_1
    //   573: anewarray 4	java/lang/Object
    //   576: dup
    //   577: iconst_0
    //   578: aload_0
    //   579: invokeinterface 78 1 0
    //   584: aastore
    //   585: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   588: aload_0
    //   589: aload 5
    //   591: invokestatic 298	com/tencent/mm/pluginsdk/g/a/c/j:a	(Lcom/tencent/mm/pluginsdk/g/a/c/e;Ljava/lang/Exception;)Lcom/tencent/mm/pluginsdk/g/a/c/m;
    //   594: astore_0
    //   595: aload 4
    //   597: ifnull +16 -> 613
    //   600: aload 4
    //   602: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   605: invokevirtual 98	java/io/InputStream:close	()V
    //   608: aload 4
    //   610: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
    //   613: ldc 53
    //   615: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   618: aload_0
    //   619: areturn
    //   620: astore 4
    //   622: ldc 73
    //   624: ldc_w 300
    //   627: iconst_1
    //   628: anewarray 4	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: aload_0
    //   634: invokeinterface 78 1 0
    //   639: aastore
    //   640: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   643: ldc 73
    //   645: aload 4
    //   647: ldc_w 302
    //   650: iconst_0
    //   651: anewarray 4	java/lang/Object
    //   654: invokestatic 306	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   657: goto -238 -> 419
    //   660: astore_0
    //   661: aload 6
    //   663: astore 4
    //   665: aload 4
    //   667: ifnull +16 -> 683
    //   670: aload 4
    //   672: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   675: invokevirtual 98	java/io/InputStream:close	()V
    //   678: aload 4
    //   680: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
    //   683: ldc 53
    //   685: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: aload_0
    //   689: athrow
    //   690: astore 7
    //   692: aconst_null
    //   693: astore 5
    //   695: aload 5
    //   697: astore 4
    //   699: ldc 73
    //   701: ldc_w 308
    //   704: iconst_1
    //   705: anewarray 4	java/lang/Object
    //   708: dup
    //   709: iconst_0
    //   710: aload_0
    //   711: invokeinterface 78 1 0
    //   716: aastore
    //   717: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   720: aload 5
    //   722: astore 4
    //   724: ldc 73
    //   726: aload 7
    //   728: ldc_w 302
    //   731: iconst_0
    //   732: anewarray 4	java/lang/Object
    //   735: invokestatic 306	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   738: aload 5
    //   740: astore 4
    //   742: ldc 53
    //   744: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   747: aload 5
    //   749: astore 4
    //   751: aload 7
    //   753: athrow
    //   754: astore 7
    //   756: aload 4
    //   758: astore 5
    //   760: aload 7
    //   762: astore 4
    //   764: aload 5
    //   766: ifnull +8 -> 774
    //   769: aload 5
    //   771: invokevirtual 240	java/io/DataOutputStream:close	()V
    //   774: ldc 53
    //   776: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   779: aload 4
    //   781: athrow
    //   782: astore 5
    //   784: ldc 73
    //   786: ldc_w 300
    //   789: iconst_1
    //   790: anewarray 4	java/lang/Object
    //   793: dup
    //   794: iconst_0
    //   795: aload_0
    //   796: invokeinterface 78 1 0
    //   801: aastore
    //   802: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   805: ldc 73
    //   807: aload 5
    //   809: ldc_w 302
    //   812: iconst_0
    //   813: anewarray 4	java/lang/Object
    //   816: invokestatic 306	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   819: goto -45 -> 774
    //   822: astore_0
    //   823: ldc 73
    //   825: aload_0
    //   826: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   829: invokestatic 313	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   832: goto -388 -> 444
    //   835: astore_0
    //   836: goto -387 -> 449
    //   839: astore 5
    //   841: ldc 73
    //   843: aload 5
    //   845: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   848: invokestatic 313	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   851: goto -243 -> 608
    //   854: astore 4
    //   856: goto -243 -> 613
    //   859: aload 4
    //   861: ifnull +16 -> 877
    //   864: aload 4
    //   866: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   869: invokevirtual 98	java/io/InputStream:close	()V
    //   872: aload 4
    //   874: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
    //   877: ldc 53
    //   879: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   882: aload 6
    //   884: areturn
    //   885: astore_0
    //   886: ldc 73
    //   888: aload_0
    //   889: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   892: invokestatic 313	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   895: goto -23 -> 872
    //   898: astore_0
    //   899: goto -22 -> 877
    //   902: astore 5
    //   904: ldc 73
    //   906: aload 5
    //   908: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   911: invokestatic 313	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   914: goto -857 -> 57
    //   917: astore 4
    //   919: goto -857 -> 62
    //   922: astore 5
    //   924: ldc 73
    //   926: aload 5
    //   928: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   931: invokestatic 313	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   934: goto -256 -> 678
    //   937: astore 4
    //   939: goto -256 -> 683
    //   942: astore 4
    //   944: aload 5
    //   946: astore 4
    //   948: goto -666 -> 282
    //   951: astore_0
    //   952: aconst_null
    //   953: astore 4
    //   955: goto -290 -> 665
    //   958: astore_0
    //   959: goto -294 -> 665
    //   962: astore 5
    //   964: aconst_null
    //   965: astore 4
    //   967: goto -443 -> 524
    //   970: astore 4
    //   972: aconst_null
    //   973: astore 5
    //   975: goto -211 -> 764
    //   978: astore 7
    //   980: goto -285 -> 695
    //   983: astore 4
    //   985: goto -494 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	988	0	parame	e
    //   159	312	1	l	long
    //   194	294	3	bool	boolean
    //   44	565	4	localObject1	Object
    //   620	26	4	localIOException1	IOException
    //   663	117	4	localObject2	Object
    //   854	19	4	localException1	Exception
    //   917	1	4	localException2	Exception
    //   937	1	4	localException3	Exception
    //   942	1	4	localException4	Exception
    //   946	20	4	localObject3	Object
    //   970	1	4	localObject4	Object
    //   983	1	4	localException5	Exception
    //   250	165	5	localObject5	Object
    //   518	72	5	localException6	Exception
    //   693	77	5	localObject6	Object
    //   782	26	5	localIOException2	IOException
    //   839	5	5	localException7	Exception
    //   902	5	5	localException8	Exception
    //   922	23	5	localException9	Exception
    //   962	1	5	localException10	Exception
    //   973	1	5	localObject7	Object
    //   107	776	6	localObject8	Object
    //   243	249	7	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    //   690	62	7	localIOException3	IOException
    //   754	7	7	localObject9	Object
    //   978	1	7	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   109	187	518	java/lang/Exception
    //   195	252	518	java/lang/Exception
    //   261	268	518	java/lang/Exception
    //   311	390	518	java/lang/Exception
    //   414	419	518	java/lang/Exception
    //   419	431	518	java/lang/Exception
    //   457	486	518	java/lang/Exception
    //   491	515	518	java/lang/Exception
    //   622	657	518	java/lang/Exception
    //   769	774	518	java/lang/Exception
    //   774	782	518	java/lang/Exception
    //   784	819	518	java/lang/Exception
    //   414	419	620	java/io/IOException
    //   109	187	660	finally
    //   195	252	660	finally
    //   261	268	660	finally
    //   277	282	660	finally
    //   287	311	660	finally
    //   311	390	660	finally
    //   414	419	660	finally
    //   419	431	660	finally
    //   457	486	660	finally
    //   491	515	660	finally
    //   622	657	660	finally
    //   769	774	660	finally
    //   774	782	660	finally
    //   784	819	660	finally
    //   390	404	690	java/io/IOException
    //   408	414	754	finally
    //   699	720	754	finally
    //   724	738	754	finally
    //   742	747	754	finally
    //   751	754	754	finally
    //   769	774	782	java/io/IOException
    //   436	444	822	java/lang/Exception
    //   444	449	835	java/lang/Exception
    //   823	832	835	java/lang/Exception
    //   600	608	839	java/lang/Exception
    //   608	613	854	java/lang/Exception
    //   841	851	854	java/lang/Exception
    //   864	872	885	java/lang/Exception
    //   872	877	898	java/lang/Exception
    //   886	895	898	java/lang/Exception
    //   49	57	902	java/lang/Exception
    //   57	62	917	java/lang/Exception
    //   904	914	917	java/lang/Exception
    //   670	678	922	java/lang/Exception
    //   678	683	937	java/lang/Exception
    //   924	934	937	java/lang/Exception
    //   277	282	942	java/lang/Exception
    //   62	81	951	finally
    //   81	109	951	finally
    //   524	532	958	finally
    //   537	595	958	finally
    //   62	81	962	java/lang/Exception
    //   81	109	962	java/lang/Exception
    //   390	404	970	finally
    //   408	414	978	java/io/IOException
    //   287	311	983	java/lang/Exception
  }
  
  private static m a(e parame, Exception paramException)
  {
    AppMethodBeat.i(79585);
    int i = -1;
    Object localObject = paramException;
    if ((paramException instanceof f))
    {
      i = ((f)paramException).httpStatusCode;
      localObject = ((f)paramException).vOc;
    }
    ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", new Object[] { parame.dlZ(), localObject });
    parame = new m(parame, (Exception)localObject, i, 3);
    AppMethodBeat.o(79585);
    return parame;
  }
  
  /* Error */
  private static m a(e parame, HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 334
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 73
    //   8: ldc_w 336
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokeinterface 78 1 0
    //   23: aastore
    //   24: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   54: invokevirtual 339	java/net/HttpURLConnection:getResponseCode	()I
    //   57: istore 11
    //   59: aload_1
    //   60: invokevirtual 342	java/net/HttpURLConnection:getContentLength	()I
    //   63: istore 12
    //   65: aload_1
    //   66: invokevirtual 345	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   69: astore 36
    //   71: aload_1
    //   72: invokevirtual 348	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   75: astore 35
    //   77: ldc_w 350
    //   80: aload_1
    //   81: ldc_w 352
    //   84: invokevirtual 356	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   87: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifeq +154 -> 244
    //   93: iconst_1
    //   94: istore 14
    //   96: ldc 73
    //   98: ldc_w 358
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
    //   119: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: aastore
    //   123: dup
    //   124: iconst_2
    //   125: iload 12
    //   127: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
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
    //   153: invokevirtual 367	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   156: invokestatic 373	com/tencent/mm/pluginsdk/g/a/d/b:aR	(Ljava/util/Map;)Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_0
    //   164: invokeinterface 65 1 0
    //   169: invokestatic 136	com/tencent/mm/pluginsdk/g/a/d/a:eG	(Ljava/lang/String;)J
    //   172: lstore 16
    //   174: iload 12
    //   176: ifne +99 -> 275
    //   179: sipush 206
    //   182: iload 11
    //   184: if_icmpne +91 -> 275
    //   187: lload 16
    //   189: lconst_0
    //   190: lcmp
    //   191: ifle +84 -> 275
    //   194: ldc 73
    //   196: ldc_w 375
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_0
    //   206: invokeinterface 78 1 0
    //   211: aastore
    //   212: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: new 328	com/tencent/mm/pluginsdk/g/a/c/m
    //   218: dup
    //   219: aload_0
    //   220: lload 16
    //   222: aload 35
    //   224: invokespecial 378	com/tencent/mm/pluginsdk/g/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/g/a/c/e;JLjava/lang/String;)V
    //   227: astore_1
    //   228: aconst_null
    //   229: invokestatic 381	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   232: aconst_null
    //   233: invokestatic 381	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   236: ldc_w 334
    //   239: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload_1
    //   243: areturn
    //   244: aload_1
    //   245: ldc_w 383
    //   248: invokevirtual 356	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   251: astore 20
    //   253: aload 20
    //   255: ifnull +1623 -> 1878
    //   258: aload 20
    //   260: ldc_w 350
    //   263: invokevirtual 386	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   266: ifeq +1612 -> 1878
    //   269: iconst_1
    //   270: istore 14
    //   272: goto -176 -> 96
    //   275: iload 12
    //   277: ifne +98 -> 375
    //   280: new 34	com/tencent/mm/pluginsdk/g/a/b/g
    //   283: dup
    //   284: invokespecial 387	com/tencent/mm/pluginsdk/g/a/b/g:<init>	()V
    //   287: astore_1
    //   288: ldc_w 334
    //   291: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload_1
    //   295: athrow
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_1
    //   299: aload 29
    //   301: astore 21
    //   303: iload_3
    //   304: istore 4
    //   306: aload 21
    //   308: astore 22
    //   310: aload_1
    //   311: astore 20
    //   313: ldc_w 334
    //   316: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: iload_3
    //   320: istore 4
    //   322: aload 21
    //   324: astore 22
    //   326: aload_1
    //   327: astore 20
    //   329: aload_0
    //   330: athrow
    //   331: astore_0
    //   332: aload 20
    //   334: astore_1
    //   335: iload 4
    //   337: istore_3
    //   338: aload_1
    //   339: invokestatic 381	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   342: aload 22
    //   344: invokestatic 381	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   347: iload_3
    //   348: ifle +19 -> 367
    //   351: getstatic 393	com/tencent/mm/model/ao$a:flJ	Lcom/tencent/mm/model/ao$e;
    //   354: ifnull +13 -> 367
    //   357: getstatic 393	com/tencent/mm/model/ao$a:flJ	Lcom/tencent/mm/model/ao$e;
    //   360: iload_3
    //   361: iconst_0
    //   362: invokeinterface 399 3 0
    //   367: ldc_w 334
    //   370: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   373: aload_0
    //   374: athrow
    //   375: aload_0
    //   376: invokeinterface 402 1 0
    //   381: ifne +59 -> 440
    //   384: iload 12
    //   386: ifge +54 -> 440
    //   389: new 38	java/net/SocketException
    //   392: dup
    //   393: invokespecial 403	java/net/SocketException:<init>	()V
    //   396: astore_1
    //   397: ldc_w 334
    //   400: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: aload_1
    //   404: athrow
    //   405: astore_0
    //   406: aconst_null
    //   407: astore_1
    //   408: aload 30
    //   410: astore 21
    //   412: iload_3
    //   413: istore 4
    //   415: aload 21
    //   417: astore 22
    //   419: aload_1
    //   420: astore 20
    //   422: ldc_w 334
    //   425: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   428: iload_3
    //   429: istore 4
    //   431: aload 21
    //   433: astore 22
    //   435: aload_1
    //   436: astore 20
    //   438: aload_0
    //   439: athrow
    //   440: iload 12
    //   442: ifle +127 -> 569
    //   445: iload 12
    //   447: i2l
    //   448: lstore 18
    //   450: aload_0
    //   451: lload 18
    //   453: invokeinterface 407 3 0
    //   458: ifne +111 -> 569
    //   461: new 30	com/tencent/mm/pluginsdk/g/a/b/a
    //   464: dup
    //   465: invokespecial 408	com/tencent/mm/pluginsdk/g/a/b/a:<init>	()V
    //   468: astore_1
    //   469: ldc_w 334
    //   472: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: aload_1
    //   476: athrow
    //   477: astore 21
    //   479: aconst_null
    //   480: astore_1
    //   481: aload 31
    //   483: astore 23
    //   485: iload_3
    //   486: istore 4
    //   488: aload 23
    //   490: astore 22
    //   492: aload_1
    //   493: astore 20
    //   495: ldc 73
    //   497: ldc_w 410
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: aload_0
    //   507: invokeinterface 78 1 0
    //   512: aastore
    //   513: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   516: iload_3
    //   517: istore 4
    //   519: aload 23
    //   521: astore 22
    //   523: aload_1
    //   524: astore 20
    //   526: ldc 73
    //   528: aload 21
    //   530: ldc_w 302
    //   533: iconst_0
    //   534: anewarray 4	java/lang/Object
    //   537: invokestatic 306	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   540: iload_3
    //   541: istore 4
    //   543: aload 23
    //   545: astore 22
    //   547: aload_1
    //   548: astore 20
    //   550: ldc_w 334
    //   553: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: iload_3
    //   557: istore 4
    //   559: aload 23
    //   561: astore 22
    //   563: aload_1
    //   564: astore 20
    //   566: aload 21
    //   568: athrow
    //   569: sipush 416
    //   572: iload 11
    //   574: if_icmpne +109 -> 683
    //   577: new 412	com/tencent/mm/pluginsdk/g/a/b/b
    //   580: dup
    //   581: iload 12
    //   583: i2l
    //   584: lload 16
    //   586: invokespecial 415	com/tencent/mm/pluginsdk/g/a/b/b:<init>	(JJ)V
    //   589: astore_1
    //   590: ldc_w 334
    //   593: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: aload_1
    //   597: athrow
    //   598: astore 21
    //   600: aconst_null
    //   601: astore_1
    //   602: aload 32
    //   604: astore 23
    //   606: iload_3
    //   607: istore 4
    //   609: aload 23
    //   611: astore 22
    //   613: aload_1
    //   614: astore 20
    //   616: ldc 73
    //   618: new 247	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   625: aload_0
    //   626: invokeinterface 78 1 0
    //   631: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: ldc_w 418
    //   637: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: aload 21
    //   642: invokevirtual 419	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   645: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 313	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: iload_3
    //   655: istore 4
    //   657: aload 23
    //   659: astore 22
    //   661: aload_1
    //   662: astore 20
    //   664: ldc_w 334
    //   667: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   670: iload_3
    //   671: istore 4
    //   673: aload 23
    //   675: astore 22
    //   677: aload_1
    //   678: astore 20
    //   680: aload 21
    //   682: athrow
    //   683: new 421	java/io/BufferedInputStream
    //   686: dup
    //   687: aload_1
    //   688: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   691: invokespecial 424	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   694: astore 21
    //   696: iload_3
    //   697: istore 4
    //   699: aload 34
    //   701: astore 22
    //   703: aload 21
    //   705: astore 20
    //   707: aload 21
    //   709: astore_1
    //   710: aload 21
    //   712: astore 23
    //   714: aload 21
    //   716: astore 24
    //   718: aload 21
    //   720: astore 25
    //   722: aload 21
    //   724: astore 26
    //   726: aload 21
    //   728: astore 27
    //   730: aload 36
    //   732: invokestatic 71	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   735: ifne +89 -> 824
    //   738: iload_3
    //   739: istore 4
    //   741: aload 34
    //   743: astore 22
    //   745: aload 21
    //   747: astore 20
    //   749: aload 21
    //   751: astore_1
    //   752: aload 21
    //   754: astore 23
    //   756: aload 21
    //   758: astore 24
    //   760: aload 21
    //   762: astore 25
    //   764: aload 21
    //   766: astore 26
    //   768: aload 21
    //   770: astore 27
    //   772: aload 36
    //   774: ldc_w 426
    //   777: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   780: ifeq +44 -> 824
    //   783: iload_3
    //   784: istore 4
    //   786: aload 34
    //   788: astore 22
    //   790: aload 21
    //   792: astore 20
    //   794: aload 21
    //   796: astore 23
    //   798: aload 21
    //   800: astore 24
    //   802: aload 21
    //   804: astore 25
    //   806: aload 21
    //   808: astore 26
    //   810: aload 21
    //   812: astore 27
    //   814: new 428	java/util/zip/GZIPInputStream
    //   817: dup
    //   818: aload 21
    //   820: invokespecial 429	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   823: astore_1
    //   824: iload_3
    //   825: istore 4
    //   827: aload 34
    //   829: astore 22
    //   831: aload_1
    //   832: astore 20
    //   834: aload_1
    //   835: astore 23
    //   837: aload_1
    //   838: astore 24
    //   840: aload_1
    //   841: astore 25
    //   843: aload_1
    //   844: astore 26
    //   846: aload_1
    //   847: astore 27
    //   849: aload_0
    //   850: invokeinterface 65 1 0
    //   855: astore 21
    //   857: iload_3
    //   858: istore 4
    //   860: aload 34
    //   862: astore 22
    //   864: aload_1
    //   865: astore 20
    //   867: aload_1
    //   868: astore 23
    //   870: aload_1
    //   871: astore 24
    //   873: aload_1
    //   874: astore 25
    //   876: aload_1
    //   877: astore 26
    //   879: aload_1
    //   880: astore 27
    //   882: aload_0
    //   883: invokeinterface 78 1 0
    //   888: astore 36
    //   890: iload_2
    //   891: ifeq +1004 -> 1895
    //   894: iload 14
    //   896: ifeq +999 -> 1895
    //   899: iconst_1
    //   900: istore 15
    //   902: iload_3
    //   903: istore 4
    //   905: aload 34
    //   907: astore 22
    //   909: aload_1
    //   910: astore 20
    //   912: aload_1
    //   913: astore 23
    //   915: aload_1
    //   916: astore 24
    //   918: aload_1
    //   919: astore 25
    //   921: aload_1
    //   922: astore 26
    //   924: aload_1
    //   925: astore 27
    //   927: ldc 73
    //   929: ldc_w 431
    //   932: iconst_2
    //   933: anewarray 4	java/lang/Object
    //   936: dup
    //   937: iconst_0
    //   938: aload 36
    //   940: aastore
    //   941: dup
    //   942: iconst_1
    //   943: aload 21
    //   945: aastore
    //   946: invokestatic 200	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   949: iload_3
    //   950: istore 4
    //   952: aload 34
    //   954: astore 22
    //   956: aload_1
    //   957: astore 20
    //   959: aload_1
    //   960: astore 23
    //   962: aload_1
    //   963: astore 24
    //   965: aload_1
    //   966: astore 25
    //   968: aload_1
    //   969: astore 26
    //   971: aload_1
    //   972: astore 27
    //   974: aload 21
    //   976: invokestatic 71	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   979: ifeq +111 -> 1090
    //   982: iload_3
    //   983: istore 4
    //   985: aload 34
    //   987: astore 22
    //   989: aload_1
    //   990: astore 20
    //   992: aload_1
    //   993: astore 23
    //   995: aload_1
    //   996: astore 24
    //   998: aload_1
    //   999: astore 25
    //   1001: aload_1
    //   1002: astore 26
    //   1004: aload_1
    //   1005: astore 27
    //   1007: new 28	java/io/FileNotFoundException
    //   1010: dup
    //   1011: ldc_w 433
    //   1014: iconst_1
    //   1015: anewarray 4	java/lang/Object
    //   1018: dup
    //   1019: iconst_0
    //   1020: aload 36
    //   1022: aastore
    //   1023: invokestatic 437	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1026: invokespecial 438	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   1029: astore 21
    //   1031: iload_3
    //   1032: istore 4
    //   1034: aload 34
    //   1036: astore 22
    //   1038: aload_1
    //   1039: astore 20
    //   1041: aload_1
    //   1042: astore 23
    //   1044: aload_1
    //   1045: astore 24
    //   1047: aload_1
    //   1048: astore 25
    //   1050: aload_1
    //   1051: astore 26
    //   1053: aload_1
    //   1054: astore 27
    //   1056: ldc_w 334
    //   1059: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1062: iload_3
    //   1063: istore 4
    //   1065: aload 34
    //   1067: astore 22
    //   1069: aload_1
    //   1070: astore 20
    //   1072: aload_1
    //   1073: astore 23
    //   1075: aload_1
    //   1076: astore 24
    //   1078: aload_1
    //   1079: astore 25
    //   1081: aload_1
    //   1082: astore 26
    //   1084: aload_1
    //   1085: astore 27
    //   1087: aload 21
    //   1089: athrow
    //   1090: iload_3
    //   1091: istore 4
    //   1093: aload 34
    //   1095: astore 22
    //   1097: aload_1
    //   1098: astore 20
    //   1100: aload_1
    //   1101: astore 23
    //   1103: aload_1
    //   1104: astore 24
    //   1106: aload_1
    //   1107: astore 25
    //   1109: aload_1
    //   1110: astore 26
    //   1112: aload_1
    //   1113: astore 27
    //   1115: new 440	java/io/BufferedOutputStream
    //   1118: dup
    //   1119: new 442	java/io/FileOutputStream
    //   1122: dup
    //   1123: aload 21
    //   1125: iload 15
    //   1127: invokespecial 445	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   1130: invokespecial 446	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1133: astore 21
    //   1135: iload_3
    //   1136: istore 4
    //   1138: iload_3
    //   1139: istore 5
    //   1141: iload_3
    //   1142: istore 6
    //   1144: iload_3
    //   1145: istore 7
    //   1147: iload_3
    //   1148: istore 8
    //   1150: iload_3
    //   1151: istore 9
    //   1153: iload_3
    //   1154: istore 10
    //   1156: ldc 73
    //   1158: ldc_w 448
    //   1161: iconst_3
    //   1162: anewarray 4	java/lang/Object
    //   1165: dup
    //   1166: iconst_0
    //   1167: aload_0
    //   1168: invokeinterface 78 1 0
    //   1173: aastore
    //   1174: dup
    //   1175: iconst_1
    //   1176: iload_2
    //   1177: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1180: aastore
    //   1181: dup
    //   1182: iconst_2
    //   1183: iload 14
    //   1185: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1188: aastore
    //   1189: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1192: iload_3
    //   1193: istore 4
    //   1195: iload_3
    //   1196: istore 5
    //   1198: iload_3
    //   1199: istore 6
    //   1201: iload_3
    //   1202: istore 7
    //   1204: iload_3
    //   1205: istore 8
    //   1207: iload_3
    //   1208: istore 9
    //   1210: iload_3
    //   1211: istore 10
    //   1213: sipush 16384
    //   1216: newarray byte
    //   1218: astore 20
    //   1220: iconst_0
    //   1221: istore_3
    //   1222: iload_3
    //   1223: istore 4
    //   1225: iload_3
    //   1226: istore 5
    //   1228: iload_3
    //   1229: istore 6
    //   1231: iload_3
    //   1232: istore 7
    //   1234: iload_3
    //   1235: istore 8
    //   1237: iload_3
    //   1238: istore 9
    //   1240: iload_3
    //   1241: istore 10
    //   1243: aload_1
    //   1244: aload 20
    //   1246: iconst_0
    //   1247: sipush 16384
    //   1250: invokevirtual 452	java/io/InputStream:read	([BII)I
    //   1253: istore 13
    //   1255: iload 13
    //   1257: iconst_m1
    //   1258: if_icmpeq +66 -> 1324
    //   1261: iload_3
    //   1262: istore 4
    //   1264: iload_3
    //   1265: istore 5
    //   1267: iload_3
    //   1268: istore 6
    //   1270: iload_3
    //   1271: istore 7
    //   1273: iload_3
    //   1274: istore 8
    //   1276: iload_3
    //   1277: istore 9
    //   1279: iload_3
    //   1280: istore 10
    //   1282: aload 21
    //   1284: aload 20
    //   1286: iconst_0
    //   1287: iload 13
    //   1289: invokevirtual 457	java/io/OutputStream:write	([BII)V
    //   1292: iload_3
    //   1293: iload 13
    //   1295: iadd
    //   1296: istore_3
    //   1297: iload_3
    //   1298: istore 4
    //   1300: iload_3
    //   1301: istore 5
    //   1303: iload_3
    //   1304: istore 6
    //   1306: iload_3
    //   1307: istore 7
    //   1309: iload_3
    //   1310: istore 8
    //   1312: iload_3
    //   1313: istore 9
    //   1315: iload_3
    //   1316: istore 10
    //   1318: invokestatic 113	com/tencent/mm/pluginsdk/g/a/c/j:dmx	()V
    //   1321: goto -99 -> 1222
    //   1324: iload_3
    //   1325: istore 4
    //   1327: iload_3
    //   1328: istore 5
    //   1330: iload_3
    //   1331: istore 6
    //   1333: iload_3
    //   1334: istore 7
    //   1336: iload_3
    //   1337: istore 8
    //   1339: iload_3
    //   1340: istore 9
    //   1342: iload_3
    //   1343: istore 10
    //   1345: ldc 73
    //   1347: ldc_w 459
    //   1350: iconst_2
    //   1351: anewarray 4	java/lang/Object
    //   1354: dup
    //   1355: iconst_0
    //   1356: aload_0
    //   1357: invokeinterface 78 1 0
    //   1362: aastore
    //   1363: dup
    //   1364: iconst_1
    //   1365: iload_3
    //   1366: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1369: aastore
    //   1370: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1373: iload_3
    //   1374: istore 4
    //   1376: iload_3
    //   1377: istore 5
    //   1379: iload_3
    //   1380: istore 6
    //   1382: iload_3
    //   1383: istore 7
    //   1385: iload_3
    //   1386: istore 8
    //   1388: iload_3
    //   1389: istore 9
    //   1391: iload_3
    //   1392: istore 10
    //   1394: aload 21
    //   1396: invokevirtual 462	java/io/OutputStream:flush	()V
    //   1399: iload_3
    //   1400: istore 4
    //   1402: iload_3
    //   1403: istore 5
    //   1405: iload_3
    //   1406: istore 6
    //   1408: iload_3
    //   1409: istore 7
    //   1411: iload_3
    //   1412: istore 8
    //   1414: iload_3
    //   1415: istore 9
    //   1417: iload_3
    //   1418: istore 10
    //   1420: ldc 73
    //   1422: ldc_w 464
    //   1425: iconst_1
    //   1426: anewarray 4	java/lang/Object
    //   1429: dup
    //   1430: iconst_0
    //   1431: aload_0
    //   1432: invokeinterface 78 1 0
    //   1437: aastore
    //   1438: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1441: iload_3
    //   1442: istore 4
    //   1444: iload_3
    //   1445: istore 5
    //   1447: iload_3
    //   1448: istore 6
    //   1450: iload_3
    //   1451: istore 7
    //   1453: iload_3
    //   1454: istore 8
    //   1456: iload_3
    //   1457: istore 9
    //   1459: iload_3
    //   1460: istore 10
    //   1462: aload_0
    //   1463: invokeinterface 402 1 0
    //   1468: ifeq +83 -> 1551
    //   1471: iload_3
    //   1472: istore 4
    //   1474: iload_3
    //   1475: istore 5
    //   1477: iload_3
    //   1478: istore 6
    //   1480: iload_3
    //   1481: istore 7
    //   1483: iload_3
    //   1484: istore 8
    //   1486: iload_3
    //   1487: istore 9
    //   1489: iload_3
    //   1490: istore 10
    //   1492: new 328	com/tencent/mm/pluginsdk/g/a/c/m
    //   1495: dup
    //   1496: aload_0
    //   1497: aload_0
    //   1498: invokeinterface 65 1 0
    //   1503: invokestatic 136	com/tencent/mm/pluginsdk/g/a/d/a:eG	(Ljava/lang/String;)J
    //   1506: aload 35
    //   1508: invokespecial 378	com/tencent/mm/pluginsdk/g/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/g/a/c/e;JLjava/lang/String;)V
    //   1511: astore 20
    //   1513: aload_1
    //   1514: invokestatic 381	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1517: aload 21
    //   1519: invokestatic 381	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1522: iload_3
    //   1523: ifle +19 -> 1542
    //   1526: getstatic 393	com/tencent/mm/model/ao$a:flJ	Lcom/tencent/mm/model/ao$e;
    //   1529: ifnull +13 -> 1542
    //   1532: getstatic 393	com/tencent/mm/model/ao$a:flJ	Lcom/tencent/mm/model/ao$e;
    //   1535: iload_3
    //   1536: iconst_0
    //   1537: invokeinterface 399 3 0
    //   1542: ldc_w 334
    //   1545: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1548: aload 20
    //   1550: areturn
    //   1551: iload_3
    //   1552: istore 4
    //   1554: iload_3
    //   1555: istore 5
    //   1557: iload_3
    //   1558: istore 6
    //   1560: iload_3
    //   1561: istore 7
    //   1563: iload_3
    //   1564: istore 8
    //   1566: iload_3
    //   1567: istore 9
    //   1569: iload_3
    //   1570: istore 10
    //   1572: new 328	com/tencent/mm/pluginsdk/g/a/c/m
    //   1575: dup
    //   1576: aload_0
    //   1577: iload 12
    //   1579: i2l
    //   1580: aload 35
    //   1582: invokespecial 378	com/tencent/mm/pluginsdk/g/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/g/a/c/e;JLjava/lang/String;)V
    //   1585: astore 20
    //   1587: aload_1
    //   1588: invokestatic 381	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1591: aload 21
    //   1593: invokestatic 381	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1596: iload_3
    //   1597: ifle +19 -> 1616
    //   1600: getstatic 393	com/tencent/mm/model/ao$a:flJ	Lcom/tencent/mm/model/ao$e;
    //   1603: ifnull +13 -> 1616
    //   1606: getstatic 393	com/tencent/mm/model/ao$a:flJ	Lcom/tencent/mm/model/ao$e;
    //   1609: iload_3
    //   1610: iconst_0
    //   1611: invokeinterface 399 3 0
    //   1616: ldc_w 334
    //   1619: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1622: aload 20
    //   1624: areturn
    //   1625: astore_0
    //   1626: aconst_null
    //   1627: astore_1
    //   1628: aload 33
    //   1630: astore 21
    //   1632: iload_3
    //   1633: istore 4
    //   1635: aload 21
    //   1637: astore 22
    //   1639: aload_1
    //   1640: astore 20
    //   1642: ldc_w 334
    //   1645: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1648: iload_3
    //   1649: istore 4
    //   1651: aload 21
    //   1653: astore 22
    //   1655: aload_1
    //   1656: astore 20
    //   1658: aload_0
    //   1659: athrow
    //   1660: astore 20
    //   1662: iconst_m1
    //   1663: istore 11
    //   1665: aconst_null
    //   1666: astore_1
    //   1667: aload 28
    //   1669: astore 22
    //   1671: aload_1
    //   1672: invokestatic 381	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1675: ldc 73
    //   1677: ldc_w 466
    //   1680: iconst_2
    //   1681: anewarray 4	java/lang/Object
    //   1684: dup
    //   1685: iconst_0
    //   1686: aload_0
    //   1687: invokeinterface 78 1 0
    //   1692: aastore
    //   1693: dup
    //   1694: iconst_1
    //   1695: aload 20
    //   1697: aastore
    //   1698: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1701: new 316	com/tencent/mm/pluginsdk/g/a/b/f
    //   1704: dup
    //   1705: iload 11
    //   1707: aload 20
    //   1709: invokespecial 469	com/tencent/mm/pluginsdk/g/a/b/f:<init>	(ILjava/io/IOException;)V
    //   1712: astore_0
    //   1713: ldc_w 334
    //   1716: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1719: aload_0
    //   1720: athrow
    //   1721: astore_0
    //   1722: goto -1384 -> 338
    //   1725: astore_0
    //   1726: aconst_null
    //   1727: astore_1
    //   1728: goto -1390 -> 338
    //   1731: astore_0
    //   1732: iload 4
    //   1734: istore_3
    //   1735: aload 21
    //   1737: astore 22
    //   1739: goto -1401 -> 338
    //   1742: astore 20
    //   1744: aconst_null
    //   1745: astore_1
    //   1746: aload 28
    //   1748: astore 22
    //   1750: goto -79 -> 1671
    //   1753: astore 20
    //   1755: aload 21
    //   1757: astore_1
    //   1758: aload 28
    //   1760: astore 22
    //   1762: goto -91 -> 1671
    //   1765: astore 20
    //   1767: aload 28
    //   1769: astore 22
    //   1771: goto -100 -> 1671
    //   1774: astore 20
    //   1776: iload 5
    //   1778: istore_3
    //   1779: aload 21
    //   1781: astore 22
    //   1783: goto -112 -> 1671
    //   1786: astore_0
    //   1787: aload 33
    //   1789: astore 21
    //   1791: aload 23
    //   1793: astore_1
    //   1794: goto -162 -> 1632
    //   1797: astore_0
    //   1798: iload 6
    //   1800: istore_3
    //   1801: goto -169 -> 1632
    //   1804: astore 21
    //   1806: aload 32
    //   1808: astore 23
    //   1810: aload 24
    //   1812: astore_1
    //   1813: goto -1207 -> 606
    //   1816: astore 20
    //   1818: aload 21
    //   1820: astore 23
    //   1822: aload 20
    //   1824: astore 21
    //   1826: iload 7
    //   1828: istore_3
    //   1829: goto -1223 -> 606
    //   1832: astore 21
    //   1834: aload 31
    //   1836: astore 23
    //   1838: aload 25
    //   1840: astore_1
    //   1841: goto -1356 -> 485
    //   1844: astore 20
    //   1846: aload 21
    //   1848: astore 23
    //   1850: aload 20
    //   1852: astore 21
    //   1854: iload 8
    //   1856: istore_3
    //   1857: goto -1372 -> 485
    //   1860: astore_0
    //   1861: aload 30
    //   1863: astore 21
    //   1865: aload 26
    //   1867: astore_1
    //   1868: goto -1456 -> 412
    //   1871: astore_0
    //   1872: iload 9
    //   1874: istore_3
    //   1875: goto -1463 -> 412
    //   1878: iconst_0
    //   1879: istore 14
    //   1881: goto -1785 -> 96
    //   1884: astore_0
    //   1885: aload 29
    //   1887: astore 21
    //   1889: aload 27
    //   1891: astore_1
    //   1892: goto -1589 -> 303
    //   1895: iconst_0
    //   1896: istore 15
    //   1898: goto -996 -> 902
    //   1901: astore_0
    //   1902: iload 10
    //   1904: istore_3
    //   1905: goto -1602 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1908	0	parame	e
    //   0	1908	1	paramHttpURLConnection	HttpURLConnection
    //   0	1908	2	paramBoolean	boolean
    //   52	1853	3	i	int
    //   304	1429	4	j	int
    //   1139	638	5	k	int
    //   1142	657	6	m	int
    //   1145	682	7	n	int
    //   1148	707	8	i1	int
    //   1151	722	9	i2	int
    //   1154	749	10	i3	int
    //   57	1649	11	i4	int
    //   63	1515	12	i5	int
    //   1253	43	13	i6	int
    //   94	1786	14	bool1	boolean
    //   900	997	15	bool2	boolean
    //   172	413	16	l1	long
    //   448	4	18	l2	long
    //   251	1406	20	localObject1	Object
    //   1660	48	20	localIOException1	IOException
    //   1742	1	20	localIOException2	IOException
    //   1753	1	20	localIOException3	IOException
    //   1765	1	20	localIOException4	IOException
    //   1774	1	20	localIOException5	IOException
    //   1816	7	20	localSocketException1	SocketException
    //   1844	7	20	localSSLHandshakeException1	javax.net.ssl.SSLHandshakeException
    //   301	131	21	localObject2	Object
    //   477	90	21	localSSLHandshakeException2	javax.net.ssl.SSLHandshakeException
    //   598	83	21	localSocketException2	SocketException
    //   694	1096	21	localObject3	Object
    //   1804	15	21	localSocketException3	SocketException
    //   1824	1	21	localSocketException4	SocketException
    //   1832	15	21	localSSLHandshakeException3	javax.net.ssl.SSLHandshakeException
    //   1852	36	21	localObject4	Object
    //   31	1751	22	localObject5	Object
    //   483	1366	23	localObject6	Object
    //   716	1095	24	localObject7	Object
    //   720	1119	25	localObject8	Object
    //   724	1142	26	localObject9	Object
    //   728	1162	27	localObject10	Object
    //   46	1722	28	localObject11	Object
    //   49	1837	29	localObject12	Object
    //   34	1828	30	localObject13	Object
    //   37	1798	31	localObject14	Object
    //   40	1767	32	localObject15	Object
    //   43	1745	33	localObject16	Object
    //   28	1066	34	localObject17	Object
    //   75	1506	35	str1	String
    //   69	952	36	str2	String
    // Exception table:
    //   from	to	target	type
    //   53	59	296	java/lang/InterruptedException
    //   59	93	296	java/lang/InterruptedException
    //   96	174	296	java/lang/InterruptedException
    //   194	228	296	java/lang/InterruptedException
    //   244	253	296	java/lang/InterruptedException
    //   258	269	296	java/lang/InterruptedException
    //   280	296	296	java/lang/InterruptedException
    //   375	384	296	java/lang/InterruptedException
    //   389	405	296	java/lang/InterruptedException
    //   450	477	296	java/lang/InterruptedException
    //   577	598	296	java/lang/InterruptedException
    //   683	696	296	java/lang/InterruptedException
    //   313	319	331	finally
    //   329	331	331	finally
    //   422	428	331	finally
    //   438	440	331	finally
    //   495	516	331	finally
    //   526	540	331	finally
    //   550	556	331	finally
    //   566	569	331	finally
    //   616	654	331	finally
    //   664	670	331	finally
    //   680	683	331	finally
    //   730	738	331	finally
    //   772	783	331	finally
    //   814	824	331	finally
    //   849	857	331	finally
    //   882	890	331	finally
    //   927	949	331	finally
    //   974	982	331	finally
    //   1007	1031	331	finally
    //   1056	1062	331	finally
    //   1087	1090	331	finally
    //   1115	1135	331	finally
    //   1642	1648	331	finally
    //   1658	1660	331	finally
    //   53	59	405	java/net/UnknownHostException
    //   59	93	405	java/net/UnknownHostException
    //   96	174	405	java/net/UnknownHostException
    //   194	228	405	java/net/UnknownHostException
    //   244	253	405	java/net/UnknownHostException
    //   258	269	405	java/net/UnknownHostException
    //   280	296	405	java/net/UnknownHostException
    //   375	384	405	java/net/UnknownHostException
    //   389	405	405	java/net/UnknownHostException
    //   450	477	405	java/net/UnknownHostException
    //   577	598	405	java/net/UnknownHostException
    //   683	696	405	java/net/UnknownHostException
    //   53	59	477	javax/net/ssl/SSLHandshakeException
    //   59	93	477	javax/net/ssl/SSLHandshakeException
    //   96	174	477	javax/net/ssl/SSLHandshakeException
    //   194	228	477	javax/net/ssl/SSLHandshakeException
    //   244	253	477	javax/net/ssl/SSLHandshakeException
    //   258	269	477	javax/net/ssl/SSLHandshakeException
    //   280	296	477	javax/net/ssl/SSLHandshakeException
    //   375	384	477	javax/net/ssl/SSLHandshakeException
    //   389	405	477	javax/net/ssl/SSLHandshakeException
    //   450	477	477	javax/net/ssl/SSLHandshakeException
    //   577	598	477	javax/net/ssl/SSLHandshakeException
    //   683	696	477	javax/net/ssl/SSLHandshakeException
    //   53	59	598	java/net/SocketException
    //   59	93	598	java/net/SocketException
    //   96	174	598	java/net/SocketException
    //   194	228	598	java/net/SocketException
    //   244	253	598	java/net/SocketException
    //   258	269	598	java/net/SocketException
    //   280	296	598	java/net/SocketException
    //   375	384	598	java/net/SocketException
    //   389	405	598	java/net/SocketException
    //   450	477	598	java/net/SocketException
    //   577	598	598	java/net/SocketException
    //   683	696	598	java/net/SocketException
    //   53	59	1625	java/net/SocketTimeoutException
    //   59	93	1625	java/net/SocketTimeoutException
    //   96	174	1625	java/net/SocketTimeoutException
    //   194	228	1625	java/net/SocketTimeoutException
    //   244	253	1625	java/net/SocketTimeoutException
    //   258	269	1625	java/net/SocketTimeoutException
    //   280	296	1625	java/net/SocketTimeoutException
    //   375	384	1625	java/net/SocketTimeoutException
    //   389	405	1625	java/net/SocketTimeoutException
    //   450	477	1625	java/net/SocketTimeoutException
    //   577	598	1625	java/net/SocketTimeoutException
    //   683	696	1625	java/net/SocketTimeoutException
    //   53	59	1660	java/io/IOException
    //   1671	1721	1721	finally
    //   53	59	1725	finally
    //   59	93	1725	finally
    //   96	174	1725	finally
    //   194	228	1725	finally
    //   244	253	1725	finally
    //   258	269	1725	finally
    //   280	296	1725	finally
    //   375	384	1725	finally
    //   389	405	1725	finally
    //   450	477	1725	finally
    //   577	598	1725	finally
    //   683	696	1725	finally
    //   1156	1192	1731	finally
    //   1213	1220	1731	finally
    //   1243	1255	1731	finally
    //   1282	1292	1731	finally
    //   1318	1321	1731	finally
    //   1345	1373	1731	finally
    //   1394	1399	1731	finally
    //   1420	1441	1731	finally
    //   1462	1471	1731	finally
    //   1492	1513	1731	finally
    //   1572	1587	1731	finally
    //   59	93	1742	java/io/IOException
    //   96	174	1742	java/io/IOException
    //   194	228	1742	java/io/IOException
    //   244	253	1742	java/io/IOException
    //   258	269	1742	java/io/IOException
    //   280	296	1742	java/io/IOException
    //   375	384	1742	java/io/IOException
    //   389	405	1742	java/io/IOException
    //   450	477	1742	java/io/IOException
    //   577	598	1742	java/io/IOException
    //   683	696	1742	java/io/IOException
    //   730	738	1753	java/io/IOException
    //   772	783	1753	java/io/IOException
    //   814	824	1753	java/io/IOException
    //   849	857	1765	java/io/IOException
    //   882	890	1765	java/io/IOException
    //   927	949	1765	java/io/IOException
    //   974	982	1765	java/io/IOException
    //   1007	1031	1765	java/io/IOException
    //   1056	1062	1765	java/io/IOException
    //   1087	1090	1765	java/io/IOException
    //   1115	1135	1765	java/io/IOException
    //   1156	1192	1774	java/io/IOException
    //   1213	1220	1774	java/io/IOException
    //   1243	1255	1774	java/io/IOException
    //   1282	1292	1774	java/io/IOException
    //   1318	1321	1774	java/io/IOException
    //   1345	1373	1774	java/io/IOException
    //   1394	1399	1774	java/io/IOException
    //   1420	1441	1774	java/io/IOException
    //   1462	1471	1774	java/io/IOException
    //   1492	1513	1774	java/io/IOException
    //   1572	1587	1774	java/io/IOException
    //   730	738	1786	java/net/SocketTimeoutException
    //   772	783	1786	java/net/SocketTimeoutException
    //   814	824	1786	java/net/SocketTimeoutException
    //   849	857	1786	java/net/SocketTimeoutException
    //   882	890	1786	java/net/SocketTimeoutException
    //   927	949	1786	java/net/SocketTimeoutException
    //   974	982	1786	java/net/SocketTimeoutException
    //   1007	1031	1786	java/net/SocketTimeoutException
    //   1056	1062	1786	java/net/SocketTimeoutException
    //   1087	1090	1786	java/net/SocketTimeoutException
    //   1115	1135	1786	java/net/SocketTimeoutException
    //   1156	1192	1797	java/net/SocketTimeoutException
    //   1213	1220	1797	java/net/SocketTimeoutException
    //   1243	1255	1797	java/net/SocketTimeoutException
    //   1282	1292	1797	java/net/SocketTimeoutException
    //   1318	1321	1797	java/net/SocketTimeoutException
    //   1345	1373	1797	java/net/SocketTimeoutException
    //   1394	1399	1797	java/net/SocketTimeoutException
    //   1420	1441	1797	java/net/SocketTimeoutException
    //   1462	1471	1797	java/net/SocketTimeoutException
    //   1492	1513	1797	java/net/SocketTimeoutException
    //   1572	1587	1797	java/net/SocketTimeoutException
    //   730	738	1804	java/net/SocketException
    //   772	783	1804	java/net/SocketException
    //   814	824	1804	java/net/SocketException
    //   849	857	1804	java/net/SocketException
    //   882	890	1804	java/net/SocketException
    //   927	949	1804	java/net/SocketException
    //   974	982	1804	java/net/SocketException
    //   1007	1031	1804	java/net/SocketException
    //   1056	1062	1804	java/net/SocketException
    //   1087	1090	1804	java/net/SocketException
    //   1115	1135	1804	java/net/SocketException
    //   1156	1192	1816	java/net/SocketException
    //   1213	1220	1816	java/net/SocketException
    //   1243	1255	1816	java/net/SocketException
    //   1282	1292	1816	java/net/SocketException
    //   1318	1321	1816	java/net/SocketException
    //   1345	1373	1816	java/net/SocketException
    //   1394	1399	1816	java/net/SocketException
    //   1420	1441	1816	java/net/SocketException
    //   1462	1471	1816	java/net/SocketException
    //   1492	1513	1816	java/net/SocketException
    //   1572	1587	1816	java/net/SocketException
    //   730	738	1832	javax/net/ssl/SSLHandshakeException
    //   772	783	1832	javax/net/ssl/SSLHandshakeException
    //   814	824	1832	javax/net/ssl/SSLHandshakeException
    //   849	857	1832	javax/net/ssl/SSLHandshakeException
    //   882	890	1832	javax/net/ssl/SSLHandshakeException
    //   927	949	1832	javax/net/ssl/SSLHandshakeException
    //   974	982	1832	javax/net/ssl/SSLHandshakeException
    //   1007	1031	1832	javax/net/ssl/SSLHandshakeException
    //   1056	1062	1832	javax/net/ssl/SSLHandshakeException
    //   1087	1090	1832	javax/net/ssl/SSLHandshakeException
    //   1115	1135	1832	javax/net/ssl/SSLHandshakeException
    //   1156	1192	1844	javax/net/ssl/SSLHandshakeException
    //   1213	1220	1844	javax/net/ssl/SSLHandshakeException
    //   1243	1255	1844	javax/net/ssl/SSLHandshakeException
    //   1282	1292	1844	javax/net/ssl/SSLHandshakeException
    //   1318	1321	1844	javax/net/ssl/SSLHandshakeException
    //   1345	1373	1844	javax/net/ssl/SSLHandshakeException
    //   1394	1399	1844	javax/net/ssl/SSLHandshakeException
    //   1420	1441	1844	javax/net/ssl/SSLHandshakeException
    //   1462	1471	1844	javax/net/ssl/SSLHandshakeException
    //   1492	1513	1844	javax/net/ssl/SSLHandshakeException
    //   1572	1587	1844	javax/net/ssl/SSLHandshakeException
    //   730	738	1860	java/net/UnknownHostException
    //   772	783	1860	java/net/UnknownHostException
    //   814	824	1860	java/net/UnknownHostException
    //   849	857	1860	java/net/UnknownHostException
    //   882	890	1860	java/net/UnknownHostException
    //   927	949	1860	java/net/UnknownHostException
    //   974	982	1860	java/net/UnknownHostException
    //   1007	1031	1860	java/net/UnknownHostException
    //   1056	1062	1860	java/net/UnknownHostException
    //   1087	1090	1860	java/net/UnknownHostException
    //   1115	1135	1860	java/net/UnknownHostException
    //   1156	1192	1871	java/net/UnknownHostException
    //   1213	1220	1871	java/net/UnknownHostException
    //   1243	1255	1871	java/net/UnknownHostException
    //   1282	1292	1871	java/net/UnknownHostException
    //   1318	1321	1871	java/net/UnknownHostException
    //   1345	1373	1871	java/net/UnknownHostException
    //   1394	1399	1871	java/net/UnknownHostException
    //   1420	1441	1871	java/net/UnknownHostException
    //   1462	1471	1871	java/net/UnknownHostException
    //   1492	1513	1871	java/net/UnknownHostException
    //   1572	1587	1871	java/net/UnknownHostException
    //   730	738	1884	java/lang/InterruptedException
    //   772	783	1884	java/lang/InterruptedException
    //   814	824	1884	java/lang/InterruptedException
    //   849	857	1884	java/lang/InterruptedException
    //   882	890	1884	java/lang/InterruptedException
    //   927	949	1884	java/lang/InterruptedException
    //   974	982	1884	java/lang/InterruptedException
    //   1007	1031	1884	java/lang/InterruptedException
    //   1056	1062	1884	java/lang/InterruptedException
    //   1087	1090	1884	java/lang/InterruptedException
    //   1115	1135	1884	java/lang/InterruptedException
    //   1156	1192	1901	java/lang/InterruptedException
    //   1213	1220	1901	java/lang/InterruptedException
    //   1243	1255	1901	java/lang/InterruptedException
    //   1282	1292	1901	java/lang/InterruptedException
    //   1318	1321	1901	java/lang/InterruptedException
    //   1345	1373	1901	java/lang/InterruptedException
    //   1394	1399	1901	java/lang/InterruptedException
    //   1420	1441	1901	java/lang/InterruptedException
    //   1462	1471	1901	java/lang/InterruptedException
    //   1492	1513	1901	java/lang/InterruptedException
    //   1572	1587	1901	java/lang/InterruptedException
  }
  
  private static void a(e parame, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(79582);
    ab.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", new Object[] { parame.dlZ() });
    Object localObject = parame.dmu();
    if ((localObject != null) && (((Collection)localObject).size() > 0))
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        paramHttpURLConnection.addRequestProperty(localb.name, localb.value);
      }
    }
    paramHttpURLConnection.setRequestMethod(parame.dmt());
    if ("GET".equalsIgnoreCase(parame.dmt())) {
      paramHttpURLConnection.setDoOutput(false);
    }
    paramHttpURLConnection.setConnectTimeout(parame.getConnectTimeout());
    paramHttpURLConnection.setReadTimeout(parame.getReadTimeout());
    paramHttpURLConnection.setUseCaches(false);
    if (parame.avT()) {
      paramHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
    }
    for (;;)
    {
      parame = System.getProperty("http.agent");
      if (!bo.isNullOrNil(parame)) {
        paramHttpURLConnection.setRequestProperty("User-agent", parame);
      }
      paramHttpURLConnection.setInstanceFollowRedirects(true);
      AppMethodBeat.o(79582);
      return;
      paramHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
  }
  
  private static SSLContext aku(String paramString)
  {
    AppMethodBeat.i(79583);
    try
    {
      paramString = SSLContext.getInstance(paramString);
      AppMethodBeat.o(79583);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(79583);
    }
    return null;
  }
  
  private static m b(e parame, Exception paramException)
  {
    AppMethodBeat.i(79586);
    if ((paramException instanceof ProtocolException))
    {
      ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", new Object[] { parame.dlZ(), parame.dmt() });
      parame = a(parame, paramException);
      AppMethodBeat.o(79586);
      return parame;
    }
    if ((paramException instanceof com.tencent.mm.pluginsdk.g.a.b.b))
    {
      ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", new Object[] { parame.dlZ(), paramException.getClass().getSimpleName(), paramException.getMessage() });
      com.tencent.mm.pluginsdk.g.a.d.a.alT(parame.getFilePath());
      AppMethodBeat.o(79586);
      return null;
    }
    Class[] arrayOfClass = vOp;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].equals(paramException.getClass()))
      {
        ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", new Object[] { parame.dlZ(), paramException });
        parame = new m(parame, paramException, 4);
        AppMethodBeat.o(79586);
        return parame;
      }
      i += 1;
    }
    arrayOfClass = vOr;
    j = arrayOfClass.length;
    i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].equals(paramException.getClass()))
      {
        AppMethodBeat.o(79586);
        return null;
      }
      i += 1;
    }
    arrayOfClass = vOq;
    j = arrayOfClass.length;
    i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].equals(paramException.getClass()))
      {
        parame = a(parame, paramException);
        AppMethodBeat.o(79586);
        return parame;
      }
      i += 1;
    }
    parame = a(parame, paramException);
    AppMethodBeat.o(79586);
    return parame;
  }
  
  private static void dmx()
  {
    AppMethodBeat.i(79581);
    if (Thread.interrupted())
    {
      InterruptedException localInterruptedException = new InterruptedException(Thread.currentThread().getName() + " has interrupted by someone!");
      AppMethodBeat.o(79581);
      throw localInterruptedException;
    }
    AppMethodBeat.o(79581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.j
 * JD-Core Version:    0.7.0.1
 */