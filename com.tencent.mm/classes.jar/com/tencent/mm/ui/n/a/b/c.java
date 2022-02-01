package com.tencent.mm.ui.n.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "systemLog";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(276137);
    String str = paramJSONObject.optString("level");
    paramJSONObject = paramJSONObject.optString("content");
    if ((!Util.isNullOrNil(str)) && (!Util.isNullOrNil(paramJSONObject)))
    {
      if (!"info".equalsIgnoreCase(str)) {
        break label71;
      }
      Log.i("MicroMsg.JsApiSystemLogME", paramJSONObject);
    }
    for (;;)
    {
      parame.j(paramInt, h("ok", null));
      AppMethodBeat.o(276137);
      return;
      label71:
      if ("warn".equalsIgnoreCase(str)) {
        Log.w("MicroMsg.JsApiSystemLogME", paramJSONObject);
      } else {
        Log.e("MicroMsg.JsApiSystemLogME", paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.b.c
 * JD-Core Version:    0.7.0.1
 */