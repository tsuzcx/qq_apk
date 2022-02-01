package com.tencent.mm.plugin.webview;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ab;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;

public class PluginWebView
  extends com.tencent.mm.kernel.b.f
{
  private void abi64WebViewCompat(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77810);
    SharedPreferences localSharedPreferences = paramg.Zw.getSharedPreferences("abi64_webview_compat_sp", 0);
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
        boolean bool = com.tencent.mm.plugin.webview.k.a.je(paramg.Zw);
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
      if (paramg.aIE()) {
        h.aHH().a(new com.tencent.mm.kernel.api.g()
        {
          public final void abB()
          {
            AppMethodBeat.i(265091);
            h.aHH().b(this);
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(661L, i, 1L, false);
            AppMethodBeat.o(265091);
          }
          
          public final void dn(boolean paramAnonymousBoolean) {}
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
        AppMethodBeat.i(267885);
        com.tencent.mm.xwebutil.c.a(this.PDG);
        AppMethodBeat.o(267885);
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
    if ((paramg.aIE()) || (paramg.MY(":tools")) || (paramg.MY(":toolsmp"))) {
      pin(new y(com.tencent.mm.plugin.webview.modeltools.f.class));
    }
    if (paramg.aIE())
    {
      ab.a("CDNTemp", "CDNTemp", 259200000L, 69);
      ab.a("vproxy", "vproxy", 604800000L, 69);
    }
    AppMethodBeat.o(77813);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77811);
    Object localObject;
    if (paramg.aIE())
    {
      abi64WebViewCompat(paramg);
      localObject = m.PuL;
      m.gPv();
      localObject = m.PuL;
      m.CF(false);
      localObject = d.Qkh;
      d.gUX();
    }
    if ((paramg.aIE()) || (paramg.MY(":tools")) || (paramg.MY(":toolsmp")))
    {
      com.tencent.mm.plugin.webview.l.g.OO();
      com.tencent.mm.plugin.webview.core.g.OO();
      localObject = com.tencent.mm.plugin.webview.d.a.PNm;
      com.tencent.mm.plugin.webview.d.a.gTJ();
      Log.i("MicroMsg.PluginWebView", "init DefaultJsApiPool");
      h.b(aa.class, new p());
    }
    if (paramg.MY(":tools"))
    {
      WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cME());
      preInitWebViewSafeDuringMMKernelStage(null);
    }
    for (;;)
    {
      if ((paramg.MY(":tools")) || (paramg.MY(":toolsmp"))) {
        com.tencent.mm.plugin.ac.a.p(paramg.Zw);
      }
      AppMethodBeat.o(77811);
      return;
      if (paramg.MY(":toolsmp"))
      {
        WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cME());
        preInitWebViewSafeDuringMMKernelStage(new WebView.PreInitCallback()
        {
          public final void bEj()
          {
            AppMethodBeat.i(268007);
            Log.i("MPToolsMinifiedBootStep", "onCoreInitFailed");
            AppMethodBeat.o(268007);
          }
          
          public final void onCoreInitFinished()
          {
            AppMethodBeat.i(268005);
            Log.i("MPToolsMinifiedBootStep", "onCoreInitFinished");
            if (((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(20)) {
              ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyD();
            }
            AppMethodBeat.o(268005);
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