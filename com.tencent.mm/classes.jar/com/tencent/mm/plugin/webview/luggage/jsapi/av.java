package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class av
  extends bn
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(78611);
    JSONArray localJSONArray = parama.bZV.bZb.optJSONArray("idKeyDataInfo");
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      ad.e("MicroMsg.JsApiReportIDKey", "idkey data is null");
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
      localIDKey.SetID(bt.getInt(localJSONObject.optString("id"), 0));
      localIDKey.SetKey(bt.getInt(localJSONObject.optString("key"), 0));
      localIDKey.SetValue(bt.getInt(localJSONObject.optString("value"), 0));
      localArrayList.add(localIDKey);
      i += 1;
    }
    if (localArrayList.size() > 0) {
      h.vKh.b(localArrayList, true);
    }
    parama.a("", null);
    AppMethodBeat.o(78611);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportIDKey";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.av
 * JD-Core Version:    0.7.0.1
 */