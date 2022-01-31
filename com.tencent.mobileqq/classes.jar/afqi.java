import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver.12;
import com.tencent.mobileqq.activity.main.MainAssistObserver.13;
import com.tencent.mobileqq.activity.main.MainAssistObserver.15;
import com.tencent.mobileqq.activity.main.MainAssistObserver.2;
import com.tencent.mobileqq.activity.main.MainAssistObserver.22;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class afqi
{
  public final int a;
  public afqg a;
  ajfo jdField_a_of_type_Ajfo = new afqs(this);
  private ajgf jdField_a_of_type_Ajgf = new afqk(this);
  private ajmm jdField_a_of_type_Ajmm = new afrc(this);
  private ajmt jdField_a_of_type_Ajmt = new afrh(this);
  private ajnk jdField_a_of_type_Ajnk = new afri(this);
  ajrb jdField_a_of_type_Ajrb = new afqw(this);
  private akfr jdField_a_of_type_Akfr = new afrf(this);
  private akfs jdField_a_of_type_Akfs = new afre(this);
  protected Bundle a;
  public Handler a;
  private anoj jdField_a_of_type_Anoj = new afql(this);
  private atdh jdField_a_of_type_Atdh = new afrg(this);
  private atdi jdField_a_of_type_Atdi = new afqr(this);
  private atdk jdField_a_of_type_Atdk = new afrd(this);
  private atdl jdField_a_of_type_Atdl = new afqj(this);
  bafb jdField_a_of_type_Bafb = null;
  public bbms a;
  public SplashActivity a;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  protected String a;
  ConcurrentLinkedQueue<Runnable> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  protected mps a;
  public volatile boolean a;
  public final int b;
  protected Bundle b;
  protected Handler b;
  protected bafb b;
  protected String b;
  protected boolean b;
  public final int c;
  protected bafb c;
  protected String c;
  public boolean c;
  public boolean d;
  
  public afqi(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 3;
    this.jdField_a_of_type_AndroidOsHandler = new afqn(this, Looper.getMainLooper());
    this.jdField_a_of_type_Mps = new afqv(this);
    this.jdField_a_of_type_Afqg = new afqg(paramSplashActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private bafb a(String paramString)
  {
    return babr.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131625014), new afqz(this));
  }
  
  private bafb a(String paramString1, String paramString2)
  {
    return babr.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString1).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131653580), new afrb(this)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131653579) + paramString2, new afra(this));
  }
  
  private void a(Bundle paramBundle)
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
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", ajih.class.getSimpleName());
      i();
      return;
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_app_not_privilege");
      if (bool3) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_mini_app_not_privilege_not_bind");
      }
      for (this.jdField_c_of_type_Bafb = a(paramBundle, str4);; this.jdField_c_of_type_Bafb = a(paramBundle))
      {
        this.jdField_c_of_type_Bafb.show();
        return;
      }
    }
    ajih.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, str1, str2, str3);
  }
  
  private void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramRunnable);
    l();
  }
  
  private void a(String paramString)
  {
    babr.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131633781), new Object[] { paramString })).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131625487), new afqy(this, paramString)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131625012), new afqx(this)).show();
  }
  
  private void b(Bundle paramBundle)
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
      this.jdField_c_of_type_Bafb = a(str1);
      this.jdField_c_of_type_Bafb.show();
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
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", apja.class.getSimpleName());
        i();
        return;
      }
    } while (!bool3);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_add_friend_tip");
    a(str2);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    int i = ((atax)paramQQAppInterface.getManager(160)).a();
    String str = null;
    switch (i)
    {
    }
    for (;;)
    {
      if (str != null) {
        awqx.b(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      str = "0X80073B0";
      continue;
      str = "0X80073B2";
      continue;
      str = "0X80073B6";
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = akgo.a().a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Atdl);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Atdk);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Atdh);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Ajgf);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Ajmm);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Atdi);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_Ajmt);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Akfr);
      VSNetworkHelper.a().a();
      VSNetworkHelper.a();
      ((ajnf)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(34)).a(this.jdField_a_of_type_Ajnk);
      ((mmr)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(43)).a();
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Ajfo);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Mps);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Ajrb);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Anoj);
      Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(162);
      ((KandianMergeManager)localObject).a(this.jdField_a_of_type_Akfs);
      QLog.d("Q.readinjoy.4tab", 2, "register main assist call notify to update icon red point!");
      ((KandianMergeManager)localObject).k();
      localObject = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(280);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(((KandianSubscribeManager)localObject).a());
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
      }
    }
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
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Atdk);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Atdi);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Atdh);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Ajgf);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Akfr);
    ((ajnf)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(34)).b(this.jdField_a_of_type_Ajnk);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Ajrb);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Atdl);
    ((mmr)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(43)).b();
    VSNetworkHelper.a().a();
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(162)).b(this.jdField_a_of_type_Akfs);
    KandianSubscribeManager localKandianSubscribeManager = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(280);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(localKandianSubscribeManager.a());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Ajfo);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Mps);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Anoj);
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool2;
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_AndroidOsBundle = paramIntent.getExtras();
      } while (this.jdField_b_of_type_AndroidOsBundle == null);
      boolean bool1 = this.jdField_b_of_type_AndroidOsBundle.getBoolean("thridparty_pull_main", false);
      bool2 = this.jdField_b_of_type_AndroidOsBundle.getBoolean("thridparty_prepare_mini_app", false);
      if (bool1)
      {
        b(this.jdField_b_of_type_AndroidOsBundle);
        return;
      }
    } while (!bool2);
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
    this.jdField_a_of_type_Afqg.a();
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
    ThreadManager.post(new MainAssistObserver.12(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    ThreadManager.post(new MainAssistObserver.13(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
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
    a(this.jdField_a_of_type_Afqg.a(new afqm(this)));
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    e();
    Object localObject = localQQAppInterface.a();
    ajnf localajnf = (ajnf)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(34);
    if ((localObject != null) && (localajnf != null)) {
      ThreadManager.post(new MainAssistObserver.15(this, localQQAppInterface, (QQMessageFacade)localObject), 8, null, false);
    }
    g();
    f();
    localObject = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.getApp().sendBroadcast((Intent)localObject);
  }
  
  protected void i()
  {
    if (this.jdField_b_of_type_Bafb == null)
    {
      this.jdField_b_of_type_Bafb = babr.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230);
      this.jdField_b_of_type_Bafb.setMessage(2131629880);
      this.jdField_b_of_type_Bafb.setTitle(2131626648);
      this.jdField_b_of_type_Bafb.setNegativeButton(2131625035, new afqt(this));
      this.jdField_b_of_type_Bafb.setPositiveButton(2131629850, new afqu(this));
    }
    if (!this.jdField_b_of_type_Bafb.isShowing()) {
      this.jdField_b_of_type_Bafb.show();
    }
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_Bbms == null)
    {
      this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bbms.a(ajjy.a(2131640628));
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("MainAssistObserver", 2, "-->checkAccountDiff, mOpenid: " + this.jdField_b_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((OpenID)localObject1).openID))) {
        break label185;
      }
      this.jdField_a_of_type_Bbms.c(2131627396);
      this.jdField_a_of_type_Bbms.show();
      this.jdField_b_of_type_AndroidOsHandler = new Handler();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new MainAssistObserver.22(this), 3000L);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().d(this.jdField_a_of_type_JavaLangString);
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
        azlj.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidOsBundle.getInt("vistor_type", 1));
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
        if (apja.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject2 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(51);
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin", "");
          if (((ajjj)localObject2).b((String)localObject1))
          {
            if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("thridparty_pull_aio", false))
            {
              localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, SplashActivity.class);
              ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
              ((Intent)localObject2).putExtra("thridparty_pull_aio", true);
              localObject1 = babh.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, (String)localObject1);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              localObject1 = aciy.a((Intent)localObject2, new int[] { 2 });
              this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
            }
          }
          else {
            a((String)localObject1);
          }
        }
        else if (ajih.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_id", "");
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_path", "");
          String str = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_type", "release");
          ajih.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, (String)localObject1, (String)localObject2, str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqi
 * JD-Core Version:    0.7.0.1
 */