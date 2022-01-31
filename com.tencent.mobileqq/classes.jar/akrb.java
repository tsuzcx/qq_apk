import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;

public class akrb
  implements Runnable
{
  public akrb(HealthStepCounterPlugin paramHealthStepCounterPlugin) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.a.mRuntime.a().getContext());
    QQToast.a(this.a.mRuntime.a().getContext(), "抱歉，你未安装微信客户端，无法进行微信分享", 0).b((int)(localQQToast.b() * 2.5D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akrb
 * JD-Core Version:    0.7.0.1
 */