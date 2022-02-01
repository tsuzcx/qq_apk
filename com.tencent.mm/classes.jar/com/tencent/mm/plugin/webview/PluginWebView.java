package com.tencent.mm.plugin.webview;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;

public class PluginWebView
  extends f
{
  private void abi64WebViewCompat(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77810);
    SharedPreferences localSharedPreferences = paramg.ca.getSharedPreferences("abi64_webview_compat_sp", 0);
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
        boolean bool = com.tencent.mm.plugin.webview.k.a.ic(paramg.ca);
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
      if (paramg.aBb()) {
        com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g()
        {
          public final void WY()
          {
            AppMethodBeat.i(210805);
            com.tencent.mm.kernel.g.aAi().b(this);
            e.Cxv.idkeyStat(661L, i, 1L, false);
            AppMethodBeat.o(210805);
          }
          
          public final void cQ(boolean paramAnonymousBoolean) {}
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
        AppMethodBeat.i(210808);
        com.tencent.mm.cr.d.a(this.IJr);
        AppMethodBeat.o(210808);
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
    if ((paramg.aBb()) || (paramg.FY(":tools")) || (paramg.FY(":toolsmp"))) {
      pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.webview.modeltools.g.class));
    }
    if (paramg.aBb())
    {
      com.tencent.mm.vfs.y.b("CDNTemp", "CDNTemp", 259200000L, 71);
      com.tencent.mm.vfs.y.b("vproxy", "vproxy", 604800000L, 71);
    }
    AppMethodBeat.o(77813);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(77811);
    Object localObject;
    if (paramg.aBb())
    {
      abi64WebViewCompat(paramg);
      localObject = m.IAG;
      m.fWN();
      localObject = m.IAG;
      m.yK(false);
      localObject = com.tencent.mm.plugin.webview.ui.tools.floatball.d.JmQ;
      com.tencent.mm.plugin.webview.ui.tools.floatball.d.gcb();
    }
    if ((paramg.aBb()) || (paramg.FY(":tools")) || (paramg.FY(":toolsmp")))
    {
      com.tencent.mm.plugin.webview.l.g.LW();
      com.tencent.mm.plugin.webview.core.g.LW();
      localObject = com.tencent.mm.plugin.webview.d.a.IQX;
      com.tencent.mm.plugin.webview.d.a.gaR();
      Log.i("MicroMsg.PluginWebView", "init DefaultJsApiPool");
      com.tencent.mm.kernel.g.b(aa.class, new b());
    }
    if (paramg.FY(":tools"))
    {
      WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cyj());
      preInitWebViewSafeDuringMMKernelStage(null);
    }
    for (;;)
    {
      if ((paramg.FY(":tools")) || (paramg.FY(":toolsmp"))) {
        com.tencent.mm.plugin.s.a.m(paramg.ca);
      }
      AppMethodBeat.o(77811);
      return;
      if (paramg.FY(":toolsmp"))
      {
        WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cyj());
        preInitWebViewSafeDuringMMKernelStage(new WebView.PreInitCallback()
        {
          public final void btl()
          {
            AppMethodBeat.i(210807);
            Log.i("MPToolsMinifiedBootStep", "onCoreInitFailed");
            AppMethodBeat.o(210807);
          }
          
          public final void onCoreInitFinished()
          {
            AppMethodBeat.i(210806);
            Log.i("MPToolsMinifiedBootStep", "onCoreInitFinished");
            if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(20)) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clg();
            }
            AppMethodBeat.o(210806);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.PluginWebView
 * JD-Core Version:    0.7.0.1
 */