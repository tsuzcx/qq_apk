import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class agmp
  implements ayww
{
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
    new Canvas(localBitmap).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new RectF(0.0F, 0.0F, paramInt1, paramInt2), new Paint(6));
    return localBitmap;
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  public Bitmap a(java.net.URL paramURL)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 70	com/tencent/mobileqq/activity/photo/LocalMediaInfo:parseUrl	(Ljava/net/URL;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   4: astore 8
    //   6: aload 8
    //   8: ifnull +511 -> 519
    //   11: new 72	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 73	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: iconst_0
    //   21: putfield 77	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload 8
    //   26: getfield 81	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   29: aload_1
    //   30: invokestatic 86	bbdr:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: astore_1
    //   34: aload 8
    //   36: getfield 90	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   39: istore_2
    //   40: aload 8
    //   42: getfield 93	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   45: istore_3
    //   46: aload_1
    //   47: invokevirtual 36	android/graphics/Bitmap:getWidth	()I
    //   50: istore 4
    //   52: aload_1
    //   53: invokevirtual 39	android/graphics/Bitmap:getHeight	()I
    //   56: istore 5
    //   58: iload 5
    //   60: iload 4
    //   62: if_icmple +258 -> 320
    //   65: iload 5
    //   67: iload 4
    //   69: idiv
    //   70: i2f
    //   71: ldc 94
    //   73: fcmpl
    //   74: ifle +172 -> 246
    //   77: iload_3
    //   78: iload_2
    //   79: getstatic 19	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   82: invokestatic 25	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   85: astore 6
    //   87: new 27	android/graphics/Canvas
    //   90: dup
    //   91: aload 6
    //   93: invokespecial 30	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   96: aload_1
    //   97: new 32	android/graphics/Rect
    //   100: dup
    //   101: iconst_0
    //   102: iload 5
    //   104: iload 4
    //   106: iconst_3
    //   107: imul
    //   108: isub
    //   109: iconst_2
    //   110: idiv
    //   111: iload 4
    //   113: iload 5
    //   115: iload 4
    //   117: iconst_3
    //   118: imul
    //   119: iadd
    //   120: iconst_2
    //   121: idiv
    //   122: invokespecial 42	android/graphics/Rect:<init>	(IIII)V
    //   125: new 44	android/graphics/RectF
    //   128: dup
    //   129: fconst_0
    //   130: fconst_0
    //   131: iload_3
    //   132: i2f
    //   133: iload_2
    //   134: i2f
    //   135: invokespecial 47	android/graphics/RectF:<init>	(FFFF)V
    //   138: new 49	android/graphics/Paint
    //   141: dup
    //   142: bipush 6
    //   144: invokespecial 52	android/graphics/Paint:<init>	(I)V
    //   147: invokevirtual 56	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   150: aload 6
    //   152: ifnull +417 -> 569
    //   155: aload_1
    //   156: invokevirtual 97	android/graphics/Bitmap:recycle	()V
    //   159: aload 6
    //   161: astore_1
    //   162: aload 8
    //   164: getfield 81	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   167: invokestatic 102	aywk:a	(Ljava/lang/String;)I
    //   170: istore_2
    //   171: aload_1
    //   172: astore 6
    //   174: iload_2
    //   175: ifeq +68 -> 243
    //   178: new 104	android/graphics/Matrix
    //   181: dup
    //   182: invokespecial 105	android/graphics/Matrix:<init>	()V
    //   185: astore 6
    //   187: aload 6
    //   189: iload_2
    //   190: i2f
    //   191: aload_1
    //   192: invokevirtual 36	android/graphics/Bitmap:getWidth	()I
    //   195: iconst_2
    //   196: idiv
    //   197: i2f
    //   198: aload_1
    //   199: invokevirtual 39	android/graphics/Bitmap:getHeight	()I
    //   202: iconst_2
    //   203: idiv
    //   204: i2f
    //   205: invokevirtual 109	android/graphics/Matrix:setRotate	(FFF)V
    //   208: aload_1
    //   209: iconst_0
    //   210: iconst_0
    //   211: aload_1
    //   212: invokevirtual 36	android/graphics/Bitmap:getWidth	()I
    //   215: aload_1
    //   216: invokevirtual 39	android/graphics/Bitmap:getHeight	()I
    //   219: aload 6
    //   221: iconst_1
    //   222: invokestatic 112	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   225: astore 7
    //   227: aload_1
    //   228: astore 6
    //   230: aload 7
    //   232: ifnull +11 -> 243
    //   235: aload_1
    //   236: invokevirtual 97	android/graphics/Bitmap:recycle	()V
    //   239: aload 7
    //   241: astore 6
    //   243: aload 6
    //   245: areturn
    //   246: iload 5
    //   248: iload_2
    //   249: if_icmple +329 -> 578
    //   252: aload_0
    //   253: aload_1
    //   254: iload 4
    //   256: iload_2
    //   257: imul
    //   258: iload 5
    //   260: idiv
    //   261: iload_2
    //   262: invokespecial 114	agmp:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   265: astore 7
    //   267: aload_1
    //   268: astore 6
    //   270: aload 7
    //   272: ifnull +300 -> 572
    //   275: aload_1
    //   276: invokevirtual 97	android/graphics/Bitmap:recycle	()V
    //   279: aload 7
    //   281: astore 6
    //   283: goto +289 -> 572
    //   286: aload_0
    //   287: aload_1
    //   288: iload_3
    //   289: iload 5
    //   291: iload_3
    //   292: imul
    //   293: iload 4
    //   295: idiv
    //   296: invokespecial 114	agmp:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   299: astore 7
    //   301: aload_1
    //   302: astore 6
    //   304: aload 7
    //   306: ifnull +299 -> 605
    //   309: aload_1
    //   310: invokevirtual 97	android/graphics/Bitmap:recycle	()V
    //   313: aload 7
    //   315: astore 6
    //   317: goto +288 -> 605
    //   320: iload 4
    //   322: iload 5
    //   324: idiv
    //   325: i2f
    //   326: ldc 94
    //   328: fcmpl
    //   329: ifle +95 -> 424
    //   332: iload_2
    //   333: iload_3
    //   334: getstatic 19	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   337: invokestatic 25	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   340: astore 7
    //   342: new 27	android/graphics/Canvas
    //   345: dup
    //   346: aload 7
    //   348: invokespecial 30	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   351: aload_1
    //   352: new 32	android/graphics/Rect
    //   355: dup
    //   356: iload 4
    //   358: iload 5
    //   360: iconst_3
    //   361: imul
    //   362: isub
    //   363: iconst_2
    //   364: idiv
    //   365: iconst_0
    //   366: iload 4
    //   368: iload 5
    //   370: iconst_3
    //   371: imul
    //   372: iadd
    //   373: iconst_2
    //   374: idiv
    //   375: iload 5
    //   377: invokespecial 42	android/graphics/Rect:<init>	(IIII)V
    //   380: new 44	android/graphics/RectF
    //   383: dup
    //   384: fconst_0
    //   385: fconst_0
    //   386: iload_2
    //   387: i2f
    //   388: iload_3
    //   389: i2f
    //   390: invokespecial 47	android/graphics/RectF:<init>	(FFFF)V
    //   393: new 49	android/graphics/Paint
    //   396: dup
    //   397: bipush 6
    //   399: invokespecial 52	android/graphics/Paint:<init>	(I)V
    //   402: invokevirtual 56	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   405: aload_1
    //   406: astore 6
    //   408: aload 7
    //   410: ifnull +201 -> 611
    //   413: aload_1
    //   414: invokevirtual 97	android/graphics/Bitmap:recycle	()V
    //   417: aload 7
    //   419: astore 6
    //   421: goto +190 -> 611
    //   424: iload 4
    //   426: iload_2
    //   427: if_icmple +196 -> 623
    //   430: aload_0
    //   431: aload_1
    //   432: iload_2
    //   433: iload 5
    //   435: iload_2
    //   436: imul
    //   437: iload 4
    //   439: idiv
    //   440: invokespecial 114	agmp:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   443: astore 7
    //   445: aload_1
    //   446: astore 6
    //   448: aload 7
    //   450: ifnull +167 -> 617
    //   453: aload_1
    //   454: invokevirtual 97	android/graphics/Bitmap:recycle	()V
    //   457: aload 7
    //   459: astore 6
    //   461: goto +156 -> 617
    //   464: aload_0
    //   465: aload_1
    //   466: iload 4
    //   468: iload_3
    //   469: imul
    //   470: iload 5
    //   472: idiv
    //   473: iload_3
    //   474: invokespecial 114	agmp:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   477: astore 6
    //   479: aload 6
    //   481: ifnull +88 -> 569
    //   484: aload_1
    //   485: invokevirtual 97	android/graphics/Bitmap:recycle	()V
    //   488: aload 6
    //   490: astore_1
    //   491: goto -329 -> 162
    //   494: astore 6
    //   496: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +13 -> 512
    //   502: ldc 122
    //   504: iconst_2
    //   505: ldc 124
    //   507: aload 6
    //   509: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   512: aload_1
    //   513: astore 6
    //   515: aload_1
    //   516: ifnonnull -273 -> 243
    //   519: aconst_null
    //   520: areturn
    //   521: astore 6
    //   523: aconst_null
    //   524: astore_1
    //   525: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq +13 -> 541
    //   531: ldc 122
    //   533: iconst_2
    //   534: ldc 130
    //   536: aload 6
    //   538: invokestatic 128	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   541: aload_1
    //   542: ifnull -23 -> 519
    //   545: aload_1
    //   546: areturn
    //   547: astore 6
    //   549: goto -24 -> 525
    //   552: astore 6
    //   554: goto -29 -> 525
    //   557: astore 6
    //   559: aconst_null
    //   560: astore_1
    //   561: goto -65 -> 496
    //   564: astore 6
    //   566: goto -70 -> 496
    //   569: goto -407 -> 162
    //   572: aload 6
    //   574: astore_1
    //   575: goto -413 -> 162
    //   578: iload 5
    //   580: iload_2
    //   581: if_icmpge -295 -> 286
    //   584: iload 5
    //   586: iload_3
    //   587: if_icmple -301 -> 286
    //   590: iload 4
    //   592: iload_2
    //   593: if_icmpge -307 -> 286
    //   596: iload 4
    //   598: iload_3
    //   599: if_icmple -313 -> 286
    //   602: goto -440 -> 162
    //   605: aload 6
    //   607: astore_1
    //   608: goto -446 -> 162
    //   611: aload 6
    //   613: astore_1
    //   614: goto -452 -> 162
    //   617: aload 6
    //   619: astore_1
    //   620: goto -458 -> 162
    //   623: iload 4
    //   625: iload_2
    //   626: if_icmpge -162 -> 464
    //   629: iload 4
    //   631: iload_3
    //   632: if_icmple -168 -> 464
    //   635: iload 5
    //   637: iload_2
    //   638: if_icmpge -174 -> 464
    //   641: iload 5
    //   643: iload_3
    //   644: if_icmple -180 -> 464
    //   647: goto -485 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	agmp
    //   0	650	1	paramURL	java.net.URL
    //   39	600	2	i	int
    //   45	600	3	j	int
    //   50	583	4	k	int
    //   56	589	5	m	int
    //   85	404	6	localObject	Object
    //   494	14	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   513	1	6	localURL	java.net.URL
    //   521	16	6	localException1	java.lang.Exception
    //   547	1	6	localException2	java.lang.Exception
    //   552	1	6	localException3	java.lang.Exception
    //   557	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   564	54	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   225	233	7	localBitmap	Bitmap
    //   4	159	8	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   34	58	494	java/lang/OutOfMemoryError
    //   65	150	494	java/lang/OutOfMemoryError
    //   155	159	494	java/lang/OutOfMemoryError
    //   252	267	494	java/lang/OutOfMemoryError
    //   275	279	494	java/lang/OutOfMemoryError
    //   286	301	494	java/lang/OutOfMemoryError
    //   309	313	494	java/lang/OutOfMemoryError
    //   320	405	494	java/lang/OutOfMemoryError
    //   413	417	494	java/lang/OutOfMemoryError
    //   430	445	494	java/lang/OutOfMemoryError
    //   453	457	494	java/lang/OutOfMemoryError
    //   464	479	494	java/lang/OutOfMemoryError
    //   484	488	494	java/lang/OutOfMemoryError
    //   11	34	521	java/lang/Exception
    //   34	58	547	java/lang/Exception
    //   65	150	547	java/lang/Exception
    //   155	159	547	java/lang/Exception
    //   252	267	547	java/lang/Exception
    //   275	279	547	java/lang/Exception
    //   286	301	547	java/lang/Exception
    //   309	313	547	java/lang/Exception
    //   320	405	547	java/lang/Exception
    //   413	417	547	java/lang/Exception
    //   430	445	547	java/lang/Exception
    //   453	457	547	java/lang/Exception
    //   464	479	547	java/lang/Exception
    //   484	488	547	java/lang/Exception
    //   162	171	552	java/lang/Exception
    //   178	227	552	java/lang/Exception
    //   235	239	552	java/lang/Exception
    //   11	34	557	java/lang/OutOfMemoryError
    //   162	171	564	java/lang/OutOfMemoryError
    //   178	227	564	java/lang/OutOfMemoryError
    //   235	239	564	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agmp
 * JD-Core Version:    0.7.0.1
 */