import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class adgh
{
  WeakReference<CustomWebView> a;
  WeakReference<AppInterface> b;
  WeakReference<Activity> c;
  WeakReference<bhni> d = null;
  WeakReference<WebViewFragment> e = null;
  
  public adgh(Activity paramActivity)
  {
    this.c = new WeakReference(paramActivity);
  }
  
  public Activity a()
  {
    return (Activity)this.c.get();
  }
  
  public bhni a()
  {
    Activity localActivity;
    if (this.d == null)
    {
      localActivity = a();
      if (!(localActivity instanceof bhni)) {
        break label45;
      }
    }
    label45:
    for (this.d = new WeakReference((bhni)localActivity);; this.d = new WeakReference(a())) {
      return (bhni)this.d.get();
    }
  }
  
  public CustomWebView a()
  {
    WebViewFragment localWebViewFragment;
    if (this.a == null)
    {
      localWebViewFragment = a();
      if (localWebViewFragment == null) {
        break label42;
      }
    }
    label42:
    for (this.a = new WeakReference(localWebViewFragment.getWebView());; this.a = new WeakReference(null)) {
      return (CustomWebView)this.a.get();
    }
  }
  
  public AppInterface a()
  {
    AppRuntime localAppRuntime;
    if (this.b == null)
    {
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localAppRuntime instanceof ToolAppRuntime)) {
        break label52;
      }
      this.b = new WeakReference((AppInterface)localAppRuntime.getAppRuntime("modular_web"));
    }
    for (;;)
    {
      return (AppInterface)this.b.get();
      label52:
      if ((localAppRuntime instanceof AppInterface)) {
        this.b = new WeakReference((AppInterface)localAppRuntime);
      } else {
        this.b = new WeakReference(null);
      }
    }
  }
  
  public WebViewFragment a()
  {
    Activity localActivity;
    if (this.e == null)
    {
      localActivity = a();
      if (!(localActivity instanceof bhne)) {
        break label50;
      }
    }
    label50:
    for (this.e = new WeakReference(((bhne)localActivity).a());; this.e = new WeakReference(null)) {
      return (WebViewFragment)this.e.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgh
 * JD-Core Version:    0.7.0.1
 */