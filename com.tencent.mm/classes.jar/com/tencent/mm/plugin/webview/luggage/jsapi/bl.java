package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import org.json.JSONObject;

public class bl
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78626);
    Log.i("MicroMsg.JsApiSetNavigationBarColor", "invoke");
    if (paramb.eiZ.eif.optInt("actionCode") == 1)
    {
      i = 1;
      f = -1.0F;
      localObject1 = "";
    }
    for (;;)
    {
      try
      {
        localObject2 = paramb.eiZ.eif.optJSONObject("wxcolor");
        if (localObject2 != null) {
          if (aw.isDarkMode())
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
        Log.e("MicroMsg.JsApiSetNavigationBarColor", localException1.getMessage());
        i = 1;
        continue;
      }
      try
      {
        d = paramb.eiZ.eif.optDouble("alpha", -1.0D);
        f = (float)d;
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.JsApiSetNavigationBarColor", localException2.getMessage());
        continue;
        ((g)paramb.eiY).b((String)localObject1, f, j);
        continue;
      }
      j = paramb.eiZ.eif.optInt("iconDark", -1);
      if (i == 0) {
        break label248;
      }
      ((g)paramb.eiY).coZ();
      Log.d("MicroMsg.JsApiSetNavigationBarColor", "colorStr:%s, alpha:%f, iconDark:%d", new Object[] { localObject1, Float.valueOf(f), Integer.valueOf(j) });
      paramb.a("", null);
      AppMethodBeat.o(78626);
      return;
      i = 0;
      break;
      localObject2 = ((JSONObject)localObject2).optString("light");
      localObject1 = localObject2;
      continue;
      localObject2 = paramb.eiZ.eif.optString("color");
      localObject1 = localObject2;
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setNavigationBarColor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bl
 * JD-Core Version:    0.7.0.1
 */