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
    AppMethodBeat.i(3256);
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
      AppMethodBeat.o(3256);
      return localObject;
    }
    catch (RuntimeException paramArrayOfObject)
    {
      if (paramCursorFactory != null) {
        paramCursorFactory.close();
      }
      AppMethodBeat.o(3256);
      throw paramArrayOfObject;
    }
  }
  
  public final void setBindArguments(String[] paramArrayOfString)
  {
    AppMethodBeat.i(3257);
    this.mQuery.bindAllArgsAsStrings(paramArrayOfString);
    AppMethodBeat.o(3257);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(3258);
    String str = "SQLiteDirectCursorDriver: " + this.mSql;
    AppMethodBeat.o(3258);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectCursorDriver
 * JD-Core Version:    0.7.0.1
 */