import android.os.Message;
import com.tencent.mobileqq.activity.QQIdentiferLegacy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class abkn
  implements YTAGReflectLiveCheckInterface.GetLiveStyleResult
{
  public abkn(QQIdentiferLegacy paramQQIdentiferLegacy, boolean paramBoolean) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = new WeJson();
    Object localObject2 = new LiveStyleRequester.YTLiveStyleReq(-2.0F);
    ((LiveStyleRequester.YTLiveStyleReq)localObject2).app_id = "10164651";
    localObject1 = ((WeJson)localObject1).toJson(localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy.a.obtainMessage(2);
    ((Message)localObject2).arg1 = 24;
    ((Message)localObject2).obj = localObject1;
    if (paramInt == 3) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy.a.sendMessageDelayed((Message)localObject2, 2000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder("getLightInfo Failed code=");
        ((StringBuilder)localObject1).append(paramInt).append(" tips=").append(paramString1).append(" howtofix=").append(paramString2).append(" lightRTry=").append(QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).get());
        QLog.d("QQIdentiferLegacy", 2, ((StringBuilder)localObject1).toString());
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy.a.sendMessage((Message)localObject2);
    }
  }
  
  public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse)
  {
    paramYTLiveStyleReq.app_id = "10164651";
    paramYTLiveStyleReq = new WeJson().toJson(paramYTLiveStyleReq);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy.a.removeMessages(2);
    paramLiveStyleResponse = this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy.a.obtainMessage(2);
    paramLiveStyleResponse.arg1 = 23;
    this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy.a.sendMessage(paramLiveStyleResponse);
    if (QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).compareAndSet(true, true)) {}
    do
    {
      return;
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy, paramYTLiveStyleReq, this.jdField_a_of_type_Boolean);
    } while (!QLog.isColorLevel());
    QLog.d("QQIdentiferLegacy", 2, "getLightInfo success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abkn
 * JD-Core Version:    0.7.0.1
 */