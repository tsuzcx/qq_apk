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
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.1;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.2;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.3;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
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

public class agvm
  extends ameq
{
  public agvm(TroopChatPie paramTroopChatPie) {}
  
  protected void a()
  {
    TroopChatPie.c(this.a);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 9) && (this.a.af)) {
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, alud.a(2131715660), 0).a();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 2) || (paramInt1 == 9))
    {
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "onTroopManagerSuccess, isTroopOwner =" + this.a.af);
        }
        String str = alud.a(2131715665);
        if (this.a.af) {
          str = alud.a(2131715663);
        }
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, str, 0).a();
        str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        TroopChatPie.a(this.a, paramString, str);
        ((amdu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, alud.a(2131715658), 0).a();
  }
  
  protected void a(bbuo parambbuo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onPushTroopEnterEffect: troopUin = " + parambbuo.b + ", data.id = " + parambbuo.jdField_a_of_type_Int);
    }
    if (nav.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onPushTroopEnterEffect: troopUin = " + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " isAnonymous");
      }
      return;
    }
    parambbuo = this.a.a();
    parambbuo.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    parambbuo.a();
  }
  
  protected void a(Boolean paramBoolean)
  {
    if ((TroopChatPie.e(this.a) != null) && (paramBoolean.booleanValue())) {}
  }
  
  protected void a(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList)
  {
    if ((TroopChatPie.f(this.a) != null) && (paramBoolean.booleanValue())) {
      TroopChatPie.g(this.a).a();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
      this.a.e.setText(paramString2);
      if (AppSetting.c)
      {
        this.a.e.setContentDescription(paramString2);
        this.a.a().setTitle(paramString2);
      }
    }
  }
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (paramTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramTroopInfo.troopuin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramTroopInfo.getTroopName();
      this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.c)
      {
        paramTroopInfo = this.a.e.getText().toString();
        this.a.e.setContentDescription(paramTroopInfo);
        this.a.a().setTitle(this.a.e.getText());
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!bdeu.a(String.valueOf(paramLong1), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    ThreadManager.post(new TroopChatPie.12.1(this, paramList), 8, null, true);
  }
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if ((TroopChatPie.a(this.a) != null) && (paramTroopInfo != null) && (paramTroopInfo.troopuin.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      TroopChatPie.b(this.a).a(true);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    TroopChatPie.g(this.a).removeMessages(24);
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
      localHashMap.put("netType", bdin.a(BaseApplication.getContext()) + "");
      azri.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      do
      {
        return;
        if (paramBoolean) {
          break label405;
        }
        i = 1;
        break;
        if ((this.a.c != null) && (aupg.a().jdField_a_of_type_Int != 2)) {
          this.a.c.dismiss();
        }
        aupg.a().b.clear();
        if ((paramBoolean) && (paramObject != null))
        {
          aupg.a().b.putAll((Map)paramObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + paramObject);
          }
        }
        while (aupg.a().b.size() == 0)
        {
          QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698785, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
          }
        }
      } while (paramObject == null);
      if (aupg.a().jdField_a_of_type_Int == 6)
      {
        ((affg)TroopChatPie.a(this.a).a(11)).a((Map)paramObject, aupg.a().jdField_a_of_type_JavaUtilArrayList, aupg.a().jdField_a_of_type_Int);
        return;
      }
      ((affj)TroopChatPie.b(this.a).a(1)).a((Map)paramObject, aupg.a().jdField_a_of_type_JavaUtilArrayList, aupg.a().jdField_a_of_type_Int);
      return;
      label405:
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      paramString = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString.getTroopName();
        this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        if (AppSetting.c)
        {
          paramString = this.a.e.getText().toString();
          this.a.e.setContentDescription(paramString);
          this.a.a().setTitle(this.a.e.getText());
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    QLog.i(this.a.jdField_a_of_type_JavaLangString, 1, String.format("troopBatchAddFrd.onTroopBatchAddFrdsReadyForTip suc_troopUin_type_intentUIn=%b_%s_%d_%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt), localObject }));
    if ((paramBoolean) && (bctz.a(paramInt)) && (paramString.equalsIgnoreCase((String)localObject)))
    {
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 5)) {
        break label129;
      }
      paramList = (afgi)this.a.a(28);
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
        if (!this.a.am)
        {
          localObject = (String)paramList.get(0);
          paramBoolean = this.a.a((String)localObject);
          localObject = (afgi)this.a.a(28);
          if (localObject != null) {
            ((afgi)localObject).a(paramBoolean, paramString);
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onTroopBatchAddFrdsReadyForTip  isScrolling = " + this.a.am + ",visible = " + paramBoolean + ",targetUins = " + paramList);
          return;
          this.a.i = ((String)paramList.get(0));
          paramBoolean = false;
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, new Object[] { "onChangeGroupClassExt. oldClassExt=", Long.valueOf(paramLong1), ", newClassExt=", Long.valueOf(paramLong2) });
    }
    if (paramLong2 == 32L) {
      i = 1;
    }
    if (i != 0) {
      new bcdk(this.a.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
    }
    if ((TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramBoolean) && (paramLong1 != paramLong2) && (TroopChatPie.a(this.a) != null)) {
      TroopChatPie.a(this.a).a(paramLong2, true, this.a, paramString);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString + ".troop.notification_center.auto_pull_down", 2, "onTroopNewFeedsAutoPullDown, isSuc:" + paramBoolean + "troopUin" + paramString1 + ",feedsId:" + paramString2 + ",flag:" + paramInt);
    }
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) {}
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString2)) && (paramInt1 == 1) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: cmd==1," + paramBoolean + "," + paramString1 + "," + paramString2 + "," + this.a.r);
      }
      if (!paramBoolean) {
        break label196;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_history", 0, 0, paramString1, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: pullRecentGroupMsg");
      }
    }
    label196:
    while (this.a.r <= 0) {
      return;
    }
    this.a.C(1);
    paramString1 = this.a;
    paramString1.r -= 1;
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4)
  {
    if (paramBoolean)
    {
      if (paramInt4 == 0)
      {
        nav.a().a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, null, paramString4);
        TroopChatPie.f(this.a).postDelayed(new TroopChatPie.12.2(this), 500L);
        return;
      }
      this.a.a(3, paramString3);
      return;
    }
    this.a.a(1, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690101));
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(paramString2, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (TroopInfo.isHomeworkTroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)))
    {
      if ((!bckt.a(paramInt)) && (TroopChatPie.a(this.a) != null) && ((TroopChatPie.a(this.a).a instanceof bcgs))) {
        ((bcgs)TroopChatPie.a(this.a).a).b(this.a);
      }
      if (TroopChatPie.a(this.a) != null) {
        TroopChatPie.a(this.a).a(paramInt);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    String str1;
    if (QLog.isColorLevel())
    {
      String str2 = this.a.jdField_a_of_type_JavaLangString;
      if (paramString1 == null)
      {
        str1 = "";
        QLog.d(str2, 2, new Object[] { "onChangeTroopAIORedPoint. isSuc=", Boolean.valueOf(paramBoolean1), ", troopUin=", str1, ", type = ", paramString2, ", from0x8c2=", Boolean.valueOf(paramBoolean2) });
      }
    }
    else
    {
      if ((paramBoolean1) && (!paramBoolean2)) {
        break label101;
      }
    }
    label101:
    while ((!TextUtils.equals(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!TroopInfo.isHomeworkTroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!String.valueOf(1104445552).equals(paramString2)) || (TroopChatPie.a(this.a) == null) || (!(TroopChatPie.a(this.a).a instanceof bcgs)))
    {
      return;
      str1 = paramString1;
      break;
    }
    ((bcgs)TroopChatPie.a(this.a).a).a(false, this.a);
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) || (!TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    Integer localInteger = ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((localInteger != null) && (-1 == localInteger.intValue())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onTroopNewFeedsComing, isSuc:" + paramBoolean1 + ", troopUin=" + paramString + ",bDeleted:" + paramBoolean2 + ", isFromPush=" + paramBoolean3 + ", hasNewNotify=" + bool);
      }
      if (paramBoolean3) {
        break;
      }
      bclt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      break label15;
    }
    label15:
    label50:
    label226:
    label227:
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020))
      {
        int i = 0;
        if (i < paramArrayList.size())
        {
          TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
          if ((localTroopMemberCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localTroopMemberCardInfo.memberuin)))
          {
            paramArrayList = localTroopMemberCardInfo.name;
            if ((paramArrayList != null) && (!"".equals(paramArrayList))) {
              break label226;
            }
            paramArrayList = localTroopMemberCardInfo.nick;
          }
        }
        for (;;)
        {
          if ((paramArrayList == null) || ("".equals(paramArrayList))) {
            break label227;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramArrayList;
          this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (!AppSetting.c) {
            break;
          }
          paramArrayList = this.a.e.getText().toString();
          this.a.e.setContentDescription(paramArrayList);
          this.a.a().setTitle(this.a.e.getText());
          return;
          i += 1;
          break label50;
          break label15;
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<bcwi> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, new Object[] { "onUpdateTroopUnreadMsg. isSuc=", Boolean.valueOf(paramBoolean1), ", isPush=", Boolean.valueOf(paramBoolean2) });
    }
    if ((!paramBoolean1) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    label421:
    for (;;)
    {
      label72:
      bcwi localbcwi;
      if (paramList.hasNext())
      {
        localbcwi = (bcwi)paramList.next();
        if (!TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localbcwi.jdField_a_of_type_JavaLangString)) {
          continue;
        }
        if (localbcwi.jdField_a_of_type_Long == 1104445552L)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, new Object[] { "onUpdateTroopUnreadMsg homework. num=", Integer.valueOf(localbcwi.b) });
          }
          if (!TroopInfo.isHomeworkTroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label328;
          }
          if ((TroopChatPie.a(this.a) != null) && ((TroopChatPie.a(this.a).a instanceof bcgs))) {
            ((bcgs)TroopChatPie.a(this.a).a).a(false, this.a);
          }
        }
      }
      for (;;)
      {
        if (localbcwi.jdField_a_of_type_Long != 2L) {
          break label421;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "receive troop album  red dot, push=" + paramBoolean2 + ", num=" + localbcwi.b);
        }
        Message localMessage = TroopChatPie.c(this.a).obtainMessage(85);
        localMessage.arg1 = localbcwi.b;
        localMessage.sendToTarget();
        break label72;
        break;
        label328:
        if (localbcwi.jdField_a_of_type_Long == 1106611799L)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "receive game feed red dot, push=" + paramBoolean2 + ", num=" + localbcwi.b);
          }
          localMessage = TroopChatPie.b(this.a).obtainMessage(85);
          localMessage.arg1 = localbcwi.b;
          localMessage.sendToTarget();
        }
      }
    }
  }
  
  protected void b()
  {
    this.a.bH();
    if ((TroopChatPie.a(this.a) != null) && (TroopChatPie.b(this.a).a() != null)) {
      TroopChatPie.c(this.a).a().b();
    }
  }
  
  protected void b(Boolean paramBoolean)
  {
    if ((TroopChatPie.h(this.a) != null) && (paramBoolean.booleanValue())) {
      TroopChatPie.i(this.a).a();
    }
  }
  
  protected void b(String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) && (!this.a.N)) {
      this.a.b(1);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.a.z();
      this.a.r();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, String.format("onPassiveExit, troopUin: %s, reason: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    this.a.a(paramBoolean, paramObject);
  }
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopChatPie.a(this.a);
    }
  }
  
  protected void c(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 0);
    boolean bool = localSharedPreferences.getBoolean("HomeworkIcon_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    if (!TextUtils.isEmpty(paramString)) {
      i = 1;
    }
    if (((bool) && (i == 0)) || ((!bool) && (i != 0)))
    {
      if (i != 0) {
        break label149;
      }
      localSharedPreferences.edit().remove("HomeworkIcon_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).commit();
    }
    for (;;)
    {
      if (TroopChatPie.c(this.a) != null) {
        TroopChatPie.d(this.a).a();
      }
      return;
      label149:
      localSharedPreferences.edit().putBoolean("HomeworkIcon_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).commit();
    }
  }
  
  protected void c(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1))
    {
      List localList = this.a.jdField_a_of_type_Aeqo.a();
      int i = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int j = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      paramString1 = ((bcpc)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(paramString1, paramString2);
      if (paramString1 != null)
      {
        int k = localList.indexOf(paramString1);
        if ((k >= i) && (k <= j)) {
          this.a.e(131077);
        }
      }
    }
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
        this.a.r();
      }
    }
  }
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, this.a.a().jdField_a_of_type_JavaLangString))
    {
      paramString2 = (bcws)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      TroopChatPie.a(this.a, paramString1, true);
      if ((paramBoolean) && (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()))
      {
        long l = (paramString2.b(this.a.a().jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime()) * 1000L;
        if (QLog.isColorLevel()) {
          QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "mGetOnlineMemberTipsRunnable, delay = " + l);
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(TroopChatPie.a(this.a));
        ThreadManager.getUIHandler().post(new TroopChatPie.12.4(this, l));
      }
    }
  }
  
  protected void c(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      TroopChatPie.a(this.a);
    }
  }
  
  protected void d(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramString = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
      if (paramString != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString.getTroopName();
        Intent localIntent = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
        localIntent.putExtra("uinname", paramString.getTroopName());
        this.a.b(localIntent);
        this.a.bH();
        if (TroopChatPie.a(this.a) != null) {
          TroopChatPie.a(this.a).a(paramString.dwGroupClassExt, true, this.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        TroopChatPie.b(this.a);
        TroopChatPie.c(this.a);
      }
    }
  }
  
  protected void d(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.a.N) || (this.a.jdField_a_of_type_Bcwj == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (!TextUtils.equals(paramString1, this.a.a().jdField_a_of_type_JavaLangString));
      bool1 = ((atpl)this.a.a(33)).c();
      bool2 = ((afgf)this.a.a(43)).c();
    } while ((this.a.V) || (bool1) || (bool2));
    if (!paramBoolean)
    {
      this.a.jdField_a_of_type_Bcwj.a(2);
      return;
    }
    paramString2 = ((bcws)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.a.c(true);
      this.a.f.setText(paramString2);
    }
    if (this.a.jdField_a_of_type_Bcwj != null)
    {
      this.a.jdField_a_of_type_Bcwj.a(paramString1);
      if (this.a.jdField_a_of_type_Bcwj.a())
      {
        this.a.jdField_a_of_type_Bcwj.d();
        TroopChatPie.a(this.a, true);
        return;
      }
      this.a.jdField_a_of_type_Bcwj.a(0);
      TroopChatPie.a(this.a, false);
      return;
    }
    TroopChatPie.a(this.a, false);
  }
  
  protected void d(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_Bbqg == null);
      bool1 = this.a.jdField_a_of_type_Bbqg.a();
      bool2 = this.a.jdField_a_of_type_Bbqg.d();
      int j = 0;
      int i = j;
      if (paramList != null)
      {
        i = j;
        if (paramList.size() > 0)
        {
          this.a.jdField_a_of_type_Bbqg.a(paramList);
          i = j;
          if (!bool2)
          {
            i = j;
            if (!bool1)
            {
              this.a.jdField_a_of_type_Bbqg.f();
              i = 1;
            }
          }
        }
      }
      bool3 = TroopInfo.isQidianPrivateTroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((!bool1) && (!bool2) && (i == 0) && (!bool3)) {
        ThreadManager.getUIHandler().postDelayed(new TroopChatPie.12.3(this), 500L);
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
  
  protected void e(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.a.z();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, String.format("onAddTroopSuccess, troopUin: %s", new Object[] { paramString }));
    }
  }
  
  protected void e(boolean paramBoolean, String paramString)
  {
    if (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      TroopChatPie.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvm
 * JD-Core Version:    0.7.0.1
 */