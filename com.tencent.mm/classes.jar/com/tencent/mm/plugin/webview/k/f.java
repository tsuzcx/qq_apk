package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCache;", "", "()V", "TAG", "", "jsapiWebComptMap", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "addJSAPIWebCompt", "", "url", "webCompts", "getJSAPIWebComptList", "list", "Lorg/json/JSONArray;", "getUrlKey", "webview-sdk_release"})
public final class f
{
  private static Map<String, LinkedList<bmn>> CSr;
  public static final f CSs;
  
  static
  {
    AppMethodBeat.i(205621);
    CSs = new f();
    CSr = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(205621);
  }
  
  private static String Tk(String paramString)
  {
    AppMethodBeat.i(205620);
    if (!((b)g.ab(b.class)).isMpUrl(paramString))
    {
      AppMethodBeat.o(205620);
      return paramString;
    }
    paramString = ((b)g.ab(b.class)).Tk(paramString);
    AppMethodBeat.o(205620);
    return paramString;
  }
  
  public static LinkedList<bmn> c(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(205619);
    k.h(paramString, "url");
    k.h(paramJSONArray, "list");
    Object localObject = Tk(paramString);
    paramString = new LinkedList();
    localObject = (LinkedList)CSr.get(localObject);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      label131:
      while (((Iterator)localObject).hasNext())
      {
        bmn localbmn = (bmn)((Iterator)localObject).next();
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label131;
          }
          if (bs.lr((String)paramJSONArray.get(i), localbmn.name))
          {
            paramString.add(localbmn);
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(205619);
    return paramString;
  }
  
  public static final void h(String paramString, LinkedList<bmn> paramLinkedList)
  {
    AppMethodBeat.i(205618);
    k.h(paramString, "url");
    if (paramLinkedList != null)
    {
      paramString = Tk(paramString);
      ac.i("MicroMsg.WebComptCache", "addJSAPIWebCompt " + paramLinkedList.size());
      if (paramString != null) {
        CSr.put(paramString, paramLinkedList);
      }
      AppMethodBeat.o(205618);
      return;
    }
    AppMethodBeat.o(205618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.f
 * JD-Core Version:    0.7.0.1
 */