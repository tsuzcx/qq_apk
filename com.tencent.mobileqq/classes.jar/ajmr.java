import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.qphone.base.util.QLog;

public class ajmr
  implements azdk
{
  public ajmr(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "single tap focus " + paramBoolean1);
    }
    ajnh.a(paramBoolean1);
    if (paramBoolean1)
    {
      NewFlowCameraActivity.h(this.a, true);
      return;
    }
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmr
 * JD-Core Version:    0.7.0.1
 */