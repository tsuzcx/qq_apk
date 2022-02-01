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
  public b IBt;
  public JsapiPermissionWrapper IBv;
  public Bundle IRs;
  public String ISe;
  public JSONObject ISf;
  public Map<String, Object> ISg;
  public String mhO;
  public Map<String, Object> params;
  public String type;
  
  public n()
  {
    AppMethodBeat.i(224430);
    this.ISg = new HashMap();
    AppMethodBeat.o(224430);
  }
  
  public static Map<String, Object> aN(Bundle paramBundle)
  {
    AppMethodBeat.i(224432);
    if (paramBundle == null)
    {
      AppMethodBeat.o(224432);
      return null;
    }
    Object localObject = paramBundle.keySet();
    if (localObject == null)
    {
      AppMethodBeat.o(224432);
      return null;
    }
    HashMap localHashMap = new HashMap();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localHashMap.put(str, paramBundle.get(str));
    }
    AppMethodBeat.o(224432);
    return localHashMap;
  }
  
  public static Bundle bL(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(224431);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      AppMethodBeat.o(224431);
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
    AppMethodBeat.o(224431);
    return localBundle;
  }
  
  public final Map<String, Object> gbq()
  {
    return this.ISg;
  }
  
  public static final class a
  {
    private static String a(String paramString1, String paramString2, Map<String, Object> paramMap, JSONObject paramJSONObject, boolean paramBoolean, String paramString3)
    {
      AppMethodBeat.i(224423);
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
              localJSONObject.put("__params", be(paramMap));
              if (!paramBoolean) {
                break;
              }
              paramString1 = o(localJSONObject, paramString3);
              AppMethodBeat.o(224423);
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
          AppMethodBeat.o(224423);
          return null;
        }
      }
      paramString1 = localJSONObject.toString();
      AppMethodBeat.o(224423);
      return paramString1;
    }
    
    public static String a(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(224420);
      paramString1 = a("callback", paramString1, paramMap, null, paramBoolean, paramString2);
      AppMethodBeat.o(224420);
      return paramString1;
    }
    
    public static String a(String paramString1, JSONObject paramJSONObject, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(224421);
      paramString1 = a("event", paramString1, null, paramJSONObject, paramBoolean, paramString2);
      AppMethodBeat.o(224421);
      return paramString1;
    }
    
    private static void a(JSONObject paramJSONObject, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(224427);
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
      AppMethodBeat.o(224427);
    }
    
    private static n aYn(String paramString)
    {
      AppMethodBeat.i(224428);
      if ((paramString == null) || (paramString.length() == 0))
      {
        Log.e("MicroMsg.MsgWrapper", "fromString fail, src is null");
        AppMethodBeat.o(224428);
        return null;
      }
      n localn = new n();
      try
      {
        paramString = new JSONObject(paramString);
        localn.type = paramString.getString("__msg_type");
        localn.ISe = paramString.optString("__callback_id", "-1");
        localn.mhO = paramString.getString("func");
        localn.params = new HashMap();
        paramString = paramString.getJSONObject("params");
        if ((!TextUtils.isEmpty(localn.mhO)) && (a.contains(c.KyC, localn.mhO))) {}
        for (localn.ISf = paramString;; localn.ISf = null)
        {
          if (paramString != null) {
            a(paramString, localn.params);
          }
          AppMethodBeat.o(224428);
          return localn;
        }
        return null;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.MsgWrapper", "fromString fail, exception = " + paramString.getMessage());
        AppMethodBeat.o(224428);
      }
    }
    
    public static String b(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(224422);
      paramString1 = a("event", paramString1, paramMap, null, paramBoolean, paramString2);
      AppMethodBeat.o(224422);
      return paramString1;
    }
    
    public static JSONObject be(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(224425);
      if ((paramMap == null) || (paramMap.size() == 0))
      {
        paramMap = new JSONObject();
        AppMethodBeat.o(224425);
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
          AppMethodBeat.o(224425);
          return null;
        }
      }
      AppMethodBeat.o(224425);
      return localJSONObject;
    }
    
    static List<n> k(String paramString1, boolean paramBoolean, String paramString2)
    {
      int i = 0;
      AppMethodBeat.i(224429);
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        Log.e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
        AppMethodBeat.o(224429);
        return null;
      }
      if (paramBoolean) {}
      try
      {
        Object localObject = new JSONObject(paramString1);
        paramString1 = ((JSONObject)localObject).getJSONArray("__json_message");
        localObject = ((JSONObject)localObject).getString("__sha_key");
        paramString2 = com.tencent.mm.b.n.fc(paramString1.toString().replaceAll("\\\\/", "/") + paramString2);
        if (!((String)localObject).equals(paramString2))
        {
          Log.e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", new Object[] { localObject, paramString2, paramString1.toString().replaceAll("\\\\/", "/") });
          h.CyF.idkeyStat(894L, 6L, 1L, false);
          AppMethodBeat.o(224429);
          return null;
        }
        for (;;)
        {
          int j = paramString1.length();
          if (j != 0) {
            break;
          }
          AppMethodBeat.o(224429);
          return null;
          paramString1 = new JSONArray(paramString1);
        }
        paramString2 = new LinkedList();
        while (i < paramString1.length())
        {
          paramString2.add(aYn(paramString1.getString(i)));
          i += 1;
        }
        AppMethodBeat.o(224429);
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + paramString1.getMessage());
        AppMethodBeat.o(224429);
        return null;
      }
      return paramString2;
    }
    
    public static n lY(String paramString1, String paramString2)
    {
      AppMethodBeat.i(224426);
      n localn = new n();
      localn.type = "call";
      localn.mhO = paramString1;
      localn.params = new HashMap();
      localn.ISe = "0";
      paramString1 = new JSONObject(paramString2);
      if ((!TextUtils.isEmpty(localn.mhO)) && (a.contains(c.KyC, localn.mhO))) {}
      for (localn.ISf = paramString1;; localn.ISf = null)
      {
        a(paramString1, localn.params);
        AppMethodBeat.o(224426);
        return localn;
      }
    }
    
    private static String o(JSONObject paramJSONObject, String paramString)
    {
      AppMethodBeat.i(224424);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("__json_message", paramJSONObject);
        paramJSONObject = paramJSONObject.toString().replaceAll("\\\\/", "/");
        Log.i("MicroMsg.MsgWrapper", "js digest verification contentStr = %s", new Object[] { paramJSONObject });
        paramJSONObject = com.tencent.mm.b.n.fc(paramJSONObject + paramString);
        Log.i("MicroMsg.MsgWrapper", "js digest verification shaStr = %s", new Object[] { paramJSONObject });
        localJSONObject.put("__sha_key", paramJSONObject);
        paramJSONObject = localJSONObject.toString();
        AppMethodBeat.o(224424);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramJSONObject.getMessage());
        AppMethodBeat.o(224424);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.n
 * JD-Core Version:    0.7.0.1
 */