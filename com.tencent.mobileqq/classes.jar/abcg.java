import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginInfoActivity;

public class abcg
  implements DialogInterface.OnDismissListener
{
  public abcg(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == LoginInfoActivity.a(this.a)) {
      LoginInfoActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abcg
 * JD-Core Version:    0.7.0.1
 */