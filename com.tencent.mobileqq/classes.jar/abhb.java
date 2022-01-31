import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class abhb
  implements Runnable
{
  public abhb(FlowCameraPhotoActivity paramFlowCameraPhotoActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      this.a.e();
      QQToast.a(this.a, "扫描超时", 1).a();
    } while (!QLog.isColorLevel());
    QLog.d("BusinessCard_FlowCameraPhotoActivity", 2, "request ocr time out!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abhb
 * JD-Core Version:    0.7.0.1
 */