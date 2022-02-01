package com.tencent.mm.plugin.surface.c;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.magicbrush.e.b;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.file.ai;
import com.tencent.mm.plugin.appbrand.jsapi.file.aj;
import com.tencent.mm.plugin.surface.b.a.b;
import com.tencent.mm.plugin.surface.core.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/render/RenderService;", "Lcom/tencent/mm/plugin/surface/core/MultiContextService;", "service", "bootstrap", "", "listener", "Lcom/tencent/mm/plugin/surface/render/RenderListener;", "(Lcom/tencent/mm/plugin/surface/core/MultiContextService;Ljava/lang/String;Lcom/tencent/mm/plugin/surface/render/RenderListener;)V", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "serviceName", "getServiceName", "()Ljava/lang/String;", "create", "", "path", "createJsApiPool", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "getFileSystem", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystem;", "injectCommonLib", "", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "injectCommonLib$plugin_surface_app_release", "injectEnv", "injectEnv$plugin_surface_app_release", "notifyDestroy", "notifyForeground", "onJsRuntimeCreated", "onJsRuntimeInit", "onRedraw", "canvasId", "width", "height", "onRedraw$plugin_surface_app_release", "postMsgToWorker", "id", "message", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.plugin.surface.core.c
{
  public static final a SLv;
  private final com.tencent.mm.plugin.surface.core.c SJP;
  private com.tencent.magicbrush.e SKU;
  private final String SLw;
  private final i SLx;
  private final String serviceName;
  
  static
  {
    AppMethodBeat.i(265081);
    SLv = new a((byte)0);
    AppMethodBeat.o(265081);
  }
  
  public j(com.tencent.mm.plugin.surface.core.c paramc, String paramString, i parami)
  {
    AppMethodBeat.i(265054);
    this.SJP = paramc;
    this.SLw = paramString;
    this.SLx = parami;
    this.serviceName = "SurfaceRenderService";
    AppMethodBeat.o(265054);
  }
  
  private static final void bdc(String paramString)
  {
    AppMethodBeat.i(265061);
    Log.i("MicroMsg.SurfaceApp.RenderService", s.X("eval basic done: ", paramString));
    AppMethodBeat.o(265061);
  }
  
  private static final void bdd(String paramString)
  {
    AppMethodBeat.i(265066);
    Log.v("MicroMsg.SurfaceApp.RenderService", s.X("commonLib magicbrush injected: ", paramString));
    AppMethodBeat.o(265066);
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> arA()
  {
    AppMethodBeat.i(265106);
    Map localMap = com.tencent.mm.plugin.surface.core.h.C((Collection)kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.p[] { (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.a(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.aa.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.c.i(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.c(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.e(), (com.tencent.mm.plugin.appbrand.jsapi.p)new aj(), (com.tencent.mm.plugin.appbrand.jsapi.p)new ai() }));
    AppMethodBeat.o(265106);
    return localMap;
  }
  
  public final void be(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(265150);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("canvasId", paramInt1);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("width", h.e((Number)Integer.valueOf(paramInt2)));
    ((JSONObject)localObject).put("height", h.e((Number)Integer.valueOf(paramInt3)));
    ah localah = ah.aiuX;
    localJSONObject.put("viewport", localObject);
    localObject = ah.aiuX;
    cJ("surface:canvas:redraw", localJSONObject.toString());
    AppMethodBeat.o(265150);
  }
  
  public final int create(String paramString)
  {
    AppMethodBeat.i(265114);
    s.u(paramString, "path");
    Log.e("MicroMsg.SurfaceApp.RenderService", "can not create");
    AppMethodBeat.o(265114);
    return -1;
  }
  
  public final w getFileSystem()
  {
    AppMethodBeat.i(265135);
    w localw = this.SJP.getFileSystem();
    AppMethodBeat.o(265135);
    return localw;
  }
  
  public final String getServiceName()
  {
    return this.serviceName;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(265123);
    s.u(parami, "jsRuntime");
    Log.i("MicroMsg.SurfaceApp.RenderService", "onJsRuntimeCreated");
    Object localObject1 = l.SLC;
    localObject1 = l.c(this);
    ((com.tencent.magicbrush.e)localObject1).eHC.add(new b(this));
    Object localObject2 = e.SLi;
    e.a((k)new c((com.tencent.magicbrush.e)localObject1));
    localObject2 = e.SLi;
    if (!e.hBS())
    {
      Log.i("MicroMsg.SurfaceApp.RenderService", "frameSet not empty notify foreground");
      ((com.tencent.magicbrush.e)localObject1).avl();
    }
    localObject2 = ah.aiuX;
    this.SKU = ((com.tencent.magicbrush.e)localObject1);
    localObject1 = this.SKU;
    if (localObject1 == null)
    {
      s.bIx("magicBrush");
      localObject1 = null;
    }
    for (;;)
    {
      new com.tencent.mm.plugin.surface.b.a.a((b)new d(this, (com.tencent.magicbrush.e)localObject1)).l(parami);
      AppMethodBeat.o(265123);
      return;
    }
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(265129);
    s.u(parami, "jsRuntime");
    d.b localb = this.SJP.SJU.bcP(this.SLw);
    if (localb == null) {}
    for (parami = null;; parami = ah.aiuX)
    {
      if (parami == null) {
        Log.e("MicroMsg.SurfaceApp.RenderService", "bootstrap:" + this.SLw + " not found");
      }
      AppMethodBeat.o(265129);
      return;
      com.tencent.mm.plugin.surface.core.h.a(parami, localb, j..ExternalSyntheticLambda0.INSTANCE);
    }
  }
  
  public final void j(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(265138);
    s.u(parami, "jsRuntime");
    super.j(parami);
    com.tencent.mm.plugin.surface.core.h.a(parami, "wxa_library/lazy_load.js", null);
    AppMethodBeat.o(265138);
  }
  
  public final void k(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(265142);
    s.u(parami, "jsRuntime");
    super.k(parami);
    com.tencent.mm.plugin.surface.core.h.a(parami, "jsapi/surface/lib/magicbrush_extension.js", j..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(265142);
  }
  
  public final void postMsgToWorker(int paramInt, String paramString)
  {
    AppMethodBeat.i(265112);
    s.u(paramString, "message");
    this.SJP.bcM(paramString);
    AppMethodBeat.o(265112);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/render/RenderService$Companion;", "", "()V", "TAG", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/render/RenderService$onJsRuntimeCreated$1$1", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "onFirstFrame", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements e.b
  {
    b(j paramj) {}
    
    public final void onFirstFrame()
    {
      AppMethodBeat.i(265020);
      j.b(this.SLy);
      AppMethodBeat.o(265020);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/render/RenderService$onJsRuntimeCreated$1$2", "Lcom/tencent/mm/plugin/surface/render/RenderStatusListener;", "onBackground", "", "onForeground", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements k
  {
    c(com.tencent.magicbrush.e parame) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(265021);
      Log.i("MicroMsg.SurfaceApp.RenderService", "magicBrush notifyBackground");
      this.SLz.avm();
      AppMethodBeat.o(265021);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(265015);
      Log.i("MicroMsg.SurfaceApp.RenderService", "magicBrush notifyForeground");
      this.SLz.avl();
      AppMethodBeat.o(265015);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/render/RenderService$onJsRuntimeCreated$2", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceCanvasJsApiContext;", "createCanvas", "", "frameSetId", "", "getFrameSet", "Lcom/tencent/mm/plugin/surface/render/FrameSet;", "getFrameSet$plugin_surface_app_release", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends b
  {
    d(j paramj, com.tencent.magicbrush.e parame)
    {
      super();
    }
    
    public final c bcZ(String paramString)
    {
      AppMethodBeat.i(265028);
      s.u(paramString, "frameSetId");
      e locale = e.SLi;
      paramString = e.bda(paramString);
      AppMethodBeat.o(265028);
      return paramString;
    }
    
    public final int createCanvas(String paramString)
    {
      AppMethodBeat.i(265042);
      s.u(paramString, "frameSetId");
      Object localObject = bcZ(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(265042);
        return -1;
      }
      final j localj = this.SLy;
      ViewGroup localViewGroup = ((c)localObject).mJe;
      localObject = localViewGroup.getContext();
      s.s(localObject, "root.context");
      final MagicBrushView localMagicBrushView = new MagicBrushView((Context)localObject, MagicBrushView.h.eKZ);
      com.tencent.magicbrush.e locale = j.a(localj);
      localObject = locale;
      if (locale == null)
      {
        s.bIx("magicBrush");
        localObject = null;
      }
      localMagicBrushView.setMagicBrush((com.tencent.magicbrush.e)localObject);
      Log.i("MicroMsg.SurfaceApp.RenderService", "createCanvasView#" + paramString + ' ' + localMagicBrushView.getVirtualElementId());
      localMagicBrushView.setOpaque(false);
      localMagicBrushView.setEnableTouchEvent(true);
      d.uiThread((kotlin.g.a.a)new a(localViewGroup, localMagicBrushView));
      localMagicBrushView.a((MagicBrushView.c)new b(paramString, localMagicBrushView, localj));
      int i = localMagicBrushView.getVirtualElementId();
      AppMethodBeat.o(265042);
      return i;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ViewGroup paramViewGroup, MagicBrushView paramMagicBrushView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/render/RenderService$onJsRuntimeCreated$2$createCanvas$1$1$2", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "onSurfaceAvailable", "", "surface", "", "width", "", "height", "canReadPixelsFromJava", "", "onSurfaceDestroyed", "syncDestroy", "onSurfaceSizeChanged", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements MagicBrushView.c
    {
      b(String paramString, MagicBrushView paramMagicBrushView, j paramj) {}
      
      public final void a(Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
      {
        AppMethodBeat.i(265016);
        s.u(paramObject, "surface");
        Log.i("MicroMsg.SurfaceApp.RenderService", "onSurfaceAvailable#" + this.SLB + ' ' + localMagicBrushView.getVirtualElementId());
        s.t(paramObject, "surface");
        localj.be(localMagicBrushView.getVirtualElementId(), paramInt1, paramInt2);
        AppMethodBeat.o(265016);
      }
      
      public final void c(Object paramObject, boolean paramBoolean)
      {
        AppMethodBeat.i(265023);
        s.u(paramObject, "surface");
        Log.i("MicroMsg.SurfaceApp.RenderService", "onSurfaceDestroyed#" + this.SLB + ' ' + localMagicBrushView.getVirtualElementId());
        AppMethodBeat.o(265023);
      }
      
      public final void e(Object paramObject, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(265027);
        s.u(paramObject, "surface");
        Log.i("MicroMsg.SurfaceApp.RenderService", "onSurfaceSizeChanged#" + this.SLB + ' ' + localMagicBrushView.getVirtualElementId() + " [" + paramInt1 + ", " + paramInt2 + ']');
        AppMethodBeat.o(265027);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.c.j
 * JD-Core Version:    0.7.0.1
 */