import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class ahzj
  implements ahyf
{
  public void a(ahed paramahed, MessageRecord paramMessageRecord, ahfq paramahfq, agjk paramagjk, String paramString, LinearLayout paramLinearLayout, Context paramContext)
  {
    if ((paramMessageRecord instanceof MessageForSafeGrayTips)) {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
      }
    }
    for (paramMessageRecord = (MessageForSafeGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      paramahed.a(paramMessageRecord, paramahfq.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzj
 * JD-Core Version:    0.7.0.1
 */