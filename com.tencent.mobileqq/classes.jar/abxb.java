import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AddAccountActivity;

public class abxb
  implements DialogInterface.OnDismissListener
{
  public abxb(AddAccountActivity paramAddAccountActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AddAccountActivity.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxb
 * JD-Core Version:    0.7.0.1
 */