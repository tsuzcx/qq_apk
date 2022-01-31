package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.a.m;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i$a
{
  private static i TX(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.MsgWrapper", "fromString fail, src is null");
      return null;
    }
    i locali = new i();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        locali.type = paramString.getString("__msg_type");
        locali.rAL = paramString.getString("__callback_id");
        locali.rAO = paramString.getString("func");
        locali.ndL = new HashMap();
        JSONObject localJSONObject = paramString.getJSONObject("params");
        locali.rAM = localJSONObject;
        if (localJSONObject == null) {
          break;
        }
        Iterator localIterator = localJSONObject.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        String str = (String)localIterator.next();
        Object localObject = localJSONObject.getString(str);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        if ("urls".equalsIgnoreCase(str))
        {
          y.v("MicroMsg.MsgWrapper", "key is JSONArray, %s", new Object[] { str });
          try
          {
            paramString = new JSONArray(paramString);
            localObject = new String[paramString.length()];
            int i = 0;
            if (i < localObject.length)
            {
              localObject[i] = paramString.getString(i);
              i += 1;
              continue;
            }
            locali.ndL.put(str, localObject);
          }
          catch (Exception paramString)
          {
            y.e("MicroMsg.MsgWrapper", "parse JSONArray fail, ex = %s", new Object[] { paramString.getMessage() });
          }
        }
        else
        {
          locali.ndL.put(str, paramString);
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.MsgWrapper", "fromString fail, exception = " + paramString.getMessage());
        return null;
      }
    }
    return locali;
  }
  
  public static JSONObject U(Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return new JSONObject();
    }
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        String str1 = (String)paramMap.get("jsapi_callback_json_special_key");
        localJSONObject = new JSONObject();
        Iterator localIterator = paramMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        String str2 = (String)localIterator.next();
        if ((str2 != null) && (!str2.equals("jsapi_callback_json_special_key"))) {
          if ((str1 != null) && (str2.equals(str1))) {
            localJSONObject.put(str1, new JSONArray((String)paramMap.get(str1)));
          } else {
            localJSONObject.put(str2, paramMap.get(str2));
          }
        }
      }
      catch (Exception paramMap)
      {
        y.e("MicroMsg.MsgWrapper", "convertMapToJSON fail, exception = " + paramMap.getMessage());
        return null;
      }
    }
    return localJSONObject;
  }
  
  static String a(String paramString1, String paramString2, Map<String, Object> paramMap, JSONObject paramJSONObject, boolean paramBoolean, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("__msg_type", paramString1);
        if (paramString1.equals("callback"))
        {
          localJSONObject.put("__callback_id", paramString2);
          if (paramJSONObject == null)
          {
            localJSONObject.put("__params", U(paramMap));
            if (!paramBoolean) {
              break;
            }
            return n(localJSONObject, paramString3);
          }
        }
        else
        {
          if (!paramString1.equals("event")) {
            continue;
          }
          localJSONObject.put("__event_id", paramString2);
          continue;
        }
        localJSONObject.put("__params", paramJSONObject);
      }
      catch (Exception paramString1)
      {
        y.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramString1.getMessage());
        return null;
      }
    }
    return localJSONObject.toString();
  }
  
  public static String a(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
  {
    return a("event", paramString1, paramMap, null, paramBoolean, paramString2);
  }
  
  public static String a(String paramString1, JSONObject paramJSONObject, boolean paramBoolean, String paramString2)
  {
    return a("event", paramString1, null, paramJSONObject, paramBoolean, paramString2);
  }
  
  static List<i> g(String paramString1, boolean paramBoolean, String paramString2)
  {
    int i = 0;
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      y.e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
    }
    for (;;)
    {
      return null;
      if (paramBoolean) {
        try
        {
          Object localObject = new JSONObject(paramString1);
          paramString1 = ((JSONObject)localObject).getJSONArray("__json_message");
          localObject = ((JSONObject)localObject).getString("__sha_key");
          paramString2 = m.getSHA1(paramString1.toString().replaceAll("\\\\/", "/") + paramString2);
          if (!((String)localObject).equals(paramString2))
          {
            y.e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", new Object[] { localObject, paramString2, paramString1.toString().replaceAll("\\\\/", "/") });
            return null;
          }
        }
        catch (Exception paramString1)
        {
          y.e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + paramString1.getMessage());
          return null;
        }
      }
      while (paramString1.length() != 0)
      {
        paramString2 = new LinkedList();
        while (i < paramString1.length())
        {
          paramString2.add(TX(paramString1.getString(i)));
          i += 1;
        }
        paramString1 = new JSONArray(paramString1);
      }
    }
    return paramString2;
  }
  
  private static String n(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("__json_message", paramJSONObject);
      paramJSONObject = paramJSONObject.toString().replaceAll("\\\\/", "/");
      y.i("MicroMsg.MsgWrapper", "js digest verification contentStr = ", new Object[] { paramJSONObject });
      paramJSONObject = m.getSHA1(paramJSONObject + paramString);
      y.i("MicroMsg.MsgWrapper", "js digest verification shaStr = ", new Object[] { paramJSONObject });
      localJSONObject.put("__sha_key", paramJSONObject);
      return localJSONObject.toString();
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramJSONObject.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a
 * JD-Core Version:    0.7.0.1
 */