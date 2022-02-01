package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class e
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(160421);
    Log.i("MicroMsg.Predownload.WebViewJsApiBatchPreloadMiniProgram", "invokeInOwn");
    Object localObject = paramb.eiZ.eif;
    if (localObject == null)
    {
      AppMethodBeat.o(160421);
      return;
    }
    localObject = ((IAppBrandBatchPreloadController)h.ax(IAppBrandBatchPreloadController.class)).preload((JSONObject)localObject, true);
    if (!Util.isNullOrNil((String)localObject))
    {
      if ("ok".equalsIgnoreCase((String)localObject))
      {
        paramb.a("", null);
        AppMethodBeat.o(160421);
        return;
      }
      paramb.a((String)localObject, null);
      AppMethodBeat.o(160421);
      return;
    }
    paramb.a("error", null);
    AppMethodBeat.o(160421);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "batchPreloadMiniProgram";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.e
 * JD-Core Version:    0.7.0.1
 */