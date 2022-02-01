package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.IOException;

public final class s
  extends MAutoStorage<r>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(105137);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(r.info, "GetEmotionListCache") };
    AppMethodBeat.o(105137);
  }
  
  public s(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, r.info, "GetEmotionListCache", null);
  }
  
  public s(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
    this.db = paramISQLiteDatabase;
  }
  
  private boolean bxV(String paramString)
  {
    AppMethodBeat.i(105128);
    if (this.db.delete("GetEmotionListCache", "reqType=?", new String[] { paramString }) > 0)
    {
      AppMethodBeat.o(105128);
      return true;
    }
    AppMethodBeat.o(105128);
    return false;
  }
  
  public final boolean a(int paramInt, buh parambuh)
  {
    AppMethodBeat.i(105129);
    if (parambuh == null)
    {
      AppMethodBeat.o(105129);
      return false;
    }
    try
    {
      this.db.delete("GetEmotionListCache", "reqType=?", new String[] { String.valueOf(paramInt) });
      parambuh = new r(String.valueOf(paramInt), parambuh.toByteArray());
      Log.d("MicroMsg.emoji.Storage", "insert cache: %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = insert(parambuh);
      AppMethodBeat.o(105129);
      return bool;
    }
    catch (Exception parambuh)
    {
      Log.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { Util.stackTraceToString(parambuh) });
      AppMethodBeat.o(105129);
    }
    return false;
  }
  
  public final boolean a(eiv parameiv)
  {
    AppMethodBeat.i(105134);
    if (parameiv == null)
    {
      AppMethodBeat.o(105134);
      return false;
    }
    try
    {
      bxV("Smiley_panel_req_type");
      boolean bool = insert(new r("Smiley_panel_req_type", parameiv.toByteArray()));
      AppMethodBeat.o(105134);
      return bool;
    }
    catch (Exception parameiv)
    {
      Log.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { Util.stackTraceToString(parameiv) });
      AppMethodBeat.o(105134);
    }
    return false;
  }
  
  public final boolean a(String paramString, btz parambtz)
  {
    AppMethodBeat.i(105136);
    if (parambtz == null)
    {
      AppMethodBeat.o(105136);
      return false;
    }
    try
    {
      bxV("activityID:".concat(String.valueOf(paramString)));
      boolean bool = insert(new r("activityID:".concat(String.valueOf(paramString)), parambtz.toByteArray()));
      AppMethodBeat.o(105136);
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(105136);
    }
    return false;
  }
  
  public final boolean a(String paramString, caj paramcaj)
  {
    AppMethodBeat.i(105131);
    if (paramcaj == null)
    {
      AppMethodBeat.o(105131);
      return false;
    }
    try
    {
      bxV(paramString);
      boolean bool = insert(new r(paramString, paramcaj.toByteArray()));
      AppMethodBeat.o(105131);
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(105131);
    }
    return false;
  }
  
  public final buh asU(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(105130);
    Cursor localCursor = this.db.query("GetEmotionListCache", null, "reqType=?", new String[] { String.valueOf(paramInt) }, null, null, null, 2);
    Object localObject1 = localObject3;
    r localr;
    if (localCursor != null)
    {
      localObject1 = localObject3;
      if (localCursor.moveToFirst()) {
        localr = new r(localCursor);
      }
    }
    try
    {
      localObject1 = new buh();
      ((buh)localObject1).parseFrom(localr.field_cache);
      Log.d("MicroMsg.emoji.Storage", "succed get cache: %d", new Object[] { Integer.valueOf(paramInt) });
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(105130);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { Util.stackTraceToString(localIOException) });
        Object localObject2 = localObject3;
      }
    }
  }
  
  public final caj bxW(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(105132);
    Cursor localCursor = this.db.query("GetEmotionListCache", null, "reqType=?", new String[] { paramString }, null, null, null, 2);
    Object localObject1 = localObject2;
    r localr;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst()) {
        localr = new r(localCursor);
      }
    }
    try
    {
      localObject1 = new caj();
      ((caj)localObject1).parseFrom(localr.field_cache);
      Log.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", new Object[] { paramString });
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(105132);
      return localObject1;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.emoji.Storage", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        localObject1 = localObject2;
      }
    }
  }
  
  /* Error */
  public final btz bxX(String paramString)
  {
    // Byte code:
    //   0: ldc 178
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 181	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +17 -> 26
    //   12: ldc 77
    //   14: ldc 183
    //   16: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 178
    //   21: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: getfield 46	com/tencent/mm/storage/emotion/s:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   30: ldc 28
    //   32: aconst_null
    //   33: ldc 51
    //   35: iconst_1
    //   36: anewarray 20	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: ldc 120
    //   43: aload_1
    //   44: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   50: aastore
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: invokeinterface 190 8 0
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +142 -> 203
    //   64: aload_1
    //   65: astore_2
    //   66: aload_1
    //   67: invokeinterface 150 1 0
    //   72: ifeq +131 -> 203
    //   75: aload_1
    //   76: astore_2
    //   77: new 22	com/tencent/mm/storage/emotion/r
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 153	com/tencent/mm/storage/emotion/r:<init>	(Landroid/database/Cursor;)V
    //   85: astore 4
    //   87: aload_1
    //   88: astore_2
    //   89: new 129	com/tencent/mm/protocal/protobuf/btz
    //   92: dup
    //   93: invokespecial 191	com/tencent/mm/protocal/protobuf/btz:<init>	()V
    //   96: astore_3
    //   97: aload_1
    //   98: astore_2
    //   99: aload_3
    //   100: aload 4
    //   102: getfield 159	com/tencent/mm/storage/emotion/r:field_cache	[B
    //   105: invokevirtual 192	com/tencent/mm/protocal/protobuf/btz:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   108: pop
    //   109: aload_3
    //   110: astore_2
    //   111: aload_2
    //   112: astore_3
    //   113: aload_1
    //   114: ifnull +11 -> 125
    //   117: aload_1
    //   118: invokeinterface 168 1 0
    //   123: aload_2
    //   124: astore_3
    //   125: ldc 178
    //   127: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_3
    //   131: areturn
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_2
    //   137: ldc 77
    //   139: ldc 98
    //   141: iconst_1
    //   142: anewarray 81	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_3
    //   148: invokestatic 104	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_1
    //   156: ifnull +42 -> 198
    //   159: aload_1
    //   160: invokeinterface 168 1 0
    //   165: aconst_null
    //   166: astore_3
    //   167: goto -42 -> 125
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull +9 -> 183
    //   177: aload_2
    //   178: invokeinterface 168 1 0
    //   183: ldc 178
    //   185: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: goto -18 -> 173
    //   194: astore_3
    //   195: goto -60 -> 135
    //   198: aconst_null
    //   199: astore_3
    //   200: goto -75 -> 125
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -94 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	s
    //   0	208	1	paramString	String
    //   65	140	2	localObject1	Object
    //   96	35	3	localObject2	Object
    //   132	16	3	localIOException1	IOException
    //   166	1	3	localObject3	Object
    //   194	1	3	localIOException2	IOException
    //   199	1	3	localObject4	Object
    //   85	16	4	localr	r
    // Exception table:
    //   from	to	target	type
    //   26	60	132	java/io/IOException
    //   26	60	170	finally
    //   66	75	190	finally
    //   77	87	190	finally
    //   89	97	190	finally
    //   99	109	190	finally
    //   137	155	190	finally
    //   66	75	194	java/io/IOException
    //   77	87	194	java/io/IOException
    //   89	97	194	java/io/IOException
    //   99	109	194	java/io/IOException
  }
  
  public final byte[] get(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(225949);
    Cursor localCursor = this.db.query("GetEmotionListCache", null, "reqType=?", new String[] { paramString }, null, null, null);
    paramString = localObject2;
    if (localCursor != null)
    {
      paramString = localObject1;
      if (localCursor.moveToFirst()) {
        paramString = new r(localCursor).field_cache;
      }
      localCursor.close();
    }
    AppMethodBeat.o(225949);
    return paramString;
  }
  
  /* Error */
  public final eiv hBK()
  {
    // Byte code:
    //   0: ldc 198
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 46	com/tencent/mm/storage/emotion/s:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   9: ldc 28
    //   11: aconst_null
    //   12: ldc 51
    //   14: iconst_1
    //   15: anewarray 20	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 111
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokeinterface 190 8 0
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +142 -> 175
    //   36: aload_1
    //   37: astore_2
    //   38: aload_1
    //   39: invokeinterface 150 1 0
    //   44: ifeq +131 -> 175
    //   47: aload_1
    //   48: astore_2
    //   49: new 22	com/tencent/mm/storage/emotion/r
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 153	com/tencent/mm/storage/emotion/r:<init>	(Landroid/database/Cursor;)V
    //   57: astore 4
    //   59: aload_1
    //   60: astore_2
    //   61: new 115	com/tencent/mm/protocal/protobuf/eiv
    //   64: dup
    //   65: invokespecial 199	com/tencent/mm/protocal/protobuf/eiv:<init>	()V
    //   68: astore_3
    //   69: aload_1
    //   70: astore_2
    //   71: aload_3
    //   72: aload 4
    //   74: getfield 159	com/tencent/mm/storage/emotion/r:field_cache	[B
    //   77: invokevirtual 200	com/tencent/mm/protocal/protobuf/eiv:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   80: pop
    //   81: aload_3
    //   82: astore_2
    //   83: aload_2
    //   84: astore_3
    //   85: aload_1
    //   86: ifnull +11 -> 97
    //   89: aload_1
    //   90: invokeinterface 168 1 0
    //   95: aload_2
    //   96: astore_3
    //   97: ldc 198
    //   99: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_3
    //   103: areturn
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_2
    //   109: ldc 77
    //   111: ldc 98
    //   113: iconst_1
    //   114: anewarray 81	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokestatic 104	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_1
    //   128: ifnull +42 -> 170
    //   131: aload_1
    //   132: invokeinterface 168 1 0
    //   137: aconst_null
    //   138: astore_3
    //   139: goto -42 -> 97
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 168 1 0
    //   155: ldc 198
    //   157: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: goto -18 -> 145
    //   166: astore_3
    //   167: goto -60 -> 107
    //   170: aconst_null
    //   171: astore_3
    //   172: goto -75 -> 97
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -94 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	s
    //   31	101	1	localCursor	Cursor
    //   142	19	1	localObject1	Object
    //   162	1	1	localObject2	Object
    //   37	140	2	localObject3	Object
    //   68	35	3	localObject4	Object
    //   104	16	3	localException1	Exception
    //   138	1	3	localObject5	Object
    //   166	1	3	localException2	Exception
    //   171	1	3	localObject6	Object
    //   57	16	4	localr	r
    // Exception table:
    //   from	to	target	type
    //   5	32	104	java/lang/Exception
    //   5	32	142	finally
    //   38	47	162	finally
    //   49	59	162	finally
    //   61	69	162	finally
    //   71	81	162	finally
    //   109	127	162	finally
    //   38	47	166	java/lang/Exception
    //   49	59	166	java/lang/Exception
    //   61	69	166	java/lang/Exception
    //   71	81	166	java/lang/Exception
  }
  
  public final void l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225951);
    replace(new r(paramString, paramArrayOfByte));
    AppMethodBeat.o(225951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.s
 * JD-Core Version:    0.7.0.1
 */