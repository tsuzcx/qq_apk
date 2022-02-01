package com.tencent.mm.plugin.shake.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class a
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column PyN;
  private static final int PyQ;
  private static final int PyR;
  public static final Column ROWID;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE = new SingleTable("ShakeMessage");
  public static final Column TYPE;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jON;
  private static final int jOT;
  private static final int kBR;
  public static final Column keb;
  public static final Column keg;
  public static final Column keh;
  public static final Column kei;
  public static final Column keq;
  private static final int kfE;
  private static final int kfJ;
  private static final int kfK;
  private static final int kfL;
  private static final int kgA;
  public static final Column kgs;
  private static final int kjT;
  public static final Column kjX;
  private static final int kkr;
  private static final StorageObserverOwner<a> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean PyO = true;
  private boolean PyP = true;
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
  private boolean jIC = true;
  private boolean jOQ = true;
  private boolean kBG = true;
  private boolean keQ = true;
  private boolean keV = true;
  private boolean keW = true;
  private boolean keX = true;
  private boolean kgw = true;
  private boolean kjR = true;
  private boolean kkh = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    keb = new Column("svrid", "long", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    SUBTYPE = new Column("subtype", "int", TABLE.getName(), "");
    CREATETIME = new Column("createtime", "long", TABLE.getName(), "");
    kjX = new Column("tag", "string", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    kgs = new Column("desc", "string", TABLE.getName(), "");
    keq = new Column("thumburl", "string", TABLE.getName(), "");
    keg = new Column("reserved1", "string", TABLE.getName(), "");
    keh = new Column("reserved2", "string", TABLE.getName(), "");
    kei = new Column("reserved3", "int", TABLE.getName(), "");
    PyN = new Column("reservedBuf", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kfE = "svrid".hashCode();
    type_HASHCODE = "type".hashCode();
    kjT = "subtype".hashCode();
    kBR = "createtime".hashCode();
    kkr = "tag".hashCode();
    jIF = "status".hashCode();
    jOT = "title".hashCode();
    kgA = "desc".hashCode();
    PyQ = "thumburl".hashCode();
    kfJ = "reserved1".hashCode();
    kfK = "reserved2".hashCode();
    kfL = "reserved3".hashCode();
    PyR = "reservedBuf".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "svrid";
    localMAutoDBInfo.colsMap.put("svrid", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "svrid";
    localMAutoDBInfo.columns[1] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "subtype";
    localMAutoDBInfo.colsMap.put("subtype", "INTEGER default '0' ");
    localStringBuilder.append(" subtype INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "tag";
    localMAutoDBInfo.colsMap.put("tag", "TEXT");
    localStringBuilder.append(" tag TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "thumburl";
    localMAutoDBInfo.colsMap.put("thumburl", "TEXT");
    localStringBuilder.append(" thumburl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "reserved1";
    localMAutoDBInfo.colsMap.put("reserved1", "TEXT");
    localStringBuilder.append(" reserved1 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "reserved2";
    localMAutoDBInfo.colsMap.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "reserved3";
    localMAutoDBInfo.colsMap.put("reserved3", "INTEGER");
    localStringBuilder.append(" reserved3 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "reservedBuf";
    localMAutoDBInfo.colsMap.put("reservedBuf", "BLOB");
    localStringBuilder.append(" reservedBuf BLOB");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("svrid"))
    {
      this.field_svrid = paramContentValues.getAsLong("svrid").longValue();
      if (paramBoolean) {
        this.keQ = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("subtype"))
    {
      this.field_subtype = paramContentValues.getAsInteger("subtype").intValue();
      if (paramBoolean) {
        this.kjR = true;
      }
    }
    if (paramContentValues.containsKey("createtime"))
    {
      this.field_createtime = paramContentValues.getAsLong("createtime").longValue();
      if (paramBoolean) {
        this.kBG = true;
      }
    }
    if (paramContentValues.containsKey("tag"))
    {
      this.field_tag = paramContentValues.getAsString("tag");
      if (paramBoolean) {
        this.kkh = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("desc"))
    {
      this.field_desc = paramContentValues.getAsString("desc");
      if (paramBoolean) {
        this.kgw = true;
      }
    }
    if (paramContentValues.containsKey("thumburl"))
    {
      this.field_thumburl = paramContentValues.getAsString("thumburl");
      if (paramBoolean) {
        this.PyO = true;
      }
    }
    if (paramContentValues.containsKey("reserved1"))
    {
      this.field_reserved1 = paramContentValues.getAsString("reserved1");
      if (paramBoolean) {
        this.keV = true;
      }
    }
    if (paramContentValues.containsKey("reserved2"))
    {
      this.field_reserved2 = paramContentValues.getAsString("reserved2");
      if (paramBoolean) {
        this.keW = true;
      }
    }
    if (paramContentValues.containsKey("reserved3"))
    {
      this.field_reserved3 = paramContentValues.getAsInteger("reserved3").intValue();
      if (paramBoolean) {
        this.keX = true;
      }
    }
    if (paramContentValues.containsKey("reservedBuf"))
    {
      this.field_reservedBuf = paramContentValues.getAsByteArray("reservedBuf");
      if (paramBoolean) {
        this.PyP = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
      if (kfE != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.keQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (kjT == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (kBR == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (kkr == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (jOT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (kgA == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (PyQ == k) {
        this.field_thumburl = paramCursor.getString(i);
      } else if (kfJ == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (kfK == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (kfL == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (PyR == k) {
        this.field_reservedBuf = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.keQ) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.kjR) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.kBG) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.kkh) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.kgw) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.PyO) {
      localContentValues.put("thumburl", this.field_thumburl);
    }
    if (this.keV) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.keW) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.keX) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.PyP) {
      localContentValues.put("reservedBuf", this.field_reservedBuf);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends a> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_svrid);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.a.a
 * JD-Core Version:    0.7.0.1
 */