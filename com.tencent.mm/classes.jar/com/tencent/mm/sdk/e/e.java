package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;

public abstract interface e
{
  public abstract Cursor a(String paramString, String[] paramArrayOfString, int paramInt);
  
  public abstract Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt);
  
  public abstract int delete(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract boolean execSQL(String paramString1, String paramString2);
  
  public abstract boolean fqe();
  
  public abstract long insert(String paramString1, String paramString2, ContentValues paramContentValues);
  
  public abstract Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5);
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
  
  public abstract long replace(String paramString1, String paramString2, ContentValues paramContentValues);
  
  public abstract int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.e
 * JD-Core Version:    0.7.0.1
 */