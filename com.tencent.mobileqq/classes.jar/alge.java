import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class alge
{
  public String a;
  public WeakReference<WebViewPlugin> a;
  private WeakReference<algd> b;
  
  public alge(algd paramalgd, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramalgd);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(algf paramalgf, algg paramalgg)
  {
    algd localalgd = (algd)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localalgd != null) && (paramalgf != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramalgg != null) {
          paramalgg.d = System.currentTimeMillis();
        }
        if (algf.a(paramalgf) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { algf.a(paramalgf).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + algf.a(paramalgf));
      }
      if (algd.a(localalgd) != null)
      {
        algd.a(localalgd).remove(algf.a(paramalgf));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + algf.a(paramalgf));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alge
 * JD-Core Version:    0.7.0.1
 */