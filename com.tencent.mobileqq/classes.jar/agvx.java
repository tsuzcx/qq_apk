import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class agvx
{
  private agvw jdField_a_of_type_Agvw;
  private agvz jdField_a_of_type_Agvz;
  private Context jdField_a_of_type_AndroidContentContext;
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private String jdField_a_of_type_JavaLangString;
  
  public agvx(agvz paramagvz)
  {
    this.jdField_a_of_type_Agvw = new agvw(paramagvz.jdField_a_of_type_AndroidContentContext, paramagvz.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentContext = paramagvz.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_JavaLangString = paramagvz.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Agvz = paramagvz;
  }
  
  /* Error */
  public java.util.HashMap<String, String> a()
  {
    // Byte code:
    //   0: new 38	java/util/HashMap
    //   3: dup
    //   4: invokespecial 39	java/util/HashMap:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 28	agvx:jdField_a_of_type_Agvw	Lagvw;
    //   14: invokevirtual 43	agvw:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 47
    //   26: iconst_4
    //   27: anewarray 49	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 51
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc 53
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: ldc 55
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: ldc 57
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 63	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 6
    //   60: aload 6
    //   62: ifnull +239 -> 301
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: ldc 51
    //   73: invokeinterface 69 2 0
    //   78: istore_1
    //   79: aload 6
    //   81: astore 5
    //   83: aload 6
    //   85: ldc 53
    //   87: invokeinterface 69 2 0
    //   92: istore_2
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: ldc 55
    //   101: invokeinterface 69 2 0
    //   106: istore_3
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: ldc 57
    //   115: invokeinterface 69 2 0
    //   120: istore 4
    //   122: aload 6
    //   124: astore 5
    //   126: aload 6
    //   128: invokeinterface 73 1 0
    //   133: ifeq +168 -> 301
    //   136: aload 6
    //   138: astore 5
    //   140: new 75	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   147: astore 8
    //   149: aload 6
    //   151: astore 5
    //   153: aload 8
    //   155: aload 6
    //   157: iload_3
    //   158: invokeinterface 80 2 0
    //   163: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: astore 5
    //   171: aload 8
    //   173: ldc 86
    //   175: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 6
    //   181: astore 5
    //   183: aload 8
    //   185: aload 6
    //   187: iload_2
    //   188: invokeinterface 80 2 0
    //   193: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: astore 5
    //   201: aload 8
    //   203: ldc 86
    //   205: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 6
    //   211: astore 5
    //   213: aload 8
    //   215: aload 6
    //   217: iload_1
    //   218: invokeinterface 80 2 0
    //   223: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 6
    //   229: astore 5
    //   231: aload 7
    //   233: aload 8
    //   235: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: aload 6
    //   240: iload 4
    //   242: invokeinterface 80 2 0
    //   247: invokevirtual 94	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: goto -129 -> 122
    //   254: astore 7
    //   256: aload 6
    //   258: astore 5
    //   260: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +15 -> 278
    //   266: aload 6
    //   268: astore 5
    //   270: ldc 101
    //   272: iconst_2
    //   273: ldc 103
    //   275: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload 6
    //   280: astore 5
    //   282: aload 7
    //   284: invokevirtual 110	java/lang/Throwable:printStackTrace	()V
    //   287: aload 6
    //   289: ifnull +60 -> 349
    //   292: aload 6
    //   294: invokeinterface 113 1 0
    //   299: aconst_null
    //   300: areturn
    //   301: aload 6
    //   303: ifnull +48 -> 351
    //   306: aload 6
    //   308: invokeinterface 113 1 0
    //   313: aload 7
    //   315: areturn
    //   316: astore 6
    //   318: aconst_null
    //   319: astore 5
    //   321: aload 5
    //   323: ifnull +10 -> 333
    //   326: aload 5
    //   328: invokeinterface 113 1 0
    //   333: aload 6
    //   335: athrow
    //   336: astore 6
    //   338: goto -17 -> 321
    //   341: astore 7
    //   343: aconst_null
    //   344: astore 6
    //   346: goto -90 -> 256
    //   349: aconst_null
    //   350: areturn
    //   351: aload 7
    //   353: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	agvx
    //   78	140	1	i	int
    //   92	96	2	j	int
    //   106	52	3	k	int
    //   120	121	4	m	int
    //   67	260	5	localCursor1	android.database.Cursor
    //   58	249	6	localCursor2	android.database.Cursor
    //   316	18	6	localObject1	Object
    //   336	1	6	localObject2	Object
    //   344	1	6	localObject3	Object
    //   7	225	7	localHashMap	java.util.HashMap
    //   254	60	7	localThrowable1	Throwable
    //   341	11	7	localThrowable2	Throwable
    //   147	87	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	79	254	java/lang/Throwable
    //   83	93	254	java/lang/Throwable
    //   97	107	254	java/lang/Throwable
    //   111	122	254	java/lang/Throwable
    //   126	136	254	java/lang/Throwable
    //   140	149	254	java/lang/Throwable
    //   153	167	254	java/lang/Throwable
    //   171	179	254	java/lang/Throwable
    //   183	197	254	java/lang/Throwable
    //   201	209	254	java/lang/Throwable
    //   213	227	254	java/lang/Throwable
    //   231	251	254	java/lang/Throwable
    //   9	60	316	finally
    //   69	79	336	finally
    //   83	93	336	finally
    //   97	107	336	finally
    //   111	122	336	finally
    //   126	136	336	finally
    //   140	149	336	finally
    //   153	167	336	finally
    //   171	179	336	finally
    //   183	197	336	finally
    //   201	209	336	finally
    //   213	227	336	finally
    //   231	251	336	finally
    //   260	266	336	finally
    //   270	278	336	finally
    //   282	287	336	finally
    //   9	60	341	java/lang/Throwable
  }
  
  /* Error */
  public java.util.List<agvy> a()
  {
    // Byte code:
    //   0: new 120	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 121	java/util/ArrayList:<init>	()V
    //   7: astore 16
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 28	agvx:jdField_a_of_type_Agvw	Lagvw;
    //   14: invokevirtual 43	agvw:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 123
    //   26: bipush 11
    //   28: anewarray 49	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 51
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 125
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 127
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc 129
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc 131
    //   55: aastore
    //   56: dup
    //   57: iconst_5
    //   58: ldc 133
    //   60: aastore
    //   61: dup
    //   62: bipush 6
    //   64: ldc 135
    //   66: aastore
    //   67: dup
    //   68: bipush 7
    //   70: ldc 137
    //   72: aastore
    //   73: dup
    //   74: bipush 8
    //   76: ldc 139
    //   78: aastore
    //   79: dup
    //   80: bipush 9
    //   82: ldc 141
    //   84: aastore
    //   85: dup
    //   86: bipush 10
    //   88: ldc 143
    //   90: aastore
    //   91: aconst_null
    //   92: aconst_null
    //   93: aconst_null
    //   94: aconst_null
    //   95: ldc 145
    //   97: invokevirtual 63	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   100: astore 14
    //   102: aload 14
    //   104: ifnull +509 -> 613
    //   107: aload 14
    //   109: astore 13
    //   111: aload 14
    //   113: ldc 51
    //   115: invokeinterface 69 2 0
    //   120: istore_1
    //   121: aload 14
    //   123: astore 13
    //   125: aload 14
    //   127: ldc 125
    //   129: invokeinterface 69 2 0
    //   134: istore_2
    //   135: aload 14
    //   137: astore 13
    //   139: aload 14
    //   141: ldc 127
    //   143: invokeinterface 69 2 0
    //   148: istore_3
    //   149: aload 14
    //   151: astore 13
    //   153: aload 14
    //   155: ldc 129
    //   157: invokeinterface 69 2 0
    //   162: istore 4
    //   164: aload 14
    //   166: astore 13
    //   168: aload 14
    //   170: ldc 131
    //   172: invokeinterface 69 2 0
    //   177: istore 5
    //   179: aload 14
    //   181: astore 13
    //   183: aload 14
    //   185: ldc 133
    //   187: invokeinterface 69 2 0
    //   192: istore 6
    //   194: aload 14
    //   196: astore 13
    //   198: aload 14
    //   200: ldc 135
    //   202: invokeinterface 69 2 0
    //   207: istore 7
    //   209: aload 14
    //   211: astore 13
    //   213: aload 14
    //   215: ldc 137
    //   217: invokeinterface 69 2 0
    //   222: istore 8
    //   224: aload 14
    //   226: astore 13
    //   228: aload 14
    //   230: ldc 139
    //   232: invokeinterface 69 2 0
    //   237: istore 9
    //   239: aload 14
    //   241: astore 13
    //   243: aload 14
    //   245: ldc 141
    //   247: invokeinterface 69 2 0
    //   252: istore 10
    //   254: aload 14
    //   256: astore 13
    //   258: aload 14
    //   260: ldc 143
    //   262: invokeinterface 69 2 0
    //   267: istore 11
    //   269: aload 14
    //   271: astore 13
    //   273: aload 14
    //   275: invokeinterface 73 1 0
    //   280: ifeq +333 -> 613
    //   283: aload 14
    //   285: astore 13
    //   287: new 147	agvy
    //   290: dup
    //   291: invokespecial 148	agvy:<init>	()V
    //   294: astore 15
    //   296: aload 14
    //   298: astore 13
    //   300: aload 14
    //   302: iload 7
    //   304: invokeinterface 152 2 0
    //   309: iconst_1
    //   310: if_icmpne +285 -> 595
    //   313: iconst_1
    //   314: istore 12
    //   316: aload 14
    //   318: astore 13
    //   320: aload 15
    //   322: iload 12
    //   324: putfield 156	agvy:jdField_b_of_type_Boolean	Z
    //   327: aload 14
    //   329: astore 13
    //   331: aload 14
    //   333: iload 6
    //   335: invokeinterface 152 2 0
    //   340: iconst_1
    //   341: if_icmpne +260 -> 601
    //   344: iconst_1
    //   345: istore 12
    //   347: aload 14
    //   349: astore 13
    //   351: aload 15
    //   353: iload 12
    //   355: putfield 158	agvy:jdField_a_of_type_Boolean	Z
    //   358: aload 14
    //   360: astore 13
    //   362: aload 15
    //   364: aload 14
    //   366: iload 5
    //   368: invokeinterface 80 2 0
    //   373: putfield 160	agvy:d	Ljava/lang/String;
    //   376: aload 14
    //   378: astore 13
    //   380: aload 15
    //   382: aload 14
    //   384: iload_1
    //   385: invokeinterface 80 2 0
    //   390: putfield 161	agvy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   393: aload 14
    //   395: astore 13
    //   397: aload 15
    //   399: aload 14
    //   401: iload_2
    //   402: invokeinterface 80 2 0
    //   407: putfield 163	agvy:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   410: aload 14
    //   412: astore 13
    //   414: aload 15
    //   416: aload 14
    //   418: iload_3
    //   419: invokeinterface 80 2 0
    //   424: putfield 166	agvy:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   427: aload 14
    //   429: astore 13
    //   431: aload 15
    //   433: aload 14
    //   435: iload 4
    //   437: invokeinterface 170 2 0
    //   442: putfield 173	agvy:jdField_a_of_type_Long	J
    //   445: aload 14
    //   447: astore 13
    //   449: aload 14
    //   451: iload 8
    //   453: invokeinterface 152 2 0
    //   458: iconst_1
    //   459: if_icmpne +148 -> 607
    //   462: iconst_1
    //   463: istore 12
    //   465: aload 14
    //   467: astore 13
    //   469: aload 15
    //   471: iload 12
    //   473: putfield 175	agvy:jdField_c_of_type_Boolean	Z
    //   476: aload 14
    //   478: astore 13
    //   480: aload 15
    //   482: aload 14
    //   484: iload 9
    //   486: invokeinterface 152 2 0
    //   491: putfield 178	agvy:jdField_a_of_type_Int	I
    //   494: aload 14
    //   496: astore 13
    //   498: aload 15
    //   500: aload 14
    //   502: iload 10
    //   504: invokeinterface 80 2 0
    //   509: putfield 181	agvy:e	Ljava/lang/String;
    //   512: aload 14
    //   514: astore 13
    //   516: aload 15
    //   518: aload 14
    //   520: iload 11
    //   522: invokeinterface 80 2 0
    //   527: putfield 184	agvy:f	Ljava/lang/String;
    //   530: aload 14
    //   532: astore 13
    //   534: aload 16
    //   536: aload 15
    //   538: invokeinterface 190 2 0
    //   543: pop
    //   544: goto -275 -> 269
    //   547: astore 15
    //   549: aload 14
    //   551: astore 13
    //   553: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq +15 -> 571
    //   559: aload 14
    //   561: astore 13
    //   563: ldc 101
    //   565: iconst_2
    //   566: ldc 192
    //   568: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: aload 14
    //   573: astore 13
    //   575: aload 15
    //   577: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   580: aload 14
    //   582: ifnull +10 -> 592
    //   585: aload 14
    //   587: invokeinterface 113 1 0
    //   592: aload 16
    //   594: areturn
    //   595: iconst_0
    //   596: istore 12
    //   598: goto -282 -> 316
    //   601: iconst_0
    //   602: istore 12
    //   604: goto -257 -> 347
    //   607: iconst_0
    //   608: istore 12
    //   610: goto -145 -> 465
    //   613: aload 14
    //   615: ifnull -23 -> 592
    //   618: aload 14
    //   620: invokeinterface 113 1 0
    //   625: aload 16
    //   627: areturn
    //   628: astore 14
    //   630: aconst_null
    //   631: astore 13
    //   633: aload 13
    //   635: ifnull +10 -> 645
    //   638: aload 13
    //   640: invokeinterface 113 1 0
    //   645: aload 14
    //   647: athrow
    //   648: astore 14
    //   650: goto -17 -> 633
    //   653: astore 15
    //   655: aconst_null
    //   656: astore 14
    //   658: goto -109 -> 549
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	agvx
    //   120	265	1	i	int
    //   134	268	2	j	int
    //   148	271	3	k	int
    //   162	274	4	m	int
    //   177	190	5	n	int
    //   192	142	6	i1	int
    //   207	96	7	i2	int
    //   222	230	8	i3	int
    //   237	248	9	i4	int
    //   252	251	10	i5	int
    //   267	254	11	i6	int
    //   314	295	12	bool	boolean
    //   109	530	13	localCursor1	android.database.Cursor
    //   100	519	14	localCursor2	android.database.Cursor
    //   628	18	14	localObject1	Object
    //   648	1	14	localObject2	Object
    //   656	1	14	localObject3	Object
    //   294	243	15	localagvy	agvy
    //   547	29	15	localException1	Exception
    //   653	1	15	localException2	Exception
    //   7	619	16	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   111	121	547	java/lang/Exception
    //   125	135	547	java/lang/Exception
    //   139	149	547	java/lang/Exception
    //   153	164	547	java/lang/Exception
    //   168	179	547	java/lang/Exception
    //   183	194	547	java/lang/Exception
    //   198	209	547	java/lang/Exception
    //   213	224	547	java/lang/Exception
    //   228	239	547	java/lang/Exception
    //   243	254	547	java/lang/Exception
    //   258	269	547	java/lang/Exception
    //   273	283	547	java/lang/Exception
    //   287	296	547	java/lang/Exception
    //   300	313	547	java/lang/Exception
    //   320	327	547	java/lang/Exception
    //   331	344	547	java/lang/Exception
    //   351	358	547	java/lang/Exception
    //   362	376	547	java/lang/Exception
    //   380	393	547	java/lang/Exception
    //   397	410	547	java/lang/Exception
    //   414	427	547	java/lang/Exception
    //   431	445	547	java/lang/Exception
    //   449	462	547	java/lang/Exception
    //   469	476	547	java/lang/Exception
    //   480	494	547	java/lang/Exception
    //   498	512	547	java/lang/Exception
    //   516	530	547	java/lang/Exception
    //   534	544	547	java/lang/Exception
    //   9	102	628	finally
    //   111	121	648	finally
    //   125	135	648	finally
    //   139	149	648	finally
    //   153	164	648	finally
    //   168	179	648	finally
    //   183	194	648	finally
    //   198	209	648	finally
    //   213	224	648	finally
    //   228	239	648	finally
    //   243	254	648	finally
    //   258	269	648	finally
    //   273	283	648	finally
    //   287	296	648	finally
    //   300	313	648	finally
    //   320	327	648	finally
    //   331	344	648	finally
    //   351	358	648	finally
    //   362	376	648	finally
    //   380	393	648	finally
    //   397	410	648	finally
    //   414	427	648	finally
    //   431	445	648	finally
    //   449	462	648	finally
    //   469	476	648	finally
    //   480	494	648	finally
    //   498	512	648	finally
    //   516	530	648	finally
    //   534	544	648	finally
    //   553	559	648	finally
    //   563	571	648	finally
    //   575	580	648	finally
    //   9	102	653	java/lang/Exception
  }
  
  /* Error */
  public java.util.List<agwi> a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 120	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 121	java/util/ArrayList:<init>	()V
    //   10: astore 7
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 28	agvx:jdField_a_of_type_Agvw	Lagvw;
    //   17: invokevirtual 43	agvw:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: putfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_0
    //   24: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 4
    //   29: new 75	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   36: iload_1
    //   37: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc 200
    //   42: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 6
    //   50: aload 4
    //   52: ldc 202
    //   54: iconst_2
    //   55: anewarray 49	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc 53
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: ldc 204
    //   67: aastore
    //   68: ldc 206
    //   70: iconst_1
    //   71: anewarray 49	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: aload 6
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokevirtual 63	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 4
    //   87: aload 4
    //   89: astore 5
    //   91: aload 5
    //   93: ifnull +167 -> 260
    //   96: aload 5
    //   98: astore 4
    //   100: aload 5
    //   102: ldc 53
    //   104: invokeinterface 69 2 0
    //   109: istore_2
    //   110: aload 5
    //   112: astore 4
    //   114: aload 5
    //   116: ldc 204
    //   118: invokeinterface 69 2 0
    //   123: istore_3
    //   124: aload 5
    //   126: astore 4
    //   128: aload 5
    //   130: invokeinterface 73 1 0
    //   135: ifeq +125 -> 260
    //   138: aload 5
    //   140: astore 4
    //   142: new 208	agwi
    //   145: dup
    //   146: invokespecial 209	agwi:<init>	()V
    //   149: astore 6
    //   151: aload 5
    //   153: astore 4
    //   155: aload 6
    //   157: iload_1
    //   158: putfield 210	agwi:jdField_a_of_type_Int	I
    //   161: aload 5
    //   163: astore 4
    //   165: aload 6
    //   167: aload 5
    //   169: iload_2
    //   170: invokeinterface 170 2 0
    //   175: putfield 211	agwi:jdField_a_of_type_Long	J
    //   178: aload 5
    //   180: astore 4
    //   182: aload 6
    //   184: aload 5
    //   186: iload_3
    //   187: invokeinterface 170 2 0
    //   192: putfield 213	agwi:b	J
    //   195: aload 5
    //   197: astore 4
    //   199: aload 7
    //   201: aload 6
    //   203: invokeinterface 190 2 0
    //   208: pop
    //   209: goto -85 -> 124
    //   212: astore 6
    //   214: aload 5
    //   216: astore 4
    //   218: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +15 -> 236
    //   224: aload 5
    //   226: astore 4
    //   228: ldc 101
    //   230: iconst_2
    //   231: ldc 215
    //   233: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 5
    //   238: astore 4
    //   240: aload 6
    //   242: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   245: aload 5
    //   247: ifnull +10 -> 257
    //   250: aload 5
    //   252: invokeinterface 113 1 0
    //   257: aload 7
    //   259: areturn
    //   260: aload 5
    //   262: ifnull -5 -> 257
    //   265: aload 5
    //   267: invokeinterface 113 1 0
    //   272: aload 7
    //   274: areturn
    //   275: astore 4
    //   277: aload 5
    //   279: ifnull +10 -> 289
    //   282: aload 5
    //   284: invokeinterface 113 1 0
    //   289: aload 4
    //   291: athrow
    //   292: astore 6
    //   294: aload 4
    //   296: astore 5
    //   298: aload 6
    //   300: astore 4
    //   302: goto -25 -> 277
    //   305: astore 6
    //   307: aconst_null
    //   308: astore 5
    //   310: goto -96 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	agvx
    //   0	313	1	paramInt	int
    //   109	61	2	i	int
    //   123	64	3	j	int
    //   27	212	4	localObject1	Object
    //   275	20	4	localObject2	Object
    //   300	1	4	localObject3	Object
    //   1	308	5	localObject4	Object
    //   48	154	6	localObject5	Object
    //   212	29	6	localException1	Exception
    //   292	7	6	localObject6	Object
    //   305	1	6	localException2	Exception
    //   10	263	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   100	110	212	java/lang/Exception
    //   114	124	212	java/lang/Exception
    //   128	138	212	java/lang/Exception
    //   142	151	212	java/lang/Exception
    //   155	161	212	java/lang/Exception
    //   165	178	212	java/lang/Exception
    //   182	195	212	java/lang/Exception
    //   199	209	212	java/lang/Exception
    //   12	87	275	finally
    //   100	110	292	finally
    //   114	124	292	finally
    //   128	138	292	finally
    //   142	151	292	finally
    //   155	161	292	finally
    //   165	178	292	finally
    //   182	195	292	finally
    //   199	209	292	finally
    //   218	224	292	finally
    //   228	236	292	finally
    //   240	245	292	finally
    //   12	87	305	java/lang/Exception
  }
  
  public JSONObject a(String paramString)
  {
    if (bbjw.a(paramString)) {
      return new JSONObject();
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return new JSONObject();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null) {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
    }
  }
  
  public void a(agvy paramagvy)
  {
    int j = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Agvw.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramagvy.jdField_a_of_type_JavaLangString);
      localContentValues.put("redbag_index", paramagvy.jdField_b_of_type_JavaLangString);
      localContentValues.put("uint64_creator_uin", paramagvy.jdField_c_of_type_JavaLangString);
      localContentValues.put("expire_time", Long.valueOf(paramagvy.jdField_a_of_type_Long));
      localContentValues.put("password", paramagvy.d);
      if (paramagvy.jdField_a_of_type_Boolean)
      {
        i = 1;
        localContentValues.put("is_open", Integer.valueOf(i));
        if (!paramagvy.jdField_b_of_type_Boolean) {
          break label195;
        }
        i = 1;
        label109:
        localContentValues.put("is_finish", Integer.valueOf(i));
        if (!paramagvy.jdField_c_of_type_Boolean) {
          break label200;
        }
      }
      label195:
      label200:
      for (int i = j;; i = 0)
      {
        localContentValues.put("is_overdue", Integer.valueOf(i));
        localContentValues.put("redbag_type", Integer.valueOf(paramagvy.jdField_a_of_type_Int));
        localContentValues.put("last_password", paramagvy.e);
        localContentValues.put("ext_str", paramagvy.f);
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("red_bags", null, localContentValues);
        return;
        i = 0;
        break;
        i = 0;
        break label109;
      }
      return;
    }
    catch (Exception paramagvy)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "insertPasswdRedBag failed ");
      }
      paramagvy.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Agvw.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("last_password", paramString2);
      localContentValues.put("ext_str", paramString3);
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString1 });
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setLastPasswd success result " + i);
      }
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setLastPasswd failed " + paramString1);
      }
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Agvw.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramString3);
      localContentValues.put("source", paramString1);
      localContentValues.put("code", paramString2);
      localContentValues.put("authkey", paramString4);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("red_bag_relations", null, localContentValues);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "insertPasswdRedBagRelation failed ");
      }
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "setOpen|id: " + paramString + " isOpen: " + paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Agvw.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_open", Integer.valueOf(i));
        i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagManager", 2, "setOpen result " + i);
        }
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setOpen failed ");
      }
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public void a(java.util.List<agwi> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 28	agvx:jdField_a_of_type_Agvw	Lagvw;
    //   7: invokevirtual 43	agvw:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: putfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   13: aload_0
    //   14: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   17: invokevirtual 292	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   20: new 232	android/content/ContentValues
    //   23: dup
    //   24: invokespecial 233	android/content/ContentValues:<init>	()V
    //   27: astore_2
    //   28: aload_1
    //   29: invokeinterface 296 1 0
    //   34: astore_1
    //   35: aload_1
    //   36: invokeinterface 301 1 0
    //   41: ifeq +103 -> 144
    //   44: aload_1
    //   45: invokeinterface 305 1 0
    //   50: checkcast 208	agwi
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 308	android/content/ContentValues:clear	()V
    //   58: aload_2
    //   59: ldc 53
    //   61: aload_3
    //   62: getfield 211	agwi:jdField_a_of_type_Long	J
    //   65: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: invokevirtual 245	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   71: aload_2
    //   72: ldc 55
    //   74: aload_3
    //   75: getfield 210	agwi:jdField_a_of_type_Int	I
    //   78: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   84: aload_2
    //   85: ldc 204
    //   87: aload_3
    //   88: getfield 213	agwi:b	J
    //   91: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: invokevirtual 245	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   97: aload_0
    //   98: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   101: ldc 202
    //   103: aconst_null
    //   104: aload_2
    //   105: invokevirtual 257	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   108: pop2
    //   109: goto -74 -> 35
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 110	java/lang/Throwable:printStackTrace	()V
    //   117: aload_0
    //   118: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   121: ifnull +20 -> 141
    //   124: aload_0
    //   125: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   128: invokevirtual 311	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   131: ifeq +10 -> 141
    //   134: aload_0
    //   135: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   138: invokevirtual 314	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: aload_0
    //   145: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   148: invokevirtual 317	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   151: aload_0
    //   152: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   155: ifnull -14 -> 141
    //   158: aload_0
    //   159: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   162: invokevirtual 311	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   165: ifeq -24 -> 141
    //   168: aload_0
    //   169: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   172: invokevirtual 314	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   175: goto -34 -> 141
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 110	java/lang/Throwable:printStackTrace	()V
    //   183: goto -42 -> 141
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 110	java/lang/Throwable:printStackTrace	()V
    //   196: goto -55 -> 141
    //   199: astore_1
    //   200: aload_0
    //   201: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   204: ifnull +20 -> 224
    //   207: aload_0
    //   208: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   211: invokevirtual 311	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   214: ifeq +10 -> 224
    //   217: aload_0
    //   218: getfield 45	agvx:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   221: invokevirtual 314	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   224: aload_1
    //   225: athrow
    //   226: astore_2
    //   227: aload_2
    //   228: invokevirtual 110	java/lang/Throwable:printStackTrace	()V
    //   231: goto -7 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	agvx
    //   0	234	1	paramList	java.util.List<agwi>
    //   27	78	2	localContentValues	ContentValues
    //   226	2	2	localThrowable	Throwable
    //   53	35	3	localagwi	agwi
    // Exception table:
    //   from	to	target	type
    //   2	35	112	java/lang/Throwable
    //   35	109	112	java/lang/Throwable
    //   144	151	112	java/lang/Throwable
    //   151	175	178	java/lang/Throwable
    //   117	141	186	finally
    //   151	175	186	finally
    //   179	183	186	finally
    //   192	196	186	finally
    //   200	224	186	finally
    //   224	226	186	finally
    //   227	231	186	finally
    //   117	141	191	java/lang/Throwable
    //   2	35	199	finally
    //   35	109	199	finally
    //   113	117	199	finally
    //   144	151	199	finally
    //   200	224	226	java/lang/Throwable
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Agvw.getWritableDatabase();
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("red_bags", "expire_time < ?", new String[] { String.valueOf(l) });
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "clearExpirePasswdRedBag failed ");
      }
      localException.printStackTrace();
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    int i = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Agvw.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_finish", Integer.valueOf(i));
        i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagManager", 2, "setFinish result " + i);
        }
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setFinish failed ");
      }
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 22
    //   3: aconst_null
    //   4: astore 23
    //   6: aload_0
    //   7: getfield 29	agvx:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   10: ldc_w 343
    //   13: invokevirtual 349	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore 24
    //   18: aload 24
    //   20: invokevirtual 354	java/io/File:exists	()Z
    //   23: istore 16
    //   25: iload 16
    //   27: ifne +28 -> 55
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 356	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 357	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 356	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 357	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: return
    //   55: aload 24
    //   57: invokevirtual 360	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: aconst_null
    //   61: iconst_0
    //   62: invokestatic 364	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   65: astore 24
    //   67: aload 24
    //   69: astore 22
    //   71: aload 22
    //   73: ifnonnull +26 -> 99
    //   76: iconst_0
    //   77: ifeq +11 -> 88
    //   80: new 356	java/lang/NullPointerException
    //   83: dup
    //   84: invokespecial 357	java/lang/NullPointerException:<init>	()V
    //   87: athrow
    //   88: aload 22
    //   90: ifnull -36 -> 54
    //   93: aload 22
    //   95: invokevirtual 229	android/database/sqlite/SQLiteDatabase:close	()V
    //   98: return
    //   99: aload 22
    //   101: ldc_w 366
    //   104: iconst_1
    //   105: anewarray 49	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload_0
    //   111: getfield 30	agvx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   114: aastore
    //   115: invokevirtual 370	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 24
    //   120: aload 24
    //   122: ifnull +405 -> 527
    //   125: aload 24
    //   127: ldc 51
    //   129: invokeinterface 69 2 0
    //   134: istore 13
    //   136: aload 24
    //   138: ldc 125
    //   140: invokeinterface 69 2 0
    //   145: istore 11
    //   147: aload 24
    //   149: ldc 127
    //   151: invokeinterface 69 2 0
    //   156: istore 4
    //   158: aload 24
    //   160: ldc 129
    //   162: invokeinterface 69 2 0
    //   167: istore 7
    //   169: aload 24
    //   171: ldc 131
    //   173: invokeinterface 69 2 0
    //   178: istore_1
    //   179: aload 24
    //   181: ldc 57
    //   183: invokeinterface 69 2 0
    //   188: istore 10
    //   190: aload 24
    //   192: ldc 53
    //   194: invokeinterface 69 2 0
    //   199: istore 9
    //   201: aload 24
    //   203: ldc 55
    //   205: invokeinterface 69 2 0
    //   210: istore_2
    //   211: aload 24
    //   213: ldc 133
    //   215: invokeinterface 69 2 0
    //   220: istore 14
    //   222: aload 24
    //   224: ldc 135
    //   226: invokeinterface 69 2 0
    //   231: istore 15
    //   233: aload 24
    //   235: ldc 139
    //   237: invokeinterface 69 2 0
    //   242: istore 8
    //   244: aload 24
    //   246: ldc 141
    //   248: invokeinterface 69 2 0
    //   253: istore 12
    //   255: aload 24
    //   257: ldc 143
    //   259: invokeinterface 69 2 0
    //   264: istore_3
    //   265: aload 24
    //   267: invokeinterface 73 1 0
    //   272: ifeq +255 -> 527
    //   275: aload_0
    //   276: getfield 32	agvx:jdField_a_of_type_Agvz	Lagvz;
    //   279: astore 23
    //   281: aload 24
    //   283: iload 13
    //   285: invokeinterface 80 2 0
    //   290: astore 25
    //   292: aload 24
    //   294: iload 11
    //   296: invokeinterface 80 2 0
    //   301: astore 28
    //   303: aload 24
    //   305: iload_1
    //   306: invokeinterface 80 2 0
    //   311: astore 27
    //   313: aload 24
    //   315: iload 4
    //   317: invokeinterface 170 2 0
    //   322: lstore 18
    //   324: aload 24
    //   326: iload 7
    //   328: invokeinterface 170 2 0
    //   333: lstore 20
    //   335: aload 24
    //   337: iload_2
    //   338: invokeinterface 152 2 0
    //   343: istore 5
    //   345: aload 24
    //   347: iload 9
    //   349: invokeinterface 152 2 0
    //   354: istore 6
    //   356: aload 24
    //   358: iload 10
    //   360: invokeinterface 80 2 0
    //   365: astore 26
    //   367: aload 24
    //   369: iload 14
    //   371: invokeinterface 152 2 0
    //   376: iconst_1
    //   377: if_icmpne +138 -> 515
    //   380: iconst_1
    //   381: istore 16
    //   383: aload 24
    //   385: iload 15
    //   387: invokeinterface 152 2 0
    //   392: iconst_1
    //   393: if_icmpne +128 -> 521
    //   396: iconst_1
    //   397: istore 17
    //   399: aload 23
    //   401: aload 25
    //   403: aload 28
    //   405: aload 27
    //   407: lload 18
    //   409: invokestatic 331	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   412: lload 20
    //   414: iload 5
    //   416: invokestatic 372	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   419: iload 6
    //   421: invokestatic 372	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   424: aload 26
    //   426: iload 16
    //   428: iload 17
    //   430: aload 24
    //   432: iload 8
    //   434: invokeinterface 152 2 0
    //   439: aload 24
    //   441: iload 12
    //   443: invokeinterface 80 2 0
    //   448: aload 24
    //   450: iload_3
    //   451: invokeinterface 80 2 0
    //   456: invokevirtual 375	agvz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;)V
    //   459: goto -194 -> 265
    //   462: astore 25
    //   464: aload 24
    //   466: astore 23
    //   468: aload 25
    //   470: astore 24
    //   472: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq +12 -> 487
    //   478: ldc 101
    //   480: iconst_2
    //   481: ldc_w 377
    //   484: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: aload 24
    //   489: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   492: aload 23
    //   494: ifnull +10 -> 504
    //   497: aload 23
    //   499: invokeinterface 113 1 0
    //   504: aload 22
    //   506: ifnull -452 -> 54
    //   509: aload 22
    //   511: invokevirtual 229	android/database/sqlite/SQLiteDatabase:close	()V
    //   514: return
    //   515: iconst_0
    //   516: istore 16
    //   518: goto -135 -> 383
    //   521: iconst_0
    //   522: istore 17
    //   524: goto -125 -> 399
    //   527: aload 24
    //   529: ifnull +10 -> 539
    //   532: aload 24
    //   534: invokeinterface 113 1 0
    //   539: aload 22
    //   541: ifnull -487 -> 54
    //   544: aload 22
    //   546: invokevirtual 229	android/database/sqlite/SQLiteDatabase:close	()V
    //   549: return
    //   550: astore 23
    //   552: aconst_null
    //   553: astore 24
    //   555: aconst_null
    //   556: astore 22
    //   558: aload 24
    //   560: ifnull +10 -> 570
    //   563: aload 24
    //   565: invokeinterface 113 1 0
    //   570: aload 22
    //   572: ifnull +8 -> 580
    //   575: aload 22
    //   577: invokevirtual 229	android/database/sqlite/SQLiteDatabase:close	()V
    //   580: aload 23
    //   582: athrow
    //   583: astore 23
    //   585: aconst_null
    //   586: astore 24
    //   588: goto -30 -> 558
    //   591: astore 23
    //   593: goto -35 -> 558
    //   596: astore 25
    //   598: aload 23
    //   600: astore 24
    //   602: aload 25
    //   604: astore 23
    //   606: goto -48 -> 558
    //   609: astore 24
    //   611: goto -139 -> 472
    //   614: astore 24
    //   616: goto -144 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	agvx
    //   178	128	1	i	int
    //   210	128	2	j	int
    //   264	187	3	k	int
    //   156	160	4	m	int
    //   343	72	5	n	int
    //   354	66	6	i1	int
    //   167	160	7	i2	int
    //   242	191	8	i3	int
    //   199	149	9	i4	int
    //   188	171	10	i5	int
    //   145	150	11	i6	int
    //   253	189	12	i7	int
    //   134	150	13	i8	int
    //   220	150	14	i9	int
    //   231	155	15	i10	int
    //   23	494	16	bool1	boolean
    //   397	126	17	bool2	boolean
    //   322	86	18	l1	long
    //   333	80	20	l2	long
    //   1	575	22	localObject1	Object
    //   4	494	23	localObject2	Object
    //   550	31	23	localObject3	Object
    //   583	1	23	localObject4	Object
    //   591	8	23	localObject5	Object
    //   604	1	23	localObject6	Object
    //   16	585	24	localObject7	Object
    //   609	1	24	localException1	Exception
    //   614	1	24	localException2	Exception
    //   290	112	25	str1	String
    //   462	7	25	localException3	Exception
    //   596	7	25	localObject8	Object
    //   365	60	26	str2	String
    //   311	95	27	str3	String
    //   301	103	28	str4	String
    // Exception table:
    //   from	to	target	type
    //   125	265	462	java/lang/Exception
    //   265	380	462	java/lang/Exception
    //   383	396	462	java/lang/Exception
    //   399	459	462	java/lang/Exception
    //   6	25	550	finally
    //   55	67	550	finally
    //   99	120	583	finally
    //   125	265	591	finally
    //   265	380	591	finally
    //   383	396	591	finally
    //   399	459	591	finally
    //   472	487	596	finally
    //   487	492	596	finally
    //   6	25	609	java/lang/Exception
    //   55	67	609	java/lang/Exception
    //   99	120	614	java/lang/Exception
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    int i = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Agvw.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_overdue", Integer.valueOf(i));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setOverDue failed ");
      }
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agvx
 * JD-Core Version:    0.7.0.1
 */