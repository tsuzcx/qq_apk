import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.qphone.base.util.QLog;

public class agtf
  implements Runnable
{
  public agtf(CapturePtvTemplateManager paramCapturePtvTemplateManager) {}
  
  public void run()
  {
    this.a.c(true);
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig", 2, "saved to red dot config file");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agtf
 * JD-Core Version:    0.7.0.1
 */