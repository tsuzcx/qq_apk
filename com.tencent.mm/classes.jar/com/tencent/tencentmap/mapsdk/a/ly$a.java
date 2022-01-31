package com.tencent.tencentmap.mapsdk.a;

import java.lang.ref.WeakReference;

public class ly$a
  implements kt
{
  private final WeakReference<ly> a;
  private byte[] b = null;
  private String c;
  
  public ly$a(ly paramly)
  {
    this.a = new WeakReference(paramly);
    this.c = "";
  }
  
  /* Error */
  public byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/tencentmap/mapsdk/a/ly$a:a	Ljava/lang/ref/WeakReference;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 29	com/tencent/tencentmap/mapsdk/a/ly$a:a	Ljava/lang/ref/WeakReference;
    //   11: invokevirtual 43	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   14: ifnonnull +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 29	com/tencent/tencentmap/mapsdk/a/ly$a:a	Ljava/lang/ref/WeakReference;
    //   23: invokevirtual 43	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   26: checkcast 8	com/tencent/tencentmap/mapsdk/a/ly
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 47	com/tencent/tencentmap/mapsdk/a/ly:getMap	()Lcom/tencent/map/lib/f;
    //   34: ifnull +39 -> 73
    //   37: aload_0
    //   38: getfield 33	com/tencent/tencentmap/mapsdk/a/ly$a:c	Ljava/lang/String;
    //   41: invokestatic 53	com/tencent/map/lib/util/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   44: ifeq +29 -> 73
    //   47: aload_0
    //   48: new 55	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 57
    //   54: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_3
    //   58: invokevirtual 47	com/tencent/tencentmap/mapsdk/a/ly:getMap	()Lcom/tencent/map/lib/f;
    //   61: invokevirtual 66	com/tencent/map/lib/f:I	()Ljava/lang/String;
    //   64: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: putfield 33	com/tencent/tencentmap/mapsdk/a/ly$a:c	Ljava/lang/String;
    //   73: aload_3
    //   74: invokestatic 76	com/tencent/tencentmap/mapsdk/a/ly:a	(Lcom/tencent/tencentmap/mapsdk/a/ly;)Lcom/tencent/tencentmap/mapsdk/a/oj;
    //   77: aload_1
    //   78: invokevirtual 80	com/tencent/tencentmap/mapsdk/a/oj:a	(Ljava/lang/String;)Z
    //   81: ifne +5 -> 86
    //   84: aconst_null
    //   85: areturn
    //   86: aload_1
    //   87: astore_3
    //   88: aload_1
    //   89: ifnull +28 -> 117
    //   92: aload_1
    //   93: ldc 82
    //   95: ldc 84
    //   97: invokevirtual 90	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   100: ldc 92
    //   102: invokestatic 96	com/tencent/tencentmap/mapsdk/a/lh:b	()Ljava/lang/String;
    //   105: invokevirtual 90	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   108: ldc 98
    //   110: invokestatic 96	com/tencent/tencentmap/mapsdk/a/lh:b	()Ljava/lang/String;
    //   113: invokevirtual 90	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   116: astore_3
    //   117: aload_3
    //   118: invokestatic 101	com/tencent/tencentmap/mapsdk/a/lh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 4
    //   123: aload 4
    //   125: ldc 103
    //   127: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   130: ifeq +117 -> 247
    //   133: aload 4
    //   135: ldc 109
    //   137: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   140: ifeq +107 -> 247
    //   143: aload 4
    //   145: ldc 111
    //   147: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   150: ifeq +97 -> 247
    //   153: iconst_1
    //   154: istore_2
    //   155: iload_2
    //   156: ifne +236 -> 392
    //   159: aload 4
    //   161: ldc 113
    //   163: invokevirtual 116	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   166: ifne +434 -> 600
    //   169: aload 4
    //   171: ldc 118
    //   173: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   176: ifne +424 -> 600
    //   179: aload 4
    //   181: ldc 123
    //   183: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   186: ifne +414 -> 600
    //   189: new 55	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   196: aload 4
    //   198: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 33	com/tencent/tencentmap/mapsdk/a/ly$a:c	Ljava/lang/String;
    //   205: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: getfield 29	com/tencent/tencentmap/mapsdk/a/ly$a:a	Ljava/lang/ref/WeakReference;
    //   212: invokevirtual 43	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   215: checkcast 8	com/tencent/tencentmap/mapsdk/a/ly
    //   218: invokestatic 127	com/tencent/tencentmap/mapsdk/a/ly:b	(Lcom/tencent/tencentmap/mapsdk/a/ly;)Ljava/lang/String;
    //   221: invokestatic 131	com/tencent/tencentmap/mapsdk/a/lq:c	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: astore_1
    //   231: invokestatic 136	com/tencent/tencentmap/mapsdk/a/qs:a	()Lcom/tencent/tencentmap/mapsdk/a/qs;
    //   234: aload_1
    //   235: ldc 138
    //   237: invokevirtual 141	com/tencent/tencentmap/mapsdk/a/qs:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/a/qt;
    //   240: astore_1
    //   241: aload_1
    //   242: ifnonnull +13 -> 255
    //   245: aconst_null
    //   246: areturn
    //   247: iconst_0
    //   248: istore_2
    //   249: goto -94 -> 155
    //   252: astore_1
    //   253: aconst_null
    //   254: areturn
    //   255: aload 4
    //   257: ldc 143
    //   259: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   262: ifne +21 -> 283
    //   265: aload_0
    //   266: getfield 29	com/tencent/tencentmap/mapsdk/a/ly$a:a	Ljava/lang/ref/WeakReference;
    //   269: invokevirtual 43	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   272: checkcast 8	com/tencent/tencentmap/mapsdk/a/ly
    //   275: invokestatic 76	com/tencent/tencentmap/mapsdk/a/ly:a	(Lcom/tencent/tencentmap/mapsdk/a/ly;)Lcom/tencent/tencentmap/mapsdk/a/oj;
    //   278: aload 4
    //   280: invokevirtual 145	com/tencent/tencentmap/mapsdk/a/oj:b	(Ljava/lang/String;)V
    //   283: aload 4
    //   285: ldc 123
    //   287: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   290: ifeq +97 -> 387
    //   293: aload_1
    //   294: getfield 149	com/tencent/tencentmap/mapsdk/a/qt:a	[B
    //   297: ifnull +90 -> 387
    //   300: aload_1
    //   301: getfield 149	com/tencent/tencentmap/mapsdk/a/qt:a	[B
    //   304: arraylength
    //   305: ifne +82 -> 387
    //   308: aload_0
    //   309: getfield 22	com/tencent/tencentmap/mapsdk/a/ly$a:b	[B
    //   312: ifnonnull +67 -> 379
    //   315: sipush 256
    //   318: sipush 256
    //   321: getstatic 155	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   324: invokestatic 161	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   327: astore_3
    //   328: new 163	android/graphics/Canvas
    //   331: dup
    //   332: aload_3
    //   333: invokespecial 166	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   336: iconst_0
    //   337: sipush 255
    //   340: sipush 255
    //   343: sipush 255
    //   346: invokevirtual 170	android/graphics/Canvas:drawARGB	(IIII)V
    //   349: new 172	java/io/ByteArrayOutputStream
    //   352: dup
    //   353: invokespecial 173	java/io/ByteArrayOutputStream:<init>	()V
    //   356: astore 4
    //   358: aload_3
    //   359: getstatic 179	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   362: bipush 100
    //   364: aload 4
    //   366: invokevirtual 183	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   369: pop
    //   370: aload_0
    //   371: aload 4
    //   373: invokevirtual 187	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   376: putfield 22	com/tencent/tencentmap/mapsdk/a/ly$a:b	[B
    //   379: aload_1
    //   380: aload_0
    //   381: getfield 22	com/tencent/tencentmap/mapsdk/a/ly$a:b	[B
    //   384: putfield 149	com/tencent/tencentmap/mapsdk/a/qt:a	[B
    //   387: aload_1
    //   388: getfield 149	com/tencent/tencentmap/mapsdk/a/qt:a	[B
    //   391: areturn
    //   392: new 189	java/net/URL
    //   395: dup
    //   396: aload 4
    //   398: invokespecial 190	java/net/URL:<init>	(Ljava/lang/String;)V
    //   401: invokevirtual 194	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   404: checkcast 196	java/net/HttpURLConnection
    //   407: astore_1
    //   408: aload_1
    //   409: ldc 198
    //   411: ldc 138
    //   413: invokevirtual 202	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload_1
    //   417: sipush 10000
    //   420: invokevirtual 206	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   423: aload_1
    //   424: invokevirtual 210	java/net/HttpURLConnection:getResponseCode	()I
    //   427: sipush 200
    //   430: if_icmpne +61 -> 491
    //   433: aload_1
    //   434: invokevirtual 214	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   437: astore_3
    //   438: aload_3
    //   439: invokestatic 219	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/InputStream;)[B
    //   442: astore 5
    //   444: aload 4
    //   446: ldc 143
    //   448: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   451: ifne +21 -> 472
    //   454: aload_0
    //   455: getfield 29	com/tencent/tencentmap/mapsdk/a/ly$a:a	Ljava/lang/ref/WeakReference;
    //   458: invokevirtual 43	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   461: checkcast 8	com/tencent/tencentmap/mapsdk/a/ly
    //   464: invokestatic 76	com/tencent/tencentmap/mapsdk/a/ly:a	(Lcom/tencent/tencentmap/mapsdk/a/ly;)Lcom/tencent/tencentmap/mapsdk/a/oj;
    //   467: aload 4
    //   469: invokevirtual 145	com/tencent/tencentmap/mapsdk/a/oj:b	(Ljava/lang/String;)V
    //   472: aload_1
    //   473: ifnull +7 -> 480
    //   476: aload_1
    //   477: invokevirtual 222	java/net/HttpURLConnection:disconnect	()V
    //   480: aload_3
    //   481: ifnull +7 -> 488
    //   484: aload_3
    //   485: invokestatic 225	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   488: aload 5
    //   490: areturn
    //   491: aload_1
    //   492: ifnull +7 -> 499
    //   495: aload_1
    //   496: invokevirtual 222	java/net/HttpURLConnection:disconnect	()V
    //   499: aconst_null
    //   500: areturn
    //   501: astore_1
    //   502: aconst_null
    //   503: astore_1
    //   504: aconst_null
    //   505: astore_3
    //   506: aload_3
    //   507: ifnull +7 -> 514
    //   510: aload_3
    //   511: invokevirtual 222	java/net/HttpURLConnection:disconnect	()V
    //   514: aload_1
    //   515: ifnull -16 -> 499
    //   518: aload_1
    //   519: invokestatic 225	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   522: goto -23 -> 499
    //   525: astore_1
    //   526: aconst_null
    //   527: astore_3
    //   528: aconst_null
    //   529: astore 4
    //   531: aload 4
    //   533: ifnull +8 -> 541
    //   536: aload 4
    //   538: invokevirtual 222	java/net/HttpURLConnection:disconnect	()V
    //   541: aload_3
    //   542: ifnull +7 -> 549
    //   545: aload_3
    //   546: invokestatic 225	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   549: aload_1
    //   550: athrow
    //   551: astore 5
    //   553: aconst_null
    //   554: astore_3
    //   555: aload_1
    //   556: astore 4
    //   558: aload 5
    //   560: astore_1
    //   561: goto -30 -> 531
    //   564: astore 5
    //   566: aload_1
    //   567: astore 4
    //   569: aload 5
    //   571: astore_1
    //   572: goto -41 -> 531
    //   575: astore_3
    //   576: aconst_null
    //   577: astore 4
    //   579: aload_1
    //   580: astore_3
    //   581: aload 4
    //   583: astore_1
    //   584: goto -78 -> 506
    //   587: astore 4
    //   589: aload_3
    //   590: astore 4
    //   592: aload_1
    //   593: astore_3
    //   594: aload 4
    //   596: astore_1
    //   597: goto -91 -> 506
    //   600: aload 4
    //   602: astore_1
    //   603: goto -372 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	a
    //   0	606	1	paramString	String
    //   154	95	2	i	int
    //   29	526	3	localObject1	Object
    //   575	1	3	localThrowable1	java.lang.Throwable
    //   580	14	3	str1	String
    //   121	461	4	localObject2	Object
    //   587	1	4	localThrowable2	java.lang.Throwable
    //   590	11	4	str2	String
    //   442	47	5	arrayOfByte	byte[]
    //   551	8	5	localObject3	Object
    //   564	6	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   231	241	252	java/lang/Exception
    //   392	408	501	java/lang/Throwable
    //   392	408	525	finally
    //   408	438	551	finally
    //   438	472	564	finally
    //   408	438	575	java/lang/Throwable
    //   438	472	587	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ly.a
 * JD-Core Version:    0.7.0.1
 */