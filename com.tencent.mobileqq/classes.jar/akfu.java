import android.app.Application;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;

public final class akfu
  implements Runnable
{
  public akfu(Application paramApplication) {}
  
  public void run()
  {
    UnifiedDebugManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfu
 * JD-Core Version:    0.7.0.1
 */