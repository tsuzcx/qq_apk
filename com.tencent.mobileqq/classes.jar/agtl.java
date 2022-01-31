import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.qphone.base.util.QLog;

public class agtl
  implements Runnable
{
  public agtl(CaptureVideoFilterManager paramCaptureVideoFilterManager) {}
  
  public void run()
  {
    this.a.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig", 2, "saved to red dot config file");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agtl
 * JD-Core Version:    0.7.0.1
 */