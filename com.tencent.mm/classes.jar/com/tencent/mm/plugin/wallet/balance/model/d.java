package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
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
  implements com.tencent.mm.wallet_core.c.j, ITenpaySave
{
  public b CwA;
  public com.tencent.mm.plugin.wallet_core.model.j CwB;
  public String CwC;
  public boolean CwD;
  public a CwE;
  public String CwF;
  public boolean Cwx;
  public String Cwy;
  public b Cwz;
  public String dMS;
  public String dMT;
  public String dMU;
  public String dMV;
  public String dMW;
  public int dkM;
  public String dve;
  private ITenpaySave.RetryPayInfo retryPayInfo;
  public double xYB;
  public double xYr;
  
  public d(double paramDouble, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(68394);
    this.dve = null;
    this.Cwx = false;
    this.Cwy = "";
    this.xYr = 0.0D;
    this.xYB = 0.0D;
    this.dkM = 0;
    this.CwD = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", com.tencent.mm.wallet_core.ui.e.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("operation", String.valueOf(paramInt));
    localHashMap.put("charge_rate_version", (String)g.ajC().ajl().get(al.a.ICf, ""));
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
    ad.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(68395);
      return;
    }
    this.dve = paramJSONObject.optString("req_key");
    this.Cwx = "1".equals(paramJSONObject.optString("should_alert"));
    this.Cwy = paramJSONObject.optString("alert_msg");
    this.xYr = com.tencent.mm.wallet_core.ui.e.a(paramJSONObject.optString("charge_fee", "0"), "100", 2, RoundingMode.HALF_UP);
    this.xYB = com.tencent.mm.wallet_core.ui.e.a(paramJSONObject.optString("total_fee", "0"), "100", 2, RoundingMode.HALF_UP);
    paramString = paramJSONObject.optJSONObject("first_fetch_info");
    if (paramString != null)
    {
      ad.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
      this.Cwz = com.tencent.mm.plugin.wallet_core.model.ai.b(paramString, false);
      paramString = paramJSONObject.optJSONObject("need_charge_fee_info");
      if (paramString == null) {
        break label611;
      }
      ad.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
      this.CwA = com.tencent.mm.plugin.wallet_core.model.ai.b(paramString, false);
    }
    for (;;)
    {
      this.dkM = paramJSONObject.optInt("operation", 0);
      ad.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.xYr + " total_fee:" + this.xYB + " operation:" + this.dkM);
      if (paramJSONObject.has("real_name_info"))
      {
        paramString = paramJSONObject.optJSONObject("real_name_info");
        ad.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", new Object[] { paramString.toString() });
        this.dMS = paramString.optString("guide_flag");
        this.dMT = paramString.optString("guide_wording");
        this.dMU = paramString.optString("left_button_wording");
        this.dMV = paramString.optString("right_button_wording");
        this.dMW = paramString.optString("upload_credit_url");
      }
      this.CwD = paramJSONObject.optBoolean("need_large_account_tip");
      if ((this.CwD) && (paramJSONObject.has("large_account_tip")))
      {
        ad.i("Micromsg.NetSceneTenpayBalanceFetch", "get large_account_tip");
        paramString = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("large_account_tip");
        paramString.title = localJSONObject.optString("title");
        paramString.content = localJSONObject.optString("content");
        paramString.CwG = localJSONObject.optString("button_name");
        paramString.CwH = localJSONObject.optString("button_jump_url");
        ad.d("Micromsg.NetSceneTenpayBalanceFetch", "parseLargeAccountTipDialog() title:%s content:%s button_name:%s button_jump_url:%s", new Object[] { bt.nullAsNil(paramString.title), bt.nullAsNil(paramString.content), bt.nullAsNil(paramString.CwG), bt.nullAsNil(paramString.CwH) });
        this.CwE = paramString;
      }
      boolean bool2 = this.CwD;
      if (this.CwE == null) {
        bool1 = true;
      }
      ad.i("Micromsg.NetSceneTenpayBalanceFetch", "needLargeAccountTip:%s accountTipDialog:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.retryPayInfo = new ITenpaySave.RetryPayInfo();
      this.retryPayInfo.bk(paramJSONObject);
      this.CwC = paramJSONObject.optString("charge_checkout_wording");
      this.CwB = com.tencent.mm.plugin.wallet_core.model.j.bh(paramJSONObject.optJSONObject("fetch_alert_dialog"));
      paramString = paramJSONObject.optJSONObject("cashier_v2");
      if (paramString != null) {
        this.CwF = paramString.toString();
      }
      AppMethodBeat.o(68395);
      return;
      ad.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
      break;
      label611:
      ad.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
    }
  }
  
  public static final class a
  {
    public String CwG;
    public String CwH;
    public String content;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.d
 * JD-Core Version:    0.7.0.1
 */