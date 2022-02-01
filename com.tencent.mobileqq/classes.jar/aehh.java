import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginInfoActivity;

public class aehh
  implements DialogInterface.OnDismissListener
{
  public aehh(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == LoginInfoActivity.a(this.a)) {
      LoginInfoActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehh
 * JD-Core Version:    0.7.0.1
 */