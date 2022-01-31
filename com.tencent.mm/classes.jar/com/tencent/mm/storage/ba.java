package com.tencent.mm.storage;

import a.l;
import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/storage/FunctionMsgStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/api/FunctionMsgItem;", "()V", "ALL_FUNCTION_MSG_ITEM_PROJECTION", "", "", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDb", "()Lcom/tencent/mm/storagebase/SqliteDB;", "deleteAllHandleFunctionMsg", "", "getAllNeedHandleFunctionMsg", "", "getByFunctionMsgId", "functionMsgId", "updateByFunctionMsgId", "newFunctionMsgItem", "plugin-functionmsg_release"})
public final class ba
  extends com.tencent.mm.sdk.e.j<f>
{
  private static final h fnw;
  private static final String[] yNZ;
  public static final ba yOa;
  
  static
  {
    AppMethodBeat.i(35502);
    yOa = new ba();
    yNZ = new String[] { "*", "rowid" };
    Object localObject = g.RL();
    a.f.b.j.p(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Rq();
    if (localObject == null) {
      a.f.b.j.ebi();
    }
    fnw = (h)localObject;
    AppMethodBeat.o(35502);
  }
  
  private ba()
  {
    super((com.tencent.mm.sdk.e.e)locale.Rq(), f.info, "FunctionMsgItem", new String[] { "CREATE INDEX IF NOT EXISTS functionIdIndex ON FunctionMsgItem(functionmsgid)" });
    AppMethodBeat.i(35501);
    AppMethodBeat.o(35501);
  }
  
  public static void a(String paramString, f paramf)
  {
    AppMethodBeat.i(35498);
    a.f.b.j.q(paramString, "functionMsgId");
    a.f.b.j.q(paramf, "newFunctionMsgItem");
    ab.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s", new Object[] { paramString });
    Object localObject = asf(paramString);
    if (localObject != null) {
      try
      {
        boolean bool1;
        if (paramf.Ag() == null)
        {
          bool1 = true;
          if (((f)localObject).Ag() != null) {
            break label186;
          }
        }
        label186:
        for (boolean bool2 = true;; bool2 = false)
        {
          ab.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s, newFunctionMsgItem.msgContent==null: %s,oldFunctionMsgItem.msgContent==null: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          paramf = paramf.convertTo();
          if ((paramf.get("addMsg") == null) && (((f)localObject).Ag() != null))
          {
            localObject = ((f)localObject).Ag();
            if (localObject == null) {
              a.f.b.j.ebi();
            }
            paramf.put("addMsg", ((cm)localObject).toByteArray());
          }
          ab.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, ret: %s", new Object[] { Integer.valueOf(fnw.update("FunctionMsgItem", paramf, "functionmsgid=?", new String[] { paramString })) });
          AppMethodBeat.o(35498);
          return;
          bool1 = false;
          break;
        }
        AppMethodBeat.o(35498);
      }
      catch (Exception paramString)
      {
        ab.e("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId error: %s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  /* Error */
  public static f asf(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 189
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 109
    //   10: invokestatic 112	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokestatic 195	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +10 -> 27
    //   20: ldc 189
    //   22: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aconst_null
    //   26: areturn
    //   27: ldc 115
    //   29: ldc 197
    //   31: iconst_1
    //   32: anewarray 119	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: aastore
    //   39: invokestatic 124	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: getstatic 83	com/tencent/mm/storage/ba:fnw	Lcom/tencent/mm/cg/h;
    //   45: ldc 97
    //   47: getstatic 58	com/tencent/mm/storage/ba:yNZ	[Ljava/lang/String;
    //   50: ldc 166
    //   52: iconst_1
    //   53: anewarray 52	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: aload_0
    //   59: aastore
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: iconst_2
    //   64: invokevirtual 200	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   67: astore_0
    //   68: aload_0
    //   69: checkcast 202	java/io/Closeable
    //   72: astore_2
    //   73: aload_0
    //   74: ifnonnull +6 -> 80
    //   77: invokestatic 81	a/f/b/j:ebi	()V
    //   80: aload_0
    //   81: invokeinterface 208 1 0
    //   86: ifeq +28 -> 114
    //   89: new 91	com/tencent/mm/api/f
    //   92: dup
    //   93: invokespecial 209	com/tencent/mm/api/f:<init>	()V
    //   96: astore_3
    //   97: aload_3
    //   98: aload_0
    //   99: invokevirtual 213	com/tencent/mm/api/f:convertFrom	(Landroid/database/Cursor;)V
    //   102: aload_2
    //   103: aconst_null
    //   104: invokestatic 218	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   107: ldc 189
    //   109: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_3
    //   113: areturn
    //   114: getstatic 224	a/y:BMg	La/y;
    //   117: astore_0
    //   118: aload_2
    //   119: aconst_null
    //   120: invokestatic 218	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   123: ldc 189
    //   125: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_1
    //   131: ldc 189
    //   133: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: aload_2
    //   140: aload_1
    //   141: invokestatic 218	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   144: ldc 189
    //   146: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_0
    //   150: athrow
    //   151: astore_0
    //   152: goto -13 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString	String
    //   1	1	1	localObject	Object
    //   130	11	1	localThrowable	java.lang.Throwable
    //   72	68	2	localCloseable	java.io.Closeable
    //   96	17	3	localf	f
    // Exception table:
    //   from	to	target	type
    //   77	80	130	java/lang/Throwable
    //   80	102	130	java/lang/Throwable
    //   114	118	130	java/lang/Throwable
    //   131	138	138	finally
    //   77	80	151	finally
    //   80	102	151	finally
    //   114	118	151	finally
  }
  
  /* Error */
  public static java.util.List<f> dxI()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 227
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 83	com/tencent/mm/storage/ba:fnw	Lcom/tencent/mm/cg/h;
    //   10: ldc 97
    //   12: getstatic 58	com/tencent/mm/storage/ba:yNZ	[Ljava/lang/String;
    //   15: ldc 229
    //   17: iconst_1
    //   18: anewarray 52	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc 231
    //   25: aastore
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: iconst_2
    //   30: invokevirtual 200	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   33: checkcast 202	java/io/Closeable
    //   36: astore_2
    //   37: aload_2
    //   38: checkcast 204	android/database/Cursor
    //   41: astore_0
    //   42: new 233	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 234	java/util/ArrayList:<init>	()V
    //   49: astore_3
    //   50: aload_0
    //   51: invokeinterface 208 1 0
    //   56: pop
    //   57: aload_0
    //   58: ldc 236
    //   60: invokestatic 72	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   63: aload_0
    //   64: invokeinterface 239 1 0
    //   69: ifne +56 -> 125
    //   72: new 91	com/tencent/mm/api/f
    //   75: dup
    //   76: invokespecial 209	com/tencent/mm/api/f:<init>	()V
    //   79: astore 4
    //   81: aload 4
    //   83: aload_0
    //   84: invokevirtual 213	com/tencent/mm/api/f:convertFrom	(Landroid/database/Cursor;)V
    //   87: aload_3
    //   88: aload 4
    //   90: invokevirtual 243	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_0
    //   95: invokeinterface 246 1 0
    //   100: pop
    //   101: goto -44 -> 57
    //   104: astore_1
    //   105: ldc 227
    //   107: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_1
    //   111: athrow
    //   112: astore_0
    //   113: aload_2
    //   114: aload_1
    //   115: invokestatic 218	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   118: ldc 227
    //   120: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_0
    //   124: athrow
    //   125: aload_3
    //   126: checkcast 248	java/util/List
    //   129: astore_0
    //   130: aload_2
    //   131: aconst_null
    //   132: invokestatic 218	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   135: ldc 227
    //   137: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_0
    //   141: areturn
    //   142: astore_0
    //   143: goto -30 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	54	0	localCursor	android.database.Cursor
    //   112	12	0	localObject1	Object
    //   129	12	0	localList	java.util.List
    //   142	1	0	localObject2	Object
    //   1	1	1	localObject3	Object
    //   104	11	1	localThrowable	java.lang.Throwable
    //   36	95	2	localCloseable	java.io.Closeable
    //   49	77	3	localArrayList	java.util.ArrayList
    //   79	10	4	localf	f
    // Exception table:
    //   from	to	target	type
    //   37	57	104	java/lang/Throwable
    //   57	101	104	java/lang/Throwable
    //   125	130	104	java/lang/Throwable
    //   105	112	112	finally
    //   37	57	142	finally
    //   57	101	142	finally
    //   125	130	142	finally
  }
  
  public static void dxJ()
  {
    AppMethodBeat.i(35500);
    int i = fnw.delete("FunctionMsgItem", "status=?", new String[] { "100" });
    int j = fnw.delete("FunctionMsgItem", "status=?", new String[] { "3" });
    ab.i("FunctionMsg.FunctionMsgStorage", "[deleteAllHandleFunctionMsg] ret1:" + i + " ret2:" + j);
    AppMethodBeat.o(35500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.ba
 * JD-Core Version:    0.7.0.1
 */