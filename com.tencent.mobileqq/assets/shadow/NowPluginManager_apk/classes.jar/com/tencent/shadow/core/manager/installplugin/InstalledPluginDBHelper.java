package com.tencent.shadow.core.manager.installplugin;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InstalledPluginDBHelper
  extends SQLiteOpenHelper
{
  public static final String COLUMN_BUSINESS_NAME = "businessName";
  public static final String COLUMN_DEPENDSON = "dependsOn";
  public static final String COLUMN_HASH = "hash";
  public static final String COLUMN_HOST_WHITELIST = "hostWhiteList";
  public static final String COLUMN_ID = "id";
  public static final String COLUMN_INSTALL_TIME = "installedTime";
  public static final String COLUMN_PARTKEY = "partKey";
  public static final String COLUMN_PATH = "filePath";
  public static final String COLUMN_PLUGIN_LIB = "libPath";
  public static final String COLUMN_PLUGIN_ODEX = "odexPath";
  public static final String COLUMN_TYPE = "type";
  public static final String COLUMN_UUID = "uuid";
  public static final String COLUMN_VERSION = "version";
  static final String DB_NAME_PREFIX = "shadow_installed_plugin_db";
  public static final String TABLE_NAME_MANAGER = "shadowPluginManager";
  private static final int VERSION = 4;
  private static final Logger mLogger = LoggerFactory.getLogger(InstalledPluginDBHelper.class);
  
  public InstalledPluginDBHelper(Context paramContext, String paramString)
  {
    super(paramContext, "shadow_installed_plugin_db" + paramString, null, 4);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS shadowPluginManager ( id INTEGER PRIMARY KEY AUTOINCREMENT,hash VARCHAR , filePath VARCHAR, type INTEGER, businessName VARCHAR, partKey VARCHAR, dependsOn VARCHAR, uuid VARCHAR, version VARCHAR, installedTime INTEGER ,odexPath VARCHAR ,libPath VARCHAR ,hostWhiteList VARCHAR );");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 2) {
      paramSQLiteDatabase.beginTransaction();
    }
    for (;;)
    {
      try
      {
        Cursor localCursor = paramSQLiteDatabase.query(true, "shadowPluginManager", new String[] { "uuid", "type" }, "type = ?", new String[] { "2" }, null, null, null, null);
        localArrayList = new ArrayList();
        if (localCursor.moveToNext())
        {
          localArrayList.add(localCursor.getString(localCursor.getColumnIndex("uuid")));
          continue;
        }
      }
      catch (SQLException localSQLException1)
      {
        ArrayList localArrayList;
        mLogger.error(localSQLException1.getMessage());
        paramSQLiteDatabase.endTransaction();
        if (paramInt1 < 3) {
          paramSQLiteDatabase.beginTransaction();
        }
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE shadowPluginManager ADD hostWhiteList VARCHAR");
        }
        catch (SQLException localSQLException2)
        {
          mLogger.error(localSQLException2.getMessage());
          paramSQLiteDatabase.endTransaction();
          continue;
        }
        finally {}
        if (paramInt1 < 4) {
          paramSQLiteDatabase.beginTransaction();
        }
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE shadowPluginManager ADD businessName VARCHAR");
          return;
        }
        catch (SQLException localSQLException3)
        {
          Iterator localIterator;
          mLogger.error(localSQLException3.getMessage());
          return;
        }
        finally {}
        localSQLException1.close();
        localIterator = localArrayList.iterator();
        if (localIterator.hasNext())
        {
          paramSQLiteDatabase.delete("shadowPluginManager", "uuid = ?", new String[] { (String)localIterator.next() });
          continue;
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      paramSQLiteDatabase.endTransaction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.InstalledPluginDBHelper
 * JD-Core Version:    0.7.0.1
 */