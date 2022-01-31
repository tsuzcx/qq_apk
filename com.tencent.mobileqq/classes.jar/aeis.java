import com.tencent.mobileqq.leba.LebaTitleBar;
import com.tencent.mobileqq.leba.LebaWithFeeds;

public class aeis
  implements Runnable
{
  public aeis(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void run()
  {
    if (LebaWithFeeds.a(this.a) != null) {
      LebaWithFeeds.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeis
 * JD-Core Version:    0.7.0.1
 */