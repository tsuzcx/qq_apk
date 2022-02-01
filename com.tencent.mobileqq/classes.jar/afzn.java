import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie.3;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie.4;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie.5;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class afzn
  extends BaseChatPie
  implements afvv
{
  protected long a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  protected bfxw a;
  public ProxyObserver a;
  public TroopAIORobotLayout a;
  public String b;
  protected boolean b;
  public String c;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  
  public afzn(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new afzp(this);
  }
  
  private List<Integer> a(int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramInt < paramList1.size())
    {
      if (!a(((ChatMessage)paramList1.get(paramInt)).uniseq, paramList2)) {
        localArrayList.add(Integer.valueOf(paramInt));
      }
      paramInt += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "getInsertMsgsPositions() called with: positions = [" + localArrayList + "]");
    }
    return localArrayList;
  }
  
  private static boolean a(long paramLong, List<ChatMessage> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ChatMessage)paramList.next()).uniseq == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public void a() {}
  
  protected void a(Object paramObject)
  {
    paramObject = (bffr)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "handleUpdateTroopAioAgentMessage: " + paramObject.a);
      }
      if (paramObject.a != bffq.a) {
        break label73;
      }
      refreshHeadMessage(paramObject.c, paramObject.a(), paramObject.d, null);
    }
    label73:
    while ((paramObject.a != bffq.b) || (this.speakerPhoneLayout == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.speakerPhoneLayout.getLayoutParams()).addRule(2, paramObject.b);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (((bgkf)this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.sessionInfo.curFriendUin, true).a) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
    } while (!this.sessionInfo.debugFilterMemberMsgCommand);
    BaseChatpieHelper.a(this.sessionInfo, this.input, this.mFunBtn, false);
    return;
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
      this.mFunBtn.setText(anvx.a(2131700561));
      this.uiHandler.postDelayed(new BaseTroopChatPie.4(this), 200L);
      return;
    }
    this.uiHandler.postDelayed(new BaseTroopChatPie.5(this, paramBoolean, paramString1, paramString2, paramInt), 300L);
  }
  
  public boolean a()
  {
    return this.hasDestory;
  }
  
  protected void b()
  {
    setInputStat(0);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.mTitleBtnRight.setContentDescription(this.mActivity.getString(2131719603));
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "--->current AIO info<--- onresume. troopUin:" + this.sessionInfo.troopUin + ",curFriendUin:" + this.sessionInfo.curFriendUin + ",type:" + this.sessionInfo.curType);
    }
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void clickSendTextButton()
  {
    super.clickSendTextButton();
    this.mDraftText = "";
  }
  
  protected void d()
  {
    if (this.mTroopTips == null) {
      this.mTroopTips = new bfgl();
    }
    if (this.mScrollerRunnable != null)
    {
      this.mScrollerRunnable.a(this.mTroopTips);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "Base#onShow_troopType#setTroopTips");
      }
    }
    this.mTroopTips.h();
    this.mTroopTips.a(this.app, this.mActivity, this, this.sessionInfo, this.mContent, this.listAdapter, this.listView, this.mScrollerRunnable);
    if ((this.mTroopTips != null) && (this.mTipsMgr.a() != 9)) {
      this.mTroopTips.e();
    }
    e();
  }
  
  public void doOnCreate_initData()
  {
    super.doOnCreate_initData();
    this.mSingleTitle = false;
  }
  
  public void doOnCreate_initUI()
  {
    super.doOnCreate_initUI();
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new afzo(this);
      this.input.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.mTitleText.setTextColor(this.mActivity.getResources().getColor(2131167023));
    this.mSubTilteText.setTextColor(this.mActivity.getResources().getColor(2131167023));
    this.mTitleBtnLeft.setTextColor(this.mActivity.getResources().getColor(2131167020));
    agld localagld = (agld)this.helperProvider.a(23);
    if (localagld != null) {
      localagld.a();
    }
    if (this.mScrollerRunnable != null) {
      this.mScrollerRunnable.a(true);
    }
    if (this.mScrollerdownRunnable != null) {
      this.mScrollerdownRunnable.a(this);
    }
  }
  
  @TargetApi(16)
  public void doOnDestroy()
  {
    if (this.hasDestory)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.mTroopTips != null) {
      this.mTroopTips.a();
    }
    if (this.jdField_a_of_type_Bfxw != null)
    {
      this.jdField_a_of_type_Bfxw.b();
      this.jdField_a_of_type_Bfxw = null;
    }
    if (Build.VERSION.SDK_INT < 16) {
      this.input.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      b();
      if (this.mScrollerRunnable != null) {
        this.mScrollerRunnable.a(false);
      }
      agld localagld = (agld)this.helperProvider.a(23);
      if (localagld != null) {
        localagld.b();
      }
      super.doOnDestroy();
      return;
      this.input.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.mTroopTips != null) {
      this.mTroopTips.i();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    c();
  }
  
  public void doOnStop()
  {
    if (!this.hasDestory)
    {
      Object localObject = (bfzk)this.app.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      if (localObject != null)
      {
        ((bfzk)localObject).a(this.sessionInfo.curFriendUin, 0);
        if (this.mTroopTips != null)
        {
          localObject = this.mTroopTips.a();
          if (localObject != null) {
            ((bfyo)localObject).a.set(false);
          }
        }
      }
    }
    super.doOnStop();
  }
  
  public void doUpdateUnreadBubble(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super.doUpdateUnreadBubble(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    aglh localaglh = (aglh)getHelper(53);
    agkb localagkb = (agkb)getHelper(52);
    if ((localaglh != null) && (localagkb != null) && (localagkb.b()) && (localaglh.a())) {
      localagkb.a(this.mContent);
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "handleGrayTipsMsg");
    }
    Object localObject = (bgmf)this.app.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.sessionInfo.curType != 1) || (!((bgmf)localObject).a(this.sessionInfo.curFriendUin))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "troopAIO has unread troopTipMsg");
    }
    localObject = new BaseTroopChatPie.3(this, (bgmf)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public boolean enableBlur()
  {
    boolean bool = false;
    if ((this.isThemeDefault) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public void f()
  {
    leftBackEvent(true);
  }
  
  public boolean finish(int paramInt)
  {
    if (this.mTroopTips != null) {
      this.mTroopTips.a();
    }
    return super.finish(paramInt);
  }
  
  public QQRecorder.RecorderParam getRecorderParam()
  {
    boolean bool = super.isVoiceChangerPanel();
    return bhhd.a(this.app, bool);
  }
  
  public void hideTroopFCView(boolean paramBoolean)
  {
    if (this.sessionInfo.curType != 1) {}
    while (((this.root.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_Bfxw == null) || (!this.jdField_a_of_type_Bfxw.a())) {
      return;
    }
    this.jdField_a_of_type_Bfxw.a();
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    if (this.mTroopTips != null) {
      this.mTroopTips.a();
    }
    super.leftBackEvent(paramBoolean);
  }
  
  public boolean onBackEvent()
  {
    if (this.mTroopTips != null) {
      this.mTroopTips.a();
    }
    return super.onBackEvent();
  }
  
  public View onCreatePanel(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.mEmoPanel = ((EmoticonMainPanel)this.mActivity.getLayoutInflater().inflate(2131559158, null));
      this.mEmoPanel.setCallBack(this);
      EmoticonMainPanel localEmoticonMainPanel = this.mEmoPanel;
      if ((isFullScreenMode()) || (this.receiptMode)) {}
      for (boolean bool = true;; bool = false)
      {
        localEmoticonMainPanel.onlySysAndEmoji = bool;
        if (isFullScreenMode()) {
          this.mEmoPanel.setHideAllSettingTabs(true);
        }
        this.mEmoPanel.disableMoreEmotionButton = this.receiptMode;
        this.mEmoPanel.disableGuide = this.receiptMode;
        this.mEmoPanel.init(this.app, this.sessionInfo.curType, this.mActivity, this.mActivity.getTitleBarHeight(), this.defaultEpId, this.defaultPanelType, this);
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
        }
        if (this.d) {
          this.mEmoPanel.switchToAnonymous(this.d);
        }
        return this.mEmoPanel;
      }
    }
    return super.onCreatePanel(paramInt);
  }
  
  public void onDoubleTap(MotionEvent paramMotionEvent)
  {
    agld localagld = (agld)this.helperProvider.a(23);
    if ((localagld != null) && (localagld.a(paramMotionEvent, this.isJubaoMode))) {
      return;
    }
    super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    agkb localagkb = (agkb)getHelper(52);
    if ((localagkb != null) && (localagkb.a(paramMotionEvent))) {
      return false;
    }
    return bool;
  }
  
  public Pair<Integer, Integer> onJumpTopGetNewTop(int paramInt1, List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt2)
  {
    Pair localPair = super.onJumpTopGetNewTop(paramInt1, paramList1, paramList2, paramInt2);
    paramList1 = a(paramInt1, paramList1, paramList2);
    int i = paramList1.size() - 1;
    if (i >= 0)
    {
      paramList2 = (Integer)paramList1.get(i);
      if (paramList2.intValue() >= paramInt2 + paramInt1) {}
    }
    for (paramList1 = new Pair(Integer.valueOf(paramList2.intValue() + 1), Integer.valueOf(paramInt2 + paramInt1 + paramList1.size()));; paramList1 = localPair)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onJumpTopGetNewTop() called with: newTop = [" + paramInt1 + "], readCnt = [" + paramInt2 + "], result = [" + paramList1 + "]");
      }
      return paramList1;
      i -= 1;
      break;
    }
  }
  
  public void onPanelIconClick(Object paramObject)
  {
    super.onPanelIconClick(paramObject);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.listView.getFooterViewsCount();
    int j = this.listView.getHeaderViewsCount();
    if (this.mTroopTips != null) {
      this.mTroopTips.a(paramInt1, paramInt2, paramInt3, i, j);
    }
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.listAdapter.getCount() > 0)
    {
      this.pullReqTime = SystemClock.uptimeMillis();
      ((afrc)this.refreshMessageContext.context).a(this.pullReqTime);
      if (this.mTroopTips != null) {
        if (this.mTroopTips.jdField_b_of_type_Boolean)
        {
          this.refreshMessageContext.needAutoNavigateTop = true;
          this.app.getMessageFacade().getTroopMessageManager().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.mTroopTips.jdField_a_of_type_Long, this.mTroopTips.jdField_b_of_type_Long, this.mTroopTips.c, this.refreshMessageContext);
          this.mTroopTips.j();
          if ((this.sessionInfo.curType == 1) && (this.app.getTroopMask(this.sessionInfo.curFriendUin) == 3)) {
            bdla.b(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, this.sessionInfo.curFriendUin, "", "", "");
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.refreshMessageContext.needAutoNavigateTop = false;
      this.refreshMessageContext.needNotifyUI = true;
      if (!this.c)
      {
        this.app.getMessageFacade().refreshMessageListHead(this.sessionInfo.curFriendUin, this.sessionInfo.curType, 20, this.refreshMessageContext);
        break;
      }
      this.app.getMessageFacade().refreshMessageListHeadByAIOBreak(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.refreshMessageContext);
      this.c = false;
      break;
      this.refreshMessageContext.needAutoNavigateTop = false;
      this.refreshMessageContext.needNotifyUI = true;
      if (!this.c)
      {
        this.app.getMessageFacade().refreshMessageListHead(this.sessionInfo.curFriendUin, this.sessionInfo.curType, 20, this.refreshMessageContext);
        break;
      }
      this.app.getMessageFacade().refreshMessageListHeadByAIOBreak(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.refreshMessageContext);
      this.c = false;
      break;
      setOverScrollHandleVisable(false);
    }
  }
  
  public void saveTextDraft(SessionInfo paramSessionInfo, awtg paramawtg, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramSessionInfo.curType == 1) {
      paramSpanned = bgcz.a(this.input.getEditableText(), localArrayList);
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        paramString2 = bgcz.a(localArrayList);
      }
      for (;;)
      {
        if (this.input != null) {
          super.saveTextDraft(paramSessionInfo, paramawtg, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, paramString2);
        }
        return;
      }
    }
  }
  
  public void setSubTitleVisable(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mSubTilteText.getVisibility() == 8))
    {
      this.mSubTilteText.setVisibility(0);
      this.mTitleText.setTextSize(1, 17.0F);
      this.mTitleCount.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.mSubTilteText.getVisibility() != 0) || (this.d)) {
      return;
    }
    this.mSubTilteText.setVisibility(8);
    this.mTitleText.setTextSize(1, 17.0F);
    this.mTitleCount.setTextSize(1, 17.0F);
  }
  
  public void setTag()
  {
    this.tag = "BaseTroopChatPie";
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      if (this.mUserActionState != null)
      {
        if ((this.mUserActionState.d == bfka.c) && (this.mUserActionState.a != null)) {
          refreshHeadMessage(this.mUserActionState.a.c, this.mUserActionState.a.a(), this.mUserActionState.a.d, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.tag + ".trooptroop_pull_msg", 2, "update,mUserActionState.actionType" + this.mUserActionState.d);
        }
        this.mUserActionState = null;
        this.app.getMessageFacade().getTroopMessageManager().deleteObservers();
      }
    }
    while (!(paramObject instanceof bffr)) {
      return;
    }
    a(paramObject);
  }
  
  public void updateFriendNick()
  {
    String str = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
    this.sessionInfo.curFriendNick = str;
  }
  
  public void updateListUnRead(int paramInt)
  {
    super.updateListUnRead(paramInt);
    Object localObject = (agld)this.helperProvider.a(23);
    if (localObject != null) {
      ((agld)localObject).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout, this.mContent);
    }
    localObject = (agkb)getHelper(52);
    if (localObject != null) {
      ((agkb)localObject).a(this.mContent);
    }
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.sessionInfo.curFriendNick = paramIntent;
    }
    for (;;)
    {
      this.mTitleText.setText(new begq(this.sessionInfo.curFriendNick, 32).a());
      if (AppSetting.c)
      {
        paramIntent = this.mTitleText.getText().toString();
        this.mTitleText.setContentDescription(paramIntent);
        getActivity().setTitle(this.mTitleText.getText());
      }
      return;
      updateFriendNick();
    }
  }
  
  public void updateSession_updateTitleRightView()
  {
    if ((this.d) || (this.e))
    {
      this.mTitleBtnRight.setImageResource(2130843729);
      return;
    }
    updateViewForTheme(this.mTitleBtnRight, 2130850143, 2130850144);
  }
  
  public void updateSession_updateUI(Intent paramIntent)
  {
    super.updateSession_updateUI(paramIntent);
    if (this.d)
    {
      this.mInputBar.getBackground().setVisible(true, false);
      this.mInputBar.findViewById(2131377820).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.root.a(i, false);
    }
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    agld localagld = (agld)this.helperProvider.a(23);
    if (localagld != null) {
      localagld.a(paramIntent);
    }
  }
  
  public void updateSpeakerPhoneLayout(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.speakerPhoneLayout != null) {
      super.updateSpeakerPhoneLayout(paramBoolean1, paramBoolean2);
    }
    Object localObject;
    do
    {
      return;
      super.updateSpeakerPhoneLayout(paramBoolean1, paramBoolean2);
      localObject = (agld)this.helperProvider.a(23);
      if (localObject != null) {
        ((agld)localObject).a(this.speakerPhoneLayout);
      }
      localObject = (agkb)getHelper(52);
    } while (localObject == null);
    ((agkb)localObject).a(this.mContent, this.speakerPhoneLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzn
 * JD-Core Version:    0.7.0.1
 */