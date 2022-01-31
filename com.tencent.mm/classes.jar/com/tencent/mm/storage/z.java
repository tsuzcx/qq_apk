package com.tencent.mm.storage;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import junit.framework.Assert;

public final class z
  extends n
{
  public static final String[] SQL_CREATE;
  private static final Object yxd;
  private h fnw;
  private Handler mHandler;
  public HandlerThread mHandlerThread;
  private a<Integer> yxe;
  private a<String> yxf;
  private HashMap<Integer, b> yxg;
  private HashMap<String, b> yxh;
  private volatile boolean yxi;
  private final Runnable yxj;
  
  static
  {
    AppMethodBeat.i(58988);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )" };
    yxd = new Object();
    AppMethodBeat.o(58988);
  }
  
  public z(h paramh)
  {
    AppMethodBeat.i(58970);
    this.yxe = new a("userinfo", "id");
    this.yxf = new a("userinfo2", "sid");
    this.yxg = new HashMap();
    this.yxh = new HashMap();
    this.yxj = new Runnable()
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
        //   17: getfield 14	com/tencent/mm/storage/z$1:yxk	Lcom/tencent/mm/storage/z;
        //   20: invokestatic 32	com/tencent/mm/storage/z:a	(Lcom/tencent/mm/storage/z;)Lcom/tencent/mm/cg/h;
        //   23: invokevirtual 38	com/tencent/mm/cg/h:dzV	()Lcom/tencent/wcdb/database/SQLiteDatabase;
        //   26: astore 8
        //   28: aload 8
        //   30: ifnull +11 -> 41
        //   33: aload 8
        //   35: invokevirtual 44	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
        //   38: ifne +16 -> 54
        //   41: ldc 46
        //   43: ldc 48
        //   45: invokestatic 54	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
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
        //   95: getfield 14	com/tencent/mm/storage/z$1:yxk	Lcom/tencent/mm/storage/z;
        //   98: astore 11
        //   100: iload 5
        //   102: istore_2
        //   103: iload 6
        //   105: istore_3
        //   106: aload 11
        //   108: monitorenter
        //   109: aload_0
        //   110: getfield 14	com/tencent/mm/storage/z$1:yxk	Lcom/tencent/mm/storage/z;
        //   113: invokestatic 67	com/tencent/mm/storage/z:b	(Lcom/tencent/mm/storage/z;)Ljava/util/HashMap;
        //   116: astore 12
        //   118: aload_0
        //   119: getfield 14	com/tencent/mm/storage/z$1:yxk	Lcom/tencent/mm/storage/z;
        //   122: invokestatic 70	com/tencent/mm/storage/z:c	(Lcom/tencent/mm/storage/z;)Ljava/util/HashMap;
        //   125: astore 10
        //   127: aload_0
        //   128: getfield 14	com/tencent/mm/storage/z$1:yxk	Lcom/tencent/mm/storage/z;
        //   131: new 72	java/util/HashMap
        //   134: dup
        //   135: invokespecial 73	java/util/HashMap:<init>	()V
        //   138: invokestatic 76	com/tencent/mm/storage/z:a	(Lcom/tencent/mm/storage/z;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   141: pop
        //   142: aload_0
        //   143: getfield 14	com/tencent/mm/storage/z$1:yxk	Lcom/tencent/mm/storage/z;
        //   146: new 72	java/util/HashMap
        //   149: dup
        //   150: invokespecial 73	java/util/HashMap:<init>	()V
        //   153: invokestatic 78	com/tencent/mm/storage/z:b	(Lcom/tencent/mm/storage/z;Ljava/util/HashMap;)Ljava/util/HashMap;
        //   156: pop
        //   157: aload_0
        //   158: getfield 14	com/tencent/mm/storage/z$1:yxk	Lcom/tencent/mm/storage/z;
        //   161: invokestatic 82	com/tencent/mm/storage/z:d	(Lcom/tencent/mm/storage/z;)Z
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
        //   197: ifeq +282 -> 479
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
        //   227: checkcast 108	com/tencent/mm/storage/z$b
        //   230: astore 13
        //   232: aload 13
        //   234: ifnonnull +130 -> 364
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
        //   265: iload_1
        //   266: iconst_1
        //   267: iadd
        //   268: istore_1
        //   269: goto -83 -> 186
        //   272: astore 7
        //   274: aload 11
        //   276: monitorexit
        //   277: iload 5
        //   279: istore_2
        //   280: iload 6
        //   282: istore_3
        //   283: ldc 22
        //   285: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   288: iload 5
        //   290: istore_2
        //   291: iload 6
        //   293: istore_3
        //   294: aload 7
        //   296: athrow
        //   297: astore 7
        //   299: iconst_1
        //   300: istore_3
        //   301: iload_2
        //   302: istore_1
        //   303: iload_3
        //   304: istore_2
        //   305: ldc 46
        //   307: aload 7
        //   309: ldc 119
        //   311: iconst_0
        //   312: anewarray 4	java/lang/Object
        //   315: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   318: iload_2
        //   319: ifeq +8 -> 327
        //   322: aload 8
        //   324: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   327: aload 8
        //   329: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   332: ldc 46
        //   334: new 131	java/lang/StringBuilder
        //   337: dup
        //   338: ldc 133
        //   340: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   343: iload_1
        //   344: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   347: ldc 142
        //   349: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   352: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   355: invokestatic 151	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   358: ldc 22
        //   360: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   363: return
        //   364: iload_1
        //   365: istore_2
        //   366: iload_1
        //   367: istore_3
        //   368: aload 7
        //   370: iconst_0
        //   371: aload 12
        //   373: invokeinterface 111 1 0
        //   378: aastore
        //   379: iload_1
        //   380: istore_2
        //   381: iload_1
        //   382: istore_3
        //   383: aload 7
        //   385: iconst_1
        //   386: aload 13
        //   388: getfield 155	com/tencent/mm/storage/z$b:type	I
        //   391: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   394: aastore
        //   395: iload_1
        //   396: istore_2
        //   397: iload_1
        //   398: istore_3
        //   399: aload 7
        //   401: iconst_2
        //   402: aload 13
        //   404: getfield 165	com/tencent/mm/storage/z$b:fnF	Ljava/lang/String;
        //   407: aastore
        //   408: iload_1
        //   409: istore_2
        //   410: iload_1
        //   411: istore_3
        //   412: aload 8
        //   414: ldc 167
        //   416: aload 7
        //   418: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   421: goto -156 -> 265
        //   424: astore 7
        //   426: iload_3
        //   427: istore_1
        //   428: iload 4
        //   430: istore_2
        //   431: iload_2
        //   432: ifeq +8 -> 440
        //   435: aload 8
        //   437: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   440: aload 8
        //   442: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   445: ldc 46
        //   447: new 131	java/lang/StringBuilder
        //   450: dup
        //   451: ldc 133
        //   453: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   456: iload_1
        //   457: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   460: ldc 142
        //   462: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   465: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   468: invokestatic 151	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   471: ldc 22
        //   473: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   476: aload 7
        //   478: athrow
        //   479: iload_1
        //   480: istore_2
        //   481: iload_1
        //   482: istore_3
        //   483: aload 10
        //   485: invokevirtual 86	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   488: invokeinterface 92 1 0
        //   493: astore 10
        //   495: iload_1
        //   496: istore_2
        //   497: iload_1
        //   498: istore_3
        //   499: aload 10
        //   501: invokeinterface 97 1 0
        //   506: ifeq +131 -> 637
        //   509: iload_1
        //   510: istore_2
        //   511: iload_1
        //   512: istore_3
        //   513: aload 10
        //   515: invokeinterface 101 1 0
        //   520: checkcast 103	java/util/Map$Entry
        //   523: astore 11
        //   525: iload_1
        //   526: istore_2
        //   527: iload_1
        //   528: istore_3
        //   529: aload 11
        //   531: invokeinterface 106 1 0
        //   536: checkcast 108	com/tencent/mm/storage/z$b
        //   539: astore 12
        //   541: aload 12
        //   543: ifnonnull +34 -> 577
        //   546: iload_1
        //   547: istore_2
        //   548: iload_1
        //   549: istore_3
        //   550: aload 9
        //   552: iconst_0
        //   553: aload 11
        //   555: invokeinterface 111 1 0
        //   560: aastore
        //   561: iload_1
        //   562: istore_2
        //   563: iload_1
        //   564: istore_3
        //   565: aload 8
        //   567: ldc 169
        //   569: aload 9
        //   571: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   574: goto +137 -> 711
        //   577: iload_1
        //   578: istore_2
        //   579: iload_1
        //   580: istore_3
        //   581: aload 7
        //   583: iconst_0
        //   584: aload 11
        //   586: invokeinterface 111 1 0
        //   591: aastore
        //   592: iload_1
        //   593: istore_2
        //   594: iload_1
        //   595: istore_3
        //   596: aload 7
        //   598: iconst_1
        //   599: aload 12
        //   601: getfield 155	com/tencent/mm/storage/z$b:type	I
        //   604: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   607: aastore
        //   608: iload_1
        //   609: istore_2
        //   610: iload_1
        //   611: istore_3
        //   612: aload 7
        //   614: iconst_2
        //   615: aload 12
        //   617: getfield 165	com/tencent/mm/storage/z$b:fnF	Ljava/lang/String;
        //   620: aastore
        //   621: iload_1
        //   622: istore_2
        //   623: iload_1
        //   624: istore_3
        //   625: aload 8
        //   627: ldc 171
        //   629: aload 7
        //   631: invokevirtual 117	com/tencent/wcdb/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
        //   634: goto +77 -> 711
        //   637: iload_1
        //   638: istore_2
        //   639: iload_1
        //   640: istore_3
        //   641: aload 8
        //   643: invokevirtual 174	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
        //   646: aload 8
        //   648: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
        //   651: aload 8
        //   653: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:releaseReference	()V
        //   656: ldc 46
        //   658: new 131	java/lang/StringBuilder
        //   661: dup
        //   662: ldc 133
        //   664: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   667: iload_1
        //   668: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   671: ldc 142
        //   673: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   676: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   679: invokestatic 151	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   682: ldc 22
        //   684: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   687: return
        //   688: astore 7
        //   690: iconst_0
        //   691: istore_2
        //   692: iconst_0
        //   693: istore_1
        //   694: goto -263 -> 431
        //   697: astore 7
        //   699: goto -268 -> 431
        //   702: astore 7
        //   704: iconst_0
        //   705: istore_2
        //   706: iconst_0
        //   707: istore_1
        //   708: goto -403 -> 305
        //   711: iload_1
        //   712: iconst_1
        //   713: iadd
        //   714: istore_1
        //   715: goto -220 -> 495
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	718	0	this	1
        //   10	705	1	i	int
        //   66	640	2	j	int
        //   69	572	3	k	int
        //   1	428	4	m	int
        //   4	285	5	n	int
        //   7	285	6	i1	int
        //   74	1	7	arrayOfObject1	Object[]
        //   272	23	7	localObject1	Object
        //   297	120	7	localRuntimeException1	java.lang.RuntimeException
        //   424	206	7	arrayOfObject2	Object[]
        //   688	1	7	localObject2	Object
        //   697	1	7	localObject3	Object
        //   702	1	7	localRuntimeException2	java.lang.RuntimeException
        //   26	626	8	localSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
        //   86	484	9	arrayOfObject3	Object[]
        //   125	389	10	localObject4	Object
        //   98	487	11	localObject5	Object
        //   116	500	12	localObject6	Object
        //   230	173	13	localb	z.b
        // Exception table:
        //   from	to	target	type
        //   109	168	272	finally
        //   274	277	272	finally
        //   70	76	297	java/lang/RuntimeException
        //   82	88	297	java/lang/RuntimeException
        //   94	100	297	java/lang/RuntimeException
        //   106	109	297	java/lang/RuntimeException
        //   174	186	297	java/lang/RuntimeException
        //   190	200	297	java/lang/RuntimeException
        //   204	216	297	java/lang/RuntimeException
        //   220	232	297	java/lang/RuntimeException
        //   241	252	297	java/lang/RuntimeException
        //   256	265	297	java/lang/RuntimeException
        //   283	288	297	java/lang/RuntimeException
        //   294	297	297	java/lang/RuntimeException
        //   368	379	297	java/lang/RuntimeException
        //   383	395	297	java/lang/RuntimeException
        //   399	408	297	java/lang/RuntimeException
        //   412	421	297	java/lang/RuntimeException
        //   483	495	297	java/lang/RuntimeException
        //   499	509	297	java/lang/RuntimeException
        //   513	525	297	java/lang/RuntimeException
        //   529	541	297	java/lang/RuntimeException
        //   550	561	297	java/lang/RuntimeException
        //   565	574	297	java/lang/RuntimeException
        //   581	592	297	java/lang/RuntimeException
        //   596	608	297	java/lang/RuntimeException
        //   612	621	297	java/lang/RuntimeException
        //   625	634	297	java/lang/RuntimeException
        //   641	646	297	java/lang/RuntimeException
        //   70	76	424	finally
        //   82	88	424	finally
        //   94	100	424	finally
        //   106	109	424	finally
        //   174	186	424	finally
        //   190	200	424	finally
        //   204	216	424	finally
        //   220	232	424	finally
        //   241	252	424	finally
        //   256	265	424	finally
        //   283	288	424	finally
        //   294	297	424	finally
        //   368	379	424	finally
        //   383	395	424	finally
        //   399	408	424	finally
        //   412	421	424	finally
        //   483	495	424	finally
        //   499	509	424	finally
        //   513	525	424	finally
        //   529	541	424	finally
        //   550	561	424	finally
        //   565	574	424	finally
        //   581	592	424	finally
        //   596	608	424	finally
        //   612	621	424	finally
        //   625	634	424	finally
        //   641	646	424	finally
        //   54	64	688	finally
        //   305	318	697	finally
        //   54	64	702	java/lang/RuntimeException
      }
    };
    this.fnw = paramh;
    this.mHandlerThread = new HandlerThread("ConfigStorage");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    AppMethodBeat.o(58970);
  }
  
  private static boolean a(String paramString, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(58981);
    if ((paramObject == null) && (paramBoolean))
    {
      AppMethodBeat.o(58981);
      return true;
    }
    if ((paramString.equals("INT")) && ((paramObject instanceof Integer)))
    {
      AppMethodBeat.o(58981);
      return true;
    }
    if ((paramString.equals("LONG")) && ((paramObject instanceof Long)))
    {
      AppMethodBeat.o(58981);
      return true;
    }
    if ((paramString.equals("STRING")) && ((paramObject instanceof String)))
    {
      AppMethodBeat.o(58981);
      return true;
    }
    if ((paramString.equals("BOOLEAN")) && ((paramObject instanceof Boolean)))
    {
      AppMethodBeat.o(58981);
      return true;
    }
    if ((paramString.equals("FLOAT")) && ((paramObject instanceof Float)))
    {
      AppMethodBeat.o(58981);
      return true;
    }
    if ((paramString.equals("DOUBLE")) && ((paramObject instanceof Double)))
    {
      AppMethodBeat.o(58981);
      return true;
    }
    if ((paramObject != null) && (b.dsf())) {
      Assert.assertTrue("checkType failed, input type and value[" + paramString + ", " + paramObject + "] are not match", false);
    }
    if (paramBoolean) {
      ab.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", new Object[] { paramString, paramObject });
    }
    AppMethodBeat.o(58981);
    return false;
  }
  
  private Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(58978);
    Assert.assertNotNull("db is null", this.fnw);
    paramString = this.yxf.get(paramString);
    if ((paramString == null) || (paramString == yxd))
    {
      AppMethodBeat.o(58978);
      return paramObject;
    }
    AppMethodBeat.o(58978);
    return paramString;
  }
  
  public final long Ns(int paramInt)
  {
    AppMethodBeat.i(58987);
    Long localLong = (Long)get(paramInt, null);
    if (localLong == null)
    {
      AppMethodBeat.o(58987);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(58987);
    return l;
  }
  
  public final long a(ac.a parama, long paramLong)
  {
    AppMethodBeat.i(58976);
    parama = get(parama, Long.valueOf(paramLong));
    if ((parama != null) && ((parama instanceof Long)))
    {
      paramLong = ((Long)parama).longValue();
      AppMethodBeat.o(58976);
      return paramLong;
    }
    AppMethodBeat.o(58976);
    return paramLong;
  }
  
  public final boolean aqj()
  {
    AppMethodBeat.i(58982);
    if ((this.fnw == null) || (this.fnw.dun()))
    {
      if (this.fnw == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.fnw.dun()))
      {
        ab.w("MicroMsg.ConfigStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(58982);
        return false;
      }
    }
    AppMethodBeat.o(58982);
    return true;
  }
  
  public final void dww()
  {
    AppMethodBeat.i(58983);
    try
    {
      this.mHandler.removeCallbacks(this.yxj);
      this.mHandler.post(this.yxj);
      this.yxi = true;
      ab.i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
      AppMethodBeat.o(58983);
      return;
    }
    finally
    {
      AppMethodBeat.o(58983);
    }
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(156842);
    Object localObject = get(paramInt, null);
    AppMethodBeat.o(156842);
    return localObject;
  }
  
  public final Object get(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(58972);
    Assert.assertNotNull("db is null", this.fnw);
    Object localObject = this.yxe.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (localObject == yxd))
    {
      AppMethodBeat.o(58972);
      return paramObject;
    }
    AppMethodBeat.o(58972);
    return localObject;
  }
  
  public final Object get(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(58974);
    if (parama == null)
    {
      AppMethodBeat.o(58974);
      return paramObject;
    }
    String str = parama.name();
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(58974);
      return paramObject;
    }
    String[] arrayOfString = str.split("_");
    Object localObject = arrayOfString[(arrayOfString.length - 1)];
    parama = (ac.a)localObject;
    if (((String)localObject).equals("SYNC")) {
      parama = arrayOfString[(arrayOfString.length - 2)];
    }
    localObject = get(str.substring(0, str.lastIndexOf(parama) + parama.length()), paramObject);
    if (!a(parama, localObject, false))
    {
      AppMethodBeat.o(58974);
      return paramObject;
    }
    AppMethodBeat.o(58974);
    return localObject;
  }
  
  public final boolean getBoolean(ac.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(58975);
    parama = get(parama, Boolean.valueOf(paramBoolean));
    if ((parama != null) && ((parama instanceof Boolean)))
    {
      paramBoolean = ((Boolean)parama).booleanValue();
      AppMethodBeat.o(58975);
      return paramBoolean;
    }
    AppMethodBeat.o(58975);
    return paramBoolean;
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(58985);
    Integer localInteger = (Integer)get(paramInt1, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(58985);
      return paramInt2;
    }
    paramInt1 = localInteger.intValue();
    AppMethodBeat.o(58985);
    return paramInt1;
  }
  
  public final int getInt(ac.a parama, int paramInt)
  {
    AppMethodBeat.i(58977);
    parama = get(parama, Integer.valueOf(paramInt));
    if ((parama != null) && ((parama instanceof Integer)))
    {
      paramInt = ((Integer)parama).intValue();
      AppMethodBeat.o(58977);
      return paramInt;
    }
    AppMethodBeat.o(58977);
    return paramInt;
  }
  
  public final Object i(ac.a parama)
  {
    AppMethodBeat.i(156843);
    parama = get(parama, null);
    AppMethodBeat.o(156843);
    return parama;
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(58979);
    Assert.assertNotNull("db is null", this.fnw);
    Object localObject1 = paramObject;
    if (paramObject == null) {
      localObject1 = yxd;
    }
    if (!localObject1.equals(this.yxe.put(Integer.valueOf(paramInt), localObject1)))
    {
      if (localObject1 != yxd) {
        break label177;
      }
      paramObject = null;
    }
    for (;;)
    {
      try
      {
        this.yxg.put(Integer.valueOf(paramInt), paramObject);
        if (!this.yxi)
        {
          this.yxi = true;
          this.mHandler.postDelayed(this.yxj, 30000L);
        }
        if (localObject1 != yxd) {
          break label210;
        }
        i = 5;
        b(i, this, Integer.valueOf(paramInt));
        localObject2 = new StringBuilder("SET: ").append(paramInt).append(" => ");
        if (localObject1 != yxd) {
          break label215;
        }
        paramObject = "(DELETED)";
        ab.i("MicroMsg.ConfigStorage", paramObject);
        AppMethodBeat.o(58979);
        return;
      }
      finally
      {
        Object localObject2;
        label177:
        AppMethodBeat.o(58979);
      }
      localObject2 = b.cB(localObject1);
      paramObject = localObject2;
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(58979);
      return;
      label210:
      int i = 4;
      continue;
      label215:
      paramObject = localObject1.toString();
    }
  }
  
  public final void set(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(58980);
    if (parama == null)
    {
      AppMethodBeat.o(58980);
      return;
    }
    Object localObject1 = parama.name();
    if (bo.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(58980);
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
        AppMethodBeat.o(58980);
        return;
      }
      int j = ((String)localObject1).lastIndexOf(parama);
      localObject2 = ((String)localObject1).substring(0, parama.length() + j);
      parama = paramObject;
      if (paramObject == null) {
        parama = yxd;
      }
      if (!parama.equals(this.yxf.put(localObject2, parama)))
      {
        if (parama != yxd) {
          break label246;
        }
        paramObject = null;
      }
      for (;;)
      {
        try
        {
          this.yxh.put(localObject2, paramObject);
          if (i != 0)
          {
            dww();
            if (parama != yxd) {
              break label308;
            }
            i = 5;
            b(i, this, localObject2);
            paramObject = new StringBuilder("SET: ").append((String)localObject2).append(" => ");
            if (parama != yxd) {
              break label313;
            }
            parama = "(DELETED)";
            ab.i("MicroMsg.ConfigStorage", parama);
            AppMethodBeat.o(58980);
            return;
            label246:
            localObject1 = b.cB(parama);
            paramObject = localObject1;
            if (localObject1 != null) {
              break;
            }
            AppMethodBeat.o(58980);
            return;
          }
          if (this.yxi) {
            continue;
          }
          this.yxi = true;
          this.mHandler.postDelayed(this.yxj, 30000L);
          continue;
          i = 4;
        }
        finally
        {
          AppMethodBeat.o(58980);
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
    AppMethodBeat.i(58984);
    set(paramInt1, Integer.valueOf(paramInt2));
    AppMethodBeat.o(58984);
  }
  
  public final void setLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(58986);
    set(paramInt, Long.valueOf(paramLong));
    AppMethodBeat.o(58986);
  }
  
  final class a<K>
    extends ae<K, Object>
  {
    private final String yxl;
    
    a(String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(58965);
      this.yxl = ("SELECT * FROM " + paramString1 + " WHERE " + paramString2 + "=?;");
      AppMethodBeat.o(58965);
    }
    
    /* Error */
    public final Object create(K paramK)
    {
      // Byte code:
      //   0: ldc 57
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 16	com/tencent/mm/storage/z$a:yxk	Lcom/tencent/mm/storage/z;
      //   9: invokestatic 60	com/tencent/mm/storage/z:a	(Lcom/tencent/mm/storage/z;)Lcom/tencent/mm/cg/h;
      //   12: aload_0
      //   13: getfield 46	com/tencent/mm/storage/z$a:yxl	Ljava/lang/String;
      //   16: iconst_1
      //   17: anewarray 62	java/lang/String
      //   20: dup
      //   21: iconst_0
      //   22: aload_1
      //   23: invokevirtual 65	java/lang/Object:toString	()Ljava/lang/String;
      //   26: aastore
      //   27: iconst_2
      //   28: invokevirtual 70	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
      //   31: astore 4
      //   33: aload 4
      //   35: invokeinterface 76 1 0
      //   40: ifeq +87 -> 127
      //   43: new 78	com/tencent/mm/storage/z$b
      //   46: dup
      //   47: aload 4
      //   49: iconst_1
      //   50: invokeinterface 82 2 0
      //   55: aload 4
      //   57: iconst_2
      //   58: invokeinterface 86 2 0
      //   63: invokespecial 89	com/tencent/mm/storage/z$b:<init>	(ILjava/lang/String;)V
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
      //   91: getfield 98	com/tencent/mm/storage/z$b:fnF	Ljava/lang/String;
      //   94: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   100: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   103: aload_2
      //   104: invokevirtual 107	com/tencent/mm/storage/z$b:aoU	()Ljava/lang/Object;
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
      //   153: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   156: invokestatic 116	com/tencent/mm/storage/z:cPJ	()Ljava/lang/Object;
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
      //   228: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    final String fnF;
    final int type;
    
    b(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.fnF = paramString;
    }
    
    static b cB(Object paramObject)
    {
      AppMethodBeat.i(58967);
      int i;
      if ((paramObject instanceof Integer)) {
        i = 1;
      }
      for (;;)
      {
        paramObject = new b(i, paramObject.toString());
        AppMethodBeat.o(58967);
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
      ab.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + paramObject.getClass().toString());
      AppMethodBeat.o(58967);
      return null;
    }
    
    final Object aoU()
    {
      AppMethodBeat.i(58969);
      if (this.fnF == z.cPJ())
      {
        AppMethodBeat.o(58969);
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
          ab.e("MicroMsg.ConfigStorage", "exception:%s", new Object[] { bo.l(localException) });
        }
      }
      AppMethodBeat.o(58969);
      return null;
      localObject = Integer.valueOf(this.fnF);
      AppMethodBeat.o(58969);
      return localObject;
      localObject = Long.valueOf(this.fnF);
      AppMethodBeat.o(58969);
      return localObject;
      localObject = this.fnF;
      AppMethodBeat.o(58969);
      return localObject;
      localObject = Boolean.valueOf(this.fnF);
      AppMethodBeat.o(58969);
      return localObject;
      localObject = Float.valueOf(this.fnF);
      AppMethodBeat.o(58969);
      return localObject;
      localObject = Double.valueOf(this.fnF);
      AppMethodBeat.o(58969);
      return localObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(58968);
      if (paramObject == null)
      {
        AppMethodBeat.o(58968);
        return false;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(58968);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.type != paramObject.type)
      {
        AppMethodBeat.o(58968);
        return false;
      }
      if (this.fnF == null)
      {
        if (paramObject.fnF == null)
        {
          AppMethodBeat.o(58968);
          return true;
        }
        AppMethodBeat.o(58968);
        return false;
      }
      boolean bool = this.fnF.equals(paramObject.fnF);
      AppMethodBeat.o(58968);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.z
 * JD-Core Version:    0.7.0.1
 */