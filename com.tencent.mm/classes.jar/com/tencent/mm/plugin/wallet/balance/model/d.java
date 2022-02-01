package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.i;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
  implements com.tencent.mm.wallet_core.model.j, ITenpaySave
{
  public double OjF;
  public double OjO;
  public boolean UZh;
  public String UZi;
  public b UZj;
  public b UZk;
  public com.tencent.mm.plugin.wallet_core.model.j UZl;
  public String UZm;
  public boolean UZn;
  public a UZo;
  public String UZp;
  public int hAf;
  public String hMy;
  public String igC;
  public String igD;
  public String igE;
  public String igF;
  public String igG;
  private ITenpaySave.RetryPayInfo retryPayInfo;
  
  public d(double paramDouble, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(68394);
    this.hMy = null;
    this.UZh = false;
    this.UZi = "";
    this.OjF = 0.0D;
    this.OjO = 0.0D;
    this.hAf = 0;
    this.UZn = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("total_fee", i.c(String.valueOf(paramDouble), "100", 0, RoundingMode.HALF_UP).toString());
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("operation", String.valueOf(paramInt));
    localHashMap.put("charge_rate_version", (String)h.baE().ban().get(at.a.acUN, ""));
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
    this.hMy = paramJSONObject.optString("req_key");
    this.UZh = "1".equals(paramJSONObject.optString("should_alert"));
    this.UZi = paramJSONObject.optString("alert_msg");
    this.OjF = i.a(paramJSONObject.optString("charge_fee", "0"), "100", 2, RoundingMode.HALF_UP);
    this.OjO = i.a(paramJSONObject.optString("total_fee", "0"), "100", 2, RoundingMode.HALF_UP);
    paramString = paramJSONObject.optJSONObject("first_fetch_info");
    if (paramString != null)
    {
      Log.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
      this.UZj = ah.c(paramString, false);
      paramString = paramJSONObject.optJSONObject("need_charge_fee_info");
      if (paramString == null) {
        break label611;
      }
      Log.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
      this.UZk = ah.c(paramString, false);
    }
    for (;;)
    {
      this.hAf = paramJSONObject.optInt("operation", 0);
      Log.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.OjF + " total_fee:" + this.OjO + " operation:" + this.hAf);
      if (paramJSONObject.has("real_name_info"))
      {
        paramString = paramJSONObject.optJSONObject("real_name_info");
        Log.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", new Object[] { paramString.toString() });
        this.igC = paramString.optString("guide_flag");
        this.igD = paramString.optString("guide_wording");
        this.igE = paramString.optString("left_button_wording");
        this.igF = paramString.optString("right_button_wording");
        this.igG = paramString.optString("upload_credit_url");
      }
      this.UZn = paramJSONObject.optBoolean("need_large_account_tip");
      if ((this.UZn) && (paramJSONObject.has("large_account_tip")))
      {
        Log.i("Micromsg.NetSceneTenpayBalanceFetch", "get large_account_tip");
        paramString = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("large_account_tip");
        paramString.title = localJSONObject.optString("title");
        paramString.content = localJSONObject.optString("content");
        paramString.mdR = localJSONObject.optString("button_name");
        paramString.UZq = localJSONObject.optString("button_jump_url");
        Log.d("Micromsg.NetSceneTenpayBalanceFetch", "parseLargeAccountTipDialog() title:%s content:%s button_name:%s button_jump_url:%s", new Object[] { Util.nullAsNil(paramString.title), Util.nullAsNil(paramString.content), Util.nullAsNil(paramString.mdR), Util.nullAsNil(paramString.UZq) });
        this.UZo = paramString;
      }
      boolean bool2 = this.UZn;
      if (this.UZo == null) {
        bool1 = true;
      }
      Log.i("Micromsg.NetSceneTenpayBalanceFetch", "needLargeAccountTip:%s accountTipDialog:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.retryPayInfo = new ITenpaySave.RetryPayInfo();
      this.retryPayInfo.cq(paramJSONObject);
      this.UZm = paramJSONObject.optString("charge_checkout_wording");
      this.UZl = com.tencent.mm.plugin.wallet_core.model.j.cn(paramJSONObject.optJSONObject("fetch_alert_dialog"));
      paramString = paramJSONObject.optJSONObject("cashier_v2");
      if (paramString != null) {
        this.UZp = paramString.toString();
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
    public String UZq;
    public String content;
    public String mdR;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.d
 * JD-Core Version:    0.7.0.1
 */