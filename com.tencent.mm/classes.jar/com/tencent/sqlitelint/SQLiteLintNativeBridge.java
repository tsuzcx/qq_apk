package com.tencent.sqlitelint;

import android.database.Cursor;
import android.database.SQLException;
import com.tencent.sqlitelint.util.SLog;
import java.util.ArrayList;

public class SQLiteLintNativeBridge
{
  private static final String TAG = "SQLiteLint.SQLiteLintNativeBridge";
  
  private void doExecSqlCallback(long paramLong1, long paramLong2, String paramString, Cursor paramCursor)
  {
    if (paramCursor == null)
    {
      SLog.w("SQLiteLint.SQLiteLintNativeBridge", "doExecSqlCallback cu is null", new Object[0]);
      return;
    }
    int j;
    String[] arrayOfString2;
    String[] arrayOfString1;
    int i;
    do
    {
      execSqlCallback(paramLong1, paramLong2, paramString, j, arrayOfString2, arrayOfString1);
      if (!paramCursor.moveToNext()) {
        break;
      }
      j = paramCursor.getColumnCount();
      arrayOfString1 = new String[j];
      arrayOfString2 = new String[j];
      i = 0;
    } while (i >= j);
    arrayOfString1[i] = paramCursor.getColumnName(i);
    switch (paramCursor.getType(i))
    {
    default: 
      arrayOfString2[i] = "";
    }
    for (;;)
    {
      i += 1;
      break;
      arrayOfString2[i] = String.valueOf(paramCursor.getBlob(i));
      continue;
      arrayOfString2[i] = String.valueOf(paramCursor.getLong(i));
      continue;
      arrayOfString2[i] = String.valueOf(paramCursor.getString(i));
      continue;
      arrayOfString2[i] = String.valueOf(paramCursor.getFloat(i));
    }
  }
  
  private native void execSqlCallback(long paramLong1, long paramLong2, String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  public static void loadLibrary()
  {
    System.loadLibrary("SqliteLint-lib");
    SLog.nativeSetLogger(2);
  }
  
  public static native void nativeAddToWhiteList(String paramString, String[] paramArrayOfString, String[][] paramArrayOfString1);
  
  public static native void nativeEnableCheckers(String paramString, String[] paramArrayOfString);
  
  static native void nativeInstall(String paramString);
  
  static native void nativeNotifySqlExecute(String paramString1, String paramString2, long paramLong, String paramString3);
  
  static native void nativeUninstall(String paramString);
  
  private static void onPublishIssue(String paramString, ArrayList<SQLiteLintIssue> paramArrayList)
  {
    try
    {
      g.wRf.afX(paramString).ey(paramArrayList);
      return;
    }
    catch (Throwable paramString)
    {
      SLog.e("SQLiteLint.SQLiteLintNativeBridge", "onPublishIssue ex ", new Object[] { paramString.getMessage() });
    }
  }
  
  private String[] sqliteLintExecSql(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    String[] arrayOfString = new String[2];
    c localc;
    for (;;)
    {
      try
      {
        SLog.i("SQLiteLint.SQLiteLintNativeBridge", "dbPath %s, sql is %s ,needCallBack: %b", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
        arrayOfString[0] = "";
        arrayOfString[1] = "-1";
        localc = null;
        f localf = g.wRf.afX(paramString1);
        if (localf != null) {
          localc = localf.wQX;
        }
        if (localc == null)
        {
          SLog.w("SQLiteLint.SQLiteLintNativeBridge", "sqliteLintExecSql mExecSqlImp is null", new Object[0]);
          return arrayOfString;
        }
        if (!paramBoolean) {
          break;
        }
        try
        {
          paramString2 = localc.rawQuery(paramString2, new String[0]);
          if ((paramString2 == null) || (paramString2.getCount() < 0))
          {
            SLog.w("SQLiteLint.SQLiteLintNativeBridge", "sqliteLintExecSql cu is null", new Object[0]);
            arrayOfString[0] = "Cursor is null";
            if (paramString2 == null) {
              continue;
            }
            paramString2.close();
            return arrayOfString;
          }
        }
        catch (Exception paramString1)
        {
          SLog.w("SQLiteLint.SQLiteLintNativeBridge", "sqliteLintExecSql rawQuery exp: %s", new Object[] { paramString1.getMessage() });
          arrayOfString[0] = paramString1.getMessage();
          return arrayOfString;
        }
        doExecSqlCallback(paramLong1, paramLong2, paramString1, paramString2);
      }
      catch (Throwable paramString1)
      {
        SLog.e("SQLiteLint.SQLiteLintNativeBridge", "sqliteLintExecSql ex ", new Object[] { paramString1.getMessage() });
        return arrayOfString;
      }
      arrayOfString[1] = "0";
    }
    try
    {
      localc.execSQL(paramString2);
      arrayOfString[1] = "0";
      return arrayOfString;
    }
    catch (SQLException paramString1)
    {
      SLog.w("SQLiteLint.SQLiteLintNativeBridge", "sqliteLintExecSql execSQL exp: %s", new Object[] { paramString1.getMessage() });
      arrayOfString[0] = paramString1.getMessage();
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLintNativeBridge
 * JD-Core Version:    0.7.0.1
 */