package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public class ar
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78599);
    ac.i("MicroMsg.JsApiPrivateOpenWeappFunctionalPage", "invokeInOwn");
    Object localObject = parama.bWS.bVY;
    String str = ((JSONObject)localObject).optString("uuid");
    localObject = ((JSONObject)localObject).optString("req_data");
    ((i)g.ab(i.class)).cb(str, (String)localObject);
    parama.a("", null);
    ((f)parama.bWR).ClJ = true;
    AppMethodBeat.o(78599);
  }
  
  public final int bYk()
  {
    return 1;
  }
  
  public final String name()
  {
    return "privateOpenWeappFunctionalPage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */