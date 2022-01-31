import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class adcu
  extends bcaz
  implements bcdq, bcej, bcif, bcij
{
  private adcr a;
  protected xmq a;
  
  public adcu(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.preInitPluginEngine();
    this.mWebview = new TouchWebView(paramContext);
    buildBaseWebView(this.mInterface);
    this.jdField_a_of_type_Adcr = new adcr(paramActivity, this.mWebview);
  }
  
  public Activity a()
  {
    return this.mInActivity;
  }
  
  public TouchWebView a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      paramViewGroup.addView(this.mWebview);
    }
    return this.mWebview;
  }
  
  public WebViewFragment a()
  {
    return null;
  }
  
  public WebView a()
  {
    return this.mWebview;
  }
  
  public xmq a()
  {
    return b();
  }
  
  public void a()
  {
    super.doOnDestroy();
  }
  
  public void a(String paramString)
  {
    this.mUrl = paramString;
    this.mWebview.loadUrl(this.mUrl);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(String paramString)
  {
    return b().a(paramString);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return b().a(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public String b()
  {
    String str2 = this.mUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (this.mWebview != null)
      {
        if (TextUtils.isEmpty(this.mWebview.getUrl())) {
          break label46;
        }
        str1 = this.mWebview.getUrl();
      }
    }
    return str1;
    label46:
    return this.mInActivity.getIntent().getStringExtra("url");
  }
  
  protected xmq b()
  {
    if (this.jdField_a_of_type_Xmq == null)
    {
      this.jdField_a_of_type_Xmq = new xmq(this.mInterface, this.mInActivity);
      this.jdField_a_of_type_Xmq.a(this);
    }
    return this.jdField_a_of_type_Xmq;
  }
  
  public void b() {}
  
  public boolean b()
  {
    return false;
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList.add(new bcim());
      paramArrayList.add(new ConfessPlugin());
      paramArrayList.add(new UiApiPlugin());
      paramArrayList.add(new arne());
      paramArrayList.add(new xmw());
      paramArrayList.add(new nov());
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Adcr.a(b());
  }
  
  public CustomWebView getWebView()
  {
    return this.mWebview;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    paramByte = switchRequestCode(paramWebViewPlugin, (byte)1);
    if (paramByte == -1) {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "pluginStartActivityForResult not handled");
      }
    }
    while (this.mInActivity == null) {
      return paramByte;
    }
    this.mInActivity.startActivityForResult(paramIntent, 15001);
    return paramByte;
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.getPluginEngine() == null);
      i = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AbsWebView", 2, "switchRequestCode failed: webView index=" + 0 + ", pluginIndex=" + i);
    return -1;
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adcu
 * JD-Core Version:    0.7.0.1
 */