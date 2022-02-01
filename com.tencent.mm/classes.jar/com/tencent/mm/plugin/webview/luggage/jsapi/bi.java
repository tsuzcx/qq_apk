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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class bi
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78627);
    Log.i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
    String str = paramb.ctb.csi.optString("title");
    if (!Util.isNullOrNil(paramb.ctb.csi.optString("color")))
    {
      int i = e.gw(paramb.ctb.csi.optString("color"), ((g)paramb.cta).mContext.getResources().getColor(2131099892));
      ((g)paramb.cta).ec(str, i);
    }
    for (;;)
    {
      paramb.c("", null);
      AppMethodBeat.o(78627);
      return;
      ((g)paramb.cta).ec(str, 0);
    }
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setPageTitle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bi
 * JD-Core Version:    0.7.0.1
 */