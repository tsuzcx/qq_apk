package com.tencent.mm.plugin.surface.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.surface.d.a;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/SurfaceConfig;", "", "jsApis", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "reporter", "Lcom/tencent/mm/plugin/surface/reporter/SurfaceReporter;", "(Ljava/util/Collection;Lcom/tencent/mm/plugin/surface/reporter/SurfaceReporter;)V", "jsApiPool", "", "", "kotlin.jvm.PlatformType", "getJsApiPool$plugin_surface_app_release", "()Ljava/util/Map;", "getJsApis", "()Ljava/util/Collection;", "getReporter", "()Lcom/tencent/mm/plugin/surface/reporter/SurfaceReporter;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private final Collection<p> SKw;
  private final a SKx;
  final Map<String, p> SKy;
  
  public g(Collection<? extends p> paramCollection, a parama)
  {
    AppMethodBeat.i(265197);
    this.SKw = paramCollection;
    this.SKx = parama;
    this.SKy = h.C(this.SKw);
    AppMethodBeat.o(265197);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(265216);
    if (this == paramObject)
    {
      AppMethodBeat.o(265216);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(265216);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.SKw, paramObject.SKw))
    {
      AppMethodBeat.o(265216);
      return false;
    }
    if (!s.p(this.SKx, paramObject.SKx))
    {
      AppMethodBeat.o(265216);
      return false;
    }
    AppMethodBeat.o(265216);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(265209);
    int i = this.SKw.hashCode();
    int j = this.SKx.hashCode();
    AppMethodBeat.o(265209);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(265203);
    String str = "SurfaceConfig(jsApis=" + this.SKw + ", reporter=" + this.SKx + ')';
    AppMethodBeat.o(265203);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.g
 * JD-Core Version:    0.7.0.1
 */