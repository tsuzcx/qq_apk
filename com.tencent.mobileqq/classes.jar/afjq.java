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
import com.tencent.mobileqq.activity.aio.core.TroopChatPie.12.1;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie.12.2;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie.12.3;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class afjq
  extends andd
{
  public afjq(TroopChatPie paramTroopChatPie) {}
  
  protected void onAddTroopSuccess(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a.sessionInfo.curFriendUin))) {
      this.a.updateSession_updateTitleRightView();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, String.format("onAddTroopSuccess, troopUin: %s", new Object[] { paramString }));
    }
  }
  
  protected void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject)
  {
    this.a.uiHandler.removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.a.mProgressDialog == null) || (!this.a.mProgressDialog.isShowing()))
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      do
      {
        return;
        if (paramBoolean) {
          break label394;
        }
        i = 1;
        break;
        if ((this.a.mProgressDialog != null) && (awcm.a().jdField_a_of_type_Int != 2)) {
          this.a.mProgressDialog.dismiss();
        }
        awcm.a().b.clear();
        if ((paramBoolean) && (paramObject != null))
        {
          awcm.a().b.putAll((Map)paramObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + paramObject);
          }
        }
        while (awcm.a().b.size() == 0)
        {
          QQToast.a(this.a.mActivity, 2131697901, 0).b(this.a.mActivity.getTitleBarHeight());
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
          }
        }
      } while (paramObject == null);
      if (awcm.a().jdField_a_of_type_Int == 6)
      {
        ((afri)this.a.helperProvider.a(11)).a((Map)paramObject, awcm.a().jdField_a_of_type_JavaUtilArrayList, awcm.a().jdField_a_of_type_Int);
        return;
      }
      ((afrl)this.a.helperProvider.a(1)).a((Map)paramObject, awcm.a().jdField_a_of_type_JavaUtilArrayList, awcm.a().jdField_a_of_type_Int);
      return;
      label394:
      i = 0;
    }
  }
  
  protected void onBeKickOutTroop(String paramString)
  {
    if ((this.a.sessionInfo.curFriendUin.equals(paramString)) && (!this.a.hasDestory)) {
      this.a.finish(1);
    }
  }
  
  protected void onChangeGroupClassExt(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, new Object[] { "onChangeGroupClassExt. oldClassExt=", Long.valueOf(paramLong1), ", newClassExt=", Long.valueOf(paramLong2) });
    }
    if (paramLong2 == 32L) {
      i = 1;
    }
    if (i != 0) {
      new bena(this.a.mContext, "3171", "libWXVoice.so", "WXVoice").a();
    }
    if ((TextUtils.equals(paramString, this.a.sessionInfo.curFriendUin)) && (paramBoolean) && (paramLong1 != paramLong2) && (TroopChatPie.a(this.a) != null)) {
      TroopChatPie.a(this.a).a(paramLong2, true, this.a, paramString);
    }
  }
  
  protected void onChangeTroopAIORedPoint(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    String str1;
    if (QLog.isColorLevel())
    {
      String str2 = this.a.tag;
      if (paramString1 == null)
      {
        str1 = "";
        QLog.d(str2, 2, new Object[] { "onChangeTroopAIORedPoint. isSuc=", Boolean.valueOf(paramBoolean1), ", troopUin=", str1, ", type = ", paramString2, ", from0x8c2=", Boolean.valueOf(paramBoolean2) });
      }
    }
    else
    {
      if ((paramBoolean1) && (!paramBoolean2)) {
        break label100;
      }
    }
    label100:
    while ((!TextUtils.equals(paramString1, this.a.sessionInfo.curFriendUin)) || (!TroopInfo.isHomeworkTroop(this.a.app, this.a.sessionInfo.curFriendUin)) || (!String.valueOf(1104445552).equals(paramString2)) || (TroopChatPie.a(this.a) == null) || (!(TroopChatPie.a(this.a).a instanceof beqp)))
    {
      return;
      str1 = paramString1;
      break;
    }
    ((beqp)TroopChatPie.a(this.a).a).a(false, this.a);
  }
  
  protected void onCleanOnlineMemberList(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopChatPie.a(this.a);
    }
  }
  
  protected void onClearTroopAppRedPoint(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList)
  {
    paramArrayList = (PlusPanel)this.a.panelManager.a(8);
    if ((paramArrayList != null) && (paramBoolean.booleanValue())) {
      paramArrayList.c();
    }
  }
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if ((this.a.sessionInfo.curType == 1) && (this.a.sessionInfo.curFriendUin.equals(paramString1)))
    {
      this.a.sessionInfo.curFriendNick = paramString2;
      this.a.mTitleText.setText(paramString2);
      if (AppSetting.c)
      {
        this.a.mTitleText.setContentDescription(paramString2);
        this.a.getActivity().setTitle(paramString2);
      }
    }
  }
  
  protected void onGetAnonyChatNick(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4)
  {
    if (paramBoolean)
    {
      if (paramInt4 == 0)
      {
        nmy.a().a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, null, paramString4);
        this.a.uiHandler.postDelayed(new TroopChatPie.12.1(this), 500L);
        return;
      }
      this.a.a(3, paramString3);
      return;
    }
    this.a.a(1, this.a.mActivity.getResources().getString(2131690018));
  }
  
  protected void onGetHomeworkSurvey(boolean paramBoolean, String paramString)
  {
    if (TextUtils.equals(paramString, this.a.sessionInfo.curFriendUin)) {
      TroopChatPie.b(this.a);
    }
  }
  
  protected void onGetHomeworkTab(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 0);
    boolean bool = localSharedPreferences.getBoolean("HomeworkIcon_" + this.a.sessionInfo.curFriendUin, false);
    if (!TextUtils.isEmpty(paramString)) {
      i = 1;
    }
    if (((bool) && (i == 0)) || ((!bool) && (i != 0)))
    {
      if (i != 0) {
        break label153;
      }
      localSharedPreferences.edit().remove("HomeworkIcon_" + this.a.sessionInfo.curFriendUin).commit();
    }
    for (;;)
    {
      paramString = (PlusPanel)this.a.panelManager.a(8);
      if (paramString != null) {
        paramString.c();
      }
      return;
      label153:
      localSharedPreferences.edit().putBoolean("HomeworkIcon_" + this.a.sessionInfo.curFriendUin, true).commit();
    }
  }
  
  protected void onGetHomeworkTroopIdentity(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, this.a.sessionInfo.curFriendUin)) && (TextUtils.equals(paramString2, this.a.app.getCurrentAccountUin())) && (TroopInfo.isHomeworkTroop(this.a.app, paramString1)))
    {
      if ((!beyy.a(paramInt)) && (TroopChatPie.a(this.a) != null) && ((TroopChatPie.a(this.a).a instanceof beqp))) {
        ((beqp)TroopChatPie.a(this.a).a).b(this.a);
      }
      if (TroopChatPie.a(this.a) != null) {
        TroopChatPie.a(this.a).a(paramInt);
      }
    }
  }
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    paramString = (PlusPanel)this.a.panelManager.a(8);
    if ((paramString != null) && (paramTroopInfo != null) && (paramTroopInfo.troopuin.equals(this.a.sessionInfo.curFriendUin))) {
      paramString.b(true);
    }
  }
  
  protected void onGetTroopAioNotifyFeeds(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList)
  {
    if (!this.a.sessionInfo.curFriendUin.equals(paramString)) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    do
    {
      do
      {
        return;
      } while (this.a.mTroopTips == null);
      bool1 = this.a.mTroopTips.a();
      bool2 = this.a.mTroopTips.d();
      int j = 0;
      int i = j;
      if (paramList != null)
      {
        i = j;
        if (paramList.size() > 0)
        {
          this.a.mTroopTips.a(paramList);
          i = j;
          if (!bool2)
          {
            i = j;
            if (!bool1)
            {
              this.a.mTroopTips.f();
              i = 1;
            }
          }
        }
      }
      bool3 = TroopInfo.isQidianPrivateTroop(this.a.app, this.a.sessionInfo.curFriendUin);
      if ((!bool1) && (!bool2) && (i == 0) && (!bool3)) {
        ThreadManager.getUIHandler().postDelayed(new TroopChatPie.12.2(this), 500L);
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
    if (((PlusPanel)this.a.panelManager.a(8) != null) && (paramBoolean.booleanValue())) {}
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.sessionInfo.curType == 1) && (this.a.sessionInfo.curFriendUin.equals(paramString)))
    {
      paramString = ((TroopManager)this.a.app.getManager(52)).b(this.a.sessionInfo.curFriendUin);
      if (paramString != null)
      {
        this.a.sessionInfo.curFriendNick = paramString.getTroopName();
        this.a.mTitleText.setText(this.a.sessionInfo.curFriendNick);
        if (AppSetting.c)
        {
          paramString = this.a.mTitleText.getText().toString();
          this.a.mTitleText.setContentDescription(paramString);
          this.a.getActivity().setTitle(this.a.mTitleText.getText());
        }
      }
    }
  }
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    this.a.a(paramBoolean, paramObject);
  }
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      break label15;
    }
    label15:
    label50:
    label224:
    label225:
    for (;;)
    {
      return;
      if ((this.a.sessionInfo.curType == 1000) || (this.a.sessionInfo.curType == 1020))
      {
        int i = 0;
        if (i < paramArrayList.size())
        {
          TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
          if ((localTroopMemberCardInfo != null) && (this.a.sessionInfo.curFriendUin.equals(localTroopMemberCardInfo.memberuin)))
          {
            paramArrayList = localTroopMemberCardInfo.name;
            if ((paramArrayList != null) && (!"".equals(paramArrayList))) {
              break label224;
            }
            paramArrayList = localTroopMemberCardInfo.nick;
          }
        }
        for (;;)
        {
          if ((paramArrayList == null) || ("".equals(paramArrayList))) {
            break label225;
          }
          this.a.sessionInfo.curFriendNick = paramArrayList;
          this.a.mTitleText.setText(this.a.sessionInfo.curFriendNick);
          if (!AppSetting.c) {
            break;
          }
          paramArrayList = this.a.mTitleText.getText().toString();
          this.a.mTitleText.setContentDescription(paramArrayList);
          this.a.getActivity().setTitle(this.a.mTitleText.getText());
          return;
          i += 1;
          break label50;
          break label15;
        }
      }
    }
  }
  
  protected void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if ((paramBoolean) && (this.a.sessionInfo.curType == 1) && (paramTroopInfo != null) && (this.a.sessionInfo.curFriendUin.equals(paramTroopInfo.troopuin)))
    {
      this.a.sessionInfo.curFriendNick = paramTroopInfo.getTroopName();
      this.a.mTitleText.setText(this.a.sessionInfo.curFriendNick);
      if (AppSetting.c)
      {
        paramTroopInfo = this.a.mTitleText.getText().toString();
        this.a.mTitleText.setContentDescription(paramTroopInfo);
        this.a.getActivity().setTitle(this.a.mTitleText.getText());
      }
    }
  }
  
  protected void onNotifyUpdateTitleBtnCall(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      if ((this.a.sessionInfo != null) && (this.a.sessionInfo.curFriendUin.equals(String.valueOf(l)))) {
        this.a.updateSession_updateTitleBtnCall();
      }
    }
  }
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!bftf.a(String.valueOf(paramLong1), this.a.sessionInfo.curFriendUin)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i(this.a.tag, 2, localStringBuilder.toString());
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    TroopChatPie.a(this.a, paramList);
  }
  
  protected void onOIDB0XA80_0_Ret(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.a.sessionInfo.curFriendUin.equals(paramString1)) && (this.a.app.getCurrentAccountUin().equals(paramString2)) && (paramInt1 == 1) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: cmd==1," + paramBoolean + "," + paramString1 + "," + paramString2 + "," + this.a.b);
      }
      if (!paramBoolean) {
        break label192;
      }
      this.a.app.getMessageFacade().pullRecentGroupMsg(this.a.sessionInfo.curFriendUin);
      bcef.b(this.a.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_history", 0, 0, paramString1, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: pullRecentGroupMsg");
      }
    }
    label192:
    while (this.a.b <= 0) {
      return;
    }
    this.a.c(1);
    paramString1 = this.a;
    paramString1.b -= 1;
  }
  
  protected void onPassiveExit(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a.sessionInfo.curFriendUin)))
    {
      this.a.updateSession_updateTitleRightView();
      this.a.updateSession_updateTitleBtnCall();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, String.format("onPassiveExit, troopUin: %s, reason: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    paramString = (afpr)this.a.getHelper(71);
    if (paramString != null) {
      paramString.a();
    }
  }
  
  protected void onPushTroopEnterEffect(bedr parambedr)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onPushTroopEnterEffect: troopUin = " + parambedr.b + ", data.id = " + parambedr.jdField_a_of_type_Int);
    }
    if (nmy.a().a(this.a.sessionInfo.curFriendUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "onPushTroopEnterEffect: troopUin = " + this.a.sessionInfo.curFriendUin + " isAnonymous");
      }
      return;
    }
    parambedr = this.a.a();
    parambedr.a(this.a.sessionInfo.curFriendUin);
    parambedr.a();
  }
  
  protected void onSortedTroopAppList(Boolean paramBoolean)
  {
    PlusPanel localPlusPanel = (PlusPanel)this.a.panelManager.a(8);
    if ((localPlusPanel != null) && (paramBoolean.booleanValue())) {
      localPlusPanel.c();
    }
  }
  
  protected void onTroopBatchAddFrdsReadyForTip(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject = this.a.mActivity.getIntent().getStringExtra("uin");
    QLog.i(this.a.tag, 1, String.format("troopBatchAddFrd.onTroopBatchAddFrdsReadyForTip suc_troopUin_type_intentUIn=%b_%s_%d_%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt), localObject }));
    if ((paramBoolean) && (bfic.a(paramInt)) && (paramString.equalsIgnoreCase((String)localObject)))
    {
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 5)) {
        break label129;
      }
      paramList = (TroopAddFriendTipsHelper)this.a.getHelper(28);
      if (paramList != null) {
        paramList.a(true, paramString);
      }
    }
    for (;;)
    {
      return;
      label129:
      if ((paramInt == 4) && (paramList != null) && (paramList.size() > 0))
      {
        if (!this.a.u)
        {
          localObject = (String)paramList.get(0);
          paramBoolean = this.a.a((String)localObject);
          localObject = (TroopAddFriendTipsHelper)this.a.getHelper(28);
          if (localObject != null) {
            ((TroopAddFriendTipsHelper)localObject).a(paramBoolean, paramString);
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d(this.a.tag, 2, "onTroopBatchAddFrdsReadyForTip  isScrolling = " + this.a.u + ",visible = " + paramBoolean + ",targetUins = " + paramList);
          return;
          this.a.jdField_d_of_type_JavaLangString = ((String)paramList.get(0));
          paramBoolean = false;
        }
      }
    }
  }
  
  protected void onTroopBlockStatusChanged(String paramString)
  {
    if ((this.a.sessionInfo == null) || (TextUtils.isEmpty(this.a.sessionInfo.curFriendUin))) {}
    do
    {
      do
      {
        return;
      } while (!this.a.sessionInfo.curFriendUin.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, String.format("onTroopBlockStatusChanged, troopUin: %s", new Object[] { this.a.sessionInfo.curFriendUin }));
      }
      paramString = (aftc)this.a.getHelper(76);
    } while (paramString == null);
    paramString.b();
  }
  
  protected void onTroopInfoUpdate(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.sessionInfo.curFriendUin)))
    {
      paramString = ((TroopManager)this.a.app.getManager(52)).c(paramString);
      if (paramString != null)
      {
        this.a.sessionInfo.curFriendNick = paramString.getTroopName();
        Intent localIntent = this.a.mActivity.getIntent();
        localIntent.putExtra("uinname", paramString.getTroopName());
        this.a.updateSession_updateTitle(localIntent);
        this.a.r();
        if (TroopChatPie.a(this.a) != null) {
          TroopChatPie.a(this.a).a(paramString.dwGroupClassExt, true, this.a, this.a.sessionInfo.curFriendUin);
        }
        TroopChatPie.b(this.a);
        TroopChatPie.c(this.a);
        ((bcpa)this.a.app.getManager(362)).a(this.a.sessionInfo.curFriendUin);
      }
    }
  }
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 9) && (this.a.n)) {
      QQToast.a(this.a.mActivity, 1, amtj.a(2131714282), 0).a();
    }
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 2) || (paramInt1 == 9))
    {
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "onTroopManagerSuccess, isTroopOwner =" + this.a.n);
        }
        String str = amtj.a(2131714287);
        if (this.a.n) {
          str = amtj.a(2131714285);
        }
        QQToast.a(this.a.mActivity, 2, str, 0).a();
        str = this.a.app.getCurrentUin();
        TroopChatPie.a(this.a, paramString, str);
        ((anca)this.a.app.getBusinessHandler(20)).a().a(this.a.sessionInfo.curFriendUin);
      }
    }
    else {
      return;
    }
    QQToast.a(this.a.mActivity, 1, amtj.a(2131714280), 0).a();
  }
  
  protected void onTroopMemberUpdate()
  {
    this.a.r();
    if ((this.a.mAIOGiftPanelContainer != null) && (this.a.mAIOGiftPanelContainer.a() != null)) {
      this.a.mAIOGiftPanelContainer.a().b();
    }
  }
  
  protected void onTroopNewFeedsAutoPullDown(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag + ".troop.notification_center.auto_pull_down", 2, "onTroopNewFeedsAutoPullDown, isSuc:" + paramBoolean + "troopUin" + paramString1 + ",feedsId:" + paramString2 + ",flag:" + paramInt);
    }
    if (!this.a.sessionInfo.curFriendUin.equals(paramString1)) {}
  }
  
  protected void onTroopNewFeedsComing(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) || (!TextUtils.equals(paramString, this.a.sessionInfo.curFriendUin))) {
      return;
    }
    Integer localInteger = ChatActivityUtils.a(this.a.sessionInfo.curFriendUin, this.a.app.getCurrentAccountUin());
    if ((localInteger != null) && (-1 == localInteger.intValue())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onTroopNewFeedsComing, isSuc:" + paramBoolean1 + ", troopUin=" + paramString + ",bDeleted:" + paramBoolean2 + ", isFromPush=" + paramBoolean3 + ", hasNewNotify=" + bool);
      }
      if (paramBoolean3) {
        break;
      }
      bezz.a(this.a.app, this.a.sessionInfo.curFriendUin);
      return;
    }
  }
  
  protected void onTroopRewardChangeNotify(String paramString1, String paramString2)
  {
    if (this.a.sessionInfo.curFriendUin.equals(paramString1))
    {
      List localList = this.a.listAdapter.a();
      int i = this.a.listView.getFirstVisiblePosition();
      int j = this.a.listView.getLastVisiblePosition();
      paramString1 = ((bfdi)this.a.app.getManager(152)).a(paramString1, paramString2);
      if (paramString1 != null)
      {
        int k = localList.indexOf(paramString1);
        if ((k >= i) && (k <= j)) {
          this.a.refresh(131077);
        }
      }
    }
  }
  
  protected void onUpdateGameOnlineSwitchStatus(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopChatPie.a(this.a);
    }
  }
  
  protected void onUpdateOnlineMemberList(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.a.hasDestory) || (this.a.a == null)) {}
    while ((!TextUtils.equals(paramString1, this.a.getSessionInfo().curFriendUin)) || (this.a.jdField_d_of_type_Boolean) || (afpz.a(this.a))) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.a.a(2);
      return;
    }
    paramString2 = ((bfkq)this.a.app.getManager(234)).a(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.a.setSubTitleVisable(true);
      this.a.mSubTilteText.setText(paramString2);
    }
    if (this.a.a != null)
    {
      this.a.a.a(paramString1);
      if (this.a.a.a())
      {
        this.a.a.d();
        TroopChatPie.a(this.a, true);
        return;
      }
      this.a.a.a(0);
      TroopChatPie.a(this.a, false);
      return;
    }
    TroopChatPie.a(this.a, false);
  }
  
  protected void onUpdateOnlineMemberTips(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, this.a.getSessionInfo().curFriendUin))
    {
      paramString2 = (bfkq)this.a.app.getManager(234);
      TroopChatPie.a(this.a, paramString1, true);
      if ((paramBoolean) && (this.a.mActivity != null) && (this.a.mActivity.isResume()))
      {
        long l = (paramString2.b(this.a.getSessionInfo().curFriendUin) - NetConnInfoCenter.getServerTime()) * 1000L;
        if (QLog.isColorLevel()) {
          QLog.i(this.a.tag, 2, "mGetOnlineMemberTipsRunnable, delay = " + l);
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(TroopChatPie.a(this.a));
        ThreadManager.getUIHandler().post(new TroopChatPie.12.3(this, l));
      }
    }
  }
  
  protected void onUpdateRecentList()
  {
    afqv localafqv = (afqv)this.a.getHelper(73);
    if (localafqv != null) {
      localafqv.a();
    }
    TroopChatPie.c(this.a);
  }
  
  protected void onUpdateTroopAIOTips()
  {
    afqv localafqv = (afqv)this.a.getHelper(73);
    if (localafqv != null) {
      localafqv.a();
    }
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    aftc localaftc = (aftc)this.a.getHelper(76);
    if (localaftc != null) {
      localaftc.b();
    }
  }
  
  protected void onUpdateTroopMiniAppEntranceRedPoint(String paramString, boolean paramBoolean) {}
  
  protected void onUpdateTroopUnreadMsg(boolean paramBoolean1, boolean paramBoolean2, List<bfkg> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, new Object[] { "onUpdateTroopUnreadMsg. isSuc=", Boolean.valueOf(paramBoolean1), ", isPush=", Boolean.valueOf(paramBoolean2) });
    }
    if ((!paramBoolean1) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    label393:
    for (;;)
    {
      label72:
      bfkg localbfkg;
      if (paramList.hasNext())
      {
        localbfkg = (bfkg)paramList.next();
        if (!TextUtils.equals(this.a.sessionInfo.curFriendUin, localbfkg.jdField_a_of_type_JavaLangString)) {
          continue;
        }
        if (localbfkg.jdField_a_of_type_Long == 1104445552L)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.a.tag, 2, new Object[] { "onUpdateTroopUnreadMsg homework. num=", Integer.valueOf(localbfkg.b) });
          }
          if (!TroopInfo.isHomeworkTroop(this.a.app, this.a.sessionInfo.curFriendUin)) {
            break label314;
          }
          if ((TroopChatPie.a(this.a) != null) && ((TroopChatPie.a(this.a).a instanceof beqp))) {
            ((beqp)TroopChatPie.a(this.a).a).a(false, this.a);
          }
        }
      }
      for (;;)
      {
        if (localbfkg.jdField_a_of_type_Long != 2L) {
          break label393;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a.tag, 2, "receive troop album  red dot, push=" + paramBoolean2 + ", num=" + localbfkg.b);
        }
        this.a.uiHandler.obtainMessage(85).sendToTarget();
        break label72;
        break;
        label314:
        if (localbfkg.jdField_a_of_type_Long == 1106611799L)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.a.tag, 2, "receive game feed red dot, push=" + paramBoolean2 + ", num=" + localbfkg.b);
          }
          this.a.uiHandler.obtainMessage(85).sendToTarget();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjq
 * JD-Core Version:    0.7.0.1
 */