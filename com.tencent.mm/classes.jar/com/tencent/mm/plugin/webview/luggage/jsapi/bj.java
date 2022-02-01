package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class bj
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(296056);
    int i = paramb.eiZ.eif.optInt("fontSize");
    ((g)paramb.eiY).atq(i);
    Log.i("MicroMsg.JsApiSetFrontSizeCallback", "doSetFontSizeCb, fontSize = ".concat(String.valueOf(i)));
    paramb.a("", null);
    AppMethodBeat.o(296056);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setFontSizeCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bj
 * JD-Core Version:    0.7.0.1
 */