package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Color;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import org.json.JSONObject;

public class bg
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78626);
    ad.i("MicroMsg.JsApiSetNavigationBarColor", "invoke");
    if (paramb.chh.cgn.optInt("actionCode") == 1)
    {
      i = 1;
      j = -1;
    }
    for (;;)
    {
      try
      {
        localObject = paramb.chh.cgn.optJSONObject("wxcolor");
        if (localObject != null) {
          if (al.isDarkMode())
          {
            localObject = ((JSONObject)localObject).optString("dark");
            if (bt.isNullOrNil((String)localObject)) {
              continue;
            }
            int k = Color.parseColor((String)localObject);
            j = k | 0xFF000000;
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject;
        double d;
        float f;
        ad.e("MicroMsg.JsApiSetNavigationBarColor", localException1.getMessage());
        i = 1;
        continue;
        j = -1;
        continue;
      }
      try
      {
        d = paramb.chh.cgn.optDouble("alpha", -1.0D);
        f = (float)d;
      }
      catch (Exception localException2)
      {
        ad.e("MicroMsg.JsApiSetNavigationBarColor", localException2.getMessage());
        f = -1.0F;
        continue;
        ((g)paramb.chg).u(j, f);
        continue;
      }
      if (i == 0) {
        continue;
      }
      ((g)paramb.chg).bhr();
      paramb.a("", null);
      AppMethodBeat.o(78626);
      return;
      i = 0;
      break;
      localObject = ((JSONObject)localObject).optString("light");
      continue;
      localObject = paramb.chh.cgn.optString("color");
    }
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setNavigationBarColor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bg
 * JD-Core Version:    0.7.0.1
 */