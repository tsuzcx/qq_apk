import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class akne
  extends AbsRecentStatus
{
  public int[] declareStatus()
  {
    return new int[4];
  }
  
  public boolean focusUINType(RecentBaseData paramRecentBaseData, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    return true;
  }
  
  public boolean handleBusiness(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData)
  {
    if (!(paramIMCoreAppRuntime instanceof QQAppInterface)) {
      return false;
    }
    paramIMCoreAppRuntime = ((QQAppInterface)paramIMCoreAppRuntime).getMessageFacade();
    if ((paramIMCoreAppRuntime != null) && (paramIMCoreAppRuntime.hasDraftText(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType())))
    {
      paramRecentBaseData.mStatus = 4;
      return false;
    }
    paramRecentBaseData.mStatus = 0;
    return false;
  }
  
  public int priority()
  {
    return AbsRecentStatus.PRIORITY_DRAFT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akne
 * JD-Core Version:    0.7.0.1
 */