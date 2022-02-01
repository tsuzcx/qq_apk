import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

class agzs
  implements QQPermissionCallback
{
  agzs(agzq paramagzq, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
    this.jdField_a_of_type_Agzq.denied();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Agzq.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzs
 * JD-Core Version:    0.7.0.1
 */