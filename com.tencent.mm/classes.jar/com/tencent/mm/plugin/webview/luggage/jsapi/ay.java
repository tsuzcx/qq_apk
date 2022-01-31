package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Color;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class ay
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6374);
    ab.i("MicroMsg.JsApiSetNavigationBarColor", "invoke");
    int i;
    if (parama.byF.bxK.optInt("actionCode") == 1) {
      i = 1;
    }
    for (;;)
    {
      int j = -1;
      try
      {
        k = Color.parseColor(parama.byF.bxK.optString("color"));
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
            bo.getFloat(parama.byF.bxK.optString("alpha"), 1.0F);
            if (j == 0) {
              break label150;
            }
            ((e)parama.byE).aAJ();
            parama.a("", null);
            AppMethodBeat.o(6374);
            return;
            i = 0;
            break;
            localException1 = localException1;
            ab.e("MicroMsg.JsApiSetNavigationBarColor", localException1.getMessage());
            int k = 1;
            i = j;
            j = k;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.e("MicroMsg.JsApiSetNavigationBarColor", localException2.getMessage());
            continue;
            label150:
            ((e)parama.byE).setStatusBarColor(i);
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
    return "setNavigationBarColor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ay
 * JD-Core Version:    0.7.0.1
 */