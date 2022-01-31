package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dDS;
  private static final int dfJ;
  private static final int dkj;
  private static final int dtY = "svrid".hashCode();
  private static final int duO;
  private static final int dud = "reserved1".hashCode();
  private static final int due = "reserved2".hashCode();
  private static final int duf = "reserved3".hashCode();
  private static final int dwY;
  private static final int dxm;
  private static final int qME;
  private static final int qMF = "reservedBuf".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dDN = true;
  private boolean dfG = true;
  private boolean dkg = true;
  private boolean dtl = true;
  private boolean dtq = true;
  private boolean dtr = true;
  private boolean dtt = true;
  private boolean duK = true;
  private boolean dwW = true;
  private boolean dxc = true;
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
  private boolean qMC = true;
  private boolean qMD = true;
  
  static
  {
    dwY = "subtype".hashCode();
    dDS = "createtime".hashCode();
    dxm = "tag".hashCode();
    dfJ = "status".hashCode();
    dkj = "title".hashCode();
    duO = "desc".hashCode();
    qME = "thumburl".hashCode();
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
      if (dtY != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.dtl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dwY == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (dDS == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (dxm == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dkj == k) {
        this.field_title = paramCursor.getString(i);
      } else if (duO == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (qME == k) {
        this.field_thumburl = paramCursor.getString(i);
      } else if (dud == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (due == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (duf == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (qMF == k) {
        this.field_reservedBuf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dtl) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dwW) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.dDN) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.dxc) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dkg) {
      localContentValues.put("title", this.field_title);
    }
    if (this.duK) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.qMC) {
      localContentValues.put("thumburl", this.field_thumburl);
    }
    if (this.dtq) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.dtr) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.dtt) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.qMD) {
      localContentValues.put("reservedBuf", this.field_reservedBuf);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.a
 * JD-Core Version:    0.7.0.1
 */