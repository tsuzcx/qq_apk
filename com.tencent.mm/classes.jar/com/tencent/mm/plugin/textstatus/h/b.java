package com.tencent.mm.plugin.textstatus.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class b
  extends IAutoDBItem
{
  private static final int Gcf;
  private static final int Gcg;
  private static final int Gch;
  private static final int Gci;
  private static final int Gcj = "Notify".hashCode();
  private static final int Gck = "Read".hashCode();
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS TextStatusLike_TextStatusId_index ON TextStatusLike(TextStatusId)" };
  private static final int fGA;
  private static final int fGC;
  private static final int fOg;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean GbZ = true;
  private boolean Gca = true;
  private boolean Gcb = true;
  private boolean Gcc = true;
  private boolean Gcd = true;
  private boolean Gce = true;
  private boolean fGs = true;
  private boolean fGu = true;
  private boolean fNq = true;
  public int field_CreateTime;
  public String field_Description;
  public String field_DisplayName;
  public String field_HashUserName;
  public String field_HeadImgUrl;
  public int field_Notify;
  public int field_Read;
  public String field_TextStatusId;
  public int field_Type;
  
  static
  {
    Gcf = "TextStatusId".hashCode();
    Gcg = "HashUserName".hashCode();
    Gch = "DisplayName".hashCode();
    Gci = "HeadImgUrl".hashCode();
    fGC = "Description".hashCode();
    fOg = "Type".hashCode();
    fGA = "CreateTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
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
    localMAutoDBInfo.columns[9] = "rowid";
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
      if (Gcf != k) {
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
      if (Gcg == k) {
        this.field_HashUserName = paramCursor.getString(i);
      } else if (Gch == k) {
        this.field_DisplayName = paramCursor.getString(i);
      } else if (Gci == k) {
        this.field_HeadImgUrl = paramCursor.getString(i);
      } else if (fGC == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (fOg == k) {
        this.field_Type = paramCursor.getInt(i);
      } else if (fGA == k) {
        this.field_CreateTime = paramCursor.getInt(i);
      } else if (Gcj == k) {
        this.field_Notify = paramCursor.getInt(i);
      } else if (Gck == k) {
        this.field_Read = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.GbZ) {
      localContentValues.put("TextStatusId", this.field_TextStatusId);
    }
    if (this.Gca) {
      localContentValues.put("HashUserName", this.field_HashUserName);
    }
    if (this.Gcb) {
      localContentValues.put("DisplayName", this.field_DisplayName);
    }
    if (this.Gcc) {
      localContentValues.put("HeadImgUrl", this.field_HeadImgUrl);
    }
    if (this.fGu) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.fNq) {
      localContentValues.put("Type", Integer.valueOf(this.field_Type));
    }
    if (this.fGs) {
      localContentValues.put("CreateTime", Integer.valueOf(this.field_CreateTime));
    }
    if (this.Gcd) {
      localContentValues.put("Notify", Integer.valueOf(this.field_Notify));
    }
    if (this.Gce) {
      localContentValues.put("Read", Integer.valueOf(this.field_Read));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.b
 * JD-Core Version:    0.7.0.1
 */