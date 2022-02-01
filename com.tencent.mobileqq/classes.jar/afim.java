import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie.6;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie.7;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class afim
  extends BaseChatPie
{
  ahpo jdField_a_of_type_Ahpo;
  amop jdField_a_of_type_Amop = new afiq(this);
  private amrc jdField_a_of_type_Amrc = new afip(this);
  protected amwl a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bjnw a;
  private Observer jdField_a_of_type_JavaUtilObserver = new afis(this);
  
  public afim(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Amwl = new afit(this);
  }
  
  private void a(Intent paramIntent)
  {
    if (this.mAIOGiftPanelContainer != null)
    {
      TroopGiftPanel localTroopGiftPanel = this.mAIOGiftPanelContainer.a();
      if (localTroopGiftPanel != null) {
        localTroopGiftPanel.a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
      }
    }
  }
  
  private void a(String paramString)
  {
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.mActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("input_text", this.input.getEditableText().toString());
    localIntent.putExtra("input_panel_status", this.root.a());
    this.mActivity.startActivity(localIntent);
  }
  
  private void b()
  {
    amrb localamrb = (amrb)this.app.getManager(53);
    DiscussionInfo localDiscussionInfo = localamrb.a(this.sessionInfo.curFriendUin);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.sessionInfo.curFriendNick = localDiscussionInfo.discussionName;
      a(this.sessionInfo.curFriendNick, localDiscussionInfo.uin, this.mTitleText);
    }
    if (localamrb.a.containsKey(this.sessionInfo.curFriendUin)) {
      c();
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getStringExtra("result");; paramIntent = "")
    {
      if ((paramIntent != null) && (!paramIntent.equals("")))
      {
        if (NetworkUtil.isNetSupport(getActivity())) {
          ((amqx)this.app.getBusinessHandler(6)).a(Long.valueOf(this.sessionInfo.curFriendUin).longValue(), paramIntent);
        }
      }
      else {
        return;
      }
      QQToast.a(this.mContext, this.mContext.getString(2131694108), 0).b(getTitleBarHeight());
      return;
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    amrb localamrb;
    Object localObject1;
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          return;
          localamrb = (amrb)this.app.getManager(53);
          if (localamrb.a.containsKey(this.sessionInfo.curFriendUin)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.tag, 2, "DiscussionManager's discToTroopCache doesn't contain discussionUIN :" + this.sessionInfo.curFriendUin);
        return;
        localObject1 = (String[])localamrb.a.get(this.sessionInfo.curFriendUin);
      } while ((localObject1 == null) || (localObject1.length < 2));
      str1 = localObject1[0];
      str2 = localObject1[1];
    } while (this.mActivity.isFinishing());
    for (;;)
    {
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130842478);
        localObject2 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = bfvo.b((Bitmap)localObject1, 10.0F, 140, 140);
          this.jdField_a_of_type_AndroidAppDialog = bfur.a(this.mContext, (Bitmap)localObject2, ContactUtils.getDiscussionMemberName(this.app, this.sessionInfo.curFriendUin, str2) + amtj.a(2131702468), amtj.a(2131702467) + str1, this.mContext.getString(2131718436), null, new afio(this, str1), null);
          if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.mActivity.isFinishing())) {
            this.jdField_a_of_type_AndroidAppDialog.show();
          }
          localamrb.a.remove(this.sessionInfo.curFriendUin);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject2;
          break label314;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject1 = null;
      }
      label314:
      if (QLog.isColorLevel())
      {
        QLog.d(this.tag, 2, QLog.getStackTraceString(localOutOfMemoryError1));
        localObject2 = localObject1;
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    String str1 = paramIntent.getExtras().getString("member_uin");
    Object localObject = paramIntent.getExtras().getString("member_display_name");
    if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.mApolloInfo != null))
    {
      if ("0".equals(str1)) {
        return;
      }
      paramIntent = ContactUtils.getTroopMemberNameWithoutRemark(this.app, this.sessionInfo.curFriendUin, str1);
      if (!android.text.TextUtils.isEmpty(paramIntent)) {
        break label466;
      }
      paramIntent = (Intent)localObject;
    }
    label445:
    label466:
    for (;;)
    {
      paramIntent = new StringBuilder("@").append(paramIntent);
      this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = str1;
      this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = paramIntent.toString();
      this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(this.input.getText().toString());
      this.input.getText().clear();
      send(this.mApolloInfo);
      int i = 0;
      int j;
      String str2;
      String str3;
      if (android.text.TextUtils.isEmpty(this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText))
      {
        j = 2;
        i = j;
        if (!android.text.TextUtils.isEmpty(this.mApolloInfo.b))
        {
          if (this.mApolloInfo.d == 0) {
            i = 6;
          }
        }
        else
        {
          localObject = this.app;
          str1 = this.sessionInfo.curFriendUin;
          j = ApolloUtil.b(this.sessionInfo.curType);
          str2 = "" + this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
          str3 = "655_" + this.mApolloInfo.jdField_a_of_type_Int;
          if (!android.text.TextUtils.isEmpty(this.mApolloInfo.b)) {
            break label445;
          }
        }
      }
      for (paramIntent = "0";; paramIntent = this.mApolloInfo.b)
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, i, j, new String[] { str2, str3, paramIntent, this.mApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        i = j;
        if (this.mApolloInfo.d != 1) {
          break;
        }
        i = 7;
        break;
        if (android.text.TextUtils.isEmpty(this.mApolloInfo.b))
        {
          i = 3;
          break;
        }
        if (this.mApolloInfo.d == 0)
        {
          i = 4;
          break;
        }
        if (this.mApolloInfo.d != 1) {
          break;
        }
        i = 5;
        break;
      }
      a(str1, (String)localObject, true);
      return;
    }
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this.mActivity, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
    localIntent.putExtra("uinname", this.sessionInfo.curFriendNick);
    localIntent.putExtra("uintype", this.sessionInfo.curType);
    if ((1000 == this.sessionInfo.curType) || (1004 == this.sessionInfo.curType)) {
      localIntent.putExtra("troop_uin", this.sessionInfo.troopUin);
    }
    this.mActivity.startActivityForResult(localIntent, 2000);
  }
  
  private void e()
  {
    Intent localIntent = TroopMemberListActivity.a(this.mActivity, this.sessionInfo.curFriendUin, 11);
    localIntent.putExtra("param_is_pop_up_style", true);
    localIntent.setFlags(603979776);
    this.mActivity.startActivityForResult(localIntent, 6001);
    if (super.getCurrentPanel() == 21) {
      localIntent.putExtra("param_troop_send_apollo_msg", true);
    }
  }
  
  protected void a()
  {
    if (this.mTroopTips == null) {
      this.mTroopTips = new bdzi();
    }
    if (this.mScrollerRunnable != null)
    {
      this.mScrollerRunnable.a(this.mTroopTips);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "Dis#onShow_troopType#setTroopTips");
      }
    }
    this.mTroopTips.h();
    this.mTroopTips.a(this.app, this.mActivity, this, this.sessionInfo, this.mContent, this.listAdapter, this.listView, this.mScrollerRunnable);
    if ((this.mTroopTips != null) && (this.mTipsMgr.a() != 9)) {
      this.mTroopTips.e();
    }
  }
  
  public void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "genDiscussTitle, name == null");
      }
    }
    int i;
    do
    {
      return;
      i = ((amrb)this.app.getManager(53)).a(this.sessionInfo.curFriendUin);
      paramString1 = new QQText(paramString1, 1);
      if (i > 0) {
        break;
      }
      paramTextView.setText(paramString1);
    } while (!AppSetting.c);
    paramTextView.setContentDescription(paramTextView.getText().toString());
    getActivity().setTitle(paramTextView.getText());
    return;
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mTitleLayout.findViewById(2131365635));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.mCustomTitleView != null)
      {
        paramString2 = this.mCustomTitleView;
        if (this.speakerPhoneOn) {
          break label235;
        }
      }
    }
    label235:
    for (boolean bool = true;; bool = false)
    {
      paramString2.a(bool, this.sessionInfo.curType);
      paramTextView.setText(paramString1);
      if (!AppSetting.c) {
        break;
      }
      paramTextView.setContentDescription(paramTextView.getText().toString());
      getActivity().setTitle(paramTextView.getText());
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2)))
    {
      if (this.sessionInfo.debugFilterMemberMsgCommand) {
        BaseChatpieHelper.a(this.sessionInfo, this.input, this.mFunBtn, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_At_Me_DISC", 2, "memUin:" + paramString1 + " displayName:" + bftf.a(paramString2) + " isRemoveOldAtFlag:" + paramBoolean);
    }
    if ((this.root.a() == 2) && (this.app.getApplication().getResources().getConfiguration().orientation == 2)) {
      this.root.a();
    }
    if (this.sessionInfo.debugFilterMemberMsgCommand)
    {
      if ("0".equals(paramString1))
      {
        BaseChatpieHelper.a(this.sessionInfo, this.input, this.mFunBtn, false);
        return;
      }
      this.sessionInfo.debugFilterMsgTargetUin = paramString1;
      this.dirty = 131077;
      refresh(this.dirty);
      this.mFunBtn.setText(amtj.a(2131702464));
      this.uiHandler.postDelayed(new DiscussChatPie.6(this), 200L);
      return;
    }
    this.uiHandler.postDelayed(new DiscussChatPie.7(this, paramBoolean, paramString1, paramString2), 300L);
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addDefaultObservers(this.jdField_a_of_type_Amwl);
    this.app.addObserver(this.jdField_a_of_type_Amrc);
    this.app.addObserver(this.jdField_a_of_type_Amop);
    ((aubl)this.app.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void adjustTitleDimension()
  {
    this.mCustomTitleView.c();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        return;
        c(paramIntent);
        return;
        b(paramIntent);
        return;
        a(paramIntent);
        return;
      } while (paramInt2 != 0);
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (!this.sessionInfo.debugFilterMemberMsgCommand);
    BaseChatpieHelper.a(this.sessionInfo, this.input, this.mFunBtn, false);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.sessionInfo.curFriendNick != null) {
      a(this.sessionInfo.curFriendNick, this.sessionInfo.curFriendUin, this.mTitleText);
    }
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bjnw != null) && (this.jdField_a_of_type_Bjnw.isShowing())) {
      this.jdField_a_of_type_Bjnw.dismiss();
    }
    this.jdField_a_of_type_Bjnw = null;
    if (this.mTroopTips != null) {
      this.mTroopTips.a();
    }
    if (!android.text.TextUtils.isEmpty(this.sessionInfo.curFriendUin)) {
      abwz.b(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, -4021);
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    b();
  }
  
  public void doOnStop()
  {
    if (!this.hasDestory)
    {
      bese localbese = (bese)this.app.getManager(363);
      if (localbese != null) {
        localbese.a(this.sessionInfo.curFriendUin + "&" + 3000, 0);
      }
    }
    super.doOnStop();
  }
  
  public boolean enableBlur()
  {
    boolean bool = false;
    if ((this.isThemeDefault) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public QQRecorder.RecorderParam getRecorderParam()
  {
    boolean bool = super.isVoiceChangerPanel();
    return bfyl.a(this.app, bool);
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  public void initTipsTaskList()
  {
    super.initTipsTaskList();
    ahph localahph = new ahph(this.app, this.mTipsMgr, this.mActivity, this.sessionInfo, this.listAdapter);
    ahpj localahpj = new ahpj(this.app, this.mTipsMgr, this.mActivity, this.sessionInfo, this.listAdapter);
    this.jdField_a_of_type_Ahpo = new ahpo(this.app, this.mTipsMgr, this.mActivity, this.sessionInfo);
    this.mTipsMgr.a(localahph);
    this.mTipsMgr.a(localahpj);
    this.mTipsMgr.a(this.jdField_a_of_type_Ahpo);
  }
  
  public void onClickTitleLayout(View paramView)
  {
    d();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.listAdapter != null)
    {
      if ((this.mTroopTips != null) && (this.mTroopTips.d())) {
        this.mTroopTips.b(0);
      }
      super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onShow()
  {
    a();
    super.onShow();
  }
  
  public void onShowFirst(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "disscuss Uin : " + this.sessionInfo.curFriendUin);
    }
    lms locallms = this.app.getAVNotifyCenter().a(Long.valueOf(this.sessionInfo.curFriendUin).longValue(), 2);
    if (locallms != null)
    {
      if (!locallms.a) {
        break label133;
      }
      bcef.b(null, "CliOper", "", "", "0X80066C0", "0X80066C0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.app.getAVNotifyCenter().a(Long.valueOf(this.sessionInfo.curFriendUin).longValue(), 2);
      super.onShowFirst(paramInt);
      return;
      label133:
      bcef.b(null, "CliOper", "", "", "0X80066BD", "0X80066BD", 0, 0, "", "", "", "");
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (BaseChatpieHelper.a(this.mFunBtn, paramCharSequence, this.sessionInfo.curType))
    {
      this.sessionInfo.debugFilterMemberMsgCommand = true;
      e();
    }
    boolean bool;
    do
    {
      return;
      DiscussionInfo localDiscussionInfo = ((amrb)this.app.getManager(53)).a(this.sessionInfo.curFriendUin);
      bool = false;
      if (localDiscussionInfo != null) {
        bool = localDiscussionInfo.isDiscussHrMeeting();
      }
    } while ((bool) || (this.sessionInfo.curType != 3000) || (this.sessionInfo.curFriendUin == null) || (this.sessionInfo.curFriendUin.length() == 0) || (paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '@') && (paramCharSequence.charAt(paramInt1) != 65312)) || (this.isBeingInputDraft) || (((afsd)getHelper(27)).a));
    e();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131370017) && (this.mScrollerRunnable != null)) {
      this.mScrollerRunnable.b();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.listAdapter.getCount() > 0)
    {
      this.pullReqTime = SystemClock.uptimeMillis();
      ((aezq)this.refreshMessageContext.context).a(this.pullReqTime);
      if (this.mTroopTips != null)
      {
        if (this.mTroopTips.jdField_b_of_type_Boolean)
        {
          this.refreshMessageContext.needAutoNavigateTop = true;
          this.app.getMessageFacade().getDiscMessageManager().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.mTroopTips.a, this.mTroopTips.jdField_b_of_type_Long, this.mTroopTips.c, this.refreshMessageContext);
          this.mTroopTips.j();
          return true;
        }
        this.refreshMessageContext.needAutoNavigateTop = false;
        this.refreshMessageContext.needNotifyUI = true;
        this.app.getMessageFacade().refreshMessageListHead(this.sessionInfo.curFriendUin, this.sessionInfo.curType, 20, this.refreshMessageContext);
        return true;
      }
      this.refreshMessageContext.needAutoNavigateTop = false;
      this.refreshMessageContext.needNotifyUI = true;
      this.app.getMessageFacade().refreshMessageListHead(this.sessionInfo.curFriendUin, this.sessionInfo.curType, 20, this.refreshMessageContext);
      return true;
    }
    setOverScrollHandleVisable(false);
    return true;
  }
  
  public void openOptionActivity()
  {
    d();
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Amwl);
    this.app.removeObserver(this.jdField_a_of_type_Amrc);
    this.app.removeObserver(this.jdField_a_of_type_Amop);
    ((aubl)this.app.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void saveTextDraft(SessionInfo paramSessionInfo, avnb paramavnb, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (paramSessionInfo.curType == 3000)
    {
      paramSpanned = new ArrayList();
      paramSpanned = bevq.a(this.input.getEditableText(), paramSpanned);
    }
    for (;;)
    {
      super.saveTextDraft(paramSessionInfo, paramavnb, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, null);
      return;
    }
  }
  
  public void setLeftTitleToCancle(ChatMessage paramChatMessage)
  {
    super.setLeftTitleToCancle(paramChatMessage);
    adjustTitleDimension();
  }
  
  public void setTag()
  {
    this.tag = "DiscussChatPie";
  }
  
  public void showZhituAfterDraft()
  {
    showZhituIcon();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {}
    label173:
    for (;;)
    {
      return;
      if ((paramObject instanceof bdyo))
      {
        paramObservable = (bdyo)paramObject;
        if (paramObservable != null)
        {
          if (paramObservable.jdField_a_of_type_Int != bdyn.jdField_a_of_type_Int) {
            break label127;
          }
          refreshHeadMessage(paramObservable.c, paramObservable.a(), paramObservable.d, null);
        }
      }
      for (;;)
      {
        if (!(paramObject instanceof MessageForText)) {
          break label173;
        }
        paramObservable = (MessageForText)paramObject;
        if (!paramObservable.frienduin.equals(this.sessionInfo.curFriendUin)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in DiscussChatPie.update()");
        }
        bgny.a().a(this.app, this.sessionInfo, paramObservable, paramObservable.msg, this.mContext, paramObservable.isSend());
        return;
        label127:
        if ((paramObservable.jdField_a_of_type_Int == bdyn.b) && (this.speakerPhoneLayout != null))
        {
          ((RelativeLayout.LayoutParams)this.speakerPhoneLayout.getLayoutParams()).addRule(2, paramObservable.b);
          continue;
          if (!(paramObject instanceof Integer)) {}
        }
      }
    }
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
    }
    this.sessionInfo.curFriendNick = paramIntent;
    a(this.sessionInfo.curFriendNick, this.sessionInfo.curFriendUin, this.mTitleText);
    this.mTitleLayout.setOnClickListener(this);
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    this.mTitleBtnCall.setOnClickListener(new afin(this));
    if (maq.a().a(this.app.getCurrentAccountUin()))
    {
      this.mTitleBtnCall.setVisibility(0);
      this.mTitleBtnCall.setContentDescription(this.mActivity.getResources().getString(2131697977));
    }
    for (;;)
    {
      adjustTitleDimension();
      return;
      this.mTitleBtnCall.setVisibility(8);
    }
  }
  
  public void updateSession_updateTitleRightView()
  {
    updateViewForTheme(this.mTitleBtnRight, 2130850050, 2130850051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afim
 * JD-Core Version:    0.7.0.1
 */