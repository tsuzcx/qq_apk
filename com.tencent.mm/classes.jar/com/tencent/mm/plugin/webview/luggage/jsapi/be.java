package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class be
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78627);
    ad.i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
    String str = parama.bZV.bZb.optString("title");
    if (!bt.isNullOrNil(parama.bZV.bZb.optString("color")))
    {
      int i = com.tencent.mm.plugin.webview.ui.tools.e.fj(parama.bZV.bZb.optString("color"), ((f)parama.bZU).mContext.getResources().getColor(2131099874));
      ((f)parama.bZU).dn(str, i);
    }
    for (;;)
    {
      parama.a("", null);
      AppMethodBeat.o(78627);
      return;
      ((f)parama.bZU).dn(str, 0);
    }
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setPageTitle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.be
 * JD-Core Version:    0.7.0.1
 */