package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class be
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(198099);
    int i = paramb.chh.cgn.optInt("fontSize");
    ((g)paramb.chg).Xp(i);
    ae.i("MicroMsg.JsApiSetFrontSizeCallback", "doSetFontSizeCb, fontSize = ".concat(String.valueOf(i)));
    paramb.a("", null);
    AppMethodBeat.o(198099);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setFontSizeCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.be
 * JD-Core Version:    0.7.0.1
 */