package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.c;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
  implements i, ITenpaySave
{
  public String cLV;
  public String cLW;
  public String cLX;
  public String cLY;
  public String cLZ;
  public int coO;
  public String cwk;
  public double qjD;
  public double qjN;
  private ITenpaySave.RetryPayInfo retryPayInfo;
  public boolean tLX;
  public String tLY;
  public c tLZ;
  public c tMa;
  public l tMb;
  public String tMc;
  public boolean tMd;
  public d.a tMe;
  public String tMf;
  
  public d(double paramDouble, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(45223);
    this.cwk = null;
    this.tLX = false;
    this.tLY = "";
    this.qjD = 0.0D;
    this.qjN = 0.0D;
    this.coO = 0;
    this.tMd = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", com.tencent.mm.wallet_core.ui.e.b(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("operation", String.valueOf(paramInt));
    localHashMap.put("charge_rate_version", (String)g.RL().Ru().get(ac.a.yIW, ""));
    setRequestData(localHashMap);
    AppMethodBeat.o(45223);
  }
  
  public final int getFuncId()
  {
    return 1503;
  }
  
  public final ITenpaySave.RetryPayInfo getRetryPayInfo()
  {
    return this.retryPayInfo;
  }
  
  public final int getTenpayCgicmd()
  {
    return 75;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    boolean bool1 = false;
    AppMethodBeat.i(45224);
    ab.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(45224);
      return;
    }
    this.cwk = paramJSONObject.optString("req_key");
    this.tLX = "1".equals(paramJSONObject.optString("should_alert"));
    this.tLY = paramJSONObject.optString("alert_msg");
    this.qjD = com.tencent.mm.wallet_core.ui.e.b(paramJSONObject.optString("charge_fee", "0"), "100", RoundingMode.HALF_UP);
    this.qjN = com.tencent.mm.wallet_core.ui.e.b(paramJSONObject.optString("total_fee", "0"), "100", RoundingMode.HALF_UP);
    paramString = paramJSONObject.optJSONObject("first_fetch_info");
    if (paramString != null)
    {
      ab.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
      this.tLZ = ah.a(paramString, false);
      paramString = paramJSONObject.optJSONObject("need_charge_fee_info");
      if (paramString == null) {
        break label609;
      }
      ab.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
      this.tMa = ah.a(paramString, false);
    }
    for (;;)
    {
      this.coO = paramJSONObject.optInt("operation", 0);
      ab.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.qjD + " total_fee:" + this.qjN + " operation:" + this.coO);
      if (paramJSONObject.has("real_name_info"))
      {
        paramString = paramJSONObject.optJSONObject("real_name_info");
        ab.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", new Object[] { paramString.toString() });
        this.cLV = paramString.optString("guide_flag");
        this.cLW = paramString.optString("guide_wording");
        this.cLX = paramString.optString("left_button_wording");
        this.cLY = paramString.optString("right_button_wording");
        this.cLZ = paramString.optString("upload_credit_url");
      }
      this.tMd = paramJSONObject.optBoolean("need_large_account_tip");
      if ((this.tMd) && (paramJSONObject.has("large_account_tip")))
      {
        ab.i("Micromsg.NetSceneTenpayBalanceFetch", "get large_account_tip");
        paramString = new d.a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("large_account_tip");
        paramString.title = localJSONObject.optString("title");
        paramString.content = localJSONObject.optString("content");
        paramString.tMg = localJSONObject.optString("button_name");
        paramString.tMh = localJSONObject.optString("button_jump_url");
        ab.d("Micromsg.NetSceneTenpayBalanceFetch", "parseLargeAccountTipDialog() title:%s content:%s button_name:%s button_jump_url:%s", new Object[] { bo.nullAsNil(paramString.title), bo.nullAsNil(paramString.content), bo.nullAsNil(paramString.tMg), bo.nullAsNil(paramString.tMh) });
        this.tMe = paramString;
      }
      boolean bool2 = this.tMd;
      if (this.tMe == null) {
        bool1 = true;
      }
      ab.i("Micromsg.NetSceneTenpayBalanceFetch", "needLargeAccountTip:%s accountTipDialog:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.retryPayInfo = new ITenpaySave.RetryPayInfo();
      this.retryPayInfo.aF(paramJSONObject);
      this.tMc = paramJSONObject.optString("charge_checkout_wording");
      this.tMb = l.aD(paramJSONObject.optJSONObject("fetch_alert_dialog"));
      paramString = paramJSONObject.optJSONObject("cashier_v2");
      if (paramString != null) {
        this.tMf = paramString.toString();
      }
      AppMethodBeat.o(45224);
      return;
      ab.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
      break;
      label609:
      ab.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.d
 * JD-Core Version:    0.7.0.1
 */