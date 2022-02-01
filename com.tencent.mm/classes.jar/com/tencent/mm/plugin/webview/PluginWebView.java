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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
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
    if (h.gMM) {}
    for (int i = 2; !h.gMM; i = 1)
    {
      if (j == 2) {
        break label83;
      }
      ac.i("MicroMsg.PluginWebView", "Still 32Bit");
      AppMethodBeat.o(77810);
      return;
    }
    if (j == 2)
    {
      ac.i("MicroMsg.PluginWebView", "Still 64Bit");
      AppMethodBeat.o(77810);
      return;
    }
    label83:
    boolean bool = com.tencent.mm.plugin.webview.j.a.gX(paramg.ca);
    ac.i("MicroMsg.PluginWebView", "result %s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      localSharedPreferences.edit().putInt("last_is_32bit_wechat", i).commit();
    }
    AppMethodBeat.o(77810);
  }
  
  private static void preInitWebViewSafeDuringMMKernelStage(WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(77812);
    paramPreInitCallback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77809);
        d.a(this.CcD);
        AppMethodBeat.o(77809);
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
    if ((paramg.ahL()) || (paramg.up(":tools")) || (paramg.up(":toolsmp"))) {
      pin(new t(com.tencent.mm.plugin.webview.modeltools.g.class));
    }
    if (paramg.ahL())
    {
      o.b("CDNTemp", "CDNTemp", 259200000L, 71);
      o.b("vproxy", "vproxy", 604800000L, 71);
    }
    AppMethodBeat.o(77813);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77811);
    if (paramg.ahL()) {
      abi64WebViewCompat(paramg);
    }
    if ((paramg.ahL()) || (paramg.up(":tools")) || (paramg.up(":toolsmp")))
    {
      com.tencent.mm.plugin.webview.k.g.AY();
      com.tencent.mm.plugin.webview.core.f.AY();
      com.tencent.mm.kernel.g.b(x.class, new b());
    }
    if (paramg.up(":tools"))
    {
      WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.bUy());
      preInitWebViewSafeDuringMMKernelStage(null);
    }
    for (;;)
    {
      if ((paramg.up(":tools")) || (paramg.up(":toolsmp")))
      {
        com.tencent.mm.plugin.webview.c.a locala = com.tencent.mm.plugin.webview.c.a.Cjn;
        com.tencent.mm.plugin.webview.c.a.ezF();
        ac.i("MicroMsg.PluginWebView", "init DefaultJsApiPool");
        com.tencent.mm.plugin.t.a.k(paramg.ca);
      }
      AppMethodBeat.o(77811);
      return;
      if (paramg.up(":toolsmp"))
      {
        WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.bUy());
        preInitWebViewSafeDuringMMKernelStage(new WebView.PreInitCallback()
        {
          public final void aUA()
          {
            AppMethodBeat.i(77808);
            ac.i("MPToolsMinifiedBootStep", "onCoreInitFailed");
            AppMethodBeat.o(77808);
          }
          
          public final void onCoreInitFinished()
          {
            AppMethodBeat.i(77807);
            ac.i("MPToolsMinifiedBootStep", "onCoreInitFinished");
            if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(20)) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIS();
            }
            AppMethodBeat.o(77807);
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