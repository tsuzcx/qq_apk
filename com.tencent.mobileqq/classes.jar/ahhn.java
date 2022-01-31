import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.qphone.base.util.QLog;

public class ahhn
  implements Runnable
{
  public ahhn(CaptureVideoFilterManager paramCaptureVideoFilterManager) {}
  
  public void run()
  {
    this.a.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig", 2, "saved to red dot config file");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahhn
 * JD-Core Version:    0.7.0.1
 */