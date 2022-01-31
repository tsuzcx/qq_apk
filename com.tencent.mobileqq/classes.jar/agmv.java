import android.os.Handler;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.ButtonClickListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agmv
  implements ARTipsManager.ButtonClickListener
{
  public agmv(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a()
  {
    ScanTorchActivity.g(this.a);
    ScanTorchActivity.j(this.a, true);
    ScanTorchActivity.a(this.a).postDelayed(new agmw(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agmv
 * JD-Core Version:    0.7.0.1
 */