package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  private static final int cFD;
  private static final int cFI;
  private static final int cFJ;
  private static final int cFK;
  private static final int cGk;
  private static final int cIC;
  private static final int cIo;
  private static final int cOc;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csy;
  private static final int cvZ;
  private static final int nYu;
  private static final int nYv;
  private boolean cFa = true;
  private boolean cFf = true;
  private boolean cFg = true;
  private boolean cFh = true;
  private boolean cGg = true;
  private boolean cIm = true;
  private boolean cIs = true;
  private boolean cNX = true;
  private boolean crk = true;
  private boolean csa = true;
  private boolean cvV = true;
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
  private boolean nYs = true;
  private boolean nYt = true;
  
  static
  {
    cFD = "svrid".hashCode();
    csy = "type".hashCode();
    cIo = "subtype".hashCode();
    cOc = "createtime".hashCode();
    cIC = "tag".hashCode();
    crn = "status".hashCode();
    cvZ = "title".hashCode();
    cGk = "desc".hashCode();
    nYu = "thumburl".hashCode();
    cFI = "reserved1".hashCode();
    cFJ = "reserved2".hashCode();
    cFK = "reserved3".hashCode();
    nYv = "reservedBuf".hashCode();
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
      if (cFD != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.cFa = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (cIo == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (cOc == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (cIC == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cvZ == k) {
        this.field_title = paramCursor.getString(i);
      } else if (cGk == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (nYu == k) {
        this.field_thumburl = paramCursor.getString(i);
      } else if (cFI == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (cFJ == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (cFK == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (nYv == k) {
        this.field_reservedBuf = paramCursor.getBlob(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cFa) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cIm) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.cNX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.cIs) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.cGg) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.nYs) {
      localContentValues.put("thumburl", this.field_thumburl);
    }
    if (this.cFf) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.cFg) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.cFh) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.nYt) {
      localContentValues.put("reservedBuf", this.field_reservedBuf);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.a
 * JD-Core Version:    0.7.0.1
 */