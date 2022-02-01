package com.tencent.mm.plugin.surface.b.a;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApi;", "T", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApiContext;", "", "name", "", "context", "(Ljava/lang/String;Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApiContext;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApiContext;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApiContext;", "getName", "attach", "", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class h<T extends i>
{
  private final T SLg;
  private final String TAG;
  private final String name;
  
  public h(String paramString, T paramT)
  {
    this.name = paramString;
    this.SLg = paramT;
    this.TAG = ("MicroMsg.SurfaceApp." + getClass().getSimpleName() + ':' + this.SLg.getClass().getSimpleName());
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  protected final T hBQ()
  {
    return this.SLg;
  }
  
  public void l(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    s.u(parami, "jsRuntime");
    parami.addJavascriptInterface(this, this.name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.a.h
 * JD-Core Version:    0.7.0.1
 */