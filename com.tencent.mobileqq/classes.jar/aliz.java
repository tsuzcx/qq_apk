import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class aliz
  extends AbsRecentStatus
{
  public static int a = 16;
  
  public int[] declareStatus()
  {
    return new int[] { 11 };
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
      do
      {
        return false;
      } while ((paramRecentBaseData.getRecentUserType() != 3000) && (paramRecentBaseData.getRecentUserType() != 1));
      paramIMCoreAppRuntime = (QQAppInterface)paramIMCoreAppRuntime;
      String str = paramRecentBaseData.getRecentUserUin();
      paramIMCoreAppRuntime = ((TroopManager)paramIMCoreAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).a(str);
    } while ((paramIMCoreAppRuntime == null) || (!paramIMCoreAppRuntime.getStudyRoomOpen()));
    paramRecentBaseData.mStatus = 11;
    return false;
  }
  
  public int priority()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aliz
 * JD-Core Version:    0.7.0.1
 */