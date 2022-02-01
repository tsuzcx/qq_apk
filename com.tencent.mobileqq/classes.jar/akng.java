import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class akng
  extends AbsRecentStatus
{
  private static int a = 15;
  
  public int[] declareStatus()
  {
    return new int[] { 8 };
  }
  
  public boolean focusUINType(RecentBaseData paramRecentBaseData, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    return true;
  }
  
  public boolean handleBusiness(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData)
  {
    if (!(paramIMCoreAppRuntime instanceof QQAppInterface)) {}
    String str;
    do
    {
      do
      {
        return false;
        paramIMCoreAppRuntime = (QQAppInterface)paramIMCoreAppRuntime;
        str = paramRecentBaseData.getRecentUserUin();
        paramRecentBaseData.mStatus = 0;
        if (paramRecentBaseData.getRecentUserType() != 1) {
          break;
        }
      } while (!avhg.b(paramIMCoreAppRuntime, str));
      paramRecentBaseData.mStatus = 8;
      return false;
    } while ((paramRecentBaseData.getRecentUserType() != 0) || (!avhg.a(paramIMCoreAppRuntime, str)));
    paramRecentBaseData.mStatus = 8;
    return false;
  }
  
  public int priority()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akng
 * JD-Core Version:    0.7.0.1
 */