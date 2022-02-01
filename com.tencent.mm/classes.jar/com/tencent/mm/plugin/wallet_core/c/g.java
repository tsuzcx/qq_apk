package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends m
{
  public g()
  {
    AppMethodBeat.i(69900);
    t.fQM().db.execSQL("WalletBulletin", "delete from WalletBulletin");
    setRequestData(new HashMap());
    AppMethodBeat.o(69900);
  }
  
  public final int getFuncId()
  {
    return 1679;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1679;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69901);
    Log.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + paramInt + " " + paramJSONObject);
    if (paramInt == 0)
    {
      y.bN(paramJSONObject);
      long l = paramJSONObject.optLong("banner_update_interval", 0L);
      Log.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=".concat(String.valueOf(l)));
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWE, Long.valueOf(l));
      paramString = paramJSONObject.optJSONObject("lbs_info");
      if (paramString != null)
      {
        JSONArray localJSONArray = paramString.optJSONArray("config_array");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          k localk = k.fQt();
          if (localJSONArray != null)
          {
            Log.d("MicroMsg.GpsReportHelper", localJSONArray.toString());
            localk.HXV = localJSONArray;
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXv, localJSONArray.toString());
          }
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXw, paramString.optString("title"));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXx, paramString.optString("content"));
      }
      paramJSONObject = paramJSONObject.optJSONObject("realname_info");
      if (paramJSONObject != null)
      {
        paramString = paramJSONObject.optString("title");
        paramJSONObject = paramJSONObject.optString("balance_title");
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXy, paramString);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXz, paramJSONObject);
      }
    }
    AppMethodBeat.o(69901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.g
 * JD-Core Version:    0.7.0.1
 */