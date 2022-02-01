import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class acdq
{
  public long a;
  public aced a;
  private final acer jdField_a_of_type_Acer = new acer();
  private acet jdField_a_of_type_Acet;
  public acko a;
  public View a;
  public FrameLayout a;
  public TouchWebView a;
  private Integer jdField_a_of_type_JavaLangInteger;
  public String a;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  public boolean a;
  private long b;
  public View b;
  public boolean b;
  public View c;
  public boolean c;
  private boolean d;
  
  private boolean a(WebView paramWebView, String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.startsWith("gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/"))
      {
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, "handleSchema error");
        return false;
      }
      if ((this.jdField_a_of_type_Aced == null) || (this.jdField_a_of_type_Aced.a() == null) || (this.jdField_a_of_type_Aced.a() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aced.a().getUrlForClick())))
      {
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, "handleSchema urlForClick is Empty");
        return false;
      }
      String str = this.jdField_a_of_type_Aced.a().getUrlForClick();
      achv.a(1, 0, this.jdField_a_of_type_Aced.a());
      GdtReporter.doCgiReport(str);
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "handleSchema url= " + paramString);
      this.jdField_a_of_type_Acer.a(paramWebView, paramString);
      return true;
    }
    catch (Exception paramWebView)
    {
      QLog.e("EndCardWebGdtMVEndcardWebController", 1, "fitSpecialScreen", paramWebView);
    }
    return false;
  }
  
  public void a()
  {
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "onWebError");
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void a(long paramLong)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Long <= 0L) || (paramLong / 1000L > this.jdField_a_of_type_Long));
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "preLoadUrl   " + paramLong);
    } while (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Acet.a(1020035L);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(aced paramaced, View paramView, Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView activity == null");
      return;
    }
    if (paramaced == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView model == null");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131381391));
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView webFrameLayout == null");
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = paramaced.a();
    if (localGdtMotiveVideoPageData == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView data == null");
      return;
    }
    if (TextUtils.isEmpty(localGdtMotiveVideoPageData.endcardUrl))
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "TextUtils.isEmpty(data.endcardUrl)");
      return;
    }
    this.jdField_a_of_type_JavaLangString = localGdtMotiveVideoPageData.endcardUrl;
    a(paramBoolean);
    this.jdField_a_of_type_Aced = paramaced;
    this.jdField_a_of_type_Long = localGdtMotiveVideoPageData.endcardLoadTime;
    a(paramView);
    try
    {
      this.jdField_a_of_type_Acet = new acet(this.jdField_a_of_type_Aced.a().getTraceId(), String.valueOf(AppSetting.a()));
      paramaced = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acko = new acdr(this, paramActivity, paramActivity, null, paramaced);
      this.jdField_a_of_type_Acko.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acko.a(null);
      new bieb(this.jdField_a_of_type_Acko).a(null, paramaced, null);
      this.jdField_c_of_type_Boolean = true;
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView url = " + this.jdField_a_of_type_JavaLangString + ",time = " + this.jdField_a_of_type_Long);
      return;
    }
    catch (Exception paramaced)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView", paramaced);
    }
  }
  
  public void a(Activity paramActivity, aced paramaced, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramaced == null) || (paramaced.a() == null)) {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "changeScreenOrientation error");
    }
    int j;
    int i;
    do
    {
      return;
      j = paramaced.a().getEndcardDirection();
      if (!paramBoolean) {
        break;
      }
      i = 1;
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "changeScreenOrientation endcard = " + j + ",curr = " + i);
    } while (((j != 1) && (j != 2)) || (j == i));
    for (;;)
    {
      try
      {
        d();
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramActivity.getRequestedOrientation());
        if (j != 1) {
          break label147;
        }
        i = 1;
        paramActivity.setRequestedOrientation(i);
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("EndCardWebGdtMVEndcardWebController", 1, "changeScreenOrientation", paramActivity);
        return;
      }
      i = 2;
      break;
      label147:
      i = 0;
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Acko != null)
      {
        this.jdField_a_of_type_Acko.c();
        this.jdField_a_of_type_Acko = null;
      }
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)localViewParent).removeAllViewsInLayout();
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
      }
      if ((this.jdField_a_of_type_JavaLangInteger != null) && (paramBoolean) && (paramActivity != null))
      {
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, "onDestroy setRequestedOrientation " + this.jdField_a_of_type_JavaLangInteger);
        paramActivity.setRequestedOrientation(this.jdField_a_of_type_JavaLangInteger.intValue());
      }
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "onDestroy", paramActivity);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367607);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initLoadingContainer container == null");
      return;
    }
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367608);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367609);
    if ((this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null))
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initLoadingContainer view == null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {}
    for (String str1 = "vertical";; str1 = "horizontal")
    {
      this.jdField_a_of_type_JavaLangString = bkyp.a(str2, "direction", str1);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
          {
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
            bool1 = true;
          }
        }
      }
    }
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "onBackEvent return " + bool1);
    return bool1;
  }
  
  public boolean a(Activity paramActivity, aced paramaced, boolean paramBoolean)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb !mHasInit");
      return false;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb mHasError");
      return false;
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb mWebViewContainer == null");
      return false;
    }
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb");
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
    }
    a(paramActivity, paramaced, paramBoolean);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Acko != null) {
      this.jdField_a_of_type_Acko.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Acko != null) {
      this.jdField_a_of_type_Acko.b();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null))
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingContainer error");
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingContainer");
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingError error");
    }
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingError");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdq
 * JD-Core Version:    0.7.0.1
 */