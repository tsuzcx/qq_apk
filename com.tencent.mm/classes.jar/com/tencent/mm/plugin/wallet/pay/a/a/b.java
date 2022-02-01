package com.tencent.mm.plugin.wallet.pay.a.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends n
{
  private Map<String, String> AJV;
  public boolean HFE;
  private Map<String, String> HFF;
  public boolean HFG;
  public Orders HFH;
  public Authen HFI;
  public String HFJ;
  public String HFK;
  private String HFL;
  public int HFM;
  public String HFN;
  public int HFO;
  public JSONArray HFP;
  private String token;
  
  public b(Authen paramAuthen, Orders paramOrders)
  {
    this(paramAuthen, paramOrders, false);
  }
  
  public b(Authen paramAuthen, Orders paramOrders, boolean paramBoolean)
  {
    this(paramAuthen, paramOrders, paramBoolean, (byte)0);
  }
  
  private b(Authen paramAuthen, Orders paramOrders, boolean paramBoolean, byte paramByte)
  {
    AppMethodBeat.i(69264);
    this.HFG = false;
    this.HFH = null;
    this.token = null;
    this.HFJ = null;
    this.HFK = null;
    this.HFL = null;
    this.HFM = 0;
    this.HFO = 0;
    this.HFI = paramAuthen;
    this.HFH = paramOrders;
    if (paramAuthen == null)
    {
      paramAuthen = new IllegalArgumentException("authen == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    a(paramOrders, paramAuthen);
    if (paramAuthen.BDB == null)
    {
      paramAuthen = new IllegalArgumentException("authen.payInfo == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    Log.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + paramAuthen.BDB.channel);
    this.AJV = new HashMap();
    this.HFF = new HashMap();
    boolean bool1;
    if ((!paramBoolean) && (!Util.isNullOrNil(this.HFI.HUO)))
    {
      bool1 = true;
      Log.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool1) });
      setPayInfo(paramAuthen.BDB, this.AJV, this.HFF, bool1);
      if (!paramBoolean) {
        break label645;
      }
      this.AJV.put("brief_reg", "1");
      label237:
      this.HZm = paramOrders.HZm;
      this.AJV.put("default_favorcomposedid", paramAuthen.HUX);
      this.AJV.put("favorcomposedid", paramAuthen.HUY);
      this.AJV.put("arrive_type", paramAuthen.HUU);
      this.AJV.put("sms_flag", paramAuthen.HUZ);
      this.AJV.put("ban_sms_bind_serial", paramAuthen.HVa);
      this.AJV.put("ban_sms_bank_type", paramAuthen.HVb);
      this.AJV.put("busi_sms_flag", paramAuthen.HVc);
      this.AJV.put("buttontype", paramAuthen.BDB.Kxz);
      this.AJV.put("mobile_area", paramAuthen.HVd);
      Log.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[] { Integer.valueOf(paramAuthen.BDB.Kxz), Integer.valueOf(this.HZm), paramAuthen.HVd });
      switch (paramAuthen.cSx)
      {
      default: 
        label488:
        aX(this.AJV);
        setRequestData(this.AJV);
        paramOrders = ((com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).dJZ();
        if (paramOrders != null) {
          this.HFF.putAll(paramOrders);
        }
        paramOrders = paramAuthen.BDB.KxB;
        if (paramAuthen.BDB.bex)
        {
          paramByte = 2;
          label553:
          if (paramAuthen.BDB.Ijy != 1) {
            break label2073;
          }
        }
        break;
      }
    }
    label645:
    label2073:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      com.tencent.mm.plugin.wallet.pay.a.b.u(paramOrders, paramByte, paramBoolean);
      if (z.hhq())
      {
        this.HFF.put("uuid_for_bindcard", z.getBindCardUuid());
        this.HFF.put("bindcard_scene", z.hhr());
      }
      setWXRequestData(this.HFF);
      AppMethodBeat.o(69264);
      return;
      bool1 = false;
      break;
      this.AJV.put("passwd", paramAuthen.HUO);
      break label237;
      this.AJV.put("flag", "1");
      this.AJV.put("bank_type", paramAuthen.dDj);
      this.AJV.put("true_name", paramAuthen.HTZ);
      this.AJV.put("identify_card", paramAuthen.HUP);
      if (paramAuthen.HUQ > 0) {
        this.AJV.put("cre_type", paramAuthen.HUQ);
      }
      this.AJV.put("mobile_no", paramAuthen.HQc);
      this.AJV.put("bank_card_id", paramAuthen.HUR);
      if (!Util.isNullOrNil(paramAuthen.HUS)) {
        this.AJV.put("cvv2", paramAuthen.HUS);
      }
      if (!Util.isNullOrNil(paramAuthen.HUT)) {
        this.AJV.put("valid_thru", paramAuthen.HUT);
      }
      this.AJV.put("creid_renewal", String.valueOf(paramAuthen.HUj));
      this.AJV.put("birth_date", paramAuthen.HUo);
      this.AJV.put("cre_expire_date", paramAuthen.HUk);
      break label488;
      this.AJV.put("flag", "2");
      this.AJV.put("bank_type", paramAuthen.dDj);
      this.AJV.put("h_bind_serial", paramAuthen.ANo);
      this.AJV.put("card_tail", paramAuthen.xxN);
      if (!Util.isNullOrNil(paramAuthen.HTZ)) {
        this.AJV.put("true_name", paramAuthen.HTZ);
      }
      if (!Util.isNullOrNil(paramAuthen.HUP)) {
        this.AJV.put("identify_card", paramAuthen.HUP);
      }
      this.AJV.put("cre_type", paramAuthen.HUQ);
      this.AJV.put("mobile_no", paramAuthen.HQc);
      this.AJV.put("bank_card_id", paramAuthen.HUR);
      if (!Util.isNullOrNil(paramAuthen.HUS)) {
        this.AJV.put("cvv2", paramAuthen.HUS);
      }
      if (!Util.isNullOrNil(paramAuthen.HUT)) {
        this.AJV.put("valid_thru", paramAuthen.HUT);
      }
      this.AJV.put("creid_renewal", String.valueOf(paramAuthen.HUj));
      this.AJV.put("birth_date", paramAuthen.HUo);
      this.AJV.put("cre_expire_date", paramAuthen.HUk);
      break label488;
      if (paramAuthen.HUN == 1)
      {
        this.AJV.put("reset_flag", "1");
        if (!Util.isNullOrNil(paramAuthen.HQc)) {
          this.AJV.put("mobile_no", paramAuthen.HQc);
        }
        if (!Util.isNullOrNil(paramAuthen.HUS)) {
          this.AJV.put("cvv2", paramAuthen.HUS);
        }
        if (!Util.isNullOrNil(paramAuthen.HUT)) {
          this.AJV.put("valid_thru", paramAuthen.HUT);
        }
      }
      this.AJV.put("flag", "3");
      this.AJV.put("bank_type", paramAuthen.dDj);
      this.AJV.put("bind_serial", paramAuthen.ANo);
      break label488;
      this.AJV.put("flag", "4");
      this.AJV.put("bank_type", paramAuthen.dDj);
      this.AJV.put("first_name", paramAuthen.HUV);
      this.AJV.put("last_name", paramAuthen.HUW);
      this.AJV.put("country", paramAuthen.country);
      this.AJV.put("area", paramAuthen.fuJ);
      this.AJV.put("city", paramAuthen.fuK);
      this.AJV.put("address", paramAuthen.iUO);
      this.AJV.put("phone_number", paramAuthen.ynV);
      this.AJV.put("zip_code", paramAuthen.ksV);
      this.AJV.put("email", paramAuthen.fuD);
      this.AJV.put("bank_card_id", paramAuthen.HUR);
      if (!Util.isNullOrNil(paramAuthen.HUS)) {
        this.AJV.put("cvv2", paramAuthen.HUS);
      }
      if (Util.isNullOrNil(paramAuthen.HUT)) {
        break label488;
      }
      this.AJV.put("valid_thru", paramAuthen.HUT);
      break label488;
      this.AJV.put("flag", "5");
      this.AJV.put("bank_type", paramAuthen.dDj);
      this.AJV.put("first_name", paramAuthen.HUV);
      this.AJV.put("last_name", paramAuthen.HUW);
      this.AJV.put("country", paramAuthen.country);
      this.AJV.put("area", paramAuthen.fuJ);
      this.AJV.put("city", paramAuthen.fuK);
      this.AJV.put("address", paramAuthen.iUO);
      this.AJV.put("phone_number", paramAuthen.ynV);
      this.AJV.put("zip_code", paramAuthen.ksV);
      this.AJV.put("email", paramAuthen.fuD);
      this.AJV.put("bank_card_id", paramAuthen.HUR);
      if (!Util.isNullOrNil(paramAuthen.HUS)) {
        this.AJV.put("cvv2", paramAuthen.HUS);
      }
      if (!Util.isNullOrNil(paramAuthen.HUT)) {
        this.AJV.put("valid_thru", paramAuthen.HUT);
      }
      this.AJV.put("h_bind_serial", paramAuthen.ANo);
      this.AJV.put("card_tail", paramAuthen.xxN);
      break label488;
      if (paramAuthen.HUN == 1)
      {
        this.AJV.put("reset_flag", "1");
        if (!Util.isNullOrNil(paramAuthen.HUS)) {
          this.AJV.put("cvv2", paramAuthen.HUS);
        }
        if (!Util.isNullOrNil(paramAuthen.HUT)) {
          this.AJV.put("valid_thru", paramAuthen.HUT);
        }
      }
      this.AJV.put("phone_number", paramAuthen.HQc);
      this.AJV.put("flag", "6");
      this.AJV.put("bank_type", paramAuthen.dDj);
      this.AJV.put("bind_serial", paramAuthen.ANo);
      break label488;
      paramByte = 1;
      break label553;
    }
  }
  
  protected void aX(Map<String, String> paramMap) {}
  
  public final boolean fOm()
  {
    return this.HFI.BDB.Ijy == 1;
  }
  
  public final boolean fOn()
  {
    return (this.HFI.BDB.dVv == 11) || (this.HFI.BDB.dVv == 21);
  }
  
  public int getFuncId()
  {
    if (this.HFI.BDB.dVv == 11) {
      return 1610;
    }
    if (this.HFI.BDB.dVv == 21) {
      return 1605;
    }
    return 461;
  }
  
  public int getTenpayCgicmd()
  {
    return 0;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String getUri()
  {
    if (this.HFI.BDB.dVv == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
    }
    if (this.HFI.BDB.dVv == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
    }
    return "/cgi-bin/mmpay-bin/tenpay/authen";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69266);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    Log.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + paramInt + " errMsg :" + paramString);
    Log.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[] { this.HFJ });
    this.HFG = "1".equals(paramJSONObject.optString("is_free_sms"));
    this.token = paramJSONObject.optString("token");
    this.HFJ = paramJSONObject.optString("balance_mobile");
    this.HFK = paramJSONObject.optString("balance_help_url");
    this.HFL = paramJSONObject.optString("modify_mobile_url");
    paramString = paramJSONObject.optString("bind_serial");
    if (!Util.isNullOrNil(paramString)) {
      Log.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(paramString)));
    }
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.HFH = Orders.a(paramJSONObject, this.HFH);
      paramString = paramJSONObject.optJSONObject("verify_cre_tail_info");
      if (paramString != null)
      {
        this.HFM = paramString.optInt("is_can_verify_tail", 0);
        this.HFN = paramString.optString("verify_tail_wording");
      }
      this.HFO = paramJSONObject.optInt("no_reset_mobile", 0);
      Log.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.HFI.BDB.dVv);
      if (this.HFI.BDB.dVv == 21)
      {
        this.HFP = paramJSONObject.optJSONArray("fetch_charge_show_info");
        g.aAh().azQ().set(ar.a.OeW, paramJSONObject.optString("charge_rate_version"));
      }
      if ((paramInt != 0) || (this.HFI.BDB.dVv != 39)) {
        break label394;
      }
      Log.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
      com.tencent.mm.plugin.wallet_core.utils.e.bW(paramJSONObject);
    }
    for (;;)
    {
      paramString = com.tencent.mm.wallet_core.a.bpk("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dQL.putInt("key_is_clear_failure", this.RuW);
      }
      setPaySuccess(false);
      break;
      label394:
      Log.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(69266);
  }
  
  public void onGYNetEnd2(com.tencent.mm.wallet_core.c.e parame, JSONObject paramJSONObject)
  {
    int i = 2;
    AppMethodBeat.i(69267);
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((this.SVR_ERR_TYPE == 0) && (this.SVR_ERR_CODE == 0))
    {
      if (this.isPaySuccess)
      {
        parame = this.HFI.BDB.KxB;
        if (this.HFI.BDB.bex) {}
        for (;;)
        {
          com.tencent.mm.plugin.wallet.pay.a.b.fY(parame, i);
          com.tencent.mm.plugin.wallet.pay.a.b.cD(this.HFI.BDB.KxB, checkRecSrvResp());
          AppMethodBeat.o(69267);
          return;
          i = 1;
        }
      }
    }
    else
    {
      parame = this.HFI.BDB.KxB;
      if (!this.HFI.BDB.bex) {
        break label146;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet.pay.a.b.fY(parame, i);
      com.tencent.mm.plugin.wallet.pay.a.b.cD(this.HFI.BDB.KxB, checkRecSrvResp());
      AppMethodBeat.o(69267);
      return;
      label146:
      i = 1;
    }
  }
  
  public boolean resend()
  {
    AppMethodBeat.i(69265);
    super.resend();
    this.AJV.put("is_repeat_send", "1");
    setRequestData(this.AJV);
    this.HFE = true;
    AppMethodBeat.o(69265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.b
 * JD-Core Version:    0.7.0.1
 */