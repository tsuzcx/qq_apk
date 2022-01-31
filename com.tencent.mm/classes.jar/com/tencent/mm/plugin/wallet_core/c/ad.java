package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import org.json.JSONObject;

public final class ad
  extends j
{
  public String nAm;
  public double nyG;
  public String qrf;
  public double qrg;
  
  public final int HH()
  {
    return 1689;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      y.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
      return;
    }
    this.qrf = paramJSONObject.optString("short_desc");
    this.nAm = paramJSONObject.optString("charge_desc");
    this.qrg = paramJSONObject.optDouble("acc_fee");
    this.nyG = (paramJSONObject.optDouble("remain_fee") / 100.0D);
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transfergetchargefee";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ad
 * JD-Core Version:    0.7.0.1
 */