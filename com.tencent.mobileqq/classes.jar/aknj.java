import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class aknj
  extends AbsRecentStatus
{
  public int[] declareStatus()
  {
    return new int[] { 2, 3, 1, 5 };
  }
  
  public boolean focusUINType(RecentBaseData paramRecentBaseData, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    return true;
  }
  
  public boolean handleBusiness(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData)
  {
    if (!(paramIMCoreAppRuntime instanceof QQAppInterface)) {}
    int k;
    long l;
    int m;
    Object localObject;
    for (;;)
    {
      return false;
      paramIMCoreAppRuntime = (QQAppInterface)paramIMCoreAppRuntime;
      k = paramRecentBaseData.getRecentUserType();
      if ((k == 3000) || (k == 1)) {
        try
        {
          l = Long.parseLong(paramRecentBaseData.getRecentUserUin());
          m = mum.b(k);
          if (paramIMCoreAppRuntime.getAVNotifyCenter().a(m, l) > 0L) {
            if (paramIMCoreAppRuntime.getAVNotifyCenter().a(m, l))
            {
              paramRecentBaseData.mStatus = 2;
              if ((k != 0) || (!paramIMCoreAppRuntime.getAVNotifyCenter().d(paramRecentBaseData.getRecentUserUin()))) {
                continue;
              }
              paramRecentBaseData.mStatus = 5;
              return false;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            l = 0L;
            continue;
            paramRecentBaseData.mStatus = 3;
          }
          localObject = paramIMCoreAppRuntime.getAVNotifyCenter().a(l, 2);
          if (localObject == null) {}
        }
      }
    }
    for (int i = ((lmr)localObject).a + 0;; i = 0)
    {
      localObject = paramIMCoreAppRuntime.getAVNotifyCenter().a(l, 10);
      int j = i;
      if (localObject != null) {
        j = i + ((lmr)localObject).a;
      }
      if (j <= 0) {
        break;
      }
      if (paramIMCoreAppRuntime.getAVNotifyCenter().a(m, l))
      {
        paramRecentBaseData.mStatus = 2;
        break;
      }
      paramRecentBaseData.mStatus = 3;
      break;
      if ((!paramIMCoreAppRuntime.isVideoChatting()) || ((paramIMCoreAppRuntime.getAVNotifyCenter().e() != 1) && (paramIMCoreAppRuntime.getAVNotifyCenter().e() != 2))) {
        break;
      }
      i = paramIMCoreAppRuntime.getAVNotifyCenter().f();
      localObject = paramIMCoreAppRuntime.getAVNotifyCenter().c();
      String str = paramIMCoreAppRuntime.getAVNotifyCenter().d();
      if ((k != i) || ((!paramRecentBaseData.getRecentUserUin().equals(localObject)) && (!paramRecentBaseData.getRecentUserUin().equals(str)))) {
        break;
      }
      paramRecentBaseData.mStatus = 1;
      break;
    }
  }
  
  public int priority()
  {
    return AbsRecentStatus.PRIORITY_VIDEO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknj
 * JD-Core Version:    0.7.0.1
 */