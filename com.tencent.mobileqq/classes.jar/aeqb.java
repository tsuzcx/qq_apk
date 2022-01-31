import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.11;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.13;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.14;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.15;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.17;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.22;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.8;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SegmentedControlView;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import java.util.Observable;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class aeqb
  extends aemd
  implements RadioGroup.OnCheckedChangeListener
{
  protected static final String[] a;
  static long i;
  private aemg jdField_a_of_type_Aemg;
  public ainh a;
  ajyr jdField_a_of_type_Ajyr = new aeqe(this);
  ajyt jdField_a_of_type_Ajyt;
  ajyv jdField_a_of_type_Ajyv;
  akil jdField_a_of_type_Akil = new aeqc(this);
  protected ateo a;
  protected baqr a;
  public HotChatManager a;
  public HotChatInfo a;
  protected TroopGiftPanelForNearby a;
  public RedDotRadioButton a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  SegmentedControlView jdField_a_of_type_ComTencentWidgetSegmentedControlView;
  public XListView a;
  xjj jdField_a_of_type_Xjj = null;
  public boolean af;
  public boolean ag;
  boolean ah = false;
  boolean ai;
  boolean aj = false;
  RedDotRadioButton b;
  Dialog g;
  long h;
  public Dialog h;
  String j;
  public TextView n;
  View q = null;
  View r;
  public int t;
  public int u;
  public int v = 0;
  protected int w = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "@all", ajya.a(2131705585) };
  }
  
  public aeqb(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_h_of_type_Long = 0L;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramInt == 1)
    {
      if (this.r != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.r);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      }
      this.w = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()))
      {
        e(131072);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
      }
      if ((this.jdField_a_of_type_Azno != null) && (this.jdField_a_of_type_Azno.a() > 0)) {
        this.jdField_a_of_type_Azno.c(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (paramBoolean))
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) {
          break label201;
        }
        str = "2";
        axqy.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, str, "", "", "");
      }
    }
    for (;;)
    {
      axqy.b(null, "dc00899", "grp_lbs", "", "hot_room", "exp_visit_post", 0, 0, "", "", "", "");
      return;
      label201:
      str = "1";
      break;
      if (paramInt == 2)
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()))
        {
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
          if (this.jdField_a_of_type_Ainh != null) {
            d(0, this.jdField_a_of_type_Ainh.getCount());
          }
        }
        this.jdField_a_of_type_Azno.c(4);
        bt();
        ap();
        if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.clearRedPoint();
        }
        this.w = 2;
        if (this.jdField_a_of_type_Acup != null) {
          this.v = this.jdField_a_of_type_Acup.getCount();
        }
      }
    }
  }
  
  private void bt()
  {
    if (this.r == null) {
      this.r = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559137, null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.r.findViewById(2131377694));
      this.n = ((TextView)this.r.findViewById(2131365675));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559459, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(-1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(10);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839135));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(30);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new aeqm(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new aeqn(this));
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.r) == -1)
    {
      localLayoutParams.addRule(6, 2131369274);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.r, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(8);
    }
    int k;
    if (bbkb.T(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)
    {
      k = 1;
      if (k == 0) {
        break label396;
      }
      if (this.jdField_a_of_type_Xjj == null)
      {
        this.jdField_a_of_type_Xjj = new xjj(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "QQ_Hotchat_post_list.apk", "2586", "/hotchatPostListPlugin/opt");
        this.jdField_a_of_type_Xjj.a(new aeqo(this), false);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() == 8) || ((this.jdField_a_of_type_Ainh != null) && (this.jdField_a_of_type_Ainh.getCount() == 0))) {
        d(0, 10);
      }
      return;
      k = 0;
      break;
      label396:
      if (this.jdField_a_of_type_Ainh == null)
      {
        this.jdField_a_of_type_Ainh = new ainh(this.jdField_a_of_type_AndroidContentContext, null, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ainh);
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotChatPie.22(this, paramInt2, paramInt1), 8, null, true);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString + "Q.hotchat.aio_post_list_req", 2, "getPostListFromServer start: " + paramInt1 + "|num:" + paramInt2);
    }
  }
  
  private void t(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.q == null) {
        this.q = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559733, null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(14);
        localLayoutParams.topMargin = 32;
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.q, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b();
        this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = ((SegmentedControlView)this.q.findViewById(2131367641));
      }
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.q.findViewById(2131367639));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(true);
        this.w = 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.q.findViewById(2131367640));
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setOnCheckedChangeListener(this);
      return;
    }
    if ((this.q != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.q) != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.q);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  private void u(boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new HotChatPie.3(this, paramBoolean));
  }
  
  public void A()
  {
    String str = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bbcz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
    }
  }
  
  public boolean E()
  {
    return true;
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_Ajyv != null)
    {
      this.jdField_a_of_type_Ajyv.b();
      this.jdField_a_of_type_Ajyv = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
      b(1, false);
      if ((this.q != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.q) != -1)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.q);
      }
      this.q = null;
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
      this.r = null;
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_Ainh = null;
      this.jdField_a_of_type_Xjj = null;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_h_of_type_Long;
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l1 - l2), String.valueOf(this.u), "", "");
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("open_chatfragment_fromphoto", false))) || (this.jdField_h_of_type_AndroidAppDialog != null))
    {
      this.jdField_h_of_type_AndroidAppDialog.dismiss();
      this.jdField_h_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_g_of_type_AndroidAppDialog != null)
    {
      this.jdField_g_of_type_AndroidAppDialog.dismiss();
      this.jdField_g_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_Ajyt != null) {
      this.jdField_a_of_type_Ajyt.a();
    }
    if (this.jdField_a_of_type_Ainh != null) {
      this.jdField_a_of_type_Ainh.c();
    }
    ((bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a();
    if (this.jdField_a_of_type_Baqr != null) {
      this.jdField_a_of_type_Baqr.b();
    }
    super.G();
  }
  
  public void K()
  {
    super.K();
    this.aj = true;
  }
  
  public void L()
  {
    super.L();
    if (this.jdField_a_of_type_Ajyv != null) {
      this.jdField_a_of_type_Ajyv.a();
    }
  }
  
  public void O()
  {
    super.O();
    this.aj = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) && (this.w == 2) && (this.jdField_a_of_type_Azno != null)) {
      this.jdField_a_of_type_Azno.c(4);
    }
    this.jdField_a_of_type_Baqr.a();
  }
  
  public void P()
  {
    super.P();
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      return;
      String str = localIntent.getStringExtra("uin");
      int k = localIntent.getIntExtra("uintype", -1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != k))) {}
      for (k = 1; (k != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()); k = 0)
      {
        this.r = null;
        this.jdField_a_of_type_ComTencentWidgetXListView = null;
        return;
      }
    }
  }
  
  public void Q()
  {
    super.Q();
  }
  
  public void V()
  {
    super.V();
    if (this.w == 2) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "HotChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      Intent localIntent = actj.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
      continue;
      if ((paramInt2 == 8001) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
  }
  
  public void a(View paramView) {}
  
  public void a(SessionInfo paramSessionInfo, asek paramasek, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    super.a(paramSessionInfo, paramasek, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo);
  }
  
  public void a(QQMessageFacade.Message paramMessage) {}
  
  public void a(ChatMessage paramChatMessage, String paramString)
  {
    bfpc localbfpc = bfpc.a(a());
    String str3 = ajya.a(2131705594);
    String str4 = paramChatMessage.getExtInfoFromExtStr("hotchat_gender");
    String str1 = str3;
    try
    {
      if (Integer.parseInt(str4) == 1) {
        str1 = ajya.a(2131705591);
      }
      localbfpc.c(str1);
      localbfpc.a(ajya.a(2131705588), 3);
      localbfpc.c(2131690596);
      localbfpc.a(new aeqf(this, localbfpc, paramChatMessage, paramString));
      localbfpc.show();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str2 = str3;
        if (QLog.isColorLevel())
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "showHeadLongClickActionSheet, NumberFormatException, genderStr:" + str4);
          str2 = str3;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)a().getSystemService("input_method");
    View localView = a().getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_Ateo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), new aeql(this), false, false, false, this);
      this.jdField_a_of_type_Ateo = new ateo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.c, true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.setIsPttRoom(false);
    this.jdField_a_of_type_Ateo.a(paramBoolean, false, 4);
    ap();
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.aj) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString + paramString4, 2, "onKickHotChatMember.isSuccess=" + paramBoolean + ",groupuin=" + paramString1 + ",result=" + paramInt + ",memberuin=" + paramString2 + ",strError=" + paramString3);
    }
    if ((this.jdField_h_of_type_AndroidAppDialog != null) && (this.jdField_h_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_h_of_type_AndroidAppDialog.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      bcql.a(a(), ajya.a(2131705574), 0).b(a().getTitleBarHeight());
      return;
    }
    bcql.a(a(), ajya.a(2131705576), 0).b(a().getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    super.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    while (this.aj) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed = true;
      ThreadManager.post(new HotChatPie.15(this), 8, null, true);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_Baec == null) {
          this.jdField_a_of_type_Baec = new baec(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.d, this.jdField_a_of_type_Azno, this.V, null);
        }
        paramString1 = paramString3;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = paramString3;
          if (!paramString3.startsWith("mqqapi"))
          {
            paramString1 = paramString3;
            if (!paramString3.startsWith("http://")) {
              paramString1 = "http://" + paramString3;
            }
          }
        }
        this.jdField_a_of_type_Baec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString2, paramString1);
        if (this.jdField_a_of_type_Ajyv != null) {
          this.jdField_a_of_type_Ajyv.b = false;
        }
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.G = false;
    this.i = false;
    this.jdField_a_of_type_Aemg = new aemg(this);
    this.jdField_a_of_type_Ajyt = new ajyt(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    this.jdField_a_of_type_Baqr = new baqr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    return super.a(paramBoolean);
  }
  
  public void aU()
  {
    if (this.jdField_a_of_type_Ateo != null) {
      this.jdField_a_of_type_Ateo.a();
    }
  }
  
  public void ag()
  {
    bB();
    bq();
    super.ag();
    this.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
    NearbyTransitActivity.a("AIOShow", 2);
    Object localObject4 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    Object localObject1 = ((Intent)localObject4).getStringExtra("uin");
    Object localObject2 = ((Intent)localObject4).getStringExtra("uinname");
    Object localObject3 = ((Intent)localObject4).getStringExtra("hotnamecode");
    boolean bool = ((Intent)localObject4).getBooleanExtra("param_newly_created_hot_chat", false);
    if ((!this.ai) && (bool) && (((Intent)localObject4).getBooleanExtra("param_newly_created_hot_chat", false)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
    {
      localObject4 = ajyi.a((String)localObject3, 1);
      localObject2 = ShareHotChatGrayTips.makeShareGrayTip(ShareHotChatGrayTips.SHARE_GRAY_TIP_CONTENT, ajya.a(2131705589), (String)localObject1, (String)localObject2, (String)localObject4, (String)localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.ai = true;
        localObject3 = axas.a(-2033);
        long l = awzy.a();
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((MessageRecord)localObject3).init((String)localObject4, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject4, (String)localObject2, l, -2033, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
        ((MessageRecord)localObject3).isread = true;
        if (!akas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject3, (String)localObject4);
        }
      }
      this.jdField_g_of_type_AndroidAppDialog = ajyi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new aeqq(this, (String)localObject1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a()) {
      ThreadManager.post(new HotChatPie.10(this), 8, null, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.pkFlag != 0))
    {
      if (this.jdField_a_of_type_Ajyv == null)
      {
        ThreadManager.post(new HotChatPie.11(this), 5, null, true);
        localObject1 = new aeqd(this);
        this.jdField_a_of_type_Ajyv = new ajyv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ajyw)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
      }
      this.jdField_a_of_type_Ajyv.a(10000L);
    }
    int k;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.need2ReqRedPoint()) {
        ThreadManager.post(new HotChatPie.13(this), 8, null, true);
      }
      k = 1;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (k == 0) {
        break label518;
      }
    }
    label518:
    for (localObject1 = "2";; localObject1 = "1")
    {
      axqy.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject1, "", "", "");
      return;
      b(1, false);
      k = 0;
      break;
    }
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajyr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Aemg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Akte);
    }
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aemg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Akte);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajyr);
  }
  
  public void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      mzb.a("2586", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aeqp(this), true, 0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.q);
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    super.b(paramIntent);
  }
  
  public void bB()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if (localHotChatInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a();
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("param_newly_created_hot_chat", false)) {
        ThreadManager.post(new HotChatPie.17(this, localHotChatInfo), 8, null, true);
      }
    }
  }
  
  public void bC()
  {
    bbgu localbbgu = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230);
    localbbgu.setMessage(String.format("需要等级LV%d才能使用闪照功能哦", new Object[] { Integer.valueOf(HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) }));
    localbbgu.setNegativeButton(ajya.a(2131705584), new aeqi(this, localbbgu));
    localbbgu.setPositiveButton(ajya.a(2131705577), new aeqk(this));
    localbbgu.setCanceledOnTouchOutside(false);
    localbbgu.show();
  }
  
  void bp()
  {
    super.bp();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131693307));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state != 0)) {
      ThreadManager.post(new HotChatPie.8(this), 5, null, false);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    this.t = paramInt2;
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null)
    {
      if (QLog.isColorLevel()) {
        atbr.a("PttShow", new Object[] { "HotChatPie_updateSession_business HotChatInfo is null", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
      }
      b(0);
    }
    do
    {
      do
      {
        do
        {
          return;
          this.u = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate;
          if ((paramIntent != null) && (paramIntent.getIntExtra("hot_chat_from", 1) == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.c())) {
            ajyi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isRobotHotChat);
        this.jdField_g_of_type_JavaLangString = ("" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.robotUin);
        this.jdField_h_of_type_JavaLangString = bbcz.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_g_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this, new aeqj(this));
        paramIntent = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
        paramIntent.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString);
        paramIntent = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString);
      } while (paramIntent == null);
      try
      {
        new cmd0x934.RspBody().mergeFrom(paramIntent);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntent) {}
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramIntent.getMessage());
  }
  
  public void e(Intent paramIntent)
  {
    this.af = paramIntent.getBooleanExtra("abp_flag", false);
    this.ag = paramIntent.getBooleanExtra("is_from_web", false);
    if ((this.ag) && (!this.af))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690331);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajya.a(2131705583));
      return;
    }
    if (this.af)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131705595));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajya.a(2131705581));
      return;
    }
    super.e(paramIntent);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.af)
    {
      if (this.jdField_a_of_type_Azno != null) {
        this.jdField_a_of_type_Azno.a();
      }
      HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.af);
      return;
    }
    super.f(paramBoolean);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = super.handleMessage(paramMessage);
    }
    return bool;
  }
  
  public boolean i()
  {
    boolean bool1;
    if ((this.jdField_a_of_type_Ateo != null) && (this.jdField_a_of_type_Ateo.a()))
    {
      this.jdField_a_of_type_Ateo.a();
      bool1 = true;
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return bool1;
          bool2 = super.i();
          bool1 = bool2;
        } while (this.j);
        bool1 = bool2;
      } while (!this.af);
      bool1 = bool2;
    } while (bool2);
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.af);
    return bool2;
  }
  
  public int j()
  {
    return this.w;
  }
  
  public void n(int paramInt)
  {
    super.n(paramInt);
  }
  
  public void n(boolean paramBoolean)
  {
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int k;
    QQAppInterface localQQAppInterface;
    if (paramInt == 2131367639)
    {
      k = 1;
      b(k, true);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramInt != 2131367639) {
        break label62;
      }
    }
    label62:
    for (paramRadioGroup = "clk_hot_room";; paramRadioGroup = "clk_see_post")
    {
      axqy.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", paramRadioGroup, 0, 0, "", "", "", "");
      return;
      k = 2;
      break;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!this.s))
    {
      paramCharSequence = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if (paramCharSequence != null) {}
      for (paramCharSequence = paramCharSequence.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; paramCharSequence = null)
      {
        if (paramCharSequence != null)
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", bfnx.a(bfnx.a(bfnx.a(bfnx.a(bfnx.a("http://nearby.qq.com/hot_chat/member_list.html", "_wv", "3"), "_bid", "2581"), "gc", paramCharSequence.troopUin), "rid", paramCharSequence.uuid), "from", String.valueOf(1)));
          paramCharSequence = new Bundle();
          paramCharSequence.putBoolean("hide_left_button", true);
          localIntent.putExtras(paramCharSequence);
          a().startActivity(localIntent);
        }
        return;
      }
    }
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum > 0)) {}
    for (int k = 1;; k = 0)
    {
      c(true);
      if (k == 0) {
        break;
      }
      this.f.setVisibility(0);
      this.f.setText(String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131693325), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum) }));
      this.f.setTextSize(1, 12.0F);
      return;
    }
    this.f.setVisibility(8);
  }
  
  public void s()
  {
    this.d.setVisibility(4);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
      o(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) && (paramObject != null) && ((paramObject instanceof MessageRecord)) && (this.w == 2)) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new HotChatPie.14(this));
    }
  }
  
  public void x()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a((String)localObject)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid)))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", bfnx.a(bfnx.a(bfnx.a(bfnx.a(bfnx.a(bfnx.a(bfnx.a("https://nearby.qq.com/hot_chat/room_info.html", "_wv", "3"), "_bid", "2581"), "gc", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin), "rid", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid), "rname", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name), "rtype", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.hotChatType)), "rnum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount)));
      a().startActivity((Intent)localObject);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isGameRoom) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "clk_grp_card", 0, 0, "", "", "", "");
      }
      return;
    }
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), ajya.a(2131705593), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public boolean x()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d())
    {
      bC();
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005DD2", "0X8005DD2", 0, 0, "", "", "", "");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqb
 * JD-Core Version:    0.7.0.1
 */