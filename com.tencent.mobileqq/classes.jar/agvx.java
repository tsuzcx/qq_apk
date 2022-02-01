import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class agvx
  implements agut
{
  public void a(agap paramagap, MessageRecord paramMessageRecord, agcc paramagcc, afce paramafce, String paramString, LinearLayout paramLinearLayout, Context paramContext)
  {
    if ((paramMessageRecord instanceof MessageForSafeGrayTips)) {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
      }
    }
    for (paramMessageRecord = (MessageForSafeGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      paramagap.a(paramMessageRecord, paramagcc.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvx
 * JD-Core Version:    0.7.0.1
 */