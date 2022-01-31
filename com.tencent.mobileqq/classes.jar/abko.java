import android.os.Bundle;
import com.tencent.mobileqq.activity.QQIdentiferLegacy;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicBoolean;

public class abko
  implements EIPCResultCallback
{
  public abko(QQIdentiferLegacy paramQQIdentiferLegacy, boolean paramBoolean) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQIdentiferLegacy", 2, "callServer error_code:" + paramEIPCResult.code);
    }
    switch (paramEIPCResult.code)
    {
    default: 
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        QQIdentiferLegacy.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy);
      }
      return;
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
      continue;
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
      if (paramEIPCResult.data != null) {
        QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy, (FaceDetectForThirdPartyManager.AppConf)paramEIPCResult.data.getSerializable("FaceRecognition.AppConf"));
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QQIdentiferLegacy", 2, "callServer error_code:" + QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy));
        continue;
        QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
        QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abko
 * JD-Core Version:    0.7.0.1
 */