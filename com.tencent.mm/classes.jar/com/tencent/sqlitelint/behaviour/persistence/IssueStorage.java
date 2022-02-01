package com.tencent.sqlitelint.behaviour.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.ArrayList;
import java.util.List;

public class IssueStorage
{
  public static final String COLUMN_ADVICE = "advice";
  public static final String COLUMN_CREATE_TIME = "createTime";
  public static final String COLUMN_DB_PATH = "dbPath";
  public static final String COLUMN_DESC = "desc";
  public static final String COLUMN_DETAIL = "detail";
  public static final String COLUMN_EXT_INFO = "extInfo";
  public static final String COLUMN_ID = "id";
  public static final String COLUMN_LEVEL = "level";
  public static final String COLUMN_SQL_TIME_COST = "sqlTimeCost";
  public static final String[] DB_VERSION_1_CREATE_INDEX;
  public static final String DB_VERSION_1_CREATE_SQL;
  public static final String TABLE_NAME = "Issue";
  private static final String TAG = "SQLiteLint.IssueStorage";
  private static SQLiteStatement sInsertAllSqlStatement;
  
  static
  {
    AppMethodBeat.i(52921);
    DB_VERSION_1_CREATE_SQL = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT PRIMARY KEY NOT NULL, %s TEXT NOT NULL, %s INTEGER, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s TEXT, %s INTEGER)", new Object[] { "Issue", "id", "dbPath", "level", "desc", "detail", "advice", "createTime", "extInfo", "sqlTimeCost" });
    DB_VERSION_1_CREATE_INDEX = new String[] { String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s)", new Object[] { "DbLabel_Index", "Issue", "dbPath" }), String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s,%s)", new Object[] { "DbLabel_CreateTime_Index", "Issue", "dbPath", "createTime" }) };
    AppMethodBeat.o(52921);
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(52918);
    String str = String.format("delete from %s", new Object[] { "Issue" });
    SQLiteLintDbHelper.INSTANCE.getDatabase().execSQL(str);
    AppMethodBeat.o(52918);
  }
  
  private static boolean doInsertIssue(SQLiteLintIssue paramSQLiteLintIssue)
  {
    AppMethodBeat.i(52914);
    SQLiteStatement localSQLiteStatement = getInsertAllSqlStatement();
    localSQLiteStatement.bindString(1, paramSQLiteLintIssue.id);
    localSQLiteStatement.bindString(2, paramSQLiteLintIssue.dbPath);
    localSQLiteStatement.bindLong(3, paramSQLiteLintIssue.level);
    localSQLiteStatement.bindString(4, SQLiteLintUtil.nullAsNil(paramSQLiteLintIssue.desc));
    localSQLiteStatement.bindString(5, SQLiteLintUtil.nullAsNil(paramSQLiteLintIssue.detail));
    localSQLiteStatement.bindString(6, SQLiteLintUtil.nullAsNil(paramSQLiteLintIssue.advice));
    localSQLiteStatement.bindLong(7, paramSQLiteLintIssue.createTime);
    localSQLiteStatement.bindString(8, paramSQLiteLintIssue.extInfo);
    localSQLiteStatement.bindLong(9, paramSQLiteLintIssue.sqlTimeCost);
    long l = localSQLiteStatement.executeInsert();
    SLog.d("SQLiteLint.IssueStorage", "saveIssue insert ret=%s, id=%s", new Object[] { Long.valueOf(l), paramSQLiteLintIssue.id });
    if (l == -1L)
    {
      SLog.e("SQLiteLint.IssueStorage", "addIssue failed", new Object[0]);
      AppMethodBeat.o(52914);
      return false;
    }
    AppMethodBeat.o(52914);
    return true;
  }
  
  public static List<String> getDbPathList()
  {
    AppMethodBeat.i(52916);
    ArrayList localArrayList = new ArrayList();
    Object localObject = String.format("SELECT DISTINCT(%s) FROM %s", new Object[] { "dbPath", "Issue" });
    localObject = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery((String)localObject, null);
    try
    {
      if (((Cursor)localObject).moveToNext()) {}
      return localList;
    }
    finally
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(52916);
    }
  }
  
  private static SQLiteStatement getInsertAllSqlStatement()
  {
    AppMethodBeat.i(52919);
    if (sInsertAllSqlStatement == null) {
      sInsertAllSqlStatement = SQLiteLintDbHelper.INSTANCE.getDatabase().compileStatement(String.format("INSERT INTO %s VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[] { "Issue" }));
    }
    SQLiteStatement localSQLiteStatement = sInsertAllSqlStatement;
    AppMethodBeat.o(52919);
    return localSQLiteStatement;
  }
  
  public static List<SQLiteLintIssue> getIssueListByDb(String paramString)
  {
    AppMethodBeat.i(52915);
    ArrayList localArrayList = new ArrayList();
    if (SQLiteLintUtil.isNullOrNil(paramString))
    {
      AppMethodBeat.o(52915);
      return localArrayList;
    }
    String str = String.format("SELECT * FROM %s where %s=? ORDER BY %s DESC", new Object[] { "Issue", "dbPath", "createTime" });
    paramString = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery(str, new String[] { paramString });
    try
    {
      if (paramString.moveToNext()) {}
      return localList;
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(52915);
    }
  }
  
  public static long getLastRowId()
  {
    AppMethodBeat.i(52917);
    Object localObject1 = String.format("SELECT rowid FROM %s order by rowid desc limit 1", new Object[] { "Issue" });
    localObject1 = SQLiteLintDbHelper.INSTANCE.getDatabase().rawQuery((String)localObject1, null);
    if (localObject1 != null) {}
    try
    {
      if (((Cursor)localObject1).getCount() > 0)
      {
        ((Cursor)localObject1).moveToFirst();
        long l = ((Cursor)localObject1).getLong(0);
        return l;
      }
      return -1L;
    }
    finally
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(52917);
    }
  }
  
  /* Error */
  public static boolean hasIssue(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 246
    //   4: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 248
    //   9: iconst_4
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc 26
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc 38
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: ldc 26
    //   27: aastore
    //   28: dup
    //   29: iconst_3
    //   30: aload_0
    //   31: aastore
    //   32: invokestatic 60	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: astore_0
    //   36: getstatic 89	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintDbHelper:INSTANCE	Lcom/tencent/sqlitelint/behaviour/persistence/SQLiteLintDbHelper;
    //   39: invokevirtual 93	com/tencent/sqlitelint/behaviour/persistence/SQLiteLintDbHelper:getDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: aload_0
    //   43: aconst_null
    //   44: invokevirtual 181	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_0
    //   48: aload_0
    //   49: invokeinterface 237 1 0
    //   54: istore_1
    //   55: iload_1
    //   56: ifle +16 -> 72
    //   59: aload_0
    //   60: invokeinterface 204 1 0
    //   65: ldc 246
    //   67: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iload_2
    //   71: ireturn
    //   72: iconst_0
    //   73: istore_2
    //   74: goto -15 -> 59
    //   77: astore_3
    //   78: aload_0
    //   79: invokeinterface 204 1 0
    //   84: ldc 246
    //   86: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_3
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramString	String
    //   54	2	1	i	int
    //   1	73	2	bool	boolean
    //   77	13	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   48	55	77	finally
  }
  
  private static SQLiteLintIssue issueConvertFromCursor(Cursor paramCursor)
  {
    AppMethodBeat.i(52920);
    SQLiteLintIssue localSQLiteLintIssue = new SQLiteLintIssue();
    localSQLiteLintIssue.id = paramCursor.getString(paramCursor.getColumnIndex("id"));
    localSQLiteLintIssue.dbPath = paramCursor.getString(paramCursor.getColumnIndex("dbPath"));
    localSQLiteLintIssue.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
    localSQLiteLintIssue.desc = paramCursor.getString(paramCursor.getColumnIndex("desc"));
    localSQLiteLintIssue.detail = paramCursor.getString(paramCursor.getColumnIndex("detail"));
    localSQLiteLintIssue.advice = paramCursor.getString(paramCursor.getColumnIndex("advice"));
    localSQLiteLintIssue.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
    localSQLiteLintIssue.extInfo = paramCursor.getString(paramCursor.getColumnIndex("extInfo"));
    localSQLiteLintIssue.sqlTimeCost = paramCursor.getLong(paramCursor.getColumnIndex("sqlTimeCost"));
    AppMethodBeat.o(52920);
    return localSQLiteLintIssue;
  }
  
  public static boolean saveIssue(SQLiteLintIssue paramSQLiteLintIssue)
  {
    AppMethodBeat.i(52911);
    if (hasIssue(paramSQLiteLintIssue.id))
    {
      SLog.i("SQLiteLint.IssueStorage", "saveIssue already recorded id=%s", new Object[] { paramSQLiteLintIssue.id });
      AppMethodBeat.o(52911);
      return false;
    }
    boolean bool = doInsertIssue(paramSQLiteLintIssue);
    AppMethodBeat.o(52911);
    return bool;
  }
  
  public static void saveIssues(List<SQLiteLintIssue> paramList)
  {
    AppMethodBeat.i(52912);
    SQLiteLintDbHelper.INSTANCE.getDatabase().beginTransaction();
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        saveIssue((SQLiteLintIssue)paramList.get(i));
        i += 1;
      }
      SQLiteLintDbHelper.INSTANCE.getDatabase().setTransactionSuccessful();
      return;
    }
    finally
    {
      SQLiteLintDbHelper.INSTANCE.getDatabase().endTransaction();
      AppMethodBeat.o(52912);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.persistence.IssueStorage
 * JD-Core Version:    0.7.0.1
 */