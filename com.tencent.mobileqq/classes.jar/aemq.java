import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aemq
  implements DialogInterface.OnClickListener
{
  public aemq(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PhoneUnityBindInfoActivity.a(this.a) != null)
    {
      this.a.h();
      PhoneUnityBindInfoActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemq
 * JD-Core Version:    0.7.0.1
 */