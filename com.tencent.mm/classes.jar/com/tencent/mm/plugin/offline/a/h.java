package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class h
  extends m
{
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
    throw null;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66293);
    Log.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      Log.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 22L, 1L, true);
      AppMethodBeat.o(66293);
      return;
    }
    Log.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", new Object[] { Integer.valueOf(paramInt), paramString });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 23L, 1L, true);
    AppMethodBeat.o(66293);
  }
  
  public final void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66294);
    if ((parame.agSM == 0) && (parame.errType != 0))
    {
      AppMethodBeat.o(66294);
      throw null;
    }
    AppMethodBeat.o(66294);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.h
 * JD-Core Version:    0.7.0.1
 */