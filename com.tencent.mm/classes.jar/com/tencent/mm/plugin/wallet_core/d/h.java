package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends MAutoStorage<ae>
{
  public static final String[] SQL_CREATE;
  public static Map<String, ae> jTI;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(70620);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ae.info, "WalletLuckyMoney") };
    jTI = new HashMap();
    AppMethodBeat.o(70620);
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ae.info, "WalletLuckyMoney", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(ae paramae)
  {
    AppMethodBeat.i(70618);
    if ((paramae != null) && (jTI.containsKey(paramae.field_mNativeUrl))) {
      jTI.put(paramae.field_mNativeUrl, paramae);
    }
    boolean bool = super.replace(paramae);
    AppMethodBeat.o(70618);
    return bool;
  }
  
  public final ae aVA(String paramString)
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
    ae localae = new ae();
    localae.convertFrom(paramString);
    paramString.close();
    AppMethodBeat.o(70617);
    return localae;
  }
  
  /* Error */
  public final java.util.List<ae> aVB(String paramString)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 111
    //   14: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 54	com/tencent/mm/plugin/wallet_core/d/h:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   23: ldc 31
    //   25: iconst_1
    //   26: anewarray 23	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 119
    //   33: aastore
    //   34: ldc 121
    //   36: iconst_1
    //   37: anewarray 23	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: iconst_2
    //   48: invokeinterface 125 9 0
    //   53: astore_3
    //   54: aload_3
    //   55: invokeinterface 99 1 0
    //   60: ifeq +62 -> 122
    //   63: new 127	java/util/ArrayList
    //   66: dup
    //   67: invokespecial 128	java/util/ArrayList:<init>	()V
    //   70: astore_1
    //   71: new 25	com/tencent/mm/plugin/wallet_core/model/ae
    //   74: dup
    //   75: invokespecial 100	com/tencent/mm/plugin/wallet_core/model/ae:<init>	()V
    //   78: astore_2
    //   79: aload_2
    //   80: aload_3
    //   81: invokevirtual 104	com/tencent/mm/plugin/wallet_core/model/ae:convertFrom	(Landroid/database/Cursor;)V
    //   84: aload_1
    //   85: aload_2
    //   86: invokevirtual 131	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: aload_3
    //   91: invokeinterface 134 1 0
    //   96: ifne -25 -> 71
    //   99: aload_3
    //   100: invokeinterface 95 1 0
    //   105: aload_3
    //   106: ifnull +9 -> 115
    //   109: aload_3
    //   110: invokeinterface 95 1 0
    //   115: ldc 111
    //   117: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: areturn
    //   122: aload_3
    //   123: invokeinterface 95 1 0
    //   128: aload_3
    //   129: ifnull +9 -> 138
    //   132: aload_3
    //   133: invokeinterface 95 1 0
    //   138: ldc 111
    //   140: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_2
    //   146: ldc 111
    //   148: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_2
    //   152: athrow
    //   153: astore_1
    //   154: aload_3
    //   155: ifnull +13 -> 168
    //   158: aload_2
    //   159: ifnull +41 -> 200
    //   162: aload_3
    //   163: invokeinterface 95 1 0
    //   168: ldc 111
    //   170: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: ldc 136
    //   178: aload_1
    //   179: ldc 138
    //   181: iconst_0
    //   182: anewarray 140	java/lang/Object
    //   185: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: goto -50 -> 138
    //   191: astore_3
    //   192: aload_2
    //   193: aload_3
    //   194: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   197: goto -29 -> 168
    //   200: aload_3
    //   201: invokeinterface 95 1 0
    //   206: goto -38 -> 168
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: goto -58 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	h
    //   0	215	1	paramString	String
    //   78	8	2	localae	ae
    //   145	48	2	localThrowable1	java.lang.Throwable
    //   211	1	2	localObject	java.lang.Object
    //   53	110	3	localCursor	Cursor
    //   191	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   54	71	145	java/lang/Throwable
    //   71	105	145	java/lang/Throwable
    //   122	128	145	java/lang/Throwable
    //   146	153	153	finally
    //   19	54	175	java/lang/Exception
    //   109	115	175	java/lang/Exception
    //   132	138	175	java/lang/Exception
    //   162	168	175	java/lang/Exception
    //   168	175	175	java/lang/Exception
    //   192	197	175	java/lang/Exception
    //   200	206	175	java/lang/Exception
    //   162	168	191	java/lang/Throwable
    //   54	71	209	finally
    //   71	105	209	finally
    //   122	128	209	finally
  }
  
  /* Error */
  public final ae aVC(String paramString)
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 154
    //   14: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 54	com/tencent/mm/plugin/wallet_core/d/h:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   23: ldc 31
    //   25: iconst_1
    //   26: anewarray 23	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 119
    //   33: aastore
    //   34: ldc 156
    //   36: iconst_1
    //   37: anewarray 23	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: iconst_2
    //   48: invokeinterface 125 9 0
    //   53: astore_3
    //   54: aload_3
    //   55: invokeinterface 99 1 0
    //   60: ifeq +39 -> 99
    //   63: new 25	com/tencent/mm/plugin/wallet_core/model/ae
    //   66: dup
    //   67: invokespecial 100	com/tencent/mm/plugin/wallet_core/model/ae:<init>	()V
    //   70: astore_1
    //   71: aload_1
    //   72: aload_3
    //   73: invokevirtual 104	com/tencent/mm/plugin/wallet_core/model/ae:convertFrom	(Landroid/database/Cursor;)V
    //   76: aload_3
    //   77: invokeinterface 95 1 0
    //   82: aload_3
    //   83: ifnull +9 -> 92
    //   86: aload_3
    //   87: invokeinterface 95 1 0
    //   92: ldc 154
    //   94: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: areturn
    //   99: aload_3
    //   100: invokeinterface 95 1 0
    //   105: aload_3
    //   106: ifnull +9 -> 115
    //   109: aload_3
    //   110: invokeinterface 95 1 0
    //   115: ldc 154
    //   117: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_2
    //   123: ldc 154
    //   125: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_2
    //   129: athrow
    //   130: astore_1
    //   131: aload_3
    //   132: ifnull +13 -> 145
    //   135: aload_2
    //   136: ifnull +45 -> 181
    //   139: aload_3
    //   140: invokeinterface 95 1 0
    //   145: ldc 154
    //   147: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: ldc 136
    //   155: aload_1
    //   156: ldc 138
    //   158: iconst_0
    //   159: anewarray 140	java/lang/Object
    //   162: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: ldc 154
    //   167: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_3
    //   173: aload_2
    //   174: aload_3
    //   175: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   178: goto -33 -> 145
    //   181: aload_3
    //   182: invokeinterface 95 1 0
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
    //   192	1	2	localObject	java.lang.Object
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
  public final java.util.List<ae> fSt()
  {
    // Byte code:
    //   0: ldc 159
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 127	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 128	java/util/ArrayList:<init>	()V
    //   12: astore_3
    //   13: new 161	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc 164
    //   24: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc 170
    //   31: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: ldc 172
    //   38: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: ldc 174
    //   45: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: ldc 176
    //   52: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_2
    //   57: ldc 172
    //   59: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_2
    //   64: ldc 174
    //   66: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: ldc 176
    //   73: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: getfield 54	com/tencent/mm/plugin/wallet_core/d/h:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   81: astore_1
    //   82: aload_2
    //   83: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_2
    //   87: aload_1
    //   88: ldc 31
    //   90: iconst_2
    //   91: anewarray 23	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: ldc 119
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: ldc 182
    //   103: aastore
    //   104: aload_2
    //   105: iconst_3
    //   106: anewarray 23	java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: ldc 184
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: ldc 186
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: ldc 188
    //   123: aastore
    //   124: aconst_null
    //   125: aconst_null
    //   126: aconst_null
    //   127: iconst_2
    //   128: invokeinterface 125 9 0
    //   133: astore 4
    //   135: aload 4
    //   137: invokeinterface 99 1 0
    //   142: ifeq +61 -> 203
    //   145: new 25	com/tencent/mm/plugin/wallet_core/model/ae
    //   148: dup
    //   149: invokespecial 100	com/tencent/mm/plugin/wallet_core/model/ae:<init>	()V
    //   152: astore_1
    //   153: aload_1
    //   154: aload 4
    //   156: invokevirtual 104	com/tencent/mm/plugin/wallet_core/model/ae:convertFrom	(Landroid/database/Cursor;)V
    //   159: aload_3
    //   160: aload_1
    //   161: invokeinterface 191 2 0
    //   166: pop
    //   167: aload 4
    //   169: invokeinterface 134 1 0
    //   174: ifne -29 -> 145
    //   177: aload 4
    //   179: invokeinterface 95 1 0
    //   184: aload 4
    //   186: ifnull +10 -> 196
    //   189: aload 4
    //   191: invokeinterface 95 1 0
    //   196: ldc 159
    //   198: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_3
    //   202: areturn
    //   203: aload 4
    //   205: invokeinterface 95 1 0
    //   210: aload 4
    //   212: ifnull +10 -> 222
    //   215: aload 4
    //   217: invokeinterface 95 1 0
    //   222: ldc 159
    //   224: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: aload_3
    //   228: areturn
    //   229: astore_2
    //   230: ldc 159
    //   232: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_2
    //   236: athrow
    //   237: astore_1
    //   238: aload 4
    //   240: ifnull +14 -> 254
    //   243: aload_2
    //   244: ifnull +51 -> 295
    //   247: aload 4
    //   249: invokeinterface 95 1 0
    //   254: ldc 159
    //   256: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: ldc 136
    //   264: aload_1
    //   265: ldc 193
    //   267: iconst_1
    //   268: anewarray 140	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload_1
    //   274: invokevirtual 196	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   277: aastore
    //   278: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: goto -59 -> 222
    //   284: astore 4
    //   286: aload_2
    //   287: aload 4
    //   289: invokevirtual 150	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   292: goto -38 -> 254
    //   295: aload 4
    //   297: invokeinterface 95 1 0
    //   302: goto -48 -> 254
    //   305: astore_1
    //   306: aconst_null
    //   307: astore_2
    //   308: goto -70 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	h
    //   81	80	1	localObject1	java.lang.Object
    //   237	23	1	localObject2	java.lang.Object
    //   261	13	1	localException	java.lang.Exception
    //   305	1	1	localObject3	java.lang.Object
    //   20	85	2	localObject4	java.lang.Object
    //   229	58	2	localThrowable1	java.lang.Throwable
    //   307	1	2	localObject5	java.lang.Object
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