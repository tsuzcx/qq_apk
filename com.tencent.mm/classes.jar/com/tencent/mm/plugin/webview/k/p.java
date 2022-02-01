package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ay.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class p
{
  private static Pattern QAD = null;
  private static String QAE = null;
  private static Boolean QAF = null;
  
  public static boolean bno(String paramString)
  {
    AppMethodBeat.i(205901);
    if ((WebView.isX5()) && (bnp(paramString)) && (!"true".equals(a.oO("disable_apk_hook", "tools"))))
    {
      AppMethodBeat.o(205901);
      return true;
    }
    AppMethodBeat.o(205901);
    return false;
  }
  
  private static boolean bnp(String paramString)
  {
    AppMethodBeat.i(82385);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(82385);
      return false;
    }
    try
    {
      paramString = Uri.parse(paramString).getPathSegments();
      if (paramString != null)
      {
        int i = paramString.size();
        if (i > 0) {}
      }
      else
      {
        AppMethodBeat.o(82385);
        return false;
      }
      paramString = (String)paramString.get(paramString.size() - 1);
      if (paramString != null)
      {
        boolean bool = paramString.toLowerCase().trim().endsWith(".apk");
        if (bool)
        {
          AppMethodBeat.o(82385);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(82385);
    }
    return false;
  }
  
  public static boolean bnq(String paramString)
  {
    AppMethodBeat.i(82386);
    boolean bool;
    if ((QAF != null) && (Util.isEqual(paramString, QAE)))
    {
      bool = QAF.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
    }
    QAE = paramString;
    if (Pattern.compile("^(http|https)://" + WeChatHosts.domainString(a.a.host_mp_weixin_qq_com) + "/(s|mp/author|mp/appmsg/show)", 2).matcher(paramString).find()) {
      bool = true;
    }
    for (;;)
    {
      paramString = Boolean.valueOf(bool);
      QAF = paramString;
      bool = paramString.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
      if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?" + WeChatHosts.domainString(a.a.host_open_weixin_qq_com) + "/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(paramString).find())
      {
        bool = true;
      }
      else
      {
        if (QAD == null)
        {
          String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzn, "^(http|https)://" + WeChatHosts.domainString(a.a.host_mp_weixin_qq_com) + "/mp/(readtemplate\\?t=scanlogin/index_tmpl|scanlogin\\?action=index|relatedarticle\\?action=page|aboutbiz|infringement|qa|appmsgalbum)");
          Log.i("MicroMsg.WebViewUIUtil", "mpHosts=:%s", new Object[] { str });
          QAD = Pattern.compile(str);
        }
        if ((QAD != null) && (QAD.matcher(paramString).find())) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public static void h(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(205900);
    if (paramMMWebView == null)
    {
      AppMethodBeat.o(205900);
      return;
    }
    if (paramMMWebView.getIsX5Kernel())
    {
      AppMethodBeat.o(205900);
      return;
    }
    if (d.qV(19))
    {
      AppMethodBeat.o(205900);
      return;
    }
    try
    {
      paramMMWebView = new com.tencent.mm.compatible.loader.b(paramMMWebView, "mSysWebView", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { paramMMWebView });
      paramMMWebView = new com.tencent.mm.compatible.loader.b(paramMMWebView, "mProvider", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { paramMMWebView });
      paramMMWebView = new com.tencent.mm.compatible.loader.b(paramMMWebView, "mWebViewCore", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { paramMMWebView });
      paramMMWebView = new com.tencent.mm.compatible.loader.b(paramMMWebView, "sWebCoreHandler", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { paramMMWebView });
      paramMMWebView = new com.tencent.mm.compatible.loader.b(paramMMWebView, "mLooper", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { paramMMWebView });
      paramMMWebView = new com.tencent.mm.compatible.loader.b(paramMMWebView, "mThread", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { paramMMWebView });
      if ((paramMMWebView instanceof Thread))
      {
        paramMMWebView = (Thread)paramMMWebView;
        Log.i("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { paramMMWebView.getState() });
        if (paramMMWebView.getState() == Thread.State.WAITING) {
          paramMMWebView.interrupt();
        }
      }
      AppMethodBeat.o(205900);
      return;
    }
    catch (Exception paramMMWebView)
    {
      Log.e("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(205900);
    }
  }
  
  public static String jh(Context paramContext)
  {
    AppMethodBeat.i(205898);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).getString("url", null);
    AppMethodBeat.o(205898);
    return paramContext;
  }
  
  public static void ji(Context paramContext)
  {
    AppMethodBeat.i(205899);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.remove("url");
    paramContext.apply();
    AppMethodBeat.o(205899);
  }
  
  public static void l(String paramString, Context paramContext)
  {
    AppMethodBeat.i(82384);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.putString("url", paramString);
    paramContext.apply();
    AppMethodBeat.o(82384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.p
 * JD-Core Version:    0.7.0.1
 */