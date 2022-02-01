package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.a.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class aa
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(296015);
    Log.d("MicroMsg.JsApiGetUserConfig", "invokeInMM");
    paramContext = new JSONObject();
    try
    {
      boolean bool1 = a.a.jlv().jls();
      boolean bool2 = com.tencent.mm.ce.b.iRp();
      paramContext.put("isAccessibilityMode", bool1);
      paramContext.put("isCareMode", bool2);
      Log.i("MicroMsg.JsApiGetUserConfig", "isAccessibilityMode:%b, isCareMode:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      label78:
      parama.j(null, paramContext);
      AppMethodBeat.o(296015);
      return;
    }
    catch (JSONException paramString)
    {
      break label78;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getUserConfig";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aa
 * JD-Core Version:    0.7.0.1
 */