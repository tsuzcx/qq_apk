import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.activity.weather.webpage.WeatherArkViewWrapper;
import com.tencent.mobileqq.activity.weather.webpage.WebViewFragmentWithArk;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "y", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onScrollChanged"}, k=3, mv={1, 1, 16})
public final class alhh
  implements TouchWebView.OnScrollChangedListener
{
  public alhh(WebViewFragmentWithArk paramWebViewFragmentWithArk) {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "showPreview scrollChangedListener  y: " + paramInt2 + ", arkLoadState：" + WebViewFragmentWithArk.a(this.a));
    }
    WebViewFragmentWithArk.a(this.a).scrollTo(0, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhh
 * JD-Core Version:    0.7.0.1
 */