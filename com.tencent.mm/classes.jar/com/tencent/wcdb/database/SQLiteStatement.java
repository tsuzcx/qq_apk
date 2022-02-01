package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteStatement
  extends SQLiteProgram
{
  SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, null);
  }
  
  public final void execute()
  {
    AppMethodBeat.i(3315);
    execute(null);
    AppMethodBeat.o(3315);
  }
  
  public final void execute(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3316);
    acquireReference();
    try
    {
      getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return;
    }
    catch (SQLiteException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(3316);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3316);
    }
  }
  
  public final long executeInsert()
  {
    AppMethodBeat.i(3319);
    long l = executeInsert(null);
    AppMethodBeat.o(3319);
    return l;
  }
  
  public final long executeInsert(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3320);
    acquireReference();
    try
    {
      long l = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(3320);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3320);
    }
  }
  
  public final int executeUpdateDelete()
  {
    AppMethodBeat.i(3317);
    int i = executeUpdateDelete(null);
    AppMethodBeat.o(3317);
    return i;
  }
  
  public final int executeUpdateDelete(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3318);
    acquireReference();
    try
    {
      int i = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return i;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(3318);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3318);
    }
  }
  
  public final long simpleQueryForLong()
  {
    AppMethodBeat.i(3321);
    long l = simpleQueryForLong(null);
    AppMethodBeat.o(3321);
    return l;
  }
  
  public final long simpleQueryForLong(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3322);
    acquireReference();
    try
    {
      long l = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(3322);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3322);
    }
  }
  
  public final String simpleQueryForString()
  {
    AppMethodBeat.i(3323);
    String str = simpleQueryForString(null);
    AppMethodBeat.o(3323);
    return str;
  }
  
  public final String simpleQueryForString(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3324);
    acquireReference();
    try
    {
      paramCancellationSignal = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return paramCancellationSignal;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(3324);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(3324);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(3325);
    String str = "SQLiteProgram: " + getSql();
    AppMethodBeat.o(3325);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteStatement
 * JD-Core Version:    0.7.0.1
 */