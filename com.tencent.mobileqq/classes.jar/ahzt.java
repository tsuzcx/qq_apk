import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class ahzt
  implements ahzu
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    int i = 1;
    if (ahml.a(paramMessageRecord)) {
      if (paramMessageRecord.istroop != 0) {
        break label41;
      }
    }
    for (;;)
    {
      bdll.b(paramQQAppInterface, "dc00898", "", "", "0X800B154", "0X800B154", i, 0, "", "", "", "");
      return;
      label41:
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
 * Qualified Name:     ahzt
 * JD-Core Version:    0.7.0.1
 */