import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class afip
  implements QQPermissionCallback
{
  afip(afio paramafio, QQSettingMe paramQQSettingMe) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions denied...");
    bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions grant...");
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afip
 * JD-Core Version:    0.7.0.1
 */