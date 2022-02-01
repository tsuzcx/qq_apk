package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.d.e;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;

public final class b
  implements aa
{
  private static final HashSet<String> IJs;
  
  static
  {
    AppMethodBeat.i(210815);
    HashSet localHashSet = new HashSet();
    IJs = localHashSet;
    localHashSet.add("preVerifyJSAPI");
    IJs.add("openUrlWithExtraWebview");
    IJs.add("getInstallState");
    IJs.add("launchApplication");
    IJs.add("getBrandWCPayRequest");
    IJs.add("geoLocation");
    IJs.add("profile");
    IJs.add("installDownloadTask");
    IJs.add("pauseDownloadTask");
    IJs.add("addDownloadTask");
    IJs.add("addDownloadTaskStraight");
    IJs.add("resumeDownloadTask");
    IJs.add("queryDownloadTask");
    IJs.add("addContact");
    IJs.add("quicklyAddBrandContact");
    IJs.add("requestBindPhoneNumber");
    IJs.add("openWeApp");
    IJs.add("checkJsApi");
    IJs.add("getNetworkType");
    AppMethodBeat.o(210815);
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(210809);
    BaseWebViewController.c localc = new BaseWebViewController.c();
    localc.IKX = 69;
    paramMMWebView = new i(paramMMWebView, new az(), localc, IJs, null);
    AppMethodBeat.o(210809);
    return paramMMWebView;
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView, BaseWebViewController.c paramc, e parame)
  {
    AppMethodBeat.i(210810);
    paramMMWebView = new i(paramMMWebView, new az(), paramc, null, parame);
    AppMethodBeat.o(210810);
    return paramMMWebView;
  }
  
  public final boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(210813);
    boolean bool = new a().d(paramActivity, paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(210813);
    return bool;
  }
  
  public final h b(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(210811);
    try
    {
      if ((paramMMWebView instanceof MMWebViewWithJsApi))
      {
        paramMMWebView = ((MMWebViewWithJsApi)paramMMWebView).getJsapi();
        AppMethodBeat.o(210811);
        return paramMMWebView;
      }
    }
    catch (Throwable paramMMWebView)
    {
      AppMethodBeat.o(210811);
    }
    return null;
  }
  
  public final void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(210812);
    new a().c(paramActivity, paramString);
    AppMethodBeat.o(210812);
  }
  
  public final String fM(String paramString)
  {
    AppMethodBeat.i(210814);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(210814);
      return null;
    }
    String str1 = WeChatHosts.domainString(2131761726);
    paramString = Uri.parse(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(210814);
      return null;
    }
    if (!Util.isEqual(paramString.getHost(), str1))
    {
      AppMethodBeat.o(210814);
      return null;
    }
    str1 = Util.nullAs(paramString.getQueryParameter("__biz"), "");
    String str2 = Util.nullAs(paramString.getQueryParameter("mid"), "");
    paramString = Util.nullAs(paramString.getQueryParameter("idx"), "");
    if ((str1.length() > 0) && (str2.length() > 0) && (paramString.length() > 0))
    {
      paramString = Util.safeFormatString("id://local/i.html?__biz=%s&mid=%s&idx=%s", new Object[] { str1, str2, paramString });
      AppMethodBeat.o(210814);
      return paramString;
    }
    AppMethodBeat.o(210814);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b
 * JD-Core Version:    0.7.0.1
 */