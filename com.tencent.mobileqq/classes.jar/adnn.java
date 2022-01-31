import android.app.ProgressDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;

class adnn
  implements Runnable
{
  adnn(adnl paramadnl) {}
  
  public void run()
  {
    this.a.a.b.dismiss();
    QQToast.a(this.a.a.mRuntime.a().getApplication(), 1, "分享失败，请稍后重试！", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adnn
 * JD-Core Version:    0.7.0.1
 */