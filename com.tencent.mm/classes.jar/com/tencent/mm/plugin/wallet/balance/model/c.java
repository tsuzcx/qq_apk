package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class c
  extends m
{
  public String dlJ;
  
  public final int getFuncId()
  {
    return 1506;
  }
  
  public final int getTenpayCgicmd()
  {
    return 76;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/verifybind";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(68393);
    ad.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(68393);
      return;
    }
    this.dlJ = paramJSONObject.optString("req_key");
    AppMethodBeat.o(68393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.c
 * JD-Core Version:    0.7.0.1
 */