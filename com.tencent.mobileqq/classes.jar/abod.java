import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

public class abod
  extends TransProcessorHandler
{
  public abod(FlowCameraPhotoActivity paramFlowCameraPhotoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    this.a.d = true;
    switch (paramMessage.what)
    {
    default: 
    case 1003: 
      do
      {
        do
        {
          return;
        } while (localFileMsg == null);
        paramMessage = localFileMsg.a;
        if (paramMessage != null)
        {
          this.a.a = CardOCRInfo.a(paramMessage);
          this.a.runOnUiThread(new aboe(this));
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("BusinessCard_FlowCameraPhotoActivity", 2, "extraInfo is null");
      return;
    }
    paramMessage = localFileMsg.a;
    if (paramMessage != null) {
      this.a.a = CardOCRInfo.a(paramMessage);
    }
    if (this.a.a != null) {
      BusinessCardUtils.a(this.a.app.getCurrentAccountUin(), this.a.a.a, -1, false, 0L);
    }
    this.a.runOnUiThread(new abof(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abod
 * JD-Core Version:    0.7.0.1
 */