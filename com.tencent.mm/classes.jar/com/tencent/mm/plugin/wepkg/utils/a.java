package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static String Dy(int paramInt)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("subCode", paramInt);
      localObject = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return null;
    }
    catch (JSONException localJSONException)
    {
      label29:
      break label29;
    }
  }
  
  public static String Vo(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", paramString);
      paramString = URLEncoder.encode(localJSONObject.toString(), "UTF-8");
      return paramString;
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.WePkgReport", paramString.getMessage());
      return "";
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.WePkgReport", paramString.getMessage());
      }
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5)
  {
    for (;;)
    {
      try
      {
        if (bk.bl(paramString5))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("netType", aq.fH(ae.getContext()));
          localObject = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
          paramString5 = (String)localObject;
          localObject = paramString5;
          str3 = paramString2;
        }
      }
      catch (Exception localException1)
      {
        Object localObject;
        String str1 = paramString5;
        str3 = paramString2;
        continue;
      }
      try
      {
        if (!bk.bl(paramString2))
        {
          str3 = URLEncoder.encode(paramString2, "UTF-8");
          localObject = paramString5;
        }
      }
      catch (Exception localException2)
      {
        String str2 = paramString5;
        str3 = paramString2;
        continue;
      }
      h.nFQ.f(13980, new Object[] { paramString1, str3, paramString3, paramString4, Long.valueOf(paramLong1), localObject, Long.valueOf(paramLong2) });
      return;
      localObject = new JSONObject(URLDecoder.decode(paramString5, "UTF-8"));
      ((JSONObject)localObject).put("netType", aq.fH(ae.getContext()));
      localObject = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
      paramString5 = (String)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.a
 * JD-Core Version:    0.7.0.1
 */