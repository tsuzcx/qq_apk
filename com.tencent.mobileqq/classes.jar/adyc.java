import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.ScreenShotUtil.ScreenshotCallback;

class adyc
  implements ScreenShotUtil.ScreenshotCallback
{
  adyc(adyb paramadyb) {}
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.post(new adyd(this, paramBitmap), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyc
 * JD-Core Version:    0.7.0.1
 */