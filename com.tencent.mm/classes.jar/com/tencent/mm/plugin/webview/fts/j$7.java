package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class j$7
  implements l
{
  j$7(j paramj) {}
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(210846);
    switch (paramk.resultCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210846);
      return;
      if ((paramk.wXb == null) || (paramk.wXb.size() == 0))
      {
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "local contact search size 0");
        g.ahd(((Integer)j.d(this.IPq).wVS).intValue()).aXm("");
        AppMethodBeat.o(210846);
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
        Iterator localIterator = paramk.wXb.iterator();
        while (localIterator.hasNext())
        {
          m localm = (m)localIterator.next();
          if (localm.type == 131072) {
            localJSONArray2.put(j.a(localm, paramk.wWd));
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (Exception paramk)
      {
        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramk, "onSearchDone", new Object[0]);
        AppMethodBeat.o(210846);
        return;
      }
      localJSONObject2.put("title", MMApplicationContext.getContext().getString(2131761037));
      localJSONObject2.put("count", localJSONArray2.length());
      localJSONObject2.put("type", 3);
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      localJSONObject1.put("ret", 0);
      g.ahd(((Integer)j.d(this.IPq).wVS).intValue()).aXm(localJSONObject1.toString());
      AppMethodBeat.o(210846);
      return;
      g.ahd(((Integer)j.d(this.IPq).wVS).intValue()).aXm("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.j.7
 * JD-Core Version:    0.7.0.1
 */