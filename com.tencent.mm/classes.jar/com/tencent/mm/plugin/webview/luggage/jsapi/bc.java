package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.g.14;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class bc
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78622);
    Log.i("MicroMsg.JsApiSetBounceBackground", "invokeInOwn");
    String str = paramb.ctb.csi.optString("backgroundColor");
    if (Util.isNullOrNil(str))
    {
      paramb.c("invalid_data", null);
      AppMethodBeat.o(78622);
      return;
    }
    g localg = (g)paramb.cta;
    localg.mHandler.post(new g.14(localg, str));
    paramb.c("", null);
    AppMethodBeat.o(78622);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setBounceBackground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bc
 * JD-Core Version:    0.7.0.1
 */