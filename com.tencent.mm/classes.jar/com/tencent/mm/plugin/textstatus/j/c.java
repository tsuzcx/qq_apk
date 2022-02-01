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

public abstract class c
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("TextStatusGreetingItem");
  private static final int TtD;
  private static final int TtE;
  private static final int TtF;
  private static final int TtG;
  private static final int TtH;
  private static final int TtI;
  private static final int TtJ;
  private static final int TtK;
  private static final int TtL;
  private static final int TtM;
  public static final a Ttf = new a();
  public static final Column Ttj;
  public static final Column Ttk;
  public static final Column Ttl;
  public static final Column Ttm;
  public static final Column Ttn;
  public static final Column Tto;
  public static final Column Ttp;
  public static final Column Ttq;
  public static final Column Ttr;
  public static final Column Tts;
  private static final int createTime_HASHCODE;
  public static final Column kAd;
  private static final int kAm;
  public static final Column kjX;
  private static final int kkr;
  private static final StorageObserverOwner<c> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean TtA = true;
  private boolean TtB = true;
  private boolean TtC = true;
  private boolean Ttt = true;
  private boolean Ttu = true;
  private boolean Ttv = true;
  private boolean Ttw = true;
  private boolean Ttx = true;
  private boolean Tty = true;
  private boolean Ttz = true;
  private boolean __hadSetcreateTime = true;
  public int field_Read;
  public int field_canChatting;
  public long field_card_key;
  public int field_createTime;
  public String field_encUsername;
  public String field_hash_username;
  public int field_modify_count;
  public long field_newMsgId;
  public String field_plain;
  public String field_session_id;
  public String field_source_id;
  public String field_status_id;
  public String field_tag;
  private boolean kAg = true;
  private boolean kkh = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kAd = new Column("newMsgId", "long", TABLE.getName(), "");
    Ttj = new Column("session_id", "string", TABLE.getName(), "");
    Ttk = new Column("hash_username", "string", TABLE.getName(), "");
    Ttl = new Column("encUsername", "string", TABLE.getName(), "");
    kjX = new Column("tag", "string", TABLE.getName(), "");
    Ttm = new Column("source_id", "string", TABLE.getName(), "");
    Ttn = new Column("canChatting", "int", TABLE.getName(), "");
    Tto = new Column("plain", "string", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "int", TABLE.getName(), "");
    Ttp = new Column("Read", "int", TABLE.getName(), "");
    Ttq = new Column("status_id", "string", TABLE.getName(), "");
    Ttr = new Column("modify_count", "int", TABLE.getName(), "");
    Tts = new Column("card_key", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS TextStatusGreetingItem_sessionId_index ON TextStatusGreetingItem(session_id)" };
    kAm = "newMsgId".hashCode();
    TtD = "session_id".hashCode();
    TtE = "hash_username".hashCode();
    TtF = "encUsername".hashCode();
    kkr = "tag".hashCode();
    TtG = "source_id".hashCode();
    TtH = "canChatting".hashCode();
    TtI = "plain".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    TtJ = "Read".hashCode();
    TtK = "status_id".hashCode();
    TtL = "modify_count".hashCode();
    TtM = "card_key".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "newMsgId";
    localMAutoDBInfo.colsMap.put("newMsgId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" newMsgId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "newMsgId";
    localMAutoDBInfo.columns[1] = "session_id";
    localMAutoDBInfo.colsMap.put("session_id", "TEXT default '' ");
    localStringBuilder.append(" session_id TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "hash_username";
    localMAutoDBInfo.colsMap.put("hash_username", "TEXT default '' ");
    localStringBuilder.append(" hash_username TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "encUsername";
    localMAutoDBInfo.colsMap.put("encUsername", "TEXT default '' ");
    localStringBuilder.append(" encUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "tag";
    localMAutoDBInfo.colsMap.put("tag", "TEXT default '' ");
    localStringBuilder.append(" tag TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "source_id";
    localMAutoDBInfo.colsMap.put("source_id", "TEXT default '' ");
    localStringBuilder.append(" source_id TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "canChatting";
    localMAutoDBInfo.colsMap.put("canChatting", "INTEGER default '0' ");
    localStringBuilder.append(" canChatting INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "plain";
    localMAutoDBInfo.colsMap.put("plain", "TEXT default '' ");
    localStringBuilder.append(" plain TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "Read";
    localMAutoDBInfo.colsMap.put("Read", "INTEGER default '0' ");
    localStringBuilder.append(" Read INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "status_id";
    localMAutoDBInfo.colsMap.put("status_id", "TEXT default '' ");
    localStringBuilder.append(" status_id TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "modify_count";
    localMAutoDBInfo.colsMap.put("modify_count", "INTEGER default '0' ");
    localStringBuilder.append(" modify_count INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "card_key";
    localMAutoDBInfo.colsMap.put("card_key", "LONG default '0' ");
    localStringBuilder.append(" card_key LONG default '0' ");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("newMsgId"))
    {
      this.field_newMsgId = paramContentValues.getAsLong("newMsgId").longValue();
      if (paramBoolean) {
        this.kAg = true;
      }
    }
    if (paramContentValues.containsKey("session_id"))
    {
      this.field_session_id = paramContentValues.getAsString("session_id");
      if (paramBoolean) {
        this.Ttt = true;
      }
    }
    if (paramContentValues.containsKey("hash_username"))
    {
      this.field_hash_username = paramContentValues.getAsString("hash_username");
      if (paramBoolean) {
        this.Ttu = true;
      }
    }
    if (paramContentValues.containsKey("encUsername"))
    {
      this.field_encUsername = paramContentValues.getAsString("encUsername");
      if (paramBoolean) {
        this.Ttv = true;
      }
    }
    if (paramContentValues.containsKey("tag"))
    {
      this.field_tag = paramContentValues.getAsString("tag");
      if (paramBoolean) {
        this.kkh = true;
      }
    }
    if (paramContentValues.containsKey("source_id"))
    {
      this.field_source_id = paramContentValues.getAsString("source_id");
      if (paramBoolean) {
        this.Ttw = true;
      }
    }
    if (paramContentValues.containsKey("canChatting"))
    {
      this.field_canChatting = paramContentValues.getAsInteger("canChatting").intValue();
      if (paramBoolean) {
        this.Ttx = true;
      }
    }
    if (paramContentValues.containsKey("plain"))
    {
      this.field_plain = paramContentValues.getAsString("plain");
      if (paramBoolean) {
        this.Tty = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsInteger("createTime").intValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("Read"))
    {
      this.field_Read = paramContentValues.getAsInteger("Read").intValue();
      if (paramBoolean) {
        this.Ttz = true;
      }
    }
    if (paramContentValues.containsKey("status_id"))
    {
      this.field_status_id = paramContentValues.getAsString("status_id");
      if (paramBoolean) {
        this.TtA = true;
      }
    }
    if (paramContentValues.containsKey("modify_count"))
    {
      this.field_modify_count = paramContentValues.getAsInteger("modify_count").intValue();
      if (paramBoolean) {
        this.TtB = true;
      }
    }
    if (paramContentValues.containsKey("card_key"))
    {
      this.field_card_key = paramContentValues.getAsLong("card_key").longValue();
      if (paramBoolean) {
        this.TtC = true;
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
      if (kAm != k) {
        break label65;
      }
      this.field_newMsgId = paramCursor.getLong(i);
      this.kAg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (TtD == k) {
        this.field_session_id = paramCursor.getString(i);
      } else if (TtE == k) {
        this.field_hash_username = paramCursor.getString(i);
      } else if (TtF == k) {
        this.field_encUsername = paramCursor.getString(i);
      } else if (kkr == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (TtG == k) {
        this.field_source_id = paramCursor.getString(i);
      } else if (TtH == k) {
        this.field_canChatting = paramCursor.getInt(i);
      } else if (TtI == k) {
        this.field_plain = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (TtJ == k) {
        this.field_Read = paramCursor.getInt(i);
      } else if (TtK == k) {
        this.field_status_id = paramCursor.getString(i);
      } else if (TtL == k) {
        this.field_modify_count = paramCursor.getInt(i);
      } else if (TtM == k) {
        this.field_card_key = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kAg) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_session_id == null) {
      this.field_session_id = "";
    }
    if (this.Ttt) {
      localContentValues.put("session_id", this.field_session_id);
    }
    if (this.field_hash_username == null) {
      this.field_hash_username = "";
    }
    if (this.Ttu) {
      localContentValues.put("hash_username", this.field_hash_username);
    }
    if (this.field_encUsername == null) {
      this.field_encUsername = "";
    }
    if (this.Ttv) {
      localContentValues.put("encUsername", this.field_encUsername);
    }
    if (this.field_tag == null) {
      this.field_tag = "";
    }
    if (this.kkh) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.field_source_id == null) {
      this.field_source_id = "";
    }
    if (this.Ttw) {
      localContentValues.put("source_id", this.field_source_id);
    }
    if (this.Ttx) {
      localContentValues.put("canChatting", Integer.valueOf(this.field_canChatting));
    }
    if (this.field_plain == null) {
      this.field_plain = "";
    }
    if (this.Tty) {
      localContentValues.put("plain", this.field_plain);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.Ttz) {
      localContentValues.put("Read", Integer.valueOf(this.field_Read));
    }
    if (this.field_status_id == null) {
      this.field_status_id = "";
    }
    if (this.TtA) {
      localContentValues.put("status_id", this.field_status_id);
    }
    if (this.TtB) {
      localContentValues.put("modify_count", Integer.valueOf(this.field_modify_count));
    }
    if (this.TtC) {
      localContentValues.put("card_key", Long.valueOf(this.field_card_key));
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
  
  public StorageObserverOwner<? extends c> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_newMsgId);
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
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.c
 * JD-Core Version:    0.7.0.1
 */