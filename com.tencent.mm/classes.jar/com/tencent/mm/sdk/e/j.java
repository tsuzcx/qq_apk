package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public abstract class j<T extends c>
  extends k
  implements d<T>
{
  private static final String TAG = "MicroMsg.SDK.MAutoStorage";
  private final e db;
  private final c.a dbInfo;
  public int field_MARK_CURSOR_CHECK_IGNORE = 1;
  private final String table;
  
  public j(e parame, c.a parama, String paramString, String[] paramArrayOfString)
  {
    this.db = parame;
    this.dbInfo = parama;
    parama = this.dbInfo;
    if (bo.isNullOrNil(this.dbInfo.yrL)) {}
    for (parame = "rowid";; parame = this.dbInfo.yrL)
    {
      parama.yrL = parame;
      this.table = paramString;
      updateColumnSQLs(paramArrayOfString);
      return;
    }
  }
  
  private void LOGD(String paramString)
  {
    ab.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
  }
  
  private void LOGE(String paramString)
  {
    ab.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
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
    Cursor localCursor = this.db.query(getTableName(), this.dbInfo.columns, this.dbInfo.yrL + " = ?", new String[] { bo.nullAsNil(paramContentValues.getAsString(this.dbInfo.yrL)) }, null, null, null);
    boolean bool = c.checkIOEqual(paramContentValues, localCursor);
    localCursor.close();
    return bool;
  }
  
  public static String getCreateSQLs(c.a parama, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + paramString + " ( ");
    localStringBuilder.append(parama.sql);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  public static List<String> getUpdateSQLs(c.a parama, String paramString, e parame)
  {
    ArrayList localArrayList = new ArrayList();
    if ((parame == null) || (paramString == null))
    {
      if (parame == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.e("MicroMsg.SDK.MAutoStorage", "dk getUpdateSQLs db==null :%b  table:%s", new Object[] { Boolean.valueOf(bool), paramString });
        return localArrayList;
      }
    }
    Object localObject1 = parame.a("PRAGMA table_info( " + paramString + " )", new String[0], 2);
    if (localObject1 == null) {
      return localArrayList;
    }
    parame = new HashMap();
    int i = ((Cursor)localObject1).getColumnIndex("name");
    int j = ((Cursor)localObject1).getColumnIndex("type");
    while (((Cursor)localObject1).moveToNext()) {
      parame.put(((Cursor)localObject1).getString(i), ((Cursor)localObject1).getString(j));
    }
    ((Cursor)localObject1).close();
    parama = parama.yrM.entrySet().iterator();
    while (parama.hasNext())
    {
      Object localObject2 = (Map.Entry)parama.next();
      localObject1 = (String)((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        String str = (String)parame.get(localObject2);
        if (str == null)
        {
          localArrayList.add("ALTER TABLE " + paramString + " ADD COLUMN " + (String)localObject2 + " " + (String)localObject1 + ";");
          parame.remove(localObject2);
        }
        else if (!((String)localObject1).toLowerCase().startsWith(str.toLowerCase()))
        {
          ab.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + (String)localObject2 + ", " + str + "<o-n>" + (String)localObject1);
          parame.remove(localObject2);
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
        ab.i("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", new Object[] { this.table, localList.get(i) });
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
      arrayOfString[i] = bo.nullAsNil(paramContentValues.getAsString(paramArrayOfString[i]));
      i += 1;
    }
    return arrayOfString;
  }
  
  public boolean delete(long paramLong)
  {
    return deleteNotify(paramLong, true);
  }
  
  public boolean delete(T paramT, boolean paramBoolean, String... paramVarArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramT = paramT.convertTo();
    if ((paramT == null) || (paramT.size() <= 0)) {
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
        if (this.db.delete(getTableName(), this.dbInfo.yrL + " = ?", new String[] { bo.nullAsNil(paramT.getAsString(this.dbInfo.yrL)) }) > 0) {
          bool1 = true;
        }
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (!paramBoolean);
    doNotify();
    return bool1;
    StringBuilder localStringBuilder = checkKeysWithValues(paramT, paramVarArgs);
    if (localStringBuilder == null)
    {
      LOGE("delete failed, check keys failed");
      return false;
    }
    if ((this.db.delete(getTableName(), localStringBuilder.toString(), valuesFromKeys(paramVarArgs, paramT)) > 0) && (paramBoolean))
    {
      doNotify(this.dbInfo.yrL);
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
        doNotify();
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
    Cursor localCursor = this.db.a(getTableName(), this.dbInfo.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
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
      paramVarArgs = this.db.a(getTableName(), this.dbInfo.columns, this.dbInfo.yrL + " = ?", new String[] { bo.nullAsNil(localContentValues.getAsString(this.dbInfo.yrL)) }, null, null, null, 2);
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
    paramVarArgs = this.db.a(getTableName(), this.dbInfo.columns, localStringBuilder.toString(), valuesFromKeys(paramVarArgs, localContentValues), null, null, null, 2);
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
    return this.dbInfo.yrL;
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
    paramT.systemRowid = this.db.insert(getTableName(), this.dbInfo.yrL, localContentValues);
    if (paramT.systemRowid <= 0L)
    {
      LOGE("insert failed");
      return false;
    }
    localContentValues.put("rowid", Long.valueOf(paramT.systemRowid));
    if (paramBoolean) {
      doNotify(localContentValues.getAsString(this.dbInfo.yrL));
    }
    return true;
  }
  
  public Cursor rawQuery(String paramString, String... paramVarArgs)
  {
    return this.db.rawQuery(paramString, paramVarArgs);
  }
  
  public boolean replace(T paramT)
  {
    boolean bool;
    ContentValues localContentValues;
    int j;
    int k;
    if (!bo.isNullOrNil(this.dbInfo.yrL))
    {
      bool = true;
      Assert.assertTrue("replace primaryKey == null", bool);
      localContentValues = paramT.convertTo();
      if (localContentValues != null)
      {
        j = localContentValues.size();
        k = paramT.getDBInfo().yrK.length;
        if (!localContentValues.containsKey("rowid")) {
          break label86;
        }
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      if (j == i + k) {
        break label91;
      }
      LOGE("replace failed, cv.size() != item.fields().length");
      return false;
      bool = false;
      break;
    }
    label91:
    if (checkOld(localContentValues))
    {
      LOGD("no need replace , fields no change");
      return true;
    }
    if (this.db.replace(getTableName(), this.dbInfo.yrL, localContentValues) > 0L)
    {
      doNotify(this.dbInfo.yrL);
      return true;
    }
    LOGE("replace failed");
    return false;
  }
  
  public boolean update(long paramLong, T paramT)
  {
    return update(paramLong, paramT, true);
  }
  
  public boolean update(long paramLong, T paramT, boolean paramBoolean)
  {
    paramT = paramT.convertTo();
    boolean bool2;
    if ((paramT == null) || (paramT.size() <= 0))
    {
      LOGE("update failed, value.size <= 0");
      bool2 = false;
      return bool2;
    }
    Cursor localCursor = this.db.query(getTableName(), this.dbInfo.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (c.checkIOEqual(paramT, localCursor))
    {
      localCursor.close();
      LOGD("no need replace , fields no change");
      return true;
    }
    localCursor.close();
    if (this.db.update(getTableName(), paramT, "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {}
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
      doNotify();
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
    paramT = paramT.convertTo();
    if ((paramT == null) || (paramT.size() <= 0)) {
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
        if (checkOld(paramT))
        {
          LOGD("no need replace , fields no change");
          return true;
        }
        if (this.db.update(getTableName(), paramT, this.dbInfo.yrL + " = ?", new String[] { bo.nullAsNil(paramT.getAsString(this.dbInfo.yrL)) }) > 0) {
          bool1 = true;
        }
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (!paramBoolean);
    doNotify();
    return bool1;
    StringBuilder localStringBuilder = checkKeysWithValues(paramT, paramVarArgs);
    if (localStringBuilder == null)
    {
      LOGE("update failed, check keys failed");
      return false;
    }
    if (this.db.update(getTableName(), paramT, localStringBuilder.toString(), valuesFromKeys(paramVarArgs, paramT)) > 0)
    {
      if (paramBoolean) {
        doNotify(paramT.getAsString(this.dbInfo.yrL));
      }
      return true;
    }
    LOGE("update failed");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.j
 * JD-Core Version:    0.7.0.1
 */