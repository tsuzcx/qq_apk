import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agln
  implements DialogInterface.OnDismissListener
{
  public agln(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onDismiss");
    }
    if ((!this.a.isFinishing()) && (this.a.a != null))
    {
      if (this.a.isResume())
      {
        this.a.a.b(false);
        ScanTorchActivity.c(this.a, true);
      }
    }
    else {
      return;
    }
    ScanTorchActivity.n(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agln
 * JD-Core Version:    0.7.0.1
 */