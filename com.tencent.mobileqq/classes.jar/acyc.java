import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class acyc
  implements Comparator<RecentUser>
{
  public acyc(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    return (int)(paramRecentUser2.showUpTime - paramRecentUser1.showUpTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acyc
 * JD-Core Version:    0.7.0.1
 */