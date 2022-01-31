import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.ScreenShotUtil.ScreenshotCallback;

class aegm
  implements ScreenShotUtil.ScreenshotCallback
{
  aegm(aegl paramaegl) {}
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.post(new aegn(this, paramBitmap), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegm
 * JD-Core Version:    0.7.0.1
 */