package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import java.util.HashMap;

public class DownloadSettingTable
  implements ITableBase
{
  public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
  public static final String QUERY_SQL = "select * from settingInfo";
  public static final String TABLE_NAME = "settingInfo";
  private static final String TAG = "DownloadSettingTable";
  
  public static HashMap<String, String> query()
  {
    localObject3 = null;
    localObject1 = null;
    localHashMap = new HashMap();
    do
    {
      try
      {
        localCursor = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery("select * from settingInfo", null);
        if (localCursor == null) {
          continue;
        }
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (!localCursor.moveToFirst()) {
          continue;
        }
        boolean bool;
        do
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          localHashMap.put(localCursor.getString(localCursor.getColumnIndex("settingField")), localCursor.getString(localCursor.getColumnIndex("value")));
          localObject1 = localCursor;
          localObject3 = localCursor;
          bool = localCursor.moveToNext();
        } while (bool);
      }
      catch (Exception localException)
      {
        Cursor localCursor;
        localObject3 = localObject1;
        y.printErrStackTrace("DownloadSettingTable", localException, "", new Object[0]);
        return localHashMap;
      }
      finally
      {
        if (localObject3 == null) {
          break;
        }
        localObject3.close();
      }
      return localHashMap;
    } while (localCursor == null);
    localCursor.close();
    return localHashMap;
  }
  
  public static void save(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
      if (update(paramString1, paramString2, paramString3, localSQLiteDatabase) <= 0)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("settingField", paramString1);
        localContentValues.put("value", paramString2);
        localContentValues.put("type", paramString3);
        localSQLiteDatabase.insert("settingInfo", null, localContentValues);
      }
      return;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("DownloadSettingTable", paramString1, "", new Object[0]);
    }
  }
  
  private static int update(String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if ((paramString1 == null) || (paramString2 == null)) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("settingField", paramString1);
        localContentValues.put("value", paramString2);
        localContentValues.put("type", paramString3);
        int j = paramSQLiteDatabase.update("settingInfo", localContentValues, "settingField = ?", new String[] { paramString1 });
        i = j;
        if (j > 0) {
          continue;
        }
        return 0;
      }
      catch (Exception paramString1)
      {
        paramString1 = paramString1;
        y.printErrStackTrace("DownloadSettingTable", paramString1, "", new Object[0]);
        return -2;
      }
      finally {}
    }
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
  }
  
  public void dataMovement(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2) {}
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public SqliteHelper getHelper()
  {
    return AstSDKDBHelper_V2.getInstance();
  }
  
  public String tableName()
  {
    return "settingInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.DownloadSettingTable
 * JD-Core Version:    0.7.0.1
 */