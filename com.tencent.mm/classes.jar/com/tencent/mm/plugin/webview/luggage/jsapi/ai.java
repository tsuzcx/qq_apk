package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class ai
  extends br<s>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b.a parama)
  {
    AppMethodBeat.i(78579);
    parama = parama.ctb.csi;
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210947);
        Log.i("MicroMsg.JsApiLog", "jslog : " + parama.optString("msg"));
        AppMethodBeat.o(210947);
      }
    });
    AppMethodBeat.o(78579);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "log";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ai
 * JD-Core Version:    0.7.0.1
 */