package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
    s.erC().db.execSQL("WalletBulletin", "delete from WalletBulletin");
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
    ac.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + paramInt + " " + paramJSONObject);
    if (paramInt == 0)
    {
      x.be(paramJSONObject);
      long l = paramJSONObject.optLong("banner_update_interval", 0L);
      ac.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=".concat(String.valueOf(l)));
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHN, Long.valueOf(l));
      paramString = paramJSONObject.optJSONObject("lbs_info");
      if (paramString != null)
      {
        JSONArray localJSONArray = paramString.optJSONArray("config_array");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          k localk = k.erj();
          if (localJSONArray != null)
          {
            ac.d("MicroMsg.GpsReportHelper", localJSONArray.toString());
            localk.BwI = localJSONArray;
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIE, localJSONArray.toString());
          }
        }
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIF, paramString.optString("title"));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIG, paramString.optString("content"));
      }
      paramJSONObject = paramJSONObject.optJSONObject("realname_info");
      if (paramJSONObject != null)
      {
        paramString = paramJSONObject.optString("title");
        paramJSONObject = paramJSONObject.optString("balance_title");
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIH, paramString);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GII, paramJSONObject);
      }
    }
    AppMethodBeat.o(69901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.g
 * JD-Core Version:    0.7.0.1
 */