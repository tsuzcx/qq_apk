import android.text.TextUtils;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import java.io.File;

public class aftz
  implements Runnable
{
  public aftz(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.q(this.a);
    if ((!TextUtils.isEmpty(ScanTorchActivity.c(this.a))) && (new File(ScanTorchActivity.c(this.a)).exists()))
    {
      this.a.runOnUiThread(new afua(this));
      return;
    }
    this.a.runOnUiThread(new afuc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftz
 * JD-Core Version:    0.7.0.1
 */