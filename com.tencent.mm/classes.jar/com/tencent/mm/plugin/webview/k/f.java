package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCache;", "", "()V", "TAG", "", "jsapiWebComptMap", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "addJSAPIWebCompt", "", "url", "webCompts", "getJSAPIWebComptList", "list", "Lorg/json/JSONArray;", "getUrlKey", "webview-sdk_release"})
public final class f
{
  private static Map<String, LinkedList<brr>> EOP;
  public static final f EOQ;
  
  static
  {
    AppMethodBeat.i(214256);
    EOQ = new f();
    EOP = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(214256);
  }
  
  private static String XC(String paramString)
  {
    AppMethodBeat.i(214255);
    if (!((b)g.ab(b.class)).isMpUrl(paramString))
    {
      AppMethodBeat.o(214255);
      return paramString;
    }
    paramString = ((b)g.ab(b.class)).XC(paramString);
    AppMethodBeat.o(214255);
    return paramString;
  }
  
  public static LinkedList<brr> c(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(214254);
    p.h(paramString, "url");
    p.h(paramJSONArray, "list");
    Object localObject = XC(paramString);
    paramString = new LinkedList();
    localObject = (LinkedList)EOP.get(localObject);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      label131:
      while (((Iterator)localObject).hasNext())
      {
        brr localbrr = (brr)((Iterator)localObject).next();
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label131;
          }
          if (bu.lX((String)paramJSONArray.get(i), localbrr.name))
          {
            paramString.add(localbrr);
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(214254);
    return paramString;
  }
  
  public static final void g(String paramString, LinkedList<brr> paramLinkedList)
  {
    AppMethodBeat.i(214253);
    p.h(paramString, "url");
    if (paramLinkedList != null)
    {
      paramString = XC(paramString);
      ae.i("MicroMsg.WebComptCache", "addJSAPIWebCompt " + paramLinkedList.size());
      if (paramString != null) {
        EOP.put(paramString, paramLinkedList);
      }
      AppMethodBeat.o(214253);
      return;
    }
    AppMethodBeat.o(214253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.f
 * JD-Core Version:    0.7.0.1
 */