package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import junit.framework.Assert;

public final class aq
  extends MStorageEx
{
  public static final String[] SQL_CREATE;
  private static final Object acHf;
  private a<Integer> acHg;
  private a<String> acHh;
  private HashMap<Integer, b> acHi;
  private HashMap<String, b> acHj;
  private volatile boolean acHk;
  private final Runnable acHl;
  public MMHandler mHandler;
  private h omV;
  
  static
  {
    AppMethodBeat.i(133280);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )" };
    acHf = new Object();
    AppMethodBeat.o(133280);
  }
  
  public aq(h paramh)
  {
    AppMethodBeat.i(133262);
    this.acHg = new a("userinfo", "id");
    this.acHh = new a("userinfo2", "sid");
    this.acHi = new HashMap();
    this.acHj = new HashMap();
    this.acHl = new Runnable()
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
        //   17: getfield 14	com/tencent/mm/storage/aq$1:acHm	Lcom/tencent/mm/storage/aq;
        //   20: invokestatic 32	com/tencent/mm/storage/aq:a	(Lcom/tencent/mm/storage/aq;)Lcom/tencent/mm/storagebase/h;
        //   23: ifnull +724 -> 747
        //   26: aload_0
        //   27: getfield 14	com/tencent/mm/storage/aq$1:acHm	Lcom/tencent/mm/storage/aq;
        //   30: invokestatic 32	com/tencent/mm/storage/aq:a	(Lcom/tencent/mm/storage/aq;)Lcom/tencent/mm/storagebase/h;
        //   33: invokevirtual 38	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
        //   36: astore 8
        //   38: aload 8
        //   40: ifnull +11 -> 51
        //   43: aload 8
        //   45: invokevirtual 44	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
        //   48: ifne +16 -> 64
        //   51: ldc 46
        //   53: ldc 48
        //   55: invokestatic 54	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
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
        //   105: getfield 14	com/tencent/mm/storage/aq$1:acHm	Lcom/tencent/mm/storage/aq;
        //   108: astore 11
        //   110: iload 5
        //   112: istore_2
        //   113: iload 6
        //   115: istore_3
        //   116: aload 11
        //   118: monitorenter
        //   119: aload_0
        //   120: getfield 14	com/tencent/mm/storage/aq$1:acHm	Lcom/tencent/mm/storage/aq;
        //   123: invokestatic 67	com/tencent/mm/storage/aq:b	(Lcom/tencent/mm/storage/aq;)Ljava/util/HashMap;
        //   126: astore 12
        //   128: aload_0
        //   129: getfield 14	com/tencent/mm/storage/aq$1:acHm	Lcom/tencent/mm/storage/aq;
        //   132: invokestatic 70	com/tencent/mm/storage/aq:c	(Lcom/tencent/mm/storage/aq;)Ljava/util/HashMap;
        //   135: astore 10
        //   137: aload_0
        //   138: getfield 14	com/tencent/mm/storage/aq$1:acHm	Lcom/tencent/mm/storage/aq;
        //   141: new 72	java/util/HashMap
        //   144: dup
        //   145: invokespecial 73	java/util/HashMap:<init>	()V
        //   148: invokestatic 76	com/tencent/mm/storage/aq:a	(Lcom/tencent/mm/storage/aq;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   151: pop
        //   152: aload_0
        //   153: getfield 14	com/tencent/mm/storage/aq$1:acHm	Lcom/tencent/mm/storage/aq;
        //   156: new 72	java/util/HashMap
        //   159: dup
        //   160: invokespecial 73	java/util/HashMap:<init>	()V
        //   163: invokestatic 78	com/tencent/mm/storage/aq:b	(Lcom/tencent/mm/storage/aq;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   166: pop
        //   167: aload_0
        //   168: getfield 14	com/tencent/mm/storage/aq$1:acHm	Lcom/tencent/mm/storage/aq;
        //   171: invokestatic 82	com/tencent/mm/storage/aq:d	(Lcom/tencent/mm/storage/aq;)Z
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
        //   207: ifeq +300 -> 507
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
        //   237: checkcast 108	com/tencent/mm/storage/aq$b
        //   240: astore 13
        //   242: aload 13
        //   244: ifnonnull +140 -> 384
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
        //   275: goto +478 -> 753
        //   278: astore 7
        //   280: iload 5
        //   282: istore_2
        //   283: iload 6
        //   285: istore_3
        //   286: aload 11
        //   288: monitorexit
        //   289: iload 5
        //   291: istore_2
        //   292: iload 6
        //   294: istore_3
        //   295: ldc 22
        //   297: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   300: iload 5
        //   302: istore_2
        //   303: iload 6
        //   305: istore_3
        //   306: aload 7
        //   308: athrow
        //   309: astore 7
        //   311: iconst_1
        //   312: istore_3
        //   313: iload_2
        //   314: istore_1
        //   315: iload_3
        //   316: istore_2
        //   317: ldc 46
        //   319: aload 7
        //   321: ldc 119
        //   323: iconst_0
        //   324: anewarray 4	java/lang/Object
        //   327: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   330: iload_2
        //   331: ifeq +16 -> 347
        //   334: aload 8
        //   336: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
        //   339: ifeq +8 -> 347
        //   342: aload 8
        //   344: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   347: aload 8
        //   349: invokevirtual 132	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   352: ldc 46
        //   354: new 134	java/lang/StringBuilder
        //   357: dup
        //   358: ldc 136
        //   360: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   363: iload_1
        //   364: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   367: ldc 145
        //   369: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   372: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   375: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   378: ldc 22
        //   380: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   383: return
        //   384: iload_1
        //   385: istore_2
        //   386: iload_1
        //   387: istore_3
        //   388: aload 7
        //   390: iconst_0
        //   391: aload 12
        //   393: invokeinterface 111 1 0
        //   398: aastore
        //   399: iload_1
        //   400: istore_2
        //   401: iload_1
        //   402: istore_3
        //   403: aload 7
        //   405: iconst_1
        //   406: aload 13
        //   408: getfield 158	com/tencent/mm/storage/aq$b:type	I
        //   411: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   414: aastore
        //   415: iload_1
        //   416: istore_2
        //   417: iload_1
        //   418: istore_3
        //   419: aload 7
        //   421: iconst_2
        //   422: aload 13
        //   424: getfield 168	com/tencent/mm/storage/aq$b:onf	Ljava/lang/String;
        //   427: aastore
        //   428: iload_1
        //   429: istore_2
        //   430: iload_1
        //   431: istore_3
        //   432: aload 8
        //   434: ldc 170
        //   436: aload 7
        //   438: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   441: goto +312 -> 753
        //   444: astore 7
        //   446: iload_3
        //   447: istore_1
        //   448: iload 4
        //   450: istore_2
        //   451: iload_2
        //   452: ifeq +16 -> 468
        //   455: aload 8
        //   457: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
        //   460: ifeq +8 -> 468
        //   463: aload 8
        //   465: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   468: aload 8
        //   470: invokevirtual 132	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   473: ldc 46
        //   475: new 134	java/lang/StringBuilder
        //   478: dup
        //   479: ldc 136
        //   481: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   484: iload_1
        //   485: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   488: ldc 145
        //   490: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   493: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   496: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   499: ldc 22
        //   501: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   504: aload 7
        //   506: athrow
        //   507: iload_1
        //   508: istore_2
        //   509: iload_1
        //   510: istore_3
        //   511: aload 10
        //   513: invokevirtual 86	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   516: invokeinterface 92 1 0
        //   521: astore 10
        //   523: iload_1
        //   524: istore_2
        //   525: iload_1
        //   526: istore_3
        //   527: aload 10
        //   529: invokeinterface 97 1 0
        //   534: ifeq +131 -> 665
        //   537: iload_1
        //   538: istore_2
        //   539: iload_1
        //   540: istore_3
        //   541: aload 10
        //   543: invokeinterface 101 1 0
        //   548: checkcast 103	java/util/Map$Entry
        //   551: astore 11
        //   553: iload_1
        //   554: istore_2
        //   555: iload_1
        //   556: istore_3
        //   557: aload 11
        //   559: invokeinterface 106 1 0
        //   564: checkcast 108	com/tencent/mm/storage/aq$b
        //   567: astore 12
        //   569: aload 12
        //   571: ifnonnull +34 -> 605
        //   574: iload_1
        //   575: istore_2
        //   576: iload_1
        //   577: istore_3
        //   578: aload 9
        //   580: iconst_0
        //   581: aload 11
        //   583: invokeinterface 111 1 0
        //   588: aastore
        //   589: iload_1
        //   590: istore_2
        //   591: iload_1
        //   592: istore_3
        //   593: aload 8
        //   595: ldc 172
        //   597: aload 9
        //   599: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   602: goto +158 -> 760
        //   605: iload_1
        //   606: istore_2
        //   607: iload_1
        //   608: istore_3
        //   609: aload 7
        //   611: iconst_0
        //   612: aload 11
        //   614: invokeinterface 111 1 0
        //   619: aastore
        //   620: iload_1
        //   621: istore_2
        //   622: iload_1
        //   623: istore_3
        //   624: aload 7
        //   626: iconst_1
        //   627: aload 12
        //   629: getfield 158	com/tencent/mm/storage/aq$b:type	I
        //   632: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   635: aastore
        //   636: iload_1
        //   637: istore_2
        //   638: iload_1
        //   639: istore_3
        //   640: aload 7
        //   642: iconst_2
        //   643: aload 12
        //   645: getfield 168	com/tencent/mm/storage/aq$b:onf	Ljava/lang/String;
        //   648: aastore
        //   649: iload_1
        //   650: istore_2
        //   651: iload_1
        //   652: istore_3
        //   653: aload 8
        //   655: ldc 174
        //   657: aload 7
        //   659: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   662: goto +98 -> 760
        //   665: iload_1
        //   666: istore_2
        //   667: iload_1
        //   668: istore_3
        //   669: aload 8
        //   671: invokevirtual 177	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
        //   674: aload 8
        //   676: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
        //   679: ifeq +8 -> 687
        //   682: aload 8
        //   684: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   687: aload 8
        //   689: invokevirtual 132	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   692: ldc 46
        //   694: new 134	java/lang/StringBuilder
        //   697: dup
        //   698: ldc 136
        //   700: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   703: iload_1
        //   704: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   707: ldc 145
        //   709: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   712: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   715: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   718: ldc 22
        //   720: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   723: return
        //   724: astore 7
        //   726: iconst_0
        //   727: istore_2
        //   728: iconst_0
        //   729: istore_1
        //   730: goto -279 -> 451
        //   733: astore 7
        //   735: goto -284 -> 451
        //   738: astore 7
        //   740: iconst_0
        //   741: istore_2
        //   742: iconst_0
        //   743: istore_1
        //   744: goto -427 -> 317
        //   747: aconst_null
        //   748: astore 8
        //   750: goto -712 -> 38
        //   753: iload_1
        //   754: iconst_1
        //   755: iadd
        //   756: istore_1
        //   757: goto -561 -> 196
        //   760: iload_1
        //   761: iconst_1
        //   762: iadd
        //   763: istore_1
        //   764: goto -241 -> 523
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	767	0	this	1
        //   10	754	1	i	int
        //   76	666	2	j	int
        //   79	590	3	k	int
        //   1	448	4	m	int
        //   4	297	5	n	int
        //   7	297	6	i1	int
        //   84	1	7	arrayOfObject1	Object[]
        //   278	29	7	localObject1	Object
        //   309	128	7	localRuntimeException1	java.lang.RuntimeException
        //   444	214	7	arrayOfObject2	Object[]
        //   724	1	7	localObject2	Object
        //   733	1	7	localObject3	Object
        //   738	1	7	localRuntimeException2	java.lang.RuntimeException
        //   36	713	8	localSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
        //   96	502	9	arrayOfObject3	Object[]
        //   135	407	10	localObject4	Object
        //   108	505	11	localObject5	Object
        //   126	518	12	localObject6	Object
        //   240	183	13	localb	aq.b
        // Exception table:
        //   from	to	target	type
        //   119	178	278	finally
        //   80	86	309	java/lang/RuntimeException
        //   92	98	309	java/lang/RuntimeException
        //   104	110	309	java/lang/RuntimeException
        //   116	119	309	java/lang/RuntimeException
        //   184	196	309	java/lang/RuntimeException
        //   200	210	309	java/lang/RuntimeException
        //   214	226	309	java/lang/RuntimeException
        //   230	242	309	java/lang/RuntimeException
        //   251	262	309	java/lang/RuntimeException
        //   266	275	309	java/lang/RuntimeException
        //   286	289	309	java/lang/RuntimeException
        //   295	300	309	java/lang/RuntimeException
        //   306	309	309	java/lang/RuntimeException
        //   388	399	309	java/lang/RuntimeException
        //   403	415	309	java/lang/RuntimeException
        //   419	428	309	java/lang/RuntimeException
        //   432	441	309	java/lang/RuntimeException
        //   511	523	309	java/lang/RuntimeException
        //   527	537	309	java/lang/RuntimeException
        //   541	553	309	java/lang/RuntimeException
        //   557	569	309	java/lang/RuntimeException
        //   578	589	309	java/lang/RuntimeException
        //   593	602	309	java/lang/RuntimeException
        //   609	620	309	java/lang/RuntimeException
        //   624	636	309	java/lang/RuntimeException
        //   640	649	309	java/lang/RuntimeException
        //   653	662	309	java/lang/RuntimeException
        //   669	674	309	java/lang/RuntimeException
        //   80	86	444	finally
        //   92	98	444	finally
        //   104	110	444	finally
        //   116	119	444	finally
        //   184	196	444	finally
        //   200	210	444	finally
        //   214	226	444	finally
        //   230	242	444	finally
        //   251	262	444	finally
        //   266	275	444	finally
        //   286	289	444	finally
        //   295	300	444	finally
        //   306	309	444	finally
        //   388	399	444	finally
        //   403	415	444	finally
        //   419	428	444	finally
        //   432	441	444	finally
        //   511	523	444	finally
        //   527	537	444	finally
        //   541	553	444	finally
        //   557	569	444	finally
        //   578	589	444	finally
        //   593	602	444	finally
        //   609	620	444	finally
        //   624	636	444	finally
        //   640	649	444	finally
        //   653	662	444	finally
        //   669	674	444	finally
        //   64	74	724	finally
        //   317	330	733	finally
        //   64	74	738	java/lang/RuntimeException
      }
    };
    this.omV = paramh;
    this.mHandler = new MMHandler("ConfigStorage");
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
    if ((paramObject != null) && (CrashReportFactory.hasDebuger())) {
      Assert.assertTrue("checkType failed, input type and value[" + paramString + ", " + paramObject + "] are not match", false);
    }
    if (paramBoolean) {
      Log.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", new Object[] { paramString, paramObject });
    }
    AppMethodBeat.o(133273);
    return false;
  }
  
  private Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(133270);
    Assert.assertNotNull("db is null", this.omV);
    paramString = this.acHh.get(paramString);
    if ((paramString == null) || (paramString == acHf))
    {
      AppMethodBeat.o(133270);
      return paramObject;
    }
    AppMethodBeat.o(133270);
    return paramString;
  }
  
  public final void B(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133271);
    Assert.assertNotNull("db is null", this.omV);
    Object localObject1 = paramObject;
    if (paramObject == null) {
      localObject1 = acHf;
    }
    if (!localObject1.equals(this.acHg.put(Integer.valueOf(paramInt), localObject1)))
    {
      if (localObject1 != acHf) {
        break label172;
      }
      paramObject = null;
    }
    for (;;)
    {
      try
      {
        this.acHi.put(Integer.valueOf(paramInt), paramObject);
        if (!this.acHk)
        {
          this.acHk = true;
          this.mHandler.postDelayed(this.acHl, 30000L);
        }
        if (localObject1 != acHf) {
          break label203;
        }
        i = 5;
        doNotify(i, this, Integer.valueOf(paramInt));
        localObject2 = new StringBuilder("SET: ").append(paramInt).append(" => ");
        if (localObject1 != acHf) {
          break label208;
        }
        paramObject = "(DELETED)";
        Log.i("MicroMsg.ConfigStorage", paramObject);
        AppMethodBeat.o(133271);
        return;
      }
      finally
      {
        Object localObject2;
        label172:
        AppMethodBeat.o(133271);
      }
      localObject2 = b.gE(localObject1);
      paramObject = localObject2;
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(133271);
      return;
      label203:
      int i = 4;
      continue;
      label208:
      paramObject = localObject1.toString();
    }
  }
  
  public final Object R(String paramString, Object paramObject)
  {
    AppMethodBeat.i(248696);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(248696);
      return paramObject;
    }
    String[] arrayOfString = paramString.split("_");
    String str2 = arrayOfString[(arrayOfString.length - 1)];
    String str1 = str2;
    if (str2.equals("SYNC")) {
      str1 = arrayOfString[(arrayOfString.length - 2)];
    }
    paramString = get(paramString.substring(0, paramString.lastIndexOf(str1) + str1.length()), paramObject);
    if (!a(str1, paramString, false))
    {
      AppMethodBeat.o(248696);
      return paramObject;
    }
    AppMethodBeat.o(248696);
    return paramString;
  }
  
  public final void S(String paramString, Object paramObject)
  {
    AppMethodBeat.i(248731);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(248731);
      return;
    }
    Object localObject2 = paramString.split("_");
    Object localObject1 = localObject2[(localObject2.length - 1)];
    if (((String)localObject1).equals("SYNC")) {
      localObject1 = localObject2[(localObject2.length - 2)];
    }
    for (int i = 1;; i = 0)
    {
      if (!a((String)localObject1, paramObject, true))
      {
        AppMethodBeat.o(248731);
        return;
      }
      int j = paramString.lastIndexOf((String)localObject1);
      String str = paramString.substring(0, ((String)localObject1).length() + j);
      localObject1 = paramObject;
      if (paramObject == null) {
        localObject1 = acHf;
      }
      if (!localObject1.equals(this.acHh.put(str, localObject1)))
      {
        if (localObject1 != acHf) {
          break label232;
        }
        paramObject = null;
      }
      for (;;)
      {
        try
        {
          this.acHj.put(str, paramObject);
          if (i != 0)
          {
            iZy();
            if (localObject1 != acHf) {
              break label295;
            }
            i = 5;
            doNotify(i, this, paramString);
            paramObject = new StringBuilder("SET: ").append(str).append(" => ");
            if (localObject1 != acHf) {
              break label300;
            }
            paramString = "(DELETED)";
            Log.i("MicroMsg.ConfigStorage", paramString);
            AppMethodBeat.o(248731);
            return;
            label232:
            localObject2 = b.gE(localObject1);
            paramObject = localObject2;
            if (localObject2 != null) {
              break;
            }
            AppMethodBeat.o(248731);
            return;
          }
          if (this.acHk) {
            continue;
          }
          this.acHk = true;
          this.mHandler.postDelayed(this.acHl, 30000L);
          continue;
          i = 4;
        }
        finally
        {
          AppMethodBeat.o(248731);
        }
        label295:
        continue;
        label300:
        paramString = localObject1.toString();
      }
    }
  }
  
  public final long a(at.a parama, long paramLong)
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
  
  public final long amW(int paramInt)
  {
    AppMethodBeat.i(133279);
    Long localLong = (Long)d(paramInt, null);
    if (localLong == null)
    {
      AppMethodBeat.o(133279);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(133279);
    return l;
  }
  
  public final String b(at.a parama, String paramString)
  {
    AppMethodBeat.i(248703);
    parama = get(parama, paramString);
    if ((parama != null) && ((parama instanceof String)))
    {
      parama = (String)parama;
      AppMethodBeat.o(248703);
      return parama;
    }
    AppMethodBeat.o(248703);
    return paramString;
  }
  
  public final String bbx(String paramString)
  {
    AppMethodBeat.i(369604);
    Object localObject = d(274436, paramString);
    if ((localObject != null) && ((localObject instanceof String)))
    {
      paramString = (String)localObject;
      AppMethodBeat.o(369604);
      return paramString;
    }
    AppMethodBeat.o(369604);
    return paramString;
  }
  
  public final Object d(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133264);
    Assert.assertNotNull("db is null", this.omV);
    Object localObject = this.acHg.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (localObject == acHf))
    {
      AppMethodBeat.o(133264);
      return paramObject;
    }
    AppMethodBeat.o(133264);
    return localObject;
  }
  
  public final Object get(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(133266);
    if (parama == null)
    {
      AppMethodBeat.o(133266);
      return paramObject;
    }
    parama = R(parama.name(), paramObject);
    AppMethodBeat.o(133266);
    return parama;
  }
  
  public final boolean getBoolean(at.a parama, boolean paramBoolean)
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
    Integer localInteger = (Integer)d(paramInt1, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(133277);
      return paramInt2;
    }
    paramInt1 = localInteger.intValue();
    AppMethodBeat.o(133277);
    return paramInt1;
  }
  
  public final int getInt(at.a parama, int paramInt)
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
  
  public final void iZy()
  {
    AppMethodBeat.i(133275);
    try
    {
      this.mHandler.removeCallbacks(this.acHl);
      this.mHandler.post(this.acHl);
      this.acHk = true;
      Log.i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
      AppMethodBeat.o(133275);
      return;
    }
    finally
    {
      AppMethodBeat.o(133275);
    }
  }
  
  public final void set(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(133272);
    if (parama == null)
    {
      AppMethodBeat.o(133272);
      return;
    }
    Object localObject2 = parama.name();
    if (Util.isNullOrNil((String)localObject2))
    {
      AppMethodBeat.o(133272);
      return;
    }
    Object localObject3 = ((String)localObject2).split("_");
    Object localObject1 = localObject3[(localObject3.length - 1)];
    if (((String)localObject1).equals("SYNC")) {
      localObject1 = localObject3[(localObject3.length - 2)];
    }
    for (int i = 1;; i = 0)
    {
      if (!a((String)localObject1, paramObject, true))
      {
        AppMethodBeat.o(133272);
        return;
      }
      int j = ((String)localObject2).lastIndexOf((String)localObject1);
      localObject3 = ((String)localObject2).substring(0, ((String)localObject1).length() + j);
      localObject1 = paramObject;
      if (paramObject == null) {
        localObject1 = acHf;
      }
      if (!localObject1.equals(this.acHh.put(localObject3, localObject1)))
      {
        if (localObject1 != acHf) {
          break label253;
        }
        paramObject = null;
      }
      for (;;)
      {
        try
        {
          this.acHj.put(localObject3, paramObject);
          if (i != 0)
          {
            iZy();
            if (localObject1 != acHf) {
              break label316;
            }
            i = 5;
            doNotify(i, this, parama);
            paramObject = new StringBuilder("SET: ").append((String)localObject3).append(" => ");
            if (localObject1 != acHf) {
              break label321;
            }
            parama = "(DELETED)";
            Log.i("MicroMsg.ConfigStorage", parama);
            AppMethodBeat.o(133272);
            return;
            label253:
            localObject2 = b.gE(localObject1);
            paramObject = localObject2;
            if (localObject2 != null) {
              break;
            }
            AppMethodBeat.o(133272);
            return;
          }
          if (this.acHk) {
            continue;
          }
          this.acHk = true;
          this.mHandler.postDelayed(this.acHl, 30000L);
          continue;
          i = 4;
        }
        finally
        {
          AppMethodBeat.o(133272);
        }
        label316:
        continue;
        label321:
        parama = localObject1.toString();
      }
    }
  }
  
  public final void setInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133276);
    B(paramInt1, Integer.valueOf(paramInt2));
    AppMethodBeat.o(133276);
  }
  
  public final void setLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(133278);
    B(paramInt, Long.valueOf(paramLong));
    AppMethodBeat.o(133278);
  }
  
  public final boolean shouldProcessEvent()
  {
    AppMethodBeat.i(133274);
    if ((this.omV == null) || (this.omV.isClose()))
    {
      if (this.omV == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.omV.isClose()))
      {
        Log.w("MicroMsg.ConfigStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(133274);
        return false;
      }
    }
    AppMethodBeat.o(133274);
    return true;
  }
  
  final class a<K>
    extends LruCache<K, Object>
  {
    private final String acHn;
    
    a(String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(133257);
      this.acHn = ("SELECT * FROM " + paramString1 + " WHERE " + paramString2 + "=?;");
      AppMethodBeat.o(133257);
    }
    
    /* Error */
    public final Object create(K paramK)
    {
      // Byte code:
      //   0: ldc 55
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 16	com/tencent/mm/storage/aq$a:acHm	Lcom/tencent/mm/storage/aq;
      //   9: invokestatic 58	com/tencent/mm/storage/aq:a	(Lcom/tencent/mm/storage/aq;)Lcom/tencent/mm/storagebase/h;
      //   12: aload_0
      //   13: getfield 46	com/tencent/mm/storage/aq$a:acHn	Ljava/lang/String;
      //   16: iconst_1
      //   17: anewarray 60	java/lang/String
      //   20: dup
      //   21: iconst_0
      //   22: aload_1
      //   23: invokevirtual 63	java/lang/Object:toString	()Ljava/lang/String;
      //   26: aastore
      //   27: iconst_2
      //   28: invokevirtual 69	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 75 1 0
      //   38: ifeq +83 -> 121
      //   41: new 77	com/tencent/mm/storage/aq$b
      //   44: dup
      //   45: aload_2
      //   46: iconst_1
      //   47: invokeinterface 81 2 0
      //   52: aload_2
      //   53: iconst_2
      //   54: invokeinterface 85 2 0
      //   59: invokespecial 88	com/tencent/mm/storage/aq$b:<init>	(ILjava/lang/String;)V
      //   62: astore_3
      //   63: ldc 90
      //   65: new 27	java/lang/StringBuilder
      //   68: dup
      //   69: ldc 92
      //   71: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   74: aload_1
      //   75: invokevirtual 63	java/lang/Object:toString	()Ljava/lang/String;
      //   78: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: ldc 94
      //   83: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   86: aload_3
      //   87: getfield 97	com/tencent/mm/storage/aq$b:onf	Ljava/lang/String;
      //   90: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   93: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   96: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   99: aload_3
      //   100: invokevirtual 106	com/tencent/mm/storage/aq$b:bVp	()Ljava/lang/Object;
      //   103: astore_3
      //   104: aload_2
      //   105: ifnull +9 -> 114
      //   108: aload_2
      //   109: invokeinterface 110 1 0
      //   114: ldc 55
      //   116: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   119: aload_3
      //   120: areturn
      //   121: ldc 90
      //   123: new 27	java/lang/StringBuilder
      //   126: dup
      //   127: ldc 92
      //   129: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   132: aload_1
      //   133: invokevirtual 63	java/lang/Object:toString	()Ljava/lang/String;
      //   136: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   139: ldc 112
      //   141: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   144: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   147: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   150: invokestatic 115	com/tencent/mm/storage/aq:icm	()Ljava/lang/Object;
      //   153: astore_3
      //   154: aload_2
      //   155: ifnull +9 -> 164
      //   158: aload_2
      //   159: invokeinterface 110 1 0
      //   164: ldc 55
      //   166: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   169: aload_3
      //   170: areturn
      //   171: astore_3
      //   172: aload_2
      //   173: ifnull +9 -> 182
      //   176: aload_2
      //   177: invokeinterface 110 1 0
      //   182: ldc 55
      //   184: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   187: aload_3
      //   188: athrow
      //   189: astore_2
      //   190: ldc 90
      //   192: aload_2
      //   193: ldc 117
      //   195: aload_1
      //   196: invokestatic 121	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   199: invokevirtual 125	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   202: iconst_0
      //   203: anewarray 62	java/lang/Object
      //   206: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   209: ldc 55
      //   211: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   214: aconst_null
      //   215: areturn
      //   216: astore_2
      //   217: aload_3
      //   218: aload_2
      //   219: invokevirtual 135	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   222: goto -40 -> 182
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	225	0	this	a
      //   0	225	1	paramK	K
      //   31	146	2	localCursor	android.database.Cursor
      //   189	4	2	localRuntimeException	java.lang.RuntimeException
      //   216	3	2	localThrowable	java.lang.Throwable
      //   62	108	3	localObject1	Object
      //   171	47	3	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   32	104	171	finally
      //   121	154	171	finally
      //   5	32	189	java/lang/RuntimeException
      //   108	114	189	java/lang/RuntimeException
      //   158	164	189	java/lang/RuntimeException
      //   182	189	189	java/lang/RuntimeException
      //   217	222	189	java/lang/RuntimeException
      //   176	182	216	finally
    }
  }
  
  static final class b
  {
    final String onf;
    final int type;
    
    b(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.onf = paramString;
    }
    
    static b gE(Object paramObject)
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
      Log.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + paramObject.getClass().toString());
      AppMethodBeat.o(133259);
      return null;
    }
    
    final Object bVp()
    {
      AppMethodBeat.i(133261);
      if (this.onf == aq.icm())
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
          Log.e("MicroMsg.ConfigStorage", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        }
      }
      AppMethodBeat.o(133261);
      return null;
      localObject = Integer.valueOf(this.onf);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Long.valueOf(this.onf);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = this.onf;
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Boolean.valueOf(this.onf);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Float.valueOf(this.onf);
      AppMethodBeat.o(133261);
      return localObject;
      localObject = Double.valueOf(this.onf);
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
      if (this.onf == null)
      {
        if (paramObject.onf == null)
        {
          AppMethodBeat.o(133260);
          return true;
        }
        AppMethodBeat.o(133260);
        return false;
      }
      boolean bool = this.onf.equals(paramObject.onf);
      AppMethodBeat.o(133260);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.aq
 * JD-Core Version:    0.7.0.1
 */