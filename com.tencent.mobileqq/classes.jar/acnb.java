import android.os.Bundle;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.26.1;
import com.tencent.mobileqq.activity.Conversation.26.2;
import com.tencent.mobileqq.activity.Conversation.26.3;
import com.tencent.mobileqq.activity.Conversation.26.4;
import com.tencent.mobileqq.activity.Conversation.26.5;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class acnb
  extends alox
{
  public acnb(Conversation paramConversation) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onCancelMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      alro localalro = (alro)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      ArrayList localArrayList = localalro.c();
      if (localalro.a(paramString)) {
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "onCancelMayKnowRecommend recommends is empty ");
        }
        localalro.e();
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).g();
      }
    }
  }
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1 = (ProxyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18);
    if (localObject1 == null)
    {
      localObject1 = null;
      atwd.a().i(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject1 != null) {
        break label176;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label186;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.getType() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localRecentUser.uin) == 3))
        {
          if (localObject1 != null) {
            ((amjk)localObject1).b(localRecentUser);
          }
          ajgm.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, 1);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localRecentUser.uin, localRecentUser.getType());
        }
      }
      localObject1 = ((ProxyManager)localObject1).a();
      break;
      label176:
      localObject2 = ((amjk)localObject1).a(false);
    }
    label186:
    this.a.a(9, aljq.C, 5000);
    this.a.a(9, aljq.aL, 5001);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onGetGenralSettings");
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("is_from_init");; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onGetMayKnowRecommend isSuccess = " + paramBoolean + " isFromInit: " + bool);
      }
      if (!bool) {
        Conversation.i(this.a);
      }
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      return;
    }
  }
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " Conversation.onUpdateCustomHead: uins:" + paramHashSet + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (paramHashSet.contains(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.sendEmptyMessage(3);
    }
    this.a.a(new Conversation.26.3(this, paramHashSet));
  }
  
  protected void onHideConversationMayKnowRecommend(boolean paramBoolean, Object paramObject)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onHideConversationMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      paramObject = (alro)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      paramObject.e();
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      paramBoolean = paramObject.b("sp_mayknow_ml_s_a_vl");
      paramObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramBoolean) {}
      for (i = 2;; i = 1)
      {
        ContactReportUtils.a(paramObject, "msgtab_listhide_clk", 1, i);
        return;
      }
    }
    QQToast.a(BaseApplication.getContext(), alpo.a(2131702974), 0).a();
    paramBoolean = ((alro)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).b("sp_mayknow_ml_s_a_vl");
    paramObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean) {}
    for (;;)
    {
      ContactReportUtils.a(paramObject, "msgtab_listhide_clk", 0, i);
      return;
      i = 1;
    }
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onMayknowStateChanged isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (((alro)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).b("sp_mayknow_ml_s_a_vl")))
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.a(1009, 500L, true);
    }
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap != null) {
        break label66;
      }
    }
    label66:
    for (int i = 0;; i = paramMap.size())
    {
      QLog.d("Q.recent", 2, i);
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break;
      }
      return;
    }
    Object localObject = (ProxyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18);
    label113:
    String str;
    if (localObject == null)
    {
      localObject = null;
      paramMap = paramMap.entrySet().iterator();
      if (!paramMap.hasNext()) {
        break label333;
      }
      str = (String)((Map.Entry)paramMap.next()).getKey();
      i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str);
      if (i != 2) {
        break label315;
      }
      atwd.a().a(str, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      if ((i == 3) && (localObject != null)) {}
      try
      {
        RecentUser localRecentUser = ((amjk)localObject).b(str, 1);
        if (localRecentUser != null)
        {
          ((amjk)localObject).b(localRecentUser);
          ajeu.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
          ((amjk)localObject).b(localRecentUser);
          ajgm.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, 1);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localRecentUser.uin, localRecentUser.getType());
        }
      }
      catch (Exception localException)
      {
        label290:
        break label290;
      }
      this.a.a(9, str, 1);
      break label113;
      localObject = ((ProxyManager)localObject).a();
      break;
      label315:
      atwd.a().c(str, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    label333:
    this.a.a(9, aljq.C, 5000);
    this.a.a(9, aljq.aL, 5001);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " Conversation.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (!bdal.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.a.a(new Conversation.26.2(this, paramString));
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.sendEmptyMessage(3);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatedelfriend");
      }
      this.a.a(0L);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onUpdateFriendInfo uin = " + paramString + ", isSc = " + paramBoolean);
    }
    if (!paramBoolean) {}
    while (bdal.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
      return;
    }
    this.a.a(0L);
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatefriendlist");
      }
      this.a.a(0L);
      this.a.a(new Conversation.26.1(this));
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if (paramBoolean) {
      this.a.a(new Conversation.26.5(this, paramArrayList));
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onUpdateOnlineFriend| isSuc = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
  
  protected void onUpdateRecentList()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a(new Conversation.26.4(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnb
 * JD-Core Version:    0.7.0.1
 */