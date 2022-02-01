package com.tencent.wcdb;

import com.tencent.wcdb.database.SQLiteDatabase;

public abstract interface DatabaseErrorHandler
{
  public abstract void onCorruption(SQLiteDatabase paramSQLiteDatabase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.DatabaseErrorHandler
 * JD-Core Version:    0.7.0.1
 */