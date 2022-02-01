package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends m
{
  private boolean dIH;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66292);
    this.dIH = true;
    HashMap localHashMap = new HashMap();
    localHashMap.put("code_ver", paramString1);
    localHashMap.put("cn", paramString2);
    ad.i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", new Object[] { paramString1, paramString2 });
    setRequestData(localHashMap);
    AppMethodBeat.o(66292);
  }
  
  public final int getFuncId()
  {
    return 1686;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1686;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineverifytoken";
  }
  
  public final boolean isBlock()
  {
    return this.dIH;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66293);
    ad.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      ad.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
      g.yhR.idkeyStat(135L, 22L, 1L, true);
      AppMethodBeat.o(66293);
      return;
    }
    ad.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", new Object[] { Integer.valueOf(paramInt), paramString });
    g.yhR.idkeyStat(135L, 23L, 1L, true);
    AppMethodBeat.o(66293);
  }
  
  public final void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66294);
    if ((parame.LxP == 0) && (parame.errType != 0)) {}
    for (this.dIH = false;; this.dIH = true)
    {
      ad.i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", new Object[] { Boolean.valueOf(this.dIH) });
      AppMethodBeat.o(66294);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.f
 * JD-Core Version:    0.7.0.1
 */