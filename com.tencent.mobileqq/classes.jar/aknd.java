import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class aknd
  extends AbsRecentStatus
{
  private static int a = 8;
  
  public int[] declareStatus()
  {
    return new int[] { 0, 10 };
  }
  
  public boolean focusUINType(RecentBaseData paramRecentBaseData, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    return paramRecentBaseData.getRecentUserType() == 1;
  }
  
  public boolean handleBusiness(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData)
  {
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {}
    for (paramIMCoreAppRuntime = (QQAppInterface)paramIMCoreAppRuntime;; paramIMCoreAppRuntime = null)
    {
      if ((paramIMCoreAppRuntime == null) || (paramRecentBaseData == null)) {}
      String str;
      do
      {
        int i;
        do
        {
          return false;
          i = paramRecentBaseData.getRecentUserType();
          str = paramRecentBaseData.getRecentUserUin();
        } while ((i != 1) || ((paramRecentBaseData.mStatus != 0) && (paramRecentBaseData.mStatus != 10)));
        paramRecentBaseData.mStatus = 0;
        paramIMCoreAppRuntime = (mxn)paramIMCoreAppRuntime.getManager(373);
      } while ((paramIMCoreAppRuntime == null) || (!paramIMCoreAppRuntime.b(str)));
      paramRecentBaseData.mStatus = 10;
      return false;
    }
  }
  
  public int priority()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknd
 * JD-Core Version:    0.7.0.1
 */