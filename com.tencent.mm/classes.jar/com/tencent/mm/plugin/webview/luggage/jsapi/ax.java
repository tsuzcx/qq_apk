package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class ax
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78599);
    Log.i("MicroMsg.JsApiPrivateOpenWeappFunctionalPage", "invokeInOwn");
    Object localObject = paramb.eiZ.eif;
    String str = ((JSONObject)localObject).optString("uuid");
    localObject = ((JSONObject)localObject).optString("req_data");
    ((com.tencent.mm.plugin.appbrand.service.k)h.ax(com.tencent.mm.plugin.appbrand.service.k.class)).cN(str, (String)localObject);
    paramb.a("", null);
    ((g)paramb.eiY).WGo = true;
    AppMethodBeat.o(78599);
  }
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "privateOpenWeappFunctionalPage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */