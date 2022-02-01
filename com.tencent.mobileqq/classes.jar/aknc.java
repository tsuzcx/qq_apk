import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.menu.AbsMenuFlag;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class aknc
  extends AbsMenuFlag
{
  public boolean handleBusiness(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData)
  {
    if (!(paramIMCoreAppRuntime instanceof QQAppInterface)) {
      return false;
    }
    paramIMCoreAppRuntime = (QQAppInterface)paramIMCoreAppRuntime;
    paramRecentBaseData.mMenuFlag &= 0xFFFFFF0F;
    int i;
    if ((((RecentUserBaseData)paramRecentBaseData).mUser.getType() == 1) && (!awhn.a(paramIMCoreAppRuntime, (RecentUser)((RecentUserBaseData)paramRecentBaseData).mUser)))
    {
      paramIMCoreAppRuntime = (TroopManager)paramIMCoreAppRuntime.getManager(52);
      int j = paramRecentBaseData.mMenuFlag;
      if (paramIMCoreAppRuntime.b(((RecentUserBaseData)paramRecentBaseData).mUser.uin))
      {
        i = 32;
        label93:
        paramRecentBaseData.mMenuFlag = (i | j);
      }
    }
    for (;;)
    {
      paramRecentBaseData.mMenuFlag &= 0xF0FFFFFF;
      if (((RecentUserBaseData)paramRecentBaseData).mUser.isHiddenChat != 1) {
        break;
      }
      paramRecentBaseData.mMenuFlag |= 0x1000000;
      return false;
      i = 16;
      break label93;
      FriendsStatusUtil.a(paramIMCoreAppRuntime, (RecentUser)((RecentUserBaseData)paramRecentBaseData).mUser);
      if ((((RecentUserBaseData)paramRecentBaseData).mUser.showUpTime == 0L) && (9223372036854775807L - ((RecentUserBaseData)paramRecentBaseData).mUser.lastmsgtime > 4L)) {
        paramRecentBaseData.mMenuFlag |= 0x10;
      } else {
        paramRecentBaseData.mMenuFlag |= 0x20;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknc
 * JD-Core Version:    0.7.0.1
 */