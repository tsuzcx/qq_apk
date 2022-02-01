package com.unionpay;

import android.app.Activity;
import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.unionpay.utils.j;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class b
  implements Serializable
{
  WebView aimg;
  x aisF;
  Map aisG;
  Map aisH;
  long aisI;
  boolean aisJ;
  Activity mContext;
  
  public b(Activity paramActivity, WebView paramWebView)
  {
    AppMethodBeat.i(207301);
    this.aisJ = false;
    this.mContext = paramActivity;
    this.aimg = paramWebView;
    this.aisF = null;
    this.aisG = new HashMap();
    this.aisH = new HashMap();
    this.aisI = 0L;
    paramActivity = this.aimg.getSettings();
    paramActivity.setJavaScriptEnabled(true);
    paramActivity.setSavePassword(false);
    paramActivity.setAllowFileAccess(false);
    paramActivity.setDomStorageEnabled(true);
    try
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.aimg.removeJavascriptInterface("accessibility");
        this.aimg.removeJavascriptInterface("accessibilityTraversal");
        this.aimg.removeJavascriptInterface("searchBoxJavaBridge_");
      }
      label119:
      this.aimg.addJavascriptInterface(this, "_WebViewJavascriptBridge");
      this.aimg.setWebViewClient(new w(this, (byte)0));
      this.aimg.setWebChromeClient(new t(this, (byte)0));
      AppMethodBeat.o(207301);
      return;
    }
    finally
    {
      break label119;
    }
  }
  
  @JavascriptInterface
  public final void _handleMessageFromJs(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(207357);
    if (paramString2 != null)
    {
      ((y)this.aisH.get(paramString2)).a(paramString3);
      this.aisH.remove(paramString2);
      AppMethodBeat.o(207357);
      return;
    }
    if (paramString4 != null) {}
    for (paramString2 = new v(this, paramString4);; paramString2 = null)
    {
      if (paramString5 != null)
      {
        paramString4 = (x)this.aisG.get(paramString5);
        paramString3 = paramString4;
        if (paramString4 == null)
        {
          j.b("test", "WVJB Warning: No handler for ".concat(String.valueOf(paramString5)));
          AppMethodBeat.o(207357);
        }
      }
      else
      {
        paramString3 = this.aisF;
      }
      try
      {
        this.mContext.runOnUiThread(new s(this, paramString3, paramString1, paramString2));
        AppMethodBeat.o(207357);
        return;
      }
      catch (Exception paramString1)
      {
        j.b("test", "WebViewJavascriptBridge: WARNING: java handler threw. " + paramString1.getMessage());
        AppMethodBeat.o(207357);
        return;
      }
    }
  }
  
  public final void a(String paramString, x paramx)
  {
    AppMethodBeat.i(207340);
    this.aisG.put(paramString, paramx);
    AppMethodBeat.o(207340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.b
 * JD-Core Version:    0.7.0.1
 */