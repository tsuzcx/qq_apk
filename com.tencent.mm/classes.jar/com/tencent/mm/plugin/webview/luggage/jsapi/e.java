package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class e
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(160421);
    ad.i("MicroMsg.Predownload.WebViewJsApiBatchPreloadMiniProgram", "invokeInOwn");
    Object localObject = parama.bZV.bZb;
    if (localObject == null)
    {
      AppMethodBeat.o(160421);
      return;
    }
    localObject = ((IAppBrandBatchPreloadController)g.ab(IAppBrandBatchPreloadController.class)).preload((JSONObject)localObject, true);
    if (!bt.isNullOrNil((String)localObject))
    {
      if ("ok".equalsIgnoreCase((String)localObject))
      {
        parama.a("", null);
        AppMethodBeat.o(160421);
        return;
      }
      parama.a((String)localObject, null);
      AppMethodBeat.o(160421);
      return;
    }
    parama.a("error", null);
    AppMethodBeat.o(160421);
  }
  
  public final int bQV()
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