import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;
import com.tencent.qphone.base.util.QLog;

public class aadw
{
  private CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  public volatile String a;
  public volatile boolean a;
  
  public aadw(aadt paramaadt, CustomWebView paramCustomWebView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj doCallback body: " + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs("window._websoPageData=" + this.jdField_a_of_type_JavaLangString + "; if(window.silentCallback) {window.silentCallback(" + this.jdField_a_of_type_JavaLangString + " );}");
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj onDataLoaded: " + paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      a();
    }
  }
  
  @JavascriptInterface
  public void catchHtml(String paramString)
  {
    paramString = bgzd.g(paramString);
    bgzd.a("catchHtml");
    WebSoService.WebSoState.WebSo3 localWebSo3 = aadt.a(this.jdField_a_of_type_Aadt).a();
    if (localWebSo3 != null)
    {
      WebSoService.a(paramString, localWebSo3.jdField_a_of_type_JavaLangString, localWebSo3.b, Uri.parse(localWebSo3.d));
      return;
    }
    bgzd.a("return webSo3 == null");
  }
  
  @JavascriptInterface
  public void didDOMContentLoaded()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj didDOMContentLoaded.");
    }
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  @JavascriptInterface
  public void didEventFiredWithParams(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj didEventFiredWithParams, envent: " + paramString1 + " param: " + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadw
 * JD-Core Version:    0.7.0.1
 */