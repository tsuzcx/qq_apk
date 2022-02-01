import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class ahph
  implements ahpi
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    int i = 1;
    if (ahbo.a(paramMessageRecord)) {
      if (paramMessageRecord.istroop != 0) {
        break label41;
      }
    }
    for (;;)
    {
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800B154", "0X800B154", i, 0, "", "", "", "");
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
 * Qualified Name:     ahph
 * JD-Core Version:    0.7.0.1
 */