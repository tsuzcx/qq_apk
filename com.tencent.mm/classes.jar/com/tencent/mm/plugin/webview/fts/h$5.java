package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class h$5
  implements com.tencent.mm.plugin.fts.a.l
{
  h$5(h paramh) {}
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(5742);
    switch (paramj.bpE)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(5742);
      return;
      if ((paramj.mSW == null) || (paramj.mSW.size() == 0))
      {
        ab.i("MicroMsg.WebSearch.WebSearchLogic", "local contact search size 0");
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(((Integer)h.e(this.uPD).mRQ).intValue()).aiZ("");
        AppMethodBeat.o(5742);
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
        Iterator localIterator = paramj.mSW.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.fts.a.a.l locall = (com.tencent.mm.plugin.fts.a.a.l)localIterator.next();
          if (locall.type == 131072) {
            localJSONArray2.put(h.a(locall, paramj.mRX));
          }
        }
        localJSONObject2.put("items", localJSONArray2);
      }
      catch (Exception paramj)
      {
        ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramj, "onSearchDone", new Object[0]);
        AppMethodBeat.o(5742);
        return;
      }
      localJSONObject2.put("title", ah.getContext().getString(2131300236));
      localJSONObject2.put("count", localJSONArray2.length());
      localJSONObject2.put("type", 3);
      localJSONArray1.put(localJSONObject2);
      localJSONObject1.put("data", localJSONArray1);
      localJSONObject1.put("ret", 0);
      com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(((Integer)h.e(this.uPD).mRQ).intValue()).aiZ(localJSONObject1.toString());
      AppMethodBeat.o(5742);
      return;
      com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(((Integer)h.e(this.uPD).mRQ).intValue()).aiZ("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h.5
 * JD-Core Version:    0.7.0.1
 */