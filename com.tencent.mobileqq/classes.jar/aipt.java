import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;

public class aipt
  extends SQLiteOpenHelper
{
  public aipt(Context paramContext, String paramString)
  {
    super(paramContext, "passwd_red_bag_" + paramString + ".db", null, 5);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagDBHelper", 2, " onCreate execSQL sqlRedBags=" + "CREATE TABLE IF NOT EXISTS red_bags (redbag_id VARCHAR PRIMARY KEY, redbag_index VARCHAR, uint64_creator_uin VARCHAR, expire_time INTEGER, password VARCHAR, is_open INTEGER, is_finish INTEGER, is_overdue INTEGER, redbag_type INTEGER, last_password VARCHAR, ext_str VARCHAR);" + " sqlRedBagRelation=" + "CREATE TABLE IF NOT EXISTS red_bag_relations (code VARCHAR, source VARCHAR, redbag_id VARCHAR, authkey VARCHAR );" + " sqlUpdateTimes=" + "CREATE TABLE IF NOT EXISTS update_times (code INTEGER, source INTEGER, last_update_time INTEGER, PRIMARY KEY(code,source));");
      }
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS red_bags (redbag_id VARCHAR PRIMARY KEY, redbag_index VARCHAR, uint64_creator_uin VARCHAR, expire_time INTEGER, password VARCHAR, is_open INTEGER, is_finish INTEGER, is_overdue INTEGER, redbag_type INTEGER, last_password VARCHAR, ext_str VARCHAR);");
      return;
    }
    catch (SQLException localSQLException2)
    {
      try
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS red_bag_relations (code VARCHAR, source VARCHAR, redbag_id VARCHAR, authkey VARCHAR );");
      }
      catch (SQLException localSQLException2)
      {
        try
        {
          for (;;)
          {
            paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_times (code INTEGER, source INTEGER, last_update_time INTEGER, PRIMARY KEY(code,source));");
            return;
            localSQLException1 = localSQLException1;
            if (QLog.isColorLevel())
            {
              QLog.e("PasswdRedBagDBHelper", 2, " onCreate execSQL exception", localSQLException1);
              continue;
              localSQLException2 = localSQLException2;
              if (QLog.isColorLevel()) {
                QLog.e("PasswdRedBagDBHelper", 2, " onCreate execSQL exception", localSQLException2);
              }
            }
          }
        }
        catch (SQLException paramSQLiteDatabase)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("PasswdRedBagDBHelper", 2, " onCreate execSQL exception", paramSQLiteDatabase);
        }
      }
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (QLog.isColorLevel())
    {
      QLog.d("PasswdRedBagDBHelper", 2, "onUpgrade<<<<<oldVersion: " + paramInt1 + " newVersion: " + paramInt2);
      i = paramInt1;
    }
    if (i < paramInt2)
    {
      switch (i)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN redbag_index VARCHAR ");
        }
        catch (Exception localException1) {}
        if (QLog.isColorLevel())
        {
          QLog.e("PasswdRedBagDBHelper", 2, " exception occurred when " + "ALTER TABLE red_bags ADD COLUMN redbag_index VARCHAR ", localException1);
          continue;
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN redbag_type INTEGER DEFAULT 0");
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel())
          {
            QLog.e("PasswdRedBagDBHelper", 2, " exception occurred when " + "ALTER TABLE red_bags ADD COLUMN redbag_type INTEGER DEFAULT 0", localException2);
            continue;
            try
            {
              paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN last_password VARCHAR ");
            }
            catch (Exception localException3) {}
            if (QLog.isColorLevel())
            {
              QLog.e("PasswdRedBagDBHelper", 2, " exception occurred when " + "ALTER TABLE red_bags ADD COLUMN last_password VARCHAR ", localException3);
              continue;
              try
              {
                paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN ext_str VARCHAR ");
              }
              catch (Exception localException4) {}
              if (QLog.isColorLevel()) {
                QLog.e("PasswdRedBagDBHelper", 2, " exception occurred when " + "ALTER TABLE red_bags ADD COLUMN ext_str VARCHAR ", localException4);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipt
 * JD-Core Version:    0.7.0.1
 */