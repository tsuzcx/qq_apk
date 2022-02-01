package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
  extends a
{
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(294659);
    Object localObject = paramp.WEI;
    if (localObject == null)
    {
      AppMethodBeat.o(294659);
      return false;
    }
    localObject = ((IAppBrandBatchPreloadController)com.tencent.mm.kernel.h.ax(IAppBrandBatchPreloadController.class)).preload((JSONObject)localObject, true);
    if (!Util.isNullOrNil((String)localObject)) {
      paramh.WDy.doCallback(paramp.WEH, paramp.function + ":" + (String)localObject, null);
    }
    for (;;)
    {
      AppMethodBeat.o(294659);
      return true;
      paramh.WDy.doCallback(paramp.WEH, paramp.function + ":error", null);
    }
  }
  
  public final String gPX()
  {
    return "batchPreloadMiniProgram";
  }
  
  public final int gPZ()
  {
    return 366;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.b
 * JD-Core Version:    0.7.0.1
 */