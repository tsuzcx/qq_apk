package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteDirectCursorDriver
  implements SQLiteCursorDriver
{
  private static SQLiteDatabase.CursorFactory DEFAULT_FACTORY = SQLiteCursor.FACTORY;
  private final CancellationSignal mCancellationSignal;
  private final SQLiteDatabase mDatabase;
  private final String mEditTable;
  private SQLiteProgram mQuery;
  private final String mSql;
  
  public SQLiteDirectCursorDriver(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, CancellationSignal paramCancellationSignal)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mEditTable = paramString2;
    this.mSql = paramString1;
    this.mCancellationSignal = paramCancellationSignal;
  }
  
  public final void cursorClosed() {}
  
  public final void cursorDeactivated() {}
  
  public final void cursorRequeried(Cursor paramCursor) {}
  
  public final Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(12570);
    Object localObject = paramCursorFactory;
    if (paramCursorFactory == null) {
      localObject = DEFAULT_FACTORY;
    }
    paramCursorFactory = null;
    try
    {
      paramArrayOfObject = ((SQLiteDatabase.CursorFactory)localObject).newQuery(this.mDatabase, this.mSql, paramArrayOfObject, this.mCancellationSignal);
      paramCursorFactory = paramArrayOfObject;
      localObject = ((SQLiteDatabase.CursorFactory)localObject).newCursor(this.mDatabase, this, this.mEditTable, paramArrayOfObject);
      this.mQuery = paramArrayOfObject;
      AppMethodBeat.o(12570);
      return localObject;
    }
    catch (RuntimeException paramArrayOfObject)
    {
      if (paramCursorFactory != null) {
        paramCursorFactory.close();
      }
      AppMethodBeat.o(12570);
      throw paramArrayOfObject;
    }
  }
  
  public final void setBindArguments(String[] paramArrayOfString)
  {
    AppMethodBeat.i(12571);
    this.mQuery.bindAllArgsAsStrings(paramArrayOfString);
    AppMethodBeat.o(12571);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12572);
    String str = "SQLiteDirectCursorDriver: " + this.mSql;
    AppMethodBeat.o(12572);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectCursorDriver
 * JD-Core Version:    0.7.0.1
 */