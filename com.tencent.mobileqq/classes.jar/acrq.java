import android.animation.ValueAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMVCellingStyleController.2;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class acrq
  implements acya, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private final acrv jdField_a_of_type_Acrv = new acrv();
  private acsg jdField_a_of_type_Acsg;
  private final acst jdField_a_of_type_Acst = new acst();
  private acsv jdField_a_of_type_Acsv;
  private acsw jdField_a_of_type_Acsw;
  private acsz jdField_a_of_type_Acsz;
  public acyg a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public FrameLayout a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public TouchWebView a;
  private GdtVideoCeilingLandView jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = -2147483648;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View d;
  
  public acrq(acsz paramacsz, View paramView, acsg paramacsg)
  {
    this.jdField_a_of_type_Acsz = paramacsz;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Acsg = paramacsg;
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private boolean a(WebView paramWebView, String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.startsWith("gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/"))
      {
        QLog.i("GdtMVCellingStyleController", 1, "handleSchema error");
        return false;
      }
      if ((this.jdField_a_of_type_Acsg == null) || (this.jdField_a_of_type_Acsg.a() == null) || (this.jdField_a_of_type_Acsg.a() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Acsg.a().getUrlForClick())))
      {
        QLog.i("GdtMVCellingStyleController", 1, "handleSchema urlForClick is Empty");
        return false;
      }
      String str = this.jdField_a_of_type_Acsg.a().getUrlForClick();
      acvi.a(1, 0, this.jdField_a_of_type_Acsg.a());
      GdtReporter.doCgiReport(str);
      QLog.i("GdtMVCellingStyleController", 1, "handleSchema url= " + paramString);
      this.jdField_a_of_type_Acst.a(paramWebView, paramString);
      return true;
    }
    catch (Exception paramWebView)
    {
      QLog.e("GdtMVCellingStyleController", 1, "fitSpecialScreen", paramWebView);
    }
    return false;
  }
  
  private void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Acsg == null)
    {
      QLog.i("GdtMVCellingStyleController", 1, "initWebTitle mModel == null");
      return;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Acst.a(this.jdField_a_of_type_Acsg.a(), paramActivity);
    QLog.i("GdtMVCellingStyleController", 1, "initWebTitle action= " + this.jdField_c_of_type_Int);
    if ((this.jdField_c_of_type_Int == 4) || (this.jdField_c_of_type_Int == 5))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      String str2;
      if (this.jdField_a_of_type_Acsg.a() == null)
      {
        paramActivity = "";
        String str1 = anzj.a(2131704123) + paramActivity;
        str2 = anzj.a(2131692601);
        if ((TextUtils.isEmpty(paramActivity)) || (str1.length() > str2.length())) {
          break label190;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
      }
      for (;;)
      {
        this.jdField_a_of_type_Acrv.a(this.jdField_c_of_type_AndroidWidgetTextView);
        return;
        paramActivity = this.jdField_a_of_type_Acsg.a().getAppName();
        break;
        label190:
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void e(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    localValueAnimator.addUpdateListener(new acrr(this, localLayoutParams, localLayoutParams.topMargin, paramInt));
    localValueAnimator.setDuration(300L);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Boolean = true;
    localValueAnimator.start();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setGdtVideoCeilingListeners(this, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
  }
  
  private void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int == 0)
    {
      localLayoutParams.topMargin = this.jdField_a_of_type_Int;
      a(1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Boolean = false;
      return;
      localLayoutParams.topMargin = this.jdField_b_of_type_Int;
      a(0.0F);
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Acsg == null) || (this.jdField_a_of_type_Acsg.a() == null) || (this.jdField_a_of_type_Acsg.a() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Acsg.a().getUrlForClick())))
    {
      QLog.i("GdtMVCellingStyleController", 1, "reportBarBtnClick reportBarBtnClick is Empty");
      return;
    }
    QLog.i("GdtMVCellingStyleController", 1, "reportBarBtnClick");
    String str = this.jdField_a_of_type_Acsg.a().getUrlForClick();
    GdtReporter.doCgiReport(this.jdField_a_of_type_Acrv.a(str, this.jdField_a_of_type_Acsz.a(), this.jdField_a_of_type_Acsz.a(), this.jdField_a_of_type_Acsz.b(), null));
    j();
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Acsv != null) && (this.jdField_a_of_type_Acsz != null) && (this.jdField_a_of_type_Acrv != null)) {
      this.jdField_a_of_type_Acsv.a(this.jdField_a_of_type_Acsz.a(), this.jdField_a_of_type_Acrv);
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370165));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366068));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366069));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366067));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381323));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380899));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362102));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362103);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380860));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380900);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView = ((GdtVideoCeilingLandView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381318));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131381308).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381319));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372078));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131379154);
  }
  
  public void a(double paramDouble)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new GdtMVCellingStyleController.2(this, paramDouble));
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Acsw != null) {
      this.jdField_a_of_type_Acsw.a(paramFloat);
    }
    this.jdField_c_of_type_AndroidViewView.setAlpha(1.0F - paramFloat);
  }
  
  public void a(int paramInt)
  {
    QLog.i("GdtMVCellingStyleController", 1, "drag onStart");
  }
  
  public void a(acsv paramacsv)
  {
    this.jdField_a_of_type_Acsv = paramacsv;
  }
  
  protected void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Acsg == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Acst.a(this.jdField_a_of_type_Acsg.a()));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Acst.a(paramActivity, this.jdField_a_of_type_Acsg.a()));
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_Acst.a(paramActivity, this.jdField_a_of_type_Acsg));
  }
  
  public void a(Activity paramActivity, acsw paramacsw)
  {
    this.jdField_a_of_type_Acsw = paramacsw;
    this.jdField_b_of_type_Int = bhtq.b(63.0F);
    this.jdField_a_of_type_Int = bhtq.b(211.0F);
    a();
    b(paramActivity);
    f();
    g();
    c(paramActivity);
    a(paramActivity);
    QLog.i("GdtMVCellingStyleController", 1, "init");
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.d == null)
      {
        QLog.i("GdtMVCellingStyleController", 1, "fitSpecialScreen mTopBar == null");
        return;
      }
      if (!paramBoolean)
      {
        QLog.i("GdtMVCellingStyleController", 1, "fitSpecialScreen !isPortait");
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.e("GdtMVCellingStyleController", 1, "fitSpecialScreen", paramActivity);
      return;
    }
    LiuHaiUtils.a(paramActivity);
    if (LiuHaiUtils.b())
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.height = LiuHaiUtils.b(paramActivity);
      this.d.setLayoutParams(localLayoutParams);
      QLog.i("GdtMVCellingStyleController", 1, "fitSpecialScreen addHeight = " + localLayoutParams.height);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
        bool1 = true;
      }
    }
    QLog.i("GdtMVCellingStyleController", 1, "onBackEvent return " + bool1);
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void b(int paramInt)
  {
    paramInt = (int)(paramInt + 0.5F) + this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getTop();
    if (paramInt > this.jdField_a_of_type_Int) {
      paramInt = this.jdField_a_of_type_Int;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
      a((paramInt - this.jdField_b_of_type_Int) * 1.0F / (this.jdField_a_of_type_Int - this.jdField_b_of_type_Int));
      return;
      if (paramInt < this.jdField_b_of_type_Int) {
        paramInt = this.jdField_b_of_type_Int;
      }
    }
  }
  
  protected void b(Activity paramActivity)
  {
    try
    {
      Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acyg = new acrs(this, paramActivity, paramActivity, null, (AppInterface)localObject);
      this.jdField_a_of_type_Acyg.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acyg.a(null);
      new binb(this.jdField_a_of_type_Acyg).a(null, (AppInterface)localObject, null);
      localObject = "";
      paramActivity = (Activity)localObject;
      if (this.jdField_a_of_type_Acsg != null)
      {
        paramActivity = (Activity)localObject;
        if (this.jdField_a_of_type_Acsg.a() != null) {
          paramActivity = blhn.a(this.jdField_a_of_type_Acsg.a().getUrlForLandingPage(), "xj_scene", "3");
        }
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramActivity);
      QLog.i("GdtMVCellingStyleController", 1, "initWeb url = " + paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("GdtMVCellingStyleController", 1, "initWebView", paramActivity);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    e(this.jdField_b_of_type_Int - localLayoutParams.topMargin);
  }
  
  public void c(int paramInt)
  {
    paramInt = this.jdField_b_of_type_Int;
    int i = (int)((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) * 0.5F);
    int j = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams()).topMargin;
    if (j <= i + paramInt)
    {
      paramInt = this.jdField_b_of_type_Int - j;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 2;
      if (Math.abs(paramInt) <= 0) {
        break label120;
      }
      e(paramInt);
    }
    for (;;)
    {
      QLog.i("GdtMVCellingStyleController", 1, "drag onEnd state=" + this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int);
      return;
      paramInt = this.jdField_a_of_type_Int - j;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.jdField_a_of_type_Int = 0;
      break;
      label120:
      h();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Acsg == null)
    {
      QLog.i("GdtMVCellingStyleController", 1, "onClickOpenApp mModel == null");
      return;
    }
    Activity localActivity = this.jdField_a_of_type_Acsz.a().a();
    if (localActivity == null)
    {
      QLog.i("GdtMVCellingStyleController", 1, "onClickOpenApp activity == null");
      return;
    }
    i();
    if (this.jdField_c_of_type_Int == 5)
    {
      this.jdField_a_of_type_Acst.a(localActivity, this.jdField_a_of_type_Acsg.a());
      return;
    }
    if (this.jdField_c_of_type_Int == 4)
    {
      this.jdField_a_of_type_Acst.b(localActivity, this.jdField_a_of_type_Acsg.a());
      return;
    }
    QLog.i("GdtMVCellingStyleController", 1, "onClickOpenApp mModel == null");
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    localLayoutParams.topMargin = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
  }
  
  public void e()
  {
    QLog.i("GdtMVCellingStyleController", 1, "onClickBack");
    acti localacti;
    if (!this.jdField_a_of_type_Acsz.c())
    {
      localacti = this.jdField_a_of_type_Acsz.a();
      if (localacti == null) {
        QLog.i("GdtMVCellingStyleController", 1, "iMotiveVideoView == null");
      }
    }
    else
    {
      return;
    }
    QLog.i("GdtMVCellingStyleController", 1, "iMotiveVideoView.finish()");
    localacti.a();
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Acsg == null) || (this.jdField_a_of_type_Acsg.a() == null)) {
      return;
    }
    int j = this.jdField_a_of_type_Acsg.a().vSize;
    int i;
    double d1;
    if (j == 585)
    {
      i = bhtq.b(375.0F);
      d1 = 1.0D;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      QLog.i("GdtMVCellingStyleController", 1, "initVideoStyle style = " + j + ",height=" + i);
      d(i);
      a(d1);
      return;
      i = bhtq.b(211.0F);
      d1 = 0.5625D;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
      continue;
      e();
      continue;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrq
 * JD-Core Version:    0.7.0.1
 */