import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatPie.75.1;
import com.tencent.mobileqq.activity.BaseChatPie.75.2;
import com.tencent.mobileqq.activity.BaseChatPie.75.3;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class aadg
  extends ajjh
{
  public aadg(BaseChatPie paramBaseChatPie) {}
  
  protected void onAddFriend(String paramString)
  {
    int k = 0;
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    paramString = akbm.q;
    int m = paramString.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        j = paramString[i];
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == j) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.75.1(this));
        return;
      }
      i += 1;
    }
  }
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!azzz.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
      this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.c)
      {
        paramString1 = this.a.e.getText().toString();
        this.a.e.setContentDescription(paramString1);
        this.a.a().setTitle(this.a.e.getText());
      }
    } while (!QLog.isDevelopLevel());
    amvy.a(this.a.jdField_a_of_type_JavaLangString, new Object[] { "onGetFriendDateNick", paramString2 });
  }
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.a.c == null) || (!this.a.c.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", badq.a(BaseApplication.getContext()) + "");
      awrn.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label371;
        }
        i = 1;
        break;
        if (arxu.a().jdField_a_of_type_Int != 2) {
          this.a.c.dismiss();
        }
        arxu.a().b.clear();
        if ((paramBoolean) && (paramObject != null)) {
          arxu.a().b.putAll((Map)paramObject);
        }
        if (arxu.a().b.size() == 0) {
          bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131632732, 0).b(this.a.a());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
          return;
          if (paramObject != null) {
            if (arxu.a().jdField_a_of_type_Int == 6) {
              ((acxm)this.a.jdField_a_of_type_Acxb.a(11)).a((Map)paramObject, arxu.a().jdField_a_of_type_JavaUtilArrayList, arxu.a().jdField_a_of_type_Int);
            } else {
              ((acxp)this.a.jdField_a_of_type_Acxb.a(1)).a((Map)paramObject, arxu.a().jdField_a_of_type_JavaUtilArrayList, arxu.a().jdField_a_of_type_Int);
            }
          }
        }
      }
      label371:
      i = 0;
    }
  }
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.a.D();
    }
  }
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject)
  {
    if (this.a.h != 0) {}
    while ((adnu.a == 0L) || (!(paramObject instanceof avcq))) {
      return;
    }
    ThreadManager.post(new BaseChatPie.75.3(this, (avcq)paramObject), 5, null, false);
  }
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    AvatarLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramHashSet);
  }
  
  protected void onGetStrangerInfo(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null) || (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (!(paramObject instanceof Set))) {
      return;
    }
    bajo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Set localSet = (Set)paramObject;
    int k = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
    int i = 0;
    label56:
    Object localObject1;
    ChatMessage localChatMessage;
    label114:
    int j;
    if (i < k)
    {
      paramObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramObject != null) && ((paramObject instanceof BaseChatItemLayout)))
      {
        localObject1 = (acju)aciy.a(paramObject);
        localChatMessage = aciy.a(paramObject);
        if (!localChatMessage.isSend()) {
          break label265;
        }
        paramObject = localChatMessage.selfuin;
        Object localObject2 = (ajjj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((localObject1 != null) && (((acju)localObject1).a != null) && (paramObject != null) && (localSet.contains(paramObject)))
        {
          localObject2 = ((ajjj)localObject2).a(paramObject);
          if (localObject2 != null)
          {
            Object localObject3 = Long.valueOf(((ExtensionInfo)localObject2).pendantId);
            if (localObject3 != null)
            {
              if (((Long)localObject3).longValue() == 0L) {
                break label322;
              }
              localObject3 = ((AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(((Long)localObject3).longValue());
              localObject1 = ((acju)localObject1).a;
              if (i == k) {
                break label316;
              }
              j = 1;
              label238:
              ((PendantInfo)localObject3).a((View)localObject1, j, localChatMessage.uniseq, paramObject, ((ExtensionInfo)localObject2).pendantDiyId);
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label56;
      break;
      label265:
      if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004))
      {
        paramObject = localChatMessage.frienduin;
        break label114;
      }
      paramObject = localChatMessage.senderuin;
      break label114;
      label316:
      j = 2;
      break label238;
      label322:
      if (((acju)localObject1).a.a != null)
      {
        ((acju)localObject1).a.a.setImageDrawable(null);
        ((acju)localObject1).a.a.setVisibility(8);
      }
    }
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean) || (paramInt1 != 146)) {
      return;
    }
    if (paramInt2 == 0)
    {
      aiet.a().a(paramLong);
      return;
    }
    aiet.a().a(paramLong, paramInt2);
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.75.2(this, paramLong));
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {}
    switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
    case 1037: 
    case 1044: 
      do
      {
        do
        {
          return;
        } while (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onSetComment curFriendNick" + azzz.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d));
        }
        this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      } while (!AppSetting.c);
      paramString1 = this.a.e.getText().toString();
      this.a.e.setContentDescription(paramString1);
      this.a.a().setTitle(this.a.e.getText());
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = babh.m(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {}
      for (paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;; paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
      {
        paramString2.d = paramString1;
        break;
      }
    case 1: 
      this.a.b(false, false);
      return;
    }
    this.a.b(false, false);
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    if ((!paramBoolean) && (this.a.v())) {
      bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2130839278, this.a.jdField_a_of_type_AndroidContentContext.getString(2131654642), 0).b(this.a.a());
    }
  }
  
  protected void onUpdateC2ChatStatus(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (!paramHashMap.containsKey(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    int i = 0;
    label20:
    acju localacju;
    if (i < this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      paramHashMap = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramHashMap != null) && ((paramHashMap instanceof BaseChatItemLayout)))
      {
        localacju = (acju)aciy.a(paramHashMap);
        paramHashMap = aciy.a(paramHashMap);
        if ((localacju != null) && (paramHashMap != null) && (!paramHashMap.isSendFromLocal()) && (paramHashMap.istroop != 1) && (paramHashMap.istroop != 3000)) {
          if ((paramHashMap.istroop != 1010) && (paramHashMap.istroop != 1001) && (paramHashMap.istroop != 10002)) {
            break label170;
          }
        }
      }
    }
    label170:
    for (paramHashMap = azwp.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramHashMap.senderuin, true);; paramHashMap = azwp.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramHashMap.senderuin))
    {
      localacju.a.setHeaderIcon(paramHashMap);
      i += 1;
      break label20;
      break;
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (paramString == null)) {
      return;
    }
    AvatarLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, Arrays.asList(new String[] { paramString }));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject + "")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "onUpdateDelFriend exit ChatActivity now uin = " + paramObject);
      }
      this.a.b(1);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateFriendInfo wrong uinType");
      return;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034) || (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) && (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
    String str = null;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) {
      str = babh.j(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateFriendInfo title" + azzz.a(str));
      }
      this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (!AppSetting.c) {
        break;
      }
      paramString = this.a.e.getText().toString();
      this.a.e.setContentDescription(paramString);
      this.a.a().setTitle(this.a.e.getText());
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) {
        str = mqb.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      } else if (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        str = babh.m(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.D();
  }
  
  protected void onUpdateRecentList() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aadg
 * JD-Core Version:    0.7.0.1
 */