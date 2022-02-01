package com.tencent.mm.plugin.surface.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/CommonBindingService;", "", "service", "Lcom/tencent/mm/plugin/surface/core/MultiContextService;", "(Lcom/tencent/mm/plugin/surface/core/MultiContextService;)V", "commonBinding", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandCommonBinding;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "provideCommonBindingParams", "Lcom/tencent/mm/appbrand/commonjni/AppBrandCommonBindingJniParams;", "getProvideCommonBindingParams", "()Lcom/tencent/mm/appbrand/commonjni/AppBrandCommonBindingJniParams;", "notifyDestroy", "", "notifyRuntimeReady", "appId", "", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a SJO;
  private final c SJP;
  final com.tencent.luggage.sdk.b.a.d.a SJQ;
  private final i ekj;
  
  static
  {
    AppMethodBeat.i(265206);
    SJO = new a.a((byte)0);
    AppMethodBeat.o(265206);
  }
  
  public a(c paramc)
  {
    AppMethodBeat.i(265171);
    this.SJP = paramc;
    paramc = this.SJP.getJsRuntime();
    s.s(paramc, "service.jsRuntime");
    this.ekj = paramc;
    this.SJQ = new com.tencent.luggage.sdk.b.a.d.a((com.tencent.mm.appbrand.commonjni.a.a.a)new b(this, this.SJP));
    AppMethodBeat.o(265171);
  }
  
  private static final void a(a parama)
  {
    Object localObject1 = null;
    AppMethodBeat.i(265183);
    s.u(parama, "this$0");
    Log.i("MicroMsg.SurfaceApp.CommonBindingService", "hy: base service js runtime post created run");
    Object localObject2 = (v)parama.ekj.Z(v.class);
    if (localObject2 == null)
    {
      parama = null;
      if (parama == null) {
        Log.e("MicroMsg.SurfaceApp.CommonBindingService", "hy: v8 not ready or released!");
      }
      AppMethodBeat.o(265183);
      return;
    }
    parama.SJQ.esf.notifyBindTo(((v)localObject2).getIsolatePtr(), ((v)localObject2).aEn(), ((v)localObject2).getUVLoopPtr());
    parama.SJQ.esg.bindTo(((v)localObject2).getIsolatePtr(), ((v)localObject2).aEn());
    localObject2 = (com.tencent.mm.plugin.appbrand.n.k)parama.ekj.Z(com.tencent.mm.plugin.appbrand.n.k.class);
    if (localObject2 == null) {}
    for (parama = localObject1;; parama = ah.aiuX)
    {
      if (parama == null) {
        Log.w("MicroMsg.SurfaceApp.CommonBindingService", "hy: buffer url addon not exist!");
      }
      parama = ah.aiuX;
      break;
      ((com.tencent.mm.plugin.appbrand.n.k)localObject2).a((com.tencent.mm.plugin.appbrand.n.y)new c(parama));
    }
  }
  
  public final void bcL(String paramString)
  {
    AppMethodBeat.i(265221);
    s.u(paramString, "appId");
    Object localObject = this.SJQ.esf;
    AppBrandCommonBindingJniParams localAppBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
    String str = b.bnp();
    com.tencent.mm.vfs.y.bDX(str);
    localAppBrandCommonBindingJniParams.wasmCachePath = com.tencent.mm.vfs.y.n(str, true);
    localAppBrandCommonBindingJniParams.wasmOptState = -2;
    ((AppBrandCommonBindingJni)localObject).notifyCreate(localAppBrandCommonBindingJniParams);
    localObject = (q)this.ekj.Z(q.class);
    if (localObject != null) {
      ((q)localObject).a(new a..ExternalSyntheticLambda0(this), false);
    }
    this.SJQ.esf.notifyRuntimeReady(paramString, com.tencent.mm.plugin.appbrand.appcache.r.a(this.SJP.SJU.SKq));
    AppMethodBeat.o(265221);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/core/CommonBindingService$commonBinding$1", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandCommonBinding$AbsAppBrandDelegate;", "doInnerLoopTask", "", "nativeInvokeHandler", "", "api", "data", "privateData", "callbackId", "", "isFromAsync", "readWeAppFile", "Ljava/nio/ByteBuffer;", "path", "resumeLoopTasks", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.luggage.sdk.b.a.d.a.a
  {
    b(a parama, c paramc)
    {
      super();
      AppMethodBeat.i(265238);
      AppMethodBeat.o(265238);
    }
    
    public final boolean doInnerLoopTask()
    {
      AppMethodBeat.i(265255);
      q localq = (q)a.c(this.SJR).Z(q.class);
      if (localq == null)
      {
        AppMethodBeat.o(265255);
        return false;
      }
      boolean bool = localq.doInnerLoopTask();
      AppMethodBeat.o(265255);
      return bool;
    }
    
    public final String nativeInvokeHandler(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(265264);
      s.u(paramString1, "api");
      s.u(paramString2, "data");
      s.u(paramString3, "privateData");
      paramString3 = super.nativeInvokeHandler(paramString1, paramString2, paramString3, paramInt, paramBoolean);
      if (!s.p(paramString1, "systemLog"))
      {
        paramString2 = new StringBuilder("jsapi ").append(paramString1).append('#').append(paramInt).append(' ').append(paramString2).append(' ');
        if (!paramBoolean) {
          break label125;
        }
      }
      label125:
      for (paramString1 = "async";; paramString1 = "sync")
      {
        Log.v("MicroMsg.SurfaceApp.CommonBindingService", paramString1 + " called. ret: " + paramString3);
        s.s(paramString3, "result");
        AppMethodBeat.o(265264);
        return paramString3;
      }
    }
    
    public final ByteBuffer readWeAppFile(String paramString)
    {
      AppMethodBeat.i(265271);
      s.u(paramString, "path");
      Log.i("MicroMsg.SurfaceApp.CommonBindingService", s.X("readWeAppFile:", paramString));
      com.tencent.mm.plugin.appbrand.af.k localk = new com.tencent.mm.plugin.appbrand.af.k();
      w localw = a.d(this.SJR).getFileSystem();
      if (localw == null) {}
      for (paramString = null; paramString == com.tencent.mm.plugin.appbrand.appstorage.r.qML; paramString = localw.b(paramString, localk))
      {
        paramString = ae.t((ByteBuffer)localk.value);
        AppMethodBeat.o(265271);
        return paramString;
      }
      AppMethodBeat.o(265271);
      return null;
    }
    
    public final void resumeLoopTasks()
    {
      AppMethodBeat.i(265246);
      q localq = (q)a.c(this.SJR).Z(q.class);
      if (localq != null) {
        localq.resumeLoopTasks();
      }
      AppMethodBeat.o(265246);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/core/CommonBindingService$notifyRuntimeReady$1$1$1$1", "Lcom/tencent/mm/plugin/appbrand/jsruntime/IBufferURLManager;", "createBufferURL", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "getBuffer", "url", "revokeBufferURL", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.appbrand.n.y
  {
    c(a parama) {}
    
    public final ByteBuffer fu(String paramString)
    {
      AppMethodBeat.i(265240);
      paramString = a.b(this.SJR).esg.fu(paramString);
      AppMethodBeat.o(265240);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.a
 * JD-Core Version:    0.7.0.1
 */