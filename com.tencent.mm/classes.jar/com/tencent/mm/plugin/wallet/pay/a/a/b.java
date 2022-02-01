package com.tencent.mm.plugin.wallet.pay.a.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.utils.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.aa;
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
  private Map<String, String> Kvm;
  public boolean VmI;
  private Map<String, String> VmJ;
  public boolean VmK;
  public Orders VmL;
  public Authen VmM;
  public String VmN;
  public String VmO;
  private String VmP;
  public int VmQ;
  public String VmR;
  public int VmS;
  public JSONArray VmT;
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
    this.VmK = false;
    this.VmL = null;
    this.token = null;
    this.VmN = null;
    this.VmO = null;
    this.VmP = null;
    this.VmQ = 0;
    this.VmS = 0;
    this.VmM = paramAuthen;
    this.VmL = paramOrders;
    if (paramAuthen == null)
    {
      paramAuthen = new IllegalArgumentException("authen == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    a(paramOrders, paramAuthen);
    if (paramAuthen.Nxi == null)
    {
      paramAuthen = new IllegalArgumentException("authen.payInfo == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    Log.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + paramAuthen.Nxi.channel);
    this.Kvm = new HashMap();
    this.VmJ = new HashMap();
    boolean bool1;
    if ((!paramBoolean) && (!Util.isNullOrNil(this.VmM.VCA)))
    {
      bool1 = true;
      Log.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool1) });
      setPayInfo(paramAuthen.Nxi, this.Kvm, this.VmJ, bool1);
      if (!paramBoolean) {
        break label645;
      }
      this.Kvm.put("brief_reg", "1");
      label237:
      this.VHg = paramOrders.VHg;
      this.Kvm.put("default_favorcomposedid", paramAuthen.VCJ);
      this.Kvm.put("favorcomposedid", paramAuthen.VCK);
      this.Kvm.put("arrive_type", paramAuthen.VCG);
      this.Kvm.put("sms_flag", paramAuthen.VCL);
      this.Kvm.put("ban_sms_bind_serial", paramAuthen.VCM);
      this.Kvm.put("ban_sms_bank_type", paramAuthen.VCN);
      this.Kvm.put("busi_sms_flag", paramAuthen.VCO);
      this.Kvm.put("buttontype", paramAuthen.Nxi.YvL);
      this.Kvm.put("mobile_area", paramAuthen.VCP);
      Log.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[] { Integer.valueOf(paramAuthen.Nxi.YvL), Integer.valueOf(this.VHg), paramAuthen.VCP });
      switch (paramAuthen.eQp)
      {
      default: 
        label488:
        bi(this.Kvm);
        setRequestData(this.Kvm);
        paramOrders = ((com.tencent.mm.plugin.fingerprint.c.a)h.ax(com.tencent.mm.plugin.fingerprint.c.a.class)).ftB();
        if (paramOrders != null) {
          this.VmJ.putAll(paramOrders);
        }
        paramOrders = paramAuthen.Nxi.YvN;
        if (paramAuthen.Nxi.cHU)
        {
          paramByte = 2;
          label553:
          if (paramAuthen.Nxi.VSv != 1) {
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
      com.tencent.mm.plugin.wallet.pay.a.b.A(paramOrders, paramByte, paramBoolean);
      if (aa.jOO())
      {
        this.VmJ.put("uuid_for_bindcard", aa.getBindCardUuid());
        this.VmJ.put("bindcard_scene", aa.jOP());
      }
      setWXRequestData(this.VmJ);
      AppMethodBeat.o(69264);
      return;
      bool1 = false;
      break;
      this.Kvm.put("passwd", paramAuthen.VCA);
      break label237;
      this.Kvm.put("flag", "1");
      this.Kvm.put("bank_type", paramAuthen.hAk);
      this.Kvm.put("true_name", paramAuthen.VBL);
      this.Kvm.put("identify_card", paramAuthen.VCB);
      if (paramAuthen.VCC > 0) {
        this.Kvm.put("cre_type", paramAuthen.VCC);
      }
      this.Kvm.put("mobile_no", paramAuthen.VxX);
      this.Kvm.put("bank_card_id", paramAuthen.VCD);
      if (!Util.isNullOrNil(paramAuthen.VCE)) {
        this.Kvm.put("cvv2", paramAuthen.VCE);
      }
      if (!Util.isNullOrNil(paramAuthen.VCF)) {
        this.Kvm.put("valid_thru", paramAuthen.VCF);
      }
      this.Kvm.put("creid_renewal", String.valueOf(paramAuthen.VBV));
      this.Kvm.put("birth_date", paramAuthen.VCa);
      this.Kvm.put("cre_expire_date", paramAuthen.VBW);
      break label488;
      this.Kvm.put("flag", "2");
      this.Kvm.put("bank_type", paramAuthen.hAk);
      this.Kvm.put("h_bind_serial", paramAuthen.MDt);
      this.Kvm.put("card_tail", paramAuthen.IvM);
      if (!Util.isNullOrNil(paramAuthen.VBL)) {
        this.Kvm.put("true_name", paramAuthen.VBL);
      }
      if (!Util.isNullOrNil(paramAuthen.VCB)) {
        this.Kvm.put("identify_card", paramAuthen.VCB);
      }
      this.Kvm.put("cre_type", paramAuthen.VCC);
      this.Kvm.put("mobile_no", paramAuthen.VxX);
      this.Kvm.put("bank_card_id", paramAuthen.VCD);
      if (!Util.isNullOrNil(paramAuthen.VCE)) {
        this.Kvm.put("cvv2", paramAuthen.VCE);
      }
      if (!Util.isNullOrNil(paramAuthen.VCF)) {
        this.Kvm.put("valid_thru", paramAuthen.VCF);
      }
      this.Kvm.put("creid_renewal", String.valueOf(paramAuthen.VBV));
      this.Kvm.put("birth_date", paramAuthen.VCa);
      this.Kvm.put("cre_expire_date", paramAuthen.VBW);
      break label488;
      if (paramAuthen.VCz == 1)
      {
        this.Kvm.put("reset_flag", "1");
        if (!Util.isNullOrNil(paramAuthen.VxX)) {
          this.Kvm.put("mobile_no", paramAuthen.VxX);
        }
        if (!Util.isNullOrNil(paramAuthen.VCE)) {
          this.Kvm.put("cvv2", paramAuthen.VCE);
        }
        if (!Util.isNullOrNil(paramAuthen.VCF)) {
          this.Kvm.put("valid_thru", paramAuthen.VCF);
        }
      }
      this.Kvm.put("flag", "3");
      this.Kvm.put("bank_type", paramAuthen.hAk);
      this.Kvm.put("bind_serial", paramAuthen.MDt);
      break label488;
      this.Kvm.put("flag", "4");
      this.Kvm.put("bank_type", paramAuthen.hAk);
      this.Kvm.put("first_name", paramAuthen.VCH);
      this.Kvm.put("last_name", paramAuthen.VCI);
      this.Kvm.put("country", paramAuthen.country);
      this.Kvm.put("area", paramAuthen.province);
      this.Kvm.put("city", paramAuthen.city);
      this.Kvm.put("address", paramAuthen.oDI);
      this.Kvm.put("phone_number", paramAuthen.JFm);
      this.Kvm.put("zip_code", paramAuthen.qhL);
      this.Kvm.put("email", paramAuthen.kab);
      this.Kvm.put("bank_card_id", paramAuthen.VCD);
      if (!Util.isNullOrNil(paramAuthen.VCE)) {
        this.Kvm.put("cvv2", paramAuthen.VCE);
      }
      if (Util.isNullOrNil(paramAuthen.VCF)) {
        break label488;
      }
      this.Kvm.put("valid_thru", paramAuthen.VCF);
      break label488;
      this.Kvm.put("flag", "5");
      this.Kvm.put("bank_type", paramAuthen.hAk);
      this.Kvm.put("first_name", paramAuthen.VCH);
      this.Kvm.put("last_name", paramAuthen.VCI);
      this.Kvm.put("country", paramAuthen.country);
      this.Kvm.put("area", paramAuthen.province);
      this.Kvm.put("city", paramAuthen.city);
      this.Kvm.put("address", paramAuthen.oDI);
      this.Kvm.put("phone_number", paramAuthen.JFm);
      this.Kvm.put("zip_code", paramAuthen.qhL);
      this.Kvm.put("email", paramAuthen.kab);
      this.Kvm.put("bank_card_id", paramAuthen.VCD);
      if (!Util.isNullOrNil(paramAuthen.VCE)) {
        this.Kvm.put("cvv2", paramAuthen.VCE);
      }
      if (!Util.isNullOrNil(paramAuthen.VCF)) {
        this.Kvm.put("valid_thru", paramAuthen.VCF);
      }
      this.Kvm.put("h_bind_serial", paramAuthen.MDt);
      this.Kvm.put("card_tail", paramAuthen.IvM);
      break label488;
      if (paramAuthen.VCz == 1)
      {
        this.Kvm.put("reset_flag", "1");
        if (!Util.isNullOrNil(paramAuthen.VCE)) {
          this.Kvm.put("cvv2", paramAuthen.VCE);
        }
        if (!Util.isNullOrNil(paramAuthen.VCF)) {
          this.Kvm.put("valid_thru", paramAuthen.VCF);
        }
      }
      this.Kvm.put("phone_number", paramAuthen.VxX);
      this.Kvm.put("flag", "6");
      this.Kvm.put("bank_type", paramAuthen.hAk);
      this.Kvm.put("bind_serial", paramAuthen.MDt);
      break label488;
      paramByte = 1;
      break label553;
    }
  }
  
  protected void bi(Map<String, String> paramMap) {}
  
  public int getFuncId()
  {
    if (this.VmM.Nxi.hUR == 11) {
      return 1610;
    }
    if (this.VmM.Nxi.hUR == 21) {
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
    if (this.VmM.Nxi.hUR == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
    }
    if (this.VmM.Nxi.hUR == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
    }
    return "/cgi-bin/mmpay-bin/tenpay/authen";
  }
  
  public final boolean ifU()
  {
    return this.VmM.Nxi.VSv == 1;
  }
  
  public final boolean ifV()
  {
    return (this.VmM.Nxi.hUR == 11) || (this.VmM.Nxi.hUR == 21);
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69266);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    Log.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + paramInt + " errMsg :" + paramString);
    Log.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[] { this.VmN });
    this.VmK = "1".equals(paramJSONObject.optString("is_free_sms"));
    this.token = paramJSONObject.optString("token");
    this.VmN = paramJSONObject.optString("balance_mobile");
    this.VmO = paramJSONObject.optString("balance_help_url");
    this.VmP = paramJSONObject.optString("modify_mobile_url");
    paramString = paramJSONObject.optString("bind_serial");
    if (!Util.isNullOrNil(paramString)) {
      Log.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(paramString)));
    }
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.VmL = Orders.a(paramJSONObject, this.VmL);
      paramString = paramJSONObject.optJSONObject("verify_cre_tail_info");
      if (paramString != null)
      {
        this.VmQ = paramString.optInt("is_can_verify_tail", 0);
        this.VmR = paramString.optString("verify_tail_wording");
      }
      this.VmS = paramJSONObject.optInt("no_reset_mobile", 0);
      Log.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.VmM.Nxi.hUR);
      if (this.VmM.Nxi.hUR == 21)
      {
        this.VmT = paramJSONObject.optJSONArray("fetch_charge_show_info");
        h.baE().ban().set(at.a.acUN, paramJSONObject.optString("charge_rate_version"));
      }
      if ((paramInt != 0) || (this.VmM.Nxi.hUR != 39)) {
        break label394;
      }
      Log.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
      l.cD(paramJSONObject);
    }
    for (;;)
    {
      paramString = com.tencent.mm.wallet_core.a.bEC("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((com.tencent.mm.wallet_core.e)paramString.next()).hPH.putInt("key_is_clear_failure", this.agUo);
      }
      setPaySuccess(false);
      break;
      label394:
      Log.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(69266);
  }
  
  public void onGYNetEnd2(com.tencent.mm.wallet_core.model.e parame, JSONObject paramJSONObject)
  {
    int i = 2;
    AppMethodBeat.i(69267);
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((this.SVR_ERR_TYPE == 0) && (this.SVR_ERR_CODE == 0))
    {
      if (this.isPaySuccess)
      {
        parame = this.VmM.Nxi.YvN;
        if (this.VmM.Nxi.cHU) {}
        for (;;)
        {
          com.tencent.mm.plugin.wallet.pay.a.b.hE(parame, i);
          com.tencent.mm.plugin.wallet.pay.a.b.dz(this.VmM.Nxi.YvN, checkRecSrvResp());
          AppMethodBeat.o(69267);
          return;
          i = 1;
        }
      }
    }
    else
    {
      parame = this.VmM.Nxi.YvN;
      if (!this.VmM.Nxi.cHU) {
        break label146;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet.pay.a.b.hE(parame, i);
      com.tencent.mm.plugin.wallet.pay.a.b.dz(this.VmM.Nxi.YvN, checkRecSrvResp());
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
    this.Kvm.put("is_repeat_send", "1");
    setRequestData(this.Kvm);
    this.VmI = true;
    AppMethodBeat.o(69265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.b
 * JD-Core Version:    0.7.0.1
 */