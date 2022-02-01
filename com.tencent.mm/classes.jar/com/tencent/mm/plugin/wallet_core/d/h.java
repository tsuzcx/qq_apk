package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends MAutoStorage<ad>
{
  public static final String[] SQL_CREATE;
  public static Map<String, ad> pHC;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70620);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ad.info, "WalletLuckyMoney") };
    pHC = new HashMap();
    AppMethodBeat.o(70620);
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ad.info, "WalletLuckyMoney", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(ad paramad)
  {
    AppMethodBeat.i(70618);
    if ((paramad != null) && (pHC.containsKey(paramad.field_mNativeUrl))) {
      pHC.put(paramad.field_mNativeUrl, paramad);
    }
    boolean bool = super.replace(paramad);
    AppMethodBeat.o(70618);
    return bool;
  }
  
  public final ad bgT(String paramString)
  {
    AppMethodBeat.i(70617);
    paramString = this.db.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(70617);
      return null;
    }
    if (paramString.getCount() == 0)
    {
      paramString.close();
      AppMethodBeat.o(70617);
      return null;
    }
    paramString.moveToFirst();
    ad localad = new ad();
    localad.convertFrom(paramString);
    paramString.close();
    AppMethodBeat.o(70617);
    return localad;
  }
  
  /* Error */
  public final java.util.List<ad> bgU(final String paramString)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 111
    //   14: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 56	com/tencent/mm/plugin/wallet_core/d/h:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   23: instanceof 119
    //   26: ifeq +185 -> 211
    //   29: new 121	com/tencent/wcdb/support/CancellationSignal
    //   32: dup
    //   33: invokespecial 122	com/tencent/wcdb/support/CancellationSignal:<init>	()V
    //   36: astore_2
    //   37: new 7	com/tencent/mm/plugin/wallet_core/d/h$1
    //   40: dup
    //   41: aload_0
    //   42: aload_2
    //   43: aload_1
    //   44: invokespecial 125	com/tencent/mm/plugin/wallet_core/d/h$1:<init>	(Lcom/tencent/mm/plugin/wallet_core/d/h;Lcom/tencent/wcdb/support/CancellationSignal;Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 4
    //   51: ldc2_w 126
    //   54: invokestatic 133	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   57: aload_0
    //   58: getfield 56	com/tencent/mm/plugin/wallet_core/d/h:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   61: checkcast 119	com/tencent/mm/storagebase/h
    //   64: invokevirtual 137	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   67: iconst_0
    //   68: ldc 33
    //   70: iconst_1
    //   71: anewarray 25	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: ldc 139
    //   78: aastore
    //   79: ldc 141
    //   81: iconst_1
    //   82: anewarray 25	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: aload_1
    //   88: aastore
    //   89: aconst_null
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: aload_2
    //   94: invokevirtual 147	com/tencent/wcdb/database/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/wcdb/support/CancellationSignal;)Lcom/tencent/wcdb/Cursor;
    //   97: astore_2
    //   98: aload_2
    //   99: astore_1
    //   100: aload_2
    //   101: invokeinterface 101 1 0
    //   106: ifeq +82 -> 188
    //   109: aload_2
    //   110: astore_1
    //   111: new 149	java/util/ArrayList
    //   114: dup
    //   115: invokespecial 150	java/util/ArrayList:<init>	()V
    //   118: astore_3
    //   119: aload_2
    //   120: astore_1
    //   121: new 27	com/tencent/mm/plugin/wallet_core/model/ad
    //   124: dup
    //   125: invokespecial 102	com/tencent/mm/plugin/wallet_core/model/ad:<init>	()V
    //   128: astore 5
    //   130: aload_2
    //   131: astore_1
    //   132: aload 5
    //   134: aload_2
    //   135: invokevirtual 106	com/tencent/mm/plugin/wallet_core/model/ad:convertFrom	(Landroid/database/Cursor;)V
    //   138: aload_2
    //   139: astore_1
    //   140: aload_3
    //   141: aload 5
    //   143: invokevirtual 153	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   146: pop
    //   147: aload_2
    //   148: astore_1
    //   149: aload_2
    //   150: invokeinterface 156 1 0
    //   155: ifne -36 -> 119
    //   158: aload_2
    //   159: astore_1
    //   160: aload_2
    //   161: invokeinterface 97 1 0
    //   166: aload_2
    //   167: ifnull +9 -> 176
    //   170: aload_2
    //   171: invokeinterface 97 1 0
    //   176: aload 4
    //   178: invokestatic 160	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   181: ldc 111
    //   183: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_3
    //   187: areturn
    //   188: aload_2
    //   189: astore_1
    //   190: aload_2
    //   191: invokeinterface 97 1 0
    //   196: aload_2
    //   197: ifnull +9 -> 206
    //   200: aload_2
    //   201: invokeinterface 97 1 0
    //   206: aload 4
    //   208: invokestatic 160	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   211: ldc 111
    //   213: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_2
    //   221: aload_2
    //   222: astore_1
    //   223: ldc 162
    //   225: aload_3
    //   226: ldc 164
    //   228: iconst_0
    //   229: anewarray 166	java/lang/Object
    //   232: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_2
    //   236: ifnull +9 -> 245
    //   239: aload_2
    //   240: invokeinterface 97 1 0
    //   245: aload 4
    //   247: invokestatic 160	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   250: goto -39 -> 211
    //   253: astore_2
    //   254: aconst_null
    //   255: astore_1
    //   256: aload_1
    //   257: ifnull +9 -> 266
    //   260: aload_1
    //   261: invokeinterface 97 1 0
    //   266: aload 4
    //   268: invokestatic 160	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   271: ldc 111
    //   273: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_2
    //   277: athrow
    //   278: astore_2
    //   279: goto -23 -> 256
    //   282: astore_3
    //   283: goto -62 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	h
    //   0	286	1	paramString	String
    //   36	204	2	localObject1	Object
    //   253	24	2	localObject2	Object
    //   278	1	2	localObject3	Object
    //   118	69	3	localArrayList	java.util.ArrayList
    //   218	8	3	localException1	java.lang.Exception
    //   282	1	3	localException2	java.lang.Exception
    //   47	220	4	local1	1
    //   128	14	5	localad	ad
    // Exception table:
    //   from	to	target	type
    //   57	98	218	java/lang/Exception
    //   57	98	253	finally
    //   100	109	278	finally
    //   111	119	278	finally
    //   121	130	278	finally
    //   132	138	278	finally
    //   140	147	278	finally
    //   149	158	278	finally
    //   160	166	278	finally
    //   190	196	278	finally
    //   223	235	278	finally
    //   100	109	282	java/lang/Exception
    //   111	119	282	java/lang/Exception
    //   121	130	282	java/lang/Exception
    //   132	138	282	java/lang/Exception
    //   140	147	282	java/lang/Exception
    //   149	158	282	java/lang/Exception
    //   160	166	282	java/lang/Exception
    //   190	196	282	java/lang/Exception
  }
  
  /* Error */
  public final ad bgV(String paramString)
  {
    // Byte code:
    //   0: ldc 176
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 176
    //   14: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 56	com/tencent/mm/plugin/wallet_core/d/h:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   23: ldc 33
    //   25: iconst_1
    //   26: anewarray 25	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 139
    //   33: aastore
    //   34: ldc 178
    //   36: iconst_1
    //   37: anewarray 25	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: iconst_2
    //   48: invokeinterface 181 9 0
    //   53: astore_1
    //   54: aload_1
    //   55: invokeinterface 101 1 0
    //   60: ifeq +39 -> 99
    //   63: new 27	com/tencent/mm/plugin/wallet_core/model/ad
    //   66: dup
    //   67: invokespecial 102	com/tencent/mm/plugin/wallet_core/model/ad:<init>	()V
    //   70: astore_2
    //   71: aload_2
    //   72: aload_1
    //   73: invokevirtual 106	com/tencent/mm/plugin/wallet_core/model/ad:convertFrom	(Landroid/database/Cursor;)V
    //   76: aload_1
    //   77: invokeinterface 97 1 0
    //   82: aload_1
    //   83: ifnull +9 -> 92
    //   86: aload_1
    //   87: invokeinterface 97 1 0
    //   92: ldc 176
    //   94: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_2
    //   98: areturn
    //   99: aload_1
    //   100: invokeinterface 97 1 0
    //   105: aload_1
    //   106: ifnull +9 -> 115
    //   109: aload_1
    //   110: invokeinterface 97 1 0
    //   115: ldc 176
    //   117: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_2
    //   123: aload_1
    //   124: ifnull +9 -> 133
    //   127: aload_1
    //   128: invokeinterface 97 1 0
    //   133: ldc 176
    //   135: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_2
    //   139: athrow
    //   140: astore_1
    //   141: ldc 162
    //   143: aload_1
    //   144: ldc 164
    //   146: iconst_0
    //   147: anewarray 166	java/lang/Object
    //   150: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: ldc 176
    //   155: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aload_2
    //   162: aload_1
    //   163: invokevirtual 187	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   166: goto -33 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	h
    //   0	169	1	paramString	String
    //   70	28	2	localad	ad
    //   122	40	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	82	122	finally
    //   99	105	122	finally
    //   19	54	140	java/lang/Exception
    //   86	92	140	java/lang/Exception
    //   109	115	140	java/lang/Exception
    //   133	140	140	java/lang/Exception
    //   161	166	140	java/lang/Exception
    //   127	133	160	finally
  }
  
  /* Error */
  public final java.util.List<ad> ikq()
  {
    // Byte code:
    //   0: ldc 190
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 149	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 150	java/util/ArrayList:<init>	()V
    //   12: astore_1
    //   13: new 192	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   20: astore_3
    //   21: aload_3
    //   22: ldc 195
    //   24: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: ldc 201
    //   31: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: ldc 203
    //   38: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: ldc 205
    //   45: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_3
    //   50: ldc 207
    //   52: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_3
    //   57: ldc 203
    //   59: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_3
    //   64: ldc 205
    //   66: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_3
    //   71: ldc 207
    //   73: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: getfield 56	com/tencent/mm/plugin/wallet_core/d/h:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   81: astore_2
    //   82: aload_3
    //   83: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_3
    //   87: aload_2
    //   88: ldc 33
    //   90: iconst_2
    //   91: anewarray 25	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: ldc 139
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: ldc 213
    //   103: aastore
    //   104: aload_3
    //   105: iconst_3
    //   106: anewarray 25	java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: ldc 215
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: ldc 217
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: ldc 219
    //   123: aastore
    //   124: aconst_null
    //   125: aconst_null
    //   126: aconst_null
    //   127: iconst_2
    //   128: invokeinterface 181 9 0
    //   133: astore_2
    //   134: aload_2
    //   135: invokeinterface 101 1 0
    //   140: ifeq +56 -> 196
    //   143: new 27	com/tencent/mm/plugin/wallet_core/model/ad
    //   146: dup
    //   147: invokespecial 102	com/tencent/mm/plugin/wallet_core/model/ad:<init>	()V
    //   150: astore_3
    //   151: aload_3
    //   152: aload_2
    //   153: invokevirtual 106	com/tencent/mm/plugin/wallet_core/model/ad:convertFrom	(Landroid/database/Cursor;)V
    //   156: aload_1
    //   157: aload_3
    //   158: invokeinterface 222 2 0
    //   163: pop
    //   164: aload_2
    //   165: invokeinterface 156 1 0
    //   170: ifne -27 -> 143
    //   173: aload_2
    //   174: invokeinterface 97 1 0
    //   179: aload_2
    //   180: ifnull +9 -> 189
    //   183: aload_2
    //   184: invokeinterface 97 1 0
    //   189: ldc 190
    //   191: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_1
    //   195: areturn
    //   196: aload_2
    //   197: invokeinterface 97 1 0
    //   202: aload_2
    //   203: ifnull +9 -> 212
    //   206: aload_2
    //   207: invokeinterface 97 1 0
    //   212: ldc 190
    //   214: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: areturn
    //   219: astore_3
    //   220: aload_2
    //   221: ifnull +9 -> 230
    //   224: aload_2
    //   225: invokeinterface 97 1 0
    //   230: ldc 190
    //   232: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_3
    //   236: athrow
    //   237: astore_2
    //   238: ldc 162
    //   240: aload_2
    //   241: ldc 224
    //   243: iconst_1
    //   244: anewarray 166	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload_2
    //   250: invokevirtual 227	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: aastore
    //   254: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: goto -45 -> 212
    //   260: astore_2
    //   261: aload_3
    //   262: aload_2
    //   263: invokevirtual 187	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   266: goto -36 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	h
    //   12	206	1	localArrayList	java.util.ArrayList
    //   81	144	2	localObject1	Object
    //   237	13	2	localException	java.lang.Exception
    //   260	3	2	localThrowable	java.lang.Throwable
    //   20	138	3	localObject2	Object
    //   219	43	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   134	143	219	finally
    //   143	179	219	finally
    //   196	202	219	finally
    //   77	134	237	java/lang/Exception
    //   183	189	237	java/lang/Exception
    //   206	212	237	java/lang/Exception
    //   230	237	237	java/lang/Exception
    //   261	266	237	java/lang/Exception
    //   224	230	260	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.h
 * JD-Core Version:    0.7.0.1
 */