import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.qphone.base.util.QLog;

public class abhp
  implements DialogInterface.OnClickListener
{
  public abhp(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "showRecommendDialog cancel clicked!");
    }
    awqx.b(this.a.app, "dc00898", "", "", "0X800A605", "0X800A605", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhp
 * JD-Core Version:    0.7.0.1
 */