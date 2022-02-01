package com.tencent.mm.plugin.surface.core;

import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8ScriptException;
import com.eclipsesource.mmv8.V8Value;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.x;
import com.tencent.mm.plugin.surface.b.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/WorkerJsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "config", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "worker", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceWorkerJsApiContext;", "(Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceWorkerJsApiContext;)V", "global", "Lcom/eclipsesource/mmv8/V8Object;", "getGlobal", "()Lcom/eclipsesource/mmv8/V8Object;", "v8", "Lcom/eclipsesource/mmv8/V8Context;", "getV8", "()Lcom/eclipsesource/mmv8/V8Context;", "onMessage", "", "message", "", "v8ArrayOf", "Lcom/eclipsesource/mmv8/V8Array;", "args", "", "", "([Ljava/lang/Object;)Lcom/eclipsesource/mmv8/V8Array;", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class k
  extends x
{
  public static final a SKG = new a((byte)0);
  
  public k(IJSRuntime.Config paramConfig, com.tencent.mm.plugin.surface.b.a.k paramk)
  {
    super(paramConfig);
    paramConfig = new j(paramk);
    paramk = czi();
    s.s(paramk, "mainJsContext");
    paramConfig.l((i)paramk);
  }
  
  private V8Array C(Object... paramVarArgs)
  {
    s.u(paramVarArgs, "args");
    V8Array localV8Array = hBO().newV8Array();
    int i = 0;
    while (i <= 0)
    {
      localV8Array.push(paramVarArgs[0]);
      i += 1;
    }
    s.s(localV8Array, "v8.newV8Array().apply { args.forEach(::push) }");
    return localV8Array;
  }
  
  private static final void a(k paramk, String paramString)
  {
    s.u(paramk, "this$0");
    s.u(paramString, "$message");
    if (paramk.hBO().getType("onmessage") != 7) {
      return;
    }
    try
    {
      localObject = paramk.hBO().get("onmessage");
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type com.eclipsesource.mmv8.V8Function");
      }
    }
    catch (V8ScriptException paramk)
    {
      Log.printErrStackTrace("MicroMsg.SurfaceApp.WorkerJsEngine", (Throwable)paramk, "hy: js exception in worker!", new Object[0]);
      return;
    }
    Object localObject = (V8Value)localObject;
    V8Function localV8Function = (V8Function)localObject;
    paramString = (V8Value)paramk.C(new Object[] { paramString });
    V8Array localV8Array = (V8Array)paramString;
    paramk = paramk.czf().getGlobalObject();
    s.s(paramk, "v8Context.globalObject");
    localV8Function.call(paramk, localV8Array);
    paramString.release();
    ((V8Value)localObject).release();
  }
  
  private V8Context hBO()
  {
    V8Context localV8Context = czf().aEm();
    s.s(localV8Context, "v8Context.v8Context");
    return localV8Context;
  }
  
  public final void Yk(String paramString)
  {
    s.u(paramString, "message");
    post(new k..ExternalSyntheticLambda0(this, paramString));
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/WorkerJsEngine$Companion;", "", "()V", "TAG", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.k
 * JD-Core Version:    0.7.0.1
 */