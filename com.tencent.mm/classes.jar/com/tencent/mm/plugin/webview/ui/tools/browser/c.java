package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseReporter;", "", "()V", "TAG", "", "reportBrowserChooseDialogAction", "", "sessionId", "", "action", "", "browserCount", "reportBrowserChooseDialogClickBrowser", "clickPosition", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "reportBrowserSettingDialogAction", "reportBrowserSettingDialogResult", "browserItemInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "selectedPosition", "ChooseDialogAction", "SettingDialogAction", "plugin-webview_release"})
public final class c
{
  public static final c JlC;
  
  static
  {
    AppMethodBeat.i(210420);
    JlC = new c();
    AppMethodBeat.o(210420);
  }
  
  public static final void a(long paramLong, int paramInt1, int paramInt2, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(210417);
    if (paramResolveInfo == null)
    {
      AppMethodBeat.o(210417);
      return;
    }
    Object localObject2 = new StringBuilder("alvinluo reportBrowserChooseDialogClickBrowser clickPosition: ").append(paramInt1).append(", browserCount: ").append(paramInt2).append(", packageName: ");
    Object localObject1 = paramResolveInfo.activityInfo;
    if (localObject1 != null) {}
    for (localObject1 = ((ActivityInfo)localObject1).packageName;; localObject1 = null)
    {
      Log.v("MicroMsg.BrowserChooseReporter", (String)localObject1);
      localObject2 = h.CyF;
      paramResolveInfo = paramResolveInfo.activityInfo;
      if (paramResolveInfo != null)
      {
        localObject1 = paramResolveInfo.packageName;
        paramResolveInfo = (ResolveInfo)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramResolveInfo = "";
      }
      ((h)localObject2).a(21454, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(0), paramResolveInfo, Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(210417);
      return;
    }
  }
  
  public static final void a(long paramLong, f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210419);
    if (paramf == null)
    {
      AppMethodBeat.o(210419);
      return;
    }
    int i;
    if (paramf.dUm == 1) {
      i = 1;
    }
    for (;;)
    {
      paramf = paramf.resolveInfo;
      if (paramf != null)
      {
        paramf = paramf.activityInfo;
        if (paramf != null)
        {
          String str = paramf.packageName;
          paramf = str;
          if (str != null) {
            break label61;
          }
        }
      }
      paramf = "";
      label61:
      Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserSettingDialogResult settingResult: " + i + ", selectedPosition: " + paramInt2 + ", packageName: " + paramf);
      h.CyF.a(21458, new Object[] { Integer.valueOf(2), Integer.valueOf(i), paramf, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(210419);
      return;
      if (paramf.dUm == 2) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static final void q(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210416);
    Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserChooseDialogAction action: " + paramInt1 + ", browserCount: " + paramInt2);
    h.CyF.a(21454, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(210416);
  }
  
  public static final void r(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210418);
    Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserSettingDialogAction action: " + paramInt1 + ", browserCount: " + paramInt2);
    h.CyF.a(21458, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), "", Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong) });
    AppMethodBeat.o(210418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.c
 * JD-Core Version:    0.7.0.1
 */