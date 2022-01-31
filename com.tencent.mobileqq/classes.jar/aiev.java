import android.os.SystemClock;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.WatermarkVideoRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aiev
  implements FFmpegExecuteResponseCallback
{
  public aiev(ShortVideoUtils.WatermarkVideoRunnable paramWatermarkVideoRunnable, String paramString) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, new Object[] { "update system gallery: ", this.jdField_a_of_type_JavaLangString });
    }
    com.tencent.biz.qqstory.utils.FileUtils.a(BaseApplication.getContext(), new File(this.jdField_a_of_type_JavaLangString));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ShortVideoUtils", 2, new Object[] { "watermark video finish: ", Boolean.valueOf(paramBoolean) });
      double d = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUtils$WatermarkVideoRunnable.jdField_a_of_type_Long) / 1000.0D;
      QLog.d("ShortVideoUtils", 2, "generate files|third step cost:" + d);
    }
    for (;;)
    {
      synchronized (ShortVideoUtils.WatermarkVideoRunnable.a())
      {
        ShortVideoUtils.WatermarkVideoRunnable.a().notify();
        if (!ShortVideoUtils.WatermarkVideoRunnable.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUtils$WatermarkVideoRunnable))
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUtils$WatermarkVideoRunnable;
          if (paramBoolean)
          {
            i = 10000;
            ShortVideoUtils.WatermarkVideoRunnable.a((ShortVideoUtils.WatermarkVideoRunnable)???, i);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUtils$WatermarkVideoRunnable.jdField_a_of_type_JavaLangString != null) {
            com.tencent.mobileqq.utils.FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUtils$WatermarkVideoRunnable.jdField_a_of_type_JavaLangString);
          }
          return;
        }
      }
      int i = 10001;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoUtils", 2, "watermark video failed: " + paramString);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aiev
 * JD-Core Version:    0.7.0.1
 */