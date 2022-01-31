import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.qphone.base.util.QLog;

public class ablc
  implements Runnable
{
  public ablc(ConfessPlugin paramConfessPlugin) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 4, "mProcessShareRunable mLastShareData:" + this.a.jdField_a_of_type_OrgJsonJSONObject + " mHeaderLoader:" + this.a.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader);
    }
    if ((this.a.jdField_a_of_type_OrgJsonJSONObject == null) || (this.a.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader == null)) {
      return;
    }
    ConfessPlugin.a(this.a, this.a.jdField_a_of_type_OrgJsonJSONObject);
    this.a.jdField_a_of_type_OrgJsonJSONObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ablc
 * JD-Core Version:    0.7.0.1
 */