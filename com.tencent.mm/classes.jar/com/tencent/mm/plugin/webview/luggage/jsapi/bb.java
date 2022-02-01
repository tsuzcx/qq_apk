package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class bb
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(187876);
    int i = parama.bZV.bZb.optInt("fontSize");
    ((f)parama.bZU).SK(i);
    ad.i("MicroMsg.JsApiSetFrontSizeCallback", "doSetFontSizeCb, fontSize = ".concat(String.valueOf(i)));
    parama.a("", null);
    AppMethodBeat.o(187876);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setFontSizeCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bb
 * JD-Core Version:    0.7.0.1
 */