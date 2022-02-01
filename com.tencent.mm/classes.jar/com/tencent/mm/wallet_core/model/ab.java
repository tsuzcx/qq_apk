package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import junit.framework.Assert;

public class ab
  extends MStorageEx
{
  public static final String[] SQL_CREATE;
  private static final Object acHf;
  private HashMap<Integer, b> acHi;
  private HashMap<String, b> acHj;
  private volatile boolean acHk;
  private final Runnable acHl;
  private a<String> agTA;
  private MMHandler mHandler;
  private h omV;
  
  static
  {
    AppMethodBeat.i(130945);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS walletcache ( sid TEXT PRIMARY KEY, type INT, value TEXT )" };
    acHf = new Object();
    AppMethodBeat.o(130945);
  }
  
  public ab(h paramh)
  {
    AppMethodBeat.i(130938);
    this.agTA = new a("walletcache", "sid");
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
        //   17: getfield 14	com/tencent/mm/wallet_core/model/ab$1:agTB	Lcom/tencent/mm/wallet_core/model/ab;
        //   20: invokestatic 32	com/tencent/mm/wallet_core/model/ab:a	(Lcom/tencent/mm/wallet_core/model/ab;)Lcom/tencent/mm/storagebase/h;
        //   23: invokevirtual 38	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
        //   26: astore 8
        //   28: aload 8
        //   30: ifnull +11 -> 41
        //   33: aload 8
        //   35: invokevirtual 44	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
        //   38: ifne +16 -> 54
        //   41: ldc 46
        //   43: ldc 48
        //   45: invokestatic 54	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   48: ldc 22
        //   50: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   53: return
        //   54: aload 8
        //   56: invokevirtual 60	com/tencent/wcdb/database/SQLiteDatabase:acquireReference	()V
        //   59: aload 8
        //   61: invokevirtual 63	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
        //   64: iload 5
        //   66: istore_2
        //   67: iload 6
        //   69: istore_3
        //   70: iconst_3
        //   71: anewarray 4	java/lang/Object
        //   74: astore 7
        //   76: iload 5
        //   78: istore_2
        //   79: iload 6
        //   81: istore_3
        //   82: iconst_1
        //   83: anewarray 4	java/lang/Object
        //   86: astore 9
        //   88: iload 5
        //   90: istore_2
        //   91: iload 6
        //   93: istore_3
        //   94: aload_0
        //   95: getfield 14	com/tencent/mm/wallet_core/model/ab$1:agTB	Lcom/tencent/mm/wallet_core/model/ab;
        //   98: astore 11
        //   100: iload 5
        //   102: istore_2
        //   103: iload 6
        //   105: istore_3
        //   106: aload 11
        //   108: monitorenter
        //   109: aload_0
        //   110: getfield 14	com/tencent/mm/wallet_core/model/ab$1:agTB	Lcom/tencent/mm/wallet_core/model/ab;
        //   113: invokestatic 67	com/tencent/mm/wallet_core/model/ab:b	(Lcom/tencent/mm/wallet_core/model/ab;)Ljava/util/HashMap;
        //   116: astore 12
        //   118: aload_0
        //   119: getfield 14	com/tencent/mm/wallet_core/model/ab$1:agTB	Lcom/tencent/mm/wallet_core/model/ab;
        //   122: invokestatic 70	com/tencent/mm/wallet_core/model/ab:c	(Lcom/tencent/mm/wallet_core/model/ab;)Ljava/util/HashMap;
        //   125: astore 10
        //   127: aload_0
        //   128: getfield 14	com/tencent/mm/wallet_core/model/ab$1:agTB	Lcom/tencent/mm/wallet_core/model/ab;
        //   131: new 72	java/util/HashMap
        //   134: dup
        //   135: invokespecial 73	java/util/HashMap:<init>	()V
        //   138: invokestatic 76	com/tencent/mm/wallet_core/model/ab:a	(Lcom/tencent/mm/wallet_core/model/ab;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   141: pop
        //   142: aload_0
        //   143: getfield 14	com/tencent/mm/wallet_core/model/ab$1:agTB	Lcom/tencent/mm/wallet_core/model/ab;
        //   146: new 72	java/util/HashMap
        //   149: dup
        //   150: invokespecial 73	java/util/HashMap:<init>	()V
        //   153: invokestatic 78	com/tencent/mm/wallet_core/model/ab:b	(Lcom/tencent/mm/wallet_core/model/ab;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   156: pop
        //   157: aload_0
        //   158: getfield 14	com/tencent/mm/wallet_core/model/ab$1:agTB	Lcom/tencent/mm/wallet_core/model/ab;
        //   161: invokestatic 82	com/tencent/mm/wallet_core/model/ab:d	(Lcom/tencent/mm/wallet_core/model/ab;)Z
        //   164: pop
        //   165: aload 11
        //   167: monitorexit
        //   168: iload 5
        //   170: istore_2
        //   171: iload 6
        //   173: istore_3
        //   174: aload 12
        //   176: invokevirtual 86	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   179: invokeinterface 92 1 0
        //   184: astore 11
        //   186: iload_1
        //   187: istore_2
        //   188: iload_1
        //   189: istore_3
        //   190: aload 11
        //   192: invokeinterface 97 1 0
        //   197: ifeq +284 -> 481
        //   200: iload_1
        //   201: istore_2
        //   202: iload_1
        //   203: istore_3
        //   204: aload 11
        //   206: invokeinterface 101 1 0
        //   211: checkcast 103	java/util/Map$Entry
        //   214: astore 12
        //   216: iload_1
        //   217: istore_2
        //   218: iload_1
        //   219: istore_3
        //   220: aload 12
        //   222: invokeinterface 106 1 0
        //   227: checkcast 108	com/tencent/mm/wallet_core/model/ab$b
        //   230: astore 13
        //   232: aload 13
        //   234: ifnonnull +132 -> 366
        //   237: iload_1
        //   238: istore_2
        //   239: iload_1
        //   240: istore_3
        //   241: aload 9
        //   243: iconst_0
        //   244: aload 12
        //   246: invokeinterface 111 1 0
        //   251: aastore
        //   252: iload_1
        //   253: istore_2
        //   254: iload_1
        //   255: istore_3
        //   256: aload 8
        //   258: ldc 113
        //   260: aload 9
        //   262: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   265: goto +448 -> 713
        //   268: astore 7
        //   270: iload 5
        //   272: istore_2
        //   273: iload 6
        //   275: istore_3
        //   276: aload 11
        //   278: monitorexit
        //   279: iload 5
        //   281: istore_2
        //   282: iload 6
        //   284: istore_3
        //   285: ldc 22
        //   287: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   290: iload 5
        //   292: istore_2
        //   293: iload 6
        //   295: istore_3
        //   296: aload 7
        //   298: athrow
        //   299: astore 7
        //   301: iconst_1
        //   302: istore_3
        //   303: iload_2
        //   304: istore_1
        //   305: iload_3
        //   306: istore_2
        //   307: ldc 46
        //   309: aload 7
        //   311: ldc 119
        //   313: iconst_0
        //   314: anewarray 4	java/lang/Object
        //   317: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   320: iload_2
        //   321: ifeq +8 -> 329
        //   324: aload 8
        //   326: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   329: aload 8
        //   331: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   334: ldc 46
        //   336: new 131	java/lang/StringBuilder
        //   339: dup
        //   340: ldc 133
        //   342: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   345: iload_1
        //   346: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   349: ldc 142
        //   351: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   354: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   357: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   360: ldc 22
        //   362: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   365: return
        //   366: iload_1
        //   367: istore_2
        //   368: iload_1
        //   369: istore_3
        //   370: aload 7
        //   372: iconst_0
        //   373: aload 12
        //   375: invokeinterface 111 1 0
        //   380: aastore
        //   381: iload_1
        //   382: istore_2
        //   383: iload_1
        //   384: istore_3
        //   385: aload 7
        //   387: iconst_1
        //   388: aload 13
        //   390: getfield 155	com/tencent/mm/wallet_core/model/ab$b:type	I
        //   393: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   396: aastore
        //   397: iload_1
        //   398: istore_2
        //   399: iload_1
        //   400: istore_3
        //   401: aload 7
        //   403: iconst_2
        //   404: aload 13
        //   406: getfield 165	com/tencent/mm/wallet_core/model/ab$b:onf	Ljava/lang/String;
        //   409: aastore
        //   410: iload_1
        //   411: istore_2
        //   412: iload_1
        //   413: istore_3
        //   414: aload 8
        //   416: ldc 167
        //   418: aload 7
        //   420: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   423: goto +290 -> 713
        //   426: astore 7
        //   428: iload_3
        //   429: istore_1
        //   430: iload 4
        //   432: istore_2
        //   433: iload_2
        //   434: ifeq +8 -> 442
        //   437: aload 8
        //   439: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   442: aload 8
        //   444: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   447: ldc 46
        //   449: new 131	java/lang/StringBuilder
        //   452: dup
        //   453: ldc 133
        //   455: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   458: iload_1
        //   459: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   462: ldc 142
        //   464: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   467: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   470: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   473: ldc 22
        //   475: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   478: aload 7
        //   480: athrow
        //   481: iload_1
        //   482: istore_2
        //   483: iload_1
        //   484: istore_3
        //   485: aload 10
        //   487: invokevirtual 86	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   490: invokeinterface 92 1 0
        //   495: astore 10
        //   497: iload_1
        //   498: istore_2
        //   499: iload_1
        //   500: istore_3
        //   501: aload 10
        //   503: invokeinterface 97 1 0
        //   508: ifeq +131 -> 639
        //   511: iload_1
        //   512: istore_2
        //   513: iload_1
        //   514: istore_3
        //   515: aload 10
        //   517: invokeinterface 101 1 0
        //   522: checkcast 103	java/util/Map$Entry
        //   525: astore 11
        //   527: iload_1
        //   528: istore_2
        //   529: iload_1
        //   530: istore_3
        //   531: aload 11
        //   533: invokeinterface 106 1 0
        //   538: checkcast 108	com/tencent/mm/wallet_core/model/ab$b
        //   541: astore 12
        //   543: aload 12
        //   545: ifnonnull +34 -> 579
        //   548: iload_1
        //   549: istore_2
        //   550: iload_1
        //   551: istore_3
        //   552: aload 9
        //   554: iconst_0
        //   555: aload 11
        //   557: invokeinterface 111 1 0
        //   562: aastore
        //   563: iload_1
        //   564: istore_2
        //   565: iload_1
        //   566: istore_3
        //   567: aload 8
        //   569: ldc 169
        //   571: aload 9
        //   573: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   576: goto +144 -> 720
        //   579: iload_1
        //   580: istore_2
        //   581: iload_1
        //   582: istore_3
        //   583: aload 7
        //   585: iconst_0
        //   586: aload 11
        //   588: invokeinterface 111 1 0
        //   593: aastore
        //   594: iload_1
        //   595: istore_2
        //   596: iload_1
        //   597: istore_3
        //   598: aload 7
        //   600: iconst_1
        //   601: aload 12
        //   603: getfield 155	com/tencent/mm/wallet_core/model/ab$b:type	I
        //   606: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   609: aastore
        //   610: iload_1
        //   611: istore_2
        //   612: iload_1
        //   613: istore_3
        //   614: aload 7
        //   616: iconst_2
        //   617: aload 12
        //   619: getfield 165	com/tencent/mm/wallet_core/model/ab$b:onf	Ljava/lang/String;
        //   622: aastore
        //   623: iload_1
        //   624: istore_2
        //   625: iload_1
        //   626: istore_3
        //   627: aload 8
        //   629: ldc 167
        //   631: aload 7
        //   633: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   636: goto +84 -> 720
        //   639: iload_1
        //   640: istore_2
        //   641: iload_1
        //   642: istore_3
        //   643: aload 8
        //   645: invokevirtual 172	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
        //   648: aload 8
        //   650: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   653: aload 8
        //   655: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   658: ldc 46
        //   660: new 131	java/lang/StringBuilder
        //   663: dup
        //   664: ldc 133
        //   666: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   669: iload_1
        //   670: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   673: ldc 142
        //   675: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   678: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   681: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   684: ldc 22
        //   686: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   689: return
        //   690: astore 7
        //   692: iconst_0
        //   693: istore_2
        //   694: iconst_0
        //   695: istore_1
        //   696: goto -263 -> 433
        //   699: astore 7
        //   701: goto -268 -> 433
        //   704: astore 7
        //   706: iconst_0
        //   707: istore_2
        //   708: iconst_0
        //   709: istore_1
        //   710: goto -403 -> 307
        //   713: iload_1
        //   714: iconst_1
        //   715: iadd
        //   716: istore_1
        //   717: goto -531 -> 186
        //   720: iload_1
        //   721: iconst_1
        //   722: iadd
        //   723: istore_1
        //   724: goto -227 -> 497
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	727	0	this	1
        //   10	714	1	i	int
        //   66	642	2	j	int
        //   69	574	3	k	int
        //   1	430	4	m	int
        //   4	287	5	n	int
        //   7	287	6	i1	int
        //   74	1	7	arrayOfObject1	Object[]
        //   268	29	7	localObject1	Object
        //   299	120	7	localRuntimeException1	java.lang.RuntimeException
        //   426	206	7	arrayOfObject2	Object[]
        //   690	1	7	localObject2	Object
        //   699	1	7	localObject3	Object
        //   704	1	7	localRuntimeException2	java.lang.RuntimeException
        //   26	628	8	localSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
        //   86	486	9	arrayOfObject3	Object[]
        //   125	391	10	localObject4	Object
        //   98	489	11	localObject5	Object
        //   116	502	12	localObject6	Object
        //   230	175	13	localb	ab.b
        // Exception table:
        //   from	to	target	type
        //   109	168	268	finally
        //   70	76	299	java/lang/RuntimeException
        //   82	88	299	java/lang/RuntimeException
        //   94	100	299	java/lang/RuntimeException
        //   106	109	299	java/lang/RuntimeException
        //   174	186	299	java/lang/RuntimeException
        //   190	200	299	java/lang/RuntimeException
        //   204	216	299	java/lang/RuntimeException
        //   220	232	299	java/lang/RuntimeException
        //   241	252	299	java/lang/RuntimeException
        //   256	265	299	java/lang/RuntimeException
        //   276	279	299	java/lang/RuntimeException
        //   285	290	299	java/lang/RuntimeException
        //   296	299	299	java/lang/RuntimeException
        //   370	381	299	java/lang/RuntimeException
        //   385	397	299	java/lang/RuntimeException
        //   401	410	299	java/lang/RuntimeException
        //   414	423	299	java/lang/RuntimeException
        //   485	497	299	java/lang/RuntimeException
        //   501	511	299	java/lang/RuntimeException
        //   515	527	299	java/lang/RuntimeException
        //   531	543	299	java/lang/RuntimeException
        //   552	563	299	java/lang/RuntimeException
        //   567	576	299	java/lang/RuntimeException
        //   583	594	299	java/lang/RuntimeException
        //   598	610	299	java/lang/RuntimeException
        //   614	623	299	java/lang/RuntimeException
        //   627	636	299	java/lang/RuntimeException
        //   643	648	299	java/lang/RuntimeException
        //   70	76	426	finally
        //   82	88	426	finally
        //   94	100	426	finally
        //   106	109	426	finally
        //   174	186	426	finally
        //   190	200	426	finally
        //   204	216	426	finally
        //   220	232	426	finally
        //   241	252	426	finally
        //   256	265	426	finally
        //   276	279	426	finally
        //   285	290	426	finally
        //   296	299	426	finally
        //   370	381	426	finally
        //   385	397	426	finally
        //   401	410	426	finally
        //   414	423	426	finally
        //   485	497	426	finally
        //   501	511	426	finally
        //   515	527	426	finally
        //   531	543	426	finally
        //   552	563	426	finally
        //   567	576	426	finally
        //   583	594	426	finally
        //   598	610	426	finally
        //   614	623	426	finally
        //   627	636	426	finally
        //   643	648	426	finally
        //   54	64	690	finally
        //   307	320	699	finally
        //   54	64	704	java/lang/RuntimeException
      }
    };
    this.omV = paramh;
    this.mHandler = new MMHandler("WalletCacheStorage");
    AppMethodBeat.o(130938);
  }
  
  private static boolean a(String paramString, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(130942);
    if ((paramObject == null) && (paramBoolean))
    {
      AppMethodBeat.o(130942);
      return true;
    }
    if ((paramString.equals("INT")) && ((paramObject instanceof Integer)))
    {
      AppMethodBeat.o(130942);
      return true;
    }
    if ((paramString.equals("LONG")) && ((paramObject instanceof Long)))
    {
      AppMethodBeat.o(130942);
      return true;
    }
    if ((paramString.equals("STRING")) && ((paramObject instanceof String)))
    {
      AppMethodBeat.o(130942);
      return true;
    }
    if ((paramString.equals("BOOLEAN")) && ((paramObject instanceof Boolean)))
    {
      AppMethodBeat.o(130942);
      return true;
    }
    if ((paramString.equals("FLOAT")) && ((paramObject instanceof Float)))
    {
      AppMethodBeat.o(130942);
      return true;
    }
    if ((paramString.equals("DOUBLE")) && ((paramObject instanceof Double)))
    {
      AppMethodBeat.o(130942);
      return true;
    }
    if ((paramObject != null) && (CrashReportFactory.hasDebuger())) {
      Assert.assertTrue("checkType failed, input type and value[" + paramString + ", " + paramObject + "] are not match", false);
    }
    if (paramBoolean) {
      Log.e("MicroMsg.WalletCacheStorage", "checkType failed, input type and value[%s, %s] are not match", new Object[] { paramString, paramObject });
    }
    AppMethodBeat.o(130942);
    return false;
  }
  
  private Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(130940);
    Assert.assertNotNull("db is null", this.omV);
    paramString = this.agTA.get(paramString);
    if ((paramString == null) || (paramString == acHf))
    {
      AppMethodBeat.o(130940);
      return paramObject;
    }
    AppMethodBeat.o(130940);
    return paramString;
  }
  
  public final Object get(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(130939);
    if (parama == null)
    {
      AppMethodBeat.o(130939);
      return paramObject;
    }
    String str = parama.name();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(130939);
      return paramObject;
    }
    String[] arrayOfString = str.split("_");
    Object localObject = arrayOfString[(arrayOfString.length - 1)];
    parama = (at.a)localObject;
    if (((String)localObject).equals("SYNC")) {
      parama = arrayOfString[(arrayOfString.length - 2)];
    }
    localObject = get(str.substring(0, str.lastIndexOf(parama) + parama.length()), paramObject);
    if (!a(parama, localObject, false))
    {
      AppMethodBeat.o(130939);
      return paramObject;
    }
    AppMethodBeat.o(130939);
    return localObject;
  }
  
  public final void iZy()
  {
    AppMethodBeat.i(130944);
    try
    {
      this.mHandler.removeCallbacks(this.acHl);
      this.mHandler.post(this.acHl);
      this.acHk = true;
      Log.i("MicroMsg.WalletCacheStorage", "Posted appendAllToDisk");
      AppMethodBeat.o(130944);
      return;
    }
    finally
    {
      AppMethodBeat.o(130944);
    }
  }
  
  public final void set(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(130941);
    if (parama == null)
    {
      AppMethodBeat.o(130941);
      return;
    }
    Object localObject1 = parama.name();
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(130941);
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
        AppMethodBeat.o(130941);
        return;
      }
      int j = ((String)localObject1).lastIndexOf(parama);
      localObject2 = ((String)localObject1).substring(0, parama.length() + j);
      parama = paramObject;
      if (paramObject == null) {
        parama = acHf;
      }
      if (!parama.equals(this.agTA.put(localObject2, parama)))
      {
        if (parama != acHf) {
          break label238;
        }
        paramObject = null;
      }
      for (;;)
      {
        try
        {
          this.acHj.put(localObject2, paramObject);
          if (i != 0)
          {
            iZy();
            if (parama != acHf) {
              break label298;
            }
            i = 5;
            doNotify(i, this, localObject2);
            paramObject = new StringBuilder("SET: ").append((String)localObject2).append(" => ");
            if (parama != acHf) {
              break label303;
            }
            parama = "(DELETED)";
            Log.i("MicroMsg.WalletCacheStorage", parama);
            AppMethodBeat.o(130941);
            return;
            label238:
            localObject1 = b.gX(parama);
            paramObject = localObject1;
            if (localObject1 != null) {
              break;
            }
            AppMethodBeat.o(130941);
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
          AppMethodBeat.o(130941);
        }
        label298:
        continue;
        label303:
        parama = parama.toString();
      }
    }
  }
  
  public boolean shouldProcessEvent()
  {
    AppMethodBeat.i(130943);
    if ((this.omV == null) || (this.omV.isClose()))
    {
      if (this.omV == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.omV.isClose()))
      {
        Log.w("MicroMsg.WalletCacheStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(130943);
        return false;
      }
    }
    AppMethodBeat.o(130943);
    return true;
  }
  
  final class a<K>
    extends LruCache<K, Object>
  {
    private final String acHn;
    
    a(String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(130933);
      this.acHn = ("SELECT * FROM " + paramString1 + " WHERE " + paramString2 + "=?;");
      AppMethodBeat.o(130933);
    }
    
    /* Error */
    public final Object create(K paramK)
    {
      // Byte code:
      //   0: ldc 55
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 16	com/tencent/mm/wallet_core/model/ab$a:agTB	Lcom/tencent/mm/wallet_core/model/ab;
      //   9: invokestatic 58	com/tencent/mm/wallet_core/model/ab:a	(Lcom/tencent/mm/wallet_core/model/ab;)Lcom/tencent/mm/storagebase/h;
      //   12: aload_0
      //   13: getfield 46	com/tencent/mm/wallet_core/model/ab$a:acHn	Ljava/lang/String;
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
      //   41: new 77	com/tencent/mm/wallet_core/model/ab$b
      //   44: dup
      //   45: aload_2
      //   46: iconst_1
      //   47: invokeinterface 81 2 0
      //   52: aload_2
      //   53: iconst_2
      //   54: invokeinterface 85 2 0
      //   59: invokespecial 88	com/tencent/mm/wallet_core/model/ab$b:<init>	(ILjava/lang/String;)V
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
      //   87: getfield 97	com/tencent/mm/wallet_core/model/ab$b:onf	Ljava/lang/String;
      //   90: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   93: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   96: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   99: aload_3
      //   100: invokevirtual 106	com/tencent/mm/wallet_core/model/ab$b:bVp	()Ljava/lang/Object;
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
      //   150: invokestatic 115	com/tencent/mm/wallet_core/model/ab:icm	()Ljava/lang/Object;
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
    
    static b gX(Object paramObject)
    {
      AppMethodBeat.i(130935);
      int i;
      if ((paramObject instanceof Integer)) {
        i = 1;
      }
      for (;;)
      {
        paramObject = new b(i, paramObject.toString());
        AppMethodBeat.o(130935);
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
      Log.e("MicroMsg.WalletCacheStorage", "unresolve failed, unknown type=" + paramObject.getClass().toString());
      AppMethodBeat.o(130935);
      return null;
    }
    
    final Object bVp()
    {
      AppMethodBeat.i(130937);
      if (this.onf == ab.icm())
      {
        AppMethodBeat.o(130937);
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
          Log.e("MicroMsg.WalletCacheStorage", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        }
      }
      AppMethodBeat.o(130937);
      return null;
      localObject = Integer.valueOf(this.onf);
      AppMethodBeat.o(130937);
      return localObject;
      localObject = Long.valueOf(this.onf);
      AppMethodBeat.o(130937);
      return localObject;
      localObject = this.onf;
      AppMethodBeat.o(130937);
      return localObject;
      localObject = Boolean.valueOf(this.onf);
      AppMethodBeat.o(130937);
      return localObject;
      localObject = Float.valueOf(this.onf);
      AppMethodBeat.o(130937);
      return localObject;
      localObject = Double.valueOf(this.onf);
      AppMethodBeat.o(130937);
      return localObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(130936);
      if (paramObject == null)
      {
        AppMethodBeat.o(130936);
        return false;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(130936);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.type != paramObject.type)
      {
        AppMethodBeat.o(130936);
        return false;
      }
      if (this.onf == null)
      {
        if (paramObject.onf == null)
        {
          AppMethodBeat.o(130936);
          return true;
        }
        AppMethodBeat.o(130936);
        return false;
      }
      boolean bool = this.onf.equals(paramObject.onf);
      AppMethodBeat.o(130936);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.ab
 * JD-Core Version:    0.7.0.1
 */