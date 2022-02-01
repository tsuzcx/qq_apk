package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public n wyF;
  public com.tencent.mm.plugin.wallet_core.c.ad wyG;
  public e wyH;
  public e wyI;
  
  public q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(174388);
    this.wyF = new n(System.currentTimeMillis(), paramInt1);
    setRequestData(this.wyF.wyE);
    this.wyG = new com.tencent.mm.plugin.wallet_core.c.ad(null, 8);
    this.wyG.CPu = true;
    Map localMap = this.wyG.wyE;
    localMap.put("event_id", String.valueOf(paramInt2));
    localMap.put("event_feature", paramString);
    addRequestData(localMap);
    setWXRequestData(this.wyG.CIl);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(174388);
  }
  
  private static e aI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66317);
    e locale = new e();
    locale.errMsg = aj.getContext().getString(2131765224);
    String str = aj.getContext().getString(2131765224);
    try
    {
      i = paramJSONObject.getInt("retcode");
      paramJSONObject = paramJSONObject.optString("retmsg");
      if (i != 0)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
        if (i != -10089)
        {
          locale.e(1000, i, paramJSONObject, 2);
          AppMethodBeat.o(66317);
          return locale;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + paramJSONObject.toString());
        int i = -10089;
        paramJSONObject = str;
        continue;
        locale.e(1000, 2, paramJSONObject, 2);
        continue;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
      }
    }
  }
  
  public final int getFuncId()
  {
    return 1742;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1742;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineuserbindquery";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66316);
    if (paramInt != 0)
    {
      AppMethodBeat.o(66316);
      return;
    }
    paramString = paramJSONObject.optJSONObject("queryuser_resp");
    this.wyH = aI(paramString);
    this.wyF.onGYNetEnd(this.wyH.errCode, this.wyH.errMsg, paramString);
    paramJSONObject = paramJSONObject.optJSONObject("bindquerynew_resp");
    this.wyI = aI(paramJSONObject);
    this.wyG.onGYNetEnd(this.wyI.errCode, this.wyI.errMsg, paramJSONObject);
    if (paramString != null)
    {
      paramString = paramString.optString("card_list");
      if (paramString != null) {
        a.atK(paramString);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "card_list: %s", new Object[] { paramString });
    }
    AppMethodBeat.o(66316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.q
 * JD-Core Version:    0.7.0.1
 */