package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class g
{
  public static void S(String paramString, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(80874);
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      e.U(paramString, paramMap);
      AppMethodBeat.o(80874);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("report_data", bT(paramMap).toString());
    localBundle.putString("page_key", paramString);
    ToolsProcessIPCService.a(localBundle, a.class, null);
    AppMethodBeat.o(80874);
  }
  
  private static JSONObject bT(Map<Integer, Object> paramMap)
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
  
  public static Map<Integer, Object> cn(JSONObject paramJSONObject)
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
      int i = Util.getInt(str, -1);
      if (i == -1) {
        Log.i("MicroMsg.GameWebReportUtil", "reportData key error");
      } else {
        localHashMap.put(Integer.valueOf(i), paramJSONObject.opt(str));
      }
    }
    AppMethodBeat.o(80876);
    return localHashMap;
  }
  
  public static class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.g
 * JD-Core Version:    0.7.0.1
 */