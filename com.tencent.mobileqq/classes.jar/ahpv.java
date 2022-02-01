import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class ahpv
  implements ahor
{
  public void a(agup paramagup, MessageRecord paramMessageRecord, agwc paramagwc, afzq paramafzq, String paramString, LinearLayout paramLinearLayout, Context paramContext)
  {
    if ((paramMessageRecord instanceof MessageForSafeGrayTips)) {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
      }
    }
    for (paramMessageRecord = (MessageForSafeGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      paramagup.a(paramMessageRecord, paramagwc.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpv
 * JD-Core Version:    0.7.0.1
 */