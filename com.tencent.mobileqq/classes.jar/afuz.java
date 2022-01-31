import android.os.Handler;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.ButtonClickListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class afuz
  implements ARTipsManager.ButtonClickListener
{
  public afuz(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a()
  {
    ScanTorchActivity.g(this.a);
    ScanTorchActivity.j(this.a, true);
    ScanTorchActivity.a(this.a).postDelayed(new afva(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuz
 * JD-Core Version:    0.7.0.1
 */