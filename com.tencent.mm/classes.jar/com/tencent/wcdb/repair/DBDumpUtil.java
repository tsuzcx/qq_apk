package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.PrintStream;
import java.util.ArrayList;

public class DBDumpUtil
{
  private static final String TAG = "WCDB.DBDumpUtil";
  
  public static String buildColumnsString(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
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
    return paramArrayList;
  }
  
  public static boolean doRecoveryDb(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3)
  {
    return doRecoveryDb(paramSQLiteDatabase, paramString1, paramString2, paramString3, null, null, null, true);
  }
  
  /* Error */
  public static boolean doRecoveryDb(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, java.util.List<String> paramList1, java.util.List<String> paramList2, ExecuteSqlCallback paramExecuteSqlCallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 80	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   8: ifne +12 -> 20
    //   11: ldc 11
    //   13: ldc 82
    //   15: invokestatic 88	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_1
    //   21: aload_2
    //   22: aload_3
    //   23: invokestatic 92	com/tencent/wcdb/repair/DBDumpUtil:nativeDumpDB	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   26: ifne +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: new 94	java/io/BufferedReader
    //   34: dup
    //   35: new 96	java/io/FileReader
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 98	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 17
    //   48: aload_0
    //   49: ldc 103
    //   51: invokevirtual 106	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: invokevirtual 109	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   58: iconst_0
    //   59: istore 11
    //   61: iconst_0
    //   62: istore 10
    //   64: iconst_0
    //   65: istore 9
    //   67: new 111	java/util/HashMap
    //   70: dup
    //   71: invokespecial 112	java/util/HashMap:<init>	()V
    //   74: astore 18
    //   76: iconst_0
    //   77: istore 8
    //   79: aconst_null
    //   80: astore_2
    //   81: aload 17
    //   83: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   86: astore 15
    //   88: aload 15
    //   90: ifnull +623 -> 713
    //   93: iload 8
    //   95: ifeq +78 -> 173
    //   98: new 28	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   105: aload_2
    //   106: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 117
    //   111: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 15
    //   116: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 15
    //   124: aload 15
    //   126: ldc 119
    //   128: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   131: ifeq +759 -> 890
    //   134: aload 15
    //   136: invokestatic 126	com/tencent/wcdb/repair/DBDumpUtil:nativeIsSqlComplete	(Ljava/lang/String;)Z
    //   139: istore 14
    //   141: aload 15
    //   143: astore_2
    //   144: iload 14
    //   146: ifne +106 -> 252
    //   149: aload 15
    //   151: astore_2
    //   152: goto -71 -> 81
    //   155: astore_0
    //   156: ldc 11
    //   158: ldc 128
    //   160: iconst_1
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_3
    //   167: aastore
    //   168: invokestatic 131	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: iconst_0
    //   172: ireturn
    //   173: aload 15
    //   175: ldc 133
    //   177: invokevirtual 136	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   180: ifne +13 -> 193
    //   183: aload 15
    //   185: ldc 138
    //   187: invokevirtual 136	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   190: ifeq -109 -> 81
    //   193: aload 15
    //   195: ldc 119
    //   197: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   200: ifeq +11 -> 211
    //   203: aload 15
    //   205: invokestatic 126	com/tencent/wcdb/repair/DBDumpUtil:nativeIsSqlComplete	(Ljava/lang/String;)Z
    //   208: ifne +694 -> 902
    //   211: aload_2
    //   212: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifeq +9 -> 224
    //   218: aload 15
    //   220: astore_2
    //   221: goto +675 -> 896
    //   224: new 28	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   231: aload_2
    //   232: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc 117
    //   237: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 15
    //   242: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: astore_2
    //   249: goto +647 -> 896
    //   252: iconst_0
    //   253: istore 8
    //   255: aload 5
    //   257: ifnull +86 -> 343
    //   260: aload 5
    //   262: invokeinterface 147 1 0
    //   267: ifle +76 -> 343
    //   270: aload_2
    //   271: invokestatic 151	com/tencent/wcdb/repair/DBDumpUtil:getTableNameFromSql	(Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 16
    //   276: aload 5
    //   278: invokeinterface 155 1 0
    //   283: astore 15
    //   285: aload 15
    //   287: invokeinterface 160 1 0
    //   292: ifeq +616 -> 908
    //   295: aload 16
    //   297: aload 15
    //   299: invokeinterface 164 1 0
    //   304: checkcast 41	java/lang/String
    //   307: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   310: ifeq -25 -> 285
    //   313: iconst_0
    //   314: istore 8
    //   316: iload 8
    //   318: ifeq +92 -> 410
    //   321: ldc 11
    //   323: ldc 170
    //   325: iconst_1
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload 16
    //   333: aastore
    //   334: invokestatic 173	com/tencent/wcdb/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: iconst_0
    //   338: istore 8
    //   340: goto -259 -> 81
    //   343: aload 4
    //   345: ifnull +539 -> 884
    //   348: aload 4
    //   350: invokeinterface 147 1 0
    //   355: ifle +529 -> 884
    //   358: aload_2
    //   359: invokestatic 151	com/tencent/wcdb/repair/DBDumpUtil:getTableNameFromSql	(Ljava/lang/String;)Ljava/lang/String;
    //   362: astore 16
    //   364: aload 4
    //   366: invokeinterface 155 1 0
    //   371: astore 15
    //   373: aload 15
    //   375: invokeinterface 160 1 0
    //   380: ifeq +498 -> 878
    //   383: aload 16
    //   385: aload 15
    //   387: invokeinterface 164 1 0
    //   392: checkcast 41	java/lang/String
    //   395: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   398: ifeq -25 -> 373
    //   401: iconst_1
    //   402: istore 8
    //   404: ldc 26
    //   406: astore_2
    //   407: goto -91 -> 316
    //   410: iload 10
    //   412: istore 8
    //   414: aload_2
    //   415: ldc 138
    //   417: invokevirtual 136	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   420: ifeq +144 -> 564
    //   423: iload 10
    //   425: istore 8
    //   427: aload 18
    //   429: aload 16
    //   431: aload_2
    //   432: invokestatic 177	com/tencent/wcdb/repair/DBDumpUtil:getColumnNamesFromSql	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   435: invokestatic 179	com/tencent/wcdb/repair/DBDumpUtil:buildColumnsString	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   438: invokevirtual 183	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   441: pop
    //   442: aload_2
    //   443: astore 15
    //   445: aconst_null
    //   446: astore_2
    //   447: aload 6
    //   449: ifnull +17 -> 466
    //   452: iload 10
    //   454: istore 8
    //   456: aload 6
    //   458: aload 15
    //   460: invokeinterface 186 2 0
    //   465: astore_2
    //   466: iload 10
    //   468: istore 8
    //   470: aload_2
    //   471: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   474: ifne +398 -> 872
    //   477: iload 10
    //   479: iconst_1
    //   480: iadd
    //   481: istore 10
    //   483: iload 10
    //   485: istore 8
    //   487: aload_0
    //   488: aload_2
    //   489: invokevirtual 106	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   492: iload 9
    //   494: iconst_1
    //   495: iadd
    //   496: istore 13
    //   498: iload 13
    //   500: istore 8
    //   502: iload 10
    //   504: istore 9
    //   506: iload 11
    //   508: istore 12
    //   510: iload 13
    //   512: bipush 100
    //   514: if_icmplt +26 -> 540
    //   517: aload_0
    //   518: invokevirtual 189	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   521: aload_0
    //   522: invokevirtual 192	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   525: aload_0
    //   526: invokevirtual 109	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   529: iconst_0
    //   530: istore 8
    //   532: iload 11
    //   534: istore 12
    //   536: iload 10
    //   538: istore 9
    //   540: iconst_0
    //   541: istore 13
    //   543: aconst_null
    //   544: astore_2
    //   545: iload 9
    //   547: istore 10
    //   549: iload 12
    //   551: istore 11
    //   553: iload 8
    //   555: istore 9
    //   557: iload 13
    //   559: istore 8
    //   561: goto -480 -> 81
    //   564: aload_2
    //   565: astore 15
    //   567: iload 10
    //   569: istore 8
    //   571: aload_2
    //   572: ldc 194
    //   574: invokevirtual 136	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   577: ifeq -132 -> 445
    //   580: iload 10
    //   582: istore 8
    //   584: aload 18
    //   586: aload 16
    //   588: invokevirtual 197	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   591: checkcast 41	java/lang/String
    //   594: astore 19
    //   596: aload_2
    //   597: astore 15
    //   599: iload 10
    //   601: istore 8
    //   603: aload 19
    //   605: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   608: ifne -163 -> 445
    //   611: iload 10
    //   613: istore 8
    //   615: new 28	java/lang/StringBuilder
    //   618: dup
    //   619: ldc 199
    //   621: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   624: astore 15
    //   626: iload 10
    //   628: istore 8
    //   630: aload 15
    //   632: ldc 202
    //   634: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: aload 16
    //   639: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: ldc 202
    //   644: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: iload 10
    //   650: istore 8
    //   652: aload 15
    //   654: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: astore 16
    //   659: iload 10
    //   661: istore 8
    //   663: aload 15
    //   665: aload 19
    //   667: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: iload 10
    //   673: istore 8
    //   675: aload_2
    //   676: aload 16
    //   678: aload 15
    //   680: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokevirtual 206	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   686: astore 15
    //   688: goto -243 -> 445
    //   691: astore_2
    //   692: iload 9
    //   694: istore 10
    //   696: iload 8
    //   698: istore 9
    //   700: iload 10
    //   702: istore 8
    //   704: iload 11
    //   706: iconst_1
    //   707: iadd
    //   708: istore 12
    //   710: goto -170 -> 540
    //   713: aload 17
    //   715: invokevirtual 209	java/io/BufferedReader:close	()V
    //   718: iload 10
    //   720: iload 11
    //   722: if_icmple +124 -> 846
    //   725: aload_0
    //   726: invokevirtual 212	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   729: ifeq +7 -> 736
    //   732: aload_0
    //   733: invokevirtual 189	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   736: aload_0
    //   737: invokevirtual 212	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   740: ifeq +7 -> 747
    //   743: aload_0
    //   744: invokevirtual 192	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   747: iload 7
    //   749: ifeq +45 -> 794
    //   752: new 214	java/io/File
    //   755: dup
    //   756: aload_3
    //   757: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   760: astore_0
    //   761: aload_0
    //   762: invokevirtual 218	java/io/File:exists	()Z
    //   765: ifeq +8 -> 773
    //   768: aload_0
    //   769: invokevirtual 221	java/io/File:delete	()Z
    //   772: pop
    //   773: new 214	java/io/File
    //   776: dup
    //   777: aload_1
    //   778: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   781: astore_0
    //   782: aload_0
    //   783: invokevirtual 218	java/io/File:exists	()Z
    //   786: ifeq +8 -> 794
    //   789: aload_0
    //   790: invokevirtual 221	java/io/File:delete	()Z
    //   793: pop
    //   794: ldc 11
    //   796: ldc 223
    //   798: iconst_2
    //   799: anewarray 4	java/lang/Object
    //   802: dup
    //   803: iconst_0
    //   804: iload 10
    //   806: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   809: aastore
    //   810: dup
    //   811: iconst_1
    //   812: iload 11
    //   814: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aastore
    //   818: invokestatic 173	com/tencent/wcdb/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   821: iconst_1
    //   822: ireturn
    //   823: astore_0
    //   824: ldc 11
    //   826: ldc 231
    //   828: invokestatic 88	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: aload 17
    //   833: invokevirtual 209	java/io/BufferedReader:close	()V
    //   836: iconst_0
    //   837: ireturn
    //   838: astore_0
    //   839: aload 17
    //   841: invokevirtual 209	java/io/BufferedReader:close	()V
    //   844: aload_0
    //   845: athrow
    //   846: iconst_0
    //   847: ireturn
    //   848: astore_2
    //   849: goto -131 -> 718
    //   852: astore_0
    //   853: goto -17 -> 836
    //   856: astore_1
    //   857: goto -13 -> 844
    //   860: astore_2
    //   861: iload 13
    //   863: istore 8
    //   865: iload 10
    //   867: istore 9
    //   869: goto -165 -> 704
    //   872: aload 15
    //   874: astore_2
    //   875: goto -398 -> 477
    //   878: iconst_0
    //   879: istore 8
    //   881: goto -565 -> 316
    //   884: aconst_null
    //   885: astore 16
    //   887: goto -571 -> 316
    //   890: aload 15
    //   892: astore_2
    //   893: goto -812 -> 81
    //   896: iconst_1
    //   897: istore 8
    //   899: goto -818 -> 81
    //   902: aload 15
    //   904: astore_2
    //   905: goto -653 -> 252
    //   908: iconst_1
    //   909: istore 8
    //   911: goto -595 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	914	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	914	1	paramString1	String
    //   0	914	2	paramString2	String
    //   0	914	3	paramString3	String
    //   0	914	4	paramList1	java.util.List<String>
    //   0	914	5	paramList2	java.util.List<String>
    //   0	914	6	paramExecuteSqlCallback	ExecuteSqlCallback
    //   0	914	7	paramBoolean	boolean
    //   77	833	8	i	int
    //   65	803	9	j	int
    //   62	804	10	k	int
    //   59	754	11	m	int
    //   508	201	12	n	int
    //   496	366	13	i1	int
    //   139	6	14	bool	boolean
    //   86	817	15	localObject	Object
    //   274	612	16	str1	String
    //   46	794	17	localBufferedReader	java.io.BufferedReader
    //   74	511	18	localHashMap	java.util.HashMap
    //   594	72	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   31	48	155	java/io/FileNotFoundException
    //   414	423	691	java/lang/Exception
    //   427	442	691	java/lang/Exception
    //   456	466	691	java/lang/Exception
    //   470	477	691	java/lang/Exception
    //   487	492	691	java/lang/Exception
    //   571	580	691	java/lang/Exception
    //   584	596	691	java/lang/Exception
    //   603	611	691	java/lang/Exception
    //   615	626	691	java/lang/Exception
    //   630	648	691	java/lang/Exception
    //   652	659	691	java/lang/Exception
    //   663	671	691	java/lang/Exception
    //   675	688	691	java/lang/Exception
    //   67	76	823	java/io/IOException
    //   81	88	823	java/io/IOException
    //   98	141	823	java/io/IOException
    //   173	193	823	java/io/IOException
    //   193	211	823	java/io/IOException
    //   211	218	823	java/io/IOException
    //   224	249	823	java/io/IOException
    //   260	285	823	java/io/IOException
    //   285	313	823	java/io/IOException
    //   321	337	823	java/io/IOException
    //   348	373	823	java/io/IOException
    //   373	401	823	java/io/IOException
    //   414	423	823	java/io/IOException
    //   427	442	823	java/io/IOException
    //   456	466	823	java/io/IOException
    //   470	477	823	java/io/IOException
    //   487	492	823	java/io/IOException
    //   517	529	823	java/io/IOException
    //   571	580	823	java/io/IOException
    //   584	596	823	java/io/IOException
    //   603	611	823	java/io/IOException
    //   615	626	823	java/io/IOException
    //   630	648	823	java/io/IOException
    //   652	659	823	java/io/IOException
    //   663	671	823	java/io/IOException
    //   675	688	823	java/io/IOException
    //   67	76	838	finally
    //   81	88	838	finally
    //   98	141	838	finally
    //   173	193	838	finally
    //   193	211	838	finally
    //   211	218	838	finally
    //   224	249	838	finally
    //   260	285	838	finally
    //   285	313	838	finally
    //   321	337	838	finally
    //   348	373	838	finally
    //   373	401	838	finally
    //   414	423	838	finally
    //   427	442	838	finally
    //   456	466	838	finally
    //   470	477	838	finally
    //   487	492	838	finally
    //   517	529	838	finally
    //   571	580	838	finally
    //   584	596	838	finally
    //   603	611	838	finally
    //   615	626	838	finally
    //   630	648	838	finally
    //   652	659	838	finally
    //   663	671	838	finally
    //   675	688	838	finally
    //   824	831	838	finally
    //   713	718	848	java/io/IOException
    //   831	836	852	java/io/IOException
    //   839	844	856	java/io/IOException
    //   517	529	860	java/lang/Exception
  }
  
  public static ArrayList<String> getColumnNamesFromSql(String paramString)
  {
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
    return localArrayList;
  }
  
  public static String getTableNameFromSql(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 100) {
      str = paramString.substring(0, 100);
    }
    paramString = str.split("\\s");
    if ((paramString != null) && (paramString.length > 1)) {
      return paramString[2].replaceAll("\"", "");
    }
    return null;
  }
  
  private static native boolean nativeDumpDB(String paramString1, String paramString2, String paramString3);
  
  private static native boolean nativeIsSqlComplete(String paramString);
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: new 214	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 218	java/io/File:exists	()Z
    //   13: ifne +21 -> 34
    //   16: ldc 11
    //   18: ldc_w 270
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: aastore
    //   29: invokestatic 131	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aconst_null
    //   33: areturn
    //   34: aload_3
    //   35: invokevirtual 273	java/io/File:length	()J
    //   38: l2i
    //   39: istore_1
    //   40: new 275	java/io/FileInputStream
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 278	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: astore_3
    //   49: iload_1
    //   50: newarray byte
    //   52: astore 4
    //   54: aload_3
    //   55: aload 4
    //   57: invokevirtual 282	java/io/FileInputStream:read	([B)I
    //   60: istore_2
    //   61: iload_2
    //   62: iload_1
    //   63: if_icmpeq +42 -> 105
    //   66: ldc 11
    //   68: ldc_w 284
    //   71: iconst_3
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: iload_1
    //   82: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: dup
    //   87: iconst_2
    //   88: iload_2
    //   89: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: invokestatic 131	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload_3
    //   97: invokevirtual 285	java/io/FileInputStream:close	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: areturn
    //   105: aload_3
    //   106: invokevirtual 285	java/io/FileInputStream:close	()V
    //   109: aload 4
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 285	java/io/FileInputStream:close	()V
    //   123: ldc 11
    //   125: ldc_w 287
    //   128: invokestatic 290	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 285	java/io/FileInputStream:close	()V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: goto -38 -> 109
    //   150: astore_0
    //   151: goto -28 -> 123
    //   154: astore_3
    //   155: goto -11 -> 144
    //   158: astore_0
    //   159: goto -23 -> 136
    //   162: astore_0
    //   163: aload_3
    //   164: astore_0
    //   165: goto -50 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   39	43	1	i	int
    //   60	29	2	j	int
    //   8	133	3	localObject	Object
    //   154	10	3	localIOException	java.io.IOException
    //   52	58	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   96	100	102	java/io/IOException
    //   34	49	112	java/lang/Exception
    //   34	49	133	finally
    //   105	109	146	java/io/IOException
    //   119	123	150	java/io/IOException
    //   140	144	154	java/io/IOException
    //   49	61	158	finally
    //   66	96	158	finally
    //   49	61	162	java/lang/Exception
    //   66	96	162	java/lang/Exception
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