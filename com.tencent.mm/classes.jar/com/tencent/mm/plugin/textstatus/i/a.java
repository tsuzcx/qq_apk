package com.tencent.mm.plugin.textstatus.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class a
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS TextStatus_USERNAME_index ON TextStatus(UserName)" };
  public static final Column MGU;
  public static final Column MGV;
  public static final Column MGW;
  public static final Column MGX;
  public static final Column MGY;
  public static final Column MGZ;
  private static final int MHR;
  private static final int MHS;
  private static final int MHT;
  private static final int MHU;
  private static final int MHV;
  private static final int MHW;
  private static final int MHX;
  private static final int MHY;
  private static final int MHZ;
  public static final Column MHa;
  public static final Column MHb;
  public static final Column MHc;
  public static final Column MHd;
  public static final Column MHe;
  public static final Column MHf;
  public static final Column MHg;
  public static final Column MHh;
  public static final Column MHi;
  public static final Column MHj;
  public static final Column MHk;
  public static final Column MHl;
  public static final Column MHm;
  public static final Column MHn;
  public static final Column MHo;
  public static final Column MHp;
  private static final int MIa;
  private static final int MIb;
  private static final int MIc;
  private static final int MId;
  private static final int MIe;
  private static final int MIf;
  private static final int MIg;
  private static final int MIh;
  private static final int MIi;
  private static final int MIj = "backgroundId".hashCode();
  private static final int MIk = "option".hashCode();
  private static final int MIl = "mediaWidth".hashCode();
  private static final int MIm = "mediaHeight".hashCode();
  private static final int MIn = "visibilityInfo".hashCode();
  private static final int MIo = "referenceUserName".hashCode();
  private static final int MIp = "referenceTextStatusId".hashCode();
  private static final int MIq = "referenceCount".hashCode();
  private static final int MIr = "sceneType".hashCode();
  public static final SingleTable TABLE = new SingleTable("TextStatus");
  public static final Column hHa;
  private static final int hIC;
  public static final Column hLI;
  private static final int hVP;
  private static final int hVR;
  private static final int hVT;
  public static final Column hXP;
  public static final Column hXT;
  public static final Column hZf;
  public static final Column hsb;
  public static final Column ies;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean MHA = true;
  private boolean MHB = true;
  private boolean MHC = true;
  private boolean MHD = true;
  private boolean MHE = true;
  private boolean MHF = true;
  private boolean MHG = true;
  private boolean MHH = true;
  private boolean MHI = true;
  private boolean MHJ = true;
  private boolean MHK = true;
  private boolean MHL = true;
  private boolean MHM = true;
  private boolean MHN = true;
  private boolean MHO = true;
  private boolean MHP = true;
  private boolean MHQ = true;
  private boolean MHq = true;
  private boolean MHr = true;
  private boolean MHs = true;
  private boolean MHt = true;
  private boolean MHu = true;
  private boolean MHv = true;
  private boolean MHw = true;
  private boolean MHx = true;
  private boolean MHy = true;
  private boolean MHz = true;
  public byte[] field_ClusterShowInfo;
  public int field_CreateTime;
  public String field_Description;
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
  public int field_mediaHeight;
  public int field_mediaWidth;
  public Long field_option;
  public int field_referenceCount;
  public String field_referenceTextStatusId;
  public String field_referenceUserName;
  public int field_sceneType;
  public int field_state;
  public String field_visibilityInfo;
  private boolean hHO = true;
  private boolean hVG = true;
  private boolean hVI = true;
  private boolean hVK = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "TextStatus", "");
    C_USERNAME = new Column("username", "string", "TextStatus", "");
    MGU = new Column("statusid", "string", "TextStatus", "");
    MGV = new Column("topicid", "string", "TextStatus", "");
    hLI = new Column("sourceid", "string", "TextStatus", "");
    MGW = new Column("topicinfo", "byte[]", "TextStatus", "");
    MGX = new Column("clustershowinfo", "byte[]", "TextStatus", "");
    MGY = new Column("iconid", "string", "TextStatus", "");
    hsb = new Column("description", "string", "TextStatus", "");
    hXP = new Column("mediatype", "int", "TextStatus", "");
    hXT = new Column("mediaurl", "string", "TextStatus", "");
    MGZ = new Column("mediaaeskey", "string", "TextStatus", "");
    MHa = new Column("mediathumburl", "string", "TextStatus", "");
    MHb = new Column("mediathumbaeskey", "string", "TextStatus", "");
    MHc = new Column("poiid", "string", "TextStatus", "");
    MHd = new Column("poiname", "string", "TextStatus", "");
    MHe = new Column("longitude", "double", "TextStatus", "");
    MHf = new Column("latitude", "double", "TextStatus", "");
    MHg = new Column("visibility", "int", "TextStatus", "");
    C_CREATETIME = new Column("createtime", "int", "TextStatus", "");
    hZf = new Column("expiretime", "int", "TextStatus", "");
    ies = new Column("likecount", "int", "TextStatus", "");
    hHa = new Column("state", "int", "TextStatus", "");
    MHh = new Column("backgroundid", "string", "TextStatus", "");
    MHi = new Column("option", "long", "TextStatus", "");
    MHj = new Column("mediawidth", "int", "TextStatus", "");
    MHk = new Column("mediaheight", "int", "TextStatus", "");
    MHl = new Column("visibilityinfo", "string", "TextStatus", "");
    MHm = new Column("referenceusername", "string", "TextStatus", "");
    MHn = new Column("referencetextstatusid", "string", "TextStatus", "");
    MHo = new Column("referencecount", "int", "TextStatus", "");
    MHp = new Column("scenetype", "int", "TextStatus", "");
    hVT = "UserName".hashCode();
    MHR = "StatusID".hashCode();
    MHS = "TopicId".hashCode();
    MHT = "SourceID".hashCode();
    MHU = "TopicInfo".hashCode();
    MHV = "ClusterShowInfo".hashCode();
    MHW = "IconID".hashCode();
    hVR = "Description".hashCode();
    MHX = "MediaType".hashCode();
    MHY = "MediaUrl".hashCode();
    MHZ = "MediaAESKey".hashCode();
    MIa = "MediaThumbUrl".hashCode();
    MIb = "MediaThumbAESKey".hashCode();
    MIc = "PoiID".hashCode();
    MId = "PoiName".hashCode();
    MIe = "Longitude".hashCode();
    MIf = "Latitude".hashCode();
    MIg = "Visibility".hashCode();
    hVP = "CreateTime".hashCode();
    MIh = "ExpireTime".hashCode();
    MIi = "LikeCount".hashCode();
    hIC = "state".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[31];
    localMAutoDBInfo.columns = new String[32];
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
    localMAutoDBInfo.columns[31] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (hVT != k) {
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
      if (MHR == k) {
        this.field_StatusID = paramCursor.getString(i);
      } else if (MHS == k) {
        this.field_TopicId = paramCursor.getString(i);
      } else if (MHT == k) {
        this.field_SourceID = paramCursor.getString(i);
      } else if (MHU == k) {
        this.field_TopicInfo = paramCursor.getBlob(i);
      } else if (MHV == k) {
        this.field_ClusterShowInfo = paramCursor.getBlob(i);
      } else if (MHW == k) {
        this.field_IconID = paramCursor.getString(i);
      } else if (hVR == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (MHX == k) {
        this.field_MediaType = paramCursor.getInt(i);
      } else if (MHY == k) {
        this.field_MediaUrl = paramCursor.getString(i);
      } else if (MHZ == k) {
        this.field_MediaAESKey = paramCursor.getString(i);
      } else if (MIa == k) {
        this.field_MediaThumbUrl = paramCursor.getString(i);
      } else if (MIb == k) {
        this.field_MediaThumbAESKey = paramCursor.getString(i);
      } else if (MIc == k) {
        this.field_PoiID = paramCursor.getString(i);
      } else if (MId == k) {
        this.field_PoiName = paramCursor.getString(i);
      } else if (MIe == k) {
        this.field_Longitude = paramCursor.getDouble(i);
      } else if (MIf == k) {
        this.field_Latitude = paramCursor.getDouble(i);
      } else if (MIg == k) {
        this.field_Visibility = paramCursor.getInt(i);
      } else if (hVP == k) {
        this.field_CreateTime = paramCursor.getInt(i);
      } else if (MIh == k) {
        this.field_ExpireTime = paramCursor.getInt(i);
      } else if (MIi == k) {
        this.field_LikeCount = paramCursor.getInt(i);
      } else if (hIC == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (MIj == k) {
        this.field_backgroundId = paramCursor.getString(i);
      } else if (MIk == k) {
        this.field_option = Long.valueOf(paramCursor.getLong(i));
      } else if (MIl == k) {
        this.field_mediaWidth = paramCursor.getInt(i);
      } else if (MIm == k) {
        this.field_mediaHeight = paramCursor.getInt(i);
      } else if (MIn == k) {
        this.field_visibilityInfo = paramCursor.getString(i);
      } else if (MIo == k) {
        this.field_referenceUserName = paramCursor.getString(i);
      } else if (MIp == k) {
        this.field_referenceTextStatusId = paramCursor.getString(i);
      } else if (MIq == k) {
        this.field_referenceCount = paramCursor.getInt(i);
      } else if (MIr == k) {
        this.field_sceneType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hVK) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.MHq) {
      localContentValues.put("StatusID", this.field_StatusID);
    }
    if (this.MHr) {
      localContentValues.put("TopicId", this.field_TopicId);
    }
    if (this.MHs) {
      localContentValues.put("SourceID", this.field_SourceID);
    }
    if (this.MHt) {
      localContentValues.put("TopicInfo", this.field_TopicInfo);
    }
    if (this.MHu) {
      localContentValues.put("ClusterShowInfo", this.field_ClusterShowInfo);
    }
    if (this.MHv) {
      localContentValues.put("IconID", this.field_IconID);
    }
    if (this.hVI) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.MHw) {
      localContentValues.put("MediaType", Integer.valueOf(this.field_MediaType));
    }
    if (this.MHx) {
      localContentValues.put("MediaUrl", this.field_MediaUrl);
    }
    if (this.MHy) {
      localContentValues.put("MediaAESKey", this.field_MediaAESKey);
    }
    if (this.MHz) {
      localContentValues.put("MediaThumbUrl", this.field_MediaThumbUrl);
    }
    if (this.MHA) {
      localContentValues.put("MediaThumbAESKey", this.field_MediaThumbAESKey);
    }
    if (this.MHB) {
      localContentValues.put("PoiID", this.field_PoiID);
    }
    if (this.MHC) {
      localContentValues.put("PoiName", this.field_PoiName);
    }
    if (this.MHD) {
      localContentValues.put("Longitude", Double.valueOf(this.field_Longitude));
    }
    if (this.MHE) {
      localContentValues.put("Latitude", Double.valueOf(this.field_Latitude));
    }
    if (this.MHF) {
      localContentValues.put("Visibility", Integer.valueOf(this.field_Visibility));
    }
    if (this.hVG) {
      localContentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
    }
    if (this.MHG) {
      localContentValues.put("ExpireTime", Integer.valueOf(this.field_ExpireTime));
    }
    if (this.MHH) {
      localContentValues.put("LikeCount", Integer.valueOf(this.field_LikeCount));
    }
    if (this.hHO) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.MHI) {
      localContentValues.put("backgroundId", this.field_backgroundId);
    }
    if (this.MHJ) {
      localContentValues.put("option", this.field_option);
    }
    if (this.MHK) {
      localContentValues.put("mediaWidth", Integer.valueOf(this.field_mediaWidth));
    }
    if (this.MHL) {
      localContentValues.put("mediaHeight", Integer.valueOf(this.field_mediaHeight));
    }
    if (this.MHM) {
      localContentValues.put("visibilityInfo", this.field_visibilityInfo);
    }
    if (this.MHN) {
      localContentValues.put("referenceUserName", this.field_referenceUserName);
    }
    if (this.MHO) {
      localContentValues.put("referenceTextStatusId", this.field_referenceTextStatusId);
    }
    if (this.MHP) {
      localContentValues.put("referenceCount", Integer.valueOf(this.field_referenceCount));
    }
    if (this.MHQ) {
      localContentValues.put("sceneType", Integer.valueOf(this.field_sceneType));
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
    return "TextStatus";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.a
 * JD-Core Version:    0.7.0.1
 */