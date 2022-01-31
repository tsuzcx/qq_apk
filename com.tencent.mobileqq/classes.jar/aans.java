import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;

public class aans
  implements Runnable
{
  public aans(ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void run()
  {
    ThreadManager.post(new aant(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aans
 * JD-Core Version:    0.7.0.1
 */