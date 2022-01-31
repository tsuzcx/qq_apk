package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cq
  extends ch
{
  private static boolean a = false;
  
  public final void a(cd paramcd)
  {
    AppMethodBeat.i(147372);
    Object localObject3 = new cg();
    Object localObject2 = new cf();
    Object localObject1 = new ce();
    try
    {
      if ((dd.a(((cf)localObject2).b)) || (!a))
      {
        paramcd.a.put("needUpdateState", Integer.valueOf(1));
        a = true;
      }
      for (;;)
      {
        if (dd.a(((cf)localObject2).b))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("model", ((cg)localObject3).a);
          localJSONObject.put("osVersion", ((cg)localObject3).b);
          localJSONObject.put("imei", ((cg)localObject3).c);
          localJSONObject.put("imsi", ((cg)localObject3).d);
          localJSONObject.put("pseudoId", ((cg)localObject3).e);
          paramcd.a.put("RegistDeviceInfo", localJSONObject);
        }
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("platform", ((cf)localObject2).a);
        ((JSONObject)localObject3).put("deviceId", ((cf)localObject2).b);
        ((JSONObject)localObject3).put("sdkVersion", ((cf)localObject2).c);
        paramcd.a.put("BindDeviceInfo", localObject3);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("bundle", ((ce)localObject1).a);
        ((JSONObject)localObject2).put("verCode", ((ce)localObject1).b);
        ((JSONObject)localObject2).put("verName", ((ce)localObject1).c);
        ((JSONObject)localObject2).put("appId", ((ce)localObject1).e);
        ((JSONObject)localObject2).put("uuid", ((ce)localObject1).d);
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(localObject2);
        paramcd.a.put("AppState", localObject1);
        localObject1 = da.a(an.g());
        paramcd.a.put("netType", localObject1);
        localObject1 = cb.a(an.j().intValue());
        paramcd.a.put("oper", localObject1);
        AppMethodBeat.o(147372);
        return;
        paramcd.a.put("needUpdateState", Integer.valueOf(0));
      }
      return;
    }
    catch (Exception paramcd)
    {
      AppMethodBeat.o(147372);
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147373);
    try
    {
      String str1 = paramJSONObject.optString("result");
      boolean bool = TextUtils.isEmpty(str1);
      if (!bool) {
        try
        {
          if (Integer.parseInt(str1) == 1002)
          {
            da.a("");
            AppMethodBeat.o(147373);
            return;
          }
        }
        catch (Throwable localThrowable) {}
      }
      String str2 = paramJSONObject.optString("deviceId");
      if (!TextUtils.isEmpty(str2))
      {
        String str3 = da.a();
        if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str3))) {
          da.a(str2);
        }
      }
      for (;;)
      {
        paramJSONObject = paramJSONObject.optString("oper");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          cb.a().a(an.b(), paramJSONObject);
        }
        AppMethodBeat.o(147373);
        return;
        da.a("");
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(147373);
    }
  }
  
  public final String c()
  {
    return "state";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cq
 * JD-Core Version:    0.7.0.1
 */