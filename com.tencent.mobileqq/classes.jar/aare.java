import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class aare
  extends SQLiteOpenHelper
{
  public aare(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 2);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS action_app_name(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `context` char(128) NOT NULL, `action` char(32) NOT NULL, `app_id` BIGINT NOT NULL, `app_name` char(128) NOT NULL, `time` BIGINT NOT NULL, `update_interval` INTEGER DEFAULT 0 NOT NULL, UNIQUE (context, action, app_id, app_name))");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS action_app_name");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS action_app_name");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aare
 * JD-Core Version:    0.7.0.1
 */