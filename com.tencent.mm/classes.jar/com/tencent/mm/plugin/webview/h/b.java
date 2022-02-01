package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
  extends a
{
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(268424);
    Object localObject = paramn.POv;
    if (localObject == null)
    {
      AppMethodBeat.o(268424);
      return false;
    }
    localObject = ((IAppBrandBatchPreloadController)com.tencent.mm.kernel.h.ae(IAppBrandBatchPreloadController.class)).preload((JSONObject)localObject, true);
    if (!Util.isNullOrNil((String)localObject)) {
      paramf.PNo.h(paramn.POu, paramn.function + ":" + (String)localObject, null);
    }
    for (;;)
    {
      AppMethodBeat.o(268424);
      return true;
      paramf.PNo.h(paramn.POu, paramn.function + ":error", null);
    }
  }
  
  public final String fCm()
  {
    return "batchPreloadMiniProgram";
  }
  
  public final int fCn()
  {
    return 366;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.b
 * JD-Core Version:    0.7.0.1
 */