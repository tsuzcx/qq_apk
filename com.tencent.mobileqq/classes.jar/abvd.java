import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import com.tencent.mobileqq.data.QQEntityManagerFactory;

public class abvd
  implements DatabaseErrorHandler
{
  private DefaultDatabaseErrorHandler jdField_a_of_type_AndroidDatabaseDefaultDatabaseErrorHandler = new DefaultDatabaseErrorHandler();
  
  @TargetApi(11)
  public abvd(QQEntityManagerFactory paramQQEntityManagerFactory) {}
  
  /* Error */
  public void onCorruption(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +36 -> 39
    //   6: aload_0
    //   7: getfield 16	abvd:jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   10: getfield 46	com/tencent/mobileqq/data/QQEntityManagerFactory:TAG	Ljava/lang/String;
    //   13: iconst_2
    //   14: new 48	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   21: ldc 51
    //   23: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 61	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   30: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: invokestatic 74	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   42: invokevirtual 78	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   45: astore 17
    //   47: aload 17
    //   49: invokevirtual 83	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   52: getstatic 88	com/tencent/mobileqq/database/corrupt/DBFixManager:b	Ljava/lang/String;
    //   55: iconst_0
    //   56: invokevirtual 94	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   59: astore 18
    //   61: aload 17
    //   63: invokevirtual 83	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   66: new 48	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   73: aload 17
    //   75: invokevirtual 97	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   78: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 99
    //   83: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokevirtual 103	mqq/app/MobileQQ:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   92: astore 15
    //   94: aload 15
    //   96: invokevirtual 108	java/io/File:exists	()Z
    //   99: ifeq +13 -> 112
    //   102: aload 15
    //   104: invokevirtual 112	java/io/File:length	()J
    //   107: lconst_0
    //   108: lcmp
    //   109: ifne +66 -> 175
    //   112: new 114	java/util/HashMap
    //   115: dup
    //   116: invokespecial 115	java/util/HashMap:<init>	()V
    //   119: astore 16
    //   121: aload 15
    //   123: invokevirtual 108	java/io/File:exists	()Z
    //   126: ifeq +911 -> 1037
    //   129: ldc 117
    //   131: astore 14
    //   133: aload 16
    //   135: ldc 119
    //   137: aload 14
    //   139: invokevirtual 123	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: invokestatic 129	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   146: invokestatic 134	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   149: aconst_null
    //   150: getstatic 137	com/tencent/mobileqq/database/corrupt/DBFixManager:l	Ljava/lang/String;
    //   153: iconst_1
    //   154: ldc2_w 138
    //   157: lconst_0
    //   158: aload 16
    //   160: aconst_null
    //   161: iconst_0
    //   162: invokevirtual 142	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   165: aload 15
    //   167: invokevirtual 143	java/io/File:getPath	()Ljava/lang/String;
    //   170: invokestatic 149	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   173: pop
    //   174: return
    //   175: aload 18
    //   177: new 48	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   184: aload 17
    //   186: invokevirtual 97	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   189: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: getstatic 152	com/tencent/mobileqq/database/corrupt/DBFixManager:g	Ljava/lang/String;
    //   195: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokeinterface 157 2 0
    //   206: ifne +377 -> 583
    //   209: aload 18
    //   211: invokeinterface 161 1 0
    //   216: new 48	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   223: aload 17
    //   225: invokevirtual 97	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   228: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: getstatic 152	com/tencent/mobileqq/database/corrupt/DBFixManager:g	Ljava/lang/String;
    //   234: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: iconst_1
    //   241: invokeinterface 167 3 0
    //   246: invokeinterface 170 1 0
    //   251: pop
    //   252: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   255: putstatic 179	com/tencent/mobileqq/data/QQEntityManagerFactory:corruptedTime	J
    //   258: iconst_0
    //   259: istore 5
    //   261: lconst_0
    //   262: lstore 8
    //   264: lconst_0
    //   265: lstore 10
    //   267: lload 10
    //   269: lstore 6
    //   271: iload 5
    //   273: istore 4
    //   275: aload 17
    //   277: instanceof 181
    //   280: ifeq +167 -> 447
    //   283: aload 15
    //   285: invokevirtual 112	java/io/File:length	()J
    //   288: lstore 12
    //   290: lload 10
    //   292: lstore 6
    //   294: lload 12
    //   296: lstore 8
    //   298: iload 5
    //   300: istore 4
    //   302: aload 15
    //   304: invokevirtual 108	java/io/File:exists	()Z
    //   307: ifeq +140 -> 447
    //   310: lload 10
    //   312: lstore 6
    //   314: lload 12
    //   316: lstore 8
    //   318: iload 5
    //   320: istore 4
    //   322: aload 15
    //   324: invokevirtual 112	java/io/File:length	()J
    //   327: lconst_0
    //   328: lcmp
    //   329: ifle +118 -> 447
    //   332: lload 10
    //   334: lstore 6
    //   336: lload 12
    //   338: lstore 8
    //   340: iload 5
    //   342: istore 4
    //   344: invokestatic 185	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   347: ifeq +100 -> 447
    //   350: lload 10
    //   352: lstore 6
    //   354: lload 12
    //   356: lstore 8
    //   358: iload 5
    //   360: istore 4
    //   362: invokestatic 187	com/tencent/mobileqq/util/SystemUtil:a	()J
    //   365: aload 15
    //   367: invokevirtual 112	java/io/File:length	()J
    //   370: lcmp
    //   371: ifle +76 -> 447
    //   374: new 105	java/io/File
    //   377: dup
    //   378: new 48	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   385: invokestatic 193	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   388: invokevirtual 143	java/io/File:getPath	()Ljava/lang/String;
    //   391: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc 195
    //   396: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   405: astore 14
    //   407: lload 10
    //   409: lstore 6
    //   411: lload 12
    //   413: lstore 8
    //   415: iload 5
    //   417: istore 4
    //   419: aload 14
    //   421: invokevirtual 108	java/io/File:exists	()Z
    //   424: ifne +23 -> 447
    //   427: aload 15
    //   429: aload 14
    //   431: invokestatic 201	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   434: istore 4
    //   436: aload 14
    //   438: invokevirtual 112	java/io/File:length	()J
    //   441: lstore 6
    //   443: lload 12
    //   445: lstore 8
    //   447: invokestatic 204	com/tencent/mobileqq/data/QQEntityManagerFactory:getSqliteLibraryVersion	()Ljava/lang/String;
    //   450: astore 14
    //   452: new 114	java/util/HashMap
    //   455: dup
    //   456: invokespecial 115	java/util/HashMap:<init>	()V
    //   459: astore 15
    //   461: aload 15
    //   463: ldc 206
    //   465: invokestatic 211	com/tencent/mobileqq/utils/DeviceInfoUtil:k	()Ljava/lang/String;
    //   468: invokevirtual 123	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: aload 15
    //   474: ldc 213
    //   476: iload 4
    //   478: invokestatic 219	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   481: invokevirtual 123	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   484: pop
    //   485: aload 15
    //   487: ldc 221
    //   489: lload 8
    //   491: invokestatic 224	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   494: invokevirtual 123	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   497: pop
    //   498: aload 15
    //   500: ldc 226
    //   502: lload 6
    //   504: invokestatic 224	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   507: invokevirtual 123	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   510: pop
    //   511: aload 15
    //   513: ldc 228
    //   515: aload 14
    //   517: invokevirtual 123	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   520: pop
    //   521: aload_0
    //   522: getfield 16	abvd:jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   525: getfield 46	com/tencent/mobileqq/data/QQEntityManagerFactory:TAG	Ljava/lang/String;
    //   528: iconst_1
    //   529: ldc 230
    //   531: iconst_3
    //   532: anewarray 4	java/lang/Object
    //   535: dup
    //   536: iconst_0
    //   537: lload 8
    //   539: invokestatic 235	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   542: aastore
    //   543: dup
    //   544: iconst_1
    //   545: lload 6
    //   547: invokestatic 235	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   550: aastore
    //   551: dup
    //   552: iconst_2
    //   553: aload 14
    //   555: aastore
    //   556: invokestatic 239	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   559: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: invokestatic 129	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   565: invokestatic 134	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   568: aconst_null
    //   569: ldc 241
    //   571: iconst_1
    //   572: ldc2_w 138
    //   575: lconst_0
    //   576: aload 15
    //   578: aconst_null
    //   579: iconst_0
    //   580: invokevirtual 142	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   583: new 105	java/io/File
    //   586: dup
    //   587: aload_1
    //   588: invokevirtual 61	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   591: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   594: invokevirtual 244	java/io/File:getName	()Ljava/lang/String;
    //   597: astore 19
    //   599: aload 19
    //   601: new 48	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   608: aload 17
    //   610: invokevirtual 97	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   613: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: ldc 99
    //   618: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokevirtual 248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   627: istore 5
    //   629: aconst_null
    //   630: astore 15
    //   632: aload 17
    //   634: sipush 204
    //   637: invokevirtual 252	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   640: checkcast 85	com/tencent/mobileqq/database/corrupt/DBFixManager
    //   643: astore 14
    //   645: aload 14
    //   647: invokevirtual 253	com/tencent/mobileqq/database/corrupt/DBFixManager:a	()Z
    //   650: istore 4
    //   652: iconst_0
    //   653: istore_2
    //   654: aconst_null
    //   655: astore 16
    //   657: aload 14
    //   659: astore 15
    //   661: aload 16
    //   663: astore 14
    //   665: iload 4
    //   667: ifeq +103 -> 770
    //   670: iload 5
    //   672: ifeq +98 -> 770
    //   675: aload_1
    //   676: invokevirtual 256	android/database/sqlite/SQLiteDatabase:close	()V
    //   679: aload 15
    //   681: aconst_null
    //   682: iconst_1
    //   683: invokevirtual 259	com/tencent/mobileqq/database/corrupt/DBFixManager:a	(Landroid/content/Context;Z)V
    //   686: return
    //   687: astore 14
    //   689: aload_0
    //   690: getfield 24	abvd:jdField_a_of_type_AndroidDatabaseDefaultDatabaseErrorHandler	Landroid/database/DefaultDatabaseErrorHandler;
    //   693: aload_1
    //   694: invokevirtual 261	android/database/DefaultDatabaseErrorHandler:onCorruption	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   697: return
    //   698: astore 16
    //   700: aload 15
    //   702: astore 14
    //   704: aload 16
    //   706: astore 15
    //   708: aload_0
    //   709: getfield 16	abvd:jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   712: getfield 46	com/tencent/mobileqq/data/QQEntityManagerFactory:TAG	Ljava/lang/String;
    //   715: iconst_1
    //   716: ldc_w 263
    //   719: aload 15
    //   721: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   724: getstatic 271	com/tencent/mobileqq/database/corrupt/DBFixManager:jdField_f_of_type_Int	I
    //   727: istore_2
    //   728: aload 15
    //   730: invokestatic 277	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   733: astore 16
    //   735: iconst_0
    //   736: istore 4
    //   738: aload 14
    //   740: astore 15
    //   742: aload 16
    //   744: astore 14
    //   746: goto -81 -> 665
    //   749: astore 14
    //   751: aload_0
    //   752: getfield 16	abvd:jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   755: getfield 46	com/tencent/mobileqq/data/QQEntityManagerFactory:TAG	Ljava/lang/String;
    //   758: iconst_1
    //   759: ldc_w 279
    //   762: aload 14
    //   764: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   767: goto -88 -> 679
    //   770: aload 18
    //   772: new 48	java/lang/StringBuilder
    //   775: dup
    //   776: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   779: aload 17
    //   781: invokevirtual 97	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   784: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: getstatic 281	com/tencent/mobileqq/database/corrupt/DBFixManager:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   790: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: iconst_0
    //   797: invokeinterface 285 3 0
    //   802: istore_3
    //   803: aload_0
    //   804: getfield 16	abvd:jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   807: getfield 46	com/tencent/mobileqq/data/QQEntityManagerFactory:TAG	Ljava/lang/String;
    //   810: iconst_1
    //   811: bipush 6
    //   813: anewarray 4	java/lang/Object
    //   816: dup
    //   817: iconst_0
    //   818: ldc_w 287
    //   821: aastore
    //   822: dup
    //   823: iconst_1
    //   824: aload 19
    //   826: aastore
    //   827: dup
    //   828: iconst_2
    //   829: ldc_w 289
    //   832: aastore
    //   833: dup
    //   834: iconst_3
    //   835: iload 5
    //   837: invokestatic 294	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   840: aastore
    //   841: dup
    //   842: iconst_4
    //   843: ldc_w 296
    //   846: aastore
    //   847: dup
    //   848: iconst_5
    //   849: iload_3
    //   850: invokestatic 301	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   853: aastore
    //   854: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   857: iload_3
    //   858: getstatic 307	com/tencent/mobileqq/database/corrupt/DBFixManager:c	I
    //   861: if_icmpge +8 -> 869
    //   864: iload 5
    //   866: ifne +170 -> 1036
    //   869: aload_0
    //   870: getfield 24	abvd:jdField_a_of_type_AndroidDatabaseDefaultDatabaseErrorHandler	Landroid/database/DefaultDatabaseErrorHandler;
    //   873: aload_1
    //   874: invokevirtual 261	android/database/DefaultDatabaseErrorHandler:onCorruption	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   877: aload 18
    //   879: invokeinterface 161 1 0
    //   884: getstatic 152	com/tencent/mobileqq/database/corrupt/DBFixManager:g	Ljava/lang/String;
    //   887: invokeinterface 311 2 0
    //   892: invokeinterface 170 1 0
    //   897: pop
    //   898: invokestatic 316	com/tencent/mobileqq/service/message/MessageCache:j	()V
    //   901: aload 18
    //   903: invokeinterface 161 1 0
    //   908: ldc_w 318
    //   911: iconst_0
    //   912: invokeinterface 167 3 0
    //   917: invokeinterface 170 1 0
    //   922: pop
    //   923: aload_0
    //   924: getfield 16	abvd:jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory	Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   927: getfield 46	com/tencent/mobileqq/data/QQEntityManagerFactory:TAG	Ljava/lang/String;
    //   930: iconst_1
    //   931: ldc_w 320
    //   934: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   937: iload_2
    //   938: istore_3
    //   939: iload_2
    //   940: ifne +12 -> 952
    //   943: iload 5
    //   945: ifeq +79 -> 1024
    //   948: getstatic 324	com/tencent/mobileqq/database/corrupt/DBFixManager:e	I
    //   951: istore_3
    //   952: new 114	java/util/HashMap
    //   955: dup
    //   956: invokespecial 115	java/util/HashMap:<init>	()V
    //   959: astore 15
    //   961: aload 15
    //   963: ldc_w 326
    //   966: iload_3
    //   967: invokestatic 329	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   970: invokevirtual 123	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   973: pop
    //   974: aload 15
    //   976: ldc_w 331
    //   979: aload 19
    //   981: invokevirtual 123	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   984: pop
    //   985: aload 14
    //   987: ifnull +14 -> 1001
    //   990: aload 15
    //   992: ldc_w 333
    //   995: aload 14
    //   997: invokevirtual 123	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1000: pop
    //   1001: invokestatic 129	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1004: invokestatic 134	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1007: aconst_null
    //   1008: getstatic 335	com/tencent/mobileqq/database/corrupt/DBFixManager:j	Ljava/lang/String;
    //   1011: iconst_1
    //   1012: ldc2_w 138
    //   1015: lconst_0
    //   1016: aload 15
    //   1018: aconst_null
    //   1019: iconst_0
    //   1020: invokevirtual 142	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1023: return
    //   1024: getstatic 337	com/tencent/mobileqq/database/corrupt/DBFixManager:d	I
    //   1027: istore_3
    //   1028: goto -76 -> 952
    //   1031: astore 15
    //   1033: goto -325 -> 708
    //   1036: return
    //   1037: ldc_w 339
    //   1040: astore 14
    //   1042: goto -909 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1045	0	this	abvd
    //   0	1045	1	paramSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   653	287	2	i	int
    //   802	226	3	j	int
    //   273	464	4	bool1	boolean
    //   259	685	5	bool2	boolean
    //   269	277	6	l1	long
    //   262	276	8	l2	long
    //   265	143	10	l3	long
    //   288	156	12	l4	long
    //   131	533	14	localObject1	Object
    //   687	1	14	localStackOverflowError	java.lang.StackOverflowError
    //   702	43	14	localObject2	Object
    //   749	247	14	localSQLiteException	android.database.sqlite.SQLiteException
    //   1040	1	14	str1	java.lang.String
    //   92	925	15	localObject3	Object
    //   1031	1	15	localThrowable1	java.lang.Throwable
    //   119	543	16	localHashMap	java.util.HashMap
    //   698	7	16	localThrowable2	java.lang.Throwable
    //   733	10	16	str2	java.lang.String
    //   45	735	17	localAppRuntime	mqq.app.AppRuntime
    //   59	843	18	localSharedPreferences	android.content.SharedPreferences
    //   597	383	19	str3	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   0	39	687	java/lang/StackOverflowError
    //   39	112	687	java/lang/StackOverflowError
    //   112	129	687	java/lang/StackOverflowError
    //   133	174	687	java/lang/StackOverflowError
    //   175	258	687	java/lang/StackOverflowError
    //   275	290	687	java/lang/StackOverflowError
    //   302	310	687	java/lang/StackOverflowError
    //   322	332	687	java/lang/StackOverflowError
    //   344	350	687	java/lang/StackOverflowError
    //   362	407	687	java/lang/StackOverflowError
    //   419	443	687	java/lang/StackOverflowError
    //   447	583	687	java/lang/StackOverflowError
    //   583	629	687	java/lang/StackOverflowError
    //   632	645	687	java/lang/StackOverflowError
    //   645	652	687	java/lang/StackOverflowError
    //   675	679	687	java/lang/StackOverflowError
    //   679	686	687	java/lang/StackOverflowError
    //   708	735	687	java/lang/StackOverflowError
    //   751	767	687	java/lang/StackOverflowError
    //   770	864	687	java/lang/StackOverflowError
    //   869	937	687	java/lang/StackOverflowError
    //   948	952	687	java/lang/StackOverflowError
    //   952	985	687	java/lang/StackOverflowError
    //   990	1001	687	java/lang/StackOverflowError
    //   1001	1023	687	java/lang/StackOverflowError
    //   1024	1028	687	java/lang/StackOverflowError
    //   632	645	698	java/lang/Throwable
    //   675	679	749	android/database/sqlite/SQLiteException
    //   645	652	1031	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abvd
 * JD-Core Version:    0.7.0.1
 */