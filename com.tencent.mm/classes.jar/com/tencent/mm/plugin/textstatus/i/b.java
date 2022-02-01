package com.tencent.mm.plugin.textstatus.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class b
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS TextStatusLike_TextStatusId_index ON TextStatusLike(TextStatusId)" };
  public static final Column MGW;
  private static final int MHU = "TopicInfo".hashCode();
  private static final int MIE;
  private static final int MIF;
  private static final int MIG;
  private static final int MIH;
  private static final int MII;
  private static final int MIJ;
  private static final int MIK = "DeleteInMsgList".hashCode();
  public static final Column MIs;
  public static final Column MIt;
  public static final Column MIu;
  public static final Column MIv;
  public static final Column MIw;
  public static final SingleTable TABLE = new SingleTable("TextStatusLike");
  public static final Column hAa;
  public static final Column hHm;
  private static final int hIO;
  private static final int hVP;
  private static final int hVR;
  private static final int hVW;
  public static final Column hsb;
  public static final Column hww;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean MHt = true;
  private boolean MIA = true;
  private boolean MIB = true;
  private boolean MIC = true;
  private boolean MID = true;
  private boolean MIx = true;
  private boolean MIy = true;
  private boolean MIz = true;
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
  private boolean hIa = true;
  private boolean hVG = true;
  private boolean hVI = true;
  private boolean hVN = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "TextStatusLike", "");
    MIs = new Column("textstatusid", "string", "TextStatusLike", "");
    MIt = new Column("hashusername", "string", "TextStatusLike", "");
    hAa = new Column("displayname", "string", "TextStatusLike", "");
    hww = new Column("headimgurl", "string", "TextStatusLike", "");
    hsb = new Column("description", "string", "TextStatusLike", "");
    C_TYPE = new Column("type", "int", "TextStatusLike", "");
    C_CREATETIME = new Column("createtime", "int", "TextStatusLike", "");
    MIu = new Column("notify", "int", "TextStatusLike", "");
    MIv = new Column("read", "int", "TextStatusLike", "");
    hHm = new Column("thumburl", "string", "TextStatusLike", "");
    MGW = new Column("topicinfo", "byte[]", "TextStatusLike", "");
    MIw = new Column("deleteinmsglist", "int", "TextStatusLike", "");
    MIE = "TextStatusId".hashCode();
    MIF = "HashUserName".hashCode();
    MIG = "DisplayName".hashCode();
    MIH = "HeadImgUrl".hashCode();
    hVR = "Description".hashCode();
    hVW = "Type".hashCode();
    hVP = "CreateTime".hashCode();
    MII = "Notify".hashCode();
    MIJ = "Read".hashCode();
    hIO = "thumbUrl".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
      if (MIE != k) {
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
      if (MIF == k) {
        this.field_HashUserName = paramCursor.getString(i);
      } else if (MIG == k) {
        this.field_DisplayName = paramCursor.getString(i);
      } else if (MIH == k) {
        this.field_HeadImgUrl = paramCursor.getString(i);
      } else if (hVR == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (hVW == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (hVP == k) {
        this.field_CreateTime = paramCursor.getInt(i);
      } else if (MII == k) {
        this.field_Notify = paramCursor.getInt(i);
      } else if (MIJ == k) {
        this.field_Read = paramCursor.getInt(i);
      } else if (hIO == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (MHU == k) {
        this.field_TopicInfo = paramCursor.getBlob(i);
      } else if (MIK == k) {
        this.field_DeleteInMsgList = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.MIx) {
      localContentValues.put("TextStatusId", this.field_TextStatusId);
    }
    if (this.MIy) {
      localContentValues.put("HashUserName", this.field_HashUserName);
    }
    if (this.MIz) {
      localContentValues.put("DisplayName", this.field_DisplayName);
    }
    if (this.MIA) {
      localContentValues.put("HeadImgUrl", this.field_HeadImgUrl);
    }
    if (this.hVI) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.hVN) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.hVG) {
      localContentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
    }
    if (this.MIB) {
      localContentValues.put("Notify", Integer.valueOf(this.field_Notify));
    }
    if (this.MIC) {
      localContentValues.put("Read", Integer.valueOf(this.field_Read));
    }
    if (this.hIa) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.MHt) {
      localContentValues.put("TopicInfo", this.field_TopicInfo);
    }
    if (this.MID) {
      localContentValues.put("DeleteInMsgList", Integer.valueOf(this.field_DeleteInMsgList));
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
    return "TextStatusLike";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.b
 * JD-Core Version:    0.7.0.1
 */