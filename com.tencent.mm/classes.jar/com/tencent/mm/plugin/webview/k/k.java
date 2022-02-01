package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
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

public final class k
{
  private static Pattern JBU = null;
  private static String JBV = null;
  private static Boolean JBW = null;
  
  public static boolean bbp(String paramString)
  {
    AppMethodBeat.i(224519);
    if ((WebView.isX5()) && (bbq(paramString)) && (!"true".equals(a.nS("disable_apk_hook", "tools"))))
    {
      AppMethodBeat.o(224519);
      return true;
    }
    AppMethodBeat.o(224519);
    return false;
  }
  
  private static boolean bbq(String paramString)
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
  
  public static boolean bbr(String paramString)
  {
    AppMethodBeat.i(82386);
    boolean bool;
    if ((JBW != null) && (Util.isEqual(paramString, JBV)))
    {
      bool = JBW.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
    }
    JBV = paramString;
    if (Pattern.compile("^(http|https)://" + WeChatHosts.domainString(2131761726) + "/(s|mp/author|mp/appmsg/show)", 2).matcher(paramString).find()) {
      bool = true;
    }
    for (;;)
    {
      paramString = Boolean.valueOf(bool);
      JBW = paramString;
      bool = paramString.booleanValue();
      AppMethodBeat.o(82386);
      return bool;
      if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?" + WeChatHosts.domainString(2131761728) + "/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(paramString).find())
      {
        bool = true;
      }
      else
      {
        if (JBU == null)
        {
          String str = ((b)g.af(b.class)).a(b.a.rSO, "^(http|https)://" + WeChatHosts.domainString(2131761726) + "/mp/(readtemplate\\?t=scanlogin/index_tmpl|scanlogin\\?action=index|relatedarticle\\?action=page|aboutbiz|infringement|qa)");
          Log.i("MicroMsg.WebViewUIUtil", "mpHosts=:%s", new Object[] { str });
          JBU = Pattern.compile(str);
        }
        if ((JBU != null) && (JBU.matcher(paramString).find())) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public static void h(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(224518);
    if (paramMMWebView == null)
    {
      AppMethodBeat.o(224518);
      return;
    }
    if (paramMMWebView.getIsX5Kernel())
    {
      AppMethodBeat.o(224518);
      return;
    }
    if (d.oD(19))
    {
      AppMethodBeat.o(224518);
      return;
    }
    try
    {
      paramMMWebView = new c(paramMMWebView, "mSysWebView", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mProvider", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mWebViewCore", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "sWebCoreHandler", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mLooper", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { paramMMWebView });
      paramMMWebView = new c(paramMMWebView, "mThread", null).get();
      Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { paramMMWebView });
      if ((paramMMWebView instanceof Thread))
      {
        paramMMWebView = (Thread)paramMMWebView;
        Log.i("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { paramMMWebView.getState() });
        if (paramMMWebView.getState() == Thread.State.WAITING) {
          paramMMWebView.interrupt();
        }
      }
      AppMethodBeat.o(224518);
      return;
    }
    catch (Exception paramMMWebView)
    {
      Log.e("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { paramMMWebView });
      AppMethodBeat.o(224518);
    }
  }
  
  public static String ie(Context paramContext)
  {
    AppMethodBeat.i(224516);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).getString("url", null);
    AppMethodBeat.o(224516);
    return paramContext;
  }
  
  public static void jdMethod_if(Context paramContext)
  {
    AppMethodBeat.i(224517);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.remove("url");
    paramContext.apply();
    AppMethodBeat.o(224517);
  }
  
  public static void j(String paramString, Context paramContext)
  {
    AppMethodBeat.i(82384);
    paramContext = paramContext.getSharedPreferences("webview_url_prefs", 4).edit();
    paramContext.putString("url", paramString);
    paramContext.apply();
    AppMethodBeat.o(82384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.k
 * JD-Core Version:    0.7.0.1
 */