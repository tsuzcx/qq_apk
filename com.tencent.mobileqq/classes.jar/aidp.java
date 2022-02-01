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
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.12;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.17;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.27;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.28;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.33;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.34;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.35;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.46;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.47;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.48;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.52;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.56;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.61;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.62;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.8;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.9;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.PublicMenuBar;
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
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class aidp
  extends BaseChatPie
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G = -1;
  private int H;
  private int I;
  private int J;
  boolean S = false;
  public boolean T = false;
  public boolean U;
  boolean V = false;
  boolean W = false;
  boolean X = false;
  public boolean Y;
  public boolean Z;
  private aifk jdField_a_of_type_Aifk;
  public Handler a;
  protected SpannableString a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private anmu jdField_a_of_type_Anmu;
  protected anqd a;
  public anry a;
  private aoqn jdField_a_of_type_Aoqn;
  public aval a;
  public bers a;
  public bjft a;
  public bjha a;
  bkho jdField_a_of_type_Bkho;
  private bkqc jdField_a_of_type_Bkqc = new aifd(this);
  public CustomMenuBar a;
  public PublicAccountHandler a;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  public PublicAccountInfo a;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  PublicMenuBar jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = null;
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new aiea(this);
  public nzz a;
  public ocm a;
  odf jdField_a_of_type_Odf = new aiez(this);
  private oei jdField_a_of_type_Oei;
  public int[] a;
  private boolean aA;
  private boolean aB;
  private boolean aC;
  public boolean aa;
  boolean ab = false;
  boolean ac = false;
  boolean ad = false;
  boolean ae = false;
  boolean af = false;
  boolean ag = false;
  public boolean ah;
  boolean ai = false;
  boolean aj = false;
  public boolean ak;
  public boolean al;
  boolean am = false;
  public boolean an = false;
  boolean ao = false;
  boolean ap = false;
  boolean aq = false;
  public boolean ar;
  private boolean as;
  private boolean at;
  private boolean au;
  private boolean av;
  private boolean aw;
  private boolean ax;
  private boolean ay;
  private boolean az;
  protected SpannableString b;
  public View.OnClickListener b;
  protected LinearLayout b;
  private aoqn jdField_b_of_type_Aoqn;
  private PublicMenuBar jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  protected PatchedButton b;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_b_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  Dialog jdField_c_of_type_AndroidAppDialog;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private bgpa jdField_c_of_type_Bgpa;
  List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_c_of_type_MqqAppNewIntent;
  private Dialog jdField_d_of_type_AndroidAppDialog;
  biau jdField_d_of_type_Biau;
  long e;
  long f;
  long g;
  public String g;
  long h;
  public String h;
  private long i;
  public String i;
  private long j;
  public String j;
  private long k;
  public String k;
  private long jdField_l_of_type_Long;
  protected ImageView l;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  public String l;
  private long jdField_m_of_type_Long;
  protected ImageView m;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  public String m;
  public View n;
  public ImageView n;
  public String n;
  public View o;
  private ImageView jdField_o_of_type_AndroidWidgetImageView;
  private String jdField_o_of_type_JavaLangString = "";
  View jdField_p_of_type_AndroidViewView;
  private ImageView jdField_p_of_type_AndroidWidgetImageView;
  public int q;
  View q;
  public int r;
  View r;
  int jdField_s_of_type_Int = 0;
  private View jdField_s_of_type_AndroidViewView;
  int jdField_t_of_type_Int = 3;
  private View jdField_t_of_type_AndroidViewView;
  protected int u;
  private View u;
  protected int v;
  private View v;
  public int w;
  public int x;
  public int y;
  public int z;
  
  public aidp(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_n_of_type_AndroidViewView = null;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_r_of_type_Int = -1;
    this.jdField_e_of_type_Long = -1L;
    this.jdField_f_of_type_Long = -1L;
    this.jdField_g_of_type_Long = -1L;
    this.jdField_u_of_type_Int = 2130837962;
    this.jdField_v_of_type_Int = 2130837961;
    this.jdField_i_of_type_Long = 9223372036854775807L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_F_of_type_Int = -1;
    this.jdField_a_of_type_Aval = new aval("web_public_account", "com.tencent.mobileqq:tool");
    this.jdField_a_of_type_AndroidOsHandler = new aidq(this);
    this.jdField_a_of_type_Anqd = new aids(this);
    this.jdField_a_of_type_Anry = new aiey(this);
    this.jdField_a_of_type_Bjha = new aife(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aifh(this);
  }
  
  private void E(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new PublicAccountChatPie.27(this, paramInt), 500L);
  }
  
  private void F(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams.gravity != paramInt)
      {
        localLayoutParams.gravity = paramInt;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    } while (localLayoutParams.gravity == paramInt);
    localLayoutParams.gravity = paramInt;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  private boolean I()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ("2747277822".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private boolean J()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private boolean K()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ("1816533856".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.addUpdateListener(new aidt(this, paramView, paramInt1, paramInt2));
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
      localLinearLayout.setOnClickListener(new aiew(this, paramRelativeLayout, localLinearLayout));
      Object localObject = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((ImageView)localObject).setImageResource(2130841622);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      Resources localResources = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      localLayoutParams.width = afur.a(73.0F, localResources);
      localLayoutParams.height = afur.a(73.0F, localResources);
      localLayoutParams.topMargin = afur.a(100.0F, localResources);
      localLayoutParams.gravity = 17;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((TextView)localObject).setText(anni.a(2131707568));
      ((TextView)localObject).setTextSize(2, 18.0F);
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = afur.a(28.0F, localResources);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      paramRelativeLayout.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
      localSharedPreferences.edit().putBoolean("firstIntoAIO", false).commit();
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountChatPie.28(this, paramAccountDetail), 10L);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    try
    {
      paramMessageForArkApp = paramMessageForArkApp.ark_app_message;
      if (paramMessageForArkApp != null)
      {
        paramMessageForArkApp = paramMessageForArkApp.metaList;
        if (!bgsp.a(paramMessageForArkApp))
        {
          JSONObject localJSONObject = new JSONObject(paramMessageForArkApp).optJSONObject("gdt");
          paramMessageForArkApp = new qq_ad_get.QQAdGetRsp.AdInfo();
          paramMessageForArkApp.report_info.trace_info.aid.set(Long.parseLong(localJSONObject.optString("aid")));
          localJSONObject = localJSONObject.optJSONObject("thirdparty_monitor_urls");
          if (localJSONObject != null)
          {
            paramMessageForArkApp.report_info.thirdparty_monitor_urls.api_click_monitor_url.set(odu.a(localJSONObject.optJSONArray("api_click_monitor_url")));
            paramMessageForArkApp.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(odu.a(localJSONObject.optJSONArray("api_exposure_monitor_url")));
            paramMessageForArkApp.report_info.thirdparty_monitor_urls.sdk_click_monitor_url.set(odu.a(localJSONObject.optJSONArray("sdk_click_monitor_url")));
            paramMessageForArkApp.report_info.thirdparty_monitor_urls.sdk_exposure_monitor_url.set(odu.a(localJSONObject.optJSONArray("sdk_exposure_monitor_url")));
            acre.a(1, 2, paramMessageForArkApp);
          }
        }
      }
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
        for (;;)
        {
          if (paramMessageForStructing.hasNext())
          {
            Object localObject = (bcvs)paramMessageForStructing.next();
            if ((localObject instanceof bczn))
            {
              localObject = ((bczn)localObject).a;
              if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
                continue;
              }
              localObject = ((ArrayList)localObject).iterator();
              if (!((Iterator)localObject).hasNext()) {
                continue;
              }
              bcvs localbcvs = (bcvs)((Iterator)localObject).next();
              if (!(localbcvs instanceof bdaz)) {
                break;
              }
              try
              {
                acre.a(1, 2, oda.a(localbcvs));
              }
              catch (Throwable localThrowable)
              {
                QLog.e(this.jdField_a_of_type_JavaLangString, 1, localThrowable, new Object[0]);
              }
              continue;
            }
            if ((localThrowable instanceof bczp)) {
              paramMessageForStructing = (bczp)localThrowable;
            }
          }
        }
      }
    }
    try
    {
      acre.a(1, 2, oda.a(paramMessageForStructing));
      return;
    }
    catch (Throwable paramMessageForStructing)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, paramMessageForStructing, new Object[0]);
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
        ThreadManager.post(new PublicAccountChatPie.35(this, paramString, paramInt, l1, l2), 5, null, true);
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
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Report message at index: " + String.valueOf(paramInt) + ". MessageId is " + l1);
              }
            }
            paramChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
            str1 = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
            paramList1 = str1;
            if (str1 == null) {
              paramList1 = "";
            }
            oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80057C4", "0X80057C4", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(l1), paramList1, "", false);
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
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, " parse ad_id error");
        paramList1 = str1;
        break label355;
      }
      paramList2.add(str2);
      this.jdField_c_of_type_JavaUtilList.add(paramList1);
      paramList3.add(str3);
      paramList4.add(str4);
    } while (paramList.contains(paramChatMessage));
    paramList.add(paramChatMessage);
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (anrs)paramQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((anrs)localObject).b(paramString);; localObject = null)
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
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
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
        this.aC = false;
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
        this.aC = true;
      }
    }
  }
  
  private void b(AbsListView paramAbsListView)
  {
    if (J())
    {
      int i2 = paramAbsListView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = paramAbsListView.getChildAt(i1);
        if (localView != null) {
          acrh.a().a(localView);
        }
        i1 += 1;
      }
    }
  }
  
  private void bH()
  {
    if (this.ac) {}
    odu localodu;
    do
    {
      return;
      this.ac = true;
      localodu = (odu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()) || (localodu == null));
    Object localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
    Object localObject2 = ((ChatMessage)localObject1).getExtInfoFromExtStr("public_account_msg_id");
    String str = ((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg");
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "enter qqgouwu aio msgId = " + (String)localObject2 + " hasAdver: " + str);
    }
    if ("1".equals(str))
    {
      localObject2 = new odk();
      ((odk)localObject2).jdField_a_of_type_Int = 2;
      localObject2 = odh.a((odk)localObject2, (MessageRecord)localObject1);
      ((odh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(139)).a((odk)localObject2, null);
      if ((localObject1 instanceof MessageForStructing)) {
        a((MessageForStructing)localObject1);
      }
    }
    for (;;)
    {
      int i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("jump_from", 4);
      if (i1 != 2) {
        break;
      }
      localodu.a(134243865, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, null, null, i1, false);
      return;
      if ((localObject1 instanceof MessageForArkApp))
      {
        a((MessageForArkApp)localObject1);
        continue;
        if ((localObject1 instanceof MessageForArkApp)) {
          localodu.a(134243863, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
        } else {
          localodu.a(134243857, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
        }
      }
    }
  }
  
  private void bI()
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    }
    ay();
    aA();
  }
  
  private void bJ()
  {
    ThreadManager.postImmediately(new PublicAccountChatPie.8(this), null, true);
  }
  
  private void bK()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null) {
      I();
    }
  }
  
  private void bL()
  {
    this.jdField_n_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2131558630, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    if (this.jdField_n_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_n_of_type_AndroidViewView.setClickable(true);
    this.jdField_n_of_type_AndroidViewView.findViewById(2131368138).setOnClickListener(new aidy(this));
    if (this.jdField_q_of_type_Int == 2)
    {
      this.jdField_n_of_type_AndroidViewView.findViewById(2131373023).setVisibility(8);
      this.jdField_n_of_type_AndroidViewView.findViewById(2131373009).setVisibility(8);
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_n_of_type_AndroidViewView, localLayoutParams);
      return;
      if (this.am)
      {
        this.jdField_n_of_type_AndroidViewView.findViewById(2131373023).setVisibility(8);
        this.jdField_n_of_type_AndroidViewView.findViewById(2131373009).setVisibility(8);
      }
    }
  }
  
  private void bM()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = ((PublicMenuBar)this.jdField_n_of_type_AndroidViewView.findViewById(2131373006));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setOnMenuItemClickListener(new aidz(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.b();
    Object localObject;
    int i1;
    aaum localaaum1;
    if (!this.am)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      if (this.az)
      {
        i1 = 2131691642;
        localObject = new aaum("DO_NOT_FOLLOW", ((FragmentActivity)localObject).getString(i1), a().getResources().getDrawable(2130841716), 0);
        localaaum1 = new aaum("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691640), a().getResources().getDrawable(2130841615), 1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((aaum)localObject, 2131559981);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localaaum1, 2131559981);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setSwitchButtonVisibility(false);
      if (!this.aB) {
        break label338;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(8);
      return;
      i1 = 2131691641;
      break;
      localObject = new aaum("DO_CANCEL", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690584), a().getResources().getDrawable(2130841716), 0);
      localaaum1 = new aaum("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691640), a().getResources().getDrawable(2130841615), 1);
      aaum localaaum2 = new aaum("DO_NOT_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691642), a().getResources().getDrawable(2130841716), 0);
      this.jdField_q_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((aaum)localObject, 2131559981);
      this.jdField_p_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localaaum2, 2131559981);
      this.jdField_r_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localaaum1, 2131559981);
    }
    label338:
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(0);
  }
  
  private void bN()
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
      new bfpp("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new aief(this), 1000, null).a(localHashMap);
      bq();
      return;
    }
  }
  
  private void bO()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("public_aio_setting", 0);
    String str = "firstOpen_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (localSharedPreferences.getBoolean(str, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = ((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_a_of_type_Nzz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.33(this, localSharedPreferences, str));
  }
  
  private void bP()
  {
    if (this.jdField_k_of_type_Long == 0L) {}
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
    localHashMap.put("menu_click", "" + this.w);
    localHashMap.put("menu_to_webview", "" + this.jdField_y_of_type_Int);
    localHashMap.put("article_click", "" + this.x);
    localHashMap.put("article_to_webview", "" + this.z);
    localHashMap.put("net_type", "" + bdwu.a().a());
    localHashMap.put("unread_count", "" + this.E);
    long l1 = System.currentTimeMillis() - this.jdField_k_of_type_Long;
    if ((this.z != 0) || (this.jdField_y_of_type_Int != 0)) {}
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
      bctj.a(BaseApplication.getContext()).a(null, "actPublicAccountWebviewPreload", bool, l1, 0L, localHashMap, "");
      this.jdField_k_of_type_Long = 0L;
      this.E = 0;
      this.jdField_y_of_type_Int = 0;
      this.w = 0;
      this.x = 0;
      this.z = 0;
      return;
    }
  }
  
  private void bQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((anrs)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      return;
    }
    Object localObject = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), oaz.class);
    ((NewIntent)localObject).putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.4.1,3,4680");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      label163:
      ((NewIntent)localObject).putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new aiem(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  private void bR()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      anrs localanrs = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localanrs != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localanrs.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      bS();
    }
  }
  
  private void bS()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.requestPermissions(new aieu(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      bT();
      return;
    }
    bT();
  }
  
  private void bT()
  {
    SosoInterface.a(new aiev(this, 1, true, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void bU()
  {
    a((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getParent());
  }
  
  private void bV()
  {
    Object localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((anrs)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (tzo.a(((PublicAccountInfo)localObject).accountFlag2) == -10L))
      {
        this.aB = true;
        localObject = aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 115, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  private void bW()
  {
    if (this.jdField_m_of_type_Long == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_m_of_type_Long;
    PublicAccountInfo localPublicAccountInfo = ((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localPublicAccountInfo != null) {
      alcv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPublicAccountInfo.uin + "", l1 - l2, localPublicAccountInfo.name + "");
    }
    this.jdField_m_of_type_Long = 0L;
  }
  
  private void c(AccountDetail paramAccountDetail)
  {
    if (this.jdField_n_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject1 = (TextView)this.jdField_n_of_type_AndroidViewView.findViewById(2131380196);
    Object localObject2 = (TextView)this.jdField_n_of_type_AndroidViewView.findViewById(2131380195);
    ImageView localImageView = (ImageView)this.jdField_n_of_type_AndroidViewView.findViewById(2131368138);
    if (this.az) {
      if ((this.jdField_a_of_type_Bers != null) && (this.jdField_a_of_type_Bers.b > 0) && (this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList.get(0);
        ((TextView)localObject1).setText(localTroopInfo.troopname);
        ((TextView)localObject2).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131694597), new Object[] { paramAccountDetail.name }));
        localImageView.setImageDrawable(aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localTroopInfo.troopuin));
        localObject1 = "";
        if (this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = ((TroopInfo)this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          break label318;
        }
        localObject2 = "";
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "exp_temp", 0, 0, (String)localObject1, "" + (String)localObject2, "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Anmu == null)
      {
        this.jdField_a_of_type_Anmu = new aieq(this, localImageView);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.addObserver(this.jdField_a_of_type_Anmu);
      }
      localObject1 = (ImageView)this.jdField_n_of_type_AndroidViewView.findViewById(2131364290);
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
      localImageView.setImageDrawable(aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().jdField_a_of_type_JavaLangString, (byte)3));
    }
    label375:
    ((ImageView)localObject1).setVisibility(0);
  }
  
  private void e(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1)) {
      F(80);
    }
    while (!CustomMenuBar.a()) {
      return;
    }
    F(16);
  }
  
  private void h(Intent paramIntent)
  {
    try
    {
      this.as = paramIntent.getBooleanExtra("jump_minusonescreen_view", false);
      this.at = paramIntent.getBooleanExtra("req_qgg_hide_tab", false);
      if (this.as)
      {
        this.jdField_a_of_type_Oei = new oef();
        if (this.jdField_a_of_type_Oei.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout)) {
          bI();
        }
      }
      else
      {
        this.jdField_a_of_type_Oei = new oeh();
        if ((!this.at) && (this.jdField_a_of_type_Oei.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout)))
        {
          bI();
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new PublicAccountChatPie.7(this));
        }
        paramIntent = (odh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(139);
        if (paramIntent != null)
        {
          paramIntent.a(null, null, false, null, 11);
          return;
        }
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, QLog.getStackTraceString(paramIntent));
    }
  }
  
  private void h(String paramString)
  {
    afur.n = true;
    this.jdField_d_of_type_Biau = new biau(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    long l1 = NetConnInfoCenter.getServerTime();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    String str1;
    if ("DO_FOLLOW".equals(paramString)) {
      if (this.az)
      {
        bN();
        str1 = "";
        paramString = str1;
        if (this.jdField_a_of_type_Bers != null)
        {
          paramString = str1;
          if (this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList != null)
          {
            paramString = str1;
            if (this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList.size() > 0) {
              paramString = ((TroopInfo)this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
            }
          }
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_close_temp", 0, 0, paramString, "" + str2, "", "");
        this.jdField_a_of_type_Nzz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new aieb(this));
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
        oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF5", "0X8004EF5", 0, 0, Long.toString(l1), "", "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, this.jdField_o_of_type_JavaLangString, false);
      }
      z(2131694663);
      bw();
      return;
      if ("DO_NOT_FOLLOW".equals(paramString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
          oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF7", "0X8004EF7", 0, 0, Long.toString(l1), "", "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "" + this.jdField_o_of_type_JavaLangString, false);
        }
        if (this.az)
        {
          i(str2);
          str1 = "";
          paramString = str1;
          if (this.jdField_a_of_type_Bers != null)
          {
            paramString = str1;
            if (this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList != null)
            {
              paramString = str1;
              if (this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList.size() > 0) {
                paramString = ((TroopInfo)this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
              }
            }
          }
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_focus_temp", 0, 0, paramString, "" + str2, "", "");
          return;
        }
        bt();
        return;
      }
    } while (!"DO_CANCEL".equals(paramString));
    z(2131694663);
    this.jdField_b_of_type_MqqAppNewIntent = nzz.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, false, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aiec(this));
  }
  
  private void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow");
    }
    E(2131694661);
    Object localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((anrs)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (tzo.a(((AccountDetail)localObject).accountFlag) != -4)) {
        break label191;
      }
      localObject = new NewIntent(BaseApplicationImpl.getContext(), oaz.class);
      ((NewIntent)localObject).putExtra("cmd", "unfollow");
      mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
      localUnFollowRequest.uin.set((int)Long.parseLong(paramString));
      ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
      this.jdField_b_of_type_MqqObserverBusinessObserver = new aieg(this, paramString);
      ((NewIntent)localObject).setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
    }
    for (;;)
    {
      this.I += 1;
      tzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow exit");
      }
      return;
      label191:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Aoqn);
      this.jdField_b_of_type_Aoqn = new aoqn(new aieh(this, paramString));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Aoqn);
      aoqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
  }
  
  public void A(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  public void B(int paramInt)
  {
    try
    {
      this.jdField_m_of_type_AndroidWidgetTextView.setText(paramInt);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void C(int paramInt)
  {
    try
    {
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
        return;
        this.jdField_m_of_type_AndroidWidgetTextView.setText(2131718233);
        continue;
        this.jdField_m_of_type_AndroidWidgetTextView.setText(2131718227);
        continue;
        this.jdField_m_of_type_AndroidWidgetTextView.setText(2131694619);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void D(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidAppDialog == null)
    {
      this.jdField_d_of_type_AndroidAppDialog = new ReportDialog(a(), 2131755823);
      this.jdField_d_of_type_AndroidAppDialog.setContentView(2131560926);
    }
    TextView localTextView1 = (TextView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131378776);
    TextView localTextView2 = (TextView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131361937);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidAppDialog.setOnCancelListener(new aiff(this));
      this.jdField_d_of_type_AndroidAppDialog.show();
      return;
      localTextView1.setText(2131697485);
      localTextView2.setText(2131697491);
      continue;
      localTextView1.setText(2131697486);
      localTextView2.setText(2131697487);
      continue;
      localTextView1.setText(2131697489);
      localTextView2.setText(2131697487);
    }
  }
  
  public boolean E()
  {
    Object localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((anrs)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject == null) && (tzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null))
      {
        tzo.a();
        tzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return true;
      }
      return false;
    }
  }
  
  public boolean F()
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
            this.jdField_q_of_type_Int = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean G()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 8);
  }
  
  public void H()
  {
    pmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_j_of_type_Long, this.ab, this.jdField_a_of_type_Afwy.a());
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(null);
    }
    if (this.M) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
    }
    for (;;)
    {
      return;
      tzo.a();
      if (this.jdField_a_of_type_Aifk != null) {}
      try
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Aifk);
        label89:
        this.jdField_a_of_type_Aifk = null;
        if (this.jdField_b_of_type_MqqAppNewIntent != null) {
          nzz.a().a(this.jdField_b_of_type_MqqAppNewIntent);
        }
        if (this.jdField_c_of_type_MqqAppNewIntent != null) {
          this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
        }
        if (this.jdField_a_of_type_Anmu != null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.removeObserver(this.jdField_a_of_type_Anmu);
          this.jdField_a_of_type_Anmu = null;
        }
        super.H();
        if (this.jdField_a_of_type_Nzz != null)
        {
          this.jdField_a_of_type_Nzz.a(a());
          this.jdField_a_of_type_Nzz.a(this.jdField_a_of_type_AndroidContentContext);
        }
        Iterator localIterator = this.jdField_a_of_type_Afwy.a().iterator();
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
        if ((this.jdField_d_of_type_Biau != null) && (this.jdField_d_of_type_Biau.isShowing()))
        {
          this.jdField_d_of_type_Biau.dismiss();
          this.jdField_d_of_type_Biau = null;
        }
        if ((this.jdField_d_of_type_AndroidAppDialog != null) && (this.jdField_d_of_type_AndroidAppDialog.isShowing()))
        {
          this.jdField_d_of_type_AndroidAppDialog.dismiss();
          this.jdField_d_of_type_AndroidAppDialog = null;
        }
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
        }
        if ((this.jdField_c_of_type_Bgpa != null) && (this.jdField_c_of_type_Bgpa.isShowing()))
        {
          this.jdField_c_of_type_Bgpa.dismiss();
          this.jdField_c_of_type_Bgpa = null;
        }
        if (this.jdField_a_of_type_Bers != null) {
          this.jdField_a_of_type_Bers.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.d();
        }
        bo();
        bP();
        if (this.jdField_j_of_type_Long != 0L)
        {
          this.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_j_of_type_Long);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D5", "0X80064D5", 0, 0, "", "" + this.jdField_j_of_type_Long, "" + this.J, "");
          this.jdField_j_of_type_Long = 0L;
          this.D = 0;
        }
        if (this.ah) {
          ThreadManager.executeOnSubThread(new PublicAccountChatPie.9(this));
        }
        bB();
        tzo.jdField_a_of_type_Boolean = false;
        try
        {
          if (!J()) {
            continue;
          }
          ArkAppNotifyCenter.unRegistVolumnReceiver();
          ArkAppNotifyCenter.setNotify("com.tencent.gouwu.video", null);
          akwh.a().b("com.tencent.qqshop");
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
  
  public boolean H()
  {
    return (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) || (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getVisibility() == 8);
  }
  
  public void L()
  {
    super.L();
    bW();
    long l1 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      int i1 = this.jdField_b_of_type_JavaUtilList.size() - 1;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C35", "0X8005C35", 0, 1, 0, (String)this.jdField_b_of_type_JavaUtilList.get(i1), String.valueOf(this.jdField_e_of_type_Long), String.valueOf(l1), (String)this.jdField_c_of_type_JavaUtilList.get(i1));
    }
    if (this.Y)
    {
      if (this.Z) {
        oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "new", String.valueOf(l1 - this.jdField_g_of_type_Long), "", "", false);
      }
    }
    else {
      return;
    }
    oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "old", String.valueOf(l1 - this.jdField_g_of_type_Long), "", "", false);
  }
  
  public void M()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      ((oda)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    super.M();
    this.jdField_a_of_type_Aval.d();
    PublicAccountInfo localPublicAccountInfo = ((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localPublicAccountInfo != null) {
      switch (tzo.a(localPublicAccountInfo.accountFlag))
      {
      }
    }
    for (;;)
    {
      if (J())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "report stay page time tabid is1");
        }
        oev.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "gouwu.aio.stay", "1", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.jdField_l_of_type_Long + "");
        oev.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "gouwu_aio_stay", "1", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.jdField_l_of_type_Long + "");
      }
      return;
      aoqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.G, 2, System.currentTimeMillis() - this.jdField_l_of_type_Long);
      continue;
      aoqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.G, 3, System.currentTimeMillis() - this.jdField_l_of_type_Long);
      continue;
      aoqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.G, 4, System.currentTimeMillis() - this.jdField_l_of_type_Long);
    }
  }
  
  public void N()
  {
    super.N();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(37, 500L);
    if (this.jdField_a_of_type_Bers.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bers.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Bers.c();
    }
    if ((ahdq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(anni.a(2131707514));
    }
    if ((!this.av) && (this.aw))
    {
      this.aw = false;
      ThreadManager.postImmediately(new PublicAccountChatPie.4(this), null, true);
    }
    this.jdField_g_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      if (mal.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
    }
    for (;;)
    {
      ode localode = (ode)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(68);
      if (tue.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        long l1 = 0L;
        if (oda.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {
          l1 = ((Long)oda.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).longValue();
        }
        if ((!TextUtils.isEmpty((String)oda.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && (System.currentTimeMillis() - l1 <= oda.jdField_a_of_type_Int)) {
          break;
        }
        oda.b.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
        localode.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      if ((this.jdField_e_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getText().length() < 6)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      } else {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    if (mal.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130847074);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void P()
  {
    if ((this.az) && (this.aA)) {
      return;
    }
    this.jdField_m_of_type_Long = System.currentTimeMillis();
    try
    {
      ark.arkNotify("com.tencent.weather", "pubaccountPendantRefresh", "", "json");
      super.P();
      if (!this.aA) {
        ThreadManager.post(new PublicAccountChatPie.52(this), 5, null, false);
      }
      this.aA = true;
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      bcst.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "exp", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "ark.arkNotify exception:", localUnsatisfiedLinkError);
      }
    }
  }
  
  public void Q()
  {
    super.Q();
    this.av = false;
    this.aw = false;
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
            paramAbsStructMsg = bkgj.b(paramAbsStructMsg.substring(paramAbsStructMsg.indexOf("?") + 1));
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
    this.aw = true;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.Y) {
      B(2131694624);
    }
  }
  
  void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    anld localanld = (anld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localanld != null) {
      localanld.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.am) {
      bE();
    }
    if (ahdq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(8);
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
      if (this.jdField_a_of_type_Bers != null)
      {
        Iterator localIterator = this.jdField_a_of_type_Bers.jdField_a_of_type_JavaUtilList.iterator();
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
    if (twi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, i1))
    {
      aong localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject = (RecentUser)localaong.findRecentUserByUin((String)localObject, i1);
      if (localObject != null) {
        localaong.delRecentUser((BaseRecentUser)localObject);
      }
    }
    if ((J()) && (this.jdField_a_of_type_Oei != null)) {
      this.jdField_a_of_type_Oei.a(paramChatMessage);
    }
  }
  
  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    anrs localanrs;
    if (paramPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + paramPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + paramPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + paramPublicAccountInfo.mIsAgreeSyncLbs);
      }
      localanrs = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localanrs == null) {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): pam is null");
        }
      }
    }
    for (;;)
    {
      return;
      if ((paramPublicAccountInfo.isSyncLbs) && (!paramPublicAccountInfo.mIsSyncLbsSelected) && (!paramPublicAccountInfo.mIsAgreeSyncLbs) && (!this.ax))
      {
        String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691876);
        String str2 = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691874), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        this.jdField_c_of_type_AndroidAppDialog = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, str1, str2, 2131691873, 2131691875, new aien(this, paramPublicAccountInfo, localanrs), new aieo(this, paramPublicAccountInfo, localanrs));
        this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new aiep(this));
        this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
          this.jdField_c_of_type_AndroidAppDialog.show();
        }
        this.ax = true;
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
    while (i1 <= paramAbsListView.getLastVisiblePosition())
    {
      a(localArrayList5, localArrayList4, localArrayList1, localArrayList2, localArrayList3, (ChatMessage)this.jdField_a_of_type_Afwy.getItem(i1), i1);
      i1 += 1;
    }
    b(localArrayList5);
    if (!localArrayList4.isEmpty()) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_Nzz.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, 0L, l1, l2, 2, localArrayList4);
      paramAbsListView = localArrayList5.iterator();
      while (paramAbsListView.hasNext()) {
        if ("1".equals(((ChatMessage)paramAbsListView.next()).getExtInfoFromExtStr("is_AdArrive_Msg")))
        {
          if (this.jdField_e_of_type_Long == -1L) {
            this.jdField_e_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
          }
          this.jdField_b_of_type_JavaUtilList = localArrayList1;
          txr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList2, localArrayList1, localArrayList3);
        }
      }
      return;
    }
    catch (Exception paramAbsListView) {}
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    this.al = true;
    super.a(paramList, paramCharSequence);
    int i1;
    long l1;
    if (this.jdField_y_of_type_Boolean)
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D4", "0X80064D4", 0, 0, "", "" + i1, "" + l1, "");
      return;
      label174:
      continue;
      label177:
      l1 = 0L;
      i1 = -1;
    }
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "<<<<<<<<<<<<<<list.size<<<<<<<<<" + paramList.size());
    try
    {
      if (J())
      {
        if (this.as)
        {
          this.jdField_a_of_type_Afwy.a = Boolean.valueOf(false);
          if (this.jdField_a_of_type_Oei == null) {
            return;
          }
          this.jdField_a_of_type_Oei.a(paramList, new aifb(this, paramCharSequence));
          return;
        }
        if (this.jdField_a_of_type_Oei == null) {
          return;
        }
        this.jdField_a_of_type_Oei.a(paramList, new aifc(this, paramCharSequence, paramInt));
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, QLog.getStackTraceString(localThrowable1));
      if (tzo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
      try
      {
        ((akmh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(341)).a(paramList);
        super.a(paramList, paramCharSequence, paramInt);
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, localThrowable2, new Object[0]);
        }
      }
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qidianWpaClick ... mQidianKefu = " + this.ao);
    }
    z(2131694663);
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
      this.jdField_a_of_type_Nzz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMap, (String)localObject, null, new aifg(this));
      return;
      localObject = null;
      paramMap = null;
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!H()) {
        this.jdField_F_of_type_Int = 2;
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
        if (!G()) {
          this.jdField_F_of_type_Int = 1;
        } else {
          this.jdField_F_of_type_Int = 0;
        }
      }
    }
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    switch (this.jdField_F_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_F_of_type_Int = -1;
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
    if (!this.Y) {
      return super.a(paramInt, paramView, paramListView);
    }
    if ((this.jdField_a_of_type_Afwy != null) && (this.jdField_a_of_type_Afwy.getCount() > 0))
    {
      this.aa = true;
      d(System.currentTimeMillis());
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((afxb)this.jdField_a_of_type_Acwr.a).a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Acwr.e = false;
      this.jdField_a_of_type_Acwr.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 21, this.jdField_a_of_type_Acwr);
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Aifk = new aifk(this, null);
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Aifk, (IntentFilter)localObject1);
    this.M = false;
    this.jdField_F_of_type_Boolean = false;
    bK();
    this.jdField_a_of_type_Nzz = nzz.a();
    bA();
    super.a(paramBoolean);
    if (this.am) {
      bC();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0) {
      this.ah = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(this.jdField_a_of_type_Bkqc);
    this.jdField_a_of_type_Bers = new bers();
    this.jdField_a_of_type_Bers.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Afwy, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_Bers.addObserver(this);
    localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    this.jdField_j_of_type_Long = System.currentTimeMillis();
    this.D = ((Intent)localObject1).getIntExtra("red_hot_count", 0);
    Object localObject2 = ((Intent)localObject1).getStringExtra("from");
    this.ad = ((Intent)localObject1).getBooleanExtra("shouldreport", false);
    this.jdField_k_of_type_Long = System.currentTimeMillis();
    this.x = 0;
    this.z = 0;
    this.w = 0;
    this.jdField_y_of_type_Int = 0;
    this.E = this.D;
    tzo.jdField_a_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("is_come_from_readinjoy", false);
    this.G = ((Intent)localObject1).getIntExtra("INTENT_KEY_FROM", 1);
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      PublicAccountInfo localPublicAccountInfo = ((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localPublicAccountInfo == null) || (tzo.a(localPublicAccountInfo.accountFlag) != -2)) {
        break label601;
      }
      this.ay = true;
      bs();
      this.jdField_a_of_type_Bers.f();
      if (this.jdField_a_of_type_Bers.b > 0) {
        break label483;
      }
      this.jdField_a_of_type_Bers.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
    }
    for (;;)
    {
      PublicAccountHandler.jdField_a_of_type_JavaLangString = null;
      this.ab = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("has_unread_msg", false);
      if ((localObject2 == null) || (!((String)localObject2).equals("starShortcut"))) {
        break;
      }
      nzz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Intent)localObject1).getStringExtra("starhomeurl"), ((Intent)localObject1).getStringExtra("uin"), (String)localObject2);
      return true;
      label483:
      int i2 = ((bfrd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (i2 == -1)
      {
        this.jdField_a_of_type_Bers.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
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
          this.az = true;
        }
        for (;;)
        {
          bJ();
          break;
          i1 = 0;
          break label545;
          label579:
          i2 = 0;
          break label554;
          label584:
          this.jdField_a_of_type_Bers.e();
          this.jdField_a_of_type_Bers.b();
        }
        label601:
        bJ();
      }
    }
    if ((bgnt.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()) == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals("2632129500"))) {
      nko.b("108", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new aiex(this));
    }
    if ("3105932915".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject2 = (bkzy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
      if (localObject2 != null) {
        bkzv.a(((bkzy)localObject2).a(5));
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "the public account is boodo comic");
      }
      akwh.a().a("com.tencent.qqcomic.care");
      akwh.a().a("com.tencent.carecomic.normal");
      akwh.a().a("com.tencent.carecomic.update");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    this.Y = tzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate, isMediaAndOtherSubscript = " + this.Y);
    }
    this.jdField_f_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (tzo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject2 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate, preload web process");
        }
        ((WebProcessManager)localObject2).e();
      }
    }
    if (this.Y)
    {
      bU();
      bx();
      bz();
    }
    if (this.Y) {
      if (this.Z) {
        oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "new", "", "", false);
      }
    }
    for (;;)
    {
      pmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.U = true;
      }
      if ((I()) && (this.E > 0)) {
        ThreadManagerV2.excute(new PublicAccountChatPie.6(this), 16, null, false);
      }
      if (J())
      {
        ArkAppNotifyCenter.setNotify("com.tencent.gouwu.video", new WeakReference(new apis()));
        ArkAppNotifyCenter.registVolumnReceiver();
        if (oen.b()) {
          akwh.a().a("com.tencent.qqshop");
        }
        h((Intent)localObject1);
      }
      if (ahdq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        alzs.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_page_arrive");
      }
      return true;
      oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "old", "", "", false);
      continue;
      oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
      if ("2290230341".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E2", "0X80090E2", 0, 0, "", "", "", "");
        bcsq.a(2);
      }
    }
  }
  
  public void aA()
  {
    super.aA();
    if (this.jdField_l_of_type_AndroidViewView != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_l_of_type_AndroidViewView.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (!H())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getId());
            return;
          }
          if (!G())
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
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    super.afterTextChanged(paramEditable);
    e(paramEditable);
    PatchedButton localPatchedButton;
    if (this.jdField_f_of_type_Int == 0)
    {
      if (!this.jdField_f_of_type_Boolean) {
        break label75;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690671);
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
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
      } while ((this.jdField_n_of_type_AndroidWidgetImageView != null) && (this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() == 0));
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() > 0) {
        bool1 = true;
      }
      localPatchedButton.setEnabled(bool1);
    } while (paramEditable.length() <= 0);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690671);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
  }
  
  public void ai()
  {
    if ((this.ay) && (twi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) > 0)) {
      twi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.ai();
    if (ahdq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
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
      oda localoda = (oda)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      if ((localoda != null) && (localoda.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        ThreadManager.post(new PublicAccountChatPie.3(this), 5, null, true);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      nov.a().a(1000L);
      return;
      if (("3026775809".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSystemService("sensor")).getDefaultSensor(19) != null)) {
        ((bhft)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260)).a("public account");
      }
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anqd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anry);
    oda localoda = (oda)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
    if (tue.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Odf);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bjha);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anqd);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anry);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Odf);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bjha);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoqn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Aoqn);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.Y) {
      B(2131694636);
    }
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if (tzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    super.b(paramQQAppInterface);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (tue.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (tue.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      tue.a().a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_Afwy.a(paramChatMessage) + 1;
    if ((i1 >= 0) && (i1 <= this.jdField_a_of_type_Afwy.getCount() - 1))
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_Afwy.getItem(i1);
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
    ThreadManager.postImmediately(new PublicAccountChatPie.17(this, paramList), null, false);
  }
  
  void b(boolean paramBoolean, int paramInt)
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      nzz.a().a(this.jdField_b_of_type_MqqAppNewIntent);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    this.jdField_b_of_type_MqqAppNewIntent = nzz.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt, paramBoolean, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aier(this));
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = ((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        return (((PublicAccountInfo)localObject).accountFlag & 0x40000000) == 1073741824;
      }
      return false;
    }
    Object localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((anrs)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        return false;
      }
      return (((AccountDetail)localObject).accountFlag & 0x40000000) == 1073741824;
    }
    return false;
  }
  
  void bA()
  {
    bG();
    this.jdField_a_of_type_Bjft = ((bjft)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165));
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_wpa_key");
    if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
    {
      this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_kfuin");
      this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_type");
      this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_key");
      this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_ext");
      this.jdField_n_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("rkey");
      this.am = true;
      this.an = false;
      this.ao = false;
      this.ap = false;
      this.aq = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      this.jdField_a_of_type_Bjft.a(str, this.jdField_j_of_type_JavaLangString);
      return;
    }
    this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_Bjft.b(str);
    if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))
    {
      this.am = true;
      this.an = true;
      this.jdField_k_of_type_JavaLangString = null;
      this.jdField_l_of_type_JavaLangString = null;
      this.jdField_m_of_type_JavaLangString = null;
      this.jdField_n_of_type_JavaLangString = null;
      this.ao = true;
      this.ap = false;
      this.aq = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      return;
    }
    this.am = false;
    this.an = false;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_n_of_type_JavaLangString = null;
    this.ao = false;
    this.ap = false;
    this.aq = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  }
  
  protected void bB()
  {
    this.am = false;
    this.an = false;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.jdField_n_of_type_JavaLangString = null;
    this.ao = false;
    this.ap = false;
    this.aq = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
    this.ar = false;
  }
  
  public void bC()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkQDAccountValid ...");
    }
    ThreadManager.post(new PublicAccountChatPie.56(this), 8, null, false);
  }
  
  public void bD()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("updateHeader ... ");
      if (this.jdField_n_of_type_AndroidViewView == null) {
        break label71;
      }
    }
    label71:
    for (Object localObject = Integer.valueOf(this.jdField_n_of_type_AndroidViewView.getVisibility());; localObject = "")
    {
      QLog.d(str, 2, localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) && (this.an)) {
        break;
      }
      return;
    }
    if (this.ap)
    {
      this.jdField_q_of_type_AndroidViewView.setVisibility(0);
      this.jdField_p_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_q_of_type_AndroidViewView.setVisibility(8);
    this.jdField_p_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void bE()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateWpaUiForQidian: mQidianAccountValid = " + this.an + ", mQidianKefu = " + this.ao + ", mQidianShield: " + this.ap);
    }
    if (this.an) {
      if (((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
        break label292;
      }
    }
    label292:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        bu();
        return;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      InputLinearLayout localInputLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
      if (this.ap) {
        i1 = 8;
      }
      for (;;)
      {
        localInputLinearLayout.setVisibility(i1);
        if (this.jdField_o_of_type_AndroidWidgetImageView == null) {
          this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366156));
        }
        this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        if (this.jdField_n_of_type_AndroidViewView == null)
        {
          if (QLog.isColorLevel()) {
            QZLog.d(this.jdField_a_of_type_JavaLangString, 2, "setInitHeader in updateWpaUiForQidian");
          }
          br();
        }
        bD();
        return;
        if (this.ao) {
          i1 = 0;
        } else {
          i1 = 8;
        }
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void bF()
  {
    if ((!this.an) || (!this.aq)) {}
    int i1;
    do
    {
      return;
      if (((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {}
      for (i1 = 1; (this.ap) && (i1 == 0); i1 = 0)
      {
        aoey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131697488), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, true);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
        return;
      }
    } while ((this.ap) || (i1 != 0));
  }
  
  public void bG()
  {
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.62(this));
  }
  
  public void bo()
  {
    ChatMessage localChatMessage;
    String str1;
    if (this.jdField_a_of_type_Afwy.getCount() >= 1)
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_Afwy.a().get(this.jdField_a_of_type_Afwy.getCount() - 1);
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "old", String.valueOf(l1 - this.jdField_f_of_type_Long), "", "");
    }
    Object localObject = localChatMessage.getExtInfoFromExtStr("pa_msgId");
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "" + localChatMessage.frienduin, "0X8005C38", "0X8005C38", 0, 1, 0, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
    if (this.Y)
    {
      l1 = NetConnInfoCenter.getServerTime() * 1000L;
      if (this.Z) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "new", String.valueOf(l1 - this.jdField_f_of_type_Long), "", "");
      }
    }
    else
    {
      return;
    }
  }
  
  public void bp()
  {
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_Biau != null) && (this.jdField_d_of_type_Biau.isShowing())) {
      this.jdField_d_of_type_Biau.dismiss();
    }
  }
  
  @TargetApi(11)
  void bq()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new PublicAccountChatPie.12(this));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_t_of_type_AndroidViewView);
      this.au = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    a(this.jdField_t_of_type_AndroidViewView, this.jdField_t_of_type_AndroidViewView.getHeight(), 0, new aidu(this));
    this.jdField_n_of_type_AndroidViewView.setTranslationY(0.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_n_of_type_AndroidViewView.getHeight());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new aidv(this));
    this.jdField_n_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  void br()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {}
    do
    {
      return;
      bL();
      this.jdField_t_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2131558629, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    } while (this.jdField_t_of_type_AndroidViewView == null);
    Object localObject;
    if (this.jdField_q_of_type_Int == 2)
    {
      this.jdField_t_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297509));
      if ((!this.am) && (!this.ar)) {
        break label222;
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject != null)
      {
        localObject = ((anrs)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (this.T))
        {
          c((AccountDetail)localObject);
          this.T = false;
        }
      }
      bM();
      return;
      if (!this.am) {
        break;
      }
      this.jdField_t_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297509));
      break;
      label222:
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_t_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter((ListAdapter)localObject);
    }
  }
  
  void bs()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    if (this.jdField_h_of_type_AndroidViewView != null) {
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_i_of_type_AndroidViewView != null) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  void bt()
  {
    if (this.jdField_a_of_type_Bkho == null)
    {
      this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null));
      this.jdField_a_of_type_Bkho.a(anni.a(2131707561));
      this.jdField_a_of_type_Bkho.a(anni.a(2131707557), 3);
      this.jdField_a_of_type_Bkho.c(2131690582);
      this.jdField_a_of_type_Bkho.setOnDismissListener(new aied(this));
      this.jdField_a_of_type_Bkho.a(new aiee(this));
    }
    if (!this.jdField_a_of_type_Bkho.isShowing())
    {
      this.ag = false;
      this.jdField_a_of_type_Bkho.show();
    }
  }
  
  void bu()
  {
    if (this.av) {
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
        this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366156));
        if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
          this.jdField_o_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131695728));
        }
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar);
        }
        if (this.jdField_n_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_n_of_type_AndroidViewView);
          this.jdField_n_of_type_AndroidViewView = null;
        }
        if (this.jdField_t_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_t_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366155));
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131558631, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366155));
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) {
            break label816;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_Nzz.b(a()));
          if (CustomMenuBar.a())
          {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167129));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(afur.a(48.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
          {
            Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
            Object localObject2 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getLayoutParams();
            if ((localObject3 != null) && (localObject2 != null) && ((localObject3 instanceof RelativeLayout.LayoutParams)) && ((localObject2 instanceof RelativeLayout.LayoutParams)))
            {
              localObject3 = (RelativeLayout.LayoutParams)localObject3;
              int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject3).getRules();
              if ((arrayOfInt.length > 2) && (arrayOfInt[2] == 2131368652))
              {
                ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131366155);
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131368652);
                this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          if (this.X)
          {
            localObject1 = new TranslateAnimation(0.0F, 0.0F, afur.a(34.0F, (Resources)localObject1), 0.0F);
            ((TranslateAnimation)localObject1).setDuration(250L);
            ((TranslateAnimation)localObject1).setFillAfter(true);
            ((TranslateAnimation)localObject1).setAnimationListener(new aiei(this));
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.startAnimation((Animation)localObject1);
          }
          localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366154);
          ((View)localObject1).setOnClickListener(new aiej(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject1);
          this.jdField_s_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372087);
          bO();
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("menuEventSharePre", 0);
          if (!((SharedPreferences)localObject1).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            localObject1 = ((SharedPreferences)localObject1).edit();
            ((SharedPreferences.Editor)localObject1).putInt(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
            ((SharedPreferences.Editor)localObject1).commit();
          }
          this.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new aiek(this));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new aiel(this));
          localObject1 = this.jdField_a_of_type_Nzz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          c((List)localObject1);
          this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_Nzz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            v(true);
          }
          this.av = true;
          if (this.jdField_a_of_type_Ocm == null) {
            this.jdField_a_of_type_Ocm = new ocm(this.jdField_a_of_type_AndroidContentContext);
          }
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
          if ((((Intent)localObject1).hasExtra("pub_account_type")) && ("type_ecshop_account".equals(((Intent)localObject1).getStringExtra("pub_account_type"))))
          {
            localObject1 = ((Intent)localObject1).getStringExtra("ecshop_distance_tip");
            localObject1 = this.jdField_a_of_type_Ocm.a((String)localObject1, this);
            this.jdField_a_of_type_Ocm.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (View)localObject1);
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconPv", "Pv_shopnearbyicon", 0, 0, "", "", "", "");
          }
          if ((!I()) || (!auuc.a())) {
            break;
          }
          ay();
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
  
  public void bv()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      if ((this.jdField_e_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getText().length() < 6)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void bw()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow");
    Object localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((anrs)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (tzo.a(((AccountDetail)localObject).accountFlag) != -4)) {
        break label212;
      }
      if (this.jdField_c_of_type_MqqAppNewIntent != null) {
        this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
      }
      this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), oaz.class);
      this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
      localObject = new mobileqq_mp.FollowRequest();
      ((mobileqq_mp.FollowRequest)localObject).ext.set("4");
      ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
      localObject = new aies(this);
      this.jdField_c_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
    }
    for (;;)
    {
      oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4);
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow exit");
      return;
      label212:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoqn);
      this.jdField_a_of_type_Aoqn = new aoqn(new aiet(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoqn);
      aoqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
  }
  
  public void bx()
  {
    ThreadManager.post(new PublicAccountChatPie.48(this), 8, null, true);
  }
  
  @TargetApi(11)
  protected void by()
  {
    if (this.jdField_l_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130844832);
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!VersionUtils.isHoneycomb());
    this.jdField_l_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.jdField_f_of_type_Int == 2)
    {
      this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.isHoneycomb()) {
        this.jdField_l_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130849870);
        }
        for (;;)
        {
          this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131697663));
          return;
          this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850301);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130849869);
      }
      for (;;)
      {
        this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131697662));
        return;
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850302);
      }
    }
    this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130849870);
      }
      for (;;)
      {
        this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131697663));
        label246:
        if (!VersionUtils.isHoneycomb()) {
          break;
        }
        this.jdField_l_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850301);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130849869);
    }
    for (;;)
    {
      this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131697662));
      break label246;
      break;
      this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850302);
    }
  }
  
  public void bz()
  {
    this.jdField_u_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559629, null);
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_u_of_type_AndroidViewView.findViewById(2131376318));
    if (!this.Z) {
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_u_of_type_AndroidViewView.findViewById(2131376312));
    this.jdField_p_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_u_of_type_AndroidViewView.findViewById(2131376310));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_u_of_type_AndroidViewView.findViewById(2131376313));
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    by();
    if (paramInt2 == 8) {
      if (this.jdField_m_of_type_AndroidWidgetImageView != null)
      {
        if (!CustomMenuBar.a()) {
          break label295;
        }
        this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130849919);
      }
    }
    for (;;)
    {
      if (!this.jdField_f_of_type_Boolean)
      {
        SpannableString localSpannableString;
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838073);
          localSpannableString = new SpannableString(anni.a(2131707567));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838367);
          localSpannableString = new SpannableString(anni.a(2131707563));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if ((QLog.isColorLevel()) && (this.jdField_n_of_type_AndroidWidgetImageView != null)) {
          QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_n_of_type_AndroidWidgetImageView.getVisibility());
        }
        if (paramInt2 != 2) {
          break;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (afug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(false);
        }
      }
      return;
      label295:
      this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130849841);
      continue;
      if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
        if (CustomMenuBar.a()) {
          this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130849918);
        } else {
          this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130849840);
        }
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject).setSelected(bool);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
        break;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690671);
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramIntent);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new PublicAccountChatPie.34(this));
    bR();
    bG();
    bV();
  }
  
  public void c(View paramView)
  {
    super.c(paramView);
    paramView = afur.a(paramView);
    ((agny)this.jdField_a_of_type_Aglu.a(22)).a(paramView);
  }
  
  void c(List<mobileqq_mp.ButtonInfo> paramList)
  {
    if ((I()) && (auuc.a())) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqgame pubaccount return");
    }
    for (;;)
    {
      return;
      if ((J()) && ((!this.at) || (this.as)))
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqshop pubaccount return");
        return;
      }
      if (K())
      {
        ay();
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqlive pubaccount return");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_Nzz.b(a()));
        }
        if ((paramList == null) || (paramList.isEmpty()))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
          }
          if (this.jdField_h_of_type_AndroidViewView != null) {
            this.jdField_h_of_type_AndroidViewView.setVisibility(0);
          }
          if (this.jdField_i_of_type_AndroidViewView != null) {
            this.jdField_i_of_type_AndroidViewView.setVisibility(0);
          }
          if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
            this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        else
        {
          if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
            this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          Object localObject1;
          if ((paramList != null) && (ahdq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            localObject1 = new mobileqq_mp.ButtonInfo();
            ((mobileqq_mp.ButtonInfo)localObject1).id.set(0);
            ((mobileqq_mp.ButtonInfo)localObject1).name.set(anni.a(2131712601));
            ((mobileqq_mp.ButtonInfo)localObject1).event_id.set(1000002);
            ((mobileqq_mp.ButtonInfo)localObject1).type.set(3);
            paramList.add(0, localObject1);
          }
          int i3 = paramList.size();
          int i1 = 0;
          while ((i1 < i3) && (i1 <= 2))
          {
            Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i1);
            String str;
            label363:
            label383:
            aaum localaaum;
            label426:
            label450:
            mobileqq_mp.ButtonInfo localButtonInfo;
            if (((mobileqq_mp.ButtonInfo)localObject2).key.has())
            {
              localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
              if (!((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
                break label573;
              }
              str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
              if (!((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
                break label580;
              }
              i2 = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
              localaaum = new aaum((String)localObject1, str, null, i2);
              localaaum.a((mobileqq_mp.ButtonInfo)localObject2);
              if (!((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
                break label585;
              }
              localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
              if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
                break label610;
              }
              localObject2 = ((List)localObject1).iterator();
              if (!((Iterator)localObject2).hasNext()) {
                break label610;
              }
              localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
              if (!localButtonInfo.key.has()) {
                break label591;
              }
              localObject1 = localButtonInfo.key.get();
              label493:
              if (!localButtonInfo.name.has()) {
                break label598;
              }
              str = localButtonInfo.name.get();
              label514:
              if (!localButtonInfo.id.has()) {
                break label605;
              }
            }
            label573:
            label580:
            label585:
            label591:
            label598:
            label605:
            for (int i2 = localButtonInfo.id.get();; i2 = 0)
            {
              localObject1 = new aaum((String)localObject1, str, null, i2);
              ((aaum)localObject1).a(localButtonInfo);
              localaaum.a((aaum)localObject1);
              break label450;
              localObject1 = "";
              break;
              str = "";
              break label363;
              i2 = 0;
              break label383;
              localObject1 = null;
              break label426;
              localObject1 = "";
              break label493;
              str = "";
              break label514;
            }
            label610:
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localaaum, a());
            i1 += 1;
          }
        }
      }
    }
  }
  
  public void d(long paramLong)
  {
    try
    {
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d(View paramView)
  {
    paramView.getLayoutParams().height = 0;
    paramView.requestLayout();
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131690389));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  public void e(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_Afwy.a(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i1);
    }
    if (i1 < 0) {
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int i3 = i1 - i2;
    this.jdField_o_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + i3 + ",firstPos is:" + i2 + ",pos is:" + i1);
    }
    this.jdField_a_of_type_Afwy.a(paramChatMessage);
  }
  
  public void f()
  {
    super.f();
    this.jdField_b_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367274));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setContentDescription(anni.a(2131707573));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366156));
    if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
      this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131373026));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367275));
    localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (CustomMenuBar.a()) {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-1);
    }
    for (;;)
    {
      this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131362996));
      this.jdField_n_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372699));
      this.jdField_m_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131365878));
      this.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130847887);
        this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130838019);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        int i1 = afur.a(3.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        if (CustomMenuBar.a())
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130849973);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167129));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, i1, 0, i1);
      }
      if (K()) {
        ay();
      }
      return;
      F(80);
    }
  }
  
  public void f(int paramInt)
  {
    int i1 = 0xFFFF0000 & paramInt;
    super.f(paramInt);
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
          if ((this.jdField_i_of_type_Long == 9223372036854775807L) || (localChatMessage.uniseq == this.jdField_i_of_type_Long)) {
            i1 = 1;
          }
          i2 = i1;
          if (this.jdField_i_of_type_Long == 9223372036854775807L) {}
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
          this.jdField_i_of_type_Long = localChatMessage.uniseq;
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
  
  public void f(boolean paramBoolean)
  {
    try
    {
      if ((J()) && (this.jdField_a_of_type_Oei != null)) {
        this.jdField_a_of_type_Oei.a(a());
      }
      label27:
      super.f(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  public void g(String paramString)
  {
    boolean bool = true;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Ocm != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
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
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new PublicAccountChatPie.61(this, bool, str, (String)localObject, i1, i2, i3));
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.Y)
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
        {
          if (this.jdField_u_of_type_AndroidViewView == null) {
            bz();
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_u_of_type_AndroidViewView);
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
    PublicAccountInfo localPublicAccountInfo = ((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_Aimj.a(1000, new Object[0]);
      continue;
      if (this.jdField_s_of_type_AndroidViewView != null)
      {
        this.jdField_s_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
        continue;
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        if ((this.jdField_s_of_type_AndroidViewView != null) && (this.jdField_s_of_type_AndroidViewView.getVisibility() == 0))
        {
          this.jdField_s_of_type_AndroidViewView.setVisibility(8);
          continue;
          a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
          }
          Object localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
          if (localObject != null)
          {
            localObject = ((anrs)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              this.jdField_e_of_type_AndroidWidgetTextView.setText(((AccountDetail)localObject).name);
              if (this.T)
              {
                c((AccountDetail)localObject);
                this.T = false;
              }
              if (this.jdField_c_of_type_AndroidAppDialog == null) {}
              bv();
            }
          }
          if (this.S)
          {
            this.S = false;
            if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
              this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
            }
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            bp();
            continue;
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.c();
          }
        }
      }
    }
  }
  
  public boolean i()
  {
    try
    {
      if ((J()) && (this.jdField_a_of_type_Oei != null)) {
        this.jdField_a_of_type_Oei.a(a());
      }
      label27:
      return super.i();
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  public int j()
  {
    int i1 = 0;
    View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((this.jdField_v_of_type_AndroidViewView != null) && (localView != this.jdField_v_of_type_AndroidViewView))
    {
      this.A = 0;
      this.jdField_v_of_type_AndroidViewView = localView;
      return 0;
    }
    if (localView != null) {
      i1 = -localView.getTop();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ScrollY: " + String.valueOf(i1) + "  OldScrollY: " + String.valueOf(this.A));
    }
    this.jdField_v_of_type_AndroidViewView = localView;
    return i1;
  }
  
  public void j()
  {
    aima localaima = new aima(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aimj, this, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Aimj.a(localaima);
  }
  
  public void l()
  {
    if (!this.Y) {
      super.l();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366156) {
      v(true);
    }
    if (2131368961 == paramView.getId())
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
      bgnv.a(null, "pubAcc_profile_display", "");
    }
    if (paramView.getId() == 2131367274)
    {
      long l1 = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_n_of_type_AndroidWidgetImageView != null)) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, " onClick fun_btn start mInputStat = " + this.jdField_f_of_type_Int + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() + " currentPanel:" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() + " currenttime:" + System.currentTimeMillis());
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) && (this.jdField_n_of_type_AndroidWidgetImageView != null) && (this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() != 0))
      {
        c();
        if (ahdq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) && (((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          alzs.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_search_push");
        }
      }
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, " onClick fun_btn end mInputStat = " + this.jdField_f_of_type_Int + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
        }
        oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800584F", "0X800584F", 0, 0, "", "", "", "", false);
      }
    }
    if ((paramView.getId() == 2131365878) && (this.jdField_f_of_type_Int != 1))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3) {
        break label899;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
        this.jdField_m_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689907));
      }
    }
    if (paramView.getId() == 2131372699)
    {
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8)
      {
        if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
          this.jdField_m_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689907));
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
      label643:
      if (paramView.getId() == 2131362996)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) {
          break label1032;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        if (this.jdField_n_of_type_AndroidWidgetImageView != null)
        {
          this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(this.jdField_u_of_type_Int);
          this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131689924));
        }
      }
      label710:
      if (paramView.getId() == 2131371393) {
        an();
      }
      if (this.aB) {}
      switch (paramView.getId())
      {
      default: 
        label776:
        if ((this.Y) && (paramView.getId() == 2131367274)) {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C9C", "0X8005C9C", 0, 1, 0, "", "", "", "");
        }
        if (((paramView.getTag() instanceof String)) && (ocm.jdField_a_of_type_JavaLangString.equals((String)paramView.getTag())) && (this.jdField_a_of_type_AndroidContentContext != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          if (System.currentTimeMillis() - this.jdField_h_of_type_Long >= 1000L) {
            break;
          }
        }
        break;
      }
    }
    label899:
    label1032:
    Object localObject1;
    Object localObject2;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      if ((this.jdField_n_of_type_AndroidWidgetImageView != null) && (this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        w(false);
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      aj();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
      if ((this.jdField_n_of_type_AndroidWidgetImageView != null) && (this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        w(false);
      }
      if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
        this.jdField_m_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689835));
      }
      p(0);
      break label643;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      if (this.jdField_n_of_type_AndroidWidgetImageView == null) {
        break label710;
      }
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(this.jdField_v_of_type_Int);
      this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131689923));
      break label710;
      bcst.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "clk_return", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "");
      break label776;
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      localObject1 = new StringBuilder("https://gouwu.qq.com/m/html/shop_map.html?_wv=1027&shop_uin=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", ((StringBuilder)localObject1).toString());
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconClk", "Clk_shopnearbyicon", 0, 0, "", "", "", "");
      if (paramView.getId() != 2131368956) {
        break label1416;
      }
      localObject1 = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (!tue.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label1416;
      }
      localObject2 = (String)oda.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("uin", (String)localObject2);
    localIntent = afur.a(localIntent, null);
    if (((anmw)localObject1).b((String)localObject2)) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Shop_customservice", "Clk_shopcustomservice", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      label1416:
      super.onClick(paramView);
      break;
      localIntent.putExtra("uintype", 1005);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + anni.a(2131707549));
      localIntent.putExtra("key_sub_title_from", "来自\"QQ咨询\"");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    ((agny)this.jdField_a_of_type_Aglu.a(22)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((J()) && (this.as) && (oen.b())) {
      oev.a().a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Afwy);
    }
    b(paramAbsListView);
    if ((this.am) || (this.ar)) {}
    label309:
    label311:
    int i1;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((this.jdField_n_of_type_AndroidViewView != null) && (this.jdField_t_of_type_AndroidViewView != null) && (this.jdField_t_of_type_Int != 5))
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
              if ((!this.au) && (!this.W)) {
                break label309;
              }
              if ((!this.af) || (this.W)) {
                break label311;
              }
              this.af = false;
              return;
              if (this.C >= paramInt3) {
                break;
              }
              this.jdField_t_of_type_Int = 3;
              break;
              if ((paramInt3 > paramInt2) && (!this.au))
              {
                this.B = this.jdField_t_of_type_AndroidViewView.getLayoutParams().height;
                d(this.jdField_t_of_type_AndroidViewView);
                this.au = true;
              }
              this.jdField_t_of_type_Int = 2;
              this.af = true;
              continue;
              if ((paramInt3 == paramInt2) && (this.au))
              {
                if (this.B != 0) {
                  a(this.jdField_t_of_type_AndroidViewView, this.B);
                }
                this.au = false;
                this.W = true;
              }
              this.jdField_t_of_type_Int = 2;
              this.af = true;
            }
          }
        }
        if (this.jdField_n_of_type_AndroidViewView.getHeight() != 0) {
          this.B = this.jdField_n_of_type_AndroidViewView.getHeight();
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
      } while (((i1 <= 5) || (!this.ae)) && ((paramInt1 != this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()) || (i1 <= 0) || (!this.ae) || (this.V)));
      this.V = true;
      paramAbsListView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.B);
      paramAbsListView.setFillAfter(true);
      paramAbsListView.setDuration(250L);
      paramAbsListView.setAnimationListener(new aidw(this));
      this.jdField_n_of_type_AndroidViewView.startAnimation(paramAbsListView);
      return;
    } while (((i1 >= -5) || (!this.ae)) && (((!this.W) && ((paramInt1 + paramInt2 != paramInt3) || (i1 >= 0) || (!this.ae))) || (this.V)));
    this.V = true;
    paramAbsListView = new TranslateAnimation(0.0F, 0.0F, -this.B, 0.0F);
    paramAbsListView.setFillAfter(true);
    paramAbsListView.setDuration(250L);
    paramAbsListView.setAnimationListener(new aidx(this));
    this.jdField_n_of_type_AndroidViewView.startAnimation(paramAbsListView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(37);
      nov.a().a(500L);
    }
    ((agny)this.jdField_a_of_type_Aglu.a(22)).a(paramAbsListView, paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.ae = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  @TargetApi(11)
  public void p(int paramInt)
  {
    super.p(paramInt);
    ImageSpan localImageSpan;
    SpannableString localSpannableString;
    if (paramInt != this.jdField_f_of_type_Int)
    {
      if (paramInt != 1) {
        break label87;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838073);
        localSpannableString = new SpannableString(anni.a(2131707579));
        localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
    label332:
    for (;;)
    {
      by();
      return;
      label87:
      if (paramInt == 2)
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838367);
          localSpannableString = new SpannableString(anni.a(2131707508));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        if (VersionUtils.isHoneycomb())
        {
          if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
            this.jdField_m_of_type_AndroidWidgetImageView.setAlpha(0.6F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
        }
      }
      else
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838367);
          localSpannableString = new SpannableString(anni.a(2131707554));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690671);
        }
        for (;;)
        {
          if (!VersionUtils.isHoneycomb()) {
            break label332;
          }
          if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
            this.jdField_m_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
          break;
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        }
      }
    }
  }
  
  public void r()
  {
    super.r();
    bv();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageRecord))
    {
      localObject = ((MessageRecord)paramObject).getExtInfoFromExtStr("welcome_msg");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("true"))) {
        ThreadManager.post(new PublicAccountChatPie.46(this), 8, null, false);
      }
      this.ah = true;
    }
    if ((bmqa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((paramObject instanceof MessageRecord))) {
      ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.update(paramObservable, paramObject);
    int i1;
    if ((paramObservable instanceof bers)) {
      if ((paramObject instanceof Integer))
      {
        i1 = ((Integer)paramObject).intValue();
        if (i1 != 0) {
          break label153;
        }
        this.jdField_a_of_type_Bers.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Bers.b();
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
      bJ();
      for (;;)
      {
        return;
        if (i1 != 1) {
          break label148;
        }
        this.az = true;
        break label148;
        if ((paramObservable instanceof QQMessageFacade))
        {
          if (this.jdField_a_of_type_Bers == null) {
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
    } while (!this.Y);
    ThreadManager.post(new PublicAccountChatPie.47(this), 5, null, false);
  }
  
  public void v(boolean paramBoolean)
  {
    if (K())
    {
      ay();
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setPublicAccountMenuBarVisible new qqlive pubaccount return");
    }
    while (!paramBoolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(4);
    }
    if (this.jdField_h_of_type_AndroidViewView != null) {
      this.jdField_h_of_type_AndroidViewView.setVisibility(4);
    }
    if (this.jdField_i_of_type_AndroidViewView != null) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(4);
    }
    aA();
  }
  
  protected void w(boolean paramBoolean)
  {
    int i2 = 8;
    if (this.jdField_n_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_n_of_type_AndroidWidgetImageView.clearAnimation();
    Object localObject = this.jdField_n_of_type_AndroidWidgetImageView;
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
        localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
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
        localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838073);
        SpannableString localSpannableString = new SpannableString(anni.a(2131707540));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
      return;
      i1 = 8;
      break label30;
    }
  }
  
  public void x()
  {
    if (this.aB)
    {
      "https://h5.qzone.qq.com/subscription/homepage/{userId}?_proxy=1&_wv=16777217&_wwv=4".replace("{userId}", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      aaae.a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      bcst.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "clk_head", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.am) {
      localIntent.putExtra("qidian_chat", true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      localIntent.putExtra("public_account_msg_id", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
    }
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    tzo.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 1, tzo.jdField_a_of_type_Boolean);
  }
  
  public boolean y()
  {
    if ((!this.ai) && (this.Y))
    {
      this.ai = true;
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_Afwy.getCount() - 1);
    }
    while ((this.aj) || (!this.Y)) {
      return true;
    }
    this.aj = true;
    return false;
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ("2277373213".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130847331);
      }
    }
    else {
      return;
    }
    if (K()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131368961).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850127, 2130850128);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131695720));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850127, 2130850128);
    }
  }
  
  public void z(int paramInt)
  {
    if (this.jdField_d_of_type_Biau == null) {
      this.jdField_d_of_type_Biau = new biau(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_Biau != null))
    {
      this.jdField_d_of_type_Biau.c(paramInt);
      if (!this.jdField_d_of_type_Biau.isShowing()) {
        this.jdField_d_of_type_Biau.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidp
 * JD-Core Version:    0.7.0.1
 */