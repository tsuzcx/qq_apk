package com.tencent.mm.plugin.textstatus.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class d
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  private static final int MIF = "HashUserName".hashCode();
  public static final Column MIL;
  private static final int MIN = "CommHashUserName".hashCode();
  public static final Column MIt;
  public static final SingleTable TABLE = new SingleTable("TextStatusUserNameMap");
  private static final int hVT;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean MIM = true;
  private boolean MIy = true;
  public String field_CommHashUserName;
  public String field_HashUserName;
  public String field_UserName;
  private boolean hVK = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "TextStatusUserNameMap", "");
    C_USERNAME = new Column("username", "string", "TextStatusUserNameMap", "");
    MIt = new Column("hashusername", "string", "TextStatusUserNameMap", "");
    MIL = new Column("commhashusername", "string", "TextStatusUserNameMap", "");
    hVT = "UserName".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "UserName";
    localMAutoDBInfo.colsMap.put("UserName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" UserName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "UserName";
    localMAutoDBInfo.columns[1] = "HashUserName";
    localMAutoDBInfo.colsMap.put("HashUserName", "TEXT");
    localStringBuilder.append(" HashUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "CommHashUserName";
    localMAutoDBInfo.colsMap.put("CommHashUserName", "TEXT");
    localStringBuilder.append(" CommHashUserName TEXT");
    localMAutoDBInfo.columns[3] = "rowid";
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
        break label65;
      }
      this.field_UserName = paramCursor.getString(i);
      this.hVK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (MIF == k) {
        this.field_HashUserName = paramCursor.getString(i);
      } else if (MIN == k) {
        this.field_CommHashUserName = paramCursor.getString(i);
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
    if (this.MIy) {
      localContentValues.put("HashUserName", this.field_HashUserName);
    }
    if (this.MIM) {
      localContentValues.put("CommHashUserName", this.field_CommHashUserName);
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
    return "TextStatusUserNameMap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.d
 * JD-Core Version:    0.7.0.1
 */