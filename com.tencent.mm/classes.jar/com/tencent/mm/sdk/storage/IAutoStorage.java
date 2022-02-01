package com.tencent.mm.sdk.storage;

import android.database.Cursor;

public abstract interface IAutoStorage<T extends IAutoDBItem>
{
  public abstract boolean delete(long paramLong);
  
  public abstract boolean delete(T paramT, boolean paramBoolean, String... paramVarArgs);
  
  public abstract boolean delete(T paramT, String... paramVarArgs);
  
  public abstract boolean deleteNotify(long paramLong, boolean paramBoolean);
  
  public abstract boolean execSQL(String paramString1, String paramString2);
  
  public abstract boolean get(long paramLong, T paramT);
  
  public abstract boolean get(T paramT, String... paramVarArgs);
  
  public abstract Cursor getAll();
  
  public abstract int getCount();
  
  public abstract boolean insert(T paramT);
  
  public abstract boolean insertNotify(T paramT, boolean paramBoolean);
  
  public abstract Cursor rawQuery(String paramString, String... paramVarArgs);
  
  public abstract boolean replace(T paramT);
  
  public abstract boolean update(long paramLong, T paramT);
  
  public abstract boolean update(long paramLong, T paramT, boolean paramBoolean);
  
  public abstract boolean update(T paramT, String... paramVarArgs);
  
  public abstract boolean updateNotify(T paramT, boolean paramBoolean, String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.IAutoStorage
 * JD-Core Version:    0.7.0.1
 */