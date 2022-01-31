package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class f
{
  public static void A(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(8703);
    if (ah.dsW())
    {
      localObject = g.aiO(paramString);
      paramMap.put(Integer.valueOf(e.b.vmR), Long.valueOf(((g)localObject).vmX - ((g)localObject).startTime));
      paramMap.put(Integer.valueOf(e.b.vmS), Long.valueOf(((g)localObject).vmY - ((g)localObject).startTime));
      paramMap.put(Integer.valueOf(e.b.vmT), Long.valueOf(((g)localObject).vmZ - ((g)localObject).vmY));
      paramMap.put(Integer.valueOf(e.b.vmU), Long.valueOf(((g)localObject).vnb - ((g)localObject).vna));
      paramMap.put(Integer.valueOf(e.b.vmV), Long.valueOf(((g)localObject).vnd - ((g)localObject).vnc));
      e.z(paramString, paramMap);
      AppMethodBeat.o(8703);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("report_data", aK(paramMap).toString());
    ((Bundle)localObject).putString("url", paramString);
    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", (Parcelable)localObject, f.a.class, null);
    AppMethodBeat.o(8703);
  }
  
  private static JSONObject aK(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(8704);
    localJSONObject = new JSONObject();
    if (paramMap == null)
    {
      AppMethodBeat.o(8704);
      return localJSONObject;
    }
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localJSONObject.put(String.valueOf(localInteger), paramMap.get(localInteger));
      }
      return localJSONObject;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(8704);
    }
  }
  
  public static Map<Integer, Object> aT(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(8705);
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(8705);
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = bo.getInt(str, -1);
      if (i == -1) {
        ab.i("MicroMsg.GameWebReportUtil", "reportData key error");
      } else {
        localHashMap.put(Integer.valueOf(i), paramJSONObject.opt(str));
      }
    }
    AppMethodBeat.o(8705);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.f
 * JD-Core Version:    0.7.0.1
 */