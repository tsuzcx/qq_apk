package com.tencent.tencentmap.mapsdk.a;

import java.util.Locale;

public final class up
{
  private static String a = Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
  
  /* Error */
  public static byte[] a(java.net.URL paramURL)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 46	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   9: ifnull +509 -> 518
    //   12: new 48	java/net/Proxy
    //   15: dup
    //   16: getstatic 54	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   19: new 56	java/net/InetSocketAddress
    //   22: dup
    //   23: invokestatic 46	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   26: invokestatic 60	android/net/Proxy:getDefaultPort	()I
    //   29: invokespecial 63	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   32: invokespecial 66	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +178 -> 215
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 72	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   45: checkcast 74	java/net/HttpURLConnection
    //   48: astore_3
    //   49: aload_3
    //   50: sipush 5000
    //   53: invokevirtual 78	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   56: aload_3
    //   57: sipush 15000
    //   60: invokevirtual 81	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   63: aload_3
    //   64: ldc 83
    //   66: ldc 85
    //   68: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_3
    //   72: ldc 91
    //   74: ldc 93
    //   76: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_3
    //   80: ldc 95
    //   82: getstatic 37	com/tencent/tencentmap/mapsdk/a/up:a	Ljava/lang/String;
    //   85: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_3
    //   89: invokevirtual 98	java/net/HttpURLConnection:getResponseCode	()I
    //   92: sipush 200
    //   95: if_icmpne +411 -> 506
    //   98: aload_3
    //   99: invokevirtual 102	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 105	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   107: invokevirtual 110	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   110: invokevirtual 113	java/lang/String:trim	()Ljava/lang/String;
    //   113: ldc 115
    //   115: invokevirtual 119	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   118: ifeq +108 -> 226
    //   121: new 121	java/io/InputStreamReader
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 124	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   129: astore 5
    //   131: new 126	java/io/BufferedReader
    //   134: dup
    //   135: aload 5
    //   137: invokespecial 129	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   145: astore_2
    //   146: aload_2
    //   147: ifnull +353 -> 500
    //   150: aload_2
    //   151: invokevirtual 110	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   154: invokevirtual 113	java/lang/String:trim	()Ljava/lang/String;
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +341 -> 500
    //   162: aload_2
    //   163: ldc 134
    //   165: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +332 -> 500
    //   171: iconst_1
    //   172: newarray byte
    //   174: astore 6
    //   176: aload 6
    //   178: iconst_0
    //   179: iconst_m1
    //   180: bastore
    //   181: aload_0
    //   182: astore 4
    //   184: aload_1
    //   185: astore_2
    //   186: aload 5
    //   188: astore_1
    //   189: aload 6
    //   191: astore_0
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: aload_3
    //   197: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   200: aload 4
    //   202: invokestatic 146	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   205: aload_1
    //   206: invokestatic 146	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   209: aload_2
    //   210: invokestatic 146	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   213: aload_0
    //   214: areturn
    //   215: aload_0
    //   216: invokevirtual 149	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   219: checkcast 74	java/net/HttpURLConnection
    //   222: astore_3
    //   223: goto -174 -> 49
    //   226: ldc 151
    //   228: aload_3
    //   229: ldc 153
    //   231: invokevirtual 157	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   234: invokevirtual 161	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   237: ifeq +258 -> 495
    //   240: new 163	java/util/zip/GZIPInputStream
    //   243: dup
    //   244: aload_1
    //   245: invokespecial 164	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   248: astore_0
    //   249: aload_0
    //   250: invokestatic 167	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/InputStream;)[B
    //   253: astore_1
    //   254: aload_1
    //   255: iconst_0
    //   256: aload_1
    //   257: arraylength
    //   258: invokestatic 173	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   261: pop
    //   262: aconst_null
    //   263: astore 4
    //   265: aconst_null
    //   266: astore 5
    //   268: aload_0
    //   269: astore_2
    //   270: aload_1
    //   271: astore_0
    //   272: aload 5
    //   274: astore_1
    //   275: goto -83 -> 192
    //   278: astore_1
    //   279: new 10	java/lang/StringBuilder
    //   282: dup
    //   283: ldc 175
    //   285: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: aload_1
    //   289: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   292: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aconst_null
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_1
    //   301: aload_0
    //   302: astore_2
    //   303: aconst_null
    //   304: astore_0
    //   305: goto -113 -> 192
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_0
    //   311: aconst_null
    //   312: astore_2
    //   313: aconst_null
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_3
    //   317: aload_3
    //   318: ifnull +7 -> 325
    //   321: aload_3
    //   322: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   325: aload_0
    //   326: invokestatic 146	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   329: aload_2
    //   330: invokestatic 146	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   333: aload_1
    //   334: invokestatic 146	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   337: aconst_null
    //   338: areturn
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_1
    //   342: aconst_null
    //   343: astore_2
    //   344: aconst_null
    //   345: astore 4
    //   347: aconst_null
    //   348: astore_3
    //   349: aload_3
    //   350: ifnull +7 -> 357
    //   353: aload_3
    //   354: invokevirtual 141	java/net/HttpURLConnection:disconnect	()V
    //   357: aload_1
    //   358: invokestatic 146	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   361: aload_2
    //   362: invokestatic 146	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   365: aload 4
    //   367: invokestatic 146	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   370: aload_0
    //   371: athrow
    //   372: astore_0
    //   373: aconst_null
    //   374: astore_1
    //   375: aconst_null
    //   376: astore_2
    //   377: aconst_null
    //   378: astore 4
    //   380: goto -31 -> 349
    //   383: astore_0
    //   384: aconst_null
    //   385: astore 5
    //   387: aconst_null
    //   388: astore_2
    //   389: aload_1
    //   390: astore 4
    //   392: aload 5
    //   394: astore_1
    //   395: goto -46 -> 349
    //   398: astore_0
    //   399: aconst_null
    //   400: astore 6
    //   402: aload 5
    //   404: astore_2
    //   405: aload_1
    //   406: astore 4
    //   408: aload 6
    //   410: astore_1
    //   411: goto -62 -> 349
    //   414: astore_2
    //   415: aload_0
    //   416: astore 6
    //   418: aload_2
    //   419: astore_0
    //   420: aload 5
    //   422: astore_2
    //   423: aload_1
    //   424: astore 4
    //   426: aload 6
    //   428: astore_1
    //   429: goto -80 -> 349
    //   432: astore 5
    //   434: aconst_null
    //   435: astore_1
    //   436: aconst_null
    //   437: astore_2
    //   438: aload_0
    //   439: astore 4
    //   441: aload 5
    //   443: astore_0
    //   444: goto -95 -> 349
    //   447: astore_0
    //   448: aconst_null
    //   449: astore_0
    //   450: aconst_null
    //   451: astore_2
    //   452: aconst_null
    //   453: astore_1
    //   454: goto -137 -> 317
    //   457: astore_0
    //   458: aconst_null
    //   459: astore_0
    //   460: aconst_null
    //   461: astore_2
    //   462: goto -145 -> 317
    //   465: astore_0
    //   466: aconst_null
    //   467: astore_0
    //   468: aload 5
    //   470: astore_2
    //   471: goto -154 -> 317
    //   474: astore_2
    //   475: aload 5
    //   477: astore_2
    //   478: goto -161 -> 317
    //   481: astore_1
    //   482: aconst_null
    //   483: astore 4
    //   485: aconst_null
    //   486: astore_2
    //   487: aload_0
    //   488: astore_1
    //   489: aload 4
    //   491: astore_0
    //   492: goto -175 -> 317
    //   495: aload_1
    //   496: astore_0
    //   497: goto -248 -> 249
    //   500: aconst_null
    //   501: astore 6
    //   503: goto -322 -> 181
    //   506: aconst_null
    //   507: astore 4
    //   509: aconst_null
    //   510: astore_1
    //   511: aconst_null
    //   512: astore_2
    //   513: aconst_null
    //   514: astore_0
    //   515: goto -323 -> 192
    //   518: aconst_null
    //   519: astore_1
    //   520: goto -484 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramURL	java.net.URL
    //   35	240	1	localObject1	Object
    //   278	11	1	localException1	java.lang.Exception
    //   300	154	1	localObject2	Object
    //   481	1	1	localException2	java.lang.Exception
    //   488	32	1	localURL	java.net.URL
    //   145	260	2	localObject3	Object
    //   414	5	2	localObject4	Object
    //   422	49	2	localObject5	Object
    //   474	1	2	localException3	java.lang.Exception
    //   477	36	2	localObject6	Object
    //   48	306	3	localHttpURLConnection	java.net.HttpURLConnection
    //   182	326	4	localObject7	Object
    //   129	292	5	localInputStreamReader	java.io.InputStreamReader
    //   432	44	5	localObject8	Object
    //   174	328	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   254	262	278	java/lang/Exception
    //   6	36	308	java/lang/Exception
    //   40	49	308	java/lang/Exception
    //   215	223	308	java/lang/Exception
    //   6	36	339	finally
    //   40	49	339	finally
    //   215	223	339	finally
    //   49	103	372	finally
    //   103	131	383	finally
    //   226	249	383	finally
    //   131	141	398	finally
    //   141	146	414	finally
    //   150	158	414	finally
    //   162	176	414	finally
    //   249	254	432	finally
    //   254	262	432	finally
    //   279	296	432	finally
    //   49	103	447	java/lang/Exception
    //   103	131	457	java/lang/Exception
    //   226	249	457	java/lang/Exception
    //   131	141	465	java/lang/Exception
    //   141	146	474	java/lang/Exception
    //   150	158	474	java/lang/Exception
    //   162	176	474	java/lang/Exception
    //   249	254	481	java/lang/Exception
    //   279	296	481	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.up
 * JD-Core Version:    0.7.0.1
 */