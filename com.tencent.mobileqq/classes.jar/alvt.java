import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.qphone.base.util.QLog;

public class alvt
  implements bdbf
{
  public alvt(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "[onCameraException]", paramException);
    }
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvt
 * JD-Core Version:    0.7.0.1
 */