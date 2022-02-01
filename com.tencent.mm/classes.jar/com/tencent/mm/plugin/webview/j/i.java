package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i
{
  private static Pattern CPF = null;
  
  public static boolean aEb(String paramString)
  {
    AppMethodBeat.i(205405);
    if ((WebView.isX5()) && (aEc(paramString)) && (!"true".equals(a.mx("disable_apk_hook", "tools"))))
    {
      AppMethodBeat.o(205405);
      return true;
    }
    AppMethodBeat.o(205405);
    return false;
  }
  
  private static boolean aEc(String paramString)
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
  
  public static boolean aEd(String paramString)
  {
    AppMethodBeat.i(82386);
    if (Pattern.compile("^(http|https)://mp.weixin.qq.com/(s|mp/author|mp/appmsg/show)", 2).matcher(paramString).find())
    {
      AppMethodBeat.o(82386);
      return true;
    }
    if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?open.weixin.qq.com/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(paramString).find())
    {
      AppMethodBeat.o(82386);
      return true;
    }
    if (CPF == null)
    {
      String str = ((b)g.ab(b.class)).a(b.a.pPM, "^(http|https)://mp.weixin.qq.com/mp/(readtemplate\\?t=scanlogin/index_tmpl|scanlogin\\?action=index|relatedarticle\\?action=page|aboutbiz|infringement|qa)");
      ac.i("MicroMsg.WebViewUIUtil", "mpHosts=:%s", new Object[] { str });
      CPF = Pattern.compile(str);
    }
    if ((CPF != null) && (CPF.matcher(paramString).find()))
    {
      AppMethodBeat.o(82386);
      return true;
    }
    AppMethodBeat.o(82386);
    return false;
  }
  
  public static void f(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(205404);
    if (paramMMWebView == null)
    {
      AppMethodBeat.o(205404);
      return;
    }
    if (paramMMWebView.getIsX5Kernel())
    {
      AppMethodBeat.o(205404);
      return;
    }
    if (d.kZ(19))
    {
      AppMethodBeat.o(205404);
      return;
    }
    try
    {
      paramMMWebView = new c(paramMMWebView, "mSysWebView", null).get();
      ac.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mProvider", null).get();
      ac.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mWebViewCore", null).get();
      ac.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "sWebCoreHandler", null).get();
      ac.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mLooper", null).get();
      ac.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mThread", null).get();
      ac.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { paramMMWebView });
      if ((paramMMWebView instanceof Thread))
      {
        paramMMWebView = (Thread)paramMMWebView;
        ac.i("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { paramMMWebView.getState() });
        if (paramMMWebView.getState() == Thread.State.WAITING) {
          paramMMWebView.interrupt();
        }
      }
      AppMethodBeat.o(205404);
      return;
    }
    catch (Exception paramMMWebView)
    {
      ac.e("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(205404);
    }
  }
  
  public static String gZ(Context paramContext)
  {
    AppMethodBeat.i(205402);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).getString("url", null);
    AppMethodBeat.o(205402);
    return paramContext;
  }
  
  public static void h(String paramString, Context paramContext)
  {
    AppMethodBeat.i(82384);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.putString("url", paramString);
    paramContext.apply();
    AppMethodBeat.o(82384);
  }
  
  public static void ha(Context paramContext)
  {
    AppMethodBeat.i(205403);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.remove("url");
    paramContext.apply();
    AppMethodBeat.o(205403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.i
 * JD-Core Version:    0.7.0.1
 */