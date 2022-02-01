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

public class abvx
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
  
  public abvx() {}
  
  public abvx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(bcyf parambcyf)
  {
    ThreadManager.getSubThreadHandler().post(new DevShortVideoOperator.1(this, parambcyf));
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: aload_0
    //   14: getfield 47	abvx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 52	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +55 -> 77
    //   25: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 60
    //   33: iconst_2
    //   34: ldc 62
    //   36: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: iconst_0
    //   40: ifeq +11 -> 51
    //   43: new 67	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: iconst_0
    //   52: ifeq +11 -> 63
    //   55: new 67	java/lang/NullPointerException
    //   58: dup
    //   59: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   62: athrow
    //   63: iconst_0
    //   64: ifeq +11 -> 75
    //   67: new 67	java/lang/NullPointerException
    //   70: dup
    //   71: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   74: athrow
    //   75: iconst_m1
    //   76: ireturn
    //   77: aload_2
    //   78: invokestatic 71	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   81: astore 8
    //   83: aload 8
    //   85: ifnonnull +56 -> 141
    //   88: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +11 -> 102
    //   94: ldc 60
    //   96: iconst_2
    //   97: ldc 73
    //   99: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: iconst_0
    //   103: ifeq +11 -> 114
    //   106: new 67	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   113: athrow
    //   114: iconst_0
    //   115: ifeq +11 -> 126
    //   118: new 67	java/lang/NullPointerException
    //   121: dup
    //   122: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   125: athrow
    //   126: iconst_0
    //   127: ifeq -52 -> 75
    //   130: new 67	java/lang/NullPointerException
    //   133: dup
    //   134: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   137: athrow
    //   138: astore_2
    //   139: iconst_m1
    //   140: ireturn
    //   141: aload_0
    //   142: aload 8
    //   144: invokevirtual 78	android/graphics/Bitmap:getWidth	()I
    //   147: putfield 80	abvx:jdField_b_of_type_Int	I
    //   150: aload_0
    //   151: aload 8
    //   153: invokevirtual 83	android/graphics/Bitmap:getHeight	()I
    //   156: putfield 85	abvx:jdField_c_of_type_Int	I
    //   159: new 87	java/io/File
    //   162: dup
    //   163: aload_0
    //   164: getfield 47	abvx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   167: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore_2
    //   171: aload_0
    //   172: aload_2
    //   173: invokevirtual 94	java/io/File:length	()J
    //   176: putfield 96	abvx:jdField_a_of_type_Long	J
    //   179: new 98	java/io/FileInputStream
    //   182: dup
    //   183: aload_2
    //   184: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   187: astore_3
    //   188: aload_0
    //   189: aload_3
    //   190: aload_0
    //   191: getfield 96	abvx:jdField_a_of_type_Long	J
    //   194: invokestatic 107	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   197: invokestatic 113	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   200: putfield 115	abvx:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   203: aload_0
    //   204: getfield 115	abvx:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   207: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   210: ifeq +72 -> 282
    //   213: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +31 -> 247
    //   219: ldc 60
    //   221: iconst_2
    //   222: new 123	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   229: ldc 126
    //   231: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_0
    //   235: getfield 115	abvx:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   238: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 137	java/io/FileInputStream:close	()V
    //   255: iconst_0
    //   256: ifeq +11 -> 267
    //   259: new 67	java/lang/NullPointerException
    //   262: dup
    //   263: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   266: athrow
    //   267: iconst_0
    //   268: ifeq -193 -> 75
    //   271: new 67	java/lang/NullPointerException
    //   274: dup
    //   275: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   278: athrow
    //   279: astore_2
    //   280: iconst_m1
    //   281: ireturn
    //   282: aload_0
    //   283: getfield 115	abvx:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   286: ldc 139
    //   288: invokestatic 142	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 10
    //   293: new 123	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   300: invokestatic 144	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   303: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 146
    //   308: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 150	bhmi:c	(Ljava/lang/String;)V
    //   317: new 87	java/io/File
    //   320: dup
    //   321: aload 10
    //   323: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   326: astore 9
    //   328: new 87	java/io/File
    //   331: dup
    //   332: aload 9
    //   334: invokevirtual 153	java/io/File:getParent	()Ljava/lang/String;
    //   337: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   340: astore_2
    //   341: aload_2
    //   342: invokevirtual 156	java/io/File:exists	()Z
    //   345: ifeq +10 -> 355
    //   348: aload_2
    //   349: invokevirtual 159	java/io/File:isDirectory	()Z
    //   352: ifne +8 -> 360
    //   355: aload_2
    //   356: invokevirtual 162	java/io/File:mkdirs	()Z
    //   359: pop
    //   360: aload 9
    //   362: invokevirtual 156	java/io/File:exists	()Z
    //   365: ifeq +11 -> 376
    //   368: aload 9
    //   370: invokevirtual 165	java/io/File:isFile	()Z
    //   373: ifne +9 -> 382
    //   376: aload 9
    //   378: invokevirtual 168	java/io/File:createNewFile	()Z
    //   381: pop
    //   382: new 170	java/io/FileOutputStream
    //   385: dup
    //   386: aload 9
    //   388: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   391: astore_2
    //   392: aload 8
    //   394: getstatic 177	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   397: bipush 50
    //   399: aload_2
    //   400: invokevirtual 181	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   403: pop
    //   404: aload_2
    //   405: invokevirtual 184	java/io/FileOutputStream:flush	()V
    //   408: new 98	java/io/FileInputStream
    //   411: dup
    //   412: aload 9
    //   414: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   417: astore 4
    //   419: aload_0
    //   420: aload 4
    //   422: aload 9
    //   424: invokevirtual 94	java/io/File:length	()J
    //   427: invokestatic 107	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   430: invokestatic 113	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   433: putfield 186	abvx:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   436: aload_0
    //   437: getfield 186	abvx:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   440: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   443: ifeq +68 -> 511
    //   446: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +31 -> 480
    //   452: ldc 60
    //   454: iconst_2
    //   455: new 123	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   462: ldc 188
    //   464: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_0
    //   468: getfield 186	abvx:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   471: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload_3
    //   481: ifnull +7 -> 488
    //   484: aload_3
    //   485: invokevirtual 137	java/io/FileInputStream:close	()V
    //   488: aload_2
    //   489: ifnull +7 -> 496
    //   492: aload_2
    //   493: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   496: aload 4
    //   498: ifnull -423 -> 75
    //   501: aload 4
    //   503: invokevirtual 137	java/io/FileInputStream:close	()V
    //   506: iconst_m1
    //   507: ireturn
    //   508: astore_2
    //   509: iconst_m1
    //   510: ireturn
    //   511: aload_0
    //   512: aload_0
    //   513: getfield 186	abvx:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   516: ldc 139
    //   518: invokestatic 142	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   521: putfield 191	abvx:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   524: aload 10
    //   526: aload_0
    //   527: getfield 191	abvx:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   530: invokestatic 194	bhmi:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   533: istore_1
    //   534: iload_1
    //   535: ifne +34 -> 569
    //   538: aload_3
    //   539: ifnull +7 -> 546
    //   542: aload_3
    //   543: invokevirtual 137	java/io/FileInputStream:close	()V
    //   546: aload_2
    //   547: ifnull +7 -> 554
    //   550: aload_2
    //   551: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   554: aload 4
    //   556: ifnull -481 -> 75
    //   559: aload 4
    //   561: invokevirtual 137	java/io/FileInputStream:close	()V
    //   564: iconst_m1
    //   565: ireturn
    //   566: astore_2
    //   567: iconst_m1
    //   568: ireturn
    //   569: aload_0
    //   570: getfield 196	abvx:jdField_b_of_type_Long	J
    //   573: lconst_0
    //   574: lcmp
    //   575: ifne +14 -> 589
    //   578: aload_0
    //   579: aload_0
    //   580: getfield 47	abvx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   583: invokestatic 199	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   586: putfield 196	abvx:jdField_b_of_type_Long	J
    //   589: aload_3
    //   590: ifnull +7 -> 597
    //   593: aload_3
    //   594: invokevirtual 137	java/io/FileInputStream:close	()V
    //   597: aload_2
    //   598: ifnull +7 -> 605
    //   601: aload_2
    //   602: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   605: aload 4
    //   607: ifnull +8 -> 615
    //   610: aload 4
    //   612: invokevirtual 137	java/io/FileInputStream:close	()V
    //   615: iconst_0
    //   616: ireturn
    //   617: astore 4
    //   619: aconst_null
    //   620: astore_2
    //   621: aconst_null
    //   622: astore_3
    //   623: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +13 -> 639
    //   629: ldc 60
    //   631: iconst_2
    //   632: ldc 201
    //   634: aload 4
    //   636: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   639: aload_3
    //   640: ifnull +7 -> 647
    //   643: aload_3
    //   644: invokevirtual 137	java/io/FileInputStream:close	()V
    //   647: aload 5
    //   649: ifnull +8 -> 657
    //   652: aload 5
    //   654: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   657: aload_2
    //   658: ifnull -583 -> 75
    //   661: aload_2
    //   662: invokevirtual 137	java/io/FileInputStream:close	()V
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
    //   691: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   694: ifeq +23 -> 717
    //   697: aload 6
    //   699: astore 7
    //   701: aload_2
    //   702: astore 4
    //   704: aload 8
    //   706: astore_3
    //   707: ldc 60
    //   709: iconst_2
    //   710: ldc 201
    //   712: aload 5
    //   714: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   717: aload 8
    //   719: ifnull +8 -> 727
    //   722: aload 8
    //   724: invokevirtual 137	java/io/FileInputStream:close	()V
    //   727: aload 6
    //   729: ifnull +8 -> 737
    //   732: aload 6
    //   734: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   737: aload_2
    //   738: ifnull -663 -> 75
    //   741: aload_2
    //   742: invokevirtual 137	java/io/FileInputStream:close	()V
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
    //   757: aload 6
    //   759: astore 7
    //   761: aload_2
    //   762: astore 4
    //   764: aload 8
    //   766: astore_3
    //   767: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   770: ifeq +23 -> 793
    //   773: aload 6
    //   775: astore 7
    //   777: aload_2
    //   778: astore 4
    //   780: aload 8
    //   782: astore_3
    //   783: ldc 60
    //   785: iconst_2
    //   786: ldc 206
    //   788: aload 5
    //   790: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   793: aload 8
    //   795: ifnull +8 -> 803
    //   798: aload 8
    //   800: invokevirtual 137	java/io/FileInputStream:close	()V
    //   803: aload 6
    //   805: ifnull +8 -> 813
    //   808: aload 6
    //   810: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   813: aload_2
    //   814: ifnull -739 -> 75
    //   817: aload_2
    //   818: invokevirtual 137	java/io/FileInputStream:close	()V
    //   821: iconst_m1
    //   822: ireturn
    //   823: astore_2
    //   824: iconst_m1
    //   825: ireturn
    //   826: astore_2
    //   827: aconst_null
    //   828: astore 4
    //   830: aconst_null
    //   831: astore_3
    //   832: aload 7
    //   834: astore 5
    //   836: aload_3
    //   837: ifnull +7 -> 844
    //   840: aload_3
    //   841: invokevirtual 137	java/io/FileInputStream:close	()V
    //   844: aload 5
    //   846: ifnull +8 -> 854
    //   849: aload 5
    //   851: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   854: aload 4
    //   856: ifnull +8 -> 864
    //   859: aload 4
    //   861: invokevirtual 137	java/io/FileInputStream:close	()V
    //   864: aload_2
    //   865: athrow
    //   866: astore_2
    //   867: goto -816 -> 51
    //   870: astore_2
    //   871: goto -808 -> 63
    //   874: astore_2
    //   875: iconst_m1
    //   876: ireturn
    //   877: astore_2
    //   878: goto -764 -> 114
    //   881: astore_2
    //   882: goto -756 -> 126
    //   885: astore_2
    //   886: goto -631 -> 255
    //   889: astore_2
    //   890: goto -623 -> 267
    //   893: astore_3
    //   894: goto -406 -> 488
    //   897: astore_2
    //   898: goto -402 -> 496
    //   901: astore_3
    //   902: goto -356 -> 546
    //   905: astore_2
    //   906: goto -352 -> 554
    //   909: astore_3
    //   910: goto -313 -> 597
    //   913: astore_2
    //   914: goto -309 -> 605
    //   917: astore_2
    //   918: goto -303 -> 615
    //   921: astore_3
    //   922: goto -275 -> 647
    //   925: astore_3
    //   926: goto -269 -> 657
    //   929: astore_3
    //   930: goto -203 -> 727
    //   933: astore_3
    //   934: goto -197 -> 737
    //   937: astore_3
    //   938: goto -135 -> 803
    //   941: astore_3
    //   942: goto -129 -> 813
    //   945: astore_3
    //   946: goto -102 -> 844
    //   949: astore_3
    //   950: goto -96 -> 854
    //   953: astore_3
    //   954: goto -90 -> 864
    //   957: astore_2
    //   958: aconst_null
    //   959: astore 4
    //   961: aload 7
    //   963: astore 5
    //   965: goto -129 -> 836
    //   968: astore 6
    //   970: aconst_null
    //   971: astore 4
    //   973: aload_2
    //   974: astore 5
    //   976: aload 6
    //   978: astore_2
    //   979: goto -143 -> 836
    //   982: astore 6
    //   984: aload_2
    //   985: astore 5
    //   987: aload 6
    //   989: astore_2
    //   990: goto -154 -> 836
    //   993: astore 6
    //   995: aload_2
    //   996: astore 4
    //   998: aload 6
    //   1000: astore_2
    //   1001: goto -165 -> 836
    //   1004: astore_2
    //   1005: aload 7
    //   1007: astore 5
    //   1009: goto -173 -> 836
    //   1012: astore 5
    //   1014: aconst_null
    //   1015: astore_2
    //   1016: aload_3
    //   1017: astore 8
    //   1019: goto -262 -> 757
    //   1022: astore 5
    //   1024: aconst_null
    //   1025: astore 4
    //   1027: aload_2
    //   1028: astore 6
    //   1030: aload 4
    //   1032: astore_2
    //   1033: aload_3
    //   1034: astore 8
    //   1036: goto -279 -> 757
    //   1039: astore 5
    //   1041: aload_2
    //   1042: astore 6
    //   1044: aload 4
    //   1046: astore_2
    //   1047: aload_3
    //   1048: astore 8
    //   1050: goto -293 -> 757
    //   1053: astore 5
    //   1055: aconst_null
    //   1056: astore_2
    //   1057: aload 4
    //   1059: astore 6
    //   1061: aload_3
    //   1062: astore 8
    //   1064: goto -383 -> 681
    //   1067: astore 5
    //   1069: aconst_null
    //   1070: astore 4
    //   1072: aload_2
    //   1073: astore 6
    //   1075: aload 4
    //   1077: astore_2
    //   1078: aload_3
    //   1079: astore 8
    //   1081: goto -400 -> 681
    //   1084: astore 5
    //   1086: aload_2
    //   1087: astore 6
    //   1089: aload 4
    //   1091: astore_2
    //   1092: aload_3
    //   1093: astore 8
    //   1095: goto -414 -> 681
    //   1098: astore 4
    //   1100: aconst_null
    //   1101: astore_2
    //   1102: goto -479 -> 623
    //   1105: astore 4
    //   1107: aconst_null
    //   1108: astore 6
    //   1110: aload_2
    //   1111: astore 5
    //   1113: aload 6
    //   1115: astore_2
    //   1116: goto -493 -> 623
    //   1119: astore 6
    //   1121: aload_2
    //   1122: astore 5
    //   1124: aload 4
    //   1126: astore_2
    //   1127: aload 6
    //   1129: astore 4
    //   1131: goto -508 -> 623
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1134	0	this	abvx
    //   533	2	1	bool	boolean
    //   20	58	2	localBitmap	android.graphics.Bitmap
    //   138	1	2	localIOException1	java.io.IOException
    //   170	14	2	localFile1	java.io.File
    //   279	1	2	localIOException2	java.io.IOException
    //   340	153	2	localObject1	Object
    //   508	43	2	localIOException3	java.io.IOException
    //   566	36	2	localIOException4	java.io.IOException
    //   620	42	2	localObject2	Object
    //   667	1	2	localIOException5	java.io.IOException
    //   673	69	2	localObject3	Object
    //   747	1	2	localIOException6	java.io.IOException
    //   753	65	2	localObject4	Object
    //   823	1	2	localIOException7	java.io.IOException
    //   826	39	2	localObject5	Object
    //   866	1	2	localIOException8	java.io.IOException
    //   870	1	2	localIOException9	java.io.IOException
    //   874	1	2	localIOException10	java.io.IOException
    //   877	1	2	localIOException11	java.io.IOException
    //   881	1	2	localIOException12	java.io.IOException
    //   885	1	2	localIOException13	java.io.IOException
    //   889	1	2	localIOException14	java.io.IOException
    //   897	1	2	localIOException15	java.io.IOException
    //   905	1	2	localIOException16	java.io.IOException
    //   913	1	2	localIOException17	java.io.IOException
    //   917	1	2	localIOException18	java.io.IOException
    //   957	17	2	localObject6	Object
    //   978	23	2	localObject7	Object
    //   1004	1	2	localObject8	Object
    //   1015	112	2	localObject9	Object
    //   187	654	3	localObject10	Object
    //   893	1	3	localIOException19	java.io.IOException
    //   901	1	3	localIOException20	java.io.IOException
    //   909	1	3	localIOException21	java.io.IOException
    //   921	1	3	localIOException22	java.io.IOException
    //   925	1	3	localIOException23	java.io.IOException
    //   929	1	3	localIOException24	java.io.IOException
    //   933	1	3	localIOException25	java.io.IOException
    //   937	1	3	localIOException26	java.io.IOException
    //   941	1	3	localIOException27	java.io.IOException
    //   945	1	3	localIOException28	java.io.IOException
    //   949	1	3	localIOException29	java.io.IOException
    //   953	140	3	localIOException30	java.io.IOException
    //   1	610	4	localFileInputStream	java.io.FileInputStream
    //   617	61	4	localIOException31	java.io.IOException
    //   686	404	4	localObject11	Object
    //   1098	1	4	localIOException32	java.io.IOException
    //   1105	20	4	localIOException33	java.io.IOException
    //   1129	1	4	localObject12	Object
    //   10	643	5	localObject13	Object
    //   670	43	5	localException1	java.lang.Exception
    //   750	39	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   834	174	5	localObject14	Object
    //   1012	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1022	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1039	1	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1053	1	5	localException2	java.lang.Exception
    //   1067	1	5	localException3	java.lang.Exception
    //   1084	1	5	localException4	java.lang.Exception
    //   1111	12	5	localObject15	Object
    //   4	805	6	localIOException34	java.io.IOException
    //   968	9	6	localObject16	Object
    //   982	6	6	localObject17	Object
    //   993	6	6	localObject18	Object
    //   1028	86	6	localObject19	Object
    //   1119	9	6	localIOException35	java.io.IOException
    //   7	999	7	localIOException36	java.io.IOException
    //   81	1013	8	localObject20	Object
    //   326	97	9	localFile2	java.io.File
    //   291	234	10	str	String
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
    //   817	821	823	java/io/IOException
    //   12	21	826	finally
    //   25	39	826	finally
    //   77	83	826	finally
    //   88	102	826	finally
    //   141	188	826	finally
    //   43	51	866	java/io/IOException
    //   55	63	870	java/io/IOException
    //   67	75	874	java/io/IOException
    //   106	114	877	java/io/IOException
    //   118	126	881	java/io/IOException
    //   251	255	885	java/io/IOException
    //   259	267	889	java/io/IOException
    //   484	488	893	java/io/IOException
    //   492	496	897	java/io/IOException
    //   542	546	901	java/io/IOException
    //   550	554	905	java/io/IOException
    //   593	597	909	java/io/IOException
    //   601	605	913	java/io/IOException
    //   610	615	917	java/io/IOException
    //   643	647	921	java/io/IOException
    //   652	657	925	java/io/IOException
    //   722	727	929	java/io/IOException
    //   732	737	933	java/io/IOException
    //   798	803	937	java/io/IOException
    //   808	813	941	java/io/IOException
    //   840	844	945	java/io/IOException
    //   849	854	949	java/io/IOException
    //   859	864	953	java/io/IOException
    //   188	247	957	finally
    //   282	355	957	finally
    //   355	360	957	finally
    //   360	376	957	finally
    //   376	382	957	finally
    //   382	392	957	finally
    //   392	419	968	finally
    //   419	480	982	finally
    //   511	534	982	finally
    //   569	589	982	finally
    //   623	639	993	finally
    //   691	697	1004	finally
    //   707	717	1004	finally
    //   767	773	1004	finally
    //   783	793	1004	finally
    //   188	247	1012	java/lang/OutOfMemoryError
    //   282	355	1012	java/lang/OutOfMemoryError
    //   355	360	1012	java/lang/OutOfMemoryError
    //   360	376	1012	java/lang/OutOfMemoryError
    //   376	382	1012	java/lang/OutOfMemoryError
    //   382	392	1012	java/lang/OutOfMemoryError
    //   392	419	1022	java/lang/OutOfMemoryError
    //   419	480	1039	java/lang/OutOfMemoryError
    //   511	534	1039	java/lang/OutOfMemoryError
    //   569	589	1039	java/lang/OutOfMemoryError
    //   188	247	1053	java/lang/Exception
    //   282	355	1053	java/lang/Exception
    //   355	360	1053	java/lang/Exception
    //   360	376	1053	java/lang/Exception
    //   376	382	1053	java/lang/Exception
    //   382	392	1053	java/lang/Exception
    //   392	419	1067	java/lang/Exception
    //   419	480	1084	java/lang/Exception
    //   511	534	1084	java/lang/Exception
    //   569	589	1084	java/lang/Exception
    //   188	247	1098	java/io/IOException
    //   282	355	1098	java/io/IOException
    //   355	360	1098	java/io/IOException
    //   360	376	1098	java/io/IOException
    //   376	382	1098	java/io/IOException
    //   382	392	1098	java/io/IOException
    //   392	419	1105	java/io/IOException
    //   419	480	1119	java/io/IOException
    //   511	534	1119	java/io/IOException
    //   569	589	1119	java/io/IOException
  }
  
  public bcwz a(Object paramObject, bcxn parambcxn)
  {
    return null;
  }
  
  public bcyf a(Object paramObject, bcxn parambcxn)
  {
    if (paramObject == null)
    {
      azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
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
      localObject = new bcyf();
      ((bcyf)localObject).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((bcyf)localObject).h = this.jdField_a_of_type_JavaLangString;
      ((bcyf)localObject).j = this.jdField_d_of_type_JavaLangString;
      ((bcyf)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ((bcyf)localObject).jdField_d_of_type_JavaLangString = "";
      ((bcyf)localObject).jdField_e_of_type_Int = ((int)this.jdField_a_of_type_Long);
      ((bcyf)localObject).f = ((int)this.jdField_b_of_type_Long / 1000);
      ((bcyf)localObject).jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      ((bcyf)localObject).jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      ((bcyf)localObject).jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      ((bcyf)localObject).jdField_g_of_type_Int = parambcxn.jdField_a_of_type_Int;
      ((bcyf)localObject).jdField_a_of_type_JavaLangObject = paramObject;
      ((bcyf)localObject).jdField_g_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      ((bcyf)localObject).l = "";
      azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localObject;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        this.jdField_b_of_type_JavaLangString = ((MessageForShortVideo)localObject).frienduin;
        this.jdField_a_of_type_Int = ((MessageForShortVideo)localObject).istroop;
        this.jdField_a_of_type_Long = ((MessageForShortVideo)localObject).videoFileSize;
        this.jdField_b_of_type_Long = (((MessageForShortVideo)localObject).videoFileTime * 1000);
        this.jdField_a_of_type_JavaLangString = ((MessageForShortVideo)localObject).videoFileName;
        this.jdField_d_of_type_JavaLangString = ShortVideoUtils.a(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        this.jdField_c_of_type_JavaLangString = ((MessageForShortVideo)localObject).md5;
        this.jdField_b_of_type_Int = ((MessageForShortVideo)localObject).thumbWidth;
        this.jdField_c_of_type_Int = ((MessageForShortVideo)localObject).thumbHeight;
        this.jdField_e_of_type_JavaLangString = ((MessageForShortVideo)localObject).thumbMD5;
      }
    }
  }
  
  public MessageRecord a(bcwz parambcwz)
  {
    return null;
  }
  
  public MessageRecord a(bcyf parambcyf)
  {
    int i = 0;
    long l = System.currentTimeMillis();
    MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)bcry.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambcyf.jdField_c_of_type_JavaLangString, parambcyf.jdField_d_of_type_JavaLangString, parambcyf.jdField_b_of_type_Int);
    localMessageForDevShortVideo.videoFileName = parambcyf.h;
    if (parambcyf.jdField_a_of_type_JavaLangString == null) {
      parambcyf.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevShortVideo.uuid = parambcyf.jdField_a_of_type_JavaLangString;
    if (parambcyf.jdField_e_of_type_JavaLangString == null) {
      parambcyf.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevShortVideo.md5 = parambcyf.jdField_e_of_type_JavaLangString;
    localMessageForDevShortVideo.videoFileFormat = 2;
    localMessageForDevShortVideo.videoFileSize = parambcyf.jdField_e_of_type_Int;
    localMessageForDevShortVideo.videoFileTime = parambcyf.f;
    localMessageForDevShortVideo.thumbWidth = parambcyf.jdField_c_of_type_Int;
    localMessageForDevShortVideo.thumbHeight = parambcyf.jdField_d_of_type_Int;
    localMessageForDevShortVideo.videoFileStatus = 1002;
    localMessageForDevShortVideo.videoFileProgress = 0;
    localMessageForDevShortVideo.fileType = 19;
    localMessageForDevShortVideo.thumbMD5 = parambcyf.jdField_g_of_type_JavaLangString;
    localMessageForDevShortVideo.extraflag = 32772;
    if (parambcyf.l == null) {
      parambcyf.l = "";
    }
    localMessageForDevShortVideo.fileSource = parambcyf.l;
    localMessageForDevShortVideo.lastModified = 0L;
    if (parambcyf.jdField_a_of_type_Bcyg != null) {
      i = 1;
    }
    if (i != 0)
    {
      localMessageForDevShortVideo.msgseq = parambcyf.jdField_a_of_type_Bcyg.jdField_a_of_type_Long;
      localMessageForDevShortVideo.shmsgseq = parambcyf.jdField_a_of_type_Bcyg.jdField_b_of_type_Long;
      localMessageForDevShortVideo.msgUid = parambcyf.jdField_a_of_type_Bcyg.c;
    }
    localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
    localMessageForDevShortVideo.serial();
    parambcyf.jdField_a_of_type_Long = localMessageForDevShortVideo.uniseq;
    azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevShortVideo.toLogString() + "-" + localMessageForDevShortVideo.toString());
    return localMessageForDevShortVideo;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(azrh paramazrh)
  {
    azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "updateMsg", "resut:" + paramazrh);
    if (paramazrh != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramazrh.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramazrh.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramazrh.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
  
  public void a(bcyf parambcyf)
  {
    azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    b(parambcyf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvx
 * JD-Core Version:    0.7.0.1
 */