import android.util.SparseArray;
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
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMsgBox;
import com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine;
import com.tencent.mobileqq.activity.recent.data.RecentItemQCallData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRouterDataLine;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;

final class almd
  extends SparseArray<Class<? extends RecentBaseData>>
{
  almd()
  {
    put(5000, RecentItemTroopAssistant.class);
    put(5001, RecentHotChatCenterItem.class);
    put(6000, RecentItemPcDataLine.class);
    put(6003, RecentItemPcDataLine.class);
    put(6002, RecentItemRouterDataLine.class);
    put(7000, RecentItemSubAccount.class);
    put(1009, RecentItemMsgBox.class);
    put(1001, RecentItemMsgBox.class);
    put(1010, RecentItemMsgBox.class);
    put(10002, RecentItemMsgBox.class);
    put(10005, RecentItemImaxADData.class);
    put(1, RecentItemTroopMsgData.class);
    put(6004, RecentItemTencentDocsAssistantData.class);
    put(3000, RecentItemDiscussionMsgData.class);
    put(9000, RecentItemTroopNotification.class);
    put(4001, RecentItemTroopNotification.class);
    put(9003, SendBlessRecentItemData.class);
    put(8112, RecentItemMayKnowFriendVerticalListData.class);
    put(8113, RecentItemRecommendTroopData.class);
    put(7230, RecentItemServiceAccountFolderData.class);
    put(7120, RecentItemEcShopAssitant.class);
    put(8, RecentItemQCallData.class);
    put(1031, RecentItemChatMsgData.class);
    put(1032, RecentItemConfessMsgBox.class);
    put(1033, RecentItemConfessMsgBox.class);
    put(1034, RecentItemConfessMsgBox.class);
    put(9002, RecentItemActivateFriendsData.class);
    put(1038, RecentItemAppletsFolderData.class);
    put(8114, RecentItemContactsGuideData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almd
 * JD-Core Version:    0.7.0.1
 */