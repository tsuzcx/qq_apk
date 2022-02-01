package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.webview.h.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class az<T extends a>
  extends br<T>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<T>.a paramb)
  {
    AppMethodBeat.i(210956);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210955);
        try
        {
          String str = paramb.ctb.csi.optString("url");
          if (Util.isNullOrNil(str))
          {
            paramb.c("fail", null);
            AppMethodBeat.o(210955);
            return;
          }
          Object localObject1 = new JSONObject();
          Object localObject2 = new com.tencent.mm.plugin.wepkg.e();
          if (((com.tencent.mm.plugin.wepkg.e)localObject2).m(str, true, false))
          {
            Log.i("MicroMsg.JsApiRequire", "has wepkg");
            WebResourceResponse localWebResourceResponse = ((com.tencent.mm.plugin.wepkg.e)localObject2).p(null, str);
            if (localWebResourceResponse != null)
            {
              str = d.convertStreamToString(localWebResourceResponse.mInputStream);
              ((JSONObject)localObject1).put("header", localWebResourceResponse.mResponseHeaders);
              ((JSONObject)localObject1).put("data", str);
              paramb.c("", (JSONObject)localObject1);
              ((com.tencent.mm.plugin.wepkg.e)localObject2).zE(true);
              AppMethodBeat.o(210955);
              return;
            }
          }
          localObject1 = com.tencent.mm.plugin.webview.h.e.Q(str, null);
          if (localObject1 != null)
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("header", ((e.a)localObject1).njn);
            ((JSONObject)localObject2).put("data", ((e.a)localObject1).data);
            paramb.c("", (JSONObject)localObject2);
            AppMethodBeat.o(210955);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          paramb.c("fail", null);
          AppMethodBeat.o(210955);
          return;
        }
        paramb.c("fail", null);
        AppMethodBeat.o(210955);
      }
    });
    AppMethodBeat.o(210956);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "require";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.az
 * JD-Core Version:    0.7.0.1
 */