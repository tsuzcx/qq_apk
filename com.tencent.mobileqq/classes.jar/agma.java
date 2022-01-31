import android.text.TextUtils;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import java.io.File;

public class agma
  implements Runnable
{
  public agma(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.r(this.a);
    if ((!TextUtils.isEmpty(ScanTorchActivity.b(this.a))) && (new File(ScanTorchActivity.b(this.a)).exists()))
    {
      this.a.runOnUiThread(new agmb(this));
      return;
    }
    this.a.runOnUiThread(new agmd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agma
 * JD-Core Version:    0.7.0.1
 */