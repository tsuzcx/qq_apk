import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ahmj
  implements Comparator<RecentBaseData>
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  public ahmj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt) > 0);
  }
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      boolean bool1;
      if ((paramRecentBaseData1.mUser.getType() == 1) && (!asyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData1.mUser)))
      {
        bool1 = localTroopManager.b(paramRecentBaseData1.a());
        if ((paramRecentBaseData2.mUser.getType() != 1) || (asyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData2.mUser))) {
          break label138;
        }
      }
      label138:
      for (boolean bool2 = localTroopManager.b(paramRecentBaseData2.a());; bool2 = FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData2.mUser))
      {
        if ((!bool1) || (bool2)) {
          break label154;
        }
        return -1;
        bool1 = FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData1.mUser);
        break;
      }
      label154:
      if ((!bool1) && (bool2)) {
        return 1;
      }
      if ((!bool1) && (!bool2)) {
        if ((paramRecentBaseData1.mUnreadNum > 0) && (paramRecentBaseData1.mUser.getType() == 0) && (aijb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramRecentBaseData1.mUser.uin)) && (!a(paramRecentBaseData1.mUser.uin, 0)))
        {
          i = 1;
          if (i == 0) {
            break label577;
          }
        }
      }
    }
    label558:
    label571:
    label577:
    for (int i = 4096;; i = 0)
    {
      if ((paramRecentBaseData2.mUnreadNum > 0) && (paramRecentBaseData2.mUser.getType() == 0) && (aijb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramRecentBaseData2.mUser.uin)) && (!a(paramRecentBaseData2.mUser.uin, 0)))
      {
        j = 1;
        label325:
        if (j == 0) {
          break label571;
        }
      }
      for (int j = 4096;; j = 0)
      {
        long l2 = Math.max(paramRecentBaseData1.mUser.lastmsgtime, paramRecentBaseData1.mUser.lastmsgdrafttime);
        long l3 = Math.max(paramRecentBaseData2.mUser.lastmsgtime, paramRecentBaseData2.mUser.lastmsgdrafttime);
        long l1 = l2;
        if (paramRecentBaseData1.mUser.lastmsgtime <= 0L)
        {
          l1 = l2;
          if (paramRecentBaseData1.mUser.lastmsgdrafttime <= 0L) {
            l1 = Math.max(l2, paramRecentBaseData1.mUser.opTime);
          }
        }
        l2 = l3;
        if (paramRecentBaseData2.mUser.lastmsgtime <= 0L)
        {
          l2 = l3;
          if (paramRecentBaseData2.mUser.lastmsgdrafttime <= 0L) {
            l2 = Math.max(l3, paramRecentBaseData2.mUser.opTime);
          }
        }
        label465:
        if (l1 > l2) {
          l1 = 3L;
        }
        for (;;)
        {
          l1 = (int)(l1 | i) - (int)(0x2 | j);
          if (l1 != 0L) {
            break label558;
          }
          return 0;
          i = 0;
          break;
          j = 0;
          break label325;
          l1 = paramRecentBaseData1.mDisplayTime;
          l2 = paramRecentBaseData2.mDisplayTime;
          j = 0;
          i = 0;
          break label465;
          if (l1 < l2) {
            l1 = 1L;
          } else {
            l1 = 2L;
          }
        }
        if (l1 < 0L) {
          return 1;
        }
        return -1;
        return 0;
      }
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBaseActivity.getAppRuntime());
  }
  
  public void a(List<RecentUser> paramList)
  {
    RecentUser localRecentUser;
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, src[");
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localRecentUser = (RecentUser)((Iterator)localObject).next();
          this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentUser.uin + "|" + localRecentUser.getType() + ",");
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("], [");
    }
    Object localObject = null;
    int i;
    if (paramList == null)
    {
      i = 0;
      i -= 1;
      label141:
      if (i < 0) {
        break label560;
      }
      localRecentUser = (RecentUser)paramList.get(i);
      if (localRecentUser != null) {
        break label187;
      }
      paramList.remove(i);
    }
    label187:
    label597:
    label600:
    for (;;)
    {
      i -= 1;
      break label141;
      i = paramList.size();
      break;
      if ((TextUtils.isEmpty(localRecentUser.uin)) || (TextUtils.isEmpty(localRecentUser.uin.trim())))
      {
        paramList.remove(i);
        if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel())) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(i).append(",").append(localRecentUser.getType()).append(";");
        }
      }
      else if ((localRecentUser.getType() == 1) && ((localRecentUser.lFlag & 1L) != 0L))
      {
        if ((localObject != null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label597;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
      }
      for (;;)
      {
        if ((localObject == null) || (((HotChatManager)localObject).b(localRecentUser.uin))) {
          break label600;
        }
        paramList.remove(i);
        if ((this.jdField_a_of_type_JavaLangStringBuilder == null) || (!QLog.isDevelopLevel())) {
          break label600;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append("invalide hotchat ").append(i).append(",").append(localRecentUser.uin).append(";");
        break;
        if (localRecentUser.getType() == 3000)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label557;
          }
          DiscussionInfo localDiscussionInfo = ((ajvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(localRecentUser.uin);
          if ((localDiscussionInfo == null) || (localDiscussionInfo.isUIControlFlag_Hidden_RecentUser()) || (localDiscussionInfo.isHidden()))
          {
            paramList.remove(i);
            if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel())) {
              this.jdField_a_of_type_JavaLangStringBuilder.append("hidden_RecentUser ").append(i).append(",").append(localRecentUser.uin).append(";");
            }
          }
          break;
        }
        if (localRecentUser.lFlag == 16L)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label557;
          }
          nje.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
          break;
        }
        if ((localRecentUser.getType() == 10005) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          ardd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
        }
        break;
        if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel()))
        {
          this.jdField_a_of_type_JavaLangStringBuilder.append("]");
          QLog.i("Q.recent", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmj
 * JD-Core Version:    0.7.0.1
 */