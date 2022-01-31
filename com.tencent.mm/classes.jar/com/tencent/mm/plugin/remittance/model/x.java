package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends j
{
  public double iHP;
  public boolean llS;
  public String mOZ;
  public int mPH;
  public String mPx;
  private String nzq = null;
  public int nzr;
  private String nzs;
  public String nzt;
  public int nzu;
  public String nzv;
  public String nzw;
  public int nzx;
  public String nzy;
  public String nzz;
  public int status;
  
  public x(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.nzq = paramString1;
    this.mPH = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_id", paramString2);
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1628;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    this.nzr = paramJSONObject.optInt("pay_time");
    this.iHP = (paramJSONObject.optDouble("fee") / 100.0D);
    this.mOZ = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("trans_status");
    this.nzs = paramJSONObject.optString("trans_status_name");
    this.nzu = paramJSONObject.optInt("modify_time");
    this.llS = paramJSONObject.optBoolean("is_payer");
    this.mPx = paramJSONObject.optString("refund_bank_type");
    this.nzv = paramJSONObject.optString("status_desc");
    this.nzw = paramJSONObject.optString("status_supplementary");
    this.nzx = paramJSONObject.optInt("delay_confirm_flag");
    this.nzy = paramJSONObject.optString("banner_content");
    this.nzz = paramJSONObject.optString("banner_url");
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transferquery";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.x
 * JD-Core Version:    0.7.0.1
 */