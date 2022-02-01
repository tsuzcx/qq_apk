import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class ahov
  implements ahnr
{
  public void a(agtf paramagtf, MessageRecord paramMessageRecord, agus paramagus, aftk paramaftk, String paramString, LinearLayout paramLinearLayout, Context paramContext)
  {
    if ((paramMessageRecord instanceof MessageForSafeGrayTips)) {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
      }
    }
    for (paramMessageRecord = (MessageForSafeGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      paramagtf.a(paramMessageRecord, paramagus.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahov
 * JD-Core Version:    0.7.0.1
 */