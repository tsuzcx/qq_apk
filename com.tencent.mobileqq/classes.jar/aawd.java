import android.graphics.Bitmap;
import com.tencent.mobileqq.armap.FrameBmpCache;
import com.tencent.mobileqq.armap.SdCardImageAnimView;

public class aawd
  implements Runnable
{
  public aawd(SdCardImageAnimView paramSdCardImageAnimView) {}
  
  public void run()
  {
    if (SdCardImageAnimView.a(this.a) != null)
    {
      Bitmap localBitmap = SdCardImageAnimView.a(this.a).a(0);
      this.a.post(new aawe(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawd
 * JD-Core Version:    0.7.0.1
 */