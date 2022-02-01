package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCache;", "", "()V", "TAG", "", "jsapiWebComptMap", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "addJSAPIWebCompt", "", "url", "webCompts", "getJSAPIWebComptList", "list", "Lorg/json/JSONArray;", "getUrlKey", "webview-sdk_release"})
public final class f
{
  private static Map<String, LinkedList<cnf>> QDu;
  public static final f QDv;
  
  static
  {
    AppMethodBeat.i(210484);
    QDv = new f();
    QDu = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(210484);
  }
  
  private static String apf(String paramString)
  {
    AppMethodBeat.i(210481);
    if (!((c)h.ae(c.class)).isMpUrl(paramString))
    {
      AppMethodBeat.o(210481);
      return paramString;
    }
    paramString = ((c)h.ae(c.class)).apf(paramString);
    AppMethodBeat.o(210481);
    return paramString;
  }
  
  public static LinkedList<cnf> c(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(210479);
    p.k(paramString, "url");
    p.k(paramJSONArray, "list");
    Object localObject = apf(paramString);
    paramString = new LinkedList();
    localObject = (LinkedList)QDu.get(localObject);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      label131:
      while (((Iterator)localObject).hasNext())
      {
        cnf localcnf = (cnf)((Iterator)localObject).next();
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label131;
          }
          if (Util.isEqual((String)paramJSONArray.get(i), localcnf.name))
          {
            paramString.add(localcnf);
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(210479);
    return paramString;
  }
  
  public static final void h(String paramString, LinkedList<cnf> paramLinkedList)
  {
    AppMethodBeat.i(210476);
    p.k(paramString, "url");
    if (paramLinkedList != null)
    {
      paramString = apf(paramString);
      Log.i("MicroMsg.WebComptCache", "addJSAPIWebCompt " + paramLinkedList.size());
      if (paramString != null) {
        QDu.put(paramString, paramLinkedList);
      }
      AppMethodBeat.o(210476);
      return;
    }
    AppMethodBeat.o(210476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.f
 * JD-Core Version:    0.7.0.1
 */