package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCi;
  private static final int eCw;
  private static final int eJw;
  private static final int ejR;
  private static final int eoG;
  private static final int eyY = "svrid".hashCode();
  private static final int ezO;
  private static final int ezd;
  private static final int eze;
  private static final int ezf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private static final int wlr;
  private static final int wls;
  private boolean __hadSettype = true;
  private boolean eCg = true;
  private boolean eCm = true;
  private boolean eJn = true;
  private boolean ejO = true;
  private boolean eoD = true;
  private boolean eym = true;
  private boolean eyr = true;
  private boolean eys = true;
  private boolean eyt = true;
  private boolean ezK = true;
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
  private boolean wlp = true;
  private boolean wlq = true;
  
  static
  {
    eCi = "subtype".hashCode();
    eJw = "createtime".hashCode();
    eCw = "tag".hashCode();
    ejR = "status".hashCode();
    eoG = "title".hashCode();
    ezO = "desc".hashCode();
    wlr = "thumburl".hashCode();
    ezd = "reserved1".hashCode();
    eze = "reserved2".hashCode();
    ezf = "reserved3".hashCode();
    wls = "reservedBuf".hashCode();
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
      if (eyY != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.eym = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eCi == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (eJw == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (eCw == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eoG == k) {
        this.field_title = paramCursor.getString(i);
      } else if (ezO == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (wlr == k) {
        this.field_thumburl = paramCursor.getString(i);
      } else if (ezd == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (eze == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (ezf == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (wls == k) {
        this.field_reservedBuf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eym) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eCg) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.eJn) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.eCm) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.ezK) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.wlp) {
      localContentValues.put("thumburl", this.field_thumburl);
    }
    if (this.eyr) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.eys) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.eyt) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.wlq) {
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