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

public abstract class b
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("TextStatusConversation");
  public static final Column TYPE;
  public static final a Ttf = new a();
  public static final Column Ttg;
  private static final int Tti;
  public static final Column UPDATETIME;
  private static final int content_HASHCODE;
  private static final int jIF;
  public static final Column jIz;
  private static final int jJD;
  public static final Column jJz;
  public static final Column jPH;
  public static final Column jPJ;
  public static final Column jPL;
  public static final Column jPM;
  public static final Column jPO;
  public static final Column jPQ;
  private static final int jQl;
  private static final int jQn;
  private static final int jQp;
  private static final int jQq;
  private static final int jQs;
  private static final int jQu;
  public static final Column jTB;
  private static final int jUd;
  public static final Column kiW;
  private static final int kjy;
  private static final int kpA;
  private static final int kpB;
  public static final Column kph;
  public static final Column kpi;
  public static final Column kpj;
  public static final Column kpk;
  public static final Column kpl;
  public static final Column kpm;
  public static final Column kpn;
  private static final int kpv;
  private static final int kpw;
  private static final int kpx;
  private static final int kpy;
  private static final int kpz;
  private static final StorageObserverOwner<b> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean Tth = true;
  private boolean __hadSetcontent = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  public int field_actionPermission;
  public String field_content;
  public String field_digest;
  public String field_digestType;
  public String field_digestUser;
  public String field_editingMsg;
  public int field_isRedDot;
  public int field_isSend;
  public long field_lastMsgID;
  public long field_placedFlag;
  public int field_readStatus;
  public int field_scene;
  public int field_senderRoleType;
  public String field_senderUserName;
  public int field_senderUserNameVersion;
  public String field_sessionId;
  public int field_status;
  public String field_talker;
  public int field_type;
  public int field_unReadCount;
  public long field_updateTime;
  private boolean jIC = true;
  private boolean jJB = true;
  private boolean jPW = true;
  private boolean jPY = true;
  private boolean jQa = true;
  private boolean jQb = true;
  private boolean jQd = true;
  private boolean jQf = true;
  private boolean jTP = true;
  private boolean kjk = true;
  private boolean kpo = true;
  private boolean kpp = true;
  private boolean kpq = true;
  private boolean kpr = true;
  private boolean kps = true;
  private boolean kpt = true;
  private boolean kpu = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kiW = new Column("sessionId", "string", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    jPH = new Column("unReadCount", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    jPL = new Column("digest", "string", TABLE.getName(), "");
    jPM = new Column("digestUser", "string", TABLE.getName(), "");
    kph = new Column("digestType", "string", TABLE.getName(), "");
    jPJ = new Column("lastMsgID", "long", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    jPQ = new Column("isSend", "int", TABLE.getName(), "");
    kpi = new Column("placedFlag", "long", TABLE.getName(), "");
    jPO = new Column("editingMsg", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    kpj = new Column("actionPermission", "int", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    kpk = new Column("readStatus", "int", TABLE.getName(), "");
    kpl = new Column("senderUserName", "string", TABLE.getName(), "");
    kpm = new Column("senderRoleType", "int", TABLE.getName(), "");
    kpn = new Column("senderUserNameVersion", "int", TABLE.getName(), "");
    Ttg = new Column("isRedDot", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS TextStatus_sessionId_index ON TextStatusConversation(sessionId)", "CREATE INDEX IF NOT EXISTS TextStatusConversation_talker_index ON TextStatusConversation(talker)", "CREATE INDEX IF NOT EXISTS TextStatusConversation_username_status ON TextStatusConversation(status)", "CREATE INDEX IF NOT EXISTS TextStatusConversation_updateTime_index ON TextStatusConversation(updateTime)", "CREATE INDEX IF NOT EXISTS TextStatusConversation_type_index ON TextStatusConversation(type)", "CREATE INDEX IF NOT EXISTS TextStatusConversation_scene_index ON TextStatusConversation(scene)", "CREATE INDEX IF NOT EXISTS TextStatusConversation_readStatus_index ON TextStatusConversation(readStatus)", "CREATE INDEX IF NOT EXISTS TextStatusConversation_senderUserName_index ON TextStatusConversation(senderUserName)", "CREATE INDEX IF NOT EXISTS TextStatusConversation_senderUserNameVersion_index ON TextStatusConversation(senderUserNameVersion)" };
    kjy = "sessionId".hashCode();
    jUd = "talker".hashCode();
    jQl = "unReadCount".hashCode();
    jIF = "status".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    jQp = "digest".hashCode();
    jQq = "digestUser".hashCode();
    kpv = "digestType".hashCode();
    jQn = "lastMsgID".hashCode();
    content_HASHCODE = "content".hashCode();
    jQu = "isSend".hashCode();
    kpw = "placedFlag".hashCode();
    jQs = "editingMsg".hashCode();
    type_HASHCODE = "type".hashCode();
    kpx = "actionPermission".hashCode();
    jJD = "scene".hashCode();
    kpy = "readStatus".hashCode();
    kpz = "senderUserName".hashCode();
    kpA = "senderRoleType".hashCode();
    kpB = "senderUserNameVersion".hashCode();
    Tti = "isRedDot".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[21];
    localMAutoDBInfo.columns = new String[22];
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
    localMAutoDBInfo.columns[2] = "unReadCount";
    localMAutoDBInfo.colsMap.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "digest";
    localMAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "digestUser";
    localMAutoDBInfo.colsMap.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "digestType";
    localMAutoDBInfo.colsMap.put("digestType", "TEXT default '' ");
    localStringBuilder.append(" digestType TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "lastMsgID";
    localMAutoDBInfo.colsMap.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "placedFlag";
    localMAutoDBInfo.colsMap.put("placedFlag", "LONG default '0' ");
    localStringBuilder.append(" placedFlag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "editingMsg";
    localMAutoDBInfo.colsMap.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "actionPermission";
    localMAutoDBInfo.colsMap.put("actionPermission", "INTEGER");
    localStringBuilder.append(" actionPermission INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "readStatus";
    localMAutoDBInfo.colsMap.put("readStatus", "INTEGER");
    localStringBuilder.append(" readStatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "senderUserName";
    localMAutoDBInfo.colsMap.put("senderUserName", "TEXT default '' ");
    localStringBuilder.append(" senderUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "senderRoleType";
    localMAutoDBInfo.colsMap.put("senderRoleType", "INTEGER default '0' ");
    localStringBuilder.append(" senderRoleType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "senderUserNameVersion";
    localMAutoDBInfo.colsMap.put("senderUserNameVersion", "INTEGER default '0' ");
    localStringBuilder.append(" senderUserNameVersion INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "isRedDot";
    localMAutoDBInfo.colsMap.put("isRedDot", "INTEGER default '0' ");
    localStringBuilder.append(" isRedDot INTEGER default '0' ");
    localMAutoDBInfo.columns[21] = "rowid";
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
    if (paramContentValues.containsKey("unReadCount"))
    {
      this.field_unReadCount = paramContentValues.getAsInteger("unReadCount").intValue();
      if (paramBoolean) {
        this.jPW = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("digest"))
    {
      this.field_digest = paramContentValues.getAsString("digest");
      if (paramBoolean) {
        this.jQa = true;
      }
    }
    if (paramContentValues.containsKey("digestUser"))
    {
      this.field_digestUser = paramContentValues.getAsString("digestUser");
      if (paramBoolean) {
        this.jQb = true;
      }
    }
    if (paramContentValues.containsKey("digestType"))
    {
      this.field_digestType = paramContentValues.getAsString("digestType");
      if (paramBoolean) {
        this.kpo = true;
      }
    }
    if (paramContentValues.containsKey("lastMsgID"))
    {
      this.field_lastMsgID = paramContentValues.getAsLong("lastMsgID").longValue();
      if (paramBoolean) {
        this.jPY = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("isSend"))
    {
      this.field_isSend = paramContentValues.getAsInteger("isSend").intValue();
      if (paramBoolean) {
        this.jQf = true;
      }
    }
    if (paramContentValues.containsKey("placedFlag"))
    {
      this.field_placedFlag = paramContentValues.getAsLong("placedFlag").longValue();
      if (paramBoolean) {
        this.kpp = true;
      }
    }
    if (paramContentValues.containsKey("editingMsg"))
    {
      this.field_editingMsg = paramContentValues.getAsString("editingMsg");
      if (paramBoolean) {
        this.jQd = true;
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
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
      }
    }
    if (paramContentValues.containsKey("readStatus"))
    {
      this.field_readStatus = paramContentValues.getAsInteger("readStatus").intValue();
      if (paramBoolean) {
        this.kpr = true;
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
    if (paramContentValues.containsKey("senderUserNameVersion"))
    {
      this.field_senderUserNameVersion = paramContentValues.getAsInteger("senderUserNameVersion").intValue();
      if (paramBoolean) {
        this.kpu = true;
      }
    }
    if (paramContentValues.containsKey("isRedDot"))
    {
      this.field_isRedDot = paramContentValues.getAsInteger("isRedDot").intValue();
      if (paramBoolean) {
        this.Tth = true;
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
      } else if (jQl == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (jQp == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (jQq == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (kpv == k) {
        this.field_digestType = paramCursor.getString(i);
      } else if (jQn == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (jQu == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (kpw == k) {
        this.field_placedFlag = paramCursor.getLong(i);
      } else if (jQs == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (kpx == k) {
        this.field_actionPermission = paramCursor.getInt(i);
      } else if (jJD == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (kpy == k) {
        this.field_readStatus = paramCursor.getInt(i);
      } else if (kpz == k) {
        this.field_senderUserName = paramCursor.getString(i);
      } else if (kpA == k) {
        this.field_senderRoleType = paramCursor.getInt(i);
      } else if (kpB == k) {
        this.field_senderUserNameVersion = paramCursor.getInt(i);
      } else if (Tti == k) {
        this.field_isRedDot = paramCursor.getInt(i);
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
    if (this.jPW) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.jQa) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.jQb) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.field_digestType == null) {
      this.field_digestType = "";
    }
    if (this.kpo) {
      localContentValues.put("digestType", this.field_digestType);
    }
    if (this.jPY) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.jQf) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.kpp) {
      localContentValues.put("placedFlag", Long.valueOf(this.field_placedFlag));
    }
    if (this.jQd) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.kpq) {
      localContentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.kpr) {
      localContentValues.put("readStatus", Integer.valueOf(this.field_readStatus));
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
    if (this.kpu) {
      localContentValues.put("senderUserNameVersion", Integer.valueOf(this.field_senderUserNameVersion));
    }
    if (this.Tth) {
      localContentValues.put("isRedDot", Integer.valueOf(this.field_isRedDot));
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
  
  public StorageObserverOwner<? extends b> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.b
 * JD-Core Version:    0.7.0.1
 */