package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class b
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctF = "username".hashCode();
  private static final int nYy = "lastshaketime".hashCode();
  private static final int nYz = "isshowed".hashCode();
  private boolean ctD;
  public boolean field_isshowed;
  public int field_lastshaketime;
  public String field_username;
  private boolean nYw;
  private boolean nYx;
  
  public final void d(Cursor paramCursor)
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
      if (ctF != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.ctD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (nYy == k)
      {
        this.field_lastshaketime = paramCursor.getInt(i);
      }
      else
      {
        if (nYz == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isshowed = bool;
            break;
          }
        }
        if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.nYw) {
      localContentValues.put("lastshaketime", Integer.valueOf(this.field_lastshaketime));
    }
    if (this.nYx) {
      localContentValues.put("isshowed", Boolean.valueOf(this.field_isshowed));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.b
 * JD-Core Version:    0.7.0.1
 */