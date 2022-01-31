import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbySPUtil;

public final class aeml
  implements Runnable
{
  public aeml(String paramString) {}
  
  public void run()
  {
    NearbyProcessMonitor.b(this.a);
    NearbyProcessMonitor.a(this.a);
    NearbyProcessMonitor.a += 1;
    NearbySPUtil.a(this.a);
    NearbyProcessMonitor.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeml
 * JD-Core Version:    0.7.0.1
 */