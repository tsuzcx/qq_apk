import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.data.RockDownloadInfo;
import java.util.HashMap;
import java.util.Map;

public class amat
  extends QQEntityManagerFactory
{
  private static Map<String, Class<?>> a = new HashMap();
  
  static
  {
    a.put(RockDownloadInfo.class.getSimpleName(), RockDownloadInfo.class);
  }
  
  public amat()
  {
    super("RockDownload");
  }
  
  public akfu build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 1);
      this.dbHelper = new akfu(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(aulp.a(new RockDownloadInfo()));
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amat
 * JD-Core Version:    0.7.0.1
 */