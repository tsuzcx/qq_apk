package com.tencent.mm.plugin.wallet.pay.a.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  private String token;
  private Map<String, String> ukq;
  public boolean zPC;
  private Map<String, String> zPD;
  public boolean zPE;
  public Orders zPF;
  public Authen zPG;
  public String zPH;
  public String zPI;
  private String zPJ;
  public int zPK;
  public String zPL;
  public int zPM;
  public JSONArray zPN;
  
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
    this.zPE = false;
    this.zPF = null;
    this.token = null;
    this.zPH = null;
    this.zPI = null;
    this.zPJ = null;
    this.zPK = 0;
    this.zPM = 0;
    this.zPG = paramAuthen;
    this.zPF = paramOrders;
    if (paramAuthen == null)
    {
      paramAuthen = new IllegalArgumentException("authen == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    a(paramOrders, paramAuthen);
    if (paramAuthen.uXi == null)
    {
      paramAuthen = new IllegalArgumentException("authen.payInfo == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    ad.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + paramAuthen.uXi.channel);
    this.ukq = new HashMap();
    this.zPD = new HashMap();
    boolean bool1;
    if ((!paramBoolean) && (!bt.isNullOrNil(this.zPG.Abg)))
    {
      bool1 = true;
      ad.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool1) });
      setPayInfo(paramAuthen.uXi, this.ukq, this.zPD, bool1);
      if (!paramBoolean) {
        break label645;
      }
      this.ukq.put("brief_reg", "1");
      label237:
      this.AfG = paramOrders.AfG;
      this.ukq.put("default_favorcomposedid", paramAuthen.Abp);
      this.ukq.put("favorcomposedid", paramAuthen.Abq);
      this.ukq.put("arrive_type", paramAuthen.Abm);
      this.ukq.put("sms_flag", paramAuthen.Abr);
      this.ukq.put("ban_sms_bind_serial", paramAuthen.Abs);
      this.ukq.put("ban_sms_bank_type", paramAuthen.Abt);
      this.ukq.put("busi_sms_flag", paramAuthen.Abu);
      this.ukq.put("buttontype", paramAuthen.uXi.Coy);
      this.ukq.put("mobile_area", paramAuthen.Abv);
      ad.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[] { Integer.valueOf(paramAuthen.uXi.Coy), Integer.valueOf(this.AfG), paramAuthen.Abv });
      switch (paramAuthen.dtM)
      {
      default: 
        label488:
        aL(this.ukq);
        setRequestData(this.ukq);
        paramOrders = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).ctY();
        if (paramOrders != null) {
          this.zPD.putAll(paramOrders);
        }
        paramOrders = paramAuthen.uXi.CoA;
        if (paramAuthen.uXi.aTo)
        {
          paramByte = 2;
          label553:
          if (paramAuthen.uXi.ApW != 1) {
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
      com.tencent.mm.plugin.wallet.pay.a.b.r(paramOrders, paramByte, paramBoolean);
      if (z.fjX())
      {
        this.zPD.put("uuid_for_bindcard", z.getBindCardUuid());
        this.zPD.put("bindcard_scene", z.fjY());
      }
      setWXRequestData(this.zPD);
      AppMethodBeat.o(69264);
      return;
      bool1 = false;
      break;
      this.ukq.put("passwd", paramAuthen.Abg);
      break label237;
      this.ukq.put("flag", "1");
      this.ukq.put("bank_type", paramAuthen.dca);
      this.ukq.put("true_name", paramAuthen.Aar);
      this.ukq.put("identify_card", paramAuthen.Abh);
      if (paramAuthen.Abi > 0) {
        this.ukq.put("cre_type", paramAuthen.Abi);
      }
      this.ukq.put("mobile_no", paramAuthen.zWw);
      this.ukq.put("bank_card_id", paramAuthen.Abj);
      if (!bt.isNullOrNil(paramAuthen.Abk)) {
        this.ukq.put("cvv2", paramAuthen.Abk);
      }
      if (!bt.isNullOrNil(paramAuthen.Abl)) {
        this.ukq.put("valid_thru", paramAuthen.Abl);
      }
      this.ukq.put("creid_renewal", String.valueOf(paramAuthen.AaB));
      this.ukq.put("birth_date", paramAuthen.AaG);
      this.ukq.put("cre_expire_date", paramAuthen.AaC);
      break label488;
      this.ukq.put("flag", "2");
      this.ukq.put("bank_type", paramAuthen.dca);
      this.ukq.put("h_bind_serial", paramAuthen.uns);
      this.ukq.put("card_tail", paramAuthen.sqX);
      if (!bt.isNullOrNil(paramAuthen.Aar)) {
        this.ukq.put("true_name", paramAuthen.Aar);
      }
      if (!bt.isNullOrNil(paramAuthen.Abh)) {
        this.ukq.put("identify_card", paramAuthen.Abh);
      }
      this.ukq.put("cre_type", paramAuthen.Abi);
      this.ukq.put("mobile_no", paramAuthen.zWw);
      this.ukq.put("bank_card_id", paramAuthen.Abj);
      if (!bt.isNullOrNil(paramAuthen.Abk)) {
        this.ukq.put("cvv2", paramAuthen.Abk);
      }
      if (!bt.isNullOrNil(paramAuthen.Abl)) {
        this.ukq.put("valid_thru", paramAuthen.Abl);
      }
      this.ukq.put("creid_renewal", String.valueOf(paramAuthen.AaB));
      this.ukq.put("birth_date", paramAuthen.AaG);
      this.ukq.put("cre_expire_date", paramAuthen.AaC);
      break label488;
      if (paramAuthen.Abf == 1)
      {
        this.ukq.put("reset_flag", "1");
        if (!bt.isNullOrNil(paramAuthen.zWw)) {
          this.ukq.put("mobile_no", paramAuthen.zWw);
        }
        if (!bt.isNullOrNil(paramAuthen.Abk)) {
          this.ukq.put("cvv2", paramAuthen.Abk);
        }
        if (!bt.isNullOrNil(paramAuthen.Abl)) {
          this.ukq.put("valid_thru", paramAuthen.Abl);
        }
      }
      this.ukq.put("flag", "3");
      this.ukq.put("bank_type", paramAuthen.dca);
      this.ukq.put("bind_serial", paramAuthen.uns);
      break label488;
      this.ukq.put("flag", "4");
      this.ukq.put("bank_type", paramAuthen.dca);
      this.ukq.put("first_name", paramAuthen.Abn);
      this.ukq.put("last_name", paramAuthen.Abo);
      this.ukq.put("country", paramAuthen.country);
      this.ukq.put("area", paramAuthen.evz);
      this.ukq.put("city", paramAuthen.evA);
      this.ukq.put("address", paramAuthen.hdQ);
      this.ukq.put("phone_number", paramAuthen.szk);
      this.ukq.put("zip_code", paramAuthen.iyB);
      this.ukq.put("email", paramAuthen.evs);
      this.ukq.put("bank_card_id", paramAuthen.Abj);
      if (!bt.isNullOrNil(paramAuthen.Abk)) {
        this.ukq.put("cvv2", paramAuthen.Abk);
      }
      if (bt.isNullOrNil(paramAuthen.Abl)) {
        break label488;
      }
      this.ukq.put("valid_thru", paramAuthen.Abl);
      break label488;
      this.ukq.put("flag", "5");
      this.ukq.put("bank_type", paramAuthen.dca);
      this.ukq.put("first_name", paramAuthen.Abn);
      this.ukq.put("last_name", paramAuthen.Abo);
      this.ukq.put("country", paramAuthen.country);
      this.ukq.put("area", paramAuthen.evz);
      this.ukq.put("city", paramAuthen.evA);
      this.ukq.put("address", paramAuthen.hdQ);
      this.ukq.put("phone_number", paramAuthen.szk);
      this.ukq.put("zip_code", paramAuthen.iyB);
      this.ukq.put("email", paramAuthen.evs);
      this.ukq.put("bank_card_id", paramAuthen.Abj);
      if (!bt.isNullOrNil(paramAuthen.Abk)) {
        this.ukq.put("cvv2", paramAuthen.Abk);
      }
      if (!bt.isNullOrNil(paramAuthen.Abl)) {
        this.ukq.put("valid_thru", paramAuthen.Abl);
      }
      this.ukq.put("h_bind_serial", paramAuthen.uns);
      this.ukq.put("card_tail", paramAuthen.sqX);
      break label488;
      if (paramAuthen.Abf == 1)
      {
        this.ukq.put("reset_flag", "1");
        if (!bt.isNullOrNil(paramAuthen.Abk)) {
          this.ukq.put("cvv2", paramAuthen.Abk);
        }
        if (!bt.isNullOrNil(paramAuthen.Abl)) {
          this.ukq.put("valid_thru", paramAuthen.Abl);
        }
      }
      this.ukq.put("phone_number", paramAuthen.zWw);
      this.ukq.put("flag", "6");
      this.ukq.put("bank_type", paramAuthen.dca);
      this.ukq.put("bind_serial", paramAuthen.uns);
      break label488;
      paramByte = 1;
      break label553;
    }
  }
  
  protected void aL(Map<String, String> paramMap) {}
  
  public final boolean dZZ()
  {
    return this.zPG.uXi.ApW == 1;
  }
  
  public final boolean eaa()
  {
    return (this.zPG.uXi.dtb == 11) || (this.zPG.uXi.dtb == 21);
  }
  
  public int getFuncId()
  {
    if (this.zPG.uXi.dtb == 11) {
      return 1610;
    }
    if (this.zPG.uXi.dtb == 21) {
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
    if (this.zPG.uXi.dtb == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
    }
    if (this.zPG.uXi.dtb == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
    }
    return "/cgi-bin/mmpay-bin/tenpay/authen";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69266);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    ad.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + paramInt + " errMsg :" + paramString);
    ad.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[] { this.zPH });
    this.zPE = "1".equals(paramJSONObject.optString("is_free_sms"));
    this.token = paramJSONObject.optString("token");
    this.zPH = paramJSONObject.optString("balance_mobile");
    this.zPI = paramJSONObject.optString("balance_help_url");
    this.zPJ = paramJSONObject.optString("modify_mobile_url");
    paramString = paramJSONObject.optString("bind_serial");
    if (!bt.isNullOrNil(paramString)) {
      ad.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(paramString)));
    }
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.zPF = Orders.a(paramJSONObject, this.zPF);
      paramString = paramJSONObject.optJSONObject("verify_cre_tail_info");
      if (paramString != null)
      {
        this.zPK = paramString.optInt("is_can_verify_tail", 0);
        this.zPL = paramString.optString("verify_tail_wording");
      }
      this.zPM = paramJSONObject.optInt("no_reset_mobile", 0);
      ad.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.zPG.uXi.dtb);
      if (this.zPG.uXi.dtb == 21)
      {
        this.zPN = paramJSONObject.optJSONArray("fetch_charge_show_info");
        g.afB().afk().set(ae.a.FrU, paramJSONObject.optString("charge_rate_version"));
      }
      if ((paramInt != 0) || (this.zPG.uXi.dtb != 39)) {
        break label394;
      }
      ad.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
      com.tencent.mm.plugin.wallet_core.utils.e.bn(paramJSONObject);
    }
    for (;;)
    {
      paramString = com.tencent.mm.wallet_core.a.aMX("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dow.putInt("key_is_clear_failure", this.IeL);
      }
      setPaySuccess(false);
      break;
      label394:
      ad.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:".concat(String.valueOf(paramInt)));
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
        parame = this.zPG.uXi.CoA;
        if (this.zPG.uXi.aTo) {}
        for (;;)
        {
          com.tencent.mm.plugin.wallet.pay.a.b.eL(parame, i);
          com.tencent.mm.plugin.wallet.pay.a.b.bR(this.zPG.uXi.CoA, checkRecSrvResp());
          AppMethodBeat.o(69267);
          return;
          i = 1;
        }
      }
    }
    else
    {
      parame = this.zPG.uXi.CoA;
      if (!this.zPG.uXi.aTo) {
        break label146;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet.pay.a.b.eL(parame, i);
      com.tencent.mm.plugin.wallet.pay.a.b.bR(this.zPG.uXi.CoA, checkRecSrvResp());
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
    this.ukq.put("is_repeat_send", "1");
    setRequestData(this.ukq);
    this.zPC = true;
    AppMethodBeat.o(69265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.b
 * JD-Core Version:    0.7.0.1
 */