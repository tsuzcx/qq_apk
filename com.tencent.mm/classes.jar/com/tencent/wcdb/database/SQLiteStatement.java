package com.tencent.wcdb.database;

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
    execute(null);
  }
  
  public final void execute(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return;
    }
    catch (SQLiteException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final long executeInsert()
  {
    return executeInsert(null);
  }
  
  public final long executeInsert(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      long l = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final int executeUpdateDelete()
  {
    return executeUpdateDelete(null);
  }
  
  public final int executeUpdateDelete(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      int i = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return i;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final long simpleQueryForLong()
  {
    return simpleQueryForLong(null);
  }
  
  public final long simpleQueryForLong(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      long l = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return l;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final String simpleQueryForString()
  {
    return simpleQueryForString(null);
  }
  
  public final String simpleQueryForString(CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      paramCancellationSignal = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), paramCancellationSignal);
      return paramCancellationSignal;
    }
    catch (SQLiteDatabaseCorruptException paramCancellationSignal)
    {
      checkCorruption(paramCancellationSignal);
      throw paramCancellationSignal;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public final String toString()
  {
    return "SQLiteProgram: " + getSql();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteStatement
 * JD-Core Version:    0.7.0.1
 */