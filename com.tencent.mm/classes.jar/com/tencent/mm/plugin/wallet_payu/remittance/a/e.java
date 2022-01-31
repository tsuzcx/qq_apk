package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends a
{
  public int bMC;
  public int bcw;
  public double iHP;
  public String mOZ;
  private String nzq = null;
  public int nzr;
  public int qOA;
  public int qOB;
  public int status;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, 0);
  }
  
  public e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.nzq = paramString1;
    this.bMC = 1;
    this.bcw = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("receiver_name", paramString2);
    localHashMap.put("invalid_time", String.valueOf(paramInt1));
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    this.nzr = paramJSONObject.optInt("pay_time");
    this.iHP = (paramJSONObject.optDouble("total_fee") / 100.0D);
    this.mOZ = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("pay_status");
    this.qOA = paramJSONObject.optInt("refund_time");
    this.qOB = paramJSONObject.optInt("receive_time");
  }
  
  public final int bUM()
  {
    return 25;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.e
 * JD-Core Version:    0.7.0.1
 */