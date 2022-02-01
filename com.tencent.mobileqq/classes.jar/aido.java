import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.10;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.13;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.18;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.28;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.29;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.34;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.35;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.36;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.47;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.48;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.49;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.5;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.53;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.57;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.62;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.63;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.8;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.9;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.PublicMenuBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.XPanelContainer;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aido
  extends BaseChatPie
{
  public boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private boolean J;
  private boolean K;
  private boolean L;
  private boolean M;
  public int a;
  long jdField_a_of_type_Long = -1L;
  private aifk jdField_a_of_type_Aifk;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Handler a;
  protected SpannableString a;
  public View.OnClickListener a;
  public View a;
  protected ImageView a;
  protected LinearLayout a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi;
  protected anyz a;
  public aoav a;
  private apar jdField_a_of_type_Apar;
  public avli a;
  public bfhm a;
  bisl jdField_a_of_type_Bisl;
  public bjxa a;
  public bjyh a;
  bkzi jdField_a_of_type_Bkzi;
  public CustomMenuBar a;
  public PublicAccountHandler a;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  public PublicAccountInfo a;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  PublicMenuBar jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = null;
  protected PatchedButton a;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new aifb(this);
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new aieg(this);
  public okn a;
  public onc a;
  onv jdField_a_of_type_Onv = new aiex(this);
  private ooy jdField_a_of_type_Ooy;
  public int[] a;
  public int b;
  long jdField_b_of_type_Long = -1L;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  protected SpannableString b;
  public View b;
  protected ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private apar jdField_b_of_type_Apar;
  private PublicMenuBar jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  public String b;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_b_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = -1L;
  View jdField_c_of_type_AndroidViewView;
  public ImageView c;
  public String c;
  private NewIntent jdField_c_of_type_MqqAppNewIntent;
  public boolean c;
  int jdField_d_of_type_Int = 3;
  long jdField_d_of_type_Long = 0L;
  View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  public String d;
  public boolean d;
  protected int e;
  private long jdField_e_of_type_Long = 9223372036854775807L;
  View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  public String e;
  boolean jdField_e_of_type_Boolean = false;
  protected int f;
  private long jdField_f_of_type_Long;
  private View jdField_f_of_type_AndroidViewView;
  public String f;
  boolean jdField_f_of_type_Boolean = false;
  public int g;
  private long jdField_g_of_type_Long;
  private View jdField_g_of_type_AndroidViewView;
  public String g;
  boolean jdField_g_of_type_Boolean = false;
  public int h;
  private long jdField_h_of_type_Long;
  private View jdField_h_of_type_AndroidViewView;
  public String h;
  public boolean h;
  public int i;
  private long jdField_i_of_type_Long;
  private View jdField_i_of_type_AndroidViewView;
  public String i;
  public boolean i;
  public int j;
  private String j;
  public boolean j;
  private int jdField_k_of_type_Int;
  boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int;
  boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int;
  boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int;
  boolean jdField_n_of_type_Boolean = false;
  private int jdField_o_of_type_Int;
  boolean jdField_o_of_type_Boolean = false;
  private int jdField_p_of_type_Int = -1;
  boolean jdField_p_of_type_Boolean = false;
  private int q;
  public boolean q;
  private int jdField_r_of_type_Int;
  boolean jdField_r_of_type_Boolean = false;
  private int jdField_s_of_type_Int;
  boolean jdField_s_of_type_Boolean = false;
  private int t;
  public boolean t;
  private int u;
  public boolean u;
  boolean v = false;
  public boolean w = false;
  boolean x = false;
  boolean y = false;
  boolean z = false;
  
  public aido(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -1;
    this.jdField_e_of_type_Int = 2130838008;
    this.jdField_f_of_type_Int = 2130838007;
    this.jdField_q_of_type_Int = -1;
    this.jdField_a_of_type_Avli = new avli("web_public_account", "com.tencent.mobileqq:tool");
    this.jdField_a_of_type_AndroidOsHandler = new aidp(this);
    this.jdField_a_of_type_Anyz = new aidq(this);
    this.jdField_a_of_type_Aoav = new aiew(this);
    this.jdField_a_of_type_Bjyh = new aifc(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aifg(this);
  }
  
  private void A()
  {
    PublicAccountInfo localPublicAccountInfo = ((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.sessionInfo.curFriendUin);
    if ((localPublicAccountInfo != null) && (uuc.a(localPublicAccountInfo.accountFlag) == -2))
    {
      this.H = true;
      e();
      this.jdField_a_of_type_Bfhm.f();
      if (this.jdField_a_of_type_Bfhm.jdField_b_of_type_Int <= 0)
      {
        this.jdField_a_of_type_Bfhm.a(Long.valueOf(this.sessionInfo.curFriendUin).longValue(), 1);
        return;
      }
      int i2 = ((bgiy)this.app.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.sessionInfo.curFriendUin);
      if (i2 == -1)
      {
        this.jdField_a_of_type_Bfhm.a(Long.valueOf(this.sessionInfo.curFriendUin).longValue(), 2);
        return;
      }
      int i1;
      if ((i2 & 0xF) == 0)
      {
        i1 = 1;
        if (i2 >> 4 != 1) {
          break label180;
        }
        i2 = 1;
        label157:
        if ((i1 == 0) || (i2 == 0)) {
          break label185;
        }
        this.I = true;
      }
      for (;;)
      {
        I();
        return;
        i1 = 0;
        break;
        label180:
        i2 = 0;
        break label157;
        label185:
        this.jdField_a_of_type_Bfhm.e();
        this.jdField_a_of_type_Bfhm.b();
      }
    }
    I();
  }
  
  private void B()
  {
    if ((NetworkUtil.getNetworkType(this.mActivity.getApplicationContext()) == 1) && (this.sessionInfo.curFriendUin != null) && (this.sessionInfo.curFriendUin.equals("2632129500"))) {
      nuz.b("108", this.app, true, new aife(this));
    }
  }
  
  private void C()
  {
    if ("3105932915".equals(this.sessionInfo.curFriendUin))
    {
      blqh localblqh = (blqh)this.app.getManager(QQManagerFactory.QQCOMIC_PRELOAD_MANAGER);
      if (localblqh != null) {
        blqe.a(localblqh.a(5));
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "the public account is boodo comic");
      }
      albi.a().a("com.tencent.qqcomic.care");
      albi.a().a("com.tencent.carecomic.normal");
      albi.a().a("com.tencent.carecomic.update");
    }
  }
  
  private void D()
  {
    if (uuc.a(this.sessionInfo.curFriendUin))
    {
      WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
      if (localWebProcessManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "doOnCreate, preload web process");
        }
        localWebProcessManager.e();
      }
    }
  }
  
  private void E()
  {
    if (this.jdField_h_of_type_Boolean) {
      if (this.jdField_i_of_type_Boolean) {
        olh.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.sessionInfo.curFriendUin, "new", "", "", false);
      }
    }
    for (;;)
    {
      pwb.a().a(this.sessionInfo.curFriendUin);
      if (((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(this.sessionInfo.curFriendUin)) {
        this.jdField_d_of_type_Boolean = true;
      }
      return;
      olh.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.sessionInfo.curFriendUin, "old", "", "", false);
      continue;
      olh.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.sessionInfo.curFriendUin, "", "", "", false);
      if ("2290230341".equals(this.sessionInfo.curFriendUin))
      {
        bdla.b(this.app, "CliOper", "", "", "0X80090E2", "0X80090E2", 0, 0, "", "", "", "");
        bdkx.a(2);
      }
    }
  }
  
  private void F()
  {
    if ((i()) && (this.jdField_o_of_type_Int > 0)) {
      ThreadManagerV2.excute(new PublicAccountChatPie.7(this), 16, null, false);
    }
  }
  
  private void G()
  {
    if (ahcf.a(this.sessionInfo.curFriendUin)) {
      amed.a().a(this.app, "aio_page_arrive");
    }
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    }
    hideBottomBar();
    handleNightMask();
  }
  
  private void I()
  {
    ThreadManager.postImmediately(new PublicAccountChatPie.9(this), null, true);
  }
  
  private void J()
  {
    Iterator localIterator = this.listAdapter.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatMessage)localIterator.next();
      if (MessageForStructing.class.isInstance(localObject))
      {
        localObject = ((MessageForStructing)localObject).structingMsg;
        if (StructMsgForGeneralShare.class.isInstance(localObject)) {
          ((StructMsgForGeneralShare)localObject).unInitPay();
        }
      }
    }
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()))
    {
      this.jdField_a_of_type_Bisl.dismiss();
      this.jdField_a_of_type_Bisl = null;
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_Bfhm != null) {
      this.jdField_a_of_type_Bfhm.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.d();
    }
  }
  
  private void K()
  {
    if (this.mActivity.getIntent().getExtras() == null) {
      finish();
    }
  }
  
  private void L()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.mActivity.getBaseContext()).inflate(2131558647, this.mContent, false);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131368381).setOnClickListener(new aidw(this));
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131373317).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131373303).setVisibility(8);
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(2131299080);
      this.mContent.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      if (this.v)
      {
        this.jdField_a_of_type_AndroidViewView.findViewById(2131373317).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131373303).setVisibility(8);
      }
    }
  }
  
  private void M()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = ((PublicMenuBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131373300));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setOnMenuItemClickListener(new aidy(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.b();
    Object localObject;
    int i1;
    aako localaako1;
    if (!this.v)
    {
      localObject = this.mActivity;
      if (this.I)
      {
        i1 = 2131691774;
        localObject = new aako("DO_NOT_FOLLOW", ((FragmentActivity)localObject).getString(i1), getActivity().getResources().getDrawable(2130841778), 0);
        localaako1 = new aako("DO_FOLLOW", this.mActivity.getString(2131691772), getActivity().getResources().getDrawable(2130841671), 1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((aako)localObject, 2131560035);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localaako1, 2131560035);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setSwitchButtonVisibility(false);
      if (!this.K) {
        break label338;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(8);
      return;
      i1 = 2131691773;
      break;
      localObject = new aako("DO_CANCEL", this.mActivity.getString(2131690699), getActivity().getResources().getDrawable(2130841778), 0);
      localaako1 = new aako("DO_FOLLOW", this.mActivity.getString(2131691772), getActivity().getResources().getDrawable(2130841671), 1);
      aako localaako2 = new aako("DO_NOT_FOLLOW", this.mActivity.getString(2131691774), getActivity().getResources().getDrawable(2130841778), 0);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((aako)localObject, 2131560035);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localaako2, 2131560035);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localaako1, 2131560035);
    }
    label338:
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(0);
  }
  
  private void N()
  {
    String str = this.app.getCurrentUin();
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("op", "0");
      localBundle.putString("puin", "" + this.sessionInfo.curFriendUin);
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      localBundle.putString("Referer", "https://buluo.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.app.getApp().getApplicationContext());
      new bghj("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new aied(this), 1000, null).a(localHashMap);
      c();
      return;
    }
  }
  
  private void O()
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new aiej(this));
  }
  
  private void P()
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new aiek(this));
  }
  
  private void Q()
  {
    SharedPreferences localSharedPreferences = this.mActivity.getSharedPreferences("public_aio_setting", 0);
    String str = "firstOpen_" + this.sessionInfo.curFriendUin;
    if (localSharedPreferences.getBoolean(str, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = ((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.sessionInfo.curFriendUin);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_a_of_type_Okn.a(this.mActivity, this.app, this.sessionInfo.curFriendUin, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.34(this, localSharedPreferences, str));
  }
  
  private void R()
  {
    if (this.jdField_g_of_type_Long == 0L) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
    } while (this.app == null);
    Object localObject = this.app.getCurrentAccountUin();
    if (localObject != null) {
      localHashMap.put("uin", localObject);
    }
    if ((this.sessionInfo != null) && (this.sessionInfo.curFriendUin != null)) {
      localHashMap.put("puin", this.sessionInfo.curFriendUin);
    }
    localHashMap.put("menu_click", "" + this.jdField_g_of_type_Int);
    localHashMap.put("menu_to_webview", "" + this.jdField_i_of_type_Int);
    localHashMap.put("article_click", "" + this.jdField_h_of_type_Int);
    localHashMap.put("article_to_webview", "" + this.jdField_j_of_type_Int);
    localHashMap.put("net_type", "" + NetworkCenter.getInstance().getNetType());
    localHashMap.put("unread_count", "" + this.jdField_o_of_type_Int);
    long l1 = System.currentTimeMillis() - this.jdField_g_of_type_Long;
    if ((this.jdField_j_of_type_Int != 0) || (this.jdField_i_of_type_Int != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("public account webview preload data: ");
        ((StringBuilder)localObject).append("duration: ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", entered: ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", exinfo: ");
        ((StringBuilder)localObject).append(localHashMap.toString());
        QLog.d(this.tag, 2, ((StringBuilder)localObject).toString());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPublicAccountWebviewPreload", bool, l1, 0L, localHashMap, "");
      this.jdField_g_of_type_Long = 0L;
      this.jdField_o_of_type_Int = 0;
      this.jdField_i_of_type_Int = 0;
      this.jdField_g_of_type_Int = 0;
      this.jdField_h_of_type_Int = 0;
      this.jdField_j_of_type_Int = 0;
      return;
    }
  }
  
  private void S()
  {
    bdla.b(this.app, "CliOper", "", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
    bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
    bhfm.a(null, "pubAcc_profile_display", "");
  }
  
  private void T()
  {
    if (this.K) {
      bdla.b(null, "dc00898", "", this.sessionInfo.curFriendUin, "auth_aio", "clk_return", 0, 0, "", "", this.sessionInfo.curFriendNick, "");
    }
  }
  
  private void U()
  {
    if (this.root.a() == 2)
    {
      this.root.a();
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(this.jdField_e_of_type_Int);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.app.getApp().getString(2131689974));
      }
    }
    do
    {
      return;
      this.root.a(2);
    } while (this.jdField_c_of_type_AndroidWidgetImageView == null);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(this.jdField_f_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(this.app.getApp().getString(2131689973));
  }
  
  private void V()
  {
    ShortVideoUtils.loadShortVideoSo(this.app);
    aghq localaghq = (aghq)getHelper(83);
    if (this.root.a() == 8)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.app.getApplication().getString(2131689957));
      }
      localaghq.b(true);
      this.root.a(1);
      return;
    }
    localaghq.b();
    this.root.a(8);
    if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      b(false);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.app.getApplication().getString(2131689881));
    }
    setInputStat(0);
  }
  
  private void W()
  {
    if (this.mInputStat != 1)
    {
      if (this.root.a() != 3) {
        break label85;
      }
      this.root.a(1);
      bdla.b(this.app, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.app.getApplication().getString(2131689957));
      }
      return;
      label85:
      this.root.a(3);
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        b(false);
      }
      bdla.b(this.app, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
    }
  }
  
  private void X()
  {
    long l1 = System.currentTimeMillis();
    if ((QLog.isColorLevel()) && (this.jdField_c_of_type_AndroidWidgetImageView != null)) {
      QLog.d(this.tag, 2, " onClick fun_btn start mInputStat = " + this.mInputStat + " text.length " + this.input.getText().length() + "mAudioBtn visibility:" + this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() + " currentPanel:" + this.root.a() + " currenttime:" + System.currentTimeMillis());
    }
    if ((this.input.getText().length() > 0) && (this.root.a() != 2) && (this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0))
    {
      send();
      if (ahcf.a(this.sessionInfo.curFriendUin))
      {
        if ((this.root.a() == 1) && (((InputMethodManager)this.mContext.getSystemService("input_method")).isActive(this.input))) {
          this.root.a();
        }
        amed.a().a(this.app, "aio_search_push");
      }
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, " onClick fun_btn end mInputStat = " + this.mInputStat + "text.length" + this.input.getText().length() + "cast time :" + (l2 - l1));
      }
      olh.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800584F", "0X800584F", 0, 0, "", "", "", "", false);
    }
    if (this.jdField_h_of_type_Boolean) {
      bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "0X8005C9C", "0X8005C9C", 0, 1, 0, "", "", "", "");
    }
  }
  
  private void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    if (!this.mActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((aoan)localObject).c(this.sessionInfo.curFriendUin);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      return;
    }
    Object localObject = new NewIntent(this.mActivity.getApplicationContext(), oln.class);
    ((NewIntent)localObject).putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.4.10,3,4875");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.sessionInfo.curFriendUin));
      label164:
      ((NewIntent)localObject).putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new aiel(this));
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label164;
    }
  }
  
  private void Z()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
    }
    Object localObject = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((aoan)localObject).a(this.sessionInfo.curFriendUin);
      if (localObject != null)
      {
        this.mTitleText.setText(((AccountDetail)localObject).name);
        if (this.jdField_c_of_type_Boolean)
        {
          c((AccountDetail)localObject);
          this.jdField_c_of_type_Boolean = false;
        }
        if (this.jdField_a_of_type_AndroidAppDialog == null) {}
        h();
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
      b();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return;
    case 3: 
      if ((paramInt2 > paramInt1) && (!this.D))
      {
        this.jdField_l_of_type_Int = this.jdField_g_of_type_AndroidViewView.getLayoutParams().height;
        a(this.jdField_g_of_type_AndroidViewView);
        this.D = true;
      }
      this.jdField_d_of_type_Int = 2;
      this.jdField_o_of_type_Boolean = true;
      return;
    }
    if ((paramInt2 == paramInt1) && (this.D))
    {
      if (this.jdField_l_of_type_Int != 0) {
        a(this.jdField_g_of_type_AndroidViewView, this.jdField_l_of_type_Int);
      }
      this.D = false;
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_d_of_type_Int = 2;
    this.jdField_o_of_type_Boolean = true;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      b(paramInt1, paramInt4);
      return;
    }
    b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void a(Intent paramIntent)
  {
    try
    {
      if (onx.a(this.sessionInfo))
      {
        albi.a().a("com.tencent.gouwu.video");
        albi.a().a("com.tencent.gwh.video");
        ArkAppNotifyCenter.registVolumnReceiver();
        if (j())
        {
          if (ope.b()) {
            albi.a().a("com.tencent.qqshop");
          }
          b(paramIntent);
          return;
        }
        paramIntent = (onx)this.app.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
        if (paramIntent != null)
        {
          paramIntent.a(null, null, false, null, 2);
          return;
        }
      }
    }
    catch (Throwable paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountChatPie", 2, paramIntent, new Object[0]);
      }
    }
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = paramMessage.getData();
    if (paramMessage != null)
    {
      this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilMap.put(paramMessage.getString("troopUin"), Integer.valueOf(this.app.getConversationFacade().a(paramMessage.getString("troopUin"), 1)));
      this.jdField_a_of_type_Bfhm.d();
      this.jdField_a_of_type_Bfhm.e();
      this.jdField_a_of_type_Bfhm.c();
    }
  }
  
  private void a(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.input.getLineCount() > 1)) {
      g(80);
    }
    while (!CustomMenuBar.a()) {
      return;
    }
    g(16);
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.addUpdateListener(new aidr(this, paramView, paramInt1, paramInt2));
    localValueAnimator.addListener(paramAnimatorListener);
    localValueAnimator.setDuration(500L).start();
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    SharedPreferences localSharedPreferences = this.mActivity.getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("firstIntoAIO", true))
    {
      LinearLayout localLinearLayout = new LinearLayout(this.mActivity);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.parseColor("#B3000000"));
      localLinearLayout.setVisibility(0);
      localLinearLayout.setClickable(true);
      localLinearLayout.setOnClickListener(new aiev(this, paramRelativeLayout, localLinearLayout));
      Object localObject = new ImageView(this.mActivity);
      ((ImageView)localObject).setImageResource(2130841678);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      Resources localResources = this.mActivity.getResources();
      localLayoutParams.width = AIOUtils.dp2px(73.0F, localResources);
      localLayoutParams.height = AIOUtils.dp2px(73.0F, localResources);
      localLayoutParams.topMargin = AIOUtils.dp2px(100.0F, localResources);
      localLayoutParams.gravity = 17;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      localObject = new TextView(this.mActivity);
      ((TextView)localObject).setText(anvx.a(2131708256));
      ((TextView)localObject).setTextSize(2, 18.0F);
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = AIOUtils.dp2px(28.0F, localResources);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      paramRelativeLayout.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
      localSharedPreferences.edit().putBoolean("firstIntoAIO", false).commit();
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountChatPie.29(this, paramAccountDetail), 10L);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    try
    {
      achv.a(1, 2, onq.a(paramMessageForArkApp));
      return;
    }
    catch (Exception paramMessageForArkApp)
    {
      paramMessageForArkApp.printStackTrace();
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = paramMessageForStructing.structingMsg;
    if ((paramMessageForStructing instanceof StructMsgForGeneralShare))
    {
      paramMessageForStructing = ((StructMsgForGeneralShare)paramMessageForStructing).mStructMsgItemLists;
      if ((paramMessageForStructing != null) && (!paramMessageForStructing.isEmpty()))
      {
        paramMessageForStructing = paramMessageForStructing.iterator();
        label145:
        do
        {
          for (;;)
          {
            if (!paramMessageForStructing.hasNext()) {
              break label168;
            }
            Object localObject = (bdnu)paramMessageForStructing.next();
            if (!(localObject instanceof bdrp)) {
              break label145;
            }
            localObject = ((bdrp)localObject).a;
            if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
            {
              localObject = ((ArrayList)localObject).iterator();
              if (((Iterator)localObject).hasNext())
              {
                bdnu localbdnu = (bdnu)((Iterator)localObject).next();
                if (!(localbdnu instanceof bdte)) {
                  break;
                }
                try
                {
                  achv.a(1, 2, onq.a(localbdnu));
                }
                catch (Throwable localThrowable)
                {
                  QLog.e(this.tag, 1, localThrowable, new Object[0]);
                }
              }
            }
          }
        } while ((!(localThrowable instanceof bdrr)) && (!(localThrowable instanceof bdsf)));
      }
    }
    try
    {
      achv.a(1, 2, onq.a(localThrowable));
      label168:
      return;
    }
    catch (Throwable paramMessageForStructing)
    {
      QLog.e(this.tag, 1, paramMessageForStructing, new Object[0]);
    }
  }
  
  private void a(String paramString, int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("need_report", false))
    {
      PublicAccountHandler.a(this.app, this.sessionInfo.curFriendUin, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
      long l1 = paramIntent.getLongExtra("incoming_msguid", 0L);
      long l2 = paramIntent.getLongExtra("incoming_shmsgseq", 0L);
      if (l1 > 0L) {
        ThreadManager.post(new PublicAccountChatPie.36(this, paramString, paramInt, l1, l2), 5, null, true);
      }
    }
    if (paramIntent.hasExtra("need_report")) {
      paramIntent.removeExtra("need_report");
    }
  }
  
  private void a(List<ChatMessage> paramList, List<Long> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList2 == null) || (paramList3 == null) || (paramList4 == null) || (paramChatMessage == null)) {}
    label355:
    do
    {
      for (;;)
      {
        return;
        try
        {
          if ((!paramChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("")) && (!paramChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("true")))
          {
            paramList.add(paramChatMessage);
            str2 = paramChatMessage.getExtInfoFromExtStr("pa_msgId");
            str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = "0";
            }
            long l1 = Long.parseLong(str1);
            if (paramChatMessage.getExtInfoFromExtStr("pa_should_report").equals("true"))
            {
              paramList1.add(Long.valueOf(l1));
              if (QLog.isColorLevel()) {
                QLog.d(this.tag, 2, "Report message at index: " + String.valueOf(paramInt) + ". MessageId is " + l1);
              }
            }
            paramChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
            str1 = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
            paramList1 = str1;
            if (str1 == null) {
              paramList1 = "";
            }
            olh.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "0X80057C4", "0X80057C4", 0, 0, this.sessionInfo.curFriendUin, String.valueOf(l1), paramList1, "", false);
          }
          if (paramChatMessage.getExtInfoFromExtStr("ad_msgHasRead").equals("false"))
          {
            paramChatMessage.saveExtInfoToExtStr("ad_msgHasRead", "true");
            str2 = paramChatMessage.getExtInfoFromExtStr("pa_msgId");
            str3 = paramChatMessage.getExtInfoFromExtStr("gdt_msgClick");
            str1 = "0";
            str4 = paramChatMessage.getExtInfoFromExtStr("gdt_view_id");
          }
        }
        catch (Exception paramList)
        {
          String str2;
          String str3;
          String str4;
          JSONObject localJSONObject;
          paramList.printStackTrace();
          return;
        }
      }
      try
      {
        localJSONObject = new JSONObject(str3);
        paramList1 = str1;
        if (localJSONObject.has("ad_id")) {
          paramList1 = localJSONObject.getString("ad_id");
        }
      }
      catch (Exception paramList1)
      {
        paramList1 = str1;
        if (!QLog.isColorLevel()) {
          break label355;
        }
        QLog.d(this.tag, 2, " parse ad_id error");
        paramList1 = str1;
        break label355;
      }
      paramList2.add(str2);
      this.jdField_b_of_type_JavaUtilList.add(paramList1);
      paramList3.add(str3);
      paramList4.add(str4);
    } while (paramList.contains(paramChatMessage));
    paramList.add(paramChatMessage);
  }
  
  private boolean a(Intent paramIntent, String paramString)
  {
    if ((paramString != null) && (paramString.equals("starShortcut")))
    {
      okn.a(this.mActivity, this.app, paramIntent.getStringExtra("starhomeurl"), paramIntent.getStringExtra("uin"), paramString);
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView)
  {
    boolean bool = false;
    paramView = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    String str;
    if (uot.e(this.app, this.sessionInfo.curFriendUin))
    {
      str = (String)onq.jdField_a_of_type_JavaUtilHashMap.get(this.sessionInfo.curFriendUin);
      if (TextUtils.isEmpty(str)) {
        bool = true;
      }
    }
    else
    {
      return bool;
    }
    Intent localIntent = new Intent(this.mContext, SplashActivity.class);
    localIntent.putExtra("uin", str);
    localIntent = AIOUtils.setOpenAIOIntent(localIntent, null);
    if (paramView.b(str)) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      this.mContext.startActivity(localIntent);
      bdla.b(this.app, "CliOper", "", "", "Shop_customservice", "Clk_shopcustomservice", 0, 0, "", "", this.sessionInfo.curFriendUin, this.app.getCurrentAccountUin());
      return false;
      localIntent.putExtra("uintype", 1005);
      localIntent.putExtra("uinname", this.sessionInfo.curFriendNick + anvx.a(2131708237));
      localIntent.putExtra("key_sub_title_from", "来自\"QQ咨询\"");
    }
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null) {}
    for (localObject = ((aoan)localObject).b(paramString);; localObject = null)
    {
      if (localObject == null)
      {
        paramQQAppInterface = paramQQAppInterface.getMessageFacade();
        if (paramQQAppInterface != null)
        {
          paramString = paramQQAppInterface.getLastMessage(paramString, 1008);
          if ((paramString != null) && (paramString.msgtype == -2011))
          {
            paramQQAppInterface = new MessageForStructing();
            MessageForStructing.copyMessageRecordBaseField(paramQQAppInterface, paramString);
            paramQQAppInterface.parse();
            if ((paramQQAppInterface.structingMsg != null) && ((paramQQAppInterface.structingMsg.mPromotionType == 1) || (paramQQAppInterface.structingMsg.mPromotionType == 2))) {
              return true;
            }
          }
        }
      }
      return false;
    }
  }
  
  private boolean a(List<mobileqq_mp.ButtonInfo> paramList)
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    if (this.sessionInfo != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_Okn.b(getCurFriendUin()));
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (this.mInputBar != null) {
        this.mInputBar.setVisibility(0);
      }
      if (this.mFakeInput != null) {
        this.mFakeInput.setVisibility(0);
      }
      if (this.mFakeUpInput != null) {
        this.mFakeUpInput.setVisibility(0);
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      bool = true;
    }
    while (this.jdField_d_of_type_AndroidWidgetImageView == null) {
      return bool;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    return false;
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 0)
    {
      olh.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.sessionInfo.curFriendUin, "", "", "", false);
      Object localObject = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject != null)
      {
        localObject = ((aoan)localObject).a(this.sessionInfo.curFriendUin);
        if (localObject != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
          }
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(localObject);
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_g_of_type_Boolean = true;
        c();
        if (this.v)
        {
          localObject = (PlusPanel)this.panelManager.a(8);
          if (localObject != null) {
            ((PlusPanel)localObject).a();
          }
        }
        return paramBoolean;
        a();
        paramBoolean = false;
        continue;
        a();
        paramBoolean = false;
      }
    }
    if (paramInt == 58)
    {
      b(2131694979);
      return paramBoolean;
    }
    if (paramInt == 65)
    {
      b(2131694954);
      return paramBoolean;
    }
    b(2131694983);
    return paramBoolean;
  }
  
  private void aa()
  {
    this.app.removeObserver(this.jdField_a_of_type_Apar);
    this.jdField_a_of_type_Apar = new apar(new aier(this));
    this.app.addObserver(this.jdField_a_of_type_Apar);
    apaw.a(this.app, true, this.sessionInfo.curFriendUin, 0);
  }
  
  private void ab()
  {
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(this.mActivity.getApplicationContext(), oln.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).ext.set("4");
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.sessionInfo.curFriendUin));
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new aies(this);
    this.jdField_c_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.app.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
  }
  
  private void ac()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      aoan localaoan = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localaoan != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localaoan.c(this.sessionInfo.curFriendUin);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      ad();
    }
  }
  
  private void ad()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.mActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        this.mActivity.requestPermissions(new aiet(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      ae();
      return;
    }
    ae();
  }
  
  private void ae()
  {
    SosoInterface.startLocation(new aieu(this, 1, true, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void af()
  {
    a((RelativeLayout)this.root.getParent());
  }
  
  private void ag()
  {
    Object localObject = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((aoan)localObject).b(this.sessionInfo.curFriendUin);
      if ((localObject != null) && (uuc.a(((PublicAccountInfo)localObject).accountFlag2) == -10L))
      {
        this.K = true;
        localObject = FaceDrawable.getFaceDrawable(this.app, 115, this.sessionInfo.curFriendUin);
        if (localObject != null)
        {
          if (this.mTitleBtnRight != null) {
            this.mTitleBtnRight.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          }
          this.mCustomTitleView.setRight1Icon((Drawable)localObject);
        }
      }
    }
  }
  
  private void ah()
  {
    if (this.jdField_i_of_type_Long == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_i_of_type_Long;
    PublicAccountInfo localPublicAccountInfo = ((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.sessionInfo.curFriendUin);
    if (localPublicAccountInfo != null) {
      alhu.a(this.app, localPublicAccountInfo.uin + "", l1 - l2, localPublicAccountInfo.name + "");
    }
    this.jdField_i_of_type_Long = 0L;
  }
  
  private void ai()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aifi(this);
    this.mContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void aj()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      return;
    }
    try
    {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PublicAccountChatPie", 2, "unregisterNetworkChangedReceiver error", localException);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (((paramInt2 > 5) && (this.jdField_n_of_type_Boolean)) || ((paramInt1 == this.listView.getHeaderViewsCount()) && (paramInt2 > 0) && (this.jdField_n_of_type_Boolean) && (!this.jdField_e_of_type_Boolean)))
    {
      this.jdField_e_of_type_Boolean = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_l_of_type_Int);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setAnimationListener(new aidv(this));
      this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt4 < -5) && (this.jdField_n_of_type_Boolean)) || (((this.jdField_f_of_type_Boolean) || ((paramInt1 + paramInt2 == paramInt3) && (paramInt4 < 0) && (this.jdField_n_of_type_Boolean))) && (!this.jdField_e_of_type_Boolean)))
    {
      this.jdField_e_of_type_Boolean = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_l_of_type_Int, 0.0F);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setAnimationListener(new aidu(this));
      this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
  }
  
  private void b(Intent paramIntent)
  {
    try
    {
      this.B = paramIntent.getBooleanExtra("jump_minusonescreen_view", false);
      this.C = paramIntent.getBooleanExtra("req_qgg_hide_tab", false);
      QLog.i(this.tag, 2, "---isHideTab---" + this.C);
      if (this.B)
      {
        this.jdField_a_of_type_Ooy = new oov();
        if (this.jdField_a_of_type_Ooy.a(this.mContext, this.mContent)) {
          H();
        }
      }
      else
      {
        this.jdField_a_of_type_Ooy = new oox();
        if ((!this.C) && (this.jdField_a_of_type_Ooy.a(this.mContext, this.mContent)))
        {
          H();
          this.listView.post(new PublicAccountChatPie.8(this));
        }
        paramIntent = (onx)this.app.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
        if (paramIntent != null)
        {
          paramIntent.a(null, null, false, null, 10);
          return;
        }
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e(this.tag, 1, QLog.getStackTraceString(paramIntent));
    }
  }
  
  private void b(Message paramMessage)
  {
    if (this.mActivity.isFinishing()) {}
    while (paramMessage.arg2 != 1) {
      return;
    }
    int i1 = paramMessage.arg1;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.mContext, 230, null, String.format(anvx.a(2131708211), new Object[] { (String)paramMessage.obj }), anvx.a(2131708225), anvx.a(2131708221), new aidx(this, i1), null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    localEntityManager.remove(paramAccountDetail);
    localEntityManager.close();
  }
  
  private void b(MessageForStructing paramMessageForStructing)
  {
    int i1 = 0;
    if (paramMessageForStructing.structingMsg == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramMessageForStructing.structingMsg;
      this.jdField_j_of_type_JavaLangString = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
      this.jdField_a_of_type_Int = paramMessageForStructing.structingMsg.mPromotionType;
      this.jdField_b_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMsg;
      this.jdField_c_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMenus;
      this.jdField_b_of_type_Int = paramMessageForStructing.structingMsg.mPromotionMenuDestructiveIndex;
      try
      {
        if (this.jdField_c_of_type_JavaLangString == null) {
          continue;
        }
        this.L = false;
        paramMessageForStructing = this.jdField_c_of_type_JavaLangString.split(",");
        if (paramMessageForStructing == null) {
          continue;
        }
        int i2 = paramMessageForStructing.length;
        this.jdField_a_of_type_ArrayOfInt = new int[i2];
        while (i1 < i2)
        {
          paramMessageForStructing[i1] = paramMessageForStructing[i1].trim();
          this.jdField_a_of_type_ArrayOfInt[i1] = Integer.parseInt(paramMessageForStructing[i1]);
          i1 += 1;
        }
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        this.L = true;
      }
    }
  }
  
  private void b(AbsListView paramAbsListView)
  {
    try
    {
      if (onx.a(this.sessionInfo))
      {
        int i2 = paramAbsListView.getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = paramAbsListView.getChildAt(i1);
          if (localView != null) {
            achy.a().a(localView);
          }
          i1 += 1;
        }
      }
      return;
    }
    catch (Throwable paramAbsListView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountChatPie", 2, paramAbsListView, new Object[0]);
      }
    }
  }
  
  private void b(String paramString)
  {
    AIOUtils.isUserOperatedInAIO = true;
    this.jdField_a_of_type_Bisl = new bisl(this.mContent.getContext(), this.mActivity.getTitleBarHeight());
    long l1 = NetConnInfoCenter.getServerTime();
    String str2 = this.sessionInfo.curFriendUin;
    String str1;
    if ("DO_FOLLOW".equals(paramString)) {
      if (this.I)
      {
        N();
        str1 = "";
        paramString = str1;
        if (this.jdField_a_of_type_Bfhm != null)
        {
          paramString = str1;
          if (this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList != null)
          {
            paramString = str1;
            if (this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList.size() > 0) {
              paramString = ((TroopInfo)this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
            }
          }
        }
        bdla.b(this.app, "dc00899", "Grp_public", "", "oper", "Clk_close_temp", 0, 0, paramString, "" + str2, "", "");
        this.jdField_a_of_type_Okn.a(this.mActivity, this.app, this.app.getAccount(), this.sessionInfo.curFriendUin, new aidz(this));
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
        olh.a(this.app, "CliOper", "", str2, "0X8004EF5", "0X8004EF5", 0, 0, Long.toString(l1), "", "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, this.jdField_j_of_type_JavaLangString, false);
      }
      a(2131695032);
      i();
      return;
      if ("DO_NOT_FOLLOW".equals(paramString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
          olh.a(this.app, "CliOper", "", str2, "0X8004EF7", "0X8004EF7", 0, 0, Long.toString(l1), "", "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "" + this.jdField_j_of_type_JavaLangString, false);
        }
        if (this.I)
        {
          c(str2);
          str1 = "";
          paramString = str1;
          if (this.jdField_a_of_type_Bfhm != null)
          {
            paramString = str1;
            if (this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList != null)
            {
              paramString = str1;
              if (this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList.size() > 0) {
                paramString = ((TroopInfo)this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
              }
            }
          }
          bdla.b(this.app, "dc00899", "Grp_public", "", "oper", "Clk_focus_temp", 0, 0, paramString, "" + str2, "", "");
          return;
        }
        f();
        return;
      }
    } while (!"DO_CANCEL".equals(paramString));
    a(2131695032);
    this.jdField_b_of_type_MqqAppNewIntent = okn.a().a(this.sessionInfo.curFriendUin, 0, false, BaseApplication.getContext(), this.app, new aiea(this));
  }
  
  private boolean b(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramView.getTag() instanceof String))
    {
      bool1 = bool2;
      if (onc.a.equals(paramView.getTag()))
      {
        bool1 = bool2;
        if (this.mContext != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.sessionInfo.curFriendUin))
          {
            if (System.currentTimeMillis() - this.jdField_d_of_type_Long >= 1000L) {
              break label72;
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
    label72:
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    paramView = new StringBuilder("https://gouwu.qq.com/m/html/shop_map.html?_wv=1027&shop_uin=");
    paramView.append(this.sessionInfo.curFriendUin);
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.toString());
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("webStyle", "noBottomBar");
    this.mContext.startActivity(localIntent);
    bdla.b(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconClk", "Clk_shopnearbyicon", 0, 0, "", "", "", "");
    return false;
  }
  
  private void c(AccountDetail paramAccountDetail)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380442);
    Object localObject2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380441);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368381);
    if (this.I) {
      if ((this.jdField_a_of_type_Bfhm != null) && (this.jdField_a_of_type_Bfhm.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList.get(0);
        ((TextView)localObject1).setText(localTroopInfo.troopname);
        ((TextView)localObject2).setText(String.format(this.mContext.getString(2131694960), new Object[] { paramAccountDetail.name }));
        localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 4, localTroopInfo.troopuin));
        localObject1 = "";
        if (this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = ((TroopInfo)this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
        }
        if (this.sessionInfo != null) {
          break label318;
        }
        localObject2 = "";
        bdla.b(this.app, "dc00899", "Grp_public", "", "oper", "exp_temp", 0, 0, (String)localObject1, "" + (String)localObject2, "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Anvi == null)
      {
        this.jdField_a_of_type_Anvi = new aiep(this, localImageView);
        this.mActivity.addObserver(this.jdField_a_of_type_Anvi);
      }
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364434);
      if (paramAccountDetail.certifiedGrade != 0) {
        break label375;
      }
      ((ImageView)localObject1).setVisibility(8);
      return;
      label318:
      localObject2 = this.sessionInfo.curFriendUin;
      break;
      ((TextView)localObject1).setText(paramAccountDetail.name);
      if (this.jdField_b_of_type_JavaLangString != null) {
        ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangString);
      }
      localImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.app, getSessionInfo().curFriendUin, (byte)3));
    }
    label375:
    ((ImageView)localObject1).setVisibility(0);
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "unfollow");
    }
    f(2131695030);
    Object localObject = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((aoan)localObject).a(this.sessionInfo.curFriendUin);
      if ((localObject != null) && (uuc.a(((AccountDetail)localObject).accountFlag) != -4)) {
        break label192;
      }
      localObject = new NewIntent(BaseApplicationImpl.getContext(), oln.class);
      ((NewIntent)localObject).putExtra("cmd", "unfollow");
      mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
      localUnFollowRequest.uin.set((int)Long.parseLong(paramString));
      ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
      this.jdField_b_of_type_MqqObserverBusinessObserver = new aiee(this, paramString);
      ((NewIntent)localObject).setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      this.app.startServlet((NewIntent)localObject);
    }
    for (;;)
    {
      this.t += 1;
      uuc.a(this.app, paramString);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "unfollow exit");
      }
      return;
      label192:
      this.app.removeObserver(this.jdField_b_of_type_Apar);
      this.jdField_b_of_type_Apar = new apar(new aief(this, paramString));
      this.app.addObserver(this.jdField_b_of_type_Apar);
      apaw.a(this.app, false, this.sessionInfo.curFriendUin, 0);
    }
  }
  
  private void c(List<mobileqq_mp.ButtonInfo> paramList)
  {
    this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_Okn.a(this.mActivity, this.app, getCurFriendUin(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
    if ((paramList != null) && (!paramList.isEmpty())) {
      a(true);
    }
    this.E = true;
    if (this.jdField_a_of_type_Onc == null) {
      this.jdField_a_of_type_Onc = new onc(this.mContext);
    }
    Object localObject = this.mActivity.getIntent();
    if ((((Intent)localObject).hasExtra("pub_account_type")) && ("type_ecshop_account".equals(((Intent)localObject).getStringExtra("pub_account_type"))))
    {
      localObject = ((Intent)localObject).getStringExtra("ecshop_distance_tip");
      localObject = this.jdField_a_of_type_Onc.a((String)localObject, this);
      this.jdField_a_of_type_Onc.a(this.mContent, (View)localObject);
      bdla.b(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconPv", "Pv_shopnearbyicon", 0, 0, "", "", "", "");
    }
    if ((i()) && (aveq.a()))
    {
      hideBottomBar();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "initPublicAccountMenu new qqgame pubaccount return");
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) && (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getVisibility() == 0) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (mobileqq_mp.ButtonInfo)paramList.next();
        if (localObject != null) {
          nzg.a.a(getCurFriendUin(), ((mobileqq_mp.ButtonInfo)localObject).id.get(), ((mobileqq_mp.ButtonInfo)localObject).name.get());
        }
      }
    }
  }
  
  private void d(List<mobileqq_mp.ButtonInfo> paramList)
  {
    int i3 = paramList.size();
    int i1 = 0;
    for (;;)
    {
      if ((i1 >= i3) || (i1 > 2)) {
        return;
      }
      Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i1);
      Object localObject1;
      String str;
      label76:
      label96:
      aako localaako;
      label139:
      label163:
      mobileqq_mp.ButtonInfo localButtonInfo;
      if (((mobileqq_mp.ButtonInfo)localObject2).key.has())
      {
        localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
        if (!((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
          break label286;
        }
        str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
        if (!((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
          break label293;
        }
        i2 = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
        localaako = new aako((String)localObject1, str, null, i2);
        localaako.a((mobileqq_mp.ButtonInfo)localObject2);
        if (!((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
          break label298;
        }
        localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label323;
        }
        localObject2 = ((List)localObject1).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label323;
        }
        localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
        if (!localButtonInfo.key.has()) {
          break label304;
        }
        localObject1 = localButtonInfo.key.get();
        label206:
        if (!localButtonInfo.name.has()) {
          break label311;
        }
        str = localButtonInfo.name.get();
        label227:
        if (!localButtonInfo.id.has()) {
          break label318;
        }
      }
      label286:
      label293:
      label298:
      label304:
      label311:
      label318:
      for (int i2 = localButtonInfo.id.get();; i2 = 0)
      {
        localObject1 = new aako((String)localObject1, str, null, i2);
        ((aako)localObject1).a(localButtonInfo);
        localaako.a((aako)localObject1);
        break label163;
        localObject1 = "";
        break;
        str = "";
        break label76;
        i2 = 0;
        break label96;
        localObject1 = null;
        break label139;
        localObject1 = "";
        break label206;
        str = "";
        break label227;
      }
      label323:
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localaako, getCurFriendUin());
      i1 += 1;
    }
  }
  
  private boolean e()
  {
    if (this.listView != null) {
      this.listView.setDrawFinishedListener(null);
    }
    if (this.hasDestory)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "hasDestory = true return");
      }
      return true;
    }
    uuc.a();
    if (this.jdField_a_of_type_Aifk != null) {}
    try
    {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_Aifk);
      label62:
      this.jdField_a_of_type_Aifk = null;
      if (this.jdField_b_of_type_MqqAppNewIntent != null) {
        okn.a().a(this.jdField_b_of_type_MqqAppNewIntent);
      }
      if (this.jdField_c_of_type_MqqAppNewIntent != null) {
        this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
      }
      if (this.jdField_a_of_type_Anvi != null)
      {
        this.mActivity.removeObserver(this.jdField_a_of_type_Anvi);
        this.jdField_a_of_type_Anvi = null;
      }
      return false;
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  private void f(int paramInt)
  {
    this.uiHandler.postDelayed(new PublicAccountChatPie.28(this, paramInt), 500L);
  }
  
  private boolean f()
  {
    if ((this.v) || (this.A)) {}
    while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_g_of_type_AndroidViewView == null) || (this.jdField_d_of_type_Int == 5)) {
      return true;
    }
    return false;
  }
  
  private void g(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.input.getLayoutParams();
      if (localLayoutParams.gravity != paramInt)
      {
        localLayoutParams.gravity = paramInt;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.input.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    } while (localLayoutParams.gravity == paramInt);
    localLayoutParams.gravity = paramInt;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  private boolean g()
  {
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.mAIORootView.findViewById(2131366337));
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.mActivity.getText(2131696163));
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) {
      this.mContent.removeView(this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.mContent.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (this.jdField_g_of_type_AndroidViewView != null) {
      this.listView.removeHeaderView(this.jdField_g_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.mContent.findViewById(2131366336));
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null)
    {
      this.mActivity.getLayoutInflater().inflate(2131558648, this.mContent);
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.mContent.findViewById(2131366336));
    }
    while (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null)
    {
      return true;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_Okn.b(getCurFriendUin()));
    if (CustomMenuBar.a())
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.mActivity.getResources().getColor(2131167176));
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(AIOUtils.dp2px(48.0F, this.mActivity.getResources()));
    }
    if (this.listView != null)
    {
      Object localObject2 = this.listView.getLayoutParams();
      Object localObject1 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getLayoutParams();
      if ((localObject2 != null) && (localObject1 != null) && ((localObject2 instanceof RelativeLayout.LayoutParams)) && ((localObject1 instanceof RelativeLayout.LayoutParams)))
      {
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject2).getRules();
        if ((arrayOfInt.length > 2) && (arrayOfInt[2] == 2131368910))
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131366336);
          this.listView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131368910);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    return false;
  }
  
  private boolean h()
  {
    if ((i()) && (aveq.a())) {
      QLog.d(this.tag, 2, "updatePublicAccountMenu new qqgame pubaccount return");
    }
    do
    {
      return true;
      if ((j()) && ((!this.C) || (this.B)))
      {
        QLog.d(this.tag, 2, "updatePublicAccountMenu new qqshop pubaccount return");
        return true;
      }
      if (k())
      {
        hideBottomBar();
        QLog.d(this.tag, 2, "updatePublicAccountMenu new qqlive pubaccount return");
        return true;
      }
    } while (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null);
    return false;
  }
  
  private boolean i()
  {
    return (this.sessionInfo != null) && (this.sessionInfo.curFriendUin != null) && ("2747277822".equals(this.sessionInfo.curFriendUin));
  }
  
  private boolean j()
  {
    return (this.sessionInfo != null) && (this.sessionInfo.curFriendUin != null) && ("3046055438".equals(this.sessionInfo.curFriendUin));
  }
  
  private boolean k()
  {
    return (this.sessionInfo != null) && (this.sessionInfo.curFriendUin != null) && ("1816533856".equals(this.sessionInfo.curFriendUin));
  }
  
  private void t()
  {
    if (!(this.mActivity instanceof SplashActivity))
    {
      this.mActivity.finish();
      return;
    }
    Intent localIntent = new Intent(this.mActivity, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(67108864);
    this.mActivity.startActivity(localIntent);
  }
  
  private void u()
  {
    if (this.listView != null)
    {
      this.listView.springBackOverScrollHeaderView();
      this.jdField_j_of_type_Boolean = false;
    }
  }
  
  private void v()
  {
    if ((!this.mActivity.isFinishing()) && (this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()))
    {
      this.jdField_a_of_type_Bisl.dismiss();
      QQToast.a(this.mActivity, 2131698184, 0).b(this.mActivity.getTitleBarHeight());
    }
  }
  
  private void w()
  {
    if ((i()) && (aveq.a())) {}
    do
    {
      do
      {
        return;
      } while (j());
      e();
      d();
      if (QLog.isColorLevel()) {
        QZLog.d(this.tag, 2, "setInitHeader in INIT_PUBLICACCOUNT_COVER_MENU");
      }
    } while (this.jdField_a_of_type_Int == 1);
    this.jdField_d_of_type_Int = 5;
  }
  
  private void x()
  {
    List localList = this.jdField_a_of_type_Okn.a(this.app, getCurFriendUin());
    b(localList);
    if ((localList != null) && (!localList.isEmpty()))
    {
      if ((!i()) || (!aveq.a())) {
        a(true);
      }
      if (!j()) {
        a(true);
      }
    }
  }
  
  private void y()
  {
    if (this.v) {
      if (this.w) {}
    }
    while (((j()) && ((!this.C) || (this.B)) && (this.jdField_a_of_type_Ooy != null) && (this.jdField_a_of_type_Ooy.a(this.mContent))) || (this.mActivity.isFinishing())) {
      do
      {
        return;
      } while (((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).c(this.sessionInfo.curFriendUin) == null);
    }
    try
    {
      g();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void z()
  {
    if (this.jdField_l_of_type_Boolean) {}
    ook localook;
    do
    {
      return;
      this.jdField_l_of_type_Boolean = true;
      localook = (ook)this.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      localObject1 = this.app.getMessageFacade().getAIOList(this.sessionInfo.curFriendUin, this.sessionInfo.curType);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()) || (localook == null));
    Object localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
    Object localObject2 = ((ChatMessage)localObject1).getExtInfoFromExtStr("public_account_msg_id");
    String str = ((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg");
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "enter qqgouwu aio msgId = " + (String)localObject2 + " hasAdver: " + str);
    }
    if ("1".equals(str))
    {
      localObject2 = new ooa();
      ((ooa)localObject2).jdField_a_of_type_Int = 2;
      localObject2 = onx.a((ooa)localObject2, (MessageRecord)localObject1);
      ((onx)this.app.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a((ooa)localObject2, null);
      if ((localObject1 instanceof MessageForStructing)) {
        a((MessageForStructing)localObject1);
      }
    }
    for (;;)
    {
      int i1 = this.mActivity.getIntent().getIntExtra("jump_from", 4);
      if (i1 != 2) {
        break;
      }
      localook.a(134243865, this.sessionInfo.curFriendUin, null, null, null, i1, false);
      return;
      if ((localObject1 instanceof MessageForArkApp))
      {
        a((MessageForArkApp)localObject1);
        continue;
        if ((localObject1 instanceof MessageForArkApp)) {
          localook.a(134243863, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
        } else {
          localook.a(134243857, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
        }
      }
    }
  }
  
  public int a()
  {
    int i1 = 0;
    View localView = this.listView.getChildAt(0);
    if ((this.jdField_i_of_type_AndroidViewView != null) && (localView != this.jdField_i_of_type_AndroidViewView))
    {
      this.jdField_k_of_type_Int = 0;
      this.jdField_i_of_type_AndroidViewView = localView;
      return 0;
    }
    if (localView != null) {
      i1 = -localView.getTop();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "ScrollY: " + String.valueOf(i1) + "  OldScrollY: " + String.valueOf(this.jdField_k_of_type_Int));
    }
    this.jdField_i_of_type_AndroidViewView = localView;
    return i1;
  }
  
  public Map<String, String> a(AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg != null) {
      try
      {
        if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
        {
          paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).mMsgActionData;
          if ((paramAbsStructMsg != null) && (!TextUtils.isEmpty(paramAbsStructMsg)))
          {
            paramAbsStructMsg = bkyp.b(paramAbsStructMsg.substring(paramAbsStructMsg.indexOf("?") + 1));
            return paramAbsStructMsg;
          }
        }
      }
      catch (Exception paramAbsStructMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, paramAbsStructMsg.getMessage());
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    ChatMessage localChatMessage;
    String str1;
    if (this.listAdapter.getCount() >= 1)
    {
      localChatMessage = (ChatMessage)this.listAdapter.a().get(this.listAdapter.getCount() - 1);
      str1 = "0";
      if (localChatMessage != null)
      {
        localObject = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("ad_id")) {
        str1 = ((JSONObject)localObject).getString("ad_id");
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        String str2 = "0";
      }
      bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "0X8005D17", "0X8005D17", 0, 1, 0, "old", String.valueOf(l1 - this.jdField_b_of_type_Long), "", "");
    }
    Object localObject = localChatMessage.getExtInfoFromExtStr("pa_msgId");
    bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", "" + localChatMessage.frienduin, "0X8005C38", "0X8005C38", 0, 1, 0, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
    if (this.jdField_h_of_type_Boolean)
    {
      l1 = NetConnInfoCenter.getServerTime() * 1000L;
      if (this.jdField_i_of_type_Boolean) {
        bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "0X8005D17", "0X8005D17", 0, 1, 0, "new", String.valueOf(l1 - this.jdField_b_of_type_Long), "", "");
      }
    }
    else
    {
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this.mContent.getContext(), this.mActivity.getTitleBarHeight());
    }
    if ((!this.mActivity.isFinishing()) && (this.jdField_a_of_type_Bisl != null))
    {
      this.jdField_a_of_type_Bisl.c(paramInt);
      if (!this.jdField_a_of_type_Bisl.isShowing()) {
        this.jdField_a_of_type_Bisl.show();
      }
    }
  }
  
  void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    antw localantw = (antw)this.app.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
    if (localantw != null) {
      localantw.a(this.sessionInfo.curFriendUin, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(View paramView)
  {
    paramView.getLayoutParams().height = 0;
    paramView.requestLayout();
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int i1 = this.listAdapter.a(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i1);
    }
    if (i1 < 0) {
      return;
    }
    int i2 = this.listView.getFirstVisiblePosition();
    int i3 = i1 - i2;
    this.jdField_b_of_type_AndroidViewView = this.listView.getChildAt(i3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + i3 + ",firstPos is:" + i2 + ",pos is:" + i1);
    }
    this.listAdapter.a(paramChatMessage);
  }
  
  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    aoan localaoan;
    if (paramPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + paramPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + paramPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + paramPublicAccountInfo.mIsAgreeSyncLbs);
      }
      localaoan = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localaoan == null) {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "showEqqLbsEnableDialog(): pam is null");
        }
      }
    }
    for (;;)
    {
      return;
      if ((paramPublicAccountInfo.isSyncLbs) && (!paramPublicAccountInfo.mIsSyncLbsSelected) && (!paramPublicAccountInfo.mIsAgreeSyncLbs) && (!this.G))
      {
        String str1 = this.mActivity.getString(2131692016);
        String str2 = String.format(this.mActivity.getString(2131692014), new Object[] { this.sessionInfo.curFriendNick });
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this.mActivity, 230, str1, str2, 2131692013, 2131692015, new aiem(this, paramPublicAccountInfo, localaoan), new aien(this, paramPublicAccountInfo, localaoan));
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new aieo(this));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        if (!this.mActivity.isFinishing()) {
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        this.G = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.d(this.tag, 2, "showEqqLbsEnableDialog(): END");
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.tag, 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.sessionInfo.curFriendUin);
        }
      }
    }
  }
  
  void a(AbsListView paramAbsListView)
  {
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    int i1 = paramAbsListView.getFirstVisiblePosition();
    while (i1 <= paramAbsListView.getLastVisiblePosition())
    {
      a(localArrayList5, localArrayList4, localArrayList1, localArrayList2, localArrayList3, (ChatMessage)this.listAdapter.getItem(i1), i1);
      i1 += 1;
    }
    a(localArrayList5);
    if (!localArrayList4.isEmpty()) {}
    try
    {
      long l1 = Long.parseLong(this.sessionInfo.curFriendUin);
      long l2 = Long.parseLong(this.app.getCurrentAccountUin());
      this.jdField_a_of_type_Okn.a(BaseApplication.getContext(), this.app, 0L, 0L, l1, l2, 2, localArrayList4);
      paramAbsListView = localArrayList5.iterator();
      while (paramAbsListView.hasNext()) {
        if ("1".equals(((ChatMessage)paramAbsListView.next()).getExtInfoFromExtStr("is_AdArrive_Msg")))
        {
          if (this.jdField_a_of_type_Long == -1L) {
            this.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
          }
          this.jdField_a_of_type_JavaUtilList = localArrayList1;
          usf.a(this.app, "", "", this.sessionInfo.curFriendUin, localArrayList2, localArrayList1, localArrayList3);
        }
      }
      return;
    }
    catch (Exception paramAbsListView) {}
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Onc != null) && (this.mActivity != null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppSchemeCenter", 2, "args:" + paramString);
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.getJSONObject("bidInfo");
      if (((JSONObject)localObject).optInt("isshow", 0) == 1) {}
      for (;;)
      {
        String str = ((JSONObject)localObject).getString("icon");
        localObject = ((JSONObject)localObject).getString("url");
        int i1 = paramString.getInt("bid");
        int i2 = paramString.getInt("cid");
        int i3 = paramString.getInt("web");
        this.mActivity.runOnUiThread(new PublicAccountChatPie.62(this, bool, str, (String)localObject, i1, i2, i3));
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  void a(List<ChatMessage> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "saveReadedToDB");
    }
    ThreadManager.postImmediately(new PublicAccountChatPie.18(this, paramList), null, false);
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "qidianWpaClick ... mQidianKefu = " + this.x);
    }
    a(2131695032);
    Object localObject;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localObject = (String)paramMap.get("AssignType");
      String str = (String)paramMap.get("AssignID");
      paramMap = (Map<String, String>)localObject;
      localObject = str;
    }
    for (;;)
    {
      this.jdField_a_of_type_Okn.a(this.mActivity, this.sessionInfo.curFriendUin, paramMap, (String)localObject, null, new aiff(this));
      return;
      localObject = null;
      paramMap = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (k())
    {
      hideBottomBar();
      QLog.d(this.tag, 2, "setPublicAccountMenuBarVisible new qqlive pubaccount return");
    }
    while (!paramBoolean) {
      return;
    }
    this.root.a();
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
    }
    if (this.mInputBar != null) {
      this.mInputBar.setVisibility(4);
    }
    if (this.mFakeInput != null) {
      this.mFakeInput.setVisibility(4);
    }
    if (this.mFakeUpInput != null) {
      this.mFakeUpInput.setVisibility(4);
    }
    handleNightMask();
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    bdla.b(this.app, "CliOper", "", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      okn.a().a(this.jdField_b_of_type_MqqAppNewIntent);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    this.jdField_b_of_type_MqqAppNewIntent = okn.a().a(this.sessionInfo.curFriendUin, paramInt, paramBoolean, BaseApplication.getContext(), this.app, new aieq(this));
  }
  
  public boolean a()
  {
    Object localObject = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null) {}
    for (localObject = ((aoan)localObject).b(this.sessionInfo.curFriendUin);; localObject = null)
    {
      if ((localObject == null) && (uuc.a(this.app, this.sessionInfo.curFriendUin) == null))
      {
        uuc.a();
        uuc.a(this.app, BaseApplication.getContext(), this.uiHandler, this.sessionInfo.curFriendUin);
        return true;
      }
      return false;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = ((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.sessionInfo.curFriendUin);
      if (localObject != null) {
        return (((PublicAccountInfo)localObject).accountFlag & 0x40000000) == 1073741824;
      }
      return false;
    }
    Object localObject = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((aoan)localObject).a(this.sessionInfo.curFriendUin);
      if (localObject == null) {
        return false;
      }
      return (((AccountDetail)localObject).accountFlag & 0x40000000) == 1073741824;
    }
    return false;
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addObserver(this.jdField_a_of_type_Anyz);
    this.app.getMessageFacade().addObserver(this);
    this.app.addObserver(this.jdField_a_of_type_Aoav);
    onq localonq = (onq)this.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (uot.e(this.app, this.sessionInfo.curFriendUin)) {
      this.app.addObserver(this.jdField_a_of_type_Onv);
    }
    this.app.addObserver(this.jdField_a_of_type_Bjyh);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    super.afterTextChanged(paramEditable);
    a(paramEditable);
    PatchedButton localPatchedButton;
    if (this.mInputStat == 0)
    {
      if (!this.isSimpleBar) {
        break label75;
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(true);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690786);
      localPatchedButton = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() <= 0) {
        break label70;
      }
      bool1 = bool2;
      localPatchedButton.setEnabled(bool1);
    }
    label70:
    label75:
    do
    {
      do
      {
        return;
        bool1 = false;
        break;
      } while ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0));
      localPatchedButton = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() > 0) {
        bool1 = true;
      }
      localPatchedButton.setEnabled(bool1);
    } while (paramEditable.length() <= 0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690786);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(true);
  }
  
  public void b()
  {
    if ((!this.mActivity.isFinishing()) && (this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void b(int paramInt)
  {
    Toast.makeText(this.mActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  void b(List<mobileqq_mp.ButtonInfo> paramList)
  {
    if (h()) {}
    while (a(paramList)) {
      return;
    }
    if ((paramList != null) && (ahcf.a(this.sessionInfo.curFriendUin)))
    {
      mobileqq_mp.ButtonInfo localButtonInfo = new mobileqq_mp.ButtonInfo();
      localButtonInfo.id.set(0);
      localButtonInfo.name.set(anvx.a(2131713289));
      localButtonInfo.event_id.set(1000002);
      localButtonInfo.type.set(3);
      paramList.add(0, localButtonInfo);
    }
    d(paramList);
  }
  
  protected void b(boolean paramBoolean)
  {
    int i2 = 8;
    if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    Object localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      i1 = 0;
      label30:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.input;
      i1 = i2;
      if (!paramBoolean) {
        i1 = 0;
      }
      ((XEditTextEx)localObject).setVisibility(i1);
      if (this.isPttOnlyBar)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (!paramBoolean) {
          break label162;
        }
      }
    }
    label162:
    for (int i1 = 4;; i1 = 0)
    {
      ((PatchedButton)localObject).setVisibility(i1);
      if (!paramBoolean) {
        break;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localObject = new ImageSpan(this.mContext, 2130838122);
        SpannableString localSpannableString = new SpannableString(anvx.a(2131708228));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
      return;
      i1 = 8;
      break label30;
    }
  }
  
  public boolean b()
  {
    Object localObject = this.app.getMessageFacade();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).getLastMessage(this.sessionInfo.curFriendUin, 1008);
      if (localObject != null) {
        if (((QQMessageFacade.Message)localObject).msgtype == -2011)
        {
          localMessageForStructing = new MessageForStructing();
          MessageForStructing.copyMessageRecordBaseField(localMessageForStructing, (MessageRecord)localObject);
          localMessageForStructing.parse();
          if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mPromotionType == 1) || (localMessageForStructing.structingMsg.mPromotionType == 2))) {
            b(localMessageForStructing);
          }
        }
        else
        {
          while ((((QQMessageFacade.Message)localObject).msgtype == -2009) && (((QQMessageFacade.Message)localObject).isSend()))
          {
            MessageForStructing localMessageForStructing;
            return true;
          }
          if ((((QQMessageFacade.Message)localObject).msgtype == -5008) && (!((QQMessageFacade.Message)localObject).isSend()))
          {
            this.jdField_a_of_type_Int = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  @TargetApi(11)
  void c()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.mContent.post(new PublicAccountChatPie.13(this));
      this.listView.removeHeaderView(this.jdField_g_of_type_AndroidViewView);
      this.D = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    a(this.jdField_g_of_type_AndroidViewView, this.jdField_g_of_type_AndroidViewView.getHeight(), 0, new aids(this));
    this.jdField_a_of_type_AndroidViewView.setTranslationY(0.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidViewView.getHeight());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new aidt(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean c()
  {
    return (this.mInputBar == null) || (this.mInputBar.getVisibility() == 8);
  }
  
  void d()
  {
    if ((this.mContent == null) || (this.listView == null)) {}
    do
    {
      return;
      L();
      this.jdField_g_of_type_AndroidViewView = LayoutInflater.from(this.mActivity.getBaseContext()).inflate(2131558646, this.listView, false);
    } while (this.jdField_g_of_type_AndroidViewView == null);
    Object localObject;
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_g_of_type_AndroidViewView.getLayoutParams().height = ((int)this.mActivity.getResources().getDimension(2131297577));
      if ((!this.v) && (!this.A)) {
        break label223;
      }
      localObject = (RelativeLayout.LayoutParams)this.listView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.mContext.getResources().getDimensionPixelSize(2131299080);
      this.listView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      localObject = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject != null)
      {
        localObject = ((aoan)localObject).a(this.sessionInfo.curFriendUin);
        if ((localObject != null) && (this.jdField_c_of_type_Boolean))
        {
          c((AccountDetail)localObject);
          this.jdField_c_of_type_Boolean = false;
        }
      }
      M();
      return;
      if (!this.v) {
        break;
      }
      this.jdField_g_of_type_AndroidViewView.getLayoutParams().height = ((int)this.mActivity.getResources().getDimension(2131297577));
      break;
      label223:
      localObject = this.listView.getAdapter();
      this.listView.setAdapter(null);
      this.listView.addHeaderView(this.jdField_g_of_type_AndroidViewView);
      this.listView.setAdapter((ListAdapter)localObject);
    }
  }
  
  public void d(int paramInt)
  {
    try
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718999);
        continue;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718993);
        continue;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694985);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) || (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getVisibility() == 8);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.F = true;
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    this.app.setHandler(getClass(), this.uiHandler);
    this.jdField_a_of_type_Aifk = new aifk(this, null);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    this.mContext.registerReceiver(this.jdField_a_of_type_Aifk, (IntentFilter)localObject);
    this.hasDestory = false;
    this.needAutoInput = false;
    K();
    this.jdField_a_of_type_Okn = okn.a();
    m();
    super.doOnCreate(paramBoolean);
    if (this.v) {
      o();
    }
    if (this.app.getConversationFacade().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType) > 0) {
      this.jdField_q_of_type_Boolean = true;
    }
    this.listView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_Bfhm = new bfhm();
    this.jdField_a_of_type_Bfhm.a(this.app, getActivity(), this, this.sessionInfo, this.mContent, this.listAdapter, this.listView);
    this.jdField_a_of_type_Bfhm.addObserver(this);
    localObject = this.mActivity.getIntent();
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    this.jdField_n_of_type_Int = ((Intent)localObject).getIntExtra("red_hot_count", 0);
    String str = ((Intent)localObject).getStringExtra("from");
    this.jdField_m_of_type_Boolean = ((Intent)localObject).getBooleanExtra("shouldreport", false);
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_o_of_type_Int = this.jdField_n_of_type_Int;
    uuc.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("is_come_from_readinjoy", false);
    this.jdField_q_of_type_Int = ((Intent)localObject).getIntExtra("INTENT_KEY_FROM", 1);
    if (!this.mActivity.isFinishing())
    {
      A();
      PublicAccountHandler.a = null;
      this.jdField_k_of_type_Boolean = this.mActivity.getIntent().getBooleanExtra("has_unread_msg", false);
    }
    if (a((Intent)localObject, str)) {
      return true;
    }
    B();
    C();
    if (this.panelicons != null) {
      this.panelicons.setCustomHeight(0);
    }
    this.jdField_h_of_type_Boolean = uuc.a(this.app, this.sessionInfo.curFriendUin);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "doOnCreate, isMediaAndOtherSubscript = " + this.jdField_h_of_type_Boolean);
    }
    this.jdField_b_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    D();
    if (this.jdField_h_of_type_Boolean)
    {
      af();
      j();
      l();
    }
    E();
    F();
    a((Intent)localObject);
    G();
    ai();
    return true;
  }
  
  public void doOnCreate_initUI()
  {
    super.doOnCreate_initUI();
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.mAIORootView.findViewById(2131367476));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(anvx.a(2131708261));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.mAIORootView.findViewById(2131366337));
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mAIORootView.findViewById(2131373320));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mAIORootView.findViewById(2131367477));
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.input.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    this.input.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (CustomMenuBar.a()) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-1);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363049));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131372972));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131366054));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847907);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838067);
      }
      if (this.input != null)
      {
        int i1 = AIOUtils.dp2px(3.0F, this.mActivity.getResources());
        if (CustomMenuBar.a())
        {
          this.input.setBackgroundResource(2130849994);
          this.mInputBar.setBackgroundColor(this.mActivity.getResources().getColor(2131167176));
        }
        this.mInputBar.setPadding(0, i1, 0, i1);
      }
      if (k()) {
        hideBottomBar();
      }
      return;
      g(80);
    }
  }
  
  public void doOnDestroy()
  {
    pwb.a().a(this.sessionInfo.curFriendUin, this.jdField_f_of_type_Long, this.jdField_k_of_type_Boolean, this.listAdapter.a());
    if (e()) {
      return;
    }
    super.doOnDestroy();
    if (this.jdField_a_of_type_Okn != null)
    {
      this.jdField_a_of_type_Okn.a(getCurFriendUin());
      this.jdField_a_of_type_Okn.a(this.mContext);
    }
    J();
    a();
    R();
    if (this.jdField_f_of_type_Long != 0L)
    {
      this.jdField_f_of_type_Long = (System.currentTimeMillis() - this.jdField_f_of_type_Long);
      bdla.b(this.app, "dc00899", "Pb_account_lifeservice", "" + this.sessionInfo.curFriendUin, "0X80064D5", "0X80064D5", 0, 0, "", "" + this.jdField_f_of_type_Long, "" + this.jdField_u_of_type_Int, "");
      this.jdField_f_of_type_Long = 0L;
      this.jdField_n_of_type_Int = 0;
    }
    if (this.jdField_q_of_type_Boolean) {
      ThreadManager.executeOnSubThread(new PublicAccountChatPie.10(this));
    }
    n();
    uuc.jdField_a_of_type_Boolean = false;
    try
    {
      if (onx.a(this.sessionInfo))
      {
        ArkAppNotifyCenter.unRegistVolumnReceiver();
        albi.a().b("com.tencent.gouwu.video");
        albi.a().b("com.tencent.gwh.video");
        albi.a().b("com.tencent.qqshop");
      }
      label272:
      aj();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label272;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    K();
    if (this.sessionInfo.curFriendUin != null)
    {
      localObject = paramIntent.getStringExtra("uin");
      if (!this.sessionInfo.curFriendUin.equals(localObject))
      {
        R();
        this.jdField_g_of_type_Long = System.currentTimeMillis();
        ah();
        this.jdField_i_of_type_Long = System.currentTimeMillis();
      }
    }
    if (this.app.getConversationFacade().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType) > 0) {
      this.jdField_q_of_type_Boolean = true;
    }
    m();
    if (this.v)
    {
      this.root.a();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      }
      if (this.mInputBar != null) {
        this.mInputBar.setVisibility(8);
      }
      if (this.mFakeInput != null) {
        this.mFakeInput.setVisibility(8);
      }
      if (this.mFakeUpInput != null) {
        this.mFakeUpInput.setVisibility(8);
      }
    }
    super.doOnNewIntent(paramIntent);
    this.app.addObserver(this.jdField_a_of_type_Bjyh);
    if (this.v) {
      o();
    }
    if ((!this.mActivity.isFinishing()) && (!this.v))
    {
      if ((this.app != null) && (!this.app.getAccount().equals(this.jdField_a_of_type_Okn.a()))) {
        this.jdField_a_of_type_Okn.a(getCurFriendUin());
      }
      localObject = this.jdField_a_of_type_Okn.a(this.app, getCurFriendUin());
      b((List)localObject);
      this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_Okn.a(this.mActivity, this.app, getCurFriendUin(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        a(true);
      }
    }
    Object localObject = paramIntent.getStringExtra("from");
    if ((localObject != null) && (((String)localObject).equals("starShortcut"))) {
      okn.a(this.mActivity, this.app, paramIntent.getStringExtra("starhomeurl"), paramIntent.getStringExtra("uin"), (String)localObject);
    }
    this.J = false;
  }
  
  public void doOnNewIntent_clearBusinessData()
  {
    super.doOnNewIntent_clearBusinessData();
    this.E = false;
    this.F = false;
  }
  
  public void doOnPause()
  {
    if ((this.app != null) && (this.sessionInfo != null)) {
      ((onq)this.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).jdField_i_of_type_JavaLangString = this.sessionInfo.curFriendUin;
    }
    super.doOnPause();
    this.jdField_a_of_type_Avli.d();
    PublicAccountInfo localPublicAccountInfo = ((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.sessionInfo.curFriendUin);
    if (localPublicAccountInfo != null) {
      switch (uuc.a(localPublicAccountInfo.accountFlag))
      {
      }
    }
    for (;;)
    {
      if (j())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "report stay page time tabid is1");
        }
        opk.a(this.app, "gouwu.aio.stay", "1", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.jdField_h_of_type_Long + "");
        opk.b(this.app, "gouwu_aio_stay", "1", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.jdField_h_of_type_Long + "");
      }
      nzg.a.a(getCurFriendUin());
      return;
      apau.a(this.app, this.sessionInfo.curFriendUin, this.jdField_q_of_type_Int, 2, System.currentTimeMillis() - this.jdField_h_of_type_Long);
      continue;
      apau.a(this.app, this.sessionInfo.curFriendUin, this.jdField_q_of_type_Int, 3, System.currentTimeMillis() - this.jdField_h_of_type_Long);
      continue;
      apau.a(this.app, this.sessionInfo.curFriendUin, this.jdField_q_of_type_Int, 4, System.currentTimeMillis() - this.jdField_h_of_type_Long);
    }
  }
  
  public void doOnResume()
  {
    if ((this.I) && (this.J)) {
      return;
    }
    this.jdField_i_of_type_Long = System.currentTimeMillis();
    try
    {
      ark.arkNotify("com.tencent.weather", "pubaccountPendantRefresh", "", "json");
      super.doOnResume();
      if (!this.J) {
        ThreadManager.post(new PublicAccountChatPie.53(this), 5, null, false);
      }
      this.J = true;
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      bdla.b(null, "dc00898", "", this.sessionInfo.curFriendUin, "auth_aio", "exp", 0, 0, "", "", this.sessionInfo.curFriendNick, "");
      nzg.a.a();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        QLog.e(this.tag, 1, "ark.arkNotify exception:", localUnsatisfiedLinkError);
      }
    }
  }
  
  public void doOnResume_updateUI()
  {
    super.doOnResume_updateUI();
    this.uiHandler.sendEmptyMessageDelayed(37, 500L);
    if (this.jdField_a_of_type_Bfhm.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bfhm.a(this.app);
      this.jdField_a_of_type_Bfhm.c();
    }
    if ((ahcf.a(this.sessionInfo.curFriendUin)) && (this.input != null)) {
      this.input.setHint(anvx.a(2131708202));
    }
    if ((!this.E) && (this.F))
    {
      this.F = false;
      ThreadManager.postImmediately(new PublicAccountChatPie.5(this), null, true);
    }
    this.jdField_c_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (ChatActivityUtils.b(this.app, this.sessionInfo)) {
      if (mbl.a().a(this.app.getCurrentAccountUin()))
      {
        this.mTitleBtnCall.setVisibility(0);
        this.mTitleBtnCall.setOnClickListener(this);
        onu localonu = (onu)this.app.getBusinessHandler(BusinessHandlerFactory.ECSHOP_HANDLER);
        if (uot.e(this.app, this.sessionInfo.curFriendUin))
        {
          long l1 = 0L;
          if (onq.b.get(this.sessionInfo.curFriendUin) != null) {
            l1 = ((Long)onq.b.get(this.sessionInfo.curFriendUin)).longValue();
          }
          if ((!TextUtils.isEmpty((String)onq.jdField_a_of_type_JavaUtilHashMap.get(this.sessionInfo.curFriendUin))) && (System.currentTimeMillis() - l1 <= onq.jdField_a_of_type_Int)) {
            break label394;
          }
          onq.b.put(this.sessionInfo.curFriendUin, Long.valueOf(System.currentTimeMillis()));
          localonu.a(this.sessionInfo.curFriendUin);
        }
      }
    }
    for (;;)
    {
      if ((j()) && (this.isFromOnCreate)) {
        onq.a(this.mContent, this.mContext, this.app);
      }
      return;
      this.mTitleBtnCall.setVisibility(8);
      break;
      if ((this.mTitleText.getText() != null) && (this.mTitleText.getText().length() < 6))
      {
        this.mTitleBtnCall.setVisibility(4);
        break;
      }
      this.mTitleBtnCall.setVisibility(8);
      break;
      label394:
      if (mbl.a().a(this.app.getCurrentAccountUin()))
      {
        this.mTitleBtnCall.setVisibility(0);
        this.mTitleBtnCall.setOnClickListener(this);
        this.mCustomTitleView.setRight2Icon(2130847096);
      }
      else
      {
        this.mTitleBtnCall.setVisibility(8);
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ah();
    long l1 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      int i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
      bdla.b(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "0X8005C35", "0X8005C35", 0, 1, 0, (String)this.jdField_a_of_type_JavaUtilList.get(i1), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(l1), (String)this.jdField_b_of_type_JavaUtilList.get(i1));
    }
    if (this.jdField_h_of_type_Boolean)
    {
      if (this.jdField_i_of_type_Boolean) {
        olh.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "0X8005D16", "0X8005D16", 0, 0, "new", String.valueOf(l1 - this.jdField_c_of_type_Long), "", "", false);
      }
    }
    else {
      return;
    }
    olh.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "0X8005D16", "0X8005D16", 0, 0, "old", String.valueOf(l1 - this.jdField_c_of_type_Long), "", "", false);
  }
  
  public void doPanelChanged(int paramInt1, int paramInt2)
  {
    super.doPanelChanged(paramInt1, paramInt2);
    k();
    if (paramInt2 == 8) {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        if (!CustomMenuBar.a()) {
          break label295;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849940);
      }
    }
    for (;;)
    {
      if (!this.isSimpleBar)
      {
        SpannableString localSpannableString;
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.mContext, 2130838122);
          localSpannableString = new SpannableString(anvx.a(2131708255));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.mContext, 2130838416);
          localSpannableString = new SpannableString(anvx.a(2131708251));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if ((QLog.isColorLevel()) && (this.jdField_c_of_type_AndroidWidgetImageView != null)) {
          QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.input.getText().length() + "mAudioBtn visibility:" + this.jdField_c_of_type_AndroidWidgetImageView.getVisibility());
        }
        if (paramInt2 != 2) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        if ((this.mAudioPanel != null) && (paramInt1 != 2) && (afod.a(this.app))) {
          this.mAudioPanel.a(false);
        }
      }
      return;
      label295:
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849862);
      continue;
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        if (CustomMenuBar.a()) {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849939);
        } else {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849861);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
    if (this.input.getText().length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject).setSelected(bool);
      if (this.input.getText().length() <= 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690786);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setSelected(false);
  }
  
  void e()
  {
    this.listView.setOnScrollListener(this);
    this.root.a();
    if (this.mInputBar != null) {
      this.mInputBar.setVisibility(8);
    }
    if (this.mFakeInput != null) {
      this.mFakeInput.setVisibility(8);
    }
    if (this.mFakeUpInput != null) {
      this.mFakeUpInput.setVisibility(8);
    }
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null)
    {
      this.jdField_b_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755829);
      this.jdField_b_of_type_AndroidAppDialog.setContentView(2131560897);
    }
    TextView localTextView1 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131379001);
    TextView localTextView2 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131361939);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidAppDialog.setOnCancelListener(new aifd(this));
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
      localTextView1.setText(2131697996);
      localTextView2.setText(2131698002);
      continue;
      localTextView1.setText(2131697997);
      localTextView2.setText(2131697998);
      continue;
      localTextView1.setText(2131698000);
      localTextView2.setText(2131697998);
    }
  }
  
  public boolean enableFullScreenInput()
  {
    return false;
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Bkzi == null)
    {
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this.mActivity, null));
      this.jdField_a_of_type_Bkzi.a(anvx.a(2131708249));
      this.jdField_a_of_type_Bkzi.a(anvx.a(2131708245), 3);
      this.jdField_a_of_type_Bkzi.c(2131690697);
      this.jdField_a_of_type_Bkzi.setOnDismissListener(new aieb(this));
      this.jdField_a_of_type_Bkzi.a(new aiec(this));
    }
    if (!this.jdField_a_of_type_Bkzi.isShowing())
    {
      this.jdField_p_of_type_Boolean = false;
      this.jdField_a_of_type_Bkzi.show();
    }
  }
  
  void g()
  {
    if (this.E) {}
    do
    {
      do
      {
        return;
      } while (this.mContent == null);
      localObject = this.mActivity.getResources();
    } while (g());
    if (this.jdField_g_of_type_Boolean)
    {
      localObject = new TranslateAnimation(0.0F, 0.0F, AIOUtils.dp2px(34.0F, (Resources)localObject), 0.0F);
      ((TranslateAnimation)localObject).setDuration(250L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new aieh(this));
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.startAnimation((Animation)localObject);
    }
    Object localObject = this.mContent.findViewById(2131366335);
    ((View)localObject).setOnClickListener(new aiei(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_f_of_type_AndroidViewView = this.mContent.findViewById(2131372356);
    Q();
    localObject = this.mActivity.getSharedPreferences("menuEventSharePre", 0);
    if (!((SharedPreferences)localObject).contains(this.sessionInfo.curFriendUin))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.sessionInfo.curFriendUin, 0);
      ((SharedPreferences.Editor)localObject).commit();
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    O();
    P();
    localObject = this.jdField_a_of_type_Okn.a(this.app, getCurFriendUin());
    b((List)localObject);
    c((List)localObject);
  }
  
  public int getScrollFlag(int paramInt)
  {
    if ((j()) && (this.B)) {
      return 0;
    }
    return super.getScrollFlag(paramInt);
  }
  
  public void h()
  {
    if (this.sessionInfo.curType == 1008)
    {
      if ((this.mTitleText.getText() != null) && (this.mTitleText.getText().length() < 6)) {
        this.mTitleBtnCall.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.mTitleBtnCall.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.mTipsMgr.a(1000, new Object[0]);
      continue;
      if (this.jdField_f_of_type_AndroidViewView != null)
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.uiHandler.removeMessages(20);
        this.uiHandler.sendEmptyMessageDelayed(20, 10000L);
        continue;
        this.uiHandler.removeMessages(20);
        if ((this.jdField_f_of_type_AndroidViewView != null) && (this.jdField_f_of_type_AndroidViewView.getVisibility() == 0))
        {
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          continue;
          a(this.listView);
          continue;
          Z();
          continue;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.c();
        }
      }
    }
  }
  
  public void handleNightMask()
  {
    super.handleNightMask();
    if (this.mMask != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mMask.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (!d())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getId());
            return;
          }
          if (!c())
          {
            localLayoutParams.addRule(2, this.mInputBar.getId());
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void handleScrollOutScreen(View paramView)
  {
    super.handleScrollOutScreen(paramView);
    paramView = AIOUtils.getHolder(paramView);
    ((aglk)this.helperProvider.a(22)).a(paramView);
  }
  
  public void hideAddFriendAndShield()
  {
    if (!this.jdField_h_of_type_Boolean) {
      super.hideAddFriendAndShield();
    }
  }
  
  void i()
  {
    QLog.d(this.tag, 2, "follow");
    Object localObject = (aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((aoan)localObject).a(this.sessionInfo.curFriendUin);
      if ((localObject != null) && (uuc.a(((AccountDetail)localObject).accountFlag) != -4)) {
        break label88;
      }
      ab();
    }
    for (;;)
    {
      olh.a(this.app, this.sessionInfo.curFriendUin, 4);
      QLog.d(this.tag, 2, "follow exit");
      return;
      label88:
      aa();
    }
  }
  
  public void initTipsTaskList()
  {
    aile localaile = new aile(this.app, this.sessionInfo, this.mTipsMgr, this, this.uiHandler);
    this.mTipsMgr.a(localaile);
  }
  
  public void j()
  {
    ThreadManager.post(new PublicAccountChatPie.49(this), 8, null, true);
  }
  
  @TargetApi(11)
  protected void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.mInputStat != 1) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844791);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!VersionUtils.isHoneycomb());
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.mInputStat == 2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.isHoneycomb()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.root.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849891);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getString(2131698176));
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850338);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849890);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getString(2131698175));
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850339);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.root.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849891);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getString(2131698176));
        label246:
        if (!VersionUtils.isHoneycomb()) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850338);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849890);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.mContext.getString(2131698175));
      break label246;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850339);
    }
  }
  
  public void l()
  {
    this.jdField_h_of_type_AndroidViewView = LayoutInflater.from(this.mContext).inflate(2131559671, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_h_of_type_AndroidViewView.findViewById(2131376466));
    if (!this.jdField_i_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_h_of_type_AndroidViewView.findViewById(2131376460));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_h_of_type_AndroidViewView.findViewById(2131376458));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_h_of_type_AndroidViewView.findViewById(2131376461));
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    try
    {
      if ((j()) && (this.jdField_a_of_type_Ooy != null)) {
        this.jdField_a_of_type_Ooy.a(getActivity());
      }
      label27:
      super.leftBackEvent(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  void m()
  {
    s();
    this.jdField_a_of_type_Bjxa = ((bjxa)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    String str = this.mActivity.getIntent().getStringExtra("uin");
    this.jdField_d_of_type_JavaLangString = this.mActivity.getIntent().getStringExtra("qd_wpa_key");
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      this.jdField_e_of_type_JavaLangString = this.mActivity.getIntent().getStringExtra("qd_kfuin");
      this.jdField_f_of_type_JavaLangString = this.mActivity.getIntent().getStringExtra("assign_type");
      this.jdField_g_of_type_JavaLangString = this.mActivity.getIntent().getStringExtra("assign_key");
      this.jdField_h_of_type_JavaLangString = this.mActivity.getIntent().getStringExtra("assign_ext");
      this.jdField_i_of_type_JavaLangString = this.mActivity.getIntent().getStringExtra("rkey");
      this.v = true;
      this.w = false;
      this.x = false;
      this.y = false;
      this.z = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      this.jdField_a_of_type_Bjxa.a(str, this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bjxa.b(str);
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.v = true;
      this.w = true;
      this.jdField_f_of_type_JavaLangString = null;
      this.jdField_g_of_type_JavaLangString = null;
      this.jdField_h_of_type_JavaLangString = null;
      this.jdField_i_of_type_JavaLangString = null;
      this.x = true;
      this.y = false;
      this.z = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      return;
    }
    this.v = false;
    this.w = false;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.x = false;
    this.y = false;
    this.z = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  }
  
  public void messageTips(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Bfhm != null)
      {
        Iterator localIterator = this.jdField_a_of_type_Bfhm.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((TroopInfo)localIterator.next()).troopuin.equals(paramMessage.frienduin));
      }
      for (int i1 = 1; (paramMessage.istroop != 1) || (i1 == 0); i1 = 0)
      {
        super.messageTips(paramMessage);
        return;
      }
    }
  }
  
  protected void n()
  {
    this.v = false;
    this.w = false;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.x = false;
    this.y = false;
    this.z = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
    this.A = false;
  }
  
  public boolean needShowTimeForLastMsgItem()
  {
    if ((!this.jdField_r_of_type_Boolean) && (this.jdField_h_of_type_Boolean))
    {
      this.jdField_r_of_type_Boolean = true;
      this.listView.setSelection(this.listAdapter.getCount() - 1);
    }
    while ((this.jdField_s_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) {
      return true;
    }
    this.jdField_s_of_type_Boolean = true;
    return false;
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "checkQDAccountValid ...");
    }
    ThreadManager.post(new PublicAccountChatPie.57(this), 8, null, false);
  }
  
  public boolean onBackEvent()
  {
    try
    {
      if ((j()) && (this.jdField_a_of_type_Ooy != null)) {
        this.jdField_a_of_type_Ooy.a(getActivity());
      }
      label27:
      return super.onBackEvent();
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (!b(paramView)) {
        break;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(true);
      break;
      S();
      break;
      X();
      break;
      W();
      break;
      V();
      break;
      U();
      break;
      hideSoftInput();
      break;
      T();
      break;
      if (!a(paramView)) {
        break;
      }
      continue;
      super.onClick(paramView);
    }
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_h_of_type_Boolean) {
      c(2131694990);
    }
  }
  
  public void onPostSetReadConfirm(QQAppInterface paramQQAppInterface)
  {
    super.onPostSetReadConfirm(paramQQAppInterface);
    if ((this.sessionInfo.curType == 1008) && (uot.b(paramQQAppInterface, this.sessionInfo.curFriendUin)) && (uot.a().a(this.sessionInfo.curFriendUin))) {
      uot.a().a(paramQQAppInterface, this.sessionInfo.curFriendUin);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    ((aglk)this.helperProvider.a(22)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((j()) && (this.B) && (ope.b()))
    {
      opk.a().a(this.listView, this.listAdapter);
      this.jdField_s_of_type_Int = (a() - this.jdField_k_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, "onScrollStateChanged<<<<<: " + this.jdField_s_of_type_Int);
      }
    }
    b(paramAbsListView);
    if (f()) {
      return;
    }
    if (this.jdField_m_of_type_Int > paramInt3) {
      this.jdField_d_of_type_Int = 4;
    }
    for (;;)
    {
      this.jdField_m_of_type_Int = paramInt3;
      a(paramInt2, paramInt3);
      if ((!this.D) && (!this.jdField_f_of_type_Boolean)) {
        break;
      }
      if ((!this.jdField_o_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) {
        break label204;
      }
      this.jdField_o_of_type_Boolean = false;
      return;
      if (this.jdField_m_of_type_Int < paramInt3) {
        this.jdField_d_of_type_Int = 3;
      }
    }
    label204:
    if (this.jdField_a_of_type_AndroidViewView.getHeight() != 0) {
      this.jdField_l_of_type_Int = this.jdField_a_of_type_AndroidViewView.getHeight();
    }
    int i1 = this.jdField_k_of_type_Int - a();
    this.jdField_k_of_type_Int = a();
    if (this.jdField_r_of_type_Int * i1 < 0)
    {
      this.jdField_r_of_type_Int = i1;
      return;
    }
    this.jdField_r_of_type_Int = i1;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "Move = " + String.valueOf(i1));
    }
    a(paramInt1, paramInt2, paramInt3, i1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      this.uiHandler.sendEmptyMessage(37);
      nza.a().a(500L);
    }
    if ((j()) && (this.B) && (ope.b()) && (paramInt == 0))
    {
      this.jdField_k_of_type_Int = a();
      if (this.jdField_s_of_type_Int > 100)
      {
        opk.a(null, "qgg.index.up", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
        opk.b(null, "qgg_index_up", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
        if (QLog.isColorLevel()) {
          QLog.i(this.tag, 2, "report qgg_index_up");
        }
      }
    }
    ((aglk)this.helperProvider.a(22)).a(paramAbsListView, paramInt);
  }
  
  public void onShow()
  {
    if ((this.H) && (uqx.a().a(this.app, this.sessionInfo.curFriendUin) > 0)) {
      uqx.a().a(this.app, this.sessionInfo.curFriendUin);
    }
    super.onShow();
    if (ahcf.a(this.sessionInfo.curFriendUin))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.mActivity, 2, null);
      }
    }
    for (;;)
    {
      onq localonq = (onq)this.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if ((localonq != null) && (localonq.a(this.sessionInfo.curFriendUin))) {
        ThreadManager.post(new PublicAccountChatPie.4(this), 5, null, true);
      }
      b(this.listView);
      nza.a().a(1000L);
      nzg.a.a(getActivity());
      return;
      if (("3026775809".equals(this.sessionInfo.curFriendUin)) && (Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.app.getApplication().getApplicationContext().getSystemService("sensor")).getDefaultSensor(19) != null)) {
        ((bhwz)this.app.getManager(QQManagerFactory.SPORT_MANAGER)).a("public account");
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_n_of_type_Boolean = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_h_of_type_Boolean) {
      c(2131695002);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "listView onViewCompleteVisableAndReleased");
    }
    if (!this.jdField_h_of_type_Boolean) {
      return super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
    if ((this.listAdapter != null) && (this.listAdapter.getCount() > 0))
    {
      this.jdField_j_of_type_Boolean = true;
      a(System.currentTimeMillis());
      this.pullReqTime = SystemClock.uptimeMillis();
      ((afrc)this.refreshMessageContext.context).a(this.pullReqTime);
      this.refreshMessageContext.needAutoNavigateTop = false;
      this.refreshMessageContext.needNotifyUI = true;
      this.app.getMessageFacade().refreshMessageListHead(this.sessionInfo.curFriendUin, this.sessionInfo.curType, 21, this.refreshMessageContext);
    }
    return true;
  }
  
  public void openOptionActivity()
  {
    if (this.K)
    {
      "https://h5.qzone.qq.com/subscription/homepage/{userId}?_proxy=1&_wv=16777217&_wwv=4".replace("{userId}", this.sessionInfo.curFriendUin);
      zqm.a(getActivity(), this.sessionInfo.curFriendUin);
      bdla.b(null, "dc00898", "", this.sessionInfo.curFriendUin, "auth_aio", "clk_head", 0, 0, "", "", this.sessionInfo.curFriendNick, "");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
    localIntent.putExtra("uinname", this.sessionInfo.curFriendNick);
    localIntent.putExtra("uintype", this.sessionInfo.curType);
    if (this.v) {
      localIntent.putExtra("qidian_chat", true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      localIntent.putExtra("public_account_msg_id", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
    }
    if ((1 == this.sessionInfo.curType) || (1000 == this.sessionInfo.curType) || (1020 == this.sessionInfo.curType) || (1004 == this.sessionInfo.curType)) {
      localIntent.putExtra("troop_uin", this.sessionInfo.troopUin);
    }
    uuc.a(localIntent, this.app, this.mActivity.getActivity(), this.sessionInfo.curFriendUin, -1, 2000, 1, uuc.jdField_a_of_type_Boolean);
  }
  
  public void p()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.tag;
      localStringBuilder = new StringBuilder().append("updateHeader ... ");
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label71;
      }
    }
    label71:
    for (Object localObject = Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getVisibility());; localObject = "")
    {
      QLog.d(str, 2, localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) && (this.w)) {
        break;
      }
      return;
    }
    if (this.y)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "updateWpaUiForQidian: mQidianAccountValid = " + this.w + ", mQidianKefu = " + this.x + ", mQidianShield: " + this.y);
    }
    if (this.w) {
      if (((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).c(this.sessionInfo.curFriendUin) == null) {
        break label293;
      }
    }
    label293:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.mTitleText.setVisibility(0);
        this.mTitleBtnRight.setVisibility(0);
        this.mInputBar.setVisibility(0);
        g();
        return;
      }
      this.mTitleText.setVisibility(0);
      this.mTitleBtnRight.setVisibility(0);
      InputLinearLayout localInputLinearLayout = this.mInputBar;
      if (this.y) {
        i1 = 8;
      }
      for (;;)
      {
        localInputLinearLayout.setVisibility(i1);
        if (this.jdField_d_of_type_AndroidWidgetImageView == null) {
          this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.mAIORootView.findViewById(2131366337));
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          if (QLog.isColorLevel()) {
            QZLog.d(this.tag, 2, "setInitHeader in updateWpaUiForQidian");
          }
          d();
        }
        p();
        return;
        if (this.x) {
          i1 = 0;
        } else {
          i1 = 8;
        }
      }
      this.mTitleText.setVisibility(4);
      this.mTitleBtnRight.setVisibility(4);
      this.mInputBar.setVisibility(8);
      return;
    }
  }
  
  public void r()
  {
    if ((!this.w) || (!this.z)) {}
    int i1;
    do
    {
      return;
      if (((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).c(this.sessionInfo.curFriendUin) != null) {}
      for (i1 = 1; (this.y) && (i1 == 0); i1 = 0)
      {
        aonr.a(this.app, this.sessionInfo.curFriendUin, this.app.getApp().getResources().getString(2131697999), this.sessionInfo.curType, false, true);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing != null)
      {
        this.app.getMessageFacade().addMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, this.app.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
        return;
      }
    } while ((this.y) || (i1 != 0));
  }
  
  public void refresh(int paramInt)
  {
    int i1 = 0xFFFF0000 & paramInt;
    super.refresh(paramInt);
    if ((this.sessionInfo == null) || (this.sessionInfo.curFriendUin == null)) {
      return;
    }
    List localList = this.app.getMessageFacade().getAIOList(this.sessionInfo.curFriendUin, this.sessionInfo.curType);
    if (((i1 == 196608) || (i1 == 131072)) && (localList.size() > 0))
    {
      i1 = 0;
      int i3 = localList.size() - 1;
      if (i3 >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(i3);
        int i2 = i1;
        if (i1 == 0)
        {
          if ((this.jdField_e_of_type_Long == 9223372036854775807L) || (localChatMessage.uniseq == this.jdField_e_of_type_Long)) {
            i1 = 1;
          }
          i2 = i1;
          if (this.jdField_e_of_type_Long == 9223372036854775807L) {}
        }
        for (;;)
        {
          i3 -= 1;
          break;
          if (i2 != 0) {
            break label174;
          }
          i1 = i2;
        }
        label174:
        if (((localChatMessage instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.isPALongMsg(localChatMessage)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(localChatMessage))))
        {
          String str = localChatMessage.getExtInfoFromExtStr("longMsg_State");
          if ((str == null) || (!String.valueOf(3).equals(str))) {
            break label239;
          }
        }
        for (;;)
        {
          this.jdField_e_of_type_Long = localChatMessage.uniseq;
          i1 = i2;
          break;
          label239:
          localChatMessage.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
          StructLongMessageDownloadProcessor.getStructLongMessage(this.app, (MessageForStructing)localChatMessage);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "REFRESH_FLAG_RELOAD  to load long message");
      }
    }
    if (paramInt != 131072) {
      this.uiHandler.sendEmptyMessage(20);
    }
    this.uiHandler.sendEmptyMessage(37);
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Anyz);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    this.app.removeObserver(this.jdField_a_of_type_Aoav);
    this.app.removeObserver(this.jdField_a_of_type_Onv);
    this.app.removeObserver(this.jdField_a_of_type_Bjyh);
    this.app.removeObserver(this.jdField_a_of_type_Apar);
    this.app.removeObserver(this.jdField_b_of_type_Apar);
  }
  
  public void s()
  {
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.63(this));
  }
  
  @TargetApi(11)
  public void setInputStat(int paramInt)
  {
    super.setInputStat(paramInt);
    ImageSpan localImageSpan;
    SpannableString localSpannableString;
    if (paramInt != this.mInputStat)
    {
      if (paramInt != 1) {
        break label87;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localImageSpan = new ImageSpan(this.mContext, 2130838122);
        localSpannableString = new SpannableString(anvx.a(2131708267));
        localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
    label332:
    for (;;)
    {
      k();
      return;
      label87:
      if (paramInt == 2)
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.mContext, 2130838416);
          localSpannableString = new SpannableString(anvx.a(2131708196));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        if (VersionUtils.isHoneycomb())
        {
          if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
            this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.6F);
          }
          this.input.setAlpha(0.6F);
          this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
        }
      }
      else
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.mContext, 2130838416);
          localSpannableString = new SpannableString(anvx.a(2131708242));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.input.getText().length() > 0) {
          this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690786);
        }
        for (;;)
        {
          if (!VersionUtils.isHoneycomb()) {
            break label332;
          }
          if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
            this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          }
          this.input.setAlpha(1.0F);
          this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
          break;
          this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        }
      }
    }
  }
  
  public void setLeftCheckBoxVisible(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!d()) {
        this.jdField_p_of_type_Int = 2;
      }
      for (;;)
      {
        if (this.mInputBar != null) {
          this.mInputBar.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        super.setLeftCheckBoxVisible(paramBoolean1, paramChatMessage, paramBoolean2);
        return;
        if (!c()) {
          this.jdField_p_of_type_Int = 1;
        } else {
          this.jdField_p_of_type_Int = 0;
        }
      }
    }
    super.setLeftCheckBoxVisible(paramBoolean1, paramChatMessage, paramBoolean2);
    switch (this.jdField_p_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_p_of_type_Int = -1;
      return;
      if (this.mInputBar != null) {
        this.mInputBar.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        continue;
        if (this.mInputBar != null) {
          this.mInputBar.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
          continue;
          if (this.mInputBar != null) {
            this.mInputBar.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
          }
        }
      }
    }
  }
  
  public void setList(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    this.jdField_u_of_type_Boolean = true;
    super.setList(paramList, paramCharSequence);
    int i1;
    long l1;
    if (this.isFromOnCreate)
    {
      if (paramList.size() <= 0) {
        break label177;
      }
      paramList = (ChatMessage)paramList.get(paramList.size() - 1);
      i1 = paramList.msgtype;
      l1 = paramList.msgseq;
      if (!(paramList instanceof MessageForStructing)) {
        break label174;
      }
      paramList = (MessageForStructing)paramList;
      if (paramList.structingMsg == null) {
        break label174;
      }
      l1 = paramList.structingMsg.msgId;
    }
    for (;;)
    {
      bdla.b(this.app, "dc00899", "Pb_account_lifeservice", "" + this.sessionInfo.curFriendUin, "0X80064D4", "0X80064D4", 0, 0, "", "" + i1, "" + l1, "");
      return;
      label174:
      continue;
      label177:
      l1 = 0L;
      i1 = -1;
    }
  }
  
  public void setList(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    QLog.i(this.tag, 2, "<<<<<<<<<<<<<<list.size<<<<<<<<<" + paramList.size());
    try
    {
      if (j())
      {
        if (this.B)
        {
          this.listAdapter.a = Boolean.valueOf(false);
          if (this.jdField_a_of_type_Ooy == null) {
            return;
          }
          this.jdField_a_of_type_Ooy.a(paramList, new aiez(this, paramCharSequence, paramInt));
          return;
        }
        if (this.jdField_a_of_type_Ooy == null) {
          return;
        }
        this.jdField_a_of_type_Ooy.a(paramList, new aifa(this, paramCharSequence, paramInt));
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e(this.tag, 1, QLog.getStackTraceString(localThrowable1));
      if (uuc.a(this.sessionInfo)) {}
      try
      {
        ((akrc)this.app.getManager(QQManagerFactory.QWALLET_GDT_AD_MANAGER)).a(paramList);
        super.setList(paramList, paramCharSequence, paramInt);
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.e(this.tag, 1, localThrowable2, new Object[0]);
        }
      }
    }
  }
  
  public void setOverScrollHandleVisable(boolean paramBoolean)
  {
    if (this.jdField_h_of_type_Boolean)
    {
      if (paramBoolean)
      {
        if (this.listView.getOverScrollHeaderView() == null)
        {
          if (this.jdField_h_of_type_AndroidViewView == null) {
            l();
          }
          this.listView.setOverScrollHeader(this.jdField_h_of_type_AndroidViewView);
        }
        return;
      }
      this.listView.setOverscrollHeader((Drawable)null);
      this.listView.setOverScrollHeader((View)null);
      return;
    }
    super.setOverScrollHandleVisable(paramBoolean);
  }
  
  public void setTag()
  {
    this.tag = "PublicAccountChatPie";
  }
  
  public void startDelAnim(ChatMessage paramChatMessage)
  {
    int i1 = this.listAdapter.a(paramChatMessage) + 1;
    if ((i1 >= 0) && (i1 <= this.listAdapter.getCount() - 1))
    {
      ChatMessage localChatMessage = (ChatMessage)this.listAdapter.getItem(i1);
      if ((localChatMessage != null) && (localChatMessage.msgtype == -1048))
      {
        super.startDelAnim(paramChatMessage);
        a(localChatMessage);
        return;
      }
    }
    super.startDelAnim(paramChatMessage);
  }
  
  public void startDelAnimAndDelMsg(ChatMessage paramChatMessage)
  {
    super.startDelAnimAndDelMsg(paramChatMessage);
    Object localObject = paramChatMessage.frienduin;
    int i1 = paramChatMessage.istroop;
    if (uqx.a().a(this.app, (String)localObject, i1))
    {
      aoxz localaoxz = this.app.getProxyManager().a();
      localObject = (RecentUser)localaoxz.findRecentUserByUin((String)localObject, i1);
      if (localObject != null) {
        localaoxz.delRecentUser((BaseRecentUser)localObject);
      }
    }
    if ((j()) && (this.jdField_a_of_type_Ooy != null)) {
      this.jdField_a_of_type_Ooy.a(paramChatMessage);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageRecord))
    {
      localObject = ((MessageRecord)paramObject).getExtInfoFromExtStr("welcome_msg");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("true"))) {
        ThreadManager.post(new PublicAccountChatPie.47(this), 8, null, false);
      }
      this.jdField_q_of_type_Boolean = true;
    }
    if ((bmhv.a(this.app)) && ((paramObject instanceof MessageRecord))) {
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.sessionInfo.curFriendUin);
    }
    super.update(paramObservable, paramObject);
    int i1;
    if ((paramObservable instanceof bfhm)) {
      if ((paramObject instanceof Integer))
      {
        i1 = ((Integer)paramObject).intValue();
        if (i1 != 0) {
          break label153;
        }
        this.jdField_a_of_type_Bfhm.a(this.app);
        this.jdField_a_of_type_Bfhm.b();
      }
    }
    label148:
    label152:
    label153:
    do
    {
      break label152;
      break label152;
      break label152;
      break label152;
      I();
      for (;;)
      {
        return;
        if (i1 != 1) {
          break label148;
        }
        this.I = true;
        break label148;
        if ((paramObservable instanceof QQMessageFacade))
        {
          if (this.jdField_a_of_type_Bfhm == null) {
            break;
          }
          paramObject = (TroopManager)this.mActivity.app.getManager(QQManagerFactory.TROOP_MANAGER);
          paramObservable = ((QQMessageFacade)paramObservable).getIncomingMsg();
          if (paramObservable == null) {
            break;
          }
          paramObservable = paramObject.c(paramObservable.frienduin);
          if (paramObservable == null) {
            break;
          }
          try
          {
            if (paramObservable.associatePubAccount == Long.valueOf(this.sessionInfo.curFriendUin).longValue())
            {
              paramObject = Message.obtain();
              paramObject.what = 9;
              localObject = new Bundle();
              ((Bundle)localObject).putString("troopUin", paramObservable.troopuin);
              paramObject.setData((Bundle)localObject);
              this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
              return;
            }
          }
          catch (NumberFormatException paramObservable)
          {
            QLog.d(this.tag, 2, "exception: sessionInfo curFriendUin is not a long type.");
            return;
          }
        }
      }
    } while (!this.jdField_h_of_type_Boolean);
    ThreadManager.post(new PublicAccountChatPie.48(this), 5, null, false);
  }
  
  public void updateSession(Intent paramIntent)
  {
    super.updateSession(paramIntent);
    a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramIntent);
    this.root.post(new PublicAccountChatPie.35(this));
    ac();
    s();
    ag();
    this.refreshMessageContext.msgRefresher = new acns(this.app.getMessageFacade().getC2CMessageManager());
  }
  
  public boolean updateSession_updateSimpleBar()
  {
    PublicAccountInfo localPublicAccountInfo = ((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.sessionInfo.curFriendUin);
    return (localPublicAccountInfo == null) || ((localPublicAccountInfo.accountFlag & 0x10000000) == 0);
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    super.updateSession_updateTitle(paramIntent);
    if (uuc.a(this.app)) {
      this.mTitleText.setText(this.sessionInfo.curFriendUin);
    }
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    super.updateSession_updateTitleBtnCall();
    h();
  }
  
  public void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    super.updateSession_updateTitleLeftView(paramIntent);
    if (this.mDefaultLeftBack != null) {
      this.mDefaultLeftBack.setContentDescription(this.app.getApplication().getString(2131690499));
    }
    if (this.mTitleBtnLeft != null) {
      this.mTitleBtnLeft.setText("");
    }
  }
  
  public void updateSession_updateTitleRightView()
  {
    if (this.mTitleBtnRight != null)
    {
      if ("2277373213".equals(this.sessionInfo.curFriendUin)) {
        this.mCustomTitleView.setRight1Icon(2130847345);
      }
    }
    else {
      return;
    }
    if (k()) {
      this.mCustomTitleView.findViewById(2131369245).setVisibility(8);
    }
    for (;;)
    {
      this.mCustomTitleView.setRight1Icon(2130850149, 2130850150);
      this.mTitleBtnRight.setContentDescription(this.mActivity.getText(2131696155));
      return;
      this.mCustomTitleView.setRight1Icon(2130850149, 2130850150);
    }
  }
  
  public void updateSession_updateUI(Intent paramIntent)
  {
    super.updateSession_updateUI(paramIntent);
    if (this.v) {
      q();
    }
    if (ahcf.a(this.sessionInfo.curFriendUin))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aido
 * JD-Core Version:    0.7.0.1
 */