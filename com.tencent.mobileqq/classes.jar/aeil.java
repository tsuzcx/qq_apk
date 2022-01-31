import android.os.AsyncTask;
import java.util.ArrayList;

class aeil
  extends AsyncTask<Integer, Integer, Integer>
{
  int jdField_a_of_type_Int;
  aeiy jdField_a_of_type_Aeiy;
  boolean jdField_a_of_type_Boolean = true;
  aeiy[] jdField_a_of_type_ArrayOfAeiy;
  
  public aeil(ArrayList<aeiy> paramArrayList)
  {
    Object localObject;
    this.jdField_a_of_type_ArrayOfAeiy = ((aeiy[])localObject.toArray(new aeiy[0]));
  }
  
  /* Error */
  protected Integer a(Integer... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +1135 -> 1138
    //   6: ldc 47
    //   8: iconst_2
    //   9: new 49	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   16: ldc 52
    //   18: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: goto +1107 -> 1138
    //   34: iload_3
    //   35: aload_1
    //   36: arraylength
    //   37: if_icmpge +1088 -> 1125
    //   40: aload_1
    //   41: iload_3
    //   42: aaload
    //   43: invokevirtual 73	java/lang/Integer:intValue	()I
    //   46: istore 4
    //   48: aload_0
    //   49: getfield 20	aeil:jdField_a_of_type_Boolean	Z
    //   52: ifne +8 -> 60
    //   55: iconst_1
    //   56: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: areturn
    //   60: aload_0
    //   61: iconst_1
    //   62: anewarray 69	java/lang/Integer
    //   65: dup
    //   66: iconst_0
    //   67: iload_3
    //   68: bipush 100
    //   70: imul
    //   71: aload_1
    //   72: arraylength
    //   73: idiv
    //   74: ldc 78
    //   76: iand
    //   77: iload 4
    //   79: bipush 16
    //   81: ishl
    //   82: ior
    //   83: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: aastore
    //   87: invokevirtual 82	aeil:publishProgress	([Ljava/lang/Object;)V
    //   90: iload 4
    //   92: tableswitch	default:+1053 -> 1145, 0:+1060->1152, 1:+413->505, 2:+1060->1152
    //   121: aload_0
    //   122: getfield 31	aeil:jdField_a_of_type_ArrayOfAeiy	[Laeiy;
    //   125: arraylength
    //   126: if_icmpge +1038 -> 1164
    //   129: aload_0
    //   130: getfield 20	aeil:jdField_a_of_type_Boolean	Z
    //   133: ifne +8 -> 141
    //   136: iconst_1
    //   137: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: areturn
    //   141: aload_0
    //   142: iconst_1
    //   143: anewarray 69	java/lang/Integer
    //   146: dup
    //   147: iconst_0
    //   148: iload_3
    //   149: bipush 100
    //   151: imul
    //   152: aload_1
    //   153: arraylength
    //   154: idiv
    //   155: iload_2
    //   156: bipush 100
    //   158: imul
    //   159: aload_1
    //   160: arraylength
    //   161: idiv
    //   162: aload_0
    //   163: getfield 31	aeil:jdField_a_of_type_ArrayOfAeiy	[Laeiy;
    //   166: arraylength
    //   167: idiv
    //   168: iadd
    //   169: ldc 78
    //   171: iand
    //   172: iload 4
    //   174: bipush 16
    //   176: ishl
    //   177: ior
    //   178: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aastore
    //   182: invokevirtual 82	aeil:publishProgress	([Ljava/lang/Object;)V
    //   185: aload_0
    //   186: getfield 31	aeil:jdField_a_of_type_ArrayOfAeiy	[Laeiy;
    //   189: iload_2
    //   190: aaload
    //   191: astore 8
    //   193: ldc 84
    //   195: aload 8
    //   197: getfield 87	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   200: invokevirtual 93	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   203: ifeq +289 -> 492
    //   206: aload 8
    //   208: getfield 87	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   211: checkcast 84	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   214: astore 7
    //   216: aload 7
    //   218: getfield 97	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   221: astore 9
    //   223: ldc 99
    //   225: aload 9
    //   227: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +6 -> 236
    //   233: goto +924 -> 1157
    //   236: aload_0
    //   237: aload 8
    //   239: putfield 106	aeil:jdField_a_of_type_Aeiy	Laeiy;
    //   242: aload_0
    //   243: getfield 20	aeil:jdField_a_of_type_Boolean	Z
    //   246: ifeq +164 -> 410
    //   249: aload 9
    //   251: ifnull +18 -> 269
    //   254: new 108	java/io/File
    //   257: dup
    //   258: aload 9
    //   260: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   263: invokevirtual 114	java/io/File:exists	()Z
    //   266: ifne +144 -> 410
    //   269: aload_0
    //   270: getfield 106	aeil:jdField_a_of_type_Aeiy	Laeiy;
    //   273: iconst_1
    //   274: putfield 115	aeiy:jdField_a_of_type_Boolean	Z
    //   277: aload_0
    //   278: getfield 15	aeil:jdField_a_of_type_Aeid	Laeid;
    //   281: getfield 120	aeid:jdField_a_of_type_Aejb	Laejb;
    //   284: aload 7
    //   286: getfield 124	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Long	J
    //   289: aload 7
    //   291: getfield 126	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_f_of_type_Int	I
    //   294: iconst_2
    //   295: invokeinterface 131 5 0
    //   300: aload_0
    //   301: getfield 106	aeil:jdField_a_of_type_Aeiy	Laeiy;
    //   304: astore 8
    //   306: aload 8
    //   308: monitorenter
    //   309: aload_0
    //   310: getfield 106	aeil:jdField_a_of_type_Aeiy	Laeiy;
    //   313: getfield 115	aeiy:jdField_a_of_type_Boolean	Z
    //   316: ifeq +10 -> 326
    //   319: aload_0
    //   320: getfield 106	aeil:jdField_a_of_type_Aeiy	Laeiy;
    //   323: invokevirtual 136	java/lang/Object:wait	()V
    //   326: aload 8
    //   328: monitorexit
    //   329: aload 7
    //   331: getfield 138	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_Boolean	Z
    //   334: ifeq +76 -> 410
    //   337: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +41 -> 381
    //   343: ldc 47
    //   345: iconst_2
    //   346: new 49	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   353: ldc 140
    //   355: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload_2
    //   359: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 145
    //   364: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 7
    //   369: getfield 97	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   372: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload_0
    //   382: aload_0
    //   383: getfield 31	aeil:jdField_a_of_type_ArrayOfAeiy	[Laeiy;
    //   386: arraylength
    //   387: iload_2
    //   388: isub
    //   389: putfield 147	aeil:jdField_a_of_type_Int	I
    //   392: bipush 11
    //   394: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: areturn
    //   398: astore_1
    //   399: aload 8
    //   401: monitorexit
    //   402: aload_1
    //   403: athrow
    //   404: astore_1
    //   405: iconst_2
    //   406: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   409: areturn
    //   410: aload_0
    //   411: getfield 20	aeil:jdField_a_of_type_Boolean	Z
    //   414: ifne +8 -> 422
    //   417: iconst_1
    //   418: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: areturn
    //   422: aload 7
    //   424: iconst_2
    //   425: invokevirtual 150	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   428: ifnonnull +729 -> 1157
    //   431: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +41 -> 475
    //   437: ldc 47
    //   439: iconst_2
    //   440: new 49	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   447: ldc 152
    //   449: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: iload_2
    //   453: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   456: ldc 145
    //   458: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 7
    //   463: getfield 97	com/tencent/mobileqq/activity/aio/photo/AIOImageData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   466: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: aload_0
    //   476: aload_0
    //   477: getfield 31	aeil:jdField_a_of_type_ArrayOfAeiy	[Laeiy;
    //   480: arraylength
    //   481: iload_2
    //   482: isub
    //   483: putfield 147	aeil:jdField_a_of_type_Int	I
    //   486: bipush 11
    //   488: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   491: areturn
    //   492: ldc 154
    //   494: aload 8
    //   496: invokevirtual 93	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   499: ifeq +658 -> 1157
    //   502: goto +655 -> 1157
    //   505: invokestatic 159	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   508: ldc 161
    //   510: invokevirtual 165	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   513: ifne +23 -> 536
    //   516: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +11 -> 530
    //   522: ldc 47
    //   524: iconst_2
    //   525: ldc 167
    //   527: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   530: bipush 23
    //   532: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   535: areturn
    //   536: new 108	java/io/File
    //   539: dup
    //   540: getstatic 172	ajsd:bc	Ljava/lang/String;
    //   543: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   546: astore 9
    //   548: aload 9
    //   550: invokevirtual 114	java/io/File:exists	()Z
    //   553: ifne +629 -> 1182
    //   556: aload 9
    //   558: invokevirtual 175	java/io/File:mkdirs	()Z
    //   561: pop
    //   562: goto +620 -> 1182
    //   565: iload_2
    //   566: aload_0
    //   567: getfield 31	aeil:jdField_a_of_type_ArrayOfAeiy	[Laeiy;
    //   570: arraylength
    //   571: if_icmpge +537 -> 1108
    //   574: aload_0
    //   575: getfield 31	aeil:jdField_a_of_type_ArrayOfAeiy	[Laeiy;
    //   578: iload_2
    //   579: aaload
    //   580: astore 7
    //   582: aload_0
    //   583: getfield 20	aeil:jdField_a_of_type_Boolean	Z
    //   586: ifne +8 -> 594
    //   589: iconst_1
    //   590: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   593: areturn
    //   594: ldc 84
    //   596: aload 7
    //   598: getfield 87	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   601: invokevirtual 93	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   604: ifeq +222 -> 826
    //   607: aload 7
    //   609: getfield 87	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   612: checkcast 84	com/tencent/mobileqq/activity/aio/photo/AIOImageData
    //   615: astore 7
    //   617: aload_0
    //   618: iconst_1
    //   619: anewarray 69	java/lang/Integer
    //   622: dup
    //   623: iconst_0
    //   624: iload_3
    //   625: bipush 100
    //   627: imul
    //   628: aload_1
    //   629: arraylength
    //   630: idiv
    //   631: iload_2
    //   632: bipush 100
    //   634: imul
    //   635: aload_1
    //   636: arraylength
    //   637: idiv
    //   638: aload_0
    //   639: getfield 31	aeil:jdField_a_of_type_ArrayOfAeiy	[Laeiy;
    //   642: arraylength
    //   643: idiv
    //   644: iadd
    //   645: ldc 78
    //   647: iand
    //   648: iload 4
    //   650: bipush 16
    //   652: ishl
    //   653: ior
    //   654: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   657: aastore
    //   658: invokevirtual 82	aeil:publishProgress	([Ljava/lang/Object;)V
    //   661: aload 7
    //   663: iconst_2
    //   664: invokevirtual 150	com/tencent/mobileqq/activity/aio/photo/AIOImageData:a	(I)Ljava/io/File;
    //   667: astore 7
    //   669: aload 7
    //   671: ifnull +516 -> 1187
    //   674: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   677: invokestatic 185	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   680: lstore 5
    //   682: aload 7
    //   684: invokevirtual 189	java/io/File:length	()J
    //   687: lload 5
    //   689: lcmp
    //   690: ifle +23 -> 713
    //   693: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   696: ifeq +11 -> 707
    //   699: ldc 47
    //   701: iconst_2
    //   702: ldc 191
    //   704: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: bipush 22
    //   709: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   712: areturn
    //   713: new 108	java/io/File
    //   716: dup
    //   717: aload 9
    //   719: new 49	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   726: aload 7
    //   728: invokevirtual 194	java/io/File:getName	()Ljava/lang/String;
    //   731: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: ldc 196
    //   736: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokespecial 199	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   745: astore 8
    //   747: aload 7
    //   749: aload 8
    //   751: invokestatic 204	gp:a	(Ljava/io/File;Ljava/io/File;)Z
    //   754: ifne +54 -> 808
    //   757: invokestatic 159	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   760: ldc 161
    //   762: invokevirtual 165	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   765: ifne +23 -> 788
    //   768: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   771: ifeq +11 -> 782
    //   774: ldc 47
    //   776: iconst_2
    //   777: ldc 206
    //   779: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: bipush 24
    //   784: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   787: areturn
    //   788: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   791: ifeq +11 -> 802
    //   794: ldc 47
    //   796: iconst_2
    //   797: ldc 208
    //   799: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   802: bipush 21
    //   804: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   807: areturn
    //   808: aload_0
    //   809: getfield 15	aeil:jdField_a_of_type_Aeid	Laeid;
    //   812: invokestatic 211	aeid:a	(Laeid;)Landroid/app/Activity;
    //   815: aload 8
    //   817: invokevirtual 214	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   820: invokestatic 219	bbef:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   823: goto +364 -> 1187
    //   826: ldc 221
    //   828: aload 7
    //   830: getfield 87	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   833: invokevirtual 93	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   836: ifeq +259 -> 1095
    //   839: aload 7
    //   841: getfield 87	aeiy:jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData	Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   844: checkcast 221	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   847: astore 10
    //   849: aload_0
    //   850: iconst_1
    //   851: anewarray 69	java/lang/Integer
    //   854: dup
    //   855: iconst_0
    //   856: iload_3
    //   857: bipush 100
    //   859: imul
    //   860: aload_1
    //   861: arraylength
    //   862: idiv
    //   863: iload_2
    //   864: bipush 100
    //   866: imul
    //   867: aload_1
    //   868: arraylength
    //   869: idiv
    //   870: aload_0
    //   871: getfield 31	aeil:jdField_a_of_type_ArrayOfAeiy	[Laeiy;
    //   874: arraylength
    //   875: idiv
    //   876: iadd
    //   877: ldc 78
    //   879: iand
    //   880: iload 4
    //   882: bipush 16
    //   884: ishl
    //   885: ior
    //   886: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   889: aastore
    //   890: invokevirtual 82	aeil:publishProgress	([Ljava/lang/Object;)V
    //   893: aload 10
    //   895: bipush 20
    //   897: invokevirtual 222	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   900: astore 8
    //   902: aload 8
    //   904: astore 7
    //   906: aload 8
    //   908: ifnonnull +227 -> 1135
    //   911: aload 10
    //   913: bipush 18
    //   915: invokevirtual 222	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   918: astore 8
    //   920: aload 8
    //   922: astore 7
    //   924: aload 8
    //   926: ifnonnull +209 -> 1135
    //   929: aload 10
    //   931: bipush 16
    //   933: invokevirtual 222	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:a	(I)Ljava/io/File;
    //   936: astore 7
    //   938: aload 7
    //   940: ifnull +247 -> 1187
    //   943: invokestatic 179	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   946: invokestatic 185	com/tencent/image/Utils:getUsableSpace	(Ljava/io/File;)J
    //   949: lstore 5
    //   951: aload 7
    //   953: invokevirtual 189	java/io/File:length	()J
    //   956: lload 5
    //   958: lcmp
    //   959: ifle +23 -> 982
    //   962: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   965: ifeq +11 -> 976
    //   968: ldc 47
    //   970: iconst_2
    //   971: ldc 191
    //   973: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: bipush 22
    //   978: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   981: areturn
    //   982: new 108	java/io/File
    //   985: dup
    //   986: aload 9
    //   988: new 49	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   995: aload 7
    //   997: invokevirtual 194	java/io/File:getName	()Ljava/lang/String;
    //   1000: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: ldc 196
    //   1005: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokespecial 199	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1014: astore 8
    //   1016: aload 7
    //   1018: aload 8
    //   1020: invokestatic 204	gp:a	(Ljava/io/File;Ljava/io/File;)Z
    //   1023: ifne +54 -> 1077
    //   1026: invokestatic 159	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   1029: ldc 161
    //   1031: invokevirtual 165	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1034: ifne +23 -> 1057
    //   1037: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1040: ifeq +11 -> 1051
    //   1043: ldc 47
    //   1045: iconst_2
    //   1046: ldc 206
    //   1048: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1051: bipush 24
    //   1053: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1056: areturn
    //   1057: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq +11 -> 1071
    //   1063: ldc 47
    //   1065: iconst_2
    //   1066: ldc 208
    //   1068: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1071: bipush 21
    //   1073: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1076: areturn
    //   1077: aload_0
    //   1078: getfield 15	aeil:jdField_a_of_type_Aeid	Laeid;
    //   1081: invokestatic 224	aeid:b	(Laeid;)Landroid/app/Activity;
    //   1084: aload 8
    //   1086: invokevirtual 214	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1089: invokestatic 219	bbef:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   1092: goto +95 -> 1187
    //   1095: ldc 154
    //   1097: aload 7
    //   1099: invokevirtual 93	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   1102: ifeq +85 -> 1187
    //   1105: goto +82 -> 1187
    //   1108: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1111: ifeq +83 -> 1194
    //   1114: ldc 47
    //   1116: iconst_2
    //   1117: ldc 226
    //   1119: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: goto +72 -> 1194
    //   1125: iload_2
    //   1126: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1129: areturn
    //   1130: astore 9
    //   1132: goto -806 -> 326
    //   1135: goto -192 -> 943
    //   1138: iconst_0
    //   1139: istore_3
    //   1140: iconst_0
    //   1141: istore_2
    //   1142: goto -1108 -> 34
    //   1145: iload_3
    //   1146: iconst_1
    //   1147: iadd
    //   1148: istore_3
    //   1149: goto -1115 -> 34
    //   1152: iconst_0
    //   1153: istore_2
    //   1154: goto -1034 -> 120
    //   1157: iload_2
    //   1158: iconst_1
    //   1159: iadd
    //   1160: istore_2
    //   1161: goto -1041 -> 120
    //   1164: iload 4
    //   1166: iconst_2
    //   1167: if_icmpne +9 -> 1176
    //   1170: bipush 30
    //   1172: istore_2
    //   1173: goto -28 -> 1145
    //   1176: bipush 10
    //   1178: istore_2
    //   1179: goto -34 -> 1145
    //   1182: iconst_0
    //   1183: istore_2
    //   1184: goto -619 -> 565
    //   1187: iload_2
    //   1188: iconst_1
    //   1189: iadd
    //   1190: istore_2
    //   1191: goto -626 -> 565
    //   1194: bipush 20
    //   1196: istore_2
    //   1197: goto -52 -> 1145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1200	0	this	aeil
    //   0	1200	1	paramVarArgs	Integer[]
    //   120	1077	2	i	int
    //   34	1115	3	j	int
    //   46	1122	4	k	int
    //   680	277	5	l	long
    //   214	884	7	localObject1	Object
    //   221	766	9	localObject3	Object
    //   1130	1	9	localInterruptedException	java.lang.InterruptedException
    //   847	83	10	localAIOFilePicData	com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
    // Exception table:
    //   from	to	target	type
    //   309	326	398	finally
    //   326	329	398	finally
    //   399	402	398	finally
    //   0	31	404	java/lang/Throwable
    //   34	60	404	java/lang/Throwable
    //   60	90	404	java/lang/Throwable
    //   120	141	404	java/lang/Throwable
    //   141	233	404	java/lang/Throwable
    //   236	249	404	java/lang/Throwable
    //   254	269	404	java/lang/Throwable
    //   269	309	404	java/lang/Throwable
    //   329	381	404	java/lang/Throwable
    //   381	392	404	java/lang/Throwable
    //   402	404	404	java/lang/Throwable
    //   410	422	404	java/lang/Throwable
    //   422	475	404	java/lang/Throwable
    //   475	492	404	java/lang/Throwable
    //   492	502	404	java/lang/Throwable
    //   505	530	404	java/lang/Throwable
    //   530	536	404	java/lang/Throwable
    //   536	562	404	java/lang/Throwable
    //   565	594	404	java/lang/Throwable
    //   594	669	404	java/lang/Throwable
    //   674	707	404	java/lang/Throwable
    //   707	713	404	java/lang/Throwable
    //   713	782	404	java/lang/Throwable
    //   782	788	404	java/lang/Throwable
    //   788	802	404	java/lang/Throwable
    //   802	808	404	java/lang/Throwable
    //   808	823	404	java/lang/Throwable
    //   826	902	404	java/lang/Throwable
    //   911	920	404	java/lang/Throwable
    //   929	938	404	java/lang/Throwable
    //   943	976	404	java/lang/Throwable
    //   976	982	404	java/lang/Throwable
    //   982	1051	404	java/lang/Throwable
    //   1051	1057	404	java/lang/Throwable
    //   1057	1071	404	java/lang/Throwable
    //   1071	1077	404	java/lang/Throwable
    //   1077	1092	404	java/lang/Throwable
    //   1095	1105	404	java/lang/Throwable
    //   1108	1122	404	java/lang/Throwable
    //   309	326	1130	java/lang/InterruptedException
  }
  
  protected void a(Integer paramInteger)
  {
    this.jdField_a_of_type_Aeid.b(paramInteger.intValue(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Aeid.jdField_a_of_type_Aeil = null;
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[(paramVarArgs.length - 1)].intValue();
    this.jdField_a_of_type_Aeid.c(i >> 16, 0xFFFF & i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeil
 * JD-Core Version:    0.7.0.1
 */