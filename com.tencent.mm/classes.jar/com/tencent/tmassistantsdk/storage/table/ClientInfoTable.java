package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(76185);
    ClientInfo localClientInfo = new ClientInfo();
    localClientInfo.clientId = paramCursor.getString(paramCursor.getColumnIndex("clientId"));
    localClientInfo.taskId = paramCursor.getInt(paramCursor.getColumnIndex("taskId"));
    localClientInfo.taskUrl = paramCursor.getString(paramCursor.getColumnIndex("taskUrl"));
    AppMethodBeat.o(76185);
    return localClientInfo;
  }
  
  public static void delete(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76190);
    if ((paramString1 != null) && (paramString2 != null)) {
      try
      {
        AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete("clientinfo", "clientId = ? and taskUrl = ?", new String[] { paramString1, paramString2 });
        AppMethodBeat.o(76190);
        return;
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("ClientInfoTable", paramString1, "", new Object[0]);
      }
    }
    AppMethodBeat.o(76190);
  }
  
  public static void deleteItemsByURL(String paramString)
  {
    AppMethodBeat.i(76191);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete("clientinfo", "taskUrl = ?", new String[] { paramString });
        AppMethodBeat.o(76191);
        return;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("ClientInfoTable", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(76191);
  }
  
  private static void fillValues(ContentValues paramContentValues, ClientInfo paramClientInfo)
  {
    AppMethodBeat.i(76184);
    if (paramClientInfo != null)
    {
      paramContentValues.put("clientId", paramClientInfo.clientId);
      paramContentValues.put("taskId", Integer.valueOf(paramClientInfo.taskId));
      paramContentValues.put("taskUrl", paramClientInfo.taskUrl);
    }
    AppMethodBeat.o(76184);
  }
  
  /* Error */
  public static java.util.ArrayList<ClientInfo> query(String paramString)
  {
    // Byte code:
    //   0: ldc 137
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +116 -> 122
    //   9: new 139	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 140	java/util/ArrayList:<init>	()V
    //   16: astore_3
    //   17: invokestatic 83	com/tencent/tmassistantsdk/storage/helper/AstSDKDBHelper_V2:getInstance	()Lcom/tencent/tmassistantsdk/storage/helper/SqliteHelper;
    //   20: invokevirtual 143	com/tencent/tmassistantsdk/storage/helper/SqliteHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_2
    //   24: aload_2
    //   25: ldc 16
    //   27: iconst_1
    //   28: anewarray 93	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: aastore
    //   35: invokevirtual 147	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +38 -> 78
    //   43: aload_2
    //   44: astore_0
    //   45: aload_2
    //   46: invokeinterface 151 1 0
    //   51: ifeq +27 -> 78
    //   54: aload_2
    //   55: astore_0
    //   56: aload_3
    //   57: aload_2
    //   58: invokestatic 153	com/tencent/tmassistantsdk/storage/table/ClientInfoTable:cursor2object	(Landroid/database/Cursor;)Lcom/tencent/tmassistantsdk/storage/model/ClientInfo;
    //   61: invokevirtual 157	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   64: pop
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: invokeinterface 160 1 0
    //   73: istore_1
    //   74: iload_1
    //   75: ifne -21 -> 54
    //   78: aload_2
    //   79: ifnull +9 -> 88
    //   82: aload_2
    //   83: invokeinterface 163 1 0
    //   88: ldc 137
    //   90: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_3
    //   94: areturn
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_2
    //   99: astore_0
    //   100: ldc 25
    //   102: aload_3
    //   103: ldc 100
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_2
    //   113: ifnull +9 -> 122
    //   116: aload_2
    //   117: invokeinterface 163 1 0
    //   122: ldc 137
    //   124: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: ifnull +9 -> 142
    //   136: aload_0
    //   137: invokeinterface 163 1 0
    //   142: ldc 137
    //   144: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: goto -18 -> 132
    //   153: astore_3
    //   154: goto -56 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramString	String
    //   73	2	1	bool	boolean
    //   23	94	2	localObject1	Object
    //   129	19	2	localObject2	Object
    //   149	1	2	localObject3	Object
    //   16	78	3	localArrayList	java.util.ArrayList
    //   95	8	3	localException1	Exception
    //   153	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	39	95	java/lang/Exception
    //   24	39	129	finally
    //   45	54	149	finally
    //   56	65	149	finally
    //   67	74	149	finally
    //   100	112	149	finally
    //   45	54	153	java/lang/Exception
    //   56	65	153	java/lang/Exception
    //   67	74	153	java/lang/Exception
  }
  
  public static void save(ClientInfo paramClientInfo)
  {
    AppMethodBeat.i(76186);
    if (paramClientInfo != null) {
      try
      {
        SQLiteDatabase localSQLiteDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
        if (update(paramClientInfo, localSQLiteDatabase) <= 0)
        {
          ContentValues localContentValues = new ContentValues();
          fillValues(localContentValues, paramClientInfo);
          localSQLiteDatabase.insert("clientinfo", null, localContentValues);
        }
        AppMethodBeat.o(76186);
        return;
      }
      catch (Exception paramClientInfo)
      {
        ab.printErrStackTrace("ClientInfoTable", paramClientInfo, "", new Object[0]);
      }
    }
    AppMethodBeat.o(76186);
  }
  
  public static void save(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76187);
    ClientInfo localClientInfo = new ClientInfo();
    localClientInfo.clientId = paramString1;
    localClientInfo.taskUrl = paramString2;
    save(localClientInfo);
    AppMethodBeat.o(76187);
  }
  
  private static int update(ClientInfo paramClientInfo, SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(76188);
    if (paramClientInfo == null)
    {
      AppMethodBeat.o(76188);
      return -1;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      fillValues(localContentValues, paramClientInfo);
      int i = paramSQLiteDatabase.update("clientinfo", localContentValues, "clientId = ? and taskUrl = ?", new String[] { paramClientInfo.clientId, paramClientInfo.taskUrl });
      if (i > 0)
      {
        AppMethodBeat.o(76188);
        return i;
      }
      AppMethodBeat.o(76188);
      return 0;
    }
    catch (Exception paramClientInfo)
    {
      ab.printErrStackTrace("ClientInfoTable", paramClientInfo, "", new Object[0]);
      AppMethodBeat.o(76188);
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
    AppMethodBeat.i(76193);
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
        ab.printErrStackTrace("ClientInfoTable", paramSQLiteDatabase1, "", new Object[0]);
        if (localSQLiteDatabase != null) {
          localSQLiteDatabase.close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label182;
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(76193);
    }
    paramSQLiteDatabase2.setTransactionSuccessful();
    paramSQLiteDatabase2.endTransaction();
    AppMethodBeat.o(76193);
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public SqliteHelper getHelper()
  {
    AppMethodBeat.i(76192);
    SqliteHelper localSqliteHelper = AstSDKDBHelper_V2.getInstance();
    AppMethodBeat.o(76192);
    return localSqliteHelper;
  }
  
  public String tableName()
  {
    return "clientinfo";
  }
  
  public class Columns
  {
    public static final String CLIENTID = "clientId";
    public static final String TASKID = "taskId";
    public static final String TASKURL = "taskUrl";
    
    public Columns() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.ClientInfoTable
 * JD-Core Version:    0.7.0.1
 */