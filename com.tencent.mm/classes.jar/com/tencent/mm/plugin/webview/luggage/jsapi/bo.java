package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;

public class bo
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78637);
    Log.i("MicroMsg.JsApiShowOptionMenu", "invoke");
    m localm = ((g)paramb.cta).gbC();
    if (localm == null)
    {
      Log.i("MicroMsg.JsApiShowOptionMenu", "actionBar is null");
      AppMethodBeat.o(78637);
      return;
    }
    localm.gbY();
    paramb.c("", null);
    AppMethodBeat.o(78637);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "showOptionMenu";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bo
 * JD-Core Version:    0.7.0.1
 */