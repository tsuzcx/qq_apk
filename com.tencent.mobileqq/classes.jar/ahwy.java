import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;

public class ahwy
  implements Runnable
{
  public ahwy(SecSpyFileManager paramSecSpyFileManager) {}
  
  public void run()
  {
    UnifiedDebugManager.a(this.a.a.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwy
 * JD-Core Version:    0.7.0.1
 */