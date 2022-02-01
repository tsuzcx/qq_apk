package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c
  extends com.tencent.mm.sdk.e.c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY = "username".hashCode();
  private static final int eJC;
  private static final int fgF = "createtime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int zbK = "deeplink".hashCode();
  private static final int zbL;
  private boolean eGV = true;
  private boolean eJz = true;
  private boolean fgu = true;
  public long field_createtime;
  public String field_deeplink;
  public String field_iconurl;
  public String field_title;
  public String field_username;
  private boolean zbI = true;
  private boolean zbJ = true;
  
  static
  {
    eJC = "title".hashCode();
    zbL = "iconurl".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eGY != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eGV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (zbK == k) {
        this.field_deeplink = paramCursor.getString(i);
      } else if (eJC == k) {
        this.field_title = paramCursor.getString(i);
      } else if (zbL == k) {
        this.field_iconurl = paramCursor.getString(i);
      } else if (fgF == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_deeplink == null) {
      this.field_deeplink = "";
    }
    if (this.zbI) {
      localContentValues.put("deeplink", this.field_deeplink);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.field_iconurl == null) {
      this.field_iconurl = "";
    }
    if (this.zbJ) {
      localContentValues.put("iconurl", this.field_iconurl);
    }
    if (this.fgu) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.c
 * JD-Core Version:    0.7.0.1
 */