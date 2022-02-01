package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.j;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/FunctionMsgStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/api/FunctionMsgItem;", "()V", "ALL_FUNCTION_MSG_ITEM_PROJECTION", "", "", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDb", "()Lcom/tencent/mm/storagebase/SqliteDB;", "deleteAllHandleFunctionMsg", "", "getAllNeedHandleFunctionMsg", "", "getByFunctionMsgId", "functionMsgId", "updateByFunctionMsgId", "newFunctionMsgItem", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bu
  extends MAutoStorage<j>
{
  public static final bu adkj;
  private static final String[] adkk;
  private static final com.tencent.mm.storagebase.h omV;
  
  static
  {
    AppMethodBeat.i(114155);
    adkj = new bu();
    adkk = new String[] { "*", "rowid" };
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.h.baE().mCN;
    s.checkNotNull(localh);
    omV = localh;
    AppMethodBeat.o(114155);
  }
  
  private bu()
  {
    super((ISQLiteDatabase)com.tencent.mm.kernel.h.baE().mCN, j.info, "FunctionMsgItem", new String[] { "CREATE INDEX IF NOT EXISTS functionIdIndex ON FunctionMsgItem(functionmsgid)" });
    AppMethodBeat.i(114154);
    AppMethodBeat.o(114154);
  }
  
  public static void a(String paramString, j paramj)
  {
    AppMethodBeat.i(114151);
    s.u(paramString, "functionMsgId");
    s.u(paramj, "newFunctionMsgItem");
    Log.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s", new Object[] { paramString });
    Object localObject = byo(paramString);
    if (localObject != null) {
      try
      {
        boolean bool1;
        if (paramj.field_addMsg == null)
        {
          bool1 = true;
          if (((j)localObject).field_addMsg != null) {
            break label183;
          }
        }
        label183:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s, newFunctionMsgItem.msgContent==null: %s,oldFunctionMsgItem.msgContent==null: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          paramj = paramj.convertTo();
          if ((paramj.get("addMsg") == null) && (((j)localObject).field_addMsg != null))
          {
            localObject = ((j)localObject).field_addMsg;
            s.checkNotNull(localObject);
            paramj.put("addMsg", ((dl)localObject).toByteArray());
          }
          Log.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, ret: %s", new Object[] { Integer.valueOf(omV.update("FunctionMsgItem", paramj, "functionmsgid=?", new String[] { paramString })) });
          AppMethodBeat.o(114151);
          return;
          bool1 = false;
          break;
        }
        AppMethodBeat.o(114151);
      }
      catch (Exception paramString)
      {
        Log.e("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId error: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public static j byo(String paramString)
  {
    AppMethodBeat.i(114150);
    s.u(paramString, "functionMsgId");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(114150);
      return null;
    }
    Log.i("FunctionMsg.FunctionMsgStorage", "getByFunctionMsgId, functionMsgId: %s", new Object[] { paramString });
    Object localObject1 = omV.query("FunctionMsgItem", adkk, "functionmsgid=?", new String[] { paramString }, null, null, null, 2);
    paramString = (Closeable)localObject1;
    try
    {
      s.checkNotNull(localObject1);
      if (((Cursor)localObject1).moveToFirst())
      {
        j localj = new j();
        localj.convertFrom((Cursor)localObject1);
        b.a(paramString, null);
        AppMethodBeat.o(114150);
        return localj;
      }
      localObject1 = ah.aiuX;
      b.a(paramString, null);
      AppMethodBeat.o(114150);
      return null;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(114150);
        throw localThrowable;
      }
      finally
      {
        b.a(paramString, localThrowable);
        AppMethodBeat.o(114150);
      }
    }
  }
  
  /* Error */
  public static java.util.List<j> jbo()
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 80	com/tencent/mm/storage/bu:omV	Lcom/tencent/mm/storagebase/h;
    //   8: ldc 94
    //   10: getstatic 61	com/tencent/mm/storage/bu:adkk	[Ljava/lang/String;
    //   13: ldc 226
    //   15: iconst_1
    //   16: anewarray 55	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 228
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: iconst_2
    //   28: invokevirtual 197	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   31: checkcast 199	java/io/Closeable
    //   34: astore_0
    //   35: aload_0
    //   36: checkcast 201	android/database/Cursor
    //   39: astore_1
    //   40: new 230	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 231	java/util/ArrayList:<init>	()V
    //   47: astore_2
    //   48: aload_1
    //   49: invokeinterface 205 1 0
    //   54: pop
    //   55: aload_1
    //   56: invokeinterface 234 1 0
    //   61: ifne +53 -> 114
    //   64: new 88	com/tencent/mm/api/j
    //   67: dup
    //   68: invokespecial 206	com/tencent/mm/api/j:<init>	()V
    //   71: astore_3
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 210	com/tencent/mm/api/j:convertFrom	(Landroid/database/Cursor;)V
    //   77: aload_2
    //   78: aload_3
    //   79: invokevirtual 238	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_1
    //   84: invokeinterface 241 1 0
    //   89: pop
    //   90: goto -35 -> 55
    //   93: astore_1
    //   94: ldc 224
    //   96: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    //   101: astore_2
    //   102: aload_0
    //   103: aload_1
    //   104: invokestatic 215	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   107: ldc 224
    //   109: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_2
    //   113: athrow
    //   114: aload_2
    //   115: checkcast 243	java/util/List
    //   118: astore_1
    //   119: aload_0
    //   120: aconst_null
    //   121: invokestatic 215	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   124: ldc 224
    //   126: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_1
    //   130: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	86	0	localCloseable	Closeable
    //   39	45	1	localCursor	Cursor
    //   93	11	1	localThrowable	Throwable
    //   118	12	1	localList	java.util.List
    //   47	31	2	localArrayList	java.util.ArrayList
    //   101	14	2	localObject	Object
    //   71	8	3	localj	j
    // Exception table:
    //   from	to	target	type
    //   35	55	93	finally
    //   55	90	93	finally
    //   114	119	93	finally
    //   94	101	101	finally
  }
  
  public static void jbp()
  {
    AppMethodBeat.i(114153);
    int i = omV.delete("FunctionMsgItem", "status=?", new String[] { "100" });
    int j = omV.delete("FunctionMsgItem", "status=?", new String[] { "3" });
    Log.i("FunctionMsg.FunctionMsgStorage", "[deleteAllHandleFunctionMsg] ret1:" + i + " ret2:" + j);
    AppMethodBeat.o(114153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bu
 * JD-Core Version:    0.7.0.1
 */