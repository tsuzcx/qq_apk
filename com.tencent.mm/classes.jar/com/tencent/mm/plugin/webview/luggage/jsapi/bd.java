package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Color;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class bd
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78626);
    ad.i("MicroMsg.JsApiSetNavigationBarColor", "invoke");
    int i;
    if (parama.bZV.bZb.optInt("actionCode") == 1) {
      i = 1;
    }
    for (;;)
    {
      int j = -1;
      try
      {
        k = Color.parseColor(parama.bZV.bZb.optString("color"));
        k |= 0xFF000000;
        j = i;
        i = k;
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            bt.getFloat(parama.bZV.bZb.optString("alpha"), 1.0F);
            if (j == 0) {
              break label148;
            }
            ((f)parama.bZU).aWP();
            parama.a("", null);
            AppMethodBeat.o(78626);
            return;
            i = 0;
            break;
            localException1 = localException1;
            ad.e("MicroMsg.JsApiSetNavigationBarColor", localException1.getMessage());
            int k = 1;
            i = j;
            j = k;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiSetNavigationBarColor", localException2.getMessage());
            continue;
            label148:
            ((f)parama.bZU).setStatusBarColor(i);
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
    return "setNavigationBarColor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bd
 * JD-Core Version:    0.7.0.1
 */