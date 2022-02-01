package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c
  extends com.tencent.mm.sdk.e.c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJw = "createtime".hashCode();
  private static final int eme = "username".hashCode();
  private static final int eoG;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int wlA;
  private static final int wlz = "deeplink".hashCode();
  private boolean eJn = true;
  private boolean emb = true;
  private boolean eoD = true;
  public long field_createtime;
  public String field_deeplink;
  public String field_iconurl;
  public String field_title;
  public String field_username;
  private boolean wlx = true;
  private boolean wly = true;
  
  static
  {
    eoG = "title".hashCode();
    wlA = "iconurl".hashCode();
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
      if (eme != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.emb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (wlz == k) {
        this.field_deeplink = paramCursor.getString(i);
      } else if (eoG == k) {
        this.field_title = paramCursor.getString(i);
      } else if (wlA == k) {
        this.field_iconurl = paramCursor.getString(i);
      } else if (eJw == k) {
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
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_deeplink == null) {
      this.field_deeplink = "";
    }
    if (this.wlx) {
      localContentValues.put("deeplink", this.field_deeplink);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.field_iconurl == null) {
      this.field_iconurl = "";
    }
    if (this.wly) {
      localContentValues.put("iconurl", this.field_iconurl);
    }
    if (this.eJn) {
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