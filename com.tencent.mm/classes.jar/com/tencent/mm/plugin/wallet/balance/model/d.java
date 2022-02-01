package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  public double CoZ;
  public double Cpj;
  public boolean HsT;
  public String HsU;
  public b HsV;
  public b HsW;
  public com.tencent.mm.plugin.wallet_core.model.j HsX;
  public String HsY;
  public boolean HsZ;
  public a Hta;
  public String Htb;
  public int dDe;
  public String dNQ;
  public String egd;
  public String ege;
  public String egf;
  public String egg;
  public String egh;
  private ITenpaySave.RetryPayInfo retryPayInfo;
  
  public d(double paramDouble, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(68394);
    this.dNQ = null;
    this.HsT = false;
    this.HsU = "";
    this.CoZ = 0.0D;
    this.Cpj = 0.0D;
    this.dDe = 0;
    this.HsZ = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", f.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("operation", String.valueOf(paramInt));
    localHashMap.put("charge_rate_version", (String)g.aAh().azQ().get(ar.a.OeW, ""));
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
    Log.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(68395);
      return;
    }
    this.dNQ = paramJSONObject.optString("req_key");
    this.HsT = "1".equals(paramJSONObject.optString("should_alert"));
    this.HsU = paramJSONObject.optString("alert_msg");
    this.CoZ = f.a(paramJSONObject.optString("charge_fee", "0"), "100", 2, RoundingMode.HALF_UP);
    this.Cpj = f.a(paramJSONObject.optString("total_fee", "0"), "100", 2, RoundingMode.HALF_UP);
    paramString = paramJSONObject.optJSONObject("first_fetch_info");
    if (paramString != null)
    {
      Log.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
      this.HsV = ai.c(paramString, false);
      paramString = paramJSONObject.optJSONObject("need_charge_fee_info");
      if (paramString == null) {
        break label611;
      }
      Log.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
      this.HsW = ai.c(paramString, false);
    }
    for (;;)
    {
      this.dDe = paramJSONObject.optInt("operation", 0);
      Log.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.CoZ + " total_fee:" + this.Cpj + " operation:" + this.dDe);
      if (paramJSONObject.has("real_name_info"))
      {
        paramString = paramJSONObject.optJSONObject("real_name_info");
        Log.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", new Object[] { paramString.toString() });
        this.egd = paramString.optString("guide_flag");
        this.ege = paramString.optString("guide_wording");
        this.egf = paramString.optString("left_button_wording");
        this.egg = paramString.optString("right_button_wording");
        this.egh = paramString.optString("upload_credit_url");
      }
      this.HsZ = paramJSONObject.optBoolean("need_large_account_tip");
      if ((this.HsZ) && (paramJSONObject.has("large_account_tip")))
      {
        Log.i("Micromsg.NetSceneTenpayBalanceFetch", "get large_account_tip");
        paramString = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("large_account_tip");
        paramString.title = localJSONObject.optString("title");
        paramString.content = localJSONObject.optString("content");
        paramString.gTt = localJSONObject.optString("button_name");
        paramString.Htc = localJSONObject.optString("button_jump_url");
        Log.d("Micromsg.NetSceneTenpayBalanceFetch", "parseLargeAccountTipDialog() title:%s content:%s button_name:%s button_jump_url:%s", new Object[] { Util.nullAsNil(paramString.title), Util.nullAsNil(paramString.content), Util.nullAsNil(paramString.gTt), Util.nullAsNil(paramString.Htc) });
        this.Hta = paramString;
      }
      boolean bool2 = this.HsZ;
      if (this.Hta == null) {
        bool1 = true;
      }
      Log.i("Micromsg.NetSceneTenpayBalanceFetch", "needLargeAccountTip:%s accountTipDialog:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.retryPayInfo = new ITenpaySave.RetryPayInfo();
      this.retryPayInfo.bK(paramJSONObject);
      this.HsY = paramJSONObject.optString("charge_checkout_wording");
      this.HsX = com.tencent.mm.plugin.wallet_core.model.j.bH(paramJSONObject.optJSONObject("fetch_alert_dialog"));
      paramString = paramJSONObject.optJSONObject("cashier_v2");
      if (paramString != null) {
        this.Htb = paramString.toString();
      }
      AppMethodBeat.o(68395);
      return;
      Log.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
      break;
      label611:
      Log.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
    }
  }
  
  public static final class a
  {
    public String Htc;
    public String content;
    public String gTt;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.d
 * JD-Core Version:    0.7.0.1
 */