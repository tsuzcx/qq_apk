package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  private static final String[] iWL;
  private static Map<String, c> iWM;
  private e db;
  
  static
  {
    AppMethodBeat.i(67625);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "RemittanceRecord") };
    iWL = new String[] { "*", "rowid" };
    iWM = new HashMap();
    AppMethodBeat.o(67625);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "RemittanceRecord", null);
    this.db = parame;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(67621);
    if ((paramc != null) && (iWM.containsKey(paramc.field_transferId))) {
      iWM.put(paramc.field_transferId, paramc);
    }
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(67621);
    return bool;
  }
  
  public final c axw(String paramString)
  {
    AppMethodBeat.i(67620);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67620);
      return null;
    }
    paramString = this.db.a("RemittanceRecord", iWL, "transferId=?", new String[] { paramString }, null, null, null, 2);
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
        ae.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", localException, "getRecordByTransferId error: %s", new Object[] { localException.getMessage() });
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
  
  public final c axx(String paramString)
  {
    AppMethodBeat.i(189959);
    if ((!bu.isNullOrNil(paramString)) && (iWM.containsKey(paramString)))
    {
      paramString = (c)iWM.get(paramString);
      AppMethodBeat.o(189959);
      return paramString;
    }
    c localc = axw(paramString);
    if (localc != null)
    {
      iWM.put(paramString, localc);
      AppMethodBeat.o(189959);
      return localc;
    }
    AppMethodBeat.o(189959);
    return null;
  }
  
  /* Error */
  public final java.util.List<c> axy(String paramString)
  {
    // Byte code:
    //   0: ldc 143
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 93	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 143
    //   14: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 61	com/tencent/mm/plugin/remittance/b/d:db	Lcom/tencent/mm/sdk/e/e;
    //   23: ldc 32
    //   25: getstatic 44	com/tencent/mm/plugin/remittance/b/d:iWL	[Ljava/lang/String;
    //   28: ldc 145
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
    //   42: invokeinterface 100 9 0
    //   47: astore 4
    //   49: aload 4
    //   51: invokeinterface 106 1 0
    //   56: ifeq +62 -> 118
    //   59: new 147	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 148	java/util/ArrayList:<init>	()V
    //   66: astore_1
    //   67: new 26	com/tencent/mm/plugin/remittance/b/c
    //   70: dup
    //   71: invokespecial 107	com/tencent/mm/plugin/remittance/b/c:<init>	()V
    //   74: astore_3
    //   75: aload_3
    //   76: aload 4
    //   78: invokevirtual 111	com/tencent/mm/plugin/remittance/b/c:convertFrom	(Landroid/database/Cursor;)V
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 151	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   86: pop
    //   87: aload 4
    //   89: invokeinterface 154 1 0
    //   94: istore_2
    //   95: iload_2
    //   96: ifne -29 -> 67
    //   99: aload 4
    //   101: ifnull +10 -> 111
    //   104: aload 4
    //   106: invokeinterface 114 1 0
    //   111: ldc 143
    //   113: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_1
    //   117: areturn
    //   118: aload 4
    //   120: ifnull +10 -> 130
    //   123: aload 4
    //   125: invokeinterface 114 1 0
    //   130: ldc 143
    //   132: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_3
    //   138: ldc 143
    //   140: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_3
    //   144: athrow
    //   145: astore_1
    //   146: aload 4
    //   148: ifnull +14 -> 162
    //   151: aload_3
    //   152: ifnull +51 -> 203
    //   155: aload 4
    //   157: invokeinterface 114 1 0
    //   162: ldc 143
    //   164: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: ldc 116
    //   172: aload_1
    //   173: ldc 118
    //   175: iconst_1
    //   176: anewarray 120	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload_1
    //   182: invokevirtual 124	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   185: aastore
    //   186: invokestatic 130	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: goto -59 -> 130
    //   192: astore 4
    //   194: aload_3
    //   195: aload 4
    //   197: invokevirtual 158	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   200: goto -38 -> 162
    //   203: aload 4
    //   205: invokeinterface 114 1 0
    //   210: goto -48 -> 162
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_3
    //   216: goto -70 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	d
    //   0	219	1	paramString	String
    //   94	2	2	bool	boolean
    //   74	9	3	localc	c
    //   137	58	3	localThrowable1	java.lang.Throwable
    //   215	1	3	localObject	Object
    //   47	109	4	localCursor	Cursor
    //   192	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   49	67	137	java/lang/Throwable
    //   67	95	137	java/lang/Throwable
    //   138	145	145	finally
    //   19	49	169	java/lang/Exception
    //   104	111	169	java/lang/Exception
    //   123	130	169	java/lang/Exception
    //   155	162	169	java/lang/Exception
    //   162	169	169	java/lang/Exception
    //   194	200	169	java/lang/Exception
    //   203	210	169	java/lang/Exception
    //   155	162	192	java/lang/Throwable
    //   49	67	213	finally
    //   67	95	213	finally
  }
  
  /* Error */
  public final java.util.List<c> dMl()
  {
    // Byte code:
    //   0: ldc 163
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 147	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 148	java/util/ArrayList:<init>	()V
    //   12: astore 4
    //   14: new 165	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: ldc 168
    //   25: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc 174
    //   32: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc 176
    //   39: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc 168
    //   46: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: ldc 174
    //   53: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_0
    //   58: getfield 61	com/tencent/mm/plugin/remittance/b/d:db	Lcom/tencent/mm/sdk/e/e;
    //   61: ldc 32
    //   63: getstatic 44	com/tencent/mm/plugin/remittance/b/d:iWL	[Ljava/lang/String;
    //   66: aload_2
    //   67: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: iconst_2
    //   71: anewarray 24	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: ldc 181
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: ldc 183
    //   83: aastore
    //   84: aconst_null
    //   85: aconst_null
    //   86: aconst_null
    //   87: iconst_2
    //   88: invokeinterface 100 9 0
    //   93: astore 5
    //   95: aload 5
    //   97: invokeinterface 106 1 0
    //   102: ifeq +58 -> 160
    //   105: new 26	com/tencent/mm/plugin/remittance/b/c
    //   108: dup
    //   109: invokespecial 107	com/tencent/mm/plugin/remittance/b/c:<init>	()V
    //   112: astore_2
    //   113: aload_2
    //   114: aload 5
    //   116: invokevirtual 111	com/tencent/mm/plugin/remittance/b/c:convertFrom	(Landroid/database/Cursor;)V
    //   119: aload 4
    //   121: aload_2
    //   122: invokeinterface 186 2 0
    //   127: pop
    //   128: aload 5
    //   130: invokeinterface 154 1 0
    //   135: istore_1
    //   136: iload_1
    //   137: ifne -32 -> 105
    //   140: aload 5
    //   142: ifnull +10 -> 152
    //   145: aload 5
    //   147: invokeinterface 114 1 0
    //   152: ldc 163
    //   154: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload 4
    //   159: areturn
    //   160: aload 5
    //   162: ifnull +10 -> 172
    //   165: aload 5
    //   167: invokeinterface 114 1 0
    //   172: ldc 163
    //   174: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload 4
    //   179: areturn
    //   180: astore_3
    //   181: ldc 163
    //   183: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_3
    //   187: athrow
    //   188: astore_2
    //   189: aload 5
    //   191: ifnull +14 -> 205
    //   194: aload_3
    //   195: ifnull +51 -> 246
    //   198: aload 5
    //   200: invokeinterface 114 1 0
    //   205: ldc 163
    //   207: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_2
    //   211: athrow
    //   212: astore_2
    //   213: ldc 116
    //   215: aload_2
    //   216: ldc 118
    //   218: iconst_1
    //   219: anewarray 120	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_2
    //   225: invokevirtual 124	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   228: aastore
    //   229: invokestatic 130	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: goto -60 -> 172
    //   235: astore 5
    //   237: aload_3
    //   238: aload 5
    //   240: invokevirtual 158	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   243: goto -38 -> 205
    //   246: aload 5
    //   248: invokeinterface 114 1 0
    //   253: goto -48 -> 205
    //   256: astore_2
    //   257: aconst_null
    //   258: astore_3
    //   259: goto -70 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	d
    //   135	2	1	bool	boolean
    //   21	101	2	localObject1	Object
    //   188	23	2	localObject2	Object
    //   212	13	2	localException	Exception
    //   256	1	2	localObject3	Object
    //   180	58	3	localThrowable1	java.lang.Throwable
    //   258	1	3	localObject4	Object
    //   12	166	4	localArrayList	java.util.ArrayList
    //   93	106	5	localCursor	Cursor
    //   235	12	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   95	105	180	java/lang/Throwable
    //   105	136	180	java/lang/Throwable
    //   181	188	188	finally
    //   57	95	212	java/lang/Exception
    //   145	152	212	java/lang/Exception
    //   165	172	212	java/lang/Exception
    //   198	205	212	java/lang/Exception
    //   205	212	212	java/lang/Exception
    //   237	243	212	java/lang/Exception
    //   246	253	212	java/lang/Exception
    //   198	205	235	java/lang/Throwable
    //   95	105	256	finally
    //   105	136	256	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.b.d
 * JD-Core Version:    0.7.0.1
 */