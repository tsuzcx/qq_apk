import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.qphone.base.util.QLog;

public class akcq
  implements DialogInterface.OnClickListener
{
  public akcq(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, "new user guild confirm unbind");
    }
    this.a.a.b(BindVerifyActivity.a(this.a), BindVerifyActivity.b(this.a), 0, BindVerifyActivity.a(this.a), BindVerifyActivity.b(this.a));
    this.a.a(2131717771, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcq
 * JD-Core Version:    0.7.0.1
 */