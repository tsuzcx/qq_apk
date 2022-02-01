package com.tencent.mm.plugin.wallet.pay.a.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public boolean BhW;
  private Map<String, String> BhX;
  public boolean BhY;
  public Orders BhZ;
  public Authen Bia;
  public String Bib;
  public String Bic;
  private String Bid;
  public int Bie;
  public String Bif;
  public int Big;
  public JSONArray Bih;
  private String token;
  private Map<String, String> vtm;
  
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
    this.BhY = false;
    this.BhZ = null;
    this.token = null;
    this.Bib = null;
    this.Bic = null;
    this.Bid = null;
    this.Bie = 0;
    this.Big = 0;
    this.Bia = paramAuthen;
    this.BhZ = paramOrders;
    if (paramAuthen == null)
    {
      paramAuthen = new IllegalArgumentException("authen == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    a(paramOrders, paramAuthen);
    if (paramAuthen.wfX == null)
    {
      paramAuthen = new IllegalArgumentException("authen.payInfo == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    ac.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + paramAuthen.wfX.channel);
    this.vtm = new HashMap();
    this.BhX = new HashMap();
    boolean bool1;
    if ((!paramBoolean) && (!bs.isNullOrNil(this.Bia.BtA)))
    {
      bool1 = true;
      ac.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool1) });
      setPayInfo(paramAuthen.wfX, this.vtm, this.BhX, bool1);
      if (!paramBoolean) {
        break label645;
      }
      this.vtm.put("brief_reg", "1");
      label237:
      this.Bya = paramOrders.Bya;
      this.vtm.put("default_favorcomposedid", paramAuthen.BtJ);
      this.vtm.put("favorcomposedid", paramAuthen.BtK);
      this.vtm.put("arrive_type", paramAuthen.BtG);
      this.vtm.put("sms_flag", paramAuthen.BtL);
      this.vtm.put("ban_sms_bind_serial", paramAuthen.BtM);
      this.vtm.put("ban_sms_bank_type", paramAuthen.BtN);
      this.vtm.put("busi_sms_flag", paramAuthen.BtO);
      this.vtm.put("buttontype", paramAuthen.wfX.DGQ);
      this.vtm.put("mobile_area", paramAuthen.BtP);
      ac.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[] { Integer.valueOf(paramAuthen.wfX.DGQ), Integer.valueOf(this.Bya), paramAuthen.BtP });
      switch (paramAuthen.drx)
      {
      default: 
        label488:
        aP(this.vtm);
        setRequestData(this.vtm);
        paramOrders = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cHk();
        if (paramOrders != null) {
          this.BhX.putAll(paramOrders);
        }
        paramOrders = paramAuthen.wfX.DGS;
        if (paramAuthen.wfX.aUg)
        {
          paramByte = 2;
          label553:
          if (paramAuthen.wfX.BIq != 1) {
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
      if (z.fAn())
      {
        this.BhX.put("uuid_for_bindcard", z.getBindCardUuid());
        this.BhX.put("bindcard_scene", z.fAo());
      }
      setWXRequestData(this.BhX);
      AppMethodBeat.o(69264);
      return;
      bool1 = false;
      break;
      this.vtm.put("passwd", paramAuthen.BtA);
      break label237;
      this.vtm.put("flag", "1");
      this.vtm.put("bank_type", paramAuthen.cZz);
      this.vtm.put("true_name", paramAuthen.BsL);
      this.vtm.put("identify_card", paramAuthen.BtB);
      if (paramAuthen.BtC > 0) {
        this.vtm.put("cre_type", paramAuthen.BtC);
      }
      this.vtm.put("mobile_no", paramAuthen.BoQ);
      this.vtm.put("bank_card_id", paramAuthen.BtD);
      if (!bs.isNullOrNil(paramAuthen.BtE)) {
        this.vtm.put("cvv2", paramAuthen.BtE);
      }
      if (!bs.isNullOrNil(paramAuthen.BtF)) {
        this.vtm.put("valid_thru", paramAuthen.BtF);
      }
      this.vtm.put("creid_renewal", String.valueOf(paramAuthen.BsV));
      this.vtm.put("birth_date", paramAuthen.Bta);
      this.vtm.put("cre_expire_date", paramAuthen.BsW);
      break label488;
      this.vtm.put("flag", "2");
      this.vtm.put("bank_type", paramAuthen.cZz);
      this.vtm.put("h_bind_serial", paramAuthen.vwo);
      this.vtm.put("card_tail", paramAuthen.tyP);
      if (!bs.isNullOrNil(paramAuthen.BsL)) {
        this.vtm.put("true_name", paramAuthen.BsL);
      }
      if (!bs.isNullOrNil(paramAuthen.BtB)) {
        this.vtm.put("identify_card", paramAuthen.BtB);
      }
      this.vtm.put("cre_type", paramAuthen.BtC);
      this.vtm.put("mobile_no", paramAuthen.BoQ);
      this.vtm.put("bank_card_id", paramAuthen.BtD);
      if (!bs.isNullOrNil(paramAuthen.BtE)) {
        this.vtm.put("cvv2", paramAuthen.BtE);
      }
      if (!bs.isNullOrNil(paramAuthen.BtF)) {
        this.vtm.put("valid_thru", paramAuthen.BtF);
      }
      this.vtm.put("creid_renewal", String.valueOf(paramAuthen.BsV));
      this.vtm.put("birth_date", paramAuthen.Bta);
      this.vtm.put("cre_expire_date", paramAuthen.BsW);
      break label488;
      if (paramAuthen.Btz == 1)
      {
        this.vtm.put("reset_flag", "1");
        if (!bs.isNullOrNil(paramAuthen.BoQ)) {
          this.vtm.put("mobile_no", paramAuthen.BoQ);
        }
        if (!bs.isNullOrNil(paramAuthen.BtE)) {
          this.vtm.put("cvv2", paramAuthen.BtE);
        }
        if (!bs.isNullOrNil(paramAuthen.BtF)) {
          this.vtm.put("valid_thru", paramAuthen.BtF);
        }
      }
      this.vtm.put("flag", "3");
      this.vtm.put("bank_type", paramAuthen.cZz);
      this.vtm.put("bind_serial", paramAuthen.vwo);
      break label488;
      this.vtm.put("flag", "4");
      this.vtm.put("bank_type", paramAuthen.cZz);
      this.vtm.put("first_name", paramAuthen.BtH);
      this.vtm.put("last_name", paramAuthen.BtI);
      this.vtm.put("country", paramAuthen.country);
      this.vtm.put("area", paramAuthen.exV);
      this.vtm.put("city", paramAuthen.exW);
      this.vtm.put("address", paramAuthen.hEt);
      this.vtm.put("phone_number", paramAuthen.tGU);
      this.vtm.put("zip_code", paramAuthen.iYE);
      this.vtm.put("email", paramAuthen.exO);
      this.vtm.put("bank_card_id", paramAuthen.BtD);
      if (!bs.isNullOrNil(paramAuthen.BtE)) {
        this.vtm.put("cvv2", paramAuthen.BtE);
      }
      if (bs.isNullOrNil(paramAuthen.BtF)) {
        break label488;
      }
      this.vtm.put("valid_thru", paramAuthen.BtF);
      break label488;
      this.vtm.put("flag", "5");
      this.vtm.put("bank_type", paramAuthen.cZz);
      this.vtm.put("first_name", paramAuthen.BtH);
      this.vtm.put("last_name", paramAuthen.BtI);
      this.vtm.put("country", paramAuthen.country);
      this.vtm.put("area", paramAuthen.exV);
      this.vtm.put("city", paramAuthen.exW);
      this.vtm.put("address", paramAuthen.hEt);
      this.vtm.put("phone_number", paramAuthen.tGU);
      this.vtm.put("zip_code", paramAuthen.iYE);
      this.vtm.put("email", paramAuthen.exO);
      this.vtm.put("bank_card_id", paramAuthen.BtD);
      if (!bs.isNullOrNil(paramAuthen.BtE)) {
        this.vtm.put("cvv2", paramAuthen.BtE);
      }
      if (!bs.isNullOrNil(paramAuthen.BtF)) {
        this.vtm.put("valid_thru", paramAuthen.BtF);
      }
      this.vtm.put("h_bind_serial", paramAuthen.vwo);
      this.vtm.put("card_tail", paramAuthen.tyP);
      break label488;
      if (paramAuthen.Btz == 1)
      {
        this.vtm.put("reset_flag", "1");
        if (!bs.isNullOrNil(paramAuthen.BtE)) {
          this.vtm.put("cvv2", paramAuthen.BtE);
        }
        if (!bs.isNullOrNil(paramAuthen.BtF)) {
          this.vtm.put("valid_thru", paramAuthen.BtF);
        }
      }
      this.vtm.put("phone_number", paramAuthen.BoQ);
      this.vtm.put("flag", "6");
      this.vtm.put("bank_type", paramAuthen.cZz);
      this.vtm.put("bind_serial", paramAuthen.vwo);
      break label488;
      paramByte = 1;
      break label553;
    }
  }
  
  protected void aP(Map<String, String> paramMap) {}
  
  public final boolean epv()
  {
    return this.Bia.wfX.BIq == 1;
  }
  
  public final boolean epw()
  {
    return (this.Bia.wfX.dqL == 11) || (this.Bia.wfX.dqL == 21);
  }
  
  public int getFuncId()
  {
    if (this.Bia.wfX.dqL == 11) {
      return 1610;
    }
    if (this.Bia.wfX.dqL == 21) {
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
    if (this.Bia.wfX.dqL == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
    }
    if (this.Bia.wfX.dqL == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
    }
    return "/cgi-bin/mmpay-bin/tenpay/authen";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69266);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    ac.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + paramInt + " errMsg :" + paramString);
    ac.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[] { this.Bib });
    this.BhY = "1".equals(paramJSONObject.optString("is_free_sms"));
    this.token = paramJSONObject.optString("token");
    this.Bib = paramJSONObject.optString("balance_mobile");
    this.Bic = paramJSONObject.optString("balance_help_url");
    this.Bid = paramJSONObject.optString("modify_mobile_url");
    paramString = paramJSONObject.optString("bind_serial");
    if (!bs.isNullOrNil(paramString)) {
      ac.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(paramString)));
    }
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.BhZ = Orders.a(paramJSONObject, this.BhZ);
      paramString = paramJSONObject.optJSONObject("verify_cre_tail_info");
      if (paramString != null)
      {
        this.Bie = paramString.optInt("is_can_verify_tail", 0);
        this.Bif = paramString.optString("verify_tail_wording");
      }
      this.Big = paramJSONObject.optInt("no_reset_mobile", 0);
      ac.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.Bia.wfX.dqL);
      if (this.Bia.wfX.dqL == 21)
      {
        this.Bih = paramJSONObject.optJSONArray("fetch_charge_show_info");
        g.agR().agA().set(ah.a.GPK, paramJSONObject.optString("charge_rate_version"));
      }
      if ((paramInt != 0) || (this.Bia.wfX.dqL != 39)) {
        break label394;
      }
      ac.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
      com.tencent.mm.plugin.wallet_core.utils.e.bo(paramJSONObject);
    }
    for (;;)
    {
      paramString = com.tencent.mm.wallet_core.a.aSA("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dmf.putInt("key_is_clear_failure", this.JGn);
      }
      setPaySuccess(false);
      break;
      label394:
      ac.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:".concat(String.valueOf(paramInt)));
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
        parame = this.Bia.wfX.DGS;
        if (this.Bia.wfX.aUg) {}
        for (;;)
        {
          com.tencent.mm.plugin.wallet.pay.a.b.eT(parame, i);
          com.tencent.mm.plugin.wallet.pay.a.b.bY(this.Bia.wfX.DGS, checkRecSrvResp());
          AppMethodBeat.o(69267);
          return;
          i = 1;
        }
      }
    }
    else
    {
      parame = this.Bia.wfX.DGS;
      if (!this.Bia.wfX.aUg) {
        break label146;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet.pay.a.b.eT(parame, i);
      com.tencent.mm.plugin.wallet.pay.a.b.bY(this.Bia.wfX.DGS, checkRecSrvResp());
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
    this.vtm.put("is_repeat_send", "1");
    setRequestData(this.vtm);
    this.BhW = true;
    AppMethodBeat.o(69265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.b
 * JD-Core Version:    0.7.0.1
 */