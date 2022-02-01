package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class b
  extends a
{
  public final boolean a(d paramd, l paraml)
  {
    AppMethodBeat.i(207995);
    Object localObject = paraml.DNA;
    if (localObject == null)
    {
      AppMethodBeat.o(207995);
      return false;
    }
    localObject = ((IAppBrandBatchPreloadController)g.ab(IAppBrandBatchPreloadController.class)).preload((JSONObject)localObject, true);
    if (!bt.isNullOrNil((String)localObject)) {
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":" + (String)localObject, null);
    }
    for (;;)
    {
      AppMethodBeat.o(207995);
      return true;
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":error", null);
    }
  }
  
  public final int eOL()
  {
    return 366;
  }
  
  public final String eOM()
  {
    return "batchPreloadMiniProgram";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.b
 * JD-Core Version:    0.7.0.1
 */