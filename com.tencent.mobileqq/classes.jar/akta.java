import android.os.HandlerThread;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.FTSDBManager.1;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class akta
  extends Observable
  implements Manager
{
  public static volatile boolean a;
  private int jdField_a_of_type_Int = -1;
  public aktl a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FTSDatabase jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  private ConcurrentHashMap<Integer, akth> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile int b;
  public volatile boolean b;
  private volatile boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public akta(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQ_FTS_Sync", 3);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Aktl = new aktl(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new akti(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aktl));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new aktm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aktl));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new aktk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aktl));
    a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager structure...");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    bbmo.a(paramQQAppInterface, paramString);
    SQLiteDatabase localSQLiteDatabase = new QQEntityManagerFactory(paramString).build(paramString).a();
    localSQLiteDatabase.a("DROP TABLE IF EXISTS msg_upgrade_log;");
    localSQLiteDatabase.a("DROP TABLE IF EXISTS msg_sync_log;");
    localSQLiteDatabase.a("DROP TABLE IF EXISTS " + FTSTroopSync.class.getSimpleName() + ";");
    localSQLiteDatabase.a("DROP TABLE IF EXISTS " + FTSTroopTime.class.getSimpleName() + ";");
    if (!paramBoolean) {
      paramQQAppInterface.a().b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.manager", 2, "FTS clear...");
      }
      return;
      paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + paramString + "-IndexQQMsg.db");
      if ((paramQQAppInterface.exists()) && (paramQQAppInterface.isFile())) {
        paramQQAppInterface.delete();
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 36	akta:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: iconst_0
    //   8: invokestatic 219	bbmo:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11: aload_0
    //   12: getfield 211	akta:c	Z
    //   15: ifne +215 -> 230
    //   18: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +115 -> 136
    //   24: ldc 221
    //   26: aconst_null
    //   27: invokestatic 227	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   30: ldc 229
    //   32: aconst_null
    //   33: invokevirtual 233	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_3
    //   37: ldc 235
    //   39: astore 5
    //   41: aload_3
    //   42: astore 4
    //   44: aload_3
    //   45: invokeinterface 240 1 0
    //   50: ifeq +36 -> 86
    //   53: aload_3
    //   54: astore 4
    //   56: new 136	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   63: aload 5
    //   65: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_3
    //   69: iconst_0
    //   70: invokeinterface 244 2 0
    //   75: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 5
    //   83: goto -42 -> 41
    //   86: aload_3
    //   87: astore 4
    //   89: ldc 90
    //   91: iconst_2
    //   92: new 136	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   99: ldc 246
    //   101: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokestatic 251	bbdh:e	()Ljava/lang/String;
    //   107: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 253
    //   112: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 5
    //   117: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_3
    //   127: ifnull +9 -> 136
    //   130: aload_3
    //   131: invokeinterface 256 1 0
    //   136: getstatic 261	android/os/Build$VERSION:SDK_INT	I
    //   139: bipush 18
    //   141: if_icmpge +531 -> 672
    //   144: aload_0
    //   145: getfield 36	akta:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   148: invokestatic 264	bbmo:f	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   151: istore_2
    //   152: aload_0
    //   153: getfield 36	akta:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   156: iload_2
    //   157: iconst_1
    //   158: iadd
    //   159: invokestatic 267	bbmo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   162: ldc 90
    //   164: iconst_1
    //   165: new 136	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 269
    //   175: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload_2
    //   179: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iload_2
    //   189: iconst_5
    //   190: if_icmplt +79 -> 269
    //   193: iload_2
    //   194: sipush 200
    //   197: if_icmpge +72 -> 269
    //   200: ldc 90
    //   202: iconst_1
    //   203: new 136	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 274
    //   213: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload_2
    //   217: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 277	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iconst_0
    //   227: putstatic 22	akta:jdField_a_of_type_Boolean	Z
    //   230: return
    //   231: astore_3
    //   232: aload 4
    //   234: ifnull -98 -> 136
    //   237: aload 4
    //   239: invokeinterface 256 1 0
    //   244: goto -108 -> 136
    //   247: astore_3
    //   248: aconst_null
    //   249: astore 5
    //   251: aload_3
    //   252: astore 4
    //   254: aload 5
    //   256: ifnull +10 -> 266
    //   259: aload 5
    //   261: invokeinterface 256 1 0
    //   266: aload 4
    //   268: athrow
    //   269: iload_2
    //   270: istore_1
    //   271: iload_2
    //   272: sipush 200
    //   275: if_icmplt +13 -> 288
    //   278: aload_0
    //   279: getfield 36	akta:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   282: iconst_0
    //   283: invokestatic 267	bbmo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   286: iload_2
    //   287: istore_1
    //   288: aload_0
    //   289: getfield 279	akta:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   292: ifnull +10 -> 302
    //   295: aload_0
    //   296: getfield 279	akta:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   299: invokevirtual 282	com/tencent/mobileqq/fts/FTSDatabase:a	()V
    //   302: aload_0
    //   303: getfield 284	akta:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   306: ifnull +10 -> 316
    //   309: aload_0
    //   310: getfield 284	akta:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   313: invokevirtual 287	com/tencent/mobileqq/persistence/fts/FTSDatatbase:b	()V
    //   316: ldc 90
    //   318: iconst_1
    //   319: ldc_w 289
    //   322: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload_0
    //   326: new 286	com/tencent/mobileqq/persistence/fts/FTSDatatbase
    //   329: dup
    //   330: aload_0
    //   331: getfield 36	akta:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: invokespecial 291	com/tencent/mobileqq/persistence/fts/FTSDatatbase:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   337: putfield 284	akta:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   340: new 293	aqlf
    //   343: dup
    //   344: invokespecial 294	aqlf:<init>	()V
    //   347: invokestatic 297	com/tencent/mobileqq/fts/FTSDatabase:a	(Laqld;)V
    //   350: aload_0
    //   351: new 299	aqkz
    //   354: dup
    //   355: invokespecial 300	aqkz:<init>	()V
    //   358: putfield 279	akta:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   361: aload_0
    //   362: getfield 284	akta:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   365: invokevirtual 301	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	()V
    //   368: new 136	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   375: aload_0
    //   376: getfield 36	akta:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   379: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   382: invokevirtual 179	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   385: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   388: ldc 184
    //   390: ldc 186
    //   392: invokevirtual 192	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   395: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: getstatic 196	java/io/File:separator	Ljava/lang/String;
    //   401: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_0
    //   405: getfield 36	akta:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 304	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   411: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc 198
    //   416: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore_3
    //   423: aload_0
    //   424: getfield 279	akta:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   427: aload_3
    //   428: invokevirtual 306	com/tencent/mobileqq/fts/FTSDatabase:a	(Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 36	akta:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   435: iconst_1
    //   436: invokestatic 308	bbmo:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   439: getstatic 261	android/os/Build$VERSION:SDK_INT	I
    //   442: bipush 18
    //   444: if_icmpge +37 -> 481
    //   447: ldc 90
    //   449: iconst_1
    //   450: new 136	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   457: ldc_w 310
    //   460: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: iload_1
    //   464: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 277	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: aload_0
    //   474: getfield 36	akta:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   477: iconst_0
    //   478: invokestatic 267	bbmo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   481: aload_0
    //   482: getfield 32	akta:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   485: invokevirtual 314	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   488: invokeinterface 320 1 0
    //   493: astore_3
    //   494: aload_3
    //   495: invokeinterface 325 1 0
    //   500: ifeq +158 -> 658
    //   503: aload_3
    //   504: invokeinterface 329 1 0
    //   509: checkcast 61	java/lang/Integer
    //   512: invokevirtual 333	java/lang/Integer:intValue	()I
    //   515: istore_1
    //   516: aload_0
    //   517: getfield 32	akta:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   520: iload_1
    //   521: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   527: checkcast 339	akth
    //   530: astore 4
    //   532: aload 4
    //   534: ifnonnull +74 -> 608
    //   537: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq -310 -> 230
    //   543: ldc 90
    //   545: iconst_2
    //   546: iconst_4
    //   547: anewarray 341	java/lang/Object
    //   550: dup
    //   551: iconst_0
    //   552: ldc_w 343
    //   555: aastore
    //   556: dup
    //   557: iconst_1
    //   558: iload_1
    //   559: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   562: aastore
    //   563: dup
    //   564: iconst_2
    //   565: ldc_w 345
    //   568: aastore
    //   569: dup
    //   570: iconst_3
    //   571: aload_0
    //   572: getfield 32	akta:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   575: invokevirtual 348	java/util/concurrent/ConcurrentHashMap:size	()I
    //   578: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   581: aastore
    //   582: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   585: return
    //   586: astore_3
    //   587: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   590: ifeq +13 -> 603
    //   593: ldc 90
    //   595: iconst_2
    //   596: ldc_w 354
    //   599: aload_3
    //   600: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   603: iconst_0
    //   604: putstatic 22	akta:jdField_a_of_type_Boolean	Z
    //   607: return
    //   608: aload 4
    //   610: aload_0
    //   611: getfield 284	akta:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   614: aload_0
    //   615: getfield 279	akta:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   618: invokevirtual 360	akth:a	(Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;Lcom/tencent/mobileqq/fts/FTSDatabase;)Z
    //   621: ifne -127 -> 494
    //   624: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   627: ifeq -397 -> 230
    //   630: ldc 90
    //   632: iconst_2
    //   633: iconst_2
    //   634: anewarray 341	java/lang/Object
    //   637: dup
    //   638: iconst_0
    //   639: ldc_w 362
    //   642: aastore
    //   643: dup
    //   644: iconst_1
    //   645: aload 4
    //   647: invokevirtual 366	java/lang/Object:getClass	()Ljava/lang/Class;
    //   650: invokevirtual 151	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   653: aastore
    //   654: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   657: return
    //   658: aload_0
    //   659: iconst_1
    //   660: putfield 211	akta:c	Z
    //   663: return
    //   664: astore 4
    //   666: aload_3
    //   667: astore 5
    //   669: goto -415 -> 254
    //   672: iconst_0
    //   673: istore_1
    //   674: goto -386 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	akta
    //   270	404	1	i	int
    //   151	136	2	j	int
    //   36	95	3	localCursor	android.database.Cursor
    //   231	1	3	localException	java.lang.Exception
    //   247	5	3	localObject1	Object
    //   422	82	3	localObject2	Object
    //   586	81	3	localThrowable	java.lang.Throwable
    //   1	645	4	localObject3	Object
    //   664	1	4	localObject4	Object
    //   39	629	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   24	37	231	java/lang/Exception
    //   44	53	231	java/lang/Exception
    //   56	83	231	java/lang/Exception
    //   89	126	231	java/lang/Exception
    //   24	37	247	finally
    //   361	481	586	java/lang/Throwable
    //   44	53	664	finally
    //   56	83	664	finally
    //   89	126	664	finally
  }
  
  public long a()
  {
    long l = 0L;
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "-IndexQQMsg.db");
    if (localFile.exists()) {
      l = localFile.length();
    }
    return l;
  }
  
  public akth a(int paramInt)
  {
    return (akth)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public akti a()
  {
    return (akti)a(1);
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_Aktl.post(new FTSDBManager.1(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.c();
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a();
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      ((akth)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).d();
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      this.c = false;
      this.jdField_a_of_type_Aktl.a();
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ((akth)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase == null) {
        break label101;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b();
    label101:
    if (this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager destroy...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akta
 * JD-Core Version:    0.7.0.1
 */