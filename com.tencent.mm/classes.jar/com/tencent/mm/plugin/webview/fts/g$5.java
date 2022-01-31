package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class g$5
  implements com.tencent.mm.plugin.fts.a.l
{
  g$5(g paramg) {}
  
  public final void b(j paramj)
  {
    switch (paramj.aYY)
    {
    default: 
      return;
    case 0: 
      if ((paramj.kxh == null) || (paramj.kxh.size() == 0))
      {
        y.i("MicroMsg.FTS.WebSearchLogic", "local contact search size 0");
        h.Db(((Integer)g.e(this.qZU).kwb).intValue()).TP("");
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
        Iterator localIterator = paramj.kxh.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.fts.a.a.l locall = (com.tencent.mm.plugin.fts.a.a.l)localIterator.next();
          if (locall.type == 131072) {
            localJSONArray2.put(g.a(locall, paramj.kwi));
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (Exception paramj)
      {
        y.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", paramj, "onSearchDone", new Object[0]);
        return;
      }
      localJSONObject2.put("title", ae.getContext().getString(R.l.fts_on_suggest_sns_title));
      localJSONObject2.put("count", localJSONArray2.length());
      localJSONObject2.put("type", 3);
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      localJSONObject1.put("ret", 0);
      h.Db(((Integer)g.e(this.qZU).kwb).intValue()).TP(localJSONObject1.toString());
      return;
    }
    h.Db(((Integer)g.e(this.qZU).kwb).intValue()).TP("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g.5
 * JD-Core Version:    0.7.0.1
 */