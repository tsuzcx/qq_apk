package com.tencent.mm.plugin.webview.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "support", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g
{
  public static final a WDw = a.WDx;
  
  public abstract boolean a(h paramh, p paramp);
  
  public abstract boolean b(h paramh, p paramp);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool$Companion;", "", "()V", "toMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lkotlin/collections/HashMap;", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(295184);
      WDx = new a();
      AppMethodBeat.o(295184);
    }
    
    public static HashMap<String, a> mg(List<? extends a> paramList)
    {
      AppMethodBeat.i(295177);
      s.u(paramList, "<this>");
      HashMap localHashMap = new HashMap();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        ((Map)localHashMap).put(locala.gPX(), locala);
      }
      AppMethodBeat.o(295177);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.g
 * JD-Core Version:    0.7.0.1
 */