package com.tencent.mm.plugin.webview;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.cp.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.webcanvas.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
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
    if (j.hjx) {
      i = 2;
    }
    while (!j.hjx) {
      if (j != 2)
      {
        ae.i("MicroMsg.PluginWebView", "Still 32Bit");
        AppMethodBeat.o(77810);
        return;
        i = 1;
      }
      else
      {
        j = 0;
        boolean bool = com.tencent.mm.plugin.webview.j.a.hi(paramg.ca);
        ae.i("MicroMsg.PluginWebView", "result %s", new Object[] { Boolean.valueOf(bool) });
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
      if (paramg.akL()) {
        com.tencent.mm.kernel.g.ajS().a(new com.tencent.mm.kernel.api.g()
        {
          public final void ML()
          {
            AppMethodBeat.i(197974);
            com.tencent.mm.kernel.g.ajS().b(this);
            e.ywz.idkeyStat(661L, i, 1L, false);
            AppMethodBeat.o(197974);
          }
          
          public final void ch(boolean paramAnonymousBoolean) {}
        });
      }
      AppMethodBeat.o(77810);
      return;
      if (j == 2)
      {
        ae.i("MicroMsg.PluginWebView", "Still 64Bit");
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
        AppMethodBeat.i(197977);
        d.a(this.DXA);
        AppMethodBeat.o(197977);
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
    if ((paramg.akL()) || (paramg.xO(":tools")) || (paramg.xO(":toolsmp"))) {
      pin(new com.tencent.mm.model.u(com.tencent.mm.plugin.webview.modeltools.g.class));
    }
    if (paramg.akL())
    {
      com.tencent.mm.vfs.u.b("CDNTemp", "CDNTemp", 259200000L, 71);
      com.tencent.mm.vfs.u.b("vproxy", "vproxy", 604800000L, 71);
    }
    AppMethodBeat.o(77813);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77811);
    Object localObject;
    if (paramg.akL())
    {
      abi64WebViewCompat(paramg);
      localObject = h.DQL;
      h.ePa();
      localObject = h.DQL;
      h.uV(false);
    }
    if ((paramg.akL()) || (paramg.xO(":tools")) || (paramg.xO(":toolsmp")))
    {
      com.tencent.mm.plugin.webview.k.g.CA();
      com.tencent.mm.plugin.webview.core.f.CA();
      localObject = com.tencent.mm.plugin.webview.c.a.Eer;
      com.tencent.mm.plugin.webview.c.a.eSf();
      ae.i("MicroMsg.PluginWebView", "init DefaultJsApiPool");
      com.tencent.mm.kernel.g.b(x.class, new b());
    }
    if (paramg.xO(":tools"))
    {
      WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cas());
      preInitWebViewSafeDuringMMKernelStage(null);
    }
    for (;;)
    {
      if ((paramg.xO(":tools")) || (paramg.xO(":toolsmp"))) {
        com.tencent.mm.plugin.t.a.n(paramg.ca);
      }
      AppMethodBeat.o(77811);
      return;
      if (paramg.xO(":toolsmp"))
      {
        WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cas());
        preInitWebViewSafeDuringMMKernelStage(new WebView.PreInitCallback()
        {
          public final void aYf()
          {
            AppMethodBeat.i(197976);
            ae.i("MPToolsMinifiedBootStep", "onCoreInitFailed");
            AppMethodBeat.o(197976);
          }
          
          public final void onCoreInitFinished()
          {
            AppMethodBeat.i(197975);
            ae.i("MPToolsMinifiedBootStep", "onCoreInitFinished");
            if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(20)) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOh();
            }
            AppMethodBeat.o(197975);
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