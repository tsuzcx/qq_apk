import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.qphone.base.remote.SimpleAccount;

public class acfy
  implements bhuk
{
  SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  
  public acfy(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.b.dismiss();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount, true);
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfy
 * JD-Core Version:    0.7.0.1
 */