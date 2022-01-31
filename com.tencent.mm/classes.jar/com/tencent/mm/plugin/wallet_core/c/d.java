package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends j
{
  public d()
  {
    o.bVw().dXw.gk("WalletBulletin", "delete from WalletBulletin");
    D(new HashMap());
  }
  
  public final int HH()
  {
    return 1679;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + paramInt + " " + paramJSONObject);
    if (paramInt == 0)
    {
      r.at(paramJSONObject);
      long l = paramJSONObject.optLong("banner_update_interval", 0L);
      y.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=" + l);
      g.DQ();
      g.DP().Dz().c(ac.a.urC, Long.valueOf(l));
      paramString = paramJSONObject.optJSONObject("lbs_info");
      if (paramString != null)
      {
        JSONArray localJSONArray = paramString.optJSONArray("config_array");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          i locali = i.bVe();
          if (localJSONArray != null)
          {
            y.d("MicroMsg.GpsReportHelper", localJSONArray.toString());
            locali.qvM = localJSONArray;
            g.DQ();
            g.DP().Dz().c(ac.a.ust, localJSONArray.toString());
          }
        }
        g.DQ();
        g.DP().Dz().c(ac.a.usu, paramString.optString("title"));
        g.DQ();
        g.DP().Dz().c(ac.a.usv, paramString.optString("content"));
      }
      paramJSONObject = paramJSONObject.optJSONObject("realname_info");
      if (paramJSONObject != null)
      {
        paramString = paramJSONObject.optString("title");
        paramJSONObject = paramJSONObject.optString("balance_title");
        g.DQ();
        g.DP().Dz().c(ac.a.usw, paramString);
        g.DQ();
        g.DP().Dz().c(ac.a.usx, paramJSONObject);
      }
    }
  }
  
  public final int aEC()
  {
    return 1679;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */