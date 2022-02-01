package com.tencent.mm.plugin.webview.d;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
{
  public Bundle PNI;
  public String POu;
  public JSONObject POv;
  public Map<String, Object> POw;
  public b PvG;
  public JsapiPermissionWrapper PvI;
  public String function;
  public Map<String, Object> params;
  public String type;
  
  public n()
  {
    AppMethodBeat.i(207143);
    this.POw = new HashMap();
    AppMethodBeat.o(207143);
  }
  
  public static Map<String, Object> aJ(Bundle paramBundle)
  {
    AppMethodBeat.i(207146);
    if (paramBundle == null)
    {
      AppMethodBeat.o(207146);
      return null;
    }
    Object localObject = paramBundle.keySet();
    if (localObject == null)
    {
      AppMethodBeat.o(207146);
      return null;
    }
    HashMap localHashMap = new HashMap();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localHashMap.put(str, paramBundle.get(str));
    }
    AppMethodBeat.o(207146);
    return localHashMap;
  }
  
  public static Bundle bQ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(207145);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      AppMethodBeat.o(207145);
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
    AppMethodBeat.o(207145);
    return localBundle;
  }
  
  public final Map<String, Object> gUk()
  {
    return this.POw;
  }
  
  public static final class a
  {
    private static String a(String paramString1, String paramString2, Map<String, Object> paramMap, JSONObject paramJSONObject, boolean paramBoolean, String paramString3)
    {
      AppMethodBeat.i(206294);
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
              localJSONObject.put("__params", aY(paramMap));
              if (!paramBoolean) {
                break;
              }
              paramString1 = q(localJSONObject, paramString3);
              AppMethodBeat.o(206294);
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
          AppMethodBeat.o(206294);
          return null;
        }
      }
      paramString1 = localJSONObject.toString();
      AppMethodBeat.o(206294);
      return paramString1;
    }
    
    public static String a(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(206289);
      paramString1 = a("callback", paramString1, paramMap, null, paramBoolean, paramString2);
      AppMethodBeat.o(206289);
      return paramString1;
    }
    
    public static String a(String paramString1, JSONObject paramJSONObject, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(206290);
      paramString1 = a("event", paramString1, null, paramJSONObject, paramBoolean, paramString2);
      AppMethodBeat.o(206290);
      return paramString1;
    }
    
    private static void a(JSONObject paramJSONObject, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(206300);
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
      AppMethodBeat.o(206300);
    }
    
    public static n aX(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(206299);
      n localn = new n();
      localn.type = "call";
      localn.function = paramString1;
      localn.params = new HashMap();
      localn.POu = paramString3;
      paramString1 = new JSONObject(paramString2);
      if ((!TextUtils.isEmpty(localn.function)) && (a.contains(c.RAq, localn.function))) {}
      for (localn.POv = paramString1;; localn.POv = null)
      {
        a(paramString1, localn.params);
        AppMethodBeat.o(206299);
        return localn;
      }
    }
    
    public static JSONObject aY(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(206297);
      if ((paramMap == null) || (paramMap.size() == 0))
      {
        paramMap = new JSONObject();
        AppMethodBeat.o(206297);
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
          AppMethodBeat.o(206297);
          return null;
        }
      }
      AppMethodBeat.o(206297);
      return localJSONObject;
    }
    
    public static String b(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(206293);
      paramString1 = a("event", paramString1, paramMap, null, paramBoolean, paramString2);
      AppMethodBeat.o(206293);
      return paramString1;
    }
    
    private static n bki(String paramString)
    {
      AppMethodBeat.i(206301);
      if ((paramString == null) || (paramString.length() == 0))
      {
        Log.e("MicroMsg.MsgWrapper", "fromString fail, src is null");
        AppMethodBeat.o(206301);
        return null;
      }
      n localn = new n();
      try
      {
        paramString = new JSONObject(paramString);
        localn.type = paramString.getString("__msg_type");
        localn.POu = paramString.optString("__callback_id", "-1");
        localn.function = paramString.getString("func");
        localn.params = new HashMap();
        paramString = paramString.getJSONObject("params");
        if ((!TextUtils.isEmpty(localn.function)) && (a.contains(c.RAq, localn.function))) {}
        for (localn.POv = paramString;; localn.POv = null)
        {
          if (paramString != null) {
            a(paramString, localn.params);
          }
          AppMethodBeat.o(206301);
          return localn;
        }
        return null;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.MsgWrapper", "fromString fail, exception = " + paramString.getMessage());
        AppMethodBeat.o(206301);
      }
    }
    
    static List<n> j(String paramString1, boolean paramBoolean, String paramString2)
    {
      int i = 0;
      AppMethodBeat.i(206303);
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        Log.e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
        AppMethodBeat.o(206303);
        return null;
      }
      if (paramBoolean) {}
      try
      {
        Object localObject = new JSONObject(paramString1);
        paramString1 = ((JSONObject)localObject).getJSONArray("__json_message");
        localObject = ((JSONObject)localObject).getString("__sha_key");
        paramString2 = com.tencent.mm.b.n.fS(paramString1.toString().replaceAll("\\\\/", "/") + paramString2);
        if (!((String)localObject).equals(paramString2))
        {
          Log.e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", new Object[] { localObject, paramString2, paramString1.toString().replaceAll("\\\\/", "/") });
          h.IzE.idkeyStat(894L, 6L, 1L, false);
          AppMethodBeat.o(206303);
          return null;
        }
        for (;;)
        {
          int j = paramString1.length();
          if (j != 0) {
            break;
          }
          AppMethodBeat.o(206303);
          return null;
          paramString1 = new JSONArray(paramString1);
        }
        paramString2 = new LinkedList();
        while (i < paramString1.length())
        {
          paramString2.add(bki(paramString1.getString(i)));
          i += 1;
        }
        AppMethodBeat.o(206303);
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + paramString1.getMessage());
        AppMethodBeat.o(206303);
        return null;
      }
      return paramString2;
    }
    
    private static String q(JSONObject paramJSONObject, String paramString)
    {
      AppMethodBeat.i(206295);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("__json_message", paramJSONObject);
        paramJSONObject = paramJSONObject.toString().replaceAll("\\\\/", "/");
        Log.i("MicroMsg.MsgWrapper", "js digest verification contentStr = %s", new Object[] { paramJSONObject });
        paramJSONObject = com.tencent.mm.b.n.fS(paramJSONObject + paramString);
        Log.i("MicroMsg.MsgWrapper", "js digest verification shaStr = %s", new Object[] { paramJSONObject });
        localJSONObject.put("__sha_key", paramJSONObject);
        paramJSONObject = localJSONObject.toString();
        AppMethodBeat.o(206295);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramJSONObject.getMessage());
        AppMethodBeat.o(206295);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.n
 * JD-Core Version:    0.7.0.1
 */