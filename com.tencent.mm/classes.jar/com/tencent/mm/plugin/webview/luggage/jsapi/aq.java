package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class aq
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(296024);
    Log.d("MicroMsg.JsApiOpenFinderView", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.j("data is null", null);
        AppMethodBeat.o(296024);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("extInfo", new JSONObject(paramString.optString("extInfo")));
        ((cn)h.az(cn.class)).enterFinderUI(paramContext, localJSONObject.toString());
        parama.j(null, null);
        AppMethodBeat.o(296024);
        return;
      }
      catch (JSONException paramContext)
      {
        parama.j("fail", null);
        AppMethodBeat.o(296024);
      }
    }
  }
  
  public final void b(b<g>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openFinderView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aq
 * JD-Core Version:    0.7.0.1
 */