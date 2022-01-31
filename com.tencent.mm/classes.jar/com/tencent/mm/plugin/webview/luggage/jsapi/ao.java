package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class ao
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(153125);
    ab.i("MicroMsg.JsApiPrivateOpenWeappFunctionalPage", "invokeInOwn");
    Object localObject = parama.byF.bxK;
    String str = ((JSONObject)localObject).optString("uuid");
    localObject = ((JSONObject)localObject).optString("req_data");
    ((com.tencent.mm.plugin.appbrand.service.e)g.E(com.tencent.mm.plugin.appbrand.service.e.class)).bt(str, (String)localObject);
    parama.a("", null);
    ((com.tencent.mm.plugin.webview.luggage.e)parama.byE).uRM = true;
    AppMethodBeat.o(153125);
  }
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "privateOpenWeappFunctionalPage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ao
 * JD-Core Version:    0.7.0.1
 */