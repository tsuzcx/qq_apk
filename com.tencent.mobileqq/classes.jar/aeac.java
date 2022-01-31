import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.OldBigDataChannelManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class aeac
  extends AccountObserver
{
  public aeac(OldBigDataChannelManager paramOldBigDataChannelManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.getFileThreadHandler().post(new aead(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeac
 * JD-Core Version:    0.7.0.1
 */