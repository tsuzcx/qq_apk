import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.proxy.ProxyObserver;

public class acxu
  extends ProxyObserver
{
  public acxu(ChatHistory paramChatHistory) {}
  
  public void onProxySaveToDbFinished()
  {
    this.a.a(11, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxu
 * JD-Core Version:    0.7.0.1
 */