import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.util.concurrent.ConcurrentHashMap;

class alum
  implements View.OnClickListener
{
  alum(alul paramalul) {}
  
  public void onClick(View paramView)
  {
    if ((alul.a(this.a) == 0) && (!TextUtils.isEmpty(alul.a(this.a))))
    {
      alul.a(this.a).put(alul.b(this.a), Integer.valueOf(1));
      paramView = this.a.mRuntime.a();
      if (paramView != null) {
        paramView.a.loadUrl(alul.a(this.a));
      }
      alul.a(this.a, null);
    }
    alul.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alum
 * JD-Core Version:    0.7.0.1
 */