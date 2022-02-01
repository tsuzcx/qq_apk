package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONObject;

public class o
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78547);
    ad.i("MicroMsg.JsApiDisableBounceScroll", "invoke");
    JSONArray localJSONArray = paramb.chh.cgn.optJSONArray("place");
    if (localJSONArray == null)
    {
      ad.i("MicroMsg.JsApiDisableBounceScroll", "placeArray is null");
      paramb.a("fail", null);
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
        paramb.a("", null);
        AppMethodBeat.o(78547);
        return;
      }
      ((g)paramb.chg).ePf();
      paramb.a("", null);
      AppMethodBeat.o(78547);
      return;
    }
  }
  
  public final int ccO()
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