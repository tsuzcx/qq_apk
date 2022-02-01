package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCache;", "", "()V", "TAG", "", "jsapiWebComptMap", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "addJSAPIWebCompt", "", "url", "webCompts", "getJSAPIWebComptList", "list", "Lorg/json/JSONArray;", "getUrlKey", "webview-sdk_release"})
public final class f
{
  private static Map<String, LinkedList<cel>> JEF;
  public static final f JEG;
  
  static
  {
    AppMethodBeat.i(225215);
    JEG = new f();
    JEF = (Map)new ConcurrentHashMap();
    AppMethodBeat.o(225215);
  }
  
  private static String ahz(String paramString)
  {
    AppMethodBeat.i(225214);
    if (!((b)g.af(b.class)).isMpUrl(paramString))
    {
      AppMethodBeat.o(225214);
      return paramString;
    }
    paramString = ((b)g.af(b.class)).ahz(paramString);
    AppMethodBeat.o(225214);
    return paramString;
  }
  
  public static LinkedList<cel> c(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(225213);
    p.h(paramString, "url");
    p.h(paramJSONArray, "list");
    Object localObject = ahz(paramString);
    paramString = new LinkedList();
    localObject = (LinkedList)JEF.get(localObject);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      label131:
      while (((Iterator)localObject).hasNext())
      {
        cel localcel = (cel)((Iterator)localObject).next();
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label131;
          }
          if (Util.isEqual((String)paramJSONArray.get(i), localcel.name))
          {
            paramString.add(localcel);
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(225213);
    return paramString;
  }
  
  public static final void g(String paramString, LinkedList<cel> paramLinkedList)
  {
    AppMethodBeat.i(225212);
    p.h(paramString, "url");
    if (paramLinkedList != null)
    {
      paramString = ahz(paramString);
      Log.i("MicroMsg.WebComptCache", "addJSAPIWebCompt " + paramLinkedList.size());
      if (paramString != null) {
        JEF.put(paramString, paramLinkedList);
      }
      AppMethodBeat.o(225212);
      return;
    }
    AppMethodBeat.o(225212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.f
 * JD-Core Version:    0.7.0.1
 */