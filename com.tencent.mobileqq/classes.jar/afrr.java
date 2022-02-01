import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import java.util.Comparator;

public class afrr
  implements Comparator<RecentBaseData>
{
  public afrr(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    if (((paramRecentBaseData1 instanceof RecentTroopAssistantItem)) && ((paramRecentBaseData2 instanceof RecentTroopAssistantItem)))
    {
      paramRecentBaseData1 = (RecentTroopAssistantItem)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentTroopAssistantItem)paramRecentBaseData2;
      TroopManager localTroopManager = (TroopManager)this.a.app.getManager(52);
      boolean bool1 = localTroopManager.b(paramRecentBaseData1.getRecentUserUin());
      boolean bool2 = localTroopManager.b(paramRecentBaseData2.getRecentUserUin());
      if ((bool1) && (!bool2)) {
        return -1;
      }
      if ((!bool1) && (bool2)) {
        return 1;
      }
      long l2;
      long l1;
      if ((!bool1) && (!bool2))
      {
        l2 = Math.max(paramRecentBaseData1.getLastMsgTime(), paramRecentBaseData1.getLastDraftTime());
        l1 = Math.max(paramRecentBaseData2.getLastMsgTime(), paramRecentBaseData2.getLastDraftTime());
        if (l2 <= l1) {
          break label173;
        }
        l1 = 3L;
      }
      for (;;)
      {
        l1 = (int)(l1 | 0) - (int)(0x2 | 0);
        if (l1 != 0L) {
          break label195;
        }
        return 0;
        l2 = paramRecentBaseData1.mDisplayTime;
        l1 = paramRecentBaseData2.mDisplayTime;
        break;
        label173:
        if (l2 < l1) {
          l1 = 1L;
        } else {
          l1 = 2L;
        }
      }
      label195:
      if (l1 < 0L) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrr
 * JD-Core Version:    0.7.0.1
 */