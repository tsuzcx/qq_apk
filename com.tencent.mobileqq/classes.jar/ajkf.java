import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class ajkf
{
  public String a;
  public WeakReference<WebViewPlugin> a;
  private WeakReference<ajke> b;
  
  public ajkf(ajke paramajke, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramajke);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(ajkg paramajkg, ajkh paramajkh)
  {
    ajke localajke = (ajke)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localajke != null) && (paramajkg != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramajkh != null) {
          paramajkh.d = System.currentTimeMillis();
        }
        if (ajkg.a(paramajkg) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ajkg.a(paramajkg).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + ajkg.a(paramajkg));
      }
      if (ajke.a(localajke) != null)
      {
        ajke.a(localajke).remove(ajkg.a(paramajkg));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + ajkg.a(paramajkg));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajkf
 * JD-Core Version:    0.7.0.1
 */