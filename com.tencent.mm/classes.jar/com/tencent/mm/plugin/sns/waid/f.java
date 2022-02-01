package com.tencent.mm.plugin.sns.waid;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class f
{
  int xZr = 100;
  int xZs = 10;
  int xZt = 1;
  
  public static f fY(Context paramContext)
  {
    AppMethodBeat.i(100587);
    f localf = new f();
    try
    {
      paramContext = paramContext.getSharedPreferences("waid_cfg_sp", 0).getString("cfg_data", "");
      ad.i("ad.waid.WaidCfg", "initCfg, jsonStr=".concat(String.valueOf(paramContext)));
      paramContext = new JSONObject(paramContext);
      localf.xZr = paramContext.optInt("maxAppWaidCount");
      localf.xZs = paramContext.optInt("maxPubWaidCount");
      localf.xZt = paramContext.optInt("pubWaidSwitch");
      AppMethodBeat.o(100587);
      return localf;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.e("ad.waid.WaidCfg", "initCfg, exp=" + paramContext.toString());
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(100586);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("maxAppWaidCount", this.xZr);
      ((JSONObject)localObject).put("maxPubWaidCount", this.xZs);
      ((JSONObject)localObject).put("pubWaidSwitch", this.xZt);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(100586);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("ad.waid.WaidCfg", "toString exp=" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.f
 * JD-Core Version:    0.7.0.1
 */