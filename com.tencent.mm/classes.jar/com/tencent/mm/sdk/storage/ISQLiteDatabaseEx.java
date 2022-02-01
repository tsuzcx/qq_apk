package com.tencent.mm.sdk.storage;

public abstract interface ISQLiteDatabaseEx
  extends ISQLiteDatabase
{
  public abstract long beginTransaction(long paramLong);
  
  public abstract void close();
  
  public abstract int endTransaction(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.ISQLiteDatabaseEx
 * JD-Core Version:    0.7.0.1
 */