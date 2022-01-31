import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.statistics.UnifiedMonitor;

public class aigi
  implements Runnable
{
  public aigi(UnifiedMonitor paramUnifiedMonitor) {}
  
  public void run()
  {
    DropFrameMonitor.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aigi
 * JD-Core Version:    0.7.0.1
 */