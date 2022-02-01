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

public abstract class e
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("TextStatusReference");
  public static final Column TrA;
  private static final int TsE;
  private static final int TtJ;
  public static final Column TtN;
  public static final Column TtO;
  private static final int TtU;
  private static final int TtY;
  public static final a Ttf = new a();
  public static final Column Ttp;
  private static final int Tua;
  public static final Column USERNAME;
  public static final Column jJI;
  public static final Column jOO;
  public static final Column keq;
  private static final int kfT;
  private static final int kvb;
  private static final int kvd;
  private static final int kvf;
  private static final StorageObserverOwner<e> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean Tsa = true;
  private boolean TtP = true;
  private boolean TtT = true;
  private boolean TtZ = true;
  private boolean Ttz = true;
  public int field_CreateTime;
  public int field_DeleteInMsgList;
  public String field_Description;
  public int field_Read;
  public int field_ShowType;
  public String field_TextStatusId;
  public byte[] field_TopicInfo;
  public String field_UserName;
  public String field_thumbUrl;
  private boolean kff = true;
  private boolean kuS = true;
  private boolean kuU = true;
  private boolean kuW = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    TtN = new Column("TextStatusId", "string", TABLE.getName(), "");
    USERNAME = new Column("UserName", "string", TABLE.getName(), "");
    CREATETIME = new Column("CreateTime", "int", TABLE.getName(), "");
    keq = new Column("thumbUrl", "string", TABLE.getName(), "");
    Ttp = new Column("Read", "int", TABLE.getName(), "");
    TrA = new Column("TopicInfo", "byte[]", TABLE.getName(), "");
    TtO = new Column("DeleteInMsgList", "int", TABLE.getName(), "");
    jJI = new Column("ShowType", "int", TABLE.getName(), "");
    jOO = new Column("Description", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS TextStatusReference_TextStatusId_index ON TextStatusReference(TextStatusId)" };
    TtU = "TextStatusId".hashCode();
    kvf = "UserName".hashCode();
    kvb = "CreateTime".hashCode();
    kfT = "thumbUrl".hashCode();
    TtJ = "Read".hashCode();
    TsE = "TopicInfo".hashCode();
    TtY = "DeleteInMsgList".hashCode();
    Tua = "ShowType".hashCode();
    kvd = "Description".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "TextStatusId";
    localMAutoDBInfo.colsMap.put("TextStatusId", "TEXT");
    localStringBuilder.append(" TextStatusId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "UserName";
    localMAutoDBInfo.colsMap.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "CreateTime";
    localMAutoDBInfo.colsMap.put("CreateTime", "INTEGER");
    localStringBuilder.append(" CreateTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "thumbUrl";
    localMAutoDBInfo.colsMap.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "Read";
    localMAutoDBInfo.colsMap.put("Read", "INTEGER");
    localStringBuilder.append(" Read INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "TopicInfo";
    localMAutoDBInfo.colsMap.put("TopicInfo", "BLOB");
    localStringBuilder.append(" TopicInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "DeleteInMsgList";
    localMAutoDBInfo.colsMap.put("DeleteInMsgList", "INTEGER");
    localStringBuilder.append(" DeleteInMsgList INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "ShowType";
    localMAutoDBInfo.colsMap.put("ShowType", "INTEGER");
    localStringBuilder.append(" ShowType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "Description";
    localMAutoDBInfo.colsMap.put("Description", "TEXT");
    localStringBuilder.append(" Description TEXT");
    localMAutoDBInfo.columns[9] = "rowid";
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
    if (paramContentValues.containsKey("UserName"))
    {
      this.field_UserName = paramContentValues.getAsString("UserName");
      if (paramBoolean) {
        this.kuW = true;
      }
    }
    if (paramContentValues.containsKey("CreateTime"))
    {
      this.field_CreateTime = paramContentValues.getAsInteger("CreateTime").intValue();
      if (paramBoolean) {
        this.kuS = true;
      }
    }
    if (paramContentValues.containsKey("thumbUrl"))
    {
      this.field_thumbUrl = paramContentValues.getAsString("thumbUrl");
      if (paramBoolean) {
        this.kff = true;
      }
    }
    if (paramContentValues.containsKey("Read"))
    {
      this.field_Read = paramContentValues.getAsInteger("Read").intValue();
      if (paramBoolean) {
        this.Ttz = true;
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
    if (paramContentValues.containsKey("ShowType"))
    {
      this.field_ShowType = paramContentValues.getAsInteger("ShowType").intValue();
      if (paramBoolean) {
        this.TtZ = true;
      }
    }
    if (paramContentValues.containsKey("Description"))
    {
      this.field_Description = paramContentValues.getAsString("Description");
      if (paramBoolean) {
        this.kuU = true;
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
      if (kvf == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (kvb == k) {
        this.field_CreateTime = paramCursor.getInt(i);
      } else if (kfT == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (TtJ == k) {
        this.field_Read = paramCursor.getInt(i);
      } else if (TsE == k) {
        this.field_TopicInfo = paramCursor.getBlob(i);
      } else if (TtY == k) {
        this.field_DeleteInMsgList = paramCursor.getInt(i);
      } else if (Tua == k) {
        this.field_ShowType = paramCursor.getInt(i);
      } else if (kvd == k) {
        this.field_Description = paramCursor.getString(i);
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
    if (this.kuW) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.kuS) {
      localContentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
    }
    if (this.kff) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.Ttz) {
      localContentValues.put("Read", Integer.valueOf(this.field_Read));
    }
    if (this.Tsa) {
      localContentValues.put("TopicInfo", this.field_TopicInfo);
    }
    if (this.TtT) {
      localContentValues.put("DeleteInMsgList", Integer.valueOf(this.field_DeleteInMsgList));
    }
    if (this.TtZ) {
      localContentValues.put("ShowType", Integer.valueOf(this.field_ShowType));
    }
    if (this.kuU) {
      localContentValues.put("Description", this.field_Description);
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
  
  public StorageObserverOwner<? extends e> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.e
 * JD-Core Version:    0.7.0.1
 */