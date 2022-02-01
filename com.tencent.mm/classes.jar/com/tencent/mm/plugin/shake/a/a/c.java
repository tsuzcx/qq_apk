package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class c
  extends IAutoDBItem
{
  private static final int DgC;
  private static final int DgD = "iconurl".hashCode();
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fLi = "createtime".hashCode();
  private static final int fne;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean DgA = true;
  private boolean DgB = true;
  private boolean __hadSetusername = true;
  private boolean fKX = true;
  public long field_createtime;
  public String field_deeplink;
  public String field_iconurl;
  public String field_title;
  public String field_username;
  private boolean fnb = true;
  
  static
  {
    DgC = "deeplink".hashCode();
    fne = "title".hashCode();
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (DgC == k) {
        this.field_deeplink = paramCursor.getString(i);
      } else if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (DgD == k) {
        this.field_iconurl = paramCursor.getString(i);
      } else if (fLi == k) {
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
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_deeplink == null) {
      this.field_deeplink = "";
    }
    if (this.DgA) {
      localContentValues.put("deeplink", this.field_deeplink);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.field_iconurl == null) {
      this.field_iconurl = "";
    }
    if (this.DgB) {
      localContentValues.put("iconurl", this.field_iconurl);
    }
    if (this.fKX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.c
 * JD-Core Version:    0.7.0.1
 */