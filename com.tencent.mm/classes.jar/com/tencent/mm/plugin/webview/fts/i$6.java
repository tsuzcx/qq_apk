package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class i$6
  implements l
{
  i$6(i parami) {}
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(197993);
    switch (paramk.bZU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(197993);
      return;
      if ((paramk.tGc == null) || (paramk.tGc.size() == 0))
      {
        ae.i("MicroMsg.WebSearch.WebSearchLogic", "local contact search size 0");
        g.Yt(((Integer)i.e(this.EcR).tET).intValue()).aIf("");
        AppMethodBeat.o(197993);
        return;
      }
      JSONObject localJSONObject1;
      JSONArray localJSONArray1;
      JSONObject localJSONObject2;
      JSONArray localJSONArray2;
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONArray1 = new JSONArray();
        localJSONObject2 = new JSONObject();
        localJSONArray2 = new JSONArray();
        Iterator localIterator = paramk.tGc.iterator();
        while (localIterator.hasNext())
        {
          m localm = (m)localIterator.next();
          if (localm.type == 131072) {
            localJSONArray2.put(i.a(localm, paramk.tFe));
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (Exception paramk)
      {
        ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramk, "onSearchDone", new Object[0]);
        AppMethodBeat.o(197993);
        return;
      }
      localJSONObject2.put("title", ak.getContext().getString(2131759716));
      localJSONObject2.put("count", localJSONArray2.length());
      localJSONObject2.put("type", 3);
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      localJSONObject1.put("ret", 0);
      g.Yt(((Integer)i.e(this.EcR).tET).intValue()).aIf(localJSONObject1.toString());
      AppMethodBeat.o(197993);
      return;
      g.Yt(((Integer)i.e(this.EcR).tET).intValue()).aIf("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.i.6
 * JD-Core Version:    0.7.0.1
 */