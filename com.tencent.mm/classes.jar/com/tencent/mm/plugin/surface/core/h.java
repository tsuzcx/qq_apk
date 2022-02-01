package com.tencent.mm.plugin.surface.core;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.n.i;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.v;

@Metadata(d1={""}, d2={"jsThreadHandler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "getJsThreadHandler", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "access", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "path", "", "addon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "inject", "", "selector", "Lcom/tencent/mm/plugin/surface/core/MultiWxaPkgSelector$Selector;", "cb", "Landroid/webkit/ValueCallback;", "injectAssetFile", "toPool", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "", "use", "R", "Lcom/eclipsesource/mmv8/V8Value;", "block", "Lkotlin/Function1;", "(Lcom/eclipsesource/mmv8/V8Value;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "plugin-surface-app_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final <T extends com.tencent.mm.plugin.appbrand.jsapi.p> Map<String, T> C(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(265207);
    s.u(paramCollection, "<this>");
    Object localObject = (Iterable)paramCollection;
    paramCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.appbrand.jsapi.p localp = (com.tencent.mm.plugin.appbrand.jsapi.p)((Iterator)localObject).next();
      paramCollection.add(v.Y(localp.getName(), localp));
    }
    paramCollection = ak.dw(ak.F((Iterable)paramCollection));
    AppMethodBeat.o(265207);
    return paramCollection;
  }
  
  public static final void a(i parami, d.b paramb, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(265198);
    s.u(parami, "<this>");
    s.u(paramb, "selector");
    parami.a(new URI("file://" + paramb.appId + '/' + paramb.path).toURL(), com.tencent.mm.plugin.appbrand.appcache.r.a(paramb.SKf, paramb.path), paramValueCallback);
    AppMethodBeat.o(265198);
  }
  
  public static final void a(i parami, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(265190);
    s.u(parami, "<this>");
    s.u(paramString, "path");
    parami.a(new URI(s.X("file://android_asset/", paramString)).toURL(), d.ags(paramString), paramValueCallback);
    AppMethodBeat.o(265190);
  }
  
  public static final com.tencent.mm.plugin.appbrand.appstorage.r c(q paramq, String paramString)
  {
    AppMethodBeat.i(265184);
    s.u(paramq, "<this>");
    s.u(paramString, "path");
    if (paramq.openReadPartialInfo(paramString) != null)
    {
      paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qML;
      AppMethodBeat.o(265184);
      return paramq;
    }
    paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qMR;
    AppMethodBeat.o(265184);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.h
 * JD-Core Version:    0.7.0.1
 */