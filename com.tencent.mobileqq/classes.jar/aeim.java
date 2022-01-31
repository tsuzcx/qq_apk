import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;

public class aeim
  extends GameCenterObserver
{
  public aeim(LebaWithFeeds paramLebaWithFeeds) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!paramBoolean1) || (paramInt == 2)) {}
    for (;;)
    {
      return;
      if (LebaWithFeeds.b(this.a))
      {
        LebaGridShowManager.a().b(this.a.a);
        this.a.a(new aein(this));
      }
      while (QLog.isColorLevel())
      {
        QLog.i("Q.lebatab.leba_with_feeds", 2, "onGameCenterMsgReceive, " + LebaWithFeeds.c(this.a));
        return;
        LebaShowListManager.a |= 0x2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeim
 * JD-Core Version:    0.7.0.1
 */