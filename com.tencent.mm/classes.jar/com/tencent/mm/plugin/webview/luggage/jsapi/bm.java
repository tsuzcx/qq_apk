package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONArray;
import org.json.JSONObject;

public class bm
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78636);
    ae.i("MicroMsg.JsApiShowMenuItems", "invokeInOwn");
    JSONArray localJSONArray = paramb.chh.cgn.optJSONArray("menuList");
    if (localJSONArray == null)
    {
      ae.i("MicroMsg.JsApiShowMenuItems", "data is null");
      paramb.a("invalid_data", null);
      AppMethodBeat.o(78636);
      return;
    }
    m localm = ((g)paramb.chg).eSQ();
    if (localm != null) {
      localm.P(localJSONArray);
    }
    paramb.a("", null);
    AppMethodBeat.o(78636);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "showMenuItems";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bm
 * JD-Core Version:    0.7.0.1
 */