import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.data.BaseRecentUser;
import java.util.Comparator;

class aket
  implements Comparator<RecentBaseData>
{
  aket(akes paramakes) {}
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    int j = 0;
    int i = j;
    long l1;
    long l2;
    if ((paramRecentBaseData1 instanceof RecentUserBaseData))
    {
      i = j;
      if ((paramRecentBaseData2 instanceof RecentUserBaseData))
      {
        paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
        paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
        l1 = Math.max(paramRecentBaseData1.mUser.lastmsgtime, paramRecentBaseData1.mUser.lastmsgdrafttime);
        l2 = Math.max(paramRecentBaseData2.mUser.lastmsgtime, paramRecentBaseData2.mUser.lastmsgdrafttime);
        if (l1 <= l2) {
          break label83;
        }
        i = -1;
      }
    }
    label83:
    do
    {
      return i;
      i = j;
    } while (l1 >= l2);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aket
 * JD-Core Version:    0.7.0.1
 */