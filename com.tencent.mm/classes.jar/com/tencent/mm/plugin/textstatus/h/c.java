package com.tencent.mm.plugin.textstatus.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class c
  extends IAutoDBItem
{
  private static final int Gcg = "HashUserName".hashCode();
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fGE = "UserName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean Gca = true;
  private boolean fGw = true;
  public String field_HashUserName;
  public String field_UserName;
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "UserName";
    localMAutoDBInfo.colsMap.put("UserName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" UserName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "UserName";
    localMAutoDBInfo.columns[1] = "HashUserName";
    localMAutoDBInfo.colsMap.put("HashUserName", "TEXT");
    localStringBuilder.append(" HashUserName TEXT");
    localMAutoDBInfo.columns[2] = "rowid";
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
        break label65;
      }
      this.field_UserName = paramCursor.getString(i);
      this.fGw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (Gcg == k) {
        this.field_HashUserName = paramCursor.getString(i);
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
    if (this.Gca) {
      localContentValues.put("HashUserName", this.field_HashUserName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.c
 * JD-Core Version:    0.7.0.1
 */