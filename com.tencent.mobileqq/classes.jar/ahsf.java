import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.statistics.UnifiedMonitor;

public class ahsf
  implements Runnable
{
  public ahsf(UnifiedMonitor paramUnifiedMonitor) {}
  
  public void run()
  {
    DropFrameMonitor.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahsf
 * JD-Core Version:    0.7.0.1
 */