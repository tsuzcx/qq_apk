import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class acrt
{
  public long a;
  public acsg a;
  public acyg a;
  public View a;
  public FrameLayout a;
  public TouchWebView a;
  private Integer a;
  public String a;
  public boolean a;
  public View b;
  public boolean b;
  public View c;
  public boolean c;
  
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
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(acsg paramacsg, View paramView, Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView activity == null");
      return;
    }
    if (paramacsg == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView model == null");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131381314));
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView webFrameLayout == null");
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = paramacsg.a();
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
    this.jdField_a_of_type_Acsg = paramacsg;
    this.jdField_a_of_type_Long = localGdtMotiveVideoPageData.endcardLoadTime;
    a(paramView);
    try
    {
      paramacsg = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acyg = new acru(this, paramActivity, paramActivity, null, paramacsg);
      this.jdField_a_of_type_Acyg.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acyg.a(null);
      new binb(this.jdField_a_of_type_Acyg).a(null, paramacsg, null);
      this.jdField_c_of_type_Boolean = true;
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView url = " + this.jdField_a_of_type_JavaLangString + ",time = " + this.jdField_a_of_type_Long);
      return;
    }
    catch (Exception paramacsg)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView", paramacsg);
    }
  }
  
  public void a(Activity paramActivity, acsg paramacsg, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramacsg == null) || (paramacsg.a() == null)) {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "changeScreenOrientation error");
    }
    int j;
    int i;
    do
    {
      return;
      j = paramacsg.a().getEndcardDirection();
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
          break label143;
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
      label143:
      i = 0;
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Acyg != null)
      {
        this.jdField_a_of_type_Acyg.c();
        this.jdField_a_of_type_Acyg = null;
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
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367447);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367448);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367449);
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null))
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
      this.jdField_a_of_type_JavaLangString = blhn.a(str2, "direction", str1);
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
  
  public boolean a(Activity paramActivity, acsg paramacsg, boolean paramBoolean)
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
    a(paramActivity, paramacsg, paramBoolean);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Acyg != null) {
      this.jdField_a_of_type_Acyg.a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Acyg != null) {
      this.jdField_a_of_type_Acyg.b();
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
 * Qualified Name:     acrt
 * JD-Core Version:    0.7.0.1
 */