package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class av
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6371);
    ab.i("MicroMsg.JsApiSetBounceBackground", "invokeInOwn");
    String str = parama.byF.bxK.optString("backgroundColor");
    if (bo.isNullOrNil(str))
    {
      parama.a("invalid_data", null);
      AppMethodBeat.o(6371);
      return;
    }
    ((e)parama.byE).agM(str);
    parama.a("", null);
    AppMethodBeat.o(6371);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setBounceBackground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.av
 * JD-Core Version:    0.7.0.1
 */