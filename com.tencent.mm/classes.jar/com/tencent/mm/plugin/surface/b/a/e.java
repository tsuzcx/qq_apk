package com.tencent.mm.plugin.surface.b.a;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceMultiContextJsApi;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApi;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceMultiContextJsApiContext;", "Lcom/tencent/mm/plugin/appbrand/AppBrandWeixinJSContextInterface;", "context", "(Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceMultiContextJsApiContext;)V", "alloc", "", "allocEmpty", "attach", "", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "create", "scriptPath", "", "destroy", "contextId", "evaluateScript", "script", "evaluateScriptFile", "loadJsFilesWithOptions", "paths", "options", "loadLibFiles", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends h<f>
  implements ad
{
  public e(f paramf)
  {
    super("WeixinJSContext", (i)paramf);
    AppMethodBeat.i(265130);
    AppMethodBeat.o(265130);
  }
  
  @JavascriptInterface
  public final int alloc()
  {
    AppMethodBeat.i(265136);
    int i = ((f)hBQ()).alloc();
    AppMethodBeat.o(265136);
    return i;
  }
  
  @JavascriptInterface
  public final int allocEmpty()
  {
    AppMethodBeat.i(265139);
    int i = ((f)hBQ()).allocEmpty();
    AppMethodBeat.o(265139);
    return i;
  }
  
  @JavascriptInterface
  public final int create(String paramString)
  {
    AppMethodBeat.i(265151);
    s.u(paramString, "scriptPath");
    int i = ((f)hBQ()).create(paramString);
    AppMethodBeat.o(265151);
    return i;
  }
  
  @JavascriptInterface
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(265182);
    ((f)hBQ()).destroy(paramInt);
    AppMethodBeat.o(265182);
  }
  
  @JavascriptInterface
  public final int evaluateScript(int paramInt, String paramString)
  {
    AppMethodBeat.i(265159);
    s.u(paramString, "script");
    paramInt = ((f)hBQ()).evaluateScript(paramInt, paramString);
    AppMethodBeat.o(265159);
    return paramInt;
  }
  
  @JavascriptInterface
  public final int evaluateScriptFile(int paramInt, String paramString)
  {
    AppMethodBeat.i(265166);
    s.u(paramString, "scriptPath");
    paramInt = ((f)hBQ()).evaluateScriptFile(paramInt, paramString);
    AppMethodBeat.o(265166);
    return paramInt;
  }
  
  public final void l(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(265189);
    s.u(parami, "jsRuntime");
    super.l(parami);
    ((f)hBQ()).a(getName(), parami);
    AppMethodBeat.o(265189);
  }
  
  @JavascriptInterface
  public final void loadJsFilesWithOptions(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(265175);
    s.u(paramString1, "paths");
    s.u(paramString2, "options");
    ((f)hBQ()).loadJsFilesWithOptions(paramInt, paramString1, paramString2);
    AppMethodBeat.o(265175);
  }
  
  @JavascriptInterface
  public final void loadLibFiles(int paramInt, String paramString)
  {
    AppMethodBeat.i(265145);
    s.u(paramString, "paths");
    ((f)hBQ()).loadLibFiles(paramInt, paramString);
    AppMethodBeat.o(265145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.a.e
 * JD-Core Version:    0.7.0.1
 */