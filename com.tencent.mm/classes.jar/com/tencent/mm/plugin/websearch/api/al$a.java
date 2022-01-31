package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class al$a
{
  private static JSONObject U(Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return new JSONObject();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str != null) {
          localJSONObject.put(str, paramMap.get(str));
        }
      }
      return localJSONObject;
    }
    catch (Exception paramMap)
    {
      y.e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + paramMap.getMessage());
      return null;
    }
  }
  
  static String f(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("__msg_type", paramString1);
      if (paramString1.equals("event")) {
        localJSONObject.put("__event_id", paramString2);
      }
      localJSONObject.put("__params", U(paramMap));
      return localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      y.e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + paramString1.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al.a
 * JD-Core Version:    0.7.0.1
 */