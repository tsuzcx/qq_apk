package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.util.StringUtil;
import java.util.ArrayList;
import navsns.RttLinkRequest;
import navsns.RttLinkResponse;
import navsns.user_login_t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lw
  implements kt
{
  private static lw a;
  private boolean b = false;
  
  private static int a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        int i = paramJSONObject.getInt(paramString);
        return i;
      }
      catch (JSONException paramJSONObject) {}
    }
    return 0;
  }
  
  private ep a(RttLinkRequest paramRttLinkRequest)
  {
    user_login_t localuser_login_t = new user_login_t();
    localuser_login_t.user_id = 0L;
    localuser_login_t.nettp = lq.b();
    if (!StringUtil.isEmpty(lq.a)) {
      localuser_login_t.fr = lq.a;
    }
    localuser_login_t.imei = lq.a();
    localuser_login_t.pf = "ANDROID";
    localuser_login_t.version = "4.1.1".replaceAll("\\.", "");
    localuser_login_t.channel = "";
    ep localep = new ep();
    localep.a("UTF-8");
    localep.a(9001);
    if (!this.b) {
      localep.c("rttserver");
    }
    for (;;)
    {
      localep.d("getLinks");
      localep.a("info", localuser_login_t);
      localep.a("req", paramRttLinkRequest);
      return localep;
      localep.c("rtthisserver");
    }
  }
  
  public static lw a()
  {
    try
    {
      if (a == null) {
        a = new lw();
      }
      lw locallw = a;
      return locallw;
    }
    finally {}
  }
  
  private RttLinkResponse a(String paramString, byte[] paramArrayOfByte)
  {
    int i = 0;
    label80:
    for (;;)
    {
      if (i < 3) {}
      try
      {
        Object localObject = qs.a().a(paramString, "sosomap navsns", paramArrayOfByte);
        if ((localObject == null) || (((qt)localObject).a == null)) {
          break label80;
        }
        ep localep = new ep();
        localep.a("UTF-8");
        localep.a(((qt)localObject).a);
        localObject = (RttLinkResponse)localep.b("res");
        return localObject;
      }
      catch (Exception localException)
      {
        i += 1;
      }
      return null;
    }
  }
  
  private byte[] a(RttLinkResponse paramRttLinkResponse)
  {
    if (paramRttLinkResponse == null) {
      return null;
    }
    return paramRttLinkResponse.result;
  }
  
  private RttLinkRequest b(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return null;
    }
    RttLinkRequest localRttLinkRequest = new RttLinkRequest();
    try
    {
      paramString = new JSONObject(paramString);
      localRttLinkRequest.setTag(c(paramString, "tag"));
      localRttLinkRequest.zoom = ((short)a(paramString, "level"));
      localRttLinkRequest.zip = ((short)a(paramString, "zip"));
      localRttLinkRequest.bounds = new ArrayList();
      JSONArray localJSONArray = b(paramString, "boundArray");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localRttLinkRequest;
        if (i >= j) {
          break;
        }
        localRttLinkRequest.bounds.add(Integer.valueOf(localJSONArray.getInt(i)));
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = null;
    }
  }
  
  private static JSONArray b(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray(paramString);
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject) {}
    }
    return null;
  }
  
  private static String c(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        paramJSONObject = paramJSONObject.getString(paramString);
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject) {}
    }
    return "";
  }
  
  public byte[] a(String paramString)
  {
    try
    {
      if (StringUtil.isEmpty(paramString)) {
        return null;
      }
      paramString = b(paramString);
      if (paramString != null)
      {
        paramString = a(paramString);
        if (paramString != null)
        {
          paramString = a(a(b(), paramString.a()));
          return paramString;
        }
      }
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public String b()
  {
    return "https://tafrtt.map.qq.com/index.wup";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lw
 * JD-Core Version:    0.7.0.1
 */