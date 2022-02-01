import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class afgt
  implements DialogInterface.OnDismissListener
{
  public afgt(QQMapActivity paramQQMapActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.l) && (!this.a.m) && (!this.a.k)) {
      this.a.finish();
    }
    this.a.m = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgt
 * JD-Core Version:    0.7.0.1
 */