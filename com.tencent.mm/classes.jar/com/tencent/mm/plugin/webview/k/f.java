package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCache;", "", "()V", "TAG", "", "jsapiWebComptMap", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "addJSAPIWebCompt", "", "url", "webCompts", "getJSAPIWebComptList", "list", "Lorg/json/JSONArray;", "getUrlKey", "webview-sdk_release"})
public final class f
{
  private static Map<String, LinkedList<biv>> BAk;
  public static final f BAl;
  
  static
  {
    AppMethodBeat.i(189488);
    BAl = new f();
    BAk = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(189488);
  }
  
  private static String Pa(String paramString)
  {
    AppMethodBeat.i(189487);
    if (!((b)g.ab(b.class)).isMpUrl(paramString))
    {
      AppMethodBeat.o(189487);
      return paramString;
    }
    paramString = ((b)g.ab(b.class)).Pa(paramString);
    AppMethodBeat.o(189487);
    return paramString;
  }
  
  public static LinkedList<biv> c(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(189486);
    k.h(paramString, "url");
    k.h(paramJSONArray, "list");
    Object localObject = Pa(paramString);
    paramString = new LinkedList();
    localObject = (LinkedList)BAk.get(localObject);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      label131:
      while (((Iterator)localObject).hasNext())
      {
        biv localbiv = (biv)((Iterator)localObject).next();
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label131;
          }
          if (bt.kU((String)paramJSONArray.get(i), localbiv.name))
          {
            paramString.add(localbiv);
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(189486);
    return paramString;
  }
  
  public static final void h(String paramString, LinkedList<biv> paramLinkedList)
  {
    AppMethodBeat.i(189485);
    k.h(paramString, "url");
    if (paramLinkedList != null)
    {
      paramString = Pa(paramString);
      ad.i("MicroMsg.WebComptCache", "addJSAPIWebCompt " + paramLinkedList.size());
      if (paramString != null) {
        BAk.put(paramString, paramLinkedList);
      }
      AppMethodBeat.o(189485);
      return;
    }
    AppMethodBeat.o(189485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.f
 * JD-Core Version:    0.7.0.1
 */