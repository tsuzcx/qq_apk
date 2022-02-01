package com.tencent.sqlitelint;

import android.database.Cursor;

public abstract interface ISQLiteExecutionDelegate
{
  public abstract void execSQL(String paramString);
  
  public abstract Cursor rawQuery(String paramString, String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.ISQLiteExecutionDelegate
 * JD-Core Version:    0.7.0.1
 */