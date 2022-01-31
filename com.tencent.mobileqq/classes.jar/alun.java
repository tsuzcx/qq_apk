import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.util.concurrent.ConcurrentHashMap;

class alun
  implements View.OnClickListener
{
  alun(alum paramalum) {}
  
  public void onClick(View paramView)
  {
    if ((alum.a(this.a) == 0) && (!TextUtils.isEmpty(alum.a(this.a))))
    {
      alum.a(this.a).put(alum.b(this.a), Integer.valueOf(1));
      paramView = this.a.mRuntime.a();
      if (paramView != null) {
        paramView.a.loadUrl(alum.a(this.a));
      }
      alum.a(this.a, null);
    }
    alum.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alun
 * JD-Core Version:    0.7.0.1
 */