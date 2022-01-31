import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;

public class aany
  implements Handler.Callback
{
  public aany(Conversation paramConversation) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    arih.a().a(paramMessage.what);
    if (paramMessage.what == 4)
    {
      this.a.a(1134013, 0L, false);
      return true;
    }
    this.a.e(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aany
 * JD-Core Version:    0.7.0.1
 */