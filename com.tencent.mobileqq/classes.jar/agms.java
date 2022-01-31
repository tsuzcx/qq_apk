import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agms
  implements Runnable
{
  public agms(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    Bitmap localBitmap = ScanTorchActivity.a(this.a, "res/fudai/alertbg.png", false);
    if (localBitmap != null) {
      BaseApplicationImpl.sImageCache.put("res/fudai/alertbg.png", localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agms
 * JD-Core Version:    0.7.0.1
 */