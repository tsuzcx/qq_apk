package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends MAutoStorage<af>
{
  public static final String[] SQL_CREATE;
  public static Map<String, af> mKV;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70620);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(af.info, "WalletLuckyMoney") };
    mKV = new HashMap();
    AppMethodBeat.o(70620);
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, af.info, "WalletLuckyMoney", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(af paramaf)
  {
    AppMethodBeat.i(70618);
    if ((paramaf != null) && (mKV.containsKey(paramaf.field_mNativeUrl))) {
      mKV.put(paramaf.field_mNativeUrl, paramaf);
    }
    boolean bool = super.replace(paramaf);
    AppMethodBeat.o(70618);
    return bool;
  }
  
  public final af bhj(String paramString)
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
    af localaf = new af();
    localaf.convertFrom(paramString);
    paramString.close();
    AppMethodBeat.o(70617);
    return localaf;
  }
  
  /* Error */
  public final java.util.List<af> bhk(final String paramString)
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
    //   64: invokevirtual 137	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
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
    //   121: new 27	com/tencent/mm/plugin/wallet_core/model/af
    //   124: dup
    //   125: invokespecial 102	com/tencent/mm/plugin/wallet_core/model/af:<init>	()V
    //   128: astore 5
    //   130: aload_2
    //   131: astore_1
    //   132: aload 5
    //   134: aload_2
    //   135: invokevirtual 106	com/tencent/mm/plugin/wallet_core/model/af:convertFrom	(Landroid/database/Cursor;)V
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
    //   128	14	5	localaf	af
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
  public final af bhl(String paramString)
  {
    // Byte code:
    //   0: ldc 178
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 178
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
    //   34: ldc 180
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
    //   48: invokeinterface 183 9 0
    //   53: astore_3
    //   54: aload_3
    //   55: invokeinterface 101 1 0
    //   60: ifeq +39 -> 99
    //   63: new 27	com/tencent/mm/plugin/wallet_core/model/af
    //   66: dup
    //   67: invokespecial 102	com/tencent/mm/plugin/wallet_core/model/af:<init>	()V
    //   70: astore_1
    //   71: aload_1
    //   72: aload_3
    //   73: invokevirtual 106	com/tencent/mm/plugin/wallet_core/model/af:convertFrom	(Landroid/database/Cursor;)V
    //   76: aload_3
    //   77: invokeinterface 97 1 0
    //   82: aload_3
    //   83: ifnull +9 -> 92
    //   86: aload_3
    //   87: invokeinterface 97 1 0
    //   92: ldc 178
    //   94: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: areturn
    //   99: aload_3
    //   100: invokeinterface 97 1 0
    //   105: aload_3
    //   106: ifnull +9 -> 115
    //   109: aload_3
    //   110: invokeinterface 97 1 0
    //   115: ldc 178
    //   117: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_2
    //   123: ldc 178
    //   125: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_2
    //   129: athrow
    //   130: astore_1
    //   131: aload_3
    //   132: ifnull +13 -> 145
    //   135: aload_2
    //   136: ifnull +45 -> 181
    //   139: aload_3
    //   140: invokeinterface 97 1 0
    //   145: ldc 178
    //   147: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: ldc 162
    //   155: aload_1
    //   156: ldc 164
    //   158: iconst_0
    //   159: anewarray 166	java/lang/Object
    //   162: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: ldc 178
    //   167: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_3
    //   173: aload_2
    //   174: aload_3
    //   175: invokevirtual 187	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   178: goto -33 -> 145
    //   181: aload_3
    //   182: invokeinterface 97 1 0
    //   187: goto -42 -> 145
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_2
    //   193: goto -62 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	h
    //   0	196	1	paramString	String
    //   122	52	2	localThrowable1	java.lang.Throwable
    //   192	1	2	localObject	Object
    //   53	87	3	localCursor	Cursor
    //   172	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   54	82	122	java/lang/Throwable
    //   99	105	122	java/lang/Throwable
    //   123	130	130	finally
    //   19	54	152	java/lang/Exception
    //   86	92	152	java/lang/Exception
    //   109	115	152	java/lang/Exception
    //   139	145	152	java/lang/Exception
    //   145	152	152	java/lang/Exception
    //   173	178	152	java/lang/Exception
    //   181	187	152	java/lang/Exception
    //   139	145	172	java/lang/Throwable
    //   54	82	190	finally
    //   99	105	190	finally
  }
  
  /* Error */
  public final java.util.List<af> gKY()
  {
    // Byte code:
    //   0: ldc 190
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 149	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 150	java/util/ArrayList:<init>	()V
    //   12: astore_3
    //   13: new 192	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc 195
    //   24: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc 201
    //   31: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: ldc 203
    //   38: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: ldc 205
    //   45: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: ldc 207
    //   52: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_2
    //   57: ldc 203
    //   59: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_2
    //   64: ldc 205
    //   66: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: ldc 207
    //   73: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: getfield 56	com/tencent/mm/plugin/wallet_core/d/h:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   81: astore_1
    //   82: aload_2
    //   83: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_2
    //   87: aload_1
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
    //   104: aload_2
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
    //   128: invokeinterface 183 9 0
    //   133: astore 4
    //   135: aload 4
    //   137: invokeinterface 101 1 0
    //   142: ifeq +61 -> 203
    //   145: new 27	com/tencent/mm/plugin/wallet_core/model/af
    //   148: dup
    //   149: invokespecial 102	com/tencent/mm/plugin/wallet_core/model/af:<init>	()V
    //   152: astore_1
    //   153: aload_1
    //   154: aload 4
    //   156: invokevirtual 106	com/tencent/mm/plugin/wallet_core/model/af:convertFrom	(Landroid/database/Cursor;)V
    //   159: aload_3
    //   160: aload_1
    //   161: invokeinterface 222 2 0
    //   166: pop
    //   167: aload 4
    //   169: invokeinterface 156 1 0
    //   174: ifne -29 -> 145
    //   177: aload 4
    //   179: invokeinterface 97 1 0
    //   184: aload 4
    //   186: ifnull +10 -> 196
    //   189: aload 4
    //   191: invokeinterface 97 1 0
    //   196: ldc 190
    //   198: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_3
    //   202: areturn
    //   203: aload 4
    //   205: invokeinterface 97 1 0
    //   210: aload 4
    //   212: ifnull +10 -> 222
    //   215: aload 4
    //   217: invokeinterface 97 1 0
    //   222: ldc 190
    //   224: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: aload_3
    //   228: areturn
    //   229: astore_2
    //   230: ldc 190
    //   232: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_2
    //   236: athrow
    //   237: astore_1
    //   238: aload 4
    //   240: ifnull +14 -> 254
    //   243: aload_2
    //   244: ifnull +51 -> 295
    //   247: aload 4
    //   249: invokeinterface 97 1 0
    //   254: ldc 190
    //   256: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: ldc 162
    //   264: aload_1
    //   265: ldc 224
    //   267: iconst_1
    //   268: anewarray 166	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload_1
    //   274: invokevirtual 227	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   277: aastore
    //   278: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: goto -59 -> 222
    //   284: astore 4
    //   286: aload_2
    //   287: aload 4
    //   289: invokevirtual 187	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   292: goto -38 -> 254
    //   295: aload 4
    //   297: invokeinterface 97 1 0
    //   302: goto -48 -> 254
    //   305: astore_1
    //   306: aconst_null
    //   307: astore_2
    //   308: goto -70 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	h
    //   81	80	1	localObject1	Object
    //   237	23	1	localObject2	Object
    //   261	13	1	localException	java.lang.Exception
    //   305	1	1	localObject3	Object
    //   20	85	2	localObject4	Object
    //   229	58	2	localThrowable1	java.lang.Throwable
    //   307	1	2	localObject5	Object
    //   12	216	3	localArrayList	java.util.ArrayList
    //   133	115	4	localCursor	Cursor
    //   284	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   135	145	229	java/lang/Throwable
    //   145	184	229	java/lang/Throwable
    //   203	210	229	java/lang/Throwable
    //   230	237	237	finally
    //   77	135	261	java/lang/Exception
    //   189	196	261	java/lang/Exception
    //   215	222	261	java/lang/Exception
    //   247	254	261	java/lang/Exception
    //   254	261	261	java/lang/Exception
    //   286	292	261	java/lang/Exception
    //   295	302	261	java/lang/Exception
    //   247	254	284	java/lang/Throwable
    //   135	145	305	finally
    //   145	184	305	finally
    //   203	210	305	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.h
 * JD-Core Version:    0.7.0.1
 */