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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ajir
  implements View.OnClickListener
{
  private ajgb jdField_a_of_type_Ajgb;
  protected View a;
  protected URLImageView a;
  protected BaseActivity a;
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  protected View b;
  private boolean b;
  protected View c;
  private boolean c;
  
  public static ajir a(BaseActivity paramBaseActivity, ajgb paramajgb)
  {
    Object localObject = ajip.a().a(a());
    if (localObject != null)
    {
      localObject = ((ajin)localObject).a();
      if (localObject != null) {
        ((ajir)localObject).a(paramBaseActivity, paramajgb);
      }
      return localObject;
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
  
  private void b(ajin paramajin)
  {
    this.jdField_b_of_type_Boolean = paramajin.a();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_Ajgb.a();
      if (this.jdField_c_of_type_Boolean) {
        i();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QbossADBannerManager", 2, "startPreloadWebView needed: " + this.jdField_b_of_type_Boolean + ", done: " + this.jdField_c_of_type_Boolean);
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
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("QbossADBannerManager", 2, "stopPreloadWebView");
    }
  }
  
  protected int a()
  {
    return 2131561734;
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
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373142);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368187);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368177));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.width = b();
    localLayoutParams.height = c();
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)) {}
    for (String str = bdgc.h(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin());; str = "") {
      return paramString.replace("{nickname}", str);
    }
  }
  
  public void a()
  {
    ajin localajin = ajip.a().a(a());
    if (localajin != null) {
      bjqm.a().b(localajin.jdField_b_of_type_JavaLangString, null);
    }
  }
  
  protected void a(ajin paramajin)
  {
    if (paramajin == null) {
      return;
    }
    QLog.i("QbossADBannerManager", 1, "onQBossADBannerExposed show");
    String str = paramajin.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.put(str, Boolean.valueOf(true));
    QLog.i("QbossADBannerManager", 1, "onQBossADBannerExposed start expose");
    bjqm.a().c(paramajin.jdField_b_of_type_JavaLangString, null);
  }
  
  public void a(BaseActivity paramBaseActivity, ajgb paramajgb)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Ajgb = paramajgb;
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
    localObject = ajip.a().a((String)localObject);
    if ((localObject == null) || (((ajin)localObject).jdField_a_of_type_AndroidUtilSparseArray == null) || (((ajin)localObject).jdField_a_of_type_AndroidUtilSparseArray.size() == 0))
    {
      QLog.i("QbossADBannerManager", 1, "isNeedShowQBossADBanner configInfo is null, return false.");
      bool = false;
    }
    return bool;
  }
  
  protected int b()
  {
    return bdoo.a();
  }
  
  public void b()
  {
    ajin localajin = ajip.a().a(a());
    if (localajin != null) {
      bjqm.a().a(localajin.jdField_b_of_type_JavaLangString, null);
    }
  }
  
  protected int c()
  {
    return (int)(b() * 0.1333333F);
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentImageURLImageView == null))
    {
      QLog.e("QbossADBannerManager", 1, "showQbossADBanner xml init error");
      e();
      return;
    }
    QLog.i("QbossADBannerManager", 1, "start showQbossADBanner");
    ajin localajin = ajip.a().a(a());
    if ((localajin != null) && (localajin.jdField_a_of_type_AndroidUtilSparseArray != null))
    {
      ajio localajio = (ajio)localajin.jdField_a_of_type_AndroidUtilSparseArray.get(1);
      if (localajio == null)
      {
        QLog.e("QbossADBannerManager", 1, "initQbossADBanner resourceInfo = null");
        e();
        return;
      }
      if ((!TextUtils.isEmpty(localajio.c)) && ((localajin.jdField_a_of_type_Int == 1) || (localajin.jdField_a_of_type_Int == 0)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bayu.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bayu.a;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = b();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = c();
        if (localajin.jdField_a_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = bool;
          localObject = URLDrawable.getFileDrawable(localajio.c, (URLDrawable.URLDrawableOptions)localObject);
          if (localObject != null) {
            break;
          }
          QLog.i("QbossADBannerManager", 1, "initQbossADBanner urlDrawable == null  file path = " + localajio.c);
          e();
          return;
        }
        if (((URLDrawable)localObject).getStatus() == 1)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable status is success");
          a(localajin);
          return;
        }
        ((URLDrawable)localObject).setURLDrawableListener(new ajis(this, localajin, localajio));
        ThreadManager.executeOnFileThread(new QbossADBannerManager.2(this, (URLDrawable)localObject));
        return;
      }
      QLog.i("QbossADBannerManager", 1, "initQbossADBanner resType is wrong: " + localajin.jdField_a_of_type_Int + " file path = " + localajio.c);
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
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerManager", 2, "hideBanner");
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Ajgb != null)
    {
      this.jdField_a_of_type_Ajgb.f();
      j();
    }
    g();
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void h()
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_c_of_type_Boolean = true;
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
      azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 11, 0, "", "", "", "");
      return;
      b();
      e();
      ajip.a().a(a());
      continue;
      ajin localajin = ajip.a().a(a());
      if ((localajin == null) || (TextUtils.isEmpty(localajin.jdField_a_of_type_JavaLangString)))
      {
        QLog.e("QbossADBannerManager", 1, "qboss banner configInfo = null || jumpUrl = null");
        return;
      }
      a();
      if (QLog.isColorLevel()) {
        QLog.i("QbossADBannerManager", 2, "qboss banner jump url = " + localajin.jdField_a_of_type_JavaLangString);
      }
      if (localajin.jdField_b_of_type_Int == 1)
      {
        Object localObject = localajin.jdField_a_of_type_JavaLangString;
        paramView = (View)localObject;
        if (!((String)localObject).contains("http://"))
        {
          paramView = (View)localObject;
          if (!((String)localObject).contains("https://")) {
            paramView = "https://" + (String)localObject;
          }
        }
        if (paramView.contains("?")) {}
        for (paramView = paramView + "&qboss_trace=" + localajin.jdField_b_of_type_JavaLangString;; paramView = paramView + "?qboss_trace=" + localajin.jdField_b_of_type_JavaLangString)
        {
          paramView = paramView + bjkd.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), localajin.jdField_b_of_type_JavaLangString, "&");
          if (QLog.isDevelopLevel()) {
            QLog.i("QbossADBannerManager", 4, "TraceInfo qboss banner final traceInfo jump url = " + paramView);
          }
          this.jdField_a_of_type_Boolean = true;
          localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView);
          ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_vip");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
          break;
        }
      }
      if (localajin.jdField_b_of_type_Int == 2)
      {
        paramView = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localajin.jdField_a_of_type_JavaLangString);
        if (paramView != null)
        {
          this.jdField_a_of_type_Boolean = true;
          paramView.c();
        }
        else
        {
          bjqm.a().a(2741, localajin.c, 100, "qboss banner jump scheme action = null , url =  " + localajin.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajir
 * JD-Core Version:    0.7.0.1
 */