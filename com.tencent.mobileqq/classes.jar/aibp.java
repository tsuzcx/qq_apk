import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;

public class aibp
  implements Runnable
{
  public aibp(SecSpyFileManager paramSecSpyFileManager) {}
  
  public void run()
  {
    UnifiedDebugManager.a(this.a.a.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibp
 * JD-Core Version:    0.7.0.1
 */