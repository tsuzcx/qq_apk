import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class ailo
  implements DialogInterface.OnClickListener
{
  public ailo(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, "new user guild confirm unbind");
    }
    this.a.a("dc00898", "0X8009F16", 0);
    this.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.a.jdField_a_of_type_JavaLangString, this.a.c, 0, this.a.jdField_a_of_type_Boolean, this.a.b);
    this.a.a(2131719785, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailo
 * JD-Core Version:    0.7.0.1
 */