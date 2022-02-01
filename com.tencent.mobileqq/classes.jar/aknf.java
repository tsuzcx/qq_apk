import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class aknf
  extends AbsRecentStatus
{
  private static int a = 20;
  
  public int[] declareStatus()
  {
    return new int[] { 6 };
  }
  
  public boolean focusUINType(RecentBaseData paramRecentBaseData, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    return true;
  }
  
  public boolean handleBusiness(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData)
  {
    if (!(paramIMCoreAppRuntime instanceof QQAppInterface)) {}
    Object localObject;
    do
    {
      return false;
      localObject = (QQAppInterface)paramIMCoreAppRuntime;
      paramIMCoreAppRuntime = paramRecentBaseData.getRecentUserUin();
      paramRecentBaseData.mStatus = 0;
      localObject = (ListenTogetherManager)((QQAppInterface)localObject).getManager(331);
      if (((paramRecentBaseData.getRecentUserType() == 3000) || (paramRecentBaseData.getRecentUserType() == 1)) && (((ListenTogetherManager)localObject).a(1, paramIMCoreAppRuntime)))
      {
        paramRecentBaseData.mStatus = 6;
        return false;
      }
    } while ((paramRecentBaseData.getRecentUserType() != 0) || (!((ListenTogetherManager)localObject).a(2, paramIMCoreAppRuntime)));
    paramRecentBaseData.mStatus = 6;
    return false;
  }
  
  public int priority()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknf
 * JD-Core Version:    0.7.0.1
 */