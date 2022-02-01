package com.tencent.mm.plugin.textstatus.j;

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
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("TextStatus");
  public static final Column TrA;
  public static final Column TrB;
  public static final Column TrC;
  public static final Column TrD;
  public static final Column TrE;
  public static final Column TrF;
  public static final Column TrG;
  public static final Column TrH;
  public static final Column TrI;
  public static final Column TrJ;
  public static final Column TrK;
  public static final Column TrL;
  public static final Column TrM;
  public static final Column TrN;
  public static final Column TrO;
  public static final Column TrP;
  public static final Column TrQ;
  public static final Column TrR;
  public static final Column TrS;
  public static final Column TrT;
  public static final Column TrU;
  public static final Column TrV;
  public static final Column TrW;
  public static final Column Try;
  public static final Column Trz;
  private static final int TsB;
  private static final int TsC;
  private static final int TsD;
  private static final int TsE;
  private static final int TsF;
  private static final int TsG;
  private static final int TsH;
  private static final int TsI;
  private static final int TsJ;
  private static final int TsK;
  private static final int TsL;
  private static final int TsM;
  private static final int TsN;
  private static final int TsO;
  private static final int TsP;
  private static final int TsQ;
  private static final int TsR;
  private static final int TsS;
  private static final int TsT;
  private static final int TsU;
  private static final int TsV;
  private static final int TsW;
  private static final int TsX;
  private static final int TsY;
  private static final int TsZ;
  private static final int Tta;
  private static final int Ttb;
  private static final int Ttc;
  private static final int Ttd;
  private static final int Tte;
  public static final com.tencent.mm.plugin.textstatus.h.f.a Ttf = new com.tencent.mm.plugin.textstatus.h.f.a();
  public static final Column USERNAME;
  public static final Column jOO;
  public static final Column kDC;
  public static final Column kee;
  private static final int kfH;
  public static final Column kiM;
  public static final Column kpG;
  private static final int kvb;
  private static final int kvd;
  private static final int kvf;
  public static final Column kxe;
  public static final Column kyq;
  private static final StorageObserverOwner<a> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean TrX = true;
  private boolean TrY = true;
  private boolean TrZ = true;
  private boolean TsA = true;
  private boolean Tsa = true;
  private boolean Tsb = true;
  private boolean Tsc = true;
  private boolean Tsd = true;
  private boolean Tse = true;
  private boolean Tsf = true;
  private boolean Tsg = true;
  private boolean Tsh = true;
  private boolean Tsi = true;
  private boolean Tsj = true;
  private boolean Tsk = true;
  private boolean Tsl = true;
  private boolean Tsm = true;
  private boolean Tsn = true;
  private boolean Tso = true;
  private boolean Tsp = true;
  private boolean Tsq = true;
  private boolean Tsr = true;
  private boolean Tss = true;
  private boolean Tst = true;
  private boolean Tsu = true;
  private boolean Tsv = true;
  private boolean Tsw = true;
  private boolean Tsx = true;
  private boolean Tsy = true;
  private boolean Tsz = true;
  public byte[] field_ClusterShowInfo;
  public int field_CreateTime;
  public String field_Description;
  public byte[] field_EmojiInfo;
  public int field_ExpireTime;
  public String field_IconID;
  public double field_Latitude;
  public int field_LikeCount;
  public double field_Longitude;
  public String field_MediaAESKey;
  public String field_MediaThumbAESKey;
  public String field_MediaThumbUrl;
  public int field_MediaType;
  public String field_MediaUrl;
  public String field_PoiID;
  public String field_PoiName;
  public String field_SourceID;
  public String field_StatusID;
  public String field_TopicId;
  public byte[] field_TopicInfo;
  public String field_UserName;
  public int field_Visibility;
  public String field_backgroundId;
  public String field_duplicateTextStatusId;
  public String field_duplicateUserName;
  public int field_mediaHeight;
  public int field_mediaWidth;
  public Long field_option;
  public int field_referenceCount;
  public String field_referenceTextStatusId;
  public String field_referenceUserName;
  public int field_sceneType;
  public int field_state;
  public String field_visibilityInfo;
  private boolean keT = true;
  private boolean kuS = true;
  private boolean kuU = true;
  private boolean kuW = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("UserName", "string", TABLE.getName(), "");
    Try = new Column("StatusID", "string", TABLE.getName(), "");
    Trz = new Column("TopicId", "string", TABLE.getName(), "");
    kiM = new Column("SourceID", "string", TABLE.getName(), "");
    TrA = new Column("TopicInfo", "byte[]", TABLE.getName(), "");
    TrB = new Column("ClusterShowInfo", "byte[]", TABLE.getName(), "");
    TrC = new Column("IconID", "string", TABLE.getName(), "");
    jOO = new Column("Description", "string", TABLE.getName(), "");
    kpG = new Column("MediaType", "int", TABLE.getName(), "");
    kxe = new Column("MediaUrl", "string", TABLE.getName(), "");
    TrD = new Column("MediaAESKey", "string", TABLE.getName(), "");
    TrE = new Column("MediaThumbUrl", "string", TABLE.getName(), "");
    TrF = new Column("MediaThumbAESKey", "string", TABLE.getName(), "");
    TrG = new Column("PoiID", "string", TABLE.getName(), "");
    TrH = new Column("PoiName", "string", TABLE.getName(), "");
    TrI = new Column("Longitude", "double", TABLE.getName(), "");
    TrJ = new Column("Latitude", "double", TABLE.getName(), "");
    TrK = new Column("Visibility", "int", TABLE.getName(), "");
    CREATETIME = new Column("CreateTime", "int", TABLE.getName(), "");
    kyq = new Column("ExpireTime", "int", TABLE.getName(), "");
    kDC = new Column("LikeCount", "int", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    TrL = new Column("backgroundId", "string", TABLE.getName(), "");
    TrM = new Column("option", "long", TABLE.getName(), "");
    TrN = new Column("mediaWidth", "int", TABLE.getName(), "");
    TrO = new Column("mediaHeight", "int", TABLE.getName(), "");
    TrP = new Column("visibilityInfo", "string", TABLE.getName(), "");
    TrQ = new Column("referenceUserName", "string", TABLE.getName(), "");
    TrR = new Column("referenceTextStatusId", "string", TABLE.getName(), "");
    TrS = new Column("referenceCount", "int", TABLE.getName(), "");
    TrT = new Column("sceneType", "int", TABLE.getName(), "");
    TrU = new Column("duplicateUserName", "string", TABLE.getName(), "");
    TrV = new Column("duplicateTextStatusId", "string", TABLE.getName(), "");
    TrW = new Column("EmojiInfo", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS TextStatus_USERNAME_index ON TextStatus(UserName)", "CREATE INDEX IF NOT EXISTS TextStatus_ExpireTime_index ON TextStatus(ExpireTime)" };
    kvf = "UserName".hashCode();
    TsB = "StatusID".hashCode();
    TsC = "TopicId".hashCode();
    TsD = "SourceID".hashCode();
    TsE = "TopicInfo".hashCode();
    TsF = "ClusterShowInfo".hashCode();
    TsG = "IconID".hashCode();
    kvd = "Description".hashCode();
    TsH = "MediaType".hashCode();
    TsI = "MediaUrl".hashCode();
    TsJ = "MediaAESKey".hashCode();
    TsK = "MediaThumbUrl".hashCode();
    TsL = "MediaThumbAESKey".hashCode();
    TsM = "PoiID".hashCode();
    TsN = "PoiName".hashCode();
    TsO = "Longitude".hashCode();
    TsP = "Latitude".hashCode();
    TsQ = "Visibility".hashCode();
    kvb = "CreateTime".hashCode();
    TsR = "ExpireTime".hashCode();
    TsS = "LikeCount".hashCode();
    kfH = "state".hashCode();
    TsT = "backgroundId".hashCode();
    TsU = "option".hashCode();
    TsV = "mediaWidth".hashCode();
    TsW = "mediaHeight".hashCode();
    TsX = "visibilityInfo".hashCode();
    TsY = "referenceUserName".hashCode();
    TsZ = "referenceTextStatusId".hashCode();
    Tta = "referenceCount".hashCode();
    Ttb = "sceneType".hashCode();
    Ttc = "duplicateUserName".hashCode();
    Ttd = "duplicateTextStatusId".hashCode();
    Tte = "EmojiInfo".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[34];
    localMAutoDBInfo.columns = new String[35];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "UserName";
    localMAutoDBInfo.colsMap.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "StatusID";
    localMAutoDBInfo.colsMap.put("StatusID", "TEXT");
    localStringBuilder.append(" StatusID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "TopicId";
    localMAutoDBInfo.colsMap.put("TopicId", "TEXT");
    localStringBuilder.append(" TopicId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "SourceID";
    localMAutoDBInfo.colsMap.put("SourceID", "TEXT");
    localStringBuilder.append(" SourceID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "TopicInfo";
    localMAutoDBInfo.colsMap.put("TopicInfo", "BLOB");
    localStringBuilder.append(" TopicInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "ClusterShowInfo";
    localMAutoDBInfo.colsMap.put("ClusterShowInfo", "BLOB");
    localStringBuilder.append(" ClusterShowInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "IconID";
    localMAutoDBInfo.colsMap.put("IconID", "TEXT");
    localStringBuilder.append(" IconID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "Description";
    localMAutoDBInfo.colsMap.put("Description", "TEXT");
    localStringBuilder.append(" Description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "MediaType";
    localMAutoDBInfo.colsMap.put("MediaType", "INTEGER");
    localStringBuilder.append(" MediaType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "MediaUrl";
    localMAutoDBInfo.colsMap.put("MediaUrl", "TEXT");
    localStringBuilder.append(" MediaUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "MediaAESKey";
    localMAutoDBInfo.colsMap.put("MediaAESKey", "TEXT");
    localStringBuilder.append(" MediaAESKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "MediaThumbUrl";
    localMAutoDBInfo.colsMap.put("MediaThumbUrl", "TEXT");
    localStringBuilder.append(" MediaThumbUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "MediaThumbAESKey";
    localMAutoDBInfo.colsMap.put("MediaThumbAESKey", "TEXT");
    localStringBuilder.append(" MediaThumbAESKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "PoiID";
    localMAutoDBInfo.colsMap.put("PoiID", "TEXT");
    localStringBuilder.append(" PoiID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "PoiName";
    localMAutoDBInfo.colsMap.put("PoiName", "TEXT");
    localStringBuilder.append(" PoiName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "Longitude";
    localMAutoDBInfo.colsMap.put("Longitude", "DOUBLE");
    localStringBuilder.append(" Longitude DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "Latitude";
    localMAutoDBInfo.colsMap.put("Latitude", "DOUBLE");
    localStringBuilder.append(" Latitude DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "Visibility";
    localMAutoDBInfo.colsMap.put("Visibility", "INTEGER");
    localStringBuilder.append(" Visibility INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "CreateTime";
    localMAutoDBInfo.colsMap.put("CreateTime", "INTEGER");
    localStringBuilder.append(" CreateTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "ExpireTime";
    localMAutoDBInfo.colsMap.put("ExpireTime", "INTEGER");
    localStringBuilder.append(" ExpireTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "LikeCount";
    localMAutoDBInfo.colsMap.put("LikeCount", "INTEGER");
    localStringBuilder.append(" LikeCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "backgroundId";
    localMAutoDBInfo.colsMap.put("backgroundId", "TEXT");
    localStringBuilder.append(" backgroundId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "option";
    localMAutoDBInfo.colsMap.put("option", "LONG");
    localStringBuilder.append(" option LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "mediaWidth";
    localMAutoDBInfo.colsMap.put("mediaWidth", "INTEGER");
    localStringBuilder.append(" mediaWidth INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "mediaHeight";
    localMAutoDBInfo.colsMap.put("mediaHeight", "INTEGER");
    localStringBuilder.append(" mediaHeight INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "visibilityInfo";
    localMAutoDBInfo.colsMap.put("visibilityInfo", "TEXT");
    localStringBuilder.append(" visibilityInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "referenceUserName";
    localMAutoDBInfo.colsMap.put("referenceUserName", "TEXT");
    localStringBuilder.append(" referenceUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "referenceTextStatusId";
    localMAutoDBInfo.colsMap.put("referenceTextStatusId", "TEXT");
    localStringBuilder.append(" referenceTextStatusId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "referenceCount";
    localMAutoDBInfo.colsMap.put("referenceCount", "INTEGER");
    localStringBuilder.append(" referenceCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "sceneType";
    localMAutoDBInfo.colsMap.put("sceneType", "INTEGER");
    localStringBuilder.append(" sceneType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "duplicateUserName";
    localMAutoDBInfo.colsMap.put("duplicateUserName", "TEXT");
    localStringBuilder.append(" duplicateUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "duplicateTextStatusId";
    localMAutoDBInfo.colsMap.put("duplicateTextStatusId", "TEXT");
    localStringBuilder.append(" duplicateTextStatusId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "EmojiInfo";
    localMAutoDBInfo.colsMap.put("EmojiInfo", "BLOB");
    localStringBuilder.append(" EmojiInfo BLOB");
    localMAutoDBInfo.columns[34] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("UserName"))
    {
      this.field_UserName = paramContentValues.getAsString("UserName");
      if (paramBoolean) {
        this.kuW = true;
      }
    }
    if (paramContentValues.containsKey("StatusID"))
    {
      this.field_StatusID = paramContentValues.getAsString("StatusID");
      if (paramBoolean) {
        this.TrX = true;
      }
    }
    if (paramContentValues.containsKey("TopicId"))
    {
      this.field_TopicId = paramContentValues.getAsString("TopicId");
      if (paramBoolean) {
        this.TrY = true;
      }
    }
    if (paramContentValues.containsKey("SourceID"))
    {
      this.field_SourceID = paramContentValues.getAsString("SourceID");
      if (paramBoolean) {
        this.TrZ = true;
      }
    }
    if (paramContentValues.containsKey("TopicInfo"))
    {
      this.field_TopicInfo = paramContentValues.getAsByteArray("TopicInfo");
      if (paramBoolean) {
        this.Tsa = true;
      }
    }
    if (paramContentValues.containsKey("ClusterShowInfo"))
    {
      this.field_ClusterShowInfo = paramContentValues.getAsByteArray("ClusterShowInfo");
      if (paramBoolean) {
        this.Tsb = true;
      }
    }
    if (paramContentValues.containsKey("IconID"))
    {
      this.field_IconID = paramContentValues.getAsString("IconID");
      if (paramBoolean) {
        this.Tsc = true;
      }
    }
    if (paramContentValues.containsKey("Description"))
    {
      this.field_Description = paramContentValues.getAsString("Description");
      if (paramBoolean) {
        this.kuU = true;
      }
    }
    if (paramContentValues.containsKey("MediaType"))
    {
      this.field_MediaType = paramContentValues.getAsInteger("MediaType").intValue();
      if (paramBoolean) {
        this.Tsd = true;
      }
    }
    if (paramContentValues.containsKey("MediaUrl"))
    {
      this.field_MediaUrl = paramContentValues.getAsString("MediaUrl");
      if (paramBoolean) {
        this.Tse = true;
      }
    }
    if (paramContentValues.containsKey("MediaAESKey"))
    {
      this.field_MediaAESKey = paramContentValues.getAsString("MediaAESKey");
      if (paramBoolean) {
        this.Tsf = true;
      }
    }
    if (paramContentValues.containsKey("MediaThumbUrl"))
    {
      this.field_MediaThumbUrl = paramContentValues.getAsString("MediaThumbUrl");
      if (paramBoolean) {
        this.Tsg = true;
      }
    }
    if (paramContentValues.containsKey("MediaThumbAESKey"))
    {
      this.field_MediaThumbAESKey = paramContentValues.getAsString("MediaThumbAESKey");
      if (paramBoolean) {
        this.Tsh = true;
      }
    }
    if (paramContentValues.containsKey("PoiID"))
    {
      this.field_PoiID = paramContentValues.getAsString("PoiID");
      if (paramBoolean) {
        this.Tsi = true;
      }
    }
    if (paramContentValues.containsKey("PoiName"))
    {
      this.field_PoiName = paramContentValues.getAsString("PoiName");
      if (paramBoolean) {
        this.Tsj = true;
      }
    }
    if (paramContentValues.containsKey("Longitude"))
    {
      this.field_Longitude = paramContentValues.getAsDouble("Longitude").doubleValue();
      if (paramBoolean) {
        this.Tsk = true;
      }
    }
    if (paramContentValues.containsKey("Latitude"))
    {
      this.field_Latitude = paramContentValues.getAsDouble("Latitude").doubleValue();
      if (paramBoolean) {
        this.Tsl = true;
      }
    }
    if (paramContentValues.containsKey("Visibility"))
    {
      this.field_Visibility = paramContentValues.getAsInteger("Visibility").intValue();
      if (paramBoolean) {
        this.Tsm = true;
      }
    }
    if (paramContentValues.containsKey("CreateTime"))
    {
      this.field_CreateTime = paramContentValues.getAsInteger("CreateTime").intValue();
      if (paramBoolean) {
        this.kuS = true;
      }
    }
    if (paramContentValues.containsKey("ExpireTime"))
    {
      this.field_ExpireTime = paramContentValues.getAsInteger("ExpireTime").intValue();
      if (paramBoolean) {
        this.Tsn = true;
      }
    }
    if (paramContentValues.containsKey("LikeCount"))
    {
      this.field_LikeCount = paramContentValues.getAsInteger("LikeCount").intValue();
      if (paramBoolean) {
        this.Tso = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
      }
    }
    if (paramContentValues.containsKey("backgroundId"))
    {
      this.field_backgroundId = paramContentValues.getAsString("backgroundId");
      if (paramBoolean) {
        this.Tsp = true;
      }
    }
    if (paramContentValues.containsKey("option"))
    {
      this.field_option = paramContentValues.getAsLong("option");
      if (paramBoolean) {
        this.Tsq = true;
      }
    }
    if (paramContentValues.containsKey("mediaWidth"))
    {
      this.field_mediaWidth = paramContentValues.getAsInteger("mediaWidth").intValue();
      if (paramBoolean) {
        this.Tsr = true;
      }
    }
    if (paramContentValues.containsKey("mediaHeight"))
    {
      this.field_mediaHeight = paramContentValues.getAsInteger("mediaHeight").intValue();
      if (paramBoolean) {
        this.Tss = true;
      }
    }
    if (paramContentValues.containsKey("visibilityInfo"))
    {
      this.field_visibilityInfo = paramContentValues.getAsString("visibilityInfo");
      if (paramBoolean) {
        this.Tst = true;
      }
    }
    if (paramContentValues.containsKey("referenceUserName"))
    {
      this.field_referenceUserName = paramContentValues.getAsString("referenceUserName");
      if (paramBoolean) {
        this.Tsu = true;
      }
    }
    if (paramContentValues.containsKey("referenceTextStatusId"))
    {
      this.field_referenceTextStatusId = paramContentValues.getAsString("referenceTextStatusId");
      if (paramBoolean) {
        this.Tsv = true;
      }
    }
    if (paramContentValues.containsKey("referenceCount"))
    {
      this.field_referenceCount = paramContentValues.getAsInteger("referenceCount").intValue();
      if (paramBoolean) {
        this.Tsw = true;
      }
    }
    if (paramContentValues.containsKey("sceneType"))
    {
      this.field_sceneType = paramContentValues.getAsInteger("sceneType").intValue();
      if (paramBoolean) {
        this.Tsx = true;
      }
    }
    if (paramContentValues.containsKey("duplicateUserName"))
    {
      this.field_duplicateUserName = paramContentValues.getAsString("duplicateUserName");
      if (paramBoolean) {
        this.Tsy = true;
      }
    }
    if (paramContentValues.containsKey("duplicateTextStatusId"))
    {
      this.field_duplicateTextStatusId = paramContentValues.getAsString("duplicateTextStatusId");
      if (paramBoolean) {
        this.Tsz = true;
      }
    }
    if (paramContentValues.containsKey("EmojiInfo"))
    {
      this.field_EmojiInfo = paramContentValues.getAsByteArray("EmojiInfo");
      if (paramBoolean) {
        this.TsA = true;
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
      if (kvf != k) {
        break label60;
      }
      this.field_UserName = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (TsB == k) {
        this.field_StatusID = paramCursor.getString(i);
      } else if (TsC == k) {
        this.field_TopicId = paramCursor.getString(i);
      } else if (TsD == k) {
        this.field_SourceID = paramCursor.getString(i);
      } else if (TsE == k) {
        this.field_TopicInfo = paramCursor.getBlob(i);
      } else if (TsF == k) {
        this.field_ClusterShowInfo = paramCursor.getBlob(i);
      } else if (TsG == k) {
        this.field_IconID = paramCursor.getString(i);
      } else if (kvd == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (TsH == k) {
        this.field_MediaType = paramCursor.getInt(i);
      } else if (TsI == k) {
        this.field_MediaUrl = paramCursor.getString(i);
      } else if (TsJ == k) {
        this.field_MediaAESKey = paramCursor.getString(i);
      } else if (TsK == k) {
        this.field_MediaThumbUrl = paramCursor.getString(i);
      } else if (TsL == k) {
        this.field_MediaThumbAESKey = paramCursor.getString(i);
      } else if (TsM == k) {
        this.field_PoiID = paramCursor.getString(i);
      } else if (TsN == k) {
        this.field_PoiName = paramCursor.getString(i);
      } else if (TsO == k) {
        this.field_Longitude = paramCursor.getDouble(i);
      } else if (TsP == k) {
        this.field_Latitude = paramCursor.getDouble(i);
      } else if (TsQ == k) {
        this.field_Visibility = paramCursor.getInt(i);
      } else if (kvb == k) {
        this.field_CreateTime = paramCursor.getInt(i);
      } else if (TsR == k) {
        this.field_ExpireTime = paramCursor.getInt(i);
      } else if (TsS == k) {
        this.field_LikeCount = paramCursor.getInt(i);
      } else if (kfH == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (TsT == k) {
        this.field_backgroundId = paramCursor.getString(i);
      } else if (TsU == k) {
        this.field_option = Long.valueOf(paramCursor.getLong(i));
      } else if (TsV == k) {
        this.field_mediaWidth = paramCursor.getInt(i);
      } else if (TsW == k) {
        this.field_mediaHeight = paramCursor.getInt(i);
      } else if (TsX == k) {
        this.field_visibilityInfo = paramCursor.getString(i);
      } else if (TsY == k) {
        this.field_referenceUserName = paramCursor.getString(i);
      } else if (TsZ == k) {
        this.field_referenceTextStatusId = paramCursor.getString(i);
      } else if (Tta == k) {
        this.field_referenceCount = paramCursor.getInt(i);
      } else if (Ttb == k) {
        this.field_sceneType = paramCursor.getInt(i);
      } else if (Ttc == k) {
        this.field_duplicateUserName = paramCursor.getString(i);
      } else if (Ttd == k) {
        this.field_duplicateTextStatusId = paramCursor.getString(i);
      } else if (Tte == k) {
        this.field_EmojiInfo = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kuW) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.TrX) {
      localContentValues.put("StatusID", this.field_StatusID);
    }
    if (this.TrY) {
      localContentValues.put("TopicId", this.field_TopicId);
    }
    if (this.TrZ) {
      localContentValues.put("SourceID", this.field_SourceID);
    }
    if (this.Tsa) {
      localContentValues.put("TopicInfo", this.field_TopicInfo);
    }
    if (this.Tsb) {
      localContentValues.put("ClusterShowInfo", this.field_ClusterShowInfo);
    }
    if (this.Tsc) {
      localContentValues.put("IconID", this.field_IconID);
    }
    if (this.kuU) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.Tsd) {
      localContentValues.put("MediaType", Integer.valueOf(this.field_MediaType));
    }
    if (this.Tse) {
      localContentValues.put("MediaUrl", this.field_MediaUrl);
    }
    if (this.Tsf) {
      localContentValues.put("MediaAESKey", this.field_MediaAESKey);
    }
    if (this.Tsg) {
      localContentValues.put("MediaThumbUrl", this.field_MediaThumbUrl);
    }
    if (this.Tsh) {
      localContentValues.put("MediaThumbAESKey", this.field_MediaThumbAESKey);
    }
    if (this.Tsi) {
      localContentValues.put("PoiID", this.field_PoiID);
    }
    if (this.Tsj) {
      localContentValues.put("PoiName", this.field_PoiName);
    }
    if (this.Tsk) {
      localContentValues.put("Longitude", Double.valueOf(this.field_Longitude));
    }
    if (this.Tsl) {
      localContentValues.put("Latitude", Double.valueOf(this.field_Latitude));
    }
    if (this.Tsm) {
      localContentValues.put("Visibility", Integer.valueOf(this.field_Visibility));
    }
    if (this.kuS) {
      localContentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
    }
    if (this.Tsn) {
      localContentValues.put("ExpireTime", Integer.valueOf(this.field_ExpireTime));
    }
    if (this.Tso) {
      localContentValues.put("LikeCount", Integer.valueOf(this.field_LikeCount));
    }
    if (this.keT) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.Tsp) {
      localContentValues.put("backgroundId", this.field_backgroundId);
    }
    if (this.Tsq) {
      localContentValues.put("option", this.field_option);
    }
    if (this.Tsr) {
      localContentValues.put("mediaWidth", Integer.valueOf(this.field_mediaWidth));
    }
    if (this.Tss) {
      localContentValues.put("mediaHeight", Integer.valueOf(this.field_mediaHeight));
    }
    if (this.Tst) {
      localContentValues.put("visibilityInfo", this.field_visibilityInfo);
    }
    if (this.Tsu) {
      localContentValues.put("referenceUserName", this.field_referenceUserName);
    }
    if (this.Tsv) {
      localContentValues.put("referenceTextStatusId", this.field_referenceTextStatusId);
    }
    if (this.Tsw) {
      localContentValues.put("referenceCount", Integer.valueOf(this.field_referenceCount));
    }
    if (this.Tsx) {
      localContentValues.put("sceneType", Integer.valueOf(this.field_sceneType));
    }
    if (this.Tsy) {
      localContentValues.put("duplicateUserName", this.field_duplicateUserName);
    }
    if (this.Tsz) {
      localContentValues.put("duplicateTextStatusId", this.field_duplicateTextStatusId);
    }
    if (this.TsA) {
      localContentValues.put("EmojiInfo", this.field_EmojiInfo);
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
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.a
 * JD-Core Version:    0.7.0.1
 */