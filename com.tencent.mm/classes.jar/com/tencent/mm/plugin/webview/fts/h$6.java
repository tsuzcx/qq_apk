package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
    AppMethodBeat.i(187857);
    switch (paramk.bRZ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(187857);
      return;
      if ((paramk.rpQ == null) || (paramk.rpQ.size() == 0))
      {
        ad.i("MicroMsg.WebSearch.WebSearchLogic", "local contact search size 0");
        g.TO(((Integer)h.e(this.APw).roI).intValue()).avX("");
        AppMethodBeat.o(187857);
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
        Iterator localIterator = paramk.rpQ.iterator();
        while (localIterator.hasNext())
        {
          m localm = (m)localIterator.next();
          if (localm.type == 131072) {
            localJSONArray2.put(h.a(localm, paramk.roS));
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (Exception paramk)
      {
        ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramk, "onSearchDone", new Object[0]);
        AppMethodBeat.o(187857);
        return;
      }
      localJSONObject2.put("title", aj.getContext().getString(2131759716));
      localJSONObject2.put("count", localJSONArray2.length());
      localJSONObject2.put("type", 3);
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      localJSONObject1.put("ret", 0);
      g.TO(((Integer)h.e(this.APw).roI).intValue()).avX(localJSONObject1.toString());
      AppMethodBeat.o(187857);
      return;
      g.TO(((Integer)h.e(this.APw).roI).intValue()).avX("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.6
 * JD-Core Version:    0.7.0.1
 */