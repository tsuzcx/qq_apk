package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;

public class m
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78545);
    Log.i("MicroMsg.JsApiCloseWindow", "invokeInOwn");
    ((g)paramb.crg).gUG();
    paramb.a("", null);
    AppMethodBeat.o(78545);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "closeWindow";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.m
 * JD-Core Version:    0.7.0.1
 */