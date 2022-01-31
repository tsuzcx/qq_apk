import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ajel
  extends QIPCModule
{
  private static volatile ajel jdField_a_of_type_Ajel;
  private ajfo jdField_a_of_type_Ajfo = new ajem(this);
  private atwx jdField_a_of_type_Atwx = new atwx();
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ConcurrentHashMap<String, Bundle> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  boolean jdField_a_of_type_Boolean = false;
  
  public ajel(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_Atwx.jdField_a_of_type_ArrayOfJavaLangString = new String[7];
  }
  
  public static ajel a()
  {
    if (jdField_a_of_type_Ajel == null) {}
    try
    {
      if (jdField_a_of_type_Ajel == null) {
        jdField_a_of_type_Ajel = new ajel("BabyQIPCModule");
      }
      return jdField_a_of_type_Ajel;
    }
    finally {}
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_process_callback_id", paramInt);
    localBundle.putString("key_js_callback_id", paramString2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localBundle);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb callWebJSHandledSetGroup");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("setFriendGrouping") != null)
    {
      localBundle = new Bundle();
      localObject2 = (Bundle)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("setFriendGrouping");
      localObject1 = ((Bundle)localObject2).getString("key_js_callback_id");
      i = ((Bundle)localObject2).getInt("key_process_callback_id");
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        localBundle.putString("key_method_action", "setFriendGrouping");
        localBundle.putString("web_js_call_back_id", (String)localObject1);
        localObject2 = (ajjj)((QQAppInterface)localObject2).getManager(51);
        if (localObject2 != null) {
          break label183;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = ((ajjj)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
          if (localObject1 != null) {
            localBundle.putString("key_handle_set_get_group", ((Groups)localObject1).group_name);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove("setFriendGrouping");
      callbackResult(i, EIPCResult.createSuccessResult(localBundle));
    }
    label183:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        Bundle localBundle;
        Object localObject2;
        int i;
        return;
        Object localObject1 = ((ajjj)localObject2).e(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      }
    }
    QLog.d("BabyQIPCModule", 2, "babyqWeb callWebJSHandledSetGroup");
  }
  
  public void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("BabyQIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_Ajfo);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb BabyQFriendStatusWebPlugin init ");
    }
    Object localObject = (ajjj)localQQAppInterface.getManager(51);
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCard = azyk.a(localQQAppInterface, ajed.aB);
      this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localObject != null)) {
      if (!((ajjj)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin)) {
        break label153;
      }
    }
    ajfi localajfi;
    label153:
    for (localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 1);; localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 19))
    {
      this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)localObject);
      localajfi = (ajfi)localQQAppInterface.a(2);
      if (localajfi != null) {
        break;
      }
      return;
    }
    long l = ProfileActivity.a((ProfileActivity.AllInOne)localObject, false);
    localajfi.a(localQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)1);
    localajfi.w();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb action = " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
      b();
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = null;
    if (paramBundle != null) {
      str = paramBundle.getString("web_js_call_back_id");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_method_action", paramString);
    localBundle.putString("web_js_call_back_id", str);
    if (paramString.equals("getFriendStatus"))
    {
      paramString = (ajjj)localQQAppInterface.getManager(51);
      if (paramString == null) {
        break label1357;
      }
    }
    label292:
    label440:
    label1349:
    label1351:
    label1357:
    for (boolean bool = paramString.b(ajed.aB);; bool = false)
    {
      if (bool) {}
      for (long l = 1L;; l = 0L)
      {
        localBundle.putLong("key_get_friend_status", l);
        return EIPCResult.createSuccessResult(localBundle);
      }
      if (paramString.equals("getZanVoteCount"))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          localBundle.putLong("key_get_zan_vote_count", this.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount);
        }
        return EIPCResult.createSuccessResult(localBundle);
      }
      if (paramString.equals("requestZan"))
      {
        paramString = (ajfi)localQQAppInterface.a(2);
        int i;
        if ((paramString != null) && (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (badq.d(BaseApplication.getContext()))) {
          if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt <= 0)
          {
            paramInt = 1;
            if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.bHaveVotedCnt > 0) || (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt > 0)) {
              break label599;
            }
            i = 1;
            if ((paramInt != 0) || (i != 0)) {
              break label625;
            }
            paramBundle = this.jdField_a_of_type_ComTencentMobileqqDataCard;
            paramBundle.lVoteCount += 1L;
            this.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted = 1;
            paramBundle = this.jdField_a_of_type_ComTencentMobileqqDataCard;
            paramBundle.bAvailVoteCnt = ((short)(paramBundle.bAvailVoteCnt - 1));
            paramString.a(Long.valueOf(localQQAppInterface.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a).longValue(), this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.vCookies, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.favoriteSource, 1, 0);
            bool = ((ased)localQQAppInterface.getManager(207)).c(Long.valueOf(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin).longValue());
            if (PraiseManager.a(localQQAppInterface) <= 0) {
              break label610;
            }
            if (!bool) {
              break label605;
            }
            paramInt = 3;
            awqx.b(localQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 1, 1, paramInt, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)), String.valueOf(1), localQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
            l = 0L;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BabyQIPCModule", 2, "babyqWeb vote, card.bAvailVoteCnt = " + this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt + ",card.bHaveVotedCnt = " + this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.bHaveVotedCnt + ",card.strVoteLimitedNotice = " + this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.strVoteLimitedNotice);
          }
          localBundle.putLong("key_request_zan_vote_result", l);
          return EIPCResult.createSuccessResult(localBundle);
          paramInt = 0;
          break;
          label599:
          i = 0;
          break label292;
          label605:
          paramInt = 2;
          break label440;
          label610:
          if (bool)
          {
            paramInt = 1;
            break label440;
          }
          paramInt = 0;
          break label440;
          label625:
          l = 1L;
          continue;
          l = 2L;
        }
      }
      if (paramString.equals("addFriend")) {
        awqx.b(localQQAppInterface, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
      }
      label1001:
      do
      {
        return null;
        if (paramString.equals("sendmsg"))
        {
          localBundle.putParcelable("key_parcel_allinone", this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          return EIPCResult.createSuccessResult(localBundle);
        }
        if (paramString.equals("deleteFriend"))
        {
          if (badq.d(BaseApplication.getContext()))
          {
            ((FriendListHandler)localQQAppInterface.a(1)).c(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, (byte)2);
            paramString = localQQAppInterface.getHandler(ChatActivity.class);
            if (paramString != null) {
              paramString.sendMessage(paramString.obtainMessage(16711681, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a));
            }
            paramString = localQQAppInterface.getHandler(ChatSettingActivity.class);
            if (paramString != null) {
              paramString.sendMessage(paramString.obtainMessage(16711681, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a));
            }
            if (QLog.isColorLevel()) {
              QLog.i("BabyQIPCModule", 2, "babyqWeb delte friend");
            }
            awqx.b(localQQAppInterface, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
            return EIPCResult.createSuccessResult(localBundle);
          }
          return EIPCResult.createResult(-102, localBundle);
        }
        if (paramString.equals("getFriendGrouping"))
        {
          if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
          {
            paramBundle = (ajjj)localQQAppInterface.getManager(51);
            if (paramBundle != null) {
              break label1001;
            }
          }
          for (paramString = null;; paramString = paramBundle.e(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
          {
            if (paramString != null)
            {
              paramString = paramBundle.a(String.valueOf(paramString.groupid));
              if (paramString != null)
              {
                localBundle.putString("key_handle_set_get_group", paramString.group_name);
                if (QLog.isColorLevel()) {
                  QLog.i("BabyQIPCModule", 2, "babyqWeb get group =" + paramString.group_name);
                }
              }
            }
            return EIPCResult.createSuccessResult(localBundle);
          }
        }
        if (paramString.equals("setFriendGrouping"))
        {
          if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
          {
            paramBundle = (ajjj)localQQAppInterface.getManager(51);
            if (paramBundle != null) {
              break label1106;
            }
          }
          for (paramBundle = null;; paramBundle = paramBundle.e(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
          {
            if (paramBundle != null)
            {
              localBundle.putString("friendUin", this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
              localBundle.putByte("mgid", (byte)paramBundle.groupid);
            }
            if (paramInt == -1) {
              break label1124;
            }
            a(paramString, paramInt, str);
            break;
          }
          return EIPCResult.createSuccessResult(localBundle);
        }
        if (paramString.equals("reportFriend"))
        {
          if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
          try
          {
            localBundle.putString("key_report_msg", xbq.a(localQQAppInterface, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, "", 21001, null));
            return EIPCResult.createSuccessResult(localBundle);
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("BabyQIPCModule", 2, "babyqWeb getReportMsg Exception", paramString);
              }
            }
          }
        }
        if (paramString.equals("getPushStatus"))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard.babyQSwitch) {}
          for (l = 1L;; l = 0L)
          {
            localBundle.putLong("key_request_zan_vote_result", l);
            return EIPCResult.createSuccessResult(localBundle);
          }
        }
      } while (!paramString.equals("setPushStatus"));
      label1106:
      label1124:
      if (paramBundle != null)
      {
        l = paramBundle.getLong("key_push_status", 0L);
        label1274:
        if (!badq.d(BaseApplication.getContext())) {
          break label1349;
        }
        paramString = (ajfi)localQQAppInterface.a(2);
        if (l != 1L) {
          break label1351;
        }
      }
      for (bool = true;; bool = false)
      {
        paramString.m(bool);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("BabyQIPCModule", 2, "babyqWeb set babyQSwitch = " + l);
        break;
        l = 0L;
        break label1274;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajel
 * JD-Core Version:    0.7.0.1
 */