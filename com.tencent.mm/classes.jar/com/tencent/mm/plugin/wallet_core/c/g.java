package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.wallet_core.tenpay.model.m
{
  public g()
  {
    AppMethodBeat.i(46498);
    t.cTR().db.execSQL("WalletBulletin", "delete from WalletBulletin");
    setRequestData(new HashMap());
    AppMethodBeat.o(46498);
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
    AppMethodBeat.i(46499);
    ab.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + paramInt + " " + paramJSONObject);
    if (paramInt == 0)
    {
      w.aH(paramJSONObject);
      long l = paramJSONObject.optLong("banner_update_interval", 0L);
      ab.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=".concat(String.valueOf(l)));
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yBC, Long.valueOf(l));
      paramString = paramJSONObject.optJSONObject("lbs_info");
      if (paramString != null)
      {
        JSONArray localJSONArray = paramString.optJSONArray("config_array");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          com.tencent.mm.plugin.wallet_core.model.m localm = com.tencent.mm.plugin.wallet_core.model.m.cTx();
          if (localJSONArray != null)
          {
            ab.d("MicroMsg.GpsReportHelper", localJSONArray.toString());
            localm.uii = localJSONArray;
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCt, localJSONArray.toString());
          }
        }
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCu, paramString.optString("title"));
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCv, paramString.optString("content"));
      }
      paramJSONObject = paramJSONObject.optJSONObject("realname_info");
      if (paramJSONObject != null)
      {
        paramString = paramJSONObject.optString("title");
        paramJSONObject = paramJSONObject.optString("balance_title");
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCw, paramString);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCx, paramJSONObject);
      }
    }
    AppMethodBeat.o(46499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.g
 * JD-Core Version:    0.7.0.1
 */