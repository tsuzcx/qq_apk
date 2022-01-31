import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.util.concurrent.ConcurrentHashMap;

class alfz
  implements View.OnClickListener
{
  alfz(alfy paramalfy) {}
  
  public void onClick(View paramView)
  {
    if ((alfy.a(this.a) == 0) && (!TextUtils.isEmpty(alfy.a(this.a))))
    {
      alfy.a(this.a).put(alfy.b(this.a), Integer.valueOf(1));
      paramView = this.a.mRuntime.a();
      if (paramView != null) {
        paramView.a.loadUrl(alfy.a(this.a));
      }
      alfy.a(this.a, null);
    }
    alfy.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alfz
 * JD-Core Version:    0.7.0.1
 */