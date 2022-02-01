package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class f
{
  public static void K(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80874);
    if ((ak.foC()) || (ak.foD()))
    {
      d.M(paramString, paramMap);
      AppMethodBeat.o(80874);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("report_data", bL(paramMap).toString());
    localBundle.putString("page_key", paramString);
    ToolsProcessIPCService.a(localBundle, a.class, null);
    AppMethodBeat.o(80874);
  }
  
  public static Map<Integer, Object> bD(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(80876);
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(80876);
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = bu.getInt(str, -1);
      if (i == -1) {
        ae.i("MicroMsg.GameWebReportUtil", "reportData key error");
      } else {
        localHashMap.put(Integer.valueOf(i), paramJSONObject.opt(str));
      }
    }
    AppMethodBeat.o(80876);
    return localHashMap;
  }
  
  private static JSONObject bL(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80875);
    localJSONObject = new JSONObject();
    if (paramMap == null)
    {
      AppMethodBeat.o(80875);
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
      AppMethodBeat.o(80875);
    }
  }
  
  public static class a
    implements b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.f
 * JD-Core Version:    0.7.0.1
 */