import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPieInnerObserver.1;
import com.tencent.mobileqq.activity.aio.core.TroopChatPieInnerObserver.2;
import com.tencent.mobileqq.activity.aio.core.TroopChatPieInnerObserver.3;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.Result;

public class agbv
  extends aofu
{
  private ahqe jdField_a_of_type_Ahqe;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public agbv(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.sessionInfo;
    this.jdField_a_of_type_Ahqe = paramTroopChatPie.panelManager;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramTroopChatPie.mActivity;
  }
  
  protected void onAddTroopSuccess(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.updateSession_updateTitleRightView();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerObserver", 2, String.format("onAddTroopSuccess, troopUin: %s", new Object[] { paramString }));
    }
  }
  
  protected void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.uiHandler.removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mProgressDialog.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      do
      {
        return;
        if (paramBoolean) {
          break label379;
        }
        i = 1;
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mProgressDialog != null) && (axio.a().jdField_a_of_type_Int != 2)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mProgressDialog.dismiss();
        }
        axio.a().b.clear();
        if ((paramBoolean) && (paramObject != null))
        {
          axio.a().b.putAll((Map)paramObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + paramObject);
          }
        }
        while (axio.a().b.size() == 0)
        {
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698184, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
          }
        }
      } while (paramObject == null);
      if (axio.a().jdField_a_of_type_Int == 6)
      {
        ((agit)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(11)).a((Map)paramObject, axio.a().jdField_a_of_type_JavaUtilArrayList, axio.a().jdField_a_of_type_Int);
        return;
      }
      ((agiw)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(1)).a((Map)paramObject, axio.a().jdField_a_of_type_JavaUtilArrayList, axio.a().jdField_a_of_type_Int);
      return;
      label379:
      i = 0;
    }
  }
  
  protected void onBeKickOutTroop(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.hasDestory)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.finish(1);
    }
  }
  
  protected void onChangeGroupClassExt(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerObserver", 2, new Object[] { "onChangeGroupClassExt. oldClassExt=", Long.valueOf(paramLong1), ", newClassExt=", Long.valueOf(paramLong2) });
    }
    if (paramLong2 == 32L) {
      i = 1;
    }
    if (i != 0) {
      new bfud(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mContext, "3171", "libWXVoice.so", "WXVoice").a();
    }
    if ((TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) && (paramBoolean) && (paramLong1 != paramLong2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox.a(paramLong2, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, paramString);
    }
  }
  
  protected void onChangeTroopAIORedPoint(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (paramString1 == null)
      {
        str = "";
        QLog.d("TroopChatPieInnerObserver", 2, new Object[] { "onChangeTroopAIORedPoint. isSuc=", Boolean.valueOf(paramBoolean1), ", troopUin=", str, ", type = ", paramString2, ", from0x8c2=", Boolean.valueOf(paramBoolean2) });
      }
    }
    else {
      if ((paramBoolean1) && (!paramBoolean2)) {
        break label91;
      }
    }
    label91:
    while ((!TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (!String.valueOf(1104445552).equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox.a instanceof bfxr)))
    {
      return;
      str = paramString1;
      break;
    }
    ((bfxr)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox.a).a(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
  }
  
  protected void onCleanOnlineMemberList(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.s();
    }
  }
  
  protected void onClearTroopAppRedPoint(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList)
  {
    paramArrayList = (PlusPanel)this.jdField_a_of_type_Ahqe.a(8);
    if ((paramArrayList != null) && (paramBoolean.booleanValue())) {
      paramArrayList.a();
    }
  }
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.setText(paramString2);
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.setContentDescription(paramString2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getActivity().setTitle(paramString2);
      }
    }
  }
  
  protected void onGetAnonyChatNick(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4)
  {
    if (paramBoolean)
    {
      if (paramInt4 == 0)
      {
        nty.a().a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, null, paramString4);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.uiHandler.postDelayed(new TroopChatPieInnerObserver.1(this), 500L);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(3, paramString3);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(1, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690047));
  }
  
  protected void onGetHomeworkSurvey(boolean paramBoolean, String paramString)
  {
    if (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.u();
    }
  }
  
  protected void onGetHomeworkTab(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 0);
    boolean bool = localSharedPreferences.getBoolean("HomeworkIcon_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, false);
    if (!TextUtils.isEmpty(paramString)) {
      i = 1;
    }
    if (((bool) && (i == 0)) || ((!bool) && (i != 0)))
    {
      if (i != 0) {
        break label144;
      }
      localSharedPreferences.edit().remove("HomeworkIcon_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin).commit();
    }
    for (;;)
    {
      paramString = (PlusPanel)this.jdField_a_of_type_Ahqe.a(8);
      if (paramString != null) {
        paramString.a();
      }
      return;
      label144:
      localSharedPreferences.edit().putBoolean("HomeworkIcon_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, true).commit();
    }
  }
  
  protected void onGetHomeworkTroopIdentity(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) && (TextUtils.equals(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)))
    {
      if ((!bghd.a(paramInt)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox.a instanceof bfxr))) {
        ((bfxr)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox.a).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox.a(paramInt);
      }
    }
  }
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    paramString = (PlusPanel)this.jdField_a_of_type_Ahqe.a(8);
    if ((paramString != null) && (paramTroopInfo != null) && (paramTroopInfo.troopuin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {
      paramString.b(true);
    }
  }
  
  protected void onGetTroopAioNotifyFeeds(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTroopTips == null));
      bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTroopTips.a();
      bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTroopTips.d();
      int j = 0;
      int i = j;
      if (paramList != null)
      {
        i = j;
        if (paramList.size() > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTroopTips.a(paramList);
          i = j;
          if (!bool2)
          {
            i = j;
            if (!bool1)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTroopTips.f();
              i = 1;
            }
          }
        }
      }
      bool3 = TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      if ((!bool1) && (!bool2) && (i == 0) && (!bool3)) {
        ThreadManager.getUIHandler().postDelayed(new TroopChatPieInnerObserver.2(this), 500L);
      }
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopAioNotifyFeeds, isSucc=").append(paramBoolean).append(", troopUin=").append(paramString).append(", size=");
    if (paramList == null) {}
    for (paramString = " ";; paramString = Integer.valueOf(paramList.size()))
    {
      QLog.d(".troop.notify_feeds.aio", 2, paramString + ", isMsgBarNeedShow=" + bool1 + ", hasMsgBar=" + bool2 + ", isQidianPrivateTroop=" + bool3);
      return;
    }
  }
  
  protected void onGetTroopAppList(Boolean paramBoolean)
  {
    if (((PlusPanel)this.jdField_a_of_type_Ahqe.a(8) != null) && (paramBoolean.booleanValue())) {}
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString)))
    {
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = paramString.getTroopName();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
        if (AppSetting.c)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.getText().toString();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.setContentDescription(paramString);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setTitle(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.getText());
        }
      }
    }
  }
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(paramBoolean, paramObject);
  }
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      break label15;
    }
    label15:
    label44:
    label206:
    label207:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1020))
      {
        int i = 0;
        if (i < paramArrayList.size())
        {
          TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
          if ((localTroopMemberCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(localTroopMemberCardInfo.memberuin)))
          {
            paramArrayList = localTroopMemberCardInfo.name;
            if ((paramArrayList != null) && (!"".equals(paramArrayList))) {
              break label206;
            }
            paramArrayList = localTroopMemberCardInfo.nick;
          }
        }
        for (;;)
        {
          if ((paramArrayList == null) || ("".equals(paramArrayList))) {
            break label207;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = paramArrayList;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
          if (!AppSetting.c) {
            break;
          }
          paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.getText().toString();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.setContentDescription(paramArrayList);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setTitle(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.getText());
          return;
          i += 1;
          break label44;
          break label15;
        }
      }
    }
  }
  
  protected void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (paramTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramTroopInfo.troopuin)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = paramTroopInfo.getTroopName();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
      if (AppSetting.c)
      {
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.getText().toString();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.setContentDescription(paramTroopInfo);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setTitle(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mTitleText.getText());
      }
    }
  }
  
  protected void onNotifyUpdateTitleBtnCall(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(String.valueOf(l)))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.updateSession_updateTitleBtnCall();
      }
    }
  }
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!bhbx.a(String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i("TroopChatPieInnerObserver", 2, localStringBuilder.toString());
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(paramList);
  }
  
  protected void onOIDB0XA80_0_Ret(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString1)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString2)) && (paramInt1 == 1) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: cmd==1," + paramBoolean + "," + paramString1 + "," + paramString2 + "," + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b);
      }
      if (!paramBoolean) {
        break label177;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().pullRecentGroupMsg(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_history", 0, 0, paramString1, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: pullRecentGroupMsg");
      }
    }
    label177:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b <= 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c(1);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
    paramString1.b -= 1;
  }
  
  protected void onPassiveExit(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.updateSession_updateTitleRightView();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.updateSession_updateTitleBtnCall();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerObserver", 2, String.format("onPassiveExit, troopUin: %s, reason: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    paramString = (aggv)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(71);
    if (paramString != null) {
      paramString.a();
    }
  }
  
  protected void onPushTroopEnterEffect(bfku parambfku)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerObserver", 2, "onPushTroopEnterEffect: troopUin = " + parambfku.b + ", data.id = " + parambfku.jdField_a_of_type_Int);
    }
    if (nty.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPieInnerObserver", 2, "onPushTroopEnterEffect: troopUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin + " isAnonymous");
      }
      return;
    }
    parambfku = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a();
    parambfku.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    parambfku.a();
  }
  
  protected void onSortedTroopAppList(Boolean paramBoolean)
  {
    PlusPanel localPlusPanel = (PlusPanel)this.jdField_a_of_type_Ahqe.a(8);
    if ((localPlusPanel != null) && (paramBoolean.booleanValue())) {
      localPlusPanel.a();
    }
  }
  
  protected void onTroopBatchAddFrdsReadyForTip(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    QLog.i("TroopChatPieInnerObserver", 1, String.format("troopBatchAddFrd.onTroopBatchAddFrdsReadyForTip suc_troopUin_type_intentUIn=%b_%s_%d_%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt), localObject }));
    if ((paramBoolean) && (bgqt.a(paramInt)) && (paramString.equalsIgnoreCase((String)localObject)))
    {
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 5)) {
        break label121;
      }
      paramList = (TroopAddFriendTipsHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(28);
      if (paramList != null) {
        paramList.a(true, paramString);
      }
    }
    for (;;)
    {
      return;
      label121:
      if ((paramInt == 4) && (paramList != null) && (paramList.size() > 0))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.u)
        {
          localObject = (String)paramList.get(0);
          paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a((String)localObject);
          localObject = (TroopAddFriendTipsHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(28);
          if (localObject != null) {
            ((TroopAddFriendTipsHelper)localObject).a(paramBoolean, paramString);
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d("TroopChatPieInnerObserver", 2, "onTroopBatchAddFrdsReadyForTip  isScrolling = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.u + ",visible = " + paramBoolean + ",targetUins = " + paramList);
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_d_of_type_JavaLangString = ((String)paramList.get(0));
          paramBoolean = false;
        }
      }
    }
  }
  
  protected void onTroopBlockStatusChanged(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPieInnerObserver", 2, String.format("onTroopBlockStatusChanged, troopUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin }));
      }
      paramString = (agkq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(76);
    } while (paramString == null);
    paramString.b();
  }
  
  protected void onTroopInfoUpdate(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)))
    {
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
      if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = paramString.getTroopName();
        Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
        localIntent.putExtra("uinname", paramString.getTroopName());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.updateSession_updateTitle(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.t();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox.a(paramString.dwGroupClassExt, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.u();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.i();
        ((bdvz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      }
    }
  }
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 9) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.n)) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, anvx.a(2131714629), 0).a();
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 2) || (paramInt1 == 9))
    {
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "onTroopManagerSuccess, isTroopOwner =" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.n);
        }
        String str = anvx.a(2131714634);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.n) {
          str = anvx.a(2131714632);
        }
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, str, 0).a();
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(paramString, str);
        ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, anvx.a(2131714627), 0).a();
  }
  
  protected void onTroopMemberUpdate()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.t();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mAIOGiftPanelContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mAIOGiftPanelContainer.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mAIOGiftPanelContainer.a().b();
    }
  }
  
  protected void onTroopNewFeedsAutoPullDown(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerObserver.troop.notification_center.auto_pull_down", 2, "onTroopNewFeedsAutoPullDown, isSuc:" + paramBoolean + "troopUin" + paramString1 + ",feedsId:" + paramString2 + ",flag:" + paramInt);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString1)) {}
  }
  
  protected void onTroopNewFeedsComing(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) || (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {
      return;
    }
    Integer localInteger = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((localInteger != null) && (-1 == localInteger.intValue())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onTroopNewFeedsComing, isSuc:" + paramBoolean1 + ", troopUin=" + paramString + ",bDeleted:" + paramBoolean2 + ", isFromPush=" + paramBoolean3 + ", hasNewNotify=" + bool);
      }
      if (paramBoolean3) {
        break;
      }
      bgif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      return;
    }
  }
  
  protected void onTroopRewardChangeNotify(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString1))
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.listAdapter.a();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.listView.getFirstVisiblePosition();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.listView.getLastVisiblePosition();
      paramString1 = ((bglo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_REWARD_MGR)).a(paramString1, paramString2);
      if (paramString1 != null)
      {
        int k = localList.indexOf(paramString1);
        if ((k >= i) && (k <= j)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.refresh(131077);
        }
      }
    }
  }
  
  protected void onUpdateGameOnlineSwitchStatus(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.s();
    }
  }
  
  protected void onUpdateOnlineMemberList(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.hasDestory) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bgsy == null)) {}
    while ((!TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getSessionInfo().curFriendUin)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_d_of_type_Boolean) || (aghd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie))) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bgsy.a(2);
      return;
    }
    paramString2 = ((bgth)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER)).a(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.setSubTitleVisable(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mSubTilteText.setText(paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bgsy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bgsy.a(paramString1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bgsy.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bgsy.d();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bgsy.a(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(false);
  }
  
  protected void onUpdateOnlineMemberTips(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getSessionInfo().curFriendUin))
    {
      paramString2 = (bgth)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(paramString1, true);
      if ((paramBoolean) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()))
      {
        long l = (paramString2.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getSessionInfo().curFriendUin) - NetConnInfoCenter.getServerTime()) * 1000L;
        if (QLog.isColorLevel()) {
          QLog.i("TroopChatPieInnerObserver", 2, "mGetOnlineMemberTipsRunnable, delay = " + l);
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c);
        ThreadManager.getUIHandler().post(new TroopChatPieInnerObserver.3(this, l));
      }
    }
  }
  
  protected void onUpdateRecentList()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.i();
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    agkq localagkq = (agkq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(76);
    if (localagkq != null) {
      localagkq.b();
    }
  }
  
  protected void onUpdateTroopMiniAppEntranceRedPoint(String paramString, boolean paramBoolean) {}
  
  protected void onUpdateTroopUnreadMsg(boolean paramBoolean1, boolean paramBoolean2, List<bgsx> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerObserver", 2, new Object[] { "onUpdateTroopUnreadMsg. isSuc=", Boolean.valueOf(paramBoolean1), ", isPush=", Boolean.valueOf(paramBoolean2) });
    }
    if ((!paramBoolean1) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    label384:
    for (;;)
    {
      label67:
      Object localObject1;
      if (paramList.hasNext())
      {
        localObject1 = (bgsx)paramList.next();
        if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ((bgsx)localObject1).jdField_a_of_type_JavaLangString)) {
          continue;
        }
        if (((bgsx)localObject1).jdField_a_of_type_Long == 1104445552L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopChatPieInnerObserver", 2, new Object[] { "onUpdateTroopUnreadMsg homework. num=", Integer.valueOf(((bgsx)localObject1).b) });
          }
          if (!TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
            break label300;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox.a instanceof bfxr))) {
            ((bfxr)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_Bfox.a).a(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
          }
        }
      }
      for (;;)
      {
        if (((bgsx)localObject1).jdField_a_of_type_Long != 2L) {
          break label384;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopChatPieInnerObserver", 2, "receive troop album  red dot, push=" + paramBoolean2 + ", num=" + ((bgsx)localObject1).b);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.uiHandler;
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
        ((MqqHandler)localObject1).obtainMessage(85).sendToTarget();
        break label67;
        break;
        label300:
        if (((bgsx)localObject1).jdField_a_of_type_Long == 1106611799L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopChatPieInnerObserver", 2, "receive game feed red dot, push=" + paramBoolean2 + ", num=" + ((bgsx)localObject1).b);
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.uiHandler;
          TroopChatPie localTroopChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
          ((MqqHandler)localObject2).obtainMessage(85).sendToTarget();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbv
 * JD-Core Version:    0.7.0.1
 */