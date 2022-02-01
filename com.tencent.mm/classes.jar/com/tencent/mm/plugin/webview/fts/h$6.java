package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class h$6
  implements l
{
  h$6(h paramh) {}
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(188283);
    switch (paramk.bPH)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188283);
      return;
      if ((paramk.syK == null) || (paramk.syK.size() == 0))
      {
        ac.i("MicroMsg.WebSearch.WebSearchLogic", "local contact search size 0");
        g.VW(((Integer)h.e(this.ChM).sxB).intValue()).aBp("");
        AppMethodBeat.o(188283);
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
        Iterator localIterator = paramk.syK.iterator();
        while (localIterator.hasNext())
        {
          m localm = (m)localIterator.next();
          if (localm.type == 131072) {
            localJSONArray2.put(h.a(localm, paramk.sxM));
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (Exception paramk)
      {
        ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramk, "onSearchDone", new Object[0]);
        AppMethodBeat.o(188283);
        return;
      }
      localJSONObject2.put("title", ai.getContext().getString(2131759716));
      localJSONObject2.put("count", localJSONArray2.length());
      localJSONObject2.put("type", 3);
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      localJSONObject1.put("ret", 0);
      g.VW(((Integer)h.e(this.ChM).sxB).intValue()).aBp(localJSONObject1.toString());
      AppMethodBeat.o(188283);
      return;
      g.VW(((Integer)h.e(this.ChM).sxB).intValue()).aBp("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.6
 * JD-Core Version:    0.7.0.1
 */