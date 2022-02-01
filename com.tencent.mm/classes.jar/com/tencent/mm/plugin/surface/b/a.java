package com.tencent.mm.plugin.surface.b;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.jsapi.ae.n;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.surface.c.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/JsApiGetSystemInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "getInfo", "", "", "", "component", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends n<f>
{
  public final Map<String, Object> a(f paramf)
  {
    AppMethodBeat.i(265102);
    s.u(paramf, "component");
    paramf = ak.f(new r[] { v.Y("screenWidth", Integer.valueOf(h.hBY())), v.Y("screenHeight", Integer.valueOf(h.hBZ())), v.Y("pixelRatio", Float.valueOf(h.getDevicePixelRatio())), v.Y("windowWidth", Integer.valueOf(h.hBY())), v.Y("windowHeight", Integer.valueOf(h.hBZ())), v.Y("brand", Build.BRAND), v.Y("model", q.aPo()), v.Y("abi", Build.CPU_ABI), v.Y("system", s.X("Android ", Build.VERSION.RELEASE)) });
    AppMethodBeat.o(265102);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.a
 * JD-Core Version:    0.7.0.1
 */