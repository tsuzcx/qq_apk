import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class acjd
  extends SQLiteOpenHelper
{
  private static acjd a;
  
  private acjd(Context paramContext)
  {
    super(paramContext, "sdk_db", null, 3);
  }
  
  public static acjd a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acjd(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE result_objects (_id INTEGER PRIMARY KEY AUTOINCREMENT,params TEXT,is_real_time TINYINT,uin BIGINT,status TINYINT,occur_time BIGINT);");
    paramSQLiteDatabase.execSQL("CREATE TABLE upload_errors (_id INTEGER PRIMARY KEY AUTOINCREMENT,uin BIGINT,plugin SMALLINT,uploadtime BIGINT,error_code SMALLINT,error_msg TEXT,http_get TEXT,status TINYINT);");
    paramSQLiteDatabase.execSQL("CREATE TABLE drop_frame (_id INTEGER PRIMARY KEY AUTOINCREMENT,uin BIGINT,scene TEXT,state TINYINT,drop_duration LONG,drop_count LONG,range_0 INT,range_1 INT,range_2_4 INT,range_4_8 INT,range_8_15 INT,range_over_15 INT,status TINYINT);");
    paramSQLiteDatabase.execSQL("CREATE TABLE configs (_id INTEGER PRIMARY KEY AUTOINCREMENT,plugin SMALLINT,user_sample_ratio INT,threshold FLOAT,max_report_num INT,event_sample_ratio FLOAT,stack_depth INT);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("Drop table if exists result_objects");
    paramSQLiteDatabase.execSQL("Drop table if exists upload_errors");
    paramSQLiteDatabase.execSQL("Drop table if exists drop_frame");
    paramSQLiteDatabase.execSQL("Drop table if exists configs");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjd
 * JD-Core Version:    0.7.0.1
 */