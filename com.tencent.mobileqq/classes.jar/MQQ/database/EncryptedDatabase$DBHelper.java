package mqq.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class EncryptedDatabase$DBHelper
  extends SQLiteOpenHelper
{
  public EncryptedDatabase$DBHelper(EncryptedDatabase paramEncryptedDatabase, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, EncryptedDatabase.access$000(paramEncryptedDatabase), paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.database.EncryptedDatabase.DBHelper
 * JD-Core Version:    0.7.0.1
 */