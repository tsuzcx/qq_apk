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

public abstract class g
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("TextStatusStrangerContact");
  public static final Column TtN;
  public static final a Ttf = new a();
  public static final Column Tub;
  public static final Column Tuc;
  public static final Column Tud;
  public static final Column Tue;
  public static final Column Tuf;
  public static final Column Tug;
  private static final int Tuo;
  private static final int Tup;
  private static final int Tuq;
  private static final int Tur;
  private static final int Tus;
  private static final int Tut;
  private static final int Tuu;
  public static final Column USERNAME;
  public static final Column jKD;
  private static final int jLl;
  public static final Column jTk;
  private static final int jTs;
  public static final Column kWG;
  public static final Column kWH;
  private static final int kXa;
  private static final int kXb;
  public static final Column kiW;
  private static final int kjy;
  private static final int kwO;
  public static final Column kwi;
  private static final StorageObserverOwner<g> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean Tuh = true;
  private boolean Tui = true;
  private boolean Tuj = true;
  private boolean Tuk = true;
  private boolean Tul = true;
  private boolean Tum = true;
  private boolean Tun = true;
  private boolean __hadSetuserName = true;
  public String field_bigHeadImgUrl;
  public int field_block;
  public int field_canTalk;
  public String field_city;
  public String field_country;
  public String field_nickname;
  public String field_province;
  public String field_sessionId;
  public int field_sex;
  public String field_signature;
  public String field_smallHeadImgUrl;
  public String field_textStatusExtInfo;
  public String field_textStatusId;
  public String field_userName;
  private boolean jKU = true;
  private boolean jTo = true;
  private boolean kWQ = true;
  private boolean kWR = true;
  private boolean kjk = true;
  private boolean kwy = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kiW = new Column("sessionId", "string", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    kwi = new Column("sex", "int", TABLE.getName(), "");
    kWG = new Column("province", "string", TABLE.getName(), "");
    kWH = new Column("city", "string", TABLE.getName(), "");
    jKD = new Column("signature", "string", TABLE.getName(), "");
    Tub = new Column("bigHeadImgUrl", "string", TABLE.getName(), "");
    Tuc = new Column("smallHeadImgUrl", "string", TABLE.getName(), "");
    Tud = new Column("textStatusExtInfo", "string", TABLE.getName(), "");
    Tue = new Column("country", "string", TABLE.getName(), "");
    TtN = new Column("textStatusId", "string", TABLE.getName(), "");
    Tuf = new Column("block", "int", TABLE.getName(), "");
    Tug = new Column("canTalk", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS TextStatusStrangerContact_sessionId_index ON TextStatusStrangerContact(sessionId)", "CREATE INDEX IF NOT EXISTS TextStatusStrangerContact_userName_index ON TextStatusStrangerContact(userName)" };
    kjy = "sessionId".hashCode();
    userName_HASHCODE = "userName".hashCode();
    jTs = "nickname".hashCode();
    kwO = "sex".hashCode();
    kXa = "province".hashCode();
    kXb = "city".hashCode();
    jLl = "signature".hashCode();
    Tuo = "bigHeadImgUrl".hashCode();
    Tup = "smallHeadImgUrl".hashCode();
    Tuq = "textStatusExtInfo".hashCode();
    Tur = "country".hashCode();
    Tus = "textStatusId".hashCode();
    Tut = "block".hashCode();
    Tuu = "canTalk".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[14];
    localMAutoDBInfo.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "sessionId";
    localMAutoDBInfo.colsMap.put("sessionId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" sessionId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "sessionId";
    localMAutoDBInfo.columns[1] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default '' ");
    localStringBuilder.append(" userName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "sex";
    localMAutoDBInfo.colsMap.put("sex", "INTEGER");
    localStringBuilder.append(" sex INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "province";
    localMAutoDBInfo.colsMap.put("province", "TEXT");
    localStringBuilder.append(" province TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "city";
    localMAutoDBInfo.colsMap.put("city", "TEXT");
    localStringBuilder.append(" city TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "bigHeadImgUrl";
    localMAutoDBInfo.colsMap.put("bigHeadImgUrl", "TEXT");
    localStringBuilder.append(" bigHeadImgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "smallHeadImgUrl";
    localMAutoDBInfo.colsMap.put("smallHeadImgUrl", "TEXT");
    localStringBuilder.append(" smallHeadImgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "textStatusExtInfo";
    localMAutoDBInfo.colsMap.put("textStatusExtInfo", "TEXT");
    localStringBuilder.append(" textStatusExtInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "country";
    localMAutoDBInfo.colsMap.put("country", "TEXT");
    localStringBuilder.append(" country TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "textStatusId";
    localMAutoDBInfo.colsMap.put("textStatusId", "TEXT");
    localStringBuilder.append(" textStatusId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "block";
    localMAutoDBInfo.colsMap.put("block", "INTEGER");
    localStringBuilder.append(" block INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "canTalk";
    localMAutoDBInfo.colsMap.put("canTalk", "INTEGER");
    localStringBuilder.append(" canTalk INTEGER");
    localMAutoDBInfo.columns[14] = "rowid";
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
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("sex"))
    {
      this.field_sex = paramContentValues.getAsInteger("sex").intValue();
      if (paramBoolean) {
        this.kwy = true;
      }
    }
    if (paramContentValues.containsKey("province"))
    {
      this.field_province = paramContentValues.getAsString("province");
      if (paramBoolean) {
        this.kWQ = true;
      }
    }
    if (paramContentValues.containsKey("city"))
    {
      this.field_city = paramContentValues.getAsString("city");
      if (paramBoolean) {
        this.kWR = true;
      }
    }
    if (paramContentValues.containsKey("signature"))
    {
      this.field_signature = paramContentValues.getAsString("signature");
      if (paramBoolean) {
        this.jKU = true;
      }
    }
    if (paramContentValues.containsKey("bigHeadImgUrl"))
    {
      this.field_bigHeadImgUrl = paramContentValues.getAsString("bigHeadImgUrl");
      if (paramBoolean) {
        this.Tuh = true;
      }
    }
    if (paramContentValues.containsKey("smallHeadImgUrl"))
    {
      this.field_smallHeadImgUrl = paramContentValues.getAsString("smallHeadImgUrl");
      if (paramBoolean) {
        this.Tui = true;
      }
    }
    if (paramContentValues.containsKey("textStatusExtInfo"))
    {
      this.field_textStatusExtInfo = paramContentValues.getAsString("textStatusExtInfo");
      if (paramBoolean) {
        this.Tuj = true;
      }
    }
    if (paramContentValues.containsKey("country"))
    {
      this.field_country = paramContentValues.getAsString("country");
      if (paramBoolean) {
        this.Tuk = true;
      }
    }
    if (paramContentValues.containsKey("textStatusId"))
    {
      this.field_textStatusId = paramContentValues.getAsString("textStatusId");
      if (paramBoolean) {
        this.Tul = true;
      }
    }
    if (paramContentValues.containsKey("block"))
    {
      this.field_block = paramContentValues.getAsInteger("block").intValue();
      if (paramBoolean) {
        this.Tum = true;
      }
    }
    if (paramContentValues.containsKey("canTalk"))
    {
      this.field_canTalk = paramContentValues.getAsInteger("canTalk").intValue();
      if (paramBoolean) {
        this.Tun = true;
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
      if (userName_HASHCODE == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (kwO == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (kXa == k) {
        this.field_province = paramCursor.getString(i);
      } else if (kXb == k) {
        this.field_city = paramCursor.getString(i);
      } else if (jLl == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (Tuo == k) {
        this.field_bigHeadImgUrl = paramCursor.getString(i);
      } else if (Tup == k) {
        this.field_smallHeadImgUrl = paramCursor.getString(i);
      } else if (Tuq == k) {
        this.field_textStatusExtInfo = paramCursor.getString(i);
      } else if (Tur == k) {
        this.field_country = paramCursor.getString(i);
      } else if (Tus == k) {
        this.field_textStatusId = paramCursor.getString(i);
      } else if (Tut == k) {
        this.field_block = paramCursor.getInt(i);
      } else if (Tuu == k) {
        this.field_canTalk = paramCursor.getInt(i);
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
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.kwy) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.kWQ) {
      localContentValues.put("province", this.field_province);
    }
    if (this.kWR) {
      localContentValues.put("city", this.field_city);
    }
    if (this.jKU) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.Tuh) {
      localContentValues.put("bigHeadImgUrl", this.field_bigHeadImgUrl);
    }
    if (this.Tui) {
      localContentValues.put("smallHeadImgUrl", this.field_smallHeadImgUrl);
    }
    if (this.Tuj) {
      localContentValues.put("textStatusExtInfo", this.field_textStatusExtInfo);
    }
    if (this.Tuk) {
      localContentValues.put("country", this.field_country);
    }
    if (this.Tul) {
      localContentValues.put("textStatusId", this.field_textStatusId);
    }
    if (this.Tum) {
      localContentValues.put("block", Integer.valueOf(this.field_block));
    }
    if (this.Tun) {
      localContentValues.put("canTalk", Integer.valueOf(this.field_canTalk));
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
  
  public StorageObserverOwner<? extends g> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.g
 * JD-Core Version:    0.7.0.1
 */