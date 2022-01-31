package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteAsyncQuery
  extends SQLiteProgram
{
  private static final String TAG = "WCDB.SQLiteAsyncQuery";
  private final int mResultColumns;
  
  public SQLiteAsyncQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
    AppMethodBeat.i(12264);
    this.mResultColumns = getColumnNames().length;
    AppMethodBeat.o(12264);
  }
  
  private static native int nativeCount(long paramLong);
  
  private static native int nativeFillRows(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  void acquire()
  {
    AppMethodBeat.i(12265);
    if (this.mPreparedStatement == null)
    {
      acquirePreparedStatement(true);
      this.mPreparedStatement.bindArguments(getBindArgs());
    }
    AppMethodBeat.o(12265);
  }
  
  int fillRows(ChunkedCursorWindow paramChunkedCursorWindow, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12267);
    acquire();
    if (paramChunkedCursorWindow.getNumColumns() != this.mResultColumns) {
      paramChunkedCursorWindow.setNumColumns(this.mResultColumns);
    }
    try
    {
      paramInt1 = nativeFillRows(this.mPreparedStatement.getPtr(), paramChunkedCursorWindow.mWindowPtr, paramInt1, paramInt2);
      AppMethodBeat.o(12267);
      return paramInt1;
    }
    catch (SQLiteException paramChunkedCursorWindow)
    {
      Log.e("WCDB.SQLiteAsyncQuery", "Got exception on fillRows: " + paramChunkedCursorWindow.getMessage() + ", SQL: " + getSql());
      checkCorruption(paramChunkedCursorWindow);
      AppMethodBeat.o(12267);
      throw paramChunkedCursorWindow;
    }
  }
  
  int getCount()
  {
    AppMethodBeat.i(12268);
    acquire();
    try
    {
      int i = nativeCount(this.mPreparedStatement.getPtr());
      AppMethodBeat.o(12268);
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e("WCDB.SQLiteAsyncQuery", "Got exception on getCount: " + localSQLiteException.getMessage() + ", SQL: " + getSql());
      checkCorruption(localSQLiteException);
      AppMethodBeat.o(12268);
      throw localSQLiteException;
    }
  }
  
  void release()
  {
    AppMethodBeat.i(12266);
    releasePreparedStatement();
    AppMethodBeat.o(12266);
  }
  
  void reset()
  {
    AppMethodBeat.i(12269);
    if (this.mPreparedStatement != null) {
      this.mPreparedStatement.reset(false);
    }
    AppMethodBeat.o(12269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncQuery
 * JD-Core Version:    0.7.0.1
 */