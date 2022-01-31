import android.os.Handler;
import com.tencent.mobileqq.armap.FrameBmpCache.EndListener;
import com.tencent.mobileqq.armap.SdCardImageAnimView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agix
  implements FrameBmpCache.EndListener
{
  public agix(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a(SdCardImageAnimView paramSdCardImageAnimView)
  {
    paramSdCardImageAnimView.a();
    this.a.a.post(new agiy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agix
 * JD-Core Version:    0.7.0.1
 */