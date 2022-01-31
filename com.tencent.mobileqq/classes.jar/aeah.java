import com.tencent.mobileqq.leba.LebaFeedsManager;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.leba.ark.LebaArkReporter;

public class aeah
  implements Runnable
{
  public aeah(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void run()
  {
    LebaArkReporter.a();
    LebaWithFeeds.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeah
 * JD-Core Version:    0.7.0.1
 */