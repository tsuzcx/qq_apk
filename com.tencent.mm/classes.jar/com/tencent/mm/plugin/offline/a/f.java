package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends m
{
  private boolean cHT;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43393);
    this.cHT = true;
    HashMap localHashMap = new HashMap();
    localHashMap.put("code_ver", paramString1);
    localHashMap.put("cn", paramString2);
    ab.i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", new Object[] { paramString1, paramString2 });
    setRequestData(localHashMap);
    AppMethodBeat.o(43393);
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
    return this.cHT;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43394);
    ab.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      ab.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
      h.qsU.idkeyStat(135L, 22L, 1L, true);
      AppMethodBeat.o(43394);
      return;
    }
    ab.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", new Object[] { Integer.valueOf(paramInt), paramString });
    h.qsU.idkeyStat(135L, 23L, 1L, true);
    AppMethodBeat.o(43394);
  }
  
  public final void onGYNetEnd2(d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43395);
    if ((paramd.AWM == 0) && (paramd.errType != 0)) {}
    for (this.cHT = false;; this.cHT = true)
    {
      ab.i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", new Object[] { Boolean.valueOf(this.cHT) });
      AppMethodBeat.o(43395);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.f
 * JD-Core Version:    0.7.0.1
 */