package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import org.json.JSONObject;

public class ak
  extends bv<s>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b.a parama)
  {
    AppMethodBeat.i(78579);
    parama = parama.eiZ.eif;
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296013);
        Log.i("MicroMsg.JsApiLog", "jslog : " + parama.optString("msg"));
        AppMethodBeat.o(296013);
      }
    });
    AppMethodBeat.o(78579);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "log";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ak
 * JD-Core Version:    0.7.0.1
 */