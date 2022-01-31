import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class agje
  implements DialogInterface.OnClickListener
{
  public agje(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, "new user guild confirm unbind");
    }
    this.a.a.b(BindVerifyActivity.a(this.a), BindVerifyActivity.b(this.a), 0, BindVerifyActivity.a(this.a), BindVerifyActivity.b(this.a));
    this.a.a(2131719281, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agje
 * JD-Core Version:    0.7.0.1
 */