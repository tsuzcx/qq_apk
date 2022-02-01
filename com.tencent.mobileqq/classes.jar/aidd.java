import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.9;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class aidd
  extends BaseChatPie
{
  int jdField_a_of_type_Int = 0;
  anvi jdField_a_of_type_Anvi = new aide(this);
  protected anyz a;
  aodm jdField_a_of_type_Aodm = new aidf(this);
  axpz jdField_a_of_type_Axpz = new aidg(this);
  protected axti a;
  protected TroopGiftPanelForNearby a;
  ntf jdField_a_of_type_Ntf = new aidh(this);
  byte[] jdField_a_of_type_ArrayOfByte = null;
  public int b;
  String b;
  public boolean b;
  String c;
  public boolean c;
  public String d;
  protected boolean d;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  protected boolean h = true;
  
  public aidd(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Anyz = new aidn(this);
    this.jdField_c_of_type_JavaLangString = this.mActivity.getIntent().getStringExtra("from_where_to_aio");
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a()
  {
    if (getActivity().getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", this.f);
      localIntent.putExtra("uin", getActivity().getIntent().getStringExtra("tinyId"));
      getActivity().setResult(-1, localIntent);
    }
  }
  
  private void a(Integer paramInteger, String paramString)
  {
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 1: 
      ((axny)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.sessionInfo.curFriendUin, Integer.valueOf(1));
      if (this.h)
      {
        paramInteger = "2";
        a(paramString, Integer.valueOf(paramInteger).intValue(), new aidk(this));
        paramString = (awtp)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        localQQAppInterface = this.app;
        if (this.sessionInfo.curType != 1001) {
          break label171;
        }
        paramInteger = "0";
        label125:
        if (!paramString.a(this.sessionInfo.curFriendUin)) {
          break label177;
        }
      }
      label171:
      label177:
      for (paramString = "1";; paramString = "0")
      {
        bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "follow_aio", 0, 0, paramInteger, "0", paramString, "");
        return;
        paramInteger = "1";
        break;
        paramInteger = "1";
        break label125;
      }
    }
    ChatActivityUtils.a(this.app, this.mActivity, this.sessionInfo.curType, paramString, this.sessionInfo.phoneNum, false);
    if (this.sessionInfo.curType == 1010) {
      bdla.b(this.app, "CliOper", "", this.sessionInfo.curFriendUin, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
    QQAppInterface localQQAppInterface = this.app;
    if (this.sessionInfo.curType == 1001)
    {
      paramInteger = "0";
      if (!this.h) {
        break label315;
      }
    }
    label315:
    for (paramString = "0";; paramString = "1")
    {
      bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "block_aio", 0, 0, paramInteger, "0", paramString, "");
      return;
      paramInteger = "1";
      break;
    }
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramString));
    if (axny.a(paramString)) {}
    for (int i = 0;; i = 1)
    {
      ((aydj)this.app.getManager(QQManagerFactory.MINI_CARD_MANAGER)).a(localArrayList, i, new aidm(this));
      return;
    }
  }
  
  private void a(String paramString, int paramInt, ntf paramntf)
  {
    NowSummaryCard.NearbyUserFollowReq localNearbyUserFollowReq = new NowSummaryCard.NearbyUserFollowReq();
    localNearbyUserFollowReq.from.set(0);
    localNearbyUserFollowReq.id_type.set(0);
    localNearbyUserFollowReq.target_id.set(Long.valueOf(paramString).longValue());
    localNearbyUserFollowReq.operation.set(paramInt);
    ntb.a(this.mActivity.app, paramntf, localNearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
  }
  
  MqqHandler a()
  {
    return this.uiHandler;
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addObserver(this.jdField_a_of_type_Anyz);
    this.app.addObserver(this.jdField_a_of_type_Aodm);
    this.app.addObserver(this.jdField_a_of_type_Axpz);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 2000) && (paramIntent != null)) {
      this.h = paramIntent.getBooleanExtra("follow_flag", false);
    }
    if ((paramInt1 == 12007) && (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.a(null);
    }
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    paramBoolean = super.doOnCreate(paramBoolean);
    a(this.sessionInfo.curFriendUin);
    a(this.app.getCurrentAccountUin());
    return paramBoolean;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnNewIntent_clearBusinessData()
  {
    super.doOnNewIntent_clearBusinessData();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  public boolean enableBlur()
  {
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.handleMessage(paramMessage);
    }
    this.jdField_c_of_type_Boolean = false;
    paramMessage = (String)paramMessage.obj;
    admh.a(this.app, this.mActivity, this.sessionInfo, paramMessage);
    return true;
  }
  
  public void handleRequest(Intent paramIntent, int paramInt)
  {
    super.handleRequest(paramIntent, paramInt);
  }
  
  public void hideGiftPanel()
  {
    if (this.jdField_a_of_type_Axti != null) {
      this.jdField_a_of_type_Axti.a();
    }
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  public void initTipsTaskList()
  {
    if (this.d) {
      return;
    }
    super.initTipsTaskList();
    aild localaild = new aild(this.app, this.sessionInfo, this.mTipsMgr);
    localaild.a(this.jdField_b_of_type_Int);
    this.mTipsMgr.a(localaild);
  }
  
  public boolean isNeedUpdate(MessageRecord paramMessageRecord)
  {
    return (this.sessionInfo.curFriendUin.equals(paramMessageRecord.frienduin)) && ((this.sessionInfo.curType == paramMessageRecord.istroop) || ((acnh.d(this.sessionInfo.curType)) && (acnh.d(paramMessageRecord.istroop))));
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    a();
    super.leftBackEvent(paramBoolean);
  }
  
  public boolean onBackEvent()
  {
    a();
    if ((this.jdField_a_of_type_Axti != null) && (this.jdField_a_of_type_Axti.a()))
    {
      this.jdField_a_of_type_Axti.a();
      super.onBackEvent();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onOverScrollTargetValue()
  {
    if (this.d) {
      return;
    }
    super.onOverScrollTargetValue();
  }
  
  public void onShow()
  {
    super.onShow();
    if (!this.isFromOnCreate) {
      a(this.sessionInfo.curFriendUin, Integer.valueOf("3").intValue(), this.jdField_a_of_type_Ntf);
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
    ((awtq)this.app.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(this.sessionInfo, this);
  }
  
  public void onShow_business()
  {
    super.onShow_business();
    int i;
    if ((this.sessionInfo.curType == 1001) || (this.sessionInfo.curType == 10002))
    {
      Object localObject = this.mContext;
      if (this.sessionInfo.curType != 1001) {
        break label168;
      }
      i = 2131698269;
      localObject = ((Context)localObject).getString(i);
      setSubTitleVisable(true);
      this.mSubTilteText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.mTitleLayout.setOnClickListener(null);
      this.mSubTitleLayout.setOnClickListener(null);
      this.mSubTilteText.setText((CharSequence)localObject);
      if (jdField_a_of_type_Boolean) {
        this.mSubTilteText.setContentDescription((CharSequence)localObject);
      }
      if ((this.sessionInfo.curType != 10002) || (this.app.getMsgCache().k(this.sessionInfo.curFriendUin) != null)) {
        break label175;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != -1) {
        axql.a(this.app, this.sessionInfo.curFriendUin, i);
      }
      return;
      label168:
      i = 2131694138;
      break;
      label175:
      if ((this.sessionInfo.curType == 1001) && (this.app.getMsgCache().n(this.sessionInfo.curFriendUin) == null)) {
        i = 0;
      } else {
        i = -1;
      }
    }
  }
  
  public void openOptionActivity()
  {
    Intent localIntent = new Intent(this.mActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
    localIntent.putExtra("uinname", this.sessionInfo.curFriendNick);
    localIntent.putExtra("uintype", this.sessionInfo.curType);
    localIntent.putExtra("add_friend_source_id", this.sessionInfo.addFriendSourceId);
    localIntent.putExtra("follow_flag", this.h);
    this.mActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void refreshListAdapter()
  {
    super.refreshListAdapter();
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Anyz);
    this.app.removeObserver(this.jdField_a_of_type_Aodm);
    this.app.removeObserver(this.jdField_a_of_type_Axpz);
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
  }
  
  public void returnMainFragment()
  {
    super.returnMainFragment();
  }
  
  public void send()
  {
    if (this.input != null) {}
    for (String str = this.input.getText().toString();; str = null)
    {
      super.send();
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0) && (this.jdField_b_of_type_JavaLangString.equals(str))) {
        ThreadManager.post(new NearbyChatPie.9(this, str), 5, null, false);
      }
      this.jdField_b_of_type_JavaLangString = null;
      if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals("nearby_recommend_people")) && (this.jdField_b_of_type_Boolean)) {
        ThreadManager.post(new NearbyChatPie.10(this), 1, null, false);
      }
      this.f = true;
      return;
    }
  }
  
  public void setTag()
  {
    this.tag = "NearbyChatPie";
  }
  
  public void showAddFriendAndShield()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "showAddFriendAndShield() ==== called.");
    }
    Object localObject2;
    if (this.linearLayout == null)
    {
      localObject2 = new aidj(this);
      this.linearLayout = ((LinearLayout)LayoutInflater.from(this.mContext).inflate(2131559993, null));
      this.linearLayout.setId(2131362553);
      this.linearLayout.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.app.getApplication().getResources().getDimension(2131297531));
      localLayoutParams.addRule(3, 2131376760);
      if (!this.isThemeDefault) {
        localLayoutParams.topMargin = 0;
      }
      this.addFriendTv = ((TextView)this.linearLayout.findViewById(2131373855));
      TextView localTextView = this.addFriendTv;
      if (this.h)
      {
        localObject1 = anvx.a(2131706591);
        localTextView.setText((CharSequence)localObject1);
        this.addFriendTv.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131296458));
        this.addFriendTv.setContentDescription(this.addFriendTv.getText());
        this.addFriendTv.setGravity(17);
        this.addFriendTv.setOnClickListener((View.OnClickListener)localObject2);
        this.addFriendTv.setTag(Integer.valueOf(1));
        this.shieldTV = ((TextView)this.linearLayout.findViewById(2131373856));
        this.shieldTV.setText(anvx.a(2131706593));
        this.shieldTV.setTag(Integer.valueOf(2));
        if ((this.sessionInfo.curType != 1006) || ((this.sessionInfo.contactUin != null) && (!this.sessionInfo.contactUin.equals("")))) {
          break label538;
        }
        this.shieldTV.setEnabled(false);
        this.shieldTV.setClickable(false);
        label321:
        this.shieldTV.setGravity(17);
        this.shieldTV.setTextSize(0, this.app.getApplication().getResources().getDimension(2131296458));
        this.shieldTV.setOnClickListener((View.OnClickListener)localObject2);
        if (this.sessionInfo.curType == 1001) {
          this.shieldTV.setVisibility(8);
        }
        ((RelativeLayout.LayoutParams)this.listView.getLayoutParams()).addRule(3, 2131362553);
        this.afRoot.addView(this.linearLayout, localLayoutParams);
      }
    }
    else
    {
      this.linearLayout.setVisibility(0);
      localObject1 = this.mAIORootView.findViewById(2131374261);
      if (localObject1 != null)
      {
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)this.mActivity.getResources().getDimension(2131297531) + (int)this.mActivity.getResources().getDimension(2131299080));
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = this.app;
      if (this.sessionInfo.curType != 1001) {
        break label557;
      }
    }
    label538:
    label557:
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      bdla.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_float", 0, 0, (String)localObject1, "", "", "");
      return;
      localObject1 = anvx.a(2131706590);
      break;
      this.shieldTV.setEnabled(true);
      this.shieldTV.setClickable(true);
      break label321;
    }
  }
  
  public void showGiftPanel(boolean paramBoolean)
  {
    showGiftPanel(paramBoolean, TroopGiftPanel.e);
  }
  
  public void showGiftPanel(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = (InputMethodManager)getActivity().getSystemService("input_method");
    Object localObject2 = getActivity().getWindow().peekDecorView();
    if ((localObject2 != null) && (((View)localObject2).getWindowToken() != null)) {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject2).getWindowToken(), 0);
    }
    boolean bool;
    if (this.jdField_a_of_type_Axti == null)
    {
      localObject1 = this.app;
      localObject2 = getActivity();
      aidi localaidi = new aidi(this);
      if (this.sessionInfo.curType == 10002)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby((QQAppInterface)localObject1, (Context)localObject2, localaidi, true, false, bool, this);
        this.jdField_a_of_type_Axti = new axti(this.app, getActivity(), this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.mAIORootView, false, true);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_Axti;
      if (this.sessionInfo.curType != 10002) {
        break label190;
      }
    }
    label190:
    for (paramInt = 8;; paramInt = 6)
    {
      ((axti)localObject1).a(paramBoolean, true, paramInt);
      hidePanel();
      return;
      bool = false;
      break;
    }
  }
  
  public boolean showorhideAddFriend()
  {
    awtp localawtp = (awtp)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    return (!this.h) && (!localawtp.a(this.sessionInfo.curFriendUin)) && (!isFullScreenMode());
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.istroop == 0) && (!this.g))
      {
        this.g = true;
        getActivity().runOnUiThread(new NearbyChatPie.8(this));
      }
      if ((this.sessionInfo.curType == 1010) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) && (paramObservable.isSendFromLocal()) && (bhbx.a(paramObservable.senderuin, this.app.getCurrentAccountUin())))
      {
        if (this.jdField_a_of_type_Int != 2) {
          break label328;
        }
        bdla.b(this.app, "CliOper", "", this.sessionInfo.curFriendUin, "0X8004946", "0X8004946", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      if ((!paramObservable.isSendFromLocal()) && (this.sessionInfo.curFriendUin.equals(paramObservable.frienduin)) && ((this.sessionInfo.curType == paramObservable.istroop) || ((acnh.d(this.sessionInfo.curType)) && (acnh.d(paramObservable.istroop)))) && ((this.sessionInfo.curType == 1001) || (this.sessionInfo.curType == 10002)) && (paramObservable.msgtype == -3001))
      {
        paramObservable = this.app.getMessageFacade().getIncomingMsg();
        if ((paramObservable != null) && (paramObservable.istroop == 1001) && (paramObservable.msgtype == -3001)) {
          OpenAppClient.a(this.mActivity.getApplicationContext(), paramObservable.action);
        }
      }
      if ((this.mActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
        playGiftAnimationPlayList(false);
      }
      return;
      label328:
      bdla.b(this.app, "CliOper", "", this.sessionInfo.curFriendUin, "0X8004945", "0X8004945", 0, 0, "", "", "", "");
    }
  }
  
  public void updateFriendNick()
  {
    this.sessionInfo.curFriendNick = ContactUtils.getDateNickName(this.app, this.sessionInfo.curFriendUin);
  }
  
  public void updateSession_business(Intent paramIntent)
  {
    super.updateSession_business(paramIntent);
    bhhy.a(null, "AIO_updateSession_business");
    if (this.sessionInfo.curType == 1009)
    {
      paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "From chatActivity : sameState Sig--->" + HexUtil.bytes2HexStr(paramIntent));
      }
      if (paramIntent != null) {
        this.app.getMsgCache().g(this.sessionInfo.curFriendUin, paramIntent);
      }
    }
    for (;;)
    {
      this.mCacnelSellPttPanle = this.d;
      if (-1 == this.jdField_b_of_type_Int) {
        ThreadManager.post(new NearbyChatPie.2(this), 8, null, false);
      }
      bhhy.a("AIO_updateSession_business", null);
      return;
      if ((this.sessionInfo.curType == 1001) || (this.sessionInfo.curType == 10002))
      {
        this.jdField_b_of_type_Int = paramIntent.getIntExtra("gender", -1);
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "From chatActivity : accost Sig--->" + HexUtil.bytes2HexStr(arrayOfByte));
        }
        if (arrayOfByte != null) {
          this.app.getMsgCache().h(this.sessionInfo.curFriendUin, arrayOfByte);
        }
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
          admh.f(this.app, this.sessionInfo);
        } else {
          ThreadManager.post(new NearbyChatPie.1(this), 5, null, false);
        }
      }
      else if (this.sessionInfo.curType == 1010)
      {
        this.jdField_b_of_type_Int = paramIntent.getIntExtra("gender", -1);
        this.jdField_a_of_type_Int = paramIntent.getIntExtra("dating_from_id", 0);
        paramIntent = paramIntent.getByteArrayExtra("rich_date_sig");
        if (paramIntent != null) {
          this.app.getMsgCache().l(this.sessionInfo.curFriendUin, paramIntent);
        }
      }
    }
  }
  
  public boolean updateSession_updateSimpleBar()
  {
    return (this.sessionInfo.curType != 1001) && (this.sessionInfo.curType != 10002) && (this.sessionInfo.curType != 1010);
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = ContactUtils.getDateNickName(this.app, this.sessionInfo.curFriendUin);
    }
    this.sessionInfo.curFriendNick = paramIntent;
    this.mActivity.runOnUiThread(new NearbyChatPie.3(this));
    if (QLog.isDevelopLevel()) {
      arxx.a(this.tag, new Object[] { "updateSession_updateTitle", this.sessionInfo.curFriendNick });
    }
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    if ((this.sessionInfo.curType == 1009) || (this.sessionInfo.curType == 10002) || (this.sessionInfo.curType == 1001))
    {
      super.updateSession_updateTitleBtnCall();
      return;
    }
    this.mTitleBtnCall.setOnClickListener(new aidl(this));
    if (mbl.a().a(this.app.getCurrentAccountUin()))
    {
      this.mTitleBtnCall.setVisibility(0);
      this.mTitleBtnCall.setContentDescription(this.mActivity.getResources().getString(2131698258));
      return;
    }
    this.mTitleBtnCall.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidd
 * JD-Core Version:    0.7.0.1
 */