package com.tencent.sqlitelint.behaviour.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static final String wRA = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT PRIMARY KEY NOT NULL, %s TEXT NOT NULL, %s INTEGER, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s TEXT, %s INTEGER)", new Object[] { "Issue", "id", "dbPath", "level", "desc", "detail", "advice", "createTime", "extInfo", "sqlTimeCost" });
  public static final String[] wRB = { String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s)", new Object[] { "DbLabel_Index", "Issue", "dbPath" }), String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s,%s)", new Object[] { "DbLabel_CreateTime_Index", "Issue", "dbPath", "createTime" }) };
  private static SQLiteStatement wRC;
  
  /* Error */
  public static boolean afY(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 57
    //   4: iconst_4
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 18
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 16
    //   17: aastore
    //   18: dup
    //   19: iconst_2
    //   20: ldc 18
    //   22: aastore
    //   23: dup
    //   24: iconst_3
    //   25: aload_0
    //   26: aastore
    //   27: invokestatic 40	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   30: astore_0
    //   31: getstatic 63	com/tencent/sqlitelint/behaviour/a/c:wRD	Lcom/tencent/sqlitelint/behaviour/a/c;
    //   34: invokevirtual 67	com/tencent/sqlitelint/behaviour/a/c:getDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: aload_0
    //   38: aconst_null
    //   39: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_0
    //   43: aload_0
    //   44: invokeinterface 79 1 0
    //   49: istore_1
    //   50: iload_1
    //   51: ifle +11 -> 62
    //   54: aload_0
    //   55: invokeinterface 82 1 0
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -10 -> 54
    //   67: astore_3
    //   68: aload_0
    //   69: invokeinterface 82 1 0
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramString	String
    //   49	2	1	i	int
    //   1	63	2	bool	boolean
    //   67	8	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	50	67	finally
  }
  
  public static List<SQLiteLintIssue> afZ(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (SQLiteLintUtil.bl(paramString)) {
      return localArrayList;
    }
    paramString = String.format("SELECT * FROM %s where %s='%s' ORDER BY %s DESC", new Object[] { "Issue", "dbPath", paramString, "createTime" });
    paramString = c.wRD.getDatabase().rawQuery(paramString, null);
    try
    {
      if (paramString.moveToNext())
      {
        SQLiteLintIssue localSQLiteLintIssue = new SQLiteLintIssue();
        localSQLiteLintIssue.id = paramString.getString(paramString.getColumnIndex("id"));
        localSQLiteLintIssue.dbPath = paramString.getString(paramString.getColumnIndex("dbPath"));
        localSQLiteLintIssue.level = paramString.getInt(paramString.getColumnIndex("level"));
        localSQLiteLintIssue.desc = paramString.getString(paramString.getColumnIndex("desc"));
        localSQLiteLintIssue.detail = paramString.getString(paramString.getColumnIndex("detail"));
        localSQLiteLintIssue.advice = paramString.getString(paramString.getColumnIndex("advice"));
        localSQLiteLintIssue.createTime = paramString.getLong(paramString.getColumnIndex("createTime"));
        localSQLiteLintIssue.extInfo = paramString.getString(paramString.getColumnIndex("extInfo"));
        localSQLiteLintIssue.sqlTimeCost = paramString.getLong(paramString.getColumnIndex("sqlTimeCost"));
        localArrayList.add(localSQLiteLintIssue);
      }
      return localList;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public static List<String> cPS()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = String.format("SELECT DISTINCT(%s) FROM %s", new Object[] { "dbPath", "Issue" });
    localObject = c.wRD.getDatabase().rawQuery((String)localObject, null);
    try
    {
      if (((Cursor)localObject).moveToNext()) {
        localArrayList.add(((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("dbPath")));
      }
      return localList;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public static long cPT()
  {
    Object localObject1 = String.format("SELECT rowid FROM %s order by rowid desc limit 1", new Object[] { "Issue" });
    localObject1 = c.wRD.getDatabase().rawQuery((String)localObject1, null);
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
    }
  }
  
  public static void ez(List<SQLiteLintIssue> paramList)
  {
    c.wRD.getDatabase().beginTransaction();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramList.size())
        {
          SQLiteLintIssue localSQLiteLintIssue = (SQLiteLintIssue)paramList.get(i);
          if (afY(localSQLiteLintIssue.id))
          {
            SLog.i("SQLiteLint.IssueStorage", "saveIssue already recorded id=%s", new Object[] { localSQLiteLintIssue.id });
          }
          else
          {
            if (wRC == null) {
              wRC = c.wRD.getDatabase().compileStatement(String.format("INSERT INTO %s VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[] { "Issue" }));
            }
            SQLiteStatement localSQLiteStatement = wRC;
            localSQLiteStatement.bindString(1, localSQLiteLintIssue.id);
            localSQLiteStatement.bindString(2, localSQLiteLintIssue.dbPath);
            localSQLiteStatement.bindLong(3, localSQLiteLintIssue.level);
            localSQLiteStatement.bindString(4, SQLiteLintUtil.pm(localSQLiteLintIssue.desc));
            localSQLiteStatement.bindString(5, SQLiteLintUtil.pm(localSQLiteLintIssue.detail));
            localSQLiteStatement.bindString(6, SQLiteLintUtil.pm(localSQLiteLintIssue.advice));
            localSQLiteStatement.bindLong(7, localSQLiteLintIssue.createTime);
            localSQLiteStatement.bindString(8, localSQLiteLintIssue.extInfo);
            localSQLiteStatement.bindLong(9, localSQLiteLintIssue.sqlTimeCost);
            long l = localSQLiteStatement.executeInsert();
            SLog.d("SQLiteLint.IssueStorage", "saveIssue insert ret=%s, id=%s", new Object[] { Long.valueOf(l), localSQLiteLintIssue.id });
            if (l == -1L) {
              SLog.e("SQLiteLint.IssueStorage", "addIssue failed", new Object[0]);
            }
          }
        }
      }
      finally
      {
        c.wRD.getDatabase().endTransaction();
      }
      c.wRD.getDatabase().setTransactionSuccessful();
      c.wRD.getDatabase().endTransaction();
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.a.a
 * JD-Core Version:    0.7.0.1
 */