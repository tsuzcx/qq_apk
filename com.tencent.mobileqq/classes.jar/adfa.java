import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AddAccountActivity;

public class adfa
  implements DialogInterface.OnDismissListener
{
  public adfa(AddAccountActivity paramAddAccountActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AddAccountActivity.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfa
 * JD-Core Version:    0.7.0.1
 */