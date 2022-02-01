import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.qphone.base.util.QLog;

public class akow
  implements DialogInterface.OnClickListener
{
  public akow(DialogBaseActivity paramDialogBaseActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "new user guild confirm unbind");
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity.app, "dc00898", "", "", "0X8006AA5", "0X8006AA5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akow
 * JD-Core Version:    0.7.0.1
 */