package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseReporter;", "", "()V", "TAG", "", "reportBrowserChooseDialogAction", "", "sessionId", "", "action", "", "browserCount", "reportBrowserChooseDialogClickBrowser", "clickPosition", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "reportBrowserSettingDialogAction", "reportBrowserSettingDialogResult", "browserItemInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "selectedPosition", "ChooseDialogAction", "SettingDialogAction", "plugin-webview_release"})
public final class c
{
  public static final c QiU;
  
  static
  {
    AppMethodBeat.i(266743);
    QiU = new c();
    AppMethodBeat.o(266743);
  }
  
  public static final void a(long paramLong, int paramInt1, int paramInt2, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(266740);
    if (paramResolveInfo == null)
    {
      AppMethodBeat.o(266740);
      return;
    }
    Object localObject2 = new StringBuilder("alvinluo reportBrowserChooseDialogClickBrowser clickPosition: ").append(paramInt1).append(", browserCount: ").append(paramInt2).append(", packageName: ");
    Object localObject1 = paramResolveInfo.activityInfo;
    if (localObject1 != null) {}
    for (localObject1 = ((ActivityInfo)localObject1).packageName;; localObject1 = null)
    {
      Log.v("MicroMsg.BrowserChooseReporter", (String)localObject1);
      localObject2 = h.IzE;
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
      AppMethodBeat.o(266740);
      return;
    }
  }
  
  public static final void a(long paramLong, f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266742);
    if (paramf == null)
    {
      AppMethodBeat.o(266742);
      return;
    }
    int i;
    if (paramf.fNO == 1) {
      i = 1;
    }
    for (;;)
    {
      paramf = paramf.pN;
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
      h.IzE.a(21458, new Object[] { Integer.valueOf(2), Integer.valueOf(i), paramf, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(266742);
      return;
      if (paramf.fNO == 2) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static final void r(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266739);
    Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserChooseDialogAction action: " + paramInt1 + ", browserCount: " + paramInt2);
    h.IzE.a(21454, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(266739);
  }
  
  public static final void s(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266741);
    Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserSettingDialogAction action: " + paramInt1 + ", browserCount: " + paramInt2);
    h.IzE.a(21458, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), "", Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong) });
    AppMethodBeat.o(266741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.c
 * JD-Core Version:    0.7.0.1
 */