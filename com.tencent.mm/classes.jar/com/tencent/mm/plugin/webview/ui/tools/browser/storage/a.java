package com.tencent.mm.plugin.webview.ui.tools.browser.storage;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/storage/BrowserSettingStorageManager;", "", "()V", "TAG", "", "getBrowserConfigId", "", "configId", "getDefaultBrowser", "saveDefaultBrowser", "", "selectedInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "packageName", "plugin-webview_release"})
public final class a
{
  public static final a JlP;
  
  static
  {
    AppMethodBeat.i(210445);
    JlP = new a();
    AppMethodBeat.o(210445);
  }
  
  public static final void a(f paramf)
  {
    AppMethodBeat.i(210442);
    p.h(paramf, "selectedInfo");
    if (paramf.dUm == 1)
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
            break label51;
          }
        }
      }
      paramf = "";
      label51:
      baC(paramf);
      AppMethodBeat.o(210442);
      return;
    }
    if (paramf.dUm == 2) {
      baC("");
    }
    AppMethodBeat.o(210442);
  }
  
  private static void baC(String paramString)
  {
    AppMethodBeat.i(210444);
    try
    {
      Log.i("MicroMsg.BrowserSettingStorageManager", "alvinluo saveDefaultBrowser packageName: %s", new Object[] { paramString });
      e locale = g.aAh();
      p.g(locale, "MMKernel.storage()");
      locale.azQ().set(274528, paramString);
      AppMethodBeat.o(210444);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(210444);
    }
  }
  
  public static final String ggv()
  {
    AppMethodBeat.i(210443);
    try
    {
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).azQ().get(274528, "");
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(210443);
        return localObject;
      }
      AppMethodBeat.o(210443);
      return "";
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(210443);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.storage.a
 * JD-Core Version:    0.7.0.1
 */