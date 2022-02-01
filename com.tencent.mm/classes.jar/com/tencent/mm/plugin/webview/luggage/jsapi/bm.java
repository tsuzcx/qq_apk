package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class bm
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78627);
    Log.i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
    String str = paramb.eiZ.eif.optString("title");
    if (!Util.isNullOrNil(paramb.eiZ.eif.optString("color")))
    {
      int i = f.fo(paramb.eiZ.eif.optString("color"), ((g)paramb.eiY).mContext.getResources().getColor(c.c.action_bar_tittle_color));
      ((g)paramb.eiY).fq(str, i);
    }
    for (;;)
    {
      paramb.a("", null);
      AppMethodBeat.o(78627);
      return;
      ((g)paramb.eiY).fq(str, 0);
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setPageTitle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bm
 * JD-Core Version:    0.7.0.1
 */