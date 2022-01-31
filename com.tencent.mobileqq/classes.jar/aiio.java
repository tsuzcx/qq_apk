import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import java.util.concurrent.atomic.AtomicReference;

public final class aiio
  implements Runnable
{
  public aiio(String paramString) {}
  
  public void run()
  {
    RecentDanceConfigMgr localRecentDanceConfigMgr = RecentDanceConfigMgr.a(this.a);
    if (localRecentDanceConfigMgr != null) {
      RecentDanceConfigMgr.a().getAndSet(localRecentDanceConfigMgr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aiio
 * JD-Core Version:    0.7.0.1
 */