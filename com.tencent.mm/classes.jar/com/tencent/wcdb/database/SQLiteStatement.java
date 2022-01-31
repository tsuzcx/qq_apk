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
    AppMethodBeat.i(12629);
    execute(null);
    AppMethodBeat.o(12629);
  }
  
  public final void execute(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12630);
    acquireReference();
    try
    {
      getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return;
    }
    catch (SQLiteException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(12630);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12630);
    }
  }
  
  public final long executeInsert()
  {
    AppMethodBeat.i(12633);
    long l = executeInsert(null);
    AppMethodBeat.o(12633);
    return l;
  }
  
  public final long executeInsert(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12634);
    acquireReference();
    try
    {
      long l = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(12634);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12634);
    }
  }
  
  public final int executeUpdateDelete()
  {
    AppMethodBeat.i(12631);
    int i = executeUpdateDelete(null);
    AppMethodBeat.o(12631);
    return i;
  }
  
  public final int executeUpdateDelete(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12632);
    acquireReference();
    try
    {
      int i = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return i;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(12632);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12632);
    }
  }
  
  public final long simpleQueryForLong()
  {
    AppMethodBeat.i(12635);
    long l = simpleQueryForLong(null);
    AppMethodBeat.o(12635);
    return l;
  }
  
  public final long simpleQueryForLong(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12636);
    acquireReference();
    try
    {
      long l = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(12636);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12636);
    }
  }
  
  public final String simpleQueryForString()
  {
    AppMethodBeat.i(12637);
    String str = simpleQueryForString(null);
    AppMethodBeat.o(12637);
    return str;
  }
  
  public final String simpleQueryForString(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(12638);
    acquireReference();
    try
    {
      paramCancellationSignal = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return paramCancellationSignal;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      AppMethodBeat.o(12638);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
      AppMethodBeat.o(12638);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12639);
    String str = "SQLiteProgram: " + getSql();
    AppMethodBeat.o(12639);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteStatement
 * JD-Core Version:    0.7.0.1
 */