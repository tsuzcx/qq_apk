package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
  implements com.tencent.mm.wallet_core.c.j, ITenpaySave
{
  public boolean COc;
  public String COd;
  public b COe;
  public b COf;
  public com.tencent.mm.plugin.wallet_core.model.j COg;
  public String COh;
  public boolean COi;
  public a COj;
  public String COk;
  public String dOi;
  public String dOj;
  public String dOk;
  public String dOl;
  public String dOm;
  public int dlO;
  public String dwj;
  private ITenpaySave.RetryPayInfo retryPayInfo;
  public double yoj;
  public double yot;
  
  public d(double paramDouble, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(68394);
    this.dwj = null;
    this.COc = false;
    this.COd = "";
    this.yoj = 0.0D;
    this.yot = 0.0D;
    this.dlO = 0;
    this.COi = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", f.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("operation", String.valueOf(paramInt));
    localHashMap.put("charge_rate_version", (String)g.ajR().ajA().get(am.a.IWE, ""));
    setRequestData(localHashMap);
    AppMethodBeat.o(68394);
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
    AppMethodBeat.i(68395);
    ae.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(68395);
      return;
    }
    this.dwj = paramJSONObject.optString("req_key");
    this.COc = "1".equals(paramJSONObject.optString("should_alert"));
    this.COd = paramJSONObject.optString("alert_msg");
    this.yoj = f.a(paramJSONObject.optString("charge_fee", "0"), "100", 2, RoundingMode.HALF_UP);
    this.yot = f.a(paramJSONObject.optString("total_fee", "0"), "100", 2, RoundingMode.HALF_UP);
    paramString = paramJSONObject.optJSONObject("first_fetch_info");
    if (paramString != null)
    {
      ae.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
      this.COe = ai.b(paramString, false);
      paramString = paramJSONObject.optJSONObject("need_charge_fee_info");
      if (paramString == null) {
        break label611;
      }
      ae.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
      this.COf = ai.b(paramString, false);
    }
    for (;;)
    {
      this.dlO = paramJSONObject.optInt("operation", 0);
      ae.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.yoj + " total_fee:" + this.yot + " operation:" + this.dlO);
      if (paramJSONObject.has("real_name_info"))
      {
        paramString = paramJSONObject.optJSONObject("real_name_info");
        ae.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", new Object[] { paramString.toString() });
        this.dOi = paramString.optString("guide_flag");
        this.dOj = paramString.optString("guide_wording");
        this.dOk = paramString.optString("left_button_wording");
        this.dOl = paramString.optString("right_button_wording");
        this.dOm = paramString.optString("upload_credit_url");
      }
      this.COi = paramJSONObject.optBoolean("need_large_account_tip");
      if ((this.COi) && (paramJSONObject.has("large_account_tip")))
      {
        ae.i("Micromsg.NetSceneTenpayBalanceFetch", "get large_account_tip");
        paramString = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("large_account_tip");
        paramString.title = localJSONObject.optString("title");
        paramString.content = localJSONObject.optString("content");
        paramString.COl = localJSONObject.optString("button_name");
        paramString.COm = localJSONObject.optString("button_jump_url");
        ae.d("Micromsg.NetSceneTenpayBalanceFetch", "parseLargeAccountTipDialog() title:%s content:%s button_name:%s button_jump_url:%s", new Object[] { bu.nullAsNil(paramString.title), bu.nullAsNil(paramString.content), bu.nullAsNil(paramString.COl), bu.nullAsNil(paramString.COm) });
        this.COj = paramString;
      }
      boolean bool2 = this.COi;
      if (this.COj == null) {
        bool1 = true;
      }
      ae.i("Micromsg.NetSceneTenpayBalanceFetch", "needLargeAccountTip:%s accountTipDialog:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.retryPayInfo = new ITenpaySave.RetryPayInfo();
      this.retryPayInfo.bk(paramJSONObject);
      this.COh = paramJSONObject.optString("charge_checkout_wording");
      this.COg = com.tencent.mm.plugin.wallet_core.model.j.bh(paramJSONObject.optJSONObject("fetch_alert_dialog"));
      paramString = paramJSONObject.optJSONObject("cashier_v2");
      if (paramString != null) {
        this.COk = paramString.toString();
      }
      AppMethodBeat.o(68395);
      return;
      ae.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
      break;
      label611:
      ae.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
    }
  }
  
  public static final class a
  {
    public String COl;
    public String COm;
    public String content;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.d
 * JD-Core Version:    0.7.0.1
 */