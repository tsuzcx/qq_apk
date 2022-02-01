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
    AppMethodBeat.i(2945);
    this.mResultColumns = getColumnNames().length;
    AppMethodBeat.o(2945);
  }
  
  private static native int nativeCount(long paramLong);
  
  private static native int nativeFillRows(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  void acquire()
  {
    AppMethodBeat.i(2946);
    if (this.mPreparedStatement == null)
    {
      acquirePreparedStatement(true);
      this.mPreparedStatement.bindArguments(getBindArgs());
    }
    AppMethodBeat.o(2946);
  }
  
  int fillRows(ChunkedCursorWindow paramChunkedCursorWindow, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2948);
    acquire();
    if (paramChunkedCursorWindow.getNumColumns() != this.mResultColumns) {
      paramChunkedCursorWindow.setNumColumns(this.mResultColumns);
    }
    try
    {
      paramInt1 = nativeFillRows(this.mPreparedStatement.getPtr(), paramChunkedCursorWindow.mWindowPtr, paramInt1, paramInt2);
      AppMethodBeat.o(2948);
      return paramInt1;
    }
    catch (SQLiteException paramChunkedCursorWindow)
    {
      Log.e("WCDB.SQLiteAsyncQuery", "Got exception on fillRows: " + paramChunkedCursorWindow.getMessage() + ", SQL: " + getSql());
      checkCorruption(paramChunkedCursorWindow);
      AppMethodBeat.o(2948);
      throw paramChunkedCursorWindow;
    }
  }
  
  int getCount()
  {
    AppMethodBeat.i(2949);
    acquire();
    try
    {
      int i = nativeCount(this.mPreparedStatement.getPtr());
      AppMethodBeat.o(2949);
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e("WCDB.SQLiteAsyncQuery", "Got exception on getCount: " + localSQLiteException.getMessage() + ", SQL: " + getSql());
      checkCorruption(localSQLiteException);
      AppMethodBeat.o(2949);
      throw localSQLiteException;
    }
  }
  
  void release()
  {
    AppMethodBeat.i(2947);
    releasePreparedStatement();
    AppMethodBeat.o(2947);
  }
  
  void reset()
  {
    AppMethodBeat.i(2950);
    if (this.mPreparedStatement != null) {
      this.mPreparedStatement.reset(false);
    }
    AppMethodBeat.o(2950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteAsyncQuery
 * JD-Core Version:    0.7.0.1
 */