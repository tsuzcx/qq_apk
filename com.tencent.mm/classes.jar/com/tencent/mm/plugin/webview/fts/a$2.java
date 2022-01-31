package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.rt.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class a$2
  extends c<rt>
{
  a$2(a parama)
  {
    AppMethodBeat.i(5664);
    this.__eventId = rt.class.getName().hashCode();
    AppMethodBeat.o(5664);
  }
  
  private boolean a(rt paramrt)
  {
    AppMethodBeat.i(5665);
    if (((paramrt instanceof rt)) && (paramrt.cIb.coO == 2))
    {
      ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Download callback %s", new Object[] { paramrt.cIb.cBO });
      if (!this.uOw.uOq.containsKey(paramrt.cIb.cBO)) {}
    }
    for (;;)
    {
      int i;
      JSONArray localJSONArray;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (this.uOw.uOq)
      {
        i = ((Integer)this.uOw.uOt.get(paramrt.cIb.cBO)).intValue();
        Object localObject = (HashSet)this.uOw.uOq.get(paramrt.cIb.cBO);
        localJSONArray = new JSONArray();
        localObject = ((HashSet)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          str2 = "weixin://fts/sns?path=" + paramrt.cIb.path;
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label212:
        localJSONArray.put(localJSONObject);
        continue;
        paramrt = finally;
        AppMethodBeat.o(5665);
        throw paramrt;
        h.KW(i).bG(0, localJSONArray.toString());
        this.uOw.uOq.remove(paramrt.cIb.cBO);
        this.uOw.uOt.remove(paramrt.cIb.cBO);
        AppMethodBeat.o(5665);
        return false;
      }
      catch (JSONException localJSONException)
      {
        break label212;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.2
 * JD-Core Version:    0.7.0.1
 */