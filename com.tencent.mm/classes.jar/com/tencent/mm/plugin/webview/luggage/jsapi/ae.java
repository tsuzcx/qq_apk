package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class ae
  extends bh<n>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(6331);
    parama = parama.byF.bxK;
    ab.i("MicroMsg.JsApiLog", "jslog : " + parama.optString("msg"));
    AppMethodBeat.o(6331);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "log";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ae
 * JD-Core Version:    0.7.0.1
 */