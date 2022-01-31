package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class cm
  extends ch
{
  private final au a;
  
  public cm()
  {
    AppMethodBeat.i(98648);
    this.a = new au();
    ac.j().post(new cn(this));
    AppMethodBeat.o(98648);
  }
  
  private static String d()
  {
    AppMethodBeat.i(147365);
    StringBuilder localStringBuilder = new StringBuilder("Halley_Cloud_Param_Content_").append(ac.c()).append("_for_SettingsHandler");
    if (ac.b()) {}
    for (String str = "_test";; str = "")
    {
      str = str;
      AppMethodBeat.o(147365);
      return str;
    }
  }
  
  public final void a(cd paramcd)
  {
    AppMethodBeat.i(147367);
    String str = this.a.c();
    paramcd.a.put("confVersion", str);
    AppMethodBeat.o(147367);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147368);
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
          ac.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", paramJSONObject).commit();
        }
      }
      return;
    }
    catch (Throwable paramJSONObject) {}finally
    {
      ac.j().post(new co(this));
      AppMethodBeat.o(147368);
    }
  }
  
  public final void b()
  {
    AppMethodBeat.i(147366);
    ac.j().post(new co(this));
    AppMethodBeat.o(147366);
  }
  
  public final String c()
  {
    return "settings";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cm
 * JD-Core Version:    0.7.0.1
 */