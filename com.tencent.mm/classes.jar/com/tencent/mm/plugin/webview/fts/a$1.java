package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.a.gc.a;
import com.tencent.mm.g.a.gc.b;
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

final class a$1
  extends c<gc>
{
  a$1(a parama)
  {
    AppMethodBeat.i(5661);
    this.__eventId = gc.class.getName().hashCode();
    AppMethodBeat.o(5661);
  }
  
  private boolean a(gc paramgc)
  {
    AppMethodBeat.i(5662);
    if (paramgc.cuC.coO == 2)
    {
      ab.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[] { paramgc.cuC.cqq });
      if (!this.uOw.uOr.containsKey(paramgc.cuC.cqq)) {}
    }
    for (;;)
    {
      int i;
      JSONArray localJSONArray;
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (this.uOw.uOr)
      {
        i = ((Integer)this.uOw.uOu.get(paramgc.cuC.cqq)).intValue();
        Object localObject = (HashSet)this.uOw.uOr.get(paramgc.cuC.cqq);
        localJSONArray = new JSONArray();
        localObject = ((HashSet)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          str2 = "weixin://fts/emoji?path=" + paramgc.cuD.path;
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("id", str1);
        localJSONObject.put("src", str2);
        label205:
        localJSONArray.put(localJSONObject);
        continue;
        paramgc = finally;
        AppMethodBeat.o(5662);
        throw paramgc;
        h.KW(i).bG(0, localJSONArray.toString());
        this.uOw.uOr.remove(paramgc.cuC.cqq);
        this.uOw.uOu.remove(paramgc.cuC.cqq);
        AppMethodBeat.o(5662);
        return false;
      }
      catch (JSONException localJSONException)
      {
        break label205;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.1
 * JD-Core Version:    0.7.0.1
 */