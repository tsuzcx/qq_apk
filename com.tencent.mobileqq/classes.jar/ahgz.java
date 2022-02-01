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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.11;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.14;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.15;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.21;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.8;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.9;
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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
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

public class ahgz
  extends afii
  implements RadioGroup.OnCheckedChangeListener
{
  protected static final String[] a;
  static long jdField_c_of_type_Long;
  private afil jdField_a_of_type_Afil;
  public aljn a;
  amua jdField_a_of_type_Amua = new amub(this);
  amud jdField_a_of_type_Amud;
  public amuf a;
  andd jdField_a_of_type_Andd = new ahha(this);
  Dialog jdField_a_of_type_AndroidAppDialog;
  protected awng a;
  protected bfhs a;
  public HotChatManager a;
  public HotChatInfo a;
  protected TroopGiftPanelForNearby a;
  public RedDotRadioButton a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  SegmentedControlView jdField_a_of_type_ComTencentWidgetSegmentedControlView;
  public XListView a;
  zzy jdField_a_of_type_Zzy = null;
  long jdField_b_of_type_Long = 0L;
  public Dialog b;
  RedDotRadioButton jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
  View jdField_c_of_type_AndroidViewView = null;
  public TextView c;
  public int d;
  View d;
  public int e;
  public String e;
  public int f = 0;
  protected int g = -1;
  public boolean n;
  public boolean o;
  boolean p = false;
  boolean q;
  boolean r = false;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "@all", amtj.a(2131704707) };
  }
  
  public ahgz(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotChatPie.21(this, paramInt2, paramInt1), 8, null, true);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag + "Q.hotchat.aio_post_list_req", 2, "getPostListFromServer start: " + paramInt1 + "|num:" + paramInt2);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramInt == 1)
    {
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.mContent.removeView(this.jdField_d_of_type_AndroidViewView);
      }
      this.listView.setVisibility(0);
      if (this.panelicons != null) {
        this.panelicons.setVisibility(0);
      }
      if (this.mInputBar != null) {
        this.mInputBar.setVisibility(0);
      }
      this.g = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()))
      {
        refresh(131072);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
      }
      if ((this.mTroopTips != null) && (this.mTroopTips.a() > 0)) {
        this.mTroopTips.c(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (paramBoolean))
      {
        QQAppInterface localQQAppInterface = this.app;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) {
          break label201;
        }
        str = "2";
        bcef.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, str, "", "", "");
      }
    }
    for (;;)
    {
      bcef.b(null, "dc00899", "grp_lbs", "", "hot_room", "exp_visit_post", 0, 0, "", "", "", "");
      return;
      label201:
      str = "1";
      break;
      if (paramInt == 2)
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()))
        {
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
          if (this.jdField_a_of_type_Aljn != null) {
            a(0, this.jdField_a_of_type_Aljn.getCount());
          }
        }
        this.mTroopTips.c(4);
        g();
        hidePanel();
        if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.clearRedPoint();
        }
        this.g = 2;
        if (this.listAdapter != null) {
          this.f = this.listAdapter.getCount();
        }
      }
    }
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!this.q) && (paramBoolean) && (paramIntent.getBooleanExtra("param_newly_created_hot_chat", false)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramIntent = amtr.a(paramString3, 1);
      paramIntent = ShareHotChatGrayTips.makeShareGrayTip(ShareHotChatGrayTips.SHARE_GRAY_TIP_CONTENT, amtj.a(2131704711), paramString1, paramString2, paramIntent, paramString3);
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.q = true;
        paramString2 = bbli.a(-2033);
        long l = bbko.a();
        paramString3 = this.app.getCurrentAccountUin();
        paramString2.init(paramString3, this.sessionInfo.curFriendUin, paramString3, paramIntent, l, -2033, this.sessionInfo.curType, l);
        paramString2.isread = true;
        if (!amwh.a(this.app, paramString2, false)) {
          this.app.getMessageFacade().addMessage(paramString2, paramString3);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog = amtr.a(this.mActivity, new ahhc(this, paramString1));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTitleLayout.setVisibility(8);
      this.mSubTitleLayout.setVisibility(8);
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.mContext).inflate(2131559941, null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(14);
        localLayoutParams.topMargin = 32;
        this.mCustomTitleView.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
        this.mCustomTitleView.b();
        this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = ((SegmentedControlView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368195));
      }
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_c_of_type_AndroidViewView.findViewById(2131368193));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(true);
        this.g = 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_c_of_type_AndroidViewView.findViewById(2131368194));
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setOnCheckedChangeListener(this);
      return;
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.mCustomTitleView.indexOfChild(this.jdField_c_of_type_AndroidViewView) != -1)) {
      this.mCustomTitleView.removeView(this.jdField_c_of_type_AndroidViewView);
    }
    this.mTitleLayout.setVisibility(0);
    this.mSubTitleLayout.setVisibility(0);
  }
  
  private void b(boolean paramBoolean)
  {
    this.uiHandler.post(new HotChatPie.3(this, paramBoolean));
  }
  
  private void g()
  {
    if (this.jdField_d_of_type_AndroidViewView == null) {
      this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this.mContext).inflate(2131559264, null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_d_of_type_AndroidViewView.findViewById(2131379079));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366078));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.mContext).inflate(2131559654, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(-1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(10);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(this.mContext.getResources().getDrawable(2130839440));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(30);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new ahhk(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new ahhl(this));
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (this.mInputBar != null) {
      this.mInputBar.setVisibility(8);
    }
    if (this.panelicons != null) {
      this.panelicons.setVisibility(8);
    }
    if (this.mContent.indexOfChild(this.jdField_d_of_type_AndroidViewView) == -1)
    {
      localLayoutParams.addRule(6, 2131370017);
      this.mContent.addView(this.jdField_d_of_type_AndroidViewView, localLayoutParams);
      this.listView.setVisibility(8);
    }
    int i;
    if (bfyz.U(this.mContext, this.app.getCurrentUin()) == 1)
    {
      i = 1;
      if (i == 0) {
        break label400;
      }
      if (this.jdField_a_of_type_Zzy == null)
      {
        this.jdField_a_of_type_Zzy = new zzy(this.mActivity, "QQ_Hotchat_post_list.apk", "2586", "/hotchatPostListPlugin/opt");
        this.jdField_a_of_type_Zzy.a(new ahhm(this), false);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() == 8) || ((this.jdField_a_of_type_Aljn != null) && (this.jdField_a_of_type_Aljn.getCount() == 0))) {
        a(0, 10);
      }
      return;
      i = 0;
      break;
      label400:
      if (this.jdField_a_of_type_Aljn == null)
      {
        this.jdField_a_of_type_Aljn = new aljn(this.mContext, null, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aljn);
      }
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.pkFlag != 0))
    {
      if (this.jdField_a_of_type_Amuf == null)
      {
        ThreadManager.post(new HotChatPie.11(this), 5, null, true);
        ahhb localahhb = new ahhb(this);
        this.jdField_a_of_type_Amuf = new amuf(this.app, localahhb, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
      }
      this.jdField_a_of_type_Amuf.a(10000L);
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  public TroopGiftPanelForNearby a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby;
  }
  
  public void a(ChatMessage paramChatMessage, String paramString)
  {
    bjnw localbjnw = bjnw.a(getActivity());
    String str3 = amtj.a(2131704716);
    String str4 = paramChatMessage.getExtInfoFromExtStr("hotchat_gender");
    String str1 = str3;
    try
    {
      if (Integer.parseInt(str4) == 1) {
        str1 = amtj.a(2131704713);
      }
      localbjnw.c(str1);
      localbjnw.a(amtj.a(2131704710), 3);
      localbjnw.c(2131690620);
      localbjnw.a(new ahhd(this, localbjnw, paramChatMessage, paramString));
      localbjnw.show();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str2 = str3;
        if (QLog.isColorLevel())
        {
          QLog.e(this.tag, 2, "showHeadLongClickActionSheet, NumberFormatException, genderStr:" + str4);
          str2 = str3;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.r) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.tag + paramString4, 2, "onKickHotChatMember.isSuccess=" + paramBoolean + ",groupuin=" + paramString1 + ",result=" + paramInt + ",memberuin=" + paramString2 + ",strError=" + paramString3);
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      QQToast.a(getActivity(), amtj.a(2131704696), 0).b(getActivity().getTitleBarHeight());
      return;
    }
    QQToast.a(getActivity(), amtj.a(2131704698), 0).b(getActivity().getTitleBarHeight());
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.equals(paramString1, this.sessionInfo.curFriendUin)) {}
    while (this.r) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed = true;
      ThreadManager.post(new HotChatPie.15(this), 8, null, true);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_Bequ == null) {
          this.jdField_a_of_type_Bequ = new bequ(this.app, this.mActivity, this.sessionInfo, this.mContent, this.mTitleBtnCall, this.mTroopTips, this.jdField_d_of_type_Boolean, null);
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
        this.jdField_a_of_type_Bequ.a(this.app, this.mContext, paramString2, paramString1);
        if (this.jdField_a_of_type_Amuf != null) {
          this.jdField_a_of_type_Amuf.b = false;
        }
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addObserver(this.jdField_a_of_type_Amua);
    this.app.addDefaultObservers(this.jdField_a_of_type_Afil);
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    super.c();
    this.mTitleBtnRight.setContentDescription(this.mActivity.getString(2131692951));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state != 0)) {
      ThreadManager.post(new HotChatPie.8(this), 5, null, false);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.mActivity, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      this.mActivity.startActivity(localIntent);
      continue;
      if ((paramInt2 == 8001) && (this.root != null)) {
        this.root.a();
      }
    }
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    this.needAutoInput = false;
    ((afqg)getHelper(83)).a(false);
    this.jdField_a_of_type_Afil = new afil(this);
    this.jdField_a_of_type_Amud = new amud(this.mActivity, this.app, null);
    this.jdField_a_of_type_Bfhs = new bfhs(this.app, this.sessionInfo.curFriendUin, "Grp_time", "Grp_AIO", "visit_time");
    return super.doOnCreate(paramBoolean);
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Amuf != null)
    {
      this.jdField_a_of_type_Amuf.b();
      this.jdField_a_of_type_Amuf = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      this.app.removeObserver(this.jdField_a_of_type_Andd);
      a(1, false);
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.mCustomTitleView.indexOfChild(this.jdField_c_of_type_AndroidViewView) != -1)) {
        this.mCustomTitleView.removeView(this.jdField_c_of_type_AndroidViewView);
      }
      this.jdField_c_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
      this.jdField_d_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_Aljn = null;
      this.jdField_a_of_type_Zzy = null;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_b_of_type_Long;
    bcef.b(this.app, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l1 - l2), String.valueOf(this.e), "", "");
    if (((this.mActivity.getIntent() == null) || (this.mActivity.getIntent().getBooleanExtra("open_chatfragment_fromphoto", false))) || (this.jdField_b_of_type_AndroidAppDialog != null))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_Amud != null) {
      this.jdField_a_of_type_Amud.a();
    }
    if (this.jdField_a_of_type_Aljn != null) {
      this.jdField_a_of_type_Aljn.c();
    }
    ((bfdm)this.app.getManager(203)).a();
    if (this.jdField_a_of_type_Bfhs != null) {
      this.jdField_a_of_type_Bfhs.b();
    }
    super.doOnDestroy();
  }
  
  public void doOnNewIntent_clearBusinessData()
  {
    super.doOnNewIntent_clearBusinessData();
    Intent localIntent = this.mActivity.getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      return;
      String str = localIntent.getStringExtra("uin");
      int i = localIntent.getIntExtra("uintype", -1);
      if ((this.sessionInfo.curFriendUin != null) && ((!this.sessionInfo.curFriendUin.equals(str)) || (this.sessionInfo.curType != i))) {}
      for (i = 1; (i != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()); i = 0)
      {
        this.jdField_d_of_type_AndroidViewView = null;
        this.jdField_a_of_type_ComTencentWidgetXListView = null;
        return;
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Amuf != null) {
      this.jdField_a_of_type_Amuf.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.r = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) && (this.g == 2) && (this.mTroopTips != null)) {
      this.mTroopTips.c(4);
    }
    this.jdField_a_of_type_Bfhs.a();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.r = true;
  }
  
  public void doPanelChanged(int paramInt1, int paramInt2)
  {
    super.doPanelChanged(paramInt1, paramInt2);
    this.jdField_d_of_type_Int = paramInt2;
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
  
  public void hideGiftPanel()
  {
    if (this.jdField_a_of_type_Awng != null) {
      this.jdField_a_of_type_Awng.a();
    }
  }
  
  public boolean isAllowSendFlash()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d())
    {
      p();
      bcef.b(this.app, "CliOper", "", "", "0X8005DD2", "0X8005DD2", 0, 0, "", "", "", "");
    }
    return bool;
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    if (this.n)
    {
      if (this.mTroopTips != null) {
        this.mTroopTips.a();
      }
      HotChatManager.a(this.mContext, this.n);
      return;
    }
    super.leftBackEvent(paramBoolean);
  }
  
  public void messageTips(QQMessageFacade.Message paramMessage) {}
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.sessionInfo.curFriendUin);
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if (localHotChatInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a();
      if (!this.mActivity.getIntent().getBooleanExtra("param_newly_created_hot_chat", false)) {
        ThreadManager.post(new HotChatPie.16(this, localHotChatInfo), 8, null, true);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool1;
    if ((this.jdField_a_of_type_Awng != null) && (this.jdField_a_of_type_Awng.a()))
    {
      this.jdField_a_of_type_Awng.a();
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
          bool2 = super.onBackEvent();
          bool1 = bool2;
        } while (this.isBack2Root);
        bool1 = bool2;
      } while (!this.n);
      bool1 = bool2;
    } while (bool2);
    HotChatManager.a(this.mContext, this.n);
    return bool2;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i;
    QQAppInterface localQQAppInterface;
    if (paramInt == 2131368193)
    {
      i = 1;
      a(i, true);
      localQQAppInterface = this.app;
      if (paramInt != 2131368193) {
        break label72;
      }
    }
    label72:
    for (String str = "clk_hot_room";; str = "clk_see_post")
    {
      bcef.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", str, 0, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      i = 2;
      break;
    }
  }
  
  public void onClickTitleLayout(View paramView) {}
  
  public void onHeadsetChanged(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    super.onHeadsetChanged(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  public void onPanelIconClick(Object paramObject)
  {
    super.onPanelIconClick(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    }
    showGiftPanel(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
    for (paramObject = "507";; paramObject = "503")
    {
      amxb.a("gift_aio", "clk_icon", getCurTroopUin(), paramObject, "", "");
      return;
    }
  }
  
  public void onShow()
  {
    int j = 1;
    o();
    d();
    super.onShow();
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    NearbyTransitActivity.a("AIOShow", 2);
    Object localObject = this.mActivity.getIntent();
    a((Intent)localObject, ((Intent)localObject).getStringExtra("uin"), ((Intent)localObject).getStringExtra("uinname"), ((Intent)localObject).getStringExtra("hotnamecode"), ((Intent)localObject).getBooleanExtra("param_newly_created_hot_chat", false));
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a()) {
      ThreadManager.post(new HotChatPie.9(this), 8, null, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.sessionInfo.curFriendUin);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      this.app.addObserver(this.jdField_a_of_type_Andd);
    }
    h();
    int i;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.need2ReqRedPoint())
      {
        ThreadManager.post(new HotChatPie.10(this), 8, null, true);
        i = j;
      }
      localQQAppInterface = this.app;
      if (i == 0) {
        break label240;
      }
    }
    label240:
    for (localObject = "2";; localObject = "1")
    {
      bcef.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject, "", "", "");
      return;
      a(1, false);
      i = 0;
      break;
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!this.isBeingInputDraft))
    {
      paramCharSequence = (HotChatManager)this.app.getManager(60);
      if (paramCharSequence != null) {}
      for (paramCharSequence = paramCharSequence.a(this.sessionInfo.curFriendUin);; paramCharSequence = null)
      {
        if (paramCharSequence != null)
        {
          Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", bjnd.a(bjnd.a(bjnd.a(bjnd.a(bjnd.a("https://nearby.qq.com/hot_chat/member_list.html", "_wv", "3"), "_bid", "2581"), "gc", paramCharSequence.troopUin), "rid", paramCharSequence.uuid), "from", String.valueOf(1)));
          paramCharSequence = new Bundle();
          paramCharSequence.putBoolean("hide_left_button", true);
          localIntent.putExtras(paramCharSequence);
          getActivity().startActivity(localIntent);
        }
        return;
      }
    }
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void openOptionActivity()
  {
    Object localObject = this.sessionInfo.curFriendUin;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a((String)localObject)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid)))
    {
      localObject = new Intent(this.mActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", bjnd.a(bjnd.a(bjnd.a(bjnd.a(bjnd.a(bjnd.a(bjnd.a("https://nearby.qq.com/hot_chat/room_info.html", "_wv", "3"), "_bid", "2581"), "gc", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin), "rid", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid), "rname", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name), "rtype", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.hotChatType)), "rnum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount)));
      getActivity().startActivity((Intent)localObject);
      bcef.b(this.app, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isGameRoom) {
        bcef.b(this.app, "dc00899", "Grp_wolf", "", "in_game", "clk_grp_card", 0, 0, "", "", "", "");
      }
      return;
    }
    QQToast.a(this.app.getApp(), amtj.a(2131704715), 0).b(this.mActivity.getTitleBarHeight());
  }
  
  public void p()
  {
    QQCustomDialog localQQCustomDialog = bfur.a(this.mContext, 230);
    localQQCustomDialog.setMessage(String.format("需要等级LV%d才能使用闪照功能哦", new Object[] { Integer.valueOf(HotChatManager.a(this.app)) }));
    localQQCustomDialog.setNegativeButton(amtj.a(2131704706), new ahhg(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(amtj.a(2131704699), new ahhh(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  public void refreshListAdapter()
  {
    super.refreshListAdapter();
    if (this.g == 2) {
      this.listView.setVisibility(4);
    }
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Afil);
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.removeObserver(this.jdField_a_of_type_Amua);
  }
  
  public void returnMainFragment()
  {
    super.returnMainFragment();
  }
  
  public void saveTextDraft(SessionInfo paramSessionInfo, avnb paramavnb, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(paramSessionInfo.curFriendUin)) {
      return;
    }
    super.saveTextDraft(paramSessionInfo, paramavnb, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, null);
  }
  
  public void setTag()
  {
    this.tag = "HotChatPie";
  }
  
  public void showGiftPanel(boolean paramBoolean)
  {
    showGiftPanel(paramBoolean, TroopGiftPanel.e);
  }
  
  public void showGiftPanel(boolean paramBoolean, int paramInt)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    View localView = getActivity().getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_Awng == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby(this.app, getActivity(), new ahhj(this), false, false, false, this);
      this.jdField_a_of_type_Awng = new awng(this.app, getActivity(), this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.mAIORootView, true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.setIsPttRoom(false);
    this.jdField_a_of_type_Awng.a(paramBoolean, false, 4);
    hidePanel();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((this.mActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
      playGiftAnimationPlayList(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) && (paramObject != null) && ((paramObject instanceof MessageRecord)) && (this.g == 2)) {
      this.uiHandler.post(new HotChatPie.14(this));
    }
  }
  
  public void updateFriendNick()
  {
    String str = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
    if (!TextUtils.equals(str, this.sessionInfo.curFriendUin)) {
      this.sessionInfo.curFriendNick = str;
    }
  }
  
  public void updateSession_business(Intent paramIntent)
  {
    super.updateSession_business(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = this.app.getHotChatMng(true);
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.sessionInfo.curFriendUin);
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null)
    {
      if (QLog.isColorLevel()) {
        awkj.a("PttShow", new Object[] { "HotChatPie_updateSession_business HotChatInfo is null", this.sessionInfo.curFriendUin });
      }
      finish(0);
    }
    do
    {
      do
      {
        do
        {
          return;
          this.e = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate;
          if ((paramIntent != null) && (paramIntent.getIntExtra("hot_chat_from", 1) == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.c())) {
            amtr.a(this.app, this.mActivity);
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isRobotHotChat);
        this.jdField_b_of_type_JavaLangString = ("" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.robotUin);
        this.jdField_c_of_type_JavaLangString = ContactUtils.getFriendDisplayName(this.app, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(this.sessionInfo.curFriendUin, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this, new ahhi(this));
        paramIntent = (bfdm)this.app.getManager(203);
        paramIntent.b(this.sessionInfo.curFriendUin, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        paramIntent = paramIntent.a(this.sessionInfo.curFriendUin, this.jdField_b_of_type_JavaLangString);
      } while (paramIntent == null);
      try
      {
        new cmd0x934.RspBody().mergeFrom(paramIntent);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntent) {}
    } while (!QLog.isColorLevel());
    QLog.d(this.tag, 2, paramIntent.getMessage());
  }
  
  public void updateSession_updateSubTitle()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum > 0)) {}
    for (int i = 1;; i = 0)
    {
      setSubTitleVisable(true);
      if (i == 0) {
        break;
      }
      this.mSubTilteText.setVisibility(0);
      this.mSubTilteText.setText(String.format(this.mActivity.getString(2131692963), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum) }));
      this.mSubTilteText.setTextSize(1, 12.0F);
      return;
    }
    this.mSubTilteText.setVisibility(8);
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      nny.a("2586", this.app, new ahhn(this), true, 0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(8);
      this.mCustomTitleView.removeView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
    }
    this.mTitleLayout.setVisibility(0);
    this.mSubTitleLayout.setVisibility(0);
    super.updateSession_updateTitle(paramIntent);
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    this.mTitleBtnCall.setVisibility(4);
  }
  
  public void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    this.n = paramIntent.getBooleanExtra("abp_flag", false);
    this.o = paramIntent.getBooleanExtra("is_from_web", false);
    if ((this.o) && (!this.n))
    {
      this.mTitleBtnLeft.setText(2131690424);
      this.mTitleBtnLeft.setContentDescription(amtj.a(2131704705));
      return;
    }
    if (this.n)
    {
      this.mTitleBtnLeft.setText(amtj.a(2131704717));
      this.mTitleBtnLeft.setContentDescription(amtj.a(2131704703));
      return;
    }
    super.updateSession_updateTitleLeftView(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgz
 * JD-Core Version:    0.7.0.1
 */