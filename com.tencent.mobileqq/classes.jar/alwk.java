public class alwk
{
  private static alwk a;
  public float a;
  public int a;
  public long a;
  public String a;
  public zia a;
  public boolean a;
  public float b;
  public long b;
  private String b;
  public boolean b;
  public float c;
  public boolean c;
  public float d;
  public boolean d;
  public boolean e;
  public boolean f;
  
  /* Error */
  private alwk()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 23	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 25
    //   7: putfield 27	alwk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: bipush 15
    //   13: putfield 29	alwk:jdField_a_of_type_Int	I
    //   16: aload_0
    //   17: ldc2_w 30
    //   20: putfield 33	alwk:jdField_a_of_type_Long	J
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 35	alwk:jdField_b_of_type_Boolean	Z
    //   28: aload_0
    //   29: ldc 36
    //   31: putfield 38	alwk:jdField_b_of_type_Float	F
    //   34: aload_0
    //   35: ldc 36
    //   37: putfield 40	alwk:jdField_c_of_type_Float	F
    //   40: aload_0
    //   41: ldc 42
    //   43: putfield 44	alwk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 46	alwk:e	Z
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 48	alwk:f	Z
    //   56: aload_0
    //   57: ldc 49
    //   59: putfield 51	alwk:jdField_d_of_type_Float	F
    //   62: aload_0
    //   63: ldc2_w 52
    //   66: putfield 55	alwk:jdField_b_of_type_Long	J
    //   69: invokestatic 60	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   72: astore 4
    //   74: aload 4
    //   76: getstatic 66	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:new_memory_strategy	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   79: invokevirtual 70	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   82: invokevirtual 73	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 5
    //   87: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +29 -> 119
    //   93: ldc 81
    //   95: iconst_2
    //   96: new 83	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   103: ldc 86
    //   105: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 5
    //   110: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_0
    //   120: new 98	zia
    //   123: dup
    //   124: ldc 100
    //   126: invokespecial 103	zia:<init>	(Ljava/lang/String;)V
    //   129: putfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   132: aload_0
    //   133: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   136: iconst_1
    //   137: putfield 107	zia:jdField_a_of_type_Boolean	Z
    //   140: invokestatic 113	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   143: ldc 115
    //   145: iconst_4
    //   146: invokevirtual 119	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   149: astore 6
    //   151: aload 6
    //   153: aload_0
    //   154: getfield 44	alwk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   157: iconst_m1
    //   158: invokeinterface 125 3 0
    //   163: istore_2
    //   164: iload_2
    //   165: istore_1
    //   166: iload_2
    //   167: iconst_m1
    //   168: if_icmpne +55 -> 223
    //   171: new 127	java/util/Random
    //   174: dup
    //   175: invokespecial 128	java/util/Random:<init>	()V
    //   178: sipush 1000
    //   181: invokevirtual 132	java/util/Random:nextInt	(I)I
    //   184: istore_1
    //   185: aload 6
    //   187: invokeinterface 136 1 0
    //   192: astore 6
    //   194: aload 6
    //   196: aload_0
    //   197: getfield 44	alwk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   200: iload_1
    //   201: invokeinterface 142 3 0
    //   206: pop
    //   207: getstatic 147	android/os/Build$VERSION:SDK_INT	I
    //   210: bipush 9
    //   212: if_icmpge +63 -> 275
    //   215: aload 6
    //   217: invokeinterface 150 1 0
    //   222: pop
    //   223: aload_0
    //   224: iconst_0
    //   225: putfield 152	alwk:jdField_c_of_type_Boolean	Z
    //   228: iload_1
    //   229: iconst_2
    //   230: irem
    //   231: ifne +8 -> 239
    //   234: aload_0
    //   235: iconst_1
    //   236: putfield 152	alwk:jdField_c_of_type_Boolean	Z
    //   239: ldc 153
    //   241: f2d
    //   242: invokestatic 159	java/lang/Math:random	()D
    //   245: dcmpl
    //   246: iflt +39 -> 285
    //   249: iconst_1
    //   250: istore_3
    //   251: aload_0
    //   252: iload_3
    //   253: putfield 161	alwk:jdField_d_of_type_Boolean	Z
    //   256: aload 5
    //   258: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   261: ifne +13 -> 274
    //   264: aload 5
    //   266: ldc 169
    //   268: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifeq +19 -> 290
    //   274: return
    //   275: aload 6
    //   277: invokeinterface 178 1 0
    //   282: goto -59 -> 223
    //   285: iconst_0
    //   286: istore_3
    //   287: goto -36 -> 251
    //   290: aload 5
    //   292: ldc 180
    //   294: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   297: astore 5
    //   299: aload 5
    //   301: arraylength
    //   302: iconst_1
    //   303: if_icmple +612 -> 915
    //   306: aload 5
    //   308: aload 4
    //   310: getfield 185	com/tencent/mobileqq/app/DeviceProfileManager:jdField_a_of_type_Int	I
    //   313: aload 5
    //   315: arraylength
    //   316: irem
    //   317: aaload
    //   318: astore 4
    //   320: aload 4
    //   322: ldc 187
    //   324: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   327: astore 4
    //   329: aload 4
    //   331: arraylength
    //   332: bipush 7
    //   334: if_icmplt -60 -> 274
    //   337: aload 4
    //   339: iconst_1
    //   340: aaload
    //   341: ldc 189
    //   343: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   346: astore 5
    //   348: aload 5
    //   350: iconst_0
    //   351: aaload
    //   352: ldc 191
    //   354: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   357: ifeq +47 -> 404
    //   360: aload_0
    //   361: iconst_1
    //   362: putfield 192	alwk:jdField_a_of_type_Boolean	Z
    //   365: aload_0
    //   366: aload 5
    //   368: iconst_1
    //   369: aaload
    //   370: invokestatic 198	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   373: putfield 29	alwk:jdField_a_of_type_Int	I
    //   376: aload_0
    //   377: getfield 29	alwk:jdField_a_of_type_Int	I
    //   380: bipush 50
    //   382: if_icmple +9 -> 391
    //   385: aload_0
    //   386: bipush 50
    //   388: putfield 29	alwk:jdField_a_of_type_Int	I
    //   391: aload_0
    //   392: getfield 29	alwk:jdField_a_of_type_Int	I
    //   395: iconst_1
    //   396: if_icmpge +8 -> 404
    //   399: aload_0
    //   400: iconst_1
    //   401: putfield 29	alwk:jdField_a_of_type_Int	I
    //   404: aload_0
    //   405: aload 4
    //   407: iconst_2
    //   408: aaload
    //   409: putfield 27	alwk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   412: aload_0
    //   413: aload 4
    //   415: iconst_4
    //   416: aaload
    //   417: invokestatic 204	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   420: invokevirtual 208	java/lang/Float:floatValue	()F
    //   423: putfield 210	alwk:jdField_a_of_type_Float	F
    //   426: aload_0
    //   427: getfield 210	alwk:jdField_a_of_type_Float	F
    //   430: fconst_1
    //   431: fcmpl
    //   432: ifle +8 -> 440
    //   435: aload_0
    //   436: fconst_1
    //   437: putfield 210	alwk:jdField_a_of_type_Float	F
    //   440: aload_0
    //   441: aload 4
    //   443: bipush 6
    //   445: aaload
    //   446: invokestatic 214	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   449: putfield 38	alwk:jdField_b_of_type_Float	F
    //   452: aload 4
    //   454: arraylength
    //   455: istore_1
    //   456: iload_1
    //   457: bipush 9
    //   459: if_icmplt +316 -> 775
    //   462: aload 4
    //   464: bipush 8
    //   466: aaload
    //   467: ldc 189
    //   469: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   472: astore 5
    //   474: aload 5
    //   476: arraylength
    //   477: iconst_5
    //   478: if_icmplt +297 -> 775
    //   481: aload_0
    //   482: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   485: ifnonnull +460 -> 945
    //   488: aload_0
    //   489: new 98	zia
    //   492: dup
    //   493: aload_0
    //   494: getfield 27	alwk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   497: invokespecial 103	zia:<init>	(Ljava/lang/String;)V
    //   500: putfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   503: aload 5
    //   505: iconst_0
    //   506: aaload
    //   507: ldc 191
    //   509: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   512: ifeq +457 -> 969
    //   515: aload_0
    //   516: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   519: iconst_1
    //   520: putfield 107	zia:jdField_a_of_type_Boolean	Z
    //   523: aload_0
    //   524: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   527: aload 5
    //   529: iconst_1
    //   530: aaload
    //   531: invokestatic 198	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   534: putfield 216	zia:b	I
    //   537: aload 5
    //   539: iconst_2
    //   540: aaload
    //   541: ldc 218
    //   543: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   546: astore 6
    //   548: aload 6
    //   550: arraylength
    //   551: iconst_4
    //   552: if_icmplt +53 -> 605
    //   555: new 220	zib
    //   558: dup
    //   559: aload 6
    //   561: iconst_0
    //   562: aaload
    //   563: invokestatic 198	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   566: aload 6
    //   568: iconst_1
    //   569: aaload
    //   570: invokestatic 198	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   573: aload 6
    //   575: iconst_2
    //   576: aaload
    //   577: invokestatic 214	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   580: aload 6
    //   582: iconst_3
    //   583: aaload
    //   584: invokestatic 214	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   587: invokespecial 223	zib:<init>	(IIFF)V
    //   590: astore 6
    //   592: aload_0
    //   593: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   596: getfield 226	zia:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   599: iconst_1
    //   600: aload 6
    //   602: invokevirtual 232	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   605: aload 5
    //   607: iconst_3
    //   608: aaload
    //   609: ldc 218
    //   611: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   614: astore 6
    //   616: aload 6
    //   618: arraylength
    //   619: iconst_4
    //   620: if_icmplt +53 -> 673
    //   623: new 220	zib
    //   626: dup
    //   627: aload 6
    //   629: iconst_0
    //   630: aaload
    //   631: invokestatic 198	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   634: aload 6
    //   636: iconst_1
    //   637: aaload
    //   638: invokestatic 198	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   641: aload 6
    //   643: iconst_2
    //   644: aaload
    //   645: invokestatic 214	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   648: aload 6
    //   650: iconst_3
    //   651: aaload
    //   652: invokestatic 214	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   655: invokespecial 223	zib:<init>	(IIFF)V
    //   658: astore 6
    //   660: aload_0
    //   661: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   664: getfield 226	zia:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   667: iconst_2
    //   668: aload 6
    //   670: invokevirtual 232	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   673: aload 5
    //   675: iconst_4
    //   676: aaload
    //   677: ldc 218
    //   679: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   682: astore 5
    //   684: aload 5
    //   686: arraylength
    //   687: iconst_4
    //   688: if_icmplt +53 -> 741
    //   691: new 220	zib
    //   694: dup
    //   695: aload 5
    //   697: iconst_0
    //   698: aaload
    //   699: invokestatic 198	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   702: aload 5
    //   704: iconst_1
    //   705: aaload
    //   706: invokestatic 198	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   709: aload 5
    //   711: iconst_2
    //   712: aaload
    //   713: invokestatic 214	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   716: aload 5
    //   718: iconst_3
    //   719: aaload
    //   720: invokestatic 214	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   723: invokespecial 223	zib:<init>	(IIFF)V
    //   726: astore 5
    //   728: aload_0
    //   729: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   732: getfield 226	zia:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   735: iconst_3
    //   736: aload 5
    //   738: invokevirtual 232	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   741: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   744: ifeq +31 -> 775
    //   747: ldc 81
    //   749: iconst_2
    //   750: new 83	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   757: ldc 234
    //   759: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_0
    //   763: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   766: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload 4
    //   777: arraylength
    //   778: bipush 10
    //   780: if_icmplt +21 -> 801
    //   783: ldc 191
    //   785: aload 4
    //   787: bipush 9
    //   789: aaload
    //   790: invokevirtual 241	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   793: ifeq +276 -> 1069
    //   796: aload_0
    //   797: iconst_1
    //   798: putfield 48	alwk:f	Z
    //   801: aload 4
    //   803: arraylength
    //   804: bipush 11
    //   806: if_icmplt +44 -> 850
    //   809: aload 4
    //   811: bipush 10
    //   813: aaload
    //   814: ldc 189
    //   816: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   819: astore 5
    //   821: aload 5
    //   823: arraylength
    //   824: iconst_2
    //   825: if_icmplt +25 -> 850
    //   828: aload_0
    //   829: aload 5
    //   831: iconst_0
    //   832: aaload
    //   833: invokestatic 214	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   836: putfield 51	alwk:jdField_d_of_type_Float	F
    //   839: aload_0
    //   840: aload 5
    //   842: iconst_1
    //   843: aaload
    //   844: invokestatic 247	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   847: putfield 55	alwk:jdField_b_of_type_Long	J
    //   850: aload 4
    //   852: arraylength
    //   853: bipush 12
    //   855: if_icmplt +21 -> 876
    //   858: ldc 191
    //   860: aload 4
    //   862: bipush 11
    //   864: aaload
    //   865: invokevirtual 241	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   868: ifeq +209 -> 1077
    //   871: aload_0
    //   872: iconst_1
    //   873: putfield 46	alwk:e	Z
    //   876: aload_0
    //   877: getfield 48	alwk:f	Z
    //   880: ifeq +205 -> 1085
    //   883: aload_0
    //   884: getfield 46	alwk:e	Z
    //   887: ifne -613 -> 274
    //   890: aload_0
    //   891: iconst_1
    //   892: putfield 152	alwk:jdField_c_of_type_Boolean	Z
    //   895: return
    //   896: astore 4
    //   898: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   901: ifeq -627 -> 274
    //   904: ldc 81
    //   906: iconst_2
    //   907: ldc 249
    //   909: aload 4
    //   911: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   914: return
    //   915: aload 5
    //   917: iconst_0
    //   918: aaload
    //   919: astore 4
    //   921: goto -601 -> 320
    //   924: astore 5
    //   926: aload_0
    //   927: fconst_0
    //   928: putfield 210	alwk:jdField_a_of_type_Float	F
    //   931: goto -491 -> 440
    //   934: astore 5
    //   936: aload_0
    //   937: ldc 153
    //   939: putfield 38	alwk:jdField_b_of_type_Float	F
    //   942: goto -490 -> 452
    //   945: aload_0
    //   946: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   949: aload_0
    //   950: getfield 27	alwk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   953: putfield 253	zia:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   956: goto -453 -> 503
    //   959: astore 5
    //   961: aload 5
    //   963: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   966: goto -191 -> 775
    //   969: aload 5
    //   971: iconst_0
    //   972: aaload
    //   973: ldc 169
    //   975: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   978: ifeq +14 -> 992
    //   981: aload_0
    //   982: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   985: iconst_0
    //   986: putfield 107	zia:jdField_a_of_type_Boolean	Z
    //   989: goto -466 -> 523
    //   992: getstatic 259	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   995: iconst_1
    //   996: if_icmpne +14 -> 1010
    //   999: aload_0
    //   1000: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   1003: iconst_1
    //   1004: putfield 107	zia:jdField_a_of_type_Boolean	Z
    //   1007: goto -484 -> 523
    //   1010: aload 5
    //   1012: iconst_0
    //   1013: aaload
    //   1014: ldc_w 261
    //   1017: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1020: ifeq +14 -> 1034
    //   1023: aload_0
    //   1024: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   1027: iconst_1
    //   1028: putfield 107	zia:jdField_a_of_type_Boolean	Z
    //   1031: goto -508 -> 523
    //   1034: aload 5
    //   1036: iconst_0
    //   1037: aaload
    //   1038: ldc_w 263
    //   1041: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1044: ifeq +14 -> 1058
    //   1047: aload_0
    //   1048: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   1051: iconst_0
    //   1052: putfield 107	zia:jdField_a_of_type_Boolean	Z
    //   1055: goto -532 -> 523
    //   1058: aload_0
    //   1059: getfield 105	alwk:jdField_a_of_type_Zia	Lzia;
    //   1062: iconst_1
    //   1063: putfield 107	zia:jdField_a_of_type_Boolean	Z
    //   1066: goto -543 -> 523
    //   1069: aload_0
    //   1070: iconst_0
    //   1071: putfield 48	alwk:f	Z
    //   1074: goto -273 -> 801
    //   1077: aload_0
    //   1078: iconst_0
    //   1079: putfield 46	alwk:e	Z
    //   1082: goto -206 -> 876
    //   1085: aload_0
    //   1086: iconst_0
    //   1087: putfield 152	alwk:jdField_c_of_type_Boolean	Z
    //   1090: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1091	0	this	alwk
    //   165	295	1	i	int
    //   163	6	2	j	int
    //   250	37	3	bool	boolean
    //   72	789	4	localObject1	Object
    //   896	14	4	localException1	java.lang.Exception
    //   919	1	4	localObject2	Object
    //   85	831	5	localObject3	Object
    //   924	1	5	localException2	java.lang.Exception
    //   934	1	5	localException3	java.lang.Exception
    //   959	76	5	localException4	java.lang.Exception
    //   149	520	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   320	391	896	java/lang/Exception
    //   391	404	896	java/lang/Exception
    //   404	412	896	java/lang/Exception
    //   452	456	896	java/lang/Exception
    //   775	801	896	java/lang/Exception
    //   801	850	896	java/lang/Exception
    //   850	876	896	java/lang/Exception
    //   876	895	896	java/lang/Exception
    //   926	931	896	java/lang/Exception
    //   936	942	896	java/lang/Exception
    //   961	966	896	java/lang/Exception
    //   1069	1074	896	java/lang/Exception
    //   1077	1082	896	java/lang/Exception
    //   1085	1090	896	java/lang/Exception
    //   412	440	924	java/lang/Exception
    //   440	452	934	java/lang/Exception
    //   462	503	959	java/lang/Exception
    //   503	523	959	java/lang/Exception
    //   523	605	959	java/lang/Exception
    //   605	673	959	java/lang/Exception
    //   673	741	959	java/lang/Exception
    //   741	775	959	java/lang/Exception
    //   945	956	959	java/lang/Exception
    //   969	989	959	java/lang/Exception
    //   992	1007	959	java/lang/Exception
    //   1010	1031	959	java/lang/Exception
    //   1034	1055	959	java/lang/Exception
    //   1058	1066	959	java/lang/Exception
  }
  
  public static alwk a()
  {
    if (jdField_a_of_type_Alwk == null) {}
    try
    {
      if (jdField_a_of_type_Alwk == null) {
        jdField_a_of_type_Alwk = new alwk();
      }
      return jdField_a_of_type_Alwk;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alwk
 * JD-Core Version:    0.7.0.1
 */