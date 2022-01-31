import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEdtiController.2;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEdtiController.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class adci
{
  private int jdField_a_of_type_Int;
  private adbt jdField_a_of_type_Adbt;
  private adbu jdField_a_of_type_Adbu;
  private ayvx jdField_a_of_type_Ayvx;
  private aywb jdField_a_of_type_Aywb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "VoiceTextEdtiController";
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private boolean jdField_a_of_type_Boolean;
  private adbv[] jdField_a_of_type_ArrayOfAdbv;
  private String b;
  private String c;
  
  private void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("issuccess", String.valueOf(paramInt1));
    localHashMap.put("errorcode", String.valueOf(paramInt2));
    axrn.a(BaseApplication.getContext()).a(null, "pttSliceToText", true, 0L, 0L, localHashMap, "");
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, byte paramByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 121	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 128	java/io/File:exists	()Z
    //   16: ifeq +8 -> 24
    //   19: aload_1
    //   20: invokevirtual 131	java/io/File:delete	()Z
    //   23: pop
    //   24: iload_3
    //   25: iflt +974 -> 999
    //   28: new 133	java/io/FileInputStream
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 134	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: new 136	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokevirtual 140	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   45: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore_1
    //   49: iload_3
    //   50: invokestatic 148	bbjg:a	(B)I
    //   53: istore 5
    //   55: new 150	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   58: dup
    //   59: aload_0
    //   60: getfield 66	adci:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   66: iconst_0
    //   67: invokespecial 159	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;Z)V
    //   70: astore 6
    //   72: aload_2
    //   73: astore 8
    //   75: aload_1
    //   76: astore 9
    //   78: aload 6
    //   80: astore 10
    //   82: iload 5
    //   84: invokestatic 162	bbjg:a	(I)I
    //   87: istore 4
    //   89: aload_2
    //   90: astore 8
    //   92: aload_1
    //   93: astore 9
    //   95: aload 6
    //   97: astore 10
    //   99: iload 4
    //   101: newarray byte
    //   103: astore 13
    //   105: aload_2
    //   106: astore 8
    //   108: aload_1
    //   109: astore 9
    //   111: aload 6
    //   113: astore 10
    //   115: iload 4
    //   117: newarray byte
    //   119: astore 14
    //   121: aload_2
    //   122: astore 8
    //   124: aload_1
    //   125: astore 9
    //   127: aload 6
    //   129: astore 10
    //   131: aload 6
    //   133: iload 5
    //   135: iconst_0
    //   136: iconst_1
    //   137: invokevirtual 165	com/tencent/mobileqq/utils/SilkCodecWrapper:a	(III)V
    //   140: aload_2
    //   141: astore 8
    //   143: aload_1
    //   144: astore 9
    //   146: aload 6
    //   148: astore 10
    //   150: iconst_2
    //   151: newarray byte
    //   153: astore 15
    //   155: aload_2
    //   156: astore 8
    //   158: aload_1
    //   159: astore 9
    //   161: aload 6
    //   163: astore 10
    //   165: aload_2
    //   166: ldc2_w 166
    //   169: invokevirtual 171	java/io/FileInputStream:skip	(J)J
    //   172: pop2
    //   173: aload_2
    //   174: astore 7
    //   176: aload_1
    //   177: astore 11
    //   179: aload 6
    //   181: astore 12
    //   183: aload_2
    //   184: astore 8
    //   186: aload_1
    //   187: astore 9
    //   189: aload 6
    //   191: astore 10
    //   193: aload_0
    //   194: getfield 173	adci:jdField_a_of_type_Boolean	Z
    //   197: ifeq +91 -> 288
    //   200: aload_2
    //   201: astore 7
    //   203: aload_1
    //   204: astore 11
    //   206: aload 6
    //   208: astore 12
    //   210: aload_1
    //   211: ifnull +77 -> 288
    //   214: aload_2
    //   215: astore 7
    //   217: aload_1
    //   218: astore 11
    //   220: aload 6
    //   222: astore 12
    //   224: aload_2
    //   225: ifnull +63 -> 288
    //   228: aload_2
    //   229: astore 8
    //   231: aload_1
    //   232: astore 9
    //   234: aload 6
    //   236: astore 10
    //   238: aload_2
    //   239: aload 15
    //   241: iconst_0
    //   242: iconst_2
    //   243: invokevirtual 177	java/io/FileInputStream:read	([BII)I
    //   246: iconst_m1
    //   247: if_icmpne +77 -> 324
    //   250: aload_2
    //   251: astore 8
    //   253: aload_1
    //   254: astore 9
    //   256: aload 6
    //   258: astore 10
    //   260: aload_1
    //   261: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   264: aload_2
    //   265: astore 8
    //   267: aload_1
    //   268: astore 9
    //   270: aload 6
    //   272: astore 10
    //   274: aload_1
    //   275: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   278: aload 6
    //   280: astore 12
    //   282: aload_1
    //   283: astore 11
    //   285: aload_2
    //   286: astore 7
    //   288: aload 11
    //   290: ifnull +13 -> 303
    //   293: aload 11
    //   295: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   298: aload 11
    //   300: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   303: aload 7
    //   305: ifnull +8 -> 313
    //   308: aload 7
    //   310: invokevirtual 184	java/io/FileInputStream:close	()V
    //   313: aload 12
    //   315: ifnull +8 -> 323
    //   318: aload 12
    //   320: invokevirtual 186	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   323: return
    //   324: aload_2
    //   325: astore 7
    //   327: aload_1
    //   328: astore 11
    //   330: aload 6
    //   332: astore 12
    //   334: aload_2
    //   335: astore 8
    //   337: aload_1
    //   338: astore 9
    //   340: aload 6
    //   342: astore 10
    //   344: aload_0
    //   345: getfield 173	adci:jdField_a_of_type_Boolean	Z
    //   348: ifeq -60 -> 288
    //   351: aload_2
    //   352: astore 8
    //   354: aload_1
    //   355: astore 9
    //   357: aload 6
    //   359: astore 10
    //   361: aload 15
    //   363: invokestatic 189	bbjg:a	([B)I
    //   366: istore 5
    //   368: iload 5
    //   370: ifgt +127 -> 497
    //   373: aload_2
    //   374: astore 7
    //   376: aload_1
    //   377: astore 11
    //   379: aload 6
    //   381: astore 12
    //   383: aload_2
    //   384: astore 8
    //   386: aload_1
    //   387: astore 9
    //   389: aload 6
    //   391: astore 10
    //   393: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq -108 -> 288
    //   399: aload_2
    //   400: astore 8
    //   402: aload_1
    //   403: astore 9
    //   405: aload 6
    //   407: astore 10
    //   409: ldc 26
    //   411: iconst_2
    //   412: new 196	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   419: ldc 199
    //   421: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: iload 5
    //   426: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   429: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   435: aload_2
    //   436: astore 7
    //   438: aload_1
    //   439: astore 11
    //   441: aload 6
    //   443: astore 12
    //   445: goto -157 -> 288
    //   448: astore 8
    //   450: aload_1
    //   451: astore 7
    //   453: aload 6
    //   455: astore_1
    //   456: aload 8
    //   458: astore 6
    //   460: aload 6
    //   462: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   465: aload 7
    //   467: ifnull +13 -> 480
    //   470: aload 7
    //   472: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   475: aload 7
    //   477: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   480: aload_2
    //   481: ifnull +7 -> 488
    //   484: aload_2
    //   485: invokevirtual 184	java/io/FileInputStream:close	()V
    //   488: aload_1
    //   489: ifnull -166 -> 323
    //   492: aload_1
    //   493: invokevirtual 186	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   496: return
    //   497: aload_2
    //   498: astore 7
    //   500: aload_1
    //   501: astore 11
    //   503: aload 6
    //   505: astore 12
    //   507: aload_2
    //   508: astore 8
    //   510: aload_1
    //   511: astore 9
    //   513: aload 6
    //   515: astore 10
    //   517: aload_0
    //   518: getfield 173	adci:jdField_a_of_type_Boolean	Z
    //   521: ifeq -233 -> 288
    //   524: aload_2
    //   525: astore 8
    //   527: aload_1
    //   528: astore 9
    //   530: aload 6
    //   532: astore 10
    //   534: aload_2
    //   535: aload 13
    //   537: iconst_0
    //   538: iload 5
    //   540: invokevirtual 177	java/io/FileInputStream:read	([BII)I
    //   543: iconst_m1
    //   544: if_icmpne +126 -> 670
    //   547: aload_2
    //   548: astore 7
    //   550: aload_1
    //   551: astore 11
    //   553: aload 6
    //   555: astore 12
    //   557: aload_2
    //   558: astore 8
    //   560: aload_1
    //   561: astore 9
    //   563: aload 6
    //   565: astore 10
    //   567: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq -282 -> 288
    //   573: aload_2
    //   574: astore 8
    //   576: aload_1
    //   577: astore 9
    //   579: aload 6
    //   581: astore 10
    //   583: ldc 26
    //   585: iconst_2
    //   586: new 196	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   593: ldc 219
    //   595: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: iload 5
    //   600: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aload_2
    //   610: astore 7
    //   612: aload_1
    //   613: astore 11
    //   615: aload 6
    //   617: astore 12
    //   619: goto -331 -> 288
    //   622: astore 7
    //   624: aload_2
    //   625: astore 8
    //   627: aload_1
    //   628: astore 9
    //   630: aload 6
    //   632: astore 10
    //   634: aload 7
    //   636: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   639: aload_1
    //   640: ifnull +11 -> 651
    //   643: aload_1
    //   644: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   647: aload_1
    //   648: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   651: aload_2
    //   652: ifnull +7 -> 659
    //   655: aload_2
    //   656: invokevirtual 184	java/io/FileInputStream:close	()V
    //   659: aload 6
    //   661: ifnull -338 -> 323
    //   664: aload 6
    //   666: invokevirtual 186	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   669: return
    //   670: aload_2
    //   671: astore 7
    //   673: aload_1
    //   674: astore 11
    //   676: aload 6
    //   678: astore 12
    //   680: aload_2
    //   681: astore 8
    //   683: aload_1
    //   684: astore 9
    //   686: aload 6
    //   688: astore 10
    //   690: aload_0
    //   691: getfield 173	adci:jdField_a_of_type_Boolean	Z
    //   694: ifeq -406 -> 288
    //   697: aload_2
    //   698: astore 8
    //   700: aload_1
    //   701: astore 9
    //   703: aload 6
    //   705: astore 10
    //   707: aload 6
    //   709: aload 13
    //   711: aload 14
    //   713: iload 5
    //   715: aload 14
    //   717: arraylength
    //   718: invokevirtual 223	com/tencent/mobileqq/utils/SilkCodecWrapper:a	([B[BII)I
    //   721: ifne +105 -> 826
    //   724: aload_2
    //   725: astore 7
    //   727: aload_1
    //   728: astore 11
    //   730: aload 6
    //   732: astore 12
    //   734: aload_2
    //   735: astore 8
    //   737: aload_1
    //   738: astore 9
    //   740: aload 6
    //   742: astore 10
    //   744: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   747: ifeq -459 -> 288
    //   750: aload_2
    //   751: astore 8
    //   753: aload_1
    //   754: astore 9
    //   756: aload 6
    //   758: astore 10
    //   760: ldc 26
    //   762: iconst_2
    //   763: ldc 225
    //   765: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   768: aload_2
    //   769: astore 7
    //   771: aload_1
    //   772: astore 11
    //   774: aload 6
    //   776: astore 12
    //   778: goto -490 -> 288
    //   781: astore 6
    //   783: aload 10
    //   785: astore_2
    //   786: aload 9
    //   788: astore_1
    //   789: aload 8
    //   791: astore 7
    //   793: aload_1
    //   794: ifnull +11 -> 805
    //   797: aload_1
    //   798: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   801: aload_1
    //   802: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   805: aload 7
    //   807: ifnull +8 -> 815
    //   810: aload 7
    //   812: invokevirtual 184	java/io/FileInputStream:close	()V
    //   815: aload_2
    //   816: ifnull +7 -> 823
    //   819: aload_2
    //   820: invokevirtual 186	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   823: aload 6
    //   825: athrow
    //   826: aload_2
    //   827: astore 8
    //   829: aload_1
    //   830: astore 9
    //   832: aload 6
    //   834: astore 10
    //   836: aload_1
    //   837: aload 14
    //   839: iconst_0
    //   840: iload 4
    //   842: invokevirtual 229	java/io/FileOutputStream:write	([BII)V
    //   845: goto -672 -> 173
    //   848: astore_1
    //   849: aload_1
    //   850: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   853: goto -540 -> 313
    //   856: astore_2
    //   857: aload_2
    //   858: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   861: goto -373 -> 488
    //   864: astore_1
    //   865: aload_1
    //   866: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   869: goto -210 -> 659
    //   872: astore_1
    //   873: aload_1
    //   874: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   877: goto -62 -> 815
    //   880: astore 6
    //   882: aconst_null
    //   883: astore 7
    //   885: aconst_null
    //   886: astore_1
    //   887: aconst_null
    //   888: astore_2
    //   889: goto -96 -> 793
    //   892: astore 6
    //   894: aconst_null
    //   895: astore_1
    //   896: aconst_null
    //   897: astore 8
    //   899: aload_2
    //   900: astore 7
    //   902: aload 8
    //   904: astore_2
    //   905: goto -112 -> 793
    //   908: astore 6
    //   910: aconst_null
    //   911: astore 8
    //   913: aload_2
    //   914: astore 7
    //   916: aload 8
    //   918: astore_2
    //   919: goto -126 -> 793
    //   922: astore 6
    //   924: aload_1
    //   925: astore 8
    //   927: aload 7
    //   929: astore_1
    //   930: aload_2
    //   931: astore 7
    //   933: aload 8
    //   935: astore_2
    //   936: goto -143 -> 793
    //   939: astore 7
    //   941: aconst_null
    //   942: astore_2
    //   943: aconst_null
    //   944: astore_1
    //   945: aconst_null
    //   946: astore 6
    //   948: goto -324 -> 624
    //   951: astore 7
    //   953: aconst_null
    //   954: astore_1
    //   955: aconst_null
    //   956: astore 6
    //   958: goto -334 -> 624
    //   961: astore 7
    //   963: aconst_null
    //   964: astore 6
    //   966: goto -342 -> 624
    //   969: astore 6
    //   971: aconst_null
    //   972: astore_2
    //   973: aconst_null
    //   974: astore_1
    //   975: goto -515 -> 460
    //   978: astore 6
    //   980: aconst_null
    //   981: astore_1
    //   982: goto -522 -> 460
    //   985: astore 6
    //   987: aconst_null
    //   988: astore 8
    //   990: aload_1
    //   991: astore 7
    //   993: aload 8
    //   995: astore_1
    //   996: goto -536 -> 460
    //   999: aconst_null
    //   1000: astore 7
    //   1002: aconst_null
    //   1003: astore 11
    //   1005: aconst_null
    //   1006: astore 12
    //   1008: goto -720 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1011	0	this	adci
    //   0	1011	1	paramString1	String
    //   0	1011	2	paramString2	String
    //   0	1011	3	paramByte	byte
    //   87	754	4	i	int
    //   53	661	5	j	int
    //   70	705	6	localObject1	Object
    //   781	52	6	localObject2	Object
    //   880	1	6	localObject3	Object
    //   892	1	6	localObject4	Object
    //   908	1	6	localObject5	Object
    //   922	1	6	localObject6	Object
    //   946	19	6	localObject7	Object
    //   969	1	6	localIOException1	java.io.IOException
    //   978	1	6	localIOException2	java.io.IOException
    //   985	1	6	localIOException3	java.io.IOException
    //   1	610	7	str1	String
    //   622	13	7	localException1	java.lang.Exception
    //   671	261	7	localObject8	Object
    //   939	1	7	localException2	java.lang.Exception
    //   951	1	7	localException3	java.lang.Exception
    //   961	1	7	localException4	java.lang.Exception
    //   991	10	7	str2	String
    //   73	328	8	str3	String
    //   448	9	8	localIOException4	java.io.IOException
    //   508	486	8	str4	String
    //   76	755	9	str5	String
    //   80	755	10	localObject9	Object
    //   177	827	11	str6	String
    //   181	826	12	localObject10	Object
    //   103	607	13	arrayOfByte1	byte[]
    //   119	719	14	arrayOfByte2	byte[]
    //   153	209	15	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   82	89	448	java/io/IOException
    //   99	105	448	java/io/IOException
    //   115	121	448	java/io/IOException
    //   131	140	448	java/io/IOException
    //   150	155	448	java/io/IOException
    //   165	173	448	java/io/IOException
    //   193	200	448	java/io/IOException
    //   238	250	448	java/io/IOException
    //   260	264	448	java/io/IOException
    //   274	278	448	java/io/IOException
    //   344	351	448	java/io/IOException
    //   361	368	448	java/io/IOException
    //   393	399	448	java/io/IOException
    //   409	435	448	java/io/IOException
    //   517	524	448	java/io/IOException
    //   534	547	448	java/io/IOException
    //   567	573	448	java/io/IOException
    //   583	609	448	java/io/IOException
    //   690	697	448	java/io/IOException
    //   707	724	448	java/io/IOException
    //   744	750	448	java/io/IOException
    //   760	768	448	java/io/IOException
    //   836	845	448	java/io/IOException
    //   82	89	622	java/lang/Exception
    //   99	105	622	java/lang/Exception
    //   115	121	622	java/lang/Exception
    //   131	140	622	java/lang/Exception
    //   150	155	622	java/lang/Exception
    //   165	173	622	java/lang/Exception
    //   193	200	622	java/lang/Exception
    //   238	250	622	java/lang/Exception
    //   260	264	622	java/lang/Exception
    //   274	278	622	java/lang/Exception
    //   344	351	622	java/lang/Exception
    //   361	368	622	java/lang/Exception
    //   393	399	622	java/lang/Exception
    //   409	435	622	java/lang/Exception
    //   517	524	622	java/lang/Exception
    //   534	547	622	java/lang/Exception
    //   567	573	622	java/lang/Exception
    //   583	609	622	java/lang/Exception
    //   690	697	622	java/lang/Exception
    //   707	724	622	java/lang/Exception
    //   744	750	622	java/lang/Exception
    //   760	768	622	java/lang/Exception
    //   836	845	622	java/lang/Exception
    //   82	89	781	finally
    //   99	105	781	finally
    //   115	121	781	finally
    //   131	140	781	finally
    //   150	155	781	finally
    //   165	173	781	finally
    //   193	200	781	finally
    //   238	250	781	finally
    //   260	264	781	finally
    //   274	278	781	finally
    //   344	351	781	finally
    //   361	368	781	finally
    //   393	399	781	finally
    //   409	435	781	finally
    //   517	524	781	finally
    //   534	547	781	finally
    //   567	573	781	finally
    //   583	609	781	finally
    //   634	639	781	finally
    //   690	697	781	finally
    //   707	724	781	finally
    //   744	750	781	finally
    //   760	768	781	finally
    //   836	845	781	finally
    //   293	303	848	java/io/IOException
    //   308	313	848	java/io/IOException
    //   470	480	856	java/io/IOException
    //   484	488	856	java/io/IOException
    //   643	651	864	java/io/IOException
    //   655	659	864	java/io/IOException
    //   797	805	872	java/io/IOException
    //   810	815	872	java/io/IOException
    //   28	37	880	finally
    //   37	49	892	finally
    //   49	72	908	finally
    //   460	465	922	finally
    //   28	37	939	java/lang/Exception
    //   37	49	951	java/lang/Exception
    //   49	72	961	java/lang/Exception
    //   28	37	969	java/io/IOException
    //   37	49	978	java/io/IOException
    //   49	72	985	java/io/IOException
  }
  
  /* Error */
  public byte a(String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: new 133	java/io/FileInputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 134	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: astore_1
    //   15: aload 4
    //   17: invokestatic 239	bbjg:a	(Ljava/io/InputStream;)B
    //   20: istore_2
    //   21: iload_2
    //   22: istore_3
    //   23: aload 4
    //   25: ifnull +10 -> 35
    //   28: aload 4
    //   30: invokevirtual 184	java/io/FileInputStream:close	()V
    //   33: iload_2
    //   34: istore_3
    //   35: iload_3
    //   36: ireturn
    //   37: astore 5
    //   39: aconst_null
    //   40: astore 4
    //   42: aload 4
    //   44: astore_1
    //   45: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +35 -> 83
    //   51: aload 4
    //   53: astore_1
    //   54: ldc 26
    //   56: iconst_2
    //   57: new 196	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   64: ldc 241
    //   66: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 5
    //   71: invokevirtual 244	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   74: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload 4
    //   85: ifnull -50 -> 35
    //   88: aload 4
    //   90: invokevirtual 184	java/io/FileInputStream:close	()V
    //   93: iconst_m1
    //   94: ireturn
    //   95: astore_1
    //   96: iconst_m1
    //   97: ireturn
    //   98: astore 4
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 184	java/io/FileInputStream:close	()V
    //   110: aload 4
    //   112: athrow
    //   113: astore_1
    //   114: iload_2
    //   115: ireturn
    //   116: astore_1
    //   117: goto -7 -> 110
    //   120: astore 4
    //   122: goto -20 -> 102
    //   125: astore 5
    //   127: goto -85 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	adci
    //   0	130	1	paramString	String
    //   20	95	2	b1	byte
    //   1	35	3	b2	byte
    //   10	79	4	localFileInputStream	java.io.FileInputStream
    //   98	13	4	localObject1	Object
    //   120	1	4	localObject2	Object
    //   37	33	5	localException1	java.lang.Exception
    //   125	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	12	37	java/lang/Exception
    //   88	93	95	java/lang/Exception
    //   2	12	98	finally
    //   28	33	113	java/lang/Exception
    //   106	110	116	java/lang/Exception
    //   15	21	120	finally
    //   45	51	120	finally
    //   54	83	120	finally
    //   15	21	125	java/lang/Exception
  }
  
  public String a(adbv paramadbv, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAdbv[paramInt] = paramadbv;
    paramadbv = new StringBuffer();
    paramInt = 0;
    for (;;)
    {
      adbv localadbv;
      if (paramInt < this.jdField_a_of_type_ArrayOfAdbv.length)
      {
        localadbv = this.jdField_a_of_type_ArrayOfAdbv[paramInt];
        if (localadbv != null) {
          break label42;
        }
      }
      label42:
      do
      {
        return paramadbv.toString();
        paramadbv.append(localadbv.jdField_a_of_type_JavaLangString);
      } while (!localadbv.jdField_a_of_type_Boolean);
      paramInt += 1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEdtiController", 2, "cancelAllRequest sendIds len=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_Ayvx.d(this.c, ((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue());
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(adbv paramadbv, int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfAdbv == null) || (paramInt >= this.jdField_a_of_type_ArrayOfAdbv.length) || ((this.jdField_a_of_type_ArrayOfAdbv[paramInt] != null) && (this.jdField_a_of_type_ArrayOfAdbv[paramInt].jdField_a_of_type_Boolean)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "updateText fail");
      }
      return;
    }
    this.jdField_a_of_type_Adbu.a(a(paramadbv, paramInt));
  }
  
  public void a(String paramString)
  {
    bdst.a(new VoiceTextEdtiController.2(this, paramString));
  }
  
  public void a(String paramString1, QQAppInterface paramQQAppInterface, adbu paramadbu, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.jdField_a_of_type_Adbu = paramadbu;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString2;
    if (paramInt == 3000) {
      this.jdField_a_of_type_Int = 1;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_a_of_type_Aywb = new adcj(this);
    this.jdField_a_of_type_Aywb.addFilter(new Class[] { ayto.class });
  }
  
  public void b()
  {
    a();
  }
  
  public void b(String paramString)
  {
    bdst.a(new VoiceTextEdtiController.3(this, paramString));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ayvx != null) {
      this.jdField_a_of_type_Ayvx.b(this.jdField_a_of_type_Aywb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adci
 * JD-Core Version:    0.7.0.1
 */