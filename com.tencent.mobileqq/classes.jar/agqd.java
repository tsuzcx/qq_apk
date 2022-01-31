import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;

public class agqd
  implements Runnable
{
  public agqd(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, String paramString1, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 29	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 30	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 9
    //   9: aload 9
    //   11: iconst_1
    //   12: putfield 34	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   15: aload_0
    //   16: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   19: getfield 40	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 46	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: invokevirtual 52	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   28: astore 10
    //   30: aload_0
    //   31: getfield 16	agqd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   34: aload 9
    //   36: invokestatic 58	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: pop
    //   40: aload 9
    //   42: iconst_0
    //   43: putfield 34	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: aload 9
    //   48: getstatic 64	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   51: putfield 67	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   54: aload 9
    //   56: aload_0
    //   57: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   60: aload 9
    //   62: aload_0
    //   63: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   66: getfield 71	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   69: aload_0
    //   70: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   73: getfield 74	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   76: invokevirtual 77	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   79: putfield 80	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   82: new 82	java/io/BufferedInputStream
    //   85: dup
    //   86: new 84	java/io/FileInputStream
    //   89: dup
    //   90: new 86	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: getfield 16	agqd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   98: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 95	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore 7
    //   109: aload 7
    //   111: astore 6
    //   113: aload 7
    //   115: aconst_null
    //   116: aload 9
    //   118: invokestatic 99	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   121: astore 8
    //   123: aload 8
    //   125: ifnonnull +27 -> 152
    //   128: aload 7
    //   130: ifnull +8 -> 138
    //   133: aload 7
    //   135: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   138: return
    //   139: astore 6
    //   141: ldc 104
    //   143: iconst_1
    //   144: ldc 106
    //   146: aload 6
    //   148: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   151: return
    //   152: aload 7
    //   154: astore 6
    //   156: aload 8
    //   158: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
    //   161: istore_2
    //   162: aload 7
    //   164: astore 6
    //   166: aload 8
    //   168: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   171: istore_3
    //   172: aload 7
    //   174: astore 6
    //   176: aload_0
    //   177: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   180: getfield 124	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:k	I
    //   183: i2f
    //   184: aload_0
    //   185: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   188: getfield 127	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:j	I
    //   191: i2f
    //   192: fdiv
    //   193: fstore_1
    //   194: aload 7
    //   196: astore 6
    //   198: iload_3
    //   199: iload_2
    //   200: i2f
    //   201: fload_1
    //   202: fmul
    //   203: f2i
    //   204: invokestatic 133	java/lang/Math:min	(II)I
    //   207: istore 4
    //   209: aload 7
    //   211: astore 6
    //   213: iload 4
    //   215: i2f
    //   216: fload_1
    //   217: fdiv
    //   218: f2i
    //   219: istore 5
    //   221: aload 7
    //   223: astore 6
    //   225: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +476 -> 704
    //   231: aload 7
    //   233: astore 6
    //   235: ldc 104
    //   237: iconst_2
    //   238: new 139	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   245: ldc 142
    //   247: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 4
    //   252: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc 151
    //   257: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: iload 5
    //   262: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: ldc 153
    //   267: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 9
    //   272: getfield 80	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   275: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: goto +420 -> 704
    //   287: aload 8
    //   289: ifnull +99 -> 388
    //   292: aload 7
    //   294: astore 6
    //   296: aload 8
    //   298: invokestatic 166	com/tencent/mobileqq/util/Utils:a	(Landroid/graphics/Bitmap;)I
    //   301: istore_2
    //   302: aload 7
    //   304: astore 6
    //   306: new 168	android/graphics/drawable/BitmapDrawable
    //   309: dup
    //   310: aload 10
    //   312: aload 8
    //   314: invokespecial 171	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   317: astore 8
    //   319: aload 7
    //   321: astore 6
    //   323: aload 8
    //   325: aload 10
    //   327: invokevirtual 177	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   330: invokevirtual 181	android/graphics/drawable/BitmapDrawable:setTargetDensity	(Landroid/util/DisplayMetrics;)V
    //   333: aload 7
    //   335: astore 6
    //   337: aload_0
    //   338: getfield 18	agqd:b	Ljava/lang/String;
    //   341: ifnull +34 -> 375
    //   344: aload 7
    //   346: astore 6
    //   348: getstatic 187	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   351: aload_0
    //   352: getfield 18	agqd:b	Ljava/lang/String;
    //   355: new 189	android/util/Pair
    //   358: dup
    //   359: aload 8
    //   361: invokevirtual 193	android/graphics/drawable/BitmapDrawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   364: iload_2
    //   365: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: invokespecial 202	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   371: invokevirtual 208	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   374: pop
    //   375: aload 7
    //   377: astore 6
    //   379: aload_0
    //   380: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   383: aload 8
    //   385: putfield 211	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   388: aload 7
    //   390: astore 6
    //   392: aload_0
    //   393: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   396: getfield 211	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   399: ifnull +34 -> 433
    //   402: aload 7
    //   404: astore 6
    //   406: aload_0
    //   407: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   410: getfield 214	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   413: ifnull +20 -> 433
    //   416: aload 7
    //   418: astore 6
    //   420: aload_0
    //   421: getfield 14	agqd:jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity	Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;
    //   424: getfield 214	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   427: bipush 27
    //   429: invokevirtual 220	android/os/Handler:sendEmptyMessage	(I)Z
    //   432: pop
    //   433: aload 7
    //   435: ifnull -297 -> 138
    //   438: aload 7
    //   440: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   443: return
    //   444: astore 6
    //   446: ldc 104
    //   448: iconst_1
    //   449: ldc 106
    //   451: aload 6
    //   453: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: return
    //   457: aload 7
    //   459: astore 6
    //   461: aload 8
    //   463: iconst_0
    //   464: iconst_0
    //   465: iload 4
    //   467: iload 5
    //   469: invokestatic 224	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   472: astore 9
    //   474: aload 7
    //   476: astore 6
    //   478: aload 8
    //   480: invokevirtual 227	android/graphics/Bitmap:recycle	()V
    //   483: aload 7
    //   485: astore 6
    //   487: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   490: ifeq +15 -> 505
    //   493: aload 7
    //   495: astore 6
    //   497: ldc 104
    //   499: iconst_2
    //   500: ldc 229
    //   502: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload 9
    //   507: astore 8
    //   509: goto -222 -> 287
    //   512: astore 8
    //   514: aconst_null
    //   515: astore 7
    //   517: aload 7
    //   519: astore 6
    //   521: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +36 -> 560
    //   527: aload 7
    //   529: astore 6
    //   531: ldc 104
    //   533: iconst_2
    //   534: new 139	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   541: ldc 231
    //   543: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 8
    //   548: invokevirtual 234	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   551: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload 7
    //   562: ifnull -424 -> 138
    //   565: aload 7
    //   567: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   570: return
    //   571: astore 6
    //   573: ldc 104
    //   575: iconst_1
    //   576: ldc 106
    //   578: aload 6
    //   580: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   583: return
    //   584: astore 8
    //   586: aconst_null
    //   587: astore 7
    //   589: aload 7
    //   591: astore 6
    //   593: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   596: ifeq +36 -> 632
    //   599: aload 7
    //   601: astore 6
    //   603: ldc 104
    //   605: iconst_2
    //   606: new 139	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   613: ldc 236
    //   615: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 8
    //   620: invokevirtual 237	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   623: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload 7
    //   634: ifnull -496 -> 138
    //   637: aload 7
    //   639: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   642: return
    //   643: astore 6
    //   645: ldc 104
    //   647: iconst_1
    //   648: ldc 106
    //   650: aload 6
    //   652: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   655: return
    //   656: astore 7
    //   658: aconst_null
    //   659: astore 6
    //   661: aload 6
    //   663: ifnull +8 -> 671
    //   666: aload 6
    //   668: invokevirtual 102	java/io/BufferedInputStream:close	()V
    //   671: aload 7
    //   673: athrow
    //   674: astore 6
    //   676: ldc 104
    //   678: iconst_1
    //   679: ldc 106
    //   681: aload 6
    //   683: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: goto -15 -> 671
    //   689: astore 7
    //   691: goto -30 -> 661
    //   694: astore 8
    //   696: goto -107 -> 589
    //   699: astore 8
    //   701: goto -184 -> 517
    //   704: iload_3
    //   705: iload 4
    //   707: if_icmpne -250 -> 457
    //   710: iload_2
    //   711: iload 5
    //   713: if_icmpne -256 -> 457
    //   716: goto -429 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	agqd
    //   193	24	1	f	float
    //   161	553	2	i	int
    //   171	537	3	j	int
    //   207	501	4	k	int
    //   219	495	5	m	int
    //   111	1	6	localBufferedInputStream1	java.io.BufferedInputStream
    //   139	8	6	localException1	java.lang.Exception
    //   154	265	6	localBufferedInputStream2	java.io.BufferedInputStream
    //   444	8	6	localException2	java.lang.Exception
    //   459	71	6	localBufferedInputStream3	java.io.BufferedInputStream
    //   571	8	6	localException3	java.lang.Exception
    //   591	11	6	localBufferedInputStream4	java.io.BufferedInputStream
    //   643	8	6	localException4	java.lang.Exception
    //   659	8	6	localObject1	Object
    //   674	8	6	localException5	java.lang.Exception
    //   107	531	7	localBufferedInputStream5	java.io.BufferedInputStream
    //   656	16	7	localObject2	Object
    //   689	1	7	localObject3	Object
    //   121	387	8	localObject4	Object
    //   512	35	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   584	35	8	localException6	java.lang.Exception
    //   694	1	8	localException7	java.lang.Exception
    //   699	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   7	499	9	localObject5	Object
    //   28	298	10	localResources	android.content.res.Resources
    // Exception table:
    //   from	to	target	type
    //   133	138	139	java/lang/Exception
    //   438	443	444	java/lang/Exception
    //   0	109	512	java/lang/OutOfMemoryError
    //   565	570	571	java/lang/Exception
    //   0	109	584	java/lang/Exception
    //   637	642	643	java/lang/Exception
    //   0	109	656	finally
    //   666	671	674	java/lang/Exception
    //   113	123	689	finally
    //   156	162	689	finally
    //   166	172	689	finally
    //   176	194	689	finally
    //   198	209	689	finally
    //   213	221	689	finally
    //   225	231	689	finally
    //   235	284	689	finally
    //   296	302	689	finally
    //   306	319	689	finally
    //   323	333	689	finally
    //   337	344	689	finally
    //   348	375	689	finally
    //   379	388	689	finally
    //   392	402	689	finally
    //   406	416	689	finally
    //   420	433	689	finally
    //   461	474	689	finally
    //   478	483	689	finally
    //   487	493	689	finally
    //   497	505	689	finally
    //   521	527	689	finally
    //   531	560	689	finally
    //   593	599	689	finally
    //   603	632	689	finally
    //   113	123	694	java/lang/Exception
    //   156	162	694	java/lang/Exception
    //   166	172	694	java/lang/Exception
    //   176	194	694	java/lang/Exception
    //   198	209	694	java/lang/Exception
    //   213	221	694	java/lang/Exception
    //   225	231	694	java/lang/Exception
    //   235	284	694	java/lang/Exception
    //   296	302	694	java/lang/Exception
    //   306	319	694	java/lang/Exception
    //   323	333	694	java/lang/Exception
    //   337	344	694	java/lang/Exception
    //   348	375	694	java/lang/Exception
    //   379	388	694	java/lang/Exception
    //   392	402	694	java/lang/Exception
    //   406	416	694	java/lang/Exception
    //   420	433	694	java/lang/Exception
    //   461	474	694	java/lang/Exception
    //   478	483	694	java/lang/Exception
    //   487	493	694	java/lang/Exception
    //   497	505	694	java/lang/Exception
    //   113	123	699	java/lang/OutOfMemoryError
    //   156	162	699	java/lang/OutOfMemoryError
    //   166	172	699	java/lang/OutOfMemoryError
    //   176	194	699	java/lang/OutOfMemoryError
    //   198	209	699	java/lang/OutOfMemoryError
    //   213	221	699	java/lang/OutOfMemoryError
    //   225	231	699	java/lang/OutOfMemoryError
    //   235	284	699	java/lang/OutOfMemoryError
    //   296	302	699	java/lang/OutOfMemoryError
    //   306	319	699	java/lang/OutOfMemoryError
    //   323	333	699	java/lang/OutOfMemoryError
    //   337	344	699	java/lang/OutOfMemoryError
    //   348	375	699	java/lang/OutOfMemoryError
    //   379	388	699	java/lang/OutOfMemoryError
    //   392	402	699	java/lang/OutOfMemoryError
    //   406	416	699	java/lang/OutOfMemoryError
    //   420	433	699	java/lang/OutOfMemoryError
    //   461	474	699	java/lang/OutOfMemoryError
    //   478	483	699	java/lang/OutOfMemoryError
    //   487	493	699	java/lang/OutOfMemoryError
    //   497	505	699	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agqd
 * JD-Core Version:    0.7.0.1
 */