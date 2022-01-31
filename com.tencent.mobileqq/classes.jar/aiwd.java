import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class aiwd
{
  public String a;
  public WeakReference<WebViewPlugin> a;
  private WeakReference<aiwc> b;
  
  public aiwd(aiwc paramaiwc, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramaiwc);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(aiwe paramaiwe, aiwf paramaiwf)
  {
    aiwc localaiwc = (aiwc)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localaiwc != null) && (paramaiwe != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramaiwf != null) {
          paramaiwf.d = System.currentTimeMillis();
        }
        if (aiwe.a(paramaiwe) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { aiwe.a(paramaiwe).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + aiwe.a(paramaiwe));
      }
      if (aiwc.a(localaiwc) != null)
      {
        aiwc.a(localaiwc).remove(aiwe.a(paramaiwe));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + aiwe.a(paramaiwe));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwd
 * JD-Core Version:    0.7.0.1
 */