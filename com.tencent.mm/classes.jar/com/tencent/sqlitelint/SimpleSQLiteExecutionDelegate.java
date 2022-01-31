package com.tencent.sqlitelint;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;

public final class SimpleSQLiteExecutionDelegate
  implements ISQLiteExecutionDelegate
{
  private static final String TAG = "SQLiteLint.SimpleSQLiteExecutionDelegate";
  private final SQLiteDatabase mDb;
  
  static
  {
    AppMethodBeat.i(94035);
    if (!SimpleSQLiteExecutionDelegate.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(94035);
      return;
    }
  }
  
  public SimpleSQLiteExecutionDelegate(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(94032);
    if ((!$assertionsDisabled) && (paramSQLiteDatabase == null))
    {
      paramSQLiteDatabase = new AssertionError();
      AppMethodBeat.o(94032);
      throw paramSQLiteDatabase;
    }
    this.mDb = paramSQLiteDatabase;
    AppMethodBeat.o(94032);
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(94034);
    if (!this.mDb.isOpen())
    {
      SLog.w("SQLiteLint.SimpleSQLiteExecutionDelegate", "rawQuery db close", new Object[0]);
      AppMethodBeat.o(94034);
      return;
    }
    this.mDb.execSQL(paramString);
    AppMethodBeat.o(94034);
  }
  
  public final Cursor rawQuery(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(94033);
    if (!this.mDb.isOpen())
    {
      SLog.w("SQLiteLint.SimpleSQLiteExecutionDelegate", "rawQuery db close", new Object[0]);
      AppMethodBeat.o(94033);
      return null;
    }
    paramString = this.mDb.rawQuery(paramString, paramVarArgs);
    AppMethodBeat.o(94033);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.SimpleSQLiteExecutionDelegate
 * JD-Core Version:    0.7.0.1
 */