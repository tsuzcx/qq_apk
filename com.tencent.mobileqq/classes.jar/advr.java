import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;

public class advr
  implements DialogInterface.OnCancelListener
{
  public advr(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advr
 * JD-Core Version:    0.7.0.1
 */