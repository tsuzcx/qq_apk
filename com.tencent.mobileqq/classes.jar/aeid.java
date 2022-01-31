import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;

class aeid
  implements Runnable
{
  aeid(aeic paramaeic) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.a.a.getManager(12);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(202, new aeie(this));
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a("Q.lebatab.", new Object[] { "preload nearby process/tool process" });
    }
    NearbyProcessMonitor.a(this.a.a.a.getAccount(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeid
 * JD-Core Version:    0.7.0.1
 */