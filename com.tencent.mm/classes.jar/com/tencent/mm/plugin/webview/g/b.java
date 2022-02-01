package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class b
  extends a
{
  public final boolean a(d paramd, l paraml)
  {
    AppMethodBeat.i(188366);
    Object localObject = paraml.Cku;
    if (localObject == null)
    {
      AppMethodBeat.o(188366);
      return false;
    }
    localObject = ((IAppBrandBatchPreloadController)g.ab(IAppBrandBatchPreloadController.class)).preload((JSONObject)localObject, true);
    if (!bs.isNullOrNil((String)localObject)) {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":" + (String)localObject, null);
    }
    for (;;)
    {
      AppMethodBeat.o(188366);
      return true;
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":error", null);
    }
  }
  
  public final int ezX()
  {
    return 366;
  }
  
  public final String ezY()
  {
    return "batchPreloadMiniProgram";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.b
 * JD-Core Version:    0.7.0.1
 */