import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.statistics.UnifiedMonitor;

public class ailb
  implements Runnable
{
  public ailb(UnifiedMonitor paramUnifiedMonitor) {}
  
  public void run()
  {
    DropFrameMonitor.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ailb
 * JD-Core Version:    0.7.0.1
 */