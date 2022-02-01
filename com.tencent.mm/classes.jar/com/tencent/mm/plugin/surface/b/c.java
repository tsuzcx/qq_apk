package com.tencent.mm.plugin.surface.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.glg;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/JsApiOperateWXData;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "operateWXData", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends ab<f>
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  public static final c.a SKK;
  
  static
  {
    AppMethodBeat.i(265084);
    SKK = new c.a((byte)0);
    AppMethodBeat.o(265084);
  }
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(265100);
    s.u(paramf, "component");
    s.u(paramJSONObject, "data");
    deg localdeg = new deg();
    localdeg.oOI = paramf.getAppId();
    paramf = paramJSONObject.optString("data");
    s.s(paramf, "data.optString(\"data\")");
    paramf = paramf.getBytes(kotlin.n.d.UTF_8);
    s.s(paramf, "(this as java.lang.String).getBytes(charset)");
    localdeg.vgA = new b(paramf);
    localdeg.aaJu = 0;
    localdeg.aaJt = 0;
    localdeg.aaJM = "";
    localdeg.ZqK = 0;
    paramf = new glg();
    paramf.scene = 1184;
    paramJSONObject = ah.aiuX;
    localdeg.aaJv = paramf;
    paramf = new com.tencent.mm.am.c.a();
    paramf.otE = ((com.tencent.mm.bx.a)localdeg);
    paramf.otF = ((com.tencent.mm.bx.a)new deh());
    paramf.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
    paramf.funcId = 1133;
    paramf.otG = 0;
    paramf.respCmdId = 0;
    com.tencent.mm.ae.d.B((kotlin.g.a.a)new c.b(paramf.bEF()));
    paramf = new p.a("ok", new Object[0]).I((Map)new HashMap());
    s.s(paramf, "CallResult(\"ok\").putAll(HashMap())");
    paramf = m(paramf.errMsg, paramf.values);
    s.s(paramf, "makeReturnJson(ret.errMsg, ret.values)");
    AppMethodBeat.o(265100);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.c
 * JD-Core Version:    0.7.0.1
 */