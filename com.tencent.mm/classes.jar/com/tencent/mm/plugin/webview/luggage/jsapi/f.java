package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;

public class f
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6285);
    ab.i("MicroMsg.JsApiCheckJsApi", "invoke");
    parama.a("fail", null);
    AppMethodBeat.o(6285);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "checkJsApi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.f
 * JD-Core Version:    0.7.0.1
 */