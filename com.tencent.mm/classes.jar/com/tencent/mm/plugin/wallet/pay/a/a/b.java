package com.tencent.mm.plugin.wallet.pay.a.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  public boolean CZQ;
  private Map<String, String> CZR;
  public boolean CZS;
  public Orders CZT;
  public Authen CZU;
  public String CZV;
  public String CZW;
  private String CZX;
  public int CZY;
  public String CZZ;
  public int Daa;
  public JSONArray Dab;
  private String token;
  private Map<String, String> wOp;
  
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
    this.CZS = false;
    this.CZT = null;
    this.token = null;
    this.CZV = null;
    this.CZW = null;
    this.CZX = null;
    this.CZY = 0;
    this.Daa = 0;
    this.CZU = paramAuthen;
    this.CZT = paramOrders;
    if (paramAuthen == null)
    {
      paramAuthen = new IllegalArgumentException("authen == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    a(paramOrders, paramAuthen);
    if (paramAuthen.xDC == null)
    {
      paramAuthen = new IllegalArgumentException("authen.payInfo == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    ae.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + paramAuthen.xDC.channel);
    this.wOp = new HashMap();
    this.CZR = new HashMap();
    boolean bool1;
    if ((!paramBoolean) && (!bu.isNullOrNil(this.CZU.Dlv)))
    {
      bool1 = true;
      ae.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool1) });
      setPayInfo(paramAuthen.xDC, this.wOp, this.CZR, bool1);
      if (!paramBoolean) {
        break label645;
      }
      this.wOp.put("brief_reg", "1");
      label237:
      this.DpY = paramOrders.DpY;
      this.wOp.put("default_favorcomposedid", paramAuthen.DlE);
      this.wOp.put("favorcomposedid", paramAuthen.DlF);
      this.wOp.put("arrive_type", paramAuthen.DlB);
      this.wOp.put("sms_flag", paramAuthen.DlG);
      this.wOp.put("ban_sms_bind_serial", paramAuthen.DlH);
      this.wOp.put("ban_sms_bank_type", paramAuthen.DlI);
      this.wOp.put("busi_sms_flag", paramAuthen.DlJ);
      this.wOp.put("buttontype", paramAuthen.xDC.FEv);
      this.wOp.put("mobile_area", paramAuthen.DlK);
      ae.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[] { Integer.valueOf(paramAuthen.xDC.FEv), Integer.valueOf(this.DpY), paramAuthen.DlK });
      switch (paramAuthen.dEu)
      {
      default: 
        label488:
        aY(this.wOp);
        setRequestData(this.wOp);
        paramOrders = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cSe();
        if (paramOrders != null) {
          this.CZR.putAll(paramOrders);
        }
        paramOrders = paramAuthen.xDC.FEx;
        if (paramAuthen.xDC.beA)
        {
          paramByte = 2;
          label553:
          if (paramAuthen.xDC.DAm != 1) {
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
      if (z.fVT())
      {
        this.CZR.put("uuid_for_bindcard", z.getBindCardUuid());
        this.CZR.put("bindcard_scene", z.fVU());
      }
      setWXRequestData(this.CZR);
      AppMethodBeat.o(69264);
      return;
      bool1 = false;
      break;
      this.wOp.put("passwd", paramAuthen.Dlv);
      break label237;
      this.wOp.put("flag", "1");
      this.wOp.put("bank_type", paramAuthen.dlT);
      this.wOp.put("true_name", paramAuthen.DkG);
      this.wOp.put("identify_card", paramAuthen.Dlw);
      if (paramAuthen.Dlx > 0) {
        this.wOp.put("cre_type", paramAuthen.Dlx);
      }
      this.wOp.put("mobile_no", paramAuthen.DgJ);
      this.wOp.put("bank_card_id", paramAuthen.Dly);
      if (!bu.isNullOrNil(paramAuthen.Dlz)) {
        this.wOp.put("cvv2", paramAuthen.Dlz);
      }
      if (!bu.isNullOrNil(paramAuthen.DlA)) {
        this.wOp.put("valid_thru", paramAuthen.DlA);
      }
      this.wOp.put("creid_renewal", String.valueOf(paramAuthen.DkQ));
      this.wOp.put("birth_date", paramAuthen.DkV);
      this.wOp.put("cre_expire_date", paramAuthen.DkR);
      break label488;
      this.wOp.put("flag", "2");
      this.wOp.put("bank_type", paramAuthen.dlT);
      this.wOp.put("h_bind_serial", paramAuthen.wRt);
      this.wOp.put("card_tail", paramAuthen.ufC);
      if (!bu.isNullOrNil(paramAuthen.DkG)) {
        this.wOp.put("true_name", paramAuthen.DkG);
      }
      if (!bu.isNullOrNil(paramAuthen.Dlw)) {
        this.wOp.put("identify_card", paramAuthen.Dlw);
      }
      this.wOp.put("cre_type", paramAuthen.Dlx);
      this.wOp.put("mobile_no", paramAuthen.DgJ);
      this.wOp.put("bank_card_id", paramAuthen.Dly);
      if (!bu.isNullOrNil(paramAuthen.Dlz)) {
        this.wOp.put("cvv2", paramAuthen.Dlz);
      }
      if (!bu.isNullOrNil(paramAuthen.DlA)) {
        this.wOp.put("valid_thru", paramAuthen.DlA);
      }
      this.wOp.put("creid_renewal", String.valueOf(paramAuthen.DkQ));
      this.wOp.put("birth_date", paramAuthen.DkV);
      this.wOp.put("cre_expire_date", paramAuthen.DkR);
      break label488;
      if (paramAuthen.Dlu == 1)
      {
        this.wOp.put("reset_flag", "1");
        if (!bu.isNullOrNil(paramAuthen.DgJ)) {
          this.wOp.put("mobile_no", paramAuthen.DgJ);
        }
        if (!bu.isNullOrNil(paramAuthen.Dlz)) {
          this.wOp.put("cvv2", paramAuthen.Dlz);
        }
        if (!bu.isNullOrNil(paramAuthen.DlA)) {
          this.wOp.put("valid_thru", paramAuthen.DlA);
        }
      }
      this.wOp.put("flag", "3");
      this.wOp.put("bank_type", paramAuthen.dlT);
      this.wOp.put("bind_serial", paramAuthen.wRt);
      break label488;
      this.wOp.put("flag", "4");
      this.wOp.put("bank_type", paramAuthen.dlT);
      this.wOp.put("first_name", paramAuthen.DlC);
      this.wOp.put("last_name", paramAuthen.DlD);
      this.wOp.put("country", paramAuthen.country);
      this.wOp.put("area", paramAuthen.eRf);
      this.wOp.put("city", paramAuthen.eRg);
      this.wOp.put("address", paramAuthen.hZQ);
      this.wOp.put("phone_number", paramAuthen.uVu);
      this.wOp.put("zip_code", paramAuthen.juG);
      this.wOp.put("email", paramAuthen.eQY);
      this.wOp.put("bank_card_id", paramAuthen.Dly);
      if (!bu.isNullOrNil(paramAuthen.Dlz)) {
        this.wOp.put("cvv2", paramAuthen.Dlz);
      }
      if (bu.isNullOrNil(paramAuthen.DlA)) {
        break label488;
      }
      this.wOp.put("valid_thru", paramAuthen.DlA);
      break label488;
      this.wOp.put("flag", "5");
      this.wOp.put("bank_type", paramAuthen.dlT);
      this.wOp.put("first_name", paramAuthen.DlC);
      this.wOp.put("last_name", paramAuthen.DlD);
      this.wOp.put("country", paramAuthen.country);
      this.wOp.put("area", paramAuthen.eRf);
      this.wOp.put("city", paramAuthen.eRg);
      this.wOp.put("address", paramAuthen.hZQ);
      this.wOp.put("phone_number", paramAuthen.uVu);
      this.wOp.put("zip_code", paramAuthen.juG);
      this.wOp.put("email", paramAuthen.eQY);
      this.wOp.put("bank_card_id", paramAuthen.Dly);
      if (!bu.isNullOrNil(paramAuthen.Dlz)) {
        this.wOp.put("cvv2", paramAuthen.Dlz);
      }
      if (!bu.isNullOrNil(paramAuthen.DlA)) {
        this.wOp.put("valid_thru", paramAuthen.DlA);
      }
      this.wOp.put("h_bind_serial", paramAuthen.wRt);
      this.wOp.put("card_tail", paramAuthen.ufC);
      break label488;
      if (paramAuthen.Dlu == 1)
      {
        this.wOp.put("reset_flag", "1");
        if (!bu.isNullOrNil(paramAuthen.Dlz)) {
          this.wOp.put("cvv2", paramAuthen.Dlz);
        }
        if (!bu.isNullOrNil(paramAuthen.DlA)) {
          this.wOp.put("valid_thru", paramAuthen.DlA);
        }
      }
      this.wOp.put("phone_number", paramAuthen.DgJ);
      this.wOp.put("flag", "6");
      this.wOp.put("bank_type", paramAuthen.dlT);
      this.wOp.put("bind_serial", paramAuthen.wRt);
      break label488;
      paramByte = 1;
      break label553;
    }
  }
  
  protected void aY(Map<String, String> paramMap) {}
  
  public final boolean eHc()
  {
    return this.CZU.xDC.DAm == 1;
  }
  
  public final boolean eHd()
  {
    return (this.CZU.xDC.dDH == 11) || (this.CZU.xDC.dDH == 21);
  }
  
  public int getFuncId()
  {
    if (this.CZU.xDC.dDH == 11) {
      return 1610;
    }
    if (this.CZU.xDC.dDH == 21) {
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
    if (this.CZU.xDC.dDH == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
    }
    if (this.CZU.xDC.dDH == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
    }
    return "/cgi-bin/mmpay-bin/tenpay/authen";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69266);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    ae.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + paramInt + " errMsg :" + paramString);
    ae.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[] { this.CZV });
    this.CZS = "1".equals(paramJSONObject.optString("is_free_sms"));
    this.token = paramJSONObject.optString("token");
    this.CZV = paramJSONObject.optString("balance_mobile");
    this.CZW = paramJSONObject.optString("balance_help_url");
    this.CZX = paramJSONObject.optString("modify_mobile_url");
    paramString = paramJSONObject.optString("bind_serial");
    if (!bu.isNullOrNil(paramString)) {
      ae.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(paramString)));
    }
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.CZT = Orders.a(paramJSONObject, this.CZT);
      paramString = paramJSONObject.optJSONObject("verify_cre_tail_info");
      if (paramString != null)
      {
        this.CZY = paramString.optInt("is_can_verify_tail", 0);
        this.CZZ = paramString.optString("verify_tail_wording");
      }
      this.Daa = paramJSONObject.optInt("no_reset_mobile", 0);
      ae.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.CZU.xDC.dDH);
      if (this.CZU.xDC.dDH == 21)
      {
        this.Dab = paramJSONObject.optJSONArray("fetch_charge_show_info");
        g.ajR().ajA().set(am.a.IWE, paramJSONObject.optString("charge_rate_version"));
      }
      if ((paramInt != 0) || (this.CZU.xDC.dDH != 39)) {
        break label394;
      }
      ae.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
      com.tencent.mm.plugin.wallet_core.utils.e.bx(paramJSONObject);
    }
    for (;;)
    {
      paramString = com.tencent.mm.wallet_core.a.bac("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dyY.putInt("key_is_clear_failure", this.LWg);
      }
      setPaySuccess(false);
      break;
      label394:
      ae.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:".concat(String.valueOf(paramInt)));
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
        parame = this.CZU.xDC.FEx;
        if (this.CZU.xDC.beA) {}
        for (;;)
        {
          com.tencent.mm.plugin.wallet.pay.a.b.fv(parame, i);
          com.tencent.mm.plugin.wallet.pay.a.b.ck(this.CZU.xDC.FEx, checkRecSrvResp());
          AppMethodBeat.o(69267);
          return;
          i = 1;
        }
      }
    }
    else
    {
      parame = this.CZU.xDC.FEx;
      if (!this.CZU.xDC.beA) {
        break label146;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet.pay.a.b.fv(parame, i);
      com.tencent.mm.plugin.wallet.pay.a.b.ck(this.CZU.xDC.FEx, checkRecSrvResp());
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
    this.wOp.put("is_repeat_send", "1");
    setRequestData(this.wOp);
    this.CZQ = true;
    AppMethodBeat.o(69265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.b
 * JD-Core Version:    0.7.0.1
 */