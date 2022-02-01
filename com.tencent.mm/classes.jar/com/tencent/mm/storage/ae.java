package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import junit.framework.Assert;

public final class ae
  extends n
{
  private static final Object GDj;
  public static final String[] SQL_CREATE;
  private a<Integer> GDk;
  private a<String> GDl;
  private HashMap<Integer, b> GDm;
  private HashMap<String, b> GDn;
  private volatile boolean GDo;
  private final Runnable GDp;
  private h hpA;
  public ao mHandler;
  
  static
  {
    AppMethodBeat.i(133280);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )" };
    GDj = new Object();
    AppMethodBeat.o(133280);
  }
  
  public ae(h paramh)
  {
    AppMethodBeat.i(133262);
    this.GDk = new a("userinfo", "id");
    this.GDl = new a("userinfo2", "sid");
    this.GDm = new HashMap();
    this.GDn = new HashMap();
    this.GDp = new Runnable()
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
        //   17: getfield 14	com/tencent/mm/storage/ae$1:GDq	Lcom/tencent/mm/storage/ae;
        //   20: invokestatic 32	com/tencent/mm/storage/ae:a	(Lcom/tencent/mm/storage/ae;)Lcom/tencent/mm/storagebase/h;
        //   23: ifnull +698 -> 721
        //   26: aload_0
        //   27: getfield 14	com/tencent/mm/storage/ae$1:GDq	Lcom/tencent/mm/storage/ae;
        //   30: invokestatic 32	com/tencent/mm/storage/ae:a	(Lcom/tencent/mm/storage/ae;)Lcom/tencent/mm/storagebase/h;
        //   33: invokevirtual 38	com/tencent/mm/storagebase/h:fdL	()Lcom/tencent/wcdb/database/SQLiteDatabase;
        //   36: astore 8
        //   38: aload 8
        //   40: ifnull +11 -> 51
        //   43: aload 8
        //   45: invokevirtual 44	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
        //   48: ifne +16 -> 64
        //   51: ldc 46
        //   53: ldc 48
        //   55: invokestatic 54	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
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
        //   105: getfield 14	com/tencent/mm/storage/ae$1:GDq	Lcom/tencent/mm/storage/ae;
        //   108: astore 11
        //   110: iload 5
        //   112: istore_2
        //   113: iload 6
        //   115: istore_3
        //   116: aload 11
        //   118: monitorenter
        //   119: aload_0
        //   120: getfield 14	com/tencent/mm/storage/ae$1:GDq	Lcom/tencent/mm/storage/ae;
        //   123: invokestatic 67	com/tencent/mm/storage/ae:b	(Lcom/tencent/mm/storage/ae;)Ljava/util/HashMap;
        //   126: astore 12
        //   128: aload_0
        //   129: getfield 14	com/tencent/mm/storage/ae$1:GDq	Lcom/tencent/mm/storage/ae;
        //   132: invokestatic 70	com/tencent/mm/storage/ae:c	(Lcom/tencent/mm/storage/ae;)Ljava/util/HashMap;
        //   135: astore 10
        //   137: aload_0
        //   138: getfield 14	com/tencent/mm/storage/ae$1:GDq	Lcom/tencent/mm/storage/ae;
        //   141: new 72	java/util/HashMap
        //   144: dup
        //   145: invokespecial 73	java/util/HashMap:<init>	()V
        //   148: invokestatic 76	com/tencent/mm/storage/ae:a	(Lcom/tencent/mm/storage/ae;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   151: pop
        //   152: aload_0
        //   153: getfield 14	com/tencent/mm/storage/ae$1:GDq	Lcom/tencent/mm/storage/ae;
        //   156: new 72	java/util/HashMap
        //   159: dup
        //   160: invokespecial 73	java/util/HashMap:<init>	()V
        //   163: invokestatic 78	com/tencent/mm/storage/ae:b	(Lcom/tencent/mm/storage/ae;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   166: pop
        //   167: aload_0
        //   168: getfield 14	com/tencent/mm/storage/ae$1:GDq	Lcom/tencent/mm/storage/ae;
        //   171: invokestatic 82	com/tencent/mm/storage/ae:d	(Lcom/tencent/mm/storage/ae;)Z
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
        //   207: ifeq +282 -> 489
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
        //   237: checkcast 108	com/tencent/mm/storage/ae$b
        //   240: astore 13
        //   242: aload 13
        //   244: ifnonnull +130 -> 374
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
        //   325: invokestatic 123	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   328: iload_2
        //   329: ifeq +8 -> 337
        //   332: aload 8
        //   334: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   337: aload 8
        //   339: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   342: ldc 46
        //   344: new 131	java/lang/StringBuilder
        //   347: dup
        //   348: ldc 133
        //   350: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   353: iload_1
        //   354: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   357: ldc 142
        //   359: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   362: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   365: invokestatic 151	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   368: ldc 22
        //   370: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   373: return
        //   374: iload_1
        //   375: istore_2
        //   376: iload_1
        //   377: istore_3
        //   378: aload 7
        //   380: iconst_0
        //   381: aload 12
        //   383: invokeinterface 111 1 0
        //   388: aastore
        //   389: iload_1
        //   390: istore_2
        //   391: iload_1
        //   392: istore_3
        //   393: aload 7
        //   395: iconst_1
        //   396: aload 13
        //   398: getfield 155	com/tencent/mm/storage/ae$b:type	I
        //   401: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   404: aastore
        //   405: iload_1
        //   406: istore_2
        //   407: iload_1
        //   408: istore_3
        //   409: aload 7
        //   411: iconst_2
        //   412: aload 13
        //   414: getfield 165	com/tencent/mm/storage/ae$b:hpH	Ljava/lang/String;
        //   417: aastore
        //   418: iload_1
        //   419: istore_2
        //   420: iload_1
        //   421: istore_3
        //   422: aload 8
        //   424: ldc 167
        //   426: aload 7
        //   428: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   431: goto -156 -> 275
        //   434: astore 7
        //   436: iload_3
        //   437: istore_1
        //   438: iload 4
        //   440: istore_2
        //   441: iload_2
        //   442: ifeq +8 -> 450
        //   445: aload 8
        //   447: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   450: aload 8
        //   452: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   455: ldc 46
        //   457: new 131	java/lang/StringBuilder
        //   460: dup
        //   461: ldc 133
        //   463: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   466: iload_1
        //   467: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   470: ldc 142
        //   472: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   475: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   478: invokestatic 151	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   481: ldc 22
        //   483: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   486: aload 7
        //   488: athrow
        //   489: iload_1
        //   490: istore_2
        //   491: iload_1
        //   492: istore_3
        //   493: aload 10
        //   495: invokevirtual 86	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   498: invokeinterface 92 1 0
        //   503: astore 10
        //   505: iload_1
        //   506: istore_2
        //   507: iload_1
        //   508: istore_3
        //   509: aload 10
        //   511: invokeinterface 97 1 0
        //   516: ifeq +131 -> 647
        //   519: iload_1
        //   520: istore_2
        //   521: iload_1
        //   522: istore_3
        //   523: aload 10
        //   525: invokeinterface 101 1 0
        //   530: checkcast 103	java/util/Map$Entry
        //   533: astore 11
        //   535: iload_1
        //   536: istore_2
        //   537: iload_1
        //   538: istore_3
        //   539: aload 11
        //   541: invokeinterface 106 1 0
        //   546: checkcast 108	com/tencent/mm/storage/ae$b
        //   549: astore 12
        //   551: aload 12
        //   553: ifnonnull +34 -> 587
        //   556: iload_1
        //   557: istore_2
        //   558: iload_1
        //   559: istore_3
        //   560: aload 9
        //   562: iconst_0
        //   563: aload 11
        //   565: invokeinterface 111 1 0
        //   570: aastore
        //   571: iload_1
        //   572: istore_2
        //   573: iload_1
        //   574: istore_3
        //   575: aload 8
        //   577: ldc 169
        //   579: aload 9
        //   581: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   584: goto +143 -> 727
        //   587: iload_1
        //   588: istore_2
        //   589: iload_1
        //   590: istore_3
        //   591: aload 7
        //   593: iconst_0
        //   594: aload 11
        //   596: invokeinterface 111 1 0
        //   601: aastore
        //   602: iload_1
        //   603: istore_2
        //   604: iload_1
        //   605: istore_3
        //   606: aload 7
        //   608: iconst_1
        //   609: aload 12
        //   611: getfield 155	com/tencent/mm/storage/ae$b:type	I
        //   614: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   617: aastore
        //   618: iload_1
        //   619: istore_2
        //   620: iload_1
        //   621: istore_3
        //   622: aload 7
        //   624: iconst_2
        //   625: aload 12
        //   627: getfield 165	com/tencent/mm/storage/ae$b:hpH	Ljava/lang/String;
        //   630: aastore
        //   631: iload_1
        //   632: istore_2
        //   633: iload_1
        //   634: istore_3
        //   635: aload 8
        //   637: ldc 171
        //   639: aload 7
        //   641: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   644: goto +83 -> 727
        //   647: iload_1
        //   648: istore_2
        //   649: iload_1
        //   650: istore_3
        //   651: aload 8
        //   653: invokevirtual 174	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
        //   656: aload 8
        //   658: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   661: aload 8
        //   663: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   666: ldc 46
        //   668: new 131	java/lang/StringBuilder
        //   671: dup
        //   672: ldc 133
        //   674: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   677: iload_1
        //   678: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   681: ldc 142
        //   683: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   686: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   689: invokestatic 151	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   692: ldc 22
        //   694: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   697: return
        //   698: astore 7
        //   700: iconst_0
        //   701: istore_2
        //   702: iconst_0
        //   703: istore_1
        //   704: goto -263 -> 441
        //   707: astore 7
        //   709: goto -268 -> 441
        //   712: astore 7
        //   714: iconst_0
        //   715: istore_2
        //   716: iconst_0
        //   717: istore_1
        //   718: goto -403 -> 315
        //   721: aconst_null
        //   722: astore 8
        //   724: goto -686 -> 38
        //   727: iload_1
        //   728: iconst_1
        //   729: iadd
        //   730: istore_1
        //   731: goto -226 -> 505
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	734	0	this	1
        //   10	721	1	i	int
        //   76	640	2	j	int
        //   79	572	3	k	int
        //   1	438	4	m	int
        //   4	295	5	n	int
        //   7	295	6	i1	int
        //   84	1	7	arrayOfObject1	Object[]
        //   282	23	7	localObject1	Object
        //   307	120	7	localRuntimeException1	java.lang.RuntimeException
        //   434	206	7	arrayOfObject2	Object[]
        //   698	1	7	localObject2	Object
        //   707	1	7	localObject3	Object
        //   712	1	7	localRuntimeException2	java.lang.RuntimeException
        //   36	687	8	localSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
        //   96	484	9	arrayOfObject3	Object[]
        //   135	389	10	localObject4	Object
        //   108	487	11	localObject5	Object
        //   126	500	12	localObject6	Object
        //   240	173	13	localb	ae.b
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
        //   378	389	307	java/lang/RuntimeException
        //   393	405	307	java/lang/RuntimeException
        //   409	418	307	java/lang/RuntimeException
        //   422	431	307	java/lang/RuntimeException
        //   493	505	307	java/lang/RuntimeException
        //   509	519	307	java/lang/RuntimeException
        //   523	535	307	java/lang/RuntimeException
        //   539	551	307	java/lang/RuntimeException
        //   560	571	307	java/lang/RuntimeException
        //   575	584	307	java/lang/RuntimeException
        //   591	602	307	java/lang/RuntimeException
        //   606	618	307	java/lang/RuntimeException
        //   622	631	307	java/lang/RuntimeException
        //   635	644	307	java/lang/RuntimeException
        //   651	656	307	java/lang/RuntimeException
        //   80	86	434	finally
        //   92	98	434	finally
        //   104	110	434	finally
        //   116	119	434	finally
        //   184	196	434	finally
        //   200	210	434	finally
        //   214	226	434	finally
        //   230	242	434	finally
        //   251	262	434	finally
        //   266	275	434	finally
        //   293	298	434	finally
        //   304	307	434	finally
        //   378	389	434	finally
        //   393	405	434	finally
        //   409	418	434	finally
        //   422	431	434	finally
        //   493	505	434	finally
        //   509	519	434	finally
        //   523	535	434	finally
        //   539	551	434	finally
        //   560	571	434	finally
        //   575	584	434	finally
        //   591	602	434	finally
        //   606	618	434	finally
        //   622	631	434	finally
        //   635	644	434	finally
        //   651	656	434	finally
        //   64	74	698	finally
        //   315	328	707	finally
        //   64	74	712	java/lang/RuntimeException
      }
    };
    this.hpA = paramh;
    this.mHandler = new ao("ConfigStorage");
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
    if ((paramObject != null) && (b.eUk())) {
      Assert.assertTrue("checkType failed, input type and value[" + paramString + ", " + paramObject + "] are not match", false);
    }
    if (paramBoolean) {
      ac.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", new Object[] { paramString, paramObject });
    }
    AppMethodBeat.o(133273);
    return false;
  }
  
  private Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(133270);
    Assert.assertNotNull("db is null", this.hpA);
    paramString = this.GDl.get(paramString);
    if ((paramString == null) || (paramString == GDj))
    {
      AppMethodBeat.o(133270);
      return paramObject;
    }
    AppMethodBeat.o(133270);
    return paramString;
  }
  
  public final long YH(int paramInt)
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
  
  public final long a(ah.a parama, long paramLong)
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
  
  public final boolean aPv()
  {
    AppMethodBeat.i(133274);
    if ((this.hpA == null) || (this.hpA.eWz()))
    {
      if (this.hpA == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.hpA.eWz()))
      {
        ac.w("MicroMsg.ConfigStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(133274);
        return false;
      }
    }
    AppMethodBeat.o(133274);
    return true;
  }
  
  public final void faa()
  {
    AppMethodBeat.i(133275);
    try
    {
      this.mHandler.removeCallbacks(this.GDp);
      this.mHandler.post(this.GDp);
      this.GDo = true;
      ac.i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
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
    AppMethodBeat.i(210309);
    Object localObject = get(paramInt, null);
    AppMethodBeat.o(210309);
    return localObject;
  }
  
  public final Object get(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133264);
    Assert.assertNotNull("db is null", this.hpA);
    Object localObject = this.GDk.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (localObject == GDj))
    {
      AppMethodBeat.o(133264);
      return paramObject;
    }
    AppMethodBeat.o(133264);
    return localObject;
  }
  
  public final Object get(ah.a parama, Object paramObject)
  {
    AppMethodBeat.i(133266);
    if (parama == null)
    {
      AppMethodBeat.o(133266);
      return paramObject;
    }
    String str = parama.name();
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(133266);
      return paramObject;
    }
    String[] arrayOfString = str.split("_");
    Object localObject = arrayOfString[(arrayOfString.length - 1)];
    parama = (ah.a)localObject;
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
  
  public final boolean getBoolean(ah.a parama, boolean paramBoolean)
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
  
  public final int getInt(ah.a parama, int paramInt)
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
  
  public final Object i(ah.a parama)
  {
    AppMethodBeat.i(210310);
    parama = get(parama, null);
    AppMethodBeat.o(210310);
    return parama;
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133271);
    Assert.assertNotNull("db is null", this.hpA);
    Object localObject1 = paramObject;
    if (paramObject == null) {
      localObject1 = GDj;
    }
    if (!localObject1.equals(this.GDk.put(Integer.valueOf(paramInt), localObject1)))
    {
      if (localObject1 != GDj) {
        break label177;
      }
      paramObject = null;
    }
    for (;;)
    {
      try
      {
        this.GDm.put(Integer.valueOf(paramInt), paramObject);
        if (!this.GDo)
        {
          this.GDo = true;
          this.mHandler.postDelayed(this.GDp, 30000L);
        }
        if (localObject1 != GDj) {
          break label210;
        }
        i = 5;
        b(i, this, Integer.valueOf(paramInt));
        localObject2 = new StringBuilder("SET: ").append(paramInt).append(" => ");
        if (localObject1 != GDj) {
          break label215;
        }
        paramObject = "(DELETED)";
        ac.i("MicroMsg.ConfigStorage", paramObject);
        AppMethodBeat.o(133271);
        return;
      }
      finally
      {
        Object localObject2;
        label177:
        AppMethodBeat.o(133271);
      }
      localObject2 = b.dT(localObject1);
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
  
  public final void set(ah.a parama, Object paramObject)
  {
    AppMethodBeat.i(133272);
    if (parama == null)
    {
      AppMethodBeat.o(133272);
      return;
    }
    Object localObject1 = parama.name();
    if (bs.isNullOrNil((String)localObject1))
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
        parama = GDj;
      }
      if (!parama.equals(this.GDl.put(localObject2, parama)))
      {
        if (parama != GDj) {
          break label246;
        }
        paramObject = null;
      }
      for (;;)
      {
        try
        {
          this.GDn.put(localObject2, paramObject);
          if (i != 0)
          {
            faa();
            if (parama != GDj) {
              break label308;
            }
            i = 5;
            b(i, this, localObject2);
            paramObject = new StringBuilder("SET: ").append((String)localObject2).append(" => ");
            if (parama != GDj) {
              break label313;
            }
            parama = "(DELETED)";
            ac.i("MicroMsg.ConfigStorage", parama);
            AppMethodBeat.o(133272);
            return;
            label246:
            localObject1 = b.dT(parama);
            paramObject = localObject1;
            if (localObject1 != null) {
              break;
            }
            AppMethodBeat.o(133272);
            return;
          }
          if (this.GDo) {
            continue;
          }
          this.GDo = true;
          this.mHandler.postDelayed(this.GDp, 30000L);
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
    extends af<K, Object>
  {
    private final String GDr;
    
    a(String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(133257);
      this.GDr = ("SELECT * FROM " + paramString1 + " WHERE " + paramString2 + "=?;");
      AppMethodBeat.o(133257);
    }
    
    /* Error */
    public final Object create(K paramK)
    {
      // Byte code:
      //   0: ldc 57
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 16	com/tencent/mm/storage/ae$a:GDq	Lcom/tencent/mm/storage/ae;
      //   9: invokestatic 60	com/tencent/mm/storage/ae:a	(Lcom/tencent/mm/storage/ae;)Lcom/tencent/mm/storagebase/h;
      //   12: aload_0
      //   13: getfield 46	com/tencent/mm/storage/ae$a:GDr	Ljava/lang/String;
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
      //   43: new 78	com/tencent/mm/storage/ae$b
      //   46: dup
      //   47: aload 4
      //   49: iconst_1
      //   50: invokeinterface 82 2 0
      //   55: aload 4
      //   57: iconst_2
      //   58: invokeinterface 86 2 0
      //   63: invokespecial 89	com/tencent/mm/storage/ae$b:<init>	(ILjava/lang/String;)V
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
      //   91: getfield 98	com/tencent/mm/storage/ae$b:hpH	Ljava/lang/String;
      //   94: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   100: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   103: aload_2
      //   104: invokevirtual 107	com/tencent/mm/storage/ae$b:aNZ	()Ljava/lang/Object;
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
      //   153: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   156: invokestatic 116	com/tencent/mm/storage/ae:emE	()Ljava/lang/Object;
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
      //   228: invokestatic 130	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    final String hpH;
    final int type;
    
    b(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.hpH = paramString;
    }
    
    static b dT(Object paramObject)
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
      ac.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + paramObject.getClass().toString());
      AppMethodBeat.o(133259);
      return null;
    }
    
    final Object aNZ()
    {
      AppMethodBeat.i(133261);
      if (this.hpH == ae.emE())
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
          ac.e("MicroMsg.ConfigStorage", "exception:%s", new Object[] { bs.m(localException) });
        }
      }
      AppMethodBeat.o(133261);
      return null;
      localObject = Integer.valueOf(this.hpH);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Long.valueOf(this.hpH);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = this.hpH;
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Boolean.valueOf(this.hpH);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Float.valueOf(this.hpH);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Double.valueOf(this.hpH);
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
      if (this.hpH == null)
      {
        if (paramObject.hpH == null)
        {
          AppMethodBeat.o(133260);
          return true;
        }
        AppMethodBeat.o(133260);
        return false;
      }
      boolean bool = this.hpH.equals(paramObject.hpH);
      AppMethodBeat.o(133260);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ae
 * JD-Core Version:    0.7.0.1
 */