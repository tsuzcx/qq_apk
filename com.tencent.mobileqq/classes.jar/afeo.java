import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

class afeo
  implements QQPermissionCallback
{
  afeo(afem paramafem, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
    this.jdField_a_of_type_Afem.denied();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Afem.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afeo
 * JD-Core Version:    0.7.0.1
 */