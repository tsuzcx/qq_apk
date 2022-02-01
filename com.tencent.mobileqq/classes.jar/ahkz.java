import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;

public class ahkz
  extends BaseChatPie
{
  protected amwl a;
  private anax jdField_a_of_type_Anax = new ahlc(this);
  bily jdField_a_of_type_Bily;
  private binf jdField_a_of_type_Binf = new ahle(this);
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public ahkz(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Amwl = new ahld(this);
  }
  
  public static Serializable a(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerChatPie", 2, String.format(Locale.getDefault(), "hasWzryInfo [%d, %b, %b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getIntent();
      localObject1 = localObject2;
      if (paramContext != null)
      {
        localObject1 = localObject2;
        if (!paramBoolean1)
        {
          localObject1 = localObject2;
          if (!paramBoolean2)
          {
            localObject1 = localObject2;
            if (paramInt == 1022)
            {
              localObject1 = localObject2;
              if (paramContext.hasExtra("param_wzry_data")) {
                localObject1 = paramContext.getSerializableExtra("param_wzry_data");
              }
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    acvv.e(this.app, this.sessionInfo);
  }
  
  private void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "" + paramInt;
      }
      QQToast.a(this.mActivity, str, 0).b(this.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.mActivity, amtj.a(2131713602), 0).b(this.mActivity.getTitleBarHeight());
  }
  
  private void a(Intent paramIntent)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "From chatActivity : accost Sig--->" + HexUtil.bytes2HexStr(arrayOfByte));
    }
    if (arrayOfByte != null) {
      this.app.getMsgCache().h(this.sessionInfo.curFriendUin, arrayOfByte);
    }
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
      acvv.f(this.app, this.sessionInfo);
    }
    do
    {
      do
      {
        return;
        paramIntent = ((amsw)this.app.getManager(51)).b(this.sessionInfo.curFriendUin);
        if (paramIntent != null) {
          break;
        }
      } while (!StringUtil.verifyUin(this.sessionInfo.curFriendUin));
      ((amov)this.app.getBusinessHandler(2)).a(this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, (byte)1, 0);
      return;
    } while ((paramIntent == null) || (paramIntent.strCertificationInfo == null) || (paramIntent.strCertificationInfo.equals("")));
    acvv.f(this.app, this.sessionInfo);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.sessionInfo.curFriendUin)) || (paramInt1 != this.sessionInfo.curType))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong + " errorCode " + paramInt2);
    }
    if (paramInt1 == 1005) {
      e(paramInt2);
    }
    for (;;)
    {
      refresh(196608);
      return;
      if (paramInt1 == 1004) {
        d(paramInt2);
      } else if (paramInt1 == 1000) {
        a(paramString1, paramInt2, paramString2);
      } else if (paramInt1 == 1020) {
        c(paramInt2);
      } else if (paramInt1 == 1006) {
        b(paramInt2);
      } else if (paramInt1 == 1022) {
        a(paramInt2);
      } else if (paramInt1 == 1023) {
        QQToast.a(this.mActivity, "errorCode" + paramInt2, 0).b(this.mActivity.getTitleBarHeight());
      } else if (paramInt1 == 1025) {
        a(paramInt2, paramString2);
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = String.format(this.mActivity.getString(2131692874), new Object[] { this.sessionInfo.curFriendNick });
    }
    switch (paramInt)
    {
    default: 
      if (paramInt > 100) {
        QQToast.a(this.mActivity, str, 0).b(this.mActivity.getTitleBarHeight());
      }
      return;
    case 102: 
    case 103: 
      QQToast.a(this.mActivity, str, 0).b(this.mActivity.getTitleBarHeight());
      bcef.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_temp", 0, 0, paramString1, "", "", "");
      return;
    }
    QQToast.a(this.mActivity, str, 0).b(this.mActivity.getTitleBarHeight());
  }
  
  private void b()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((avsy)this.app.getManager(11)).a();
    if (localRespondQueryQQBindingStat != null) {
      this.sessionInfo.phoneNum = (localRespondQueryQQBindingStat.nationCode + localRespondQueryQQBindingStat.mobileNo);
    }
    this.sessionInfo.contactUin = ContactUtils.getUinByPhoneNum(this.app, this.sessionInfo.curFriendUin);
    if ((this.sessionInfo.contactUin == null) && (QLog.isColorLevel())) {
      QLog.e(this.tag, 2, "contactUin == null");
    }
    this.mSingleTitle = false;
    this.showOnlineStatus = true;
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1600: 
      QQToast.a(this.mActivity, this.mActivity.getString(2131691936), 0).b(this.mActivity.getTitleBarHeight());
      return;
    case 1601: 
      QQToast.a(this.mActivity, this.mActivity.getString(2131691936), 0).b(this.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.mActivity, this.mActivity.getString(2131691935), 0).b(this.mActivity.getTitleBarHeight());
  }
  
  private void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "From chatActivity : sameState Sig--->" + HexUtil.bytes2HexStr(paramIntent));
    }
    if (paramIntent != null) {
      this.app.getMsgCache().g(this.sessionInfo.curFriendUin, paramIntent);
    }
  }
  
  private void c()
  {
    Object localObject = this.mActivity.getIntent();
    if (localObject == null) {}
    do
    {
      String str;
      do
      {
        return;
        str = ((Intent)localObject).getStringExtra("gid");
      } while (!ChatActivityUtils.a(this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, str));
      localObject = bchh.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
    } while (localObject == null);
    bfyv.a(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, (AbsStructMsg)localObject, null);
    if (((amsw)this.app.getManager(51)).b(this.sessionInfo.curFriendUin))
    {
      bcef.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "1", "", "", "");
      return;
    }
    bcef.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "", "1", "", "");
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Object localObject = (HotChatManager)this.app.getManager(60);
    localObject = this.mActivity.getString(2131697212);
    QQToast.a(this.mActivity, (CharSequence)localObject, 0).b(this.mActivity.getTitleBarHeight());
  }
  
  private void c(Intent paramIntent)
  {
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
      acvv.f(this.app, this.sessionInfo);
    }
    do
    {
      do
      {
        return;
        paramIntent = ((amsw)this.app.getManager(51)).b(this.sessionInfo.curFriendUin);
        if (paramIntent != null) {
          break;
        }
      } while (!StringUtil.verifyUin(this.sessionInfo.curFriendUin));
      ((amov)this.app.getBusinessHandler(2)).a(this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, (byte)1, 0);
      return;
    } while ((paramIntent == null) || (paramIntent.strCertificationInfo == null) || (paramIntent.strCertificationInfo.equals("")));
    acvv.f(this.app, this.sessionInfo);
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str = String.format(this.mActivity.getString(2131691641), new Object[] { this.sessionInfo.curFriendNick });
    QQToast.a(this.mActivity, str, 0).b(this.mActivity.getTitleBarHeight());
  }
  
  private void d(Intent paramIntent)
  {
    this.sessionInfo.realTroopUin = paramIntent.getStringExtra("troop_code");
    if ((this.sessionInfo.realTroopUin == null) || (this.sessionInfo.realTroopUin.trim().length() == 0))
    {
      paramIntent = (TroopManager)this.app.getManager(52);
      this.sessionInfo.realTroopUin = paramIntent.b(this.sessionInfo.troopUin);
      if (this.sessionInfo.realTroopUin == null)
      {
        paramIntent = (HotChatManager)this.app.getManager(60);
        this.sessionInfo.realTroopUin = paramIntent.a(this.sessionInfo.troopUin);
      }
    }
  }
  
  private void e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QQToast.a(this.mActivity, this.mActivity.getString(2131719666), 0).b(this.mActivity.getTitleBarHeight());
    case 55: 
      return;
    }
    QQToast.a(this.mActivity, this.mActivity.getString(2131719665), 0).b(this.mActivity.getTitleBarHeight());
  }
  
  public bily a()
  {
    if (this.jdField_a_of_type_Bily == null) {
      this.jdField_a_of_type_Bily = ((bily)this.app.getManager(165));
    }
    return this.jdField_a_of_type_Bily;
  }
  
  public void a()
  {
    if (this.sessionInfo.curType == 1006)
    {
      Intent localIntent = AddFriendLogicActivity.a(this.mActivity, 2, this.sessionInfo.curFriendUin, null, 3006, 12, this.sessionInfo.curFriendNick, null, null, null, null);
      this.mActivity.startActivity(localIntent);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addObserver(this.jdField_a_of_type_Amwl);
    this.app.addObserver(this.jdField_a_of_type_Anax);
    this.app.addObserver(this.jdField_a_of_type_Binf);
  }
  
  public void doOnDestroy()
  {
    if (this.mTitleBtnCall != null) {
      this.mTitleBtnCall.setOnClickListener(null);
    }
    if ((this.jdField_a_of_type_Bily != null) && (this.sessionInfo.curType == 1025)) {
      this.jdField_a_of_type_Bily.a(this.sessionInfo.curFriendUin, this.sessionInfo.curType);
    }
    if ((this.jdField_a_of_type_Bily != null) && (this.jdField_a_of_type_Bily.a(this.sessionInfo.curFriendUin))) {
      ((bing)this.app.getBusinessHandler(85)).a(null, this.sessionInfo.curFriendUin, false);
    }
    if (nns.b(this.sessionInfo.curFriendUin)) {
      if (this.jdField_a_of_type_Bily != null) {
        break label211;
      }
    }
    label211:
    for (String str = "";; str = this.jdField_a_of_type_Bily.a(this.sessionInfo.curFriendUin))
    {
      bcef.b(this.app, "dc00899", "Qidian", this.sessionInfo.curFriendUin, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.4.8", "");
      if (KplRoleInfo.isKplPie(this))
      {
        ((amsw)this.app.getManager(51)).jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "kpl global has been remove, because StrangerChatPie close");
        }
      }
      super.doOnDestroy();
      return;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    amsw localamsw = (amsw)this.app.getManager(51);
    if (KplRoleInfo.isKplPie(this))
    {
      localamsw.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "open kpl session, mark global flag");
      }
    }
    do
    {
      return;
      localamsw.jdField_a_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.d("KplMessage", 2, "not open kpl session, reset global flag");
  }
  
  public boolean enableBlur()
  {
    boolean bool = false;
    if ((this.isThemeDefault) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  public boolean isNeedUpdate(MessageRecord paramMessageRecord)
  {
    return (this.sessionInfo.curFriendUin.equals(paramMessageRecord.frienduin)) && ((abwz.v(this.sessionInfo.curType)) || (this.sessionInfo.curType == paramMessageRecord.istroop) || ((abwz.d(this.sessionInfo.curType)) && (abwz.d(paramMessageRecord.istroop))));
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    if ((this.d) && (this.mActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (ahll.a(this.app, this.mActivity, this.sessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    super.leftBackEvent(paramBoolean);
  }
  
  public boolean onBackEvent()
  {
    if ((this.d) && (this.mActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (ahll.a(this.app, this.mActivity, this.sessionInfo))) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
    if (nns.b(this.sessionInfo.curFriendUin))
    {
      showC2BTips();
      if (this.jdField_a_of_type_Bily != null) {
        break label94;
      }
    }
    label94:
    for (String str = "";; str = this.jdField_a_of_type_Bily.a(this.sessionInfo.curFriendUin))
    {
      bcef.b(this.app, "dc00899", "Qidian", this.sessionInfo.curFriendUin, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), str, "8.4.8", "");
      ((avnl)this.app.getManager(303)).a(this.sessionInfo, this);
      return;
    }
  }
  
  public void onShow_otherThings()
  {
    if ((this.sessionInfo.curType == 1006) && (!this.friendListHandler.isGetOnlineListRecently()) && (!this.friendListHandler.shouldGetOnlineInfo())) {
      this.friendListHandler.getOnlineInfo(this.sessionInfo.curFriendUin, true);
    }
    if (this.sessionInfo.curType == 10004)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label132;
      }
      this.jdField_b_of_type_JavaLangString = ajvu.a("", "strangerchat_ext", "");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        ahqc localahqc = new ahqc(this.mContext);
        this.mTipsMgr.a(localahqc, new Object[] { this.jdField_b_of_type_JavaLangString });
      }
      super.onShow_otherThings();
      return;
      label132:
      ajvu.a("", "strangerchat_ext", this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void openOptionActivity()
  {
    if ((bftf.b(this.sessionInfo.curFriendUin)) && (bftf.a(this.mContext))) {
      return;
    }
    Intent localIntent = new Intent(this.mActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
    localIntent.putExtra("uinname", this.sessionInfo.curFriendNick);
    localIntent.putExtra("uintype", this.sessionInfo.curType);
    boolean bool;
    Object localObject;
    if (this.sessionInfo.curType == 1006)
    {
      if ((this.sessionInfo.contactUin == null) || (this.sessionInfo.contactUin.equals("")))
      {
        bool = true;
        localIntent.putExtra("isShieldMsgSwitchUnClickable", bool);
      }
    }
    else
    {
      if ((1000 == this.sessionInfo.curType) || (1004 == this.sessionInfo.curType)) {
        localIntent.putExtra("troop_uin", this.sessionInfo.troopUin);
      }
      localIntent.putExtra("add_friend_source_id", this.sessionInfo.addFriendSourceId);
      localIntent.putExtra("real_troop_uin", this.sessionInfo.realTroopUin);
      localObject = a(this.mContext, this.sessionInfo.curType, false, false);
      if (localObject == null) {
        break label265;
      }
      localIntent.putExtra("param_wzry_data", (Serializable)localObject);
      localIntent.putExtra("uinname", ((KplRoleInfo.WZRYUIinfo)localObject).nick);
    }
    for (;;)
    {
      this.mActivity.startActivityForResult(localIntent, 2000);
      return;
      bool = false;
      break;
      label265:
      if (KplRoleInfo.isKplPie(this))
      {
        localObject = this.sessionInfo.curFriendUin;
        String str = KplRoleInfo.WZRYUIinfo.buildNickName(this.sessionInfo.curFriendNick, KplRoleInfo.getGameNickByUin(this.app, (String)localObject));
        localIntent.putExtra("param_wzry_data", KplRoleInfo.WZRYUIinfo.createInfo((String)localObject, str, KplRoleInfo.getKplVerifyMsg(this.app), 0, 0));
        localIntent.putExtra("uinname", str);
      }
    }
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Amwl);
    this.app.removeObserver(this.jdField_a_of_type_Anax);
    this.app.removeObserver(this.jdField_a_of_type_Binf);
  }
  
  public void send()
  {
    super.send();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      c();
    }
    if (this.c)
    {
      ahll.a(this.app, this.mActivity, this.sessionInfo, this.c);
      this.c = false;
    }
  }
  
  public void setTag()
  {
    this.tag = "StrangerChatPie";
  }
  
  public boolean showorhideAddFriend()
  {
    if (isFullScreenMode()) {
      return false;
    }
    if (this.isJubaoMode) {
      return false;
    }
    if (this.sessionInfo.curType == 1006)
    {
      PhoneContact localPhoneContact = ((avsy)this.app.getManager(11)).c(this.sessionInfo.curFriendUin);
      String str2;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str2 = this.tag;
        localStringBuilder = new StringBuilder().append("StrangerChatPie.showorhideAddFriend curFriendUin=").append(this.sessionInfo.curFriendUin).append(" contact=");
        if (localPhoneContact != null) {
          break label126;
        }
      }
      label126:
      for (String str1 = "null";; str1 = "real")
      {
        QLog.d(str2, 2, str1);
        if (localPhoneContact == null) {
          break;
        }
        return false;
      }
    }
    if (this.sessionInfo.curType == 10004) {
      return false;
    }
    return !((amsw)this.app.getManager(51)).b(this.sessionInfo.curFriendUin);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (this.sessionInfo.curFriendUin.equals(paramObservable.frienduin)) && ((this.sessionInfo.curType == paramObservable.istroop) || ((abwz.d(this.sessionInfo.curType)) && (abwz.d(paramObservable.istroop)))) && ((this.sessionInfo.curType == 1001) || (this.sessionInfo.curType == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.app.getMessageFacade().getIncomingMsg();
        if ((paramObservable != null) && ((paramObservable.istroop == 1001) || (paramObservable.istroop == 10002)) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.mActivity.getApplicationContext(), paramObservable.action);
        }
      }
    }
  }
  
  public void updateFriendNick()
  {
    Object localObject;
    if ((this.sessionInfo.curType == 1000) || (this.sessionInfo.curType == 1020) || (this.sessionInfo.curType == 1004)) {
      localObject = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.realTroopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
    }
    for (;;)
    {
      this.sessionInfo.curFriendNick = ((String)localObject);
      return;
      if (this.sessionInfo.curType == 1006)
      {
        localObject = ((avsy)this.app.getManager(11)).c(this.sessionInfo.curFriendUin);
        if (localObject != null) {
          localObject = ((PhoneContact)localObject).name;
        } else if (this.sessionInfo.contactUin != null) {
          localObject = ContactUtils.getDisplayName(this.app, this.sessionInfo.contactUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
        } else {
          localObject = this.sessionInfo.curFriendUin;
        }
      }
      else
      {
        String str = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
        localObject = str;
        if (this.sessionInfo.curType == 1005) {
          if (str != null)
          {
            localObject = str;
            if (!str.equals(this.sessionInfo.curFriendUin)) {}
          }
          else
          {
            this.friendListHandler.getFriendInfo(this.sessionInfo.curFriendUin);
            localObject = str;
          }
        }
      }
    }
  }
  
  public void updateOnlineStatus()
  {
    if ((this.showOnlineStatus) && ((this.sessionInfo.curType != 1025) || (!a().a(this.sessionInfo.curFriendUin))) && (this.sessionInfo.curType == 1006))
    {
      Object localObject = ((avsy)this.app.getManager(11)).c(this.sessionInfo.curFriendUin);
      if ((localObject == null) || (ContactUtils.getFriendStatus(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) {
        break label126;
      }
      localObject = ContactUtils.getStatusName((PhoneContact)localObject);
      setSubTitleVisable(true);
      this.mSubTilteText.setText((CharSequence)localObject);
      if (jdField_a_of_type_Boolean) {
        this.mSubTilteText.setContentDescription((CharSequence)localObject);
      }
    }
    label126:
    do
    {
      do
      {
        return;
      } while (this.mSubTilteText.getVisibility() != 0);
      setSubTitleVisable(false);
    } while (this.mTipsMgr.a() != 5);
    ahpm.c(this.app, this.sessionInfo.curFriendUin);
    this.mTipsMgr.a();
  }
  
  public void updateSession(Intent paramIntent)
  {
    super.updateSession(paramIntent);
    if (this.sessionInfo.curType == 1025)
    {
      paramIntent = paramIntent.getByteArrayExtra("sigt");
      if (paramIntent != null)
      {
        this.app.getMsgCache().d(this.sessionInfo.curFriendUin, paramIntent);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.tag, 4, "updateSession()--AIO 已保存 sigt");
        }
      }
      if (a().a.containsKey(this.sessionInfo.curFriendUin)) {
        a().a(this.sessionInfo.curFriendUin, true);
      }
      if (a().a(this.sessionInfo.curFriendUin)) {
        ((FriendListHandler)this.app.getBusinessHandler(1)).getFriendInfo(this.sessionInfo.curFriendUin);
      }
    }
    if ((this.sessionInfo.curType == 1004) && (QLog.isColorLevel())) {
      QLog.i("addFriendTag", 4, String.format(Locale.getDefault(), "BaseChatPie addFriend uin: %s troopuin: %s sourceId: %d", new Object[] { this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, Integer.valueOf(this.sessionInfo.addFriendSourceId) }));
    }
  }
  
  public void updateSession_business(Intent paramIntent)
  {
    super.updateSession_business(paramIntent);
    bfzg.a(null, "AIO_updateSession_business");
    if ((this.sessionInfo.curType == 1000) || (this.sessionInfo.curType == 1020)) {
      d(paramIntent);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("fromSencondhandCommunity", false);
      this.d = paramIntent.getBooleanExtra("from3rdApp", false);
      this.e = paramIntent.getBooleanExtra("from_wpa_for_crm", false);
      this.c = ahll.a(this.app, this.sessionInfo, paramIntent);
      bfzg.a("AIO_updateSession_business", null);
      return;
      if (this.sessionInfo.curType == 1004)
      {
        this.sessionInfo.realTroopUin = this.sessionInfo.troopUin;
      }
      else if (this.sessionInfo.curType == 1006)
      {
        b();
      }
      else if (this.sessionInfo.curType == 1003)
      {
        c(paramIntent);
      }
      else if (this.sessionInfo.curType == 1009)
      {
        b(paramIntent);
      }
      else if ((this.sessionInfo.curType == 1001) || (this.sessionInfo.curType == 10002))
      {
        a(paramIntent);
      }
      else
      {
        byte[] arrayOfByte;
        if (this.sessionInfo.curType == 10004)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_movie_sig");
          if (arrayOfByte != null) {
            this.app.getMsgCache().j(this.sessionInfo.curFriendUin, arrayOfByte);
          }
          this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("strangerchat_ext");
        }
        else if (this.sessionInfo.curType == 1010)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.app.getMsgCache().l(this.sessionInfo.curFriendUin, arrayOfByte);
          }
        }
        else if (this.sessionInfo.curType == 10008)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.app.getMsgCache().f(this.sessionInfo.curFriendUin, this.app.getCurrentUin(), arrayOfByte);
          }
        }
        else if (this.sessionInfo.curType == 10010)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.app.getMsgCache().p(this.sessionInfo.curFriendUin, arrayOfByte);
          }
        }
        else if (this.sessionInfo.curType == 10009)
        {
          arrayOfByte = paramIntent.getByteArrayExtra("rich_date_sig");
          if (arrayOfByte != null) {
            this.app.getMsgCache().e(this.sessionInfo.curFriendUin, this.app.getCurrentUin(), arrayOfByte);
          }
        }
      }
    }
  }
  
  public void updateSession_updatePanel()
  {
    super.updateSession_updatePanel();
    if (this.sessionInfo.curType == 1003) {
      this.panelicons.setChildVisible(8, 8);
    }
  }
  
  public boolean updateSession_updateSimpleBar()
  {
    return (this.sessionInfo.curType != 1006) && (this.sessionInfo.curType != 1000) && (this.sessionInfo.curType != 10004) && (this.sessionInfo.curType != 1004) && (this.sessionInfo.curType != 10008);
  }
  
  public void updateSession_updateSubTitle()
  {
    if (this.showOnlineStatus) {
      updateOnlineStatus();
    }
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if ((this.sessionInfo.curType != 1000) && (this.sessionInfo.curType != 1020) && (this.sessionInfo.curType != 1004)) {
        break label124;
      }
      paramIntent = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.realTroopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
    }
    for (;;)
    {
      this.sessionInfo.curFriendNick = paramIntent;
      this.mTitleText.setText(this.sessionInfo.curFriendNick);
      this.mTitleText.setOnClickListener(new ahla(this));
      return;
      label124:
      if (this.sessionInfo.curType == 1006)
      {
        paramIntent = ((avsy)this.app.getManager(11)).c(this.sessionInfo.curFriendUin);
        if (paramIntent != null) {
          paramIntent = paramIntent.name;
        } else if (this.sessionInfo.contactUin != null) {
          paramIntent = ContactUtils.getDisplayName(this.app, this.sessionInfo.contactUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
        } else {
          paramIntent = this.sessionInfo.curFriendUin;
        }
      }
      else
      {
        str = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
        if (str != null)
        {
          paramIntent = str;
          if (!str.equals(this.sessionInfo.curFriendUin)) {}
        }
        else if ((this.sessionInfo.curType != 1005) && (this.sessionInfo.curType != 1025) && (this.sessionInfo.curType != 10004))
        {
          paramIntent = str;
          if (this.sessionInfo.curType != 10010) {}
        }
        else
        {
          this.friendListHandler.getFriendInfo(this.sessionInfo.curFriendUin);
          paramIntent = str;
        }
      }
    }
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    this.mTitleBtnCall.setOnClickListener(new ahlb(this));
    if ((ChatActivityUtils.b(this.app, this.sessionInfo)) || (npt.a(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType)) || (this.sessionInfo.curType == 1)) {
      if (maq.a().a(this.app.getCurrentAccountUin()))
      {
        this.mTitleBtnCall.setVisibility(0);
        this.mTitleBtnCall.setContentDescription(this.mActivity.getResources().getString(2131697974));
      }
    }
    for (;;)
    {
      if ((this.sessionInfo.curType != 0) && (this.sessionInfo.curType != 1025)) {
        this.mTitleBtnCall.setVisibility(8);
      }
      return;
      this.mTitleBtnCall.setVisibility(8);
      continue;
      if ((this.mTitleText.getText() != null) && (this.mTitleText.getText().length() < 6)) {
        this.mTitleBtnCall.setVisibility(4);
      } else {
        this.mTitleBtnCall.setVisibility(8);
      }
    }
  }
  
  public void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    super.updateSession_updateTitleLeftView(paramIntent);
    if ((paramIntent.hasExtra("key_sub_title_from")) && ((this.sessionInfo.curType != 1025) || (!a().a(this.sessionInfo.curFriendUin))))
    {
      paramIntent = paramIntent.getStringExtra("key_sub_title_from");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (this.mSubTilteText.getVisibility() == 8) {
          setSubTitleVisable(true);
        }
        this.mSubTilteText.setText(paramIntent);
        this.mSingleTitle = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkz
 * JD-Core Version:    0.7.0.1
 */