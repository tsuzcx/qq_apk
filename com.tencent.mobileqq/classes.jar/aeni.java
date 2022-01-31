import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.OldBigDataChannelManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class aeni
  extends AccountObserver
{
  public aeni(OldBigDataChannelManager paramOldBigDataChannelManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.getFileThreadHandler().post(new aenj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeni
 * JD-Core Version:    0.7.0.1
 */