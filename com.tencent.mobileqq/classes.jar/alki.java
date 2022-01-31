import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class alki
{
  public static SSLContext a()
  {
    Object localObject = null;
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localObject = localSSLContext;
      localSSLContext.init(null, new TrustManager[] { new alkl() }, null);
      return localSSLContext;
    }
    catch (Exception localException) {}
    return localObject;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, alkf paramalkf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 10
    //   15: new 40	java/net/URL
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 43	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 47	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   26: checkcast 49	java/net/HttpURLConnection
    //   29: astore_0
    //   30: aload_0
    //   31: ldc 51
    //   33: invokevirtual 54	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: instanceof 56
    //   40: ifeq +29 -> 69
    //   43: invokestatic 58	alki:a	()Ljavax/net/ssl/SSLContext;
    //   46: astore 12
    //   48: aload 12
    //   50: ifnull +19 -> 69
    //   53: aload 12
    //   55: invokevirtual 62	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   58: astore 12
    //   60: aload_0
    //   61: checkcast 56	javax/net/ssl/HttpsURLConnection
    //   64: aload 12
    //   66: invokevirtual 66	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   69: aload_0
    //   70: sipush 8000
    //   73: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   76: aload_0
    //   77: sipush 8000
    //   80: invokevirtual 73	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   83: aload_0
    //   84: iconst_0
    //   85: invokevirtual 77	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   88: aload_0
    //   89: ldc 79
    //   91: aload_1
    //   92: invokevirtual 83	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: ldc 85
    //   98: aload_2
    //   99: invokevirtual 83	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_0
    //   103: ldc 87
    //   105: aload_3
    //   106: invokevirtual 83	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aconst_null
    //   110: astore_2
    //   111: iconst_0
    //   112: istore 6
    //   114: iload 6
    //   116: aload 4
    //   118: arraylength
    //   119: if_icmpge +87 -> 206
    //   122: iload 6
    //   124: iconst_2
    //   125: irem
    //   126: ifne +12 -> 138
    //   129: aload 4
    //   131: iload 6
    //   133: aaload
    //   134: astore_2
    //   135: goto +503 -> 638
    //   138: aload_0
    //   139: aload_2
    //   140: aload 4
    //   142: iload 6
    //   144: aaload
    //   145: invokevirtual 83	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto +490 -> 638
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_1
    //   154: aconst_null
    //   155: astore 4
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_0
    //   160: astore_3
    //   161: aload_1
    //   162: astore_0
    //   163: aload 4
    //   165: astore_1
    //   166: aload 5
    //   168: iconst_m1
    //   169: aconst_null
    //   170: invokevirtual 92	alkf:a	(I[B)V
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 100	java/io/OutputStream:close	()V
    //   189: aload_2
    //   190: ifnull +7 -> 197
    //   193: aload_2
    //   194: invokevirtual 103	java/io/InputStream:close	()V
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   205: return
    //   206: aload_0
    //   207: invokevirtual 110	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   210: astore_2
    //   211: aload 11
    //   213: astore 4
    //   215: aload_2
    //   216: aload_1
    //   217: invokevirtual 116	java/lang/String:getBytes	()[B
    //   220: invokevirtual 120	java/io/OutputStream:write	([B)V
    //   223: aload 11
    //   225: astore 4
    //   227: aload_2
    //   228: invokevirtual 123	java/io/OutputStream:flush	()V
    //   231: aload 11
    //   233: astore 4
    //   235: aload_0
    //   236: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
    //   239: istore 6
    //   241: aload 11
    //   243: astore 4
    //   245: aload_0
    //   246: invokevirtual 131	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   249: astore_1
    //   250: aload_1
    //   251: astore 4
    //   253: new 105	java/io/ByteArrayOutputStream
    //   256: dup
    //   257: invokespecial 132	java/io/ByteArrayOutputStream:<init>	()V
    //   260: astore_3
    //   261: sipush 1024
    //   264: newarray byte
    //   266: astore 4
    //   268: aload_1
    //   269: aload 4
    //   271: invokevirtual 136	java/io/InputStream:read	([B)I
    //   274: istore 7
    //   276: iload 7
    //   278: iconst_m1
    //   279: if_icmpeq +15 -> 294
    //   282: aload_3
    //   283: aload 4
    //   285: iconst_0
    //   286: iload 7
    //   288: invokevirtual 139	java/io/ByteArrayOutputStream:write	([BII)V
    //   291: goto -23 -> 268
    //   294: aload 5
    //   296: iload 6
    //   298: aload_3
    //   299: invokevirtual 142	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   302: invokevirtual 92	alkf:a	(I[B)V
    //   305: aload_0
    //   306: ifnull +7 -> 313
    //   309: aload_0
    //   310: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   313: aload_2
    //   314: ifnull +7 -> 321
    //   317: aload_2
    //   318: invokevirtual 100	java/io/OutputStream:close	()V
    //   321: aload_1
    //   322: ifnull +7 -> 329
    //   325: aload_1
    //   326: invokevirtual 103	java/io/InputStream:close	()V
    //   329: aload_3
    //   330: ifnull -125 -> 205
    //   333: aload_3
    //   334: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   337: return
    //   338: astore_0
    //   339: ldc 144
    //   341: iconst_1
    //   342: aload_0
    //   343: iconst_0
    //   344: anewarray 4	java/lang/Object
    //   347: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   350: return
    //   351: astore_0
    //   352: ldc 144
    //   354: iconst_1
    //   355: aload_0
    //   356: iconst_0
    //   357: anewarray 4	java/lang/Object
    //   360: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   363: goto -42 -> 321
    //   366: astore_0
    //   367: ldc 144
    //   369: iconst_1
    //   370: aload_0
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   378: goto -49 -> 329
    //   381: astore_1
    //   382: ldc 144
    //   384: iconst_1
    //   385: aload_1
    //   386: iconst_0
    //   387: anewarray 4	java/lang/Object
    //   390: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   393: goto -204 -> 189
    //   396: astore_1
    //   397: ldc 144
    //   399: iconst_1
    //   400: aload_1
    //   401: iconst_0
    //   402: anewarray 4	java/lang/Object
    //   405: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   408: goto -211 -> 197
    //   411: astore_0
    //   412: ldc 144
    //   414: iconst_1
    //   415: aload_0
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   423: return
    //   424: astore_0
    //   425: aload 9
    //   427: astore_1
    //   428: aload 8
    //   430: astore 5
    //   432: aload 10
    //   434: astore_3
    //   435: aload 12
    //   437: astore_2
    //   438: aload_2
    //   439: ifnull +7 -> 446
    //   442: aload_2
    //   443: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   446: aload_3
    //   447: ifnull +7 -> 454
    //   450: aload_3
    //   451: invokevirtual 100	java/io/OutputStream:close	()V
    //   454: aload_1
    //   455: ifnull +7 -> 462
    //   458: aload_1
    //   459: invokevirtual 103	java/io/InputStream:close	()V
    //   462: aload 5
    //   464: ifnull +8 -> 472
    //   467: aload 5
    //   469: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   472: aload_0
    //   473: athrow
    //   474: astore_2
    //   475: ldc 144
    //   477: iconst_1
    //   478: aload_2
    //   479: iconst_0
    //   480: anewarray 4	java/lang/Object
    //   483: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   486: goto -32 -> 454
    //   489: astore_1
    //   490: ldc 144
    //   492: iconst_1
    //   493: aload_1
    //   494: iconst_0
    //   495: anewarray 4	java/lang/Object
    //   498: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   501: goto -39 -> 462
    //   504: astore_1
    //   505: ldc 144
    //   507: iconst_1
    //   508: aload_1
    //   509: iconst_0
    //   510: anewarray 4	java/lang/Object
    //   513: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   516: goto -44 -> 472
    //   519: astore_1
    //   520: aload_0
    //   521: astore_2
    //   522: aload_1
    //   523: astore_0
    //   524: aload 10
    //   526: astore_3
    //   527: aload 8
    //   529: astore 5
    //   531: aload 9
    //   533: astore_1
    //   534: goto -96 -> 438
    //   537: astore_1
    //   538: aload_2
    //   539: astore_3
    //   540: aload_0
    //   541: astore_2
    //   542: aload_1
    //   543: astore_0
    //   544: aload 8
    //   546: astore 5
    //   548: aload 4
    //   550: astore_1
    //   551: goto -113 -> 438
    //   554: astore 4
    //   556: aload_3
    //   557: astore 5
    //   559: aload_2
    //   560: astore_3
    //   561: aload_0
    //   562: astore_2
    //   563: aload 4
    //   565: astore_0
    //   566: goto -128 -> 438
    //   569: astore 5
    //   571: aload_2
    //   572: astore 4
    //   574: aload 5
    //   576: astore_2
    //   577: aload_0
    //   578: astore 5
    //   580: aload_2
    //   581: astore_0
    //   582: aload_3
    //   583: astore_2
    //   584: aload_1
    //   585: astore_3
    //   586: aload 4
    //   588: astore_1
    //   589: goto -151 -> 438
    //   592: astore_0
    //   593: aconst_null
    //   594: astore_1
    //   595: aconst_null
    //   596: astore_2
    //   597: aconst_null
    //   598: astore_3
    //   599: aconst_null
    //   600: astore_0
    //   601: goto -435 -> 166
    //   604: astore_1
    //   605: aconst_null
    //   606: astore 4
    //   608: aload_0
    //   609: astore_3
    //   610: aload_2
    //   611: astore_1
    //   612: aconst_null
    //   613: astore_0
    //   614: aload 4
    //   616: astore_2
    //   617: goto -451 -> 166
    //   620: astore_3
    //   621: aload_1
    //   622: astore_3
    //   623: aload_0
    //   624: astore 4
    //   626: aload_2
    //   627: astore_1
    //   628: aconst_null
    //   629: astore_0
    //   630: aload_3
    //   631: astore_2
    //   632: aload 4
    //   634: astore_3
    //   635: goto -469 -> 166
    //   638: iload 6
    //   640: iconst_1
    //   641: iadd
    //   642: istore 6
    //   644: goto -530 -> 114
    //   647: astore 4
    //   649: aload_0
    //   650: astore 4
    //   652: aload_3
    //   653: astore_0
    //   654: aload_1
    //   655: astore_3
    //   656: aload_2
    //   657: astore_1
    //   658: aload_3
    //   659: astore_2
    //   660: aload 4
    //   662: astore_3
    //   663: goto -497 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	paramString1	String
    //   0	666	1	paramString2	String
    //   0	666	2	paramString3	String
    //   0	666	3	paramString4	String
    //   0	666	4	paramArrayOfString	String[]
    //   0	666	5	paramalkf	alkf
    //   112	531	6	i	int
    //   274	13	7	j	int
    //   10	535	8	localObject1	Object
    //   7	525	9	localObject2	Object
    //   13	512	10	localObject3	Object
    //   4	238	11	localObject4	Object
    //   1	435	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   30	48	151	java/lang/Throwable
    //   53	69	151	java/lang/Throwable
    //   69	109	151	java/lang/Throwable
    //   114	122	151	java/lang/Throwable
    //   138	148	151	java/lang/Throwable
    //   206	211	151	java/lang/Throwable
    //   333	337	338	java/io/IOException
    //   317	321	351	java/io/IOException
    //   325	329	366	java/io/IOException
    //   185	189	381	java/io/IOException
    //   193	197	396	java/io/IOException
    //   201	205	411	java/io/IOException
    //   15	30	424	finally
    //   450	454	474	java/io/IOException
    //   458	462	489	java/io/IOException
    //   467	472	504	java/io/IOException
    //   30	48	519	finally
    //   53	69	519	finally
    //   69	109	519	finally
    //   114	122	519	finally
    //   138	148	519	finally
    //   206	211	519	finally
    //   215	223	537	finally
    //   227	231	537	finally
    //   235	241	537	finally
    //   245	250	537	finally
    //   253	261	537	finally
    //   261	268	554	finally
    //   268	276	554	finally
    //   282	291	554	finally
    //   294	305	554	finally
    //   166	173	569	finally
    //   15	30	592	java/lang/Throwable
    //   215	223	604	java/lang/Throwable
    //   227	231	604	java/lang/Throwable
    //   235	241	604	java/lang/Throwable
    //   245	250	604	java/lang/Throwable
    //   253	261	620	java/lang/Throwable
    //   261	268	647	java/lang/Throwable
    //   268	276	647	java/lang/Throwable
    //   282	291	647	java/lang/Throwable
    //   294	305	647	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String[] paramArrayOfString, alkf paramalkf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 9
    //   15: new 40	java/net/URL
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 43	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 47	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   26: checkcast 49	java/net/HttpURLConnection
    //   29: astore_1
    //   30: aload_1
    //   31: aload_0
    //   32: invokevirtual 54	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: instanceof 56
    //   39: ifeq +24 -> 63
    //   42: invokestatic 58	alki:a	()Ljavax/net/ssl/SSLContext;
    //   45: astore_0
    //   46: aload_0
    //   47: ifnull +16 -> 63
    //   50: aload_0
    //   51: invokevirtual 62	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   54: astore_0
    //   55: aload_1
    //   56: checkcast 56	javax/net/ssl/HttpsURLConnection
    //   59: aload_0
    //   60: invokevirtual 66	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   63: aload_1
    //   64: sipush 8000
    //   67: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   70: aload_1
    //   71: sipush 8000
    //   74: invokevirtual 73	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   77: aload_1
    //   78: iconst_0
    //   79: invokevirtual 77	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   82: aconst_null
    //   83: astore_0
    //   84: iconst_0
    //   85: istore 5
    //   87: iload 5
    //   89: aload_3
    //   90: arraylength
    //   91: if_icmpge +83 -> 174
    //   94: iload 5
    //   96: iconst_2
    //   97: irem
    //   98: ifne +11 -> 109
    //   101: aload_3
    //   102: iload 5
    //   104: aaload
    //   105: astore_0
    //   106: goto +487 -> 593
    //   109: aload_1
    //   110: aload_0
    //   111: aload_3
    //   112: iload 5
    //   114: aaload
    //   115: invokevirtual 83	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto +475 -> 593
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_0
    //   124: aconst_null
    //   125: astore 7
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_1
    //   130: astore_3
    //   131: aload 7
    //   133: astore_1
    //   134: aload 4
    //   136: iconst_m1
    //   137: aconst_null
    //   138: invokevirtual 92	alkf:a	(I[B)V
    //   141: aload_3
    //   142: ifnull +7 -> 149
    //   145: aload_3
    //   146: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 100	java/io/OutputStream:close	()V
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 103	java/io/InputStream:close	()V
    //   165: aload_0
    //   166: ifnull +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   173: return
    //   174: aload_1
    //   175: invokevirtual 110	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   178: astore_0
    //   179: aload 10
    //   181: astore 7
    //   183: aload_0
    //   184: aload_2
    //   185: invokevirtual 120	java/io/OutputStream:write	([B)V
    //   188: aload 10
    //   190: astore 7
    //   192: aload_0
    //   193: invokevirtual 123	java/io/OutputStream:flush	()V
    //   196: aload 10
    //   198: astore 7
    //   200: aload_1
    //   201: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
    //   204: istore 5
    //   206: aload 10
    //   208: astore 7
    //   210: aload_1
    //   211: invokevirtual 131	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   214: astore_2
    //   215: aload_2
    //   216: astore 7
    //   218: new 105	java/io/ByteArrayOutputStream
    //   221: dup
    //   222: invokespecial 132	java/io/ByteArrayOutputStream:<init>	()V
    //   225: astore_3
    //   226: sipush 1024
    //   229: newarray byte
    //   231: astore 7
    //   233: aload_2
    //   234: aload 7
    //   236: invokevirtual 136	java/io/InputStream:read	([B)I
    //   239: istore 6
    //   241: iload 6
    //   243: iconst_m1
    //   244: if_icmpeq +15 -> 259
    //   247: aload_3
    //   248: aload 7
    //   250: iconst_0
    //   251: iload 6
    //   253: invokevirtual 139	java/io/ByteArrayOutputStream:write	([BII)V
    //   256: goto -23 -> 233
    //   259: aload 4
    //   261: iload 5
    //   263: aload_3
    //   264: invokevirtual 142	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   267: invokevirtual 92	alkf:a	(I[B)V
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   278: aload_0
    //   279: ifnull +7 -> 286
    //   282: aload_0
    //   283: invokevirtual 100	java/io/OutputStream:close	()V
    //   286: aload_2
    //   287: ifnull +7 -> 294
    //   290: aload_2
    //   291: invokevirtual 103	java/io/InputStream:close	()V
    //   294: aload_3
    //   295: ifnull -122 -> 173
    //   298: aload_3
    //   299: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   302: return
    //   303: astore_0
    //   304: ldc 144
    //   306: iconst_1
    //   307: aload_0
    //   308: iconst_0
    //   309: anewarray 4	java/lang/Object
    //   312: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   315: return
    //   316: astore_0
    //   317: ldc 144
    //   319: iconst_1
    //   320: aload_0
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   328: goto -42 -> 286
    //   331: astore_0
    //   332: ldc 144
    //   334: iconst_1
    //   335: aload_0
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   343: goto -49 -> 294
    //   346: astore_1
    //   347: ldc 144
    //   349: iconst_1
    //   350: aload_1
    //   351: iconst_0
    //   352: anewarray 4	java/lang/Object
    //   355: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   358: goto -201 -> 157
    //   361: astore_1
    //   362: ldc 144
    //   364: iconst_1
    //   365: aload_1
    //   366: iconst_0
    //   367: anewarray 4	java/lang/Object
    //   370: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   373: goto -208 -> 165
    //   376: astore_0
    //   377: ldc 144
    //   379: iconst_1
    //   380: aload_0
    //   381: iconst_0
    //   382: anewarray 4	java/lang/Object
    //   385: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   388: return
    //   389: astore_0
    //   390: aload 7
    //   392: astore_2
    //   393: aload 8
    //   395: astore 4
    //   397: aload 9
    //   399: astore_3
    //   400: aload 11
    //   402: astore_1
    //   403: aload_1
    //   404: ifnull +7 -> 411
    //   407: aload_1
    //   408: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   411: aload_3
    //   412: ifnull +7 -> 419
    //   415: aload_3
    //   416: invokevirtual 100	java/io/OutputStream:close	()V
    //   419: aload_2
    //   420: ifnull +7 -> 427
    //   423: aload_2
    //   424: invokevirtual 103	java/io/InputStream:close	()V
    //   427: aload 4
    //   429: ifnull +8 -> 437
    //   432: aload 4
    //   434: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   437: aload_0
    //   438: athrow
    //   439: astore_1
    //   440: ldc 144
    //   442: iconst_1
    //   443: aload_1
    //   444: iconst_0
    //   445: anewarray 4	java/lang/Object
    //   448: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   451: goto -32 -> 419
    //   454: astore_1
    //   455: ldc 144
    //   457: iconst_1
    //   458: aload_1
    //   459: iconst_0
    //   460: anewarray 4	java/lang/Object
    //   463: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   466: goto -39 -> 427
    //   469: astore_1
    //   470: ldc 144
    //   472: iconst_1
    //   473: aload_1
    //   474: iconst_0
    //   475: anewarray 4	java/lang/Object
    //   478: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   481: goto -44 -> 437
    //   484: astore_0
    //   485: aload 9
    //   487: astore_3
    //   488: aload 8
    //   490: astore 4
    //   492: aload 7
    //   494: astore_2
    //   495: goto -92 -> 403
    //   498: astore_2
    //   499: aload_0
    //   500: astore_3
    //   501: aload_2
    //   502: astore_0
    //   503: aload 8
    //   505: astore 4
    //   507: aload 7
    //   509: astore_2
    //   510: goto -107 -> 403
    //   513: astore 7
    //   515: aload_3
    //   516: astore 4
    //   518: aload_0
    //   519: astore_3
    //   520: aload 7
    //   522: astore_0
    //   523: goto -120 -> 403
    //   526: astore 7
    //   528: aload_1
    //   529: astore 4
    //   531: aload 7
    //   533: astore_1
    //   534: aload_0
    //   535: astore 7
    //   537: aload_1
    //   538: astore_0
    //   539: aload_3
    //   540: astore_1
    //   541: aload 4
    //   543: astore_3
    //   544: aload 7
    //   546: astore 4
    //   548: goto -145 -> 403
    //   551: astore_0
    //   552: aconst_null
    //   553: astore_1
    //   554: aconst_null
    //   555: astore_2
    //   556: aconst_null
    //   557: astore_3
    //   558: aconst_null
    //   559: astore_0
    //   560: goto -426 -> 134
    //   563: astore_2
    //   564: aconst_null
    //   565: astore_2
    //   566: aload_1
    //   567: astore_3
    //   568: aconst_null
    //   569: astore 7
    //   571: aload_0
    //   572: astore_1
    //   573: aload 7
    //   575: astore_0
    //   576: goto -442 -> 134
    //   579: astore_3
    //   580: aload_1
    //   581: astore_3
    //   582: aconst_null
    //   583: astore 7
    //   585: aload_0
    //   586: astore_1
    //   587: aload 7
    //   589: astore_0
    //   590: goto -456 -> 134
    //   593: iload 5
    //   595: iconst_1
    //   596: iadd
    //   597: istore 5
    //   599: goto -512 -> 87
    //   602: astore 7
    //   604: aload_1
    //   605: astore 7
    //   607: aload_0
    //   608: astore_1
    //   609: aload_3
    //   610: astore_0
    //   611: aload 7
    //   613: astore_3
    //   614: goto -480 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	paramString1	String
    //   0	617	1	paramString2	String
    //   0	617	2	paramArrayOfByte	byte[]
    //   0	617	3	paramArrayOfString	String[]
    //   0	617	4	paramalkf	alkf
    //   85	513	5	i	int
    //   239	13	6	j	int
    //   7	501	7	localObject1	Object
    //   513	8	7	localObject2	Object
    //   526	6	7	localObject3	Object
    //   535	53	7	str1	String
    //   602	1	7	localThrowable	java.lang.Throwable
    //   605	7	7	str2	String
    //   10	494	8	localObject4	Object
    //   13	473	9	localObject5	Object
    //   4	203	10	localObject6	Object
    //   1	400	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   30	46	121	java/lang/Throwable
    //   50	63	121	java/lang/Throwable
    //   63	82	121	java/lang/Throwable
    //   87	94	121	java/lang/Throwable
    //   109	118	121	java/lang/Throwable
    //   174	179	121	java/lang/Throwable
    //   298	302	303	java/io/IOException
    //   282	286	316	java/io/IOException
    //   290	294	331	java/io/IOException
    //   153	157	346	java/io/IOException
    //   161	165	361	java/io/IOException
    //   169	173	376	java/io/IOException
    //   15	30	389	finally
    //   415	419	439	java/io/IOException
    //   423	427	454	java/io/IOException
    //   432	437	469	java/io/IOException
    //   30	46	484	finally
    //   50	63	484	finally
    //   63	82	484	finally
    //   87	94	484	finally
    //   109	118	484	finally
    //   174	179	484	finally
    //   183	188	498	finally
    //   192	196	498	finally
    //   200	206	498	finally
    //   210	215	498	finally
    //   218	226	498	finally
    //   226	233	513	finally
    //   233	241	513	finally
    //   247	256	513	finally
    //   259	270	513	finally
    //   134	141	526	finally
    //   15	30	551	java/lang/Throwable
    //   183	188	563	java/lang/Throwable
    //   192	196	563	java/lang/Throwable
    //   200	206	563	java/lang/Throwable
    //   210	215	563	java/lang/Throwable
    //   218	226	579	java/lang/Throwable
    //   226	233	602	java/lang/Throwable
    //   233	241	602	java/lang/Throwable
    //   247	256	602	java/lang/Throwable
    //   259	270	602	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String[] paramArrayOfString, alkf paramalkf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: new 40	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 43	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 47	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 49	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc 51
    //   24: invokevirtual 54	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: instanceof 56
    //   31: ifeq +29 -> 60
    //   34: invokestatic 58	alki:a	()Ljavax/net/ssl/SSLContext;
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +19 -> 60
    //   44: aload 6
    //   46: invokevirtual 62	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   49: astore 6
    //   51: aload_0
    //   52: checkcast 56	javax/net/ssl/HttpsURLConnection
    //   55: aload 6
    //   57: invokevirtual 66	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   60: aload_0
    //   61: sipush 8000
    //   64: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   67: aload_0
    //   68: sipush 8000
    //   71: invokevirtual 73	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   74: aload_0
    //   75: iconst_0
    //   76: invokevirtual 77	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   79: iconst_0
    //   80: istore 4
    //   82: aconst_null
    //   83: astore 6
    //   85: iload 4
    //   87: aload_2
    //   88: arraylength
    //   89: if_icmpge +88 -> 177
    //   92: iload 4
    //   94: iconst_2
    //   95: irem
    //   96: ifne +12 -> 108
    //   99: aload_2
    //   100: iload 4
    //   102: aaload
    //   103: astore 6
    //   105: goto +505 -> 610
    //   108: aload_0
    //   109: aload 6
    //   111: aload_2
    //   112: iload 4
    //   114: aaload
    //   115: invokevirtual 83	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto +492 -> 610
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_1
    //   124: aconst_null
    //   125: astore 7
    //   127: aload_0
    //   128: astore_2
    //   129: aload 8
    //   131: astore 6
    //   133: aload 7
    //   135: astore_0
    //   136: aload_3
    //   137: iconst_m1
    //   138: aconst_null
    //   139: invokevirtual 92	alkf:a	(I[B)V
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 100	java/io/OutputStream:close	()V
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 103	java/io/InputStream:close	()V
    //   166: aload 6
    //   168: ifnull +8 -> 176
    //   171: aload 6
    //   173: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   176: return
    //   177: aload_0
    //   178: invokevirtual 110	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   181: astore_2
    //   182: aload_2
    //   183: aload_1
    //   184: invokevirtual 116	java/lang/String:getBytes	()[B
    //   187: invokevirtual 120	java/io/OutputStream:write	([B)V
    //   190: aload_2
    //   191: invokevirtual 123	java/io/OutputStream:flush	()V
    //   194: aload_0
    //   195: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
    //   198: istore 4
    //   200: aload_0
    //   201: invokevirtual 131	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   204: astore 6
    //   206: new 105	java/io/ByteArrayOutputStream
    //   209: dup
    //   210: invokespecial 132	java/io/ByteArrayOutputStream:<init>	()V
    //   213: astore 7
    //   215: sipush 1024
    //   218: newarray byte
    //   220: astore_1
    //   221: aload 6
    //   223: aload_1
    //   224: invokevirtual 136	java/io/InputStream:read	([B)I
    //   227: istore 5
    //   229: iload 5
    //   231: iconst_m1
    //   232: if_icmpeq +15 -> 247
    //   235: aload 7
    //   237: aload_1
    //   238: iconst_0
    //   239: iload 5
    //   241: invokevirtual 139	java/io/ByteArrayOutputStream:write	([BII)V
    //   244: goto -23 -> 221
    //   247: aload_3
    //   248: iload 4
    //   250: aload 7
    //   252: invokevirtual 142	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   255: invokevirtual 92	alkf:a	(I[B)V
    //   258: aload_0
    //   259: ifnull +7 -> 266
    //   262: aload_0
    //   263: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 100	java/io/OutputStream:close	()V
    //   274: aload 6
    //   276: ifnull +8 -> 284
    //   279: aload 6
    //   281: invokevirtual 103	java/io/InputStream:close	()V
    //   284: aload 7
    //   286: ifnull -110 -> 176
    //   289: aload 7
    //   291: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   294: return
    //   295: astore_0
    //   296: ldc 144
    //   298: iconst_1
    //   299: aload_0
    //   300: iconst_0
    //   301: anewarray 4	java/lang/Object
    //   304: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   307: return
    //   308: astore_0
    //   309: ldc 144
    //   311: iconst_1
    //   312: aload_0
    //   313: iconst_0
    //   314: anewarray 4	java/lang/Object
    //   317: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   320: goto -46 -> 274
    //   323: astore_0
    //   324: ldc 144
    //   326: iconst_1
    //   327: aload_0
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   335: goto -51 -> 284
    //   338: astore_0
    //   339: ldc 144
    //   341: iconst_1
    //   342: aload_0
    //   343: iconst_0
    //   344: anewarray 4	java/lang/Object
    //   347: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   350: goto -192 -> 158
    //   353: astore_0
    //   354: ldc 144
    //   356: iconst_1
    //   357: aload_0
    //   358: iconst_0
    //   359: anewarray 4	java/lang/Object
    //   362: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   365: goto -199 -> 166
    //   368: astore_0
    //   369: ldc 144
    //   371: iconst_1
    //   372: aload_0
    //   373: iconst_0
    //   374: anewarray 4	java/lang/Object
    //   377: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   380: return
    //   381: astore_0
    //   382: aconst_null
    //   383: astore_2
    //   384: aconst_null
    //   385: astore 6
    //   387: aconst_null
    //   388: astore_1
    //   389: aload 7
    //   391: astore_3
    //   392: aload_1
    //   393: ifnull +7 -> 400
    //   396: aload_1
    //   397: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   400: aload_3
    //   401: ifnull +7 -> 408
    //   404: aload_3
    //   405: invokevirtual 100	java/io/OutputStream:close	()V
    //   408: aload 6
    //   410: ifnull +8 -> 418
    //   413: aload 6
    //   415: invokevirtual 103	java/io/InputStream:close	()V
    //   418: aload_2
    //   419: ifnull +7 -> 426
    //   422: aload_2
    //   423: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   426: aload_0
    //   427: athrow
    //   428: astore_1
    //   429: ldc 144
    //   431: iconst_1
    //   432: aload_1
    //   433: iconst_0
    //   434: anewarray 4	java/lang/Object
    //   437: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   440: goto -32 -> 408
    //   443: astore_1
    //   444: ldc 144
    //   446: iconst_1
    //   447: aload_1
    //   448: iconst_0
    //   449: anewarray 4	java/lang/Object
    //   452: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   455: goto -37 -> 418
    //   458: astore_1
    //   459: ldc 144
    //   461: iconst_1
    //   462: aload_1
    //   463: iconst_0
    //   464: anewarray 4	java/lang/Object
    //   467: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   470: goto -44 -> 426
    //   473: astore_3
    //   474: aconst_null
    //   475: astore_2
    //   476: aconst_null
    //   477: astore 6
    //   479: aload_0
    //   480: astore_1
    //   481: aload_3
    //   482: astore_0
    //   483: aload 7
    //   485: astore_3
    //   486: goto -94 -> 392
    //   489: astore_3
    //   490: aconst_null
    //   491: astore 6
    //   493: aload_0
    //   494: astore_1
    //   495: aload_3
    //   496: astore_0
    //   497: aconst_null
    //   498: astore 7
    //   500: aload_2
    //   501: astore_3
    //   502: aload 7
    //   504: astore_2
    //   505: goto -113 -> 392
    //   508: astore_3
    //   509: aconst_null
    //   510: astore 7
    //   512: aload_0
    //   513: astore_1
    //   514: aload_3
    //   515: astore_0
    //   516: aload_2
    //   517: astore_3
    //   518: aload 7
    //   520: astore_2
    //   521: goto -129 -> 392
    //   524: astore_3
    //   525: aload_0
    //   526: astore_1
    //   527: aload_3
    //   528: astore_0
    //   529: aload_2
    //   530: astore_3
    //   531: aload 7
    //   533: astore_2
    //   534: goto -142 -> 392
    //   537: astore 8
    //   539: aload_1
    //   540: astore 7
    //   542: aload_2
    //   543: astore_1
    //   544: aload 6
    //   546: astore_2
    //   547: aload_0
    //   548: astore_3
    //   549: aload 8
    //   551: astore_0
    //   552: aload 7
    //   554: astore 6
    //   556: goto -164 -> 392
    //   559: astore_0
    //   560: aconst_null
    //   561: astore_0
    //   562: aconst_null
    //   563: astore_1
    //   564: aconst_null
    //   565: astore_2
    //   566: aload 8
    //   568: astore 6
    //   570: goto -434 -> 136
    //   573: astore_1
    //   574: aload_0
    //   575: astore 7
    //   577: aload_2
    //   578: astore_0
    //   579: aconst_null
    //   580: astore_1
    //   581: aload 8
    //   583: astore 6
    //   585: aload 7
    //   587: astore_2
    //   588: goto -452 -> 136
    //   591: astore_1
    //   592: aload_0
    //   593: astore 7
    //   595: aload_2
    //   596: astore_0
    //   597: aload 6
    //   599: astore_1
    //   600: aload 8
    //   602: astore 6
    //   604: aload 7
    //   606: astore_2
    //   607: goto -471 -> 136
    //   610: iload 4
    //   612: iconst_1
    //   613: iadd
    //   614: istore 4
    //   616: goto -531 -> 85
    //   619: astore_1
    //   620: aload_0
    //   621: astore 8
    //   623: aload_2
    //   624: astore_0
    //   625: aload 6
    //   627: astore_1
    //   628: aload 7
    //   630: astore 6
    //   632: aload 8
    //   634: astore_2
    //   635: goto -499 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	paramString1	String
    //   0	638	1	paramString2	String
    //   0	638	2	paramArrayOfString	String[]
    //   0	638	3	paramalkf	alkf
    //   80	535	4	i	int
    //   227	13	5	j	int
    //   37	594	6	localObject1	Object
    //   1	628	7	localObject2	Object
    //   4	126	8	localObject3	Object
    //   537	64	8	localObject4	Object
    //   621	12	8	str	String
    // Exception table:
    //   from	to	target	type
    //   21	39	121	java/lang/Throwable
    //   44	60	121	java/lang/Throwable
    //   60	79	121	java/lang/Throwable
    //   85	92	121	java/lang/Throwable
    //   108	118	121	java/lang/Throwable
    //   177	182	121	java/lang/Throwable
    //   289	294	295	java/io/IOException
    //   270	274	308	java/io/IOException
    //   279	284	323	java/io/IOException
    //   154	158	338	java/io/IOException
    //   162	166	353	java/io/IOException
    //   171	176	368	java/io/IOException
    //   6	21	381	finally
    //   404	408	428	java/io/IOException
    //   413	418	443	java/io/IOException
    //   422	426	458	java/io/IOException
    //   21	39	473	finally
    //   44	60	473	finally
    //   60	79	473	finally
    //   85	92	473	finally
    //   108	118	473	finally
    //   177	182	473	finally
    //   182	206	489	finally
    //   206	215	508	finally
    //   215	221	524	finally
    //   221	229	524	finally
    //   235	244	524	finally
    //   247	258	524	finally
    //   136	142	537	finally
    //   6	21	559	java/lang/Throwable
    //   182	206	573	java/lang/Throwable
    //   206	215	591	java/lang/Throwable
    //   215	221	619	java/lang/Throwable
    //   221	229	619	java/lang/Throwable
    //   235	244	619	java/lang/Throwable
    //   247	258	619	java/lang/Throwable
  }
  
  public static void a(@NonNull String paramString1, @NonNull String paramString2, @Nullable String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte, @NonNull alkh paramalkh, @Nullable alkg paramalkg1, @Nullable alkg paramalkg2)
  {
    if (paramalkh == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramalkh.a(-1, null, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest urlString:", paramString1 });
    }
    int i = paramString1.indexOf("http://stubcmshow.qq.com/cm3d/");
    if (i >= 0) {}
    for (paramString2 = paramString1.substring(i + "http://stubcmshow.qq.com/cm3d/".length());; paramString2 = paramString1)
    {
      int j;
      for (;;)
      {
        i = paramString1.indexOf("https://stubcmshow.qq.com/cm3d/");
        if (i >= 0) {
          paramString2 = paramString1.substring("https://stubcmshow.qq.com/cm3d/".length() + i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest localUrl:", paramString2 });
        }
        if (TextUtils.isEmpty(paramString2))
        {
          paramalkh.a(-1, null, null);
          return;
        }
        try
        {
          if (!paramString2.startsWith("Role:")) {
            break label473;
          }
          paramString1 = paramString2.substring("Role:".length() + "//".length());
          i = paramString1.indexOf("/");
          if (i <= 0) {
            break;
          }
          j = ApolloUtil.b(paramString1.substring(0, i));
          paramString1 = paramString1.substring("/".length() + i);
          if (TextUtils.isEmpty(paramString1))
          {
            paramalkh.a(-1, null, null);
            return;
          }
        }
        catch (Exception paramString1)
        {
          QLog.e("ApolloHttpUtil", 1, paramString1, new Object[0]);
          return;
        }
      }
      paramString1 = aliu.g + j + File.separator + paramString1;
      paramString2 = new File(paramString1);
      if (paramString2.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", paramString2.getAbsolutePath() });
        }
        paramArrayOfString = b(paramArrayOfString);
        if (a(paramString1))
        {
          paramString1 = b(paramString2, paramArrayOfString);
          paramalkh.a(0, paramArrayOfString, paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retByteArray:", Integer.valueOf(paramString1.length) });
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
          return;
          paramalkh.a(0, paramArrayOfString, ApolloRender.readStream(new FileInputStream(paramString2)));
        }
        break;
      }
      QLog.d("ApolloHttpUtil", 1, "fakeResource3DUrlRequest start download id:" + j);
      aldv.b(akwd.a(), null, new alkj(paramString1, paramArrayOfString, paramalkh), j, null, -1, -1, false);
      return;
      label473:
      if (paramString2.startsWith("Dress:"))
      {
        paramString1 = paramString2.substring("Dress:".length() + "//".length());
        i = paramString1.indexOf("/");
        if (i <= 0) {
          break;
        }
        j = ApolloUtil.b(paramString1.substring(0, i));
        paramString1 = paramString1.substring("/".length() + i);
        if (TextUtils.isEmpty(paramString1))
        {
          paramalkh.a(-1, null, null);
          return;
        }
        paramString1 = aliu.f + j + File.separator + paramString1;
        paramString2 = new File(paramString1);
        if (paramString2.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", paramString2.getAbsolutePath() });
          }
          paramArrayOfString = b(paramArrayOfString);
          if (a(paramString1)) {
            paramalkh.a(0, paramArrayOfString, b(paramString2, paramArrayOfString));
          }
          while (QLog.isColorLevel())
          {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
            return;
            paramalkh.a(0, paramArrayOfString, ApolloRender.readStream(new FileInputStream(paramString2)));
          }
          break;
        }
        QLog.d("ApolloHttpUtil", 1, "fakeResource3DUrlRequest start download id:" + j);
        aldv.b(akwd.a(), null, new alkk(paramString1, paramArrayOfString, paramalkh, j), -1, new int[] { j }, -1, -1, true);
        return;
      }
      if (!paramString2.startsWith("def/role/0/3D/")) {
        break;
      }
      paramString1 = aliu.c + File.separator + paramString2;
      paramString2 = new File(paramString1);
      if (paramString2.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest file exists:", paramString2.getAbsolutePath() });
        }
        paramArrayOfString = b(paramArrayOfString);
        if (a(paramString1)) {
          paramalkh.a(0, paramArrayOfString, b(paramString2, paramArrayOfString));
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest retHeader:", paramArrayOfString });
          return;
          paramalkh.a(0, paramArrayOfString, ApolloRender.readStream(new FileInputStream(paramString2)));
        }
        break;
      }
      QLog.d("ApolloHttpUtil", 1, new Object[] { "fakeResource3DUrlRequest file no exists", paramString2.getAbsolutePath() });
      return;
    }
  }
  
  /* Error */
  public static void a(String paramString, String[] paramArrayOfString, alkf paramalkf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: new 40	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 43	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 47	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 49	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ldc_w 311
    //   25: invokevirtual 54	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: instanceof 56
    //   32: ifeq +29 -> 61
    //   35: invokestatic 58	alki:a	()Ljavax/net/ssl/SSLContext;
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull +19 -> 61
    //   45: aload 5
    //   47: invokevirtual 62	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   50: astore 5
    //   52: aload_0
    //   53: checkcast 56	javax/net/ssl/HttpsURLConnection
    //   56: aload 5
    //   58: invokevirtual 66	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   61: aload_0
    //   62: sipush 8000
    //   65: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   68: aload_0
    //   69: sipush 8000
    //   72: invokevirtual 73	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   75: aload_1
    //   76: ifnull +90 -> 166
    //   79: iconst_0
    //   80: istore_3
    //   81: aconst_null
    //   82: astore 5
    //   84: iload_3
    //   85: aload_1
    //   86: arraylength
    //   87: if_icmpge +79 -> 166
    //   90: iload_3
    //   91: iconst_2
    //   92: irem
    //   93: ifne +11 -> 104
    //   96: aload_1
    //   97: iload_3
    //   98: aaload
    //   99: astore 5
    //   101: goto +348 -> 449
    //   104: aload_0
    //   105: aload 5
    //   107: aload_1
    //   108: iload_3
    //   109: aaload
    //   110: invokevirtual 83	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: goto +336 -> 449
    //   116: astore_1
    //   117: aconst_null
    //   118: astore 6
    //   120: aload 7
    //   122: astore 5
    //   124: aload_0
    //   125: astore_1
    //   126: aload 6
    //   128: astore_0
    //   129: aload_2
    //   130: ifnull +9 -> 139
    //   133: aload_2
    //   134: iconst_m1
    //   135: aconst_null
    //   136: invokevirtual 92	alkf:a	(I[B)V
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   147: aload 5
    //   149: ifnull +8 -> 157
    //   152: aload 5
    //   154: invokevirtual 103	java/io/InputStream:close	()V
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   165: return
    //   166: aload_0
    //   167: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
    //   170: istore_3
    //   171: aload_0
    //   172: invokevirtual 131	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   175: astore 5
    //   177: new 105	java/io/ByteArrayOutputStream
    //   180: dup
    //   181: invokespecial 132	java/io/ByteArrayOutputStream:<init>	()V
    //   184: astore_1
    //   185: sipush 1024
    //   188: newarray byte
    //   190: astore 6
    //   192: aload 5
    //   194: aload 6
    //   196: invokevirtual 136	java/io/InputStream:read	([B)I
    //   199: istore 4
    //   201: iload 4
    //   203: iconst_m1
    //   204: if_icmpeq +15 -> 219
    //   207: aload_1
    //   208: aload 6
    //   210: iconst_0
    //   211: iload 4
    //   213: invokevirtual 139	java/io/ByteArrayOutputStream:write	([BII)V
    //   216: goto -24 -> 192
    //   219: aload_2
    //   220: ifnull +12 -> 232
    //   223: aload_2
    //   224: iload_3
    //   225: aload_1
    //   226: invokevirtual 142	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   229: invokevirtual 92	alkf:a	(I[B)V
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   240: aload 5
    //   242: ifnull +8 -> 250
    //   245: aload 5
    //   247: invokevirtual 103	java/io/InputStream:close	()V
    //   250: aload_1
    //   251: ifnull -86 -> 165
    //   254: aload_1
    //   255: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   258: return
    //   259: astore_0
    //   260: ldc 144
    //   262: iconst_1
    //   263: aload_0
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   271: return
    //   272: astore_0
    //   273: ldc 144
    //   275: iconst_1
    //   276: aload_0
    //   277: iconst_0
    //   278: anewarray 4	java/lang/Object
    //   281: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   284: goto -34 -> 250
    //   287: astore_1
    //   288: ldc 144
    //   290: iconst_1
    //   291: aload_1
    //   292: iconst_0
    //   293: anewarray 4	java/lang/Object
    //   296: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   299: goto -142 -> 157
    //   302: astore_0
    //   303: ldc 144
    //   305: iconst_1
    //   306: aload_0
    //   307: iconst_0
    //   308: anewarray 4	java/lang/Object
    //   311: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   314: return
    //   315: astore_0
    //   316: aconst_null
    //   317: astore 5
    //   319: aconst_null
    //   320: astore_1
    //   321: aload 6
    //   323: astore_2
    //   324: aload_1
    //   325: ifnull +7 -> 332
    //   328: aload_1
    //   329: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   332: aload 5
    //   334: ifnull +8 -> 342
    //   337: aload 5
    //   339: invokevirtual 103	java/io/InputStream:close	()V
    //   342: aload_2
    //   343: ifnull +7 -> 350
    //   346: aload_2
    //   347: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   350: aload_0
    //   351: athrow
    //   352: astore_1
    //   353: ldc 144
    //   355: iconst_1
    //   356: aload_1
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   364: goto -22 -> 342
    //   367: astore_1
    //   368: ldc 144
    //   370: iconst_1
    //   371: aload_1
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   379: goto -29 -> 350
    //   382: astore_2
    //   383: aconst_null
    //   384: astore 5
    //   386: aload_0
    //   387: astore_1
    //   388: aload_2
    //   389: astore_0
    //   390: aload 6
    //   392: astore_2
    //   393: goto -69 -> 324
    //   396: astore_2
    //   397: aload_0
    //   398: astore_1
    //   399: aload_2
    //   400: astore_0
    //   401: aload 6
    //   403: astore_2
    //   404: goto -80 -> 324
    //   407: astore 6
    //   409: aload_1
    //   410: astore_2
    //   411: aload_0
    //   412: astore_1
    //   413: aload 6
    //   415: astore_0
    //   416: goto -92 -> 324
    //   419: astore 6
    //   421: aload_0
    //   422: astore_2
    //   423: aload 6
    //   425: astore_0
    //   426: goto -102 -> 324
    //   429: astore_0
    //   430: aconst_null
    //   431: astore_0
    //   432: aconst_null
    //   433: astore_1
    //   434: aload 7
    //   436: astore 5
    //   438: goto -309 -> 129
    //   441: astore_1
    //   442: aload_0
    //   443: astore_1
    //   444: aconst_null
    //   445: astore_0
    //   446: goto -317 -> 129
    //   449: iload_3
    //   450: iconst_1
    //   451: iadd
    //   452: istore_3
    //   453: goto -369 -> 84
    //   456: astore 6
    //   458: aload_0
    //   459: astore 6
    //   461: aload_1
    //   462: astore_0
    //   463: aload 6
    //   465: astore_1
    //   466: goto -337 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	paramString	String
    //   0	469	1	paramArrayOfString	String[]
    //   0	469	2	paramalkf	alkf
    //   80	373	3	i	int
    //   199	13	4	j	int
    //   38	399	5	localObject1	Object
    //   1	401	6	arrayOfByte	byte[]
    //   407	7	6	localObject2	Object
    //   419	5	6	localObject3	Object
    //   456	1	6	localException	Exception
    //   459	5	6	str	String
    //   4	431	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   21	40	116	java/lang/Exception
    //   45	61	116	java/lang/Exception
    //   61	75	116	java/lang/Exception
    //   84	90	116	java/lang/Exception
    //   104	113	116	java/lang/Exception
    //   166	177	116	java/lang/Exception
    //   254	258	259	java/io/IOException
    //   245	250	272	java/io/IOException
    //   152	157	287	java/io/IOException
    //   161	165	302	java/io/IOException
    //   6	21	315	finally
    //   337	342	352	java/io/IOException
    //   346	350	367	java/io/IOException
    //   21	40	382	finally
    //   45	61	382	finally
    //   61	75	382	finally
    //   84	90	382	finally
    //   104	113	382	finally
    //   166	177	382	finally
    //   177	185	396	finally
    //   185	192	407	finally
    //   192	201	407	finally
    //   207	216	407	finally
    //   223	232	407	finally
    //   133	139	419	finally
    //   6	21	429	java/lang/Exception
    //   177	185	441	java/lang/Exception
    //   185	192	456	java/lang/Exception
    //   192	201	456	java/lang/Exception
    //   207	216	456	java/lang/Exception
    //   223	232	456	java/lang/Exception
  }
  
  static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith(".jpg")) && (!paramString.endsWith(".png"))) {
      return false;
    }
    return true;
  }
  
  private static byte[] a(@NonNull HttpURLConnection paramHttpURLConnection, @Nullable alkg paramalkg)
  {
    localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      int i = paramHttpURLConnection.getContentLength();
      localObject1 = localObject3;
      Object localObject4;
      try
      {
        localObject4 = paramHttpURLConnection.getInputStream();
        paramHttpURLConnection = (HttpURLConnection)localObject4;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            paramHttpURLConnection.close();
            paramalkg = (alkg)localObject3;
            return paramalkg;
          }
          catch (IOException paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            return localObject3;
          }
          localIOException = localIOException;
          localObject2 = localObject3;
          paramHttpURLConnection = paramHttpURLConnection.getErrorStream();
        }
      }
      if (paramHttpURLConnection == null)
      {
        localObject1 = paramHttpURLConnection;
        localObject3 = new byte[0];
        paramalkg = (alkg)localObject3;
        if (paramHttpURLConnection == null) {}
      }
      for (;;)
      {
        Object localObject2 = paramHttpURLConnection;
        localObject3 = new ByteArrayOutputStream();
        localObject2 = paramHttpURLConnection;
        localObject4 = new byte[1024];
        for (;;)
        {
          localObject2 = paramHttpURLConnection;
          int j = paramHttpURLConnection.read((byte[])localObject4);
          if (j == -1) {
            break;
          }
          localObject2 = paramHttpURLConnection;
          ((ByteArrayOutputStream)localObject3).write((byte[])localObject4, 0, j);
          if (paramalkg != null)
          {
            localObject2 = paramHttpURLConnection;
            paramalkg.a(((ByteArrayOutputStream)localObject3).size(), i);
          }
        }
        try
        {
          ((InputStream)localObject2).close();
          throw paramHttpURLConnection;
          localObject2 = paramHttpURLConnection;
          paramalkg = ((ByteArrayOutputStream)localObject3).toByteArray();
          localObject2 = paramalkg;
          paramalkg = (alkg)localObject2;
          if (paramHttpURLConnection == null) {
            continue;
          }
          try
          {
            paramHttpURLConnection.close();
            return localObject2;
          }
          catch (IOException paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            return localObject2;
          }
        }
        catch (IOException paramalkg)
        {
          for (;;)
          {
            paramalkg.printStackTrace();
          }
        }
      }
    }
    finally
    {
      if (localObject2 == null) {}
    }
  }
  
  private static HashMap<String, String> b(String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayOfString != null)
    {
      String str = null;
      int i = 0;
      if (i < paramArrayOfString.length)
      {
        if ((i & 0x1) == 0) {
          str = paramArrayOfString[i];
        }
        for (;;)
        {
          i += 1;
          break;
          localHashMap.put(str, paramArrayOfString[i]);
        }
      }
    }
    return localHashMap;
  }
  
  /* Error */
  public static void b(@NonNull String paramString1, @NonNull String paramString2, @Nullable String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte, @NonNull alkh paramalkh, @Nullable alkg paramalkg1, @Nullable alkg paramalkg2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 15
    //   6: aconst_null
    //   7: astore 13
    //   9: aconst_null
    //   10: astore 14
    //   12: aconst_null
    //   13: astore 11
    //   15: iconst_m1
    //   16: istore 8
    //   18: new 338	java/util/HashMap
    //   21: dup
    //   22: invokespecial 339	java/util/HashMap:<init>	()V
    //   25: astore 16
    //   27: new 40	java/net/URL
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 43	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 47	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   38: checkcast 49	java/net/HttpURLConnection
    //   41: astore_0
    //   42: aload 13
    //   44: astore 11
    //   46: aload 14
    //   48: astore 12
    //   50: aload_0
    //   51: instanceof 56
    //   54: ifeq +53 -> 107
    //   57: aload 13
    //   59: astore 11
    //   61: aload 14
    //   63: astore 12
    //   65: invokestatic 58	alki:a	()Ljavax/net/ssl/SSLContext;
    //   68: astore 15
    //   70: aload 15
    //   72: ifnull +35 -> 107
    //   75: aload 13
    //   77: astore 11
    //   79: aload 14
    //   81: astore 12
    //   83: aload 15
    //   85: invokevirtual 62	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   88: astore 15
    //   90: aload 13
    //   92: astore 11
    //   94: aload 14
    //   96: astore 12
    //   98: aload_0
    //   99: checkcast 56	javax/net/ssl/HttpsURLConnection
    //   102: aload 15
    //   104: invokevirtual 66	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   107: aload 13
    //   109: astore 11
    //   111: aload 14
    //   113: astore 12
    //   115: aload_0
    //   116: aload_1
    //   117: invokevirtual 54	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   120: aload 13
    //   122: astore 11
    //   124: aload 14
    //   126: astore 12
    //   128: aload_0
    //   129: sipush 10000
    //   132: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   135: aload 13
    //   137: astore 11
    //   139: aload 14
    //   141: astore 12
    //   143: aload_0
    //   144: sipush 10000
    //   147: invokevirtual 73	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   150: aload 13
    //   152: astore 11
    //   154: aload 14
    //   156: astore 12
    //   158: aload_0
    //   159: iconst_1
    //   160: invokevirtual 348	java/net/HttpURLConnection:setDoInput	(Z)V
    //   163: aload 13
    //   165: astore 11
    //   167: aload 14
    //   169: astore 12
    //   171: aload_0
    //   172: iconst_0
    //   173: invokevirtual 77	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   176: aload_2
    //   177: ifnull +103 -> 280
    //   180: iconst_0
    //   181: istore 7
    //   183: aconst_null
    //   184: astore_1
    //   185: aload 13
    //   187: astore 11
    //   189: aload 14
    //   191: astore 12
    //   193: iload 7
    //   195: aload_2
    //   196: arraylength
    //   197: if_icmpge +83 -> 280
    //   200: iload 7
    //   202: iconst_1
    //   203: iand
    //   204: ifne +11 -> 215
    //   207: aload_2
    //   208: iload 7
    //   210: aaload
    //   211: astore_1
    //   212: goto +538 -> 750
    //   215: aload 13
    //   217: astore 11
    //   219: aload 14
    //   221: astore 12
    //   223: aload_0
    //   224: aload_1
    //   225: aload_2
    //   226: iload 7
    //   228: aaload
    //   229: invokevirtual 83	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: goto +518 -> 750
    //   235: astore_2
    //   236: iconst_m1
    //   237: istore 7
    //   239: aconst_null
    //   240: astore_3
    //   241: aload_0
    //   242: astore_1
    //   243: aload_3
    //   244: astore_0
    //   245: aload 4
    //   247: iload 7
    //   249: aload 16
    //   251: aload_2
    //   252: invokevirtual 349	java/io/IOException:toString	()Ljava/lang/String;
    //   255: invokevirtual 116	java/lang/String:getBytes	()[B
    //   258: invokeinterface 166 4 0
    //   263: aload_0
    //   264: ifnull +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 100	java/io/OutputStream:close	()V
    //   271: aload_1
    //   272: ifnull +7 -> 279
    //   275: aload_1
    //   276: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   279: return
    //   280: aload_3
    //   281: ifnull +464 -> 745
    //   284: aload 13
    //   286: astore 11
    //   288: aload 14
    //   290: astore 12
    //   292: aload_0
    //   293: iconst_1
    //   294: invokevirtual 352	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   297: aload 13
    //   299: astore 11
    //   301: aload 14
    //   303: astore 12
    //   305: aload_0
    //   306: aload_3
    //   307: arraylength
    //   308: invokevirtual 355	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   311: aload 13
    //   313: astore 11
    //   315: aload 14
    //   317: astore 12
    //   319: aload_0
    //   320: invokevirtual 110	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   323: astore_1
    //   324: aload_1
    //   325: astore 11
    //   327: aload_1
    //   328: astore 12
    //   330: aload_3
    //   331: arraylength
    //   332: istore 10
    //   334: iconst_0
    //   335: istore 7
    //   337: iload 7
    //   339: iload 10
    //   341: if_icmpge +77 -> 418
    //   344: aload_1
    //   345: astore 11
    //   347: aload_1
    //   348: astore 12
    //   350: sipush 4096
    //   353: iload 10
    //   355: iload 7
    //   357: isub
    //   358: invokestatic 361	java/lang/Math:min	(II)I
    //   361: istore 9
    //   363: aload_1
    //   364: astore 11
    //   366: aload_1
    //   367: astore 12
    //   369: aload_1
    //   370: aload_3
    //   371: iload 7
    //   373: iload 9
    //   375: invokevirtual 362	java/io/OutputStream:write	([BII)V
    //   378: iload 7
    //   380: iload 9
    //   382: iadd
    //   383: istore 9
    //   385: iload 9
    //   387: istore 7
    //   389: aload 5
    //   391: ifnull -54 -> 337
    //   394: aload_1
    //   395: astore 11
    //   397: aload_1
    //   398: astore 12
    //   400: aload 5
    //   402: iload 9
    //   404: iload 10
    //   406: invokeinterface 336 3 0
    //   411: iload 9
    //   413: istore 7
    //   415: goto -78 -> 337
    //   418: aload_1
    //   419: astore 11
    //   421: aload_1
    //   422: astore 12
    //   424: aload_1
    //   425: invokevirtual 123	java/io/OutputStream:flush	()V
    //   428: aload_0
    //   429: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
    //   432: istore 7
    //   434: aload_0
    //   435: invokevirtual 366	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   438: invokeinterface 372 1 0
    //   443: invokeinterface 378 1 0
    //   448: astore_2
    //   449: aload_2
    //   450: invokeinterface 383 1 0
    //   455: ifeq +64 -> 519
    //   458: aload_2
    //   459: invokeinterface 387 1 0
    //   464: checkcast 389	java/util/Map$Entry
    //   467: astore 5
    //   469: aload 5
    //   471: invokeinterface 392 1 0
    //   476: checkcast 112	java/lang/String
    //   479: astore_3
    //   480: aload 5
    //   482: invokeinterface 395 1 0
    //   487: checkcast 397	java/util/List
    //   490: astore 5
    //   492: aload_3
    //   493: ifnull -44 -> 449
    //   496: aload 5
    //   498: ifnull -49 -> 449
    //   501: aload 16
    //   503: aload_3
    //   504: ldc_w 399
    //   507: aload 5
    //   509: invokestatic 403	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   512: invokevirtual 343	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: pop
    //   516: goto -67 -> 449
    //   519: aload 4
    //   521: iload 7
    //   523: aload 16
    //   525: aload_0
    //   526: aload 6
    //   528: invokestatic 405	alki:a	(Ljava/net/HttpURLConnection;Lalkg;)[B
    //   531: invokeinterface 166 4 0
    //   536: aload_1
    //   537: ifnull +7 -> 544
    //   540: aload_1
    //   541: invokevirtual 100	java/io/OutputStream:close	()V
    //   544: aload_0
    //   545: ifnull -266 -> 279
    //   548: aload_0
    //   549: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   552: return
    //   553: astore_1
    //   554: aload_1
    //   555: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   558: goto -14 -> 544
    //   561: astore_0
    //   562: aload_0
    //   563: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   566: goto -295 -> 271
    //   569: astore_1
    //   570: aconst_null
    //   571: astore_0
    //   572: aload 12
    //   574: astore_2
    //   575: iload 8
    //   577: istore 7
    //   579: aload 4
    //   581: iload 7
    //   583: aload 16
    //   585: aload_1
    //   586: invokevirtual 406	java/lang/Exception:toString	()Ljava/lang/String;
    //   589: invokevirtual 116	java/lang/String:getBytes	()[B
    //   592: invokeinterface 166 4 0
    //   597: aload_2
    //   598: ifnull +7 -> 605
    //   601: aload_2
    //   602: invokevirtual 100	java/io/OutputStream:close	()V
    //   605: aload_0
    //   606: ifnull -327 -> 279
    //   609: aload_0
    //   610: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   613: return
    //   614: astore_1
    //   615: aload_1
    //   616: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   619: goto -14 -> 605
    //   622: astore_1
    //   623: aconst_null
    //   624: astore_0
    //   625: aload 15
    //   627: astore_2
    //   628: aload_2
    //   629: ifnull +7 -> 636
    //   632: aload_2
    //   633: invokevirtual 100	java/io/OutputStream:close	()V
    //   636: aload_0
    //   637: ifnull +7 -> 644
    //   640: aload_0
    //   641: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   644: aload_1
    //   645: athrow
    //   646: astore_2
    //   647: aload_2
    //   648: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   651: goto -15 -> 636
    //   654: astore_1
    //   655: aload 11
    //   657: astore_2
    //   658: goto -30 -> 628
    //   661: astore_3
    //   662: aload_1
    //   663: astore_2
    //   664: aload_3
    //   665: astore_1
    //   666: goto -38 -> 628
    //   669: astore 4
    //   671: aload_1
    //   672: astore_2
    //   673: aload_0
    //   674: astore_3
    //   675: aload 4
    //   677: astore_1
    //   678: aload_2
    //   679: astore_0
    //   680: aload_3
    //   681: astore_2
    //   682: goto -54 -> 628
    //   685: astore_1
    //   686: goto -58 -> 628
    //   689: astore_1
    //   690: iload 8
    //   692: istore 7
    //   694: aload 12
    //   696: astore_2
    //   697: goto -118 -> 579
    //   700: astore_3
    //   701: aload_1
    //   702: astore_2
    //   703: aload_3
    //   704: astore_1
    //   705: iload 8
    //   707: istore 7
    //   709: goto -130 -> 579
    //   712: astore_3
    //   713: aload_1
    //   714: astore_2
    //   715: aload_3
    //   716: astore_1
    //   717: goto -138 -> 579
    //   720: astore_2
    //   721: iconst_m1
    //   722: istore 7
    //   724: aconst_null
    //   725: astore_0
    //   726: aload 11
    //   728: astore_1
    //   729: goto -484 -> 245
    //   732: astore_2
    //   733: aload_0
    //   734: astore_3
    //   735: iconst_m1
    //   736: istore 7
    //   738: aload_1
    //   739: astore_0
    //   740: aload_3
    //   741: astore_1
    //   742: goto -497 -> 245
    //   745: aconst_null
    //   746: astore_1
    //   747: goto -319 -> 428
    //   750: iload 7
    //   752: iconst_1
    //   753: iadd
    //   754: istore 7
    //   756: goto -571 -> 185
    //   759: astore_2
    //   760: iconst_m1
    //   761: istore 7
    //   763: aload_0
    //   764: astore_3
    //   765: aload_1
    //   766: astore_0
    //   767: aload_3
    //   768: astore_1
    //   769: goto -524 -> 245
    //   772: astore_2
    //   773: aload_0
    //   774: astore_3
    //   775: aload_1
    //   776: astore_0
    //   777: aload_3
    //   778: astore_1
    //   779: goto -534 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	782	0	paramString1	String
    //   0	782	1	paramString2	String
    //   0	782	2	paramArrayOfString	String[]
    //   0	782	3	paramArrayOfByte	byte[]
    //   0	782	4	paramalkh	alkh
    //   0	782	5	paramalkg1	alkg
    //   0	782	6	paramalkg2	alkg
    //   181	581	7	i	int
    //   16	690	8	j	int
    //   361	51	9	k	int
    //   332	73	10	m	int
    //   13	714	11	localObject1	Object
    //   1	694	12	localObject2	Object
    //   7	305	13	localObject3	Object
    //   10	306	14	localObject4	Object
    //   4	622	15	localObject5	Object
    //   25	559	16	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   50	57	235	java/io/IOException
    //   65	70	235	java/io/IOException
    //   83	90	235	java/io/IOException
    //   98	107	235	java/io/IOException
    //   115	120	235	java/io/IOException
    //   128	135	235	java/io/IOException
    //   143	150	235	java/io/IOException
    //   158	163	235	java/io/IOException
    //   171	176	235	java/io/IOException
    //   193	200	235	java/io/IOException
    //   223	232	235	java/io/IOException
    //   292	297	235	java/io/IOException
    //   305	311	235	java/io/IOException
    //   319	324	235	java/io/IOException
    //   540	544	553	java/io/IOException
    //   267	271	561	java/io/IOException
    //   27	42	569	java/lang/Exception
    //   601	605	614	java/io/IOException
    //   27	42	622	finally
    //   632	636	646	java/io/IOException
    //   50	57	654	finally
    //   65	70	654	finally
    //   83	90	654	finally
    //   98	107	654	finally
    //   115	120	654	finally
    //   128	135	654	finally
    //   143	150	654	finally
    //   158	163	654	finally
    //   171	176	654	finally
    //   193	200	654	finally
    //   223	232	654	finally
    //   292	297	654	finally
    //   305	311	654	finally
    //   319	324	654	finally
    //   330	334	654	finally
    //   350	363	654	finally
    //   369	378	654	finally
    //   400	411	654	finally
    //   424	428	654	finally
    //   428	434	661	finally
    //   434	449	661	finally
    //   449	492	661	finally
    //   501	516	661	finally
    //   519	536	661	finally
    //   245	263	669	finally
    //   579	597	685	finally
    //   50	57	689	java/lang/Exception
    //   65	70	689	java/lang/Exception
    //   83	90	689	java/lang/Exception
    //   98	107	689	java/lang/Exception
    //   115	120	689	java/lang/Exception
    //   128	135	689	java/lang/Exception
    //   143	150	689	java/lang/Exception
    //   158	163	689	java/lang/Exception
    //   171	176	689	java/lang/Exception
    //   193	200	689	java/lang/Exception
    //   223	232	689	java/lang/Exception
    //   292	297	689	java/lang/Exception
    //   305	311	689	java/lang/Exception
    //   319	324	689	java/lang/Exception
    //   330	334	689	java/lang/Exception
    //   350	363	689	java/lang/Exception
    //   369	378	689	java/lang/Exception
    //   400	411	689	java/lang/Exception
    //   424	428	689	java/lang/Exception
    //   428	434	700	java/lang/Exception
    //   434	449	712	java/lang/Exception
    //   449	492	712	java/lang/Exception
    //   501	516	712	java/lang/Exception
    //   519	536	712	java/lang/Exception
    //   27	42	720	java/io/IOException
    //   428	434	732	java/io/IOException
    //   330	334	759	java/io/IOException
    //   350	363	759	java/io/IOException
    //   369	378	759	java/io/IOException
    //   400	411	759	java/io/IOException
    //   424	428	759	java/io/IOException
    //   434	449	772	java/io/IOException
    //   449	492	772	java/io/IOException
    //   501	516	772	java/io/IOException
    //   519	536	772	java/io/IOException
  }
  
  private static byte[] b(File paramFile, HashMap<String, String> paramHashMap)
  {
    if ((paramFile != null) && (paramFile.exists())) {
      try
      {
        paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
        if (paramHashMap != null)
        {
          paramHashMap.put("width", String.valueOf(paramFile.getWidth()));
          paramHashMap.put("height", String.valueOf(paramFile.getHeight()));
        }
        paramHashMap = ByteBuffer.allocateDirect(paramFile.getByteCount());
        paramHashMap.order(ByteOrder.nativeOrder());
        paramFile.copyPixelsToBuffer(paramHashMap);
        paramFile = paramHashMap.array();
        return paramFile;
      }
      catch (OutOfMemoryError paramFile)
      {
        QLog.d("ApolloHttpUtil", 2, "wrapBitmapBuffer" + paramFile);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alki
 * JD-Core Version:    0.7.0.1
 */