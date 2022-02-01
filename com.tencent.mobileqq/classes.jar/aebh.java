import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class aebh
  implements QQPermissionCallback
{
  aebh(aebg paramaebg, QQSettingMe paramQQSettingMe) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions denied...");
    bfur.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions grant...");
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebh
 * JD-Core Version:    0.7.0.1
 */