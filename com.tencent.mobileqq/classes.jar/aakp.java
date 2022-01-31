import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AuthDevActivity;

public class aakp
  implements DialogInterface.OnDismissListener
{
  public aakp(AuthDevActivity paramAuthDevActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == AuthDevActivity.a(this.a)) {
      AuthDevActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aakp
 * JD-Core Version:    0.7.0.1
 */