package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;
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
  implements i, ITenpaySave
{
  public String cLV;
  public String cLW;
  public String cLX;
  public String cLY;
  public String cLZ;
  public String cwk;
  private ITenpaySave.RetryPayInfo retryPayInfo;
  public boolean tLX;
  public String tLY;
  
  public e(double paramDouble, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(45225);
    this.cwk = null;
    this.tLX = false;
    this.tLY = "";
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", com.tencent.mm.wallet_core.ui.e.b(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    localHashMap.put("bank_type", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(45225);
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
    AppMethodBeat.i(45226);
    ab.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(45226);
      return;
    }
    this.cwk = paramJSONObject.optString("req_key");
    this.tLX = "1".equals(paramJSONObject.optString("should_alert"));
    this.tLY = paramJSONObject.optString("alert_msg");
    if (paramJSONObject.has("real_name_info"))
    {
      paramString = paramJSONObject.optJSONObject("real_name_info");
      ab.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", new Object[] { paramString.toString() });
      this.cLV = paramString.optString("guide_flag");
      this.cLW = paramString.optString("guide_wording");
      this.cLX = paramString.optString("left_button_wording");
      this.cLY = paramString.optString("right_button_wording");
      this.cLZ = paramString.optString("upload_credit_url");
    }
    this.retryPayInfo = new ITenpaySave.RetryPayInfo();
    this.retryPayInfo.aF(paramJSONObject);
    AppMethodBeat.o(45226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.e
 * JD-Core Version:    0.7.0.1
 */