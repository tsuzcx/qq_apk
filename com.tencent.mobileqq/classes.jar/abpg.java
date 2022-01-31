import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class abpg
  implements Runnable
{
  public abpg(DBFixManager paramDBFixManager) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0);
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (((SharedPreferences)localObject).getBoolean(str + DBFixManager.d, false))
    {
      this.a.a();
      if ((((SharedPreferences)localObject).getInt(str + DBFixManager.e, 0) < DBFixManager.jdField_a_of_type_Int) && (DBFixManager.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new abph(this));
      }
    }
    else
    {
      return;
    }
    QLog.d(DBFixManager.a(), 1, "DBFixDialogUI 1, max count, delete db");
    this.a.b(false);
    this.a.b();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.d);
    ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.e);
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abpg
 * JD-Core Version:    0.7.0.1
 */