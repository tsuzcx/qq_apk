package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public boolean AWo;
  public String AWp;
  public b AWq;
  public b AWr;
  public com.tencent.mm.plugin.wallet_core.model.j AWs;
  public String AWt;
  public boolean AWu;
  public a AWv;
  public String AWw;
  public int cZu;
  public String dAF;
  public String dAG;
  public String dAH;
  public String dAI;
  public String dAJ;
  public String djr;
  private ITenpaySave.RetryPayInfo retryPayInfo;
  public double wKK;
  public double wKU;
  
  public d(double paramDouble, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(68394);
    this.djr = null;
    this.AWo = false;
    this.AWp = "";
    this.wKK = 0.0D;
    this.wKU = 0.0D;
    this.cZu = 0;
    this.AWu = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", com.tencent.mm.wallet_core.ui.e.b(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("operation", String.valueOf(paramInt));
    localHashMap.put("charge_rate_version", (String)g.agR().agA().get(ah.a.GPK, ""));
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
    ac.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(68395);
      return;
    }
    this.djr = paramJSONObject.optString("req_key");
    this.AWo = "1".equals(paramJSONObject.optString("should_alert"));
    this.AWp = paramJSONObject.optString("alert_msg");
    this.wKK = com.tencent.mm.wallet_core.ui.e.b(paramJSONObject.optString("charge_fee", "0"), "100", RoundingMode.HALF_UP);
    this.wKU = com.tencent.mm.wallet_core.ui.e.b(paramJSONObject.optString("total_fee", "0"), "100", RoundingMode.HALF_UP);
    paramString = paramJSONObject.optJSONObject("first_fetch_info");
    if (paramString != null)
    {
      ac.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
      this.AWq = ah.b(paramString, false);
      paramString = paramJSONObject.optJSONObject("need_charge_fee_info");
      if (paramString == null) {
        break label609;
      }
      ac.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
      this.AWr = ah.b(paramString, false);
    }
    for (;;)
    {
      this.cZu = paramJSONObject.optInt("operation", 0);
      ac.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.wKK + " total_fee:" + this.wKU + " operation:" + this.cZu);
      if (paramJSONObject.has("real_name_info"))
      {
        paramString = paramJSONObject.optJSONObject("real_name_info");
        ac.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", new Object[] { paramString.toString() });
        this.dAF = paramString.optString("guide_flag");
        this.dAG = paramString.optString("guide_wording");
        this.dAH = paramString.optString("left_button_wording");
        this.dAI = paramString.optString("right_button_wording");
        this.dAJ = paramString.optString("upload_credit_url");
      }
      this.AWu = paramJSONObject.optBoolean("need_large_account_tip");
      if ((this.AWu) && (paramJSONObject.has("large_account_tip")))
      {
        ac.i("Micromsg.NetSceneTenpayBalanceFetch", "get large_account_tip");
        paramString = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("large_account_tip");
        paramString.title = localJSONObject.optString("title");
        paramString.content = localJSONObject.optString("content");
        paramString.AWx = localJSONObject.optString("button_name");
        paramString.AWy = localJSONObject.optString("button_jump_url");
        ac.d("Micromsg.NetSceneTenpayBalanceFetch", "parseLargeAccountTipDialog() title:%s content:%s button_name:%s button_jump_url:%s", new Object[] { bs.nullAsNil(paramString.title), bs.nullAsNil(paramString.content), bs.nullAsNil(paramString.AWx), bs.nullAsNil(paramString.AWy) });
        this.AWv = paramString;
      }
      boolean bool2 = this.AWu;
      if (this.AWv == null) {
        bool1 = true;
      }
      ac.i("Micromsg.NetSceneTenpayBalanceFetch", "needLargeAccountTip:%s accountTipDialog:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.retryPayInfo = new ITenpaySave.RetryPayInfo();
      this.retryPayInfo.bb(paramJSONObject);
      this.AWt = paramJSONObject.optString("charge_checkout_wording");
      this.AWs = com.tencent.mm.plugin.wallet_core.model.j.aZ(paramJSONObject.optJSONObject("fetch_alert_dialog"));
      paramString = paramJSONObject.optJSONObject("cashier_v2");
      if (paramString != null) {
        this.AWw = paramString.toString();
      }
      AppMethodBeat.o(68395);
      return;
      ac.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
      break;
      label609:
      ac.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
    }
  }
  
  public static final class a
  {
    public String AWx;
    public String AWy;
    public String content;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.d
 * JD-Core Version:    0.7.0.1
 */