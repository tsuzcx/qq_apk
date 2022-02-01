package com.tencent.mm.plugin.webview;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.jsapi.b;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.af;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.ao;

public class PluginWebView
  extends com.tencent.mm.kernel.b.f
{
  private void abi64WebViewCompat(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77810);
    SharedPreferences localSharedPreferences = paramg.bGP.getSharedPreferences("abi64_webview_compat_sp", 0);
    int j = localSharedPreferences.getInt("last_is_32bit_wechat", 0);
    if (BuildInfo.IS_ARM64) {
      i = 2;
    }
    while (!BuildInfo.IS_ARM64) {
      if (j != 2)
      {
        Log.i("MicroMsg.PluginWebView", "Still 32Bit");
        AppMethodBeat.o(77810);
        return;
        i = 1;
      }
      else
      {
        j = 0;
        boolean bool = com.tencent.mm.plugin.webview.k.a.le(paramg.bGP);
        Log.i("MicroMsg.PluginWebView", "result %s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          localSharedPreferences.edit().putInt("last_is_32bit_wechat", i).commit();
        }
        if (j == 0) {
          break label179;
        }
      }
    }
    label179:
    for (final int i = 8;; i = 9)
    {
      if (paramg.bbA()) {
        h.baF().a(new com.tencent.mm.kernel.api.g()
        {
          public final void aDv()
          {
            AppMethodBeat.i(294628);
            h.baF().b(this);
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(661L, i, 1L, false);
            AppMethodBeat.o(294628);
          }
          
          public final void dZ(boolean paramAnonymousBoolean) {}
        });
      }
      AppMethodBeat.o(77810);
      return;
      if (j == 2)
      {
        Log.i("MicroMsg.PluginWebView", "Still 64Bit");
        AppMethodBeat.o(77810);
        return;
      }
      j = 1;
      break;
    }
  }
  
  private static void preInitWebViewSafeDuringMMKernelStage(WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(77812);
    paramPreInitCallback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(294568);
        com.tencent.mm.xwebutil.c.a(PluginWebView.this);
        AppMethodBeat.o(294568);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramPreInitCallback.run();
      AppMethodBeat.o(77812);
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramPreInitCallback);
    AppMethodBeat.o(77812);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77813);
    if ((paramg.bbA()) || (paramg.FH(":tools")) || (paramg.FH(":toolsmp"))) {
      pin(new y(com.tencent.mm.plugin.webview.modeltools.g.class));
    }
    if (paramg.bbA())
    {
      af.a("CDNTemp", "CDNTemp", 259200000L, 69);
      af.a("vproxy", "vproxy", 604800000L, 69);
      af.b("WebCanvasPkg", "WebCanvasPkg", 134217728L, 7776000000L, 518);
      af.b("WebPrefetcherPkg", "WebPrefetcherPkg", 134217728L, 7776000000L, 518);
    }
    AppMethodBeat.o(77813);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77811);
    Object localObject;
    if (paramg.bbA())
    {
      abi64WebViewCompat(paramg);
      localObject = k.WkZ;
      k.hBK();
      localObject = k.WkZ;
      k.Ik(false);
      localObject = d.XbW;
      d.iuI();
    }
    if ((paramg.bbA()) || (paramg.FH(":tools")) || (paramg.FH(":toolsmp")))
    {
      com.tencent.mm.plugin.webview.l.f.aoW();
      i.aoW();
      localObject = b.WDu;
      b.its();
      localObject = com.tencent.mm.plugin.webview.ui.tools.newjsapi.webprefetcher.a.Xoe;
      com.tencent.mm.plugin.webview.ui.tools.newjsapi.webprefetcher.a.its();
      Log.i("MicroMsg.PluginWebView", "init DefaultJsApiPool");
      h.b(ab.class, new p());
    }
    if (paramg.FH(":tools"))
    {
      ao.a(com.tencent.mm.plugin.cdndownloader.i.a.dqi());
      preInitWebViewSafeDuringMMKernelStage(null);
    }
    for (;;)
    {
      if ((paramg.FH(":tools")) || (paramg.FH(":toolsmp"))) {
        com.tencent.mm.plugin.ad.a.p(paramg.bGP);
      }
      AppMethodBeat.o(77811);
      return;
      if (paramg.FH(":toolsmp"))
      {
        ao.a(com.tencent.mm.plugin.cdndownloader.i.a.dqi());
        preInitWebViewSafeDuringMMKernelStage(new WebView.PreInitCallback()
        {
          public final void aDm()
          {
            AppMethodBeat.i(294559);
            Log.i("MPToolsMinifiedBootStep", "onCoreInitFailed");
            AppMethodBeat.o(294559);
          }
          
          public final void onCoreInitFinished()
          {
            AppMethodBeat.i(294555);
            Log.i("MPToolsMinifiedBootStep", "onCoreInitFinished");
            if (((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(20)) {
              ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbA();
            }
            AppMethodBeat.o(294555);
          }
        });
      }
    }
  }
  
  public String name()
  {
    return "plugin-webview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.PluginWebView
 * JD-Core Version:    0.7.0.1
 */