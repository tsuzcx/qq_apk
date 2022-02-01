import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;

public class aejl
  implements Handler.Callback
{
  public aejl(Conversation paramConversation) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    awzv.a().a(paramMessage.what);
    if (paramMessage.what == 4)
    {
      this.a.a(1134013, 0L, false);
      return true;
    }
    this.a.d(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejl
 * JD-Core Version:    0.7.0.1
 */