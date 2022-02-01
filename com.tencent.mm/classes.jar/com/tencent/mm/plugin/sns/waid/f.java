package com.tencent.mm.plugin.sns.waid;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class f
{
  int zmr = 100;
  int zms = 10;
  int zmt = 1;
  
  public static f gk(Context paramContext)
  {
    AppMethodBeat.i(100587);
    f localf = new f();
    try
    {
      paramContext = paramContext.getSharedPreferences("waid_cfg_sp", 0).getString("cfg_data", "");
      ac.i("ad.waid.WaidCfg", "initCfg, jsonStr=".concat(String.valueOf(paramContext)));
      paramContext = new JSONObject(paramContext);
      localf.zmr = paramContext.optInt("maxAppWaidCount");
      localf.zms = paramContext.optInt("maxPubWaidCount");
      localf.zmt = paramContext.optInt("pubWaidSwitch");
      AppMethodBeat.o(100587);
      return localf;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ac.e("ad.waid.WaidCfg", "initCfg, exp=" + paramContext.toString());
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(100586);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("maxAppWaidCount", this.zmr);
      ((JSONObject)localObject).put("maxPubWaidCount", this.zms);
      ((JSONObject)localObject).put("pubWaidSwitch", this.zmt);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(100586);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("ad.waid.WaidCfg", "toString exp=" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.f
 * JD-Core Version:    0.7.0.1
 */