import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class abvw
  implements DialogInterface.OnDismissListener
{
  public abvw(QQMapActivity paramQQMapActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.l) && (!this.a.m) && (!this.a.k)) {
      this.a.finish();
    }
    this.a.m = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abvw
 * JD-Core Version:    0.7.0.1
 */