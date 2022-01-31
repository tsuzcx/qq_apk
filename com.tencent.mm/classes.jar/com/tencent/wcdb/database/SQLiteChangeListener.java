package com.tencent.wcdb.database;

public abstract interface SQLiteChangeListener
{
  public abstract void onChange(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteChangeListener
 * JD-Core Version:    0.7.0.1
 */