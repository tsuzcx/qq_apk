import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class alja
  extends AbsRecentStatus
{
  private static int a = 25;
  
  public int[] declareStatus()
  {
    return new int[] { 7 };
  }
  
  public boolean focusUINType(RecentBaseData paramRecentBaseData, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    return true;
  }
  
  public boolean handleBusiness(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData)
  {
    if (!(paramIMCoreAppRuntime instanceof QQAppInterface)) {}
    do
    {
      return false;
      paramIMCoreAppRuntime = (QQAppInterface)paramIMCoreAppRuntime;
    } while ((paramRecentBaseData.mStatus == 4) || ((paramRecentBaseData.getRecentUserType() != 1) && (paramRecentBaseData.getRecentUserType() != 0)));
    String str = paramRecentBaseData.getRecentUserUin();
    if (paramRecentBaseData.getRecentUserType() == 1) {}
    for (int i = 1;; i = 2)
    {
      i = ((bejv)paramIMCoreAppRuntime.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(i, str);
      if (((paramRecentBaseData.mStatus != 0) && (paramRecentBaseData.mStatus < i)) || (i == 0)) {
        break;
      }
      paramRecentBaseData.mStatus = i;
      return false;
    }
  }
  
  public int priority()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alja
 * JD-Core Version:    0.7.0.1
 */