import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkActionAppMgr.IGetAppNameByActionCallback;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import java.util.Set;

public class aany
  implements ArkActionAppMgr.IGetAppNameByActionCallback
{
  public aany(ArkLocalAppMgr paramArkLocalAppMgr, aaov paramaaov) {}
  
  public void a(Object paramObject, Set paramSet)
  {
    ThreadManager.post(new aanz(this, paramSet), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aany
 * JD-Core Version:    0.7.0.1
 */