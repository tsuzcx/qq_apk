import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils.ProxyConfig;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import java.util.ArrayList;

public class akfn
  extends AbsWebView
{
  public akfn(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.y();
    this.a = new TouchWebView(this.e);
    b(paramAppInterface);
  }
  
  public void a()
  {
    super.u();
  }
  
  public void a(Intent paramIntent)
  {
    super.b(paramIntent);
  }
  
  public void a(String paramString)
  {
    if (SwiftWebViewUtils.ProxyConfig.jdField_a_of_type_Boolean)
    {
      SwiftWebViewUtils.a(this.a, SwiftWebViewUtils.ProxyConfig.jdField_a_of_type_JavaLangString);
      SwiftWebViewUtils.ProxyConfig.jdField_a_of_type_Boolean = false;
    }
    this.h = paramString;
    this.a.loadUrl(this.h);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList.add(new WebViewJumpPlugin());
    }
  }
  
  public void b()
  {
    super.v();
  }
  
  public void c()
  {
    super.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfn
 * JD-Core Version:    0.7.0.1
 */