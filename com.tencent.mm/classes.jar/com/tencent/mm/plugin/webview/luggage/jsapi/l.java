package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.g.13;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class l
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78544);
    Log.i("MicroMsg.JsApiClearBounceBackground", "invokeInOwn");
    g localg = (g)paramb.eiY;
    localg.mHandler.post(new g.13(localg));
    paramb.a("", null);
    AppMethodBeat.o(78544);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "clearBounceBackground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.l
 * JD-Core Version:    0.7.0.1
 */