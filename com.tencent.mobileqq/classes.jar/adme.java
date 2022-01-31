import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

class adme
  implements QQPermissionCallback
{
  adme(admc paramadmc, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
    this.jdField_a_of_type_Admc.denied();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Admc.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adme
 * JD-Core Version:    0.7.0.1
 */