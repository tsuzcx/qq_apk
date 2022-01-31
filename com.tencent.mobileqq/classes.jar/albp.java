import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class albp
{
  public String a;
  public WeakReference<WebViewPlugin> a;
  private WeakReference<albo> b;
  
  public albp(albo paramalbo, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramalbo);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(albq paramalbq, albr paramalbr)
  {
    albo localalbo = (albo)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localalbo != null) && (paramalbq != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramalbr != null) {
          paramalbr.d = System.currentTimeMillis();
        }
        if (albq.a(paramalbq) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { albq.a(paramalbq).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + albq.a(paramalbq));
      }
      if (albo.a(localalbo) != null)
      {
        albo.a(localalbo).remove(albq.a(paramalbq));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + albq.a(paramalbq));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albp
 * JD-Core Version:    0.7.0.1
 */