package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends MAutoStorage<c>
{
  public static final String[] SQL_CREATE;
  private static final String[] jTH;
  private static Map<String, c> jTI;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(67625);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "RemittanceRecord") };
    jTH = new String[] { "*", "rowid" };
    jTI = new HashMap();
    AppMethodBeat.o(67625);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "RemittanceRecord", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(67621);
    if ((paramc != null) && (jTI.containsKey(paramc.field_transferId))) {
      jTI.put(paramc.field_transferId, paramc);
    }
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(67621);
    return bool;
  }
  
  public final c aLW(String paramString)
  {
    AppMethodBeat.i(67620);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67620);
      return null;
    }
    paramString = this.db.query("RemittanceRecord", jTH, "transferId=?", new String[] { paramString }, null, null, null, 2);
    try
    {
      if (paramString.moveToFirst())
      {
        c localc = new c();
        localc.convertFrom(paramString);
        return localc;
      }
      paramString.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", localException, "getRecordByTransferId error: %s", new Object[] { localException.getMessage() });
        paramString.close();
      }
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(67620);
    }
    AppMethodBeat.o(67620);
    return null;
  }
  
  public final c aLX(String paramString)
  {
    AppMethodBeat.i(213703);
    if ((!Util.isNullOrNil(paramString)) && (jTI.containsKey(paramString)))
    {
      paramString = (c)jTI.get(paramString);
      AppMethodBeat.o(213703);
      return paramString;
    }
    c localc = aLW(paramString);
    if (localc != null)
    {
      jTI.put(paramString, localc);
      AppMethodBeat.o(213703);
      return localc;
    }
    AppMethodBeat.o(213703);
    return null;
  }
  
  /* Error */
  public final java.util.List<c> aLY(String paramString)
  {
    // Byte code:
    //   0: ldc 144
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 93	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 144
    //   14: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 61	com/tencent/mm/plugin/remittance/b/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   23: ldc 32
    //   25: getstatic 44	com/tencent/mm/plugin/remittance/b/d:jTH	[Ljava/lang/String;
    //   28: ldc 146
    //   30: iconst_1
    //   31: anewarray 24	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: aastore
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: iconst_2
    //   42: invokeinterface 101 9 0
    //   47: astore_3
    //   48: aload_3
    //   49: invokeinterface 107 1 0
    //   54: ifeq +62 -> 116
    //   57: new 148	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 149	java/util/ArrayList:<init>	()V
    //   64: astore_1
    //   65: new 26	com/tencent/mm/plugin/remittance/b/c
    //   68: dup
    //   69: invokespecial 108	com/tencent/mm/plugin/remittance/b/c:<init>	()V
    //   72: astore_2
    //   73: aload_2
    //   74: aload_3
    //   75: invokevirtual 112	com/tencent/mm/plugin/remittance/b/c:convertFrom	(Landroid/database/Cursor;)V
    //   78: aload_1
    //   79: aload_2
    //   80: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   83: pop
    //   84: aload_3
    //   85: invokeinterface 155 1 0
    //   90: ifne -25 -> 65
    //   93: aload_3
    //   94: invokeinterface 115 1 0
    //   99: aload_3
    //   100: ifnull +9 -> 109
    //   103: aload_3
    //   104: invokeinterface 115 1 0
    //   109: ldc 144
    //   111: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_1
    //   115: areturn
    //   116: aload_3
    //   117: invokeinterface 115 1 0
    //   122: aload_3
    //   123: ifnull +9 -> 132
    //   126: aload_3
    //   127: invokeinterface 115 1 0
    //   132: ldc 144
    //   134: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_2
    //   140: ldc 144
    //   142: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_2
    //   146: athrow
    //   147: astore_1
    //   148: aload_3
    //   149: ifnull +13 -> 162
    //   152: aload_2
    //   153: ifnull +48 -> 201
    //   156: aload_3
    //   157: invokeinterface 115 1 0
    //   162: ldc 144
    //   164: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: ldc 117
    //   172: aload_1
    //   173: ldc 119
    //   175: iconst_1
    //   176: anewarray 121	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload_1
    //   182: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   185: aastore
    //   186: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: goto -57 -> 132
    //   192: astore_3
    //   193: aload_2
    //   194: aload_3
    //   195: invokevirtual 159	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   198: goto -36 -> 162
    //   201: aload_3
    //   202: invokeinterface 115 1 0
    //   207: goto -45 -> 162
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_2
    //   213: goto -65 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	d
    //   0	216	1	paramString	String
    //   72	8	2	localc	c
    //   139	55	2	localThrowable1	java.lang.Throwable
    //   212	1	2	localObject	Object
    //   47	110	3	localCursor	Cursor
    //   192	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   48	65	139	java/lang/Throwable
    //   65	99	139	java/lang/Throwable
    //   116	122	139	java/lang/Throwable
    //   140	147	147	finally
    //   19	48	169	java/lang/Exception
    //   103	109	169	java/lang/Exception
    //   126	132	169	java/lang/Exception
    //   156	162	169	java/lang/Exception
    //   162	169	169	java/lang/Exception
    //   193	198	169	java/lang/Exception
    //   201	207	169	java/lang/Exception
    //   156	162	192	java/lang/Throwable
    //   48	65	210	finally
    //   65	99	210	finally
    //   116	122	210	finally
  }
  
  /* Error */
  public final java.util.List<c> eNl()
  {
    // Byte code:
    //   0: ldc 172
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 148	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 149	java/util/ArrayList:<init>	()V
    //   12: astore_3
    //   13: new 174	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   20: astore_1
    //   21: aload_1
    //   22: ldc 177
    //   24: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: ldc 183
    //   31: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: ldc 185
    //   38: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: ldc 177
    //   45: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: ldc 183
    //   52: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_0
    //   57: getfield 61	com/tencent/mm/plugin/remittance/b/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   60: ldc 32
    //   62: getstatic 44	com/tencent/mm/plugin/remittance/b/d:jTH	[Ljava/lang/String;
    //   65: aload_1
    //   66: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: iconst_2
    //   70: anewarray 24	java/lang/String
    //   73: dup
    //   74: iconst_0
    //   75: ldc 190
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: ldc 192
    //   82: aastore
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: iconst_2
    //   87: invokeinterface 101 9 0
    //   92: astore 4
    //   94: aload 4
    //   96: invokeinterface 107 1 0
    //   101: ifeq +61 -> 162
    //   104: new 26	com/tencent/mm/plugin/remittance/b/c
    //   107: dup
    //   108: invokespecial 108	com/tencent/mm/plugin/remittance/b/c:<init>	()V
    //   111: astore_1
    //   112: aload_1
    //   113: aload 4
    //   115: invokevirtual 112	com/tencent/mm/plugin/remittance/b/c:convertFrom	(Landroid/database/Cursor;)V
    //   118: aload_3
    //   119: aload_1
    //   120: invokeinterface 195 2 0
    //   125: pop
    //   126: aload 4
    //   128: invokeinterface 155 1 0
    //   133: ifne -29 -> 104
    //   136: aload 4
    //   138: invokeinterface 115 1 0
    //   143: aload 4
    //   145: ifnull +10 -> 155
    //   148: aload 4
    //   150: invokeinterface 115 1 0
    //   155: ldc 172
    //   157: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_3
    //   161: areturn
    //   162: aload 4
    //   164: invokeinterface 115 1 0
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokeinterface 115 1 0
    //   181: ldc 172
    //   183: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_3
    //   187: areturn
    //   188: astore_2
    //   189: ldc 172
    //   191: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_2
    //   195: athrow
    //   196: astore_1
    //   197: aload 4
    //   199: ifnull +14 -> 213
    //   202: aload_2
    //   203: ifnull +51 -> 254
    //   206: aload 4
    //   208: invokeinterface 115 1 0
    //   213: ldc 172
    //   215: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: ldc 117
    //   223: aload_1
    //   224: ldc 119
    //   226: iconst_1
    //   227: anewarray 121	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_1
    //   233: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   236: aastore
    //   237: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: goto -59 -> 181
    //   243: astore 4
    //   245: aload_2
    //   246: aload 4
    //   248: invokevirtual 159	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   251: goto -38 -> 213
    //   254: aload 4
    //   256: invokeinterface 115 1 0
    //   261: goto -48 -> 213
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_2
    //   267: goto -70 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	d
    //   20	100	1	localObject1	Object
    //   196	23	1	localObject2	Object
    //   220	13	1	localException	Exception
    //   264	1	1	localObject3	Object
    //   188	58	2	localThrowable1	java.lang.Throwable
    //   266	1	2	localObject4	Object
    //   12	175	3	localArrayList	java.util.ArrayList
    //   92	115	4	localCursor	Cursor
    //   243	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   94	104	188	java/lang/Throwable
    //   104	143	188	java/lang/Throwable
    //   162	169	188	java/lang/Throwable
    //   189	196	196	finally
    //   56	94	220	java/lang/Exception
    //   148	155	220	java/lang/Exception
    //   174	181	220	java/lang/Exception
    //   206	213	220	java/lang/Exception
    //   213	220	220	java/lang/Exception
    //   245	251	220	java/lang/Exception
    //   254	261	220	java/lang/Exception
    //   206	213	243	java/lang/Throwable
    //   94	104	264	finally
    //   104	143	264	finally
    //   162	169	264	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.d
 * JD-Core Version:    0.7.0.1
 */