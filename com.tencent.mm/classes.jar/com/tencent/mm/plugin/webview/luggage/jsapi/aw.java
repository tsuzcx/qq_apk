package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aw
  extends bq
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(78611);
    JSONArray localJSONArray = parama.chh.cgn.optJSONArray("idKeyDataInfo");
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      ae.e("MicroMsg.JsApiReportIDKey", "idkey data is null");
      parama.a("invaild_parms", null);
      AppMethodBeat.o(78611);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localJSONArray.length())
    {
      JSONObject localJSONObject = localJSONArray.optJSONObject(i);
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(bu.getInt(localJSONObject.optString("id"), 0));
      localIDKey.SetKey(bu.getInt(localJSONObject.optString("key"), 0));
      localIDKey.SetValue(bu.getInt(localJSONObject.optString("value"), 0));
      localArrayList.add(localIDKey);
      i += 1;
    }
    if (localArrayList.size() > 0) {
      g.yxI.b(localArrayList, true);
    }
    parama.a("", null);
    AppMethodBeat.o(78611);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportIDKey";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aw
 * JD-Core Version:    0.7.0.1
 */