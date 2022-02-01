import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.smtt.sdk.WebView;

public class ackv
  extends acko
{
  public ackv(GdtVideoImaxFragment paramGdtVideoImaxFragment, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    acho.b("AbsWebView", "onPageFinished:" + paramString);
    GdtVideoImaxFragment.b(this.a, true);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    acho.b("AbsWebView", "onPageStarted:" + paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    GdtVideoImaxFragment.b(this.a, false);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    acho.b("AbsWebView", "onReceivedTitle: " + paramString);
    GdtVideoImaxFragment.a(this.a).setWebBarTitle(paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    acho.b("AbsWebView", "shouldOverrideUrlLoading:" + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {}
    for (;;)
    {
      return true;
      Object localObject = ((CustomWebView)paramWebView).getPluginEngine();
      if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        if ((localObject != null) && (((WebViewPluginEngine)localObject).a(paramString, 16L, null))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      localObject = AdUriUtil.parse(paramString);
      if (localObject != null) {}
      for (paramString = ((Uri)localObject).getScheme(); nro.a().a(paramWebView.getUrl(), paramString).booleanValue(); paramString = null)
      {
        paramWebView = new Intent("android.intent.action.VIEW", (Uri)localObject);
        paramWebView.addFlags(268435456);
        try
        {
          this.mContext.startActivity(paramWebView);
          return true;
        }
        catch (ActivityNotFoundException paramWebView)
        {
          acho.d("AbsWebView", paramWebView.toString());
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackv
 * JD-Core Version:    0.7.0.1
 */