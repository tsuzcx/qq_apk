package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public class bf
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(com.tencent.luggage.d.a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6386);
    ab.i("MicroMsg.JsApiShowSmileyPanel", "invokeInOwn");
    int i = ((com.tencent.mm.plugin.webview.luggage.e)parama.byE).daT();
    if (i > 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("height", Integer.valueOf(com.tencent.mm.cb.a.ar(((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext, i)));
      parama.c("", localHashMap);
      AppMethodBeat.o(6386);
      return;
    }
    parama.a("fail", null);
    AppMethodBeat.o(6386);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "showSmileyPanel";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bf
 * JD-Core Version:    0.7.0.1
 */