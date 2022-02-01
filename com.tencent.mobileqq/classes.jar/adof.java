import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import mqq.os.MqqHandler;

public class adof
  extends anyz
{
  public adof(ChatHistory paramChatHistory) {}
  
  protected void onUpdateDelRoamChat(boolean paramBoolean)
  {
    this.a.r();
    if (!paramBoolean)
    {
      Message localMessage = this.a.a.obtainMessage(5);
      this.a.a(localMessage);
    }
  }
  
  protected void onUpdateSetRoamChat(boolean paramBoolean)
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
 * Qualified Name:     adof
 * JD-Core Version:    0.7.0.1
 */