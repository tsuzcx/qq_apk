package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.aa;
import org.json.JSONObject;

public class bf
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(257165);
    int i = paramb.crh.cqn.optInt("fontSize");
    g localg = (g)paramb.crg;
    Log.i("MicroMsg.LuggageMMWebPage", "localSetFontSize, fontSize = ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      localg.PPv.getSettings().setTextZoom(100);
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiSetFrontSizeCallback", "doSetFontSizeCb, fontSize = ".concat(String.valueOf(i)));
      paramb.a("", null);
      AppMethodBeat.o(257165);
      return;
      localg.PPv.getSettings().setTextZoom(80);
      continue;
      localg.PPv.getSettings().setTextZoom(100);
      continue;
      localg.PPv.getSettings().setTextZoom(110);
      continue;
      localg.PPv.getSettings().setTextZoom(112);
      continue;
      localg.PPv.getSettings().setTextZoom(112);
      continue;
      localg.PPv.getSettings().setTextZoom(140);
      continue;
      localg.PPv.getSettings().setTextZoom(155);
      continue;
      localg.PPv.getSettings().setTextZoom(165);
    }
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setFontSizeCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bf
 * JD-Core Version:    0.7.0.1
 */