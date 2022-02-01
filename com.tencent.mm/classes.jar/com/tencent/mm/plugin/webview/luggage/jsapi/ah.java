package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public class ah
  extends bn<n>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a.a parama)
  {
    AppMethodBeat.i(78579);
    parama = parama.bWS.bVY;
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188301);
        ac.i("MicroMsg.JsApiLog", "jslog : " + parama.optString("msg"));
        AppMethodBeat.o(188301);
      }
    });
    AppMethodBeat.o(78579);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "log";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ah
 * JD-Core Version:    0.7.0.1
 */