import android.content.Intent;
import com.tencent.device.file.DevShortVideoOperator.1;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class aasg
  extends BaseShortVideoOprerator
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  public aasg() {}
  
  public aasg(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(bbrp parambbrp)
  {
    ThreadManager.getSubThreadHandler().post(new DevShortVideoOperator.1(this, parambbrp));
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: aload_0
    //   14: getfield 47	aasg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 53	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +55 -> 77
    //   25: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 61
    //   33: iconst_2
    //   34: ldc 63
    //   36: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: iconst_0
    //   40: ifeq +11 -> 51
    //   43: new 68	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: iconst_0
    //   52: ifeq +11 -> 63
    //   55: new 68	java/lang/NullPointerException
    //   58: dup
    //   59: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   62: athrow
    //   63: iconst_0
    //   64: ifeq +11 -> 75
    //   67: new 68	java/lang/NullPointerException
    //   70: dup
    //   71: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   74: athrow
    //   75: iconst_m1
    //   76: ireturn
    //   77: aload_2
    //   78: invokestatic 73	com/tencent/mobileqq/shortvideo/ShortVideoUtils:resizeThumb	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   81: astore 10
    //   83: aload 10
    //   85: ifnonnull +56 -> 141
    //   88: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +11 -> 102
    //   94: ldc 61
    //   96: iconst_2
    //   97: ldc 75
    //   99: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: iconst_0
    //   103: ifeq +11 -> 114
    //   106: new 68	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   113: athrow
    //   114: iconst_0
    //   115: ifeq +11 -> 126
    //   118: new 68	java/lang/NullPointerException
    //   121: dup
    //   122: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   125: athrow
    //   126: iconst_0
    //   127: ifeq -52 -> 75
    //   130: new 68	java/lang/NullPointerException
    //   133: dup
    //   134: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   137: athrow
    //   138: astore_2
    //   139: iconst_m1
    //   140: ireturn
    //   141: aload_0
    //   142: aload 10
    //   144: invokevirtual 80	android/graphics/Bitmap:getWidth	()I
    //   147: putfield 82	aasg:jdField_b_of_type_Int	I
    //   150: aload_0
    //   151: aload 10
    //   153: invokevirtual 85	android/graphics/Bitmap:getHeight	()I
    //   156: putfield 87	aasg:jdField_c_of_type_Int	I
    //   159: new 89	java/io/File
    //   162: dup
    //   163: aload_0
    //   164: getfield 47	aasg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   167: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore_2
    //   171: aload_0
    //   172: aload_2
    //   173: invokevirtual 96	java/io/File:length	()J
    //   176: putfield 98	aasg:jdField_a_of_type_Long	J
    //   179: new 100	java/io/FileInputStream
    //   182: dup
    //   183: aload_2
    //   184: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   187: astore_3
    //   188: aload_0
    //   189: aload_3
    //   190: aload_0
    //   191: getfield 98	aasg:jdField_a_of_type_Long	J
    //   194: invokestatic 109	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   197: invokestatic 115	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   200: putfield 117	aasg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   203: aload_0
    //   204: getfield 117	aasg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   207: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   210: ifeq +72 -> 282
    //   213: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +31 -> 247
    //   219: ldc 61
    //   221: iconst_2
    //   222: new 125	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   229: ldc 128
    //   231: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_0
    //   235: getfield 117	aasg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   238: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 139	java/io/FileInputStream:close	()V
    //   255: iconst_0
    //   256: ifeq +11 -> 267
    //   259: new 68	java/lang/NullPointerException
    //   262: dup
    //   263: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   266: athrow
    //   267: iconst_0
    //   268: ifeq -193 -> 75
    //   271: new 68	java/lang/NullPointerException
    //   274: dup
    //   275: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   278: athrow
    //   279: astore_2
    //   280: iconst_m1
    //   281: ireturn
    //   282: aload_0
    //   283: getfield 117	aasg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   286: ldc 141
    //   288: invokestatic 145	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 9
    //   293: new 125	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   300: invokestatic 148	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicDir	()Ljava/lang/String;
    //   303: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 150
    //   308: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 155	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   317: new 89	java/io/File
    //   320: dup
    //   321: aload 9
    //   323: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   326: astore 8
    //   328: new 89	java/io/File
    //   331: dup
    //   332: aload 8
    //   334: invokevirtual 158	java/io/File:getParent	()Ljava/lang/String;
    //   337: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   340: astore_2
    //   341: aload_2
    //   342: invokevirtual 161	java/io/File:exists	()Z
    //   345: ifeq +10 -> 355
    //   348: aload_2
    //   349: invokevirtual 164	java/io/File:isDirectory	()Z
    //   352: ifne +8 -> 360
    //   355: aload_2
    //   356: invokevirtual 167	java/io/File:mkdirs	()Z
    //   359: pop
    //   360: aload 8
    //   362: invokevirtual 161	java/io/File:exists	()Z
    //   365: ifeq +11 -> 376
    //   368: aload 8
    //   370: invokevirtual 170	java/io/File:isFile	()Z
    //   373: ifne +9 -> 382
    //   376: aload 8
    //   378: invokevirtual 173	java/io/File:createNewFile	()Z
    //   381: pop
    //   382: new 175	java/io/FileOutputStream
    //   385: dup
    //   386: aload 8
    //   388: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   391: astore_2
    //   392: aload 10
    //   394: getstatic 182	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   397: bipush 50
    //   399: aload_2
    //   400: invokevirtual 186	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   403: pop
    //   404: aload_2
    //   405: invokevirtual 189	java/io/FileOutputStream:flush	()V
    //   408: new 100	java/io/FileInputStream
    //   411: dup
    //   412: aload 8
    //   414: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   417: astore 4
    //   419: aload_0
    //   420: aload 4
    //   422: aload 8
    //   424: invokevirtual 96	java/io/File:length	()J
    //   427: invokestatic 109	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   430: invokestatic 115	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   433: putfield 191	aasg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   436: aload_0
    //   437: getfield 191	aasg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   440: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   443: ifeq +68 -> 511
    //   446: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +31 -> 480
    //   452: ldc 61
    //   454: iconst_2
    //   455: new 125	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   462: ldc 193
    //   464: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_0
    //   468: getfield 191	aasg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   471: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload_3
    //   481: ifnull +7 -> 488
    //   484: aload_3
    //   485: invokevirtual 139	java/io/FileInputStream:close	()V
    //   488: aload_2
    //   489: ifnull +7 -> 496
    //   492: aload_2
    //   493: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   496: aload 4
    //   498: ifnull -423 -> 75
    //   501: aload 4
    //   503: invokevirtual 139	java/io/FileInputStream:close	()V
    //   506: iconst_m1
    //   507: ireturn
    //   508: astore_2
    //   509: iconst_m1
    //   510: ireturn
    //   511: aload_0
    //   512: aload_0
    //   513: getfield 191	aasg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   516: ldc 141
    //   518: invokestatic 145	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   521: putfield 196	aasg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   524: aload 9
    //   526: aload_0
    //   527: getfield 196	aasg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   530: invokestatic 200	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   533: istore_1
    //   534: iload_1
    //   535: ifne +34 -> 569
    //   538: aload_3
    //   539: ifnull +7 -> 546
    //   542: aload_3
    //   543: invokevirtual 139	java/io/FileInputStream:close	()V
    //   546: aload_2
    //   547: ifnull +7 -> 554
    //   550: aload_2
    //   551: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   554: aload 4
    //   556: ifnull -481 -> 75
    //   559: aload 4
    //   561: invokevirtual 139	java/io/FileInputStream:close	()V
    //   564: iconst_m1
    //   565: ireturn
    //   566: astore_2
    //   567: iconst_m1
    //   568: ireturn
    //   569: aload_0
    //   570: getfield 202	aasg:jdField_b_of_type_Long	J
    //   573: lconst_0
    //   574: lcmp
    //   575: ifne +14 -> 589
    //   578: aload_0
    //   579: aload_0
    //   580: getfield 47	aasg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   583: invokestatic 206	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   586: putfield 202	aasg:jdField_b_of_type_Long	J
    //   589: aload_3
    //   590: ifnull +7 -> 597
    //   593: aload_3
    //   594: invokevirtual 139	java/io/FileInputStream:close	()V
    //   597: aload_2
    //   598: ifnull +7 -> 605
    //   601: aload_2
    //   602: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   605: aload 4
    //   607: ifnull +8 -> 615
    //   610: aload 4
    //   612: invokevirtual 139	java/io/FileInputStream:close	()V
    //   615: iconst_0
    //   616: ireturn
    //   617: astore 4
    //   619: aconst_null
    //   620: astore_2
    //   621: aconst_null
    //   622: astore_3
    //   623: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +13 -> 639
    //   629: ldc 61
    //   631: iconst_2
    //   632: ldc 208
    //   634: aload 4
    //   636: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   639: aload_3
    //   640: ifnull +7 -> 647
    //   643: aload_3
    //   644: invokevirtual 139	java/io/FileInputStream:close	()V
    //   647: aload 5
    //   649: ifnull +8 -> 657
    //   652: aload 5
    //   654: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   657: aload_2
    //   658: ifnull -583 -> 75
    //   661: aload_2
    //   662: invokevirtual 139	java/io/FileInputStream:close	()V
    //   665: iconst_m1
    //   666: ireturn
    //   667: astore_2
    //   668: iconst_m1
    //   669: ireturn
    //   670: astore 5
    //   672: aconst_null
    //   673: astore_2
    //   674: aconst_null
    //   675: astore 8
    //   677: aload 4
    //   679: astore 6
    //   681: aload 6
    //   683: astore 7
    //   685: aload_2
    //   686: astore 4
    //   688: aload 8
    //   690: astore_3
    //   691: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   694: ifeq +23 -> 717
    //   697: aload 6
    //   699: astore 7
    //   701: aload_2
    //   702: astore 4
    //   704: aload 8
    //   706: astore_3
    //   707: ldc 61
    //   709: iconst_2
    //   710: ldc 208
    //   712: aload 5
    //   714: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   717: aload 8
    //   719: ifnull +8 -> 727
    //   722: aload 8
    //   724: invokevirtual 139	java/io/FileInputStream:close	()V
    //   727: aload 6
    //   729: ifnull +8 -> 737
    //   732: aload 6
    //   734: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   737: aload_2
    //   738: ifnull -663 -> 75
    //   741: aload_2
    //   742: invokevirtual 139	java/io/FileInputStream:close	()V
    //   745: iconst_m1
    //   746: ireturn
    //   747: astore_2
    //   748: iconst_m1
    //   749: ireturn
    //   750: astore 5
    //   752: aconst_null
    //   753: astore_2
    //   754: aconst_null
    //   755: astore 8
    //   757: aload 7
    //   759: astore 6
    //   761: aload 6
    //   763: astore 7
    //   765: aload_2
    //   766: astore 4
    //   768: aload 8
    //   770: astore_3
    //   771: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   774: ifeq +23 -> 797
    //   777: aload 6
    //   779: astore 7
    //   781: aload_2
    //   782: astore 4
    //   784: aload 8
    //   786: astore_3
    //   787: ldc 61
    //   789: iconst_2
    //   790: ldc 213
    //   792: aload 5
    //   794: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   797: aload 8
    //   799: ifnull +8 -> 807
    //   802: aload 8
    //   804: invokevirtual 139	java/io/FileInputStream:close	()V
    //   807: aload 6
    //   809: ifnull +8 -> 817
    //   812: aload 6
    //   814: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   817: aload_2
    //   818: ifnull -743 -> 75
    //   821: aload_2
    //   822: invokevirtual 139	java/io/FileInputStream:close	()V
    //   825: iconst_m1
    //   826: ireturn
    //   827: astore_2
    //   828: iconst_m1
    //   829: ireturn
    //   830: astore_2
    //   831: aconst_null
    //   832: astore 4
    //   834: aconst_null
    //   835: astore_3
    //   836: aload 6
    //   838: astore 5
    //   840: aload_3
    //   841: ifnull +7 -> 848
    //   844: aload_3
    //   845: invokevirtual 139	java/io/FileInputStream:close	()V
    //   848: aload 5
    //   850: ifnull +8 -> 858
    //   853: aload 5
    //   855: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   858: aload 4
    //   860: ifnull +8 -> 868
    //   863: aload 4
    //   865: invokevirtual 139	java/io/FileInputStream:close	()V
    //   868: aload_2
    //   869: athrow
    //   870: astore_2
    //   871: goto -820 -> 51
    //   874: astore_2
    //   875: goto -812 -> 63
    //   878: astore_2
    //   879: iconst_m1
    //   880: ireturn
    //   881: astore_2
    //   882: goto -768 -> 114
    //   885: astore_2
    //   886: goto -760 -> 126
    //   889: astore_2
    //   890: goto -635 -> 255
    //   893: astore_2
    //   894: goto -627 -> 267
    //   897: astore_3
    //   898: goto -410 -> 488
    //   901: astore_2
    //   902: goto -406 -> 496
    //   905: astore_3
    //   906: goto -360 -> 546
    //   909: astore_2
    //   910: goto -356 -> 554
    //   913: astore_3
    //   914: goto -317 -> 597
    //   917: astore_2
    //   918: goto -313 -> 605
    //   921: astore_2
    //   922: goto -307 -> 615
    //   925: astore_3
    //   926: goto -279 -> 647
    //   929: astore_3
    //   930: goto -273 -> 657
    //   933: astore_3
    //   934: goto -207 -> 727
    //   937: astore_3
    //   938: goto -201 -> 737
    //   941: astore_3
    //   942: goto -135 -> 807
    //   945: astore_3
    //   946: goto -129 -> 817
    //   949: astore_3
    //   950: goto -102 -> 848
    //   953: astore_3
    //   954: goto -96 -> 858
    //   957: astore_3
    //   958: goto -90 -> 868
    //   961: astore_2
    //   962: aconst_null
    //   963: astore 4
    //   965: aload 6
    //   967: astore 5
    //   969: goto -129 -> 840
    //   972: astore 6
    //   974: aconst_null
    //   975: astore 4
    //   977: aload_2
    //   978: astore 5
    //   980: aload 6
    //   982: astore_2
    //   983: goto -143 -> 840
    //   986: astore 6
    //   988: aload_2
    //   989: astore 5
    //   991: aload 6
    //   993: astore_2
    //   994: goto -154 -> 840
    //   997: astore 6
    //   999: aload_2
    //   1000: astore 4
    //   1002: aload 6
    //   1004: astore_2
    //   1005: goto -165 -> 840
    //   1008: astore_2
    //   1009: aload 7
    //   1011: astore 5
    //   1013: goto -173 -> 840
    //   1016: astore 5
    //   1018: aconst_null
    //   1019: astore_2
    //   1020: aload 7
    //   1022: astore 6
    //   1024: aload_3
    //   1025: astore 8
    //   1027: goto -266 -> 761
    //   1030: astore 5
    //   1032: aconst_null
    //   1033: astore 4
    //   1035: aload_2
    //   1036: astore 6
    //   1038: aload 4
    //   1040: astore_2
    //   1041: aload_3
    //   1042: astore 8
    //   1044: goto -283 -> 761
    //   1047: astore 5
    //   1049: aload_2
    //   1050: astore 6
    //   1052: aload 4
    //   1054: astore_2
    //   1055: aload_3
    //   1056: astore 8
    //   1058: goto -297 -> 761
    //   1061: astore 5
    //   1063: aconst_null
    //   1064: astore_2
    //   1065: aload 4
    //   1067: astore 6
    //   1069: aload_3
    //   1070: astore 8
    //   1072: goto -391 -> 681
    //   1075: astore 5
    //   1077: aconst_null
    //   1078: astore 4
    //   1080: aload_2
    //   1081: astore 6
    //   1083: aload 4
    //   1085: astore_2
    //   1086: aload_3
    //   1087: astore 8
    //   1089: goto -408 -> 681
    //   1092: astore 5
    //   1094: aload_2
    //   1095: astore 6
    //   1097: aload 4
    //   1099: astore_2
    //   1100: aload_3
    //   1101: astore 8
    //   1103: goto -422 -> 681
    //   1106: astore 4
    //   1108: aconst_null
    //   1109: astore_2
    //   1110: goto -487 -> 623
    //   1113: astore 4
    //   1115: aconst_null
    //   1116: astore 6
    //   1118: aload_2
    //   1119: astore 5
    //   1121: aload 6
    //   1123: astore_2
    //   1124: goto -501 -> 623
    //   1127: astore 5
    //   1129: aload 4
    //   1131: astore 6
    //   1133: aload 5
    //   1135: astore 4
    //   1137: aload_2
    //   1138: astore 5
    //   1140: aload 6
    //   1142: astore_2
    //   1143: goto -520 -> 623
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1146	0	this	aasg
    //   533	2	1	bool	boolean
    //   20	58	2	localBitmap1	android.graphics.Bitmap
    //   138	1	2	localIOException1	java.io.IOException
    //   170	14	2	localFile	java.io.File
    //   279	1	2	localIOException2	java.io.IOException
    //   340	153	2	localObject1	Object
    //   508	43	2	localIOException3	java.io.IOException
    //   566	36	2	localIOException4	java.io.IOException
    //   620	42	2	localObject2	Object
    //   667	1	2	localIOException5	java.io.IOException
    //   673	69	2	localObject3	Object
    //   747	1	2	localIOException6	java.io.IOException
    //   753	69	2	localObject4	Object
    //   827	1	2	localIOException7	java.io.IOException
    //   830	39	2	localObject5	Object
    //   870	1	2	localIOException8	java.io.IOException
    //   874	1	2	localIOException9	java.io.IOException
    //   878	1	2	localIOException10	java.io.IOException
    //   881	1	2	localIOException11	java.io.IOException
    //   885	1	2	localIOException12	java.io.IOException
    //   889	1	2	localIOException13	java.io.IOException
    //   893	1	2	localIOException14	java.io.IOException
    //   901	1	2	localIOException15	java.io.IOException
    //   909	1	2	localIOException16	java.io.IOException
    //   917	1	2	localIOException17	java.io.IOException
    //   921	1	2	localIOException18	java.io.IOException
    //   961	17	2	localObject6	Object
    //   982	23	2	localObject7	Object
    //   1008	1	2	localObject8	Object
    //   1019	124	2	localObject9	Object
    //   187	658	3	localObject10	Object
    //   897	1	3	localIOException19	java.io.IOException
    //   905	1	3	localIOException20	java.io.IOException
    //   913	1	3	localIOException21	java.io.IOException
    //   925	1	3	localIOException22	java.io.IOException
    //   929	1	3	localIOException23	java.io.IOException
    //   933	1	3	localIOException24	java.io.IOException
    //   937	1	3	localIOException25	java.io.IOException
    //   941	1	3	localIOException26	java.io.IOException
    //   945	1	3	localIOException27	java.io.IOException
    //   949	1	3	localIOException28	java.io.IOException
    //   953	1	3	localIOException29	java.io.IOException
    //   957	144	3	localIOException30	java.io.IOException
    //   1	610	4	localFileInputStream	java.io.FileInputStream
    //   617	61	4	localIOException31	java.io.IOException
    //   686	412	4	localObject11	Object
    //   1106	1	4	localIOException32	java.io.IOException
    //   1113	17	4	localIOException33	java.io.IOException
    //   1135	1	4	localObject12	Object
    //   10	643	5	localObject13	Object
    //   670	43	5	localException1	java.lang.Exception
    //   750	43	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   838	174	5	localObject14	Object
    //   1016	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1030	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1047	1	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1061	1	5	localException2	java.lang.Exception
    //   1075	1	5	localException3	java.lang.Exception
    //   1092	1	5	localException4	java.lang.Exception
    //   1119	1	5	localObject15	Object
    //   1127	7	5	localIOException34	java.io.IOException
    //   1138	1	5	localObject16	Object
    //   7	959	6	localObject17	Object
    //   972	9	6	localObject18	Object
    //   986	6	6	localObject19	Object
    //   997	6	6	localObject20	Object
    //   1022	119	6	localObject21	Object
    //   4	1017	7	localObject22	Object
    //   326	776	8	localObject23	Object
    //   291	234	9	str	String
    //   81	312	10	localBitmap2	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   130	138	138	java/io/IOException
    //   271	279	279	java/io/IOException
    //   501	506	508	java/io/IOException
    //   559	564	566	java/io/IOException
    //   12	21	617	java/io/IOException
    //   25	39	617	java/io/IOException
    //   77	83	617	java/io/IOException
    //   88	102	617	java/io/IOException
    //   141	188	617	java/io/IOException
    //   661	665	667	java/io/IOException
    //   12	21	670	java/lang/Exception
    //   25	39	670	java/lang/Exception
    //   77	83	670	java/lang/Exception
    //   88	102	670	java/lang/Exception
    //   141	188	670	java/lang/Exception
    //   741	745	747	java/io/IOException
    //   12	21	750	java/lang/OutOfMemoryError
    //   25	39	750	java/lang/OutOfMemoryError
    //   77	83	750	java/lang/OutOfMemoryError
    //   88	102	750	java/lang/OutOfMemoryError
    //   141	188	750	java/lang/OutOfMemoryError
    //   821	825	827	java/io/IOException
    //   12	21	830	finally
    //   25	39	830	finally
    //   77	83	830	finally
    //   88	102	830	finally
    //   141	188	830	finally
    //   43	51	870	java/io/IOException
    //   55	63	874	java/io/IOException
    //   67	75	878	java/io/IOException
    //   106	114	881	java/io/IOException
    //   118	126	885	java/io/IOException
    //   251	255	889	java/io/IOException
    //   259	267	893	java/io/IOException
    //   484	488	897	java/io/IOException
    //   492	496	901	java/io/IOException
    //   542	546	905	java/io/IOException
    //   550	554	909	java/io/IOException
    //   593	597	913	java/io/IOException
    //   601	605	917	java/io/IOException
    //   610	615	921	java/io/IOException
    //   643	647	925	java/io/IOException
    //   652	657	929	java/io/IOException
    //   722	727	933	java/io/IOException
    //   732	737	937	java/io/IOException
    //   802	807	941	java/io/IOException
    //   812	817	945	java/io/IOException
    //   844	848	949	java/io/IOException
    //   853	858	953	java/io/IOException
    //   863	868	957	java/io/IOException
    //   188	247	961	finally
    //   282	355	961	finally
    //   355	360	961	finally
    //   360	376	961	finally
    //   376	382	961	finally
    //   382	392	961	finally
    //   392	419	972	finally
    //   419	480	986	finally
    //   511	534	986	finally
    //   569	589	986	finally
    //   623	639	997	finally
    //   691	697	1008	finally
    //   707	717	1008	finally
    //   771	777	1008	finally
    //   787	797	1008	finally
    //   188	247	1016	java/lang/OutOfMemoryError
    //   282	355	1016	java/lang/OutOfMemoryError
    //   355	360	1016	java/lang/OutOfMemoryError
    //   360	376	1016	java/lang/OutOfMemoryError
    //   376	382	1016	java/lang/OutOfMemoryError
    //   382	392	1016	java/lang/OutOfMemoryError
    //   392	419	1030	java/lang/OutOfMemoryError
    //   419	480	1047	java/lang/OutOfMemoryError
    //   511	534	1047	java/lang/OutOfMemoryError
    //   569	589	1047	java/lang/OutOfMemoryError
    //   188	247	1061	java/lang/Exception
    //   282	355	1061	java/lang/Exception
    //   355	360	1061	java/lang/Exception
    //   360	376	1061	java/lang/Exception
    //   376	382	1061	java/lang/Exception
    //   382	392	1061	java/lang/Exception
    //   392	419	1075	java/lang/Exception
    //   419	480	1092	java/lang/Exception
    //   511	534	1092	java/lang/Exception
    //   569	589	1092	java/lang/Exception
    //   188	247	1106	java/io/IOException
    //   282	355	1106	java/io/IOException
    //   355	360	1106	java/io/IOException
    //   360	376	1106	java/io/IOException
    //   376	382	1106	java/io/IOException
    //   382	392	1106	java/io/IOException
    //   392	419	1113	java/io/IOException
    //   419	480	1127	java/io/IOException
    //   511	534	1127	java/io/IOException
    //   569	589	1127	java/io/IOException
  }
  
  public bbqj a(Object paramObject, bbqx parambbqx)
  {
    return null;
  }
  
  public bbrp a(Object paramObject, bbqx parambbqx)
  {
    if (paramObject == null)
    {
      ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    Object localObject;
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
      this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uintype", 1003);
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("file_send_path");
    }
    for (;;)
    {
      a();
      localObject = new bbrp();
      ((bbrp)localObject).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((bbrp)localObject).h = this.jdField_a_of_type_JavaLangString;
      ((bbrp)localObject).j = this.jdField_d_of_type_JavaLangString;
      ((bbrp)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ((bbrp)localObject).jdField_d_of_type_JavaLangString = "";
      ((bbrp)localObject).jdField_e_of_type_Int = ((int)this.jdField_a_of_type_Long);
      ((bbrp)localObject).f = ((int)this.jdField_b_of_type_Long / 1000);
      ((bbrp)localObject).jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      ((bbrp)localObject).jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      ((bbrp)localObject).jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      ((bbrp)localObject).jdField_g_of_type_Int = parambbqx.jdField_a_of_type_Int;
      ((bbrp)localObject).jdField_a_of_type_JavaLangObject = paramObject;
      ((bbrp)localObject).jdField_g_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      ((bbrp)localObject).l = "";
      ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localObject;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        this.jdField_b_of_type_JavaLangString = ((MessageForShortVideo)localObject).frienduin;
        this.jdField_a_of_type_Int = ((MessageForShortVideo)localObject).istroop;
        this.jdField_a_of_type_Long = ((MessageForShortVideo)localObject).videoFileSize;
        this.jdField_b_of_type_Long = (((MessageForShortVideo)localObject).videoFileTime * 1000);
        this.jdField_a_of_type_JavaLangString = ((MessageForShortVideo)localObject).videoFileName;
        this.jdField_d_of_type_JavaLangString = ShortVideoUtils.getShortVideoThumbPicPath(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        this.jdField_c_of_type_JavaLangString = ((MessageForShortVideo)localObject).md5;
        this.jdField_b_of_type_Int = ((MessageForShortVideo)localObject).thumbWidth;
        this.jdField_c_of_type_Int = ((MessageForShortVideo)localObject).thumbHeight;
        this.jdField_e_of_type_JavaLangString = ((MessageForShortVideo)localObject).thumbMD5;
      }
    }
  }
  
  public MessageRecord a(bbqj parambbqj)
  {
    return null;
  }
  
  public MessageRecord a(bbrp parambbrp)
  {
    int i = 0;
    long l = System.currentTimeMillis();
    MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)bbli.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambbrp.jdField_c_of_type_JavaLangString, parambbrp.jdField_d_of_type_JavaLangString, parambbrp.jdField_b_of_type_Int);
    localMessageForDevShortVideo.videoFileName = parambbrp.h;
    if (parambbrp.jdField_a_of_type_JavaLangString == null) {
      parambbrp.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevShortVideo.uuid = parambbrp.jdField_a_of_type_JavaLangString;
    if (parambbrp.jdField_e_of_type_JavaLangString == null) {
      parambbrp.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevShortVideo.md5 = parambbrp.jdField_e_of_type_JavaLangString;
    localMessageForDevShortVideo.videoFileFormat = 2;
    localMessageForDevShortVideo.videoFileSize = parambbrp.jdField_e_of_type_Int;
    localMessageForDevShortVideo.videoFileTime = parambbrp.f;
    localMessageForDevShortVideo.thumbWidth = parambbrp.jdField_c_of_type_Int;
    localMessageForDevShortVideo.thumbHeight = parambbrp.jdField_d_of_type_Int;
    localMessageForDevShortVideo.videoFileStatus = 1002;
    localMessageForDevShortVideo.videoFileProgress = 0;
    localMessageForDevShortVideo.fileType = 19;
    localMessageForDevShortVideo.thumbMD5 = parambbrp.jdField_g_of_type_JavaLangString;
    localMessageForDevShortVideo.extraflag = 32772;
    if (parambbrp.l == null) {
      parambbrp.l = "";
    }
    localMessageForDevShortVideo.fileSource = parambbrp.l;
    localMessageForDevShortVideo.lastModified = 0L;
    if (parambbrp.jdField_a_of_type_Bbrq != null) {
      i = 1;
    }
    if (i != 0)
    {
      localMessageForDevShortVideo.msgseq = parambbrp.jdField_a_of_type_Bbrq.jdField_a_of_type_Long;
      localMessageForDevShortVideo.shmsgseq = parambbrp.jdField_a_of_type_Bbrq.jdField_b_of_type_Long;
      localMessageForDevShortVideo.msgUid = parambbrp.jdField_a_of_type_Bbrq.c;
    }
    localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
    localMessageForDevShortVideo.serial();
    parambbrp.jdField_a_of_type_Long = localMessageForDevShortVideo.uniseq;
    ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevShortVideo.toLogString() + "-" + localMessageForDevShortVideo.toString());
    return localMessageForDevShortVideo;
  }
  
  public void a(bbrp parambbrp)
  {
    ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    b(parambbrp);
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void updateMsg(ayep paramayep)
  {
    ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "updateMsg", "resut:" + paramayep);
    if (paramayep != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramayep.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramayep.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramayep.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasg
 * JD-Core Version:    0.7.0.1
 */