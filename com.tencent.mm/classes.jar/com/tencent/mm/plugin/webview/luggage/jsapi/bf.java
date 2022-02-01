package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class bf
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    int j = 1;
    AppMethodBeat.i(78628);
    ad.i("MicroMsg.JsApiSetScreenOrientation", "invoke");
    String str = parama.bZV.bZb.optString("orientation");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiSetScreenOrientation", "data is null");
      parama.a("invalid_data", null);
      AppMethodBeat.o(78628);
      return;
    }
    int i;
    if (str.equals("horizontal")) {
      i = 0;
    }
    for (;;)
    {
      ((f)parama.bZU).SH(i);
      parama.a("", null);
      AppMethodBeat.o(78628);
      return;
      i = j;
      if (!str.equals("vertical")) {
        if (str.equals("sensor"))
        {
          i = 4;
        }
        else if (str.equals("horizontal_unforced"))
        {
          i = 0;
        }
        else
        {
          i = j;
          if (!str.equals("vertical_unforced")) {
            i = -1;
          }
        }
      }
    }
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setScreenOrientation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bf
 * JD-Core Version:    0.7.0.1
 */