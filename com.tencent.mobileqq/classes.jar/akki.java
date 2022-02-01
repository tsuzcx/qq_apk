import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.QbossADBannerManager.2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.qboss.QbossReportManager;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class akki
  implements View.OnClickListener
{
  private akho jdField_a_of_type_Akho;
  protected View a;
  protected URLImageView a;
  protected BaseActivity a;
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  protected View b;
  private boolean b;
  private boolean c;
  
  public static akki a(BaseActivity paramBaseActivity, akho paramakho)
  {
    Object localObject = akkg.a().a(a());
    if (localObject != null)
    {
      if (bkzh.a(((akke)localObject).jdField_c_of_type_JavaLangString)) {}
      for (localObject = ((akke)localObject).b();; localObject = ((akke)localObject).a())
      {
        if (localObject != null) {
          ((akki)localObject).a(paramBaseActivity, paramakho);
        }
        return localObject;
      }
    }
    return null;
  }
  
  private static String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QbossADBannerManager", 4, "getCurrentUin = " + localAppRuntime.getAccount());
      }
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  private void b(akke paramakke)
  {
    this.jdField_b_of_type_Boolean = paramakke.a();
    if (this.jdField_b_of_type_Boolean)
    {
      this.c = this.jdField_a_of_type_Akho.a();
      if (this.c) {
        i();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QbossADBannerManager", 2, "startPreloadWebView needed: " + this.jdField_b_of_type_Boolean + ", done: " + this.c);
    }
  }
  
  private void i()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("from", -1);
    localIntent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    BaseApplicationImpl.sApplication.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  private void j()
  {
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("QbossADBannerManager", 2, "stopPreloadWebView");
    }
  }
  
  protected int a()
  {
    return 2131561890;
  }
  
  protected int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    String str = paramString;
    if (!paramString.startsWith("#")) {
      str = "#" + paramString;
    }
    try
    {
      int i = Color.parseColor(str);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QZLog.i("QbossADBannerManager", 1, " getValidTextColor error color = " + str);
    }
    return -1;
  }
  
  public View a()
  {
    QLog.i("QbossADBannerManager", 1, "initQbossADBanner");
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(a(), null);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368612);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368602));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.width = b();
    localLayoutParams.height = c();
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)) {}
    for (String str = ContactUtils.getAccountNickName(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin());; str = "") {
      return paramString.replace("{nickname}", str);
    }
  }
  
  public void a()
  {
    akke localakke = akkg.a().a(a());
    if (localakke != null)
    {
      QbossReportManager.getInstance().reportClick(localakke.jdField_b_of_type_JavaLangString, null);
      bkzh.a(a() + "", 138, localakke.jdField_c_of_type_Int + "", localakke.jdField_b_of_type_JavaLangString);
    }
  }
  
  protected void a(akke paramakke)
  {
    if (paramakke == null) {
      return;
    }
    QLog.i("QbossADBannerManager", 1, "onQBossADBannerExposed show");
    String str = paramakke.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.put(str, Boolean.valueOf(true));
    bkzh.a(a() + "");
    QLog.i("QbossADBannerManager", 1, "onQBossADBannerExposed start expose");
    QbossReportManager.getInstance().reportExpose(paramakke.jdField_b_of_type_JavaLangString, null);
    bkzh.a(a() + "", 137, paramakke.jdField_c_of_type_Int + "", paramakke.jdField_b_of_type_JavaLangString);
  }
  
  public void a(BaseActivity paramBaseActivity, akho paramakho)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Akho = paramakho;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerManager", 2, "onScrollChange isScroll = " + paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    Object localObject = a();
    localObject = akkg.a().a((String)localObject);
    if ((localObject == null) || (((akke)localObject).jdField_a_of_type_AndroidUtilSparseArray == null) || (((akke)localObject).jdField_a_of_type_AndroidUtilSparseArray.size() == 0))
    {
      QLog.i("QbossADBannerManager", 1, "isNeedShowQBossADBanner configInfo is null, return false.");
      bool = false;
    }
    return bool;
  }
  
  protected int b()
  {
    return ViewUtils.getScreenWidth();
  }
  
  public void b()
  {
    akke localakke = akkg.a().a(a());
    if (localakke != null)
    {
      QbossReportManager.getInstance().reportClose(localakke.jdField_b_of_type_JavaLangString, null);
      bkzh.a(a() + "", 122, localakke.jdField_c_of_type_Int + "", localakke.jdField_b_of_type_JavaLangString);
    }
  }
  
  protected int c()
  {
    return (int)(b() * 0.1333333F);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentImageURLImageView == null))
    {
      QLog.e("QbossADBannerManager", 1, "showQbossADBanner xml init error");
      e();
      return;
    }
    QLog.i("QbossADBannerManager", 1, "start showQbossADBanner");
    akke localakke = akkg.a().a(a());
    if ((localakke != null) && (localakke.jdField_a_of_type_AndroidUtilSparseArray != null))
    {
      akkf localakkf = (akkf)localakke.jdField_a_of_type_AndroidUtilSparseArray.get(1);
      if (localakkf == null)
      {
        QLog.e("QbossADBannerManager", 1, "initQbossADBanner resourceInfo = null");
        e();
        return;
      }
      if ((!TextUtils.isEmpty(localakkf.jdField_c_of_type_JavaLangString)) && ((localakke.jdField_a_of_type_Int == 1) || (localakke.jdField_a_of_type_Int == 0)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = b();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = c();
        if (localakke.jdField_a_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = bool;
          localObject = URLDrawable.getFileDrawable(localakkf.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          if (localObject != null) {
            break;
          }
          QLog.i("QbossADBannerManager", 1, "initQbossADBanner urlDrawable == null  file path = " + localakkf.jdField_c_of_type_JavaLangString);
          e();
          return;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        if (((URLDrawable)localObject).getStatus() == 1)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable status is success");
          a(localakke);
          SetSplash.a(this.jdField_a_of_type_AndroidViewView);
          return;
        }
        ((URLDrawable)localObject).setURLDrawableListener(new akkj(this, localakke, localakkf));
        ThreadManager.executeOnFileThread(new QbossADBannerManager.2(this, (URLDrawable)localObject));
        return;
      }
      QLog.i("QbossADBannerManager", 1, "initQbossADBanner resType is wrong: " + localakke.jdField_a_of_type_Int + " file path = " + localakkf.jdField_c_of_type_JavaLangString);
      e();
      return;
    }
    QLog.i("QbossADBannerManager", 1, "initQbossADBanner config info is null, uin: " + a());
    e();
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QbossADBannerManager", 4, "checkIfHideBanner isClick: " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void e()
  {
    QLog.e("QbossADBannerManager", 1, "hideBanner");
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Akho != null)
    {
      this.jdField_a_of_type_Akho.g();
      j();
    }
    g();
  }
  
  public void f()
  {
    QLog.e("QbossADBannerManager", 1, "onRecycle");
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void h()
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.c))
    {
      this.c = true;
      i();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      bcef.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 11, 0, "", "", "", "");
      akke localakke;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        b();
        e();
        akkg.a().a(a());
        break;
        localakke = akkg.a().a(a());
        if ((localakke != null) && (!TextUtils.isEmpty(localakke.jdField_a_of_type_JavaLangString))) {
          break label139;
        }
        QLog.e("QbossADBannerManager", 1, "qboss banner configInfo = null || jumpUrl = null");
      }
      label139:
      a();
      if (QLog.isColorLevel()) {
        QLog.i("QbossADBannerManager", 2, "qboss banner jump url = " + localakke.jdField_a_of_type_JavaLangString);
      }
      Object localObject1;
      if (localakke.jdField_b_of_type_Int == 1)
      {
        Object localObject2 = localakke.jdField_a_of_type_JavaLangString;
        localObject1 = localObject2;
        if (!((String)localObject2).contains("http://"))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).contains("https://")) {
            localObject1 = "https://" + (String)localObject2;
          }
        }
        if (((String)localObject1).contains("?")) {}
        for (localObject1 = (String)localObject1 + "&qboss_trace=" + localakke.jdField_b_of_type_JavaLangString;; localObject1 = (String)localObject1 + "?qboss_trace=" + localakke.jdField_b_of_type_JavaLangString)
        {
          localObject1 = (String)localObject1 + MobileReportManager.getStringQboos2H5(BaseApplicationImpl.getApplication().getRuntime().getAccount(), localakke.jdField_b_of_type_JavaLangString, "&");
          if (QLog.isDevelopLevel()) {
            QLog.i("QbossADBannerManager", 4, "TraceInfo qboss banner final traceInfo jump url = " + (String)localObject1);
          }
          this.jdField_a_of_type_Boolean = true;
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          break;
        }
      }
      if (localakke.jdField_b_of_type_Int == 2)
      {
        localObject1 = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localakke.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Boolean = true;
          ((bfvp)localObject1).a();
        }
        else
        {
          QbossReportManager.getInstance().sendErrorReport(2741, localakke.jdField_c_of_type_Int, 100, "qboss banner jump scheme action = null , url =  " + localakke.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akki
 * JD-Core Version:    0.7.0.1
 */