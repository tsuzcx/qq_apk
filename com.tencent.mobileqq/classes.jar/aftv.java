import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class aftv
  implements DialogInterface.OnDismissListener
{
  public aftv(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b = null;
    this.a.a.b(false);
    this.a.a.c(false);
    ScanTorchActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftv
 * JD-Core Version:    0.7.0.1
 */