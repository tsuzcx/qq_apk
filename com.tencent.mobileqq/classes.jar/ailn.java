import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Spanned;
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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
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
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.21;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.8;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SegmentedControlView;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import java.util.Observable;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class ailn
  extends aihd
  implements RadioGroup.OnCheckedChangeListener
{
  protected static final String[] a;
  static long g;
  abdn jdField_a_of_type_Abdn = null;
  private aihg jdField_a_of_type_Aihg;
  public amot a;
  aoaa jdField_a_of_type_Aoaa = new aoab(this);
  aoad jdField_a_of_type_Aoad;
  public aoaf a;
  aojs jdField_a_of_type_Aojs = new ailo(this);
  protected axzy a;
  protected bgyg a;
  public HotChatManager a;
  public HotChatInfo a;
  protected TroopGiftPanelForNearby a;
  public RedDotRadioButton a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  SegmentedControlView jdField_a_of_type_ComTencentWidgetSegmentedControlView;
  public XListView a;
  public boolean ae;
  public boolean af;
  boolean ag = false;
  boolean ah;
  boolean ai = false;
  RedDotRadioButton b;
  Dialog c;
  public Dialog d;
  long f;
  public String j;
  public TextView n;
  View p = null;
  View q;
  public int t;
  public int u;
  public int v = 0;
  protected int w = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "@all", anzj.a(2131704477) };
  }
  
  public ailn(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_f_of_type_Long = 0L;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramInt == 1)
    {
      if (this.q != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.q);
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
        f(131072);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
      }
      if ((this.jdField_a_of_type_Bfpy != null) && (this.jdField_a_of_type_Bfpy.a() > 0)) {
        this.jdField_a_of_type_Bfpy.c(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (paramBoolean))
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) {
          break label201;
        }
        str = "2";
        bdll.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, str, "", "", "");
      }
    }
    for (;;)
    {
      bdll.b(null, "dc00899", "grp_lbs", "", "hot_room", "exp_visit_post", 0, 0, "", "", "", "");
      return;
      label201:
      str = "1";
      break;
      if (paramInt == 2)
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()))
        {
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
          if (this.jdField_a_of_type_Amot != null) {
            d(0, this.jdField_a_of_type_Amot.getCount());
          }
        }
        this.jdField_a_of_type_Bfpy.c(4);
        bt();
        ar();
        if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.clearRedPoint();
        }
        this.w = 2;
        if (this.jdField_a_of_type_Aggs != null) {
          this.v = this.jdField_a_of_type_Aggs.getCount();
        }
      }
    }
  }
  
  private void bt()
  {
    if (this.q == null) {
      this.q = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559258, null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.q.findViewById(2131379309));
      this.n = ((TextView)this.q.findViewById(2131366048));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559652, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(-1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(10);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839405));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(30);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new ailx(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new aily(this));
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.q) == -1)
    {
      localLayoutParams.addRule(6, 2131370020);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.q, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(8);
    }
    int i;
    if (bhsi.T(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)
    {
      i = 1;
      if (i == 0) {
        break label396;
      }
      if (this.jdField_a_of_type_Abdn == null)
      {
        this.jdField_a_of_type_Abdn = new abdn(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "QQ_Hotchat_post_list.apk", "2586", "/hotchatPostListPlugin/opt");
        this.jdField_a_of_type_Abdn.a(new ailz(this), false);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() == 8) || ((this.jdField_a_of_type_Amot != null) && (this.jdField_a_of_type_Amot.getCount() == 0))) {
        d(0, 10);
      }
      return;
      i = 0;
      break;
      label396:
      if (this.jdField_a_of_type_Amot == null)
      {
        this.jdField_a_of_type_Amot = new amot(this.jdField_a_of_type_AndroidContentContext, null, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amot);
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotChatPie.21(this, paramInt2, paramInt1), 8, null, true);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString + "Q.hotchat.aio_post_list_req", 2, "getPostListFromServer start: " + paramInt1 + "|num:" + paramInt2);
    }
  }
  
  private void v(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.p == null) {
        this.p = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559937, null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(14);
        localLayoutParams.topMargin = 32;
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.p, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b();
        this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = ((SegmentedControlView)this.p.findViewById(2131368166));
      }
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.p.findViewById(2131368164));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(true);
        this.w = 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.p.findViewById(2131368165));
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setOnCheckedChangeListener(this);
      return;
    }
    if ((this.p != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.p) != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.p);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  private void w(boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new HotChatPie.3(this, paramBoolean));
  }
  
  public void A()
  {
    String str = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
    }
  }
  
  public boolean F()
  {
    return true;
  }
  
  public void H()
  {
    if (this.jdField_a_of_type_Aoaf != null)
    {
      this.jdField_a_of_type_Aoaf.b();
      this.jdField_a_of_type_Aoaf = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
      b(1, false);
      if ((this.p != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.p) != -1)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.p);
      }
      this.p = null;
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
      this.q = null;
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_Amot = null;
      this.jdField_a_of_type_Abdn = null;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_f_of_type_Long;
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l1 - l2), String.valueOf(this.u), "", "");
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("open_chatfragment_fromphoto", false))) || (this.jdField_d_of_type_AndroidAppDialog != null))
    {
      this.jdField_d_of_type_AndroidAppDialog.dismiss();
      this.jdField_d_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_c_of_type_AndroidAppDialog != null)
    {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
      this.jdField_c_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_Aoad != null) {
      this.jdField_a_of_type_Aoad.a();
    }
    if (this.jdField_a_of_type_Amot != null) {
      this.jdField_a_of_type_Amot.c();
    }
    ((bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a();
    if (this.jdField_a_of_type_Bgyg != null) {
      this.jdField_a_of_type_Bgyg.b();
    }
    super.H();
  }
  
  public void L()
  {
    super.L();
    this.ai = true;
  }
  
  public void M()
  {
    super.M();
    if (this.jdField_a_of_type_Aoaf != null) {
      this.jdField_a_of_type_Aoaf.a();
    }
  }
  
  public void P()
  {
    super.P();
    this.ai = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) && (this.w == 2) && (this.jdField_a_of_type_Bfpy != null)) {
      this.jdField_a_of_type_Bfpy.c(4);
    }
    this.jdField_a_of_type_Bgyg.a();
  }
  
  public void Q()
  {
    super.Q();
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      return;
      String str = localIntent.getStringExtra("uin");
      int i = localIntent.getIntExtra("uintype", -1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != i))) {}
      for (i = 1; (i != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()); i = 0)
      {
        this.q = null;
        this.jdField_a_of_type_ComTencentWidgetXListView = null;
        return;
      }
    }
  }
  
  public void R()
  {
    super.R();
  }
  
  public void W()
  {
    super.W();
    if (this.w == 2) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    }
  }
  
  public TroopGiftPanelForNearby a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby;
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
      Intent localIntent = agej.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
      continue;
      if ((paramInt2 == 8001) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
  }
  
  public void a(View paramView) {}
  
  public void a(QQMessageFacade.Message paramMessage) {}
  
  public void a(SessionInfo paramSessionInfo, awzu paramawzu, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    super.a(paramSessionInfo, paramawzu, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, null);
  }
  
  public void a(ChatMessage paramChatMessage, String paramString)
  {
    blir localblir = blir.a(a());
    String str3 = anzj.a(2131704486);
    String str4 = paramChatMessage.getExtInfoFromExtStr("hotchat_gender");
    String str1 = str3;
    try
    {
      if (Integer.parseInt(str4) == 1) {
        str1 = anzj.a(2131704483);
      }
      localblir.c(str1);
      localblir.a(anzj.a(2131704480), 3);
      localblir.c(2131690580);
      localblir.a(new ailq(this, localblir, paramChatMessage, paramString));
      localblir.show();
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
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    }
    o(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
    for (paramObject = "507";; paramObject = "503")
    {
      aocz.a("gift_aio", "clk_icon", c(), paramObject, "", "");
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)a().getSystemService("input_method");
    View localView = a().getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_Axzy == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), new ailw(this), false, false, false, this);
      this.jdField_a_of_type_Axzy = new axzy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.jdField_c_of_type_AndroidViewViewGroup, true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.setIsPttRoom(false);
    this.jdField_a_of_type_Axzy.a(paramBoolean, false, 4);
    ar();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.ai) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString + paramString4, 2, "onKickHotChatMember.isSuccess=" + paramBoolean + ",groupuin=" + paramString1 + ",result=" + paramInt + ",memberuin=" + paramString2 + ",strError=" + paramString3);
    }
    if ((this.jdField_d_of_type_AndroidAppDialog != null) && (this.jdField_d_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_d_of_type_AndroidAppDialog.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      QQToast.a(a(), anzj.a(2131704466), 0).b(a().getTitleBarHeight());
      return;
    }
    QQToast.a(a(), anzj.a(2131704468), 0).b(a().getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    super.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    while (this.ai) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed = true;
      ThreadManager.post(new HotChatPie.15(this), 8, null, true);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_Bghm == null) {
          this.jdField_a_of_type_Bghm = new bghm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bfpy, this.U, null);
        }
        paramString1 = paramString3;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = paramString3;
          if (!paramString3.startsWith("mqqapi"))
          {
            paramString1 = paramString3;
            if (!paramString3.startsWith("http://"))
            {
              paramString1 = paramString3;
              if (!paramString3.startsWith("https://")) {
                paramString1 = "https://" + paramString3;
              }
            }
          }
        }
        this.jdField_a_of_type_Bghm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString2, paramString1);
        if (this.jdField_a_of_type_Aoaf != null) {
          this.jdField_a_of_type_Aoaf.b = false;
        }
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.F = false;
    this.i = false;
    this.jdField_a_of_type_Aihg = new aihg(this);
    this.jdField_a_of_type_Aoad = new aoad(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    this.jdField_a_of_type_Bgyg = new bgyg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    return super.a(paramBoolean);
  }
  
  public void aS()
  {
    if (this.jdField_a_of_type_Axzy != null) {
      this.jdField_a_of_type_Axzy.a();
    }
  }
  
  public void ai()
  {
    bB();
    bq();
    super.ai();
    this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
    NearbyTransitActivity.a("AIOShow", 2);
    Object localObject4 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    Object localObject1 = ((Intent)localObject4).getStringExtra("uin");
    Object localObject2 = ((Intent)localObject4).getStringExtra("uinname");
    Object localObject3 = ((Intent)localObject4).getStringExtra("hotnamecode");
    boolean bool = ((Intent)localObject4).getBooleanExtra("param_newly_created_hot_chat", false);
    if ((!this.ah) && (bool) && (((Intent)localObject4).getBooleanExtra("param_newly_created_hot_chat", false)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
    {
      localObject4 = anzr.a((String)localObject3, 1);
      localObject2 = ShareHotChatGrayTips.makeShareGrayTip(ShareHotChatGrayTips.SHARE_GRAY_TIP_CONTENT, anzj.a(2131704481), (String)localObject1, (String)localObject2, (String)localObject4, (String)localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.ah = true;
        localObject3 = bcry.a(-2033);
        long l = bcrg.a();
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((MessageRecord)localObject3).init((String)localObject4, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject4, (String)localObject2, l, -2033, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
        ((MessageRecord)localObject3).isread = true;
        if (!aoci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject3, (String)localObject4);
        }
      }
      this.jdField_c_of_type_AndroidAppDialog = anzr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new aimb(this, (String)localObject1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a()) {
      ThreadManager.post(new HotChatPie.10(this), 8, null, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.pkFlag != 0))
    {
      if (this.jdField_a_of_type_Aoaf == null)
      {
        ThreadManager.post(new HotChatPie.11(this), 5, null, true);
        localObject1 = new ailp(this);
        this.jdField_a_of_type_Aoaf = new aoaf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aoag)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
      }
      this.jdField_a_of_type_Aoaf.a(10000L);
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.need2ReqRedPoint()) {
        ThreadManager.post(new HotChatPie.13(this), 8, null, true);
      }
      i = 1;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i == 0) {
        break label518;
      }
    }
    label518:
    for (localObject1 = "2";; localObject1 = "1")
    {
      bdll.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject1, "", "", "");
      return;
      b(1, false);
      i = 0;
      break;
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoaa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Aihg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aihg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoaa);
  }
  
  public void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      nmj.a("2586", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aima(this), true, 0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.p);
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
        ThreadManager.post(new HotChatPie.16(this, localHotChatInfo), 8, null, true);
      }
    }
  }
  
  public void bC()
  {
    bhpc localbhpc = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230);
    localbhpc.setMessage(String.format("需要等级LV%d才能使用闪照功能哦", new Object[] { Integer.valueOf(HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) }));
    localbhpc.setNegativeButton(anzj.a(2131704476), new ailt(this, localbhpc));
    localbhpc.setPositiveButton(anzj.a(2131704469), new ailu(this));
    localbhpc.setCanceledOnTouchOutside(false);
    localbhpc.show();
  }
  
  void bp()
  {
    super.bp();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131692901));
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
        axxb.a("PttShow", new Object[] { "HotChatPie_updateSession_business HotChatInfo is null", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
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
            anzr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isRobotHotChat);
        this.g = ("" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.robotUin);
        this.h = bhlg.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g, this.h, this, new ailv(this));
        paramIntent = (bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
        paramIntent.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g, this.h);
        paramIntent = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g);
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
    this.ae = paramIntent.getBooleanExtra("abp_flag", false);
    this.af = paramIntent.getBooleanExtra("is_from_web", false);
    if ((this.af) && (!this.ae))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690384);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131704475));
      return;
    }
    if (this.ae)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131704487));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131704473));
      return;
    }
    super.e(paramIntent);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.ae)
    {
      if (this.jdField_a_of_type_Bfpy != null) {
        this.jdField_a_of_type_Bfpy.a();
      }
      HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.ae);
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
    if ((this.jdField_a_of_type_Axzy != null) && (this.jdField_a_of_type_Axzy.a()))
    {
      this.jdField_a_of_type_Axzy.a();
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
      } while (!this.ae);
      bool1 = bool2;
    } while (bool2);
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.ae);
    return bool2;
  }
  
  public int j()
  {
    return this.w;
  }
  
  public void o(int paramInt)
  {
    super.o(paramInt);
  }
  
  public void o(boolean paramBoolean)
  {
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i;
    QQAppInterface localQQAppInterface;
    if (paramInt == 2131368164)
    {
      i = 1;
      b(i, true);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramInt != 2131368164) {
        break label72;
      }
    }
    label72:
    for (String str = "clk_hot_room";; str = "clk_see_post")
    {
      bdll.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", str, 0, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      i = 2;
      break;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!this.r))
    {
      paramCharSequence = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if (paramCharSequence != null) {}
      for (paramCharSequence = paramCharSequence.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; paramCharSequence = null)
      {
        if (paramCharSequence != null)
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", blhn.a(blhn.a(blhn.a(blhn.a(blhn.a("https://nearby.qq.com/hot_chat/member_list.html", "_wv", "3"), "_bid", "2581"), "gc", paramCharSequence.troopUin), "rid", paramCharSequence.uuid), "from", String.valueOf(1)));
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
    for (int i = 1;; i = 0)
    {
      c(true);
      if (i == 0) {
        break;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131692913), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum) }));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void r()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
      p(false);
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
      ((Intent)localObject).putExtra("url", blhn.a(blhn.a(blhn.a(blhn.a(blhn.a(blhn.a(blhn.a("https://nearby.qq.com/hot_chat/room_info.html", "_wv", "3"), "_bid", "2581"), "gc", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin), "rid", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid), "rname", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name), "rtype", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.hotChatType)), "rnum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount)));
      a().startActivity((Intent)localObject);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isGameRoom) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "clk_grp_card", 0, 0, "", "", "", "");
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), anzj.a(2131704485), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public boolean x()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d())
    {
      bC();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005DD2", "0X8005DD2", 0, 0, "", "", "", "");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailn
 * JD-Core Version:    0.7.0.1
 */