package com.tencent.mm.plugin.webview;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.cq.d;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;

public class PluginWebView
  extends com.tencent.mm.kernel.b.f
{
  private void abi64WebViewCompat(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77810);
    SharedPreferences localSharedPreferences = paramg.ca.getSharedPreferences("abi64_webview_compat_sp", 0);
    int j = localSharedPreferences.getInt("last_is_32bit_wechat", 0);
    if (i.hgJ) {
      i = 2;
    }
    while (!i.hgJ) {
      if (j != 2)
      {
        ad.i("MicroMsg.PluginWebView", "Still 32Bit");
        AppMethodBeat.o(77810);
        return;
        i = 1;
      }
      else
      {
        j = 0;
        boolean bool = com.tencent.mm.plugin.webview.j.a.hc(paramg.ca);
        ad.i("MicroMsg.PluginWebView", "result %s", new Object[] { Boolean.valueOf(bool) });
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
      if (paramg.akw()) {
        com.tencent.mm.kernel.g.ajD().a(new com.tencent.mm.kernel.api.g()
        {
          public final void MP()
          {
            AppMethodBeat.i(207800);
            com.tencent.mm.kernel.g.ajD().b(this);
            e.ygI.idkeyStat(661L, i, 1L, false);
            AppMethodBeat.o(207800);
          }
          
          public final void cg(boolean paramAnonymousBoolean) {}
        });
      }
      AppMethodBeat.o(77810);
      return;
      if (j == 2)
      {
        ad.i("MicroMsg.PluginWebView", "Still 64Bit");
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
        AppMethodBeat.i(207803);
        d.a(this.DFD);
        AppMethodBeat.o(207803);
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
    if ((paramg.akw()) || (paramg.xf(":tools")) || (paramg.xf(":toolsmp"))) {
      pin(new t(com.tencent.mm.plugin.webview.modeltools.g.class));
    }
    if (paramg.akw())
    {
      o.b("CDNTemp", "CDNTemp", 259200000L, 71);
      o.b("vproxy", "vproxy", 604800000L, 71);
    }
    AppMethodBeat.o(77813);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77811);
    Object localObject;
    if (paramg.akw())
    {
      abi64WebViewCompat(paramg);
      localObject = com.tencent.mm.plugin.webcanvas.g.Dzc;
      com.tencent.mm.plugin.webcanvas.g.eLr();
      localObject = com.tencent.mm.plugin.webcanvas.g.Dzc;
      com.tencent.mm.plugin.webcanvas.g.uN(false);
    }
    if ((paramg.akw()) || (paramg.xf(":tools")) || (paramg.xf(":toolsmp")))
    {
      com.tencent.mm.plugin.webview.k.g.Cx();
      com.tencent.mm.plugin.webview.core.f.Cx();
      localObject = com.tencent.mm.plugin.webview.c.a.DMt;
      com.tencent.mm.plugin.webview.c.a.eOu();
      ad.i("MicroMsg.PluginWebView", "init DefaultJsApiPool");
      com.tencent.mm.kernel.g.b(x.class, new b());
    }
    if (paramg.xf(":tools"))
    {
      WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.bZd());
      preInitWebViewSafeDuringMMKernelStage(null);
    }
    for (;;)
    {
      if ((paramg.xf(":tools")) || (paramg.xf(":toolsmp"))) {
        com.tencent.mm.plugin.t.a.m(paramg.ca);
      }
      AppMethodBeat.o(77811);
      return;
      if (paramg.xf(":toolsmp"))
      {
        WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.bZd());
        preInitWebViewSafeDuringMMKernelStage(new WebView.PreInitCallback()
        {
          public final void aXM()
          {
            AppMethodBeat.i(207802);
            ad.i("MPToolsMinifiedBootStep", "onCoreInitFailed");
            AppMethodBeat.o(207802);
          }
          
          public final void onCoreInitFinished()
          {
            AppMethodBeat.i(207801);
            ad.i("MPToolsMinifiedBootStep", "onCoreInitFinished");
            if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(20)) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNj();
            }
            AppMethodBeat.o(207801);
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