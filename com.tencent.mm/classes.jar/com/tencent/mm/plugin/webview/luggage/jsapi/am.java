package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class am
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(230727);
    Log.d("MicroMsg.JsApiOpenFinderView", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.i("data is null", null);
        AppMethodBeat.o(230727);
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
        ((ak)h.ag(ak.class)).enterFinderUI(paramContext, localJSONObject.toString());
        parama.i(null, null);
        AppMethodBeat.o(230727);
        return;
      }
      catch (JSONException paramContext)
      {
        parama.i("fail", null);
        AppMethodBeat.o(230727);
      }
    }
  }
  
  public final void b(b<g>.a paramb) {}
  
  public final int cDj()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openFinderView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.am
 * JD-Core Version:    0.7.0.1
 */