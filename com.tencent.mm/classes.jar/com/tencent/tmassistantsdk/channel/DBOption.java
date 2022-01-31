package com.tencent.tmassistantsdk.channel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;

public class DBOption
{
  protected static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists channeldata( itemId INTEGER PRIMARY KEY AUTOINCREMENT, itemData BLOB);";
  protected static final int DATEBASE_VERSION = 1;
  protected static final String DB_NAME = ".SystemConfig.db";
  protected static final String QUERY_ALL_SQL = "select * from channeldata";
  protected static final String TABLE_NAME = "channeldata";
  protected String DB_PATH;
  
  public DBOption()
  {
    AppMethodBeat.i(75607);
    this.DB_PATH = "";
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
      AppMethodBeat.o(75607);
      return;
    }
  }
  
  private void checkAndCreateTable(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(75614);
    int i = paramSQLiteDatabase.getVersion();
    if (i != 1)
    {
      paramSQLiteDatabase.beginTransaction();
      if (i == 0) {}
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
        AppMethodBeat.o(75614);
      }
    }
    AppMethodBeat.o(75614);
  }
  
  private void closeDB(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(75613);
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen())) {
      try
      {
        paramSQLiteDatabase.close();
        AppMethodBeat.o(75613);
        return;
      }
      catch (Exception paramSQLiteDatabase) {}
    }
    AppMethodBeat.o(75613);
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
        AppMethodBeat.i(75612);
        if (!new File(this.DB_PATH).exists())
        {
          AppMethodBeat.o(75612);
          return localObject3;
        }
        i = 0;
        localObject3 = localObject1;
        if (i >= 20) {}
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
      else
      {
        AppMethodBeat.o(75612);
      }
    }
  }
  
  private SQLiteDatabase getWritableDatabase()
  {
    Object localObject1 = null;
    AppMethodBeat.i(75611);
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= 20) {
        break label52;
      }
      try
      {
        localObject2 = SQLiteDatabase.openOrCreateDatabase(this.DB_PATH, null);
        localObject1 = localObject2;
      }
      catch (SQLiteException localSQLiteException)
      {
        label28:
        break label28;
      }
      if (localObject1 != null) {
        break;
      }
      SystemClock.sleep(50L);
      i += 1;
    }
    checkAndCreateTable(localObject1);
    Object localObject2 = localObject1;
    label52:
    AppMethodBeat.o(75611);
    return localObject2;
  }
  
  public boolean delete(long paramLong)
  {
    AppMethodBeat.i(75609);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    if (localSQLiteDatabase != null)
    {
      localSQLiteDatabase.delete("channeldata", "itemId=?", new String[] { String.valueOf(paramLong) });
      closeDB(localSQLiteDatabase);
      AppMethodBeat.o(75609);
      return true;
    }
    AppMethodBeat.o(75609);
    return false;
  }
  
  public long insert(TMAssistantSDKChannelDataItem paramTMAssistantSDKChannelDataItem)
  {
    AppMethodBeat.i(75608);
    if (paramTMAssistantSDKChannelDataItem == null)
    {
      AppMethodBeat.o(75608);
      return -1L;
    }
    paramTMAssistantSDKChannelDataItem = paramTMAssistantSDKChannelDataItem.getBuffer();
    if (paramTMAssistantSDKChannelDataItem != null)
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase != null)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("itemData", paramTMAssistantSDKChannelDataItem);
        long l = localSQLiteDatabase.insert("channeldata", "", localContentValues);
        closeDB(localSQLiteDatabase);
        AppMethodBeat.o(75608);
        return l;
      }
    }
    AppMethodBeat.o(75608);
    return -1L;
  }
  
  public ArrayList<TMAssistantSDKChannelDataItem> queryAll()
  {
    TMAssistantSDKChannelDataItem localTMAssistantSDKChannelDataItem = null;
    AppMethodBeat.i(75610);
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    if (localSQLiteDatabase != null)
    {
      Cursor localCursor = localSQLiteDatabase.rawQuery("select * from channeldata", null);
      Object localObject = localTMAssistantSDKChannelDataItem;
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
      AppMethodBeat.o(75610);
      return localObject;
    }
    AppMethodBeat.o(75610);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.channel.DBOption
 * JD-Core Version:    0.7.0.1
 */