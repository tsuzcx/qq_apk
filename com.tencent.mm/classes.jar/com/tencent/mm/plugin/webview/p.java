package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.d.e;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;

public final class p
  implements aa
{
  private static final HashSet<String> PEZ;
  
  static
  {
    AppMethodBeat.i(257227);
    HashSet localHashSet = new HashSet();
    PEZ = localHashSet;
    localHashSet.add("preVerifyJSAPI");
    PEZ.add("openUrlWithExtraWebview");
    PEZ.add("getInstallState");
    PEZ.add("launchApplication");
    PEZ.add("getBrandWCPayRequest");
    PEZ.add("geoLocation");
    PEZ.add("profile");
    PEZ.add("installDownloadTask");
    PEZ.add("pauseDownloadTask");
    PEZ.add("addDownloadTask");
    PEZ.add("addDownloadTaskStraight");
    PEZ.add("resumeDownloadTask");
    PEZ.add("queryDownloadTask");
    PEZ.add("addContact");
    PEZ.add("quicklyAddBrandContact");
    PEZ.add("requestBindPhoneNumber");
    PEZ.add("openWeApp");
    PEZ.add("checkJsApi");
    PEZ.add("getNetworkType");
    AppMethodBeat.o(257227);
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(257216);
    BaseWebViewController.d locald = new BaseWebViewController.d();
    locald.PGW = 69;
    paramMMWebView = new i(paramMMWebView, new ba(), locald, PEZ, null);
    AppMethodBeat.o(257216);
    return paramMMWebView;
  }
  
  public final BaseWebViewController a(MMWebView paramMMWebView, BaseWebViewController.d paramd, e parame)
  {
    AppMethodBeat.i(257217);
    paramMMWebView = new i(paramMMWebView, new ba(), paramd, null, parame);
    AppMethodBeat.o(257217);
    return paramMMWebView;
  }
  
  public final boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(257223);
    boolean bool = new a().c(paramActivity, paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(257223);
    return bool;
  }
  
  public final h b(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(257219);
    try
    {
      if ((paramMMWebView instanceof MMWebViewWithJsApi))
      {
        paramMMWebView = ((MMWebViewWithJsApi)paramMMWebView).getJsapi();
        AppMethodBeat.o(257219);
        return paramMMWebView;
      }
    }
    catch (Throwable paramMMWebView)
    {
      AppMethodBeat.o(257219);
    }
    return null;
  }
  
  public final void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(257222);
    new a().c(paramActivity, paramString);
    AppMethodBeat.o(257222);
  }
  
  public final String gw(String paramString)
  {
    AppMethodBeat.i(257225);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(257225);
      return null;
    }
    String str1 = WeChatHosts.domainString(c.i.host_mp_weixin_qq_com);
    paramString = Uri.parse(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(257225);
      return null;
    }
    if (!Util.isEqual(paramString.getHost(), str1))
    {
      AppMethodBeat.o(257225);
      return null;
    }
    str1 = Util.nullAs(paramString.getQueryParameter("__biz"), "");
    String str2 = Util.nullAs(paramString.getQueryParameter("mid"), "");
    paramString = Util.nullAs(paramString.getQueryParameter("idx"), "");
    if ((str1.length() > 0) && (str2.length() > 0) && (paramString.length() > 0))
    {
      paramString = Util.safeFormatString("id://local/i.html?__biz=%s&mid=%s&idx=%s", new Object[] { str1, str2, paramString });
      AppMethodBeat.o(257225);
      return paramString;
    }
    AppMethodBeat.o(257225);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.p
 * JD-Core Version:    0.7.0.1
 */