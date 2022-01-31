package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTask;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadInfoTable
  implements ITableBase
{
  public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, secondaryUrl TEXT, finalUrl TEXT, requestFileSize INTEGER, fileName TEXT, contentType TEXT, redirectCnt INTEGER, retryCnt INTEGER, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER,netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT);";
  public static final String QUERY_ALL = "select * from downloadInfo";
  public static final String QUERY_DOWNLOADINFO_URL = "select * from downloadInfo where taskUrl = ?";
  public static final String QUERY_UNFINISHED_TASK = "select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)";
  public static final String TABLE_NAME = "downloadInfo";
  private static final String TAG = "DownloadInfoTable";
  
  public static void add(DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(76197);
    if (paramDownloadInfo != null) {
      try
      {
        SQLiteDatabase localSQLiteDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
        if (update(paramDownloadInfo, localSQLiteDatabase) <= 0)
        {
          ContentValues localContentValues = new ContentValues();
          DownloadInfo.writeToContentValues(localContentValues, paramDownloadInfo);
          localSQLiteDatabase.insert("downloadInfo", null, localContentValues);
        }
        AppMethodBeat.o(76197);
        return;
      }
      catch (Exception paramDownloadInfo)
      {
        ab.printErrStackTrace("DownloadInfoTable", paramDownloadInfo, "", new Object[0]);
      }
    }
    AppMethodBeat.o(76197);
  }
  
  public static void del(String paramString)
  {
    AppMethodBeat.i(76198);
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete("downloadInfo", "taskUrl = ?", new String[] { paramString });
        AppMethodBeat.o(76198);
        return;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("DownloadInfoTable", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(76198);
  }
  
  public static ArrayList<DownloadInfo> load()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(76195);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = AstSDKDBHelper_V2.getInstance().getReadableDatabase();
    try
    {
      localObject4 = ((SQLiteDatabase)localObject4).rawQuery("select * from downloadInfo", null);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(DownloadInfo.readFromCursor((Cursor)localObject4));
            localObject1 = localObject4;
            localObject3 = localObject4;
            bool = ((Cursor)localObject4).moveToNext();
          } while (bool);
        }
      }
      if (localObject4 != null) {
        ((Cursor)localObject4).close();
      }
      AppMethodBeat.o(76195);
      return localArrayList;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      ab.printErrStackTrace("DownloadInfoTable", localException, "", new Object[0]);
      return localArrayList;
    }
    finally
    {
      if (localObject3 != null) {
        localObject3.close();
      }
      AppMethodBeat.o(76195);
    }
  }
  
  /* Error */
  public static DownloadInfo query(String paramString)
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +79 -> 85
    //   9: aload_0
    //   10: invokevirtual 92	java/lang/String:length	()I
    //   13: ifle +72 -> 85
    //   16: invokestatic 47	com/tencent/tmassistantsdk/storage/helper/AstSDKDBHelper_V2:getInstance	()Lcom/tencent/tmassistantsdk/storage/helper/SqliteHelper;
    //   19: invokevirtual 107	com/tencent/tmassistantsdk/storage/helper/SqliteHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: ldc 16
    //   24: iconst_1
    //   25: anewarray 88	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_0
    //   31: aastore
    //   32: invokevirtual 111	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +38 -> 75
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: invokeinterface 117 1 0
    //   48: ifeq +27 -> 75
    //   51: aload_1
    //   52: astore_0
    //   53: aload_1
    //   54: invokestatic 121	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:readFromCursor	(Landroid/database/Cursor;)Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   57: astore_2
    //   58: aload_1
    //   59: ifnull +9 -> 68
    //   62: aload_1
    //   63: invokeinterface 130 1 0
    //   68: ldc 135
    //   70: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_2
    //   74: areturn
    //   75: aload_1
    //   76: ifnull +9 -> 85
    //   79: aload_1
    //   80: invokeinterface 130 1 0
    //   85: ldc 135
    //   87: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: astore_0
    //   97: ldc 25
    //   99: aload_2
    //   100: ldc 77
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 83	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_1
    //   110: ifnull -25 -> 85
    //   113: aload_1
    //   114: invokeinterface 130 1 0
    //   119: goto -34 -> 85
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +9 -> 135
    //   129: aload_0
    //   130: invokeinterface 130 1 0
    //   135: ldc 135
    //   137: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: goto -18 -> 125
    //   146: astore_2
    //   147: goto -52 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   35	79	1	localCursor	Cursor
    //   122	19	1	localObject1	Object
    //   142	1	1	localObject2	Object
    //   57	17	2	localDownloadInfo	DownloadInfo
    //   92	8	2	localException1	Exception
    //   146	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   16	36	92	java/lang/Exception
    //   16	36	122	finally
    //   42	51	142	finally
    //   53	58	142	finally
    //   97	109	142	finally
    //   42	51	146	java/lang/Exception
    //   53	58	146	java/lang/Exception
  }
  
  public static ArrayList<ServiceDownloadTask> query()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(76201);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = AstSDKDBHelper_V2.getInstance().getReadableDatabase();
    try
    {
      localObject4 = ((SQLiteDatabase)localObject4).rawQuery("select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)", null);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            Object localObject5 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("clientId"));
            localObject1 = localObject4;
            localObject3 = localObject4;
            String str = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("taskUrl"));
            localObject1 = localObject4;
            localObject3 = localObject4;
            int i = ((Cursor)localObject4).getInt(((Cursor)localObject4).getColumnIndex("status"));
            localObject1 = localObject4;
            localObject3 = localObject4;
            localObject5 = new ServiceDownloadTask((String)localObject5, str);
            localObject1 = localObject4;
            localObject3 = localObject4;
            ((ServiceDownloadTask)localObject5).mState = i;
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(localObject5);
            localObject1 = localObject4;
            localObject3 = localObject4;
            bool = ((Cursor)localObject4).moveToNext();
          } while (bool);
        }
      }
      if (localObject4 != null) {
        ((Cursor)localObject4).close();
      }
      AppMethodBeat.o(76201);
      return localArrayList;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      ab.printErrStackTrace("DownloadInfoTable", localException, "", new Object[0]);
      return localArrayList;
    }
    finally
    {
      if (localObject3 != null) {
        localObject3.close();
      }
      AppMethodBeat.o(76201);
    }
  }
  
  public static void save(ArrayList<DownloadInfo> paramArrayList)
  {
    AppMethodBeat.i(76196);
    if (paramArrayList != null)
    {
      SQLiteDatabase localSQLiteDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
      try
      {
        localSQLiteDatabase.beginTransaction();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)paramArrayList.next();
          if (update(localDownloadInfo, localSQLiteDatabase) <= 0)
          {
            ContentValues localContentValues = new ContentValues();
            DownloadInfo.writeToContentValues(localContentValues, localDownloadInfo);
            localSQLiteDatabase.insert("downloadInfo", null, localContentValues);
          }
        }
        AppMethodBeat.o(76196);
      }
      catch (Exception paramArrayList)
      {
        ab.printErrStackTrace("DownloadInfoTable", paramArrayList, "", new Object[0]);
        return;
        localSQLiteDatabase.setTransactionSuccessful();
        return;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
        AppMethodBeat.o(76196);
      }
    }
  }
  
  private static int update(DownloadInfo paramDownloadInfo, SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(76199);
    if (paramDownloadInfo == null)
    {
      AppMethodBeat.o(76199);
      return -1;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      DownloadInfo.writeToContentValues(localContentValues, paramDownloadInfo);
      int i = paramSQLiteDatabase.update("downloadInfo", localContentValues, "taskUrl = ?", new String[] { paramDownloadInfo.mURL });
      if (i > 0)
      {
        AppMethodBeat.o(76199);
        return i;
      }
      AppMethodBeat.o(76199);
      return 0;
    }
    catch (Exception paramDownloadInfo)
    {
      ab.printErrStackTrace("DownloadInfoTable", paramDownloadInfo, "", new Object[0]);
      AppMethodBeat.o(76199);
    }
    return -2;
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, secondaryUrl TEXT, finalUrl TEXT, requestFileSize INTEGER, fileName TEXT, contentType TEXT, redirectCnt INTEGER, retryCnt INTEGER, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER,netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT);";
  }
  
  public void dataMovement(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2)
  {
    localObject = null;
    localSQLiteDatabase = null;
    AppMethodBeat.i(76202);
    if ((paramSQLiteDatabase2 != null) && (paramSQLiteDatabase1 != null)) {
      paramSQLiteDatabase2.beginTransaction();
    }
    try
    {
      paramSQLiteDatabase1 = paramSQLiteDatabase1.rawQuery("select * from downloadInfo", null);
      if (paramSQLiteDatabase1 != null)
      {
        localSQLiteDatabase = paramSQLiteDatabase1;
        localObject = paramSQLiteDatabase1;
        if (paramSQLiteDatabase1.moveToFirst())
        {
          localSQLiteDatabase = paramSQLiteDatabase1;
          localObject = paramSQLiteDatabase1;
          TMLog.i("downloadInfo", "start move data!");
          boolean bool;
          do
          {
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            ContentValues localContentValues = new ContentValues();
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            DownloadInfo.writeToContentValues(localContentValues, DownloadInfo.readFromSimpleCursor(paramSQLiteDatabase1));
            localSQLiteDatabase = paramSQLiteDatabase1;
            localObject = paramSQLiteDatabase1;
            paramSQLiteDatabase2.insert("downloadInfo", null, localContentValues);
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
        ab.printErrStackTrace("DownloadInfoTable", paramSQLiteDatabase1, "", new Object[0]);
        localObject = localSQLiteDatabase;
        TMLog.i("downloadInfo", "move data exception!");
        if (localSQLiteDatabase != null) {
          localSQLiteDatabase.close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label206;
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(76202);
    }
    paramSQLiteDatabase2.setTransactionSuccessful();
    paramSQLiteDatabase2.endTransaction();
    AppMethodBeat.o(76202);
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 2)) {
      return new String[] { "alter table downloadInfo add column headerParams TEXT;" };
    }
    return new String[] { "alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;" };
  }
  
  public SqliteHelper getHelper()
  {
    AppMethodBeat.i(76194);
    SqliteHelper localSqliteHelper = AstSDKDBHelper_V2.getInstance();
    AppMethodBeat.o(76194);
    return localSqliteHelper;
  }
  
  public String tableName()
  {
    return "downloadInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.table.DownloadInfoTable
 * JD-Core Version:    0.7.0.1
 */