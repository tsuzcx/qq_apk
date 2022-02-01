package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eJC;
  private static final int eUB = "svrid".hashCode();
  private static final int eUG;
  private static final int eUH;
  private static final int eUI;
  private static final int eVr;
  private static final int eXL;
  private static final int eXZ;
  private static final int fgF;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private static final int zbC;
  private static final int zbD;
  private boolean __hadSettype = true;
  private boolean eEI = true;
  private boolean eJz = true;
  private boolean eTP = true;
  private boolean eTU = true;
  private boolean eTV = true;
  private boolean eTW = true;
  private boolean eVn = true;
  private boolean eXJ = true;
  private boolean eXP = true;
  private boolean fgu = true;
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
  private boolean zbA = true;
  private boolean zbB = true;
  
  static
  {
    eXL = "subtype".hashCode();
    fgF = "createtime".hashCode();
    eXZ = "tag".hashCode();
    eEL = "status".hashCode();
    eJC = "title".hashCode();
    eVr = "desc".hashCode();
    zbC = "thumburl".hashCode();
    eUG = "reserved1".hashCode();
    eUH = "reserved2".hashCode();
    eUI = "reserved3".hashCode();
    zbD = "reservedBuf".hashCode();
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
      if (eUB != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.eTP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eXL == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (fgF == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (eXZ == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eJC == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eVr == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (zbC == k) {
        this.field_thumburl = paramCursor.getString(i);
      } else if (eUG == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (eUH == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (eUI == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (zbD == k) {
        this.field_reservedBuf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eTP) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eXJ) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.fgu) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.eXP) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eVn) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.zbA) {
      localContentValues.put("thumburl", this.field_thumburl);
    }
    if (this.eTU) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.eTV) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.eTW) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.zbB) {
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