package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONObject;

public class o
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78547);
    ad.i("MicroMsg.JsApiDisableBounceScroll", "invoke");
    JSONArray localJSONArray = parama.bZV.bZb.optJSONArray("place");
    if (localJSONArray == null)
    {
      ad.i("MicroMsg.JsApiDisableBounceScroll", "placeArray is null");
      parama.a("fail", null);
      AppMethodBeat.o(78547);
      return;
    }
    int j = 0;
    int i = 0;
    if (j < localJSONArray.length())
    {
      if (!"top".equalsIgnoreCase(localJSONArray.optString(j))) {
        break label127;
      }
      i = 1;
    }
    label127:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0)
      {
        parama.a("", null);
        AppMethodBeat.o(78547);
        return;
      }
      ((f)parama.bZU).ekT();
      parama.a("", null);
      AppMethodBeat.o(78547);
      return;
    }
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "disableBounceScroll";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.o
 * JD-Core Version:    0.7.0.1
 */