package com.tencent.mm.plugin.surface.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.f;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/JsApiNavigateToMiniProgram;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "launch", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends ab<f>
{
  public static final int CTRL_INDEX = 251;
  public static final String NAME = "navigateToMiniProgram";
  public static final b.a SKJ;
  
  static
  {
    AppMethodBeat.i(265099);
    SKJ = new b.a((byte)0);
    AppMethodBeat.o(265099);
  }
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(265117);
    s.u(paramf, "component");
    s.u(paramJSONObject, "data");
    g localg = new g();
    localg.appId = paramJSONObject.optString("appId");
    localg.qAF = paramJSONObject.optString("path");
    localg.scene = paramJSONObject.optInt("scene");
    localg.hzx = paramJSONObject.optString("sceneNote");
    localg.euz = com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.a(paramJSONObject.optString("envVersion"), com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.shS).euz;
    localg.qAI = paramJSONObject.optInt("preScene", 0);
    localg.qAJ = paramJSONObject.optString("preSceneNote");
    Object localObject1;
    Object localObject2;
    if (paramJSONObject.has("extraData"))
    {
      localObject1 = new AppBrandLaunchReferrer();
      ((AppBrandLaunchReferrer)localObject1).appId = paramf.getAppId();
      ((AppBrandLaunchReferrer)localObject1).hRR = paramJSONObject.optString("extraData");
      localObject2 = ah.aiuX;
      localg.qAO = ((AppBrandLaunchReferrer)localObject1);
    }
    int j;
    double d;
    int i;
    HalfScreenConfig.BackgroundShapeConfig localBackgroundShapeConfig;
    label278:
    boolean bool2;
    boolean bool3;
    boolean bool4;
    label322:
    boolean bool5;
    boolean bool1;
    if (s.p(paramJSONObject.optString("mode"), "halfPage"))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("halfPage");
      if (localJSONObject != null)
      {
        localObject1 = localJSONObject.optString("capsuleMenuType");
        j = com.tencent.mm.plugin.surface.c.h.d((Number)Integer.valueOf(localJSONObject.optInt("landscapeWidth", -2)));
        d = localJSONObject.optDouble("height");
        if (!Double.isNaN(d)) {
          break label633;
        }
        i = -1;
        localBackgroundShapeConfig = new HalfScreenConfig.BackgroundShapeConfig((float)localJSONObject.optDouble("cornerRadius", 35.0D), true, true, 24);
        if (!localJSONObject.optBoolean("hideCapsuleMenu")) {
          break label675;
        }
        localObject1 = HalfScreenConfig.c.rap;
        bool2 = localJSONObject.optBoolean("forceLightMode");
        bool3 = localJSONObject.optBoolean("needShowTemplateNav");
        bool4 = localJSONObject.optBoolean("enableFullScreenGesture");
        if (localJSONObject.optBoolean("usePushAnimation", false) != true) {
          break label702;
        }
        localObject2 = HalfScreenConfig.a.raf;
        bool5 = localJSONObject.optBoolean("forbidFullScreenDragUpGesture", false);
        if (localJSONObject.optBoolean("hideSimulatedNativeLeftReturnButton", false)) {
          break label710;
        }
        bool1 = true;
        label346:
        paramJSONObject = localJSONObject.optString("loadingDarkModeStyle", paramJSONObject.optString("loadingDarkModeStyle"));
        if (!s.p(paramJSONObject, "dark")) {
          break label716;
        }
        paramJSONObject = HalfScreenConfig.f.rax;
      }
    }
    for (;;)
    {
      localg.qAT = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject2, true, localBackgroundShapeConfig, bool2, null, (HalfScreenConfig.c)localObject1, bool4, bool3, null, null, false, bool5, paramJSONObject, true, null, 0, 0, j, false, bool1, false, null, 13048896);
      Log.i("MicroMsg.SurfaceApp.JsApiNavigateToMiniProgram", "launch: " + localg.appId + ", " + localg.qAF + ", " + localg.scene + ", " + localg.hzx + ", " + localg.version + ", " + localg.qAI + ", " + localg.qAJ + ", " + localg.qAT);
      paramf = paramf.getContext();
      ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramf, localg);
      paramf = new p.a("ok", new Object[0]).I((Map)new HashMap());
      s.s(paramf, "CallResult(\"ok\").putAll(HashMap())");
      paramf = m(paramf.errMsg, paramf.values);
      s.s(paramf, "makeReturnJson(ret.errMsg, ret.values)");
      AppMethodBeat.o(265117);
      return paramf;
      label633:
      if (d == 0.0D) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label660;
        }
        i = -2;
        break;
      }
      label660:
      i = com.tencent.mm.plugin.surface.c.h.d((Number)Double.valueOf(d));
      break;
      label675:
      if (s.p(localObject1, "singleClose"))
      {
        localObject1 = HalfScreenConfig.c.rao;
        break label278;
      }
      localObject1 = HalfScreenConfig.c.ran;
      break label278;
      label702:
      localObject2 = HalfScreenConfig.a.rae;
      break label322;
      label710:
      bool1 = false;
      break label346;
      label716:
      if (s.p(paramJSONObject, "light")) {
        paramJSONObject = HalfScreenConfig.f.raw;
      } else {
        paramJSONObject = HalfScreenConfig.f.rav;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.b
 * JD-Core Version:    0.7.0.1
 */