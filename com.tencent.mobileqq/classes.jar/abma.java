import com.tencent.mobileqq.config.splashlogo.ConfigServlet;

public class abma
  implements Runnable
{
  public abma(ConfigServlet paramConfigServlet, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3, String paramString3, String paramString4, float paramFloat4, boolean paramBoolean, int paramInt, String paramString5) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 53	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: getfield 22	abma:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 60
    //   16: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 18
    //   24: aload_0
    //   25: getfield 20	abma:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   28: invokevirtual 70	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   31: checkcast 72	com/tencent/common/app/AppInterface
    //   34: aload_0
    //   35: getfield 24	abma:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   38: new 74	java/io/File
    //   41: dup
    //   42: aload 18
    //   44: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokestatic 82	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   50: ifeq +986 -> 1036
    //   53: invokestatic 88	com/tencent/mobileqq/utils/DeviceInfoUtil:h	()J
    //   56: l2i
    //   57: istore 7
    //   59: invokestatic 91	com/tencent/mobileqq/utils/DeviceInfoUtil:i	()J
    //   62: l2i
    //   63: istore 8
    //   65: aload_0
    //   66: getfield 20	abma:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   69: aload_0
    //   70: getfield 26	abma:jdField_a_of_type_Float	F
    //   73: iload 7
    //   75: i2f
    //   76: invokestatic 94	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;FF)F
    //   79: fstore_3
    //   80: aload_0
    //   81: getfield 20	abma:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   84: aload_0
    //   85: getfield 28	abma:jdField_b_of_type_Float	F
    //   88: iload 8
    //   90: i2f
    //   91: iload 7
    //   93: i2f
    //   94: invokestatic 97	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;FFF)F
    //   97: fstore 4
    //   99: aload_0
    //   100: getfield 20	abma:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   103: aload_0
    //   104: getfield 30	abma:jdField_c_of_type_Float	F
    //   107: invokestatic 100	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;F)F
    //   110: fstore 5
    //   112: aconst_null
    //   113: astore 10
    //   115: aconst_null
    //   116: astore 11
    //   118: aload 18
    //   120: invokestatic 106	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   123: astore 12
    //   125: aload 12
    //   127: astore 10
    //   129: aload 10
    //   131: ifnull +1743 -> 1874
    //   134: aload 10
    //   136: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   139: ifne +1735 -> 1874
    //   142: iload 7
    //   144: iload 8
    //   146: getstatic 118	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   149: invokestatic 122	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   152: astore 12
    //   154: aload 12
    //   156: astore 11
    //   158: aload 11
    //   160: astore 15
    //   162: aload 10
    //   164: astore 16
    //   166: aload 11
    //   168: ifnull +832 -> 1000
    //   171: aload 11
    //   173: astore 15
    //   175: aload 10
    //   177: astore 16
    //   179: aload 10
    //   181: astore 14
    //   183: aload 11
    //   185: astore 13
    //   187: aload 10
    //   189: astore 12
    //   191: aload 11
    //   193: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   196: ifne +804 -> 1000
    //   199: aload 10
    //   201: astore 14
    //   203: aload 11
    //   205: astore 13
    //   207: aload 10
    //   209: astore 12
    //   211: new 124	android/graphics/Canvas
    //   214: dup
    //   215: aload 11
    //   217: invokespecial 127	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   220: astore 19
    //   222: aload 10
    //   224: astore 14
    //   226: aload 11
    //   228: astore 13
    //   230: aload 10
    //   232: astore 12
    //   234: new 129	android/graphics/Paint
    //   237: dup
    //   238: invokespecial 130	android/graphics/Paint:<init>	()V
    //   241: astore 15
    //   243: aload 10
    //   245: astore 14
    //   247: aload 11
    //   249: astore 13
    //   251: aload 10
    //   253: astore 12
    //   255: aload 19
    //   257: aload 10
    //   259: new 132	android/graphics/Rect
    //   262: dup
    //   263: iconst_0
    //   264: iconst_0
    //   265: aload 10
    //   267: invokevirtual 136	android/graphics/Bitmap:getWidth	()I
    //   270: aload 10
    //   272: invokevirtual 139	android/graphics/Bitmap:getHeight	()I
    //   275: invokespecial 142	android/graphics/Rect:<init>	(IIII)V
    //   278: new 132	android/graphics/Rect
    //   281: dup
    //   282: iconst_0
    //   283: iconst_0
    //   284: iload 7
    //   286: iload 8
    //   288: invokespecial 142	android/graphics/Rect:<init>	(IIII)V
    //   291: aload 15
    //   293: invokevirtual 146	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   296: aload 10
    //   298: astore 14
    //   300: aload 11
    //   302: astore 13
    //   304: aload 10
    //   306: astore 12
    //   308: aload 10
    //   310: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   313: aconst_null
    //   314: astore 15
    //   316: aconst_null
    //   317: astore 17
    //   319: aconst_null
    //   320: astore 16
    //   322: aload 15
    //   324: astore 14
    //   326: aload 11
    //   328: astore 13
    //   330: aload 17
    //   332: astore 12
    //   334: new 151	android/text/TextPaint
    //   337: dup
    //   338: invokespecial 152	android/text/TextPaint:<init>	()V
    //   341: astore 20
    //   343: aload 15
    //   345: astore 14
    //   347: aload 11
    //   349: astore 13
    //   351: aload 17
    //   353: astore 12
    //   355: aload 20
    //   357: iconst_1
    //   358: invokevirtual 156	android/text/TextPaint:setAntiAlias	(Z)V
    //   361: aload 15
    //   363: astore 14
    //   365: aload 11
    //   367: astore 13
    //   369: aload 17
    //   371: astore 12
    //   373: aload 20
    //   375: aload_0
    //   376: getfield 32	abma:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   379: invokestatic 162	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   382: invokevirtual 166	android/text/TextPaint:setColor	(I)V
    //   385: aload 15
    //   387: astore 14
    //   389: aload 11
    //   391: astore 13
    //   393: aload 17
    //   395: astore 12
    //   397: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +62 -> 462
    //   403: aload 15
    //   405: astore 14
    //   407: aload 11
    //   409: astore 13
    //   411: aload 17
    //   413: astore 12
    //   415: ldc 173
    //   417: iconst_2
    //   418: new 53	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   425: ldc 175
    //   427: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: fload_3
    //   431: invokevirtual 178	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   434: ldc 180
    //   436: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: fload 4
    //   441: invokevirtual 178	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   444: ldc 182
    //   446: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_0
    //   450: getfield 32	abma:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   453: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 185	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload 15
    //   464: astore 14
    //   466: aload 11
    //   468: astore 13
    //   470: aload 17
    //   472: astore 12
    //   474: ldc 187
    //   476: aload_0
    //   477: getfield 34	abma:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   480: invokevirtual 193	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   483: ifeq +659 -> 1142
    //   486: aload 15
    //   488: astore 14
    //   490: aload 11
    //   492: astore 13
    //   494: aload 17
    //   496: astore 12
    //   498: aload 20
    //   500: aload_0
    //   501: getfield 20	abma:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   504: invokevirtual 70	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   507: invokevirtual 199	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   510: aload_0
    //   511: getfield 36	abma:jdField_d_of_type_Float	F
    //   514: invokestatic 204	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   517: i2f
    //   518: invokevirtual 208	android/text/TextPaint:setTextSize	(F)V
    //   521: aload 15
    //   523: astore 14
    //   525: aload 11
    //   527: astore 13
    //   529: aload 17
    //   531: astore 12
    //   533: aload 20
    //   535: invokevirtual 212	android/text/TextPaint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   538: astore 10
    //   540: aload 15
    //   542: astore 14
    //   544: aload 11
    //   546: astore 13
    //   548: aload 17
    //   550: astore 12
    //   552: aload_0
    //   553: getfield 38	abma:jdField_a_of_type_Boolean	Z
    //   556: ifeq +1331 -> 1887
    //   559: aload 15
    //   561: astore 14
    //   563: aload 11
    //   565: astore 13
    //   567: aload 17
    //   569: astore 12
    //   571: aload 10
    //   573: getfield 217	android/graphics/Paint$FontMetrics:ascent	F
    //   576: fstore_1
    //   577: fload 4
    //   579: fload_1
    //   580: fsub
    //   581: fstore_1
    //   582: aload 15
    //   584: astore 14
    //   586: aload 11
    //   588: astore 13
    //   590: aload 17
    //   592: astore 12
    //   594: aload 20
    //   596: invokestatic 219	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   599: invokevirtual 223	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   602: fload 5
    //   604: fcmpl
    //   605: ifle +432 -> 1037
    //   608: ldc 225
    //   610: astore 10
    //   612: iconst_1
    //   613: istore 7
    //   615: iconst_1
    //   616: istore 8
    //   618: iload 8
    //   620: ifeq +85 -> 705
    //   623: aload 15
    //   625: astore 14
    //   627: aload 11
    //   629: astore 13
    //   631: aload 17
    //   633: astore 12
    //   635: new 53	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   642: invokestatic 219	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   645: iconst_0
    //   646: invokestatic 219	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   649: invokevirtual 228	java/lang/String:length	()I
    //   652: iload 7
    //   654: isub
    //   655: invokevirtual 232	java/lang/String:substring	(II)Ljava/lang/String;
    //   658: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: ldc 234
    //   663: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: astore 10
    //   671: aload 15
    //   673: astore 14
    //   675: aload 11
    //   677: astore 13
    //   679: aload 17
    //   681: astore 12
    //   683: aload 20
    //   685: aload 10
    //   687: invokevirtual 223	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   690: fload 5
    //   692: fcmpl
    //   693: ifle +1199 -> 1892
    //   696: iload 7
    //   698: iconst_1
    //   699: iadd
    //   700: istore 7
    //   702: goto +1182 -> 1884
    //   705: aload 15
    //   707: astore 14
    //   709: aload 11
    //   711: astore 13
    //   713: aload 17
    //   715: astore 12
    //   717: aload 19
    //   719: aload 10
    //   721: fload_3
    //   722: fload_1
    //   723: aload 20
    //   725: invokevirtual 238	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   728: aload 15
    //   730: astore 14
    //   732: aload 11
    //   734: astore 13
    //   736: aload 17
    //   738: astore 12
    //   740: aload 19
    //   742: bipush 31
    //   744: invokevirtual 242	android/graphics/Canvas:save	(I)I
    //   747: pop
    //   748: aload 15
    //   750: astore 14
    //   752: aload 11
    //   754: astore 13
    //   756: aload 17
    //   758: astore 12
    //   760: aload 19
    //   762: invokevirtual 245	android/graphics/Canvas:restore	()V
    //   765: aload 15
    //   767: astore 14
    //   769: aload 11
    //   771: astore 13
    //   773: aload 17
    //   775: astore 12
    //   777: new 74	java/io/File
    //   780: dup
    //   781: aload_0
    //   782: getfield 22	abma:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   785: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   788: astore 10
    //   790: aload 15
    //   792: astore 14
    //   794: aload 11
    //   796: astore 13
    //   798: aload 17
    //   800: astore 12
    //   802: new 74	java/io/File
    //   805: dup
    //   806: aload 18
    //   808: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   811: astore 18
    //   813: aload 15
    //   815: astore 14
    //   817: aload 11
    //   819: astore 13
    //   821: aload 17
    //   823: astore 12
    //   825: new 247	java/io/BufferedOutputStream
    //   828: dup
    //   829: new 249	java/io/FileOutputStream
    //   832: dup
    //   833: aload 18
    //   835: invokespecial 252	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   838: invokespecial 255	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   841: astore 19
    //   843: aload 15
    //   845: astore 14
    //   847: aload 11
    //   849: astore 13
    //   851: aload 17
    //   853: astore 12
    //   855: aload 11
    //   857: getstatic 261	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   860: bipush 100
    //   862: aload 19
    //   864: invokevirtual 265	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   867: pop
    //   868: aload 15
    //   870: astore 14
    //   872: aload 11
    //   874: astore 13
    //   876: aload 17
    //   878: astore 12
    //   880: aload 19
    //   882: invokevirtual 268	java/io/BufferedOutputStream:flush	()V
    //   885: aload 15
    //   887: astore 14
    //   889: aload 11
    //   891: astore 13
    //   893: aload 17
    //   895: astore 12
    //   897: aload 19
    //   899: invokevirtual 271	java/io/BufferedOutputStream:close	()V
    //   902: aload 15
    //   904: astore 14
    //   906: aload 11
    //   908: astore 13
    //   910: aload 17
    //   912: astore 12
    //   914: aload 10
    //   916: invokevirtual 274	java/io/File:exists	()Z
    //   919: ifeq +21 -> 940
    //   922: aload 15
    //   924: astore 14
    //   926: aload 11
    //   928: astore 13
    //   930: aload 17
    //   932: astore 12
    //   934: aload 10
    //   936: invokevirtual 277	java/io/File:delete	()Z
    //   939: pop
    //   940: aload 15
    //   942: astore 14
    //   944: aload 11
    //   946: astore 13
    //   948: aload 17
    //   950: astore 12
    //   952: aload 18
    //   954: aload 10
    //   956: invokevirtual 281	java/io/File:renameTo	(Ljava/io/File;)Z
    //   959: pop
    //   960: aload 15
    //   962: astore 14
    //   964: aload 11
    //   966: astore 13
    //   968: aload 17
    //   970: astore 12
    //   972: aload_0
    //   973: getfield 20	abma:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   976: invokevirtual 70	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   979: invokevirtual 199	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   982: aload_0
    //   983: getfield 40	abma:jdField_a_of_type_Int	I
    //   986: aload_0
    //   987: getfield 42	abma:e	Ljava/lang/String;
    //   990: getstatic 282	com/tencent/mobileqq/config/splashlogo/ConfigServlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   993: invokestatic 287	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   996: aload 11
    //   998: astore 15
    //   1000: aload 16
    //   1002: ifnull +16 -> 1018
    //   1005: aload 16
    //   1007: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   1010: ifne +8 -> 1018
    //   1013: aload 16
    //   1015: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   1018: aload 15
    //   1020: ifnull +16 -> 1036
    //   1023: aload 15
    //   1025: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   1028: ifne +8 -> 1036
    //   1031: aload 15
    //   1033: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   1036: return
    //   1037: aload 15
    //   1039: astore 14
    //   1041: aload 11
    //   1043: astore 13
    //   1045: aload 17
    //   1047: astore 12
    //   1049: aload 19
    //   1051: invokestatic 219	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1054: fload_3
    //   1055: fload_1
    //   1056: aload 20
    //   1058: invokevirtual 238	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1061: goto -333 -> 728
    //   1064: astore 12
    //   1066: aconst_null
    //   1067: astore 10
    //   1069: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1072: ifeq +33 -> 1105
    //   1075: ldc 173
    //   1077: iconst_2
    //   1078: new 53	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1085: ldc_w 289
    //   1088: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload 12
    //   1093: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1096: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokestatic 185	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1105: aload 10
    //   1107: ifnull +16 -> 1123
    //   1110: aload 10
    //   1112: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   1115: ifne +8 -> 1123
    //   1118: aload 10
    //   1120: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   1123: aload 11
    //   1125: ifnull -89 -> 1036
    //   1128: aload 11
    //   1130: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   1133: ifne -97 -> 1036
    //   1136: aload 11
    //   1138: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   1141: return
    //   1142: aload 15
    //   1144: astore 14
    //   1146: aload 11
    //   1148: astore 13
    //   1150: aload 17
    //   1152: astore 12
    //   1154: ldc_w 294
    //   1157: aload_0
    //   1158: getfield 34	abma:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1161: invokevirtual 193	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1164: ifeq +591 -> 1755
    //   1167: aload 15
    //   1169: astore 14
    //   1171: aload 11
    //   1173: astore 13
    //   1175: aload 17
    //   1177: astore 12
    //   1179: aload_0
    //   1180: getfield 36	abma:jdField_d_of_type_Float	F
    //   1183: ldc_w 295
    //   1186: fcmpg
    //   1187: ifge +256 -> 1443
    //   1190: ldc_w 295
    //   1193: fstore_1
    //   1194: goto +707 -> 1901
    //   1197: aload 15
    //   1199: astore 14
    //   1201: aload 11
    //   1203: astore 13
    //   1205: aload 17
    //   1207: astore 12
    //   1209: aload 20
    //   1211: aload_0
    //   1212: getfield 20	abma:jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet	Lcom/tencent/mobileqq/config/splashlogo/ConfigServlet;
    //   1215: invokevirtual 70	com/tencent/mobileqq/config/splashlogo/ConfigServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1218: invokevirtual 199	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   1221: fload_1
    //   1222: invokestatic 204	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1225: i2f
    //   1226: invokevirtual 208	android/text/TextPaint:setTextSize	(F)V
    //   1229: aload 15
    //   1231: astore 14
    //   1233: aload 11
    //   1235: astore 13
    //   1237: aload 17
    //   1239: astore 12
    //   1241: aload 20
    //   1243: invokestatic 219	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1246: invokevirtual 223	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   1249: fstore_2
    //   1250: fload_2
    //   1251: fload 5
    //   1253: fcmpg
    //   1254: ifgt +650 -> 1904
    //   1257: iconst_1
    //   1258: istore 7
    //   1260: iload 7
    //   1262: ifeq +201 -> 1463
    //   1265: aload 15
    //   1267: astore 14
    //   1269: aload 11
    //   1271: astore 13
    //   1273: aload 17
    //   1275: astore 12
    //   1277: aload 20
    //   1279: invokevirtual 212	android/text/TextPaint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   1282: astore 10
    //   1284: aload 15
    //   1286: astore 14
    //   1288: aload 11
    //   1290: astore 13
    //   1292: aload 17
    //   1294: astore 12
    //   1296: aload_0
    //   1297: getfield 38	abma:jdField_a_of_type_Boolean	Z
    //   1300: ifeq +639 -> 1939
    //   1303: aload 15
    //   1305: astore 14
    //   1307: aload 11
    //   1309: astore 13
    //   1311: aload 17
    //   1313: astore 12
    //   1315: aload 10
    //   1317: getfield 217	android/graphics/Paint$FontMetrics:ascent	F
    //   1320: fstore_1
    //   1321: aload 15
    //   1323: astore 14
    //   1325: aload 11
    //   1327: astore 13
    //   1329: aload 17
    //   1331: astore 12
    //   1333: fload_2
    //   1334: fconst_2
    //   1335: fdiv
    //   1336: fstore_2
    //   1337: aload 15
    //   1339: astore 14
    //   1341: aload 11
    //   1343: astore 13
    //   1345: aload 17
    //   1347: astore 12
    //   1349: aload 19
    //   1351: invokestatic 219	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1354: fload_3
    //   1355: fload_2
    //   1356: fsub
    //   1357: fload 4
    //   1359: fload_1
    //   1360: fsub
    //   1361: aload 20
    //   1363: invokevirtual 238	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1366: goto -638 -> 728
    //   1369: astore 10
    //   1371: aload 14
    //   1373: astore 10
    //   1375: aload 11
    //   1377: astore 13
    //   1379: aload 10
    //   1381: astore 12
    //   1383: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1386: ifeq +20 -> 1406
    //   1389: aload 11
    //   1391: astore 13
    //   1393: aload 10
    //   1395: astore 12
    //   1397: ldc 173
    //   1399: iconst_2
    //   1400: ldc_w 297
    //   1403: invokestatic 185	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1406: aload 10
    //   1408: ifnull +16 -> 1424
    //   1411: aload 10
    //   1413: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   1416: ifne +8 -> 1424
    //   1419: aload 10
    //   1421: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   1424: aload 11
    //   1426: ifnull -390 -> 1036
    //   1429: aload 11
    //   1431: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   1434: ifne -398 -> 1036
    //   1437: aload 11
    //   1439: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   1442: return
    //   1443: aload 15
    //   1445: astore 14
    //   1447: aload 11
    //   1449: astore 13
    //   1451: aload 17
    //   1453: astore 12
    //   1455: aload_0
    //   1456: getfield 36	abma:jdField_d_of_type_Float	F
    //   1459: fstore_1
    //   1460: goto +441 -> 1901
    //   1463: aload 15
    //   1465: astore 14
    //   1467: aload 11
    //   1469: astore 13
    //   1471: aload 17
    //   1473: astore 12
    //   1475: invokestatic 219	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1478: invokevirtual 228	java/lang/String:length	()I
    //   1481: istore 9
    //   1483: ldc 225
    //   1485: astore 10
    //   1487: fload_2
    //   1488: fstore_1
    //   1489: iconst_1
    //   1490: istore 8
    //   1492: iload 8
    //   1494: iload 9
    //   1496: if_icmpgt +369 -> 1865
    //   1499: aload 15
    //   1501: astore 14
    //   1503: aload 11
    //   1505: astore 13
    //   1507: aload 17
    //   1509: astore 12
    //   1511: new 53	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1518: invokestatic 219	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1521: iconst_0
    //   1522: invokestatic 219	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	()Ljava/lang/String;
    //   1525: invokevirtual 228	java/lang/String:length	()I
    //   1528: iload 8
    //   1530: isub
    //   1531: invokevirtual 232	java/lang/String:substring	(II)Ljava/lang/String;
    //   1534: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: ldc 234
    //   1539: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1545: astore 10
    //   1547: aload 15
    //   1549: astore 14
    //   1551: aload 11
    //   1553: astore 13
    //   1555: aload 17
    //   1557: astore 12
    //   1559: aload 20
    //   1561: aload 10
    //   1563: invokevirtual 223	android/text/TextPaint:measureText	(Ljava/lang/String;)F
    //   1566: fstore_1
    //   1567: fload_1
    //   1568: fload 5
    //   1570: fcmpl
    //   1571: ifle +373 -> 1944
    //   1574: iload 8
    //   1576: iconst_1
    //   1577: iadd
    //   1578: istore 8
    //   1580: goto -88 -> 1492
    //   1583: iload 7
    //   1585: ifeq +146 -> 1731
    //   1588: aload 15
    //   1590: astore 14
    //   1592: aload 11
    //   1594: astore 13
    //   1596: aload 17
    //   1598: astore 12
    //   1600: aload 20
    //   1602: invokevirtual 212	android/text/TextPaint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   1605: astore 21
    //   1607: aload 15
    //   1609: astore 14
    //   1611: aload 11
    //   1613: astore 13
    //   1615: aload 17
    //   1617: astore 12
    //   1619: aload_0
    //   1620: getfield 38	abma:jdField_a_of_type_Boolean	Z
    //   1623: ifeq +103 -> 1726
    //   1626: aload 15
    //   1628: astore 14
    //   1630: aload 11
    //   1632: astore 13
    //   1634: aload 17
    //   1636: astore 12
    //   1638: aload 21
    //   1640: getfield 217	android/graphics/Paint$FontMetrics:ascent	F
    //   1643: fstore_2
    //   1644: aload 15
    //   1646: astore 14
    //   1648: aload 11
    //   1650: astore 13
    //   1652: aload 17
    //   1654: astore 12
    //   1656: aload 19
    //   1658: aload 10
    //   1660: fload_3
    //   1661: fload_1
    //   1662: fconst_2
    //   1663: fdiv
    //   1664: fsub
    //   1665: fload 4
    //   1667: fload_2
    //   1668: fsub
    //   1669: aload 20
    //   1671: invokevirtual 238	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1674: goto -946 -> 728
    //   1677: astore 11
    //   1679: aload 12
    //   1681: astore 10
    //   1683: aload 13
    //   1685: astore 12
    //   1687: aload 10
    //   1689: ifnull +16 -> 1705
    //   1692: aload 10
    //   1694: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   1697: ifne +8 -> 1705
    //   1700: aload 10
    //   1702: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   1705: aload 12
    //   1707: ifnull +16 -> 1723
    //   1710: aload 12
    //   1712: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   1715: ifne +8 -> 1723
    //   1718: aload 12
    //   1720: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   1723: aload 11
    //   1725: athrow
    //   1726: fconst_0
    //   1727: fstore_2
    //   1728: goto -84 -> 1644
    //   1731: aload 15
    //   1733: astore 14
    //   1735: aload 11
    //   1737: astore 13
    //   1739: aload 17
    //   1741: astore 12
    //   1743: ldc 173
    //   1745: iconst_1
    //   1746: ldc_w 299
    //   1749: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1752: goto -1024 -> 728
    //   1755: aload 15
    //   1757: astore 14
    //   1759: aload 11
    //   1761: astore 13
    //   1763: aload 17
    //   1765: astore 12
    //   1767: ldc 173
    //   1769: iconst_1
    //   1770: new 53	java/lang/StringBuilder
    //   1773: dup
    //   1774: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1777: ldc_w 303
    //   1780: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: aload_0
    //   1784: getfield 34	abma:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1787: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1793: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1796: goto -1068 -> 728
    //   1799: astore 11
    //   1801: aconst_null
    //   1802: astore 10
    //   1804: aconst_null
    //   1805: astore 12
    //   1807: goto -120 -> 1687
    //   1810: astore 11
    //   1812: aconst_null
    //   1813: astore 12
    //   1815: goto -128 -> 1687
    //   1818: astore 13
    //   1820: aload 11
    //   1822: astore 12
    //   1824: aload 13
    //   1826: astore 11
    //   1828: goto -141 -> 1687
    //   1831: astore 10
    //   1833: aconst_null
    //   1834: astore 10
    //   1836: aconst_null
    //   1837: astore 11
    //   1839: goto -464 -> 1375
    //   1842: astore 11
    //   1844: aconst_null
    //   1845: astore 11
    //   1847: goto -472 -> 1375
    //   1850: astore 12
    //   1852: goto -783 -> 1069
    //   1855: astore 12
    //   1857: goto -788 -> 1069
    //   1860: astore 12
    //   1862: goto -793 -> 1069
    //   1865: goto -282 -> 1583
    //   1868: iconst_0
    //   1869: istore 7
    //   1871: goto -611 -> 1260
    //   1874: aconst_null
    //   1875: astore 15
    //   1877: aload 10
    //   1879: astore 16
    //   1881: goto -881 -> 1000
    //   1884: goto -1266 -> 618
    //   1887: fconst_0
    //   1888: fstore_1
    //   1889: goto -1312 -> 577
    //   1892: iconst_0
    //   1893: istore 8
    //   1895: iconst_0
    //   1896: istore 7
    //   1898: goto -14 -> 1884
    //   1901: goto -704 -> 1197
    //   1904: fload_1
    //   1905: ldc_w 295
    //   1908: fsub
    //   1909: fstore 6
    //   1911: fload 6
    //   1913: fconst_1
    //   1914: fcmpl
    //   1915: ifle +10 -> 1925
    //   1918: fload_1
    //   1919: fconst_1
    //   1920: fsub
    //   1921: fstore_1
    //   1922: goto -725 -> 1197
    //   1925: fload 6
    //   1927: fconst_0
    //   1928: fcmpl
    //   1929: ifle -61 -> 1868
    //   1932: ldc_w 295
    //   1935: fstore_1
    //   1936: goto -739 -> 1197
    //   1939: fconst_0
    //   1940: fstore_1
    //   1941: goto -620 -> 1321
    //   1944: iconst_1
    //   1945: istore 7
    //   1947: goto -364 -> 1583
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1950	0	this	abma
    //   576	1365	1	f1	float
    //   1249	479	2	f2	float
    //   79	1582	3	f3	float
    //   97	1569	4	f4	float
    //   110	1459	5	f5	float
    //   1909	17	6	f6	float
    //   57	1889	7	i	int
    //   63	1831	8	j	int
    //   1481	16	9	k	int
    //   113	1203	10	localObject1	Object
    //   1369	1	10	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1373	430	10	localObject2	Object
    //   1831	1	10	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1834	44	10	localObject3	Object
    //   116	1533	11	localObject4	Object
    //   1677	83	11	localObject5	Object
    //   1799	1	11	localObject6	Object
    //   1810	11	11	localObject7	Object
    //   1826	12	11	localObject8	Object
    //   1842	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1845	1	11	localObject9	Object
    //   123	925	12	localObject10	Object
    //   1064	28	12	localException1	java.lang.Exception
    //   1152	671	12	localObject11	Object
    //   1850	1	12	localException2	java.lang.Exception
    //   1855	1	12	localException3	java.lang.Exception
    //   1860	1	12	localException4	java.lang.Exception
    //   185	1577	13	localObject12	Object
    //   1818	7	13	localObject13	Object
    //   181	1577	14	localObject14	Object
    //   160	1716	15	localObject15	Object
    //   164	1716	16	localObject16	Object
    //   317	1447	17	localObject17	Object
    //   22	931	18	localObject18	Object
    //   220	1437	19	localObject19	Object
    //   341	1329	20	localTextPaint	android.text.TextPaint
    //   1605	34	21	localFontMetrics	android.graphics.Paint.FontMetrics
    // Exception table:
    //   from	to	target	type
    //   334	343	1064	java/lang/Exception
    //   355	361	1064	java/lang/Exception
    //   373	385	1064	java/lang/Exception
    //   397	403	1064	java/lang/Exception
    //   415	462	1064	java/lang/Exception
    //   474	486	1064	java/lang/Exception
    //   498	521	1064	java/lang/Exception
    //   533	540	1064	java/lang/Exception
    //   552	559	1064	java/lang/Exception
    //   571	577	1064	java/lang/Exception
    //   594	608	1064	java/lang/Exception
    //   635	671	1064	java/lang/Exception
    //   683	696	1064	java/lang/Exception
    //   717	728	1064	java/lang/Exception
    //   740	748	1064	java/lang/Exception
    //   760	765	1064	java/lang/Exception
    //   777	790	1064	java/lang/Exception
    //   802	813	1064	java/lang/Exception
    //   825	843	1064	java/lang/Exception
    //   855	868	1064	java/lang/Exception
    //   880	885	1064	java/lang/Exception
    //   897	902	1064	java/lang/Exception
    //   914	922	1064	java/lang/Exception
    //   934	940	1064	java/lang/Exception
    //   952	960	1064	java/lang/Exception
    //   972	996	1064	java/lang/Exception
    //   1049	1061	1064	java/lang/Exception
    //   1154	1167	1064	java/lang/Exception
    //   1179	1190	1064	java/lang/Exception
    //   1209	1229	1064	java/lang/Exception
    //   1241	1250	1064	java/lang/Exception
    //   1277	1284	1064	java/lang/Exception
    //   1296	1303	1064	java/lang/Exception
    //   1315	1321	1064	java/lang/Exception
    //   1333	1337	1064	java/lang/Exception
    //   1349	1366	1064	java/lang/Exception
    //   1455	1460	1064	java/lang/Exception
    //   1475	1483	1064	java/lang/Exception
    //   1511	1547	1064	java/lang/Exception
    //   1559	1567	1064	java/lang/Exception
    //   1600	1607	1064	java/lang/Exception
    //   1619	1626	1064	java/lang/Exception
    //   1638	1644	1064	java/lang/Exception
    //   1656	1674	1064	java/lang/Exception
    //   1743	1752	1064	java/lang/Exception
    //   1767	1796	1064	java/lang/Exception
    //   191	199	1369	java/lang/OutOfMemoryError
    //   211	222	1369	java/lang/OutOfMemoryError
    //   234	243	1369	java/lang/OutOfMemoryError
    //   255	296	1369	java/lang/OutOfMemoryError
    //   308	313	1369	java/lang/OutOfMemoryError
    //   334	343	1369	java/lang/OutOfMemoryError
    //   355	361	1369	java/lang/OutOfMemoryError
    //   373	385	1369	java/lang/OutOfMemoryError
    //   397	403	1369	java/lang/OutOfMemoryError
    //   415	462	1369	java/lang/OutOfMemoryError
    //   474	486	1369	java/lang/OutOfMemoryError
    //   498	521	1369	java/lang/OutOfMemoryError
    //   533	540	1369	java/lang/OutOfMemoryError
    //   552	559	1369	java/lang/OutOfMemoryError
    //   571	577	1369	java/lang/OutOfMemoryError
    //   594	608	1369	java/lang/OutOfMemoryError
    //   635	671	1369	java/lang/OutOfMemoryError
    //   683	696	1369	java/lang/OutOfMemoryError
    //   717	728	1369	java/lang/OutOfMemoryError
    //   740	748	1369	java/lang/OutOfMemoryError
    //   760	765	1369	java/lang/OutOfMemoryError
    //   777	790	1369	java/lang/OutOfMemoryError
    //   802	813	1369	java/lang/OutOfMemoryError
    //   825	843	1369	java/lang/OutOfMemoryError
    //   855	868	1369	java/lang/OutOfMemoryError
    //   880	885	1369	java/lang/OutOfMemoryError
    //   897	902	1369	java/lang/OutOfMemoryError
    //   914	922	1369	java/lang/OutOfMemoryError
    //   934	940	1369	java/lang/OutOfMemoryError
    //   952	960	1369	java/lang/OutOfMemoryError
    //   972	996	1369	java/lang/OutOfMemoryError
    //   1049	1061	1369	java/lang/OutOfMemoryError
    //   1154	1167	1369	java/lang/OutOfMemoryError
    //   1179	1190	1369	java/lang/OutOfMemoryError
    //   1209	1229	1369	java/lang/OutOfMemoryError
    //   1241	1250	1369	java/lang/OutOfMemoryError
    //   1277	1284	1369	java/lang/OutOfMemoryError
    //   1296	1303	1369	java/lang/OutOfMemoryError
    //   1315	1321	1369	java/lang/OutOfMemoryError
    //   1333	1337	1369	java/lang/OutOfMemoryError
    //   1349	1366	1369	java/lang/OutOfMemoryError
    //   1455	1460	1369	java/lang/OutOfMemoryError
    //   1475	1483	1369	java/lang/OutOfMemoryError
    //   1511	1547	1369	java/lang/OutOfMemoryError
    //   1559	1567	1369	java/lang/OutOfMemoryError
    //   1600	1607	1369	java/lang/OutOfMemoryError
    //   1619	1626	1369	java/lang/OutOfMemoryError
    //   1638	1644	1369	java/lang/OutOfMemoryError
    //   1656	1674	1369	java/lang/OutOfMemoryError
    //   1743	1752	1369	java/lang/OutOfMemoryError
    //   1767	1796	1369	java/lang/OutOfMemoryError
    //   191	199	1677	finally
    //   211	222	1677	finally
    //   234	243	1677	finally
    //   255	296	1677	finally
    //   308	313	1677	finally
    //   334	343	1677	finally
    //   355	361	1677	finally
    //   373	385	1677	finally
    //   397	403	1677	finally
    //   415	462	1677	finally
    //   474	486	1677	finally
    //   498	521	1677	finally
    //   533	540	1677	finally
    //   552	559	1677	finally
    //   571	577	1677	finally
    //   594	608	1677	finally
    //   635	671	1677	finally
    //   683	696	1677	finally
    //   717	728	1677	finally
    //   740	748	1677	finally
    //   760	765	1677	finally
    //   777	790	1677	finally
    //   802	813	1677	finally
    //   825	843	1677	finally
    //   855	868	1677	finally
    //   880	885	1677	finally
    //   897	902	1677	finally
    //   914	922	1677	finally
    //   934	940	1677	finally
    //   952	960	1677	finally
    //   972	996	1677	finally
    //   1049	1061	1677	finally
    //   1154	1167	1677	finally
    //   1179	1190	1677	finally
    //   1209	1229	1677	finally
    //   1241	1250	1677	finally
    //   1277	1284	1677	finally
    //   1296	1303	1677	finally
    //   1315	1321	1677	finally
    //   1333	1337	1677	finally
    //   1349	1366	1677	finally
    //   1383	1389	1677	finally
    //   1397	1406	1677	finally
    //   1455	1460	1677	finally
    //   1475	1483	1677	finally
    //   1511	1547	1677	finally
    //   1559	1567	1677	finally
    //   1600	1607	1677	finally
    //   1619	1626	1677	finally
    //   1638	1644	1677	finally
    //   1656	1674	1677	finally
    //   1743	1752	1677	finally
    //   1767	1796	1677	finally
    //   118	125	1799	finally
    //   134	154	1810	finally
    //   1069	1105	1818	finally
    //   118	125	1831	java/lang/OutOfMemoryError
    //   134	154	1842	java/lang/OutOfMemoryError
    //   118	125	1850	java/lang/Exception
    //   134	154	1855	java/lang/Exception
    //   191	199	1860	java/lang/Exception
    //   211	222	1860	java/lang/Exception
    //   234	243	1860	java/lang/Exception
    //   255	296	1860	java/lang/Exception
    //   308	313	1860	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abma
 * JD-Core Version:    0.7.0.1
 */