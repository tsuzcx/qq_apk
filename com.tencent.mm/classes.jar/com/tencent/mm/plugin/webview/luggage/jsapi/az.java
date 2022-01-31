package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class az
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6375);
    ab.i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
    String str = parama.byF.bxK.optString("title");
    if (!bo.isNullOrNil(parama.byF.bxK.optString("color")))
    {
      int i = g.by(parama.byF.bxK.optString("color"), ((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext.getResources().getColor(2131689642));
      ((com.tencent.mm.plugin.webview.luggage.e)parama.byE).cr(str, i);
    }
    for (;;)
    {
      parama.a("", null);
      AppMethodBeat.o(6375);
      return;
      ((com.tencent.mm.plugin.webview.luggage.e)parama.byE).cr(str, 0);
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setPageTitle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.az
 * JD-Core Version:    0.7.0.1
 */