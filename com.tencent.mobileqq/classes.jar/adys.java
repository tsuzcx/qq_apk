import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.LebaFeedsManager;
import java.util.Comparator;

public class adys
  implements Comparator
{
  private adys(LebaFeedsManager paramLebaFeedsManager) {}
  
  public int a(LebaFeedInfo paramLebaFeedInfo1, LebaFeedInfo paramLebaFeedInfo2)
  {
    return paramLebaFeedInfo2.serverUpdateTime - paramLebaFeedInfo1.serverUpdateTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adys
 * JD-Core Version:    0.7.0.1
 */