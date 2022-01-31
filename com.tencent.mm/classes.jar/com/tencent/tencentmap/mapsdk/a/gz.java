package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

public final class gz
  extends gu
{
  private final ff a = new ff();
  
  public gz()
  {
    em.j().post(new ha(this));
  }
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder("Halley_Cloud_Param_Content_").append(em.c()).append("_for_SettingsHandler");
    if (em.b()) {}
    for (String str = "_test";; str = "") {
      return str;
    }
  }
  
  public final void a(gp paramgp)
  {
    String str = this.a.c();
    paramgp.a.put("confVersion", str);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("Setting");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("data");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.a.a(paramJSONObject);
          paramJSONObject = this.a.a();
          em.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", paramJSONObject).commit();
        }
      }
      return;
    }
    catch (Throwable paramJSONObject) {}finally
    {
      em.j().post(new hb(this));
    }
  }
  
  public final void b()
  {
    em.j().post(new hb(this));
  }
  
  public final String c()
  {
    return "settings";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gz
 * JD-Core Version:    0.7.0.1
 */