package com.tencent.mm.plugin.textstatus.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class c
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS TextStatusReference_TextStatusId_index ON TextStatusReference(TextStatusId)" };
  public static final Column MGW;
  private static final int MHU = "TopicInfo".hashCode();
  private static final int MIE;
  private static final int MIJ;
  private static final int MIK = "DeleteInMsgList".hashCode();
  public static final Column MIs;
  public static final Column MIv;
  public static final Column MIw;
  public static final SingleTable TABLE = new SingleTable("TextStatusReference");
  public static final Column hHm;
  private static final int hIO;
  private static final int hVP;
  private static final int hVT;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean MHt = true;
  private boolean MIC = true;
  private boolean MID = true;
  private boolean MIx = true;
  public int field_CreateTime;
  public int field_DeleteInMsgList;
  public int field_Read;
  public String field_TextStatusId;
  public byte[] field_TopicInfo;
  public String field_UserName;
  public String field_thumbUrl;
  private boolean hIa = true;
  private boolean hVG = true;
  private boolean hVK = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "TextStatusReference", "");
    MIs = new Column("textstatusid", "string", "TextStatusReference", "");
    C_USERNAME = new Column("username", "string", "TextStatusReference", "");
    C_CREATETIME = new Column("createtime", "int", "TextStatusReference", "");
    hHm = new Column("thumburl", "string", "TextStatusReference", "");
    MIv = new Column("read", "int", "TextStatusReference", "");
    MGW = new Column("topicinfo", "byte[]", "TextStatusReference", "");
    MIw = new Column("deleteinmsglist", "int", "TextStatusReference", "");
    MIE = "TextStatusId".hashCode();
    hVT = "UserName".hashCode();
    hVP = "CreateTime".hashCode();
    hIO = "thumbUrl".hashCode();
    MIJ = "Read".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
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
    localMAutoDBInfo.columns[7] = "rowid";
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
      if (hVT == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (hVP == k) {
        this.field_CreateTime = paramCursor.getInt(i);
      } else if (hIO == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (MIJ == k) {
        this.field_Read = paramCursor.getInt(i);
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
    if (this.hVK) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.hVG) {
      localContentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
    }
    if (this.hIa) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.MIC) {
      localContentValues.put("Read", Integer.valueOf(this.field_Read));
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
    return "TextStatusReference";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.c
 * JD-Core Version:    0.7.0.1
 */