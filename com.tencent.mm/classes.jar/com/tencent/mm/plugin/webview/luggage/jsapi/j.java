package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;

public class j
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6304);
    ab.i("MicroMsg.JsApiClearBounceBackground", "invokeInOwn");
    ((e)parama.byE).daW();
    parama.a("", null);
    AppMethodBeat.o(6304);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "clearBounceBackground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.j
 * JD-Core Version:    0.7.0.1
 */