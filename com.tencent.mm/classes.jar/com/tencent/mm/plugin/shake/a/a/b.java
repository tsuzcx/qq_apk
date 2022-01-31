package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class b
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhU = "username".hashCode();
  private static final int qMI = "lastshaketime".hashCode();
  private static final int qMJ = "isshowed".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhS;
  public boolean field_isshowed;
  public int field_lastshaketime;
  public String field_username;
  private boolean qMG;
  private boolean qMH;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (dhU != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.dhS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (qMI == k)
      {
        this.field_lastshaketime = paramCursor.getInt(i);
      }
      else
      {
        if (qMJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isshowed = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.qMG) {
      localContentValues.put("lastshaketime", Integer.valueOf(this.field_lastshaketime));
    }
    if (this.qMH) {
      localContentValues.put("isshowed", Boolean.valueOf(this.field_isshowed));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.b
 * JD-Core Version:    0.7.0.1
 */