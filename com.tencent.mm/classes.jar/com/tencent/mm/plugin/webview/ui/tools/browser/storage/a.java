package com.tencent.mm.plugin.webview.ui.tools.browser.storage;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/storage/BrowserSettingStorageManager;", "", "()V", "TAG", "", "getBrowserConfigId", "", "configId", "getDefaultBrowser", "saveDefaultBrowser", "", "selectedInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "packageName", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Xbd;
  
  static
  {
    AppMethodBeat.i(296498);
    Xbd = new a();
    AppMethodBeat.o(296498);
  }
  
  public static final void a(com.tencent.mm.plugin.webview.ui.tools.browser.f paramf)
  {
    AppMethodBeat.i(296489);
    s.u(paramf, "selectedInfo");
    if (paramf.itemType == 1)
    {
      paramf = paramf.qK;
      if (paramf == null) {
        paramf = "";
      }
      for (;;)
      {
        bmb(paramf);
        AppMethodBeat.o(296489);
        return;
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
    if (paramf.itemType == 2) {
      bmb("");
    }
    AppMethodBeat.o(296489);
  }
  
  private static void bmb(String paramString)
  {
    AppMethodBeat.i(296496);
    try
    {
      Log.i("MicroMsg.BrowserSettingStorageManager", "alvinluo saveDefaultBrowser packageName: %s", new Object[] { paramString });
      h.baE().ban().B(274528, paramString);
      AppMethodBeat.o(296496);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(296496);
    }
  }
  
  public static final String izM()
  {
    AppMethodBeat.i(296492);
    try
    {
      Object localObject = h.baE().ban().d(274528, "");
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(296492);
        return localObject;
      }
      AppMethodBeat.o(296492);
      return "";
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(296492);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.storage.a
 * JD-Core Version:    0.7.0.1
 */