package com.tencent.mm.plugin.surface.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a;
import com.tencent.mm.plugin.appbrand.n.e;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.surface.core.d.b;
import com.tencent.mm.plugin.surface.core.h;
import com.tencent.mm.plugin.surface.core.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceMultiContextJsApiImpl;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceMultiContextJsApiContext;", "service", "Lcom/tencent/mm/plugin/surface/core/MultiContextService;", "workerJsEngine", "Lcom/tencent/mm/plugin/surface/core/WorkerJsEngine;", "(Lcom/tencent/mm/plugin/surface/core/MultiContextService;Lcom/tencent/mm/plugin/surface/core/WorkerJsEngine;)V", "bridgeHolder", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "alloc", "", "allocEmpty", "create", "scriptPath", "", "createSubContext", "destroy", "", "contextId", "evaluateScript", "script", "evaluateScriptFile", "path", "getSubContext", "loadJsFilesWithOptions", "paths", "options", "loadLibFiles", "onAttach", "name", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements f
{
  public static final a SLb;
  private final com.tencent.mm.plugin.surface.core.c SJP;
  private final k SLc;
  private com.tencent.mm.plugin.appbrand.n.g SLd;
  
  static
  {
    AppMethodBeat.i(265187);
    SLb = new a((byte)0);
    AppMethodBeat.o(265187);
  }
  
  public g(com.tencent.mm.plugin.surface.core.c paramc, k paramk)
  {
    AppMethodBeat.i(265143);
    this.SJP = paramc;
    this.SLc = paramk;
    AppMethodBeat.o(265143);
  }
  
  private static final void a(g paramg, com.tencent.mm.plugin.appbrand.n.g paramg1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(265172);
    s.u(paramg, "this$0");
    Log.e("MicroMsg.SurfaceApp.JSAPI.SurfaceMultiContextJsApiImpl", "JsException[" + paramg.SJP.getAppId() + '#' + paramg1.czh() + "]:" + paramString1 + '\n' + paramString2);
    AppMethodBeat.o(265172);
  }
  
  private final com.tencent.mm.plugin.appbrand.n.g anM(int paramInt)
  {
    AppMethodBeat.i(265163);
    com.tencent.mm.plugin.appbrand.n.g localg = this.SLc.BK(paramInt);
    AppMethodBeat.o(265163);
    return localg;
  }
  
  private final com.tencent.mm.plugin.appbrand.n.g hBP()
  {
    Object localObject2 = null;
    AppMethodBeat.i(265155);
    com.tencent.mm.plugin.appbrand.n.g localg2 = this.SLc.sSV.czj();
    localg2.setJsExceptionHandler(new g..ExternalSyntheticLambda0(this, localg2));
    com.tencent.mm.plugin.appbrand.n.g localg1 = this.SLd;
    Object localObject1 = localg1;
    if (localg1 == null)
    {
      s.bIx("bridgeHolder");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.appbrand.n.g)localObject1).b(localg2, "setTimeout");
    localg1 = this.SLd;
    localObject1 = localg1;
    if (localg1 == null)
    {
      s.bIx("bridgeHolder");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.appbrand.n.g)localObject1).b(localg2, "clearTimeout");
    localg1 = this.SLd;
    localObject1 = localg1;
    if (localg1 == null)
    {
      s.bIx("bridgeHolder");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.appbrand.n.g)localObject1).b(localg2, "setInterval");
    localg1 = this.SLd;
    localObject1 = localg1;
    if (localg1 == null)
    {
      s.bIx("bridgeHolder");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.appbrand.n.g)localObject1).b(localg2, "clearInterval");
    localg1 = this.SLd;
    localObject1 = localg1;
    if (localg1 == null)
    {
      s.bIx("bridgeHolder");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.appbrand.n.g)localObject1).b(localg2, "VMGlobal");
    localObject1 = this.SLd;
    if (localObject1 == null)
    {
      s.bIx("bridgeHolder");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.n.g)localObject1).b(localg2, "WeixinJSContext");
      s.s(localg2, "workerJsEngine.allocJsCo…INTERFACE_NAME)\n        }");
      AppMethodBeat.o(265155);
      return localg2;
    }
  }
  
  public final void a(String paramString, i parami)
  {
    Object localObject = null;
    AppMethodBeat.i(265200);
    s.u(paramString, "name");
    s.u(parami, "jsRuntime");
    this.SLc.addJavascriptInterface(new c(), "VMGlobal");
    paramString = this.SLc.sSV.czj();
    s.s(paramString, "workerJsEngine.allocJsContext()");
    this.SLd = paramString;
    k localk = this.SLc;
    parami = this.SLd;
    paramString = parami;
    if (parami == null)
    {
      s.bIx("bridgeHolder");
      paramString = null;
    }
    localk.b(paramString, "setTimeout");
    localk = this.SLc;
    parami = this.SLd;
    paramString = parami;
    if (parami == null)
    {
      s.bIx("bridgeHolder");
      paramString = null;
    }
    localk.b(paramString, "clearTimeout");
    localk = this.SLc;
    parami = this.SLd;
    paramString = parami;
    if (parami == null)
    {
      s.bIx("bridgeHolder");
      paramString = null;
    }
    localk.b(paramString, "setInterval");
    localk = this.SLc;
    parami = this.SLd;
    paramString = parami;
    if (parami == null)
    {
      s.bIx("bridgeHolder");
      paramString = null;
    }
    localk.b(paramString, "clearInterval");
    localk = this.SLc;
    parami = this.SLd;
    paramString = parami;
    if (parami == null)
    {
      s.bIx("bridgeHolder");
      paramString = null;
    }
    localk.b(paramString, "VMGlobal");
    parami = this.SLc;
    paramString = this.SLd;
    if (paramString == null)
    {
      s.bIx("bridgeHolder");
      paramString = localObject;
    }
    for (;;)
    {
      parami.b(paramString, "WeixinJSContext");
      AppMethodBeat.o(265200);
      return;
    }
  }
  
  public final int alloc()
  {
    AppMethodBeat.i(265213);
    com.tencent.mm.plugin.appbrand.n.g localg = hBP();
    this.SLc.b(localg, "NativeGlobal");
    this.SJP.j((i)localg);
    this.SJP.k((i)localg);
    int i = localg.czh();
    AppMethodBeat.o(265213);
    return i;
  }
  
  public final int allocEmpty()
  {
    AppMethodBeat.i(265217);
    int i = hBP().czh();
    AppMethodBeat.o(265217);
    return i;
  }
  
  public final int create(String paramString)
  {
    AppMethodBeat.i(265252);
    s.u(paramString, "scriptPath");
    int i = allocEmpty();
    evaluateScriptFile(i, paramString);
    AppMethodBeat.o(265252);
    return i;
  }
  
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(265205);
    this.SLc.BL(paramInt);
    AppMethodBeat.o(265205);
  }
  
  public final int evaluateScript(int paramInt, String paramString)
  {
    AppMethodBeat.i(265228);
    s.u(paramString, "script");
    com.tencent.mm.plugin.appbrand.n.g localg = anM(paramInt);
    if (localg == null)
    {
      Log.e("MicroMsg.SurfaceApp.JSAPI.SurfaceMultiContextJsApiImpl", "contextId#" + paramInt + " not found");
      AppMethodBeat.o(265228);
      return -1;
    }
    localg.evaluateJavascript(paramString, null);
    AppMethodBeat.o(265228);
    return 0;
  }
  
  public final int evaluateScriptFile(int paramInt, String paramString)
  {
    AppMethodBeat.i(265237);
    s.u(paramString, "path");
    Object localObject = anM(paramInt);
    if (localObject == null)
    {
      Log.e("MicroMsg.SurfaceApp.JSAPI.SurfaceMultiContextJsApiImpl", "contextId#" + paramInt + " not found");
      AppMethodBeat.o(265237);
      return -1;
    }
    d.b localb = this.SJP.SJU.bcP(paramString);
    if (localb == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(0))
    {
      Log.e("MicroMsg.SurfaceApp.JSAPI.SurfaceMultiContextJsApiImpl", "script file:" + paramString + " not found");
      AppMethodBeat.o(265237);
      return -2;
      h.a((i)localObject, localb, null);
    }
    paramInt = ((Integer)localObject).intValue();
    AppMethodBeat.o(265237);
    return paramInt;
  }
  
  public final void loadJsFilesWithOptions(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(265258);
    s.u(paramString1, "paths");
    s.u(paramString2, "options");
    loadLibFiles(paramInt, paramString1);
    AppMethodBeat.o(265258);
  }
  
  public final void loadLibFiles(final int paramInt, String paramString)
  {
    AppMethodBeat.i(265245);
    s.u(paramString, "paths");
    final com.tencent.mm.plugin.appbrand.n.g localg = anM(paramInt);
    if (localg != null) {
      com.tencent.luggage.sdk.h.c.a((JSONArray)new com.tencent.mm.ad.f(paramString), (b)new b(this, localg, paramInt));
    }
    AppMethodBeat.o(265245);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceMultiContextJsApiImpl$Companion;", "", "()V", "TAG", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "path", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<String, ah>
  {
    b(g paramg, com.tencent.mm.plugin.appbrand.n.g paramg1, int paramInt)
    {
      super();
    }
    
    private static final void a(g paramg, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(265154);
      s.u(paramg, "this$0");
      s.u(paramString1, "$path");
      Log.i("MicroMsg.SurfaceApp.JSAPI.SurfaceMultiContextJsApiImpl", g.a(paramg).getAppId() + '#' + paramInt + " inject basic: " + paramString1 + ", ret: " + paramString2);
      AppMethodBeat.o(265154);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/jsapi/plain/SurfaceMultiContextJsApiImpl$onAttach$1", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.a.g
 * JD-Core Version:    0.7.0.1
 */