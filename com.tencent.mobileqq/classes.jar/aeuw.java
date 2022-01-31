import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class aeuw
  implements QQPermissionCallback
{
  public aeuw(PublicView paramPublicView, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView.denied();
    babr.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeuw
 * JD-Core Version:    0.7.0.1
 */