package com.tencent.mm.plugin.surface.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/JsApiSystemLog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "log", "block", "Lkotlin/Function2;", "", "message", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends c<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 65;
  public static final String NAME = "systemLog";
  public static final a SKO;
  
  static
  {
    AppMethodBeat.i(265094);
    SKO = new a((byte)0);
    AppMethodBeat.o(265094);
  }
  
  private static void a(m<? super String, ? super String, ah> paramm, String paramString)
  {
    AppMethodBeat.i(265090);
    paramm.invoke("MicroMsg.SurfaceApp.JsApiSystemLog", paramString);
    AppMethodBeat.o(265090);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(265107);
    s.u(paramf, "env");
    s.u(paramJSONObject, "data");
    String str = "[" + paramf.getAppId() + "] " + paramJSONObject.optString("message");
    paramJSONObject = paramJSONObject.optString("level");
    if (paramJSONObject != null) {}
    switch (paramJSONObject.hashCode())
    {
    default: 
      a((m)f.SKT, str);
    }
    for (;;)
    {
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(265107);
      return;
      if (!paramJSONObject.equals("warn")) {
        break;
      }
      a((m)d.SKR, str);
      continue;
      if (!paramJSONObject.equals("debug")) {
        break;
      }
      a((m)b.SKP, str);
      continue;
      if (!paramJSONObject.equals("error")) {
        break;
      }
      a((m)e.SKS, str);
      continue;
      if (!paramJSONObject.equals("info")) {
        break;
      }
      a((m)c.SKQ, str);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/JsApiSystemLog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.f
 * JD-Core Version:    0.7.0.1
 */