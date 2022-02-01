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

public abstract class f
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("TextStatusSessionInfo");
  public static final Column TYPE;
  public static final a Ttf = new a();
  public static final Column UPDATETIME;
  public static final Column jTB;
  private static final int jUd;
  public static final Column kiW;
  private static final int kjy;
  private static final int kpA;
  public static final Column kpj;
  public static final Column kpl;
  public static final Column kpm;
  private static final int kpx;
  private static final int kpz;
  private static final int kuA;
  public static final Column kus;
  public static final Column kut;
  public static final Column kuu;
  private static final int kuy;
  private static final int kuz;
  private static final StorageObserverOwner<f> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  public int field_actionPermission;
  public int field_disableSendMsg;
  public int field_rejectMsg;
  public String field_selfUsername;
  public int field_senderRoleType;
  public String field_senderUserName;
  public String field_sessionId;
  public String field_talker;
  public int field_type;
  public long field_updateTime;
  private boolean jTP = true;
  private boolean kjk = true;
  private boolean kpq = true;
  private boolean kps = true;
  private boolean kpt = true;
  private boolean kuv = true;
  private boolean kuw = true;
  private boolean kux = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kiW = new Column("sessionId", "string", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kus = new Column("selfUsername", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    kpj = new Column("actionPermission", "int", TABLE.getName(), "");
    kut = new Column("rejectMsg", "int", TABLE.getName(), "");
    kuu = new Column("disableSendMsg", "int", TABLE.getName(), "");
    kpl = new Column("senderUserName", "string", TABLE.getName(), "");
    kpm = new Column("senderRoleType", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS TextStatusSessionInfo_sessionId_index ON TextStatusSessionInfo(sessionId)", "CREATE INDEX IF NOT EXISTS TextStatusSessionInfo_talker_index ON TextStatusSessionInfo(talker)", "CREATE INDEX IF NOT EXISTS TextStatusSessionInfo_selfUsername_index ON TextStatusSessionInfo(selfUsername)", "CREATE INDEX IF NOT EXISTS TextStatusSessionInfo_type_index ON TextStatusSessionInfo(type)", "CREATE INDEX IF NOT EXISTS TextStatusSessionInfo_senderUserName_index ON TextStatusSessionInfo(senderUserName)" };
    kjy = "sessionId".hashCode();
    jUd = "talker".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kuy = "selfUsername".hashCode();
    type_HASHCODE = "type".hashCode();
    kpx = "actionPermission".hashCode();
    kuz = "rejectMsg".hashCode();
    kuA = "disableSendMsg".hashCode();
    kpz = "senderUserName".hashCode();
    kpA = "senderRoleType".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "sessionId";
    localMAutoDBInfo.colsMap.put("sessionId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" sessionId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "sessionId";
    localMAutoDBInfo.columns[1] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "selfUsername";
    localMAutoDBInfo.colsMap.put("selfUsername", "TEXT default '' ");
    localStringBuilder.append(" selfUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "actionPermission";
    localMAutoDBInfo.colsMap.put("actionPermission", "INTEGER");
    localStringBuilder.append(" actionPermission INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "rejectMsg";
    localMAutoDBInfo.colsMap.put("rejectMsg", "INTEGER");
    localStringBuilder.append(" rejectMsg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "disableSendMsg";
    localMAutoDBInfo.colsMap.put("disableSendMsg", "INTEGER");
    localStringBuilder.append(" disableSendMsg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "senderUserName";
    localMAutoDBInfo.colsMap.put("senderUserName", "TEXT default '' ");
    localStringBuilder.append(" senderUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "senderRoleType";
    localMAutoDBInfo.colsMap.put("senderRoleType", "INTEGER default '0' ");
    localStringBuilder.append(" senderRoleType INTEGER default '0' ");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("sessionId"))
    {
      this.field_sessionId = paramContentValues.getAsString("sessionId");
      if (paramBoolean) {
        this.kjk = true;
      }
    }
    if (paramContentValues.containsKey("talker"))
    {
      this.field_talker = paramContentValues.getAsString("talker");
      if (paramBoolean) {
        this.jTP = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("selfUsername"))
    {
      this.field_selfUsername = paramContentValues.getAsString("selfUsername");
      if (paramBoolean) {
        this.kuv = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("actionPermission"))
    {
      this.field_actionPermission = paramContentValues.getAsInteger("actionPermission").intValue();
      if (paramBoolean) {
        this.kpq = true;
      }
    }
    if (paramContentValues.containsKey("rejectMsg"))
    {
      this.field_rejectMsg = paramContentValues.getAsInteger("rejectMsg").intValue();
      if (paramBoolean) {
        this.kuw = true;
      }
    }
    if (paramContentValues.containsKey("disableSendMsg"))
    {
      this.field_disableSendMsg = paramContentValues.getAsInteger("disableSendMsg").intValue();
      if (paramBoolean) {
        this.kux = true;
      }
    }
    if (paramContentValues.containsKey("senderUserName"))
    {
      this.field_senderUserName = paramContentValues.getAsString("senderUserName");
      if (paramBoolean) {
        this.kps = true;
      }
    }
    if (paramContentValues.containsKey("senderRoleType"))
    {
      this.field_senderRoleType = paramContentValues.getAsInteger("senderRoleType").intValue();
      if (paramBoolean) {
        this.kpt = true;
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
      if (kjy != k) {
        break label65;
      }
      this.field_sessionId = paramCursor.getString(i);
      this.kjk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jUd == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (kuy == k) {
        this.field_selfUsername = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (kpx == k) {
        this.field_actionPermission = paramCursor.getInt(i);
      } else if (kuz == k) {
        this.field_rejectMsg = paramCursor.getInt(i);
      } else if (kuA == k) {
        this.field_disableSendMsg = paramCursor.getInt(i);
      } else if (kpz == k) {
        this.field_senderUserName = paramCursor.getString(i);
      } else if (kpA == k) {
        this.field_senderRoleType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_sessionId == null) {
      this.field_sessionId = "";
    }
    if (this.kjk) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.jTP) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_selfUsername == null) {
      this.field_selfUsername = "";
    }
    if (this.kuv) {
      localContentValues.put("selfUsername", this.field_selfUsername);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.kpq) {
      localContentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
    }
    if (this.kuw) {
      localContentValues.put("rejectMsg", Integer.valueOf(this.field_rejectMsg));
    }
    if (this.kux) {
      localContentValues.put("disableSendMsg", Integer.valueOf(this.field_disableSendMsg));
    }
    if (this.field_senderUserName == null) {
      this.field_senderUserName = "";
    }
    if (this.kps) {
      localContentValues.put("senderUserName", this.field_senderUserName);
    }
    if (this.kpt) {
      localContentValues.put("senderRoleType", Integer.valueOf(this.field_senderRoleType));
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
  
  public StorageObserverOwner<? extends f> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_sessionId;
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
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.f
 * JD-Core Version:    0.7.0.1
 */