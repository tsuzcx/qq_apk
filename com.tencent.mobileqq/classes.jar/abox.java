import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import mqq.app.AppActivity;

public class abox
  implements DialogInterface.OnClickListener
{
  public abox(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, AppActivity paramAppActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      RegisterPhoneNumActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity.a.a(this.jdField_a_of_type_MqqAppAppActivity, false)) {
        RegisterPhoneNumActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abox
 * JD-Core Version:    0.7.0.1
 */