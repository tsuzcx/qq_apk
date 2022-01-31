package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hd
  extends gu
{
  private static boolean a = false;
  
  public final void a(gp paramgp)
  {
    Object localObject3 = new gt();
    Object localObject2 = new gs();
    Object localObject1 = new gq();
    try
    {
      if ((hq.a(((gs)localObject2).b)) || (!a))
      {
        paramgp.a.put("needUpdateState", Integer.valueOf(1));
        a = true;
      }
      for (;;)
      {
        if (hq.a(((gs)localObject2).b))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("model", ((gt)localObject3).a);
          localJSONObject.put("osVersion", ((gt)localObject3).b);
          localJSONObject.put("imei", ((gt)localObject3).c);
          localJSONObject.put("imsi", ((gt)localObject3).d);
          localJSONObject.put("pseudoId", ((gt)localObject3).e);
          paramgp.a.put("RegistDeviceInfo", localJSONObject);
        }
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("platform", ((gs)localObject2).a);
        ((JSONObject)localObject3).put("deviceId", ((gs)localObject2).b);
        ((JSONObject)localObject3).put("sdkVersion", ((gs)localObject2).c);
        paramgp.a.put("BindDeviceInfo", localObject3);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("bundle", ((gq)localObject1).a);
        ((JSONObject)localObject2).put("verCode", ((gq)localObject1).b);
        ((JSONObject)localObject2).put("verName", ((gq)localObject1).c);
        ((JSONObject)localObject2).put("appId", ((gq)localObject1).e);
        ((JSONObject)localObject2).put("uuid", ((gq)localObject1).d);
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(localObject2);
        paramgp.a.put("AppState", localObject1);
        localObject1 = hn.a(ey.g());
        paramgp.a.put("netType", localObject1);
        localObject1 = gn.a(ey.j().intValue());
        paramgp.a.put("oper", localObject1);
        return;
        paramgp.a.put("needUpdateState", Integer.valueOf(0));
      }
      return;
    }
    catch (Exception paramgp) {}
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = paramJSONObject.optString("result");
      boolean bool = TextUtils.isEmpty(str1);
      if (!bool) {
        try
        {
          if (Integer.parseInt(str1) == 1002)
          {
            hn.a("");
            return;
          }
        }
        catch (Throwable localThrowable) {}
      }
      String str2 = paramJSONObject.optString("deviceId");
      if (!TextUtils.isEmpty(str2))
      {
        String str3 = hn.a();
        if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str3))) {
          hn.a(str2);
        }
      }
      for (;;)
      {
        paramJSONObject = paramJSONObject.optString("oper");
        if (TextUtils.isEmpty(paramJSONObject)) {
          break;
        }
        gn.a().a(ey.b(), paramJSONObject);
        return;
        hn.a("");
      }
      return;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  public final String c()
  {
    return "state";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.hd
 * JD-Core Version:    0.7.0.1
 */