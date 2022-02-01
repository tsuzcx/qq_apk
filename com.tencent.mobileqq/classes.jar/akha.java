import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleObserver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver.13;
import com.tencent.mobileqq.activity.main.MainAssistObserver.14;
import com.tencent.mobileqq.activity.main.MainAssistObserver.16;
import com.tencent.mobileqq.activity.main.MainAssistObserver.2;
import com.tencent.mobileqq.activity.main.MainAssistObserver.23;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class akha
{
  public final int a;
  private ajkg jdField_a_of_type_Ajkg = new akib(this);
  public akgw a;
  protected Bundle a;
  public Handler a;
  anuw jdField_a_of_type_Anuw = new akhl(this);
  private anvn jdField_a_of_type_Anvn = new akhc(this);
  private aocj jdField_a_of_type_Aocj = new akhv(this);
  private aocq jdField_a_of_type_Aocq = new akia(this);
  aogi jdField_a_of_type_Aogi = new akhp(this);
  private apce jdField_a_of_type_Apce = new akhy(this);
  private apcf jdField_a_of_type_Apcf = new akhx(this);
  private asvt jdField_a_of_type_Asvt = new akhd(this);
  private ayxl jdField_a_of_type_Ayxl = new akhz(this);
  private ayxm jdField_a_of_type_Ayxm = new akhk(this);
  private ayxo jdField_a_of_type_Ayxo = new akhw(this);
  private ayxp jdField_a_of_type_Ayxp = new akhb(this);
  bhpc jdField_a_of_type_Bhpc = null;
  public bjbs a;
  private QCircleObserver jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver = new akhe(this);
  public SplashActivity a;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  protected String a;
  ConcurrentLinkedQueue<Runnable> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  protected noa a;
  public volatile boolean a;
  public final int b;
  protected Bundle b;
  protected Handler b;
  protected bhpc b;
  protected String b;
  protected boolean b;
  public final int c;
  protected bhpc c;
  protected String c;
  public boolean c;
  public boolean d;
  
  public akha(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 3;
    this.jdField_a_of_type_AndroidOsHandler = new akhg(this, Looper.getMainLooper());
    this.jdField_a_of_type_Noa = new akho(this);
    this.jdField_a_of_type_Akgw = new akgw(paramSplashActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private bhpc a(String paramString)
  {
    return bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131690562), new akhs(this));
  }
  
  private bhpc a(String paramString1, String paramString2)
  {
    return bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString1).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131717998), new akhu(this)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131717997) + paramString2, new akht(this));
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
        paramBundle = (mxc)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(373);
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
      paramBundle = (mxc)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(373);
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
    bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131698478), new Object[] { paramString })).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131690932), new akhr(this, paramString)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131690560), new akhq(this)).show();
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
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", anxq.class.getSimpleName());
      i();
      return;
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_app_not_privilege");
      if (bool3) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_mini_app_not_privilege_not_bind");
      }
      for (this.jdField_c_of_type_Bhpc = a(paramBundle, str4);; this.jdField_c_of_type_Bhpc = a(paramBundle))
      {
        this.jdField_c_of_type_Bhpc.show();
        return;
      }
    }
    anxq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, str1, str2, str3);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    int i = ((aysq)paramQQAppInterface.getManager(160)).a();
    String str = null;
    switch (i)
    {
    }
    for (;;)
    {
      if (str != null) {
        bdll.b(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
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
      this.jdField_c_of_type_Bhpc = a(str1);
      this.jdField_c_of_type_Bhpc.show();
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
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", auzi.class.getSimpleName());
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
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bhdu.a().a();
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
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Ayxp);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Ayxo);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_Ayxl);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Anvn);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Aocj);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Ayxm);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_Aocq);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Apce);
      VSNetworkHelper.a();
      ((ajka)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(34)).a(this.jdField_a_of_type_Ajkg);
      ((nku)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(43)).a();
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Anuw);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Noa);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Aogi);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_Asvt);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
      Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(162);
      ((KandianMergeManager)localObject).a(this.jdField_a_of_type_Apcf);
      QLog.d("Q.readinjoy.4tab", 2, "register main assist call notify to update icon red point!");
      ((KandianMergeManager)localObject).l();
      localObject = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(280);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(((KandianSubscribeManager)localObject).a());
      axwa.a().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
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
    bduy.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Ayxo);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Aocj);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Ayxm);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Ayxl);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Anvn);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Apce);
    ((ajka)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(34)).b(this.jdField_a_of_type_Ajkg);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Aogi);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_Ayxp);
    ((nku)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(43)).b();
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(162)).b(this.jdField_a_of_type_Apcf);
    KandianSubscribeManager localKandianSubscribeManager = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(280);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(localKandianSubscribeManager.a());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Anuw);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Noa);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_Asvt);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentBizQqcircleListBizblocksQCircleObserver);
    axwa.a().a();
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
    this.jdField_a_of_type_Akgw.a();
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
    ThreadManager.post(new MainAssistObserver.13(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    ThreadManager.post(new MainAssistObserver.14(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
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
    a(this.jdField_a_of_type_Akgw.a(new akhf(this)));
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    e();
    Object localObject = localQQAppInterface.a();
    ajka localajka = (ajka)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(34);
    if ((localObject != null) && (localajka != null)) {
      ThreadManager.post(new MainAssistObserver.16(this, localQQAppInterface, (QQMessageFacade)localObject), 8, null, false);
    }
    g();
    f();
    localObject = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.getApp().sendBroadcast((Intent)localObject);
  }
  
  protected void i()
  {
    if (this.jdField_b_of_type_Bhpc == null)
    {
      this.jdField_b_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230);
      this.jdField_b_of_type_Bhpc.setMessage(2131694652);
      this.jdField_b_of_type_Bhpc.setTitle(2131691920);
      this.jdField_b_of_type_Bhpc.setNegativeButton(2131690580, new akhm(this));
      this.jdField_b_of_type_Bhpc.setPositiveButton(2131694626, new akhn(this));
    }
    if (!this.jdField_b_of_type_Bhpc.isShowing()) {
      this.jdField_b_of_type_Bhpc.show();
    }
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bjbs.a(anzj.a(2131705306));
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
      this.jdField_a_of_type_Bjbs.c(2131692673);
      this.jdField_a_of_type_Bjbs.show();
      this.jdField_b_of_type_AndroidOsHandler = new Handler();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new MainAssistObserver.23(this), 3000L);
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
        bguq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidOsBundle.getInt("vistor_type", 1));
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
        if (auzi.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject2 = (anyw)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(51);
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin", "");
          if (((anyw)localObject2).b((String)localObject1))
          {
            if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("thridparty_pull_aio", false))
            {
              localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, SplashActivity.class);
              ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
              ((Intent)localObject2).putExtra("thridparty_pull_aio", true);
              localObject1 = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, (String)localObject1);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              localObject1 = agej.a((Intent)localObject2, new int[] { 2 });
              this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
            }
          }
          else {
            a((String)localObject1);
          }
        }
        else if (anxq.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_id", "");
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_path", "");
          String str = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_type", "release");
          anxq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, (String)localObject1, (String)localObject2, str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akha
 * JD-Core Version:    0.7.0.1
 */