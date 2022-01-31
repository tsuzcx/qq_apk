import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class adkh
  implements Runnable
{
  public adkh(ForwardBaseOption paramForwardBaseOption, String paramString, QQCustomDialog paramQQCustomDialog) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   4: getfield 32	com/tencent/mobileqq/forward/ForwardBaseOption:jdField_a_of_type_Boolean	Z
    //   7: ifne +234 -> 241
    //   10: ldc 34
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 16	adkh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: ifnonnull +15 -> 33
    //   21: aload_0
    //   22: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   25: aload_0
    //   26: getfield 18	adkh:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   29: invokevirtual 37	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Lcom/tencent/mobileqq/utils/QQCustomDialog;)V
    //   32: return
    //   33: aload_0
    //   34: getfield 16	adkh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: ldc 38
    //   39: invokestatic 43	com/tencent/mobileqq/shortvideo/util/ScreenUtil:a	(F)I
    //   42: ldc 44
    //   44: invokestatic 43	com/tencent/mobileqq/shortvideo/util/ScreenUtil:a	(F)I
    //   47: invokestatic 49	com/tencent/mobileqq/transfile/RegionalThumbDownloader:a	(Ljava/lang/String;II)Ljava/net/URL;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +15 -> 69
    //   57: aload_0
    //   58: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   61: aload_0
    //   62: getfield 18	adkh:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   65: invokevirtual 37	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Lcom/tencent/mobileqq/utils/QQCustomDialog;)V
    //   68: return
    //   69: aload 5
    //   71: invokevirtual 55	java/net/URL:toString	()Ljava/lang/String;
    //   74: invokestatic 60	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/lang/String;)Z
    //   77: ifne +15 -> 92
    //   80: aload_0
    //   81: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   84: aload_0
    //   85: getfield 18	adkh:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   88: invokevirtual 37	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Lcom/tencent/mobileqq/utils/QQCustomDialog;)V
    //   91: return
    //   92: aload 5
    //   94: ifnull +10 -> 104
    //   97: aload 5
    //   99: invokevirtual 55	java/net/URL:toString	()Ljava/lang/String;
    //   102: astore 4
    //   104: aload 4
    //   106: astore 5
    //   108: aload 4
    //   110: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +9 -> 122
    //   116: aload_0
    //   117: getfield 16	adkh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   120: astore 5
    //   122: aload 5
    //   124: invokestatic 72	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   127: astore 4
    //   129: aload 4
    //   131: checkcast 68	com/tencent/image/URLDrawable
    //   134: aconst_null
    //   135: iconst_0
    //   136: invokestatic 77	com/tencent/mobileqq/transfile/URLDrawableHelper:a	(Lcom/tencent/image/URLDrawable;Ljava/lang/String;Z)V
    //   139: aload_0
    //   140: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   143: aload 4
    //   145: aload_0
    //   146: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   149: getfield 32	com/tencent/mobileqq/forward/ForwardBaseOption:jdField_a_of_type_Boolean	Z
    //   152: invokevirtual 80	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/graphics/drawable/Drawable;Z)V
    //   155: aload_0
    //   156: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   159: getfield 83	com/tencent/mobileqq/forward/ForwardBaseOption:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   162: ldc 85
    //   164: invokevirtual 91	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   167: checkcast 93	java/util/ArrayList
    //   170: astore 5
    //   172: aload_0
    //   173: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   176: astore 6
    //   178: aload 5
    //   180: ifnull +424 -> 604
    //   183: aload 5
    //   185: invokevirtual 97	java/util/ArrayList:size	()I
    //   188: istore_1
    //   189: aload 6
    //   191: aload 4
    //   193: iconst_1
    //   194: iload_1
    //   195: aload_0
    //   196: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   199: getfield 32	com/tencent/mobileqq/forward/ForwardBaseOption:jdField_a_of_type_Boolean	Z
    //   202: invokevirtual 100	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/graphics/drawable/Drawable;ZIZ)V
    //   205: return
    //   206: astore 4
    //   208: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq -179 -> 32
    //   214: ldc 108
    //   216: iconst_2
    //   217: new 110	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   224: ldc 113
    //   226: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 4
    //   231: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: return
    //   241: aload_0
    //   242: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   245: getfield 127	com/tencent/mobileqq/forward/ForwardBaseOption:d	Ljava/lang/String;
    //   248: ifnull +273 -> 521
    //   251: aload_0
    //   252: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   255: getfield 127	com/tencent/mobileqq/forward/ForwardBaseOption:d	Ljava/lang/String;
    //   258: invokestatic 60	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/lang/String;)Z
    //   261: ifeq +260 -> 521
    //   264: aload_0
    //   265: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   268: getfield 127	com/tencent/mobileqq/forward/ForwardBaseOption:d	Ljava/lang/String;
    //   271: astore 5
    //   273: aload 5
    //   275: ifnull +279 -> 554
    //   278: getstatic 133	android/os/Build$VERSION:SDK_INT	I
    //   281: bipush 10
    //   283: if_icmplt +329 -> 612
    //   286: aload 5
    //   288: getstatic 139	java/util/Locale:US	Ljava/util/Locale;
    //   291: invokevirtual 145	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   294: ldc 147
    //   296: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   299: ifeq +242 -> 541
    //   302: aload 5
    //   304: iconst_0
    //   305: ldc 147
    //   307: invokevirtual 153	java/lang/String:length	()I
    //   310: invokevirtual 157	java/lang/String:substring	(II)Ljava/lang/String;
    //   313: ldc 147
    //   315: invokevirtual 160	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   318: ifeq +297 -> 615
    //   321: new 162	java/io/File
    //   324: dup
    //   325: aload 5
    //   327: ldc 147
    //   329: invokevirtual 153	java/lang/String:length	()I
    //   332: invokevirtual 165	java/lang/String:substring	(I)Ljava/lang/String;
    //   335: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   338: astore 4
    //   340: aload_0
    //   341: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   344: getfield 171	com/tencent/mobileqq/forward/ForwardBaseOption:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   347: ldc 173
    //   349: iconst_0
    //   350: invokevirtual 179	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   353: istore_2
    //   354: aload_0
    //   355: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   358: getfield 171	com/tencent/mobileqq/forward/ForwardBaseOption:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   361: ldc 181
    //   363: iconst_0
    //   364: invokevirtual 179	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   367: istore_3
    //   368: iload_2
    //   369: ifne +7 -> 376
    //   372: iload_3
    //   373: ifeq +19 -> 392
    //   376: new 162	java/io/File
    //   379: dup
    //   380: aload_0
    //   381: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   384: getfield 184	com/tencent/mobileqq/forward/ForwardBaseOption:c	Ljava/lang/String;
    //   387: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   390: astore 4
    //   392: aload 4
    //   394: ifnull +218 -> 612
    //   397: aload 4
    //   399: invokevirtual 187	java/io/File:exists	()Z
    //   402: ifeq +210 -> 612
    //   405: aload 4
    //   407: invokevirtual 190	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   410: astore 6
    //   412: aload_0
    //   413: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   416: getfield 83	com/tencent/mobileqq/forward/ForwardBaseOption:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   419: ldc 192
    //   421: aload 6
    //   423: invokevirtual 196	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: aload 6
    //   428: ldc 38
    //   430: invokestatic 43	com/tencent/mobileqq/shortvideo/util/ScreenUtil:a	(F)I
    //   433: ldc 44
    //   435: invokestatic 43	com/tencent/mobileqq/shortvideo/util/ScreenUtil:a	(F)I
    //   438: invokestatic 49	com/tencent/mobileqq/transfile/RegionalThumbDownloader:a	(Ljava/lang/String;II)Ljava/net/URL;
    //   441: astore 4
    //   443: aload 4
    //   445: ifnull +164 -> 609
    //   448: aload 4
    //   450: invokevirtual 55	java/net/URL:toString	()Ljava/lang/String;
    //   453: astore 5
    //   455: aload 5
    //   457: astore 4
    //   459: aload 5
    //   461: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   464: ifeq +7 -> 471
    //   467: aload 6
    //   469: astore 4
    //   471: aload 4
    //   473: astore 5
    //   475: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +33 -> 511
    //   481: ldc 108
    //   483: iconst_2
    //   484: new 110	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   491: ldc 198
    //   493: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload 4
    //   498: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 201	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: aload 4
    //   509: astore 5
    //   511: aload 5
    //   513: invokestatic 72	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   516: astore 4
    //   518: goto -379 -> 139
    //   521: aload_0
    //   522: getfield 14	adkh:jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption	Lcom/tencent/mobileqq/forward/ForwardBaseOption;
    //   525: getfield 184	com/tencent/mobileqq/forward/ForwardBaseOption:c	Ljava/lang/String;
    //   528: astore 5
    //   530: goto -257 -> 273
    //   533: astore 4
    //   535: aconst_null
    //   536: astore 4
    //   538: goto -198 -> 340
    //   541: aload 5
    //   543: invokestatic 205	com/tencent/mobileqq/transfile/AbsDownloader:b	(Ljava/lang/String;)Ljava/lang/String;
    //   546: invokestatic 208	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/lang/String;)Ljava/io/File;
    //   549: astore 4
    //   551: goto -211 -> 340
    //   554: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq -525 -> 32
    //   560: ldc 108
    //   562: iconst_2
    //   563: ldc 210
    //   565: invokestatic 201	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: return
    //   569: astore 4
    //   571: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq -542 -> 32
    //   577: ldc 108
    //   579: iconst_2
    //   580: new 110	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   587: ldc 212
    //   589: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload 4
    //   594: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: return
    //   604: iconst_0
    //   605: istore_1
    //   606: goto -417 -> 189
    //   609: goto -154 -> 455
    //   612: goto -101 -> 511
    //   615: aconst_null
    //   616: astore 4
    //   618: goto -278 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	adkh
    //   188	418	1	i	int
    //   353	16	2	bool1	boolean
    //   367	6	3	bool2	boolean
    //   12	180	4	localObject1	Object
    //   206	24	4	localException1	java.lang.Exception
    //   338	179	4	localObject2	Object
    //   533	1	4	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   536	14	4	localFile	java.io.File
    //   569	24	4	localException2	java.lang.Exception
    //   616	1	4	localObject3	Object
    //   50	492	5	localObject4	Object
    //   176	292	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   122	139	206	java/lang/Exception
    //   302	340	533	java/lang/IndexOutOfBoundsException
    //   511	518	569	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adkh
 * JD-Core Version:    0.7.0.1
 */