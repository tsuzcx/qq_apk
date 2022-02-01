package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ax
  extends br
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(78611);
    JSONArray localJSONArray = parama.crh.cqn.optJSONArray("idKeyDataInfo");
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      Log.e("MicroMsg.JsApiReportIDKey", "idkey data is null");
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
      localIDKey.SetID(Util.getInt(localJSONObject.optString("id"), 0));
      localIDKey.SetKey(Util.getInt(localJSONObject.optString("key"), 0));
      localIDKey.SetValue(Util.getInt(localJSONObject.optString("value"), 0));
      localArrayList.add(localIDKey);
      i += 1;
    }
    if (localArrayList.size() > 0) {
      h.IzE.b(localArrayList, true);
    }
    parama.a("", null);
    AppMethodBeat.o(78611);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportIDKey";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */