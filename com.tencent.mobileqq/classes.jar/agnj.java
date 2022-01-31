import android.os.Handler;
import com.tencent.mobileqq.armap.FrameBmpCache.EndListener;
import com.tencent.mobileqq.armap.SdCardImageAnimView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agnj
  implements FrameBmpCache.EndListener
{
  public agnj(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a(SdCardImageAnimView paramSdCardImageAnimView)
  {
    paramSdCardImageAnimView.a();
    this.a.a.post(new agnk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnj
 * JD-Core Version:    0.7.0.1
 */