package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public abstract class MAutoStorage<T extends IAutoDBItem>
  extends MStorage
  implements IAutoStorage<T>
{
  private static final String TAG = "MicroMsg.SDK.MAutoStorage";
  private final ISQLiteDatabase db;
  private final IAutoDBItem.MAutoDBInfo dbInfo;
  public int field_MARK_CURSOR_CHECK_IGNORE = 1;
  private final String table;
  
  public MAutoStorage(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    this.db = paramISQLiteDatabase;
    this.dbInfo = paramMAutoDBInfo;
    paramMAutoDBInfo = this.dbInfo;
    if (Util.isNullOrNil(this.dbInfo.primaryKey)) {}
    for (paramISQLiteDatabase = "rowid";; paramISQLiteDatabase = this.dbInfo.primaryKey)
    {
      paramMAutoDBInfo.primaryKey = paramISQLiteDatabase;
      this.table = paramString;
      updateColumnSQLs(paramArrayOfString);
      return;
    }
  }
  
  private void LOGD(String paramString)
  {
    Log.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
  }
  
  private void LOGE(String paramString)
  {
    Log.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
  }
  
  private static StringBuilder checkKeysWithValues(ContentValues paramContentValues, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localStringBuilder.append(str + " = ? AND ");
      if (paramContentValues.get(str) == null) {
        return null;
      }
      i += 1;
    }
    localStringBuilder.append(" 1=1");
    return localStringBuilder;
  }
  
  private boolean checkOld(ContentValues paramContentValues)
  {
    Cursor localCursor = this.db.query(getTableName(), this.dbInfo.columns, this.dbInfo.primaryKey + " = ?", new String[] { Util.nullAsNil(paramContentValues.getAsString(this.dbInfo.primaryKey)) }, null, null, null);
    boolean bool = IAutoDBItem.checkIOEqual(paramContentValues, localCursor);
    localCursor.close();
    return bool;
  }
  
  public static String getCreateSQLs(IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + paramString + " ( ");
    localStringBuilder.append(paramMAutoDBInfo.sql);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  public static List<String> getUpdateSQLs(IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, ISQLiteDatabase paramISQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramISQLiteDatabase == null) || (paramString == null))
    {
      if (paramISQLiteDatabase == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.e("MicroMsg.SDK.MAutoStorage", "dk getUpdateSQLs db==null :%b  table:%s", new Object[] { Boolean.valueOf(bool), paramString });
        return localArrayList;
      }
    }
    Object localObject1 = paramISQLiteDatabase.rawQuery("PRAGMA table_info( " + paramString + " )", new String[0], 2);
    if (localObject1 == null) {
      return localArrayList;
    }
    paramISQLiteDatabase = new HashMap();
    int i = ((Cursor)localObject1).getColumnIndex("name");
    int j = ((Cursor)localObject1).getColumnIndex("type");
    while (((Cursor)localObject1).moveToNext()) {
      paramISQLiteDatabase.put(((Cursor)localObject1).getString(i), ((Cursor)localObject1).getString(j));
    }
    ((Cursor)localObject1).close();
    paramMAutoDBInfo = paramMAutoDBInfo.colsMap.entrySet().iterator();
    while (paramMAutoDBInfo.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMAutoDBInfo.next();
      localObject1 = (String)((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        String str = (String)paramISQLiteDatabase.get(localObject2);
        if (str == null)
        {
          localArrayList.add("ALTER TABLE " + paramString + " ADD COLUMN " + (String)localObject2 + " " + (String)localObject1 + ";");
          paramISQLiteDatabase.remove(localObject2);
        }
        else if (!((String)localObject1).toLowerCase().startsWith(str.toLowerCase()))
        {
          Log.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + (String)localObject2 + ", " + str + "<o-n>" + (String)localObject1);
          paramISQLiteDatabase.remove(localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private void updateColumnSQLs(String[] paramArrayOfString)
  {
    int j = 0;
    List localList = getUpdateSQLs(this.dbInfo, getTableName(), this.db);
    int i = 0;
    while (i < localList.size())
    {
      if (!this.db.execSQL(this.table, (String)localList.get(i))) {
        Log.i("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", new Object[] { this.table, localList.get(i) });
      }
      i += 1;
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      i = j;
      while (i < paramArrayOfString.length)
      {
        this.db.execSQL(this.table, paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  private static String[] valuesFromKeys(String[] paramArrayOfString, ContentValues paramContentValues)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = Util.nullAsNil(paramContentValues.getAsString(paramArrayOfString[i]));
      i += 1;
    }
    return arrayOfString;
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return this.db.delete(paramString1, paramString2, paramArrayOfString);
  }
  
  public boolean delete(long paramLong)
  {
    return deleteNotify(paramLong, true);
  }
  
  public boolean delete(T paramT, boolean paramBoolean, String... paramVarArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    ContentValues localContentValues = paramT.convertTo();
    if ((localContentValues == null) || (localContentValues.size() <= 0)) {
      LOGE("delete failed, value.size <= 0");
    }
    do
    {
      do
      {
        return bool2;
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          break;
        }
        LOGD("delete with primary key");
        if (this.db.delete(getTableName(), this.dbInfo.primaryKey + " = ?", new String[] { Util.nullAsNil(localContentValues.getAsString(this.dbInfo.primaryKey)) }) > 0) {
          bool1 = true;
        }
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (!paramBoolean);
    doNotify(localContentValues.getAsString(this.dbInfo.primaryKey), 5, paramT);
    return bool1;
    StringBuilder localStringBuilder = checkKeysWithValues(localContentValues, paramVarArgs);
    if (localStringBuilder == null)
    {
      LOGE("delete failed, check keys failed");
      return false;
    }
    if ((this.db.delete(getTableName(), localStringBuilder.toString(), valuesFromKeys(paramVarArgs, localContentValues)) > 0) && (paramBoolean))
    {
      doNotify(localContentValues.getAsString(this.dbInfo.primaryKey), 5, paramT);
      return true;
    }
    LOGE("delete failed");
    return false;
  }
  
  public boolean delete(T paramT, String... paramVarArgs)
  {
    return delete(paramT, true, paramVarArgs);
  }
  
  public boolean deleteNotify(long paramLong, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.db.delete(getTableName(), "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (;;)
    {
      if ((bool) && (paramBoolean)) {
        doNotify("*", 5, null);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean execSQL(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      LOGE("null or nill table");
      return false;
    }
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      LOGE("null or nill sql");
      return false;
    }
    return this.db.execSQL(paramString1, paramString2);
  }
  
  public boolean get(long paramLong, T paramT)
  {
    Cursor localCursor = this.db.query(getTableName(), this.dbInfo.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      paramT.convertFrom(localCursor);
      localCursor.close();
      return true;
    }
    localCursor.close();
    return false;
  }
  
  public boolean get(T paramT, String... paramVarArgs)
  {
    ContentValues localContentValues = paramT.convertTo();
    if ((localContentValues == null) || (localContentValues.size() <= 0))
    {
      LOGE("get failed, value.size <= 0");
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      LOGD("get with primary key");
      paramVarArgs = this.db.query(getTableName(), this.dbInfo.columns, this.dbInfo.primaryKey + " = ?", new String[] { Util.nullAsNil(localContentValues.getAsString(this.dbInfo.primaryKey)) }, null, null, null, 2);
      if (paramVarArgs.moveToFirst())
      {
        paramT.convertFrom(paramVarArgs);
        paramVarArgs.close();
        return true;
      }
      paramVarArgs.close();
      return false;
    }
    StringBuilder localStringBuilder = checkKeysWithValues(localContentValues, paramVarArgs);
    if (localStringBuilder == null)
    {
      LOGE("get failed, check keys failed");
      return false;
    }
    paramVarArgs = this.db.query(getTableName(), this.dbInfo.columns, localStringBuilder.toString(), valuesFromKeys(paramVarArgs, localContentValues), null, null, null, 2);
    if (paramVarArgs.moveToFirst())
    {
      paramT.convertFrom(paramVarArgs);
      paramVarArgs.close();
      return true;
    }
    paramVarArgs.close();
    LOGD("get failed, not found");
    return false;
  }
  
  public Cursor getAll()
  {
    return this.db.query(getTableName(), this.dbInfo.columns, null, null, null, null, null);
  }
  
  public int getCount()
  {
    int i = 0;
    Cursor localCursor = rawQuery("select count(*) from " + getTableName(), new String[0]);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      i = localCursor.getInt(0);
      localCursor.close();
    }
    return i;
  }
  
  public String getPrimaryKey()
  {
    return this.dbInfo.primaryKey;
  }
  
  public String getTableName()
  {
    return this.table;
  }
  
  public boolean insert(T paramT)
  {
    return insertNotify(paramT, true);
  }
  
  public boolean insertNotify(T paramT, boolean paramBoolean)
  {
    ContentValues localContentValues = paramT.convertTo();
    if ((localContentValues == null) || (localContentValues.size() <= 0))
    {
      LOGE("insert failed, value.size <= 0");
      return false;
    }
    paramT.systemRowid = this.db.insert(getTableName(), this.dbInfo.primaryKey, localContentValues);
    if (paramT.systemRowid <= 0L)
    {
      LOGE("insert failed");
      return false;
    }
    localContentValues.put("rowid", Long.valueOf(paramT.systemRowid));
    if (paramBoolean) {
      doNotify(localContentValues.getAsString(this.dbInfo.primaryKey), 2, paramT);
    }
    return true;
  }
  
  public Cursor rawQuery(String paramString, String... paramVarArgs)
  {
    return this.db.rawQuery(paramString, paramVarArgs);
  }
  
  public boolean replace(T paramT)
  {
    return replace(paramT, true);
  }
  
  public boolean replace(T paramT, boolean paramBoolean)
  {
    boolean bool2 = false;
    ContentValues localContentValues;
    int j;
    int k;
    if (!Util.isNullOrNil(this.dbInfo.primaryKey))
    {
      bool1 = true;
      Assert.assertTrue("replace primaryKey == null", bool1);
      localContentValues = paramT.convertTo();
      if (localContentValues != null)
      {
        j = localContentValues.size();
        k = paramT.getDBInfo().fields.length;
        if (!localContentValues.containsKey("rowid")) {
          break label91;
        }
      }
    }
    label91:
    for (int i = 1;; i = 0)
    {
      if (j == i + k) {
        break label96;
      }
      LOGE("replace failed, cv.size() != item.fields().length");
      return false;
      bool1 = false;
      break;
    }
    label96:
    if (checkOld(localContentValues))
    {
      LOGD("no need replace , fields no change");
      return true;
    }
    paramT.systemRowid = this.db.replace(getTableName(), this.dbInfo.primaryKey, localContentValues);
    boolean bool1 = bool2;
    if (paramT.systemRowid > 0L) {
      bool1 = true;
    }
    if ((bool1) && (paramBoolean))
    {
      doNotify(this.dbInfo.primaryKey, 4, paramT);
      return true;
    }
    if (!bool1) {
      LOGE("replace failed");
    }
    return bool1;
  }
  
  public boolean update(long paramLong, T paramT)
  {
    return update(paramLong, paramT, true);
  }
  
  public boolean update(long paramLong, T paramT, boolean paramBoolean)
  {
    ContentValues localContentValues = paramT.convertTo();
    boolean bool2;
    if ((localContentValues == null) || (localContentValues.size() <= 0))
    {
      LOGE("update failed, value.size <= 0");
      bool2 = false;
      return bool2;
    }
    Cursor localCursor = this.db.query(getTableName(), this.dbInfo.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (IAutoDBItem.checkIOEqual(localContentValues, localCursor))
    {
      localCursor.close();
      LOGD("no need replace , fields no change");
      return true;
    }
    localCursor.close();
    if (this.db.update(getTableName(), localContentValues, "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (!paramBoolean) {
        break;
      }
      doNotify("*", 3, paramT);
      return bool1;
    }
  }
  
  public boolean update(T paramT, String... paramVarArgs)
  {
    return updateNotify(paramT, true, paramVarArgs);
  }
  
  public boolean updateNotify(T paramT, boolean paramBoolean, String... paramVarArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    ContentValues localContentValues = paramT.convertTo();
    if ((localContentValues == null) || (localContentValues.size() <= 0)) {
      LOGE("update failed, value.size <= 0");
    }
    do
    {
      do
      {
        return bool2;
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          break;
        }
        LOGD("update with primary key");
        if (checkOld(localContentValues))
        {
          LOGD("no need replace , fields no change");
          return true;
        }
        if (this.db.update(getTableName(), localContentValues, this.dbInfo.primaryKey + " = ?", new String[] { Util.nullAsNil(localContentValues.getAsString(this.dbInfo.primaryKey)) }) > 0) {
          bool1 = true;
        }
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (!paramBoolean);
    doNotify(localContentValues.getAsString(this.dbInfo.primaryKey), 3, paramT);
    return bool1;
    StringBuilder localStringBuilder = checkKeysWithValues(localContentValues, paramVarArgs);
    if (localStringBuilder == null)
    {
      LOGE("update failed, check keys failed");
      return false;
    }
    if (this.db.update(getTableName(), localContentValues, localStringBuilder.toString(), valuesFromKeys(paramVarArgs, localContentValues)) > 0)
    {
      if (paramBoolean) {
        doNotify(localContentValues.getAsString(this.dbInfo.primaryKey), 3, paramT);
      }
      return true;
    }
    LOGE("update failed");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MAutoStorage
 * JD-Core Version:    0.7.0.1
 */