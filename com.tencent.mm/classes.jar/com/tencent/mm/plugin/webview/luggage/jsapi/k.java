package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;

public class k
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6305);
    ab.i("MicroMsg.JsApiCloseWindow", "invokeInOwn");
    ((e)parama.byE).finish();
    parama.a("", null);
    AppMethodBeat.o(6305);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "closeWindow";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.k
 * JD-Core Version:    0.7.0.1
 */