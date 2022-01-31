import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.LruCache;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.confess.ConfessPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.16;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.25;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.26;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.27;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.3;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.32;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.38;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.39;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.8;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.9;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class aejb
  extends aebg
{
  acit jdField_a_of_type_Acit = new aekb(this);
  public aems a;
  aend jdField_a_of_type_Aend;
  aenh jdField_a_of_type_Aenh;
  public aenj a;
  aeof jdField_a_of_type_Aeof;
  public aeog a;
  aeoj jdField_a_of_type_Aeoj;
  ajey jdField_a_of_type_Ajey = new aejm(this);
  private final ajjh jdField_a_of_type_Ajjh = new aejd(this);
  protected ajmm a;
  ajrp jdField_a_of_type_Ajrp = new aejf(this);
  ajuc jdField_a_of_type_Ajuc = new aeje(this);
  ajuk jdField_a_of_type_Ajuk = new aejp(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler;
  public ScrollView a;
  public Toast a;
  axfi jdField_a_of_type_Axfi = new aeka(this);
  private ayjd jdField_a_of_type_Ayjd;
  protected ayqv a;
  private ayuu jdField_a_of_type_Ayuu;
  azig jdField_a_of_type_Azig;
  protected azoz a;
  protected azqt a;
  protected azro a;
  protected azrz a;
  protected ConfessPanel a;
  TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  private Observer jdField_a_of_type_JavaUtilObserver = new aejv(this);
  mnj jdField_a_of_type_Mnj;
  public mnk a;
  mrb jdField_a_of_type_Mrb;
  mre jdField_a_of_type_Mre = new aejo(this);
  wku jdField_a_of_type_Wku = null;
  boolean aa = false;
  boolean ab;
  boolean ac;
  public boolean ad;
  boolean ae = false;
  boolean af = false;
  protected boolean ag;
  boolean ah = false;
  boolean ai = true;
  public boolean aj = false;
  boolean ak = false;
  boolean al = false;
  public boolean am;
  private boolean an;
  private boolean ao;
  private boolean ap;
  aaed jdField_b_of_type_Aaed = new aekc(this);
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  public Handler b;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  Runnable jdField_b_of_type_JavaLangRunnable;
  protected List<aekg> b;
  public LinearLayout c;
  protected bafb c;
  Runnable c;
  public bafb d;
  private Runnable d;
  public volatile long h;
  String i;
  View o;
  View p;
  public int q;
  View q;
  protected int r;
  View r;
  public int s;
  protected int t = 0;
  public int u = 0;
  
  public aejb(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_r_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangRunnable = new TroopChatPie.3(this);
    this.jdField_b_of_type_AndroidOsHandler = new aejg(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_a_of_type_Ajmm = new aeju(this);
    this.jdField_d_of_type_JavaLangRunnable = new TroopChatPie.38(this);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
  }
  
  private void D(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "inputing @ in TroopChatPie.");
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localTroopInfo != null)
    {
      localObject1 = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localTroopInfo.troopuin, 3);
      ((Intent)localObject1).putExtra("param_is_pop_up_style", true);
      ((Intent)localObject1).setFlags(603979776);
      if (this.V)
      {
        ((Intent)localObject1).putExtra("param_chat_mode", 1);
        bool = H();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open TroopMemberListActivity, needfilterrobot:" + bool);
        }
        if (bool) {
          ((Intent)localObject1).putExtra("param_filter_robot", true);
        }
        if (super.f() == 21) {
          ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open TroopMemberListActivity to choose @ user target.");
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject1, 6001);
        if (paramInt != 1) {
          break label207;
        }
      }
    }
    label207:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      for (;;)
      {
        boolean bool;
        return;
        ((Intent)localObject1).putExtra("param_chat_mode", 0);
      }
      String str1 = "2";
      for (;;)
      {
        String str2;
        try
        {
          str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          if ((localTroopInfo.troopowneruin == null) || (!localTroopInfo.troopowneruin.equals(str2))) {
            break label303;
          }
          localObject1 = "0";
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, localTroopInfo.troopuin, "2", (String)localObject1, "");
          return;
        }
        catch (Exception localException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onTextChanged() has an exception.", localException);
        return;
        Object localObject2 = str1;
        if (localTroopInfo.Administrator != null)
        {
          localObject2 = str1;
          if (localTroopInfo.Administrator.contains(str2)) {
            localObject2 = "1";
          }
        }
      }
    }
    label303:
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onTextChanged(). troopInfo is null. while inputing @.  troopUin is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private boolean H()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    azks localazks = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    }
    if (localObject == null)
    {
      bool2 = bool1;
      return bool2;
    }
    localObject = (azef[])((Editable)localObject).getSpans(0, localObject.toString().length(), azef.class);
    int j = 0;
    for (;;)
    {
      bool1 = bool2;
      if (j < localObject.length)
      {
        if (localazks.b(localObject[j].a())) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "needFilterRobot : " + bool1);
        return bool1;
      }
      j += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clearBAFGrayTipSP troopUin=" + paramString1);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    paramString1 = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramString2, paramString1 });
    localSharedPreferences.edit().putLong(paramString1, 0L).apply();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool1;
    boolean bool2;
    label191:
    label255:
    do
    {
      return;
      azrx localazrx = (azrx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      String str = localazrx.a(paramString);
      bool1 = ((aqyr)a(33)).c();
      bool2 = ((acyj)a(43)).c();
      if ((!this.V) && (!bool1) && (!bool2) && (!TextUtils.isEmpty(str)))
      {
        if (this.t != 2)
        {
          A(2);
          if (paramBoolean)
          {
            if (localazrx.a(paramString) != 3) {
              break label191;
            }
            azzx.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { paramString });
          }
        }
        for (;;)
        {
          c(true);
          this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_Azro == null) {
            break label255;
          }
          this.jdField_a_of_type_Azro.a(paramString);
          if (!this.jdField_a_of_type_Azro.a()) {
            break;
          }
          this.jdField_a_of_type_Azro.d();
          v(true);
          return;
          new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        }
        v(false);
        return;
        v(false);
        return;
      }
    } while ((this.V) || (bool1) || (bool2));
    c(false);
    this.jdField_f_of_type_AndroidWidgetTextView.setText("");
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void bE()
  {
    ThreadManager.post(new TroopChatPie.7(this), 5, null, true);
  }
  
  private void bF()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, String.format("updateTroopHonorInteractiveIcon, troopUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
    }
    azce.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_f_of_type_AndroidWidgetImageView, this.L);
  }
  
  private void bG()
  {
    this.jdField_a_of_type_Ayjd = new aejq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayjd);
  }
  
  private void bH()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130845215));
    }
    for (;;)
    {
      awnu.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.mSystemBarComp, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
      return;
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101315), true);
    }
  }
  
  private void bI()
  {
    if ((azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (azzz.a(this.jdField_a_of_type_AndroidContentContext))) {}
    TroopManager localTroopManager;
    Intent localIntent;
    do
    {
      return;
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localIntent = new Intent();
      localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localTroopManager != null) && (localTroopManager.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b)));
    azlj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent.getExtras(), 1, 2000);
  }
  
  private void bJ()
  {
    if ((this.jdField_a_of_type_Azro != null) && (this.jdField_a_of_type_Azro.a()))
    {
      if (this.jdField_a_of_type_Azro.a() == 2)
      {
        c(false);
        A(0);
      }
    }
    else {
      return;
    }
    t(false);
  }
  
  private void bK()
  {
    if (A()) {
      return;
    }
    if (this.jdField_a_of_type_Aenh == null) {
      this.jdField_a_of_type_Aenh = new aenh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Aenh.a(this.jdField_a_of_type_Aeob);
  }
  
  private void bL()
  {
    if (this.ap) {
      return;
    }
    ((alxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.ap = true;
  }
  
  private void g(String paramString)
  {
    ThreadManager.postImmediately(new TroopChatPie.39(this, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString), null, true);
  }
  
  private void h(Intent paramIntent)
  {
    this.ap = false;
    String str = paramIntent.getStringExtra("uin");
    this.ae = ((alxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b(str, paramIntent);
  }
  
  private void v(boolean paramBoolean)
  {
    if ((!this.ao) && (!paramBoolean) && (this.t == 2)) {
      t(false);
    }
  }
  
  private void w(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public void A(int paramInt)
  {
    this.t = paramInt;
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "changeSubTitleType, not init ui");
      }
      return;
    }
    if (paramInt == 3)
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
    }
    if (paramInt == 4)
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
    }
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  void B(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, "", "");
      }
      return;
      localObject1 = "1";
      continue;
      localObject1 = "2";
      continue;
      localObject1 = "3";
      continue;
      localObject1 = "4";
      continue;
      localObject1 = "5";
      continue;
      localObject1 = "7";
    }
  }
  
  public void C(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
      ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, 0);
    }
  }
  
  public boolean E()
  {
    return false;
  }
  
  public void F()
  {
    super.F();
    bK();
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.ac = false;
    this.ab = false;
    if (this.jdField_a_of_type_Ayqv != null) {
      this.jdField_a_of_type_Ayqv.e();
    }
    if (this.N) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
    }
    for (;;)
    {
      return;
      if (this.ae) {
        bL();
      }
      ((acvo)a(34)).a();
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
      }
      if (this.jdField_a_of_type_Mnk != null)
      {
        this.jdField_a_of_type_Mnk.dismiss();
        this.jdField_a_of_type_Mnk = null;
      }
      if (this.jdField_a_of_type_Mrb != null) {
        this.jdField_a_of_type_Mrb.a();
      }
      mnf.a().b();
      if (this.V) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101315), true);
      }
      adsm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Wku != null)
      {
        this.jdField_a_of_type_Wku.dismiss();
        this.jdField_a_of_type_Wku = null;
      }
      if (this.jdField_a_of_type_Wmm != null) {
        this.jdField_a_of_type_Wmm = null;
      }
      Object localObject = (azhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      ((azhx)localObject).e("");
      if (((azhx)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((azhx)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      C(0);
      this.jdField_r_of_type_Int = 0;
      this.ah = false;
      this.aj = false;
      this.al = false;
      this.ak = false;
      localObject = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      ((azks)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g, "off");
      ((azks)localObject).a(null);
      ((sqd)sqg.a(5)).c();
      ((sqs)sqg.a(2)).d();
      ((vju)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(208)).a();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        akbm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      }
      if (this.jdField_a_of_type_Azro != null)
      {
        this.jdField_a_of_type_Azro.a();
        this.jdField_a_of_type_Azro = null;
      }
      A(0);
      if (this.jdField_a_of_type_Azoz != null) {
        this.jdField_a_of_type_Azoz.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = null;
      }
      super.G();
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
        }
      }
      azed.a().a();
      if (this.jdField_a_of_type_Azrz != null)
      {
        this.jdField_a_of_type_Azrz.b();
        this.jdField_a_of_type_Azrz = null;
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Bafb != null) && (this.jdField_d_of_type_Bafb.isShowing())) {
        this.jdField_d_of_type_Bafb.dismiss();
      }
      if (this.jdField_a_of_type_Ayuu != null) {
        this.jdField_a_of_type_Ayuu.b();
      }
      try
      {
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
        {
          this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
            {
              this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
              this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
            }
            adsh.jdField_a_of_type_JavaUtilHashMap.clear();
            adsh.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
            alyx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
            localObject = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
            BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.f();
            }
            this.ao = false;
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b(false);
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(false);
            }
            if (this.jdField_a_of_type_Acis != null) {
              this.jdField_a_of_type_Acis.a(null);
            }
            if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)) {
              break;
            }
            if (Build.VERSION.SDK_INT >= 16) {
              break label876;
            }
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
            this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
            return;
            localException1 = localException1;
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy unregisterReceiver, e:" + localException1.getMessage());
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy mConfessReceiver unregisterReceiver, e:" + localException2.getMessage());
              continue;
              label876:
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
            }
          }
        }
      }
    }
  }
  
  boolean G()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleTroopNotificationMsg");
    }
    if ((this.jdField_a_of_type_Azct != null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (azkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!azkm.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))))
    {
      ThreadManager.post(new TroopChatPie.27(this), 8, null, true);
      return true;
    }
    return false;
  }
  
  public void K()
  {
    if (this.V) {
      bH();
    }
    if (this.jdField_a_of_type_Azig != null)
    {
      azic.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azig);
      this.jdField_a_of_type_Azig = null;
    }
    if ((this.jdField_a_of_type_Wku == null) || (!this.jdField_a_of_type_Wku.isShowing()))
    {
      azfo localazfo = (azfo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if (localazfo != null) {
        localazfo.c();
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    if (this.jdField_a_of_type_Azqt != null) {
      this.jdField_a_of_type_Azqt.a();
    }
    if (azed.a().a()) {
      azed.a().b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    super.K();
  }
  
  public void L()
  {
    if (this.jdField_a_of_type_Azrz != null) {
      this.jdField_a_of_type_Azrz.a();
    }
    if (this.jdField_a_of_type_Ayqv != null) {
      this.jdField_a_of_type_Ayqv.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    super.L();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Wku == null) || (!this.jdField_a_of_type_Wku.isShowing()))
    {
      localObject = (azfo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if (localObject != null) {
        ((azfo)localObject).c();
      }
    }
    if (azed.a().a()) {
      azed.a().b();
    }
    Object localObject = (ayrg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
    ((ayrg)localObject).jdField_a_of_type_Int = 0;
    ((ayrg)localObject).b = 0;
    ((ayrg)localObject).c = 0;
    ((ayrg)localObject).d = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.af);
    }
  }
  
  public void M()
  {
    super.M();
    if (this.V)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130842947);
      mnf.a().a(this.jdField_a_of_type_Mnj);
      a(-16777216, false);
    }
    bt();
  }
  
  public void O()
  {
    super.O();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 2)
    {
      this.U = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
      if (this.U) {
        br();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    this.jdField_a_of_type_Ayqv = a();
    this.jdField_a_of_type_Ayqv.c();
    this.jdField_a_of_type_Ayqv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    alyx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_Azoz.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.e();
    }
  }
  
  public void P()
  {
    super.P();
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int j = localIntent.getIntExtra("uintype", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != j))) {}
    for (j = 1;; j = 0)
    {
      if ((j != 0) && (this.jdField_a_of_type_Azct != null))
      {
        this.jdField_a_of_type_Azct.b();
        this.jdField_a_of_type_Azct = null;
      }
      if ((j != 0) && (this.jdField_a_of_type_Ayuu != null) && (this.jdField_a_of_type_Ayuu.a != null))
      {
        this.jdField_a_of_type_Ayuu.a.b();
        this.jdField_a_of_type_Ayuu.a = null;
      }
      if (this.jdField_a_of_type_Azig != null)
      {
        azic.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azig);
        this.jdField_a_of_type_Azig = null;
      }
      this.jdField_i_of_type_Boolean = true;
      return;
    }
  }
  
  public void Q()
  {
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (this.jdField_a_of_type_Azpw != null)) {
      this.jdField_a_of_type_Azpw.c();
    }
    super.Q();
  }
  
  public void Z()
  {
    super.Z();
    ((acyj)a(43)).h();
  }
  
  public aeof a()
  {
    return this.jdField_a_of_type_Aeof;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 35)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = ((ConfessPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131492983, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;; localObject = super.a(paramInt))
    {
      if ((localObject instanceof PlusPanel)) {
        ((PlusPanel)localObject).setPagerChangedListener(new aejw(this));
      }
      return localObject;
    }
  }
  
  public ImageView a()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView;
  }
  
  public ayqv a()
  {
    if (this.jdField_a_of_type_Ayqv == null) {
      this.jdField_a_of_type_Ayqv = new ayqv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131298518));
    }
    return this.jdField_a_of_type_Ayqv;
  }
  
  public azqt a()
  {
    if (this.jdField_a_of_type_Azqt == null)
    {
      this.jdField_a_of_type_Azqt = new azqt();
      this.jdField_a_of_type_Azqt.a(this);
    }
    return this.jdField_a_of_type_Azqt;
  }
  
  public azrz a()
  {
    if (this.jdField_a_of_type_Azrz == null) {
      this.jdField_a_of_type_Azrz = new azrz(this.jdField_c_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_Azrz;
  }
  
  public PanelIconLinearLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  }
  
  public EntryModel a()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {}
    for (boolean bool = false;; bool = localTroopInfo.isAdmin()) {
      return new EntryModel(2, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, bool);
    }
  }
  
  public Boolean a()
  {
    if (this.V) {
      return new Boolean(false);
    }
    return null;
  }
  
  public String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int j = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(j + 1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "TroopChatPie";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "onPanelChanged updateAIOPanelTip. oldPanel=", Integer.valueOf(paramInt1), ", newPanel=", Integer.valueOf(paramInt2) });
    }
    b(false);
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      bJ();
    }
    if (this.jdField_a_of_type_Ayuu != null) {
      this.jdField_a_of_type_Ayuu.a();
    }
    if (paramInt1 == 35) {
      if (paramInt2 != 1) {
        break label117;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(bool);
      if (paramInt2 == 35) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.b();
      }
      super.a(paramInt1, paramInt2);
      return;
      label117:
      bool = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2000)
    {
      if ((this.jdField_a_of_type_Aeog != null) && (this.jdField_a_of_type_Aeog.a()) && (ariz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Aeob.a();
      }
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false))) {
        a().getIntent().putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      }
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (b(true))) {
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    label515:
    label728:
    do
    {
      for (;;)
      {
        super.a(paramInt1, paramInt2, paramIntent);
        return;
        Object localObject1 = aciy.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
        ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
        continue;
        localObject1 = paramIntent.getExtras().getString("troop_uin");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        String str2 = paramIntent.getExtras().getString("member_uin");
        String str1 = paramIntent.getExtras().getString("member_display_name");
        Object localObject2;
        int k;
        if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.jdField_a_of_type_Ajbx != null))
        {
          if (!"0".equals(str2))
          {
            localObject1 = null;
            if (!E()) {
              localObject1 = babh.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2);
            }
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = str1;
            }
            localObject1 = new StringBuilder("@").append((String)localObject2);
            this.jdField_a_of_type_Ajbx.a.peerUin = str2;
            this.jdField_a_of_type_Ajbx.a.atNickName = ((StringBuilder)localObject1).toString();
            this.jdField_a_of_type_Ajbx.a.inputText = axku.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
            a(this.jdField_a_of_type_Ajbx);
            j = 0;
            if (TextUtils.isEmpty(this.jdField_a_of_type_Ajbx.a.inputText))
            {
              k = 2;
              j = k;
              if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajbx.b))
              {
                if (this.jdField_a_of_type_Ajbx.d == 0) {
                  j = 6;
                }
              }
              else
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                k = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                str2 = "" + this.jdField_a_of_type_Ajbx.a.actionId;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajbx.b)) {
                  break label728;
                }
              }
            }
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_Ajbx.b)
            {
              bajr.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", str1, j, k, new String[] { str2, localObject1, this.jdField_a_of_type_Ajbx.a.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
              break;
              j = k;
              if (this.jdField_a_of_type_Ajbx.d != 1) {
                break label515;
              }
              j = 7;
              break label515;
              if (TextUtils.isEmpty(this.jdField_a_of_type_Ajbx.b))
              {
                j = 3;
                break label515;
              }
              if (this.jdField_a_of_type_Ajbx.d == 0)
              {
                j = 4;
                break label515;
              }
              if (this.jdField_a_of_type_Ajbx.d != 1) {
                break label515;
              }
              j = 5;
              break label515;
            }
          }
        }
        else
        {
          a(str2, str1, true, 4);
          continue;
          azkd.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          continue;
          ap();
          j = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
          if (j > 0)
          {
            k = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().charAt(j - 1);
            if ((k == 36) || (k == 65509) || (k == 165) || (k == 65284))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().delete(j - 1, j));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(j - 1);
              continue;
              if (this.jdField_a_of_type_Wmm != null)
              {
                localObject1 = this.jdField_a_of_type_Wmm.a();
                if (localObject1 != null)
                {
                  ((TroopGiftPanel)localObject1).a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
                  continue;
                  localObject1 = paramIntent.getStringExtra("result");
                  localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null) && (!((String)localObject1).equals(((TroopInfo)localObject2).troopname)))
                  {
                    ((ajex)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, false);
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((String)localObject1);
                    localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
                    ((Intent)localObject2).putExtra("uinname", (String)localObject1);
                    b((Intent)localObject2);
                    continue;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel != null)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(paramInt1, paramIntent);
                      continue;
                      if (paramInt2 == 8001)
                      {
                        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
                          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
                        }
                      }
                      else if (paramInt1 == 12005)
                      {
                        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                        if (localObject1 != null)
                        {
                          if (((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                            j = 0;
                          }
                          for (;;)
                          {
                            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, j + "", "", "");
                            break;
                            if (((TroopInfo)localObject1).isAdmin()) {
                              j = 1;
                            } else {
                              j = 2;
                            }
                          }
                        }
                      }
                      else if (paramInt2 == 0)
                      {
                        switch (paramInt1)
                        {
                        default: 
                          break;
                        case 6001: 
                          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l) {
                            BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
                          }
                          break;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
      for (int j = 2;; j = 1)
      {
        awqx.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", j, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
    }
    for (;;)
    {
      alyx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      break;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Mnk == null) {
      this.jdField_a_of_type_Mnk = new mnk(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Mnk.a(paramInt, paramString);
    this.jdField_a_of_type_Mnk.show();
    TroopChatPie.32 local32;
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.jdField_a_of_type_MqqOsMqqHandler;
      local32 = new TroopChatPie.32(this);
      if (!AppSetting.c) {
        break label82;
      }
    }
    label82:
    for (long l = 3000L;; l = 1000L)
    {
      paramString.postDelayed(local32, l);
      return;
    }
  }
  
  void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong1, paramLong2, new aejc(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
    }
    if ((this.jdField_c_of_type_Bafb != null) && (this.jdField_c_of_type_Bafb.isShowing())) {
      if ((paramLong == 1L) || (paramLong == 2L)) {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog, CreditLevelTipDialog isShowing:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
        }
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_Bafb.dismiss();
      if (paramLong == 1L)
      {
        this.jdField_c_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131654355)).setMessage(2131632082);
        this.jdField_c_of_type_Bafb.setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131625648), new aejh(this));
        this.jdField_c_of_type_Bafb.setNegativeButton(ajjy.a(2131649481), new aeji(this));
        this.jdField_c_of_type_Bafb.setPositiveButtonContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131625648));
        this.jdField_c_of_type_Bafb.setNegativeButtonContentDescription(ajjy.a(2131649479));
        this.jdField_c_of_type_Bafb.setCancelable(false);
        this.jdField_c_of_type_Bafb.show();
        new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }).a();
        return;
      }
      if ((paramLong == 2L) && (!paramBoolean))
      {
        this.jdField_c_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131654355)).setMessage(2131632081);
        this.jdField_c_of_type_Bafb.setPositiveButton(2131632079, new aejj(this));
        this.jdField_c_of_type_Bafb.setNegativeButton("", null);
        this.jdField_c_of_type_Bafb.setCancelable(false);
        this.jdField_c_of_type_Bafb.show();
        return;
      }
    } while ((paramLong != 2L) || (!paramBoolean));
    this.jdField_c_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131654355)).setMessage(2131632080);
    this.jdField_c_of_type_Bafb.setNegativeButton(2131632079, new aejk(this));
    this.jdField_c_of_type_Bafb.setPositiveButton(2131632078, new aejl(this));
    this.jdField_c_of_type_Bafb.setCancelable(false);
    this.jdField_c_of_type_Bafb.show();
  }
  
  public void a(aekg paramaekg)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramaekg);
  }
  
  public void a(Intent paramIntent)
  {
    A(0);
    if ((this.V) && (!mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      u(false);
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      this.p.setVisibility(8);
    }
    String str1;
    String str2;
    int j;
    for (;;)
    {
      if ((this.V) && (mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131624496) + mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      }
      super.a(paramIntent);
      str1 = paramIntent.getStringExtra("greetingsTitle");
      str2 = paramIntent.getStringExtra("greetingsContent");
      j = paramIntent.getIntExtra("types", 0);
      if (j == 1)
      {
        Object localObject1 = paramIntent.getStringExtra("greetingsMembers");
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            j = 0;
            for (;;)
            {
              if (j < ((JSONArray)localObject1).length())
              {
                Object localObject3 = ((JSONArray)localObject1).getString(j);
                String str3 = babh.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3);
                localObject3 = azef.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3, str3, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
                if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject3);
                }
                j += 1;
                continue;
                if (!mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                u(true);
                this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130842947);
                this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130842953);
                this.jdField_o_of_type_AndroidViewView.setVisibility(0);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "TroopChatPie send greetings.get members failed.");
            }
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (!TextUtils.isEmpty(str1))
      {
        localObject2 = (acxx)a(27);
        if (localObject2 != null) {
          ((acxx)localObject2).a("0", str2, str1);
        }
      }
      if (paramIntent.getBooleanExtra("sendGift", false)) {
        a(true, TroopGiftPanel.jdField_f_of_type_Int);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Acnx != null)) {
        this.jdField_a_of_type_Acnx.a();
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      ((acyj)a(43)).h();
      return;
      if (j == 2)
      {
        localObject2 = paramIntent.getStringExtra("greetingsName");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, "@" + (String)localObject2 + " ");
      }
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    int j = paramIntent.getIntExtra(baae.jdField_h_of_type_JavaLangString, -1);
    if (((j == 2) || (j == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131310824)
    {
      if (this.t == 2)
      {
        if (this.jdField_a_of_type_Azro == null) {
          this.jdField_a_of_type_Azro = new azro(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_a_of_type_Aymw);
        }
        this.jdField_a_of_type_Azro.a(a().jdField_a_of_type_JavaLangString);
        if (!this.jdField_a_of_type_Azro.b()) {}
      }
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Azro.a()) {
            break;
          }
          bJ();
        } while (this.jdField_a_of_type_Azro.b == 2);
        new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
        this.jdField_a_of_type_Azro.a(1);
        paramView = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
        if (paramView != null) {
          paramView.u(a().jdField_a_of_type_JavaLangString);
        }
        t(true);
        if (this.jdField_a_of_type_Azro.b == 2)
        {
          azzx.a("Grp_idol", "Grp_AIO", "clk_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
          return;
        }
        new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
        if (this.t == 3)
        {
          ((aqyr)a(33)).c();
          return;
        }
      } while (this.t != 4);
      ((acyj)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    bI();
  }
  
  void a(azjn paramazjn)
  {
    if (paramazjn.jdField_a_of_type_Boolean) {
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (8 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.jdField_f_of_type_Int != 1) || (this.m != 0)))
      {
        ai();
        if (this.jdField_h_of_type_AndroidWidgetTextView != null)
        {
          QLog.d("troop_gag", 1, "fightgag.updateGagStatus_UI:" + paramazjn.b);
          this.jdField_h_of_type_AndroidWidgetTextView.setText(paramazjn.b);
        }
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:" + paramazjn.jdField_a_of_type_Long + ", hasDestory=" + this.N);
        }
        if (!this.N)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramazjn.jdField_a_of_type_Long * 1000L);
        }
        this.jdField_i_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "updateGagStatus disable fastimage,  mAllowFastImage = " + this.jdField_i_of_type_Boolean);
        }
      }
    }
    do
    {
      return;
      this.ag = true;
      break;
      this.ag = false;
      bm();
      this.jdField_i_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "updateGagStatus enable fastimage,  mAllowFastImage = " + this.jdField_i_of_type_Boolean);
  }
  
  void a(azjn paramazjn, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (paramazjn == null) {
        ThreadManager.post(new TroopChatPie.16(this, paramBoolean), 8, null, true);
      }
    }
    else {
      return;
    }
    a(paramazjn);
  }
  
  public void a(Object paramObject)
  {
    aciy.n = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int k = ((Integer)paramObject).intValue();
    if (k == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    switch (k)
    {
    case 6: 
    case 7: 
    default: 
    case 3: 
    case 2: 
    case 4: 
    case 5: 
      for (;;)
      {
        B(k);
        super.a(paramObject);
        return;
        if (this.V)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          continue;
          if (this.V) {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
          if (this.X)
          {
            new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g }).a();
            continue;
            if (this.V)
            {
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              continue;
              if (this.V) {
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              }
            }
          }
        }
      }
    }
    if (!E()) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    if (this.jdField_a_of_type_Wmm == null) {
      this.jdField_a_of_type_Wmm = new wmm(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel);
    }
    wmm localwmm = this.jdField_a_of_type_Wmm;
    int m = TroopGiftPanel.e;
    if (mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    for (int j = 4;; j = 1)
    {
      localwmm.a(m, j);
      ayja.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(ayjf.a(c()));
      break;
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      j = 1;
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label130;
      }
    }
    long l2;
    int k;
    String str1;
    Object localObject;
    label130:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l2 = SystemClock.uptimeMillis();
      k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (j != 0) {
        break label482;
      }
      localObject = aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
      if (localObject != null) {
        break label136;
      }
      return;
      j = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool1;
    if (!baip.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
    }
    long l1 = ((MessageRecord)localObject).uniseq;
    axte.a.put(paramString, Long.valueOf(l2));
    if (!bool1)
    {
      awuc.a(paramString, false);
      awuc.a(paramString);
      label204:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + l1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!E) {
        break label567;
      }
    }
    label567:
    for (int j = 1;; j = 2)
    {
      awqx.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", j, 0, "", "", "", "8.2.6");
      E = true;
      j = a(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      ArrayList localArrayList = new ArrayList();
      String str2 = azef.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      azks localazks = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      boolean bool3 = false;
      boolean bool2 = bool3;
      if (this.X)
      {
        Iterator localIterator = localArrayList.iterator();
        do
        {
          bool2 = bool3;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!localazks.a(((MessageForText.AtTroopMemberInfo)localIterator.next()).uin));
        bool2 = true;
      }
      aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, str1, paramString, l1, false, paramInt2, paramRecorderParam.c, bool1, paramInt3, j, paramBoolean, paramRecorderParam.d, (Bundle)localObject, localArrayList, str2, bool2, paramInt4);
      b(paramInt1, paramInt2);
      a(0, paramString, l1);
      return;
      label482:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 0, paramLong);
      l1 = paramLong;
      if (!MessageForPtt.class.isInstance(localObject)) {
        break;
      }
      ((MessageForPtt)localObject).voiceLength = QQRecorder.a(paramInt2);
      l1 = paramLong;
      if (baip.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        break;
      }
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      l1 = paramLong;
      break;
      aucl.b(paramString);
      break label204;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    azks localazks = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if ((localazks.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localazks.b(paramString1)))
    {
      if (H()) {
        return;
      }
      this.g = paramString1;
      localazks.e = paramString1;
      this.jdField_h_of_type_JavaLangString = paramString2;
    }
    super.a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
    super.a(paramList, paramCharSequence, paramInt);
    if ((0xFFFF & paramInt) == 4)
    {
      ((aymm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(225)).a(paramList);
      if (this.jdField_a_of_type_Aymw != null) {
        this.jdField_a_of_type_Aymw.a().f();
      }
    }
  }
  
  void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = a();
    } while ((TextUtils.isEmpty(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString)) || (paramObject == null));
    for (;;)
    {
      int j;
      try
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        if (Long.parseLong(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString) != l) {
          break;
        }
        localObject1 = (TroopMemberCard)paramObject[2];
        j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
        if (j > k) {
          break label425;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(j);
        if (!(localObject2 instanceof MessageForQQWalletTips)) {
          break label549;
        }
        localObject2 = (MessageForQQWalletTips)localObject2;
        if ((((MessageForQQWalletTips)localObject2).istroop != 1) || (localObject1 == null) || (!((MessageForQQWalletTips)localObject2).memberUin.equals(String.valueOf(((TroopMemberCard)localObject1).memberUin))) || (!((MessageForQQWalletTips)localObject2).frienduin.equals(String.valueOf(l))) || ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52) == null)) {
          break label549;
        }
        Object localObject3 = ((TroopMemberCard)localObject1).nick;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handGetTroopMemberCard troopUin=" + ((MessageForQQWalletTips)localObject2).frienduin + ", memberUin=" + ((MessageForQQWalletTips)localObject2).memberUin + ",card=" + ((TroopMemberCard)localObject1).card + ",remark=" + ((TroopMemberCard)localObject1).remark + ",nick=" + ((TroopMemberCard)localObject1).nick + ",saveTroopMemberEx succ=" + true);
        }
        localObject3 = aciy.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, j);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handGetTroopMemberCard ref itemView=" + localObject3 + ",index=" + j);
        }
        if (localObject3 == null) {
          break label549;
        }
        localObject3 = (TextView)((View)localObject3).findViewById(2131301543);
        ((MessageForQQWalletTips)localObject2).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TextView)localObject3);
      }
      catch (Throwable paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 2, "handGetTroopMemberCard e=" + paramObject);
      return;
      label425:
      if ((localObject1 == null) || (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(((TroopMemberCard)localObject1).memberUin)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "handleGetTroopMemberCard. memberUin = ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      }
      if ((this.jdField_a_of_type_Ayuu != null) && ((this.jdField_a_of_type_Ayuu.a instanceof azco)))
      {
        localObject1 = (azco)this.jdField_a_of_type_Ayuu.a;
        if (((Boolean)paramObject[3]).booleanValue()) {
          break label544;
        }
      }
      label544:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((azco)localObject1).a(paramBoolean, null, this);
        bK();
        return;
      }
      label549:
      j += 1;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return super.a(paramInt, paramView, paramListView);
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!this.am)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (j > k) {}
      for (;;)
      {
        bool2 = bool1;
        if (j < k) {
          break label197;
        }
        bool2 = bool1;
        if (j > m) {
          break label197;
        }
        try
        {
          Object localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(j);
          if ((localObject == null) || (((ChatMessage)localObject).msgtype != -1012)) {
            break;
          }
          localObject = ((ChatMessage)localObject).getExtInfoFromExtStr("troop_new_member_uin");
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isNewMemberGrayTipVisible newMemberUin = " + (String)localObject + ",detect memberUin = " + paramString);
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          bool2 = ((String)localObject).equals(paramString);
          if (!bool2) {
            break;
          }
          bool1 = true;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          for (;;)
          {
            localIndexOutOfBoundsException.printStackTrace();
          }
        }
        j += 1;
        continue;
        j = k;
      }
    }
    label197:
    return bool2;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewViewGroup == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "mAIORootView == null");
      ChatFragment localChatFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment();
      if (localChatFragment != null) {
        this.jdField_c_of_type_AndroidViewViewGroup = localChatFragment.a;
      }
    }
    super.a(paramBoolean);
    C(1);
    azed.a().a(this);
    this.jdField_a_of_type_Azoz = new azoz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    bbzo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), true);
    return true;
  }
  
  public void aU()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  public void aZ()
  {
    super.aZ();
    bJ();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    paramEditable = (acxx)a(27);
    if (paramEditable != null) {
      paramEditable.b();
    }
  }
  
  public void ag()
  {
    bo();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      if (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
        a(0L, 0L);
      }
      if (amit.c().mIsEnable)
      {
        localObject = (ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        if (!localTroopManager.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label527;
        }
        ((ajrm)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        QLog.e("vip_pretty.", 1, "get the troop expired info from server");
      }
    }
    if ((localTroopInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "aio onShow:" + localTroopInfo.troopuin + ", sysFlag=" + localTroopInfo.cGroupRankSysFlag + ", userFlag=" + localTroopInfo.cGroupRankUserFlag);
    }
    super.ag();
    if (this.aa == true)
    {
      ThreadManager.post(new TroopChatPie.8(this), 1, null, true);
      this.aa = false;
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("forward_type")) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(((Bundle)localObject).getString("uin")))) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new TroopChatPie.9(this, bool), 8, null, true);
      if ((!this.al) && (localTroopManager.a.jdField_a_of_type_Boolean) && (localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        int j = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((j < 3) && (localTroopInfo.wMemberMax < 2000) && (localTroopInfo.wMemberNum >= 500))
        {
          if (this.jdField_a_of_type_Aeoj == null)
          {
            this.jdField_a_of_type_Aeoj = new aeoj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Aeob);
            this.jdField_a_of_type_Aeob.a(this.jdField_a_of_type_Aeoj);
          }
          this.jdField_a_of_type_Aeoj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Aeob.a(this.jdField_a_of_type_Aeoj, new Object[0]))
          {
            this.al = true;
            localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, j + 1);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
      return;
      label527:
      if (QLog.isColorLevel()) {
        QLog.d("vip_pretty.", 1, "get the troop expired info from local");
      }
      TroopManager.a(localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Aeob);
      break;
    }
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajey);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajrp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuk);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axfi);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aket);
    }
    bG();
    ((aqae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajey);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajrp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuk);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axfi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayjd);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Aket);
    }
    ((aqae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void ao_()
  {
    super.ao_();
    if ((this.jdField_a_of_type_Aymw != null) && (!D())) {
      this.jdField_a_of_type_Aymw.a().e();
    }
  }
  
  public void aq()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clickSendTextButton. isSending:" + this.Z);
    }
    if (!this.Z) {
      this.Z = true;
    }
    for (int j = 1;; j = 0)
    {
      super.aq();
      if (j == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clickSendTextButton process talking state");
      }
      azks localazks = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      boolean bool2 = localazks.a();
      Object localObject = localazks.b;
      String str1 = localazks.c;
      ArrayList localArrayList = new ArrayList();
      String str2 = azef.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      j = 0;
      label261:
      boolean bool3;
      if (j < localArrayList.size())
      {
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(j);
        if (localazks.a(localAtTroopMemberInfo.uin))
        {
          localObject = "" + localAtTroopMemberInfo.uin;
          str1 = babh.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
          if ((bool2) || (localazks.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            bool1 = true;
            bool3 = localazks.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            bool2 = bool1;
          }
        }
      }
      for (boolean bool1 = bool3;; bool1 = false)
      {
        if ((bool2) && (!bool1))
        {
          localObject = azef.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
          a(localazks.b, localazks.c, true, 0);
        }
        for (;;)
        {
          this.Z = false;
          return;
          bool1 = false;
          break label261;
          j += 1;
          break;
          adta.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((str2 == null) || (str2.length() <= 3478)) {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
          }
          if (this.X)
          {
            w(false);
            localObject = (acyp)a(23);
            if (localObject != null) {
              ((acyp)localObject).a(false);
            }
          }
          this.Y = false;
          localazks.a();
        }
      }
    }
  }
  
  public RelativeLayout b()
  {
    return this.jdField_d_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    bF();
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.ag)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131631942, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      ai();
      bool = true;
    }
    return bool;
  }
  
  public void bA()
  {
    if ((this.jdField_c_of_type_Bbms != null) && (this.jdField_c_of_type_Bbms.isShowing()) && (!a().isFinishing())) {
      this.jdField_c_of_type_Bbms.dismiss();
    }
  }
  
  protected void bB()
  {
    Object localObject1 = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Object localObject2;
    String str1;
    int j;
    boolean bool;
    if (((azks)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (!this.Z)
      {
        localObject2 = (azef[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString().length(), azef.class);
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        j = 0;
        if (j >= localObject2.length) {
          break label439;
        }
        if (!((azks)localObject1).b(localObject2[j].a())) {
          break label247;
        }
        String str2 = localObject2[j].a();
        this.g = str2;
        ((azks)localObject1).e = str2;
        this.jdField_h_of_type_JavaLangString = localObject2[j].b();
        if (!this.jdField_h_of_type_JavaLangString.startsWith("@")) {
          break label434;
        }
        this.jdField_h_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString.substring(1);
        bool = true;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a().equals(this.g))) {
        bool = false;
      }
      for (;;)
      {
        ((acyf)a(29)).d(bool);
        if (this.Y == bool) {
          if (bool)
          {
            localObject1 = (acyp)a(23);
            if (localObject1 != null) {
              ((acyp)localObject1).b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
            }
          }
        }
        label247:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                j += 1;
                break;
                this.Y = bool;
                if (bool) {
                  break label364;
                }
                w(false);
                localObject2 = (acyp)a(23);
                if (localObject2 != null) {
                  ((acyp)localObject2).a(false);
                }
              } while (!((azks)localObject1).a());
              ((azks)localObject1).a();
              azks.a("panel", "talk_out", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(), "2", "");
              ((azks)localObject1).b(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), Long.parseLong(this.g), "off", new aejx(this));
              return;
            } while (this.X);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(str1, this.g, this.jdField_h_of_type_JavaLangString, this, new aejy(this));
            return;
          } while (!this.X);
          w(false);
          localObject1 = (acyp)a(23);
        } while (localObject1 == null);
        label364:
        ((acyp)localObject1).a(false);
        return;
      }
      label434:
      bool = true;
      continue;
      label439:
      bool = false;
    }
  }
  
  protected void bC()
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299666));
    }
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (((TroopInfo)localObject).wMemberNumClient <= 0))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        if (localObject != null) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showNewTroopMemberCount count smaller than 0" + ((TroopInfo)localObject).wMemberNumClient);
        }
      }
      else {
        return;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showNewTroopMemberCount info is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showNewTroopMemberCount wMemberNumClient:" + ((TroopInfo)localObject).wMemberNumClient + "  wMemberNum:" + ((TroopInfo)localObject).wMemberNum + " troopUin:" + ((TroopInfo)localObject).troopuin);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject).wMemberNumClient) }));
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (this.l) {
          break label284;
        }
      }
    }
    label284:
    for (boolean bool = true;; bool = false)
    {
      ((NavBarAIO)localObject).a(bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      return;
    }
  }
  
  public void bD()
  {
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Object localObject = (aqyr)a(33);
    boolean bool1 = ((aqyr)localObject).c();
    boolean bool2 = ((aqyr)localObject).d();
    acyj localacyj = (acyj)a(43);
    boolean bool3 = localacyj.c();
    int j;
    if (bool1)
    {
      A(3);
      c(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(((aqyr)localObject).a(bool2));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
      t(bool2);
      j = aciy.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
      aqyg.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, j, 0, 0);
    }
    label147:
    while ((QLog.isColorLevel()) && (QLog.isColorLevel()))
    {
      QLog.d("BaseListenTogetherPanel_Troop", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
      return;
      if (bool3)
      {
        bool3 = localacyj.a();
        A(4);
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localacyj.a());
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
        t(bool3);
        j = aciy.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        aqyg.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, j, 0, 0);
      }
      else
      {
        localObject = ((azrx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a(a().jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label380;
        }
        A(2);
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        v(false);
      }
    }
    for (;;)
    {
      aqyg.a(this.jdField_b_of_type_AndroidViewViewGroup);
      break label147;
      break;
      label380:
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      A(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((acvo)a(34)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  void bn()
  {
    boolean bool = false;
    super.bn();
    if (this.jdField_a_of_type_Azig == null)
    {
      aekh localaekh = new aekh(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Azig = new azig(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localaekh, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    azic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azig);
    b(false);
    if (this.V != mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (!this.V) {
        bool = true;
      }
      this.V = bool;
      u(this.V);
    }
    ((azhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void bo()
  {
    super.bo();
    this.u = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ThreadManager.post(new TroopChatPie.25(this), 8, null, true);
    bu();
    Object localObject = new TroopChatPie.26(this);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    int j;
    if (localObject != null)
    {
      String str1 = ((Intent)localObject).getStringExtra("at_member_name");
      String str2 = ((Intent)localObject).getStringExtra("at_member_uin");
      j = ((Intent)localObject).getIntExtra("at_member_source", 0);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        a(str2, str1, false, j);
      }
    }
    if ((!this.ah) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      if (!BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).getBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false)) {}
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        azkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, l1, l1, l2, "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, true, false);
        wku.b("http://gdynamic.qpic.cn/gdynamic/");
        bool1 = false;
      }
      catch (Exception localException)
      {
        boolean bool2;
        localException.printStackTrace();
        bool1 = false;
        continue;
      }
      if (!bool1)
      {
        if ((this.jdField_a_of_type_Wku != null) && (this.jdField_a_of_type_Wku.isShowing()))
        {
          bool1 = true;
          bool2 = false;
          localObject = (azfo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
          if (localObject != null) {
            bool2 = ((azfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
          if ((localObject != null) && (bool2) && (bool1)) {
            ((azfo)localObject).b = false;
          }
          if ((!bool1) && (bool2))
          {
            azfo.jdField_a_of_type_Boolean = true;
            o(true);
          }
          localObject = aqyr.a(this);
          if (localObject != null)
          {
            if ((bool1) || (bool2))
            {
              bool1 = true;
              ((aqyr)localObject).a(bool1);
            }
          }
          else
          {
            this.ai = false;
            if (!this.ah)
            {
              if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != null) {
                break label664;
              }
              j = 1;
              if (j == 0) {
                break label669;
              }
              if (QLog.isColorLevel()) {
                QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
              }
              this.jdField_a_of_type_Mrb.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Mre, true);
            }
            ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
            ThreadManager.getSubThreadHandler().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 500L);
            bC();
            this.ah = true;
            if ((this.ad) && (this.jdField_a_of_type_Ayuu != null))
            {
              this.jdField_a_of_type_Ayuu.a(true);
              this.ad = false;
            }
            localObject = (ayrg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
            if ((((ayrg)localObject).jdField_a_of_type_Int != 0) && (!mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!awnu.b()))
            {
              ((ayrg)localObject).a(new ayre(((ayrg)localObject).e, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((ayrg)localObject).b, ((ayrg)localObject).c, ((ayrg)localObject).d, ((ayrg)localObject).jdField_a_of_type_Int));
              localObject = a();
              ((ayqv)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              ((ayqv)localObject).a();
            }
            return;
            bool1 = G();
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        bool1 = false;
        continue;
        label664:
        j = 0;
        continue;
        label669:
        if (QLog.isColorLevel()) {
          QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
        }
        azhh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      else
      {
        continue;
        bool1 = false;
      }
    }
  }
  
  protected void br()
  {
    g(true);
    TroopChatPie.2 local2 = new TroopChatPie.2(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, local2, 9);
  }
  
  void bs()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.post(this.jdField_c_of_type_JavaLangRunnable, 8, null, true);
    }
  }
  
  protected void bt()
  {
    boolean bool3 = false;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject = null;
    if (localTroopManager != null) {
      localObject = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, troopInfo==null:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    long l;
    do
    {
      return;
      l = ((TroopInfo)localObject).troopCreditLevel;
      if ((l == 1L) || (l == 2L)) {
        break;
      }
      if ((this.jdField_c_of_type_Bafb != null) && (this.jdField_c_of_type_Bafb.isShowing())) {
        this.jdField_c_of_type_Bafb.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, normal:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + l);
    return;
    boolean bool1;
    if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
    {
      bool1 = true;
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
        break label362;
      }
    }
    label362:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bool1) || (bool2)) {
        bool3 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + bool1 + ", " + bool2);
      }
      localObject = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, getTroopCreditInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ((ajtg)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      a(l, bool3);
      return;
      bool1 = false;
      break;
    }
  }
  
  void bu()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject != null) {
        break label29;
      }
    }
    label29:
    do
    {
      for (;;)
      {
        return;
        localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && ((((TroopInfo)localObject).wMemberNum == 0) || (TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)))) {
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l));
            ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getTroopInfoIfNeed failed");
  }
  
  public void bv()
  {
    ajtg localajtg = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localajtg != null) {}
    try
    {
      localajtg.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, localException.toString());
    }
  }
  
  void bw()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground() != null) {
      n();
    }
    bH();
    this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849303);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101254));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101254));
      aciy.a(this.jdField_a_of_type_AndroidWidgetImageView, 2130849311);
      if ((this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_f_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_f_of_type_AndroidWidgetTextView.getText().toString().startsWith(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131624496))))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText("");
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
        c(false);
      }
      azrx localazrx = (azrx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      String str = localazrx.a(a().jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(str)) {
        break label612;
      }
      A(2);
      if (localazrx.a(a().jdField_a_of_type_JavaLangString) != 3) {
        break label554;
      }
      azzx.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
      label304:
      c(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257));
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      v(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.b = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(false);
      }
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      this.p.setVisibility(8);
      mnf.a().b();
      bz();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131099800));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        aciy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130848577);
      }
      bx();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      ((acyj)a(43)).g();
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849304);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101254));
      break;
      label554:
      new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
      break label304;
      label612:
      A(0);
    }
  }
  
  public void bx()
  {
    if (this.jdField_a_of_type_Aeob != null)
    {
      aipq localaipq = aipq.a();
      if (localaipq != null) {
        localaipq.f();
      }
    }
  }
  
  public void by()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new aejs(this));
    if ((this.jdField_r_of_type_AndroidViewView != null) && (this.q != null))
    {
      this.jdField_r_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      this.q.startAnimation(localAlphaAnimation);
    }
  }
  
  public void bz()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new aejt(this));
    this.jdField_r_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    this.q.startAnimation(localAlphaAnimation);
  }
  
  public void c()
  {
    if (b(true)) {
      return;
    }
    azks localazks = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    boolean bool2 = localazks.a();
    Object localObject = localazks.b;
    String str1 = localazks.c;
    this.Z = true;
    ArrayList localArrayList = new ArrayList();
    String str2 = azef.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    int j = 0;
    label198:
    boolean bool3;
    if (j < localArrayList.size())
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(j);
      if (localazks.a(localAtTroopMemberInfo.uin))
      {
        localObject = "" + localAtTroopMemberInfo.uin;
        str1 = babh.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
        if ((bool2) || (localazks.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          bool1 = true;
          bool3 = localazks.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          bool2 = bool1;
        }
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      super.c();
      if ((bool2) && (!bool1))
      {
        localObject = azef.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
        a(localazks.b, localazks.c, true, 0);
      }
      for (;;)
      {
        this.Z = false;
        return;
        bool1 = false;
        break label198;
        j += 1;
        break;
        adta.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((str2 == null) || (str2.length() <= 3478)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        }
        if (this.X)
        {
          w(false);
          localObject = (acyp)a(23);
          if (localObject != null) {
            ((acyp)localObject).a(false);
          }
        }
        this.Y = false;
        localazks.a();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    if (paramInt2 == 8) {
      if (!this.V) {}
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (this.V)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(0);
      }
      return;
      if (!this.V) {}
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    aU();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    baio.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.jdField_r_of_type_Int = 2;
    baio.a("AIO_updateSession_business", null);
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.V) {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130842973);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(mnf.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(mnf.c);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849304);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(mnf.c);
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849303);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101254));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101254));
        return;
      }
    } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849304);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101254));
  }
  
  public void f(String paramString)
  {
    if (a().isFinishing()) {}
    do
    {
      return;
      if (this.jdField_c_of_type_Bbms == null) {
        this.jdField_c_of_type_Bbms = new bbms(a(), a().getTitleBarHeight());
      }
      this.jdField_c_of_type_Bbms.a(paramString);
    } while ((a().isFinishing()) || (this.jdField_c_of_type_Bbms.isShowing()));
    this.jdField_c_of_type_Bbms.show();
  }
  
  public void f(boolean paramBoolean)
  {
    if (azed.a().a()) {
      azed.a().b();
    }
    if (this.ae) {
      bL();
    }
    super.f(paramBoolean);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int j;
    long l1;
    long l2;
    long l3;
    while ((paramMessage.what == 60) && (this.V))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130842947);
      return true;
      if ((this.jdField_a_of_type_Wku != null) && (this.jdField_a_of_type_Wku.isShowing())) {
        this.jdField_a_of_type_Wku.dismiss();
      }
      this.jdField_a_of_type_Wku = new wku(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Azct, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      Object localObject = new int[2];
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
      j = a();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationInWindow(arrayOfInt);
      int k = arrayOfInt[1];
      int m = localObject[1];
      this.jdField_a_of_type_Wku.a(j, k - m);
      this.jdField_a_of_type_Wku.a(paramMessage.arg1);
      continue;
      if ((this.jdField_a_of_type_Aymw != null) && (this.jdField_a_of_type_Aymw.b()))
      {
        localObject = this.jdField_a_of_type_Aymw.a();
        if (((aymq)localObject).a.get())
        {
          ((aymq)localObject).a.set(false);
          continue;
          j = paramMessage.arg1;
          localObject = this.j;
          if (j == 0) {}
          for (j = 8;; j = 0)
          {
            ((ImageView)localObject).setVisibility(j);
            break;
          }
          localObject = (List)paramMessage.obj;
          if (localObject != null)
          {
            l1 = ((Long)((List)localObject).get(0)).longValue();
            l2 = ((Long)((List)localObject).get(1)).longValue();
            l3 = ((Long)((List)localObject).get(2)).longValue();
          }
        }
      }
    }
    for (;;)
    {
      long l4;
      long l5;
      try
      {
        l4 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        l5 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        if (l4 != l1) {
          break label471;
        }
        if (l2 == l5) {
          break label611;
        }
        if (l3 != l5) {
          break label471;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e(".troop.chat_pie_msg", 1, "MSG_TROOP_ADMIN_OPERATION_NOTIFY: groupUin error", localNumberFormatException);
      }
      if (j != 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: will reload plusPanel, groupUin:", Long.valueOf(l1) });
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
          break;
          break;
          label471:
          j = 0;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: should reload plusPanel, but mPlusPanel == null, groupUin:", Long.valueOf(l1) });
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition not match: group:", Long.valueOf(l1), "/", Long.valueOf(l4), " uin1/uin2/current: ", Long.valueOf(l2), "/", Long.valueOf(l3), "/", Long.valueOf(l5) });
      break;
      return super.handleMessage(paramMessage);
      label611:
      j = 1;
    }
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_Mrb = new mrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    this.aa = true;
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    ariz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    if (this.jdField_a_of_type_Acis != null) {
      this.jdField_a_of_type_Acis.a(this.jdField_a_of_type_Acit);
    }
    this.jdField_a_of_type_Aaed = this.jdField_b_of_type_Aaed;
    ThreadManager.post(new TroopChatPie.1(this), 2, null, true);
    int j;
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if (!((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label327;
        }
        j = 1;
      }
    }
    for (;;)
    {
      new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(j) }).a();
      if (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)
      {
        this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aekf(this, null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.an = false;
      ((acyp)a(23)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
      label327:
      if (((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        j = 2;
      } else {
        j = 3;
      }
    }
  }
  
  public boolean i()
  {
    if (((acvo)a(34)).a()) {
      return true;
    }
    if (((acyj)a(43)).d()) {
      return true;
    }
    if (this.jdField_a_of_type_Aymw != null) {
      this.jdField_a_of_type_Aymw.a();
    }
    if (azed.a().a()) {
      azed.a().b();
    }
    if (this.jdField_a_of_type_Aeog != null) {
      this.jdField_a_of_type_Aeog.a();
    }
    if (this.jdField_a_of_type_Ayuu != null) {
      this.jdField_a_of_type_Ayuu.c();
    }
    if (this.ae) {
      bL();
    }
    return super.i();
  }
  
  public void j()
  {
    super.j();
    if ((this.jdField_a_of_type_Aymw.d()) && ((this.jdField_a_of_type_Aymw.b() == 17) || (this.jdField_a_of_type_Aymw.b() == 100) || (this.jdField_a_of_type_Aymw.b() == 11))) {
      return;
    }
    this.jdField_a_of_type_Aeog = new aeog(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeob, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aymw, this.jdField_a_of_type_AndroidWidgetToast);
    this.jdField_a_of_type_Aeob.a(this.jdField_a_of_type_Aeog);
    this.jdField_a_of_type_Aend = new aend(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeob, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Aeob.a(this.jdField_a_of_type_Aend);
    this.jdField_a_of_type_Aeof = new aeof(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aeob, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Aeob.a(this.jdField_a_of_type_Aeof);
  }
  
  public void j(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.m = paramInt;
      if (!this.ag) {
        break label135;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      baan.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), false);
      b(true);
    }
    label135:
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711686);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  public void n(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopUin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject3 = null;
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "avType : " + ((ldb)localObject1).jdField_a_of_type_Int);
        }
        if (((ldb)localObject1).jdField_a_of_type_Int != 2) {
          break label886;
        }
        if (((ldb)localObject1).jdField_a_of_type_Boolean)
        {
          awqx.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
        }
      }
      else
      {
        bE();
        if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
          break label998;
        }
        this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView = new aejz(this, this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setScrollbarFadingEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalScrollBarEnabled(false);
        this.jdField_s_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        localObject1 = new RelativeLayout.LayoutParams(-1, this.jdField_s_of_type_Int);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = azvv.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, -1, this.jdField_s_of_type_Int);
        localObject1 = (ayrg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
        this.jdField_a_of_type_Ayqv = a();
        ((ayrg)localObject1).jdField_a_of_type_Int = 0;
        ((ayrg)localObject1).b = 0;
        ((ayrg)localObject1).c = 0;
        ((ayrg)localObject1).d = 0;
        if (!awnu.b()) {
          ((ayrg)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_Ayuu == null) {
          this.jdField_a_of_type_Ayuu = ((ayuu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(289));
        }
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Ayuu.a(((TroopInfo)localObject1).dwGroupClassExt, true, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.af = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(((TroopInfo)localObject1).troopowneruin);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.af + ",troopInfo = " + localObject1);
        }
        if ((alyx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)) {
          this.jdField_b_of_type_AndroidContentBroadcastReceiver = new aekd(this);
        }
      }
    }
    catch (Exception localException2)
    {
      try
      {
        localObject1 = new IntentFilter();
        ((IntentFilter)localObject1).addAction("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
        if (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          new ayzm(this.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
          if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
            this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aeke(this);
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            Object localObject1 = new IntentFilter();
            ((IntentFilter)localObject1).addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1, "com.tencent.msg.permission.pushnotify", null);
            azco.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if (!((amgf)alzw.a().a(553)).jdField_a_of_type_Boolean)
            {
              this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
            }
            bK();
            localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
            this.ae = ((Intent)localObject1).getBooleanExtra("open_chat_from_group_rec_confess", false);
            if (this.ae)
            {
              h((Intent)localObject1);
              g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.k = this.ae;
            v(false);
            super.n(paramInt);
            return;
            localException1 = localException1;
            Object localObject2 = localObject3;
            label998:
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onShowFirst : invalid uin!");
              localObject2 = localObject3;
              continue;
              awqx.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
              continue;
              label886:
              if (((ldb)localObject2).jdField_a_of_type_Int == 10)
              {
                if (((ldb)localObject2).jdField_a_of_type_Boolean) {
                  awqx.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
                }
                for (;;)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
                  break;
                  awqx.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
                }
                this.jdField_s_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
                localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject2).height = this.jdField_s_of_type_Int;
                ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
                this.jdField_a_of_type_AndroidWidgetScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
                this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, -1, this.jdField_s_of_type_Int);
              }
            }
          }
          localException2 = localException2;
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "register mConfessReceiver receiver exception.");
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "register homework receiver exception.");
          }
        }
      }
    }
  }
  
  public void n(boolean paramBoolean)
  {
    if (baig.m(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      a(paramBoolean, TroopGiftPanel.jdField_f_of_type_Int);
      baig.j(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      return;
    }
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131301272) && (b(true))) {}
    do
    {
      do
      {
        return;
        super.onClick(paramView);
        if (paramView.getId() != 2131304841) {
          break;
        }
      } while ((this.jdField_a_of_type_Aeog == null) || (!this.jdField_a_of_type_Aeog.a()));
      this.jdField_a_of_type_Aeob.a();
      return;
      if (paramView.getId() == 2131304839)
      {
        bJ();
        return;
      }
    } while ((paramView.getId() != 2131302816) || (this.j == null) || (this.j.getVisibility() != 0));
    azot.a(this.j).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_Aymw != null) {
      this.jdField_a_of_type_Aymw.a().a(paramInt, 500L);
    }
    if (paramInt == 2) {
      bJ();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "scrollState = " + paramInt);
    }
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.am = bool;
      paramAbsListView = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramAbsListView.hasNext()) {
        ((aekg)paramAbsListView.next()).a(this.am);
      }
    }
    if ((paramInt == 0) && (this.jdField_i_of_type_JavaLangString != null))
    {
      paramAbsListView = ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a();
      this.jdField_i_of_type_JavaLangString = null;
      paramAbsListView.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l = true;
      D(1);
    }
    label292:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, " onTextChanged:  start=" + paramInt1 + " before=" + paramInt2 + " count=" + paramInt3);
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() == 0));
        if ((paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '$') && (paramCharSequence.charAt(paramInt1) != 65509) && (paramCharSequence.charAt(paramInt1) != '¥') && (paramCharSequence.charAt(paramInt1) != 65284)) || (this.jdField_s_of_type_Boolean) || (((acxx)a(27)).jdField_a_of_type_Boolean)) {
          break;
        }
      } while (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= paramCharSequence.length()) {
          break label292;
        }
        if ((paramInt2 != paramInt1) && ((paramCharSequence.charAt(paramInt2) == '$') || (paramCharSequence.charAt(paramInt2) == 65509) || (paramCharSequence.charAt(paramInt2) == '¥') || (paramCharSequence.charAt(paramInt2) == 65284))) {
          break;
        }
        paramInt2 += 1;
      }
      paramCharSequence = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((paramCharSequence == null) || (!TroopInfo.hasPayPrivilege(paramCharSequence.troopPrivilegeFlag, 32)));
    if (paramCharSequence.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      paramInt1 = 0;
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, paramCharSequence.troopuin + "", paramInt1 + "", "", "");
      azkd.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramCharSequence.troopuin, "input", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if (paramCharSequence.isAdmin()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
    if ((!this.jdField_s_of_type_Boolean) && (!((acxx)a(27)).jdField_a_of_type_Boolean)) {
      ((acvo)a(34)).b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    bB();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Wmm != null) && (this.jdField_a_of_type_Wmm.a()))
    {
      this.jdField_a_of_type_Wmm.a();
      aisc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_gift_panel", false);
    }
    if ((paramView.getId() == 2131303604) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void r()
  {
    super.r();
    alyx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public void s()
  {
    aU();
    ((acyj)a(43)).h();
  }
  
  public void t(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_h_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = vms.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = vms.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    try
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      int j;
      if (paramBoolean)
      {
        j = 2130843181;
        localObject = ((Resources)localObject).getDrawable(j);
        if ((!awnu.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label185;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257), PorterDuff.Mode.MULTIPLY);
        label114:
        if (!paramBoolean) {
          break label217;
        }
        Drawable localDrawable = this.jdField_h_of_type_AndroidWidgetImageView.getDrawable();
        if ((localDrawable instanceof AnimationDrawable)) {
          ((AnimationDrawable)localDrawable).stop();
        }
        ((Drawable)localObject).setBounds(0, 0, vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      label185:
      label217:
      do
      {
        return;
        j = 2130843188;
        break;
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label114;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label114;
        if ((Build.VERSION.SDK_INT < 21) || (this.ao))
        {
          ((Drawable)localObject).setBounds(0, 0, vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
        if (this.t == 2)
        {
          localObject = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843187);
          ((AnimationDrawable)localObject).setOneShot(true);
          ((AnimationDrawable)localObject).setBounds(0, 0, vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
          this.ao = true;
          return;
        }
        if (this.t == 3)
        {
          localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843188);
          ((Drawable)localObject).setBounds(0, 0, vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
      } while (this.t != 4);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843188);
      ((Drawable)localObject).setBounds(0, 0, vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void u(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean, this);
    }
    ((acyf)a(29)).c(paramBoolean);
    this.V = paramBoolean;
    mnf.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) || (aisc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      aisc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_anonyous", paramBoolean);
    }
    Object localObject;
    if (this.jdField_o_of_type_AndroidViewView == null)
    {
      this.jdField_o_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_o_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_o_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_r_of_type_AndroidViewView == null)
    {
      this.jdField_r_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_r_of_type_AndroidViewView.setBackgroundResource(2130842953);
      this.jdField_r_of_type_AndroidViewView.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_r_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_r_of_type_AndroidViewView, 0);
    }
    if (this.q == null)
    {
      this.q = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.q.setBackgroundResource(2130842953);
      this.q.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.q, 0);
    }
    if (this.p == null)
    {
      this.p = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.p.setBackgroundColor(Color.rgb(19, 19, 21));
      this.p.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131302567);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.p, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_a_of_type_Azct != null) {
      this.jdField_a_of_type_Azct.a(paramBoolean);
    }
    if (paramBoolean)
    {
      paramBoolean = ((aqyr)a(33)).c();
      localObject = (acyj)a(43);
      boolean bool = ((acyj)localObject).c();
      if ((!paramBoolean) && (!bool)) {
        A(1);
      }
      this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()))
      {
        ImmersiveUtils.a(false, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
        a(-16777216, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131310461).setVisibility(8);
        aciy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130842953);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(mnf.c);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(mnf.c);
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label872;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130842973);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(mnf.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(mnf.c);
        label571:
        if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_a_of_type_JavaLangCharSequence = this.jdField_f_of_type_AndroidWidgetTextView.getText();
        }
        bJ();
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131624496) + mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(mnf.c);
        aciy.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
        c(true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.b = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(true);
        }
        this.p.setVisibility(0);
        this.jdField_a_of_type_Mnj = new aejr(this);
        mnf.a().a(this.jdField_a_of_type_Mnj);
        this.jdField_a_of_type_Aeob.a();
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(2131630651);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          aciy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130842953);
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          }
        }
        ((acyj)localObject).g();
      }
    }
    for (;;)
    {
      z();
      s();
      this.jdField_a_of_type_Acka.notifyDataSetChanged();
      return;
      a(-16777216, false);
      break;
      label872:
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label571;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849304);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(mnf.c);
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130837679);
      break label571;
      bw();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "update");
    }
    if (paramObject == null) {}
    label138:
    label413:
    for (;;)
    {
      return;
      if ((paramObject instanceof MessageRecord)) {
        if ((paramObject instanceof ChatMessage))
        {
          paramObservable = (MessageRecord)paramObject;
          this.jdField_h_of_type_Long = paramObservable.shmsgseq;
          if (paramObservable.isSendFromLocal()) {
            break label230;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((akbm.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (akbm.c(paramObservable.istroop)))) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
            o(false);
          }
          acym localacym = (acym)a(28);
          if (localacym != null) {
            localacym.a(paramObservable);
          }
        }
      }
      for (;;)
      {
        if (!(paramObject instanceof MessageForText)) {
          break label413;
        }
        paramObservable = (MessageForText)paramObject;
        if (!paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TroopChatPie.update()");
        }
        batg.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
        return;
        label230:
        if ((!((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a().b("highFreqInteract")) || (this.ac)) {
          break label138;
        }
        this.ac = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable = new TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(false);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable);
        break label138;
        if ((paramObject instanceof aylz)) {
          b(paramObject);
        } else if ((paramObject instanceof Integer)) {
          switch (((Integer)paramObject).intValue())
          {
          case 123321: 
          default: 
            break;
          case 123322: 
            if ((this.jdField_a_of_type_Azct != null) && (this.jdField_a_of_type_Azct.a())) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(1, this.jdField_a_of_type_Azct.a() / 2);
            } else {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(1);
            }
            break;
          }
        }
      }
    }
  }
  
  public void v()
  {
    bg();
  }
  
  public void v(int paramInt)
  {
    if (!this.V) {
      super.v(paramInt);
    }
  }
  
  public void x()
  {
    Object localObject1;
    Object localObject2;
    int j;
    if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject1 == null) {
        break label195;
      }
      localObject1 = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label195;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label195;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label183;
      }
      j = 1;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (j != 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        awqx.b((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        VasWebviewUtil.reportCommercialDrainage("", "style", "0X8008E61", "", 1, 0, 0, "", "", "");
        bI();
        return;
        label183:
        j = 0;
        break;
      }
      label195:
      j = 0;
    }
  }
  
  public void z()
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if ((localTroopManager != null) && (localTroopManager.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if ((this.V) || (this.W)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842969);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130848835, 2130848836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aejb
 * JD-Core Version:    0.7.0.1
 */