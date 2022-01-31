import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import friendlist.GetOnlineInfoResp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class acik
  extends altm
{
  public acik(BaseChatPie paramBaseChatPie) {}
  
  protected void onAddFriend(String paramString)
  {
    BaseChatPie.a(this.a, paramString);
  }
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    BaseChatPie.b(this.a, paramBoolean, paramString1, paramString2);
  }
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.c(this.a, paramBoolean, paramObject);
  }
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      this.a.D();
    }
  }
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.a(this.a, paramObject);
  }
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    AvatarLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramHashSet);
  }
  
  protected void onGetStrangerInfo(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.b(this.a, paramBoolean, paramObject);
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    BaseChatPie.a(this.a, paramBoolean, paramLong, paramInt1, paramInt2);
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    BaseChatPie.a(this.a, paramBoolean, paramString1, paramString2);
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    BaseChatPie.b(this.a, paramBoolean);
  }
  
  protected void onUpdateC2ChatStatus(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    BaseChatPie.a(this.a, paramHashMap);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramString == null) {
      return;
    }
    AvatarLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, Arrays.asList(new String[] { paramString }));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.a(this.a, paramBoolean, paramObject);
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    BaseChatPie.a(this.a, paramString, paramBoolean);
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.D();
  }
  
  protected void onUpdateRecentList() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acik
 * JD-Core Version:    0.7.0.1
 */