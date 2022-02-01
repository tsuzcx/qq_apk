import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class aixe
  implements QQPermissionCallback
{
  public aixe(PublicView paramPublicView, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView.denied();
    bhdj.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixe
 * JD-Core Version:    0.7.0.1
 */