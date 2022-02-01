import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import mqq.os.MqqHandler;

public class ajrf
  extends ProxyObserver
{
  public ajrf(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onProxySaveToDbFinished()
  {
    this.a.a.sendEmptyMessage(41);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrf
 * JD-Core Version:    0.7.0.1
 */