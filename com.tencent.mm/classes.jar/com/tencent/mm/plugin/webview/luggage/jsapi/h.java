package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;

public class h
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78525);
    Log.i("MicroMsg.JsApiCheckJsApi", "invoke");
    paramb.a("fail", null);
    AppMethodBeat.o(78525);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "checkJsApi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.h
 * JD-Core Version:    0.7.0.1
 */