package com.tencent.mm.pluginsdk.h.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.b.d;
import com.tencent.mm.pluginsdk.h.a.b.f;
import com.tencent.mm.pluginsdk.h.a.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final Class[] DlF = { InterruptedException.class };
  private static final Class[] DlG = { UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, com.tencent.mm.pluginsdk.h.a.b.a.class, d.class, g.class };
  private static final Class[] DlH = { SocketException.class, SocketTimeoutException.class };
  private boolean DlE = false;
  
  /* Error */
  static m a(e parame)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokeinterface 65 1 0
    //   11: invokestatic 71	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
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
    //   34: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   77: invokestatic 110	com/tencent/mm/pluginsdk/h/a/d/a:aGL	(Ljava/lang/String;)Z
    //   80: pop
    //   81: invokestatic 113	com/tencent/mm/pluginsdk/h/a/c/j:eMd	()V
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
    //   135: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: invokestatic 113	com/tencent/mm/pluginsdk/h/a/c/j:eMd	()V
    //   141: aload_0
    //   142: aload 6
    //   144: invokestatic 132	com/tencent/mm/pluginsdk/h/a/c/j:a	(Lcom/tencent/mm/pluginsdk/h/a/c/e;Ljava/net/HttpURLConnection;)V
    //   147: invokestatic 113	com/tencent/mm/pluginsdk/h/a/c/j:eMd	()V
    //   150: aload_0
    //   151: invokeinterface 65 1 0
    //   156: invokestatic 136	com/tencent/mm/pluginsdk/h/a/d/a:fD	(Ljava/lang/String;)J
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
    //   184: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   219: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: invokestatic 113	com/tencent/mm/pluginsdk/h/a/c/j:eMd	()V
    //   225: ldc 153
    //   227: aload 4
    //   229: invokevirtual 156	java/net/URL:getProtocol	()Ljava/lang/String;
    //   232: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   235: ifeq +76 -> 311
    //   238: aload 6
    //   240: checkcast 163	javax/net/ssl/HttpsURLConnection
    //   243: astore 7
    //   245: ldc 165
    //   247: invokestatic 169	com/tencent/mm/pluginsdk/h/a/c/j:aFe	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   250: astore 5
    //   252: aload 5
    //   254: astore 4
    //   256: aload 5
    //   258: ifnonnull +24 -> 282
    //   261: ldc 171
    //   263: invokestatic 169	com/tencent/mm/pluginsdk/h/a/c/j:aFe	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
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
    //   311: invokestatic 113	com/tencent/mm/pluginsdk/h/a/c/j:eMd	()V
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
    //   340: invokestatic 200	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: ldc 202
    //   345: aload_0
    //   346: invokeinterface 197 1 0
    //   351: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   354: ifeq +65 -> 419
    //   357: aconst_null
    //   358: invokestatic 210	com/tencent/mm/sdk/platformtools/bs:cv	([B)Z
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
    //   419: invokestatic 113	com/tencent/mm/pluginsdk/h/a/c/j:eMd	()V
    //   422: aload_0
    //   423: aload 6
    //   425: iload_3
    //   426: invokestatic 243	com/tencent/mm/pluginsdk/h/a/c/j:a	(Lcom/tencent/mm/pluginsdk/h/a/c/e;Ljava/net/HttpURLConnection;Z)Lcom/tencent/mm/pluginsdk/h/a/c/m;
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
    //   503: invokestatic 277	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   506: invokespecial 280	android/net/SSLSessionCache:<init>	(Landroid/content/Context;)V
    //   509: invokestatic 285	android/net/SSLCertificateSocketFactory:getDefault	(ILandroid/net/SSLSessionCache;)Ljavax/net/ssl/SSLSocketFactory;
    //   512: invokevirtual 192	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   515: goto -204 -> 311
    //   518: astore 5
    //   520: aload 6
    //   522: astore 4
    //   524: aload_0
    //   525: aload 5
    //   527: invokestatic 289	com/tencent/mm/pluginsdk/h/a/c/j:b	(Lcom/tencent/mm/pluginsdk/h/a/c/e;Ljava/lang/Exception;)Lcom/tencent/mm/pluginsdk/h/a/c/m;
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
    //   555: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   585: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   588: aload_0
    //   589: aload 5
    //   591: invokestatic 298	com/tencent/mm/pluginsdk/h/a/c/j:a	(Lcom/tencent/mm/pluginsdk/h/a/c/e;Ljava/lang/Exception;)Lcom/tencent/mm/pluginsdk/h/a/c/m;
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
    //   640: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   643: ldc 73
    //   645: aload 4
    //   647: ldc_w 302
    //   650: iconst_0
    //   651: anewarray 4	java/lang/Object
    //   654: invokestatic 306	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   717: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   720: aload 5
    //   722: astore 4
    //   724: ldc 73
    //   726: aload 7
    //   728: ldc_w 302
    //   731: iconst_0
    //   732: anewarray 4	java/lang/Object
    //   735: invokestatic 306	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   802: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   805: ldc 73
    //   807: aload 5
    //   809: ldc_w 302
    //   812: iconst_0
    //   813: anewarray 4	java/lang/Object
    //   816: invokestatic 306	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   819: goto -45 -> 774
    //   822: astore_0
    //   823: ldc 73
    //   825: aload_0
    //   826: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   829: invokestatic 313	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   832: goto -388 -> 444
    //   835: astore_0
    //   836: goto -387 -> 449
    //   839: astore 5
    //   841: ldc 73
    //   843: aload 5
    //   845: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   848: invokestatic 313	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   892: invokestatic 313	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   895: goto -23 -> 872
    //   898: astore_0
    //   899: goto -22 -> 877
    //   902: astore 5
    //   904: ldc 73
    //   906: aload 5
    //   908: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   911: invokestatic 313	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   914: goto -857 -> 57
    //   917: astore 4
    //   919: goto -857 -> 62
    //   922: astore 5
    //   924: ldc 73
    //   926: aload 5
    //   928: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   931: invokestatic 313	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    AppMethodBeat.i(152028);
    int i = -1;
    Object localObject = paramException;
    if ((paramException instanceof f))
    {
      i = ((f)paramException).httpStatusCode;
      localObject = ((f)paramException).Dls;
    }
    ac.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", new Object[] { parame.eLF(), localObject });
    parame = new m(parame, (Exception)localObject, i, 3);
    AppMethodBeat.o(152028);
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
    //   24: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   156: invokestatic 373	com/tencent/mm/pluginsdk/h/a/d/b:bD	(Ljava/util/Map;)Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_0
    //   164: invokeinterface 65 1 0
    //   169: invokestatic 136	com/tencent/mm/pluginsdk/h/a/d/a:fD	(Ljava/lang/String;)J
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
    //   212: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: new 328	com/tencent/mm/pluginsdk/h/a/c/m
    //   218: dup
    //   219: aload_0
    //   220: lload 16
    //   222: aload 35
    //   224: invokespecial 378	com/tencent/mm/pluginsdk/h/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/h/a/c/e;JLjava/lang/String;)V
    //   227: astore_1
    //   228: aconst_null
    //   229: invokestatic 382	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   232: aconst_null
    //   233: invokestatic 382	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   236: ldc_w 334
    //   239: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload_1
    //   243: areturn
    //   244: aload_1
    //   245: ldc_w 384
    //   248: invokevirtual 356	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   251: astore 20
    //   253: aload 20
    //   255: ifnull +1619 -> 1874
    //   258: aload 20
    //   260: ldc_w 350
    //   263: invokevirtual 387	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   266: ifeq +1608 -> 1874
    //   269: iconst_1
    //   270: istore 14
    //   272: goto -176 -> 96
    //   275: iload 12
    //   277: ifne +98 -> 375
    //   280: new 34	com/tencent/mm/pluginsdk/h/a/b/g
    //   283: dup
    //   284: invokespecial 388	com/tencent/mm/pluginsdk/h/a/b/g:<init>	()V
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
    //   339: invokestatic 382	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   342: aload 22
    //   344: invokestatic 382	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   347: iload_3
    //   348: ifle +19 -> 367
    //   351: getstatic 394	com/tencent/mm/model/ar$a:hnx	Lcom/tencent/mm/model/ar$e;
    //   354: ifnull +13 -> 367
    //   357: getstatic 394	com/tencent/mm/model/ar$a:hnx	Lcom/tencent/mm/model/ar$e;
    //   360: iload_3
    //   361: iconst_0
    //   362: invokeinterface 400 3 0
    //   367: ldc_w 334
    //   370: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   373: aload_0
    //   374: athrow
    //   375: aload_0
    //   376: invokeinterface 403 1 0
    //   381: ifne +59 -> 440
    //   384: iload 12
    //   386: ifge +54 -> 440
    //   389: new 38	java/net/SocketException
    //   392: dup
    //   393: invokespecial 404	java/net/SocketException:<init>	()V
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
    //   453: invokeinterface 408 3 0
    //   458: ifne +111 -> 569
    //   461: new 30	com/tencent/mm/pluginsdk/h/a/b/a
    //   464: dup
    //   465: invokespecial 409	com/tencent/mm/pluginsdk/h/a/b/a:<init>	()V
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
    //   497: ldc_w 411
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: aload_0
    //   507: invokeinterface 78 1 0
    //   512: aastore
    //   513: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   537: invokestatic 306	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   577: new 413	com/tencent/mm/pluginsdk/h/a/b/b
    //   580: dup
    //   581: iload 12
    //   583: i2l
    //   584: lload 16
    //   586: invokespecial 416	com/tencent/mm/pluginsdk/h/a/b/b:<init>	(JJ)V
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
    //   622: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   625: aload_0
    //   626: invokeinterface 78 1 0
    //   631: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: ldc_w 419
    //   637: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: aload 21
    //   642: invokevirtual 420	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   645: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 313	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   683: new 422	java/io/BufferedInputStream
    //   686: dup
    //   687: aload_1
    //   688: invokevirtual 93	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   691: invokespecial 425	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   732: invokestatic 71	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
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
    //   774: ldc_w 427
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
    //   814: new 429	java/util/zip/GZIPInputStream
    //   817: dup
    //   818: aload 21
    //   820: invokespecial 430	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   891: ifeq +1000 -> 1891
    //   894: iload 14
    //   896: ifeq +995 -> 1891
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
    //   929: ldc_w 432
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
    //   946: invokestatic 200	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   976: invokestatic 71	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
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
    //   1011: ldc_w 434
    //   1014: iconst_1
    //   1015: anewarray 4	java/lang/Object
    //   1018: dup
    //   1019: iconst_0
    //   1020: aload 36
    //   1022: aastore
    //   1023: invokestatic 438	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1026: invokespecial 439	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
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
    //   1115: new 441	java/io/BufferedOutputStream
    //   1118: dup
    //   1119: aload 21
    //   1121: iload 15
    //   1123: invokestatic 447	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   1126: invokespecial 448	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1129: astore 21
    //   1131: iload_3
    //   1132: istore 4
    //   1134: iload_3
    //   1135: istore 5
    //   1137: iload_3
    //   1138: istore 6
    //   1140: iload_3
    //   1141: istore 7
    //   1143: iload_3
    //   1144: istore 8
    //   1146: iload_3
    //   1147: istore 9
    //   1149: iload_3
    //   1150: istore 10
    //   1152: ldc 73
    //   1154: ldc_w 450
    //   1157: iconst_3
    //   1158: anewarray 4	java/lang/Object
    //   1161: dup
    //   1162: iconst_0
    //   1163: aload_0
    //   1164: invokeinterface 78 1 0
    //   1169: aastore
    //   1170: dup
    //   1171: iconst_1
    //   1172: iload_2
    //   1173: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1176: aastore
    //   1177: dup
    //   1178: iconst_2
    //   1179: iload 14
    //   1181: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1184: aastore
    //   1185: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1188: iload_3
    //   1189: istore 4
    //   1191: iload_3
    //   1192: istore 5
    //   1194: iload_3
    //   1195: istore 6
    //   1197: iload_3
    //   1198: istore 7
    //   1200: iload_3
    //   1201: istore 8
    //   1203: iload_3
    //   1204: istore 9
    //   1206: iload_3
    //   1207: istore 10
    //   1209: sipush 16384
    //   1212: newarray byte
    //   1214: astore 20
    //   1216: iconst_0
    //   1217: istore_3
    //   1218: iload_3
    //   1219: istore 4
    //   1221: iload_3
    //   1222: istore 5
    //   1224: iload_3
    //   1225: istore 6
    //   1227: iload_3
    //   1228: istore 7
    //   1230: iload_3
    //   1231: istore 8
    //   1233: iload_3
    //   1234: istore 9
    //   1236: iload_3
    //   1237: istore 10
    //   1239: aload_1
    //   1240: aload 20
    //   1242: iconst_0
    //   1243: sipush 16384
    //   1246: invokevirtual 454	java/io/InputStream:read	([BII)I
    //   1249: istore 13
    //   1251: iload 13
    //   1253: iconst_m1
    //   1254: if_icmpeq +66 -> 1320
    //   1257: iload_3
    //   1258: istore 4
    //   1260: iload_3
    //   1261: istore 5
    //   1263: iload_3
    //   1264: istore 6
    //   1266: iload_3
    //   1267: istore 7
    //   1269: iload_3
    //   1270: istore 8
    //   1272: iload_3
    //   1273: istore 9
    //   1275: iload_3
    //   1276: istore 10
    //   1278: aload 21
    //   1280: aload 20
    //   1282: iconst_0
    //   1283: iload 13
    //   1285: invokevirtual 459	java/io/OutputStream:write	([BII)V
    //   1288: iload_3
    //   1289: iload 13
    //   1291: iadd
    //   1292: istore_3
    //   1293: iload_3
    //   1294: istore 4
    //   1296: iload_3
    //   1297: istore 5
    //   1299: iload_3
    //   1300: istore 6
    //   1302: iload_3
    //   1303: istore 7
    //   1305: iload_3
    //   1306: istore 8
    //   1308: iload_3
    //   1309: istore 9
    //   1311: iload_3
    //   1312: istore 10
    //   1314: invokestatic 113	com/tencent/mm/pluginsdk/h/a/c/j:eMd	()V
    //   1317: goto -99 -> 1218
    //   1320: iload_3
    //   1321: istore 4
    //   1323: iload_3
    //   1324: istore 5
    //   1326: iload_3
    //   1327: istore 6
    //   1329: iload_3
    //   1330: istore 7
    //   1332: iload_3
    //   1333: istore 8
    //   1335: iload_3
    //   1336: istore 9
    //   1338: iload_3
    //   1339: istore 10
    //   1341: ldc 73
    //   1343: ldc_w 461
    //   1346: iconst_2
    //   1347: anewarray 4	java/lang/Object
    //   1350: dup
    //   1351: iconst_0
    //   1352: aload_0
    //   1353: invokeinterface 78 1 0
    //   1358: aastore
    //   1359: dup
    //   1360: iconst_1
    //   1361: iload_3
    //   1362: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1365: aastore
    //   1366: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1369: iload_3
    //   1370: istore 4
    //   1372: iload_3
    //   1373: istore 5
    //   1375: iload_3
    //   1376: istore 6
    //   1378: iload_3
    //   1379: istore 7
    //   1381: iload_3
    //   1382: istore 8
    //   1384: iload_3
    //   1385: istore 9
    //   1387: iload_3
    //   1388: istore 10
    //   1390: aload 21
    //   1392: invokevirtual 464	java/io/OutputStream:flush	()V
    //   1395: iload_3
    //   1396: istore 4
    //   1398: iload_3
    //   1399: istore 5
    //   1401: iload_3
    //   1402: istore 6
    //   1404: iload_3
    //   1405: istore 7
    //   1407: iload_3
    //   1408: istore 8
    //   1410: iload_3
    //   1411: istore 9
    //   1413: iload_3
    //   1414: istore 10
    //   1416: ldc 73
    //   1418: ldc_w 466
    //   1421: iconst_1
    //   1422: anewarray 4	java/lang/Object
    //   1425: dup
    //   1426: iconst_0
    //   1427: aload_0
    //   1428: invokeinterface 78 1 0
    //   1433: aastore
    //   1434: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1437: iload_3
    //   1438: istore 4
    //   1440: iload_3
    //   1441: istore 5
    //   1443: iload_3
    //   1444: istore 6
    //   1446: iload_3
    //   1447: istore 7
    //   1449: iload_3
    //   1450: istore 8
    //   1452: iload_3
    //   1453: istore 9
    //   1455: iload_3
    //   1456: istore 10
    //   1458: aload_0
    //   1459: invokeinterface 403 1 0
    //   1464: ifeq +83 -> 1547
    //   1467: iload_3
    //   1468: istore 4
    //   1470: iload_3
    //   1471: istore 5
    //   1473: iload_3
    //   1474: istore 6
    //   1476: iload_3
    //   1477: istore 7
    //   1479: iload_3
    //   1480: istore 8
    //   1482: iload_3
    //   1483: istore 9
    //   1485: iload_3
    //   1486: istore 10
    //   1488: new 328	com/tencent/mm/pluginsdk/h/a/c/m
    //   1491: dup
    //   1492: aload_0
    //   1493: aload_0
    //   1494: invokeinterface 65 1 0
    //   1499: invokestatic 136	com/tencent/mm/pluginsdk/h/a/d/a:fD	(Ljava/lang/String;)J
    //   1502: aload 35
    //   1504: invokespecial 378	com/tencent/mm/pluginsdk/h/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/h/a/c/e;JLjava/lang/String;)V
    //   1507: astore 20
    //   1509: aload_1
    //   1510: invokestatic 382	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   1513: aload 21
    //   1515: invokestatic 382	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   1518: iload_3
    //   1519: ifle +19 -> 1538
    //   1522: getstatic 394	com/tencent/mm/model/ar$a:hnx	Lcom/tencent/mm/model/ar$e;
    //   1525: ifnull +13 -> 1538
    //   1528: getstatic 394	com/tencent/mm/model/ar$a:hnx	Lcom/tencent/mm/model/ar$e;
    //   1531: iload_3
    //   1532: iconst_0
    //   1533: invokeinterface 400 3 0
    //   1538: ldc_w 334
    //   1541: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1544: aload 20
    //   1546: areturn
    //   1547: iload_3
    //   1548: istore 4
    //   1550: iload_3
    //   1551: istore 5
    //   1553: iload_3
    //   1554: istore 6
    //   1556: iload_3
    //   1557: istore 7
    //   1559: iload_3
    //   1560: istore 8
    //   1562: iload_3
    //   1563: istore 9
    //   1565: iload_3
    //   1566: istore 10
    //   1568: new 328	com/tencent/mm/pluginsdk/h/a/c/m
    //   1571: dup
    //   1572: aload_0
    //   1573: iload 12
    //   1575: i2l
    //   1576: aload 35
    //   1578: invokespecial 378	com/tencent/mm/pluginsdk/h/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/h/a/c/e;JLjava/lang/String;)V
    //   1581: astore 20
    //   1583: aload_1
    //   1584: invokestatic 382	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   1587: aload 21
    //   1589: invokestatic 382	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   1592: iload_3
    //   1593: ifle +19 -> 1612
    //   1596: getstatic 394	com/tencent/mm/model/ar$a:hnx	Lcom/tencent/mm/model/ar$e;
    //   1599: ifnull +13 -> 1612
    //   1602: getstatic 394	com/tencent/mm/model/ar$a:hnx	Lcom/tencent/mm/model/ar$e;
    //   1605: iload_3
    //   1606: iconst_0
    //   1607: invokeinterface 400 3 0
    //   1612: ldc_w 334
    //   1615: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1618: aload 20
    //   1620: areturn
    //   1621: astore_0
    //   1622: aconst_null
    //   1623: astore_1
    //   1624: aload 33
    //   1626: astore 21
    //   1628: iload_3
    //   1629: istore 4
    //   1631: aload 21
    //   1633: astore 22
    //   1635: aload_1
    //   1636: astore 20
    //   1638: ldc_w 334
    //   1641: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1644: iload_3
    //   1645: istore 4
    //   1647: aload 21
    //   1649: astore 22
    //   1651: aload_1
    //   1652: astore 20
    //   1654: aload_0
    //   1655: athrow
    //   1656: astore 20
    //   1658: iconst_m1
    //   1659: istore 11
    //   1661: aconst_null
    //   1662: astore_1
    //   1663: aload 28
    //   1665: astore 22
    //   1667: aload_1
    //   1668: invokestatic 382	com/tencent/mm/pluginsdk/h/a/d/a:c	(Ljava/io/Closeable;)V
    //   1671: ldc 73
    //   1673: ldc_w 468
    //   1676: iconst_2
    //   1677: anewarray 4	java/lang/Object
    //   1680: dup
    //   1681: iconst_0
    //   1682: aload_0
    //   1683: invokeinterface 78 1 0
    //   1688: aastore
    //   1689: dup
    //   1690: iconst_1
    //   1691: aload 20
    //   1693: aastore
    //   1694: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1697: new 316	com/tencent/mm/pluginsdk/h/a/b/f
    //   1700: dup
    //   1701: iload 11
    //   1703: aload 20
    //   1705: invokespecial 471	com/tencent/mm/pluginsdk/h/a/b/f:<init>	(ILjava/io/IOException;)V
    //   1708: astore_0
    //   1709: ldc_w 334
    //   1712: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1715: aload_0
    //   1716: athrow
    //   1717: astore_0
    //   1718: goto -1380 -> 338
    //   1721: astore_0
    //   1722: aconst_null
    //   1723: astore_1
    //   1724: goto -1386 -> 338
    //   1727: astore_0
    //   1728: iload 4
    //   1730: istore_3
    //   1731: aload 21
    //   1733: astore 22
    //   1735: goto -1397 -> 338
    //   1738: astore 20
    //   1740: aconst_null
    //   1741: astore_1
    //   1742: aload 28
    //   1744: astore 22
    //   1746: goto -79 -> 1667
    //   1749: astore 20
    //   1751: aload 21
    //   1753: astore_1
    //   1754: aload 28
    //   1756: astore 22
    //   1758: goto -91 -> 1667
    //   1761: astore 20
    //   1763: aload 28
    //   1765: astore 22
    //   1767: goto -100 -> 1667
    //   1770: astore 20
    //   1772: iload 5
    //   1774: istore_3
    //   1775: aload 21
    //   1777: astore 22
    //   1779: goto -112 -> 1667
    //   1782: astore_0
    //   1783: aload 33
    //   1785: astore 21
    //   1787: aload 23
    //   1789: astore_1
    //   1790: goto -162 -> 1628
    //   1793: astore_0
    //   1794: iload 6
    //   1796: istore_3
    //   1797: goto -169 -> 1628
    //   1800: astore 21
    //   1802: aload 32
    //   1804: astore 23
    //   1806: aload 24
    //   1808: astore_1
    //   1809: goto -1203 -> 606
    //   1812: astore 20
    //   1814: aload 21
    //   1816: astore 23
    //   1818: aload 20
    //   1820: astore 21
    //   1822: iload 7
    //   1824: istore_3
    //   1825: goto -1219 -> 606
    //   1828: astore 21
    //   1830: aload 31
    //   1832: astore 23
    //   1834: aload 25
    //   1836: astore_1
    //   1837: goto -1352 -> 485
    //   1840: astore 20
    //   1842: aload 21
    //   1844: astore 23
    //   1846: aload 20
    //   1848: astore 21
    //   1850: iload 8
    //   1852: istore_3
    //   1853: goto -1368 -> 485
    //   1856: astore_0
    //   1857: aload 30
    //   1859: astore 21
    //   1861: aload 26
    //   1863: astore_1
    //   1864: goto -1452 -> 412
    //   1867: astore_0
    //   1868: iload 9
    //   1870: istore_3
    //   1871: goto -1459 -> 412
    //   1874: iconst_0
    //   1875: istore 14
    //   1877: goto -1781 -> 96
    //   1880: astore_0
    //   1881: aload 29
    //   1883: astore 21
    //   1885: aload 27
    //   1887: astore_1
    //   1888: goto -1585 -> 303
    //   1891: iconst_0
    //   1892: istore 15
    //   1894: goto -992 -> 902
    //   1897: astore_0
    //   1898: iload 10
    //   1900: istore_3
    //   1901: goto -1598 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1904	0	parame	e
    //   0	1904	1	paramHttpURLConnection	HttpURLConnection
    //   0	1904	2	paramBoolean	boolean
    //   52	1849	3	i	int
    //   304	1425	4	j	int
    //   1135	638	5	k	int
    //   1138	657	6	m	int
    //   1141	682	7	n	int
    //   1144	707	8	i1	int
    //   1147	722	9	i2	int
    //   1150	749	10	i3	int
    //   57	1645	11	i4	int
    //   63	1511	12	i5	int
    //   1249	43	13	i6	int
    //   94	1782	14	bool1	boolean
    //   900	993	15	bool2	boolean
    //   172	413	16	l1	long
    //   448	4	18	l2	long
    //   251	1402	20	localObject1	Object
    //   1656	48	20	localIOException1	IOException
    //   1738	1	20	localIOException2	IOException
    //   1749	1	20	localIOException3	IOException
    //   1761	1	20	localIOException4	IOException
    //   1770	1	20	localIOException5	IOException
    //   1812	7	20	localSocketException1	SocketException
    //   1840	7	20	localSSLHandshakeException1	javax.net.ssl.SSLHandshakeException
    //   301	131	21	localObject2	Object
    //   477	90	21	localSSLHandshakeException2	javax.net.ssl.SSLHandshakeException
    //   598	83	21	localSocketException2	SocketException
    //   694	1092	21	localObject3	Object
    //   1800	15	21	localSocketException3	SocketException
    //   1820	1	21	localSocketException4	SocketException
    //   1828	15	21	localSSLHandshakeException3	javax.net.ssl.SSLHandshakeException
    //   1848	36	21	localObject4	Object
    //   31	1747	22	localObject5	Object
    //   483	1362	23	localObject6	Object
    //   716	1091	24	localObject7	Object
    //   720	1115	25	localObject8	Object
    //   724	1138	26	localObject9	Object
    //   728	1158	27	localObject10	Object
    //   46	1718	28	localObject11	Object
    //   49	1833	29	localObject12	Object
    //   34	1824	30	localObject13	Object
    //   37	1794	31	localObject14	Object
    //   40	1763	32	localObject15	Object
    //   43	1741	33	localObject16	Object
    //   28	1066	34	localObject17	Object
    //   75	1502	35	str1	String
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
    //   1115	1131	331	finally
    //   1638	1644	331	finally
    //   1654	1656	331	finally
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
    //   53	59	1621	java/net/SocketTimeoutException
    //   59	93	1621	java/net/SocketTimeoutException
    //   96	174	1621	java/net/SocketTimeoutException
    //   194	228	1621	java/net/SocketTimeoutException
    //   244	253	1621	java/net/SocketTimeoutException
    //   258	269	1621	java/net/SocketTimeoutException
    //   280	296	1621	java/net/SocketTimeoutException
    //   375	384	1621	java/net/SocketTimeoutException
    //   389	405	1621	java/net/SocketTimeoutException
    //   450	477	1621	java/net/SocketTimeoutException
    //   577	598	1621	java/net/SocketTimeoutException
    //   683	696	1621	java/net/SocketTimeoutException
    //   53	59	1656	java/io/IOException
    //   1667	1717	1717	finally
    //   53	59	1721	finally
    //   59	93	1721	finally
    //   96	174	1721	finally
    //   194	228	1721	finally
    //   244	253	1721	finally
    //   258	269	1721	finally
    //   280	296	1721	finally
    //   375	384	1721	finally
    //   389	405	1721	finally
    //   450	477	1721	finally
    //   577	598	1721	finally
    //   683	696	1721	finally
    //   1152	1188	1727	finally
    //   1209	1216	1727	finally
    //   1239	1251	1727	finally
    //   1278	1288	1727	finally
    //   1314	1317	1727	finally
    //   1341	1369	1727	finally
    //   1390	1395	1727	finally
    //   1416	1437	1727	finally
    //   1458	1467	1727	finally
    //   1488	1509	1727	finally
    //   1568	1583	1727	finally
    //   59	93	1738	java/io/IOException
    //   96	174	1738	java/io/IOException
    //   194	228	1738	java/io/IOException
    //   244	253	1738	java/io/IOException
    //   258	269	1738	java/io/IOException
    //   280	296	1738	java/io/IOException
    //   375	384	1738	java/io/IOException
    //   389	405	1738	java/io/IOException
    //   450	477	1738	java/io/IOException
    //   577	598	1738	java/io/IOException
    //   683	696	1738	java/io/IOException
    //   730	738	1749	java/io/IOException
    //   772	783	1749	java/io/IOException
    //   814	824	1749	java/io/IOException
    //   849	857	1761	java/io/IOException
    //   882	890	1761	java/io/IOException
    //   927	949	1761	java/io/IOException
    //   974	982	1761	java/io/IOException
    //   1007	1031	1761	java/io/IOException
    //   1056	1062	1761	java/io/IOException
    //   1087	1090	1761	java/io/IOException
    //   1115	1131	1761	java/io/IOException
    //   1152	1188	1770	java/io/IOException
    //   1209	1216	1770	java/io/IOException
    //   1239	1251	1770	java/io/IOException
    //   1278	1288	1770	java/io/IOException
    //   1314	1317	1770	java/io/IOException
    //   1341	1369	1770	java/io/IOException
    //   1390	1395	1770	java/io/IOException
    //   1416	1437	1770	java/io/IOException
    //   1458	1467	1770	java/io/IOException
    //   1488	1509	1770	java/io/IOException
    //   1568	1583	1770	java/io/IOException
    //   730	738	1782	java/net/SocketTimeoutException
    //   772	783	1782	java/net/SocketTimeoutException
    //   814	824	1782	java/net/SocketTimeoutException
    //   849	857	1782	java/net/SocketTimeoutException
    //   882	890	1782	java/net/SocketTimeoutException
    //   927	949	1782	java/net/SocketTimeoutException
    //   974	982	1782	java/net/SocketTimeoutException
    //   1007	1031	1782	java/net/SocketTimeoutException
    //   1056	1062	1782	java/net/SocketTimeoutException
    //   1087	1090	1782	java/net/SocketTimeoutException
    //   1115	1131	1782	java/net/SocketTimeoutException
    //   1152	1188	1793	java/net/SocketTimeoutException
    //   1209	1216	1793	java/net/SocketTimeoutException
    //   1239	1251	1793	java/net/SocketTimeoutException
    //   1278	1288	1793	java/net/SocketTimeoutException
    //   1314	1317	1793	java/net/SocketTimeoutException
    //   1341	1369	1793	java/net/SocketTimeoutException
    //   1390	1395	1793	java/net/SocketTimeoutException
    //   1416	1437	1793	java/net/SocketTimeoutException
    //   1458	1467	1793	java/net/SocketTimeoutException
    //   1488	1509	1793	java/net/SocketTimeoutException
    //   1568	1583	1793	java/net/SocketTimeoutException
    //   730	738	1800	java/net/SocketException
    //   772	783	1800	java/net/SocketException
    //   814	824	1800	java/net/SocketException
    //   849	857	1800	java/net/SocketException
    //   882	890	1800	java/net/SocketException
    //   927	949	1800	java/net/SocketException
    //   974	982	1800	java/net/SocketException
    //   1007	1031	1800	java/net/SocketException
    //   1056	1062	1800	java/net/SocketException
    //   1087	1090	1800	java/net/SocketException
    //   1115	1131	1800	java/net/SocketException
    //   1152	1188	1812	java/net/SocketException
    //   1209	1216	1812	java/net/SocketException
    //   1239	1251	1812	java/net/SocketException
    //   1278	1288	1812	java/net/SocketException
    //   1314	1317	1812	java/net/SocketException
    //   1341	1369	1812	java/net/SocketException
    //   1390	1395	1812	java/net/SocketException
    //   1416	1437	1812	java/net/SocketException
    //   1458	1467	1812	java/net/SocketException
    //   1488	1509	1812	java/net/SocketException
    //   1568	1583	1812	java/net/SocketException
    //   730	738	1828	javax/net/ssl/SSLHandshakeException
    //   772	783	1828	javax/net/ssl/SSLHandshakeException
    //   814	824	1828	javax/net/ssl/SSLHandshakeException
    //   849	857	1828	javax/net/ssl/SSLHandshakeException
    //   882	890	1828	javax/net/ssl/SSLHandshakeException
    //   927	949	1828	javax/net/ssl/SSLHandshakeException
    //   974	982	1828	javax/net/ssl/SSLHandshakeException
    //   1007	1031	1828	javax/net/ssl/SSLHandshakeException
    //   1056	1062	1828	javax/net/ssl/SSLHandshakeException
    //   1087	1090	1828	javax/net/ssl/SSLHandshakeException
    //   1115	1131	1828	javax/net/ssl/SSLHandshakeException
    //   1152	1188	1840	javax/net/ssl/SSLHandshakeException
    //   1209	1216	1840	javax/net/ssl/SSLHandshakeException
    //   1239	1251	1840	javax/net/ssl/SSLHandshakeException
    //   1278	1288	1840	javax/net/ssl/SSLHandshakeException
    //   1314	1317	1840	javax/net/ssl/SSLHandshakeException
    //   1341	1369	1840	javax/net/ssl/SSLHandshakeException
    //   1390	1395	1840	javax/net/ssl/SSLHandshakeException
    //   1416	1437	1840	javax/net/ssl/SSLHandshakeException
    //   1458	1467	1840	javax/net/ssl/SSLHandshakeException
    //   1488	1509	1840	javax/net/ssl/SSLHandshakeException
    //   1568	1583	1840	javax/net/ssl/SSLHandshakeException
    //   730	738	1856	java/net/UnknownHostException
    //   772	783	1856	java/net/UnknownHostException
    //   814	824	1856	java/net/UnknownHostException
    //   849	857	1856	java/net/UnknownHostException
    //   882	890	1856	java/net/UnknownHostException
    //   927	949	1856	java/net/UnknownHostException
    //   974	982	1856	java/net/UnknownHostException
    //   1007	1031	1856	java/net/UnknownHostException
    //   1056	1062	1856	java/net/UnknownHostException
    //   1087	1090	1856	java/net/UnknownHostException
    //   1115	1131	1856	java/net/UnknownHostException
    //   1152	1188	1867	java/net/UnknownHostException
    //   1209	1216	1867	java/net/UnknownHostException
    //   1239	1251	1867	java/net/UnknownHostException
    //   1278	1288	1867	java/net/UnknownHostException
    //   1314	1317	1867	java/net/UnknownHostException
    //   1341	1369	1867	java/net/UnknownHostException
    //   1390	1395	1867	java/net/UnknownHostException
    //   1416	1437	1867	java/net/UnknownHostException
    //   1458	1467	1867	java/net/UnknownHostException
    //   1488	1509	1867	java/net/UnknownHostException
    //   1568	1583	1867	java/net/UnknownHostException
    //   730	738	1880	java/lang/InterruptedException
    //   772	783	1880	java/lang/InterruptedException
    //   814	824	1880	java/lang/InterruptedException
    //   849	857	1880	java/lang/InterruptedException
    //   882	890	1880	java/lang/InterruptedException
    //   927	949	1880	java/lang/InterruptedException
    //   974	982	1880	java/lang/InterruptedException
    //   1007	1031	1880	java/lang/InterruptedException
    //   1056	1062	1880	java/lang/InterruptedException
    //   1087	1090	1880	java/lang/InterruptedException
    //   1115	1131	1880	java/lang/InterruptedException
    //   1152	1188	1897	java/lang/InterruptedException
    //   1209	1216	1897	java/lang/InterruptedException
    //   1239	1251	1897	java/lang/InterruptedException
    //   1278	1288	1897	java/lang/InterruptedException
    //   1314	1317	1897	java/lang/InterruptedException
    //   1341	1369	1897	java/lang/InterruptedException
    //   1390	1395	1897	java/lang/InterruptedException
    //   1416	1437	1897	java/lang/InterruptedException
    //   1458	1467	1897	java/lang/InterruptedException
    //   1488	1509	1897	java/lang/InterruptedException
    //   1568	1583	1897	java/lang/InterruptedException
  }
  
  private static void a(e parame, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(152025);
    ac.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", new Object[] { parame.eLF() });
    Object localObject = parame.eMa();
    if ((localObject != null) && (((Collection)localObject).size() > 0))
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        paramHttpURLConnection.addRequestProperty(localb.name, localb.value);
      }
    }
    paramHttpURLConnection.setRequestMethod(parame.eLZ());
    if ("GET".equalsIgnoreCase(parame.eLZ())) {
      paramHttpURLConnection.setDoOutput(false);
    }
    paramHttpURLConnection.setConnectTimeout(parame.getConnectTimeout());
    paramHttpURLConnection.setReadTimeout(parame.getReadTimeout());
    paramHttpURLConnection.setUseCaches(false);
    if (parame.aXd()) {
      paramHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
    }
    for (;;)
    {
      parame = System.getProperty("http.agent");
      if (!bs.isNullOrNil(parame)) {
        paramHttpURLConnection.setRequestProperty("User-agent", parame);
      }
      paramHttpURLConnection.setInstanceFollowRedirects(true);
      AppMethodBeat.o(152025);
      return;
      paramHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
  }
  
  private static SSLContext aFe(String paramString)
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
  
  private static m b(e parame, Exception paramException)
  {
    AppMethodBeat.i(152029);
    if ((paramException instanceof ProtocolException))
    {
      ac.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", new Object[] { parame.eLF(), parame.eLZ() });
      parame = a(parame, paramException);
      AppMethodBeat.o(152029);
      return parame;
    }
    if ((paramException instanceof com.tencent.mm.pluginsdk.h.a.b.b))
    {
      ac.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", new Object[] { parame.eLF(), paramException.getClass().getSimpleName(), paramException.getMessage() });
      com.tencent.mm.pluginsdk.h.a.d.a.aGL(parame.getFilePath());
      AppMethodBeat.o(152029);
      return null;
    }
    Class[] arrayOfClass = DlF;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].equals(paramException.getClass()))
      {
        ac.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", new Object[] { parame.eLF(), paramException });
        parame = new m(parame, paramException, 4);
        AppMethodBeat.o(152029);
        return parame;
      }
      i += 1;
    }
    arrayOfClass = DlH;
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
    arrayOfClass = DlG;
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
  
  private static void eMd()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.j
 * JD-Core Version:    0.7.0.1
 */