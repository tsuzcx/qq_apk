package com.tencent.mm.plugin.wallet.pay.a.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.x;
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
  private Map<String, String> plK;
  private Map<String, String> tVp;
  public boolean tVq;
  public Orders tVr;
  public Authen tVs;
  public String tVt;
  public String tVu;
  private String tVv;
  public int tVw;
  public String tVx;
  public int tVy;
  public JSONArray tVz;
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
    AppMethodBeat.i(45921);
    this.tVq = false;
    this.tVr = null;
    this.token = null;
    this.tVt = null;
    this.tVu = null;
    this.tVv = null;
    this.tVw = 0;
    this.tVy = 0;
    this.tVs = paramAuthen;
    this.tVr = paramOrders;
    if (paramAuthen == null)
    {
      paramAuthen = new IllegalArgumentException("authen == null");
      AppMethodBeat.o(45921);
      throw paramAuthen;
    }
    a(paramOrders, paramAuthen);
    if (paramAuthen.pVo == null)
    {
      paramAuthen = new IllegalArgumentException("authen.payInfo == null");
      AppMethodBeat.o(45921);
      throw paramAuthen;
    }
    ab.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + paramAuthen.pVo.cCy);
    this.plK = new HashMap();
    this.tVp = new HashMap();
    boolean bool1;
    if ((!paramBoolean) && (!bo.isNullOrNil(this.tVs.ueW)))
    {
      bool1 = true;
      ab.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool1) });
      setPayInfo(paramAuthen.pVo, this.plK, this.tVp, bool1);
      if (!paramBoolean) {
        break label645;
      }
      this.plK.put("brief_reg", "1");
      label237:
      this.uju = paramOrders.uju;
      this.plK.put("default_favorcomposedid", paramAuthen.ufg);
      this.plK.put("favorcomposedid", paramAuthen.ufh);
      this.plK.put("arrive_type", paramAuthen.ufd);
      this.plK.put("sms_flag", paramAuthen.ufi);
      this.plK.put("ban_sms_bind_serial", paramAuthen.ufj);
      this.plK.put("ban_sms_bank_type", paramAuthen.ufk);
      this.plK.put("busi_sms_flag", paramAuthen.ufl);
      this.plK.put("buttontype", paramAuthen.pVo.wgB);
      this.plK.put("mobile_area", paramAuthen.ufm);
      ab.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[] { Integer.valueOf(paramAuthen.pVo.wgB), Integer.valueOf(this.uju), paramAuthen.ufm });
      switch (paramAuthen.bsY)
      {
      default: 
        label488:
        aj(this.plK);
        setRequestData(this.plK);
        paramOrders = ((l)g.E(l.class)).bzl();
        if (paramOrders != null) {
          this.tVp.putAll(paramOrders);
        }
        paramOrders = paramAuthen.pVo.wgD;
        if (paramAuthen.pVo.axV)
        {
          paramByte = 2;
          label553:
          if (paramAuthen.pVo.utc != 1) {
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
      if (x.dSp())
      {
        this.tVp.put("uuid_for_bindcard", x.dSr());
        this.tVp.put("bindcard_scene", x.dSq());
      }
      setWXRequestData(this.tVp);
      AppMethodBeat.o(45921);
      return;
      bool1 = false;
      break;
      this.plK.put("passwd", paramAuthen.ueW);
      break label237;
      this.plK.put("flag", "1");
      this.plK.put("bank_type", paramAuthen.poq);
      this.plK.put("true_name", paramAuthen.ueu);
      this.plK.put("identify_card", paramAuthen.ueX);
      if (paramAuthen.ueY > 0) {
        this.plK.put("cre_type", paramAuthen.ueY);
      }
      this.plK.put("mobile_no", paramAuthen.ubQ);
      this.plK.put("bank_card_id", paramAuthen.ueZ);
      if (!bo.isNullOrNil(paramAuthen.ufa)) {
        this.plK.put("cvv2", paramAuthen.ufa);
      }
      if (!bo.isNullOrNil(paramAuthen.ufb)) {
        this.plK.put("valid_thru", paramAuthen.ufb);
      }
      this.plK.put("creid_renewal", String.valueOf(paramAuthen.ueC));
      this.plK.put("birth_date", paramAuthen.ueE);
      this.plK.put("cre_expire_date", paramAuthen.ufn);
      break label488;
      this.plK.put("flag", "2");
      this.plK.put("bank_type", paramAuthen.poq);
      this.plK.put("h_bind_serial", paramAuthen.por);
      this.plK.put("card_tail", paramAuthen.ufc);
      if (!bo.isNullOrNil(paramAuthen.ueu)) {
        this.plK.put("true_name", paramAuthen.ueu);
      }
      if (!bo.isNullOrNil(paramAuthen.ueX)) {
        this.plK.put("identify_card", paramAuthen.ueX);
      }
      this.plK.put("cre_type", paramAuthen.ueY);
      this.plK.put("mobile_no", paramAuthen.ubQ);
      this.plK.put("bank_card_id", paramAuthen.ueZ);
      if (!bo.isNullOrNil(paramAuthen.ufa)) {
        this.plK.put("cvv2", paramAuthen.ufa);
      }
      if (!bo.isNullOrNil(paramAuthen.ufb)) {
        this.plK.put("valid_thru", paramAuthen.ufb);
      }
      this.plK.put("creid_renewal", String.valueOf(paramAuthen.ueC));
      this.plK.put("birth_date", paramAuthen.ueE);
      this.plK.put("cre_expire_date", paramAuthen.ufn);
      break label488;
      if (paramAuthen.ueV == 1)
      {
        this.plK.put("reset_flag", "1");
        if (!bo.isNullOrNil(paramAuthen.ubQ)) {
          this.plK.put("mobile_no", paramAuthen.ubQ);
        }
        if (!bo.isNullOrNil(paramAuthen.ufa)) {
          this.plK.put("cvv2", paramAuthen.ufa);
        }
        if (!bo.isNullOrNil(paramAuthen.ufb)) {
          this.plK.put("valid_thru", paramAuthen.ufb);
        }
      }
      this.plK.put("flag", "3");
      this.plK.put("bank_type", paramAuthen.poq);
      this.plK.put("bind_serial", paramAuthen.por);
      break label488;
      this.plK.put("flag", "4");
      this.plK.put("bank_type", paramAuthen.poq);
      this.plK.put("first_name", paramAuthen.ufe);
      this.plK.put("last_name", paramAuthen.uff);
      this.plK.put("country", paramAuthen.country);
      this.plK.put("area", paramAuthen.province);
      this.plK.put("city", paramAuthen.city);
      this.plK.put("address", paramAuthen.fBq);
      this.plK.put("phone_number", paramAuthen.nLs);
      this.plK.put("zip_code", paramAuthen.gKS);
      this.plK.put("email", paramAuthen.dqF);
      this.plK.put("bank_card_id", paramAuthen.ueZ);
      if (!bo.isNullOrNil(paramAuthen.ufa)) {
        this.plK.put("cvv2", paramAuthen.ufa);
      }
      if (bo.isNullOrNil(paramAuthen.ufb)) {
        break label488;
      }
      this.plK.put("valid_thru", paramAuthen.ufb);
      break label488;
      this.plK.put("flag", "5");
      this.plK.put("bank_type", paramAuthen.poq);
      this.plK.put("first_name", paramAuthen.ufe);
      this.plK.put("last_name", paramAuthen.uff);
      this.plK.put("country", paramAuthen.country);
      this.plK.put("area", paramAuthen.province);
      this.plK.put("city", paramAuthen.city);
      this.plK.put("address", paramAuthen.fBq);
      this.plK.put("phone_number", paramAuthen.nLs);
      this.plK.put("zip_code", paramAuthen.gKS);
      this.plK.put("email", paramAuthen.dqF);
      this.plK.put("bank_card_id", paramAuthen.ueZ);
      if (!bo.isNullOrNil(paramAuthen.ufa)) {
        this.plK.put("cvv2", paramAuthen.ufa);
      }
      if (!bo.isNullOrNil(paramAuthen.ufb)) {
        this.plK.put("valid_thru", paramAuthen.ufb);
      }
      this.plK.put("h_bind_serial", paramAuthen.por);
      this.plK.put("card_tail", paramAuthen.ufc);
      break label488;
      if (paramAuthen.ueV == 1)
      {
        this.plK.put("reset_flag", "1");
        if (!bo.isNullOrNil(paramAuthen.ufa)) {
          this.plK.put("cvv2", paramAuthen.ufa);
        }
        if (!bo.isNullOrNil(paramAuthen.ufb)) {
          this.plK.put("valid_thru", paramAuthen.ufb);
        }
      }
      this.plK.put("phone_number", paramAuthen.ubQ);
      this.plK.put("flag", "6");
      this.plK.put("bank_type", paramAuthen.poq);
      this.plK.put("bind_serial", paramAuthen.por);
      break label488;
      paramByte = 1;
      break label553;
    }
  }
  
  protected void aj(Map<String, String> paramMap) {}
  
  public final boolean cRM()
  {
    return this.tVs.pVo.utc == 1;
  }
  
  public final boolean cRN()
  {
    return (this.tVs.pVo.cCD == 11) || (this.tVs.pVo.cCD == 21);
  }
  
  public int getFuncId()
  {
    if (this.tVs.pVo.cCD == 11) {
      return 1610;
    }
    if (this.tVs.pVo.cCD == 21) {
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
    if (this.tVs.pVo.cCD == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
    }
    if (this.tVs.pVo.cCD == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
    }
    return "/cgi-bin/mmpay-bin/tenpay/authen";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45923);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    ab.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + paramInt + " errMsg :" + paramString);
    ab.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[] { this.tVt });
    this.tVq = "1".equals(paramJSONObject.optString("is_free_sms"));
    this.token = paramJSONObject.optString("token");
    this.tVt = paramJSONObject.optString("balance_mobile");
    this.tVu = paramJSONObject.optString("balance_help_url");
    this.tVv = paramJSONObject.optString("modify_mobile_url");
    paramString = paramJSONObject.optString("bind_serial");
    if (!bo.isNullOrNil(paramString)) {
      ab.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(paramString)));
    }
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      setPaySuccess(true);
      this.tVr = Orders.a(paramJSONObject, this.tVr);
      paramString = paramJSONObject.optJSONObject("verify_cre_tail_info");
      if (paramString != null)
      {
        this.tVw = paramString.optInt("is_can_verify_tail", 0);
        this.tVx = paramString.optString("verify_tail_wording");
      }
      this.tVy = paramJSONObject.optInt("no_reset_mobile", 0);
      ab.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.tVs.pVo.cCD);
      if (this.tVs.pVo.cCD == 21)
      {
        this.tVz = paramJSONObject.optJSONArray("fetch_charge_show_info");
        g.RL().Ru().set(ac.a.yIW, paramJSONObject.optString("charge_rate_version"));
      }
      if ((paramInt != 0) || (this.tVs.pVo.cCD != 39)) {
        break label394;
      }
      ab.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
      com.tencent.mm.plugin.wallet_core.utils.b.aP(paramJSONObject);
    }
    for (;;)
    {
      paramString = a.avV("PayProcess").iterator();
      while (paramString.hasNext()) {
        ((c)paramString.next()).mEJ.putInt("key_is_clear_failure", this.AXY);
      }
      setPaySuccess(false);
      break;
      label394:
      ab.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(45923);
  }
  
  public void onGYNetEnd2(d paramd, JSONObject paramJSONObject)
  {
    int i = 2;
    AppMethodBeat.i(45924);
    super.onGYNetEnd2(paramd, paramJSONObject);
    if ((this.SVR_ERR_TYPE == 0) && (this.SVR_ERR_CODE == 0))
    {
      if (this.isPaySuccess)
      {
        paramd = this.tVs.pVo.wgD;
        if (this.tVs.pVo.axV) {}
        for (;;)
        {
          com.tencent.mm.plugin.wallet.pay.a.b.dD(paramd, i);
          com.tencent.mm.plugin.wallet.pay.a.b.bG(this.tVs.pVo.wgD, checkRecSrvResp());
          AppMethodBeat.o(45924);
          return;
          i = 1;
        }
      }
    }
    else
    {
      paramd = this.tVs.pVo.wgD;
      if (!this.tVs.pVo.axV) {
        break label146;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet.pay.a.b.dD(paramd, i);
      com.tencent.mm.plugin.wallet.pay.a.b.bG(this.tVs.pVo.wgD, checkRecSrvResp());
      AppMethodBeat.o(45924);
      return;
      label146:
      i = 1;
    }
  }
  
  public boolean resend()
  {
    AppMethodBeat.i(45922);
    super.resend();
    this.plK.put("is_repeat_send", "1");
    setRequestData(this.plK);
    AppMethodBeat.o(45922);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.b
 * JD-Core Version:    0.7.0.1
 */