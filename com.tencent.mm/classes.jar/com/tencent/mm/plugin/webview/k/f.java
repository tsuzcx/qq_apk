package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCache;", "", "()V", "TAG", "", "jsapiWebComptMap", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "addJSAPIWebCompt", "", "url", "webCompts", "getJSAPIWebComptList", "list", "Lorg/json/JSONArray;", "getUrlKey", "webview-sdk_release"})
public final class f
{
  private static Map<String, LinkedList<bqx>> Ewt;
  public static final f Ewu;
  
  static
  {
    AppMethodBeat.i(214415);
    Ewu = new f();
    Ewt = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(214415);
  }
  
  private static String WQ(String paramString)
  {
    AppMethodBeat.i(214414);
    if (!((b)g.ab(b.class)).isMpUrl(paramString))
    {
      AppMethodBeat.o(214414);
      return paramString;
    }
    paramString = ((b)g.ab(b.class)).WQ(paramString);
    AppMethodBeat.o(214414);
    return paramString;
  }
  
  public static LinkedList<bqx> c(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(214413);
    p.h(paramString, "url");
    p.h(paramJSONArray, "list");
    Object localObject = WQ(paramString);
    paramString = new LinkedList();
    localObject = (LinkedList)Ewt.get(localObject);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      label131:
      while (((Iterator)localObject).hasNext())
      {
        bqx localbqx = (bqx)((Iterator)localObject).next();
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label131;
          }
          if (bt.lQ((String)paramJSONArray.get(i), localbqx.name))
          {
            paramString.add(localbqx);
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(214413);
    return paramString;
  }
  
  public static final void g(String paramString, LinkedList<bqx> paramLinkedList)
  {
    AppMethodBeat.i(214412);
    p.h(paramString, "url");
    if (paramLinkedList != null)
    {
      paramString = WQ(paramString);
      ad.i("MicroMsg.WebComptCache", "addJSAPIWebCompt " + paramLinkedList.size());
      if (paramString != null) {
        Ewt.put(paramString, paramLinkedList);
      }
      AppMethodBeat.o(214412);
      return;
    }
    AppMethodBeat.o(214412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.f
 * JD-Core Version:    0.7.0.1
 */