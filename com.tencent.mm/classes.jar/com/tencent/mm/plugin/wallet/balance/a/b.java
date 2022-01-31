package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.plugin.wallet_core.model.ab;
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

public final class b
  extends j
  implements g, ITenpaySave
{
  public int bHz = 0;
  public String bOT = null;
  public String cdl;
  public String cdm;
  public String cdn;
  public String cdo;
  public String cdp;
  public double nyC = 0.0D;
  public double nyN = 0.0D;
  public boolean qfk = false;
  public String qfl = "";
  public com.tencent.mm.plugin.wallet_core.model.b qfm;
  public com.tencent.mm.plugin.wallet_core.model.b qfn;
  public double qfo;
  private ITenpaySave.RetryPayInfo qfp;
  
  public b(double paramDouble, String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    this.qfo = Math.round(100.0D * paramDouble);
    localHashMap.put("total_fee", e.c(String.valueOf(paramDouble), "100", RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("operation", String.valueOf(paramInt));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1503;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    this.bOT = paramJSONObject.optString("req_key");
    this.qfk = "1".equals(paramJSONObject.optString("should_alert"));
    this.qfl = paramJSONObject.optString("alert_msg");
    this.nyC = (paramJSONObject.optDouble("charge_fee", 0.0D) / 100.0D);
    this.nyN = (paramJSONObject.optDouble("total_fee", 0.0D) / 100.0D);
    paramString = paramJSONObject.optJSONObject("first_fetch_info");
    if (paramString != null)
    {
      y.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
      this.qfm = ab.a(paramString, false);
      paramString = paramJSONObject.optJSONObject("need_charge_fee_info");
      if (paramString == null) {
        break label327;
      }
      y.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
      this.qfn = ab.a(paramString, false);
    }
    for (;;)
    {
      this.bHz = paramJSONObject.optInt("operation", 0);
      y.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.nyC + " total_fee:" + this.nyN + " operation:" + this.bHz);
      if (paramJSONObject.has("real_name_info"))
      {
        paramString = paramJSONObject.optJSONObject("real_name_info");
        y.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", new Object[] { paramString.toString() });
        this.cdl = paramString.optString("guide_flag");
        this.cdm = paramString.optString("guide_wording");
        this.cdn = paramString.optString("left_button_wording");
        this.cdo = paramString.optString("right_button_wording");
        this.cdp = paramString.optString("upload_credit_url");
      }
      this.qfp = new ITenpaySave.RetryPayInfo();
      this.qfp.ar(paramJSONObject);
      return;
      y.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
      break;
      label327:
      y.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
    }
  }
  
  public final int aEC()
  {
    return 75;
  }
  
  public final ITenpaySave.RetryPayInfo bTh()
  {
    return this.qfp;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.b
 * JD-Core Version:    0.7.0.1
 */