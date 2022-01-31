import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginInfoActivity;

public class ablr
  implements DialogInterface.OnDismissListener
{
  public ablr(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == LoginInfoActivity.a(this.a)) {
      LoginInfoActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ablr
 * JD-Core Version:    0.7.0.1
 */