package com.tencent.wcdb.database;

import java.util.List;

public abstract interface SQLiteTrace
{
  public abstract void onConnectionObtained(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean);
  
  public abstract void onConnectionPoolBusy(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean, List<TraceInfo<String>> paramList, List<TraceInfo<StackTraceElement[]>> paramList1);
  
  public abstract void onDatabaseCorrupted(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void onSQLExecuted(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, long paramLong);
  
  public static class TraceInfo<T>
  {
    public final T info;
    public final int tid;
    public final long time;
    
    TraceInfo(T paramT, long paramLong, int paramInt)
    {
      this.info = paramT;
      this.time = paramLong;
      this.tid = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteTrace
 * JD-Core Version:    0.7.0.1
 */