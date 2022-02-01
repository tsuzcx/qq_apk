package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;

public abstract interface ISQLiteDatabase
{
  public static final int CURSOR_ASYNC = 3;
  public static final int CURSOR_DEFAULT = 0;
  public static final int CURSOR_HEAP = 4;
  public static final int CURSOR_IMMEDIATE = 2;
  public static final int CURSOR_WINDOWED = 1;
  
  public abstract int delete(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract boolean execSQL(String paramString1, String paramString2);
  
  public abstract long insert(String paramString1, String paramString2, ContentValues paramContentValues);
  
  public abstract long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues);
  
  public abstract boolean isClose();
  
  public abstract Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5);
  
  public abstract Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt);
  
  public abstract Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6);
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString, int paramInt);
  
  public abstract long replace(String paramString1, String paramString2, ContentValues paramContentValues);
  
  public abstract int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.ISQLiteDatabase
 * JD-Core Version:    0.7.0.1
 */