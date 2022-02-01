import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

class agot
  implements QQPermissionCallback
{
  agot(agor paramagor, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
    this.jdField_a_of_type_Agor.denied();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Agor.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agot
 * JD-Core Version:    0.7.0.1
 */