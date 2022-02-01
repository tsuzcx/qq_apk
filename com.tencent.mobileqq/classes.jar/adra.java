import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.List;
import mqq.os.MqqHandler;

public class adra
  implements aydl
{
  public adra(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(int paramInt, List<NowSummaryCard.MiniCard> paramList, String paramString)
  {
    if ((paramInt == 0) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ChatSettingActivity.3.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adra
 * JD-Core Version:    0.7.0.1
 */