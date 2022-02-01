package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONArray;
import org.json.JSONObject;

public class bj
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78636);
    ac.i("MicroMsg.JsApiShowMenuItems", "invokeInOwn");
    JSONArray localJSONArray = parama.bWS.bVY.optJSONArray("menuList");
    if (localJSONArray == null)
    {
      ac.i("MicroMsg.JsApiShowMenuItems", "data is null");
      parama.a("invalid_data", null);
      AppMethodBeat.o(78636);
      return;
    }
    l locall = ((f)parama.bWR).eAo();
    if (locall != null) {
      locall.N(localJSONArray);
    }
    parama.a("", null);
    AppMethodBeat.o(78636);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "showMenuItems";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bj
 * JD-Core Version:    0.7.0.1
 */