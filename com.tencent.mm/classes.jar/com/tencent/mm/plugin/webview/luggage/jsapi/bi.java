package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class bi
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    int j = 1;
    AppMethodBeat.i(78628);
    ae.i("MicroMsg.JsApiSetScreenOrientation", "invoke");
    Object localObject = paramb.chh.cgn.optString("orientation");
    if (bu.isNullOrNil((String)localObject))
    {
      ae.e("MicroMsg.JsApiSetScreenOrientation", "data is null");
      paramb.a("invalid_data", null);
      AppMethodBeat.o(78628);
      return;
    }
    int i;
    if (((String)localObject).equals("horizontal")) {
      i = 0;
    }
    for (;;)
    {
      localObject = (g)paramb.chg;
      ((s)localObject).mParams.putInt("screen_orientation", i);
      ((g)localObject).eSN();
      paramb.a("", null);
      AppMethodBeat.o(78628);
      return;
      i = j;
      if (!((String)localObject).equals("vertical")) {
        if (((String)localObject).equals("sensor"))
        {
          i = 4;
        }
        else if (((String)localObject).equals("horizontal_unforced"))
        {
          i = 0;
        }
        else
        {
          i = j;
          if (!((String)localObject).equals("vertical_unforced")) {
            i = -1;
          }
        }
      }
    }
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setScreenOrientation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bi
 * JD-Core Version:    0.7.0.1
 */