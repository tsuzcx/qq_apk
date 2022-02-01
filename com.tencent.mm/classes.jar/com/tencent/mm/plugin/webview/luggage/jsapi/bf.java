package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public class bf
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    int j = 1;
    AppMethodBeat.i(78628);
    ac.i("MicroMsg.JsApiSetScreenOrientation", "invoke");
    String str = parama.bWS.bVY.optString("orientation");
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.JsApiSetScreenOrientation", "data is null");
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
      ((f)parama.bWR).UP(i);
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
  
  public final int bYk()
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