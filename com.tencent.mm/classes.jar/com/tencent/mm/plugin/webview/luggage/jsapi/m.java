package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public class m
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6307);
    ab.i("MicroMsg.JsApiDisableBounceScroll", "invoke");
    JSONArray localJSONArray = parama.byF.bxK.optJSONArray("place");
    if (localJSONArray == null)
    {
      ab.i("MicroMsg.JsApiDisableBounceScroll", "placeArray is null");
      parama.a("fail", null);
      AppMethodBeat.o(6307);
      return;
    }
    int j = 0;
    int i = 0;
    if (j < localJSONArray.length())
    {
      if (!"top".equalsIgnoreCase(localJSONArray.optString(j))) {
        break label131;
      }
      i = 1;
    }
    label131:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0)
      {
        parama.a("", null);
        AppMethodBeat.o(6307);
        return;
      }
      ((e)parama.byE).daX();
      parama.a("", null);
      AppMethodBeat.o(6307);
      return;
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "disableBounceScroll";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.m
 * JD-Core Version:    0.7.0.1
 */