package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mo;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadLogic;", "", "()V", "CONTINUE_SET_RESULT", "", "SET_RESULT_HANDLER", "preloadObjMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "getPreloadObjMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getPreloadWebView", "biz", "preloadWebView", "", "url", "reset", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Xfl;
  private static final ConcurrentHashMap<Integer, d> Xfm;
  
  static
  {
    AppMethodBeat.i(296989);
    Xfl = new b();
    Xfm = new ConcurrentHashMap();
    AppMethodBeat.o(296989);
  }
  
  public static d auJ(int paramInt)
  {
    AppMethodBeat.i(296984);
    d locald = (d)Xfm.get(Integer.valueOf(paramInt));
    if (locald != null)
    {
      if (locald.Xfn.get()) {}
      while (locald != null)
      {
        Xfm.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(296984);
        return locald;
        locald = null;
      }
    }
    AppMethodBeat.o(296984);
    return null;
  }
  
  public static void m(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(296979);
    s.u(paramString, "url");
    if (paramBoolean) {
      Xfm.remove(Integer.valueOf(paramInt));
    }
    paramString = new e(paramInt, paramString);
    if (Xfm.containsKey(Integer.valueOf(paramString.biz)))
    {
      Log.i(c.getTAG(), "already exist preload obj biz:" + paramString.biz + " url:" + paramString.url);
      AppMethodBeat.o(296979);
      return;
    }
    Log.i(c.getTAG(), "start to preload obj biz:" + paramString.biz + " url:" + paramString.url);
    paramString.Xfo = cn.bDw();
    Object localObject = new d(paramString.biz, paramString.url);
    ((Map)Xfm).put(Integer.valueOf(((d)localObject).biz), localObject);
    ah localah = ah.aiuX;
    paramString.Xfp = ((d)localObject);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e.b(paramString));
    localObject = new mo();
    ((mo)localObject).jbO = paramString.biz;
    ((mo)localObject).ila = 1L;
    ((mo)localObject).bMH();
    as.a((com.tencent.mm.plugin.report.a)localObject);
    AppMethodBeat.o(296979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.b
 * JD-Core Version:    0.7.0.1
 */