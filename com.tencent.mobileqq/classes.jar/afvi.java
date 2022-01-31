import android.os.Handler;
import com.tencent.mobileqq.armap.FrameBmpCache.EndListener;
import com.tencent.mobileqq.armap.SdCardImageAnimView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class afvi
  implements FrameBmpCache.EndListener
{
  public afvi(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a(SdCardImageAnimView paramSdCardImageAnimView)
  {
    paramSdCardImageAnimView.a();
    this.a.a.post(new afvj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvi
 * JD-Core Version:    0.7.0.1
 */