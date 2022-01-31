import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class afvp
  implements DialogInterface.OnDismissListener
{
  public afvp(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ScanTorchActivity.a(this.a, null);
    ScanTorchActivity.a(this.a, null);
    this.a.a.b(false);
    this.a.a.c(false);
    ScanTorchActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvp
 * JD-Core Version:    0.7.0.1
 */