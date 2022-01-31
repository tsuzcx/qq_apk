package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.ui.tools.bag.h;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class l
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6306);
    JSONObject localJSONObject = parama.byF.bxK;
    String str = localJSONObject.optString("brandIcon");
    localJSONObject.optString("brandName");
    ab.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", new Object[] { str });
    ((e)parama.byE).dbd().aiE(str);
    parama.a("", null);
    AppMethodBeat.o(6306);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "currentMpInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.l
 * JD-Core Version:    0.7.0.1
 */