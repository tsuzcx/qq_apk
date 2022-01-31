import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;

public class agjz
  implements DialogInterface.OnDismissListener
{
  public agjz(DialogBaseActivity paramDialogBaseActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a.setOnDismissListener(null);
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjz
 * JD-Core Version:    0.7.0.1
 */