package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteQuery
  extends SQLiteProgram
{
  private static final String TAG = "WCDB.SQLiteQuery";
  private final CancellationSignal mCancellationSignal;
  
  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
    this.mCancellationSignal = paramCancellationSignal;
  }
  
  /* Error */
  final int fillWindow(com.tencent.wcdb.CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 3269
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 31	com/tencent/wcdb/database/SQLiteQuery:acquireReference	()V
    //   10: aload_1
    //   11: invokevirtual 34	com/tencent/wcdb/CursorWindow:acquireReference	()V
    //   14: aload_0
    //   15: invokevirtual 38	com/tencent/wcdb/database/SQLiteQuery:getSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   18: aload_0
    //   19: invokevirtual 42	com/tencent/wcdb/database/SQLiteQuery:getSql	()Ljava/lang/String;
    //   22: aload_0
    //   23: invokevirtual 46	com/tencent/wcdb/database/SQLiteQuery:getBindArgs	()[Ljava/lang/Object;
    //   26: aload_1
    //   27: iload_2
    //   28: iload_3
    //   29: iload 4
    //   31: aload_0
    //   32: invokevirtual 50	com/tencent/wcdb/database/SQLiteQuery:getConnectionFlags	()I
    //   35: aload_0
    //   36: getfield 16	com/tencent/wcdb/database/SQLiteQuery:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   39: invokevirtual 56	com/tencent/wcdb/database/SQLiteSession:executeForCursorWindow	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/CursorWindow;IIZILcom/tencent/wcdb/support/CancellationSignal;)I
    //   42: istore_2
    //   43: aload_1
    //   44: invokevirtual 59	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   47: aload_0
    //   48: invokevirtual 60	com/tencent/wcdb/database/SQLiteQuery:releaseReference	()V
    //   51: sipush 3269
    //   54: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: iload_2
    //   58: ireturn
    //   59: astore 5
    //   61: ldc 8
    //   63: new 65	java/lang/StringBuilder
    //   66: dup
    //   67: ldc 67
    //   69: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload 5
    //   74: invokevirtual 73	com/tencent/wcdb/database/SQLiteException:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 79
    //   82: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 42	com/tencent/wcdb/database/SQLiteQuery:getSql	()Ljava/lang/String;
    //   89: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 88	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: aload 5
    //   101: invokevirtual 92	com/tencent/wcdb/database/SQLiteQuery:checkCorruption	(Lcom/tencent/wcdb/database/SQLiteException;)V
    //   104: sipush 3269
    //   107: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload 5
    //   112: athrow
    //   113: astore 5
    //   115: aload_1
    //   116: invokevirtual 59	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   119: sipush 3269
    //   122: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload 5
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: invokevirtual 60	com/tencent/wcdb/database/SQLiteQuery:releaseReference	()V
    //   133: sipush 3269
    //   136: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	SQLiteQuery
    //   0	141	1	paramCursorWindow	com.tencent.wcdb.CursorWindow
    //   0	141	2	paramInt1	int
    //   0	141	3	paramInt2	int
    //   0	141	4	paramBoolean	boolean
    //   59	52	5	localSQLiteException	SQLiteException
    //   113	13	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	43	59	com/tencent/wcdb/database/SQLiteException
    //   14	43	113	finally
    //   61	113	113	finally
    //   10	14	128	finally
    //   43	47	128	finally
    //   115	128	128	finally
  }
  
  public final String toString()
  {
    AppMethodBeat.i(3270);
    String str = "SQLiteQuery: " + getSql();
    AppMethodBeat.o(3270);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteQuery
 * JD-Core Version:    0.7.0.1
 */