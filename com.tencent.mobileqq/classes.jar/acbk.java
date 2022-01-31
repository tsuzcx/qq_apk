import com.tencent.mobileqq.activity.QZoneFeedsObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.FeedsManager;
import java.util.Map;

class acbk
  implements Runnable
{
  acbk(acbj paramacbj) {}
  
  public void run()
  {
    if (!this.a.a.feedInfoCache.isEmpty()) {
      FeedsManager.access$200(this.a.a).notifyObservers(QZoneFeedsObserver.class, 10000, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbk
 * JD-Core Version:    0.7.0.1
 */