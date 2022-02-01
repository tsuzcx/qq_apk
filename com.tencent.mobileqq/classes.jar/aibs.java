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
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class aibs
  extends afzn
  implements RadioGroup.OnCheckedChangeListener
{
  protected static final String[] a;
  static long jdField_c_of_type_Long;
  aapk jdField_a_of_type_Aapk = null;
  private afzq jdField_a_of_type_Afzq;
  public amhn a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  anwo jdField_a_of_type_Anwo = new anwp(this);
  anwr jdField_a_of_type_Anwr;
  public anwt a;
  aofu jdField_a_of_type_Aofu = new aibt(this);
  protected axti a;
  protected bgqj a;
  public HotChatManager a;
  public HotChatInfo a;
  protected TroopGiftPanelForNearby a;
  public RedDotRadioButton a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  SegmentedControlView jdField_a_of_type_ComTencentWidgetSegmentedControlView;
  public XListView a;
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
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "@all", anvx.a(2131705058) };
  }
  
  public aibs(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
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
        bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, str, "", "", "");
      }
    }
    for (;;)
    {
      bdla.b(null, "dc00899", "grp_lbs", "", "hot_room", "exp_visit_post", 0, 0, "", "", "", "");
      return;
      label201:
      str = "1";
      break;
      if (paramInt == 2)
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()))
        {
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
          if (this.jdField_a_of_type_Amhn != null) {
            a(0, this.jdField_a_of_type_Amhn.getCount());
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
      paramIntent = anwf.a(paramString3, 1);
      paramIntent = ShareHotChatGrayTips.makeShareGrayTip(ShareHotChatGrayTips.SHARE_GRAY_TIP_CONTENT, anvx.a(2131705062), paramString1, paramString2, paramIntent, paramString3);
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.q = true;
        paramString2 = bcsa.a(-2033);
        long l = bcrg.a();
        paramString3 = this.app.getCurrentAccountUin();
        paramString2.init(paramString3, this.sessionInfo.curFriendUin, paramString3, paramIntent, l, -2033, this.sessionInfo.curType, l);
        paramString2.isread = true;
        if (!anyv.a(this.app, paramString2, false)) {
          this.app.getMessageFacade().addMessage(paramString2, paramString3);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog = anwf.a(this.mActivity, new aibv(this, paramString1));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTitleLayout.setVisibility(8);
      this.mSubTitleLayout.setVisibility(8);
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.mContext).inflate(2131559985, null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(14);
        localLayoutParams.topMargin = 32;
        this.mCustomTitleView.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
        this.mCustomTitleView.b();
        this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = ((SegmentedControlView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368339));
      }
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_c_of_type_AndroidViewView.findViewById(2131368337));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(true);
        this.g = 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_c_of_type_AndroidViewView.findViewById(2131368338));
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
      this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this.mContext).inflate(2131559304, null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_d_of_type_AndroidViewView.findViewById(2131379375));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131366179));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.mContext).inflate(2131559689, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(-1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(10);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(this.mContext.getResources().getDrawable(2130839461));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(30);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new aicd(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new aice(this));
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
      localLayoutParams.addRule(6, 2131370188);
      this.mContent.addView(this.jdField_d_of_type_AndroidViewView, localLayoutParams);
      this.listView.setVisibility(8);
    }
    int i;
    if (bhhr.U(this.mContext, this.app.getCurrentUin()) == 1)
    {
      i = 1;
      if (i == 0) {
        break label400;
      }
      if (this.jdField_a_of_type_Aapk == null)
      {
        this.jdField_a_of_type_Aapk = new aapk(this.mActivity, "QQ_Hotchat_post_list.apk", "2586", "/hotchatPostListPlugin/opt");
        this.jdField_a_of_type_Aapk.a(new aicf(this), false);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() == 8) || ((this.jdField_a_of_type_Amhn != null) && (this.jdField_a_of_type_Amhn.getCount() == 0))) {
        a(0, 10);
      }
      return;
      i = 0;
      break;
      label400:
      if (this.jdField_a_of_type_Amhn == null)
      {
        this.jdField_a_of_type_Amhn = new amhn(this.mContext, null, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amhn);
      }
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.pkFlag != 0))
    {
      if (this.jdField_a_of_type_Anwt == null)
      {
        ThreadManager.post(new HotChatPie.11(this), 5, null, true);
        aibu localaibu = new aibu(this);
        this.jdField_a_of_type_Anwt = new anwt(this.app, localaibu, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
      }
      this.jdField_a_of_type_Anwt.a(10000L);
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
    bkzi localbkzi = bkzi.a(getActivity());
    String str3 = anvx.a(2131705067);
    String str4 = paramChatMessage.getExtInfoFromExtStr("hotchat_gender");
    String str1 = str3;
    try
    {
      if (Integer.parseInt(str4) == 1) {
        str1 = anvx.a(2131705064);
      }
      localbkzi.c(str1);
      localbkzi.a(anvx.a(2131705061), 3);
      localbkzi.c(2131690697);
      localbkzi.a(new aibw(this, localbkzi, paramChatMessage, paramString));
      localbkzi.show();
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
      QQToast.a(getActivity(), anvx.a(2131705047), 0).b(getActivity().getTitleBarHeight());
      return;
    }
    QQToast.a(getActivity(), anvx.a(2131705049), 0).b(getActivity().getTitleBarHeight());
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
        if (this.jdField_a_of_type_Bfxw == null) {
          this.jdField_a_of_type_Bfxw = new bfxw(this.app, this.mActivity, this.sessionInfo, this.mContent, this.mTitleBtnCall, this.mTroopTips, this.jdField_d_of_type_Boolean, null);
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
        this.jdField_a_of_type_Bfxw.a(this.app, this.mContext, paramString2, paramString1);
        if (this.jdField_a_of_type_Anwt != null) {
          this.jdField_a_of_type_Anwt.b = false;
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
    this.app.addObserver(this.jdField_a_of_type_Anwo);
    this.app.addDefaultObservers(this.jdField_a_of_type_Afzq);
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
    this.mTitleBtnRight.setContentDescription(this.mActivity.getString(2131693087));
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
    ((aghq)getHelper(83)).a(false);
    this.jdField_a_of_type_Afzq = new afzq(this);
    this.jdField_a_of_type_Anwr = new anwr(this.mActivity, this.app, null);
    this.jdField_a_of_type_Bgqj = new bgqj(this.app, this.sessionInfo.curFriendUin, "Grp_time", "Grp_AIO", "visit_time");
    return super.doOnCreate(paramBoolean);
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Anwt != null)
    {
      this.jdField_a_of_type_Anwt.b();
      this.jdField_a_of_type_Anwt = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      this.app.removeObserver(this.jdField_a_of_type_Aofu);
      a(1, false);
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.mCustomTitleView.indexOfChild(this.jdField_c_of_type_AndroidViewView) != -1)) {
        this.mCustomTitleView.removeView(this.jdField_c_of_type_AndroidViewView);
      }
      this.jdField_c_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
      this.jdField_d_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_Amhn = null;
      this.jdField_a_of_type_Aapk = null;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_b_of_type_Long;
    bdla.b(this.app, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l1 - l2), String.valueOf(this.e), "", "");
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
    if (this.jdField_a_of_type_Anwr != null) {
      this.jdField_a_of_type_Anwr.a();
    }
    if (this.jdField_a_of_type_Amhn != null) {
      this.jdField_a_of_type_Amhn.c();
    }
    ((bgls)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a();
    if (this.jdField_a_of_type_Bgqj != null) {
      this.jdField_a_of_type_Bgqj.b();
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
    if (this.jdField_a_of_type_Anwt != null) {
      this.jdField_a_of_type_Anwt.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.r = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) && (this.g == 2) && (this.mTroopTips != null)) {
      this.mTroopTips.c(4);
    }
    this.jdField_a_of_type_Bgqj.a();
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
    if (this.jdField_a_of_type_Axti != null) {
      this.jdField_a_of_type_Axti.a();
    }
  }
  
  public boolean isAllowSendFlash()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d())
    {
      p();
      bdla.b(this.app, "CliOper", "", "", "0X8005DD2", "0X8005DD2", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_Axti != null) && (this.jdField_a_of_type_Axti.a()))
    {
      this.jdField_a_of_type_Axti.a();
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
    if (paramInt == 2131368337)
    {
      i = 1;
      a(i, true);
      localQQAppInterface = this.app;
      if (paramInt != 2131368337) {
        break label72;
      }
    }
    label72:
    for (String str = "clk_hot_room";; str = "clk_see_post")
    {
      bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", str, 0, 0, "", "", "", "");
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
      anzp.a("gift_aio", "clk_icon", getCurTroopUin(), paramObject, "", "");
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
      this.app.addObserver(this.jdField_a_of_type_Aofu);
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
      bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject, "", "", "");
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
      paramCharSequence = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if (paramCharSequence != null) {}
      for (paramCharSequence = paramCharSequence.a(this.sessionInfo.curFriendUin);; paramCharSequence = null)
      {
        if (paramCharSequence != null)
        {
          Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a("https://nearby.qq.com/hot_chat/member_list.html", "_wv", "3"), "_bid", "2581"), "gc", paramCharSequence.troopUin), "rid", paramCharSequence.uuid), "from", String.valueOf(1)));
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
      ((Intent)localObject).putExtra("url", bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a(bkyp.a("https://nearby.qq.com/hot_chat/room_info.html", "_wv", "3"), "_bid", "2581"), "gc", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin), "rid", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid), "rname", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name), "rtype", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.hotChatType)), "rnum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount)));
      getActivity().startActivity((Intent)localObject);
      bdla.b(this.app, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isGameRoom) {
        bdla.b(this.app, "dc00899", "Grp_wolf", "", "in_game", "clk_grp_card", 0, 0, "", "", "", "");
      }
      return;
    }
    QQToast.a(this.app.getApp(), anvx.a(2131705066), 0).b(this.mActivity.getTitleBarHeight());
  }
  
  public void p()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(this.mContext, 230);
    localQQCustomDialog.setMessage(String.format("需要等级LV%d才能使用闪照功能哦", new Object[] { Integer.valueOf(HotChatManager.a(this.app)) }));
    localQQCustomDialog.setNegativeButton(anvx.a(2131705057), new aibz(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(anvx.a(2131705050), new aica(this));
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
    this.app.removeObserver(this.jdField_a_of_type_Afzq);
    if (this.app.getProxyManager() != null) {
      this.app.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.removeObserver(this.jdField_a_of_type_Anwo);
  }
  
  public void returnMainFragment()
  {
    super.returnMainFragment();
  }
  
  public void saveTextDraft(SessionInfo paramSessionInfo, awtg paramawtg, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(paramSessionInfo.curFriendUin)) {
      return;
    }
    super.saveTextDraft(paramSessionInfo, paramawtg, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, null);
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
    if (this.jdField_a_of_type_Axti == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby(this.app, getActivity(), new aicc(this), false, false, false, this);
      this.jdField_a_of_type_Axti = new axti(this.app, getActivity(), this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.mAIORootView, true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.setIsPttRoom(false);
    this.jdField_a_of_type_Axti.a(paramBoolean, false, 4);
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
        axql.a("PttShow", new Object[] { "HotChatPie_updateSession_business HotChatInfo is null", this.sessionInfo.curFriendUin });
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
            anwf.a(this.app, this.mActivity);
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isRobotHotChat);
        this.jdField_b_of_type_JavaLangString = ("" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.robotUin);
        this.jdField_c_of_type_JavaLangString = ContactUtils.getFriendDisplayName(this.app, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(this.sessionInfo.curFriendUin, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this, new aicb(this));
        paramIntent = (bgls)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
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
      this.mSubTilteText.setText(String.format(this.mActivity.getString(2131693099), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum) }));
      this.mSubTilteText.setTextSize(1, 12.0F);
      return;
    }
    this.mSubTilteText.setVisibility(8);
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      nuz.a("2586", this.app, new aicg(this), true, 0);
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
      this.mTitleBtnLeft.setText(2131690499);
      this.mTitleBtnLeft.setContentDescription(anvx.a(2131705056));
      return;
    }
    if (this.n)
    {
      this.mTitleBtnLeft.setText(anvx.a(2131705068));
      this.mTitleBtnLeft.setContentDescription(anvx.a(2131705054));
      return;
    }
    super.updateSession_updateTitleLeftView(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibs
 * JD-Core Version:    0.7.0.1
 */