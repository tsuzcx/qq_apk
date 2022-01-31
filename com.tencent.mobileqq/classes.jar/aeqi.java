import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;

public class aeqi
  implements Runnable
{
  public aeqi(NearbyGuideActivity paramNearbyGuideActivity, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: getfield 13	aeqi:jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   10: invokevirtual 30	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:getResources	()Landroid/content/res/Resources;
    //   13: ldc 31
    //   15: invokevirtual 37	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   18: istore 4
    //   20: iconst_0
    //   21: istore_1
    //   22: iconst_0
    //   23: istore_3
    //   24: iconst_0
    //   25: istore_2
    //   26: new 39	java/io/FileInputStream
    //   29: dup
    //   30: new 41	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: getfield 15	aeqi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore 5
    //   46: iload_3
    //   47: istore_1
    //   48: aload 5
    //   50: astore 6
    //   52: new 49	android/graphics/BitmapFactory$Options
    //   55: dup
    //   56: invokespecial 50	android/graphics/BitmapFactory$Options:<init>	()V
    //   59: astore 9
    //   61: iload_3
    //   62: istore_1
    //   63: aload 5
    //   65: astore 6
    //   67: aload 9
    //   69: aload 5
    //   71: iload 4
    //   73: iload 4
    //   75: invokestatic 55	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   78: d2i
    //   79: putfield 59	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   82: iload_3
    //   83: istore_1
    //   84: aload 5
    //   86: astore 6
    //   88: aload 5
    //   90: invokevirtual 64	java/io/InputStream:close	()V
    //   93: aload 8
    //   95: astore 7
    //   97: aload_0
    //   98: getfield 15	aeqi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: aload 9
    //   103: invokestatic 69	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   106: astore 8
    //   108: aload 8
    //   110: astore 6
    //   112: aload 8
    //   114: ifnull +24 -> 138
    //   117: aload 8
    //   119: astore 7
    //   121: aload 8
    //   123: aload 8
    //   125: invokevirtual 75	android/graphics/Bitmap:getWidth	()I
    //   128: aload 8
    //   130: invokevirtual 78	android/graphics/Bitmap:getHeight	()I
    //   133: invokestatic 81	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   136: astore 6
    //   138: aload 6
    //   140: ifnonnull +139 -> 279
    //   143: aload_0
    //   144: getfield 13	aeqi:jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   147: iconst_1
    //   148: ldc 83
    //   150: invokevirtual 86	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:a	(ILjava/lang/String;)V
    //   153: return
    //   154: astore 8
    //   156: aconst_null
    //   157: astore 5
    //   159: iload_2
    //   160: istore_1
    //   161: aload 5
    //   163: astore 6
    //   165: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +20 -> 188
    //   171: iload_2
    //   172: istore_1
    //   173: aload 5
    //   175: astore 6
    //   177: ldc 94
    //   179: iconst_2
    //   180: aload 8
    //   182: invokevirtual 98	java/lang/Throwable:toString	()Ljava/lang/String;
    //   185: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload 7
    //   190: astore 6
    //   192: iload_2
    //   193: ifne -55 -> 138
    //   196: aload 7
    //   198: astore 6
    //   200: aload 5
    //   202: ifnull -64 -> 138
    //   205: aload 5
    //   207: invokevirtual 64	java/io/InputStream:close	()V
    //   210: aload 7
    //   212: astore 6
    //   214: goto -76 -> 138
    //   217: astore 5
    //   219: aload 7
    //   221: astore 6
    //   223: invokestatic 105	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   226: ifeq -88 -> 138
    //   229: aload 5
    //   231: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   234: aload 7
    //   236: astore 6
    //   238: goto -100 -> 138
    //   241: astore 7
    //   243: aconst_null
    //   244: astore 5
    //   246: iload_1
    //   247: ifne +13 -> 260
    //   250: aload 5
    //   252: ifnull +8 -> 260
    //   255: aload 5
    //   257: invokevirtual 64	java/io/InputStream:close	()V
    //   260: aload 7
    //   262: athrow
    //   263: astore 5
    //   265: invokestatic 105	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   268: ifeq -8 -> 260
    //   271: aload 5
    //   273: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   276: goto -16 -> 260
    //   279: aload 6
    //   281: ifnull -128 -> 153
    //   284: invokestatic 114	android/os/Message:obtain	()Landroid/os/Message;
    //   287: astore 5
    //   289: aload 5
    //   291: iconst_2
    //   292: putfield 117	android/os/Message:what	I
    //   295: aload 5
    //   297: aload 6
    //   299: putfield 121	android/os/Message:obj	Ljava/lang/Object;
    //   302: aload_0
    //   303: getfield 13	aeqi:jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity	Lcom/tencent/mobileqq/nearby/guide/NearbyGuideActivity;
    //   306: getfield 124	com/tencent/mobileqq/nearby/guide/NearbyGuideActivity:a	Landroid/os/Handler;
    //   309: aload 5
    //   311: invokevirtual 130	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   314: pop
    //   315: return
    //   316: astore 7
    //   318: aload 6
    //   320: astore 5
    //   322: goto -76 -> 246
    //   325: astore 7
    //   327: iconst_1
    //   328: istore_1
    //   329: goto -83 -> 246
    //   332: astore 8
    //   334: goto -175 -> 159
    //   337: astore 8
    //   339: iconst_1
    //   340: istore_2
    //   341: goto -182 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	aeqi
    //   21	308	1	i	int
    //   25	316	2	j	int
    //   23	60	3	k	int
    //   18	56	4	m	int
    //   44	162	5	localFileInputStream	java.io.FileInputStream
    //   217	13	5	localIOException1	java.io.IOException
    //   244	12	5	localObject1	Object
    //   263	9	5	localIOException2	java.io.IOException
    //   287	34	5	localObject2	Object
    //   50	269	6	localObject3	Object
    //   4	231	7	localBitmap1	android.graphics.Bitmap
    //   241	20	7	localObject4	Object
    //   316	1	7	localObject5	Object
    //   325	1	7	localObject6	Object
    //   1	128	8	localBitmap2	android.graphics.Bitmap
    //   154	27	8	localThrowable1	java.lang.Throwable
    //   332	1	8	localThrowable2	java.lang.Throwable
    //   337	1	8	localThrowable3	java.lang.Throwable
    //   59	43	9	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   26	46	154	java/lang/Throwable
    //   205	210	217	java/io/IOException
    //   26	46	241	finally
    //   255	260	263	java/io/IOException
    //   52	61	316	finally
    //   67	82	316	finally
    //   88	93	316	finally
    //   165	171	316	finally
    //   177	188	316	finally
    //   97	108	325	finally
    //   121	138	325	finally
    //   52	61	332	java/lang/Throwable
    //   67	82	332	java/lang/Throwable
    //   88	93	332	java/lang/Throwable
    //   97	108	337	java/lang/Throwable
    //   121	138	337	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeqi
 * JD-Core Version:    0.7.0.1
 */