import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class allv
{
  public static List<RecentUser> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramQQAppInterface.getProxyManager().a().getRecentList(true, false);
    int i = 0;
    while (i < localList.size())
    {
      RecentUser localRecentUser = (RecentUser)localList.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("FilterMsgBoxRecentUserUtil", 2, "getFilterBoxRecentUsers() called with: user = [" + localRecentUser.uin + "]");
      }
      if (((almg)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(localRecentUser.uin, localRecentUser.getType())) {
        localArrayList.add(localRecentUser);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Object localObject = a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("FilterMsgBoxRecentUserUtil", 2, "onRecentBaseDataDelete() called with: filterBoxRecentUsers = [" + localObject + "]");
    }
    if (((List)localObject).isEmpty())
    {
      localObject = (RecentUser)paramQQAppInterface.getRecentUserProxy().findRecentUserByUin(AppConstants.FILTER_MSG_UIN, 10012);
      paramQQAppInterface.getRecentUserProxy().c((RecentUser)localObject, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allv
 * JD-Core Version:    0.7.0.1
 */