import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class ahqf
  implements ahqg
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("MessageFoldExposeBusiness", 2, "onMessageExpose");
    }
    if (ahcz.a(paramMessageRecord)) {
      if (paramMessageRecord.istroop != 0) {
        break label55;
      }
    }
    for (;;)
    {
      bcst.b(paramQQAppInterface, "dc00898", "", "", "0X800B154", "0X800B154", i, 0, "", "", "", "");
      return;
      label55:
      if (paramMessageRecord.istroop == 1) {
        i = 2;
      } else if (ChatActivityUtils.a(paramMessageRecord.istroop)) {
        i = 3;
      } else {
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqf
 * JD-Core Version:    0.7.0.1
 */