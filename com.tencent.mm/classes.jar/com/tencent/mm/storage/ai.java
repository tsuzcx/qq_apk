package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import junit.framework.Assert;

public final class ai
  extends n
{
  private static final Object IpC;
  public static final String[] SQL_CREATE;
  private a<Integer> IpD;
  private a<String> IpE;
  private HashMap<Integer, b> IpF;
  private HashMap<String, b> IpG;
  private volatile boolean IpH;
  private final Runnable IpI;
  private h hHS;
  public ap mHandler;
  
  static
  {
    AppMethodBeat.i(133280);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )" };
    IpC = new Object();
    AppMethodBeat.o(133280);
  }
  
  public ai(h paramh)
  {
    AppMethodBeat.i(133262);
    this.IpD = new a("userinfo", "id");
    this.IpE = new a("userinfo2", "sid");
    this.IpF = new HashMap();
    this.IpG = new HashMap();
    this.IpI = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: iconst_0
        //   4: istore 5
        //   6: iconst_0
        //   7: istore 6
        //   9: iconst_0
        //   10: istore_1
        //   11: ldc 22
        //   13: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   16: aload_0
        //   17: getfield 14	com/tencent/mm/storage/ai$1:IpJ	Lcom/tencent/mm/storage/ai;
        //   20: invokestatic 32	com/tencent/mm/storage/ai:a	(Lcom/tencent/mm/storage/ai;)Lcom/tencent/mm/storagebase/h;
        //   23: ifnull +722 -> 745
        //   26: aload_0
        //   27: getfield 14	com/tencent/mm/storage/ai$1:IpJ	Lcom/tencent/mm/storage/ai;
        //   30: invokestatic 32	com/tencent/mm/storage/ai:a	(Lcom/tencent/mm/storage/ai;)Lcom/tencent/mm/storagebase/h;
        //   33: invokevirtual 38	com/tencent/mm/storagebase/h:ftT	()Lcom/tencent/wcdb/database/SQLiteDatabase;
        //   36: astore 8
        //   38: aload 8
        //   40: ifnull +11 -> 51
        //   43: aload 8
        //   45: invokevirtual 44	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
        //   48: ifne +16 -> 64
        //   51: ldc 46
        //   53: ldc 48
        //   55: invokestatic 54	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   58: ldc 22
        //   60: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   63: return
        //   64: aload 8
        //   66: invokevirtual 60	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
        //   69: aload 8
        //   71: invokevirtual 63	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
        //   74: iload 5
        //   76: istore_2
        //   77: iload 6
        //   79: istore_3
        //   80: iconst_3
        //   81: anewarray 4	java/lang/Object
        //   84: astore 7
        //   86: iload 5
        //   88: istore_2
        //   89: iload 6
        //   91: istore_3
        //   92: iconst_1
        //   93: anewarray 4	java/lang/Object
        //   96: astore 9
        //   98: iload 5
        //   100: istore_2
        //   101: iload 6
        //   103: istore_3
        //   104: aload_0
        //   105: getfield 14	com/tencent/mm/storage/ai$1:IpJ	Lcom/tencent/mm/storage/ai;
        //   108: astore 11
        //   110: iload 5
        //   112: istore_2
        //   113: iload 6
        //   115: istore_3
        //   116: aload 11
        //   118: monitorenter
        //   119: aload_0
        //   120: getfield 14	com/tencent/mm/storage/ai$1:IpJ	Lcom/tencent/mm/storage/ai;
        //   123: invokestatic 67	com/tencent/mm/storage/ai:b	(Lcom/tencent/mm/storage/ai;)Ljava/util/HashMap;
        //   126: astore 12
        //   128: aload_0
        //   129: getfield 14	com/tencent/mm/storage/ai$1:IpJ	Lcom/tencent/mm/storage/ai;
        //   132: invokestatic 70	com/tencent/mm/storage/ai:c	(Lcom/tencent/mm/storage/ai;)Ljava/util/HashMap;
        //   135: astore 10
        //   137: aload_0
        //   138: getfield 14	com/tencent/mm/storage/ai$1:IpJ	Lcom/tencent/mm/storage/ai;
        //   141: new 72	java/util/HashMap
        //   144: dup
        //   145: invokespecial 73	java/util/HashMap:<init>	()V
        //   148: invokestatic 76	com/tencent/mm/storage/ai:a	(Lcom/tencent/mm/storage/ai;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   151: pop
        //   152: aload_0
        //   153: getfield 14	com/tencent/mm/storage/ai$1:IpJ	Lcom/tencent/mm/storage/ai;
        //   156: new 72	java/util/HashMap
        //   159: dup
        //   160: invokespecial 73	java/util/HashMap:<init>	()V
        //   163: invokestatic 78	com/tencent/mm/storage/ai:b	(Lcom/tencent/mm/storage/ai;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   166: pop
        //   167: aload_0
        //   168: getfield 14	com/tencent/mm/storage/ai$1:IpJ	Lcom/tencent/mm/storage/ai;
        //   171: invokestatic 82	com/tencent/mm/storage/ai:d	(Lcom/tencent/mm/storage/ai;)Z
        //   174: pop
        //   175: aload 11
        //   177: monitorexit
        //   178: iload 5
        //   180: istore_2
        //   181: iload 6
        //   183: istore_3
        //   184: aload 12
        //   186: invokevirtual 86	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   189: invokeinterface 92 1 0
        //   194: astore 11
        //   196: iload_1
        //   197: istore_2
        //   198: iload_1
        //   199: istore_3
        //   200: aload 11
        //   202: invokeinterface 97 1 0
        //   207: ifeq +298 -> 505
        //   210: iload_1
        //   211: istore_2
        //   212: iload_1
        //   213: istore_3
        //   214: aload 11
        //   216: invokeinterface 101 1 0
        //   221: checkcast 103	java/util/Map$Entry
        //   224: astore 12
        //   226: iload_1
        //   227: istore_2
        //   228: iload_1
        //   229: istore_3
        //   230: aload 12
        //   232: invokeinterface 106 1 0
        //   237: checkcast 108	com/tencent/mm/storage/ai$b
        //   240: astore 13
        //   242: aload 13
        //   244: ifnonnull +138 -> 382
        //   247: iload_1
        //   248: istore_2
        //   249: iload_1
        //   250: istore_3
        //   251: aload 9
        //   253: iconst_0
        //   254: aload 12
        //   256: invokeinterface 111 1 0
        //   261: aastore
        //   262: iload_1
        //   263: istore_2
        //   264: iload_1
        //   265: istore_3
        //   266: aload 8
        //   268: ldc 113
        //   270: aload 9
        //   272: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   275: iload_1
        //   276: iconst_1
        //   277: iadd
        //   278: istore_1
        //   279: goto -83 -> 196
        //   282: astore 7
        //   284: aload 11
        //   286: monitorexit
        //   287: iload 5
        //   289: istore_2
        //   290: iload 6
        //   292: istore_3
        //   293: ldc 22
        //   295: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   298: iload 5
        //   300: istore_2
        //   301: iload 6
        //   303: istore_3
        //   304: aload 7
        //   306: athrow
        //   307: astore 7
        //   309: iconst_1
        //   310: istore_3
        //   311: iload_2
        //   312: istore_1
        //   313: iload_3
        //   314: istore_2
        //   315: ldc 46
        //   317: aload 7
        //   319: ldc 119
        //   321: iconst_0
        //   322: anewarray 4	java/lang/Object
        //   325: invokestatic 123	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   328: iload_2
        //   329: ifeq +16 -> 345
        //   332: aload 8
        //   334: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
        //   337: ifeq +8 -> 345
        //   340: aload 8
        //   342: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   345: aload 8
        //   347: invokevirtual 132	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   350: ldc 46
        //   352: new 134	java/lang/StringBuilder
        //   355: dup
        //   356: ldc 136
        //   358: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   361: iload_1
        //   362: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   365: ldc 145
        //   367: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   370: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   373: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   376: ldc 22
        //   378: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   381: return
        //   382: iload_1
        //   383: istore_2
        //   384: iload_1
        //   385: istore_3
        //   386: aload 7
        //   388: iconst_0
        //   389: aload 12
        //   391: invokeinterface 111 1 0
        //   396: aastore
        //   397: iload_1
        //   398: istore_2
        //   399: iload_1
        //   400: istore_3
        //   401: aload 7
        //   403: iconst_1
        //   404: aload 13
        //   406: getfield 158	com/tencent/mm/storage/ai$b:type	I
        //   409: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   412: aastore
        //   413: iload_1
        //   414: istore_2
        //   415: iload_1
        //   416: istore_3
        //   417: aload 7
        //   419: iconst_2
        //   420: aload 13
        //   422: getfield 168	com/tencent/mm/storage/ai$b:hHZ	Ljava/lang/String;
        //   425: aastore
        //   426: iload_1
        //   427: istore_2
        //   428: iload_1
        //   429: istore_3
        //   430: aload 8
        //   432: ldc 170
        //   434: aload 7
        //   436: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   439: goto -164 -> 275
        //   442: astore 7
        //   444: iload_3
        //   445: istore_1
        //   446: iload 4
        //   448: istore_2
        //   449: iload_2
        //   450: ifeq +16 -> 466
        //   453: aload 8
        //   455: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
        //   458: ifeq +8 -> 466
        //   461: aload 8
        //   463: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   466: aload 8
        //   468: invokevirtual 132	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   471: ldc 46
        //   473: new 134	java/lang/StringBuilder
        //   476: dup
        //   477: ldc 136
        //   479: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   482: iload_1
        //   483: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   486: ldc 145
        //   488: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   491: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   494: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   497: ldc 22
        //   499: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   502: aload 7
        //   504: athrow
        //   505: iload_1
        //   506: istore_2
        //   507: iload_1
        //   508: istore_3
        //   509: aload 10
        //   511: invokevirtual 86	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   514: invokeinterface 92 1 0
        //   519: astore 10
        //   521: iload_1
        //   522: istore_2
        //   523: iload_1
        //   524: istore_3
        //   525: aload 10
        //   527: invokeinterface 97 1 0
        //   532: ifeq +131 -> 663
        //   535: iload_1
        //   536: istore_2
        //   537: iload_1
        //   538: istore_3
        //   539: aload 10
        //   541: invokeinterface 101 1 0
        //   546: checkcast 103	java/util/Map$Entry
        //   549: astore 11
        //   551: iload_1
        //   552: istore_2
        //   553: iload_1
        //   554: istore_3
        //   555: aload 11
        //   557: invokeinterface 106 1 0
        //   562: checkcast 108	com/tencent/mm/storage/ai$b
        //   565: astore 12
        //   567: aload 12
        //   569: ifnonnull +34 -> 603
        //   572: iload_1
        //   573: istore_2
        //   574: iload_1
        //   575: istore_3
        //   576: aload 9
        //   578: iconst_0
        //   579: aload 11
        //   581: invokeinterface 111 1 0
        //   586: aastore
        //   587: iload_1
        //   588: istore_2
        //   589: iload_1
        //   590: istore_3
        //   591: aload 8
        //   593: ldc 172
        //   595: aload 9
        //   597: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   600: goto +151 -> 751
        //   603: iload_1
        //   604: istore_2
        //   605: iload_1
        //   606: istore_3
        //   607: aload 7
        //   609: iconst_0
        //   610: aload 11
        //   612: invokeinterface 111 1 0
        //   617: aastore
        //   618: iload_1
        //   619: istore_2
        //   620: iload_1
        //   621: istore_3
        //   622: aload 7
        //   624: iconst_1
        //   625: aload 12
        //   627: getfield 158	com/tencent/mm/storage/ai$b:type	I
        //   630: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   633: aastore
        //   634: iload_1
        //   635: istore_2
        //   636: iload_1
        //   637: istore_3
        //   638: aload 7
        //   640: iconst_2
        //   641: aload 12
        //   643: getfield 168	com/tencent/mm/storage/ai$b:hHZ	Ljava/lang/String;
        //   646: aastore
        //   647: iload_1
        //   648: istore_2
        //   649: iload_1
        //   650: istore_3
        //   651: aload 8
        //   653: ldc 174
        //   655: aload 7
        //   657: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   660: goto +91 -> 751
        //   663: iload_1
        //   664: istore_2
        //   665: iload_1
        //   666: istore_3
        //   667: aload 8
        //   669: invokevirtual 177	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
        //   672: aload 8
        //   674: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
        //   677: ifeq +8 -> 685
        //   680: aload 8
        //   682: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   685: aload 8
        //   687: invokevirtual 132	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   690: ldc 46
        //   692: new 134	java/lang/StringBuilder
        //   695: dup
        //   696: ldc 136
        //   698: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   701: iload_1
        //   702: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   705: ldc 145
        //   707: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   710: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   713: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   716: ldc 22
        //   718: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   721: return
        //   722: astore 7
        //   724: iconst_0
        //   725: istore_2
        //   726: iconst_0
        //   727: istore_1
        //   728: goto -279 -> 449
        //   731: astore 7
        //   733: goto -284 -> 449
        //   736: astore 7
        //   738: iconst_0
        //   739: istore_2
        //   740: iconst_0
        //   741: istore_1
        //   742: goto -427 -> 315
        //   745: aconst_null
        //   746: astore 8
        //   748: goto -710 -> 38
        //   751: iload_1
        //   752: iconst_1
        //   753: iadd
        //   754: istore_1
        //   755: goto -234 -> 521
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	758	0	this	1
        //   10	745	1	i	int
        //   76	664	2	j	int
        //   79	588	3	k	int
        //   1	446	4	m	int
        //   4	295	5	n	int
        //   7	295	6	i1	int
        //   84	1	7	arrayOfObject1	Object[]
        //   282	23	7	localObject1	Object
        //   307	128	7	localRuntimeException1	java.lang.RuntimeException
        //   442	214	7	arrayOfObject2	Object[]
        //   722	1	7	localObject2	Object
        //   731	1	7	localObject3	Object
        //   736	1	7	localRuntimeException2	java.lang.RuntimeException
        //   36	711	8	localSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
        //   96	500	9	arrayOfObject3	Object[]
        //   135	405	10	localObject4	Object
        //   108	503	11	localObject5	Object
        //   126	516	12	localObject6	Object
        //   240	181	13	localb	ai.b
        // Exception table:
        //   from	to	target	type
        //   119	178	282	finally
        //   284	287	282	finally
        //   80	86	307	java/lang/RuntimeException
        //   92	98	307	java/lang/RuntimeException
        //   104	110	307	java/lang/RuntimeException
        //   116	119	307	java/lang/RuntimeException
        //   184	196	307	java/lang/RuntimeException
        //   200	210	307	java/lang/RuntimeException
        //   214	226	307	java/lang/RuntimeException
        //   230	242	307	java/lang/RuntimeException
        //   251	262	307	java/lang/RuntimeException
        //   266	275	307	java/lang/RuntimeException
        //   293	298	307	java/lang/RuntimeException
        //   304	307	307	java/lang/RuntimeException
        //   386	397	307	java/lang/RuntimeException
        //   401	413	307	java/lang/RuntimeException
        //   417	426	307	java/lang/RuntimeException
        //   430	439	307	java/lang/RuntimeException
        //   509	521	307	java/lang/RuntimeException
        //   525	535	307	java/lang/RuntimeException
        //   539	551	307	java/lang/RuntimeException
        //   555	567	307	java/lang/RuntimeException
        //   576	587	307	java/lang/RuntimeException
        //   591	600	307	java/lang/RuntimeException
        //   607	618	307	java/lang/RuntimeException
        //   622	634	307	java/lang/RuntimeException
        //   638	647	307	java/lang/RuntimeException
        //   651	660	307	java/lang/RuntimeException
        //   667	672	307	java/lang/RuntimeException
        //   80	86	442	finally
        //   92	98	442	finally
        //   104	110	442	finally
        //   116	119	442	finally
        //   184	196	442	finally
        //   200	210	442	finally
        //   214	226	442	finally
        //   230	242	442	finally
        //   251	262	442	finally
        //   266	275	442	finally
        //   293	298	442	finally
        //   304	307	442	finally
        //   386	397	442	finally
        //   401	413	442	finally
        //   417	426	442	finally
        //   430	439	442	finally
        //   509	521	442	finally
        //   525	535	442	finally
        //   539	551	442	finally
        //   555	567	442	finally
        //   576	587	442	finally
        //   591	600	442	finally
        //   607	618	442	finally
        //   622	634	442	finally
        //   638	647	442	finally
        //   651	660	442	finally
        //   667	672	442	finally
        //   64	74	722	finally
        //   315	328	731	finally
        //   64	74	736	java/lang/RuntimeException
      }
    };
    this.hHS = paramh;
    this.mHandler = new ap("ConfigStorage");
    AppMethodBeat.o(133262);
  }
  
  private static boolean a(String paramString, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(133273);
    if ((paramObject == null) && (paramBoolean))
    {
      AppMethodBeat.o(133273);
      return true;
    }
    if ((paramString.equals("INT")) && ((paramObject instanceof Integer)))
    {
      AppMethodBeat.o(133273);
      return true;
    }
    if ((paramString.equals("LONG")) && ((paramObject instanceof Long)))
    {
      AppMethodBeat.o(133273);
      return true;
    }
    if ((paramString.equals("STRING")) && ((paramObject instanceof String)))
    {
      AppMethodBeat.o(133273);
      return true;
    }
    if ((paramString.equals("BOOLEAN")) && ((paramObject instanceof Boolean)))
    {
      AppMethodBeat.o(133273);
      return true;
    }
    if ((paramString.equals("FLOAT")) && ((paramObject instanceof Float)))
    {
      AppMethodBeat.o(133273);
      return true;
    }
    if ((paramString.equals("DOUBLE")) && ((paramObject instanceof Double)))
    {
      AppMethodBeat.o(133273);
      return true;
    }
    if ((paramObject != null) && (b.fjN())) {
      Assert.assertTrue("checkType failed, input type and value[" + paramString + ", " + paramObject + "] are not match", false);
    }
    if (paramBoolean) {
      ad.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", new Object[] { paramString, paramObject });
    }
    AppMethodBeat.o(133273);
    return false;
  }
  
  private Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(133270);
    Assert.assertNotNull("db is null", this.hHS);
    paramString = this.IpE.get(paramString);
    if ((paramString == null) || (paramString == IpC))
    {
      AppMethodBeat.o(133270);
      return paramObject;
    }
    AppMethodBeat.o(133270);
    return paramString;
  }
  
  public final long a(al.a parama, long paramLong)
  {
    AppMethodBeat.i(133268);
    parama = get(parama, Long.valueOf(paramLong));
    if ((parama != null) && ((parama instanceof Long)))
    {
      paramLong = ((Long)parama).longValue();
      AppMethodBeat.o(133268);
      return paramLong;
    }
    AppMethodBeat.o(133268);
    return paramLong;
  }
  
  public final String a(al.a parama, String paramString)
  {
    AppMethodBeat.i(189901);
    parama = get(parama, paramString);
    if ((parama != null) && ((parama instanceof String)))
    {
      parama = (String)parama;
      AppMethodBeat.o(189901);
      return parama;
    }
    AppMethodBeat.o(189901);
    return paramString;
  }
  
  public final boolean aSH()
  {
    AppMethodBeat.i(133274);
    if ((this.hHS == null) || (this.hHS.fmj()))
    {
      if (this.hHS == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.hHS.fmj()))
      {
        ad.w("MicroMsg.ConfigStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(133274);
        return false;
      }
    }
    AppMethodBeat.o(133274);
    return true;
  }
  
  public final long aaQ(int paramInt)
  {
    AppMethodBeat.i(133279);
    Long localLong = (Long)get(paramInt, null);
    if (localLong == null)
    {
      AppMethodBeat.o(133279);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(133279);
    return l;
  }
  
  public final void fqc()
  {
    AppMethodBeat.i(133275);
    try
    {
      this.mHandler.removeCallbacks(this.IpI);
      this.mHandler.post(this.IpI);
      this.IpH = true;
      ad.i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
      AppMethodBeat.o(133275);
      return;
    }
    finally
    {
      AppMethodBeat.o(133275);
    }
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(221715);
    Object localObject = get(paramInt, null);
    AppMethodBeat.o(221715);
    return localObject;
  }
  
  public final Object get(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133264);
    Assert.assertNotNull("db is null", this.hHS);
    Object localObject = this.IpD.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (localObject == IpC))
    {
      AppMethodBeat.o(133264);
      return paramObject;
    }
    AppMethodBeat.o(133264);
    return localObject;
  }
  
  public final Object get(al.a parama, Object paramObject)
  {
    AppMethodBeat.i(133266);
    if (parama == null)
    {
      AppMethodBeat.o(133266);
      return paramObject;
    }
    String str = parama.name();
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(133266);
      return paramObject;
    }
    String[] arrayOfString = str.split("_");
    Object localObject = arrayOfString[(arrayOfString.length - 1)];
    parama = (al.a)localObject;
    if (((String)localObject).equals("SYNC")) {
      parama = arrayOfString[(arrayOfString.length - 2)];
    }
    localObject = get(str.substring(0, str.lastIndexOf(parama) + parama.length()), paramObject);
    if (!a(parama, localObject, false))
    {
      AppMethodBeat.o(133266);
      return paramObject;
    }
    AppMethodBeat.o(133266);
    return localObject;
  }
  
  public final boolean getBoolean(al.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(133267);
    parama = get(parama, Boolean.valueOf(paramBoolean));
    if ((parama != null) && ((parama instanceof Boolean)))
    {
      paramBoolean = ((Boolean)parama).booleanValue();
      AppMethodBeat.o(133267);
      return paramBoolean;
    }
    AppMethodBeat.o(133267);
    return paramBoolean;
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133277);
    Integer localInteger = (Integer)get(paramInt1, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(133277);
      return paramInt2;
    }
    paramInt1 = localInteger.intValue();
    AppMethodBeat.o(133277);
    return paramInt1;
  }
  
  public final int getInt(al.a parama, int paramInt)
  {
    AppMethodBeat.i(133269);
    parama = get(parama, Integer.valueOf(paramInt));
    if ((parama != null) && ((parama instanceof Integer)))
    {
      paramInt = ((Integer)parama).intValue();
      AppMethodBeat.o(133269);
      return paramInt;
    }
    AppMethodBeat.o(133269);
    return paramInt;
  }
  
  public final Object i(al.a parama)
  {
    AppMethodBeat.i(221716);
    parama = get(parama, null);
    AppMethodBeat.o(221716);
    return parama;
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133271);
    Assert.assertNotNull("db is null", this.hHS);
    Object localObject1 = paramObject;
    if (paramObject == null) {
      localObject1 = IpC;
    }
    if (!localObject1.equals(this.IpD.put(Integer.valueOf(paramInt), localObject1)))
    {
      if (localObject1 != IpC) {
        break label177;
      }
      paramObject = null;
    }
    for (;;)
    {
      try
      {
        this.IpF.put(Integer.valueOf(paramInt), paramObject);
        if (!this.IpH)
        {
          this.IpH = true;
          this.mHandler.postDelayed(this.IpI, 30000L);
        }
        if (localObject1 != IpC) {
          break label210;
        }
        i = 5;
        b(i, this, Integer.valueOf(paramInt));
        localObject2 = new StringBuilder("SET: ").append(paramInt).append(" => ");
        if (localObject1 != IpC) {
          break label215;
        }
        paramObject = "(DELETED)";
        ad.i("MicroMsg.ConfigStorage", paramObject);
        AppMethodBeat.o(133271);
        return;
      }
      finally
      {
        Object localObject2;
        label177:
        AppMethodBeat.o(133271);
      }
      localObject2 = b.dW(localObject1);
      paramObject = localObject2;
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(133271);
      return;
      label210:
      int i = 4;
      continue;
      label215:
      paramObject = localObject1.toString();
    }
  }
  
  public final void set(al.a parama, Object paramObject)
  {
    AppMethodBeat.i(133272);
    if (parama == null)
    {
      AppMethodBeat.o(133272);
      return;
    }
    Object localObject1 = parama.name();
    if (bt.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(133272);
      return;
    }
    Object localObject2 = ((String)localObject1).split("_");
    parama = localObject2[(localObject2.length - 1)];
    if (parama.equals("SYNC")) {
      parama = localObject2[(localObject2.length - 2)];
    }
    for (int i = 1;; i = 0)
    {
      if (!a(parama, paramObject, true))
      {
        AppMethodBeat.o(133272);
        return;
      }
      int j = ((String)localObject1).lastIndexOf(parama);
      localObject2 = ((String)localObject1).substring(0, parama.length() + j);
      parama = paramObject;
      if (paramObject == null) {
        parama = IpC;
      }
      if (!parama.equals(this.IpE.put(localObject2, parama)))
      {
        if (parama != IpC) {
          break label246;
        }
        paramObject = null;
      }
      for (;;)
      {
        try
        {
          this.IpG.put(localObject2, paramObject);
          if (i != 0)
          {
            fqc();
            if (parama != IpC) {
              break label308;
            }
            i = 5;
            b(i, this, localObject2);
            paramObject = new StringBuilder("SET: ").append((String)localObject2).append(" => ");
            if (parama != IpC) {
              break label313;
            }
            parama = "(DELETED)";
            ad.i("MicroMsg.ConfigStorage", parama);
            AppMethodBeat.o(133272);
            return;
            label246:
            localObject1 = b.dW(parama);
            paramObject = localObject1;
            if (localObject1 != null) {
              break;
            }
            AppMethodBeat.o(133272);
            return;
          }
          if (this.IpH) {
            continue;
          }
          this.IpH = true;
          this.mHandler.postDelayed(this.IpI, 30000L);
          continue;
          i = 4;
        }
        finally
        {
          AppMethodBeat.o(133272);
        }
        label308:
        continue;
        label313:
        parama = parama.toString();
      }
    }
  }
  
  public final void setInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133276);
    set(paramInt1, Integer.valueOf(paramInt2));
    AppMethodBeat.o(133276);
  }
  
  public final void setLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(133278);
    set(paramInt, Long.valueOf(paramLong));
    AppMethodBeat.o(133278);
  }
  
  final class a<K>
    extends ag<K, Object>
  {
    private final String IpK;
    
    a(String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(133257);
      this.IpK = ("SELECT * FROM " + paramString1 + " WHERE " + paramString2 + "=?;");
      AppMethodBeat.o(133257);
    }
    
    /* Error */
    public final Object create(K paramK)
    {
      // Byte code:
      //   0: ldc 57
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 16	com/tencent/mm/storage/ai$a:IpJ	Lcom/tencent/mm/storage/ai;
      //   9: invokestatic 60	com/tencent/mm/storage/ai:a	(Lcom/tencent/mm/storage/ai;)Lcom/tencent/mm/storagebase/h;
      //   12: aload_0
      //   13: getfield 46	com/tencent/mm/storage/ai$a:IpK	Ljava/lang/String;
      //   16: iconst_1
      //   17: anewarray 62	java/lang/String
      //   20: dup
      //   21: iconst_0
      //   22: aload_1
      //   23: invokevirtual 65	java/lang/Object:toString	()Ljava/lang/String;
      //   26: aastore
      //   27: iconst_2
      //   28: invokevirtual 70	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
      //   31: astore 4
      //   33: aload 4
      //   35: invokeinterface 76 1 0
      //   40: ifeq +87 -> 127
      //   43: new 78	com/tencent/mm/storage/ai$b
      //   46: dup
      //   47: aload 4
      //   49: iconst_1
      //   50: invokeinterface 82 2 0
      //   55: aload 4
      //   57: iconst_2
      //   58: invokeinterface 86 2 0
      //   63: invokespecial 89	com/tencent/mm/storage/ai$b:<init>	(ILjava/lang/String;)V
      //   66: astore_2
      //   67: ldc 91
      //   69: new 27	java/lang/StringBuilder
      //   72: dup
      //   73: ldc 93
      //   75: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   78: aload_1
      //   79: invokevirtual 65	java/lang/Object:toString	()Ljava/lang/String;
      //   82: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: ldc 95
      //   87: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: aload_2
      //   91: getfield 98	com/tencent/mm/storage/ai$b:hHZ	Ljava/lang/String;
      //   94: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   100: invokestatic 103	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   103: aload_2
      //   104: invokevirtual 107	com/tencent/mm/storage/ai$b:aRl	()Ljava/lang/Object;
      //   107: astore_2
      //   108: aload 4
      //   110: ifnull +10 -> 120
      //   113: aload 4
      //   115: invokeinterface 111 1 0
      //   120: ldc 57
      //   122: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: aload_2
      //   126: areturn
      //   127: ldc 91
      //   129: new 27	java/lang/StringBuilder
      //   132: dup
      //   133: ldc 93
      //   135: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   138: aload_1
      //   139: invokevirtual 65	java/lang/Object:toString	()Ljava/lang/String;
      //   142: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   145: ldc 113
      //   147: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   150: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   153: invokestatic 103	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   156: invokestatic 116	com/tencent/mm/storage/ai:eAA	()Ljava/lang/Object;
      //   159: astore_2
      //   160: aload 4
      //   162: ifnull +10 -> 172
      //   165: aload 4
      //   167: invokeinterface 111 1 0
      //   172: ldc 57
      //   174: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   177: aload_2
      //   178: areturn
      //   179: astore_3
      //   180: ldc 57
      //   182: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   185: aload_3
      //   186: athrow
      //   187: astore_2
      //   188: aload 4
      //   190: ifnull +14 -> 204
      //   193: aload_3
      //   194: ifnull +55 -> 249
      //   197: aload 4
      //   199: invokeinterface 111 1 0
      //   204: ldc 57
      //   206: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   209: aload_2
      //   210: athrow
      //   211: astore_2
      //   212: ldc 91
      //   214: aload_2
      //   215: ldc 118
      //   217: aload_1
      //   218: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   221: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   224: iconst_0
      //   225: anewarray 64	java/lang/Object
      //   228: invokestatic 130	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   231: ldc 57
      //   233: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   236: aconst_null
      //   237: areturn
      //   238: astore 4
      //   240: aload_3
      //   241: aload 4
      //   243: invokevirtual 134	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   246: goto -42 -> 204
      //   249: aload 4
      //   251: invokeinterface 111 1 0
      //   256: goto -52 -> 204
      //   259: astore_2
      //   260: aconst_null
      //   261: astore_3
      //   262: goto -74 -> 188
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	265	0	this	a
      //   0	265	1	paramK	K
      //   66	112	2	localObject1	Object
      //   187	23	2	localObject2	Object
      //   211	4	2	localRuntimeException	java.lang.RuntimeException
      //   259	1	2	localObject3	Object
      //   179	62	3	localThrowable1	java.lang.Throwable
      //   261	1	3	localObject4	Object
      //   31	167	4	localCursor	android.database.Cursor
      //   238	12	4	localThrowable2	java.lang.Throwable
      // Exception table:
      //   from	to	target	type
      //   33	108	179	java/lang/Throwable
      //   127	160	179	java/lang/Throwable
      //   180	187	187	finally
      //   5	33	211	java/lang/RuntimeException
      //   113	120	211	java/lang/RuntimeException
      //   165	172	211	java/lang/RuntimeException
      //   197	204	211	java/lang/RuntimeException
      //   204	211	211	java/lang/RuntimeException
      //   240	246	211	java/lang/RuntimeException
      //   249	256	211	java/lang/RuntimeException
      //   197	204	238	java/lang/Throwable
      //   33	108	259	finally
      //   127	160	259	finally
    }
  }
  
  static final class b
  {
    final String hHZ;
    final int type;
    
    b(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.hHZ = paramString;
    }
    
    static b dW(Object paramObject)
    {
      AppMethodBeat.i(133259);
      int i;
      if ((paramObject instanceof Integer)) {
        i = 1;
      }
      for (;;)
      {
        paramObject = new b(i, paramObject.toString());
        AppMethodBeat.o(133259);
        return paramObject;
        if ((paramObject instanceof Long))
        {
          i = 2;
        }
        else if ((paramObject instanceof String))
        {
          i = 3;
        }
        else if ((paramObject instanceof Boolean))
        {
          i = 4;
        }
        else if ((paramObject instanceof Float))
        {
          i = 5;
        }
        else
        {
          if (!(paramObject instanceof Double)) {
            break;
          }
          i = 6;
        }
      }
      ad.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + paramObject.getClass().toString());
      AppMethodBeat.o(133259);
      return null;
    }
    
    final Object aRl()
    {
      AppMethodBeat.i(133261);
      if (this.hHZ == ai.eAA())
      {
        AppMethodBeat.o(133261);
        return null;
      }
      try
      {
        int i = this.type;
        switch (i)
        {
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          ad.e("MicroMsg.ConfigStorage", "exception:%s", new Object[] { bt.n(localException) });
        }
      }
      AppMethodBeat.o(133261);
      return null;
      localObject = Integer.valueOf(this.hHZ);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Long.valueOf(this.hHZ);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = this.hHZ;
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Boolean.valueOf(this.hHZ);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Float.valueOf(this.hHZ);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Double.valueOf(this.hHZ);
      AppMethodBeat.o(133261);
      return localObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(133260);
      if (paramObject == null)
      {
        AppMethodBeat.o(133260);
        return false;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(133260);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.type != paramObject.type)
      {
        AppMethodBeat.o(133260);
        return false;
      }
      if (this.hHZ == null)
      {
        if (paramObject.hHZ == null)
        {
          AppMethodBeat.o(133260);
          return true;
        }
        AppMethodBeat.o(133260);
        return false;
      }
      boolean bool = this.hHZ.equals(paramObject.hHZ);
      AppMethodBeat.o(133260);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ai
 * JD-Core Version:    0.7.0.1
 */