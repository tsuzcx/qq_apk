package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class ak$a
{
  private static JSONObject ao(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(124199);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      paramMap = new JSONObject();
      AppMethodBeat.o(124199);
      return paramMap;
    }
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str != null) {
          localJSONObject.put(str, paramMap.get(str));
        }
      }
      AppMethodBeat.o(124199);
    }
    catch (Exception paramMap)
    {
      ab.e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + paramMap.getMessage());
      AppMethodBeat.o(124199);
      return null;
    }
    return localJSONObject;
  }
  
  static String i(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(124198);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("__msg_type", paramString1);
      if (paramString1.equals("event")) {
        localJSONObject.put("__event_id", paramString2);
      }
      localJSONObject.put("__params", ao(paramMap));
      paramString1 = localJSONObject.toString();
      AppMethodBeat.o(124198);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + paramString1.getMessage());
      AppMethodBeat.o(124198);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak.a
 * JD-Core Version:    0.7.0.1
 */