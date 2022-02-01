package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class as
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb)
  {
    AppMethodBeat.i(78599);
    ae.i("MicroMsg.JsApiPrivateOpenWeappFunctionalPage", "invokeInOwn");
    Object localObject = paramb.chh.cgn;
    String str = ((JSONObject)localObject).optString("uuid");
    localObject = ((JSONObject)localObject).optString("req_data");
    ((i)com.tencent.mm.kernel.g.ab(i.class)).cd(str, (String)localObject);
    paramb.a("", null);
    ((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).EgT = true;
    AppMethodBeat.o(78599);
  }
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "privateOpenWeappFunctionalPage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.as
 * JD-Core Version:    0.7.0.1
 */