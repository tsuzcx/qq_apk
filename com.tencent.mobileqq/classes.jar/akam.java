import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.main.MainAssistObserver.14;
import com.tencent.mobileqq.activity.main.MainAssistObserver.15;
import com.tencent.mobileqq.activity.main.MainAssistObserver.17;
import com.tencent.mobileqq.activity.main.MainAssistObserver.2;
import com.tencent.mobileqq.activity.main.MainAssistObserver.24;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleObserver;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class akam
{
  public final int a;
  private aizo jdField_a_of_type_Aizo = new akbo(this);
  private ajfo jdField_a_of_type_Ajfo = new akao(this);
  public akai a;
  protected Bundle a;
  public Handler a;
  private ansi jdField_a_of_type_Ansi = new akap(this);
  private anyz jdField_a_of_type_Anyz = new akbh(this);
  private anzg jdField_a_of_type_Anzg = new akbn(this);
  aocm jdField_a_of_type_Aocm = new akbc(this);
  private aozh jdField_a_of_type_Aozh = new akbl(this);
  private aozi jdField_a_of_type_Aozi = new akbk(this);
  private aslz jdField_a_of_type_Aslz = new akaq(this);
  private ayqy jdField_a_of_type_Ayqy = new akbm(this);
  private ayqz jdField_a_of_type_Ayqz = new akax(this);
  private ayrb jdField_a_of_type_Ayrb = new akbj(this);
  private ayrc jdField_a_of_type_Ayrc = new akan(this);
  public bisl a;
  public SplashActivity a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new akay(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private QCircleObserver jdField_a_of_type_CooperationQqcircleChatQCircleObserver = new akar(this);
  protected String a;
  ConcurrentLinkedQueue<Runnable> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  protected nwk a;
  public volatile boolean a;
  public final int b;
  protected Bundle b;
  protected Handler b;
  protected QQCustomDialog b;
  protected String b;
  protected boolean b;
  public final int c;
  protected QQCustomDialog c;
  protected String c;
  public boolean c;
  public boolean d;
  
  public akam(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 3;
    this.jdField_a_of_type_AndroidOsHandler = new akat(this, Looper.getMainLooper());
    this.jdField_a_of_type_Nwk = new akbb(this);
    this.jdField_a_of_type_Akai = new akai(paramSplashActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private QQCustomDialog a(String paramString)
  {
    return bhdj.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131690679), new akbf(this));
  }
  
  private QQCustomDialog a(String paramString1, String paramString2)
  {
    return bhdj.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString1).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131718625), new akbi(this)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131718624) + paramString2, new akbg(this));
  }
  
  private void a(Bundle paramBundle)
  {
    String str;
    int i;
    int j;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("thridparty_prepare_av_game", false);
      str = paramBundle.getString("thridparty_av_game_type_key", "");
      long l1 = paramBundle.getLong("thridparty_av_game_room_id", 0L);
      long l2 = paramBundle.getLong("thridparty_av_game_share_uin", 0L);
      i = paramBundle.getInt("avgame_create_game_type_key", 0);
      j = paramBundle.getInt("avgame_from_type_key", 4);
      if ("thridparty_av_game_type_join_room".equals(str))
      {
        paramBundle = (ncz)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
        if (paramBundle == null)
        {
          QLog.e("MainAssistObserver", 1, "AV_GAME_MANAGER NULL");
          return;
        }
        paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 2, String.valueOf(l1), String.valueOf(l2));
        return;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("MainAssistObserver", 1, "realHandleThirdPartyPullUpAVGame error: " + paramBundle.getMessage());
      return;
    }
    if ("thridparty_av_game_type_create_room".equals(str))
    {
      paramBundle = (ncz)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (paramBundle == null)
      {
        QLog.e("MainAssistObserver", 1, "AV_GAME_MANAGER NULL");
        return;
      }
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, j, null, i);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramRunnable);
    l();
  }
  
  private void a(String paramString)
  {
    bhdj.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131698958), new Object[] { paramString })).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131691057), new akbe(this, paramString)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131690677), new akbd(this)).show();
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("thridparty_prepare_mini_app", false);
    boolean bool1 = paramBundle.getBoolean("pull_show_open_id_diff_main", false);
    String str1 = paramBundle.getString("mini_app_id", "");
    String str2 = paramBundle.getString("mini_app_path", "");
    String str3 = paramBundle.getString("mini_app_type", "release");
    boolean bool2 = paramBundle.getBoolean("pull_mini_app_not_privilege", false);
    boolean bool3 = paramBundle.getBoolean("pull_mini_app_not_privilege_not_bind", false);
    String str4 = paramBundle.getString("pull_mini_app_not_privilege_not_bind_app_name", "");
    paramBundle = paramBundle.getString("pull_mini_app_not_privilege_string", "");
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver", 2, "showAccountConfirm: shouldShowOpenIdDifferent is true");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_show_open_id_diff_main");
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("is_change_account", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("if_check_account_same", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", anum.class.getSimpleName());
      i();
      return;
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_app_not_privilege");
      if (bool3) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_mini_app_not_privilege_not_bind");
      }
      for (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = a(paramBundle, str4);; this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = a(paramBundle))
      {
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    }
    anum.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, str1, str2, str3);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    int i = ((aymd)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a();
    String str = null;
    switch (i)
    {
    }
    for (;;)
    {
      if (str != null) {
        bdla.b(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      str = "0X80073B0";
      continue;
      str = "0X80073B2";
      continue;
      str = "0X80073B6";
    }
  }
  
  private void c(Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("pull_app_not_privilege", false);
    String str1 = paramBundle.getString("pull_app_not_privilege_string", "");
    boolean bool2 = paramBundle.getBoolean("pull_show_open_id_diff_main", false);
    paramBundle.getBoolean("pull_uin_not_exist", false);
    boolean bool3 = paramBundle.getBoolean("pull_add_friend_tip", false);
    String str2 = paramBundle.getString("uin", "");
    paramBundle.getString("openid", "");
    paramBundle.getString("appid", "");
    if (bool1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_app_not_privilege");
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = a(str1);
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    do
    {
      return;
      if (bool2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("thridparty_pull_main");
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_show_open_id_diff_main");
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("is_change_account", true);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("if_check_account_same", true);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", aurh.class.getSimpleName());
        i();
        return;
      }
    } while (!bool3);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_add_friend_tip");
    a(str2);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.c();
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "runNext: mRunningTaskNum=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", queueSize=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localRunnable != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.post(localRunnable, 10, null, false);
      }
    }
  }
  
  public UpgradeDetailWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper == null) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bgvx.a().a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Ayrc);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Ayrb);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Ayqy);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Ansi);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Anyz);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Ayqz);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.setMsgTabUnreadListener(this.jdField_a_of_type_Anzg);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Aozh);
      VSNetworkHelper.getInstance();
      ((aizi)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(this.jdField_a_of_type_Aizo);
      ((ntj)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).a();
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Nwk);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Aocm);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Aslz);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
      Object localObject = (ajfn)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
      if (localObject != null) {
        ((ajfn)localObject).a(this.jdField_a_of_type_Ajfo);
      }
      localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      ((KandianMergeManager)localObject).a(this.jdField_a_of_type_Aozi);
      QLog.d("Q.readinjoy.4tab", 2, "register main assist call notify to update icon red point!");
      ((KandianMergeManager)localObject).l();
      localObject = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(((KandianSubscribeManager)localObject).a());
      axpk.a().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.a(paramInt1, paramInt2, paramObject);
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.a(paramInt, paramRedTypeInfo);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("if_check_account_same", false);
          this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("key_action");
        } while (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
      } while (this.jdField_a_of_type_AndroidOsBundle == null);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver", 2, "if Check =" + this.jdField_b_of_type_Boolean + " appid = " + this.jdField_a_of_type_JavaLangString + " openId= " + this.jdField_b_of_type_JavaLangString);
      }
    } while (!this.jdField_b_of_type_Boolean);
    j();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "onAccountChanged, ");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    bdvn.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Ayrb);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Anyz);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Ayqz);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Ayqy);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.setMsgTabUnreadListener(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Ansi);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Aozh);
    ((aizi)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b(this.jdField_a_of_type_Aizo);
    Object localObject = (ajfn)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localObject != null) {
      ((ajfn)localObject).b(this.jdField_a_of_type_Ajfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Aocm);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Ayrc);
    ((ntj)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).b();
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(this.jdField_a_of_type_Aozi);
    localObject = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(((KandianSubscribeManager)localObject).a());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Nwk);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Aslz);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_CooperationQqcircleChatQCircleObserver);
    axpk.a().b(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool3;
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_AndroidOsBundle = paramIntent.getExtras();
      } while (this.jdField_b_of_type_AndroidOsBundle == null);
      boolean bool1 = this.jdField_b_of_type_AndroidOsBundle.getBoolean("thridparty_pull_main", false);
      boolean bool2 = this.jdField_b_of_type_AndroidOsBundle.getBoolean("thridparty_prepare_mini_app", false);
      bool3 = this.jdField_b_of_type_AndroidOsBundle.getBoolean("thridparty_prepare_av_game", false);
      if (bool1)
      {
        c(this.jdField_b_of_type_AndroidOsBundle);
        return;
      }
      if (bool2)
      {
        b(this.jdField_b_of_type_AndroidOsBundle);
        return;
      }
    } while (!bool3);
    a(this.jdField_b_of_type_AndroidOsBundle);
  }
  
  public void c()
  {
    try
    {
      ThreadManager.getSubThreadHandler().postDelayed(new MainAssistObserver.2(this), 500L);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MainAssistObserver", 4, "notifyWindowShowed e=" + localException);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_Akai.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    ThreadManager.post(new MainAssistObserver.14(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    ThreadManager.post(new MainAssistObserver.15(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null))
    {
      QLog.d("Q.lebanew", 1, "updateTabLebaNotify but it's NewLeba!");
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "updateTabLebaNotify, curUin=" + str);
    }
    a(this.jdField_a_of_type_Akai.a(new akas(this)));
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    e();
    Object localObject = localQQAppInterface.getMessageFacade();
    aizi localaizi = (aizi)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
    if ((localObject != null) && (localaizi != null)) {
      ThreadManager.post(new MainAssistObserver.17(this, localQQAppInterface, (QQMessageFacade)localObject), 8, null, false);
    }
    g();
    f();
    localObject = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.getApp().sendBroadcast((Intent)localObject);
  }
  
  protected void i()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131694975);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692056);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690697, new akaz(this));
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694945, new akba(this));
    }
    if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bisl.a(anvx.a(2131705887));
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getMsgHandler().a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("MainAssistObserver", 2, "-->checkAccountDiff, mOpenid: " + this.jdField_b_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((OpenID)localObject1).openID))) {
        break label185;
      }
      this.jdField_a_of_type_Bisl.c(2131692826);
      this.jdField_a_of_type_Bisl.show();
      this.jdField_b_of_type_AndroidOsHandler = new Handler();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new MainAssistObserver.24(this), 3000L);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getMsgHandler().d(this.jdField_a_of_type_JavaLangString);
    }
    label185:
    do
    {
      return;
      if (!this.jdField_b_of_type_JavaLangString.equals(((OpenID)localObject1).openID))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MainAssistObserver", 2, "-->checkAccountDiff, !mOpenId.equals(openId.openID) mOpenId =" + this.jdField_b_of_type_JavaLangString + " openId.openID = " + ((OpenID)localObject1).openID);
        }
        i();
        return;
      }
    } while (this.d);
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "-->checkAccountDiff, mOpenId.equals(openId.openID)  " + this.jdField_b_of_type_JavaLangString);
    }
    if (BindGroupActivity.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, BindGroupActivity.class);
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("skey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getCurrentAccountUin()));
      ((Intent)localObject1).putExtra("key_params", this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
    }
    for (;;)
    {
      this.d = true;
      return;
      if (ChatSettingForTroop.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
      {
        TroopUtils.openTroopInfoActivity(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidOsBundle.getInt("vistor_type", 1));
      }
      else if (AddFriendLogicActivity.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
      {
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, AddFriendLogicActivity.class);
        ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
      }
      else
      {
        Object localObject2;
        if (aurh.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject2 = (anvk)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin", "");
          if (((anvk)localObject2).b((String)localObject1))
          {
            if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("thridparty_pull_aio", false))
            {
              localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, SplashActivity.class);
              ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
              ((Intent)localObject2).putExtra("thridparty_pull_aio", true);
              localObject1 = ContactUtils.getFriendNick(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, (String)localObject1);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              localObject1 = AIOUtils.setOpenAIOIntent((Intent)localObject2, new int[] { 2 });
              this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
            }
          }
          else {
            a((String)localObject1);
          }
        }
        else if (anum.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_id", "");
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_path", "");
          String str = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_type", "release");
          anum.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, (String)localObject1, (String)localObject2, str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akam
 * JD-Core Version:    0.7.0.1
 */