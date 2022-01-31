package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class as
  extends bh
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(6360);
    JSONArray localJSONArray = parama.byF.bxK.optJSONArray("idKeyDataInfo");
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      ab.e("MicroMsg.JsApiReportIDKey", "idkey data is null");
      parama.a("invaild_parms", null);
      AppMethodBeat.o(6360);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localJSONArray.length())
    {
      JSONObject localJSONObject = localJSONArray.optJSONObject(i);
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(bo.getInt(localJSONObject.optString("id"), 0));
      localIDKey.SetKey(bo.getInt(localJSONObject.optString("key"), 0));
      localIDKey.SetValue(bo.getInt(localJSONObject.optString("value"), 0));
      localArrayList.add(localIDKey);
      i += 1;
    }
    if (localArrayList.size() > 0) {
      h.qsU.b(localArrayList, true);
    }
    parama.a("", null);
    AppMethodBeat.o(6360);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportIDKey";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.as
 * JD-Core Version:    0.7.0.1
 */