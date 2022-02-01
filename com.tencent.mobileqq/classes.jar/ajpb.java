import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;

public class ajpb
  implements BitmapDecoder
{
  /* Error */
  @android.annotation.TargetApi(10)
  public android.graphics.Bitmap getBitmap(java.net.URL paramURL)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 28	com/tencent/mobileqq/activity/photo/LocalMediaInfo:parseUrl	(Ljava/net/URL;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   4: astore 7
    //   6: aload 7
    //   8: ifnull +291 -> 299
    //   11: new 30	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 31	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: iconst_1
    //   21: putfield 35	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload 7
    //   26: getfield 39	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   29: aload_1
    //   30: invokestatic 45	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: pop
    //   34: aload_1
    //   35: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   38: aload_1
    //   39: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   42: if_icmple +95 -> 137
    //   45: aload_1
    //   46: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   49: istore_3
    //   50: aload_1
    //   51: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   54: aload_1
    //   55: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   58: idiv
    //   59: i2f
    //   60: fstore_2
    //   61: fload_2
    //   62: ldc 53
    //   64: fcmpg
    //   65: ifgt +91 -> 156
    //   68: aload_1
    //   69: aload_1
    //   70: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   73: aload_1
    //   74: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   77: aload 7
    //   79: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   82: invokestatic 62	com/tencent/mobileqq/activity/photo/ThumbDecoder:calSampleSize	(III)I
    //   85: putfield 65	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   88: aload_1
    //   89: iconst_0
    //   90: putfield 35	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   93: aload_1
    //   94: getstatic 71	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   97: putfield 74	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   100: aload 7
    //   102: getfield 39	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   105: aload_1
    //   106: invokestatic 79	bfvo:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   109: astore_1
    //   110: aload_1
    //   111: ifnonnull +190 -> 301
    //   114: aload_1
    //   115: astore 6
    //   117: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +14 -> 134
    //   123: ldc 87
    //   125: iconst_2
    //   126: ldc 89
    //   128: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_1
    //   132: astore 6
    //   134: aload 6
    //   136: areturn
    //   137: aload_1
    //   138: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   141: istore_3
    //   142: aload_1
    //   143: getfield 52	android/graphics/BitmapFactory$Options:outHeight	I
    //   146: aload_1
    //   147: getfield 49	android/graphics/BitmapFactory$Options:outWidth	I
    //   150: idiv
    //   151: i2f
    //   152: fstore_2
    //   153: goto -92 -> 61
    //   156: new 95	android/graphics/Rect
    //   159: dup
    //   160: iconst_0
    //   161: iconst_0
    //   162: iload_3
    //   163: iload_3
    //   164: invokespecial 98	android/graphics/Rect:<init>	(IIII)V
    //   167: astore 9
    //   169: aload_1
    //   170: iload_3
    //   171: iload_3
    //   172: aload 7
    //   174: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   177: invokestatic 62	com/tencent/mobileqq/activity/photo/ThumbDecoder:calSampleSize	(III)I
    //   180: putfield 65	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   183: aload_1
    //   184: iconst_0
    //   185: putfield 35	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   188: aload_1
    //   189: getstatic 71	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   192: putfield 74	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   195: new 100	java/io/BufferedInputStream
    //   198: dup
    //   199: new 102	java/io/FileInputStream
    //   202: dup
    //   203: aload 7
    //   205: getfield 39	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   208: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   211: invokespecial 108	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   214: astore 6
    //   216: aload 6
    //   218: iconst_1
    //   219: invokestatic 114	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   222: astore 8
    //   224: aload 6
    //   226: ifnull +8 -> 234
    //   229: aload 6
    //   231: invokevirtual 119	java/io/InputStream:close	()V
    //   234: aload 8
    //   236: ifnull +358 -> 594
    //   239: aload 8
    //   241: aload 9
    //   243: aload_1
    //   244: invokevirtual 123	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   247: astore_1
    //   248: aload 8
    //   250: invokevirtual 126	android/graphics/BitmapRegionDecoder:recycle	()V
    //   253: goto -143 -> 110
    //   256: astore_1
    //   257: aconst_null
    //   258: astore 6
    //   260: aload 6
    //   262: ifnull +8 -> 270
    //   265: aload 6
    //   267: invokevirtual 119	java/io/InputStream:close	()V
    //   270: aload_1
    //   271: athrow
    //   272: astore 6
    //   274: aconst_null
    //   275: astore_1
    //   276: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +13 -> 292
    //   282: ldc 87
    //   284: iconst_2
    //   285: ldc 128
    //   287: aload 6
    //   289: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   292: aload_1
    //   293: astore 6
    //   295: aload_1
    //   296: ifnonnull -162 -> 134
    //   299: aconst_null
    //   300: areturn
    //   301: aload 7
    //   303: getfield 39	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   306: invokestatic 137	com/tencent/mobileqq/transfile/URLDrawableHelper:getExifRotation	(Ljava/lang/String;)I
    //   309: istore_3
    //   310: iload_3
    //   311: ifne +30 -> 341
    //   314: aload_1
    //   315: invokevirtual 143	android/graphics/Bitmap:getWidth	()I
    //   318: aload 7
    //   320: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   323: if_icmpne +18 -> 341
    //   326: aload_1
    //   327: astore 6
    //   329: aload_1
    //   330: invokevirtual 146	android/graphics/Bitmap:getHeight	()I
    //   333: aload 7
    //   335: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   338: if_icmpeq -204 -> 134
    //   341: aload_1
    //   342: invokevirtual 143	android/graphics/Bitmap:getWidth	()I
    //   345: istore 4
    //   347: aload_1
    //   348: invokevirtual 146	android/graphics/Bitmap:getHeight	()I
    //   351: istore 5
    //   353: new 95	android/graphics/Rect
    //   356: dup
    //   357: invokespecial 147	android/graphics/Rect:<init>	()V
    //   360: astore 6
    //   362: new 149	android/graphics/RectF
    //   365: dup
    //   366: fconst_0
    //   367: fconst_0
    //   368: aload 7
    //   370: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   373: i2f
    //   374: aload 7
    //   376: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   379: i2f
    //   380: invokespecial 152	android/graphics/RectF:<init>	(FFFF)V
    //   383: astore 8
    //   385: iload 4
    //   387: iload 5
    //   389: if_icmple +116 -> 505
    //   392: iload 4
    //   394: iload 5
    //   396: isub
    //   397: iconst_2
    //   398: idiv
    //   399: istore 4
    //   401: aload 6
    //   403: iload 4
    //   405: iconst_0
    //   406: iload 4
    //   408: iload 5
    //   410: iadd
    //   411: iload 5
    //   413: iconst_0
    //   414: iadd
    //   415: invokevirtual 155	android/graphics/Rect:set	(IIII)V
    //   418: aload 7
    //   420: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   423: aload 7
    //   425: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   428: getstatic 71	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   431: invokestatic 159	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   434: astore 9
    //   436: new 161	android/graphics/Canvas
    //   439: dup
    //   440: aload 9
    //   442: invokespecial 164	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   445: astore 10
    //   447: iload_3
    //   448: ifeq +26 -> 474
    //   451: aload 10
    //   453: iload_3
    //   454: i2f
    //   455: aload 7
    //   457: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   460: i2f
    //   461: fconst_2
    //   462: fdiv
    //   463: aload 7
    //   465: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   468: i2f
    //   469: fconst_2
    //   470: fdiv
    //   471: invokevirtual 168	android/graphics/Canvas:rotate	(FFF)V
    //   474: aload 10
    //   476: aload_1
    //   477: aload 6
    //   479: aload 8
    //   481: new 170	android/graphics/Paint
    //   484: dup
    //   485: bipush 6
    //   487: invokespecial 173	android/graphics/Paint:<init>	(I)V
    //   490: invokevirtual 177	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   493: aload 9
    //   495: ifnull -196 -> 299
    //   498: aload_1
    //   499: invokevirtual 178	android/graphics/Bitmap:recycle	()V
    //   502: aload 9
    //   504: areturn
    //   505: iload 5
    //   507: iload 4
    //   509: isub
    //   510: iconst_2
    //   511: idiv
    //   512: istore 5
    //   514: aload 6
    //   516: iconst_0
    //   517: iload 5
    //   519: iconst_0
    //   520: iload 4
    //   522: iadd
    //   523: iload 4
    //   525: iload 5
    //   527: iadd
    //   528: invokevirtual 155	android/graphics/Rect:set	(IIII)V
    //   531: goto -113 -> 418
    //   534: astore 6
    //   536: goto -260 -> 276
    //   539: astore 6
    //   541: aconst_null
    //   542: astore_1
    //   543: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +13 -> 559
    //   549: ldc 87
    //   551: iconst_2
    //   552: ldc 180
    //   554: aload 6
    //   556: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   559: aload_1
    //   560: ifnull -261 -> 299
    //   563: aload_1
    //   564: areturn
    //   565: astore 6
    //   567: goto -333 -> 234
    //   570: astore 6
    //   572: goto -302 -> 270
    //   575: astore 6
    //   577: goto -34 -> 543
    //   580: astore 6
    //   582: goto -39 -> 543
    //   585: astore 6
    //   587: goto -311 -> 276
    //   590: astore_1
    //   591: goto -331 -> 260
    //   594: aconst_null
    //   595: astore_1
    //   596: goto -486 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	599	0	this	ajpb
    //   0	599	1	paramURL	java.net.URL
    //   60	93	2	f	float
    //   49	405	3	i	int
    //   345	183	4	j	int
    //   351	177	5	k	int
    //   115	151	6	localObject1	Object
    //   272	16	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   293	222	6	localObject2	Object
    //   534	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   539	16	6	localException1	java.lang.Exception
    //   565	1	6	localIOException1	java.io.IOException
    //   570	1	6	localIOException2	java.io.IOException
    //   575	1	6	localException2	java.lang.Exception
    //   580	1	6	localException3	java.lang.Exception
    //   585	1	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   4	460	7	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   222	258	8	localObject3	Object
    //   167	336	9	localObject4	Object
    //   445	30	10	localCanvas	android.graphics.Canvas
    // Exception table:
    //   from	to	target	type
    //   195	216	256	finally
    //   11	61	272	java/lang/OutOfMemoryError
    //   68	110	272	java/lang/OutOfMemoryError
    //   137	153	272	java/lang/OutOfMemoryError
    //   156	195	272	java/lang/OutOfMemoryError
    //   229	234	272	java/lang/OutOfMemoryError
    //   239	248	272	java/lang/OutOfMemoryError
    //   265	270	272	java/lang/OutOfMemoryError
    //   270	272	272	java/lang/OutOfMemoryError
    //   117	131	534	java/lang/OutOfMemoryError
    //   301	310	534	java/lang/OutOfMemoryError
    //   314	326	534	java/lang/OutOfMemoryError
    //   329	341	534	java/lang/OutOfMemoryError
    //   341	385	534	java/lang/OutOfMemoryError
    //   392	418	534	java/lang/OutOfMemoryError
    //   418	447	534	java/lang/OutOfMemoryError
    //   451	474	534	java/lang/OutOfMemoryError
    //   474	493	534	java/lang/OutOfMemoryError
    //   498	502	534	java/lang/OutOfMemoryError
    //   505	531	534	java/lang/OutOfMemoryError
    //   11	61	539	java/lang/Exception
    //   68	110	539	java/lang/Exception
    //   137	153	539	java/lang/Exception
    //   156	195	539	java/lang/Exception
    //   229	234	539	java/lang/Exception
    //   239	248	539	java/lang/Exception
    //   265	270	539	java/lang/Exception
    //   270	272	539	java/lang/Exception
    //   229	234	565	java/io/IOException
    //   265	270	570	java/io/IOException
    //   248	253	575	java/lang/Exception
    //   117	131	580	java/lang/Exception
    //   301	310	580	java/lang/Exception
    //   314	326	580	java/lang/Exception
    //   329	341	580	java/lang/Exception
    //   341	385	580	java/lang/Exception
    //   392	418	580	java/lang/Exception
    //   418	447	580	java/lang/Exception
    //   451	474	580	java/lang/Exception
    //   474	493	580	java/lang/Exception
    //   498	502	580	java/lang/Exception
    //   505	531	580	java/lang/Exception
    //   248	253	585	java/lang/OutOfMemoryError
    //   216	224	590	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpb
 * JD-Core Version:    0.7.0.1
 */