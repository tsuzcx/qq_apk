import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;

public class afyd
  implements DialogInterface.OnDismissListener
{
  public afyd(DialogBaseActivity paramDialogBaseActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a.setOnDismissListener(null);
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afyd
 * JD-Core Version:    0.7.0.1
 */