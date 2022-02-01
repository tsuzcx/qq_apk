package com.tencent.mm.plugin.textstatus.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class a
  extends IAutoDBItem
{
  private static final int GbD;
  private static final int GbE;
  private static final int GbF;
  private static final int GbG;
  private static final int GbH;
  private static final int GbI;
  private static final int GbJ;
  private static final int GbK;
  private static final int GbL;
  private static final int GbM;
  private static final int GbN;
  private static final int GbO;
  private static final int GbP;
  private static final int GbQ;
  private static final int GbR;
  private static final int GbS;
  private static final int GbT;
  private static final int GbU;
  private static final int GbV = "backgroundId".hashCode();
  private static final int GbW = "option".hashCode();
  private static final int GbX = "mediaWidth".hashCode();
  private static final int GbY = "mediaHeight".hashCode();
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS TextStatus_USERNAME_index ON TextStatus(UserName)" };
  private static final int fGA;
  private static final int fGC;
  private static final int fGE = "UserName".hashCode();
  private static final int fyj;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean GbA = true;
  private boolean GbB = true;
  private boolean GbC = true;
  private boolean Gbh = true;
  private boolean Gbi = true;
  private boolean Gbj = true;
  private boolean Gbk = true;
  private boolean Gbl = true;
  private boolean Gbm = true;
  private boolean Gbn = true;
  private boolean Gbo = true;
  private boolean Gbp = true;
  private boolean Gbq = true;
  private boolean Gbr = true;
  private boolean Gbs = true;
  private boolean Gbt = true;
  private boolean Gbu = true;
  private boolean Gbv = true;
  private boolean Gbw = true;
  private boolean Gbx = true;
  private boolean Gby = true;
  private boolean Gbz = true;
  private boolean fGs = true;
  private boolean fGu = true;
  private boolean fGw = true;
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
  public int field_state;
  private boolean fxx = true;
  
  static
  {
    GbD = "StatusID".hashCode();
    GbE = "TopicId".hashCode();
    GbF = "SourceID".hashCode();
    GbG = "TopicInfo".hashCode();
    GbH = "ClusterShowInfo".hashCode();
    GbI = "IconID".hashCode();
    fGC = "Description".hashCode();
    GbJ = "MediaType".hashCode();
    GbK = "MediaUrl".hashCode();
    GbL = "MediaAESKey".hashCode();
    GbM = "MediaThumbUrl".hashCode();
    GbN = "MediaThumbAESKey".hashCode();
    GbO = "PoiID".hashCode();
    GbP = "PoiName".hashCode();
    GbQ = "Longitude".hashCode();
    GbR = "Latitude".hashCode();
    GbS = "Visibility".hashCode();
    fGA = "CreateTime".hashCode();
    GbT = "ExpireTime".hashCode();
    GbU = "LikeCount".hashCode();
    fyj = "state".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[26];
    localMAutoDBInfo.columns = new String[27];
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
    localMAutoDBInfo.columns[26] = "rowid";
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
      if (fGE != k) {
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
      if (GbD == k) {
        this.field_StatusID = paramCursor.getString(i);
      } else if (GbE == k) {
        this.field_TopicId = paramCursor.getString(i);
      } else if (GbF == k) {
        this.field_SourceID = paramCursor.getString(i);
      } else if (GbG == k) {
        this.field_TopicInfo = paramCursor.getBlob(i);
      } else if (GbH == k) {
        this.field_ClusterShowInfo = paramCursor.getBlob(i);
      } else if (GbI == k) {
        this.field_IconID = paramCursor.getString(i);
      } else if (fGC == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (GbJ == k) {
        this.field_MediaType = paramCursor.getInt(i);
      } else if (GbK == k) {
        this.field_MediaUrl = paramCursor.getString(i);
      } else if (GbL == k) {
        this.field_MediaAESKey = paramCursor.getString(i);
      } else if (GbM == k) {
        this.field_MediaThumbUrl = paramCursor.getString(i);
      } else if (GbN == k) {
        this.field_MediaThumbAESKey = paramCursor.getString(i);
      } else if (GbO == k) {
        this.field_PoiID = paramCursor.getString(i);
      } else if (GbP == k) {
        this.field_PoiName = paramCursor.getString(i);
      } else if (GbQ == k) {
        this.field_Longitude = paramCursor.getDouble(i);
      } else if (GbR == k) {
        this.field_Latitude = paramCursor.getDouble(i);
      } else if (GbS == k) {
        this.field_Visibility = paramCursor.getInt(i);
      } else if (fGA == k) {
        this.field_CreateTime = paramCursor.getInt(i);
      } else if (GbT == k) {
        this.field_ExpireTime = paramCursor.getInt(i);
      } else if (GbU == k) {
        this.field_LikeCount = paramCursor.getInt(i);
      } else if (fyj == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (GbV == k) {
        this.field_backgroundId = paramCursor.getString(i);
      } else if (GbW == k) {
        this.field_option = Long.valueOf(paramCursor.getLong(i));
      } else if (GbX == k) {
        this.field_mediaWidth = paramCursor.getInt(i);
      } else if (GbY == k) {
        this.field_mediaHeight = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fGw) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.Gbh) {
      localContentValues.put("StatusID", this.field_StatusID);
    }
    if (this.Gbi) {
      localContentValues.put("TopicId", this.field_TopicId);
    }
    if (this.Gbj) {
      localContentValues.put("SourceID", this.field_SourceID);
    }
    if (this.Gbk) {
      localContentValues.put("TopicInfo", this.field_TopicInfo);
    }
    if (this.Gbl) {
      localContentValues.put("ClusterShowInfo", this.field_ClusterShowInfo);
    }
    if (this.Gbm) {
      localContentValues.put("IconID", this.field_IconID);
    }
    if (this.fGu) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.Gbn) {
      localContentValues.put("MediaType", Integer.valueOf(this.field_MediaType));
    }
    if (this.Gbo) {
      localContentValues.put("MediaUrl", this.field_MediaUrl);
    }
    if (this.Gbp) {
      localContentValues.put("MediaAESKey", this.field_MediaAESKey);
    }
    if (this.Gbq) {
      localContentValues.put("MediaThumbUrl", this.field_MediaThumbUrl);
    }
    if (this.Gbr) {
      localContentValues.put("MediaThumbAESKey", this.field_MediaThumbAESKey);
    }
    if (this.Gbs) {
      localContentValues.put("PoiID", this.field_PoiID);
    }
    if (this.Gbt) {
      localContentValues.put("PoiName", this.field_PoiName);
    }
    if (this.Gbu) {
      localContentValues.put("Longitude", Double.valueOf(this.field_Longitude));
    }
    if (this.Gbv) {
      localContentValues.put("Latitude", Double.valueOf(this.field_Latitude));
    }
    if (this.Gbw) {
      localContentValues.put("Visibility", Integer.valueOf(this.field_Visibility));
    }
    if (this.fGs) {
      localContentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
    }
    if (this.Gbx) {
      localContentValues.put("ExpireTime", Integer.valueOf(this.field_ExpireTime));
    }
    if (this.Gby) {
      localContentValues.put("LikeCount", Integer.valueOf(this.field_LikeCount));
    }
    if (this.fxx) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.Gbz) {
      localContentValues.put("backgroundId", this.field_backgroundId);
    }
    if (this.GbA) {
      localContentValues.put("option", this.field_option);
    }
    if (this.GbB) {
      localContentValues.put("mediaWidth", Integer.valueOf(this.field_mediaWidth));
    }
    if (this.GbC) {
      localContentValues.put("mediaHeight", Integer.valueOf(this.field_mediaHeight));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.a
 * JD-Core Version:    0.7.0.1
 */