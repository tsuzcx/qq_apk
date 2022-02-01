package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class a
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_SUBTYPE;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final Column JlW;
  private static final int JlZ;
  private static final int Jma = "reservedBuf".hashCode();
  public static final SingleTable TABLE = new SingleTable("ShakeMessage");
  public static final Column hGX;
  public static final Column hHc;
  public static final Column hHd;
  public static final Column hHe;
  public static final Column hHm;
  private static final int hIE;
  private static final int hIF;
  private static final int hIG;
  private static final int hIz;
  public static final Column hJn;
  private static final int hJv;
  private static final int hMP;
  public static final Column hMT;
  private static final int hNn;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hsa;
  private static final int hsg;
  private static final int icG;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean JlX = true;
  private boolean JlY = true;
  private boolean __hadSettype = true;
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
  private boolean hHL = true;
  private boolean hHQ = true;
  private boolean hHR = true;
  private boolean hHS = true;
  private boolean hJr = true;
  private boolean hMN = true;
  private boolean hNd = true;
  private boolean hmz = true;
  private boolean hsd = true;
  private boolean icv = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ShakeMessage", "");
    hGX = new Column("svrid", "long", "ShakeMessage", "");
    C_TYPE = new Column("type", "int", "ShakeMessage", "");
    C_SUBTYPE = new Column("subtype", "int", "ShakeMessage", "");
    C_CREATETIME = new Column("createtime", "long", "ShakeMessage", "");
    hMT = new Column("tag", "string", "ShakeMessage", "");
    hmw = new Column("status", "int", "ShakeMessage", "");
    hsa = new Column("title", "string", "ShakeMessage", "");
    hJn = new Column("desc", "string", "ShakeMessage", "");
    hHm = new Column("thumburl", "string", "ShakeMessage", "");
    hHc = new Column("reserved1", "string", "ShakeMessage", "");
    hHd = new Column("reserved2", "string", "ShakeMessage", "");
    hHe = new Column("reserved3", "int", "ShakeMessage", "");
    JlW = new Column("reservedbuf", "byte[]", "ShakeMessage", "");
    hIz = "svrid".hashCode();
    type_HASHCODE = "type".hashCode();
    hMP = "subtype".hashCode();
    icG = "createtime".hashCode();
    hNn = "tag".hashCode();
    hmC = "status".hashCode();
    hsg = "title".hashCode();
    hJv = "desc".hashCode();
    JlZ = "thumburl".hashCode();
    hIE = "reserved1".hashCode();
    hIF = "reserved2".hashCode();
    hIG = "reserved3".hashCode();
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
      if (hIz != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.hHL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hMP == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (icG == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (hNn == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (hsg == k) {
        this.field_title = paramCursor.getString(i);
      } else if (hJv == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (JlZ == k) {
        this.field_thumburl = paramCursor.getString(i);
      } else if (hIE == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (hIF == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (hIG == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (Jma == k) {
        this.field_reservedBuf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hHL) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hMN) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.icv) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.hNd) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.hJr) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.JlX) {
      localContentValues.put("thumburl", this.field_thumburl);
    }
    if (this.hHQ) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.hHR) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.hHS) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.JlY) {
      localContentValues.put("reservedBuf", this.field_reservedBuf);
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
    return "ShakeMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a.a
 * JD-Core Version:    0.7.0.1
 */