import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.ar.ScanningData;
import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class aakt
  implements Runnable
{
  public aakt(ScanningSurfaceView paramScanningSurfaceView, ScanningData paramScanningData) {}
  
  public void run()
  {
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqArScanningData.a, null, null, false);
      if (localURLDrawable != null)
      {
        if (localURLDrawable.getStatus() != 1)
        {
          localURLDrawable.startDownload();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqArScanningData.b = ImageUtil.a(localURLDrawable);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ScanningSurfaceView", 1, "preloadImage catch an exception.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakt
 * JD-Core Version:    0.7.0.1
 */