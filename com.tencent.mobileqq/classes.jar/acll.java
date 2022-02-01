import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class acll
  extends WebViewPlugin
{
  private WeakReference<CustomWebView> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<aclj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public acll()
  {
    acho.a("GdtWebReportPlugin", " GdtWebReportPlugin ");
    this.mPluginNameSpace = "GdtWebReportPlugin";
    aclk localaclk = new aclk(this);
    aclm localaclm = new aclm(this);
    acld localacld = new acld(this);
    uih localuih = new uih();
    this.jdField_a_of_type_JavaUtilArrayList.add(localaclk);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaclm);
    this.jdField_a_of_type_JavaUtilArrayList.add(localuih);
    this.jdField_a_of_type_JavaUtilArrayList.add(localacld);
  }
  
  protected Activity a()
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
  
  protected WeakReference<CustomWebView> a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference;
  }
  
  public void callJs(String paramString)
  {
    super.callJs(paramString);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    acho.a("GdtWebReportPlugin", " handleEvent url = " + paramString + "==type ==" + paramLong);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((aclj)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramString, paramLong, paramMap);
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
    acho.a("GdtWebReportPlugin", " onActivityReady ");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((aclj)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    acho.a("GdtWebReportPlugin", " onCreate ");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    acho.a("GdtWebReportPlugin", " onDestroy webviewGetPerformanceResult");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((aclj)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
      i += 1;
    }
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCustomWebView);
    acho.a("GdtWebReportPlugin", " onWebViewCreated ");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((aclj)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramCustomWebView);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acll
 * JD-Core Version:    0.7.0.1
 */