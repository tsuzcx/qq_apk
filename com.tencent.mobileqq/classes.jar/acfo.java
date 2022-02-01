import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.api.motivevideo.webbottomcard.GdtMVWebBottomCardController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class acfo
{
  public static String a;
  public static String b;
  public long a;
  public aced a;
  public acfq a;
  public acko a;
  public Handler a;
  public View a;
  public FrameLayout a;
  public TouchWebView a;
  public Runnable a;
  public ArrayList<View> a;
  public boolean a;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  private final String e = "GdtMVWebBottomCardController";
  
  static
  {
    jdField_a_of_type_JavaLangString = "PAUSE";
    jdField_b_of_type_JavaLangString = "COMPLETE";
  }
  
  public acfo(acfq paramacfq, Handler paramHandler)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangRunnable = new GdtMVWebBottomCardController.1(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Acfq = paramacfq;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    }
  }
  
  private void h()
  {
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131367604));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131363693));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362128));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362098));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362119));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362038));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362096));
  }
  
  public String a(anaz paramanaz)
  {
    if (paramanaz == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "calPlayStatus player is null");
      return "";
    }
    int i = paramanaz.c();
    if (i <= 3) {
      return "PLAYING";
    }
    if (i == 4) {
      return jdField_a_of_type_JavaLangString;
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMVWebBottomCardController", 2, "showNativeBottomCard");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((View)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setVisibility(0);
      i += 1;
    }
    f();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      QLog.i("GdtMVWebBottomCardController", 1, "addWebBottomCardUrlParams url is null");
      return;
    }
    this.jdField_c_of_type_JavaLangString = bkyp.a(this.jdField_c_of_type_JavaLangString, "width", String.valueOf(paramInt1));
    this.jdField_c_of_type_JavaLangString = bkyp.a(this.jdField_c_of_type_JavaLangString, "height", String.valueOf(paramInt2));
    String str2 = this.jdField_c_of_type_JavaLangString;
    if (paramBoolean) {}
    for (String str1 = "vertical";; str1 = "horizontal")
    {
      this.jdField_c_of_type_JavaLangString = bkyp.a(str2, "direction", str1);
      QLog.d("GdtMVWebBottomCardController", 1, "encoded Url :" + this.jdField_c_of_type_JavaLangString);
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {}
    while ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    paramLong1 /= 1000L;
    paramLong2 /= 1000L;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs("getVideoStatus", new String[] { String.format(Locale.getDefault(), "{isMute:%b,totalDuration:%d,currentPosition:%d,rewardPosition:%d,status:\"%s\"}", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), paramString }) });
  }
  
  public boolean a(aced paramaced, View paramView, Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView activity == null");
      return false;
    }
    if (paramaced == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView model == null");
      return false;
    }
    if (paramView == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView rootView == null");
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131381385));
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView webFrameLayout == null");
      return false;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = paramaced.a();
    if (localGdtMotiveVideoPageData == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView data == null");
      return false;
    }
    if (TextUtils.isEmpty(localGdtMotiveVideoPageData.bottomCardUrl))
    {
      QLog.i("GdtMVWebBottomCardController", 1, "TextUtils.isEmpty(data.bottomCardUrl)");
      return false;
    }
    this.jdField_c_of_type_JavaLangString = localGdtMotiveVideoPageData.bottomCardUrl;
    this.jdField_a_of_type_Aced = paramaced;
    this.jdField_a_of_type_Long = localGdtMotiveVideoPageData.bottomCardLoadTime;
    this.d = localGdtMotiveVideoPageData.traceId;
    a(this.jdField_a_of_type_Aced.a().getImageWidth(), this.jdField_a_of_type_Aced.a().getImageHeight(), paramBoolean);
    this.jdField_a_of_type_AndroidViewView = paramView;
    h();
    return a(paramActivity);
  }
  
  public boolean a(Activity paramActivity)
  {
    try
    {
      AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acko = new acfp(this, paramActivity, paramActivity, null, localAppInterface);
      this.jdField_a_of_type_Acko.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_Acko.a(null);
      new bieb(this.jdField_a_of_type_Acko).a(null, localAppInterface, null);
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView url = " + this.jdField_c_of_type_JavaLangString);
      return true;
    }
    catch (Exception paramActivity)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView", paramActivity);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMVWebBottomCardController", 2, "showWebBottomCard");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((View)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setVisibility(4);
      i += 1;
    }
  }
  
  public void c()
  {
    QLog.i("GdtMVWebBottomCardController", 1, "onLoadFail");
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_Acfq != null) {
      this.jdField_a_of_type_Acfq.a();
    }
  }
  
  public void d()
  {
    QLog.i("GdtMVWebBottomCardController", 1, "onLoadSuccess");
    if (this.jdField_a_of_type_Acfq != null) {
      this.jdField_a_of_type_Acfq.b();
    }
  }
  
  public void e()
  {
    a();
  }
  
  public void f()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
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
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "onDestroy", localException);
    }
  }
  
  public void g()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Long <= 0L) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null));
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long * 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfo
 * JD-Core Version:    0.7.0.1
 */