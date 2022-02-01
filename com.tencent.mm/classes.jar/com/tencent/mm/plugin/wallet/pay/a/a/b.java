package com.tencent.mm.plugin.wallet.pay.a.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public boolean CIk;
  private Map<String, String> CIl;
  public boolean CIm;
  public Orders CIn;
  public Authen CIo;
  public String CIp;
  public String CIq;
  private String CIr;
  public int CIs;
  public String CIt;
  public int CIu;
  public JSONArray CIv;
  private String token;
  private Map<String, String> wyE;
  
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
    this.CIm = false;
    this.CIn = null;
    this.token = null;
    this.CIp = null;
    this.CIq = null;
    this.CIr = null;
    this.CIs = 0;
    this.CIu = 0;
    this.CIo = paramAuthen;
    this.CIn = paramOrders;
    if (paramAuthen == null)
    {
      paramAuthen = new IllegalArgumentException("authen == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    a(paramOrders, paramAuthen);
    if (paramAuthen.xnF == null)
    {
      paramAuthen = new IllegalArgumentException("authen.payInfo == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    ad.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + paramAuthen.xnF.channel);
    this.wyE = new HashMap();
    this.CIl = new HashMap();
    boolean bool1;
    if ((!paramBoolean) && (!bt.isNullOrNil(this.CIo.CTP)))
    {
      bool1 = true;
      ad.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool1) });
      setPayInfo(paramAuthen.xnF, this.wyE, this.CIl, bool1);
      if (!paramBoolean) {
        break label645;
      }
      this.wyE.put("brief_reg", "1");
      label237:
      this.CYt = paramOrders.CYt;
      this.wyE.put("default_favorcomposedid", paramAuthen.CTY);
      this.wyE.put("favorcomposedid", paramAuthen.CTZ);
      this.wyE.put("arrive_type", paramAuthen.CTV);
      this.wyE.put("sms_flag", paramAuthen.CUa);
      this.wyE.put("ban_sms_bind_serial", paramAuthen.CUb);
      this.wyE.put("ban_sms_bank_type", paramAuthen.CUc);
      this.wyE.put("busi_sms_flag", paramAuthen.CUd);
      this.wyE.put("buttontype", paramAuthen.xnF.FlX);
      this.wyE.put("mobile_area", paramAuthen.CUe);
      ad.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[] { Integer.valueOf(paramAuthen.xnF.FlX), Integer.valueOf(this.CYt), paramAuthen.CUe });
      switch (paramAuthen.dDp)
      {
      default: 
        label488:
        aS(this.wyE);
        setRequestData(this.wyE);
        paramOrders = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cPz();
        if (paramOrders != null) {
          this.CIl.putAll(paramOrders);
        }
        paramOrders = paramAuthen.xnF.FlZ;
        if (paramAuthen.xnF.beA)
        {
          paramByte = 2;
          label553:
          if (paramAuthen.xnF.DiI != 1) {
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
      if (z.fRx())
      {
        this.CIl.put("uuid_for_bindcard", z.getBindCardUuid());
        this.CIl.put("bindcard_scene", z.fRy());
      }
      setWXRequestData(this.CIl);
      AppMethodBeat.o(69264);
      return;
      bool1 = false;
      break;
      this.wyE.put("passwd", paramAuthen.CTP);
      break label237;
      this.wyE.put("flag", "1");
      this.wyE.put("bank_type", paramAuthen.dkR);
      this.wyE.put("true_name", paramAuthen.CTa);
      this.wyE.put("identify_card", paramAuthen.CTQ);
      if (paramAuthen.CTR > 0) {
        this.wyE.put("cre_type", paramAuthen.CTR);
      }
      this.wyE.put("mobile_no", paramAuthen.CPf);
      this.wyE.put("bank_card_id", paramAuthen.CTS);
      if (!bt.isNullOrNil(paramAuthen.CTT)) {
        this.wyE.put("cvv2", paramAuthen.CTT);
      }
      if (!bt.isNullOrNil(paramAuthen.CTU)) {
        this.wyE.put("valid_thru", paramAuthen.CTU);
      }
      this.wyE.put("creid_renewal", String.valueOf(paramAuthen.CTk));
      this.wyE.put("birth_date", paramAuthen.CTp);
      this.wyE.put("cre_expire_date", paramAuthen.CTl);
      break label488;
      this.wyE.put("flag", "2");
      this.wyE.put("bank_type", paramAuthen.dkR);
      this.wyE.put("h_bind_serial", paramAuthen.wBI);
      this.wyE.put("card_tail", paramAuthen.tUK);
      if (!bt.isNullOrNil(paramAuthen.CTa)) {
        this.wyE.put("true_name", paramAuthen.CTa);
      }
      if (!bt.isNullOrNil(paramAuthen.CTQ)) {
        this.wyE.put("identify_card", paramAuthen.CTQ);
      }
      this.wyE.put("cre_type", paramAuthen.CTR);
      this.wyE.put("mobile_no", paramAuthen.CPf);
      this.wyE.put("bank_card_id", paramAuthen.CTS);
      if (!bt.isNullOrNil(paramAuthen.CTT)) {
        this.wyE.put("cvv2", paramAuthen.CTT);
      }
      if (!bt.isNullOrNil(paramAuthen.CTU)) {
        this.wyE.put("valid_thru", paramAuthen.CTU);
      }
      this.wyE.put("creid_renewal", String.valueOf(paramAuthen.CTk));
      this.wyE.put("birth_date", paramAuthen.CTp);
      this.wyE.put("cre_expire_date", paramAuthen.CTl);
      break label488;
      if (paramAuthen.CTO == 1)
      {
        this.wyE.put("reset_flag", "1");
        if (!bt.isNullOrNil(paramAuthen.CPf)) {
          this.wyE.put("mobile_no", paramAuthen.CPf);
        }
        if (!bt.isNullOrNil(paramAuthen.CTT)) {
          this.wyE.put("cvv2", paramAuthen.CTT);
        }
        if (!bt.isNullOrNil(paramAuthen.CTU)) {
          this.wyE.put("valid_thru", paramAuthen.CTU);
        }
      }
      this.wyE.put("flag", "3");
      this.wyE.put("bank_type", paramAuthen.dkR);
      this.wyE.put("bind_serial", paramAuthen.wBI);
      break label488;
      this.wyE.put("flag", "4");
      this.wyE.put("bank_type", paramAuthen.dkR);
      this.wyE.put("first_name", paramAuthen.CTW);
      this.wyE.put("last_name", paramAuthen.CTX);
      this.wyE.put("country", paramAuthen.country);
      this.wyE.put("area", paramAuthen.ePu);
      this.wyE.put("city", paramAuthen.ePv);
      this.wyE.put("address", paramAuthen.hWY);
      this.wyE.put("phone_number", paramAuthen.uJH);
      this.wyE.put("zip_code", paramAuthen.jrN);
      this.wyE.put("email", paramAuthen.ePn);
      this.wyE.put("bank_card_id", paramAuthen.CTS);
      if (!bt.isNullOrNil(paramAuthen.CTT)) {
        this.wyE.put("cvv2", paramAuthen.CTT);
      }
      if (bt.isNullOrNil(paramAuthen.CTU)) {
        break label488;
      }
      this.wyE.put("valid_thru", paramAuthen.CTU);
      break label488;
      this.wyE.put("flag", "5");
      this.wyE.put("bank_type", paramAuthen.dkR);
      this.wyE.put("first_name", paramAuthen.CTW);
      this.wyE.put("last_name", paramAuthen.CTX);
      this.wyE.put("country", paramAuthen.country);
      this.wyE.put("area", paramAuthen.ePu);
      this.wyE.put("city", paramAuthen.ePv);
      this.wyE.put("address", paramAuthen.hWY);
      this.wyE.put("phone_number", paramAuthen.uJH);
      this.wyE.put("zip_code", paramAuthen.jrN);
      this.wyE.put("email", paramAuthen.ePn);
      this.wyE.put("bank_card_id", paramAuthen.CTS);
      if (!bt.isNullOrNil(paramAuthen.CTT)) {
        this.wyE.put("cvv2", paramAuthen.CTT);
      }
      if (!bt.isNullOrNil(paramAuthen.CTU)) {
        this.wyE.put("valid_thru", paramAuthen.CTU);
      }
      this.wyE.put("h_bind_serial", paramAuthen.wBI);
      this.wyE.put("card_tail", paramAuthen.tUK);
      break label488;
      if (paramAuthen.CTO == 1)
      {
        this.wyE.put("reset_flag", "1");
        if (!bt.isNullOrNil(paramAuthen.CTT)) {
          this.wyE.put("cvv2", paramAuthen.CTT);
        }
        if (!bt.isNullOrNil(paramAuthen.CTU)) {
          this.wyE.put("valid_thru", paramAuthen.CTU);
        }
      }
      this.wyE.put("phone_number", paramAuthen.CPf);
      this.wyE.put("flag", "6");
      this.wyE.put("bank_type", paramAuthen.dkR);
      this.wyE.put("bind_serial", paramAuthen.wBI);
      break label488;
      paramByte = 1;
      break label553;
    }
  }
  
  protected void aS(Map<String, String> paramMap) {}
  
  public final boolean eDv()
  {
    return this.CIo.xnF.DiI == 1;
  }
  
  public final boolean eDw()
  {
    return (this.CIo.xnF.dCC == 11) || (this.CIo.xnF.dCC == 21);
  }
  
  public int getFuncId()
  {
    if (this.CIo.xnF.dCC == 11) {
      return 1610;
    }
    if (this.CIo.xnF.dCC == 21) {
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
    if (this.CIo.xnF.dCC == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
    }
    if (this.CIo.xnF.dCC == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
    }
    return "/cgi-bin/mmpay-bin/tenpay/authen";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69266);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    ad.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + paramInt + " errMsg :" + paramString);
    ad.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[] { this.CIp });
    this.CIm = "1".equals(paramJSONObject.optString("is_free_sms"));
    this.token = paramJSONObject.optString("token");
    this.CIp = paramJSONObject.optString("balance_mobile");
    this.CIq = paramJSONObject.optString("balance_help_url");
    this.CIr = paramJSONObject.optString("modify_mobile_url");
    paramString = paramJSONObject.optString("bind_serial");
    if (!bt.isNullOrNil(paramString)) {
      ad.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(paramString)));
    }
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.CIn = Orders.a(paramJSONObject, this.CIn);
      paramString = paramJSONObject.optJSONObject("verify_cre_tail_info");
      if (paramString != null)
      {
        this.CIs = paramString.optInt("is_can_verify_tail", 0);
        this.CIt = paramString.optString("verify_tail_wording");
      }
      this.CIu = paramJSONObject.optInt("no_reset_mobile", 0);
      ad.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.CIo.xnF.dCC);
      if (this.CIo.xnF.dCC == 21)
      {
        this.CIv = paramJSONObject.optJSONArray("fetch_charge_show_info");
        g.ajC().ajl().set(al.a.ICf, paramJSONObject.optString("charge_rate_version"));
      }
      if ((paramInt != 0) || (this.CIo.xnF.dCC != 39)) {
        break label394;
      }
      ad.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
      com.tencent.mm.plugin.wallet_core.utils.e.bx(paramJSONObject);
    }
    for (;;)
    {
      paramString = com.tencent.mm.wallet_core.a.aYz("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).dxT.putInt("key_is_clear_failure", this.Lzr);
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
        parame = this.CIo.xnF.FlZ;
        if (this.CIo.xnF.beA) {}
        for (;;)
        {
          com.tencent.mm.plugin.wallet.pay.a.b.fm(parame, i);
          com.tencent.mm.plugin.wallet.pay.a.b.cg(this.CIo.xnF.FlZ, checkRecSrvResp());
          AppMethodBeat.o(69267);
          return;
          i = 1;
        }
      }
    }
    else
    {
      parame = this.CIo.xnF.FlZ;
      if (!this.CIo.xnF.beA) {
        break label146;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet.pay.a.b.fm(parame, i);
      com.tencent.mm.plugin.wallet.pay.a.b.cg(this.CIo.xnF.FlZ, checkRecSrvResp());
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
    this.wyE.put("is_repeat_send", "1");
    setRequestData(this.wyE);
    this.CIk = true;
    AppMethodBeat.o(69265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.b
 * JD-Core Version:    0.7.0.1
 */