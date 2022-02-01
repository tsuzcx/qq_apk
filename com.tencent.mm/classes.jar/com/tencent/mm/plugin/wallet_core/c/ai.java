package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class ai
  extends m
{
  public String Dha;
  public double Dhb;
  public double yon;
  public String yqu;
  
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
    ae.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ae.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
      AppMethodBeat.o(69962);
      return;
    }
    this.Dha = paramJSONObject.optString("short_desc");
    this.yqu = paramJSONObject.optString("charge_desc");
    this.Dhb = paramJSONObject.optDouble("acc_fee");
    this.yon = (paramJSONObject.optDouble("remain_fee") / 100.0D);
    AppMethodBeat.o(69962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ai
 * JD-Core Version:    0.7.0.1
 */