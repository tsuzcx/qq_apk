import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class akjw
  implements Comparator<RecentBaseData>
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  public akjw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a(RecentUserBaseData paramRecentUserBaseData, int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramRecentUserBaseData.mUnreadNum > 0)
    {
      i = j;
      if (paramRecentUserBaseData.mUser.getType() == 0)
      {
        i = j;
        if (alem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramRecentUserBaseData.mUser.uin))
        {
          i = j;
          if (!a(paramRecentUserBaseData.mUser.uin, 0)) {
            i = 1;
          }
        }
      }
    }
    if (i != 0) {
      paramInt = 4096;
    }
    return paramInt;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel()))
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append("]");
      QLog.i("Q.recent", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private void a(String... paramVarArgs)
  {
    if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel()) && (paramVarArgs != null))
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.jdField_a_of_type_JavaLangStringBuilder.append(str);
        i += 1;
      }
    }
  }
  
  private boolean a(RecentUserBaseData paramRecentUserBaseData)
  {
    if ((paramRecentUserBaseData.mUser.getType() == 1) && (!awhn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramRecentUserBaseData.mUser))) {
      return ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramRecentUserBaseData.getRecentUserUin());
    }
    return FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramRecentUserBaseData.mUser);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(paramString, paramInt) > 0);
  }
  
  private void b(List<RecentUser> paramList)
  {
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null)
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, src[");
        paramList = paramList.iterator();
      }
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label120;
        }
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if (localRecentUser == null)
        {
          this.jdField_a_of_type_JavaLangStringBuilder.append("null | null,");
          continue;
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          break;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentUser.uin).append("|").append(localRecentUser.getType()).append(",");
      }
      label120:
      this.jdField_a_of_type_JavaLangStringBuilder.append("], [");
    }
  }
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    int j;
    int i;
    long l2;
    long l3;
    long l1;
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      j = 0;
      i = 0;
      boolean bool1 = a(paramRecentBaseData1);
      boolean bool2 = a(paramRecentBaseData2);
      if ((bool1) && (!bool2)) {
        return -1;
      }
      if ((!bool1) && (bool2)) {
        return 1;
      }
      if (!bool1)
      {
        j = a(paramRecentBaseData1, 0);
        i = a(paramRecentBaseData2, 0);
        l2 = Math.max(paramRecentBaseData1.mUser.lastmsgtime, paramRecentBaseData1.mUser.lastmsgdrafttime);
        l3 = Math.max(paramRecentBaseData2.mUser.lastmsgtime, paramRecentBaseData2.mUser.lastmsgdrafttime);
        l1 = l2;
        if (paramRecentBaseData1.mUser.lastmsgtime <= 0L)
        {
          l1 = l2;
          if (paramRecentBaseData1.mUser.lastmsgdrafttime <= 0L) {
            l1 = Math.max(l2, paramRecentBaseData1.mUser.opTime);
          }
        }
        if ((paramRecentBaseData2.mUser.lastmsgtime > 0L) || (paramRecentBaseData2.mUser.lastmsgdrafttime > 0L)) {
          break label307;
        }
        l3 = Math.max(l3, paramRecentBaseData2.mUser.opTime);
        l2 = l1;
        l1 = l3;
      }
    }
    for (;;)
    {
      if (l2 > l1) {
        l1 = 3L;
      }
      for (;;)
      {
        l1 = (int)(l1 | j) - (int)(0x2 | i);
        if (l1 != 0L) {
          break label294;
        }
        return 0;
        l2 = paramRecentBaseData1.mDisplayTime;
        l1 = paramRecentBaseData2.mDisplayTime;
        break;
        if (l2 < l1) {
          l1 = 1L;
        } else {
          l1 = 2L;
        }
      }
      label294:
      if (l1 < 0L) {
        return 1;
      }
      return -1;
      return 0;
      label307:
      l2 = l1;
      l1 = l3;
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBaseActivity.getAppRuntime());
  }
  
  public void a(List<RecentUser> paramList)
  {
    b(paramList);
    HotChatManager localHotChatManager = null;
    int i;
    label17:
    RecentUser localRecentUser;
    if (paramList == null)
    {
      i = 0;
      i -= 1;
      if (i < 0) {
        break label418;
      }
      localRecentUser = (RecentUser)paramList.get(i);
      if (localRecentUser != null) {
        break label63;
      }
      paramList.remove(i);
    }
    label415:
    label418:
    label423:
    label426:
    for (;;)
    {
      i -= 1;
      break label17;
      i = paramList.size();
      break;
      label63:
      if ((TextUtils.isEmpty(localRecentUser.uin)) || (TextUtils.isEmpty(localRecentUser.uin.trim())))
      {
        paramList.remove(i);
        a(new String[] { String.valueOf(i), ",", String.valueOf(localRecentUser.getType()), ";" });
      }
      else
      {
        if ((localRecentUser.getType() == 1) && ((localRecentUser.lFlag & 1L) != 0L))
        {
          if ((localHotChatManager != null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
            break label423;
          }
          localHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);
        }
        for (;;)
        {
          if ((localHotChatManager == null) || (localHotChatManager.b(localRecentUser.uin))) {
            break label426;
          }
          paramList.remove(i);
          a(new String[] { "invalide hotchat ", String.valueOf(i), ",", localRecentUser.uin, ";" });
          break;
          if (localRecentUser.getType() == 3000)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break label415;
            }
            DiscussionInfo localDiscussionInfo = ((amrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(localRecentUser.uin);
            if ((localDiscussionInfo == null) || (localDiscussionInfo.isUIControlFlag_Hidden_RecentUser()) || (localDiscussionInfo.isHidden()))
            {
              paramList.remove(i);
              a(new String[] { "hidden_RecentUser ", String.valueOf(i), ",", localRecentUser.uin, ";" });
            }
            break;
          }
          if (localRecentUser.lFlag == 16L)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break label415;
            }
            nxz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
            break;
          }
          if ((localRecentUser.getType() == 10005) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
            aukx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
          }
          break;
          a();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjw
 * JD-Core Version:    0.7.0.1
 */