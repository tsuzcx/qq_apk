package com.tencent.tmassistantsdk.channel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;
import android.os.SystemClock;
import java.io.File;
import java.util.ArrayList;

public class DBOption
{
  protected static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists channeldata( itemId INTEGER PRIMARY KEY AUTOINCREMENT, itemData BLOB);";
  protected static final int DATEBASE_VERSION = 1;
  protected static final String DB_NAME = ".SystemConfig.db";
  protected static final String QUERY_ALL_SQL = "select * from channeldata";
  protected static final String TABLE_NAME = "channeldata";
  protected String DB_PATH = "";
  
  public DBOption()
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        File localFile = Environment.getExternalStorageDirectory();
        this.DB_PATH = (localFile.getPath() + "/tencent/assistant/");
        localFile = new File(this.DB_PATH);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        this.DB_PATH += ".SystemConfig.db";
      }
      return;
    }
  }
  
  private void checkAndCreateTable(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = paramSQLiteDatabase.getVersion();
    if (i != 1)
    {
      paramSQLiteDatabase.beginTransaction();
      if (i != 0) {}
    }
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE if not exists channeldata( itemId INTEGER PRIMARY KEY AUTOINCREMENT, itemData BLOB);");
      paramSQLiteDatabase.setVersion(1);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  private void closeDB(SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen())) {}
    try
    {
      paramSQLiteDatabase.close();
      return;
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  private SQLiteDatabase getReadableDatabase()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      int i;
      try
      {
        boolean bool = new File(this.DB_PATH).exists();
        if (!bool) {
          return localObject3;
        }
        i = 0;
        localObject3 = localObject1;
        if (i >= 20) {
          continue;
        }
      }
      finally {}
      try
      {
        localObject3 = SQLiteDatabase.openDatabase(this.DB_PATH, null, 1);
        localObject1 = localObject3;
      }
      catch (SQLiteException localSQLiteException)
      {
        continue;
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        SystemClock.sleep(50L);
        i += 1;
      }
    }
  }
  
  private SQLiteDatabase getWritableDatabase()
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= 20) {
        break label47;
      }
      try
      {
        localObject2 = SQLiteDatabase.openOrCreateDatabase(this.DB_PATH, null);
        localObject1 = localObject2;
      }
      catch (SQLiteException localSQLiteException)
      {
        label23:
        break label23;
      }
      if (localObject1 != null) {
        break;
      }
      SystemClock.sleep(50L);
      i += 1;
    }
    checkAndCreateTable(localObject1);
    Object localObject2 = localObject1;
    label47:
    return localObject2;
  }
  
  public boolean delete(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    if (localSQLiteDatabase != null)
    {
      localSQLiteDatabase.delete("channeldata", "itemId=?", new String[] { String.valueOf(paramLong) });
      closeDB(localSQLiteDatabase);
      return true;
    }
    return false;
  }
  
  public long insert(TMAssistantSDKChannelDataItem paramTMAssistantSDKChannelDataItem)
  {
    if (paramTMAssistantSDKChannelDataItem == null) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        return -1L;
        paramTMAssistantSDKChannelDataItem = paramTMAssistantSDKChannelDataItem.getBuffer();
      } while (paramTMAssistantSDKChannelDataItem == null);
      localSQLiteDatabase = getWritableDatabase();
    } while (localSQLiteDatabase == null);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("itemData", paramTMAssistantSDKChannelDataItem);
    long l = localSQLiteDatabase.insert("channeldata", "", localContentValues);
    closeDB(localSQLiteDatabase);
    return l;
  }
  
  public ArrayList<TMAssistantSDKChannelDataItem> queryAll()
  {
    Object localObject = null;
    TMAssistantSDKChannelDataItem localTMAssistantSDKChannelDataItem = null;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    if (localSQLiteDatabase != null)
    {
      Cursor localCursor = localSQLiteDatabase.rawQuery("select * from channeldata", null);
      localObject = localTMAssistantSDKChannelDataItem;
      if (localCursor != null)
      {
        localObject = localTMAssistantSDKChannelDataItem;
        if (localCursor.moveToFirst() == true)
        {
          int i = localCursor.getColumnIndex("itemId");
          int j = localCursor.getColumnIndex("itemData");
          localObject = new ArrayList();
          do
          {
            int k = localCursor.getInt(i);
            localTMAssistantSDKChannelDataItem = TMAssistantSDKChannelDataItem.getDataItemFromByte(localCursor.getBlob(j));
            if (localTMAssistantSDKChannelDataItem != null)
            {
              localTMAssistantSDKChannelDataItem.mDBIdentity = k;
              ((ArrayList)localObject).add(localTMAssistantSDKChannelDataItem);
            }
          } while (localCursor.moveToNext());
          closeDB(localSQLiteDatabase);
        }
      }
      localCursor.close();
      closeDB(localSQLiteDatabase);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.channel.DBOption
 * JD-Core Version:    0.7.0.1
 */