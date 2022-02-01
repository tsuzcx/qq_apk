package com.tencent.mm.plugin.webview.ui.tools.browser.storage;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/storage/BrowserSettingStorageManager;", "", "()V", "TAG", "", "getBrowserConfigId", "", "configId", "getDefaultBrowser", "saveDefaultBrowser", "", "selectedInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "packageName", "plugin-webview_release"})
public final class a
{
  public static final a Qjh;
  
  static
  {
    AppMethodBeat.i(267666);
    Qjh = new a();
    AppMethodBeat.o(267666);
  }
  
  public static final void a(com.tencent.mm.plugin.webview.ui.tools.browser.f paramf)
  {
    AppMethodBeat.i(267663);
    p.k(paramf, "selectedInfo");
    if (paramf.fNO == 1)
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
            break label51;
          }
        }
      }
      paramf = "";
      label51:
      bmA(paramf);
      AppMethodBeat.o(267663);
      return;
    }
    if (paramf.fNO == 2) {
      bmA("");
    }
    AppMethodBeat.o(267663);
  }
  
  private static void bmA(String paramString)
  {
    AppMethodBeat.i(267665);
    try
    {
      Log.i("MicroMsg.BrowserSettingStorageManager", "alvinluo saveDefaultBrowser packageName: %s", new Object[] { paramString });
      com.tencent.mm.kernel.f localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().i(274528, paramString);
      AppMethodBeat.o(267665);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(267665);
    }
  }
  
  public static final String gZJ()
  {
    AppMethodBeat.i(267664);
    try
    {
      Object localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.f)localObject).aHp().b(274528, "");
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(267664);
        return localObject;
      }
      AppMethodBeat.o(267664);
      return "";
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(267664);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.storage.a
 * JD-Core Version:    0.7.0.1
 */