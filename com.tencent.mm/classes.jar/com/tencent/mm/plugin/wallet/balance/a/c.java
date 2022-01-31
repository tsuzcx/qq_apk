package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.ui.e;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends j
  implements g, ITenpaySave
{
  public String bOT = null;
  public String cdl;
  public String cdm;
  public String cdn;
  public String cdo;
  public String cdp;
  public boolean qfk = false;
  public String qfl = "";
  public double qfo;
  private ITenpaySave.RetryPayInfo qfp;
  
  public c(double paramDouble, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    this.qfo = Math.round(100.0D * paramDouble);
    localHashMap.put("total_fee", e.c(String.valueOf(paramDouble), "100", RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    localHashMap.put("bank_type", paramString3);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1502;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    this.bOT = paramJSONObject.optString("req_key");
    this.qfk = "1".equals(paramJSONObject.optString("should_alert"));
    this.qfl = paramJSONObject.optString("alert_msg");
    if (paramJSONObject.has("real_name_info"))
    {
      paramString = paramJSONObject.optJSONObject("real_name_info");
      y.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", new Object[] { paramString.toString() });
      this.cdl = paramString.optString("guide_flag");
      this.cdm = paramString.optString("guide_wording");
      this.cdn = paramString.optString("left_button_wording");
      this.cdo = paramString.optString("right_button_wording");
      this.cdp = paramString.optString("upload_credit_url");
    }
    this.qfp = new ITenpaySave.RetryPayInfo();
    this.qfp.ar(paramJSONObject);
  }
  
  public final int aEC()
  {
    return 74;
  }
  
  public final ITenpaySave.RetryPayInfo bTh()
  {
    return this.qfp;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/genpresave";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.c
 * JD-Core Version:    0.7.0.1
 */