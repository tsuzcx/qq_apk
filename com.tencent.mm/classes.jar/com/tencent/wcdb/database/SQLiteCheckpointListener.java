package com.tencent.wcdb.database;

public abstract interface SQLiteCheckpointListener
{
  public abstract void onAttach(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void onDetach(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void onWALCommit(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCheckpointListener
 * JD-Core Version:    0.7.0.1
 */