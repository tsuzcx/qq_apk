import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.beacon.event.UserAction;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.11;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.15;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceAnimView;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class aici
  extends BaseChatPie
  implements Handler.Callback
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g = 6;
  private long jdField_a_of_type_Long = -1L;
  private ahqa jdField_a_of_type_Ahqa = new aicn(this);
  private anvi jdField_a_of_type_Anvi = new aicq(this);
  private anyz jdField_a_of_type_Anyz = new aicp(this);
  aslz jdField_a_of_type_Aslz = new aicr(this);
  private volatile ExtendFriendUserInfo jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new aicj(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new aico(this);
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString = "0";
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private int h = 0;
  private int i = 0;
  private volatile int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = 0;
  private int q = jdField_a_of_type_Int;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 4;
    jdField_f_of_type_Int = 5;
  }
  
  public aici(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_e_of_type_Boolean = true;
  }
  
  private int a()
  {
    String str1 = "#FFFFFFFF";
    String str2 = ThemeUtil.getCurrentThemeId();
    if ("1103".equals(str2)) {
      str1 = "#FFA1A1A1";
    }
    for (;;)
    {
      try
      {
        int i1 = Color.parseColor(str1);
        return i1;
      }
      catch (Exception localException) {}
      if ("2920".equals(str2)) {
        str1 = "#FF848484";
      } else if ("2101".equals(str2)) {
        str1 = "#FFDBB86B";
      } else if ("2105".equals(str2)) {
        str1 = "#FF12B7F5";
      } else if (bdfk.b(str2)) {
        if (("2921".equals(str2)) || ("2971".equals(str2))) {
          str1 = "#FF03081A";
        } else {
          str1 = "#FFFFFFFF";
        }
      }
    }
    return 0;
  }
  
  private void a(ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "handleExtendFriendOnlineState onlineUinList =" + paramArrayList);
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      String str = ((Long)paramArrayList.get(0)).toString();
      if (this.sessionInfo == null) {}
      for (paramArrayList = ""; str.equals(paramArrayList); paramArrayList = this.sessionInfo.curFriendUin)
      {
        getActivity().runOnUiThread(new LimitChatPie.11(this));
        return;
      }
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((!(localMessageRecord instanceof MessageForUniteGrayTip)) && (!(localMessageRecord instanceof MessageForLimitChatTopic))) {
          if (bhfj.a(localMessageRecord.issend)) {
            this.n += 1;
          } else {
            this.o += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatPie", 2, "calcHistorySendReceiveMsgCount historySendMsgCount = " + this.n + ",historyReceivedMsgCount = " + this.o);
  }
  
  private boolean a()
  {
    aslx localaslx = ((aslo)getActivity().app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if (localaslx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatPie", 2, "hasSendMsgToEachOther return true for null cfg");
      }
      return true;
    }
    int i1 = localaslx.q;
    if ((i1 > 0) && ((this.n < i1) || (this.o < i1))) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatPie", 2, "isSendReceiveMsgCountOverThreshHold result = " + bool + ",msgThreshHold = " + i1 + ",historySendMsgCount = " + this.n + ",historyReceivedMsgCount = " + this.o);
      }
      return bool;
    }
  }
  
  private boolean b()
  {
    boolean bool1 = false;
    int i2 = 0;
    if (this.root.a() != 0)
    {
      int i1 = i2;
      if (this.root.a() == 2)
      {
        i1 = i2;
        if (this.mAudioPanel != null)
        {
          i1 = i2;
          if (this.mAudioPanel.a()) {
            i1 = 1;
          }
        }
      }
      if (i1 == 0) {
        this.root.a(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.mAIOGiftPanelContainer != null)
    {
      bool2 = bool1;
      if (this.mAIOGiftPanelContainer.a())
      {
        this.mAIOGiftPanelContainer.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "gotoFriendAio : " + this.sessionInfo.curFriendUin);
    }
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
    localIntent.putExtra("uintype", 0);
    getActivity().startActivity(localIntent);
  }
  
  private boolean c()
  {
    boolean bool = false;
    asqt localasqt;
    if (this.sessionInfo.curType == 1044) {
      if (this.app != null)
      {
        localasqt = (asqt)this.app.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (localasqt == null) {
          break label67;
        }
      }
    }
    label67:
    for (bool = localasqt.c(this.app).booleanValue();; bool = false)
    {
      return bool;
      QLog.d(this.tag, 2, "UINTYPE NOT Y");
      return false;
    }
  }
  
  private void d()
  {
    String str;
    if (this.sessionInfo == null) {
      str = "";
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaLangString = asrt.a(this.app, str);
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.7(this, str));
      if ((this.sessionInfo != null) && (this.sessionInfo.curFriendUin != null)) {
        this.k = asrt.a(this.app, this.sessionInfo.curFriendUin);
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
      if (this.sessionInfo.curFriendUin == null) {
        str = "";
      } else {
        str = this.sessionInfo.curFriendUin;
      }
    }
  }
  
  private void e()
  {
    if (this.listAdapter != null) {
      this.listAdapter.a = Boolean.valueOf(false);
    }
    this.mSingleTitle = false;
    setSubTitleVisable(true);
    if (this.mSubTitleText2 != null) {
      this.mSubTitleText2.setVisibility(8);
    }
  }
  
  private void f()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.sessionInfo.curFriendUin, 96);
    ProfileActivity.a(this.mContext, localAllInOne, this.p, 2);
  }
  
  private void g()
  {
    Object localObject;
    if (this.sessionInfo == null) {
      localObject = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, "updateSession_updateSubTitle toUin =" + (String)localObject);
      }
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.add(Long.valueOf((String)localObject));
        label63:
        if (!localArrayList.isEmpty())
        {
          localObject = (aslm)this.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
          if (localObject != null) {
            ((aslm)localObject).a(localArrayList);
          }
        }
        return;
        localObject = this.sessionInfo.curFriendUin;
      }
      catch (Exception localException)
      {
        break label63;
      }
    }
  }
  
  private void h()
  {
    avrg localavrg = (avrg)getHelper(16);
    if (localavrg != null) {
      localavrg.b();
    }
  }
  
  private void i()
  {
    if ((this.mTitleBtnCall != null) && (this.mTitleBtnCall.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.tagID == 10000))
    {
      l();
      j();
    }
  }
  
  private void j()
  {
    QQCustomDialog localQQCustomDialog;
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      localQQCustomDialog = bhdj.a(this.mActivity, 230).setMessage(this.mActivity.getString(2131698112)).setPositiveButton(this.mActivity.getString(2131694399), new aicm(this)).setNegativeButton(this.mActivity.getString(2131690697), new aicl(this));
      localQQCustomDialog.setCancelable(false);
    }
    try
    {
      localQQCustomDialog.show();
      bdla.b(this.app, "dc00898", "", "", "0X800ADC8", "0X800ADC8", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.tag, 1, "ShowVoiceDialog fail" + localException.toString());
      }
    }
  }
  
  private void k()
  {
    this.jdField_e_of_type_Boolean = ((ansg)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).b();
    ((asqt)this.app.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a(this.jdField_e_of_type_Boolean);
  }
  
  private void l()
  {
    if ((this.mTitleBtnCall.getParent() instanceof RelativeLayout))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.mTitleBtnCall.getParent();
      ExtendFriendVoiceAnimView localExtendFriendVoiceAnimView = new ExtendFriendVoiceAnimView(this.mContext);
      int i1 = ViewUtils.dip2px(29.0F);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
      localLayoutParams.addRule(13, -1);
      localRelativeLayout.addView(localExtendFriendVoiceAnimView, 0, localLayoutParams);
      localExtendFriendVoiceAnimView.setCircleParams(a(), 800);
      localExtendFriendVoiceAnimView.a(500L);
    }
  }
  
  private void m()
  {
    if (!this.mActivity.isFinishing()) {
      QQToast.a(this.mContext, 1, this.mContext.getString(2131698546), 0).a();
    }
  }
  
  private void n()
  {
    ThreadManager.getSubThreadHandler().post(new LimitChatPie.15(this));
  }
  
  public void a()
  {
    int i1 = 1;
    Object localObject = (aslo)this.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    int i3 = ((aslo)localObject).d();
    int i2;
    if (i3 > 0)
    {
      i2 = this.j / i3 + 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "checkShowGrayTips " + this.j + " " + i2 + " " + this.k);
      }
      if (this.j % i3 != 0) {
        break label171;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        String str = ((aslo)localObject).c();
        localObject = ((aslo)localObject).d();
        if (!TextUtils.isEmpty(str))
        {
          asrt.a(this.app, this.sessionInfo.curFriendUin, i2);
          this.k = i2;
          ThreadManager.getSubThreadHandler().post(new LimitChatPie.6(this, str, (String)localObject));
        }
      }
      return;
      label171:
      if (i2 - this.k <= 1) {
        i1 = 0;
      }
    }
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "addBusinessObservers");
    }
    this.app.addObserver(this.jdField_a_of_type_Anyz);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
  }
  
  public void b()
  {
    bdla.b(this.app, "dc00898", "", "", "0X800A693", "0X800A693", 0, 0, "", "", "", "");
  }
  
  public void backToQzoneUserHomeActivity()
  {
    Intent localIntent = this.mActivity.getIntent();
    localIntent.putExtra("key_limit_chat_result_action", this.i);
    this.mActivity.setResult(-1, localIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "chat pie finish, finishaction:" + this.i);
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void clickSendTextButton()
  {
    super.clickSendTextButton();
    if (this.sessionInfo == null) {}
    for (String str = "";; str = this.sessionInfo.curFriendUin)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("frompage", String.valueOf(this.q));
      localHashMap.put("chat_id", this.app.getCurrentAccountUin() + "_" + str);
      localHashMap.put("to_uid", str);
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#chat_page#message_success", true, -1L, -1L, localHashMap, true, true);
      return;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    paramBoolean = super.doOnCreate(paramBoolean);
    e();
    ((aizi)this.mActivity.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.app.addObserver(this.jdField_a_of_type_Aslz);
    d();
    if (this.sessionInfo == null) {}
    for (String str = "";; str = this.sessionInfo.curFriendUin)
    {
      this.q = this.mActivity.getIntent().getIntExtra("key_limitchat_enter_type", jdField_a_of_type_Int);
      HashMap localHashMap = new HashMap();
      localHashMap.put("frompage", String.valueOf(this.q));
      localHashMap.put("chat_id", this.app.getCurrentAccountUin() + "_" + str);
      localHashMap.put("to_uid", str);
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "expose#chat_page#view", true, -1L, -1L, localHashMap, true, true);
      return paramBoolean;
    }
  }
  
  public void doOnCreate_initUI()
  {
    super.doOnCreate_initUI();
    this.listView.setChoiceMode(0);
    this.panelicons.setPanelIconClickInterceptListener(this.jdField_a_of_type_Ahqa);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "doOnDestroy, userfinish:" + this.jdField_c_of_type_Boolean);
    }
    this.panelicons.setPanelIconClickInterceptListener(null);
    ((aizi)this.mActivity.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_JavaUtilObserver = null;
    this.app.removeObserver(this.jdField_a_of_type_Aslz);
    String str;
    long l1;
    long l2;
    HashMap localHashMap;
    if (this.sessionInfo == null)
    {
      str = "";
      if (this.jdField_d_of_type_Boolean)
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_b_of_type_Long;
        localHashMap = new HashMap();
        localHashMap.put("chat_id", this.app.getCurrentAccountUin() + str);
        localHashMap.put("to_uid", str);
        if ((this.l <= 0) || (this.m <= 0)) {
          break label283;
        }
        bdla.b(this.app, "dc00898", "", "", "0X800A695", "0X800A695", 0, 0, "", "", "", "");
        UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#chat_page#double_match", true, -1L, -1L, localHashMap, true, true);
      }
    }
    for (;;)
    {
      bdla.b(this.app, "dc00898", "", "", "0X800A692", "0X800A692", 0, 0, String.valueOf(l1 - l2), "", this.jdField_c_of_type_JavaLangString, "");
      return;
      str = this.sessionInfo.curFriendUin;
      break;
      label283:
      if ((this.l > 0) || (this.m > 0))
      {
        bdla.b(this.app, "dc00898", "", "", "0X800A694", "0X800A694", 0, 0, "", "", "", "");
        UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#chat_page#single_match", true, -1L, -1L, localHashMap, true, true);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    astk.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.sessionInfo.curFriendUin)) {
      c();
    }
    k();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ((aslm)this.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.sessionInfo.curFriendUin, true);
  }
  
  public void doOnStop()
  {
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
  
  public List<ChatMessage> getAIOList()
  {
    return getAIOList(this.app, false);
  }
  
  public List<ChatMessage> getAIOList(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = super.getAIOList(paramQQAppInterface, paramBoolean);
    Collections.sort(paramQQAppInterface, this.jdField_a_of_type_JavaUtilComparator);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)paramQQAppInterface.get(paramQQAppInterface.size() - 1));
    }
    return paramQQAppInterface;
  }
  
  public List<ChatMessage> getAIOList(boolean paramBoolean)
  {
    return getAIOList(this.app, paramBoolean);
  }
  
  public QQRecorder.RecorderParam getRecorderParam()
  {
    boolean bool = super.isVoiceChangerPanel();
    return bhhd.a(this.app, bool);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  public void initTipsTaskList()
  {
    this.mVideoStatusBar = new VideoStatusTipsBar(this.app, this.sessionInfo, this.mTipsMgr, this.mActivity, this.uiHandler);
    this.mTipsMgr.a(this.mVideoStatusBar);
  }
  
  public void messageTips(QQMessageFacade.Message paramMessage)
  {
    super.messageTips(paramMessage);
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onBackEvent begin");
    }
    if (b()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onChangeMultiScreen(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    super.onPanelChanged(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onPanelChanged, old:" + paramInt1 + " new:" + paramInt2);
    }
  }
  
  public void onPanelIconClick(Object paramObject)
  {
    super.onPanelIconClick(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 4: 
      bdla.b(this.app, "dc00898", "", "", "0X80096AA", "0X80096AA", this.p, 0, "", "", "", "");
      return;
    case 2: 
      bdla.b(this.app, "dc00898", "", "", "0X80096A9", "0X80096A9", this.p, 0, "", "", "", "");
      return;
    case 5: 
      bdla.b(this.app, "dc00898", "", "", "0X80096AB", "0X80096AB", this.p, 0, "", "", "", "");
      return;
    case 24: 
      bdla.b(this.app, "dc00898", "", "", "0X80096AC", "0X80096AC", this.p, 0, "", "", "", "");
      return;
    }
    bdla.b(this.app, "dc00898", "", "", "0X80096AD", "0X80096AD", this.p, 0, "", "", "", "");
  }
  
  public void onPlayStart()
  {
    astk.b();
    super.onPlayStart();
  }
  
  public void onPostThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onPostThemeChanged" + this.isThemeDefault);
    }
    updateUI_titleBarForTheme();
  }
  
  public void onPreThemeChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onPreThemeChanged" + this.isThemeDefault);
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
    g();
  }
  
  public void onShowSubTitleText(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "setSubTitlonShowSubTitleTexteText statusText =" + paramString);
    }
    bbss localbbss = (bbss)getHelper(45);
    if ((localbbss != null) && (localbbss.a(paramBoolean, paramString))) {
      return;
    }
    getActivity().runOnUiThread(new LimitChatPie.10(this, paramString, paramBoolean));
  }
  
  public void onShow_otherThings()
  {
    super.onShow_otherThings();
  }
  
  public void openOptionActivity()
  {
    if ((bhbx.b(this.sessionInfo.curFriendUin)) && (bhbx.a(this.mContext))) {
      return;
    }
    Intent localIntent = new Intent(this.mContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
    String str2 = this.jdField_b_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.sessionInfo.curFriendNick;
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("uintype", this.sessionInfo.curType);
    localIntent.putExtra("ExtendFriendLimitChatFromeType", this.p);
    if (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) {
      localIntent.putExtra("subId", ExtendFriendUserInfo.fromTypeToSubID(this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.fromType));
    }
    this.mActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    this.app.removeObserver(this.jdField_a_of_type_Anyz);
  }
  
  public void setLeftCheckBoxVisible(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.setLeftCheckBoxVisible(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.listAdapter != null) {
      this.listAdapter.a = Boolean.valueOf(false);
    }
  }
  
  public void setSubTitleText(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "setSubTitleText text =" + paramString);
    }
    avrg localavrg = (avrg)getHelper(16);
    if (localavrg != null) {
      localavrg.a(paramString);
    }
  }
  
  public void setTag()
  {
    this.tag = "LimitChatPie";
  }
  
  public boolean showorhideAddFriend()
  {
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (avrg)getHelper(16);
      if (paramObject != null)
      {
        if (!paramObservable.isSend()) {
          break label44;
        }
        paramObject.d();
      }
    }
    label44:
    do
    {
      do
      {
        return;
        if (paramObservable.time > paramObject.jdField_b_of_type_Long) {
          h();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.enableQQCall)) {
          break;
        }
      } while (!paramObservable.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.uin));
      this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.enableQQCall = true;
      n();
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) || (this.sessionInfo == null) || (!paramObservable.senderuin.equals(this.sessionInfo.curFriendUin)));
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void updateInputBarBg()
  {
    super.updateInputBarBg();
  }
  
  public void updateListUnRead(int paramInt)
  {
    super.updateListUnRead(paramInt);
    agkb localagkb = (agkb)getHelper(52);
    if (localagkb != null) {
      localagkb.a(this.mContent);
    }
  }
  
  public void updateSession(Intent paramIntent)
  {
    super.updateSession(paramIntent);
    this.p = paramIntent.getIntExtra("key_limitchat_from_type", 0);
    this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("key_limitchat_auto_open", false);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "updateSession, mfromType :" + this.p);
    }
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    super.updateSession_updateTitle(paramIntent);
    this.mTitleText.setOnClickListener(new aics(this));
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    if (Boolean.valueOf(c()).booleanValue())
    {
      this.mTitleBtnCall.setVisibility(0);
      this.mTitleBtnCall.setOnClickListener(new aick(this));
      return;
    }
    this.mTitleBtnCall.setVisibility(8);
  }
  
  public void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    this.mTitleShowUnread = true;
    this.mTitleBtnLeft.setText("");
  }
  
  public void updateUI_titleBarForTheme()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "updateUI_titleBarForTheme" + this.isThemeDefault);
    }
    if ((this.sessionInfo == null) || (this.mContext == null)) {
      return;
    }
    super.updateUI_titleBarForTheme();
    this.panelicons.b(this.app);
  }
  
  public void updateUnreadNumOnTitleBar() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aici
 * JD-Core Version:    0.7.0.1
 */