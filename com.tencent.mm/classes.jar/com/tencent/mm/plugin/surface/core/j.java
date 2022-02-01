package com.tencent.mm.plugin.surface.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.surface.c.a;
import com.tencent.mm.plugin.surface.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/SurfaceService;", "Lcom/tencent/mm/plugin/surface/core/MultiContextService;", "()V", "configs", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/surface/core/SurfaceConfig;", "Lkotlin/collections/HashMap;", "renderCreated", "", "renderService", "Lcom/tencent/mm/plugin/surface/render/RenderService;", "serviceName", "getServiceName", "()Ljava/lang/String;", "cleanup", "", "create", "", "path", "dispatch", "event", "data", "getAppId", "getFileSystem", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystem;", "init", "onJsRuntimeCreated", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onJsRuntimeInit", "postMsgToWorker", "id", "message", "register", "appId", "config", "repaint", "width", "height", "verify", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends c
{
  public static final a SKC;
  private boolean SKD;
  private com.tencent.mm.plugin.surface.c.j SKE;
  public final HashMap<String, g> lZR;
  private final String serviceName;
  
  static
  {
    AppMethodBeat.i(265220);
    SKC = new a((byte)0);
    AppMethodBeat.o(265220);
  }
  
  public j()
  {
    AppMethodBeat.i(265195);
    this.lZR = new HashMap();
    this.serviceName = "SurfaceMainService";
    AppMethodBeat.o(265195);
  }
  
  private static final void bcY(String paramString)
  {
    AppMethodBeat.i(265202);
    Log.i("MicroMsg.SurfaceApp.SurfaceService", s.X("eval basic done: ", paramString));
    AppMethodBeat.o(265202);
  }
  
  public final void cJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265250);
    Log.i("MicroMsg.SurfaceApp.SurfaceService", "dispatch:" + paramString1 + ", " + paramString2);
    super.cJ(paramString1, paramString2);
    AppMethodBeat.o(265250);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(265295);
    super.cleanup();
    if (this.SKD)
    {
      com.tencent.mm.plugin.surface.c.j localj2 = this.SKE;
      com.tencent.mm.plugin.surface.c.j localj1 = localj2;
      if (localj2 == null)
      {
        s.bIx("renderService");
        localj1 = null;
      }
      localj1.cleanup();
    }
    AppMethodBeat.o(265295);
  }
  
  public final int create(String paramString)
  {
    AppMethodBeat.i(265286);
    s.u(paramString, "path");
    if (this.SKD)
    {
      Log.e("MicroMsg.SurfaceApp.SurfaceService", "create:" + paramString + " when render has been created");
      paramString = new Throwable("render has been created");
      AppMethodBeat.o(265286);
      throw paramString;
    }
    Log.i("MicroMsg.SurfaceApp.SurfaceService", s.X("create render with:", paramString));
    this.SKE = new com.tencent.mm.plugin.surface.c.j((c)this, paramString, (com.tencent.mm.plugin.surface.c.i)new b(this));
    this.SKD = true;
    com.tencent.mm.plugin.surface.c.j localj = this.SKE;
    paramString = localj;
    if (localj == null)
    {
      s.bIx("renderService");
      paramString = null;
    }
    paramString.init();
    AppMethodBeat.o(265286);
    return 0;
  }
  
  public final String getAppId()
  {
    return "SurfaceService";
  }
  
  public final w getFileSystem()
  {
    AppMethodBeat.i(265244);
    w localw = (w)new b((d)this.SJU);
    AppMethodBeat.o(265244);
    return localw;
  }
  
  protected final String getServiceName()
  {
    return this.serviceName;
  }
  
  protected final void h(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(265260);
    s.u(parami, "jsRuntime");
    super.h(parami);
    parami = e.SLi;
    e.a((com.tencent.mm.plugin.surface.c.b)new c(this));
    parami = e.SLi;
    e.a((com.tencent.mm.plugin.surface.c.d)new d(this));
    AppMethodBeat.o(265260);
  }
  
  protected final void i(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(265268);
    s.u(parami, "jsRuntime");
    d.b localb = this.SJU.bcP("index.js");
    if (localb == null) {}
    for (parami = null;; parami = ah.aiuX)
    {
      if (parami == null) {
        Log.e("MicroMsg.SurfaceApp.SurfaceService", "index.js not found");
      }
      AppMethodBeat.o(265268);
      return;
      h.a(parami, localb, j..ExternalSyntheticLambda0.INSTANCE);
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(265291);
    super.init();
    Log.i("MicroMsg.SurfaceApp.SurfaceService", "init finished");
    AppMethodBeat.o(265291);
  }
  
  public final void postMsgToWorker(int paramInt, String paramString)
  {
    AppMethodBeat.i(265277);
    s.u(paramString, "message");
    if (!this.SKD)
    {
      Log.e("MicroMsg.SurfaceApp.SurfaceService", "postMsgToWorker:" + paramInt + ", " + paramString + ", to no render");
      paramString = new Throwable("render has not been created");
      AppMethodBeat.o(265277);
      throw paramString;
    }
    com.tencent.mm.plugin.surface.c.j localj2 = this.SKE;
    com.tencent.mm.plugin.surface.c.j localj1 = localj2;
    if (localj2 == null)
    {
      s.bIx("renderService");
      localj1 = null;
    }
    localj1.bcM(paramString);
    AppMethodBeat.o(265277);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/SurfaceService$Companion;", "", "()V", "TAG", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/core/SurfaceService$create$1", "Lcom/tencent/mm/plugin/surface/render/RenderListener;", "onAttach", "", "onFirstFrameRender", "onSurfaceAvailable", "width", "", "height", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.surface.c.i
  {
    b(j paramj) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/core/SurfaceService$onJsRuntimeCreated$1", "Lcom/tencent/mm/plugin/surface/render/AppContextListener;", "onCreate", "", "appContext", "Lcom/tencent/mm/plugin/surface/render/AppContext;", "onDestroy", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.surface.c.b
  {
    c(j paramj) {}
    
    public final void a(a parama)
    {
      AppMethodBeat.i(265270);
      s.u(parama, "appContext");
      j localj = this.SKF;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", parama.appId);
      localJSONObject.put("appContextId", parama.id);
      parama = ah.aiuX;
      localj.cJ("surface:appContext:available", localJSONObject.toString());
      AppMethodBeat.o(265270);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/core/SurfaceService$onJsRuntimeCreated$2", "Lcom/tencent/mm/plugin/surface/render/FrameSetListener;", "onBind", "", "root", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "frameSet", "Lcom/tencent/mm/plugin/surface/render/FrameSet;", "info", "", "onCreate", "onDestroy", "onPause", "onRedraw", "canvasId", "", "width", "height", "onResume", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.surface.c.d
  {
    d(j paramj) {}
    
    public final void a(com.tencent.mm.plugin.surface.c.f paramf)
    {
      AppMethodBeat.i(265273);
      s.u(paramf, "root");
      Object localObject = (g)j.a(this.SKF).get(paramf.hBU());
      if (localObject != null)
      {
        localj = this.SKF;
        s.u(paramf, "root");
        s.u(localObject, "config");
        localObject = new c.c(paramf, localj, (g)localObject);
        ((c.c)localObject).init();
        ((Map)localj.SJV).put(paramf.hBU(), localObject);
      }
      j localj = this.SKF;
      localObject = new JSONObject();
      ((JSONObject)localObject).put("appId", paramf.hBU());
      ((JSONObject)localObject).put("appContextId", paramf.hBV());
      ((JSONObject)localObject).put("frameSetRootId", paramf.getId());
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("path", paramf.hBW());
      localJSONObject.put("query", paramf.hBX());
      paramf = ah.aiuX;
      ((JSONObject)localObject).put("launchInfo", localJSONObject);
      paramf = ah.aiuX;
      localj.cJ("surface:frameSetRoot:available", ((JSONObject)localObject).toString());
      AppMethodBeat.o(265273);
    }
    
    public final void a(com.tencent.mm.plugin.surface.c.f paramf, com.tencent.mm.plugin.surface.c.c paramc, String paramString)
    {
      AppMethodBeat.i(265279);
      s.u(paramf, "root");
      s.u(paramc, "frameSet");
      s.u(paramString, "info");
      j localj = this.SKF;
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("appId", paramf.hBU());
      localJSONObject1.put("frameSetRootId", paramf.getId());
      paramf = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("frameSetId", paramc.id);
      localJSONObject2.put("frameSetName", paramc.name);
      localJSONObject2.put("info", paramString);
      paramc = ah.aiuX;
      paramf.put(localJSONObject2);
      paramc = ah.aiuX;
      localJSONObject1.put("frameSets", paramf);
      Log.v("MicroMsg.SurfaceApp.SurfaceService", s.X("onBind ", localJSONObject1));
      paramf = ah.aiuX;
      localj.cJ("surface:frameSet:available", localJSONObject1.toString());
      AppMethodBeat.o(265279);
    }
    
    public final void b(com.tencent.mm.plugin.surface.c.f paramf)
    {
      AppMethodBeat.i(265294);
      s.u(paramf, "root");
      j localj = this.SKF;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", paramf.hBU());
      localJSONObject.put("frameSetRootId", paramf.getId());
      paramf = ah.aiuX;
      localj.cJ("surface:frameSetRoot:resume", localJSONObject.toString());
      AppMethodBeat.o(265294);
    }
    
    public final void bd(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(265287);
      com.tencent.mm.plugin.surface.c.j localj2 = j.b(this.SKF);
      com.tencent.mm.plugin.surface.c.j localj1 = localj2;
      if (localj2 == null)
      {
        s.bIx("renderService");
        localj1 = null;
      }
      localj1.be(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(265287);
    }
    
    public final void c(com.tencent.mm.plugin.surface.c.f paramf)
    {
      AppMethodBeat.i(265299);
      s.u(paramf, "root");
      j localj = this.SKF;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", paramf.hBU());
      localJSONObject.put("frameSetRootId", paramf.getId());
      paramf = ah.aiuX;
      localj.cJ("surface:frameSetRoot:pause", localJSONObject.toString());
      AppMethodBeat.o(265299);
    }
    
    public final void d(com.tencent.mm.plugin.surface.c.f paramf)
    {
      AppMethodBeat.i(265305);
      s.u(paramf, "root");
      j localj = this.SKF;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", paramf.hBU());
      localJSONObject.put("frameSetRootId", paramf.getId());
      paramf = ah.aiuX;
      localj.cJ("surface:frameSetRoot:destroyed", localJSONObject.toString());
      AppMethodBeat.o(265305);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.j
 * JD-Core Version:    0.7.0.1
 */