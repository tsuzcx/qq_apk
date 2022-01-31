import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class ajkd
{
  public String a;
  public WeakReference<WebViewPlugin> a;
  private WeakReference<ajkc> b;
  
  public ajkd(ajkc paramajkc, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramajkc);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(ajke paramajke, ajkf paramajkf)
  {
    ajkc localajkc = (ajkc)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localajkc != null) && (paramajke != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramajkf != null) {
          paramajkf.d = System.currentTimeMillis();
        }
        if (ajke.a(paramajke) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ajke.a(paramajke).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + ajke.a(paramajke));
      }
      if (ajkc.a(localajkc) != null)
      {
        ajkc.a(localajkc).remove(ajke.a(paramajke));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + ajke.a(paramajke));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajkd
 * JD-Core Version:    0.7.0.1
 */