import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.2;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.3;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.4;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.5;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideWebLaunchSuccessReceiver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class alkp
  extends ViewModel
{
  alke jdField_a_of_type_Alke = new alke();
  public alkj a;
  private MutableLiveData<alkb> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private NewerGuideWebLaunchSuccessReceiver jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver;
  
  public alkp()
  {
    this.jdField_a_of_type_Alkj = alkj.jdField_a_of_type_Alkj;
  }
  
  private void a(QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setURLDrawableListener(new alkq(this, paramQQAppInterface));
    paramURLDrawable.startDownload();
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(alkb.a(this.jdField_a_of_type_ComTencentImageURLDrawable, false));
    int j = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
    if (j == 1) {
      i = 1;
    }
    if (i == 0) {
      a(paramQQAppInterface, this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuideBannerViewModel", 2, "updateUrlDrawableBg bgUrl: " + paramString + ", status: " + j);
      }
      return;
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(alkb.a(this.jdField_a_of_type_ComTencentImageURLDrawable, true));
      d(paramQQAppInterface);
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "onNewerGuideBrowserActivityOnStart sourceFrom -> " + paramString);
    }
    if (TextUtils.equals(paramString, "NewerGuideBannerViewModel"))
    {
      paramString = new Intent("ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS");
      BaseApplicationImpl.getContext().sendBroadcast(paramString);
    }
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://ti.qq.com/hybrid-h5/new_user_guide/index"));
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "[onContactsWebJump] do not have permission");
    }
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(alkb.a());
  }
  
  private void d(BaseActivity paramBaseActivity, String paramString)
  {
    ajcr.a(paramBaseActivity, paramBaseActivity.app, new NewerGuideBannerViewModel.3(this, paramString, paramBaseActivity), new NewerGuideBannerViewModel.4(this));
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (!alkg.a.a()) {}
    while ((DeviceInfoUtil.isLowPerfDevice()) || (this.jdField_a_of_type_Alke.a() != 0) || (this.jdField_a_of_type_Alke.a(paramQQAppInterface))) {
      return;
    }
    e(paramQQAppInterface);
  }
  
  private void e(BaseActivity paramBaseActivity)
  {
    ThreadManager.excute(new NewerGuideBannerViewModel.5(this, paramBaseActivity), 16, null, false);
  }
  
  private void e(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "[onCommonWebJump] jump url: " + paramString);
    }
    if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
    {
      a();
      Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("source_from", "NewerGuideBannerViewModel");
      paramBaseActivity.startActivity(localIntent);
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "doPreloadWebProcess");
    ThreadManager.excute(new NewerGuideBannerViewModel.2(this, paramQQAppInterface), 16, null, true);
  }
  
  public MutableLiveData<alkb> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver == null)
    {
      IntentFilter localIntentFilter = new IntentFilter("ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS");
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver = new NewerGuideWebLaunchSuccessReceiver(this);
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver, localIntentFilter);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(alkb.a(true));
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    String str = this.jdField_a_of_type_Alke.a();
    if (!TextUtils.isEmpty(str)) {
      a(paramBaseActivity.app, str);
    }
    QLog.d("NewerGuideBannerViewModel", 1, "onThemeChange bgUrl: " + str);
  }
  
  void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (a(paramString))
    {
      d(paramBaseActivity, paramString);
      return;
    }
    e(paramBaseActivity, paramString);
  }
  
  public void a(BaseActivity paramBaseActivity, oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    this.jdField_a_of_type_Alke.a(paramGuidelines_8410);
    paramBaseActivity = paramBaseActivity.app;
    paramGuidelines_8410 = this.jdField_a_of_type_Alke.a();
    if (!TextUtils.isEmpty(paramGuidelines_8410))
    {
      a(paramBaseActivity, paramGuidelines_8410);
      bdla.b(paramBaseActivity, "dc00898", "", "", "0X800B618", "0X800B618", this.jdField_a_of_type_Alke.b(), 0, "", "", "", "");
      return;
    }
    c(paramBaseActivity);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "onClickClose");
    }
    b(paramQQAppInterface);
    bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800B4EA", "0X800B4EA", this.jdField_a_of_type_Alke.b(), 0, "", "", "", "");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "unRegisterReceiver");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver = null;
    }
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(alkb.a(false));
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    QQAppInterface localQQAppInterface = paramBaseActivity.app;
    String str = this.jdField_a_of_type_Alke.b();
    if (!TextUtils.isEmpty(str))
    {
      int i = this.jdField_a_of_type_Alke.a();
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuideBannerViewModel", 2, "onBannerClick url -> " + str + ", jumpType -> " + i);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X800B619", "0X800B619", this.jdField_a_of_type_Alke.b(), 0, "", "", "", "");
      return;
      a(paramBaseActivity, str);
      continue;
      b(paramBaseActivity, str);
      b(localQQAppInterface);
      continue;
      c(paramBaseActivity, str);
      b(localQQAppInterface);
    }
  }
  
  void b(BaseActivity paramBaseActivity, String paramString)
  {
    if (MiniAppLauncher.isMiniAppUrl(paramString)) {
      MiniAppLauncher.startMiniApp(paramBaseActivity, paramString, 2016, null);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    ((alkd)paramQQAppInterface.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER)).c();
    this.jdField_a_of_type_Alkj.b(paramQQAppInterface.getCurrentAccountUin());
    c(paramQQAppInterface);
  }
  
  void c(BaseActivity paramBaseActivity)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "[showPermissionDeniedHint] confirm");
    bdla.b(paramBaseActivity.app, "dc00898", "", "", "0X800B4E8", "0X800B4E8", 2, 0, "", "", "", "");
    e(paramBaseActivity, this.jdField_a_of_type_Alke.b() + "&ab_auth=0");
  }
  
  void c(BaseActivity paramBaseActivity, String paramString)
  {
    try
    {
      paramBaseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    catch (Throwable paramBaseActivity)
    {
      QLog.e("NewerGuideBannerViewModel", 1, paramBaseActivity, new Object[0]);
    }
  }
  
  void c(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "hideNewerGuideBanner");
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1134211);
      }
    }
  }
  
  void d(BaseActivity paramBaseActivity)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "[showPermissionDeniedHint] cancel");
    bdla.b(paramBaseActivity.app, "dc00898", "", "", "0X800B4E8", "0X800B4E8", 1, 0, "", "", "", "");
    b(paramBaseActivity.app);
  }
  
  public void onCleared()
  {
    super.onCleared();
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkp
 * JD-Core Version:    0.7.0.1
 */