package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class a
  extends IAutoDBItem
{
  private static final int Dgu;
  private static final int Dgv = "reservedBuf".hashCode();
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fBC;
  private static final int fBo;
  private static final int fLi;
  private static final int fjl;
  private static final int fne;
  private static final int fyW;
  private static final int fyg = "svrid".hashCode();
  private static final int fyl;
  private static final int fym;
  private static final int fyn;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean Dgs = true;
  private boolean Dgt = true;
  private boolean __hadSettype = true;
  private boolean fBm = true;
  private boolean fBs = true;
  private boolean fKX = true;
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
  private boolean fji = true;
  private boolean fnb = true;
  private boolean fxA = true;
  private boolean fxB = true;
  private boolean fxu = true;
  private boolean fxz = true;
  private boolean fyS = true;
  
  static
  {
    fBo = "subtype".hashCode();
    fLi = "createtime".hashCode();
    fBC = "tag".hashCode();
    fjl = "status".hashCode();
    fne = "title".hashCode();
    fyW = "desc".hashCode();
    Dgu = "thumburl".hashCode();
    fyl = "reserved1".hashCode();
    fym = "reserved2".hashCode();
    fyn = "reserved3".hashCode();
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
      if (fyg != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.fxu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fBo == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (fLi == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (fBC == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (fyW == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (Dgu == k) {
        this.field_thumburl = paramCursor.getString(i);
      } else if (fyl == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (fym == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (fyn == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (Dgv == k) {
        this.field_reservedBuf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fxu) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fBm) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.fKX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.fBs) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fyS) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.Dgs) {
      localContentValues.put("thumburl", this.field_thumburl);
    }
    if (this.fxz) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.fxA) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.fxB) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.Dgt) {
      localContentValues.put("reservedBuf", this.field_reservedBuf);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.a
 * JD-Core Version:    0.7.0.1
 */