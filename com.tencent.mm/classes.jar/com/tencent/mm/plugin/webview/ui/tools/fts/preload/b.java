package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hs;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadLogic;", "", "()V", "CONTINUE_SET_RESULT", "", "SET_RESULT_HANDLER", "preloadObjMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "getPreloadObjMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getPreloadWebView", "biz", "preloadWebView", "", "url", "reset", "", "plugin-webview_release"})
public final class b
{
  private static final ConcurrentHashMap<Integer, d> JpA;
  public static final b JpB;
  
  static
  {
    AppMethodBeat.i(210528);
    JpB = new b();
    JpA = new ConcurrentHashMap();
    AppMethodBeat.o(210528);
  }
  
  public static d agX(int paramInt)
  {
    AppMethodBeat.i(210527);
    d locald = (d)JpA.get(Integer.valueOf(paramInt));
    if (locald != null)
    {
      if (locald.JpC.get()) {}
      while (locald != null)
      {
        JpA.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(210527);
        return locald;
        locald = null;
      }
    }
    AppMethodBeat.o(210527);
    return null;
  }
  
  public static void k(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(210526);
    p.h(paramString, "url");
    if (paramBoolean) {
      JpA.remove(Integer.valueOf(paramInt));
    }
    paramString = new e(paramInt, paramString);
    if (JpA.containsKey(Integer.valueOf(paramString.mrG)))
    {
      Log.i(c.getTAG(), "already exist preload obj biz:" + paramString.mrG + " url:" + paramString.url);
      AppMethodBeat.o(210526);
      return;
    }
    Log.i(c.getTAG(), "start to preload obj biz:" + paramString.mrG + " url:" + paramString.url);
    paramString.JpD = cl.aWA();
    Object localObject = new d(paramString.mrG, paramString.url);
    ((Map)JpA).put(Integer.valueOf(((d)localObject).mrG), localObject);
    paramString.JpE = ((d)localObject);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new e.f(paramString));
    localObject = new hs();
    ((hs)localObject).qS(paramString.mrG);
    ((hs)localObject).qT(1L);
    ((hs)localObject).bfK();
    ar.a((com.tencent.mm.plugin.report.a)localObject);
    AppMethodBeat.o(210526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.b
 * JD-Core Version:    0.7.0.1
 */