package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class bh
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78627);
    ad.i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
    String str = paramb.chh.cgn.optString("title");
    if (!bt.isNullOrNil(paramb.chh.cgn.optString("color")))
    {
      int i = e.fO(paramb.chh.cgn.optString("color"), ((g)paramb.chg).mContext.getResources().getColor(2131099874));
      ((g)paramb.chg).dJ(str, i);
    }
    for (;;)
    {
      paramb.a("", null);
      AppMethodBeat.o(78627);
      return;
      ((g)paramb.chg).dJ(str, 0);
    }
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setPageTitle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bh
 * JD-Core Version:    0.7.0.1
 */