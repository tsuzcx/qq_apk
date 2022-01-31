import com.tencent.mobileqq.leba.LebaFeedsAdapter;
import com.tencent.mobileqq.leba.LebaFeedsObserver;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.qphone.base.util.QLog;

public class aeiq
  extends LebaFeedsObserver
{
  public aeiq(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onLoadLocalData" + paramBoolean);
    }
    if (LebaWithFeeds.a(this.a) == null)
    {
      QLog.e("Q.lebatab.leba_with_feeds", 1, "onLoadLocalData, mFeedsAdapter is null");
      return;
    }
    LebaWithFeeds.a(this.a).a(false);
    LebaWithFeeds.a(this.a, true, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba_with_feeds", 2, "onGetDynamicFeeds isSuccess=" + paramBoolean + ", eventType=" + paramInt1 + ", dataState=" + paramInt2);
    }
    if (LebaWithFeeds.a(this.a) == null)
    {
      QLog.e("Q.lebatab.leba_with_feeds", 1, "onGetDynamicFeeds, mFeedsAdapter is null");
      return;
    }
    if (paramInt1 == 1)
    {
      LebaWithFeeds.b(this.a, false);
      if (!paramBoolean) {
        break label150;
      }
      LebaWithFeeds.a(this.a).e();
      if (paramInt2 != 1) {
        break label145;
      }
    }
    label145:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      LebaWithFeeds.a(this.a).a(paramBoolean);
      LebaWithFeeds.a(this.a, false, 2);
      return;
      if (paramInt1 != 2) {
        break;
      }
      LebaWithFeeds.c(this.a, false);
      break;
    }
    label150:
    if (paramInt1 == 2)
    {
      LebaWithFeeds.a(this.a).d();
      return;
    }
    LebaWithFeeds.a(this.a).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeiq
 * JD-Core Version:    0.7.0.1
 */