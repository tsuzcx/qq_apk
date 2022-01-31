import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AddAccountActivity;

public class aagb
  implements DialogInterface.OnDismissListener
{
  public aagb(AddAccountActivity paramAddAccountActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AddAccountActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagb
 * JD-Core Version:    0.7.0.1
 */