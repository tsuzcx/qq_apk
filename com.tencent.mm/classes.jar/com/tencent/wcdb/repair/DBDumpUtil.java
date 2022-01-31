package com.tencent.wcdb.repair;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.PrintStream;
import java.util.ArrayList;

public class DBDumpUtil
{
  private static final String TAG = "WCDB.DBDumpUtil";
  
  public static String buildColumnsString(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(12650);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(12650);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int i = 0;
    while (i < paramArrayList.size())
    {
      localStringBuilder.append((String)paramArrayList.get(i));
      if (i != paramArrayList.size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    paramArrayList = localStringBuilder.toString();
    System.out.println(paramArrayList);
    AppMethodBeat.o(12650);
    return paramArrayList;
  }
  
  public static boolean doRecoveryDb(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12648);
    boolean bool = doRecoveryDb(paramSQLiteDatabase, paramString1, paramString2, paramString3, null, null, null, true);
    AppMethodBeat.o(12648);
    return bool;
  }
  
  /* Error */
  public static boolean doRecoveryDb(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, java.util.List<String> paramList1, java.util.List<String> paramList2, ExecuteSqlCallback paramExecuteSqlCallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 12649
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 89	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   14: ifne +18 -> 32
    //   17: ldc 11
    //   19: ldc 91
    //   21: invokestatic 97	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: sipush 12649
    //   27: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_1
    //   33: aload_2
    //   34: aload_3
    //   35: invokestatic 101	com/tencent/wcdb/repair/DBDumpUtil:nativeDumpDB	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   38: ifne +11 -> 49
    //   41: sipush 12649
    //   44: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: iconst_0
    //   48: ireturn
    //   49: new 103	java/io/BufferedReader
    //   52: dup
    //   53: new 105	java/io/FileReader
    //   56: dup
    //   57: aload_3
    //   58: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   61: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   64: astore 17
    //   66: aload_0
    //   67: ldc 112
    //   69: invokevirtual 115	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   72: aload_0
    //   73: invokevirtual 118	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   76: iconst_0
    //   77: istore 11
    //   79: iconst_0
    //   80: istore 10
    //   82: iconst_0
    //   83: istore 9
    //   85: new 120	java/util/HashMap
    //   88: dup
    //   89: invokespecial 121	java/util/HashMap:<init>	()V
    //   92: astore 18
    //   94: iconst_0
    //   95: istore 8
    //   97: aconst_null
    //   98: astore_2
    //   99: aload 17
    //   101: invokevirtual 124	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   104: astore 15
    //   106: aload 15
    //   108: ifnull +629 -> 737
    //   111: iload 8
    //   113: ifeq +84 -> 197
    //   116: new 37	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   123: aload_2
    //   124: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 126
    //   129: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 15
    //   134: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 15
    //   142: aload 15
    //   144: ldc 128
    //   146: invokevirtual 132	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   149: ifeq +789 -> 938
    //   152: aload 15
    //   154: invokestatic 135	com/tencent/wcdb/repair/DBDumpUtil:nativeIsSqlComplete	(Ljava/lang/String;)Z
    //   157: istore 14
    //   159: aload 15
    //   161: astore_2
    //   162: iload 14
    //   164: ifne +112 -> 276
    //   167: aload 15
    //   169: astore_2
    //   170: goto -71 -> 99
    //   173: astore_0
    //   174: ldc 11
    //   176: ldc 137
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_3
    //   185: aastore
    //   186: invokestatic 140	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: sipush 12649
    //   192: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: aload 15
    //   199: ldc 142
    //   201: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   204: ifne +13 -> 217
    //   207: aload 15
    //   209: ldc 147
    //   211: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   214: ifeq -115 -> 99
    //   217: aload 15
    //   219: ldc 128
    //   221: invokevirtual 132	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   224: ifeq +11 -> 235
    //   227: aload 15
    //   229: invokestatic 135	com/tencent/wcdb/repair/DBDumpUtil:nativeIsSqlComplete	(Ljava/lang/String;)Z
    //   232: ifne +718 -> 950
    //   235: aload_2
    //   236: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifeq +9 -> 248
    //   242: aload 15
    //   244: astore_2
    //   245: goto +699 -> 944
    //   248: new 37	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   255: aload_2
    //   256: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc 126
    //   261: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 15
    //   266: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: astore_2
    //   273: goto +671 -> 944
    //   276: iconst_0
    //   277: istore 8
    //   279: aload 5
    //   281: ifnull +86 -> 367
    //   284: aload 5
    //   286: invokeinterface 156 1 0
    //   291: ifle +76 -> 367
    //   294: aload_2
    //   295: invokestatic 160	com/tencent/wcdb/repair/DBDumpUtil:getTableNameFromSql	(Ljava/lang/String;)Ljava/lang/String;
    //   298: astore 16
    //   300: aload 5
    //   302: invokeinterface 164 1 0
    //   307: astore 15
    //   309: aload 15
    //   311: invokeinterface 169 1 0
    //   316: ifeq +640 -> 956
    //   319: aload 16
    //   321: aload 15
    //   323: invokeinterface 173 1 0
    //   328: checkcast 50	java/lang/String
    //   331: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   334: ifeq -25 -> 309
    //   337: iconst_0
    //   338: istore 8
    //   340: iload 8
    //   342: ifeq +92 -> 434
    //   345: ldc 11
    //   347: ldc 179
    //   349: iconst_1
    //   350: anewarray 4	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload 16
    //   357: aastore
    //   358: invokestatic 181	com/tencent/wcdb/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   361: iconst_0
    //   362: istore 8
    //   364: goto -265 -> 99
    //   367: aload 4
    //   369: ifnull +563 -> 932
    //   372: aload 4
    //   374: invokeinterface 156 1 0
    //   379: ifle +553 -> 932
    //   382: aload_2
    //   383: invokestatic 160	com/tencent/wcdb/repair/DBDumpUtil:getTableNameFromSql	(Ljava/lang/String;)Ljava/lang/String;
    //   386: astore 16
    //   388: aload 4
    //   390: invokeinterface 164 1 0
    //   395: astore 15
    //   397: aload 15
    //   399: invokeinterface 169 1 0
    //   404: ifeq +522 -> 926
    //   407: aload 16
    //   409: aload 15
    //   411: invokeinterface 173 1 0
    //   416: checkcast 50	java/lang/String
    //   419: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   422: ifeq -25 -> 397
    //   425: iconst_1
    //   426: istore 8
    //   428: ldc 35
    //   430: astore_2
    //   431: goto -91 -> 340
    //   434: iload 10
    //   436: istore 8
    //   438: aload_2
    //   439: ldc 147
    //   441: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   444: ifeq +144 -> 588
    //   447: iload 10
    //   449: istore 8
    //   451: aload 18
    //   453: aload 16
    //   455: aload_2
    //   456: invokestatic 185	com/tencent/wcdb/repair/DBDumpUtil:getColumnNamesFromSql	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   459: invokestatic 187	com/tencent/wcdb/repair/DBDumpUtil:buildColumnsString	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   462: invokevirtual 191	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: aload_2
    //   467: astore 15
    //   469: aconst_null
    //   470: astore_2
    //   471: aload 6
    //   473: ifnull +17 -> 490
    //   476: iload 10
    //   478: istore 8
    //   480: aload 6
    //   482: aload 15
    //   484: invokeinterface 194 2 0
    //   489: astore_2
    //   490: iload 10
    //   492: istore 8
    //   494: aload_2
    //   495: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   498: ifne +422 -> 920
    //   501: iload 10
    //   503: iconst_1
    //   504: iadd
    //   505: istore 10
    //   507: iload 10
    //   509: istore 8
    //   511: aload_0
    //   512: aload_2
    //   513: invokevirtual 115	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   516: iload 9
    //   518: iconst_1
    //   519: iadd
    //   520: istore 13
    //   522: iload 13
    //   524: istore 8
    //   526: iload 10
    //   528: istore 9
    //   530: iload 11
    //   532: istore 12
    //   534: iload 13
    //   536: bipush 100
    //   538: if_icmplt +26 -> 564
    //   541: aload_0
    //   542: invokevirtual 197	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   545: aload_0
    //   546: invokevirtual 200	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   549: aload_0
    //   550: invokevirtual 118	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   553: iconst_0
    //   554: istore 8
    //   556: iload 11
    //   558: istore 12
    //   560: iload 10
    //   562: istore 9
    //   564: iconst_0
    //   565: istore 13
    //   567: aconst_null
    //   568: astore_2
    //   569: iload 9
    //   571: istore 10
    //   573: iload 12
    //   575: istore 11
    //   577: iload 8
    //   579: istore 9
    //   581: iload 13
    //   583: istore 8
    //   585: goto -486 -> 99
    //   588: aload_2
    //   589: astore 15
    //   591: iload 10
    //   593: istore 8
    //   595: aload_2
    //   596: ldc 202
    //   598: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   601: ifeq -132 -> 469
    //   604: iload 10
    //   606: istore 8
    //   608: aload 18
    //   610: aload 16
    //   612: invokevirtual 205	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   615: checkcast 50	java/lang/String
    //   618: astore 19
    //   620: aload_2
    //   621: astore 15
    //   623: iload 10
    //   625: istore 8
    //   627: aload 19
    //   629: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   632: ifne -163 -> 469
    //   635: iload 10
    //   637: istore 8
    //   639: new 37	java/lang/StringBuilder
    //   642: dup
    //   643: ldc 207
    //   645: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   648: astore 15
    //   650: iload 10
    //   652: istore 8
    //   654: aload 15
    //   656: ldc 210
    //   658: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload 16
    //   663: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: ldc 210
    //   668: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: iload 10
    //   674: istore 8
    //   676: aload 15
    //   678: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: astore 16
    //   683: iload 10
    //   685: istore 8
    //   687: aload 15
    //   689: aload 19
    //   691: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: iload 10
    //   697: istore 8
    //   699: aload_2
    //   700: aload 16
    //   702: aload 15
    //   704: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokevirtual 214	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   710: astore 15
    //   712: goto -243 -> 469
    //   715: astore_2
    //   716: iload 9
    //   718: istore 10
    //   720: iload 8
    //   722: istore 9
    //   724: iload 10
    //   726: istore 8
    //   728: iload 11
    //   730: iconst_1
    //   731: iadd
    //   732: istore 12
    //   734: goto -170 -> 564
    //   737: aload 17
    //   739: invokevirtual 217	java/io/BufferedReader:close	()V
    //   742: iload 10
    //   744: iload 11
    //   746: if_icmple +142 -> 888
    //   749: aload_0
    //   750: invokevirtual 220	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   753: ifeq +7 -> 760
    //   756: aload_0
    //   757: invokevirtual 197	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   760: aload_0
    //   761: invokevirtual 220	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   764: ifeq +7 -> 771
    //   767: aload_0
    //   768: invokevirtual 200	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   771: iload 7
    //   773: ifeq +45 -> 818
    //   776: new 222	java/io/File
    //   779: dup
    //   780: aload_3
    //   781: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   784: astore_0
    //   785: aload_0
    //   786: invokevirtual 226	java/io/File:exists	()Z
    //   789: ifeq +8 -> 797
    //   792: aload_0
    //   793: invokevirtual 229	java/io/File:delete	()Z
    //   796: pop
    //   797: new 222	java/io/File
    //   800: dup
    //   801: aload_1
    //   802: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   805: astore_0
    //   806: aload_0
    //   807: invokevirtual 226	java/io/File:exists	()Z
    //   810: ifeq +8 -> 818
    //   813: aload_0
    //   814: invokevirtual 229	java/io/File:delete	()Z
    //   817: pop
    //   818: ldc 11
    //   820: ldc 231
    //   822: iconst_2
    //   823: anewarray 4	java/lang/Object
    //   826: dup
    //   827: iconst_0
    //   828: iload 10
    //   830: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   833: aastore
    //   834: dup
    //   835: iconst_1
    //   836: iload 11
    //   838: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   841: aastore
    //   842: invokestatic 181	com/tencent/wcdb/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   845: sipush 12649
    //   848: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   851: iconst_1
    //   852: ireturn
    //   853: astore_0
    //   854: ldc 11
    //   856: ldc 239
    //   858: invokestatic 97	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   861: aload 17
    //   863: invokevirtual 217	java/io/BufferedReader:close	()V
    //   866: sipush 12649
    //   869: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   872: iconst_0
    //   873: ireturn
    //   874: astore_0
    //   875: aload 17
    //   877: invokevirtual 217	java/io/BufferedReader:close	()V
    //   880: sipush 12649
    //   883: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   886: aload_0
    //   887: athrow
    //   888: sipush 12649
    //   891: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   894: iconst_0
    //   895: ireturn
    //   896: astore_2
    //   897: goto -155 -> 742
    //   900: astore_0
    //   901: goto -35 -> 866
    //   904: astore_1
    //   905: goto -25 -> 880
    //   908: astore_2
    //   909: iload 13
    //   911: istore 8
    //   913: iload 10
    //   915: istore 9
    //   917: goto -189 -> 728
    //   920: aload 15
    //   922: astore_2
    //   923: goto -422 -> 501
    //   926: iconst_0
    //   927: istore 8
    //   929: goto -589 -> 340
    //   932: aconst_null
    //   933: astore 16
    //   935: goto -595 -> 340
    //   938: aload 15
    //   940: astore_2
    //   941: goto -842 -> 99
    //   944: iconst_1
    //   945: istore 8
    //   947: goto -848 -> 99
    //   950: aload 15
    //   952: astore_2
    //   953: goto -677 -> 276
    //   956: iconst_1
    //   957: istore 8
    //   959: goto -619 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	962	1	paramString1	String
    //   0	962	2	paramString2	String
    //   0	962	3	paramString3	String
    //   0	962	4	paramList1	java.util.List<String>
    //   0	962	5	paramList2	java.util.List<String>
    //   0	962	6	paramExecuteSqlCallback	ExecuteSqlCallback
    //   0	962	7	paramBoolean	boolean
    //   95	863	8	i	int
    //   83	833	9	j	int
    //   80	834	10	k	int
    //   77	760	11	m	int
    //   532	201	12	n	int
    //   520	390	13	i1	int
    //   157	6	14	bool	boolean
    //   104	847	15	localObject	Object
    //   298	636	16	str1	String
    //   64	812	17	localBufferedReader	java.io.BufferedReader
    //   92	517	18	localHashMap	java.util.HashMap
    //   618	72	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   49	66	173	java/io/FileNotFoundException
    //   438	447	715	java/lang/Exception
    //   451	466	715	java/lang/Exception
    //   480	490	715	java/lang/Exception
    //   494	501	715	java/lang/Exception
    //   511	516	715	java/lang/Exception
    //   595	604	715	java/lang/Exception
    //   608	620	715	java/lang/Exception
    //   627	635	715	java/lang/Exception
    //   639	650	715	java/lang/Exception
    //   654	672	715	java/lang/Exception
    //   676	683	715	java/lang/Exception
    //   687	695	715	java/lang/Exception
    //   699	712	715	java/lang/Exception
    //   85	94	853	java/io/IOException
    //   99	106	853	java/io/IOException
    //   116	159	853	java/io/IOException
    //   197	217	853	java/io/IOException
    //   217	235	853	java/io/IOException
    //   235	242	853	java/io/IOException
    //   248	273	853	java/io/IOException
    //   284	309	853	java/io/IOException
    //   309	337	853	java/io/IOException
    //   345	361	853	java/io/IOException
    //   372	397	853	java/io/IOException
    //   397	425	853	java/io/IOException
    //   438	447	853	java/io/IOException
    //   451	466	853	java/io/IOException
    //   480	490	853	java/io/IOException
    //   494	501	853	java/io/IOException
    //   511	516	853	java/io/IOException
    //   541	553	853	java/io/IOException
    //   595	604	853	java/io/IOException
    //   608	620	853	java/io/IOException
    //   627	635	853	java/io/IOException
    //   639	650	853	java/io/IOException
    //   654	672	853	java/io/IOException
    //   676	683	853	java/io/IOException
    //   687	695	853	java/io/IOException
    //   699	712	853	java/io/IOException
    //   85	94	874	finally
    //   99	106	874	finally
    //   116	159	874	finally
    //   197	217	874	finally
    //   217	235	874	finally
    //   235	242	874	finally
    //   248	273	874	finally
    //   284	309	874	finally
    //   309	337	874	finally
    //   345	361	874	finally
    //   372	397	874	finally
    //   397	425	874	finally
    //   438	447	874	finally
    //   451	466	874	finally
    //   480	490	874	finally
    //   494	501	874	finally
    //   511	516	874	finally
    //   541	553	874	finally
    //   595	604	874	finally
    //   608	620	874	finally
    //   627	635	874	finally
    //   639	650	874	finally
    //   654	672	874	finally
    //   676	683	874	finally
    //   687	695	874	finally
    //   699	712	874	finally
    //   854	861	874	finally
    //   737	742	896	java/io/IOException
    //   861	866	900	java/io/IOException
    //   875	880	904	java/io/IOException
    //   541	553	908	java/lang/Exception
  }
  
  public static ArrayList<String> getColumnNamesFromSql(String paramString)
  {
    AppMethodBeat.i(12653);
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.substring(paramString.indexOf("(") + 1, paramString.lastIndexOf(")")).trim().split(",");
    int i = 0;
    while (i < paramString.length)
    {
      paramString[i] = paramString[i].trim();
      int j = paramString[i].indexOf(" ");
      localArrayList.add(paramString[i].substring(0, j));
      i += 1;
    }
    AppMethodBeat.o(12653);
    return localArrayList;
  }
  
  public static String getTableNameFromSql(String paramString)
  {
    AppMethodBeat.i(12651);
    String str = paramString;
    if (paramString.length() > 100) {
      str = paramString.substring(0, 100);
    }
    paramString = str.split("\\s");
    if ((paramString != null) && (paramString.length > 1))
    {
      paramString = paramString[2].replaceAll("\"", "");
      AppMethodBeat.o(12651);
      return paramString;
    }
    AppMethodBeat.o(12651);
    return null;
  }
  
  private static native boolean nativeDumpDB(String paramString1, String paramString2, String paramString3);
  
  private static native boolean nativeIsSqlComplete(String paramString);
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: sipush 12652
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 222	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 226	java/io/File:exists	()Z
    //   19: ifne +27 -> 46
    //   22: ldc 11
    //   24: ldc_w 278
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: aastore
    //   35: invokestatic 140	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: sipush 12652
    //   41: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_3
    //   47: invokevirtual 281	java/io/File:length	()J
    //   50: l2i
    //   51: istore_1
    //   52: new 283	java/io/FileInputStream
    //   55: dup
    //   56: aload_3
    //   57: invokespecial 286	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: astore_3
    //   61: iload_1
    //   62: newarray byte
    //   64: astore 4
    //   66: aload_3
    //   67: aload 4
    //   69: invokevirtual 290	java/io/FileInputStream:read	([B)I
    //   72: istore_2
    //   73: iload_2
    //   74: iload_1
    //   75: if_icmpeq +45 -> 120
    //   78: ldc 11
    //   80: ldc_w 292
    //   83: iconst_3
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: iload_1
    //   94: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: iload_2
    //   101: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 140	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: invokevirtual 293	java/io/FileInputStream:close	()V
    //   112: sipush 12652
    //   115: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aconst_null
    //   119: areturn
    //   120: aload_3
    //   121: invokevirtual 293	java/io/FileInputStream:close	()V
    //   124: sipush 12652
    //   127: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload 4
    //   132: areturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 293	java/io/FileInputStream:close	()V
    //   144: ldc 11
    //   146: ldc_w 295
    //   149: invokestatic 298	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: sipush 12652
    //   155: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_0
    //   161: aconst_null
    //   162: astore_3
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 293	java/io/FileInputStream:close	()V
    //   171: sipush 12652
    //   174: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_0
    //   178: athrow
    //   179: astore_0
    //   180: goto -68 -> 112
    //   183: astore_0
    //   184: goto -60 -> 124
    //   187: astore_0
    //   188: goto -44 -> 144
    //   191: astore_3
    //   192: goto -21 -> 171
    //   195: astore_0
    //   196: goto -33 -> 163
    //   199: astore_0
    //   200: aload_3
    //   201: astore_0
    //   202: goto -66 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramString	String
    //   51	43	1	i	int
    //   72	29	2	j	int
    //   14	154	3	localObject	Object
    //   191	10	3	localIOException	java.io.IOException
    //   64	67	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   46	61	133	java/lang/Exception
    //   46	61	160	finally
    //   108	112	179	java/io/IOException
    //   120	124	183	java/io/IOException
    //   140	144	187	java/io/IOException
    //   167	171	191	java/io/IOException
    //   61	73	195	finally
    //   78	108	195	finally
    //   61	73	199	java/lang/Exception
    //   78	108	199	java/lang/Exception
  }
  
  public static abstract interface ExecuteSqlCallback
  {
    public abstract String preExecute(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.repair.DBDumpUtil
 * JD-Core Version:    0.7.0.1
 */