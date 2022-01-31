package com.tencent.mm.storage;

import android.content.ContentValues;
import com.tencent.mm.cf.h;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;

public final class ba
  extends i<com.tencent.mm.api.e>
{
  private static final h dXo;
  private static final String[] uBN;
  public static final ba uBO = new ba();
  
  static
  {
    uBN = new String[] { "*", "rowid" };
    Object localObject = com.tencent.mm.kernel.g.DP();
    a.d.b.g.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Dv();
    if (localObject == null) {
      a.d.b.g.cUk();
    }
    dXo = (h)localObject;
  }
  
  private ba()
  {
    super((com.tencent.mm.sdk.e.e)locale.Dv(), com.tencent.mm.api.e.buS, "FunctionMsgItem", new String[] { "CREATE INDEX IF NOT EXISTS functionIdIndex ON FunctionMsgItem(functionmsgid)" });
  }
  
  public static void a(String paramString, com.tencent.mm.api.e parame)
  {
    a.d.b.g.k(paramString, "functionMsgId");
    a.d.b.g.k(parame, "newFunctionMsgItem");
    y.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s", new Object[] { paramString });
    Object localObject = abV(paramString);
    if (localObject != null) {}
    try
    {
      boolean bool1;
      if (parame.rS() == null)
      {
        bool1 = true;
        if (((com.tencent.mm.api.e)localObject).rS() != null) {
          break label176;
        }
      }
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        y.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s, newFunctionMsgItem.msgContent==null: %s,oldFunctionMsgItem.msgContent==null: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        parame = parame.vf();
        if ((parame.get("addMsg") == null) && (((com.tencent.mm.api.e)localObject).rS() != null))
        {
          localObject = ((com.tencent.mm.api.e)localObject).rS();
          if (localObject == null) {
            a.d.b.g.cUk();
          }
          parame.put("addMsg", ((cd)localObject).toByteArray());
        }
        y.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, ret: %s", new Object[] { Integer.valueOf(dXo.update("FunctionMsgItem", parame, "functionmsgid=?", new String[] { paramString })) });
        return;
        bool1 = false;
        break;
      }
      return;
    }
    catch (Exception paramString)
    {
      y.e("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId error: %s", new Object[] { paramString.getMessage() });
    }
  }
  
  /* Error */
  public static com.tencent.mm.api.e abV(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ldc 73
    //   5: invokestatic 76	a/d/b/g:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_0
    //   9: invokestatic 160	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   12: ifeq +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: ldc 80
    //   19: ldc 162
    //   21: iconst_1
    //   22: anewarray 84	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: aastore
    //   29: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: getstatic 51	com/tencent/mm/storage/ba:dXo	Lcom/tencent/mm/cf/h;
    //   35: ldc 62
    //   37: getstatic 26	com/tencent/mm/storage/ba:uBN	[Ljava/lang/String;
    //   40: ldc 132
    //   42: iconst_1
    //   43: anewarray 20	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: aload_0
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: iconst_2
    //   54: invokevirtual 165	com/tencent/mm/cf/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   57: astore_0
    //   58: aload_0
    //   59: checkcast 167	java/io/Closeable
    //   62: astore_2
    //   63: aload_0
    //   64: ifnonnull +6 -> 70
    //   67: invokestatic 49	a/d/b/g:cUk	()V
    //   70: aload_0
    //   71: invokeinterface 173 1 0
    //   76: ifeq +23 -> 99
    //   79: new 56	com/tencent/mm/api/e
    //   82: dup
    //   83: invokespecial 174	com/tencent/mm/api/e:<init>	()V
    //   86: astore_3
    //   87: aload_3
    //   88: aload_0
    //   89: invokevirtual 178	com/tencent/mm/api/e:d	(Landroid/database/Cursor;)V
    //   92: aload_2
    //   93: aconst_null
    //   94: invokestatic 183	a/c/a:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   97: aload_3
    //   98: areturn
    //   99: getstatic 189	a/n:xoh	La/n;
    //   102: astore_0
    //   103: aload_2
    //   104: aconst_null
    //   105: invokestatic 183	a/c/a:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_1
    //   111: aload_1
    //   112: athrow
    //   113: astore_0
    //   114: aload_2
    //   115: aload_1
    //   116: invokestatic 183	a/c/a:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   119: aload_0
    //   120: athrow
    //   121: astore_0
    //   122: goto -8 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   1	1	1	localObject	Object
    //   110	6	1	localThrowable	java.lang.Throwable
    //   62	53	2	localCloseable	java.io.Closeable
    //   86	12	3	locale	com.tencent.mm.api.e
    // Exception table:
    //   from	to	target	type
    //   67	70	110	java/lang/Throwable
    //   70	92	110	java/lang/Throwable
    //   99	103	110	java/lang/Throwable
    //   111	113	113	finally
    //   67	70	121	finally
    //   70	92	121	finally
    //   99	103	121	finally
  }
  
  /* Error */
  public static java.util.List<com.tencent.mm.api.e> cve()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 51	com/tencent/mm/storage/ba:dXo	Lcom/tencent/mm/cf/h;
    //   5: ldc 62
    //   7: getstatic 26	com/tencent/mm/storage/ba:uBN	[Ljava/lang/String;
    //   10: ldc 193
    //   12: iconst_1
    //   13: anewarray 20	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 195
    //   20: aastore
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: iconst_2
    //   25: invokevirtual 165	com/tencent/mm/cf/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   28: checkcast 167	java/io/Closeable
    //   31: astore_2
    //   32: aload_2
    //   33: checkcast 169	android/database/Cursor
    //   36: astore_0
    //   37: new 197	java/util/ArrayList
    //   40: dup
    //   41: invokespecial 198	java/util/ArrayList:<init>	()V
    //   44: astore_3
    //   45: aload_0
    //   46: invokeinterface 173 1 0
    //   51: pop
    //   52: aload_0
    //   53: ldc 200
    //   55: invokestatic 40	a/d/b/g:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   58: aload_0
    //   59: invokeinterface 203 1 0
    //   64: ifne +46 -> 110
    //   67: new 56	com/tencent/mm/api/e
    //   70: dup
    //   71: invokespecial 174	com/tencent/mm/api/e:<init>	()V
    //   74: astore 4
    //   76: aload 4
    //   78: aload_0
    //   79: invokevirtual 178	com/tencent/mm/api/e:d	(Landroid/database/Cursor;)V
    //   82: aload_3
    //   83: aload 4
    //   85: invokevirtual 207	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   88: pop
    //   89: aload_0
    //   90: invokeinterface 210 1 0
    //   95: pop
    //   96: goto -44 -> 52
    //   99: astore_1
    //   100: aload_1
    //   101: athrow
    //   102: astore_0
    //   103: aload_2
    //   104: aload_1
    //   105: invokestatic 183	a/c/a:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   108: aload_0
    //   109: athrow
    //   110: aload_3
    //   111: checkcast 212	java/util/List
    //   114: astore_0
    //   115: aload_2
    //   116: aconst_null
    //   117: invokestatic 183	a/c/a:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   120: aload_0
    //   121: areturn
    //   122: astore_0
    //   123: goto -20 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	54	0	localCursor	android.database.Cursor
    //   102	7	0	localObject1	Object
    //   114	7	0	localList	java.util.List
    //   122	1	0	localObject2	Object
    //   1	1	1	localObject3	Object
    //   99	6	1	localThrowable	java.lang.Throwable
    //   31	85	2	localCloseable	java.io.Closeable
    //   44	67	3	localArrayList	java.util.ArrayList
    //   74	10	4	locale	com.tencent.mm.api.e
    // Exception table:
    //   from	to	target	type
    //   32	52	99	java/lang/Throwable
    //   52	96	99	java/lang/Throwable
    //   110	115	99	java/lang/Throwable
    //   100	102	102	finally
    //   32	52	122	finally
    //   52	96	122	finally
    //   110	115	122	finally
  }
  
  public static void cvf()
  {
    int i = dXo.delete("FunctionMsgItem", "status=?", new String[] { "100" });
    int j = dXo.delete("FunctionMsgItem", "status=?", new String[] { "3" });
    y.i("FunctionMsg.FunctionMsgStorage", "[deleteAllHandleFunctionMsg] ret1:" + i + " ret2:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.ba
 * JD-Core Version:    0.7.0.1
 */