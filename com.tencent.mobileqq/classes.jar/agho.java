import android.text.TextUtils;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import java.io.File;

public class agho
  implements Runnable
{
  public agho(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.r(this.a);
    if ((!TextUtils.isEmpty(ScanTorchActivity.b(this.a))) && (new File(ScanTorchActivity.b(this.a)).exists()))
    {
      this.a.runOnUiThread(new aghp(this));
      return;
    }
    this.a.runOnUiThread(new aghr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agho
 * JD-Core Version:    0.7.0.1
 */