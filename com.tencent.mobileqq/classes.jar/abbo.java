import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;

public class abbo
  implements Runnable
{
  public abbo(ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void run()
  {
    ThreadManager.post(new abbp(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbo
 * JD-Core Version:    0.7.0.1
 */