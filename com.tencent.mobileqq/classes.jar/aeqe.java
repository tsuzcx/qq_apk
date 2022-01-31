import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class aeqe
  extends ajyr
{
  aeqe(aeqb paramaeqb) {}
  
  public void a(String paramString, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      atbr.a(this.a.jdField_a_of_type_JavaLangString, new Object[] { "onPushExitHotChat", paramString, paramHotChatStateWrapper });
    }
    if (!bbbr.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString)) {
      return;
    }
    int i = paramHotChatStateWrapper.targetState;
    ajys.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
    ajys.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "TroopChatPie.onExitHotChat  troopUin=" + paramString1);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      if (this.a.a().getIntent().getBooleanExtra("is_from_web", false)) {
        this.a.a().sendBroadcast(new Intent("com.tencent.mobileqq.refresh_hot_chat_list"));
      }
      ajys.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4);
      ajys.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
      this.a.b(1);
    }
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      atbr.a(this.a.jdField_a_of_type_JavaLangString, new Object[] { "onQuickJoinHotChat", Boolean.valueOf(paramBoolean), paramString, paramHotChatInfo });
    }
    if (!paramBoolean) {
      if ((bbbr.a(this.a.j, paramString)) || ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (bbbr.a(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid, paramString))))
      {
        paramHotChatInfo = asyx.a(paramInt);
        bcql.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramHotChatInfo, 1).a();
      }
    }
    while ((!bbbr.a(this.a.j, paramString)) || (paramHotChatInfo == null) || (bbbr.a(paramHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      atbr.a(this.a.jdField_a_of_type_JavaLangString, new Object[] { "onQuickJoinHotChat_not_same_aio", String.format("uuid:%s, new:%s, old:%s", new Object[] { paramString, paramHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }) });
    }
    MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    paramWifiPOIInfo = new Intent(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class);
    paramWifiPOIInfo.putExtra("uin", paramHotChatInfo.troopUin);
    paramWifiPOIInfo.putExtra("uintype", 1);
    paramWifiPOIInfo.putExtra("troop_uin", paramHotChatInfo.troopCode);
    paramWifiPOIInfo.putExtra("uinname", paramHotChatInfo.name);
    paramWifiPOIInfo.addFlags(67108864);
    paramWifiPOIInfo.putExtra("hotnamecode", paramHotChatInfo.uuid);
    if (paramHotChatInfo.supportDemo) {}
    for (paramInt = 2;; paramInt = 0)
    {
      paramWifiPOIInfo.putExtra("HOTCHAT_EXTRA_FLAG", paramInt);
      paramHotChatInfo = actj.a(paramWifiPOIInfo, new int[] { 2 });
      paramHotChatInfo.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramHotChatInfo);
      if (!(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)) {
        break;
      }
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramString.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onGetUserCreateHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", troopOwner=" + paramLong);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, null)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_Ajyv != null) {
      this.a.jdField_a_of_type_Ajyv.b(l1);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_global_admin");
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.a(paramString2, paramString2);
        return;
      }
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
      for (paramString1 = "507";; paramString1 = "503")
      {
        akbj.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
        return;
      }
    }
    paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
    for (paramString1 = "507";; paramString1 = "503")
    {
      akbj.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.a.a(paramString2, paramString3, true, 4);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onGetHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", jumpurl=" + paramString3);
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, paramString3)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_Ajyv != null) {
      this.a.jdField_a_of_type_Ajyv.b(l1);
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_admin");
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    asyx.a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqe
 * JD-Core Version:    0.7.0.1
 */