package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.webview_impl.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.z;
import org.json.JSONObject;

public class bf
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(210957);
    int i = paramb.ctb.csi.optInt("fontSize");
    g localg = (g)paramb.cta;
    Log.i("MicroMsg.LuggageMMWebPage", "localSetFontSize, fontSize = ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      localg.ITd.getSettings().setTextZoom(100);
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiSetFrontSizeCallback", "doSetFontSizeCb, fontSize = ".concat(String.valueOf(i)));
      paramb.c("", null);
      AppMethodBeat.o(210957);
      return;
      localg.ITd.getSettings().setTextZoom(80);
      continue;
      localg.ITd.getSettings().setTextZoom(100);
      continue;
      localg.ITd.getSettings().setTextZoom(110);
      continue;
      localg.ITd.getSettings().setTextZoom(112);
      continue;
      localg.ITd.getSettings().setTextZoom(112);
      continue;
      localg.ITd.getSettings().setTextZoom(140);
      continue;
      localg.ITd.getSettings().setTextZoom(155);
      continue;
      localg.ITd.getSettings().setTextZoom(165);
    }
  }
  
  public final int dTs()
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