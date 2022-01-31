import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppEnvConfig;
import com.tencent.mobileqq.ark.ArkAppInfo.ContextActionAppInfo;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class aaxx
{
  public static final Object a;
  int jdField_a_of_type_Int;
  SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private static String a(int paramInt)
  {
    if (1 == ArkAppEnvConfig.a().a())
    {
      if (paramInt == 1) {
        return "gray_ark_app_info_test.db";
      }
      if (paramInt == 2) {
        return "ark_app_info_test.db";
      }
    }
    else
    {
      if (paramInt == 1) {
        return "gray_ark_app_info.db";
      }
      if (paramInt == 2) {
        return "ark_app_info.db";
      }
    }
    return null;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL("DELETE FROM action_app_name WHERE id NOT IN ( SELECT id FROM action_app_name a JOIN (SELECT context, action, app_name, max(app_id) as app_id FROM action_app_name GROUP BY context, action, app_name) b ON a.context=b.context AND a.action=b.action AND a.app_name=b.app_name AND a.app_id=b.app_id) ");
      return;
    }
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) {
      return null;
    }
    ArrayList localArrayList;
    try
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Cursor localCursor = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery("SELECT context, action, MAX(app_id), MAX(time) FROM action_app_name GROUP BY context, action", null);
        if (localCursor == null) {
          return null;
        }
      }
      localArrayList = new ArrayList();
      while (localObject2.moveToNext())
      {
        String str1 = localObject2.getString(0);
        String str2 = localObject2.getString(1);
        long l1 = localObject2.getLong(2);
        long l2 = localObject2.getLong(3);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        {
          ArkAppInfo.ContextActionAppInfo localContextActionAppInfo = new ArkAppInfo.ContextActionAppInfo();
          localContextActionAppInfo.jdField_a_of_type_JavaLangString = str1;
          localContextActionAppInfo.jdField_b_of_type_JavaLangString = str2;
          localContextActionAppInfo.jdField_a_of_type_Long = l1;
          localContextActionAppInfo.jdField_b_of_type_Long = l2;
          localArrayList.add(localContextActionAppInfo);
        }
      }
      localException.close();
    }
    catch (Exception localException)
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("getContextActionList fail, msg=%s", new Object[] { localException.getMessage() }));
      return null;
    }
    return localArrayList;
  }
  
  public ArrayList a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) {}
    while ((StringUtil.a(paramString1)) || (StringUtil.a(paramString2))) {
      return null;
    }
    ArrayList localArrayList;
    try
    {
      Cursor localCursor;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localCursor = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.rawQuery("SELECT app_name, MAX(app_id), MAX(time) FROM action_app_name GROUP BY context, action, app_name HAVING context=? AND action=?", new String[] { paramString1, paramString2 });
        if (localCursor == null) {
          return null;
        }
      }
      localArrayList = new ArrayList();
      while (localCursor.moveToNext())
      {
        String str = localCursor.getString(0);
        long l1 = localCursor.getLong(1);
        long l2 = localCursor.getLong(2);
        ArkAppInfo.ContextActionAppInfo localContextActionAppInfo = new ArkAppInfo.ContextActionAppInfo();
        localContextActionAppInfo.jdField_a_of_type_JavaLangString = paramString1;
        localContextActionAppInfo.jdField_b_of_type_JavaLangString = paramString2;
        localContextActionAppInfo.c = str;
        localContextActionAppInfo.jdField_a_of_type_Long = l1;
        localContextActionAppInfo.jdField_b_of_type_Long = l2;
        localArrayList.add(localContextActionAppInfo);
      }
      localCursor.close();
    }
    catch (Exception paramString1)
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("getAppInfoByContextAction, fail, msg=%s", new Object[] { paramString1.getMessage() }));
      return null;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) {
      return;
    }
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = null;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) {
      return false;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL("DELETE FROM action_app_name");
        ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("deleteAllData success", new Object[0]));
        return true;
      }
      catch (Exception localException)
      {
        ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("deleteAllData fail, msg=%s", new Object[] { localException.getMessage() }));
        return false;
      }
    }
  }
  
  public boolean a(Context paramContext, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null) {
      return true;
    }
    String str = a(paramInt);
    if (StringUtil.a(str)) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = new aaxy(paramContext, str).getWritableDatabase();
      if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) {
        return false;
      }
      this.jdField_a_of_type_Int = paramInt;
      return true;
    }
    catch (Exception paramContext)
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("initDatabase, fail, msg=%s", new Object[] { paramContext.getMessage() }));
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = null;
      this.jdField_a_of_type_Int = 0;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    try
    {
      SQLiteStatement localSQLiteStatement;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localSQLiteStatement = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.compileStatement("UPDATE action_app_name SET time=?1 WHERE context=?2 AND action=?3");
        if (localSQLiteStatement == null) {
          return false;
        }
      }
      localSQLiteStatement.bindLong(1, System.currentTimeMillis());
      localSQLiteStatement.bindString(2, paramString1);
      localSQLiteStatement.bindString(3, paramString2);
      localSQLiteStatement.execute();
      localSQLiteStatement.close();
      return true;
    }
    catch (Exception paramString1)
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("updateActionUpdateTime fail, msg=%s", new Object[] { paramString1.getMessage() }));
    }
    return false;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) {
      return false;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return true;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransaction();
      try
      {
        SQLiteStatement localSQLiteStatement = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.compileStatement("INSERT OR REPLACE INTO action_app_name (context, action, app_id, app_name, time) VALUES (?1, ?2, ?3, ?4, ?5)");
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          ArkAppInfo.ContextActionAppInfo localContextActionAppInfo = (ArkAppInfo.ContextActionAppInfo)paramArrayList.next();
          localSQLiteStatement.clearBindings();
          localSQLiteStatement.bindString(1, localContextActionAppInfo.jdField_a_of_type_JavaLangString);
          localSQLiteStatement.bindString(2, localContextActionAppInfo.jdField_b_of_type_JavaLangString);
          localSQLiteStatement.bindLong(3, localContextActionAppInfo.jdField_a_of_type_Long);
          localSQLiteStatement.bindString(4, localContextActionAppInfo.c);
          localSQLiteStatement.bindLong(5, System.currentTimeMillis());
          localSQLiteStatement.execute();
        }
        paramArrayList = finally;
      }
      catch (Exception paramArrayList)
      {
        ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("updateAppInfo fail, msg=%s", new Object[] { paramArrayList.getMessage() }));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
        return false;
        b();
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setTransactionSuccessful();
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
        return true;
      }
      finally
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxx
 * JD-Core Version:    0.7.0.1
 */