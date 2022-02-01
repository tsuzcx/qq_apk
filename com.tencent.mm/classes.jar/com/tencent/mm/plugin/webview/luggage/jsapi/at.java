package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class at
  extends bs<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb)
  {
    AppMethodBeat.i(78599);
    Log.i("MicroMsg.JsApiPrivateOpenWeappFunctionalPage", "invokeInOwn");
    Object localObject = paramb.ctb.csi;
    String str = ((JSONObject)localObject).optString("uuid");
    localObject = ((JSONObject)localObject).optString("req_data");
    ((j)com.tencent.mm.kernel.g.af(j.class)).cr(str, (String)localObject);
    paramb.c("", null);
    ((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).ITD = true;
    AppMethodBeat.o(78599);
  }
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "privateOpenWeappFunctionalPage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.at
 * JD-Core Version:    0.7.0.1
 */