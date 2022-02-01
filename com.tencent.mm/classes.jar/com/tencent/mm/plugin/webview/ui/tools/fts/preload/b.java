package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.jx;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadLogic;", "", "()V", "CONTINUE_SET_RESULT", "", "SET_RESULT_HANDLER", "preloadObjMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "getPreloadObjMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getPreloadWebView", "biz", "preloadWebView", "", "url", "reset", "", "plugin-webview_release"})
public final class b
{
  private static final ConcurrentHashMap<Integer, d> QmV;
  public static final b QmW;
  
  static
  {
    AppMethodBeat.i(268129);
    QmW = new b();
    QmV = new ConcurrentHashMap();
    AppMethodBeat.o(268129);
  }
  
  public static d aoO(int paramInt)
  {
    AppMethodBeat.i(268128);
    d locald = (d)QmV.get(Integer.valueOf(paramInt));
    if (locald != null)
    {
      if (locald.QmX.get()) {}
      while (locald != null)
      {
        QmV.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(268128);
        return locald;
        locald = null;
      }
    }
    AppMethodBeat.o(268128);
    return null;
  }
  
  public static void l(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(268126);
    p.k(paramString, "url");
    if (paramBoolean) {
      QmV.remove(Integer.valueOf(paramInt));
    }
    paramString = new e(paramInt, paramString);
    if (QmV.containsKey(Integer.valueOf(paramString.ppO)))
    {
      Log.i(c.getTAG(), "already exist preload obj biz:" + paramString.ppO + " url:" + paramString.url);
      AppMethodBeat.o(268126);
      return;
    }
    Log.i(c.getTAG(), "start to preload obj biz:" + paramString.ppO + " url:" + paramString.url);
    paramString.QmY = cm.bfE();
    Object localObject = new d(paramString.ppO, paramString.url);
    ((Map)QmV).put(Integer.valueOf(((d)localObject).ppO), localObject);
    paramString.QmZ = ((d)localObject);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e.f(paramString));
    localObject = new jx();
    ((jx)localObject).uy(paramString.ppO);
    ((jx)localObject).uz(1L);
    ((jx)localObject).bpa();
    ar.a((com.tencent.mm.plugin.report.a)localObject);
    AppMethodBeat.o(268126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.b
 * JD-Core Version:    0.7.0.1
 */