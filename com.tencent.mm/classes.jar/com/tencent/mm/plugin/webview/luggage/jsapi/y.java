package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONObject;

public class y
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78561);
    ad.i("MicroMsg.JsApiHideMenuItems", "invokeInOwn");
    JSONArray localJSONArray = parama.bZV.bZb.optJSONArray("menuList");
    if (localJSONArray == null)
    {
      ad.i("MicroMsg.JsApiHideMenuItems", "data is null");
      parama.a("invalid_data", null);
      AppMethodBeat.o(78561);
      return;
    }
    l locall = ((f)parama.bZU).ekS();
    if (locall != null) {
      locall.M(localJSONArray);
    }
    parama.a("", null);
    AppMethodBeat.o(78561);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "hideMenuItems";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.y
 * JD-Core Version:    0.7.0.1
 */