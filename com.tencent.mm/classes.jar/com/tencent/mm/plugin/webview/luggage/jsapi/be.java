package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public class be
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78627);
    ac.i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
    String str = parama.bWS.bVY.optString("title");
    if (!bs.isNullOrNil(parama.bWS.bVY.optString("color")))
    {
      int i = com.tencent.mm.plugin.webview.ui.tools.e.fr(parama.bWS.bVY.optString("color"), ((f)parama.bWR).mContext.getResources().getColor(2131099874));
      ((f)parama.bWR).dt(str, i);
    }
    for (;;)
    {
      parama.a("", null);
      AppMethodBeat.o(78627);
      return;
      ((f)parama.bWR).dt(str, 0);
    }
  }
  
  public final int bYk()
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