package com.tencent.mm.plugin.surface.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/JsApiPreloadMiniProgramEnv;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "preloadEnv", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.ab<f>
{
  public static final int CTRL_INDEX = 644;
  public static final String NAME = "preloadMiniProgramEnv";
  public static final d.a SKM;
  
  static
  {
    AppMethodBeat.i(265077);
    SKM = new d.a((byte)0);
    AppMethodBeat.o(265077);
  }
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(265089);
    s.u(paramf, "component");
    s.u(paramJSONObject, "data");
    Log.i("MicroMsg.SurfaceApp.JsApiPreloadMiniProgramEnv", "preloadEnv");
    ((g)h.ax(g.class)).a(com.tencent.mm.plugin.appbrand.service.ab.tTT);
    paramf = new p.a("ok", new Object[0]).I((Map)new HashMap());
    s.s(paramf, "CallResult(\"ok\").putAll(HashMap())");
    paramf = m(paramf.errMsg, paramf.values);
    s.s(paramf, "makeReturnJson(ret.errMsg, ret.values)");
    AppMethodBeat.o(265089);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.d
 * JD-Core Version:    0.7.0.1
 */