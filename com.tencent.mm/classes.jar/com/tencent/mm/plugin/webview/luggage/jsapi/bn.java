package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.ae;

public class bn
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78637);
    ae.i("MicroMsg.JsApiShowOptionMenu", "invoke");
    m localm = ((g)paramb.chg).eSQ();
    if (localm == null)
    {
      ae.i("MicroMsg.JsApiShowOptionMenu", "actionBar is null");
      AppMethodBeat.o(78637);
      return;
    }
    localm.eTl();
    paramb.a("", null);
    AppMethodBeat.o(78637);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "showOptionMenu";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bn
 * JD-Core Version:    0.7.0.1
 */