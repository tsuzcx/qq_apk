package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class ag
  extends m
{
  public double qjH;
  public String qlI;
  public String ucd;
  public double uce;
  
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
    AppMethodBeat.i(46556);
    ab.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      ab.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
      AppMethodBeat.o(46556);
      return;
    }
    this.ucd = paramJSONObject.optString("short_desc");
    this.qlI = paramJSONObject.optString("charge_desc");
    this.uce = paramJSONObject.optDouble("acc_fee");
    this.qjH = (paramJSONObject.optDouble("remain_fee") / 100.0D);
    AppMethodBeat.o(46556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ag
 * JD-Core Version:    0.7.0.1
 */