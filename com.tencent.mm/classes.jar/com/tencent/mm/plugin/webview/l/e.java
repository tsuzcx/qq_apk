package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCache;", "", "()V", "TAG", "", "jsapiWebComptMap", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "addJSAPIWebCompt", "", "url", "webCompts", "getJSAPIWebComptList", "list", "Lorg/json/JSONArray;", "getUrlKey", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e Xwo;
  private static Map<String, LinkedList<ddx>> Xwp;
  
  static
  {
    AppMethodBeat.i(295440);
    Xwo = new e();
    Xwp = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(295440);
  }
  
  private static String aiC(String paramString)
  {
    AppMethodBeat.i(295436);
    if (!((c)h.ax(c.class)).isMpUrl(paramString))
    {
      AppMethodBeat.o(295436);
      return paramString;
    }
    paramString = ((c)h.ax(c.class)).aiC(paramString);
    AppMethodBeat.o(295436);
    return paramString;
  }
  
  public static LinkedList<ddx> c(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(295430);
    s.u(paramString, "url");
    s.u(paramJSONArray, "list");
    Object localObject = aiC(paramString);
    paramString = new LinkedList();
    localObject = (LinkedList)Xwp.get(localObject);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ddx localddx = (ddx)((Iterator)localObject).next();
        int i = 0;
        int k = paramJSONArray.length();
        if (k > 0) {
          for (;;)
          {
            int j = i + 1;
            if (Util.isEqual((String)paramJSONArray.get(i), localddx.name))
            {
              paramString.add(localddx);
              break;
            }
            if (j >= k) {
              break;
            }
            i = j;
          }
        }
      }
    }
    AppMethodBeat.o(295430);
    return paramString;
  }
  
  public static final void h(String paramString, LinkedList<ddx> paramLinkedList)
  {
    AppMethodBeat.i(295417);
    s.u(paramString, "url");
    if (paramLinkedList != null)
    {
      paramString = aiC(paramString);
      Log.i("MicroMsg.WebComptCache", s.X("addJSAPIWebCompt ", Integer.valueOf(paramLinkedList.size())));
      if (paramString != null) {
        Xwp.put(paramString, paramLinkedList);
      }
    }
    AppMethodBeat.o(295417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.e
 * JD-Core Version:    0.7.0.1
 */