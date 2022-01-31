package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;

public class ar
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6359);
    ab.i("MicroMsg.JsApiRecordVideo", "invoke");
    i.a(parama, 1);
    AppMethodBeat.o(6359);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "recordVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */