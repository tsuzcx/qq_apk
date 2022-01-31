package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c
  extends com.tencent.mm.sdk.e.c
{
  private static final int cOc = "createtime".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctF = "username".hashCode();
  private static final int cvZ;
  private static final int nYC = "deeplink".hashCode();
  private static final int nYD;
  private boolean cNX = true;
  private boolean ctD = true;
  private boolean cvV = true;
  public long field_createtime;
  public String field_deeplink;
  public String field_iconurl;
  public String field_title;
  public String field_username;
  private boolean nYA = true;
  private boolean nYB = true;
  
  static
  {
    cvZ = "title".hashCode();
    nYD = "iconurl".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (nYC == k) {
        this.field_deeplink = paramCursor.getString(i);
      } else if (cvZ == k) {
        this.field_title = paramCursor.getString(i);
      } else if (nYD == k) {
        this.field_iconurl = paramCursor.getString(i);
      } else if (cOc == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
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
    if (this.field_deeplink == null) {
      this.field_deeplink = "";
    }
    if (this.nYA) {
      localContentValues.put("deeplink", this.field_deeplink);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.field_iconurl == null) {
      this.field_iconurl = "";
    }
    if (this.nYB) {
      localContentValues.put("iconurl", this.field_iconurl);
    }
    if (this.cNX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.c
 * JD-Core Version:    0.7.0.1
 */