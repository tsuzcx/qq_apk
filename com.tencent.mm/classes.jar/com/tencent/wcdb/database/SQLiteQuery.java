package com.tencent.wcdb.database;

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
    //   0: aload_0
    //   1: invokevirtual 25	com/tencent/wcdb/database/SQLiteQuery:acquireReference	()V
    //   4: aload_1
    //   5: invokevirtual 28	com/tencent/wcdb/CursorWindow:acquireReference	()V
    //   8: aload_0
    //   9: invokevirtual 32	com/tencent/wcdb/database/SQLiteQuery:getSession	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   12: aload_0
    //   13: invokevirtual 36	com/tencent/wcdb/database/SQLiteQuery:getSql	()Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 40	com/tencent/wcdb/database/SQLiteQuery:getBindArgs	()[Ljava/lang/Object;
    //   20: aload_1
    //   21: iload_2
    //   22: iload_3
    //   23: iload 4
    //   25: aload_0
    //   26: invokevirtual 44	com/tencent/wcdb/database/SQLiteQuery:getConnectionFlags	()I
    //   29: aload_0
    //   30: getfield 16	com/tencent/wcdb/database/SQLiteQuery:mCancellationSignal	Lcom/tencent/wcdb/support/CancellationSignal;
    //   33: invokevirtual 50	com/tencent/wcdb/database/SQLiteSession:executeForCursorWindow	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/CursorWindow;IIZILcom/tencent/wcdb/support/CancellationSignal;)I
    //   36: istore_2
    //   37: aload_1
    //   38: invokevirtual 53	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   41: aload_0
    //   42: invokevirtual 54	com/tencent/wcdb/database/SQLiteQuery:releaseReference	()V
    //   45: iload_2
    //   46: ireturn
    //   47: astore 5
    //   49: ldc 8
    //   51: new 56	java/lang/StringBuilder
    //   54: dup
    //   55: ldc 58
    //   57: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload 5
    //   62: invokevirtual 64	com/tencent/wcdb/database/SQLiteException:getMessage	()Ljava/lang/String;
    //   65: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 70
    //   70: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: invokevirtual 36	com/tencent/wcdb/database/SQLiteQuery:getSql	()Ljava/lang/String;
    //   77: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 79	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: aload 5
    //   89: invokevirtual 83	com/tencent/wcdb/database/SQLiteQuery:checkCorruption	(Lcom/tencent/wcdb/database/SQLiteException;)V
    //   92: aload 5
    //   94: athrow
    //   95: astore 5
    //   97: aload_1
    //   98: invokevirtual 53	com/tencent/wcdb/CursorWindow:releaseReference	()V
    //   101: aload 5
    //   103: athrow
    //   104: astore_1
    //   105: aload_0
    //   106: invokevirtual 54	com/tencent/wcdb/database/SQLiteQuery:releaseReference	()V
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	SQLiteQuery
    //   0	111	1	paramCursorWindow	com.tencent.wcdb.CursorWindow
    //   0	111	2	paramInt1	int
    //   0	111	3	paramInt2	int
    //   0	111	4	paramBoolean	boolean
    //   47	46	5	localSQLiteException	SQLiteException
    //   95	7	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	37	47	com/tencent/wcdb/database/SQLiteException
    //   8	37	95	finally
    //   49	95	95	finally
    //   4	8	104	finally
    //   37	41	104	finally
    //   97	104	104	finally
  }
  
  public final String toString()
  {
    return "SQLiteQuery: " + getSql();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteQuery
 * JD-Core Version:    0.7.0.1
 */