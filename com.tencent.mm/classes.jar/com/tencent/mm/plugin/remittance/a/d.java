package com.tencent.mm.plugin.remittance.a;

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
  private static final String[] pHB;
  private static Map<String, c> pHC;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(67625);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "RemittanceRecord") };
    pHB = new String[] { "*", "rowid" };
    pHC = new HashMap();
    AppMethodBeat.o(67625);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "RemittanceRecord", c.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(67621);
    if ((paramc != null) && (pHC.containsKey(paramc.field_transferId))) {
      pHC.put(paramc.field_transferId, paramc);
    }
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(67621);
    return bool;
  }
  
  public final c aTO(String paramString)
  {
    AppMethodBeat.i(67620);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67620);
      return null;
    }
    paramString = this.db.query("RemittanceRecord", pHB, "transferId=?", new String[] { paramString }, null, null, null, 2);
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
  
  public final c aTP(String paramString)
  {
    AppMethodBeat.i(288692);
    if ((!Util.isNullOrNil(paramString)) && (pHC.containsKey(paramString)))
    {
      paramString = (c)pHC.get(paramString);
      AppMethodBeat.o(288692);
      return paramString;
    }
    c localc = aTO(paramString);
    if (localc != null)
    {
      pHC.put(paramString, localc);
      AppMethodBeat.o(288692);
      return localc;
    }
    AppMethodBeat.o(288692);
    return null;
  }
  
  /* Error */
  public final java.util.List<c> aTQ(String paramString)
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 145
    //   14: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 64	com/tencent/mm/plugin/remittance/a/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   23: ldc 32
    //   25: getstatic 44	com/tencent/mm/plugin/remittance/a/d:pHB	[Ljava/lang/String;
    //   28: ldc 147
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
    //   42: invokeinterface 104 9 0
    //   47: astore_1
    //   48: aload_1
    //   49: invokeinterface 110 1 0
    //   54: ifeq +62 -> 116
    //   57: new 149	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 150	java/util/ArrayList:<init>	()V
    //   64: astore_2
    //   65: new 26	com/tencent/mm/plugin/remittance/a/c
    //   68: dup
    //   69: invokespecial 111	com/tencent/mm/plugin/remittance/a/c:<init>	()V
    //   72: astore_3
    //   73: aload_3
    //   74: aload_1
    //   75: invokevirtual 115	com/tencent/mm/plugin/remittance/a/c:convertFrom	(Landroid/database/Cursor;)V
    //   78: aload_2
    //   79: aload_3
    //   80: invokevirtual 153	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   83: pop
    //   84: aload_1
    //   85: invokeinterface 156 1 0
    //   90: ifne -25 -> 65
    //   93: aload_1
    //   94: invokeinterface 118 1 0
    //   99: aload_1
    //   100: ifnull +9 -> 109
    //   103: aload_1
    //   104: invokeinterface 118 1 0
    //   109: ldc 145
    //   111: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_2
    //   115: areturn
    //   116: aload_1
    //   117: invokeinterface 118 1 0
    //   122: aload_1
    //   123: ifnull +9 -> 132
    //   126: aload_1
    //   127: invokeinterface 118 1 0
    //   132: ldc 145
    //   134: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_2
    //   140: aload_1
    //   141: ifnull +9 -> 150
    //   144: aload_1
    //   145: invokeinterface 118 1 0
    //   150: ldc 145
    //   152: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_2
    //   156: athrow
    //   157: astore_1
    //   158: ldc 120
    //   160: aload_1
    //   161: ldc 122
    //   163: iconst_1
    //   164: anewarray 124	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload_1
    //   170: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   173: aastore
    //   174: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: goto -45 -> 132
    //   180: astore_1
    //   181: aload_2
    //   182: aload_1
    //   183: invokevirtual 162	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   186: goto -36 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	d
    //   0	189	1	paramString	String
    //   64	51	2	localArrayList	java.util.ArrayList
    //   139	43	2	localObject	Object
    //   72	8	3	localc	c
    // Exception table:
    //   from	to	target	type
    //   48	65	139	finally
    //   65	99	139	finally
    //   116	122	139	finally
    //   19	48	157	java/lang/Exception
    //   103	109	157	java/lang/Exception
    //   126	132	157	java/lang/Exception
    //   150	157	157	java/lang/Exception
    //   181	186	157	java/lang/Exception
    //   144	150	180	finally
  }
  
  /* Error */
  public final java.util.List<c> gLL()
  {
    // Byte code:
    //   0: ldc 175
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 149	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 150	java/util/ArrayList:<init>	()V
    //   12: astore_1
    //   13: new 177	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc 180
    //   24: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc 186
    //   31: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: ldc 188
    //   38: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: ldc 180
    //   45: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: ldc 186
    //   52: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_0
    //   57: getfield 64	com/tencent/mm/plugin/remittance/a/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   60: ldc 32
    //   62: getstatic 44	com/tencent/mm/plugin/remittance/a/d:pHB	[Ljava/lang/String;
    //   65: aload_2
    //   66: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: iconst_2
    //   70: anewarray 24	java/lang/String
    //   73: dup
    //   74: iconst_0
    //   75: ldc 193
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: ldc 195
    //   82: aastore
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: iconst_2
    //   87: invokeinterface 104 9 0
    //   92: astore_2
    //   93: aload_2
    //   94: invokeinterface 110 1 0
    //   99: ifeq +56 -> 155
    //   102: new 26	com/tencent/mm/plugin/remittance/a/c
    //   105: dup
    //   106: invokespecial 111	com/tencent/mm/plugin/remittance/a/c:<init>	()V
    //   109: astore_3
    //   110: aload_3
    //   111: aload_2
    //   112: invokevirtual 115	com/tencent/mm/plugin/remittance/a/c:convertFrom	(Landroid/database/Cursor;)V
    //   115: aload_1
    //   116: aload_3
    //   117: invokeinterface 198 2 0
    //   122: pop
    //   123: aload_2
    //   124: invokeinterface 156 1 0
    //   129: ifne -27 -> 102
    //   132: aload_2
    //   133: invokeinterface 118 1 0
    //   138: aload_2
    //   139: ifnull +9 -> 148
    //   142: aload_2
    //   143: invokeinterface 118 1 0
    //   148: ldc 175
    //   150: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_1
    //   154: areturn
    //   155: aload_2
    //   156: invokeinterface 118 1 0
    //   161: aload_2
    //   162: ifnull +9 -> 171
    //   165: aload_2
    //   166: invokeinterface 118 1 0
    //   171: ldc 175
    //   173: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_1
    //   177: areturn
    //   178: astore_3
    //   179: aload_2
    //   180: ifnull +9 -> 189
    //   183: aload_2
    //   184: invokeinterface 118 1 0
    //   189: ldc 175
    //   191: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_3
    //   195: athrow
    //   196: astore_2
    //   197: ldc 120
    //   199: aload_2
    //   200: ldc 122
    //   202: iconst_1
    //   203: anewarray 124	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_2
    //   209: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: goto -45 -> 171
    //   219: astore_2
    //   220: aload_3
    //   221: aload_2
    //   222: invokevirtual 162	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   225: goto -36 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	d
    //   12	165	1	localArrayList	java.util.ArrayList
    //   20	164	2	localObject1	Object
    //   196	13	2	localException	Exception
    //   219	3	2	localThrowable	java.lang.Throwable
    //   109	8	3	localc	c
    //   178	43	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   93	102	178	finally
    //   102	138	178	finally
    //   155	161	178	finally
    //   56	93	196	java/lang/Exception
    //   142	148	196	java/lang/Exception
    //   165	171	196	java/lang/Exception
    //   189	196	196	java/lang/Exception
    //   220	225	196	java/lang/Exception
    //   183	189	219	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.d
 * JD-Core Version:    0.7.0.1
 */