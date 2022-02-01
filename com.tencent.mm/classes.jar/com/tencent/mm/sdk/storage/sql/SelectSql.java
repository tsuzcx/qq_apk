package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.sql.SqlObj;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/storage/sql/SelectSql;", "Lcom/tencent/mm/sdk/sql/SqlObj;", "sql", "", "params", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "multiQuery", "", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clazz", "Ljava/lang/Class;", "singleQuery", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Ljava/lang/Class;)Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Builder", "wechat-sdk_release"})
public final class SelectSql
  extends SqlObj
{
  public SelectSql(String paramString, String[] paramArrayOfString)
  {
    super(paramString, paramArrayOfString);
    AppMethodBeat.i(192795);
    AppMethodBeat.o(192795);
  }
  
  /* Error */
  public final <T extends com.tencent.mm.sdk.storage.IAutoDBItem> java.util.List<T> multiQuery(com.tencent.mm.sdk.storage.ISQLiteDatabase paramISQLiteDatabase, java.lang.Class<T> paramClass)
  {
    // Byte code:
    //   0: ldc 55
    //   2: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ldc 56
    //   8: invokestatic 38	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: new 58	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 61	java/util/ArrayList:<init>	()V
    //   18: astore 4
    //   20: aload_1
    //   21: ifnull +108 -> 129
    //   24: aload_1
    //   25: aload_0
    //   26: invokevirtual 65	com/tencent/mm/sdk/storage/sql/SelectSql:toSql	()Ljava/lang/String;
    //   29: aload_0
    //   30: invokevirtual 68	com/tencent/mm/sdk/storage/sql/SelectSql:params	()[Ljava/lang/String;
    //   33: invokeinterface 74 3 0
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +89 -> 129
    //   43: aload_1
    //   44: checkcast 76	java/io/Closeable
    //   47: astore_3
    //   48: aload_3
    //   49: checkcast 78	android/database/Cursor
    //   52: astore_1
    //   53: aload_1
    //   54: invokeinterface 82 1 0
    //   59: ifeq +61 -> 120
    //   62: aload_2
    //   63: invokevirtual 88	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   66: astore 5
    //   68: aload 5
    //   70: ldc 90
    //   72: invokestatic 93	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload 5
    //   77: checkcast 95	com/tencent/mm/sdk/storage/IAutoDBItem
    //   80: astore 5
    //   82: aload 5
    //   84: aload_1
    //   85: invokevirtual 99	com/tencent/mm/sdk/storage/IAutoDBItem:convertFrom	(Landroid/database/Cursor;)V
    //   88: aload 4
    //   90: aload 5
    //   92: invokevirtual 103	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   95: pop
    //   96: goto -43 -> 53
    //   99: astore_2
    //   100: ldc 55
    //   102: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: athrow
    //   107: astore_1
    //   108: aload_3
    //   109: aload_2
    //   110: invokestatic 109	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   113: ldc 55
    //   115: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: athrow
    //   120: getstatic 115	kotlin/x:aazN	Lkotlin/x;
    //   123: astore_1
    //   124: aload_3
    //   125: aconst_null
    //   126: invokestatic 109	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   129: aload 4
    //   131: checkcast 117	java/util/List
    //   134: astore_1
    //   135: ldc 55
    //   137: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: goto -37 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	SelectSql
    //   0	148	1	paramISQLiteDatabase	com.tencent.mm.sdk.storage.ISQLiteDatabase
    //   0	148	2	paramClass	java.lang.Class<T>
    //   47	78	3	localCloseable	java.io.Closeable
    //   18	112	4	localArrayList	java.util.ArrayList
    //   66	25	5	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   48	53	99	java/lang/Throwable
    //   53	96	99	java/lang/Throwable
    //   120	124	99	java/lang/Throwable
    //   100	107	107	finally
    //   48	53	142	finally
    //   53	96	142	finally
    //   120	124	142	finally
  }
  
  /* Error */
  public final <T extends com.tencent.mm.sdk.storage.IAutoDBItem> T singleQuery(com.tencent.mm.sdk.storage.ISQLiteDatabase paramISQLiteDatabase, java.lang.Class<T> paramClass)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 120
    //   4: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ldc 56
    //   10: invokestatic 38	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ifnull +87 -> 101
    //   17: aload_1
    //   18: aload_0
    //   19: invokevirtual 65	com/tencent/mm/sdk/storage/sql/SelectSql:toSql	()Ljava/lang/String;
    //   22: aload_0
    //   23: invokevirtual 68	com/tencent/mm/sdk/storage/sql/SelectSql:params	()[Ljava/lang/String;
    //   26: invokeinterface 74 3 0
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +68 -> 101
    //   36: aload_1
    //   37: checkcast 76	java/io/Closeable
    //   40: astore 4
    //   42: aload 4
    //   44: checkcast 78	android/database/Cursor
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 88	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   52: astore_2
    //   53: aload_2
    //   54: ldc 90
    //   56: invokestatic 93	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   59: aload_2
    //   60: checkcast 95	com/tencent/mm/sdk/storage/IAutoDBItem
    //   63: astore_2
    //   64: aload_1
    //   65: invokeinterface 82 1 0
    //   70: ifeq +21 -> 91
    //   73: aload_2
    //   74: aload_1
    //   75: invokevirtual 99	com/tencent/mm/sdk/storage/IAutoDBItem:convertFrom	(Landroid/database/Cursor;)V
    //   78: aload 4
    //   80: aconst_null
    //   81: invokestatic 109	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   84: ldc 120
    //   86: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_2
    //   90: areturn
    //   91: getstatic 115	kotlin/x:aazN	Lkotlin/x;
    //   94: astore_1
    //   95: aload 4
    //   97: aconst_null
    //   98: invokestatic 109	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   101: ldc 120
    //   103: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_2
    //   109: ldc 120
    //   111: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_2
    //   115: athrow
    //   116: astore_1
    //   117: aload 4
    //   119: aload_2
    //   120: invokestatic 109	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   123: ldc 120
    //   125: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aload_3
    //   132: astore_2
    //   133: goto -16 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	SelectSql
    //   0	136	1	paramISQLiteDatabase	com.tencent.mm.sdk.storage.ISQLiteDatabase
    //   0	136	2	paramClass	java.lang.Class<T>
    //   1	131	3	localObject	java.lang.Object
    //   40	78	4	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   42	78	108	java/lang/Throwable
    //   91	95	108	java/lang/Throwable
    //   109	116	116	finally
    //   42	78	130	finally
    //   91	95	130	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.SelectSql
 * JD-Core Version:    0.7.0.1
 */