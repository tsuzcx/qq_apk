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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.WebResourceResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class ay<T extends a>
  extends bq<T>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b<T>.a paramb)
  {
    AppMethodBeat.i(198098);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198097);
        try
        {
          String str = paramb.chh.cgn.optString("url");
          if (bu.isNullOrNil(str))
          {
            paramb.a("fail", null);
            AppMethodBeat.o(198097);
            return;
          }
          Object localObject1 = new JSONObject();
          Object localObject2 = new com.tencent.mm.plugin.wepkg.d();
          if (((com.tencent.mm.plugin.wepkg.d)localObject2).k(str, true, false))
          {
            ae.i("MicroMsg.JsApiRequire", "has wepkg");
            WebResourceResponse localWebResourceResponse = ((com.tencent.mm.plugin.wepkg.d)localObject2).p(null, str);
            if (localWebResourceResponse != null)
            {
              str = com.tencent.mm.plugin.appbrand.y.d.convertStreamToString(localWebResourceResponse.mInputStream);
              ((JSONObject)localObject1).put("header", localWebResourceResponse.mResponseHeaders);
              ((JSONObject)localObject1).put("data", str);
              paramb.a("", (JSONObject)localObject1);
              ((com.tencent.mm.plugin.wepkg.d)localObject2).vI(true);
              AppMethodBeat.o(198097);
              return;
            }
          }
          localObject1 = e.L(str, null);
          if (localObject1 != null)
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("header", ((e.a)localObject1).mbB);
            ((JSONObject)localObject2).put("data", ((e.a)localObject1).data);
            paramb.a("", (JSONObject)localObject2);
            AppMethodBeat.o(198097);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          paramb.a("fail", null);
          AppMethodBeat.o(198097);
          return;
        }
        paramb.a("fail", null);
        AppMethodBeat.o(198097);
      }
    });
    AppMethodBeat.o(198098);
  }
  
  public final int ced()
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