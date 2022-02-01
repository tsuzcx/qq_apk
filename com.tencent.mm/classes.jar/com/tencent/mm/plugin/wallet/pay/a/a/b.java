package com.tencent.mm.plugin.wallet.pay.a.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.utils.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.e;
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
  private Map<String, String> ECl;
  public Orders OxA;
  public Authen OxB;
  public String OxC;
  public String OxD;
  private String OxE;
  public int OxF;
  public String OxG;
  public int OxH;
  public JSONArray OxI;
  public boolean Oxx;
  private Map<String, String> Oxy;
  public boolean Oxz;
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
    this.Oxz = false;
    this.OxA = null;
    this.token = null;
    this.OxC = null;
    this.OxD = null;
    this.OxE = null;
    this.OxF = 0;
    this.OxH = 0;
    this.OxB = paramAuthen;
    this.OxA = paramOrders;
    if (paramAuthen == null)
    {
      paramAuthen = new IllegalArgumentException("authen == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    a(paramOrders, paramAuthen);
    if (paramAuthen.HzF == null)
    {
      paramAuthen = new IllegalArgumentException("authen.payInfo == null");
      AppMethodBeat.o(69264);
      throw paramAuthen;
    }
    Log.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + paramAuthen.HzF.channel);
    this.ECl = new HashMap();
    this.Oxy = new HashMap();
    boolean bool1;
    if ((!paramBoolean) && (!Util.isNullOrNil(this.OxB.OMP)))
    {
      bool1 = true;
      Log.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool1) });
      setPayInfo(paramAuthen.HzF, this.ECl, this.Oxy, bool1);
      if (!paramBoolean) {
        break label645;
      }
      this.ECl.put("brief_reg", "1");
      label237:
      this.ORm = paramOrders.ORm;
      this.ECl.put("default_favorcomposedid", paramAuthen.OMY);
      this.ECl.put("favorcomposedid", paramAuthen.OMZ);
      this.ECl.put("arrive_type", paramAuthen.OMV);
      this.ECl.put("sms_flag", paramAuthen.ONa);
      this.ECl.put("ban_sms_bind_serial", paramAuthen.ONb);
      this.ECl.put("ban_sms_bank_type", paramAuthen.ONc);
      this.ECl.put("busi_sms_flag", paramAuthen.ONd);
      this.ECl.put("buttontype", paramAuthen.HzF.Rzn);
      this.ECl.put("mobile_area", paramAuthen.ONe);
      Log.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[] { Integer.valueOf(paramAuthen.HzF.Rzn), Integer.valueOf(this.ORm), paramAuthen.ONe });
      switch (paramAuthen.cUP)
      {
      default: 
        label488:
        aR(this.ECl);
        setRequestData(this.ECl);
        paramOrders = ((com.tencent.mm.plugin.fingerprint.d.a)h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).eoy();
        if (paramOrders != null) {
          this.Oxy.putAll(paramOrders);
        }
        paramOrders = paramAuthen.HzF.Rzp;
        if (paramAuthen.HzF.aNY)
        {
          paramByte = 2;
          label553:
          if (paramAuthen.HzF.PbP != 1) {
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
      com.tencent.mm.plugin.wallet.pay.a.b.y(paramOrders, paramByte, paramBoolean);
      if (z.iiS())
      {
        this.Oxy.put("uuid_for_bindcard", z.getBindCardUuid());
        this.Oxy.put("bindcard_scene", z.iiT());
      }
      setWXRequestData(this.Oxy);
      AppMethodBeat.o(69264);
      return;
      bool1 = false;
      break;
      this.ECl.put("passwd", paramAuthen.OMP);
      break label237;
      this.ECl.put("flag", "1");
      this.ECl.put("bank_type", paramAuthen.fvP);
      this.ECl.put("true_name", paramAuthen.OMa);
      this.ECl.put("identify_card", paramAuthen.OMQ);
      if (paramAuthen.OMR > 0) {
        this.ECl.put("cre_type", paramAuthen.OMR);
      }
      this.ECl.put("mobile_no", paramAuthen.OIl);
      this.ECl.put("bank_card_id", paramAuthen.OMS);
      if (!Util.isNullOrNil(paramAuthen.OMT)) {
        this.ECl.put("cvv2", paramAuthen.OMT);
      }
      if (!Util.isNullOrNil(paramAuthen.OMU)) {
        this.ECl.put("valid_thru", paramAuthen.OMU);
      }
      this.ECl.put("creid_renewal", String.valueOf(paramAuthen.OMk));
      this.ECl.put("birth_date", paramAuthen.OMp);
      this.ECl.put("cre_expire_date", paramAuthen.OMl);
      break label488;
      this.ECl.put("flag", "2");
      this.ECl.put("bank_type", paramAuthen.fvP);
      this.ECl.put("h_bind_serial", paramAuthen.GGC);
      this.ECl.put("card_tail", paramAuthen.CBX);
      if (!Util.isNullOrNil(paramAuthen.OMa)) {
        this.ECl.put("true_name", paramAuthen.OMa);
      }
      if (!Util.isNullOrNil(paramAuthen.OMQ)) {
        this.ECl.put("identify_card", paramAuthen.OMQ);
      }
      this.ECl.put("cre_type", paramAuthen.OMR);
      this.ECl.put("mobile_no", paramAuthen.OIl);
      this.ECl.put("bank_card_id", paramAuthen.OMS);
      if (!Util.isNullOrNil(paramAuthen.OMT)) {
        this.ECl.put("cvv2", paramAuthen.OMT);
      }
      if (!Util.isNullOrNil(paramAuthen.OMU)) {
        this.ECl.put("valid_thru", paramAuthen.OMU);
      }
      this.ECl.put("creid_renewal", String.valueOf(paramAuthen.OMk));
      this.ECl.put("birth_date", paramAuthen.OMp);
      this.ECl.put("cre_expire_date", paramAuthen.OMl);
      break label488;
      if (paramAuthen.OMO == 1)
      {
        this.ECl.put("reset_flag", "1");
        if (!Util.isNullOrNil(paramAuthen.OIl)) {
          this.ECl.put("mobile_no", paramAuthen.OIl);
        }
        if (!Util.isNullOrNil(paramAuthen.OMT)) {
          this.ECl.put("cvv2", paramAuthen.OMT);
        }
        if (!Util.isNullOrNil(paramAuthen.OMU)) {
          this.ECl.put("valid_thru", paramAuthen.OMU);
        }
      }
      this.ECl.put("flag", "3");
      this.ECl.put("bank_type", paramAuthen.fvP);
      this.ECl.put("bind_serial", paramAuthen.GGC);
      break label488;
      this.ECl.put("flag", "4");
      this.ECl.put("bank_type", paramAuthen.fvP);
      this.ECl.put("first_name", paramAuthen.OMW);
      this.ECl.put("last_name", paramAuthen.OMX);
      this.ECl.put("country", paramAuthen.country);
      this.ECl.put("area", paramAuthen.province);
      this.ECl.put("city", paramAuthen.city);
      this.ECl.put("address", paramAuthen.lLg);
      this.ECl.put("phone_number", paramAuthen.DNX);
      this.ECl.put("zip_code", paramAuthen.nkC);
      this.ECl.put("email", paramAuthen.hDf);
      this.ECl.put("bank_card_id", paramAuthen.OMS);
      if (!Util.isNullOrNil(paramAuthen.OMT)) {
        this.ECl.put("cvv2", paramAuthen.OMT);
      }
      if (Util.isNullOrNil(paramAuthen.OMU)) {
        break label488;
      }
      this.ECl.put("valid_thru", paramAuthen.OMU);
      break label488;
      this.ECl.put("flag", "5");
      this.ECl.put("bank_type", paramAuthen.fvP);
      this.ECl.put("first_name", paramAuthen.OMW);
      this.ECl.put("last_name", paramAuthen.OMX);
      this.ECl.put("country", paramAuthen.country);
      this.ECl.put("area", paramAuthen.province);
      this.ECl.put("city", paramAuthen.city);
      this.ECl.put("address", paramAuthen.lLg);
      this.ECl.put("phone_number", paramAuthen.DNX);
      this.ECl.put("zip_code", paramAuthen.nkC);
      this.ECl.put("email", paramAuthen.hDf);
      this.ECl.put("bank_card_id", paramAuthen.OMS);
      if (!Util.isNullOrNil(paramAuthen.OMT)) {
        this.ECl.put("cvv2", paramAuthen.OMT);
      }
      if (!Util.isNullOrNil(paramAuthen.OMU)) {
        this.ECl.put("valid_thru", paramAuthen.OMU);
      }
      this.ECl.put("h_bind_serial", paramAuthen.GGC);
      this.ECl.put("card_tail", paramAuthen.CBX);
      break label488;
      if (paramAuthen.OMO == 1)
      {
        this.ECl.put("reset_flag", "1");
        if (!Util.isNullOrNil(paramAuthen.OMT)) {
          this.ECl.put("cvv2", paramAuthen.OMT);
        }
        if (!Util.isNullOrNil(paramAuthen.OMU)) {
          this.ECl.put("valid_thru", paramAuthen.OMU);
        }
      }
      this.ECl.put("phone_number", paramAuthen.OIl);
      this.ECl.put("flag", "6");
      this.ECl.put("bank_type", paramAuthen.fvP);
      this.ECl.put("bind_serial", paramAuthen.GGC);
      break label488;
      paramByte = 1;
      break label553;
    }
  }
  
  protected void aR(Map<String, String> paramMap) {}
  
  public final boolean gGR()
  {
    return this.OxB.HzF.PbP == 1;
  }
  
  public final boolean gGS()
  {
    return (this.OxB.HzF.fOY == 11) || (this.OxB.HzF.fOY == 21);
  }
  
  public int getFuncId()
  {
    if (this.OxB.HzF.fOY == 11) {
      return 1610;
    }
    if (this.OxB.HzF.fOY == 21) {
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
    if (this.OxB.HzF.fOY == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
    }
    if (this.OxB.HzF.fOY == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
    }
    return "/cgi-bin/mmpay-bin/tenpay/authen";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69266);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    Log.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + paramInt + " errMsg :" + paramString);
    Log.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[] { this.OxC });
    this.Oxz = "1".equals(paramJSONObject.optString("is_free_sms"));
    this.token = paramJSONObject.optString("token");
    this.OxC = paramJSONObject.optString("balance_mobile");
    this.OxD = paramJSONObject.optString("balance_help_url");
    this.OxE = paramJSONObject.optString("modify_mobile_url");
    paramString = paramJSONObject.optString("bind_serial");
    if (!Util.isNullOrNil(paramString)) {
      Log.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(paramString)));
    }
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.OxA = Orders.a(paramJSONObject, this.OxA);
      paramString = paramJSONObject.optJSONObject("verify_cre_tail_info");
      if (paramString != null)
      {
        this.OxF = paramString.optInt("is_can_verify_tail", 0);
        this.OxG = paramString.optString("verify_tail_wording");
      }
      this.OxH = paramJSONObject.optInt("no_reset_mobile", 0);
      Log.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.OxB.HzF.fOY);
      if (this.OxB.HzF.fOY == 21)
      {
        this.OxI = paramJSONObject.optJSONArray("fetch_charge_show_info");
        h.aHG().aHp().set(ar.a.Vti, paramJSONObject.optString("charge_rate_version"));
      }
      if ((paramInt != 0) || (this.OxB.HzF.fOY != 39)) {
        break label394;
      }
      Log.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
      i.ch(paramJSONObject);
    }
    for (;;)
    {
      paramString = com.tencent.mm.wallet_core.a.bCh("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((d)paramString.next()).fKb.putInt("key_is_clear_failure", this.YWu);
      }
      setPaySuccess(false);
      break;
      label394:
      Log.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(69266);
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    int i = 2;
    AppMethodBeat.i(69267);
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((this.SVR_ERR_TYPE == 0) && (this.SVR_ERR_CODE == 0))
    {
      if (this.isPaySuccess)
      {
        parame = this.OxB.HzF.Rzp;
        if (this.OxB.HzF.aNY) {}
        for (;;)
        {
          com.tencent.mm.plugin.wallet.pay.a.b.gH(parame, i);
          com.tencent.mm.plugin.wallet.pay.a.b.cR(this.OxB.HzF.Rzp, checkRecSrvResp());
          AppMethodBeat.o(69267);
          return;
          i = 1;
        }
      }
    }
    else
    {
      parame = this.OxB.HzF.Rzp;
      if (!this.OxB.HzF.aNY) {
        break label146;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet.pay.a.b.gH(parame, i);
      com.tencent.mm.plugin.wallet.pay.a.b.cR(this.OxB.HzF.Rzp, checkRecSrvResp());
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
    this.ECl.put("is_repeat_send", "1");
    setRequestData(this.ECl);
    this.Oxx = true;
    AppMethodBeat.o(69265);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.b
 * JD-Core Version:    0.7.0.1
 */