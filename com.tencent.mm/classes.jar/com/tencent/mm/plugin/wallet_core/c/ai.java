package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class ai
  extends m
{
  public String Bpg;
  public double Bph;
  public double wKO;
  public String wMV;
  
  public final int getFuncId()
  {
    return 1689;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transfergetchargefee";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69962);
    ac.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ac.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
      AppMethodBeat.o(69962);
      return;
    }
    this.Bpg = paramJSONObject.optString("short_desc");
    this.wMV = paramJSONObject.optString("charge_desc");
    this.Bph = paramJSONObject.optDouble("acc_fee");
    this.wKO = (paramJSONObject.optDouble("remain_fee") / 100.0D);
    AppMethodBeat.o(69962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ai
 * JD-Core Version:    0.7.0.1
 */