import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentHotChatCenterItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemActivateFriendsData;
import com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData;
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
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class alan
{
  @Nullable
  private static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface)
  {
    int i = paramRecentUser.getType();
    switch (i)
    {
    default: 
    case 5000: 
    case 5001: 
    case 6000: 
    case 6003: 
    case 6002: 
    case 7000: 
    case 1001: 
    case 1009: 
    case 1010: 
    case 10002: 
    case 10005: 
    case 0: 
    case 1000: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1023: 
    case 1024: 
    case 1025: 
    case 7400: 
    case 9500: 
    case 9501: 
    case 10004: 
    case 10007: 
    case 10008: 
    case 10009: 
    case 10010: 
    case 4000: 
    case 1: 
    case 6004: 
    case 3000: 
    case 4001: 
    case 9000: 
    case 9003: 
    case 8111: 
    case 8112: 
    case 8113: 
    case 7210: 
    case 7220: 
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              return new RecentItemTroopAssistant(paramRecentUser);
              return new RecentHotChatCenterItem(paramRecentUser);
              return new RecentItemPcDataLine(paramRecentUser);
              return new RecentItemRouterDataLine(paramRecentUser);
              return new RecentItemSubAccount(paramRecentUser);
              return new RecentItemMsgBox(paramRecentUser);
              return new RecentItemImaxADData(paramRecentUser);
            } while ((TextUtils.equals(paramRecentUser.uin, anhk.az)) && (bmqa.a(paramQQAppInterface)));
            if (paramRecentUser.lFlag == 16L) {
              return new RecentItemPublicAccountADFolderData(paramRecentUser);
            }
            if (i == 1008) {
              return new RecentItemPublicAccountChatMsgData(paramRecentUser);
            }
            return new RecentItemChatMsgData(paramRecentUser);
          } while ((paramRecentUser.msg != null) && (!(paramRecentUser.msg instanceof String)));
          return new RecentItemNewFriendMsgData(paramRecentUser);
          return new RecentItemTroopMsgData(paramRecentUser);
          return new RecentItemTencentDocsAssistantData(paramRecentUser);
          return new RecentItemDiscussionMsgData(paramRecentUser);
          return new RecentItemTroopNotification(paramRecentUser);
          return new SendBlessRecentItemData(paramRecentUser);
          return new RecentItemMayKnowFriendData(paramRecentUser, paramQQAppInterface.getCurrentAccountUin());
          return new RecentItemMayKnowFriendVerticalListData(paramRecentUser);
          return new RecentItemRecommendTroopData(paramRecentUser);
        } while (bmqa.a(paramQQAppInterface));
        return new RecentItemTroopBarAssitant(paramRecentUser);
      } while ((!bmqa.a(paramQQAppInterface)) || (bmqa.c()));
      return new RecentItemKandianMergeData(paramRecentUser);
    case 7230: 
      return new RecentItemServiceAccountFolderData(paramRecentUser);
    case 7120: 
      return new RecentItemEcShopAssitant(paramRecentUser);
    case 8: 
      return new RecentItemQCallData(paramRecentUser);
    case 1031: 
      return new RecentItemChatMsgData(paramRecentUser);
    case 1032: 
    case 1033: 
    case 1034: 
      return new RecentItemConfessMsgBox(paramRecentUser);
    case 9002: 
      return new RecentItemActivateFriendsData(paramRecentUser);
    case 1038: 
      return new RecentItemAppletsFolderData(paramRecentUser);
    }
    return new RecentItemContactsGuideData(paramRecentUser);
  }
  
  public static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramRecentUser, paramQQAppInterface, paramContext, true);
  }
  
  public static RecentBaseData a(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramRecentUser != null)
    {
      localObject1 = localObject2;
      if (paramQQAppInterface != null)
      {
        if (paramContext != null) {
          break label30;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      return localObject1;
      label30:
      if (TextUtils.isEmpty(paramRecentUser.uin))
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.recent", 2, "buildRecentItemData, uin is null, " + paramRecentUser);
        return null;
      }
      paramRecentUser = a(paramRecentUser, paramQQAppInterface);
      localObject1 = paramRecentUser;
      if (paramRecentUser == null) {
        continue;
      }
      if (paramBoolean) {}
      try
      {
        paramRecentUser.update(paramQQAppInterface, paramContext);
        localObject1 = paramRecentUser;
        if (!QLog.isColorLevel()) {
          continue;
        }
        long l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent.cost", 4, "[" + (l - 0L) + ", " + paramRecentUser.getRecentUserUin() + "," + paramRecentUser.getClass().getName() + "," + paramBoolean + "]");
        }
        paramRecentUser.printDataItem();
        return paramRecentUser;
      }
      catch (Throwable paramRecentUser)
      {
        alcu.a(paramQQAppInterface.getApp(), false, paramRecentUser);
        throw new RuntimeException(paramRecentUser);
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
          break label412;
        }
        i = paramList.size();
        j = i;
        if (paramQQAppInterface.a == null) {
          break label397;
        }
        j = i;
        if (!paramQQAppInterface.a.b()) {
          break label397;
        }
        j = i;
        if (i <= 90) {
          break label397;
        }
        j = i;
        if (System.currentTimeMillis() - paramQQAppInterface.a.a > 10000L) {
          break label397;
        }
        i = Math.min(90, i);
        j = i;
        if (!QLog.isColorLevel()) {
          break label397;
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
        bkpj.a(((RecentUser)localObject2).uin);
        bgso.a(null, "Recent_LoadData_conv_uin_record");
        String str = albs.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType());
        Object localObject1 = albs.a().a(str);
        if (localObject1 == null)
        {
          bgso.a(null, "Recent_LoadData_build_item");
          localObject2 = a((RecentUser)localObject2, paramQQAppInterface, paramContext);
          bgso.a("Recent_LoadData_build_item", null);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            albs.a().a((RecentBaseData)localObject2, str);
            localObject1 = localObject2;
          }
          bgso.a("Recent_LoadData_conv_uin_record", null);
          if (localObject1 != null) {
            paramList1.add(localObject1);
          }
          bkpj.a();
        }
        else
        {
          if ((localObject1 instanceof RecentUserBaseData)) {
            ((RecentUserBaseData)localObject1).setRecentUser((BaseRecentUser)localObject2);
          }
          bgso.a(null, "Recent_LoadData_update");
          try
          {
            ((RecentBaseData)localObject1).update(paramQQAppInterface, paramContext);
            bgso.a("Recent_LoadData_update", null);
          }
          catch (Throwable paramList)
          {
            alcu.a(paramContext, false, paramList);
            throw new RuntimeException(paramList);
          }
          label397:
          i = 0;
          continue;
        }
      }
      i += 1;
      continue;
      label412:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alan
 * JD-Core Version:    0.7.0.1
 */