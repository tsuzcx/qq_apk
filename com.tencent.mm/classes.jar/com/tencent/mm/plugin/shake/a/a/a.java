package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBs = "svrid".hashCode();
  private static final int eBx;
  private static final int eBy;
  private static final int eBz;
  private static final int eCi;
  private static final int eEC;
  private static final int eEQ;
  private static final int eMo;
  private static final int elV;
  private static final int eqK;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private static final int xwH;
  private static final int xwI;
  private boolean __hadSettype = true;
  private boolean eAG = true;
  private boolean eAL = true;
  private boolean eAM = true;
  private boolean eAN = true;
  private boolean eCe = true;
  private boolean eEA = true;
  private boolean eEG = true;
  private boolean eMf = true;
  private boolean elS = true;
  private boolean eqH = true;
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
  private boolean xwF = true;
  private boolean xwG = true;
  
  static
  {
    eEC = "subtype".hashCode();
    eMo = "createtime".hashCode();
    eEQ = "tag".hashCode();
    elV = "status".hashCode();
    eqK = "title".hashCode();
    eCi = "desc".hashCode();
    xwH = "thumburl".hashCode();
    eBx = "reserved1".hashCode();
    eBy = "reserved2".hashCode();
    eBz = "reserved3".hashCode();
    xwI = "reservedBuf".hashCode();
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
      if (eBs != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.eAG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEC == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (eMo == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (eEQ == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eqK == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eCi == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (xwH == k) {
        this.field_thumburl = paramCursor.getString(i);
      } else if (eBx == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (eBy == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (eBz == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (xwI == k) {
        this.field_reservedBuf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eAG) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eEA) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.eMf) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.eEG) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eCe) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.xwF) {
      localContentValues.put("thumburl", this.field_thumburl);
    }
    if (this.eAL) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.eAM) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.eAN) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.xwG) {
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