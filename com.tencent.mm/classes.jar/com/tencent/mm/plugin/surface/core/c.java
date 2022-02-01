package com.tencent.mm.plugin.surface.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.n.m;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.surface.b.a.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/MultiContextService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceWorkerJsApiContext;", "()V", "commonBindingService", "Lcom/tencent/mm/plugin/surface/core/CommonBindingService;", "debuggerListener", "Lcom/tencent/mm/api/DevToolsListener;", "packageManager", "Lcom/tencent/mm/plugin/surface/core/PackageManager;", "getPackageManager$plugin_surface_app_release", "()Lcom/tencent/mm/plugin/surface/core/PackageManager;", "serviceName", "", "getServiceName", "()Ljava/lang/String;", "subComponent", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSubComponent", "()Ljava/util/HashMap;", "workerJsEngine", "Lcom/tencent/mm/plugin/surface/core/WorkerJsEngine;", "getWorkerJsEngine$plugin_surface_app_release", "()Lcom/tencent/mm/plugin/surface/core/WorkerJsEngine;", "cleanup", "", "createFrameSetComponent", "root", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "config", "Lcom/tencent/mm/plugin/surface/core/SurfaceConfig;", "createJsApiPool", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "createJsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "generateWxConfig", "Lcom/tencent/mm/json/JSONObject;", "getAppId", "getAppState", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "getContext", "Landroid/content/Context;", "injectCommonLib", "jsRuntime", "injectCommonLib$plugin_surface_app_release", "injectDevtoolsLib", "injectDevtoolsLib$plugin_surface_app_release", "injectEnv", "injectEnv$plugin_surface_app_release", "injectWxConfig", "invoke", "api", "data", "privateData", "callbackId", "", "isFromAsyncThread", "", "workerEvaluatable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "isRunning", "onJsRuntimeCreated", "onJsRuntimeInit", "onWorkerMessage", "message", "onWorkerMessage$plugin_surface_app_release", "postJsRuntimeCreated", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends com.tencent.mm.plugin.appbrand.jsapi.g
  implements com.tencent.mm.plugin.surface.b.a.k
{
  public static final a SJT = new a((byte)0);
  private static final j<String> SJY = kotlin.k.cm((kotlin.g.a.a)b.SJZ);
  public final f SJU = new f();
  final HashMap<String, com.tencent.mm.plugin.appbrand.jsapi.g> SJV = new HashMap();
  private com.tencent.mm.api.e SJW;
  private a SJX;
  
  private static final void a(c paramc)
  {
    kotlin.g.b.s.u(paramc, "this$0");
    a locala = paramc.SJX;
    paramc = locala;
    if (locala == null)
    {
      kotlin.g.b.s.bIx("commonBindingService");
      paramc = null;
    }
    Log.i("MicroMsg.SurfaceApp.CommonBindingService", "notifyDestroy");
    paramc.SJQ.esf.notifyDestroy();
  }
  
  private static final void a(c paramc, String paramString1, String paramString2)
  {
    kotlin.g.b.s.u(paramc, "this$0");
    Log.e("MicroMsg.SurfaceApp.MultiContextService", "JsException[" + paramc.getAppId() + "]:" + paramString1 + '\n' + paramString2);
  }
  
  private static final void bcN(String paramString)
  {
    Log.v("MicroMsg.SurfaceApp.MultiContextService", kotlin.g.b.s.X("devtoolsLib injected: ", paramString));
  }
  
  private k hBE()
  {
    com.tencent.mm.plugin.appbrand.n.i locali = getJsRuntime();
    if (locali == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.surface.core.WorkerJsEngine");
    }
    return (k)locali;
  }
  
  private static final void nh(String paramString1, String paramString2)
  {
    kotlin.g.b.s.u(paramString1, "$wxConfig");
    Log.v("MicroMsg.SurfaceApp.MultiContextService", kotlin.g.b.s.X(" wxconfig injected: ", paramString1));
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, o paramo)
  {
    Object localObject = (CharSequence)paramString3;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = new JSONObject(paramString3);
      if (!((JSONObject)localObject).has("appId")) {
        break;
      }
      localObject = ((JSONObject)localObject).getString("appId");
      localObject = (com.tencent.mm.plugin.appbrand.jsapi.g)this.SJV.get(localObject);
      if (localObject == null) {
        break;
      }
      paramString1 = ((com.tencent.mm.plugin.appbrand.jsapi.g)localObject).a(paramString1, paramString2, paramString3, paramInt, paramBoolean, paramo);
      kotlin.g.b.s.s(paramString1, "component.invoke(api, da…hread, workerEvaluatable)");
      return paramString1;
    }
    paramString1 = super.a(paramString1, paramString2, paramString3, paramInt, paramBoolean, paramo);
    kotlin.g.b.s.s(paramString1, "super.invoke(\n          …rkerEvaluatable\n        )");
    return paramString1;
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> arA()
  {
    return h.C((Collection)kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.p[] { (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.a(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.aa.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.e() }));
  }
  
  public final void ary()
  {
    super.ary();
    com.tencent.mm.kernel.h.ax(com.tencent.mm.api.s.class);
    Log.i("MicroMsg.SurfaceApp.MultiContextService", "postJsRuntimeCreated");
    Object localObject1 = getJsRuntime();
    kotlin.g.b.s.s(localObject1, "jsRuntime");
    j((com.tencent.mm.plugin.appbrand.n.i)localObject1);
    this.SJX = new a(this);
    Object localObject2 = this.SJX;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("commonBindingService");
      localObject1 = null;
    }
    ((a)localObject1).bcL(getAppId());
    localObject1 = getJsRuntime();
    kotlin.g.b.s.s(localObject1, "jsRuntime");
    h((com.tencent.mm.plugin.appbrand.n.i)localObject1);
    localObject1 = getJsRuntime();
    kotlin.g.b.s.s(localObject1, "jsRuntime");
    k((com.tencent.mm.plugin.appbrand.n.i)localObject1);
    localObject1 = new com.tencent.mm.plugin.surface.b.a.e((com.tencent.mm.plugin.surface.b.a.f)new com.tencent.mm.plugin.surface.b.a.g(this, hBE()));
    localObject2 = getJsRuntime();
    kotlin.g.b.s.s(localObject2, "jsRuntime");
    ((com.tencent.mm.plugin.surface.b.a.e)localObject1).l((com.tencent.mm.plugin.appbrand.n.i)localObject2);
    localObject1 = new com.tencent.mm.plugin.surface.b.a.c(new d());
    localObject2 = getJsRuntime();
    kotlin.g.b.s.s(localObject2, "jsRuntime");
    ((com.tencent.mm.plugin.surface.b.a.c)localObject1).l((com.tencent.mm.plugin.appbrand.n.i)localObject2);
    localObject1 = getJsRuntime();
    kotlin.g.b.s.s(localObject1, "jsRuntime");
    i((com.tencent.mm.plugin.appbrand.n.i)localObject1);
    localObject1 = getJsRuntime();
    kotlin.g.b.s.s(localObject1, "jsRuntime");
    kotlin.g.b.s.u(localObject1, "jsRuntime");
    Log.v("MicroMsg.SurfaceApp.MultiContextService", kotlin.g.b.s.X("injectDevtoolsLib: ", localObject1));
    h.a((com.tencent.mm.plugin.appbrand.n.i)localObject1, "jsapi/surface/lib/devtools.js", c..ExternalSyntheticLambda1.INSTANCE);
  }
  
  public final com.tencent.mm.plugin.appbrand.n.i arz()
  {
    Object localObject = new IJSRuntime.Config();
    ((IJSRuntime.Config)localObject).hmb = ((String)SJY.getValue());
    ((IJSRuntime.Config)localObject).hmd = "0";
    ((IJSRuntime.Config)localObject).hme = true;
    ((IJSRuntime.Config)localObject).hmg = true;
    ((IJSRuntime.Config)localObject).hmh = false;
    ((IJSRuntime.Config)localObject).hmj = kotlin.g.b.s.X("Runtime", getServiceName());
    ((IJSRuntime.Config)localObject).hml = new WeakReference(this);
    localObject = new com.tencent.mm.plugin.surface.a.a((IJSRuntime.Config)localObject, (com.tencent.mm.plugin.surface.b.a.k)this);
    ((com.tencent.mm.plugin.surface.a.a)localObject).setJsExceptionHandler(new c..ExternalSyntheticLambda2(this));
    if ((BuildInfo.DEBUG) && ((com.tencent.mm.api.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.s.class) != null)) {
      this.SJW = ((com.tencent.mm.api.e)new d(this, (com.tencent.mm.plugin.surface.a.a)localObject));
    }
    return (com.tencent.mm.plugin.appbrand.n.i)localObject;
  }
  
  public final void bcM(String paramString)
  {
    kotlin.g.b.s.u(paramString, "message");
    hBE().Yk(paramString);
  }
  
  public void cleanup()
  {
    Log.i("MicroMsg.SurfaceApp.MultiContextService", "cleanup");
    Object localObject = getJsRuntime();
    kotlin.g.b.s.s(localObject, "jsRuntime");
    localObject = (m)((com.tencent.mm.plugin.appbrand.n.i)localObject).Z(m.class);
    if (localObject != null) {
      ((m)localObject).a(new c..ExternalSyntheticLambda3(this));
    }
    if (this.SJW != null) {
      com.tencent.mm.kernel.h.ax(com.tencent.mm.api.s.class);
    }
    super.cleanup();
  }
  
  public String getAppId()
  {
    return "MultiContextService";
  }
  
  public b getAppState()
  {
    return b.qKw;
  }
  
  public Context getContext()
  {
    Context localContext = MMApplicationContext.getContext();
    kotlin.g.b.s.s(localContext, "getContext()");
    return localContext;
  }
  
  protected abstract String getServiceName();
  
  protected void h(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    kotlin.g.b.s.u(parami, "jsRuntime");
  }
  
  protected abstract void i(com.tencent.mm.plugin.appbrand.n.i parami);
  
  public final boolean isRunning()
  {
    return true;
  }
  
  public void j(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    kotlin.g.b.s.u(parami, "jsRuntime");
    Log.v("MicroMsg.SurfaceApp.MultiContextService", "injectEnv");
    Object localObject = new com.tencent.mm.ad.i();
    ((com.tencent.mm.ad.i)localObject).m("platform", "android");
    ((com.tencent.mm.ad.i)localObject).A("isIsolateContext", false);
    ((com.tencent.mm.ad.i)localObject).A("nativeBufferEnabled", true);
    ((com.tencent.mm.ad.i)localObject).m("JSEngineName", getServiceName());
    ((com.tencent.mm.ad.i)localObject).au("clientVersion", BuildInfo.CLIENT_VERSION_INT);
    ((com.tencent.mm.ad.i)localObject).A("supportAsyncGetSystemInfo", true);
    ((com.tencent.mm.ad.i)localObject).A("isDarkMode", aw.isDarkMode());
    localObject = ((com.tencent.mm.ad.i)localObject).toString();
    kotlin.g.b.s.s(localObject, "generateWxConfig().toString()");
    parami.evaluateJavascript("var __wxConfig = " + (String)localObject + ';', new c..ExternalSyntheticLambda0((String)localObject));
    h.a(parami, "wxa_library/android.js", null);
    h.a(parami, "wxa_library/shared_buffer.js", null);
  }
  
  public void k(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    kotlin.g.b.s.u(parami, "jsRuntime");
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/MultiContextService$Companion;", "", "()V", "TAG", "", "cachePath", "kotlin.jvm.PlatformType", "getCachePath", "()Ljava/lang/String;", "cachePath$delegate", "Lkotlin/Lazy;", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final b SJZ;
    
    static
    {
      AppMethodBeat.i(265259);
      SJZ = new b();
      AppMethodBeat.o(265259);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/core/MultiContextService$createFrameSetComponent$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "createJsApiPool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "createJsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "getAppId", "getAppState", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "getContext", "Landroid/content/Context;", "isRunning", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.appbrand.jsapi.g
  {
    c(com.tencent.mm.plugin.surface.c.f paramf, c paramc, g paramg) {}
    
    public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> arA()
    {
      return this.SKc.SKy;
    }
    
    public final com.tencent.mm.plugin.appbrand.n.i arz()
    {
      AppMethodBeat.i(265274);
      com.tencent.mm.plugin.appbrand.n.i locali = this.SKb.getJsRuntime();
      kotlin.g.b.s.s(locali, "this@MultiContextService.jsRuntime");
      AppMethodBeat.o(265274);
      return locali;
    }
    
    public final String getAppId()
    {
      AppMethodBeat.i(265253);
      String str = this.SKa.hBU();
      AppMethodBeat.o(265253);
      return str;
    }
    
    public final b getAppState()
    {
      AppMethodBeat.i(265272);
      b localb = this.SKb.getAppState();
      AppMethodBeat.o(265272);
      return localb;
    }
    
    public final Context getContext()
    {
      AppMethodBeat.i(265262);
      Context localContext = this.SKa.getContext();
      AppMethodBeat.o(265262);
      return localContext;
    }
    
    public final boolean isRunning()
    {
      AppMethodBeat.i(265266);
      boolean bool = this.SKb.isRunning();
      AppMethodBeat.o(265266);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/core/MultiContextService$createJsRuntime$2$1", "Lcom/tencent/mm/api/DevToolsListener;", "dispatch", "", "payload", "", "getDescription", "getName", "onOpen", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.api.e
  {
    d(c paramc, com.tencent.mm.plugin.surface.a.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.c
 * JD-Core Version:    0.7.0.1
 */