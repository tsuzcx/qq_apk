package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import org.json.JSONObject;

public class bg
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78626);
    ae.i("MicroMsg.JsApiSetNavigationBarColor", "invoke");
    if (paramb.chh.cgn.optInt("actionCode") == 1)
    {
      i = 1;
      localObject1 = "";
    }
    for (;;)
    {
      try
      {
        localObject2 = paramb.chh.cgn.optJSONObject("wxcolor");
        if (localObject2 != null) {
          if (al.isDarkMode())
          {
            localObject2 = ((JSONObject)localObject2).optString("dark");
            localObject1 = localObject2;
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        double d;
        ae.e("MicroMsg.JsApiSetNavigationBarColor", localException1.getMessage());
        i = 1;
        continue;
      }
      try
      {
        d = paramb.chh.cgn.optDouble("alpha", -1.0D);
        f = (float)d;
      }
      catch (Exception localException2)
      {
        ae.e("MicroMsg.JsApiSetNavigationBarColor", localException2.getMessage());
        f = -1.0F;
        continue;
        ((g)paramb.chg).n((String)localObject1, f);
        continue;
      }
      if (i == 0) {
        break label201;
      }
      ((g)paramb.chg).bhZ();
      paramb.a("", null);
      AppMethodBeat.o(78626);
      return;
      i = 0;
      break;
      localObject2 = ((JSONObject)localObject2).optString("light");
      localObject1 = localObject2;
      continue;
      localObject2 = paramb.chh.cgn.optString("color");
      localObject1 = localObject2;
    }
  }
  
  public final int ced()
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