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

public class aeuk
{
  private int jdField_a_of_type_Int;
  private aetv jdField_a_of_type_Aetv;
  private aetw jdField_a_of_type_Aetw;
  private batw jdField_a_of_type_Batw;
  private baua jdField_a_of_type_Baua;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "VoiceTextEdtiController";
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private boolean jdField_a_of_type_Boolean;
  private aetx[] jdField_a_of_type_ArrayOfAetx;
  private String b;
  private String c;
  
  private void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("issuccess", String.valueOf(paramInt1));
    localHashMap.put("errorcode", String.valueOf(paramInt2));
    azmz.a(BaseApplication.getContext()).a(null, "pttSliceToText", true, 0L, 0L, localHashMap, "");
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
    //   25: iflt +968 -> 993
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
    //   50: invokestatic 148	bdic:a	(B)I
    //   53: istore 5
    //   55: new 150	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   58: dup
    //   59: aload_0
    //   60: getfield 66	aeuk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
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
    //   84: invokestatic 162	bdic:a	(I)I
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
    //   194: getfield 173	aeuk:jdField_a_of_type_Boolean	Z
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
    //   288: aload 12
    //   290: ifnull +8 -> 298
    //   293: aload 12
    //   295: invokevirtual 184	com/tencent/mobileqq/utils/SilkCodecWrapper:close	()V
    //   298: aload 11
    //   300: ifnull +13 -> 313
    //   303: aload 11
    //   305: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   308: aload 11
    //   310: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   313: aload 7
    //   315: ifnull +8 -> 323
    //   318: aload 7
    //   320: invokevirtual 185	java/io/FileInputStream:close	()V
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
    //   345: getfield 173	aeuk:jdField_a_of_type_Boolean	Z
    //   348: ifeq -60 -> 288
    //   351: aload_2
    //   352: astore 8
    //   354: aload_1
    //   355: astore 9
    //   357: aload 6
    //   359: astore 10
    //   361: aload 15
    //   363: invokestatic 188	bdic:a	([B)I
    //   366: istore 5
    //   368: iload 5
    //   370: ifgt +133 -> 503
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
    //   393: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq -108 -> 288
    //   399: aload_2
    //   400: astore 8
    //   402: aload_1
    //   403: astore 9
    //   405: aload 6
    //   407: astore 10
    //   409: ldc 26
    //   411: iconst_2
    //   412: new 195	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   419: ldc 198
    //   421: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: iload 5
    //   426: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   429: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   462: invokevirtual 216	java/io/IOException:printStackTrace	()V
    //   465: aload_1
    //   466: ifnull +7 -> 473
    //   469: aload_1
    //   470: invokevirtual 184	com/tencent/mobileqq/utils/SilkCodecWrapper:close	()V
    //   473: aload 7
    //   475: ifnull +13 -> 488
    //   478: aload 7
    //   480: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   483: aload 7
    //   485: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   488: aload_2
    //   489: ifnull -166 -> 323
    //   492: aload_2
    //   493: invokevirtual 185	java/io/FileInputStream:close	()V
    //   496: return
    //   497: astore_1
    //   498: aload_1
    //   499: invokevirtual 216	java/io/IOException:printStackTrace	()V
    //   502: return
    //   503: aload_2
    //   504: astore 7
    //   506: aload_1
    //   507: astore 11
    //   509: aload 6
    //   511: astore 12
    //   513: aload_2
    //   514: astore 8
    //   516: aload_1
    //   517: astore 9
    //   519: aload 6
    //   521: astore 10
    //   523: aload_0
    //   524: getfield 173	aeuk:jdField_a_of_type_Boolean	Z
    //   527: ifeq -239 -> 288
    //   530: aload_2
    //   531: astore 8
    //   533: aload_1
    //   534: astore 9
    //   536: aload 6
    //   538: astore 10
    //   540: aload_2
    //   541: aload 13
    //   543: iconst_0
    //   544: iload 5
    //   546: invokevirtual 177	java/io/FileInputStream:read	([BII)I
    //   549: iconst_m1
    //   550: if_icmpne +132 -> 682
    //   553: aload_2
    //   554: astore 7
    //   556: aload_1
    //   557: astore 11
    //   559: aload 6
    //   561: astore 12
    //   563: aload_2
    //   564: astore 8
    //   566: aload_1
    //   567: astore 9
    //   569: aload 6
    //   571: astore 10
    //   573: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq -288 -> 288
    //   579: aload_2
    //   580: astore 8
    //   582: aload_1
    //   583: astore 9
    //   585: aload 6
    //   587: astore 10
    //   589: ldc 26
    //   591: iconst_2
    //   592: new 195	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   599: ldc 218
    //   601: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: iload 5
    //   606: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: aload_2
    //   616: astore 7
    //   618: aload_1
    //   619: astore 11
    //   621: aload 6
    //   623: astore 12
    //   625: goto -337 -> 288
    //   628: astore 7
    //   630: aload_2
    //   631: astore 8
    //   633: aload_1
    //   634: astore 9
    //   636: aload 6
    //   638: astore 10
    //   640: aload 7
    //   642: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   645: aload 6
    //   647: ifnull +8 -> 655
    //   650: aload 6
    //   652: invokevirtual 184	com/tencent/mobileqq/utils/SilkCodecWrapper:close	()V
    //   655: aload_1
    //   656: ifnull +11 -> 667
    //   659: aload_1
    //   660: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   663: aload_1
    //   664: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   667: aload_2
    //   668: ifnull -345 -> 323
    //   671: aload_2
    //   672: invokevirtual 185	java/io/FileInputStream:close	()V
    //   675: return
    //   676: astore_1
    //   677: aload_1
    //   678: invokevirtual 216	java/io/IOException:printStackTrace	()V
    //   681: return
    //   682: aload_2
    //   683: astore 7
    //   685: aload_1
    //   686: astore 11
    //   688: aload 6
    //   690: astore 12
    //   692: aload_2
    //   693: astore 8
    //   695: aload_1
    //   696: astore 9
    //   698: aload 6
    //   700: astore 10
    //   702: aload_0
    //   703: getfield 173	aeuk:jdField_a_of_type_Boolean	Z
    //   706: ifeq -418 -> 288
    //   709: aload_2
    //   710: astore 8
    //   712: aload_1
    //   713: astore 9
    //   715: aload 6
    //   717: astore 10
    //   719: aload 6
    //   721: aload 13
    //   723: aload 14
    //   725: iload 5
    //   727: aload 14
    //   729: arraylength
    //   730: invokevirtual 222	com/tencent/mobileqq/utils/SilkCodecWrapper:a	([B[BII)I
    //   733: ifne +105 -> 838
    //   736: aload_2
    //   737: astore 7
    //   739: aload_1
    //   740: astore 11
    //   742: aload 6
    //   744: astore 12
    //   746: aload_2
    //   747: astore 8
    //   749: aload_1
    //   750: astore 9
    //   752: aload 6
    //   754: astore 10
    //   756: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   759: ifeq -471 -> 288
    //   762: aload_2
    //   763: astore 8
    //   765: aload_1
    //   766: astore 9
    //   768: aload 6
    //   770: astore 10
    //   772: ldc 26
    //   774: iconst_2
    //   775: ldc 224
    //   777: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   780: aload_2
    //   781: astore 7
    //   783: aload_1
    //   784: astore 11
    //   786: aload 6
    //   788: astore 12
    //   790: goto -502 -> 288
    //   793: astore 6
    //   795: aload 10
    //   797: astore_2
    //   798: aload 9
    //   800: astore_1
    //   801: aload 8
    //   803: astore 7
    //   805: aload_2
    //   806: ifnull +7 -> 813
    //   809: aload_2
    //   810: invokevirtual 184	com/tencent/mobileqq/utils/SilkCodecWrapper:close	()V
    //   813: aload_1
    //   814: ifnull +11 -> 825
    //   817: aload_1
    //   818: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   821: aload_1
    //   822: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   825: aload 7
    //   827: ifnull +8 -> 835
    //   830: aload 7
    //   832: invokevirtual 185	java/io/FileInputStream:close	()V
    //   835: aload 6
    //   837: athrow
    //   838: aload_2
    //   839: astore 8
    //   841: aload_1
    //   842: astore 9
    //   844: aload 6
    //   846: astore 10
    //   848: aload_1
    //   849: aload 14
    //   851: iconst_0
    //   852: iload 4
    //   854: invokevirtual 228	java/io/FileOutputStream:write	([BII)V
    //   857: goto -684 -> 173
    //   860: astore_1
    //   861: aload_1
    //   862: invokevirtual 216	java/io/IOException:printStackTrace	()V
    //   865: return
    //   866: astore_1
    //   867: aload_1
    //   868: invokevirtual 216	java/io/IOException:printStackTrace	()V
    //   871: goto -36 -> 835
    //   874: astore 6
    //   876: aconst_null
    //   877: astore 7
    //   879: aconst_null
    //   880: astore_1
    //   881: aconst_null
    //   882: astore_2
    //   883: goto -78 -> 805
    //   886: astore 6
    //   888: aconst_null
    //   889: astore_1
    //   890: aconst_null
    //   891: astore 8
    //   893: aload_2
    //   894: astore 7
    //   896: aload 8
    //   898: astore_2
    //   899: goto -94 -> 805
    //   902: astore 6
    //   904: aconst_null
    //   905: astore 8
    //   907: aload_2
    //   908: astore 7
    //   910: aload 8
    //   912: astore_2
    //   913: goto -108 -> 805
    //   916: astore 6
    //   918: aload_1
    //   919: astore 8
    //   921: aload 7
    //   923: astore_1
    //   924: aload_2
    //   925: astore 7
    //   927: aload 8
    //   929: astore_2
    //   930: goto -125 -> 805
    //   933: astore 7
    //   935: aconst_null
    //   936: astore_2
    //   937: aconst_null
    //   938: astore_1
    //   939: aconst_null
    //   940: astore 6
    //   942: goto -312 -> 630
    //   945: astore 7
    //   947: aconst_null
    //   948: astore_1
    //   949: aconst_null
    //   950: astore 6
    //   952: goto -322 -> 630
    //   955: astore 7
    //   957: aconst_null
    //   958: astore 6
    //   960: goto -330 -> 630
    //   963: astore 6
    //   965: aconst_null
    //   966: astore_2
    //   967: aconst_null
    //   968: astore_1
    //   969: goto -509 -> 460
    //   972: astore 6
    //   974: aconst_null
    //   975: astore_1
    //   976: goto -516 -> 460
    //   979: astore 6
    //   981: aconst_null
    //   982: astore 8
    //   984: aload_1
    //   985: astore 7
    //   987: aload 8
    //   989: astore_1
    //   990: goto -530 -> 460
    //   993: aconst_null
    //   994: astore 7
    //   996: aconst_null
    //   997: astore 11
    //   999: aconst_null
    //   1000: astore 12
    //   1002: goto -714 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1005	0	this	aeuk
    //   0	1005	1	paramString1	String
    //   0	1005	2	paramString2	String
    //   0	1005	3	paramByte	byte
    //   87	766	4	i	int
    //   53	673	5	j	int
    //   70	717	6	localObject1	Object
    //   793	52	6	localObject2	Object
    //   874	1	6	localObject3	Object
    //   886	1	6	localObject4	Object
    //   902	1	6	localObject5	Object
    //   916	1	6	localObject6	Object
    //   940	19	6	localObject7	Object
    //   963	1	6	localIOException1	java.io.IOException
    //   972	1	6	localIOException2	java.io.IOException
    //   979	1	6	localIOException3	java.io.IOException
    //   1	616	7	str1	String
    //   628	13	7	localException1	java.lang.Exception
    //   683	243	7	localObject8	Object
    //   933	1	7	localException2	java.lang.Exception
    //   945	1	7	localException3	java.lang.Exception
    //   955	1	7	localException4	java.lang.Exception
    //   985	10	7	str2	String
    //   73	328	8	str3	String
    //   448	9	8	localIOException4	java.io.IOException
    //   514	474	8	str4	String
    //   76	767	9	str5	String
    //   80	767	10	localObject9	Object
    //   177	821	11	str6	String
    //   181	820	12	localObject10	Object
    //   103	619	13	arrayOfByte1	byte[]
    //   119	731	14	arrayOfByte2	byte[]
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
    //   523	530	448	java/io/IOException
    //   540	553	448	java/io/IOException
    //   573	579	448	java/io/IOException
    //   589	615	448	java/io/IOException
    //   702	709	448	java/io/IOException
    //   719	736	448	java/io/IOException
    //   756	762	448	java/io/IOException
    //   772	780	448	java/io/IOException
    //   848	857	448	java/io/IOException
    //   469	473	497	java/io/IOException
    //   478	488	497	java/io/IOException
    //   492	496	497	java/io/IOException
    //   82	89	628	java/lang/Exception
    //   99	105	628	java/lang/Exception
    //   115	121	628	java/lang/Exception
    //   131	140	628	java/lang/Exception
    //   150	155	628	java/lang/Exception
    //   165	173	628	java/lang/Exception
    //   193	200	628	java/lang/Exception
    //   238	250	628	java/lang/Exception
    //   260	264	628	java/lang/Exception
    //   274	278	628	java/lang/Exception
    //   344	351	628	java/lang/Exception
    //   361	368	628	java/lang/Exception
    //   393	399	628	java/lang/Exception
    //   409	435	628	java/lang/Exception
    //   523	530	628	java/lang/Exception
    //   540	553	628	java/lang/Exception
    //   573	579	628	java/lang/Exception
    //   589	615	628	java/lang/Exception
    //   702	709	628	java/lang/Exception
    //   719	736	628	java/lang/Exception
    //   756	762	628	java/lang/Exception
    //   772	780	628	java/lang/Exception
    //   848	857	628	java/lang/Exception
    //   650	655	676	java/io/IOException
    //   659	667	676	java/io/IOException
    //   671	675	676	java/io/IOException
    //   82	89	793	finally
    //   99	105	793	finally
    //   115	121	793	finally
    //   131	140	793	finally
    //   150	155	793	finally
    //   165	173	793	finally
    //   193	200	793	finally
    //   238	250	793	finally
    //   260	264	793	finally
    //   274	278	793	finally
    //   344	351	793	finally
    //   361	368	793	finally
    //   393	399	793	finally
    //   409	435	793	finally
    //   523	530	793	finally
    //   540	553	793	finally
    //   573	579	793	finally
    //   589	615	793	finally
    //   640	645	793	finally
    //   702	709	793	finally
    //   719	736	793	finally
    //   756	762	793	finally
    //   772	780	793	finally
    //   848	857	793	finally
    //   293	298	860	java/io/IOException
    //   303	313	860	java/io/IOException
    //   318	323	860	java/io/IOException
    //   809	813	866	java/io/IOException
    //   817	825	866	java/io/IOException
    //   830	835	866	java/io/IOException
    //   28	37	874	finally
    //   37	49	886	finally
    //   49	72	902	finally
    //   460	465	916	finally
    //   28	37	933	java/lang/Exception
    //   37	49	945	java/lang/Exception
    //   49	72	955	java/lang/Exception
    //   28	37	963	java/io/IOException
    //   37	49	972	java/io/IOException
    //   49	72	979	java/io/IOException
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
    //   17: invokestatic 238	bdic:a	(Ljava/io/InputStream;)B
    //   20: istore_2
    //   21: iload_2
    //   22: istore_3
    //   23: aload 4
    //   25: ifnull +10 -> 35
    //   28: aload 4
    //   30: invokevirtual 185	java/io/FileInputStream:close	()V
    //   33: iload_2
    //   34: istore_3
    //   35: iload_3
    //   36: ireturn
    //   37: astore 5
    //   39: aconst_null
    //   40: astore 4
    //   42: aload 4
    //   44: astore_1
    //   45: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +35 -> 83
    //   51: aload 4
    //   53: astore_1
    //   54: ldc 26
    //   56: iconst_2
    //   57: new 195	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   64: ldc 240
    //   66: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 5
    //   71: invokevirtual 243	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   74: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload 4
    //   85: ifnull -50 -> 35
    //   88: aload 4
    //   90: invokevirtual 185	java/io/FileInputStream:close	()V
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
    //   107: invokevirtual 185	java/io/FileInputStream:close	()V
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
    //   0	130	0	this	aeuk
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
  
  public String a(aetx paramaetx, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAetx[paramInt] = paramaetx;
    paramaetx = new StringBuffer();
    paramInt = 0;
    for (;;)
    {
      aetx localaetx;
      if (paramInt < this.jdField_a_of_type_ArrayOfAetx.length)
      {
        localaetx = this.jdField_a_of_type_ArrayOfAetx[paramInt];
        if (localaetx != null) {
          break label42;
        }
      }
      label42:
      do
      {
        return paramaetx.toString();
        paramaetx.append(localaetx.jdField_a_of_type_JavaLangString);
      } while (!localaetx.jdField_a_of_type_Boolean);
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
      this.jdField_a_of_type_Batw.d(this.c, ((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue());
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(aetx paramaetx, int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfAetx == null) || (paramInt >= this.jdField_a_of_type_ArrayOfAetx.length) || ((this.jdField_a_of_type_ArrayOfAetx[paramInt] != null) && (this.jdField_a_of_type_ArrayOfAetx[paramInt].jdField_a_of_type_Boolean)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "updateText fail");
      }
      return;
    }
    this.jdField_a_of_type_Aetw.a(a(paramaetx, paramInt));
  }
  
  public void a(String paramString)
  {
    bfrq.a(new VoiceTextEdtiController.2(this, paramString));
  }
  
  public void a(String paramString1, QQAppInterface paramQQAppInterface, aetw paramaetw, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.jdField_a_of_type_Aetw = paramaetw;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString2;
    if (paramInt == 3000) {
      this.jdField_a_of_type_Int = 1;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_a_of_type_Baua = new aeul(this);
    this.jdField_a_of_type_Baua.addFilter(new Class[] { barl.class });
  }
  
  public void b()
  {
    a();
  }
  
  public void b(String paramString)
  {
    bfrq.a(new VoiceTextEdtiController.3(this, paramString));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Batw != null) {
      this.jdField_a_of_type_Batw.b(this.jdField_a_of_type_Baua);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeuk
 * JD-Core Version:    0.7.0.1
 */