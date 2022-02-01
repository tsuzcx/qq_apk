import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ally
{
  private void a(List<RecentUser> paramList, aohi paramaohi, QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser = (RecentUser)paramaohi.findRecentUserByUin(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    paramQQAppInterface = ((almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramQQAppInterface);
    if (paramQQAppInterface.isEmpty())
    {
      QLog.e("RecentUserCacheHelper", 1, "update: msgBoxRecentUsers.isEmpty()");
      return;
    }
    paramList = (RecentUser)paramQQAppInterface.get(0);
    Iterator localIterator = paramQQAppInterface.iterator();
    if (localIterator.hasNext())
    {
      paramQQAppInterface = (RecentUser)localIterator.next();
      if (Math.max(paramQQAppInterface.lastmsgtime, paramQQAppInterface.lastmsgdrafttime) <= Math.max(paramList.lastmsgtime, paramList.lastmsgdrafttime)) {
        break label198;
      }
      paramList = paramQQAppInterface;
    }
    label198:
    for (;;)
    {
      break;
      localRecentUser.uin = AppConstants.TEMP_MSG_BOX_UIN;
      localRecentUser.setType(10011);
      localRecentUser.lastmsgtime = paramList.lastmsgtime;
      localRecentUser.lastmsgdrafttime = paramList.lastmsgdrafttime;
      localRecentUser.opTime = paramList.opTime;
      QLog.i("RecentUserCacheHelper", 1, "createMsgBox: " + localRecentUser.uin);
      paramaohi.addCache(localRecentUser);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    QLog.i("RecentUserCacheHelper", 2, "initMsgBox() called with: app = [" + paramQQAppInterface + "]");
    aoxz localaoxz = paramQQAppInterface.getRecentUserProxy();
    a(localaoxz.getRecentList(true, false), localaoxz, paramQQAppInterface);
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean, aohi paramaohi, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
    if (((almg)localObject1).a(paramRecentUser.uin, paramRecentUser.getType()))
    {
      RecentUser localRecentUser1 = (RecentUser)paramaohi.findRecentUserByUin(AppConstants.FILTER_MSG_UIN, 10012);
      QLog.i("RecentUserCacheHelper", 1, "onSaveRecentUser: ToFilterBox " + paramRecentUser);
      Object localObject2 = allv.a(paramQQAppInterface);
      localRecentUser1.lastmsgtime = paramRecentUser.lastmsgtime;
      if (!((List)localObject2).isEmpty())
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser2 = (RecentUser)((Iterator)localObject2).next();
          if (localRecentUser2.lastmsgtime > localRecentUser1.lastmsgtime) {
            localRecentUser1.lastmsgtime = localRecentUser2.lastmsgtime;
          }
        }
      }
      paramaohi.saveRecentUser(localRecentUser1);
    }
    if (((almg)localObject1).b(paramRecentUser.uin, paramRecentUser.getType()))
    {
      localObject1 = (RecentUser)paramaohi.findRecentUserByUin(AppConstants.TEMP_MSG_BOX_UIN, 10011);
      QLog.i("RecentUserCacheHelper", 1, "onSaveRecentUser: ToMsgBox " + paramRecentUser);
      ((RecentUser)localObject1).lastmsgtime = paramRecentUser.lastmsgtime;
      paramaohi.saveRecentUser((BaseRecentUser)localObject1);
    }
    allv.a(paramQQAppInterface, true);
    almg.a(paramQQAppInterface, true);
  }
  
  public void b(RecentUser paramRecentUser, boolean paramBoolean, aohi paramaohi, QQAppInterface paramQQAppInterface)
  {
    paramaohi = (almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
    if (paramaohi.a(paramRecentUser.uin, paramRecentUser.getType())) {
      allv.a(paramQQAppInterface, paramBoolean);
    }
    if (paramaohi.b(paramRecentUser.uin, paramRecentUser.getType())) {
      almg.a(paramQQAppInterface, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ally
 * JD-Core Version:    0.7.0.1
 */