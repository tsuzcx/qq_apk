import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class abof
  implements Runnable
{
  abof(abod paramabod) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.a.a.a != null)) {
      QLog.w("BusinessCard_FlowCameraPhotoActivity", 2, "onSend error " + this.a.a.a.toString() + "errorCode=" + this.a.a.a.a);
    }
    this.a.a.e();
    QQToast.a(this.a.a, 2131437079, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abof
 * JD-Core Version:    0.7.0.1
 */