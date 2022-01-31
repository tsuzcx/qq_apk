package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.pluginsdk.g.a.b.d;
import com.tencent.mm.pluginsdk.g.a.b.f;
import com.tencent.mm.pluginsdk.g.a.b.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static final Class[] rXA = { SocketException.class, SocketTimeoutException.class };
  private static final Class[] rXy = { InterruptedException.class };
  private static final Class[] rXz = { UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, com.tencent.mm.pluginsdk.g.a.b.a.class, d.class, g.class };
  private boolean rXx = false;
  
  private static SSLContext UZ(String paramString)
  {
    try
    {
      paramString = SSLContext.getInstance(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  static m a(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +14 -> 15
    //   4: ldc 61
    //   6: ldc 63
    //   8: invokestatic 69	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aconst_null
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: aload_0
    //   16: invokeinterface 75 1 0
    //   21: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   24: ifeq +35 -> 59
    //   27: ldc 61
    //   29: ldc 83
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: invokeinterface 86 1 0
    //   43: aastore
    //   44: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aconst_null
    //   48: areturn
    //   49: aload 4
    //   51: ifnull +8 -> 59
    //   54: aload 4
    //   56: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   59: aload_0
    //   60: invokeinterface 99 1 0
    //   65: ifne +13 -> 78
    //   68: aload_0
    //   69: invokeinterface 75 1 0
    //   74: invokestatic 104	com/tencent/mm/pluginsdk/g/a/d/a:Wp	(Ljava/lang/String;)Z
    //   77: pop
    //   78: invokestatic 107	com/tencent/mm/pluginsdk/g/a/c/j:clJ	()V
    //   81: new 109	java/net/URL
    //   84: dup
    //   85: aload_0
    //   86: invokeinterface 112 1 0
    //   91: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   94: astore 4
    //   96: aload 4
    //   98: invokevirtual 119	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   101: checkcast 92	java/net/HttpURLConnection
    //   104: astore 6
    //   106: ldc 61
    //   108: ldc 121
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_0
    //   117: invokeinterface 86 1 0
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_0
    //   126: invokeinterface 112 1 0
    //   131: aastore
    //   132: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: invokestatic 107	com/tencent/mm/pluginsdk/g/a/c/j:clJ	()V
    //   138: aload_0
    //   139: aload 6
    //   141: invokestatic 127	com/tencent/mm/pluginsdk/g/a/c/j:a	(Lcom/tencent/mm/pluginsdk/g/a/c/e;Ljava/net/HttpURLConnection;)V
    //   144: invokestatic 107	com/tencent/mm/pluginsdk/g/a/c/j:clJ	()V
    //   147: aload_0
    //   148: invokeinterface 75 1 0
    //   153: invokestatic 131	com/tencent/mm/pluginsdk/g/a/d/a:Jr	(Ljava/lang/String;)J
    //   156: lstore_1
    //   157: ldc 61
    //   159: ldc 133
    //   161: iconst_2
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_0
    //   168: invokeinterface 86 1 0
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: lload_1
    //   177: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   180: aastore
    //   181: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: lload_1
    //   185: lconst_0
    //   186: lcmp
    //   187: ifne +259 -> 446
    //   190: iconst_0
    //   191: istore_3
    //   192: ldc 61
    //   194: ldc 141
    //   196: iconst_2
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload_0
    //   203: invokeinterface 86 1 0
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: iload_3
    //   212: invokestatic 146	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   215: aastore
    //   216: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: invokestatic 107	com/tencent/mm/pluginsdk/g/a/c/j:clJ	()V
    //   222: ldc 148
    //   224: aload 4
    //   226: invokevirtual 151	java/net/URL:getProtocol	()Ljava/lang/String;
    //   229: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   232: ifeq +76 -> 308
    //   235: aload 6
    //   237: checkcast 158	javax/net/ssl/HttpsURLConnection
    //   240: astore 7
    //   242: ldc 160
    //   244: invokestatic 162	com/tencent/mm/pluginsdk/g/a/c/j:UZ	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   247: astore 5
    //   249: aload 5
    //   251: astore 4
    //   253: aload 5
    //   255: ifnonnull +24 -> 279
    //   258: ldc 164
    //   260: invokestatic 162	com/tencent/mm/pluginsdk/g/a/c/j:UZ	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   263: astore 5
    //   265: aload 5
    //   267: astore 4
    //   269: aload 5
    //   271: ifnonnull +8 -> 279
    //   274: invokestatic 168	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   277: astore 4
    //   279: aload 4
    //   281: ifnull +198 -> 479
    //   284: aload 4
    //   286: aconst_null
    //   287: aconst_null
    //   288: new 170	java/security/SecureRandom
    //   291: dup
    //   292: invokespecial 171	java/security/SecureRandom:<init>	()V
    //   295: invokevirtual 175	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   298: aload 7
    //   300: aload 4
    //   302: invokevirtual 179	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   305: invokevirtual 183	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   308: invokestatic 107	com/tencent/mm/pluginsdk/g/a/c/j:clJ	()V
    //   311: ldc 61
    //   313: ldc 185
    //   315: iconst_2
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: aload_0
    //   322: invokeinterface 86 1 0
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: aload_0
    //   331: invokeinterface 188 1 0
    //   336: aastore
    //   337: invokestatic 190	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: ldc 192
    //   342: aload_0
    //   343: invokeinterface 188 1 0
    //   348: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifeq +65 -> 416
    //   354: aconst_null
    //   355: invokestatic 200	com/tencent/mm/sdk/platformtools/bk:bE	([B)Z
    //   358: ifne +58 -> 416
    //   361: aload 6
    //   363: iconst_1
    //   364: invokevirtual 204	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   367: aload 6
    //   369: ldc 206
    //   371: aload_0
    //   372: invokeinterface 209 1 0
    //   377: invokevirtual 212	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 6
    //   382: aconst_null
    //   383: arraylength
    //   384: invokevirtual 216	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   387: new 218	java/io/DataOutputStream
    //   390: dup
    //   391: aload 6
    //   393: invokevirtual 222	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   396: invokespecial 225	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   399: astore 5
    //   401: aload 5
    //   403: astore 4
    //   405: aload 5
    //   407: aconst_null
    //   408: invokevirtual 229	java/io/DataOutputStream:write	([B)V
    //   411: aload 5
    //   413: invokevirtual 232	java/io/DataOutputStream:close	()V
    //   416: invokestatic 107	com/tencent/mm/pluginsdk/g/a/c/j:clJ	()V
    //   419: aload_0
    //   420: aload 6
    //   422: iload_3
    //   423: invokestatic 235	com/tencent/mm/pluginsdk/g/a/c/j:a	(Lcom/tencent/mm/pluginsdk/g/a/c/e;Ljava/net/HttpURLConnection;Z)Lcom/tencent/mm/pluginsdk/g/a/c/m;
    //   426: astore 4
    //   428: aload 6
    //   430: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   433: aload 6
    //   435: ifnull +8 -> 443
    //   438: aload 6
    //   440: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   443: aload 4
    //   445: areturn
    //   446: aload 6
    //   448: ldc 237
    //   450: new 239	java/lang/StringBuilder
    //   453: dup
    //   454: ldc 241
    //   456: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   459: lload_1
    //   460: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   463: ldc 248
    //   465: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokevirtual 257	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   474: iconst_1
    //   475: istore_3
    //   476: goto -284 -> 192
    //   479: aload 7
    //   481: aload_0
    //   482: invokeinterface 261 1 0
    //   487: new 263	android/net/SSLSessionCache
    //   490: dup
    //   491: invokestatic 269	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   494: invokespecial 272	android/net/SSLSessionCache:<init>	(Landroid/content/Context;)V
    //   497: invokestatic 277	android/net/SSLCertificateSocketFactory:getDefault	(ILandroid/net/SSLSessionCache;)Ljavax/net/ssl/SSLSocketFactory;
    //   500: invokevirtual 183	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   503: goto -195 -> 308
    //   506: astore 5
    //   508: aload 6
    //   510: astore 4
    //   512: aload_0
    //   513: aload 5
    //   515: invokestatic 281	com/tencent/mm/pluginsdk/g/a/c/j:b	(Lcom/tencent/mm/pluginsdk/g/a/c/e;Ljava/lang/Exception;)Lcom/tencent/mm/pluginsdk/g/a/c/m;
    //   518: astore 6
    //   520: aload 6
    //   522: ifnonnull +257 -> 779
    //   525: ldc 61
    //   527: ldc_w 283
    //   530: iconst_1
    //   531: anewarray 4	java/lang/Object
    //   534: dup
    //   535: iconst_0
    //   536: aload_0
    //   537: invokeinterface 86 1 0
    //   542: aastore
    //   543: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   546: aload_0
    //   547: invokeinterface 286 1 0
    //   552: ifne -503 -> 49
    //   555: ldc 61
    //   557: ldc_w 288
    //   560: iconst_1
    //   561: anewarray 4	java/lang/Object
    //   564: dup
    //   565: iconst_0
    //   566: aload_0
    //   567: invokeinterface 86 1 0
    //   572: aastore
    //   573: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   576: aload_0
    //   577: aload 5
    //   579: invokestatic 290	com/tencent/mm/pluginsdk/g/a/c/j:a	(Lcom/tencent/mm/pluginsdk/g/a/c/e;Ljava/lang/Exception;)Lcom/tencent/mm/pluginsdk/g/a/c/m;
    //   582: astore 5
    //   584: aload 5
    //   586: astore_0
    //   587: aload 4
    //   589: ifnull -576 -> 13
    //   592: aload 4
    //   594: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   597: aload 5
    //   599: areturn
    //   600: astore_0
    //   601: aload 5
    //   603: areturn
    //   604: astore 4
    //   606: ldc 61
    //   608: ldc_w 292
    //   611: iconst_1
    //   612: anewarray 4	java/lang/Object
    //   615: dup
    //   616: iconst_0
    //   617: aload_0
    //   618: invokeinterface 86 1 0
    //   623: aastore
    //   624: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   627: ldc 61
    //   629: aload 4
    //   631: ldc_w 294
    //   634: iconst_0
    //   635: anewarray 4	java/lang/Object
    //   638: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: goto -225 -> 416
    //   644: astore_0
    //   645: aload 6
    //   647: astore 4
    //   649: aload 4
    //   651: ifnull +8 -> 659
    //   654: aload 4
    //   656: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   659: aload_0
    //   660: athrow
    //   661: astore 7
    //   663: aconst_null
    //   664: astore 5
    //   666: aload 5
    //   668: astore 4
    //   670: ldc 61
    //   672: ldc_w 300
    //   675: iconst_1
    //   676: anewarray 4	java/lang/Object
    //   679: dup
    //   680: iconst_0
    //   681: aload_0
    //   682: invokeinterface 86 1 0
    //   687: aastore
    //   688: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   691: aload 5
    //   693: astore 4
    //   695: ldc 61
    //   697: aload 7
    //   699: ldc_w 294
    //   702: iconst_0
    //   703: anewarray 4	java/lang/Object
    //   706: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   709: aload 5
    //   711: astore 4
    //   713: aload 7
    //   715: athrow
    //   716: astore 7
    //   718: aload 4
    //   720: astore 5
    //   722: aload 7
    //   724: astore 4
    //   726: aload 5
    //   728: ifnull +8 -> 736
    //   731: aload 5
    //   733: invokevirtual 232	java/io/DataOutputStream:close	()V
    //   736: aload 4
    //   738: athrow
    //   739: astore 5
    //   741: ldc 61
    //   743: ldc_w 292
    //   746: iconst_1
    //   747: anewarray 4	java/lang/Object
    //   750: dup
    //   751: iconst_0
    //   752: aload_0
    //   753: invokeinterface 86 1 0
    //   758: aastore
    //   759: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   762: ldc 61
    //   764: aload 5
    //   766: ldc_w 294
    //   769: iconst_0
    //   770: anewarray 4	java/lang/Object
    //   773: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   776: goto -40 -> 736
    //   779: aload 6
    //   781: astore_0
    //   782: aload 4
    //   784: ifnull -771 -> 13
    //   787: aload 4
    //   789: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   792: aload 6
    //   794: areturn
    //   795: astore_0
    //   796: aload 6
    //   798: areturn
    //   799: astore 4
    //   801: aload 5
    //   803: astore 4
    //   805: goto -526 -> 279
    //   808: astore_0
    //   809: goto -366 -> 443
    //   812: astore 4
    //   814: goto -755 -> 59
    //   817: astore 4
    //   819: goto -160 -> 659
    //   822: astore_0
    //   823: aconst_null
    //   824: astore 4
    //   826: goto -177 -> 649
    //   829: astore_0
    //   830: goto -181 -> 649
    //   833: astore 5
    //   835: aconst_null
    //   836: astore 4
    //   838: goto -326 -> 512
    //   841: astore 4
    //   843: aconst_null
    //   844: astore 5
    //   846: goto -120 -> 726
    //   849: astore 7
    //   851: goto -185 -> 666
    //   854: astore 4
    //   856: goto -377 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	859	0	parame	e
    //   156	304	1	l	long
    //   191	285	3	bool	boolean
    //   49	544	4	localObject1	Object
    //   604	26	4	localIOException1	IOException
    //   647	141	4	localObject2	Object
    //   799	1	4	localException1	Exception
    //   803	1	4	localObject3	Object
    //   812	1	4	localException2	Exception
    //   817	1	4	localException3	Exception
    //   824	13	4	localObject4	Object
    //   841	1	4	localObject5	Object
    //   854	1	4	localException4	Exception
    //   247	165	5	localObject6	Object
    //   506	72	5	localException5	Exception
    //   582	150	5	localObject7	Object
    //   739	63	5	localIOException2	IOException
    //   833	1	5	localException6	Exception
    //   844	1	5	localObject8	Object
    //   104	693	6	localObject9	Object
    //   240	240	7	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    //   661	53	7	localIOException3	IOException
    //   716	7	7	localObject10	Object
    //   849	1	7	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   106	184	506	java/lang/Exception
    //   192	249	506	java/lang/Exception
    //   258	265	506	java/lang/Exception
    //   308	387	506	java/lang/Exception
    //   411	416	506	java/lang/Exception
    //   416	433	506	java/lang/Exception
    //   446	474	506	java/lang/Exception
    //   479	503	506	java/lang/Exception
    //   606	641	506	java/lang/Exception
    //   731	736	506	java/lang/Exception
    //   736	739	506	java/lang/Exception
    //   741	776	506	java/lang/Exception
    //   592	597	600	java/lang/Exception
    //   411	416	604	java/io/IOException
    //   106	184	644	finally
    //   192	249	644	finally
    //   258	265	644	finally
    //   274	279	644	finally
    //   284	308	644	finally
    //   308	387	644	finally
    //   411	416	644	finally
    //   416	433	644	finally
    //   446	474	644	finally
    //   479	503	644	finally
    //   606	641	644	finally
    //   731	736	644	finally
    //   736	739	644	finally
    //   741	776	644	finally
    //   387	401	661	java/io/IOException
    //   405	411	716	finally
    //   670	691	716	finally
    //   695	709	716	finally
    //   713	716	716	finally
    //   731	736	739	java/io/IOException
    //   787	792	795	java/lang/Exception
    //   274	279	799	java/lang/Exception
    //   438	443	808	java/lang/Exception
    //   54	59	812	java/lang/Exception
    //   654	659	817	java/lang/Exception
    //   59	78	822	finally
    //   78	106	822	finally
    //   512	520	829	finally
    //   525	584	829	finally
    //   59	78	833	java/lang/Exception
    //   78	106	833	java/lang/Exception
    //   387	401	841	finally
    //   405	411	849	java/io/IOException
    //   284	308	854	java/lang/Exception
  }
  
  private static m a(e parame, Exception paramException)
  {
    int i = -1;
    Object localObject = paramException;
    if ((paramException instanceof f))
    {
      i = ((f)paramException).httpStatusCode;
      localObject = ((f)paramException).rXk;
    }
    y.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", new Object[] { parame.cls(), localObject });
    return new m(parame, (Exception)localObject, i, 3);
  }
  
  /* Error */
  private static m a(e parame, HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 61
    //   2: ldc_w 321
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokeinterface 86 1 0
    //   17: aastore
    //   18: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aconst_null
    //   22: astore 35
    //   24: aconst_null
    //   25: astore 22
    //   27: aconst_null
    //   28: astore 31
    //   30: aconst_null
    //   31: astore 32
    //   33: aconst_null
    //   34: astore 33
    //   36: aconst_null
    //   37: astore 34
    //   39: aconst_null
    //   40: astore 29
    //   42: aconst_null
    //   43: astore 30
    //   45: iconst_m1
    //   46: istore_3
    //   47: aload_1
    //   48: invokevirtual 324	java/net/HttpURLConnection:getResponseCode	()I
    //   51: istore 11
    //   53: aload_1
    //   54: invokevirtual 327	java/net/HttpURLConnection:getContentLength	()I
    //   57: istore 12
    //   59: aload_1
    //   60: invokevirtual 330	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   63: astore 37
    //   65: aload_1
    //   66: invokevirtual 333	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   69: astore 36
    //   71: ldc_w 335
    //   74: aload_1
    //   75: ldc_w 337
    //   78: invokevirtual 341	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   81: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +152 -> 236
    //   87: iconst_1
    //   88: istore 14
    //   90: ldc 61
    //   92: ldc_w 343
    //   95: bipush 7
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_0
    //   103: invokeinterface 86 1 0
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: iload 11
    //   113: invokestatic 348	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: aastore
    //   117: dup
    //   118: iconst_2
    //   119: iload 12
    //   121: invokestatic 348	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: dup
    //   126: iconst_3
    //   127: aload 37
    //   129: aastore
    //   130: dup
    //   131: iconst_4
    //   132: aload 36
    //   134: aastore
    //   135: dup
    //   136: iconst_5
    //   137: iload 14
    //   139: invokestatic 146	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   142: aastore
    //   143: dup
    //   144: bipush 6
    //   146: aload_1
    //   147: invokevirtual 352	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   150: invokestatic 358	com/tencent/mm/pluginsdk/g/a/d/b:as	(Ljava/util/Map;)Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_0
    //   158: invokeinterface 75 1 0
    //   163: invokestatic 131	com/tencent/mm/pluginsdk/g/a/d/a:Jr	(Ljava/lang/String;)J
    //   166: lstore 16
    //   168: iload 12
    //   170: ifne +1631 -> 1801
    //   173: sipush 206
    //   176: iload 11
    //   178: if_icmpne +1623 -> 1801
    //   181: lload 16
    //   183: lconst_0
    //   184: lcmp
    //   185: ifle +1616 -> 1801
    //   188: ldc 61
    //   190: ldc_w 360
    //   193: iconst_1
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_0
    //   200: invokeinterface 86 1 0
    //   205: aastore
    //   206: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: new 314	com/tencent/mm/pluginsdk/g/a/c/m
    //   212: dup
    //   213: aload_0
    //   214: lload 16
    //   216: aload 36
    //   218: invokespecial 363	com/tencent/mm/pluginsdk/g/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/g/a/c/e;JLjava/lang/String;)V
    //   221: astore 20
    //   223: aconst_null
    //   224: invokestatic 366	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   227: aconst_null
    //   228: invokestatic 366	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   231: aload 20
    //   233: astore_0
    //   234: aload_0
    //   235: areturn
    //   236: aload_1
    //   237: ldc_w 368
    //   240: invokevirtual 341	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   243: astore 20
    //   245: aload 20
    //   247: ifnull +1548 -> 1795
    //   250: aload 20
    //   252: ldc_w 335
    //   255: invokevirtual 371	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   258: ifeq +1537 -> 1795
    //   261: iconst_1
    //   262: istore 14
    //   264: goto -174 -> 90
    //   267: aload_0
    //   268: invokeinterface 374 1 0
    //   273: ifne +89 -> 362
    //   276: ldc 61
    //   278: ldc_w 376
    //   281: iconst_1
    //   282: anewarray 4	java/lang/Object
    //   285: dup
    //   286: iconst_0
    //   287: aload_0
    //   288: invokeinterface 86 1 0
    //   293: aastore
    //   294: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: new 32	com/tencent/mm/pluginsdk/g/a/b/d
    //   300: dup
    //   301: invokespecial 377	com/tencent/mm/pluginsdk/g/a/b/d:<init>	()V
    //   304: athrow
    //   305: astore_0
    //   306: aconst_null
    //   307: astore 20
    //   309: aload 30
    //   311: astore 22
    //   313: iload_3
    //   314: istore 4
    //   316: aload 20
    //   318: astore 21
    //   320: aload_0
    //   321: athrow
    //   322: astore_0
    //   323: aload 21
    //   325: astore 20
    //   327: iload 4
    //   329: istore_3
    //   330: aload 20
    //   332: invokestatic 366	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   335: aload 22
    //   337: invokestatic 366	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   340: iload_3
    //   341: ifle +19 -> 360
    //   344: getstatic 383	com/tencent/mm/model/am$a:dVz	Lcom/tencent/mm/model/am$e;
    //   347: ifnull +13 -> 360
    //   350: getstatic 383	com/tencent/mm/model/am$a:dVz	Lcom/tencent/mm/model/am$e;
    //   353: iload_3
    //   354: iconst_0
    //   355: invokeinterface 389 3 0
    //   360: aload_0
    //   361: athrow
    //   362: iload 12
    //   364: ifne +28 -> 392
    //   367: new 34	com/tencent/mm/pluginsdk/g/a/b/g
    //   370: dup
    //   371: invokespecial 390	com/tencent/mm/pluginsdk/g/a/b/g:<init>	()V
    //   374: athrow
    //   375: astore_0
    //   376: aconst_null
    //   377: astore 20
    //   379: aload 31
    //   381: astore 22
    //   383: iload_3
    //   384: istore 4
    //   386: aload 20
    //   388: astore 21
    //   390: aload_0
    //   391: athrow
    //   392: aload_0
    //   393: invokeinterface 393 1 0
    //   398: ifne +93 -> 491
    //   401: iload 12
    //   403: ifge +88 -> 491
    //   406: new 38	java/net/SocketException
    //   409: dup
    //   410: invokespecial 394	java/net/SocketException:<init>	()V
    //   413: athrow
    //   414: astore_1
    //   415: aconst_null
    //   416: astore 20
    //   418: aload 32
    //   420: astore 23
    //   422: iload_3
    //   423: istore 4
    //   425: aload 23
    //   427: astore 22
    //   429: aload 20
    //   431: astore 21
    //   433: ldc 61
    //   435: ldc_w 396
    //   438: iconst_1
    //   439: anewarray 4	java/lang/Object
    //   442: dup
    //   443: iconst_0
    //   444: aload_0
    //   445: invokeinterface 86 1 0
    //   450: aastore
    //   451: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   454: iload_3
    //   455: istore 4
    //   457: aload 23
    //   459: astore 22
    //   461: aload 20
    //   463: astore 21
    //   465: ldc 61
    //   467: aload_1
    //   468: ldc_w 294
    //   471: iconst_0
    //   472: anewarray 4	java/lang/Object
    //   475: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   478: iload_3
    //   479: istore 4
    //   481: aload 23
    //   483: astore 22
    //   485: aload 20
    //   487: astore 21
    //   489: aload_1
    //   490: athrow
    //   491: iload 12
    //   493: ifle +96 -> 589
    //   496: iload 12
    //   498: i2l
    //   499: lstore 18
    //   501: aload_0
    //   502: lload 18
    //   504: invokeinterface 400 3 0
    //   509: ifne +80 -> 589
    //   512: new 30	com/tencent/mm/pluginsdk/g/a/b/a
    //   515: dup
    //   516: invokespecial 401	com/tencent/mm/pluginsdk/g/a/b/a:<init>	()V
    //   519: athrow
    //   520: astore_1
    //   521: aconst_null
    //   522: astore 20
    //   524: aload 33
    //   526: astore 23
    //   528: iload_3
    //   529: istore 4
    //   531: aload 23
    //   533: astore 22
    //   535: aload 20
    //   537: astore 21
    //   539: ldc 61
    //   541: new 239	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   548: aload_0
    //   549: invokeinterface 86 1 0
    //   554: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc_w 404
    //   560: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_1
    //   564: invokevirtual 407	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   567: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 409	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: iload_3
    //   577: istore 4
    //   579: aload 23
    //   581: astore 22
    //   583: aload 20
    //   585: astore 21
    //   587: aload_1
    //   588: athrow
    //   589: sipush 416
    //   592: iload 11
    //   594: if_icmpne +33 -> 627
    //   597: new 411	com/tencent/mm/pluginsdk/g/a/b/b
    //   600: dup
    //   601: iload 12
    //   603: i2l
    //   604: lload 16
    //   606: invokespecial 414	com/tencent/mm/pluginsdk/g/a/b/b:<init>	(JJ)V
    //   609: athrow
    //   610: astore_0
    //   611: aconst_null
    //   612: astore 20
    //   614: aload 34
    //   616: astore 22
    //   618: iload_3
    //   619: istore 4
    //   621: aload 20
    //   623: astore 21
    //   625: aload_0
    //   626: athrow
    //   627: new 416	java/io/BufferedInputStream
    //   630: dup
    //   631: aload_1
    //   632: invokevirtual 420	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   635: invokespecial 423	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   638: astore 23
    //   640: iload_3
    //   641: istore 4
    //   643: aload 35
    //   645: astore 22
    //   647: aload 23
    //   649: astore 21
    //   651: aload 23
    //   653: astore 20
    //   655: aload 23
    //   657: astore 24
    //   659: aload 23
    //   661: astore 25
    //   663: aload 23
    //   665: astore 26
    //   667: aload 23
    //   669: astore 27
    //   671: aload 23
    //   673: astore 28
    //   675: aload 37
    //   677: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   680: ifne +91 -> 771
    //   683: iload_3
    //   684: istore 4
    //   686: aload 35
    //   688: astore 22
    //   690: aload 23
    //   692: astore 21
    //   694: aload 23
    //   696: astore 20
    //   698: aload 23
    //   700: astore 24
    //   702: aload 23
    //   704: astore 25
    //   706: aload 23
    //   708: astore 26
    //   710: aload 23
    //   712: astore 27
    //   714: aload 23
    //   716: astore 28
    //   718: aload 37
    //   720: ldc_w 425
    //   723: invokevirtual 156	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   726: ifeq +45 -> 771
    //   729: iload_3
    //   730: istore 4
    //   732: aload 35
    //   734: astore 22
    //   736: aload 23
    //   738: astore 21
    //   740: aload 23
    //   742: astore 24
    //   744: aload 23
    //   746: astore 25
    //   748: aload 23
    //   750: astore 26
    //   752: aload 23
    //   754: astore 27
    //   756: aload 23
    //   758: astore 28
    //   760: new 427	java/util/zip/GZIPInputStream
    //   763: dup
    //   764: aload 23
    //   766: invokespecial 428	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   769: astore 20
    //   771: iload_3
    //   772: istore 4
    //   774: aload 35
    //   776: astore 22
    //   778: aload 20
    //   780: astore 21
    //   782: aload 20
    //   784: astore 24
    //   786: aload 20
    //   788: astore 25
    //   790: aload 20
    //   792: astore 26
    //   794: aload 20
    //   796: astore 27
    //   798: aload 20
    //   800: astore 28
    //   802: aload_0
    //   803: invokeinterface 75 1 0
    //   808: astore 23
    //   810: iload_3
    //   811: istore 4
    //   813: aload 35
    //   815: astore 22
    //   817: aload 20
    //   819: astore 21
    //   821: aload 20
    //   823: astore 24
    //   825: aload 20
    //   827: astore 25
    //   829: aload 20
    //   831: astore 26
    //   833: aload 20
    //   835: astore 27
    //   837: aload 20
    //   839: astore 28
    //   841: aload_0
    //   842: invokeinterface 86 1 0
    //   847: astore 37
    //   849: iload_2
    //   850: ifeq +982 -> 1832
    //   853: iload 14
    //   855: ifeq +977 -> 1832
    //   858: iconst_1
    //   859: istore 15
    //   861: iload_3
    //   862: istore 4
    //   864: aload 35
    //   866: astore 22
    //   868: aload 20
    //   870: astore 21
    //   872: aload 20
    //   874: astore 24
    //   876: aload 20
    //   878: astore 25
    //   880: aload 20
    //   882: astore 26
    //   884: aload 20
    //   886: astore 27
    //   888: aload 20
    //   890: astore 28
    //   892: ldc 61
    //   894: ldc_w 430
    //   897: iconst_2
    //   898: anewarray 4	java/lang/Object
    //   901: dup
    //   902: iconst_0
    //   903: aload 37
    //   905: aastore
    //   906: dup
    //   907: iconst_1
    //   908: aload 23
    //   910: aastore
    //   911: invokestatic 190	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   914: iload_3
    //   915: istore 4
    //   917: aload 35
    //   919: astore 22
    //   921: aload 20
    //   923: astore 21
    //   925: aload 20
    //   927: astore 24
    //   929: aload 20
    //   931: astore 25
    //   933: aload 20
    //   935: astore 26
    //   937: aload 20
    //   939: astore 27
    //   941: aload 20
    //   943: astore 28
    //   945: aload 23
    //   947: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   950: ifeq +57 -> 1007
    //   953: iload_3
    //   954: istore 4
    //   956: aload 35
    //   958: astore 22
    //   960: aload 20
    //   962: astore 21
    //   964: aload 20
    //   966: astore 24
    //   968: aload 20
    //   970: astore 25
    //   972: aload 20
    //   974: astore 26
    //   976: aload 20
    //   978: astore 27
    //   980: aload 20
    //   982: astore 28
    //   984: new 28	java/io/FileNotFoundException
    //   987: dup
    //   988: ldc_w 432
    //   991: iconst_1
    //   992: anewarray 4	java/lang/Object
    //   995: dup
    //   996: iconst_0
    //   997: aload 37
    //   999: aastore
    //   1000: invokestatic 436	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1003: invokespecial 437	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   1006: athrow
    //   1007: iload_3
    //   1008: istore 4
    //   1010: aload 35
    //   1012: astore 22
    //   1014: aload 20
    //   1016: astore 21
    //   1018: aload 20
    //   1020: astore 24
    //   1022: aload 20
    //   1024: astore 25
    //   1026: aload 20
    //   1028: astore 26
    //   1030: aload 20
    //   1032: astore 27
    //   1034: aload 20
    //   1036: astore 28
    //   1038: new 439	java/io/BufferedOutputStream
    //   1041: dup
    //   1042: new 441	java/io/FileOutputStream
    //   1045: dup
    //   1046: aload 23
    //   1048: iload 15
    //   1050: invokespecial 444	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   1053: invokespecial 445	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1056: astore 23
    //   1058: iload_3
    //   1059: istore 4
    //   1061: iload_3
    //   1062: istore 5
    //   1064: iload_3
    //   1065: istore 6
    //   1067: iload_3
    //   1068: istore 7
    //   1070: iload_3
    //   1071: istore 8
    //   1073: iload_3
    //   1074: istore 9
    //   1076: iload_3
    //   1077: istore 10
    //   1079: ldc 61
    //   1081: ldc_w 447
    //   1084: iconst_3
    //   1085: anewarray 4	java/lang/Object
    //   1088: dup
    //   1089: iconst_0
    //   1090: aload_0
    //   1091: invokeinterface 86 1 0
    //   1096: aastore
    //   1097: dup
    //   1098: iconst_1
    //   1099: iload_2
    //   1100: invokestatic 146	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1103: aastore
    //   1104: dup
    //   1105: iconst_2
    //   1106: iload 14
    //   1108: invokestatic 146	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1111: aastore
    //   1112: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1115: iload_3
    //   1116: istore 4
    //   1118: iload_3
    //   1119: istore 5
    //   1121: iload_3
    //   1122: istore 6
    //   1124: iload_3
    //   1125: istore 7
    //   1127: iload_3
    //   1128: istore 8
    //   1130: iload_3
    //   1131: istore 9
    //   1133: iload_3
    //   1134: istore 10
    //   1136: sipush 16384
    //   1139: newarray byte
    //   1141: astore 21
    //   1143: iconst_0
    //   1144: istore_3
    //   1145: iload_3
    //   1146: istore 4
    //   1148: iload_3
    //   1149: istore 5
    //   1151: iload_3
    //   1152: istore 6
    //   1154: iload_3
    //   1155: istore 7
    //   1157: iload_3
    //   1158: istore 8
    //   1160: iload_3
    //   1161: istore 9
    //   1163: iload_3
    //   1164: istore 10
    //   1166: aload 20
    //   1168: aload 21
    //   1170: iconst_0
    //   1171: sipush 16384
    //   1174: invokevirtual 453	java/io/InputStream:read	([BII)I
    //   1177: istore 13
    //   1179: iload 13
    //   1181: iconst_m1
    //   1182: if_icmpeq +66 -> 1248
    //   1185: iload_3
    //   1186: istore 4
    //   1188: iload_3
    //   1189: istore 5
    //   1191: iload_3
    //   1192: istore 6
    //   1194: iload_3
    //   1195: istore 7
    //   1197: iload_3
    //   1198: istore 8
    //   1200: iload_3
    //   1201: istore 9
    //   1203: iload_3
    //   1204: istore 10
    //   1206: aload 23
    //   1208: aload 21
    //   1210: iconst_0
    //   1211: iload 13
    //   1213: invokevirtual 458	java/io/OutputStream:write	([BII)V
    //   1216: iload_3
    //   1217: iload 13
    //   1219: iadd
    //   1220: istore_3
    //   1221: iload_3
    //   1222: istore 4
    //   1224: iload_3
    //   1225: istore 5
    //   1227: iload_3
    //   1228: istore 6
    //   1230: iload_3
    //   1231: istore 7
    //   1233: iload_3
    //   1234: istore 8
    //   1236: iload_3
    //   1237: istore 9
    //   1239: iload_3
    //   1240: istore 10
    //   1242: invokestatic 107	com/tencent/mm/pluginsdk/g/a/c/j:clJ	()V
    //   1245: goto -100 -> 1145
    //   1248: iload_3
    //   1249: istore 4
    //   1251: iload_3
    //   1252: istore 5
    //   1254: iload_3
    //   1255: istore 6
    //   1257: iload_3
    //   1258: istore 7
    //   1260: iload_3
    //   1261: istore 8
    //   1263: iload_3
    //   1264: istore 9
    //   1266: iload_3
    //   1267: istore 10
    //   1269: ldc 61
    //   1271: ldc_w 460
    //   1274: iconst_2
    //   1275: anewarray 4	java/lang/Object
    //   1278: dup
    //   1279: iconst_0
    //   1280: aload_0
    //   1281: invokeinterface 86 1 0
    //   1286: aastore
    //   1287: dup
    //   1288: iconst_1
    //   1289: iload_3
    //   1290: invokestatic 348	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1293: aastore
    //   1294: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1318: aload 23
    //   1320: invokevirtual 463	java/io/OutputStream:flush	()V
    //   1323: iload_3
    //   1324: istore 4
    //   1326: iload_3
    //   1327: istore 5
    //   1329: iload_3
    //   1330: istore 6
    //   1332: iload_3
    //   1333: istore 7
    //   1335: iload_3
    //   1336: istore 8
    //   1338: iload_3
    //   1339: istore 9
    //   1341: iload_3
    //   1342: istore 10
    //   1344: ldc 61
    //   1346: ldc_w 465
    //   1349: iconst_1
    //   1350: anewarray 4	java/lang/Object
    //   1353: dup
    //   1354: iconst_0
    //   1355: aload_0
    //   1356: invokeinterface 86 1 0
    //   1361: aastore
    //   1362: invokestatic 124	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1365: iload_3
    //   1366: istore 4
    //   1368: iload_3
    //   1369: istore 5
    //   1371: iload_3
    //   1372: istore 6
    //   1374: iload_3
    //   1375: istore 7
    //   1377: iload_3
    //   1378: istore 8
    //   1380: iload_3
    //   1381: istore 9
    //   1383: iload_3
    //   1384: istore 10
    //   1386: aload_0
    //   1387: invokeinterface 393 1 0
    //   1392: ifeq +84 -> 1476
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
    //   1416: new 314	com/tencent/mm/pluginsdk/g/a/c/m
    //   1419: dup
    //   1420: aload_0
    //   1421: aload_0
    //   1422: invokeinterface 75 1 0
    //   1427: invokestatic 131	com/tencent/mm/pluginsdk/g/a/d/a:Jr	(Ljava/lang/String;)J
    //   1430: aload 36
    //   1432: invokespecial 363	com/tencent/mm/pluginsdk/g/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/g/a/c/e;JLjava/lang/String;)V
    //   1435: astore 21
    //   1437: aload 20
    //   1439: invokestatic 366	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1442: aload 23
    //   1444: invokestatic 366	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1447: aload 21
    //   1449: astore_0
    //   1450: iload_3
    //   1451: ifle -1217 -> 234
    //   1454: aload 21
    //   1456: astore_0
    //   1457: getstatic 383	com/tencent/mm/model/am$a:dVz	Lcom/tencent/mm/model/am$e;
    //   1460: ifnull -1226 -> 234
    //   1463: getstatic 383	com/tencent/mm/model/am$a:dVz	Lcom/tencent/mm/model/am$e;
    //   1466: iload_3
    //   1467: iconst_0
    //   1468: invokeinterface 389 3 0
    //   1473: aload 21
    //   1475: areturn
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
    //   1497: new 314	com/tencent/mm/pluginsdk/g/a/c/m
    //   1500: dup
    //   1501: aload_0
    //   1502: iload 12
    //   1504: i2l
    //   1505: aload 36
    //   1507: invokespecial 363	com/tencent/mm/pluginsdk/g/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/g/a/c/e;JLjava/lang/String;)V
    //   1510: astore 21
    //   1512: aload 20
    //   1514: invokestatic 366	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1517: aload 23
    //   1519: invokestatic 366	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1522: aload 21
    //   1524: astore_0
    //   1525: iload_3
    //   1526: ifle -1292 -> 234
    //   1529: aload 21
    //   1531: astore_0
    //   1532: getstatic 383	com/tencent/mm/model/am$a:dVz	Lcom/tencent/mm/model/am$e;
    //   1535: ifnull -1301 -> 234
    //   1538: getstatic 383	com/tencent/mm/model/am$a:dVz	Lcom/tencent/mm/model/am$e;
    //   1541: iload_3
    //   1542: iconst_0
    //   1543: invokeinterface 389 3 0
    //   1548: aload 21
    //   1550: areturn
    //   1551: astore 23
    //   1553: iconst_m1
    //   1554: istore 11
    //   1556: aconst_null
    //   1557: astore 20
    //   1559: aload 29
    //   1561: astore 24
    //   1563: aload 20
    //   1565: invokestatic 366	com/tencent/mm/pluginsdk/g/a/d/a:e	(Ljava/io/Closeable;)V
    //   1568: aload_1
    //   1569: invokevirtual 468	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   1572: astore_1
    //   1573: iload_3
    //   1574: istore 4
    //   1576: aload 24
    //   1578: astore 22
    //   1580: aload_1
    //   1581: astore 21
    //   1583: ldc 61
    //   1585: ldc_w 470
    //   1588: iconst_2
    //   1589: anewarray 4	java/lang/Object
    //   1592: dup
    //   1593: iconst_0
    //   1594: aload_0
    //   1595: invokeinterface 86 1 0
    //   1600: aastore
    //   1601: dup
    //   1602: iconst_1
    //   1603: aload 23
    //   1605: aastore
    //   1606: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1609: iload_3
    //   1610: istore 4
    //   1612: aload 24
    //   1614: astore 22
    //   1616: aload_1
    //   1617: astore 21
    //   1619: new 302	com/tencent/mm/pluginsdk/g/a/b/f
    //   1622: dup
    //   1623: iload 11
    //   1625: aload 23
    //   1627: invokespecial 473	com/tencent/mm/pluginsdk/g/a/b/f:<init>	(ILjava/io/IOException;)V
    //   1630: athrow
    //   1631: astore_0
    //   1632: aconst_null
    //   1633: astore 20
    //   1635: goto -1305 -> 330
    //   1638: astore_0
    //   1639: aload 23
    //   1641: astore 22
    //   1643: iload 4
    //   1645: istore_3
    //   1646: goto -1316 -> 330
    //   1649: astore_0
    //   1650: aload 24
    //   1652: astore 22
    //   1654: goto -1324 -> 330
    //   1657: astore 23
    //   1659: aconst_null
    //   1660: astore 20
    //   1662: aload 29
    //   1664: astore 24
    //   1666: goto -103 -> 1563
    //   1669: astore 21
    //   1671: aload 23
    //   1673: astore 20
    //   1675: aload 21
    //   1677: astore 23
    //   1679: aload 29
    //   1681: astore 24
    //   1683: goto -120 -> 1563
    //   1686: astore 23
    //   1688: aload 29
    //   1690: astore 24
    //   1692: goto -129 -> 1563
    //   1695: astore 21
    //   1697: aload 23
    //   1699: astore 24
    //   1701: aload 21
    //   1703: astore 23
    //   1705: iload 5
    //   1707: istore_3
    //   1708: goto -145 -> 1563
    //   1711: astore_0
    //   1712: aload 34
    //   1714: astore 22
    //   1716: aload 24
    //   1718: astore 20
    //   1720: goto -1102 -> 618
    //   1723: astore_0
    //   1724: aload 23
    //   1726: astore 22
    //   1728: iload 6
    //   1730: istore_3
    //   1731: goto -1113 -> 618
    //   1734: astore_1
    //   1735: aload 33
    //   1737: astore 23
    //   1739: aload 25
    //   1741: astore 20
    //   1743: goto -1215 -> 528
    //   1746: astore_1
    //   1747: iload 7
    //   1749: istore_3
    //   1750: goto -1222 -> 528
    //   1753: astore_1
    //   1754: aload 32
    //   1756: astore 23
    //   1758: aload 26
    //   1760: astore 20
    //   1762: goto -1340 -> 422
    //   1765: astore_1
    //   1766: iload 8
    //   1768: istore_3
    //   1769: goto -1347 -> 422
    //   1772: astore_0
    //   1773: aload 31
    //   1775: astore 22
    //   1777: aload 27
    //   1779: astore 20
    //   1781: goto -1398 -> 383
    //   1784: astore_0
    //   1785: aload 23
    //   1787: astore 22
    //   1789: iload 9
    //   1791: istore_3
    //   1792: goto -1409 -> 383
    //   1795: iconst_0
    //   1796: istore 14
    //   1798: goto -1708 -> 90
    //   1801: sipush 301
    //   1804: iload 11
    //   1806: if_icmpeq -1539 -> 267
    //   1809: sipush 302
    //   1812: iload 11
    //   1814: if_icmpne -1452 -> 362
    //   1817: goto -1550 -> 267
    //   1820: astore_0
    //   1821: aload 30
    //   1823: astore 22
    //   1825: aload 28
    //   1827: astore 20
    //   1829: goto -1516 -> 313
    //   1832: iconst_0
    //   1833: istore 15
    //   1835: goto -974 -> 861
    //   1838: astore_0
    //   1839: aload 23
    //   1841: astore 22
    //   1843: iload 10
    //   1845: istore_3
    //   1846: goto -1533 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1849	0	parame	e
    //   0	1849	1	paramHttpURLConnection	HttpURLConnection
    //   0	1849	2	paramBoolean	boolean
    //   46	1800	3	i	int
    //   314	1330	4	j	int
    //   1062	644	5	k	int
    //   1065	664	6	m	int
    //   1068	680	7	n	int
    //   1071	696	8	i1	int
    //   1074	716	9	i2	int
    //   1077	767	10	i3	int
    //   51	1764	11	i4	int
    //   57	1446	12	i5	int
    //   1177	43	13	i6	int
    //   88	1709	14	bool1	boolean
    //   859	975	15	bool2	boolean
    //   166	439	16	l1	long
    //   499	4	18	l2	long
    //   221	1607	20	localObject1	Object
    //   318	1300	21	localObject2	Object
    //   1669	7	21	localIOException1	IOException
    //   1695	7	21	localIOException2	IOException
    //   25	1817	22	localObject3	Object
    //   420	1098	23	localObject4	Object
    //   1551	89	23	localIOException3	IOException
    //   1657	15	23	localIOException4	IOException
    //   1677	1	23	localIOException5	IOException
    //   1686	12	23	localIOException6	IOException
    //   1703	137	23	localObject5	Object
    //   657	1060	24	localObject6	Object
    //   661	1079	25	localObject7	Object
    //   665	1094	26	localObject8	Object
    //   669	1109	27	localObject9	Object
    //   673	1153	28	localObject10	Object
    //   40	1649	29	localObject11	Object
    //   43	1779	30	localObject12	Object
    //   28	1746	31	localObject13	Object
    //   31	1724	32	localObject14	Object
    //   34	1702	33	localObject15	Object
    //   37	1676	34	localObject16	Object
    //   22	989	35	localObject17	Object
    //   69	1437	36	str1	String
    //   63	935	37	str2	String
    // Exception table:
    //   from	to	target	type
    //   47	53	305	java/lang/InterruptedException
    //   53	87	305	java/lang/InterruptedException
    //   90	168	305	java/lang/InterruptedException
    //   188	223	305	java/lang/InterruptedException
    //   236	245	305	java/lang/InterruptedException
    //   250	261	305	java/lang/InterruptedException
    //   267	305	305	java/lang/InterruptedException
    //   367	375	305	java/lang/InterruptedException
    //   392	401	305	java/lang/InterruptedException
    //   406	414	305	java/lang/InterruptedException
    //   501	520	305	java/lang/InterruptedException
    //   597	610	305	java/lang/InterruptedException
    //   627	640	305	java/lang/InterruptedException
    //   320	322	322	finally
    //   390	392	322	finally
    //   433	454	322	finally
    //   465	478	322	finally
    //   489	491	322	finally
    //   539	576	322	finally
    //   587	589	322	finally
    //   625	627	322	finally
    //   675	683	322	finally
    //   718	729	322	finally
    //   760	771	322	finally
    //   802	810	322	finally
    //   841	849	322	finally
    //   892	914	322	finally
    //   945	953	322	finally
    //   984	1007	322	finally
    //   1038	1058	322	finally
    //   1583	1609	322	finally
    //   1619	1631	322	finally
    //   47	53	375	java/net/UnknownHostException
    //   53	87	375	java/net/UnknownHostException
    //   90	168	375	java/net/UnknownHostException
    //   188	223	375	java/net/UnknownHostException
    //   236	245	375	java/net/UnknownHostException
    //   250	261	375	java/net/UnknownHostException
    //   267	305	375	java/net/UnknownHostException
    //   367	375	375	java/net/UnknownHostException
    //   392	401	375	java/net/UnknownHostException
    //   406	414	375	java/net/UnknownHostException
    //   501	520	375	java/net/UnknownHostException
    //   597	610	375	java/net/UnknownHostException
    //   627	640	375	java/net/UnknownHostException
    //   47	53	414	javax/net/ssl/SSLHandshakeException
    //   53	87	414	javax/net/ssl/SSLHandshakeException
    //   90	168	414	javax/net/ssl/SSLHandshakeException
    //   188	223	414	javax/net/ssl/SSLHandshakeException
    //   236	245	414	javax/net/ssl/SSLHandshakeException
    //   250	261	414	javax/net/ssl/SSLHandshakeException
    //   267	305	414	javax/net/ssl/SSLHandshakeException
    //   367	375	414	javax/net/ssl/SSLHandshakeException
    //   392	401	414	javax/net/ssl/SSLHandshakeException
    //   406	414	414	javax/net/ssl/SSLHandshakeException
    //   501	520	414	javax/net/ssl/SSLHandshakeException
    //   597	610	414	javax/net/ssl/SSLHandshakeException
    //   627	640	414	javax/net/ssl/SSLHandshakeException
    //   47	53	520	java/net/SocketException
    //   53	87	520	java/net/SocketException
    //   90	168	520	java/net/SocketException
    //   188	223	520	java/net/SocketException
    //   236	245	520	java/net/SocketException
    //   250	261	520	java/net/SocketException
    //   267	305	520	java/net/SocketException
    //   367	375	520	java/net/SocketException
    //   392	401	520	java/net/SocketException
    //   406	414	520	java/net/SocketException
    //   501	520	520	java/net/SocketException
    //   597	610	520	java/net/SocketException
    //   627	640	520	java/net/SocketException
    //   47	53	610	java/net/SocketTimeoutException
    //   53	87	610	java/net/SocketTimeoutException
    //   90	168	610	java/net/SocketTimeoutException
    //   188	223	610	java/net/SocketTimeoutException
    //   236	245	610	java/net/SocketTimeoutException
    //   250	261	610	java/net/SocketTimeoutException
    //   267	305	610	java/net/SocketTimeoutException
    //   367	375	610	java/net/SocketTimeoutException
    //   392	401	610	java/net/SocketTimeoutException
    //   406	414	610	java/net/SocketTimeoutException
    //   501	520	610	java/net/SocketTimeoutException
    //   597	610	610	java/net/SocketTimeoutException
    //   627	640	610	java/net/SocketTimeoutException
    //   47	53	1551	java/io/IOException
    //   47	53	1631	finally
    //   53	87	1631	finally
    //   90	168	1631	finally
    //   188	223	1631	finally
    //   236	245	1631	finally
    //   250	261	1631	finally
    //   267	305	1631	finally
    //   367	375	1631	finally
    //   392	401	1631	finally
    //   406	414	1631	finally
    //   501	520	1631	finally
    //   597	610	1631	finally
    //   627	640	1631	finally
    //   1079	1115	1638	finally
    //   1136	1143	1638	finally
    //   1166	1179	1638	finally
    //   1206	1216	1638	finally
    //   1242	1245	1638	finally
    //   1269	1297	1638	finally
    //   1318	1323	1638	finally
    //   1344	1365	1638	finally
    //   1386	1395	1638	finally
    //   1416	1437	1638	finally
    //   1497	1512	1638	finally
    //   1563	1573	1649	finally
    //   53	87	1657	java/io/IOException
    //   90	168	1657	java/io/IOException
    //   188	223	1657	java/io/IOException
    //   236	245	1657	java/io/IOException
    //   250	261	1657	java/io/IOException
    //   267	305	1657	java/io/IOException
    //   367	375	1657	java/io/IOException
    //   392	401	1657	java/io/IOException
    //   406	414	1657	java/io/IOException
    //   501	520	1657	java/io/IOException
    //   597	610	1657	java/io/IOException
    //   627	640	1657	java/io/IOException
    //   675	683	1669	java/io/IOException
    //   718	729	1669	java/io/IOException
    //   760	771	1669	java/io/IOException
    //   802	810	1686	java/io/IOException
    //   841	849	1686	java/io/IOException
    //   892	914	1686	java/io/IOException
    //   945	953	1686	java/io/IOException
    //   984	1007	1686	java/io/IOException
    //   1038	1058	1686	java/io/IOException
    //   1079	1115	1695	java/io/IOException
    //   1136	1143	1695	java/io/IOException
    //   1166	1179	1695	java/io/IOException
    //   1206	1216	1695	java/io/IOException
    //   1242	1245	1695	java/io/IOException
    //   1269	1297	1695	java/io/IOException
    //   1318	1323	1695	java/io/IOException
    //   1344	1365	1695	java/io/IOException
    //   1386	1395	1695	java/io/IOException
    //   1416	1437	1695	java/io/IOException
    //   1497	1512	1695	java/io/IOException
    //   675	683	1711	java/net/SocketTimeoutException
    //   718	729	1711	java/net/SocketTimeoutException
    //   760	771	1711	java/net/SocketTimeoutException
    //   802	810	1711	java/net/SocketTimeoutException
    //   841	849	1711	java/net/SocketTimeoutException
    //   892	914	1711	java/net/SocketTimeoutException
    //   945	953	1711	java/net/SocketTimeoutException
    //   984	1007	1711	java/net/SocketTimeoutException
    //   1038	1058	1711	java/net/SocketTimeoutException
    //   1079	1115	1723	java/net/SocketTimeoutException
    //   1136	1143	1723	java/net/SocketTimeoutException
    //   1166	1179	1723	java/net/SocketTimeoutException
    //   1206	1216	1723	java/net/SocketTimeoutException
    //   1242	1245	1723	java/net/SocketTimeoutException
    //   1269	1297	1723	java/net/SocketTimeoutException
    //   1318	1323	1723	java/net/SocketTimeoutException
    //   1344	1365	1723	java/net/SocketTimeoutException
    //   1386	1395	1723	java/net/SocketTimeoutException
    //   1416	1437	1723	java/net/SocketTimeoutException
    //   1497	1512	1723	java/net/SocketTimeoutException
    //   675	683	1734	java/net/SocketException
    //   718	729	1734	java/net/SocketException
    //   760	771	1734	java/net/SocketException
    //   802	810	1734	java/net/SocketException
    //   841	849	1734	java/net/SocketException
    //   892	914	1734	java/net/SocketException
    //   945	953	1734	java/net/SocketException
    //   984	1007	1734	java/net/SocketException
    //   1038	1058	1734	java/net/SocketException
    //   1079	1115	1746	java/net/SocketException
    //   1136	1143	1746	java/net/SocketException
    //   1166	1179	1746	java/net/SocketException
    //   1206	1216	1746	java/net/SocketException
    //   1242	1245	1746	java/net/SocketException
    //   1269	1297	1746	java/net/SocketException
    //   1318	1323	1746	java/net/SocketException
    //   1344	1365	1746	java/net/SocketException
    //   1386	1395	1746	java/net/SocketException
    //   1416	1437	1746	java/net/SocketException
    //   1497	1512	1746	java/net/SocketException
    //   675	683	1753	javax/net/ssl/SSLHandshakeException
    //   718	729	1753	javax/net/ssl/SSLHandshakeException
    //   760	771	1753	javax/net/ssl/SSLHandshakeException
    //   802	810	1753	javax/net/ssl/SSLHandshakeException
    //   841	849	1753	javax/net/ssl/SSLHandshakeException
    //   892	914	1753	javax/net/ssl/SSLHandshakeException
    //   945	953	1753	javax/net/ssl/SSLHandshakeException
    //   984	1007	1753	javax/net/ssl/SSLHandshakeException
    //   1038	1058	1753	javax/net/ssl/SSLHandshakeException
    //   1079	1115	1765	javax/net/ssl/SSLHandshakeException
    //   1136	1143	1765	javax/net/ssl/SSLHandshakeException
    //   1166	1179	1765	javax/net/ssl/SSLHandshakeException
    //   1206	1216	1765	javax/net/ssl/SSLHandshakeException
    //   1242	1245	1765	javax/net/ssl/SSLHandshakeException
    //   1269	1297	1765	javax/net/ssl/SSLHandshakeException
    //   1318	1323	1765	javax/net/ssl/SSLHandshakeException
    //   1344	1365	1765	javax/net/ssl/SSLHandshakeException
    //   1386	1395	1765	javax/net/ssl/SSLHandshakeException
    //   1416	1437	1765	javax/net/ssl/SSLHandshakeException
    //   1497	1512	1765	javax/net/ssl/SSLHandshakeException
    //   675	683	1772	java/net/UnknownHostException
    //   718	729	1772	java/net/UnknownHostException
    //   760	771	1772	java/net/UnknownHostException
    //   802	810	1772	java/net/UnknownHostException
    //   841	849	1772	java/net/UnknownHostException
    //   892	914	1772	java/net/UnknownHostException
    //   945	953	1772	java/net/UnknownHostException
    //   984	1007	1772	java/net/UnknownHostException
    //   1038	1058	1772	java/net/UnknownHostException
    //   1079	1115	1784	java/net/UnknownHostException
    //   1136	1143	1784	java/net/UnknownHostException
    //   1166	1179	1784	java/net/UnknownHostException
    //   1206	1216	1784	java/net/UnknownHostException
    //   1242	1245	1784	java/net/UnknownHostException
    //   1269	1297	1784	java/net/UnknownHostException
    //   1318	1323	1784	java/net/UnknownHostException
    //   1344	1365	1784	java/net/UnknownHostException
    //   1386	1395	1784	java/net/UnknownHostException
    //   1416	1437	1784	java/net/UnknownHostException
    //   1497	1512	1784	java/net/UnknownHostException
    //   675	683	1820	java/lang/InterruptedException
    //   718	729	1820	java/lang/InterruptedException
    //   760	771	1820	java/lang/InterruptedException
    //   802	810	1820	java/lang/InterruptedException
    //   841	849	1820	java/lang/InterruptedException
    //   892	914	1820	java/lang/InterruptedException
    //   945	953	1820	java/lang/InterruptedException
    //   984	1007	1820	java/lang/InterruptedException
    //   1038	1058	1820	java/lang/InterruptedException
    //   1079	1115	1838	java/lang/InterruptedException
    //   1136	1143	1838	java/lang/InterruptedException
    //   1166	1179	1838	java/lang/InterruptedException
    //   1206	1216	1838	java/lang/InterruptedException
    //   1242	1245	1838	java/lang/InterruptedException
    //   1269	1297	1838	java/lang/InterruptedException
    //   1318	1323	1838	java/lang/InterruptedException
    //   1344	1365	1838	java/lang/InterruptedException
    //   1386	1395	1838	java/lang/InterruptedException
    //   1416	1437	1838	java/lang/InterruptedException
    //   1497	1512	1838	java/lang/InterruptedException
  }
  
  private static void a(e parame, HttpURLConnection paramHttpURLConnection)
  {
    y.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", new Object[] { parame.cls() });
    Object localObject = parame.clG();
    if ((localObject != null) && (((Collection)localObject).size() > 0))
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        paramHttpURLConnection.addRequestProperty(localb.name, localb.value);
      }
    }
    paramHttpURLConnection.setRequestMethod(parame.clF());
    if ("GET".equalsIgnoreCase(parame.clF())) {
      paramHttpURLConnection.setDoOutput(false);
    }
    paramHttpURLConnection.setConnectTimeout(parame.getConnectTimeout());
    paramHttpURLConnection.setReadTimeout(parame.getReadTimeout());
    paramHttpURLConnection.setUseCaches(false);
    if (parame.acc()) {
      paramHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
    }
    for (;;)
    {
      localObject = System.getProperty("http.agent");
      if (!bk.bl((String)localObject)) {
        paramHttpURLConnection.setRequestProperty("User-agent", (String)localObject);
      }
      if (!parame.acg()) {
        break;
      }
      paramHttpURLConnection.setInstanceFollowRedirects(true);
      return;
      paramHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    paramHttpURLConnection.setInstanceFollowRedirects(false);
  }
  
  private static m b(e parame, Exception paramException)
  {
    Object localObject2 = null;
    if ((paramException instanceof ProtocolException))
    {
      y.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", new Object[] { parame.cls(), parame.clF() });
      localObject1 = a(parame, paramException);
      return localObject1;
    }
    if ((paramException instanceof com.tencent.mm.pluginsdk.g.a.b.b))
    {
      y.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", new Object[] { parame.cls(), paramException.getClass().getSimpleName(), paramException.getMessage() });
      com.tencent.mm.pluginsdk.g.a.d.a.Wp(parame.bjl());
      return null;
    }
    Object localObject1 = rXy;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      if (localObject1[i].equals(paramException.getClass()))
      {
        y.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", new Object[] { parame.cls(), paramException });
        return new m(parame, paramException, 4);
      }
      i += 1;
    }
    Class[] arrayOfClass = rXA;
    j = arrayOfClass.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label221;
      }
      localObject1 = localObject2;
      if (arrayOfClass[i].equals(paramException.getClass())) {
        break;
      }
      i += 1;
    }
    label221:
    localObject1 = rXz;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      if (localObject1[i].equals(paramException.getClass())) {
        return a(parame, paramException);
      }
      i += 1;
    }
    return a(parame, paramException);
  }
  
  private static void clJ()
  {
    if (Thread.interrupted()) {
      throw new InterruptedException(Thread.currentThread().getName() + " has interrupted by someone!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.j
 * JD-Core Version:    0.7.0.1
 */