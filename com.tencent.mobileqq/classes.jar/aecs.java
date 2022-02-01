import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import mqq.os.MqqHandler;

public class aecs
  extends aocj
{
  public aecs(ChatHistory paramChatHistory) {}
  
  protected void b(boolean paramBoolean)
  {
    this.a.r();
    if (!paramBoolean)
    {
      Message localMessage = this.a.a.obtainMessage(5);
      this.a.a(localMessage);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localMessage = this.a.a.obtainMessage(3);
      this.a.a(localMessage);
      return;
    }
    Message localMessage = this.a.a.obtainMessage(2);
    this.a.a(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecs
 * JD-Core Version:    0.7.0.1
 */