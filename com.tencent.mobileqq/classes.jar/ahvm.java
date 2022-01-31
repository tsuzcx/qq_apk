import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.qphone.base.util.QLog;

public class ahvm
  implements axhy
{
  public ahvm(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahvm
 * JD-Core Version:    0.7.0.1
 */