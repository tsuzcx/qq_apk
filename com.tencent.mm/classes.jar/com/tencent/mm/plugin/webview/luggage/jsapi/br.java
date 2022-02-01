package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.n;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class br
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78636);
    Log.i("MicroMsg.JsApiShowMenuItems", "invokeInOwn");
    JSONArray localJSONArray = paramb.eiZ.eif.optJSONArray("menuList");
    if (localJSONArray == null)
    {
      Log.i("MicroMsg.JsApiShowMenuItems", "data is null");
      paramb.a("invalid_data", null);
      AppMethodBeat.o(78636);
      return;
    }
    n localn = ((g)paramb.eiY).iuf();
    if (localn != null) {
      localn.ab(localJSONArray);
    }
    paramb.a("", null);
    AppMethodBeat.o(78636);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "showMenuItems";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.br
 * JD-Core Version:    0.7.0.1
 */