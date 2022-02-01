package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.f.13;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class ay
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78622);
    ad.i("MicroMsg.JsApiSetBounceBackground", "invokeInOwn");
    String str = parama.bZV.bZb.optString("backgroundColor");
    if (bt.isNullOrNil(str))
    {
      parama.a("invalid_data", null);
      AppMethodBeat.o(78622);
      return;
    }
    f localf = (f)parama.bZU;
    localf.mHandler.post(new f.13(localf, str));
    parama.a("", null);
    AppMethodBeat.o(78622);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setBounceBackground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ay
 * JD-Core Version:    0.7.0.1
 */