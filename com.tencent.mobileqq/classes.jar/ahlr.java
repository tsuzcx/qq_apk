import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import com.tencent.qphone.base.util.QLog;

public class ahlr
  implements Runnable
{
  public ahlr(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onCaptureVideoFilterRefresh");
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlr
 * JD-Core Version:    0.7.0.1
 */