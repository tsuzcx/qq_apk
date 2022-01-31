import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
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
import com.tencent.ark.ArkDispatchTask;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.11;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.16;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.24;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.25;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.30;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.31;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.32;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.43;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.44;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.45;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.49;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.50;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.52;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.57;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.58;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.8;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.PublicMenuBar;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
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

public class aegy
  extends BaseChatPie
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F = -1;
  private int G;
  private int H;
  private int I;
  private int J;
  boolean T = false;
  public boolean U = false;
  public boolean V;
  boolean W = false;
  boolean X = false;
  boolean Y = false;
  public boolean Z;
  private aeir jdField_a_of_type_Aeir;
  private ajjh jdField_a_of_type_Ajjh;
  protected ajmm a;
  public ajpe a;
  private akig jdField_a_of_type_Akig;
  public Handler a;
  protected SpannableString a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public aqeb a;
  public aynx a;
  public bcpn a;
  public bcqu a;
  begr jdField_a_of_type_Begr;
  private bepb jdField_a_of_type_Bepb = new aeij(this);
  public CustomMenuBar a;
  public PublicAccountHandler a;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  public PublicAccountInfo a;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  PublicMenuBar jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = null;
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new aehl(this);
  public ncw a;
  public nfb a;
  nfu jdField_a_of_type_Nfu = new aeig(this);
  public int[] a;
  private boolean aA;
  private boolean aB;
  public boolean aa;
  public boolean ab;
  boolean ac = false;
  public boolean ad = false;
  boolean ae = false;
  boolean af = false;
  boolean ag = false;
  boolean ah = false;
  public boolean ai;
  boolean aj = false;
  boolean ak = false;
  public boolean al;
  public boolean am;
  boolean an = false;
  public boolean ao = false;
  boolean ap = false;
  boolean aq = false;
  boolean ar = false;
  public boolean as;
  private boolean at;
  private boolean au;
  private boolean av;
  private boolean aw;
  private boolean ax;
  private boolean ay;
  private boolean az;
  private akig jdField_b_of_type_Akig;
  protected SpannableString b;
  public View.OnClickListener b;
  private PublicMenuBar jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_b_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  protected LinearLayout c;
  private bafb jdField_c_of_type_Bafb;
  protected PatchedButton c;
  List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_c_of_type_MqqAppNewIntent;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  bbms jdField_d_of_type_Bbms;
  long jdField_g_of_type_Long = -1L;
  Dialog jdField_g_of_type_AndroidAppDialog;
  public String g;
  long jdField_h_of_type_Long = -1L;
  private Dialog jdField_h_of_type_AndroidAppDialog;
  public String h;
  long i;
  public String i;
  long j;
  public String j;
  private long k;
  public String k;
  private long jdField_l_of_type_Long;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  public String l;
  private long jdField_m_of_type_Long;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  public String m;
  private long n;
  public String n;
  private long jdField_o_of_type_Long;
  public View o;
  private String jdField_o_of_type_JavaLangString = "";
  public View p;
  protected ImageView p;
  public int q;
  View q;
  protected ImageView q;
  public int r;
  View r;
  public ImageView r;
  int jdField_s_of_type_Int = 0;
  View jdField_s_of_type_AndroidViewView;
  private ImageView jdField_s_of_type_AndroidWidgetImageView;
  int jdField_t_of_type_Int = 3;
  private View jdField_t_of_type_AndroidViewView;
  private ImageView jdField_t_of_type_AndroidWidgetImageView;
  protected int u;
  private View u;
  protected int v;
  private View v;
  public int w;
  private View w;
  public int x;
  public int y;
  public int z;
  
  public aegy(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_o_of_type_AndroidViewView = null;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_r_of_type_Int = -1;
    this.jdField_i_of_type_Long = -1L;
    this.jdField_u_of_type_Int = 2130837666;
    this.jdField_v_of_type_Int = 2130837665;
    this.jdField_k_of_type_Long = 9223372036854775807L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_G_of_type_Int = -1;
    this.jdField_a_of_type_Aqeb = new aqeb("web_public_account", "com.tencent.mobileqq:tool");
    this.jdField_a_of_type_AndroidOsHandler = new aegz(this);
    this.jdField_a_of_type_Ajmm = new aeiq(this);
    this.jdField_a_of_type_Ajpe = new aeif(this);
    this.jdField_a_of_type_Bcqu = new aeik(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aein(this);
  }
  
  private void F(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new PublicAccountChatPie.24(this, paramInt), 500L);
  }
  
  private void G(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams.gravity != paramInt)
      {
        localLayoutParams.gravity = paramInt;
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    } while (localLayoutParams.gravity == paramInt);
    localLayoutParams.gravity = paramInt;
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  private boolean H()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ("2747277822".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private void a(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1)) {
      G(80);
    }
    while (!CustomMenuBar.a()) {
      return;
    }
    G(16);
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.addUpdateListener(new aehb(this, paramView, paramInt1, paramInt2));
    localValueAnimator.addListener(paramAnimatorListener);
    localValueAnimator.setDuration(500L).start();
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("firstIntoAIO", true))
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.parseColor("#B3000000"));
      localLinearLayout.setVisibility(0);
      localLinearLayout.setClickable(true);
      localLinearLayout.setOnClickListener(new aeie(this, paramRelativeLayout, localLinearLayout));
      Object localObject = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((ImageView)localObject).setImageResource(2130841123);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      Resources localResources = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      localLayoutParams.width = aciy.a(73.0F, localResources);
      localLayoutParams.height = aciy.a(73.0F, localResources);
      localLayoutParams.topMargin = aciy.a(100.0F, localResources);
      localLayoutParams.gravity = 17;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((TextView)localObject).setText(ajjy.a(2131643012));
      ((TextView)localObject).setTextSize(2, 18.0F);
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = aciy.a(28.0F, localResources);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      paramRelativeLayout.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
      localSharedPreferences.edit().putBoolean("firstIntoAIO", false).commit();
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountChatPie.25(this, paramAccountDetail), 10L);
  }
  
  private void a(MessageForStructing paramMessageForStructing)
  {
    int i1 = 0;
    if (paramMessageForStructing.structingMsg == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramMessageForStructing.structingMsg;
      this.jdField_o_of_type_JavaLangString = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
      this.jdField_q_of_type_Int = paramMessageForStructing.structingMsg.mPromotionType;
      this.jdField_g_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMsg;
      this.jdField_h_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMenus;
      this.jdField_r_of_type_Int = paramMessageForStructing.structingMsg.mPromotionMenuDestructiveIndex;
      try
      {
        if (this.jdField_h_of_type_JavaLangString == null) {
          continue;
        }
        this.aB = false;
        paramMessageForStructing = this.jdField_h_of_type_JavaLangString.split(",");
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
        this.aB = true;
      }
    }
  }
  
  private void a(String paramString, int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("need_report", false))
    {
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
      long l1 = paramIntent.getLongExtra("incoming_msguid", 0L);
      long l2 = paramIntent.getLongExtra("incoming_shmsgseq", 0L);
      if (l1 > 0L) {
        ThreadManager.post(new PublicAccountChatPie.32(this, paramString, paramInt, l1, l2), 5, null, true);
      }
    }
    if (paramIntent.hasExtra("need_report")) {
      paramIntent.removeExtra("need_report");
    }
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (ajoy)paramQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((ajoy)localObject).b(paramString);; localObject = null)
    {
      if (localObject == null)
      {
        paramQQAppInterface = paramQQAppInterface.a();
        if (paramQQAppInterface != null)
        {
          paramString = paramQQAppInterface.a(paramString, 1008);
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
  
  private void b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localatmp.b(paramAccountDetail);
    localatmp.a();
  }
  
  private void b(AbsListView paramAbsListView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      int i2 = paramAbsListView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = paramAbsListView.getChildAt(i1);
        if (localView != null) {
          yoi.a().a(localView);
        }
        i1 += 1;
      }
    }
  }
  
  private void bF()
  {
    ThreadManager.postImmediately(new PublicAccountChatPie.7(this), null, true);
  }
  
  private void bG()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null) {
      H();
    }
  }
  
  private void bH()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("op", "0");
      localBundle.putString("puin", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      localBundle.putString("Referer", "https://buluo.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new azgm("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new aehn(this), 1000, null).a(localHashMap);
      bo();
      return;
    }
  }
  
  private void bI()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("public_aio_setting", 0);
    String str = "firstOpen_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (localSharedPreferences.getBoolean(str, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_a_of_type_Ncw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.30(this, localSharedPreferences, str));
  }
  
  private void bJ()
  {
    if (this.jdField_m_of_type_Long == 0L) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (localObject != null) {
      localHashMap.put("uin", localObject);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
      localHashMap.put("puin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    localHashMap.put("menu_click", "" + this.jdField_w_of_type_Int);
    localHashMap.put("menu_to_webview", "" + this.y);
    localHashMap.put("article_click", "" + this.x);
    localHashMap.put("article_to_webview", "" + this.jdField_z_of_type_Int);
    localHashMap.put("net_type", "" + axsr.a().a());
    localHashMap.put("unread_count", "" + this.E);
    long l1 = System.currentTimeMillis() - this.jdField_m_of_type_Long;
    if ((this.jdField_z_of_type_Int != 0) || (this.y != 0)) {}
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
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
      }
      awrn.a(BaseApplication.getContext()).a(null, "actPublicAccountWebviewPreload", bool, l1, 0L, localHashMap, "");
      this.jdField_m_of_type_Long = 0L;
      this.E = 0;
      this.y = 0;
      this.jdField_w_of_type_Int = 0;
      this.x = 0;
      this.jdField_z_of_type_Int = 0;
      return;
    }
  }
  
  private void bK()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((ajoy)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      return;
    }
    Object localObject = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), ndt.class);
    ((NewIntent)localObject).putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.2.6,3,4370");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      label163:
      ((NewIntent)localObject).putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new aehu(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  private void bL()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      ajoy localajoy = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localajoy != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localajoy.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      bM();
    }
  }
  
  private void bM()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.requestPermissions(new aeic(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      bN();
      return;
    }
    bN();
  }
  
  private void bN()
  {
    SosoInterface.a(new aeid(this, 1, true, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void bO()
  {
    a((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getParent());
  }
  
  private void bP()
  {
    Object localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((ajoy)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (rtr.a(((PublicAccountInfo)localObject).accountFlag2) == -10L))
      {
        this.aA = true;
        localObject = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 115, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon((Drawable)localObject);
        }
      }
    }
  }
  
  private void bQ()
  {
    if (this.jdField_o_of_type_Long == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_o_of_type_Long;
    PublicAccountInfo localPublicAccountInfo = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localPublicAccountInfo != null) {
      ahcb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPublicAccountInfo.uin + "", l1 - l2, localPublicAccountInfo.name + "");
    }
    this.jdField_o_of_type_Long = 0L;
  }
  
  private void c(AccountDetail paramAccountDetail)
  {
    if (this.jdField_o_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject1 = (TextView)this.jdField_o_of_type_AndroidViewView.findViewById(2131312767);
    Object localObject2 = (TextView)this.jdField_o_of_type_AndroidViewView.findViewById(2131312766);
    ImageView localImageView = (ImageView)this.jdField_o_of_type_AndroidViewView.findViewById(2131302061);
    if (this.ay) {
      if ((this.jdField_a_of_type_Aynx != null) && (this.jdField_a_of_type_Aynx.b > 0) && (this.jdField_a_of_type_Aynx.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_Aynx.jdField_a_of_type_JavaUtilList.get(0);
        ((TextView)localObject1).setText(localTroopInfo.troopname);
        ((TextView)localObject2).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131629863), new Object[] { paramAccountDetail.name }));
        localImageView.setImageDrawable(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localTroopInfo.troopuin));
        localObject1 = "";
        if (this.jdField_a_of_type_Aynx.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = ((TroopInfo)this.jdField_a_of_type_Aynx.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          break label318;
        }
        localObject2 = "";
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "exp_temp", 0, 0, (String)localObject1, "" + (String)localObject2, "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ajjh == null)
      {
        this.jdField_a_of_type_Ajjh = new aehy(this, localImageView);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.addObserver(this.jdField_a_of_type_Ajjh);
      }
      localObject1 = (ImageView)this.jdField_o_of_type_AndroidViewView.findViewById(2131298465);
      if (paramAccountDetail.certifiedGrade != 0) {
        break label375;
      }
      ((ImageView)localObject1).setVisibility(8);
      return;
      label318:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break;
      ((TextView)localObject1).setText(paramAccountDetail.name);
      if (this.jdField_g_of_type_JavaLangString != null) {
        ((TextView)localObject2).setText(this.jdField_g_of_type_JavaLangString);
      }
      localImageView.setImageDrawable(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().jdField_a_of_type_JavaLangString, (byte)3));
    }
    label375:
    ((ImageView)localObject1).setVisibility(0);
  }
  
  private void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow");
    }
    F(2131629936);
    Object localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((ajoy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (rtr.a(((AccountDetail)localObject).accountFlag) != -4)) {
        break label191;
      }
      localObject = new NewIntent(BaseApplicationImpl.getContext(), ndt.class);
      ((NewIntent)localObject).putExtra("cmd", "unfollow");
      mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
      localUnFollowRequest.uin.set((int)Long.parseLong(paramString));
      ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
      this.jdField_b_of_type_MqqObserverBusinessObserver = new aeho(this, paramString);
      ((NewIntent)localObject).setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
    }
    for (;;)
    {
      this.I += 1;
      rtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow exit");
      }
      return;
      label191:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Akig);
      this.jdField_b_of_type_Akig = new akig(new aehp(this, paramString));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Akig);
      akil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
  }
  
  public void A(int paramInt)
  {
    if (this.jdField_d_of_type_Bbms == null) {
      this.jdField_d_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_Bbms != null))
    {
      this.jdField_d_of_type_Bbms.c(paramInt);
      if (!this.jdField_d_of_type_Bbms.isShowing()) {
        this.jdField_d_of_type_Bbms.show();
      }
    }
  }
  
  public void B(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  public void C(int paramInt)
  {
    try
    {
      this.jdField_m_of_type_AndroidWidgetTextView.setText(paramInt);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_t_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void D(int paramInt)
  {
    try
    {
      this.jdField_t_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        return;
        this.jdField_m_of_type_AndroidWidgetTextView.setText(2131653910);
        continue;
        this.jdField_m_of_type_AndroidWidgetTextView.setText(2131653904);
        continue;
        this.jdField_m_of_type_AndroidWidgetTextView.setText(2131629889);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean D()
  {
    Object localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((ajoy)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject == null) && (rtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null))
      {
        rtr.a();
        rtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return true;
      }
      return false;
    }
  }
  
  public void E(int paramInt)
  {
    if (this.jdField_h_of_type_AndroidAppDialog == null)
    {
      this.jdField_h_of_type_AndroidAppDialog = new Dialog(a(), 2131690181);
      this.jdField_h_of_type_AndroidAppDialog.setContentView(2131494954);
    }
    TextView localTextView1 = (TextView)this.jdField_h_of_type_AndroidAppDialog.findViewById(2131311534);
    TextView localTextView2 = (TextView)this.jdField_h_of_type_AndroidAppDialog.findViewById(2131296351);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_h_of_type_AndroidAppDialog.setOnCancelListener(new aeil(this));
      this.jdField_h_of_type_AndroidAppDialog.show();
      return;
      localTextView1.setText(2131632515);
      localTextView2.setText(2131632521);
      continue;
      localTextView1.setText(2131632516);
      localTextView2.setText(2131632517);
      continue;
      localTextView1.setText(2131632519);
      localTextView2.setText(2131632517);
    }
  }
  
  public boolean E()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1008);
      if (localObject != null) {
        if (((QQMessageFacade.Message)localObject).msgtype == -2011)
        {
          localMessageForStructing = new MessageForStructing();
          MessageForStructing.copyMessageRecordBaseField(localMessageForStructing, (MessageRecord)localObject);
          localMessageForStructing.parse();
          if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mPromotionType == 1) || (localMessageForStructing.structingMsg.mPromotionType == 2))) {
            a(localMessageForStructing);
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
            this.jdField_q_of_type_Int = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean F()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 8);
  }
  
  public void G()
  {
    ohp.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_l_of_type_Long, this.ac, this.jdField_a_of_type_Acka.a());
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(null);
    }
    if (this.N) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
    }
    for (;;)
    {
      return;
      rtr.a();
      if (this.jdField_a_of_type_Aeir != null) {}
      try
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Aeir);
        label89:
        this.jdField_a_of_type_Aeir = null;
        if (this.jdField_b_of_type_MqqAppNewIntent != null) {
          ncw.a().a(this.jdField_b_of_type_MqqAppNewIntent);
        }
        if (this.jdField_c_of_type_MqqAppNewIntent != null) {
          this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
        }
        if (this.jdField_a_of_type_Ajjh != null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.removeObserver(this.jdField_a_of_type_Ajjh);
          this.jdField_a_of_type_Ajjh = null;
        }
        super.G();
        if (this.jdField_a_of_type_Ncw != null)
        {
          this.jdField_a_of_type_Ncw.a(a());
          this.jdField_a_of_type_Ncw.a(this.jdField_a_of_type_AndroidContentContext);
        }
        Iterator localIterator = this.jdField_a_of_type_Acka.a().iterator();
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
        if ((this.jdField_d_of_type_Bbms != null) && (this.jdField_d_of_type_Bbms.isShowing()))
        {
          this.jdField_d_of_type_Bbms.dismiss();
          this.jdField_d_of_type_Bbms = null;
        }
        if ((this.jdField_h_of_type_AndroidAppDialog != null) && (this.jdField_h_of_type_AndroidAppDialog.isShowing()))
        {
          this.jdField_h_of_type_AndroidAppDialog.dismiss();
          this.jdField_h_of_type_AndroidAppDialog = null;
        }
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
        }
        if ((this.jdField_c_of_type_Bafb != null) && (this.jdField_c_of_type_Bafb.isShowing()))
        {
          this.jdField_c_of_type_Bafb.dismiss();
          this.jdField_c_of_type_Bafb = null;
        }
        if (this.jdField_a_of_type_Aynx != null) {
          this.jdField_a_of_type_Aynx.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.d();
        }
        bm();
        bJ();
        if (this.jdField_l_of_type_Long != 0L)
        {
          this.jdField_l_of_type_Long = (System.currentTimeMillis() - this.jdField_l_of_type_Long);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D5", "0X80064D5", 0, 0, "", "" + this.jdField_l_of_type_Long, "" + this.J, "");
          this.jdField_l_of_type_Long = 0L;
          this.D = 0;
        }
        if (this.ai) {
          ThreadManager.executeOnSubThread(new PublicAccountChatPie.8(this));
        }
        bz();
        rtr.jdField_a_of_type_Boolean = false;
        try
        {
          if (!"3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          ArkAppNotifyCenter.unRegistVolumnReceiver();
          ArkAppNotifyCenter.setNotify("com.tencent.gouwu.video", null);
          return;
        }
        catch (Throwable localThrowable) {}
      }
      catch (Exception localException)
      {
        break label89;
      }
    }
  }
  
  public boolean G()
  {
    return (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) || (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getVisibility() == 8);
  }
  
  public void K()
  {
    super.K();
    bQ();
    long l1 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      int i1 = this.jdField_b_of_type_JavaUtilList.size() - 1;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C35", "0X8005C35", 0, 1, 0, (String)this.jdField_b_of_type_JavaUtilList.get(i1), String.valueOf(this.jdField_g_of_type_Long), String.valueOf(l1), (String)this.jdField_c_of_type_JavaUtilList.get(i1));
    }
    if (this.Z)
    {
      if (this.aa) {
        ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "new", String.valueOf(l1 - this.jdField_i_of_type_Long), "", "", false);
      }
    }
    else {
      return;
    }
    ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "old", String.valueOf(l1 - this.jdField_i_of_type_Long), "", "", false);
  }
  
  public void L()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      ((nfp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    super.L();
    this.jdField_a_of_type_Aqeb.d();
    PublicAccountInfo localPublicAccountInfo = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localPublicAccountInfo != null) {}
    switch (rtr.a(localPublicAccountInfo.accountFlag))
    {
    default: 
      return;
    case -7: 
    case -6: 
    case -1: 
      akij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_G_of_type_Int, 2, System.currentTimeMillis() - this.jdField_n_of_type_Long);
      return;
    case -4: 
    case -3: 
    case -2: 
      akij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_G_of_type_Int, 3, System.currentTimeMillis() - this.jdField_n_of_type_Long);
      return;
    }
    akij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_G_of_type_Int, 4, System.currentTimeMillis() - this.jdField_n_of_type_Long);
  }
  
  public void M()
  {
    super.M();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(37, 500L);
    if (this.jdField_a_of_type_Aynx.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aynx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Aynx.c();
    }
    if ((adkp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(ajjy.a(2131642958));
    }
    if ((!this.au) && (this.av))
    {
      this.av = false;
      ThreadManager.postImmediately(new PublicAccountChatPie.4(this), null, true);
    }
    this.jdField_i_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      if (lqh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
    }
    for (;;)
    {
      nft localnft = (nft)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(68);
      if (rol.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        long l1 = 0L;
        if (nfp.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {
          l1 = ((Long)nfp.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).longValue();
        }
        if ((!TextUtils.isEmpty((String)nfp.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && (System.currentTimeMillis() - l1 <= nfp.jdField_a_of_type_Int)) {
          break;
        }
        nfp.b.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
        localnft.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      if ((this.e.getText() != null) && (this.e.getText().length() < 6)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      } else {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    if (lqh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130845993);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void O()
  {
    if ((this.ay) && (this.az)) {
      return;
    }
    this.jdField_o_of_type_Long = System.currentTimeMillis();
    ArkAppCenter.a().post("com.tencent.weather", new PublicAccountChatPie.49(this));
    super.O();
    if (!this.az) {
      ThreadManager.post(new PublicAccountChatPie.50(this), 5, null, false);
    }
    this.az = true;
    this.jdField_n_of_type_Long = System.currentTimeMillis();
    awqx.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "exp", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "");
  }
  
  public void P()
  {
    super.P();
    this.au = false;
    this.av = false;
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
            paramAbsStructMsg = befm.b(paramAbsStructMsg.substring(paramAbsStructMsg.indexOf("?") + 1));
            return paramAbsStructMsg;
          }
        }
      }
      catch (Exception paramAbsStructMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramAbsStructMsg.getMessage());
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "PublicAccountChatPie";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.av = true;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.Z) {
      C(2131629894);
    }
  }
  
  void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    ajho localajho = (ajho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localajho != null) {
      localajho.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.an) {
      bC();
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Aynx != null)
      {
        Iterator localIterator = this.jdField_a_of_type_Aynx.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((TroopInfo)localIterator.next()).troopuin.equals(paramMessage.frienduin));
      }
      for (int i1 = 1; (paramMessage.istroop != 1) || (i1 == 0); i1 = 0)
      {
        super.a(paramMessage);
        return;
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    super.a(paramChatMessage);
    Object localObject = paramChatMessage.frienduin;
    int i1 = paramChatMessage.istroop;
    if (rqn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, i1))
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject = paramChatMessage.a((String)localObject, i1);
      if (localObject != null) {
        paramChatMessage.b((RecentUser)localObject);
      }
    }
  }
  
  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    ajoy localajoy;
    if (paramPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + paramPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + paramPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + paramPublicAccountInfo.mIsAgreeSyncLbs);
      }
      localajoy = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localajoy == null) {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): pam is null");
        }
      }
    }
    for (;;)
    {
      return;
      if ((paramPublicAccountInfo.isSyncLbs) && (!paramPublicAccountInfo.mIsSyncLbsSelected) && (!paramPublicAccountInfo.mIsAgreeSyncLbs) && (!this.aw))
      {
        String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131626598);
        String str2 = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131626596), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        this.jdField_g_of_type_AndroidAppDialog = babr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, str1, str2, 2131626595, 2131626597, new aehv(this, paramPublicAccountInfo, localajoy), new aehw(this, paramPublicAccountInfo, localajoy));
        this.jdField_g_of_type_AndroidAppDialog.setOnDismissListener(new aehx(this));
        this.jdField_g_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
          this.jdField_g_of_type_AndroidAppDialog.show();
        }
        this.aw = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): END");
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    ChatMessage localChatMessage;
    if (i1 <= paramAbsListView.getLastVisiblePosition())
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_Acka.getItem(i1);
      if (localChatMessage != null) {}
    }
    for (;;)
    {
      i1 += 1;
      break;
      String str3;
      long l1;
      try
      {
        String str1;
        if ((!localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("")) && (!localChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("true")))
        {
          localArrayList5.add(localChatMessage);
          str3 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
          str1 = str3;
          if (TextUtils.isEmpty(str3)) {
            str1 = "0";
          }
          l1 = Long.parseLong(str1);
          if (localChatMessage.getExtInfoFromExtStr("pa_should_report").equals("true"))
          {
            localArrayList4.add(Long.valueOf(l1));
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Report message at index: " + String.valueOf(i1) + ". MessageId is " + l1);
            }
          }
          localChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
          str3 = localChatMessage.getExtInfoFromExtStr("msg_template_id");
          str1 = str3;
          if (str3 == null) {
            str1 = "";
          }
          ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80057C4", "0X80057C4", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(l1), str1, "", false);
        }
        if (!localChatMessage.getExtInfoFromExtStr("ad_msgHasRead").equals("false")) {
          continue;
        }
        localChatMessage.saveExtInfoToExtStr("ad_msgHasRead", "true");
        String str4 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
        String str5 = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        str3 = "0";
        String str6 = localChatMessage.getExtInfoFromExtStr("gdt_view_id");
        try
        {
          JSONObject localJSONObject = new JSONObject(str5);
          str1 = str3;
          if (localJSONObject.has("ad_id")) {
            str1 = localJSONObject.getString("ad_id");
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            String str2 = str3;
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, " parse ad_id error");
              str2 = str3;
            }
          }
        }
        localArrayList1.add(str4);
        this.jdField_c_of_type_JavaUtilList.add(str1);
        localArrayList2.add(str5);
        localArrayList3.add(str6);
        if (localArrayList5.contains(localChatMessage)) {
          continue;
        }
        localArrayList5.add(localChatMessage);
      }
      catch (Exception localException2) {}
      b(localArrayList5);
      if (!localArrayList4.isEmpty()) {}
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_Ncw.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, 0L, l1, l2, 2, localArrayList4);
        paramAbsListView = localArrayList5.iterator();
        while (paramAbsListView.hasNext()) {
          if ("1".equals(((ChatMessage)paramAbsListView.next()).getExtInfoFromExtStr("is_AdArrive_Msg")))
          {
            if (this.jdField_g_of_type_Long == -1L) {
              this.jdField_g_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
            }
            this.jdField_b_of_type_JavaUtilList = localArrayList1;
            rsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList2, localArrayList1, localArrayList3);
          }
        }
        return;
      }
      catch (Exception paramAbsListView)
      {
        return;
      }
    }
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    this.am = true;
    super.a(paramList, paramCharSequence);
    int i1;
    long l1;
    if (this.jdField_z_of_type_Boolean)
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D4", "0X80064D4", 0, 0, "", "" + i1, "" + l1, "");
      return;
      label174:
      continue;
      label177:
      l1 = 0L;
      i1 = -1;
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qidianWpaClick ... mQidianKefu = " + this.ap);
    }
    A(2131629938);
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
      this.jdField_a_of_type_Ncw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMap, (String)localObject, null, new aeim(this));
      return;
      localObject = null;
      paramMap = null;
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!G()) {
        this.F = 2;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        super.a(paramBoolean1, paramChatMessage, paramBoolean2);
        return;
        if (!F()) {
          this.F = 1;
        } else {
          this.F = 0;
        }
      }
    }
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    switch (this.F)
    {
    }
    for (;;)
    {
      this.F = -1;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "listView onViewCompleteVisableAndReleased");
    }
    if (!this.Z) {
      return super.a(paramInt, paramView, paramListView);
    }
    if ((this.jdField_a_of_type_Acka != null) && (this.jdField_a_of_type_Acka.getCount() > 0))
    {
      this.ab = true;
      c(System.currentTimeMillis());
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ackd)this.jdField_a_of_type_Akcg.a).a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Akcg.e = false;
      this.jdField_a_of_type_Akcg.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 21, this.jdField_a_of_type_Akcg);
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Aeir = new aeir(this, null);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Aeir, (IntentFilter)localObject);
    this.N = false;
    this.jdField_G_of_type_Boolean = false;
    bG();
    this.jdField_a_of_type_Ncw = ncw.a();
    by();
    super.a(paramBoolean);
    if (this.an) {
      bA();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0) {
      this.ai = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(this.jdField_a_of_type_Bepb);
    this.jdField_a_of_type_Aynx = new aynx();
    this.jdField_a_of_type_Aynx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acka, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_Aynx.addObserver(this);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    this.D = ((Intent)localObject).getIntExtra("red_hot_count", 0);
    String str = ((Intent)localObject).getStringExtra("from");
    this.ae = ((Intent)localObject).getBooleanExtra("shouldreport", false);
    this.jdField_m_of_type_Long = System.currentTimeMillis();
    this.x = 0;
    this.jdField_z_of_type_Int = 0;
    this.jdField_w_of_type_Int = 0;
    this.y = 0;
    this.E = this.D;
    rtr.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("is_come_from_readinjoy", false);
    this.jdField_G_of_type_Int = ((Intent)localObject).getIntExtra("INTENT_KEY_FROM", 1);
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      PublicAccountInfo localPublicAccountInfo = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localPublicAccountInfo == null) || (rtr.a(localPublicAccountInfo.accountFlag) != -2)) {
        break label601;
      }
      this.ax = true;
      bq();
      this.jdField_a_of_type_Aynx.f();
      if (this.jdField_a_of_type_Aynx.b > 0) {
        break label483;
      }
      this.jdField_a_of_type_Aynx.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
    }
    for (;;)
    {
      PublicAccountHandler.jdField_a_of_type_JavaLangString = null;
      this.ac = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("has_unread_msg", false);
      if ((str == null) || (!str.equals("starShortcut"))) {
        break;
      }
      ncw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Intent)localObject).getStringExtra("starhomeurl"), ((Intent)localObject).getStringExtra("uin"), str);
      return true;
      label483:
      int i2 = ((azhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (i2 == -1)
      {
        this.jdField_a_of_type_Aynx.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
      }
      else
      {
        int i1;
        if ((i2 & 0xF) == 0)
        {
          i1 = 1;
          label545:
          if (i2 >> 4 != 1) {
            break label579;
          }
          i2 = 1;
          label554:
          if ((i1 == 0) || (i2 == 0)) {
            break label584;
          }
          this.ay = true;
        }
        for (;;)
        {
          bF();
          break;
          i1 = 0;
          break label545;
          label579:
          i2 = 0;
          break label554;
          label584:
          this.jdField_a_of_type_Aynx.e();
          this.jdField_a_of_type_Aynx.b();
        }
        label601:
        bF();
      }
    }
    if ((badq.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()) == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals("2632129500"))) {
      mof.b("108", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new aeih(this));
    }
    if ("3105932915".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (beyy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
      if (localObject != null) {
        beyv.a(((beyy)localObject).a(5));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    this.Z = rtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate, isMediaAndOtherSubscript = " + this.Z);
    }
    this.jdField_h_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (rtr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate, preload web process");
        }
        ((WebProcessManager)localObject).e();
      }
    }
    if (this.Z)
    {
      bO();
      bv();
      bx();
    }
    if (this.Z) {
      if (this.aa) {
        ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "new", "", "", false);
      }
    }
    for (;;)
    {
      ohp.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.V = true;
      }
      if ((H()) && (this.E > 0)) {
        ThreadManagerV2.excute(new PublicAccountChatPie.6(this), 16, null, false);
      }
      if ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        ((nfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(139)).a(null, null, false, null);
        ArkAppNotifyCenter.setNotify("com.tencent.gouwu.video", new WeakReference(new albi()));
        ArkAppNotifyCenter.registVolumnReceiver();
      }
      if (adkp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ahyd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5);
      }
      return true;
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "old", "", "", false);
      continue;
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
      if ("2290230341".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E2", "0X80090E2", 0, 0, "", "", "", "");
        awqu.a(2);
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    super.afterTextChanged(paramEditable);
    a(paramEditable);
    PatchedButton localPatchedButton;
    if (this.jdField_f_of_type_Int == 0)
    {
      if (!this.jdField_f_of_type_Boolean) {
        break label75;
      }
      this.jdField_c_of_type_ComTencentWidgetPatchedButton.setSelected(true);
      this.jdField_c_of_type_ComTencentWidgetPatchedButton.setText(2131625184);
      localPatchedButton = this.jdField_c_of_type_ComTencentWidgetPatchedButton;
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
      } while ((this.jdField_r_of_type_AndroidWidgetImageView != null) && (this.jdField_r_of_type_AndroidWidgetImageView.getVisibility() == 0));
      localPatchedButton = this.jdField_c_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() > 0) {
        bool1 = true;
      }
      localPatchedButton.setEnabled(bool1);
    } while (paramEditable.length() <= 0);
    this.jdField_c_of_type_ComTencentWidgetPatchedButton.setText(2131625184);
    this.jdField_c_of_type_ComTencentWidgetPatchedButton.setSelected(true);
  }
  
  public void ag()
  {
    if ((this.ax) && (rqn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) > 0)) {
      rqn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.ag();
    if (adkp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
      }
      if (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, null);
      }
    }
    for (;;)
    {
      nfp localnfp = (nfp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      if ((localnfp != null) && (localnfp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        ThreadManager.post(new PublicAccountChatPie.3(this), 5, null, true);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      msl.a().a(1000L);
      return;
      if (("3026775809".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSystemService("sensor")).getDefaultSensor(19) != null)) {
        ((basg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260)).a("public account");
      }
    }
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajpe);
    nfp localnfp = (nfp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
    if (rol.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Nfu);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bcqu);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajpe);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Nfu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bcqu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akig);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Akig);
  }
  
  public void az()
  {
    super.az();
    if (this.jdField_m_of_type_AndroidViewView != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_m_of_type_AndroidViewView.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (!G())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getId());
            return;
          }
          if (!F())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getId());
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
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.Z) {
      C(2131629905);
    }
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if (rtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    super.b(paramQQAppInterface);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (rol.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (rol.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      rol.a().a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_Acka.a(paramChatMessage) + 1;
    if ((i1 >= 0) && (i1 <= this.jdField_a_of_type_Acka.getCount() - 1))
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_Acka.getItem(i1);
      if ((localChatMessage != null) && (localChatMessage.msgtype == -1048))
      {
        super.b(paramChatMessage);
        e(localChatMessage);
        return;
      }
    }
    super.b(paramChatMessage);
  }
  
  void b(List<ChatMessage> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveReadedToDB");
    }
    ThreadManager.postImmediately(new PublicAccountChatPie.16(this, paramList), null, false);
  }
  
  void b(boolean paramBoolean, int paramInt)
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      ncw.a().a(this.jdField_b_of_type_MqqAppNewIntent);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    this.jdField_b_of_type_MqqAppNewIntent = ncw.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt, paramBoolean, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aehz(this));
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        return (((PublicAccountInfo)localObject).accountFlag & 0x40000000) == 1073741824;
      }
      return false;
    }
    Object localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((ajoy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        return false;
      }
      return (((AccountDetail)localObject).accountFlag & 0x40000000) == 1073741824;
    }
    return false;
  }
  
  public void bA()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkQDAccountValid ...");
    }
    ThreadManager.post(new PublicAccountChatPie.52(this), 8, null, false);
  }
  
  public void bB()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("updateHeader ... ");
      if (this.jdField_o_of_type_AndroidViewView == null) {
        break label71;
      }
    }
    label71:
    for (Object localObject = Integer.valueOf(this.jdField_o_of_type_AndroidViewView.getVisibility());; localObject = "")
    {
      QLog.d(str, 2, localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) && (this.ao)) {
        break;
      }
      return;
    }
    if (this.aq)
    {
      this.jdField_r_of_type_AndroidViewView.setVisibility(0);
      this.jdField_q_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_r_of_type_AndroidViewView.setVisibility(8);
    this.jdField_q_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void bC()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateWpaUiForQidian: mQidianAccountValid = " + this.ao + ", mQidianKefu = " + this.ap + ", mQidianShield: " + this.aq);
    }
    if (this.ao) {
      if (((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
        break label292;
      }
    }
    label292:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.e.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        bs();
        return;
      }
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      InputLinearLayout localInputLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
      if (this.aq) {
        i1 = 8;
      }
      for (;;)
      {
        localInputLinearLayout.setVisibility(i1);
        if (this.jdField_s_of_type_AndroidWidgetImageView == null) {
          this.jdField_s_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131300219));
        }
        this.jdField_s_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        if (this.jdField_o_of_type_AndroidViewView == null)
        {
          if (QLog.isColorLevel()) {
            QZLog.d(this.jdField_a_of_type_JavaLangString, 2, "setInitHeader in updateWpaUiForQidian");
          }
          bp();
        }
        bB();
        return;
        if (this.ap) {
          i1 = 0;
        } else {
          i1 = 8;
        }
      }
      this.e.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void bD()
  {
    if ((!this.ao) || (!this.ar)) {}
    int i1;
    do
    {
      return;
      if (((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {}
      for (i1 = 1; (this.aq) && (i1 == 0); i1 = 0)
      {
        ajzx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131632518), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, true);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
        return;
      }
    } while ((this.aq) || (i1 != 0));
  }
  
  public void bE()
  {
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.58(this));
  }
  
  public void bm()
  {
    ChatMessage localChatMessage;
    String str1;
    if (this.jdField_a_of_type_Acka.getCount() >= 1)
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_Acka.a().get(this.jdField_a_of_type_Acka.getCount() - 1);
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "old", String.valueOf(l1 - this.jdField_h_of_type_Long), "", "");
    }
    Object localObject = localChatMessage.getExtInfoFromExtStr("pa_msgId");
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "" + localChatMessage.frienduin, "0X8005C38", "0X8005C38", 0, 1, 0, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
    if (this.Z)
    {
      l1 = NetConnInfoCenter.getServerTime() * 1000L;
      if (this.aa) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "new", String.valueOf(l1 - this.jdField_h_of_type_Long), "", "");
      }
    }
    else
    {
      return;
    }
  }
  
  public void bn()
  {
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_Bbms != null) && (this.jdField_d_of_type_Bbms.isShowing())) {
      this.jdField_d_of_type_Bbms.dismiss();
    }
  }
  
  @TargetApi(11)
  void bo()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new PublicAccountChatPie.11(this));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_u_of_type_AndroidViewView);
      this.at = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    a(this.jdField_u_of_type_AndroidViewView, this.jdField_u_of_type_AndroidViewView.getHeight(), 0, new aehc(this));
    this.jdField_o_of_type_AndroidViewView.setTranslationY(0.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_o_of_type_AndroidViewView.getHeight());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new aehd(this));
    this.jdField_o_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  void bp()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        this.jdField_o_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2131493020, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      } while (this.jdField_o_of_type_AndroidViewView == null);
      this.jdField_o_of_type_AndroidViewView.setClickable(true);
      this.jdField_o_of_type_AndroidViewView.findViewById(2131302061).setOnClickListener(new aehg(this));
      if (this.jdField_q_of_type_Int != 2) {
        break;
      }
      this.jdField_o_of_type_AndroidViewView.findViewById(2131306399).setVisibility(8);
      this.jdField_o_of_type_AndroidViewView.findViewById(2131306385).setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_o_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_u_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2131493019, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    } while (this.jdField_u_of_type_AndroidViewView == null);
    label218:
    int i1;
    label268:
    label380:
    wpb localwpb1;
    if (this.jdField_q_of_type_Int == 2)
    {
      this.jdField_u_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131166330));
      if ((!this.an) && (!this.as)) {
        break label568;
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject != null)
      {
        localObject = ((ajoy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (this.U))
        {
          c((AccountDetail)localObject);
          this.U = false;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = ((PublicMenuBar)this.jdField_o_of_type_AndroidViewView.findViewById(2131306382));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setOnMenuItemClickListener(new aehh(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a();
      if (this.an) {
        break label613;
      }
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      if (!this.ay) {
        break label606;
      }
      i1 = 2131626323;
      localObject = new wpb("DO_NOT_FOLLOW", ((FragmentActivity)localObject).getString(i1), a().getResources().getDrawable(2130841214), 0);
      localwpb1 = new wpb("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131626320), a().getResources().getDrawable(2130841116), 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((wpb)localObject, 2131494209);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localwpb1, 2131494209);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setSwitchButtonVisibility(false);
      if (!this.aA) {
        break label768;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(8);
      return;
      if (!this.an) {
        break;
      }
      this.jdField_o_of_type_AndroidViewView.findViewById(2131306399).setVisibility(8);
      this.jdField_o_of_type_AndroidViewView.findViewById(2131306385).setVisibility(8);
      break;
      if (!this.an) {
        break label218;
      }
      this.jdField_u_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131166330));
      break label218;
      label568:
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_u_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter((ListAdapter)localObject);
      break label268;
      label606:
      i1 = 2131626322;
      break label380;
      label613:
      localObject = new wpb("DO_CANCEL", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131625040), a().getResources().getDrawable(2130841214), 0);
      localwpb1 = new wpb("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131626320), a().getResources().getDrawable(2130841116), 1);
      wpb localwpb2 = new wpb("DO_NOT_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131626323), a().getResources().getDrawable(2130841214), 0);
      this.jdField_r_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((wpb)localObject, 2131494209);
      this.jdField_q_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localwpb2, 2131494209);
      this.jdField_s_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localwpb1, 2131494209);
    }
    label768:
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(0);
  }
  
  void bq()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    if (this.jdField_i_of_type_AndroidViewView != null) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_j_of_type_AndroidViewView != null) {
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  void br()
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = ((begr)behe.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null));
      this.jdField_a_of_type_Begr.a(ajjy.a(2131643005));
      this.jdField_a_of_type_Begr.a(ajjy.a(2131643001), 3);
      this.jdField_a_of_type_Begr.c(2131625035);
      this.jdField_a_of_type_Begr.setOnDismissListener(new aehk(this));
      this.jdField_a_of_type_Begr.a(new aehm(this));
    }
    if (!this.jdField_a_of_type_Begr.isShowing())
    {
      this.ah = false;
      this.jdField_a_of_type_Begr.show();
    }
  }
  
  void bs()
  {
    if (this.au) {
      break label7;
    }
    label7:
    label816:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
        this.jdField_s_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131300219));
        if (this.jdField_s_of_type_AndroidWidgetImageView != null) {
          this.jdField_s_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131631016));
        }
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar);
        }
        if (this.jdField_o_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_o_of_type_AndroidViewView);
          this.jdField_o_of_type_AndroidViewView = null;
        }
        if (this.jdField_u_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_u_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300218));
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131493021, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300218));
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) {
            break label816;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_Ncw.b(a()));
          if (CustomMenuBar.a())
          {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101397));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(aciy.a(48.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
          {
            Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
            Object localObject2 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getLayoutParams();
            if ((localObject3 != null) && (localObject2 != null) && ((localObject3 instanceof RelativeLayout.LayoutParams)) && ((localObject2 instanceof RelativeLayout.LayoutParams)))
            {
              localObject3 = (RelativeLayout.LayoutParams)localObject3;
              int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject3).getRules();
              if ((arrayOfInt.length > 2) && (arrayOfInt[2] == 2131302567))
              {
                ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131300218);
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131302567);
                this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          if (this.Y)
          {
            localObject1 = new TranslateAnimation(0.0F, 0.0F, aciy.a(34.0F, (Resources)localObject1), 0.0F);
            ((TranslateAnimation)localObject1).setDuration(250L);
            ((TranslateAnimation)localObject1).setFillAfter(true);
            ((TranslateAnimation)localObject1).setAnimationListener(new aehq(this));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.startAnimation((Animation)localObject1);
          }
          localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300217);
          ((View)localObject1).setOnClickListener(new aehr(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject1);
          this.jdField_t_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305491);
          bI();
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("menuEventSharePre", 0);
          if (!((SharedPreferences)localObject1).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            localObject1 = ((SharedPreferences)localObject1).edit();
            ((SharedPreferences.Editor)localObject1).putInt(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
            ((SharedPreferences.Editor)localObject1).commit();
          }
          this.jdField_s_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new aehs(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new aeht(this));
          localObject1 = this.jdField_a_of_type_Ncw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          c((List)localObject1);
          this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_Ncw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            t(true);
          }
          this.au = true;
          if (this.jdField_a_of_type_Nfb == null) {
            this.jdField_a_of_type_Nfb = new nfb(this.jdField_a_of_type_AndroidContentContext);
          }
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
          if ((((Intent)localObject1).hasExtra("pub_account_type")) && ("type_ecshop_account".equals(((Intent)localObject1).getStringExtra("pub_account_type"))))
          {
            localObject1 = ((Intent)localObject1).getStringExtra("ecshop_distance_tip");
            localObject1 = this.jdField_a_of_type_Nfb.a((String)localObject1, this);
            this.jdField_a_of_type_Nfb.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (View)localObject1);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconPv", "Pv_shopnearbyicon", 0, 0, "", "", "", "");
          }
          if ((!H()) || (!apyq.a())) {
            break;
          }
          ax();
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initPublicAccountMenu new qqgame pubaccount return");
          return;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
      }
    }
  }
  
  public void bt()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      if ((this.e.getText() != null) && (this.e.getText().length() < 6)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void bu()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow");
    }
    Object localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((ajoy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (rtr.a(((AccountDetail)localObject).accountFlag) != -4)) {
        break label224;
      }
      if (this.jdField_c_of_type_MqqAppNewIntent != null) {
        this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
      }
      this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), ndt.class);
      this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
      localObject = new mobileqq_mp.FollowRequest();
      ((mobileqq_mp.FollowRequest)localObject).ext.set("4");
      ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
      localObject = new aeia(this);
      this.jdField_c_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
    }
    for (;;)
    {
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow exit");
      }
      return;
      label224:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akig);
      this.jdField_a_of_type_Akig = new akig(new aeib(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akig);
      akil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
  }
  
  public void bv()
  {
    ThreadManager.post(new PublicAccountChatPie.45(this), 8, null, true);
  }
  
  @TargetApi(11)
  protected void bw()
  {
    if (this.jdField_p_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130843942);
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!befo.e());
    this.jdField_p_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.jdField_f_of_type_Int == 2)
    {
      this.jdField_p_of_type_AndroidWidgetImageView.setEnabled(false);
      if (befo.e()) {
        this.jdField_p_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130848566);
        }
        for (;;)
        {
          this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131632724));
          return;
          this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130848967);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130848565);
      }
      for (;;)
      {
        this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131632723));
        return;
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130848968);
      }
    }
    this.jdField_p_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130848566);
      }
      for (;;)
      {
        this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131632724));
        label246:
        if (!befo.e()) {
          break;
        }
        this.jdField_p_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130848967);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130848565);
    }
    for (;;)
    {
      this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131632723));
      break label246;
      break;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130848968);
    }
  }
  
  public void bx()
  {
    this.jdField_v_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493878, null);
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_v_of_type_AndroidViewView.findViewById(2131309314));
    if (!this.aa) {
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_v_of_type_AndroidViewView.findViewById(2131309308));
    this.jdField_t_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_v_of_type_AndroidViewView.findViewById(2131309306));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_v_of_type_AndroidViewView.findViewById(2131309309));
  }
  
  void by()
  {
    bE();
    this.jdField_a_of_type_Bcpn = ((bcpn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_wpa_key");
    if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
    {
      this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_kfuin");
      this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_type");
      this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_key");
      this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_ext");
      this.jdField_n_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("rkey");
      this.an = true;
      this.ao = false;
      this.ap = false;
      this.aq = false;
      this.ar = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      this.jdField_a_of_type_Bcpn.a(str, this.jdField_j_of_type_JavaLangString);
      return;
    }
    this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_Bcpn.b(str);
    if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))
    {
      this.an = true;
      this.ao = true;
      this.jdField_k_of_type_JavaLangString = null;
      this.jdField_l_of_type_JavaLangString = null;
      this.jdField_m_of_type_JavaLangString = null;
      this.jdField_n_of_type_JavaLangString = null;
      this.ap = true;
      this.aq = false;
      this.ar = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      return;
    }
    this.an = false;
    this.ao = false;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_n_of_type_JavaLangString = null;
    this.ap = false;
    this.aq = false;
    this.ar = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  }
  
  protected void bz()
  {
    this.an = false;
    this.ao = false;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_n_of_type_JavaLangString = null;
    this.ap = false;
    this.aq = false;
    this.ar = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
    this.as = false;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    bw();
    if (paramInt2 == 8) {
      if (this.jdField_q_of_type_AndroidWidgetImageView != null)
      {
        if (!CustomMenuBar.a()) {
          break label295;
        }
        this.jdField_q_of_type_AndroidWidgetImageView.setImageResource(2130848615);
      }
    }
    for (;;)
    {
      if (!this.jdField_f_of_type_Boolean)
      {
        SpannableString localSpannableString;
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837913);
          localSpannableString = new SpannableString(ajjy.a(2131643011));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838183);
          localSpannableString = new SpannableString(ajjy.a(2131643007));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if ((QLog.isColorLevel()) && (this.jdField_r_of_type_AndroidWidgetImageView != null)) {
          QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_r_of_type_AndroidWidgetImageView.getVisibility());
        }
        if (paramInt2 != 2) {
          break;
        }
        this.jdField_c_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (acin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(false);
        }
      }
      return;
      label295:
      this.jdField_q_of_type_AndroidWidgetImageView.setImageResource(2130848537);
      continue;
      if (this.jdField_q_of_type_AndroidWidgetImageView != null) {
        if (CustomMenuBar.a()) {
          this.jdField_q_of_type_AndroidWidgetImageView.setImageResource(2130848614);
        } else {
          this.jdField_q_of_type_AndroidWidgetImageView.setImageResource(2130848536);
        }
      }
    }
    Object localObject = this.jdField_c_of_type_ComTencentWidgetPatchedButton;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject).setSelected(bool);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
        break;
      }
      this.jdField_c_of_type_ComTencentWidgetPatchedButton.setText(2131625184);
      return;
    }
    this.jdField_c_of_type_ComTencentWidgetPatchedButton.setSelected(false);
  }
  
  public void c(long paramLong)
  {
    try
    {
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_t_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramIntent);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new PublicAccountChatPie.31(this));
    bL();
    bE();
    bP();
  }
  
  public void c(View paramView)
  {
    super.c(paramView);
    paramView = aciy.a(paramView);
    ((acyu)this.jdField_a_of_type_Acxb.a(22)).a(paramView);
  }
  
  void c(List<mobileqq_mp.ButtonInfo> paramList)
  {
    if ((H()) && (apyq.a())) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqgame pubaccount return");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_Ncw.b(a()));
        }
        if ((paramList == null) || (paramList.isEmpty()))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
          }
          if (this.jdField_i_of_type_AndroidViewView != null) {
            this.jdField_i_of_type_AndroidViewView.setVisibility(0);
          }
          if (this.jdField_j_of_type_AndroidViewView != null) {
            this.jdField_j_of_type_AndroidViewView.setVisibility(0);
          }
          if (this.jdField_s_of_type_AndroidWidgetImageView == null) {
            break;
          }
          this.jdField_s_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        if (this.jdField_s_of_type_AndroidWidgetImageView != null) {
          this.jdField_s_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        int i3 = paramList.size();
        int i1 = 0;
        while ((i1 < i3) && (i1 <= 2))
        {
          Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i1);
          Object localObject1;
          String str;
          label235:
          label255:
          wpb localwpb;
          label298:
          label322:
          mobileqq_mp.ButtonInfo localButtonInfo;
          if (((mobileqq_mp.ButtonInfo)localObject2).key.has())
          {
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
              break label445;
            }
            str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
            if (!((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
              break label452;
            }
            i2 = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
            localwpb = new wpb((String)localObject1, str, null, i2);
            localwpb.a((mobileqq_mp.ButtonInfo)localObject2);
            if (!((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
              break label457;
            }
            localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
              break label482;
            }
            localObject2 = ((List)localObject1).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label482;
            }
            localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
            if (!localButtonInfo.key.has()) {
              break label463;
            }
            localObject1 = localButtonInfo.key.get();
            label365:
            if (!localButtonInfo.name.has()) {
              break label470;
            }
            str = localButtonInfo.name.get();
            label386:
            if (!localButtonInfo.id.has()) {
              break label477;
            }
          }
          label445:
          label452:
          label457:
          label463:
          label470:
          label477:
          for (int i2 = localButtonInfo.id.get();; i2 = 0)
          {
            localObject1 = new wpb((String)localObject1, str, null, i2);
            ((wpb)localObject1).a(localButtonInfo);
            localwpb.a((wpb)localObject1);
            break label322;
            localObject1 = "";
            break;
            str = "";
            break label235;
            i2 = 0;
            break label255;
            localObject1 = null;
            break label298;
            localObject1 = "";
            break label365;
            str = "";
            break label386;
          }
          label482:
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localwpb, a());
          i1 += 1;
        }
      }
    }
  }
  
  public void d(View paramView)
  {
    paramView.getLayoutParams().height = 0;
    paramView.requestLayout();
  }
  
  public void e(int paramInt)
  {
    int i1 = 0xFFFF0000 & paramInt;
    super.e(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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
          if ((this.jdField_k_of_type_Long == 9223372036854775807L) || (localChatMessage.uniseq == this.jdField_k_of_type_Long)) {
            i1 = 1;
          }
          i2 = i1;
          if (this.jdField_k_of_type_Long == 9223372036854775807L) {}
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
        if (((localChatMessage instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.b(localChatMessage)) || (StructLongMessageDownloadProcessor.d(localChatMessage))))
        {
          String str = localChatMessage.getExtInfoFromExtStr("longMsg_State");
          if ((str == null) || (!String.valueOf(3).equals(str))) {
            break label239;
          }
        }
        for (;;)
        {
          this.jdField_k_of_type_Long = localChatMessage.uniseq;
          i1 = i2;
          break;
          label239:
          localChatMessage.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
          StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localChatMessage);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "REFRESH_FLAG_RELOAD  to load long message");
      }
    }
    if (paramInt != 131072) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(20);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(37);
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131624770));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  public void e(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_Acka.a(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i1);
    }
    if (i1 < 0) {
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int i3 = i1 - i2;
    this.jdField_p_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + i3 + ",firstPos is:" + i2 + ",pos is:" + i1);
    }
    this.jdField_a_of_type_Acka.a(paramChatMessage);
  }
  
  public void f()
  {
    super.f();
    this.jdField_c_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131301272));
    this.jdField_c_of_type_ComTencentWidgetPatchedButton.setContentDescription(ajjy.a(2131643017));
    this.jdField_c_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_s_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131300219));
    if (this.jdField_s_of_type_AndroidWidgetImageView != null) {
      this.jdField_s_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131306402));
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_c_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_c_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131301273));
    localObject = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (CustomMenuBar.a()) {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-1);
    }
    for (;;)
    {
      this.jdField_r_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131297309));
      this.jdField_r_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_q_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131306086));
      this.jdField_q_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_p_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131299981));
      this.jdField_p_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130846792);
        this.jdField_q_of_type_AndroidWidgetImageView.setImageResource(2130837718);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        int i1 = aciy.a(3.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        if (CustomMenuBar.a())
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130848686);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101397));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, i1, 0, i1);
      }
      return;
      G(80);
    }
  }
  
  public void f(String paramString)
  {
    boolean bool = true;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Nfb != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
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
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new PublicAccountChatPie.57(this, bool, str, (String)localObject, i1, i2, i3));
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.Z)
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
        {
          if (this.jdField_v_of_type_AndroidViewView == null) {
            bx();
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_v_of_type_AndroidViewView);
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
      return;
    }
    super.g(paramBoolean);
  }
  
  public boolean g()
  {
    PublicAccountInfo localPublicAccountInfo = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return (localPublicAccountInfo == null) || ((localPublicAccountInfo.accountFlag & 0x10000000) == 0);
  }
  
  public boolean h()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.jdField_a_of_type_Aeob.a(1000, new Object[0]);
      continue;
      if (this.jdField_t_of_type_AndroidViewView != null)
      {
        this.jdField_t_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
        continue;
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        if ((this.jdField_t_of_type_AndroidViewView != null) && (this.jdField_t_of_type_AndroidViewView.getVisibility() == 0))
        {
          this.jdField_t_of_type_AndroidViewView.setVisibility(8);
          continue;
          a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
          }
          Object localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
          if (localObject != null)
          {
            localObject = ((ajoy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              this.e.setText(((AccountDetail)localObject).name);
              if (this.U)
              {
                c((AccountDetail)localObject);
                this.U = false;
              }
              if (this.jdField_g_of_type_AndroidAppDialog == null) {}
              bt();
            }
          }
          if (this.T)
          {
            this.T = false;
            if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
              this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
            }
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            bn();
            continue;
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
          }
        }
      }
    }
  }
  
  public int j()
  {
    int i1 = 0;
    View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((this.jdField_w_of_type_AndroidViewView != null) && (localView != this.jdField_w_of_type_AndroidViewView))
    {
      this.A = 0;
      this.jdField_w_of_type_AndroidViewView = localView;
      return 0;
    }
    if (localView != null) {
      i1 = -localView.getTop();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ScrollY: " + String.valueOf(i1) + "  OldScrollY: " + String.valueOf(this.A));
    }
    this.jdField_w_of_type_AndroidViewView = localView;
    return i1;
  }
  
  public void j()
  {
    aens localaens = new aens(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aeob, this, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Aeob.a(localaens);
  }
  
  public void l()
  {
    if (!this.Z) {
      super.l();
    }
  }
  
  @TargetApi(11)
  public void o(int paramInt)
  {
    super.o(paramInt);
    ImageSpan localImageSpan;
    SpannableString localSpannableString;
    if (paramInt != this.jdField_f_of_type_Int)
    {
      if (paramInt != 1) {
        break label87;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837913);
        localSpannableString = new SpannableString(ajjy.a(2131643023));
        localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_c_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
    label332:
    for (;;)
    {
      bw();
      return;
      label87:
      if (paramInt == 2)
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838183);
          localSpannableString = new SpannableString(ajjy.a(2131642952));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        this.jdField_c_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        if (befo.e())
        {
          if (this.jdField_q_of_type_AndroidWidgetImageView != null) {
            this.jdField_q_of_type_AndroidWidgetImageView.setAlpha(0.6F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
          this.jdField_c_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
        }
      }
      else
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838183);
          localSpannableString = new SpannableString(ajjy.a(2131642998));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {
          this.jdField_c_of_type_ComTencentWidgetPatchedButton.setText(2131625184);
        }
        for (;;)
        {
          if (!befo.e()) {
            break label332;
          }
          if (this.jdField_q_of_type_AndroidWidgetImageView != null) {
            this.jdField_q_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
          this.jdField_c_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
          break;
          this.jdField_c_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131300219) {
      t(true);
    }
    if (2131302816 == paramView.getId())
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
      badx.a(null, "pubAcc_profile_display", "");
    }
    if (paramView.getId() == 2131301272)
    {
      long l1 = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_r_of_type_AndroidWidgetImageView != null)) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, " onClick fun_btn start mInputStat = " + this.jdField_f_of_type_Int + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_r_of_type_AndroidWidgetImageView.getVisibility() + " currentPanel:" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() + " currenttime:" + System.currentTimeMillis());
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) && (this.jdField_r_of_type_AndroidWidgetImageView != null) && (this.jdField_r_of_type_AndroidWidgetImageView.getVisibility() != 0))
      {
        c();
        if (adkp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) && (((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          ahyd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6);
        }
      }
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, " onClick fun_btn end mInputStat = " + this.jdField_f_of_type_Int + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
        }
        ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800584F", "0X800584F", 0, 0, "", "", "", "", false);
      }
    }
    if ((paramView.getId() == 2131299981) && (this.jdField_f_of_type_Int != 1))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3) {
        break label892;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      if (this.jdField_q_of_type_AndroidWidgetImageView != null) {
        this.jdField_q_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131624420));
      }
    }
    if (paramView.getId() == 2131306086)
    {
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8)
      {
        if (this.jdField_q_of_type_AndroidWidgetImageView != null) {
          this.jdField_q_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131624420));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("fastimage", 2, "BaseCHatPie onClick keybordicon removeFastImage");
          }
          b(true);
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      }
    }
    else
    {
      label642:
      if (paramView.getId() == 2131297309)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) {
          break label1025;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        if (this.jdField_r_of_type_AndroidWidgetImageView != null)
        {
          this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(this.jdField_u_of_type_Int);
          this.jdField_r_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131624437));
        }
      }
      label709:
      if (paramView.getId() == 2131304841) {
        al();
      }
      if (this.aA) {}
      switch (paramView.getId())
      {
      default: 
        label776:
        if ((this.Z) && (paramView.getId() == 2131301272)) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C9C", "0X8005C9C", 0, 1, 0, "", "", "", "");
        }
        if (((paramView.getTag() instanceof String)) && (nfb.jdField_a_of_type_JavaLangString.equals((String)paramView.getTag())) && (this.jdField_a_of_type_AndroidContentContext != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          if (System.currentTimeMillis() - this.jdField_j_of_type_Long >= 1000L) {
            break;
          }
        }
        break;
      }
    }
    label892:
    Object localObject1;
    label1025:
    Object localObject2;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      if ((this.jdField_r_of_type_AndroidWidgetImageView != null) && (this.jdField_r_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        u(false);
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      ah();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
      if ((this.jdField_r_of_type_AndroidWidgetImageView != null) && (this.jdField_r_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        u(false);
      }
      if (this.jdField_q_of_type_AndroidWidgetImageView != null) {
        this.jdField_q_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131624338));
      }
      o(0);
      break label642;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      if (this.jdField_r_of_type_AndroidWidgetImageView == null) {
        break label709;
      }
      this.jdField_r_of_type_AndroidWidgetImageView.setImageResource(this.jdField_v_of_type_Int);
      this.jdField_r_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131624436));
      break label709;
      awqx.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "clk_return", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "");
      break label776;
      this.jdField_j_of_type_Long = System.currentTimeMillis();
      localObject1 = new StringBuilder("https://gouwu.qq.com/m/html/shop_map.html?_wv=1027&shop_uin=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", ((StringBuilder)localObject1).toString());
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconClk", "Clk_shopnearbyicon", 0, 0, "", "", "", "");
      if (paramView.getId() != 2131302811) {
        break label1409;
      }
      localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (!rol.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label1409;
      }
      localObject2 = (String)nfp.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("uin", (String)localObject2);
    localIntent = aciy.a(localIntent, null);
    if (((ajjj)localObject1).b((String)localObject2)) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Shop_customservice", "Clk_shopcustomservice", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      label1409:
      super.onClick(paramView);
      return;
      localIntent.putExtra("uintype", 1005);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + ajjy.a(2131642993));
      localIntent.putExtra("key_sub_title_from", "来自\"QQ咨询\"");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    ((acyu)this.jdField_a_of_type_Acxb.a(22)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    b(paramAbsListView);
    if ((this.an) || (this.as)) {}
    label273:
    label275:
    int i1;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((this.jdField_o_of_type_AndroidViewView != null) && (this.jdField_u_of_type_AndroidViewView != null) && (this.jdField_t_of_type_Int != 5))
          {
            if (this.C > paramInt3)
            {
              this.jdField_t_of_type_Int = 4;
              this.C = paramInt3;
              switch (this.jdField_t_of_type_Int)
              {
              }
            }
            for (;;)
            {
              if ((!this.at) && (!this.X)) {
                break label273;
              }
              if ((!this.ag) || (this.X)) {
                break label275;
              }
              this.ag = false;
              return;
              if (this.C >= paramInt3) {
                break;
              }
              this.jdField_t_of_type_Int = 3;
              break;
              if ((paramInt3 > paramInt2) && (!this.at))
              {
                this.B = this.jdField_u_of_type_AndroidViewView.getLayoutParams().height;
                d(this.jdField_u_of_type_AndroidViewView);
                this.at = true;
              }
              this.jdField_t_of_type_Int = 2;
              this.ag = true;
              continue;
              if ((paramInt3 == paramInt2) && (this.at))
              {
                if (this.B != 0) {
                  a(this.jdField_u_of_type_AndroidViewView, this.B);
                }
                this.at = false;
                this.X = true;
              }
              this.jdField_t_of_type_Int = 2;
              this.ag = true;
            }
          }
        }
        if (this.jdField_o_of_type_AndroidViewView.getHeight() != 0) {
          this.B = this.jdField_o_of_type_AndroidViewView.getHeight();
        }
        i1 = this.A - j();
        this.A = j();
        if (this.H * i1 < 0)
        {
          this.H = i1;
          return;
        }
        this.H = i1;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Move = " + String.valueOf(i1));
        }
        switch (this.jdField_s_of_type_Int)
        {
        default: 
          return;
        }
      } while (((i1 <= 5) || (!this.af)) && ((paramInt1 != this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()) || (i1 <= 0) || (!this.af) || (this.W)));
      this.W = true;
      paramAbsListView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.B);
      paramAbsListView.setFillAfter(true);
      paramAbsListView.setDuration(250L);
      paramAbsListView.setAnimationListener(new aehe(this));
      this.jdField_o_of_type_AndroidViewView.startAnimation(paramAbsListView);
      return;
    } while (((i1 >= -5) || (!this.af)) && (((!this.X) && ((paramInt1 + paramInt2 != paramInt3) || (i1 >= 0) || (!this.af))) || (this.W)));
    this.W = true;
    paramAbsListView = new TranslateAnimation(0.0F, 0.0F, -this.B, 0.0F);
    paramAbsListView.setFillAfter(true);
    paramAbsListView.setDuration(250L);
    paramAbsListView.setAnimationListener(new aehf(this));
    this.jdField_o_of_type_AndroidViewView.startAnimation(paramAbsListView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(37);
      msl.a().a(500L);
    }
    ((acyu)this.jdField_a_of_type_Acxb.a(22)).a(paramAbsListView, paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.af = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void s()
  {
    super.s();
    bt();
  }
  
  public void t(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(4);
      }
      if (this.jdField_i_of_type_AndroidViewView != null) {
        this.jdField_i_of_type_AndroidViewView.setVisibility(4);
      }
      if (this.jdField_j_of_type_AndroidViewView != null) {
        this.jdField_j_of_type_AndroidViewView.setVisibility(4);
      }
      az();
    }
  }
  
  protected void u(boolean paramBoolean)
  {
    int i2 = 8;
    if (this.jdField_r_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_r_of_type_AndroidWidgetImageView.clearAnimation();
    Object localObject = this.jdField_r_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      i1 = 0;
      label30:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      i1 = i2;
      if (!paramBoolean) {
        i1 = 0;
      }
      ((XEditTextEx)localObject).setVisibility(i1);
      if (this.jdField_g_of_type_Boolean)
      {
        localObject = this.jdField_c_of_type_ComTencentWidgetPatchedButton;
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
        localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130837913);
        SpannableString localSpannableString = new SpannableString(ajjy.a(2131642984));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_c_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
      return;
      i1 = 8;
      break label30;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageRecord))
    {
      localObject = ((MessageRecord)paramObject).getExtInfoFromExtStr("welcome_msg");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("true"))) {
        ThreadManager.post(new PublicAccountChatPie.43(this), 8, null, false);
      }
      this.ai = true;
    }
    if ((bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((paramObject instanceof MessageRecord))) {
      ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.update(paramObservable, paramObject);
    int i1;
    if ((paramObservable instanceof aynx)) {
      if ((paramObject instanceof Integer))
      {
        i1 = ((Integer)paramObject).intValue();
        if (i1 != 0) {
          break label153;
        }
        this.jdField_a_of_type_Aynx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Aynx.b();
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
      bF();
      for (;;)
      {
        return;
        if (i1 != 1) {
          break label148;
        }
        this.ay = true;
        break label148;
        if ((paramObservable instanceof QQMessageFacade))
        {
          if (this.jdField_a_of_type_Aynx == null) {
            break;
          }
          paramObject = (TroopManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(52);
          paramObservable = ((QQMessageFacade)paramObservable).a();
          if (paramObservable == null) {
            break;
          }
          paramObservable = paramObject.c(paramObservable.frienduin);
          if (paramObservable == null) {
            break;
          }
          try
          {
            if (paramObservable.associatePubAccount == Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue())
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
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "exception: sessionInfo curFriendUin is not a long type.");
            return;
          }
        }
      }
    } while (!this.Z);
    ThreadManager.post(new PublicAccountChatPie.44(this), 5, null, false);
  }
  
  public void x()
  {
    if (this.aA)
    {
      "https://h5.qzone.qq.com/subscription/homepage/{userId}?_proxy=1&_wv=16777217&_wwv=4".replace("{userId}", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      vvy.a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      awqx.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "clk_head", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.an) {
      localIntent.putExtra("qidian_chat", true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      localIntent.putExtra("public_account_msg_id", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
    }
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    rtr.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 1, rtr.jdField_a_of_type_Boolean);
  }
  
  public boolean y()
  {
    if ((!this.aj) && (this.Z))
    {
      this.aj = true;
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_Acka.getCount() - 1);
    }
    while ((this.ak) || (!this.Z)) {
      return true;
    }
    this.ak = true;
    return false;
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ("2277373213".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130846234);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130848841, 2130848842);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131631008));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegy
 * JD-Core Version:    0.7.0.1
 */