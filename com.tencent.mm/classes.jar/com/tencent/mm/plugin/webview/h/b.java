package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b
  extends a
{
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(211033);
    Object localObject = paramn.ISf;
    if (localObject == null)
    {
      AppMethodBeat.o(211033);
      return false;
    }
    localObject = ((IAppBrandBatchPreloadController)g.af(IAppBrandBatchPreloadController.class)).preload((JSONObject)localObject, true);
    if (!Util.isNullOrNil((String)localObject)) {
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":" + (String)localObject, null);
    }
    for (;;)
    {
      AppMethodBeat.o(211033);
      return true;
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":error", null);
    }
  }
  
  public final int ePA()
  {
    return 366;
  }
  
  public final String ePz()
  {
    return "batchPreloadMiniProgram";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.b
 * JD-Core Version:    0.7.0.1
 */