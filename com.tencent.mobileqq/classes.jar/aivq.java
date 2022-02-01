import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import mqq.os.MqqHandler;

public class aivq
  extends ProxyObserver
{
  public aivq(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onProxySaveToDbFinished()
  {
    this.a.a.sendEmptyMessage(41);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivq
 * JD-Core Version:    0.7.0.1
 */