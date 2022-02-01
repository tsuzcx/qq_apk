import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.qphone.base.util.QLog;

public class alrb
  implements bdbk
{
  public alrb(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAutoFocusCallback(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "single tap focus " + paramBoolean1);
    }
    alrr.a(paramBoolean1);
    if (paramBoolean1)
    {
      NewFlowCameraActivity.h(this.a, true);
      return;
    }
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alrb
 * JD-Core Version:    0.7.0.1
 */