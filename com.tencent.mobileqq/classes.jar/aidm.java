import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.List;
import mqq.os.MqqHandler;

public class aidm
  implements aydl
{
  aidm(aidd paramaidd) {}
  
  public void a(int paramInt, List<NowSummaryCard.MiniCard> paramList, String paramString)
  {
    if ((paramInt == 0) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new NearbyChatPie.7.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidm
 * JD-Core Version:    0.7.0.1
 */