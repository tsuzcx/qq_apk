import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentHotChatCenterItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemActivateFriendsData;
import com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChangeMachine;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsgBox;
import com.tencent.mobileqq.activity.recent.data.RecentItemContactsGuideData;
import com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMsgBox;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemQCallData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRouterDataLine;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahmg
{
  public static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramRecentUser, paramQQAppInterface, paramContext, true);
  }
  
  public static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramRecentUser != null)
    {
      localObject2 = localObject1;
      if (paramQQAppInterface != null)
      {
        if (paramContext != null) {
          break label33;
        }
        localObject2 = localObject1;
      }
    }
    label33:
    do
    {
      return localObject2;
      if (!TextUtils.isEmpty(paramRecentUser.uin)) {
        break;
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "buildRecentItemData, uin is null, " + paramRecentUser);
    return null;
    int i = paramRecentUser.getType();
    switch (i)
    {
    default: 
      localObject1 = localObject3;
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          break;
        }
        if (paramBoolean) {}
        try
        {
          ((RecentBaseData)localObject1).a(paramQQAppInterface, paramContext);
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          long l = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent.cost", 4, "[" + (l - 0L) + ", " + ((RecentBaseData)localObject1).a() + "," + localObject1.getClass().getName() + "]");
          }
          ((RecentBaseData)localObject1).a();
          return localObject1;
        }
        catch (Throwable paramRecentUser)
        {
          ahon.a(paramQQAppInterface.getApp(), false, paramRecentUser);
          throw new RuntimeException(paramRecentUser);
        }
      }
      localObject1 = new RecentItemTroopAssistant(paramRecentUser);
      continue;
      localObject1 = new RecentHotChatCenterItem(paramRecentUser);
      continue;
      localObject1 = new RecentItemPcDataLine(paramRecentUser);
      continue;
      localObject1 = new RecentItemPcDataLine(paramRecentUser);
      continue;
      localObject1 = new RecentItemRouterDataLine(paramRecentUser);
      continue;
      localObject1 = new RecentItemSubAccount(paramRecentUser);
      continue;
      localObject1 = new RecentItemMsgBox(paramRecentUser);
      continue;
      localObject1 = new RecentItemImaxADData(paramRecentUser);
      continue;
      if (TextUtils.equals(paramRecentUser.uin, ajsd.az))
      {
        localObject1 = localObject3;
        if (bhvy.a(paramQQAppInterface)) {}
      }
      else if (paramRecentUser.lFlag == 16L)
      {
        localObject1 = new RecentItemPublicAccountADFolderData(paramRecentUser);
      }
      else if (i == 1008)
      {
        localObject1 = new RecentItemPublicAccountChatMsgData(paramRecentUser);
      }
      else
      {
        localObject1 = new RecentItemChatMsgData(paramRecentUser);
        continue;
        if (paramRecentUser.msg != null)
        {
          localObject1 = localObject3;
          if (!(paramRecentUser.msg instanceof String)) {}
        }
        else
        {
          localObject1 = new RecentItemNewFriendMsgData(paramRecentUser);
          continue;
          localObject1 = new RecentItemTroopMsgData(paramRecentUser);
          continue;
          localObject1 = new RecentItemTencentDocsAssistantData(paramRecentUser);
          continue;
          localObject1 = new RecentItemDiscussionMsgData(paramRecentUser);
          continue;
          localObject1 = new RecentItemTroopNotification(paramRecentUser);
          continue;
          localObject1 = new SendBlessRecentItemData(paramRecentUser);
          continue;
          localObject1 = new RecentItemMayKnowFriendData(paramRecentUser, paramQQAppInterface.getCurrentAccountUin());
          continue;
          localObject1 = new RecentItemMayKnowFriendVerticalListData(paramRecentUser);
          continue;
          localObject1 = new RecentItemRecommendTroopData(paramRecentUser);
          continue;
          localObject1 = localObject3;
          if (!bhvy.a(paramQQAppInterface))
          {
            localObject1 = new RecentItemTroopBarAssitant(paramRecentUser);
            continue;
            localObject1 = localObject3;
            if (bhvy.a(paramQQAppInterface))
            {
              localObject1 = localObject3;
              if (!bhvy.c())
              {
                localObject1 = new RecentItemKandianMergeData(paramRecentUser);
                continue;
                localObject1 = new RecentItemServiceAccountFolderData(paramRecentUser);
                continue;
                localObject1 = new RecentItemEcShopAssitant(paramRecentUser);
                continue;
                localObject1 = new RecentItemQCallData(paramRecentUser);
                continue;
                localObject1 = new RecentItemChangeMachine(paramRecentUser);
                continue;
                localObject1 = new RecentItemChatMsgData(paramRecentUser);
                continue;
                localObject1 = new RecentItemConfessMsgBox(paramRecentUser);
                continue;
                localObject1 = new RecentItemActivateFriendsData(paramRecentUser);
                continue;
                localObject1 = new RecentItemAppletsFolderData(paramRecentUser);
                continue;
                localObject1 = new RecentItemContactsGuideData(paramRecentUser);
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(List<RecentUser> paramList, QQAppInterface paramQQAppInterface, Context paramContext, List<RecentBaseData> paramList1, int paramInt)
  {
    if (paramList1 == null) {
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        paramList1.clear();
        if (paramList == null) {
          break label370;
        }
        i = paramList.size();
        j = i;
        if (paramQQAppInterface.a == null) {
          break label355;
        }
        j = i;
        if (!paramQQAppInterface.a.b()) {
          break label355;
        }
        j = i;
        if (i <= 90) {
          break label355;
        }
        j = i;
        if (System.currentTimeMillis() - paramQQAppInterface.a.a > 10000L) {
          break label355;
        }
        i = Math.min(90, i);
        j = i;
        if (!QLog.isColorLevel()) {
          break label355;
        }
        QLog.d("Q.recent", 2, "convertToRecentBaseDataList limit:" + paramInt + ",size:" + i);
        j = i;
      }
      finally {}
      if ((i >= paramInt) || (i >= j)) {
        break;
      }
      Object localObject2 = (RecentUser)paramList.get(i);
      if ((localObject2 != null) && (((RecentUser)localObject2).getType() != 9503) && ((paramInt >= j) || (((RecentUser)localObject2).getType() != 7000)))
      {
        bfwu.a(((RecentUser)localObject2).uin);
        String str = ahnl.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType());
        Object localObject1 = ahnl.a().a(str);
        if (localObject1 == null)
        {
          localObject2 = a((RecentUser)localObject2, paramQQAppInterface, paramContext);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            ahnl.a().a((RecentBaseData)localObject2, str);
            localObject1 = localObject2;
          }
          if (localObject1 != null) {
            paramList1.add(localObject1);
          }
          bfwu.a();
        }
        else
        {
          if ((localObject1 instanceof RecentUserBaseData)) {
            ((RecentUserBaseData)localObject1).a((RecentUser)localObject2);
          }
          try
          {
            ((RecentBaseData)localObject1).a(paramQQAppInterface, paramContext);
          }
          catch (Throwable paramList)
          {
            ahon.a(paramContext, false, paramList);
            throw new RuntimeException(paramList);
          }
          label355:
          i = 0;
          continue;
        }
      }
      i += 1;
      continue;
      label370:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmg
 * JD-Core Version:    0.7.0.1
 */