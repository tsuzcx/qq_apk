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

public class ba
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    int j = 1;
    AppMethodBeat.i(6376);
    ab.i("MicroMsg.JsApiSetScreenOrientation", "invoke");
    String str = parama.byF.bxK.optString("orientation");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.JsApiSetScreenOrientation", "data is null");
      parama.a("invalid_data", null);
      AppMethodBeat.o(6376);
      return;
    }
    int i;
    if (str.equals("horizontal")) {
      i = 0;
    }
    for (;;)
    {
      ((e)parama.byE).JP(i);
      parama.a("", null);
      AppMethodBeat.o(6376);
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
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setScreenOrientation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ba
 * JD-Core Version:    0.7.0.1
 */