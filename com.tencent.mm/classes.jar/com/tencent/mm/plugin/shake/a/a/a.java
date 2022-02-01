package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eHT;
  private static final int eSQ = "svrid".hashCode();
  private static final int eSV;
  private static final int eSW;
  private static final int eSX;
  private static final int eTG;
  private static final int eWa;
  private static final int eWo;
  private static final int feK;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private static final int yLs;
  private static final int yLt;
  private boolean __hadSettype = true;
  private boolean eCZ = true;
  private boolean eHQ = true;
  private boolean eSe = true;
  private boolean eSj = true;
  private boolean eSk = true;
  private boolean eSl = true;
  private boolean eTC = true;
  private boolean eVY = true;
  private boolean eWe = true;
  private boolean feB = true;
  public long field_createtime;
  public String field_desc;
  public String field_reserved1;
  public String field_reserved2;
  public int field_reserved3;
  public byte[] field_reservedBuf;
  public int field_status;
  public int field_subtype;
  public long field_svrid;
  public String field_tag;
  public String field_thumburl;
  public String field_title;
  public int field_type;
  private boolean yLq = true;
  private boolean yLr = true;
  
  static
  {
    eWa = "subtype".hashCode();
    feK = "createtime".hashCode();
    eWo = "tag".hashCode();
    eDc = "status".hashCode();
    eHT = "title".hashCode();
    eTG = "desc".hashCode();
    yLs = "thumburl".hashCode();
    eSV = "reserved1".hashCode();
    eSW = "reserved2".hashCode();
    eSX = "reserved3".hashCode();
    yLt = "reservedBuf".hashCode();
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
      if (eSQ != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.eSe = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eWa == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (feK == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (eWo == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eHT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eTG == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (yLs == k) {
        this.field_thumburl = paramCursor.getString(i);
      } else if (eSV == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (eSW == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (eSX == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (yLt == k) {
        this.field_reservedBuf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSe) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eVY) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.feB) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.eWe) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eTC) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.yLq) {
      localContentValues.put("thumburl", this.field_thumburl);
    }
    if (this.eSj) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.eSk) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.eSl) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.yLr) {
      localContentValues.put("reservedBuf", this.field_reservedBuf);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.a
 * JD-Core Version:    0.7.0.1
 */