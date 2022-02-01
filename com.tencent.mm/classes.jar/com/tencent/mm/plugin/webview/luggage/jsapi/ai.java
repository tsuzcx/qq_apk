package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class ai
  extends bq<s>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b.a parama)
  {
    AppMethodBeat.i(78579);
    parama = parama.chh.cgn;
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207909);
        ad.i("MicroMsg.JsApiLog", "jslog : " + parama.optString("msg"));
        AppMethodBeat.o(207909);
      }
    });
    AppMethodBeat.o(78579);
  }
  
  public final int ccO()
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