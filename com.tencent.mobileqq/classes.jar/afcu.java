import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;

public class afcu
  implements DialogInterface.OnClickListener
{
  public afcu(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PhoneUnityBindInfoActivity.a(this.a) != null) {
      PhoneUnityBindInfoActivity.a(this.a).dismiss();
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcu
 * JD-Core Version:    0.7.0.1
 */