package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class c
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final Column Jmf;
  private static final int Jmi;
  private static final int Jmj = "iconurl".hashCode();
  public static final SingleTable TABLE = new SingleTable("ShakeTvHistory");
  public static final Column hsa;
  private static final int hsg;
  public static final Column iOa;
  private static final int icG = "createtime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean Jmg = true;
  private boolean Jmh = true;
  private boolean __hadSetusername = true;
  public long field_createtime;
  public String field_deeplink;
  public String field_iconurl;
  public String field_title;
  public String field_username;
  private boolean hsd = true;
  private boolean icv = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ShakeTvHistory", "");
    C_USERNAME = new Column("username", "string", "ShakeTvHistory", "");
    Jmf = new Column("deeplink", "string", "ShakeTvHistory", "");
    hsa = new Column("title", "string", "ShakeTvHistory", "");
    iOa = new Column("iconurl", "string", "ShakeTvHistory", "");
    C_CREATETIME = new Column("createtime", "long", "ShakeTvHistory", "");
    username_HASHCODE = "username".hashCode();
    Jmi = "deeplink".hashCode();
    hsg = "title".hashCode();
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
      if (Jmi == k) {
        this.field_deeplink = paramCursor.getString(i);
      } else if (hsg == k) {
        this.field_title = paramCursor.getString(i);
      } else if (Jmj == k) {
        this.field_iconurl = paramCursor.getString(i);
      } else if (icG == k) {
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
    if (this.Jmg) {
      localContentValues.put("deeplink", this.field_deeplink);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.field_iconurl == null) {
      this.field_iconurl = "";
    }
    if (this.Jmh) {
      localContentValues.put("iconurl", this.field_iconurl);
    }
    if (this.icv) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "ShakeTvHistory";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.c
 * JD-Core Version:    0.7.0.1
 */