import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class acnr
{
  public long a;
  public acoe a;
  public acuc a;
  public FrameLayout a;
  public TouchWebView a;
  public String a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public void a()
  {
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "onWebError");
    this.b = true;
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void a(long paramLong)
  {
    if (!this.c) {}
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
  
  public void a(acoe paramacoe, View paramView, Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView activity == null");
      return;
    }
    if (paramacoe == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView model == null");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131381141));
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView webFrameLayout == null");
      return;
    }
    paramView = paramacoe.a();
    if (paramView == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView data == null");
      return;
    }
    if (TextUtils.isEmpty(paramView.endcardUrl))
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "TextUtils.isEmpty(data.endcardUrl)");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramView.endcardUrl;
    a(paramBoolean);
    this.jdField_a_of_type_Acoe = paramacoe;
    this.jdField_a_of_type_Long = paramView.endcardLoadTime;
    try
    {
      paramacoe = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acuc = new acns(this, paramActivity, paramActivity, null, paramacoe);
      this.jdField_a_of_type_Acuc.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acuc.a(null);
      new bhmg(this.jdField_a_of_type_Acuc).a(null, paramacoe, null);
      this.c = true;
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView url = " + this.jdField_a_of_type_JavaLangString + ",time = " + this.jdField_a_of_type_Long);
      return;
    }
    catch (Exception paramacoe)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView", paramacoe);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {}
    for (String str1 = "vertical";; str1 = "horizontal")
    {
      this.jdField_a_of_type_JavaLangString = bkgj.a(str2, "direction", str1);
      return;
    }
  }
  
  public boolean a()
  {
    if (!this.c)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb !mHasInit");
      return false;
    }
    if (this.b)
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
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Acuc != null) {
      this.jdField_a_of_type_Acuc.a();
    }
  }
  
  public boolean b()
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
  
  public void c()
  {
    if (this.jdField_a_of_type_Acuc != null) {
      this.jdField_a_of_type_Acuc.b();
    }
  }
  
  public void d()
  {
    try
    {
      if (this.jdField_a_of_type_Acuc != null)
      {
        this.jdField_a_of_type_Acuc.c();
        this.jdField_a_of_type_Acuc = null;
      }
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)localViewParent).removeAllViewsInLayout();
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "onDestroy", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnr
 * JD-Core Version:    0.7.0.1
 */