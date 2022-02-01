import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;

public class afct
  implements DialogInterface.OnClickListener
{
  public afct(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
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
 * Qualified Name:     afct
 * JD-Core Version:    0.7.0.1
 */