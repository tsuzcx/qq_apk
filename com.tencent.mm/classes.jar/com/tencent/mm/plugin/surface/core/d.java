package com.tencent.mm.plugin.surface.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/MultiWxaPkgSelector;", "", "()V", "getWxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "appId", "", "select", "Lcom/tencent/mm/plugin/surface/core/MultiWxaPkgSelector$Selector;", "url", "select$plugin_surface_app_release", "Companion", "Selector", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
{
  public static final a SKe = new a((byte)0);
  
  public abstract q bcO(String paramString);
  
  public final b bcP(String paramString)
  {
    s.u(paramString, "url");
    String str = n.bX(paramString, "://", "wx");
    q localq = bcO(str);
    if (localq == null)
    {
      Log.e("MicroMsg.SurfaceApp.MultiWxaPkgSelector", "pkg#" + str + " not found");
      return null;
    }
    paramString = n.rv(paramString, s.X(str, "://"));
    if (h.c(localq, paramString) != r.qML)
    {
      Log.e("MicroMsg.SurfaceApp.MultiWxaPkgSelector", "pkg#" + str + " path:" + paramString + " not found");
      return null;
    }
    return new b(str, paramString, localq);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/MultiWxaPkgSelector$Companion;", "", "()V", "TAG", "", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/MultiWxaPkgSelector$Selector;", "", "appId", "", "path", "pkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)V", "getAppId", "()Ljava/lang/String;", "getPath", "getPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final q SKf;
    final String appId;
    final String path;
    
    public b(String paramString1, String paramString2, q paramq)
    {
      AppMethodBeat.i(265276);
      this.appId = paramString1;
      this.path = paramString2;
      this.SKf = paramq;
      AppMethodBeat.o(265276);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(265297);
      if (this == paramObject)
      {
        AppMethodBeat.o(265297);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(265297);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(265297);
        return false;
      }
      if (!s.p(this.path, paramObject.path))
      {
        AppMethodBeat.o(265297);
        return false;
      }
      if (!s.p(this.SKf, paramObject.SKf))
      {
        AppMethodBeat.o(265297);
        return false;
      }
      AppMethodBeat.o(265297);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(265289);
      int i = this.appId.hashCode();
      int j = this.path.hashCode();
      int k = this.SKf.hashCode();
      AppMethodBeat.o(265289);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(265283);
      String str = "Selector(appId=" + this.appId + ", path=" + this.path + ", pkg=" + this.SKf + ')';
      AppMethodBeat.o(265283);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.d
 * JD-Core Version:    0.7.0.1
 */