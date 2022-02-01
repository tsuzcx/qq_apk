import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.Map;

public class acyv
  extends WebViewPlugin
{
  private ArrayList<acyt> a = new ArrayList();
  
  public acyv()
  {
    this.mPluginNameSpace = "GdtWebReportPlugin";
    acyu localacyu = new acyu(this);
    acyw localacyw = new acyw(this);
    tod localtod = new tod();
    this.a.add(localacyu);
    this.a.add(localacyw);
    this.a.add(localtod);
  }
  
  public Activity a()
  {
    if (this.mRuntime != null) {}
    for (Activity localActivity1 = this.mRuntime.a();; localActivity1 = null)
    {
      Activity localActivity2 = localActivity1;
      if ((localActivity1 instanceof BasePluginActivity)) {
        localActivity2 = ((BasePluginActivity)BasePluginActivity.class.cast(localActivity1)).getOutActivity();
      }
      return localActivity2;
    }
  }
  
  public void callJs(String paramString)
  {
    super.callJs(paramString);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((acyt)this.a.get(i)).a(paramString, paramLong, paramMap);
      i += 1;
    }
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return super.handleSchemaRequest(paramString1, paramString2);
  }
  
  public void onActivityReady()
  {
    super.onActivityReady();
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyv
 * JD-Core Version:    0.7.0.1
 */