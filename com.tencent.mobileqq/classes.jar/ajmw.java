import android.graphics.Bitmap;
import com.tencent.mobileqq.util.ScreenShotUtil.ScreenshotCallback;
import com.tencent.qphone.base.util.QLog;

public final class ajmw
  implements Runnable
{
  public ajmw(ScreenShotUtil.ScreenshotCallback paramScreenshotCallback, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScreenShotUtil", 2, "ScreenShot Finish Callback");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilScreenShotUtil$ScreenshotCallback.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajmw
 * JD-Core Version:    0.7.0.1
 */