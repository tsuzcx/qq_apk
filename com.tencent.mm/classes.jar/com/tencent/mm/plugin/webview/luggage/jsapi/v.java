package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public class v
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6315);
    ab.i("MicroMsg.JsApiHideMenuItems", "invokeInOwn");
    JSONArray localJSONArray = parama.byF.bxK.optJSONArray("menuList");
    if (localJSONArray == null)
    {
      ab.i("MicroMsg.JsApiHideMenuItems", "data is null");
      parama.a("invalid_data", null);
      AppMethodBeat.o(6315);
      return;
    }
    l locall = ((e)parama.byE).daV();
    if (locall != null) {
      locall.K(localJSONArray);
    }
    parama.a("", null);
    AppMethodBeat.o(6315);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "hideMenuItems";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.v
 * JD-Core Version:    0.7.0.1
 */