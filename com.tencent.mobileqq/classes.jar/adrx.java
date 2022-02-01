import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AddAccountActivity;

public class adrx
  implements DialogInterface.OnDismissListener
{
  public adrx(AddAccountActivity paramAddAccountActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AddAccountActivity.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrx
 * JD-Core Version:    0.7.0.1
 */