import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.qphone.base.util.QLog;

public class alph
  implements bdbe
{
  public alph(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void onCameraException(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowCameraActivity", 2, "[onCameraException]", paramException);
    }
  }
  
  public void onDispatchThreadException(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowCameraActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alph
 * JD-Core Version:    0.7.0.1
 */