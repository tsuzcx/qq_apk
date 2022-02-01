package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends m
  implements j, ITenpaySave
{
  public boolean Cwx;
  public String Cwy;
  public String dMS;
  public String dMT;
  public String dMU;
  public String dMV;
  public String dMW;
  public String dve;
  private ITenpaySave.RetryPayInfo retryPayInfo;
  
  public e(double paramDouble, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(68396);
    this.dve = null;
    this.Cwx = false;
    this.Cwy = "";
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", com.tencent.mm.wallet_core.ui.e.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    localHashMap.put("bank_type", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(68396);
  }
  
  public final int getFuncId()
  {
    return 1502;
  }
  
  public final ITenpaySave.RetryPayInfo getRetryPayInfo()
  {
    return this.retryPayInfo;
  }
  
  public final int getTenpayCgicmd()
  {
    return 74;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/genpresave";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(68397);
    ad.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(68397);
      return;
    }
    this.dve = paramJSONObject.optString("req_key");
    this.Cwx = "1".equals(paramJSONObject.optString("should_alert"));
    this.Cwy = paramJSONObject.optString("alert_msg");
    if (paramJSONObject.has("real_name_info"))
    {
      paramString = paramJSONObject.optJSONObject("real_name_info");
      ad.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", new Object[] { paramString.toString() });
      this.dMS = paramString.optString("guide_flag");
      this.dMT = paramString.optString("guide_wording");
      this.dMU = paramString.optString("left_button_wording");
      this.dMV = paramString.optString("right_button_wording");
      this.dMW = paramString.optString("upload_credit_url");
    }
    this.retryPayInfo = new ITenpaySave.RetryPayInfo();
    this.retryPayInfo.bk(paramJSONObject);
    AppMethodBeat.o(68397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.e
 * JD-Core Version:    0.7.0.1
 */