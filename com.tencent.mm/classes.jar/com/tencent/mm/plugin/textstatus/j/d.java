package com.tencent.mm.plugin.textstatus.j;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.textstatus.h.f.a;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class d
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column JmU;
  private static final int JmY;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("TextStatusLike");
  public static final Column TYPE;
  public static final Column TrA;
  private static final int TsE;
  private static final int TtJ;
  public static final Column TtN;
  public static final Column TtO;
  private static final int TtU;
  private static final int TtV;
  private static final int TtW;
  private static final int TtX;
  private static final int TtY;
  public static final a Ttf = new a();
  public static final Column Ttp;
  public static final Column jOO;
  public static final Column jTj;
  public static final Column jWT;
  public static final Column keq;
  private static final int kfT;
  public static final Column kpH;
  private static final int kvb;
  private static final int kvd;
  private static final int kvi;
  private static final StorageObserverOwner<d> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean JmW = true;
  private boolean Tsa = true;
  private boolean TtP = true;
  private boolean TtQ = true;
  private boolean TtR = true;
  private boolean TtS = true;
  private boolean TtT = true;
  private boolean Ttz = true;
  public int field_CreateTime;
  public int field_DeleteInMsgList;
  public String field_Description;
  public String field_DisplayName;
  public String field_HashUserName;
  public String field_HeadImgUrl;
  public int field_Notify;
  public int field_Read;
  public String field_TextStatusId;
  public byte[] field_TopicInfo;
  public int field_Type;
  public String field_thumbUrl;
  private boolean kff = true;
  private boolean kuS = true;
  private boolean kuU = true;
  private boolean kuZ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    TtN = new Column("TextStatusId", "string", TABLE.getName(), "");
    JmU = new Column("HashUserName", "string", TABLE.getName(), "");
    jWT = new Column("DisplayName", "string", TABLE.getName(), "");
    jTj = new Column("HeadImgUrl", "string", TABLE.getName(), "");
    jOO = new Column("Description", "string", TABLE.getName(), "");
    TYPE = new Column("Type", "int", TABLE.getName(), "");
    CREATETIME = new Column("CreateTime", "int", TABLE.getName(), "");
    kpH = new Column("Notify", "int", TABLE.getName(), "");
    Ttp = new Column("Read", "int", TABLE.getName(), "");
    keq = new Column("thumbUrl", "string", TABLE.getName(), "");
    TrA = new Column("TopicInfo", "byte[]", TABLE.getName(), "");
    TtO = new Column("DeleteInMsgList", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS TextStatusLike_TextStatusId_index ON TextStatusLike(TextStatusId)" };
    TtU = "TextStatusId".hashCode();
    JmY = "HashUserName".hashCode();
    TtV = "DisplayName".hashCode();
    TtW = "HeadImgUrl".hashCode();
    kvd = "Description".hashCode();
    kvi = "Type".hashCode();
    kvb = "CreateTime".hashCode();
    TtX = "Notify".hashCode();
    TtJ = "Read".hashCode();
    kfT = "thumbUrl".hashCode();
    TsE = "TopicInfo".hashCode();
    TtY = "DeleteInMsgList".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[12];
    localMAutoDBInfo.columns = new String[13];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "TextStatusId";
    localMAutoDBInfo.colsMap.put("TextStatusId", "TEXT");
    localStringBuilder.append(" TextStatusId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "HashUserName";
    localMAutoDBInfo.colsMap.put("HashUserName", "TEXT");
    localStringBuilder.append(" HashUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "DisplayName";
    localMAutoDBInfo.colsMap.put("DisplayName", "TEXT");
    localStringBuilder.append(" DisplayName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "HeadImgUrl";
    localMAutoDBInfo.colsMap.put("HeadImgUrl", "TEXT");
    localStringBuilder.append(" HeadImgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "Description";
    localMAutoDBInfo.colsMap.put("Description", "TEXT");
    localStringBuilder.append(" Description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "Type";
    localMAutoDBInfo.colsMap.put("Type", "INTEGER");
    localStringBuilder.append(" Type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "CreateTime";
    localMAutoDBInfo.colsMap.put("CreateTime", "INTEGER");
    localStringBuilder.append(" CreateTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "Notify";
    localMAutoDBInfo.colsMap.put("Notify", "INTEGER");
    localStringBuilder.append(" Notify INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "Read";
    localMAutoDBInfo.colsMap.put("Read", "INTEGER");
    localStringBuilder.append(" Read INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "thumbUrl";
    localMAutoDBInfo.colsMap.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "TopicInfo";
    localMAutoDBInfo.colsMap.put("TopicInfo", "BLOB");
    localStringBuilder.append(" TopicInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "DeleteInMsgList";
    localMAutoDBInfo.colsMap.put("DeleteInMsgList", "INTEGER");
    localStringBuilder.append(" DeleteInMsgList INTEGER");
    localMAutoDBInfo.columns[12] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("TextStatusId"))
    {
      this.field_TextStatusId = paramContentValues.getAsString("TextStatusId");
      if (paramBoolean) {
        this.TtP = true;
      }
    }
    if (paramContentValues.containsKey("HashUserName"))
    {
      this.field_HashUserName = paramContentValues.getAsString("HashUserName");
      if (paramBoolean) {
        this.JmW = true;
      }
    }
    if (paramContentValues.containsKey("DisplayName"))
    {
      this.field_DisplayName = paramContentValues.getAsString("DisplayName");
      if (paramBoolean) {
        this.TtQ = true;
      }
    }
    if (paramContentValues.containsKey("HeadImgUrl"))
    {
      this.field_HeadImgUrl = paramContentValues.getAsString("HeadImgUrl");
      if (paramBoolean) {
        this.TtR = true;
      }
    }
    if (paramContentValues.containsKey("Description"))
    {
      this.field_Description = paramContentValues.getAsString("Description");
      if (paramBoolean) {
        this.kuU = true;
      }
    }
    if (paramContentValues.containsKey("Type"))
    {
      this.field_Type = paramContentValues.getAsInteger("Type").intValue();
      if (paramBoolean) {
        this.kuZ = true;
      }
    }
    if (paramContentValues.containsKey("CreateTime"))
    {
      this.field_CreateTime = paramContentValues.getAsInteger("CreateTime").intValue();
      if (paramBoolean) {
        this.kuS = true;
      }
    }
    if (paramContentValues.containsKey("Notify"))
    {
      this.field_Notify = paramContentValues.getAsInteger("Notify").intValue();
      if (paramBoolean) {
        this.TtS = true;
      }
    }
    if (paramContentValues.containsKey("Read"))
    {
      this.field_Read = paramContentValues.getAsInteger("Read").intValue();
      if (paramBoolean) {
        this.Ttz = true;
      }
    }
    if (paramContentValues.containsKey("thumbUrl"))
    {
      this.field_thumbUrl = paramContentValues.getAsString("thumbUrl");
      if (paramBoolean) {
        this.kff = true;
      }
    }
    if (paramContentValues.containsKey("TopicInfo"))
    {
      this.field_TopicInfo = paramContentValues.getAsByteArray("TopicInfo");
      if (paramBoolean) {
        this.Tsa = true;
      }
    }
    if (paramContentValues.containsKey("DeleteInMsgList"))
    {
      this.field_DeleteInMsgList = paramContentValues.getAsInteger("DeleteInMsgList").intValue();
      if (paramBoolean) {
        this.TtT = true;
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
      if (TtU != k) {
        break label60;
      }
      this.field_TextStatusId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (JmY == k) {
        this.field_HashUserName = paramCursor.getString(i);
      } else if (TtV == k) {
        this.field_DisplayName = paramCursor.getString(i);
      } else if (TtW == k) {
        this.field_HeadImgUrl = paramCursor.getString(i);
      } else if (kvd == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (kvi == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (kvb == k) {
        this.field_CreateTime = paramCursor.getInt(i);
      } else if (TtX == k) {
        this.field_Notify = paramCursor.getInt(i);
      } else if (TtJ == k) {
        this.field_Read = paramCursor.getInt(i);
      } else if (kfT == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (TsE == k) {
        this.field_TopicInfo = paramCursor.getBlob(i);
      } else if (TtY == k) {
        this.field_DeleteInMsgList = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.TtP) {
      localContentValues.put("TextStatusId", this.field_TextStatusId);
    }
    if (this.JmW) {
      localContentValues.put("HashUserName", this.field_HashUserName);
    }
    if (this.TtQ) {
      localContentValues.put("DisplayName", this.field_DisplayName);
    }
    if (this.TtR) {
      localContentValues.put("HeadImgUrl", this.field_HeadImgUrl);
    }
    if (this.kuU) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.kuZ) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.kuS) {
      localContentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
    }
    if (this.TtS) {
      localContentValues.put("Notify", Integer.valueOf(this.field_Notify));
    }
    if (this.Ttz) {
      localContentValues.put("Read", Integer.valueOf(this.field_Read));
    }
    if (this.kff) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.Tsa) {
      localContentValues.put("TopicInfo", this.field_TopicInfo);
    }
    if (this.TtT) {
      localContentValues.put("DeleteInMsgList", Integer.valueOf(this.field_DeleteInMsgList));
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
  
  public StorageObserverOwner<? extends d> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
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
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.d
 * JD-Core Version:    0.7.0.1
 */