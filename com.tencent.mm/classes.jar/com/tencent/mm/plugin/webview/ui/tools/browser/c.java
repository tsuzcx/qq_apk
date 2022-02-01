package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseReporter;", "", "()V", "TAG", "", "reportBrowserChooseDialogAction", "", "sessionId", "", "action", "", "browserCount", "reportBrowserChooseDialogClickBrowser", "clickPosition", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "reportBrowserSettingDialogAction", "reportBrowserSettingDialogResult", "browserItemInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "selectedPosition", "ChooseDialogAction", "SettingDialogAction", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c XaR;
  
  static
  {
    AppMethodBeat.i(296578);
    XaR = new c();
    AppMethodBeat.o(296578);
  }
  
  public static final void A(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(296546);
    Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserChooseDialogAction action: " + paramInt1 + ", browserCount: " + paramInt2);
    h.OAn.b(21454, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    AppMethodBeat.o(296546);
  }
  
  public static final void B(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(296559);
    Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserSettingDialogAction action: " + paramInt1 + ", browserCount: " + paramInt2);
    h.OAn.b(21458, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(0), "", Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(paramLong) });
    AppMethodBeat.o(296559);
  }
  
  public static final void a(long paramLong, int paramInt1, int paramInt2, ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(296552);
    if (paramResolveInfo == null)
    {
      AppMethodBeat.o(296552);
      return;
    }
    Object localObject2 = new StringBuilder("alvinluo reportBrowserChooseDialogClickBrowser clickPosition: ").append(paramInt1).append(", browserCount: ").append(paramInt2).append(", packageName: ");
    Object localObject1 = paramResolveInfo.activityInfo;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.v("MicroMsg.BrowserChooseReporter", localObject1);
      localObject2 = h.OAn;
      paramResolveInfo = paramResolveInfo.activityInfo;
      if (paramResolveInfo != null) {
        break label165;
      }
      paramResolveInfo = "";
    }
    for (;;)
    {
      ((h)localObject2).b(21454, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(0), paramResolveInfo, Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(296552);
      return;
      localObject1 = ((ActivityInfo)localObject1).packageName;
      break;
      label165:
      localObject1 = paramResolveInfo.packageName;
      paramResolveInfo = (ResolveInfo)localObject1;
      if (localObject1 == null) {
        paramResolveInfo = "";
      }
    }
  }
  
  public static final void a(long paramLong, f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(296572);
    if (paramf == null)
    {
      AppMethodBeat.o(296572);
      return;
    }
    int i;
    if (paramf.itemType == 1)
    {
      i = 1;
      paramf = paramf.qK;
      if (paramf != null) {
        break label160;
      }
      paramf = "";
    }
    for (;;)
    {
      Log.v("MicroMsg.BrowserChooseReporter", "alvinluo reportBrowserSettingDialogResult settingResult: " + i + ", selectedPosition: " + paramInt2 + ", packageName: " + paramf);
      h.OAn.b(21458, new Object[] { Integer.valueOf(2), Integer.valueOf(i), paramf, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(296572);
      return;
      if (paramf.itemType == 2)
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label160:
      paramf = paramf.activityInfo;
      if (paramf == null)
      {
        paramf = "";
      }
      else
      {
        String str = paramf.packageName;
        paramf = str;
        if (str == null) {
          paramf = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.c
 * JD-Core Version:    0.7.0.1
 */