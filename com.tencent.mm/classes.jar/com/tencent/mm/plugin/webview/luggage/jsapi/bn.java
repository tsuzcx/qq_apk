package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class bn
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78636);
    Log.i("MicroMsg.JsApiShowMenuItems", "invokeInOwn");
    JSONArray localJSONArray = paramb.ctb.csi.optJSONArray("menuList");
    if (localJSONArray == null)
    {
      Log.i("MicroMsg.JsApiShowMenuItems", "data is null");
      paramb.c("invalid_data", null);
      AppMethodBeat.o(78636);
      return;
    }
    m localm = ((g)paramb.cta).gbC();
    if (localm != null) {
      localm.U(localJSONArray);
    }
    paramb.c("", null);
    AppMethodBeat.o(78636);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "showMenuItems";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bn
 * JD-Core Version:    0.7.0.1
 */