import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;

public class alwn
  extends Handler
{
  public alwn(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && ((this.a.j == 1) || (this.a.j == 2)))
    {
      this.a.a();
      bbmy.a(this.a, 2131625456, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alwn
 * JD-Core Version:    0.7.0.1
 */