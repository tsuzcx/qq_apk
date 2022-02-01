package com.tencent.mm.plugin.teenmode.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class b
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final Column SZg;
  public static final Column SZh;
  private static final int SZm;
  private static final int SZn;
  public static final SingleTable TABLE = new SingleTable("TeenModeBindGuardian");
  public static final Column jJA;
  private static final int jJE;
  public static final Column jUS;
  private static final int jVE;
  private static final StorageObserverOwner<b> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean SZj = true;
  private boolean SZk = true;
  public String field_guardianUserName;
  public String field_ticket;
  public long field_time;
  public String field_wardUserName;
  private boolean jJC = true;
  private boolean jVl = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    SZg = new Column("guardianUserName", "string", TABLE.getName(), "");
    SZh = new Column("wardUserName", "string", TABLE.getName(), "");
    jJA = new Column("ticket", "string", TABLE.getName(), "");
    jUS = new Column("time", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    SZm = "guardianUserName".hashCode();
    SZn = "wardUserName".hashCode();
    jJE = "ticket".hashCode();
    jVE = "time".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "guardianUserName";
    localMAutoDBInfo.colsMap.put("guardianUserName", "TEXT");
    localStringBuilder.append(" guardianUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "wardUserName";
    localMAutoDBInfo.colsMap.put("wardUserName", "TEXT");
    localStringBuilder.append(" wardUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "ticket";
    localMAutoDBInfo.colsMap.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "time";
    localMAutoDBInfo.colsMap.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("guardianUserName"))
    {
      this.field_guardianUserName = paramContentValues.getAsString("guardianUserName");
      if (paramBoolean) {
        this.SZj = true;
      }
    }
    if (paramContentValues.containsKey("wardUserName"))
    {
      this.field_wardUserName = paramContentValues.getAsString("wardUserName");
      if (paramBoolean) {
        this.SZk = true;
      }
    }
    if (paramContentValues.containsKey("ticket"))
    {
      this.field_ticket = paramContentValues.getAsString("ticket");
      if (paramBoolean) {
        this.jJC = true;
      }
    }
    if (paramContentValues.containsKey("time"))
    {
      this.field_time = paramContentValues.getAsLong("time").longValue();
      if (paramBoolean) {
        this.jVl = true;
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
      if (SZm != k) {
        break label60;
      }
      this.field_guardianUserName = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (SZn == k) {
        this.field_wardUserName = paramCursor.getString(i);
      } else if (jJE == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (jVE == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.SZj) {
      localContentValues.put("guardianUserName", this.field_guardianUserName);
    }
    if (this.SZk) {
      localContentValues.put("wardUserName", this.field_wardUserName);
    }
    if (this.jJC) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.jVl) {
      localContentValues.put("time", Long.valueOf(this.field_time));
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
  
  public StorageObserverOwner<? extends b> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.a.b
 * JD-Core Version:    0.7.0.1
 */