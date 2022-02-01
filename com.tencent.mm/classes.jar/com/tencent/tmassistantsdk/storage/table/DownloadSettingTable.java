package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
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
    AppMethodBeat.i(102453);
    HashMap localHashMap = new HashMap();
    try
    {
      Cursor localCursor = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery("select * from settingInfo", null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
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
          return localHashMap;
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        Log.printErrStackTrace("DownloadSettingTable", localException, "", new Object[0]);
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label176;
      }
      localObject3.close();
      AppMethodBeat.o(102453);
    }
    AppMethodBeat.o(102453);
    return localHashMap;
  }
  
  public static void save(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(102451);
    if ((paramString1 != null) && (paramString2 != null)) {
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
        AppMethodBeat.o(102451);
        return;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("DownloadSettingTable", paramString1, "", new Object[0]);
      }
    }
    AppMethodBeat.o(102451);
  }
  
  private static int update(String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(102452);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(102452);
      return -1;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("settingField", paramString1);
      localContentValues.put("value", paramString2);
      localContentValues.put("type", paramString3);
      int i = paramSQLiteDatabase.update("settingInfo", localContentValues, "settingField = ?", new String[] { paramString1 });
      if (i > 0) {
        return i;
      }
      return 0;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("DownloadSettingTable", paramString1, "", new Object[0]);
      return -2;
    }
    finally
    {
      AppMethodBeat.o(102452);
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
    AppMethodBeat.i(102454);
    SqliteHelper localSqliteHelper = AstSDKDBHelper_V2.getInstance();
    AppMethodBeat.o(102454);
    return localSqliteHelper;
  }
  
  public String tableName()
  {
    return "settingInfo";
  }
  
  public class Columns
  {
    public static final String SETTINGFIELD = "settingField";
    public static final String TYPE = "type";
    public static final String VALUE = "value";
    
    public Columns() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.DownloadSettingTable
 * JD-Core Version:    0.7.0.1
 */