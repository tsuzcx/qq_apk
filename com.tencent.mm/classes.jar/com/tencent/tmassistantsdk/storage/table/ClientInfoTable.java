package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import com.tencent.tmassistantsdk.storage.model.ClientInfo;

public class ClientInfoTable
  implements ITableBase
{
  public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
  public static final String QUERY_CLIENTINFO = "select * from clientinfo where clientId = ?";
  public static final String QUERY_CLIENTINFO_ALL = "select * from clientinfo";
  public static final String TABLE_NAME = "clientinfo";
  private static final String TAG = "ClientInfoTable";
  
  private static ClientInfo cursor2object(Cursor paramCursor)
  {
    ClientInfo localClientInfo = new ClientInfo();
    localClientInfo.clientId = paramCursor.getString(paramCursor.getColumnIndex("clientId"));
    localClientInfo.taskId = paramCursor.getInt(paramCursor.getColumnIndex("taskId"));
    localClientInfo.taskUrl = paramCursor.getString(paramCursor.getColumnIndex("taskUrl"));
    return localClientInfo;
  }
  
  public static void delete(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete("clientinfo", "clientId = ? and taskUrl = ?", new String[] { paramString1, paramString2 });
      return;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("ClientInfoTable", paramString1, "", new Object[0]);
    }
  }
  
  public static void deleteItemsByURL(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete("clientinfo", "taskUrl = ?", new String[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("ClientInfoTable", paramString, "", new Object[0]);
    }
  }
  
  private static void fillValues(ContentValues paramContentValues, ClientInfo paramClientInfo)
  {
    if (paramClientInfo != null)
    {
      paramContentValues.put("clientId", paramClientInfo.clientId);
      paramContentValues.put("taskId", Integer.valueOf(paramClientInfo.taskId));
      paramContentValues.put("taskUrl", paramClientInfo.taskUrl);
    }
  }
  
  /* Error */
  public static java.util.ArrayList<ClientInfo> query(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +111 -> 112
    //   4: new 124	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 125	java/util/ArrayList:<init>	()V
    //   11: astore_3
    //   12: invokestatic 71	com/tencent/tmassistantsdk/storage/helper/AstSDKDBHelper_V2:getInstance	()Lcom/tencent/tmassistantsdk/storage/helper/SqliteHelper;
    //   15: invokevirtual 128	com/tencent/tmassistantsdk/storage/helper/SqliteHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore_2
    //   19: aload_2
    //   20: ldc 15
    //   22: iconst_1
    //   23: anewarray 81	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: aastore
    //   30: invokevirtual 132	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +38 -> 73
    //   38: aload_2
    //   39: astore_0
    //   40: aload_2
    //   41: invokeinterface 136 1 0
    //   46: ifeq +27 -> 73
    //   49: aload_2
    //   50: astore_0
    //   51: aload_3
    //   52: aload_2
    //   53: invokestatic 138	com/tencent/tmassistantsdk/storage/table/ClientInfoTable:cursor2object	(Landroid/database/Cursor;)Lcom/tencent/tmassistantsdk/storage/model/ClientInfo;
    //   56: invokevirtual 142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   59: pop
    //   60: aload_2
    //   61: astore_0
    //   62: aload_2
    //   63: invokeinterface 145 1 0
    //   68: istore_1
    //   69: iload_1
    //   70: ifne -21 -> 49
    //   73: aload_2
    //   74: ifnull +9 -> 83
    //   77: aload_2
    //   78: invokeinterface 148 1 0
    //   83: aload_3
    //   84: areturn
    //   85: astore_3
    //   86: aconst_null
    //   87: astore_2
    //   88: aload_2
    //   89: astore_0
    //   90: ldc 24
    //   92: aload_3
    //   93: ldc 88
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 94	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_2
    //   103: ifnull +9 -> 112
    //   106: aload_2
    //   107: invokeinterface 148 1 0
    //   112: aconst_null
    //   113: areturn
    //   114: astore_2
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +9 -> 127
    //   121: aload_0
    //   122: invokeinterface 148 1 0
    //   127: aload_2
    //   128: athrow
    //   129: astore_2
    //   130: goto -13 -> 117
    //   133: astore_3
    //   134: goto -46 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   68	2	1	bool	boolean
    //   18	89	2	localObject1	Object
    //   114	14	2	localObject2	Object
    //   129	1	2	localObject3	Object
    //   11	73	3	localArrayList	java.util.ArrayList
    //   85	8	3	localException1	Exception
    //   133	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   19	34	85	java/lang/Exception
    //   19	34	114	finally
    //   40	49	129	finally
    //   51	60	129	finally
    //   62	69	129	finally
    //   90	102	129	finally
    //   40	49	133	java/lang/Exception
    //   51	60	133	java/lang/Exception
    //   62	69	133	java/lang/Exception
  }
  
  public static void save(ClientInfo paramClientInfo)
  {
    if (paramClientInfo != null) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
      if (update(paramClientInfo, localSQLiteDatabase) <= 0)
      {
        ContentValues localContentValues = new ContentValues();
        fillValues(localContentValues, paramClientInfo);
        localSQLiteDatabase.insert("clientinfo", null, localContentValues);
      }
      return;
    }
    catch (Exception paramClientInfo)
    {
      y.printErrStackTrace("ClientInfoTable", paramClientInfo, "", new Object[0]);
    }
  }
  
  public static void save(String paramString1, String paramString2)
  {
    ClientInfo localClientInfo = new ClientInfo();
    localClientInfo.clientId = paramString1;
    localClientInfo.taskUrl = paramString2;
    save(localClientInfo);
  }
  
  private static int update(ClientInfo paramClientInfo, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if (paramClientInfo == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        fillValues(localContentValues, paramClientInfo);
        int j = paramSQLiteDatabase.update("clientinfo", localContentValues, "clientId = ? and taskUrl = ?", new String[] { paramClientInfo.clientId, paramClientInfo.taskUrl });
        i = j;
        if (j <= 0) {
          return 0;
        }
      }
      catch (Exception paramClientInfo)
      {
        y.printErrStackTrace("ClientInfoTable", paramClientInfo, "", new Object[0]);
      }
    }
    return -2;
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
  }
  
  public void dataMovement(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2)
  {
    localObject = null;
    localSQLiteDatabase = null;
    if ((paramSQLiteDatabase2 != null) && (paramSQLiteDatabase1 != null)) {
      paramSQLiteDatabase2.beginTransaction();
    }
    try
    {
      paramSQLiteDatabase1 = paramSQLiteDatabase1.rawQuery("select * from clientinfo", null);
      if (paramSQLiteDatabase1 != null)
      {
        localSQLiteDatabase = paramSQLiteDatabase1;
        localObject = paramSQLiteDatabase1;
        if (paramSQLiteDatabase1.moveToFirst())
        {
          boolean bool;
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            ContentValues localContentValues = new ContentValues();
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            fillValues(localContentValues, cursor2object(paramSQLiteDatabase1));
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            paramSQLiteDatabase2.insert("clientinfo", null, localContentValues);
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            bool = paramSQLiteDatabase1.moveToNext();
          } while (bool);
        }
      }
      if (paramSQLiteDatabase1 != null) {
        paramSQLiteDatabase1.close();
      }
    }
    catch (Exception paramSQLiteDatabase1)
    {
      for (;;)
      {
        localObject = localSQLiteDatabase;
        y.printErrStackTrace("ClientInfoTable", paramSQLiteDatabase1, "", new Object[0]);
        if (localSQLiteDatabase != null) {
          localSQLiteDatabase.close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label172;
      }
      ((Cursor)localObject).close();
    }
    paramSQLiteDatabase2.setTransactionSuccessful();
    paramSQLiteDatabase2.endTransaction();
  }
  
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
    return "clientinfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.ClientInfoTable
 * JD-Core Version:    0.7.0.1
 */