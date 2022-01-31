import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.LebaTitleBar;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import mqq.os.MqqHandler;

public class aeak
  extends MqqHandler
{
  public aeak(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.a != null) && ("0".equals(this.a.a.getCurrentAccountUin()))) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1134006: 
      case 11340005: 
        LebaWithFeeds.a(this.a).e();
        return;
      case 11340002: 
        LebaWithFeeds.a(this.a);
        LebaWithFeeds.a(this.a, true, 3);
        return;
      }
    } while (!LebaWithFeeds.a(this.a));
    LebaWithFeeds.a(this.a, true, 5);
    return;
    LebaWithFeeds.a(this.a, true, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeak
 * JD-Core Version:    0.7.0.1
 */