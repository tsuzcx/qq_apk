import android.app.ProgressDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;

class adxp
  implements Runnable
{
  adxp(adxn paramadxn) {}
  
  public void run()
  {
    this.a.a.b.dismiss();
    QQToast.a(this.a.a.mRuntime.a().getApplication(), 1, "分享失败，请稍后重试！", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxp
 * JD-Core Version:    0.7.0.1
 */