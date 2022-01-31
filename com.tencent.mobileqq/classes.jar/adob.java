import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.ScreenShotUtil.ScreenshotCallback;

class adob
  implements ScreenShotUtil.ScreenshotCallback
{
  adob(adoa paramadoa) {}
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.post(new adoc(this, paramBitmap), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adob
 * JD-Core Version:    0.7.0.1
 */