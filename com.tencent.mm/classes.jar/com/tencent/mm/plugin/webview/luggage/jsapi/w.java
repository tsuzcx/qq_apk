package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.ab;

public class w
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6316);
    ab.i("MicroMsg.JsApiHideOptionMenu", "invoke");
    l locall = ((e)parama.byE).daV();
    if (locall == null)
    {
      ab.e("MicroMsg.JsApiHideOptionMenu", "actionBar is null");
      parama.a("fail", null);
      AppMethodBeat.o(6316);
      return;
    }
    locall.dbq();
    parama.a("", null);
    AppMethodBeat.o(6316);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "hideOptionMenu";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.w
 * JD-Core Version:    0.7.0.1
 */