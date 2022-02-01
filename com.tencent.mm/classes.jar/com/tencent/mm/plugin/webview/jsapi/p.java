package com.tencent.mm.plugin.webview.jsapi;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.c.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public Bundle WDU;
  public String WEH;
  public JSONObject WEI;
  public Map<String, Object> WEJ;
  public JsapiPermissionWrapper WlV;
  public c WlW;
  public String function;
  public Map<String, Object> params;
  public String type;
  
  public p()
  {
    AppMethodBeat.i(295217);
    this.WEJ = new HashMap();
    AppMethodBeat.o(295217);
  }
  
  public static Map<String, Object> bm(Bundle paramBundle)
  {
    AppMethodBeat.i(295232);
    if (paramBundle == null)
    {
      AppMethodBeat.o(295232);
      return null;
    }
    Object localObject = paramBundle.keySet();
    if (localObject == null)
    {
      AppMethodBeat.o(295232);
      return null;
    }
    HashMap localHashMap = new HashMap();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localHashMap.put(str, paramBundle.get(str));
    }
    AppMethodBeat.o(295232);
    return localHashMap;
  }
  
  public static Bundle cj(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(295227);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      AppMethodBeat.o(295227);
      return null;
    }
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((localObject instanceof String[])) {
        localBundle.putStringArray(str, (String[])localObject);
      } else if ((localObject instanceof Bundle)) {
        localBundle.putBundle(str, (Bundle)localObject);
      } else {
        localBundle.putString(str, String.valueOf(localObject));
      }
    }
    AppMethodBeat.o(295227);
    return localBundle;
  }
  
  public final Map<String, Object> itR()
  {
    return this.WEJ;
  }
  
  public static final class a
  {
    private static String a(String paramString1, String paramString2, Map<String, Object> paramMap, JSONObject paramJSONObject, boolean paramBoolean, String paramString3)
    {
      AppMethodBeat.i(295233);
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
              localJSONObject.put("__params", bp(paramMap));
              if (!paramBoolean) {
                break;
              }
              paramString1 = r(localJSONObject, paramString3);
              AppMethodBeat.o(295233);
              return paramString1;
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
          Log.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramString1.getMessage());
          AppMethodBeat.o(295233);
          return null;
        }
      }
      paramString1 = localJSONObject.toString();
      AppMethodBeat.o(295233);
      return paramString1;
    }
    
    public static String a(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(295215);
      paramString1 = a("callback", paramString1, paramMap, null, paramBoolean, paramString2);
      AppMethodBeat.o(295215);
      return paramString1;
    }
    
    public static String a(String paramString1, JSONObject paramJSONObject, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(295220);
      paramString1 = a("event", paramString1, null, paramJSONObject, paramBoolean, paramString2);
      AppMethodBeat.o(295220);
      return paramString1;
    }
    
    private static void a(JSONObject paramJSONObject, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(295258);
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = paramJSONObject.getString(str);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if ("urls".equalsIgnoreCase(str))
        {
          Log.v("MicroMsg.MsgWrapper", "key is JSONArray, %s", new Object[] { str });
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            localObject2 = new String[((JSONArray)localObject1).length()];
            int i = 0;
            while (i < localObject2.length)
            {
              localObject2[i] = ((JSONArray)localObject1).getString(i);
              i += 1;
            }
            paramMap.put(str, localObject2);
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.MsgWrapper", "parse JSONArray fail, ex = %s", new Object[] { localException.getMessage() });
          }
        }
        else
        {
          paramMap.put(str, localException);
        }
      }
      AppMethodBeat.o(295258);
    }
    
    public static String b(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(295226);
      paramString1 = a("event", paramString1, paramMap, null, paramBoolean, paramString2);
      AppMethodBeat.o(295226);
      return paramString1;
    }
    
    private static p bjS(String paramString)
    {
      AppMethodBeat.i(295267);
      if ((paramString == null) || (paramString.length() == 0))
      {
        Log.e("MicroMsg.MsgWrapper", "fromString fail, src is null");
        AppMethodBeat.o(295267);
        return null;
      }
      p localp = new p();
      try
      {
        paramString = new JSONObject(paramString);
        localp.type = paramString.optString("__msg_type", "");
        localp.WEH = paramString.optString("__callback_id", "-1");
        localp.function = paramString.getString("func");
        localp.params = new HashMap();
        paramString = paramString.getJSONObject("params");
        if ((!TextUtils.isEmpty(localp.function)) && (a.contains(com.tencent.mm.protocal.c.YwU, localp.function))) {}
        for (localp.WEI = paramString;; localp.WEI = null)
        {
          if (paramString != null) {
            a(paramString, localp.params);
          }
          AppMethodBeat.o(295267);
          return localp;
        }
        return null;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.MsgWrapper", "fromString fail, exception = " + paramString.getMessage());
        AppMethodBeat.o(295267);
      }
    }
    
    public static JSONObject bp(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(295243);
      if ((paramMap == null) || (paramMap.size() == 0))
      {
        paramMap = new JSONObject();
        AppMethodBeat.o(295243);
        return paramMap;
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
          Log.e("MicroMsg.MsgWrapper", "convertMapToJSON fail, exception = " + paramMap.getMessage());
          AppMethodBeat.o(295243);
          return null;
        }
      }
      AppMethodBeat.o(295243);
      return localJSONObject;
    }
    
    public static p bq(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(295251);
      p localp = new p();
      localp.type = "call";
      localp.function = paramString1;
      localp.params = new HashMap();
      localp.WEH = paramString3;
      paramString1 = new JSONObject(paramString2);
      if ((!TextUtils.isEmpty(localp.function)) && (a.contains(com.tencent.mm.protocal.c.YwU, localp.function))) {}
      for (localp.WEI = paramString1;; localp.WEI = null)
      {
        a(paramString1, localp.params);
        AppMethodBeat.o(295251);
        return localp;
      }
    }
    
    public static List<p> n(String paramString1, boolean paramBoolean, String paramString2)
    {
      int i = 0;
      AppMethodBeat.i(295278);
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        Log.e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
        AppMethodBeat.o(295278);
        return null;
      }
      if (paramBoolean) {}
      try
      {
        Object localObject = new JSONObject(paramString1);
        paramString1 = ((JSONObject)localObject).getJSONArray("__json_message");
        localObject = ((JSONObject)localObject).getString("__sha_key");
        paramString2 = n.hv(paramString1.toString().replaceAll("\\\\/", "/") + paramString2);
        if (!((String)localObject).equals(paramString2))
        {
          Log.e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", new Object[] { localObject, paramString2, paramString1.toString().replaceAll("\\\\/", "/") });
          h.OAn.idkeyStat(894L, 6L, 1L, false);
          AppMethodBeat.o(295278);
          return null;
        }
        for (;;)
        {
          int j = paramString1.length();
          if (j != 0) {
            break;
          }
          AppMethodBeat.o(295278);
          return null;
          paramString1 = new JSONArray(paramString1);
        }
        paramString2 = new LinkedList();
        while (i < paramString1.length())
        {
          paramString2.add(bjS(paramString1.getString(i)));
          i += 1;
        }
        AppMethodBeat.o(295278);
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + paramString1.getMessage());
        AppMethodBeat.o(295278);
        return null;
      }
      return paramString2;
    }
    
    private static String r(JSONObject paramJSONObject, String paramString)
    {
      AppMethodBeat.i(295238);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("__json_message", paramJSONObject);
        paramJSONObject = paramJSONObject.toString().replaceAll("\\\\/", "/");
        Log.i("MicroMsg.MsgWrapper", "js digest verification contentStr = %s", new Object[] { paramJSONObject });
        paramJSONObject = n.hv(paramJSONObject + paramString);
        Log.i("MicroMsg.MsgWrapper", "js digest verification shaStr = %s", new Object[] { paramJSONObject });
        localJSONObject.put("__sha_key", paramJSONObject);
        paramJSONObject = localJSONObject.toString();
        AppMethodBeat.o(295238);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramJSONObject.getMessage());
        AppMethodBeat.o(295238);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.p
 * JD-Core Version:    0.7.0.1
 */