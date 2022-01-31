import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class acbm
  extends AccountObserver
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public acbm(AccountManageActivity paramAccountManageActivity, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onDeleteAccount(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "DelHistoryAccountObserver onDeleteAccount isSuccess " + paramBoolean + ",peerUin:" + this.jdField_a_of_type_JavaLangString + ",isDeleteHistory:" + this.jdField_a_of_type_Boolean);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity;
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((AccountManageActivity)localObject).getSharedPreferences("Last_Login", i);
      if ((paramBoolean) && (localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(this.jdField_a_of_type_JavaLangString)))
      {
        ((SharedPreferences)localObject).edit().remove("uin").commit();
        if (QLog.isColorLevel()) {
          QLog.d("Switch_Account", 2, "delete Last_Login");
        }
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbm
 * JD-Core Version:    0.7.0.1
 */