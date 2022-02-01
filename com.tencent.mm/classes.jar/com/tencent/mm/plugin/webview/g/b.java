package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class b
  extends a
{
  public final boolean a(d paramd, l paraml)
  {
    AppMethodBeat.i(198172);
    Object localObject = paraml.Efz;
    if (localObject == null)
    {
      AppMethodBeat.o(198172);
      return false;
    }
    localObject = ((IAppBrandBatchPreloadController)g.ab(IAppBrandBatchPreloadController.class)).preload((JSONObject)localObject, true);
    if (!bu.isNullOrNil((String)localObject)) {
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":" + (String)localObject, null);
    }
    for (;;)
    {
      AppMethodBeat.o(198172);
      return true;
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":error", null);
    }
  }
  
  public final int eSw()
  {
    return 366;
  }
  
  public final String eSx()
  {
    return "batchPreloadMiniProgram";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.b
 * JD-Core Version:    0.7.0.1
 */