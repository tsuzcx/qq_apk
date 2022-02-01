package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.g.e;
import com.tencent.mm.plugin.webview.g.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebResourceResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class ay<T extends a>
  extends bq<T>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b<T>.a paramb)
  {
    AppMethodBeat.i(207918);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207917);
        try
        {
          String str = paramb.chh.cgn.optString("url");
          if (bt.isNullOrNil(str))
          {
            paramb.a("fail", null);
            AppMethodBeat.o(207917);
            return;
          }
          Object localObject1 = new JSONObject();
          Object localObject2 = new com.tencent.mm.plugin.wepkg.d();
          if (((com.tencent.mm.plugin.wepkg.d)localObject2).k(str, true, false))
          {
            ad.i("MicroMsg.JsApiRequire", "has wepkg");
            WebResourceResponse localWebResourceResponse = ((com.tencent.mm.plugin.wepkg.d)localObject2).o(null, str);
            if (localWebResourceResponse != null)
            {
              str = com.tencent.mm.plugin.appbrand.z.d.convertStreamToString(localWebResourceResponse.mInputStream);
              ((JSONObject)localObject1).put("header", localWebResourceResponse.mResponseHeaders);
              ((JSONObject)localObject1).put("data", str);
              paramb.a("", (JSONObject)localObject1);
              ((com.tencent.mm.plugin.wepkg.d)localObject2).vz(true);
              AppMethodBeat.o(207917);
              return;
            }
          }
          localObject1 = e.K(str, null);
          if (localObject1 != null)
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("header", ((e.a)localObject1).lWV);
            ((JSONObject)localObject2).put("data", ((e.a)localObject1).data);
            paramb.a("", (JSONObject)localObject2);
            AppMethodBeat.o(207917);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          paramb.a("fail", null);
          AppMethodBeat.o(207917);
          return;
        }
        paramb.a("fail", null);
        AppMethodBeat.o(207917);
      }
    });
    AppMethodBeat.o(207918);
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "require";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ay
 * JD-Core Version:    0.7.0.1
 */