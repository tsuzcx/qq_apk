import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkActionAppMgr.IGetAppNameByActionCallback;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import java.util.Set;

public class aauz
  implements ArkActionAppMgr.IGetAppNameByActionCallback
{
  public aauz(ArkLocalAppMgr paramArkLocalAppMgr, aavw paramaavw) {}
  
  public void a(Object paramObject, Set paramSet)
  {
    ThreadManager.post(new aava(this, paramSet), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aauz
 * JD-Core Version:    0.7.0.1
 */