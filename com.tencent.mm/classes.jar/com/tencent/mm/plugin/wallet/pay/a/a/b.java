package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.wallet_core.tenpay.model.k
{
  private Map<String, String> mLt;
  private Map<String, String> qma;
  public boolean qmb = false;
  public Orders qmc = null;
  public Authen qmd;
  public String qme = null;
  public String qmf = null;
  private String qmg = null;
  public int qmh = 0;
  public String qmi;
  public int qmj = 0;
  public String token = null;
  
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
    this.qmd = paramAuthen;
    this.qmc = paramOrders;
    if (paramAuthen == null) {
      throw new IllegalArgumentException("authen == null");
    }
    List localList = paramOrders.qwN;
    if (localList.size() > 0) {
      str = ((Orders.Commodity)localList.get(0)).bMY;
    }
    a(paramOrders.bMX, str, paramAuthen.nqa.bUV, paramAuthen.nqa.bUR, paramAuthen.mOb, paramAuthen.mOc);
    if (paramAuthen.nqa == null) {
      throw new IllegalArgumentException("authen.payInfo == null");
    }
    y.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + paramAuthen.nqa.bUR);
    this.mLt = new HashMap();
    this.qma = new HashMap();
    boolean bool;
    if ((!paramBoolean) && (!bk.bl(this.qmd.qsI)))
    {
      bool = true;
      y.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[] { Boolean.valueOf(bool) });
      a(paramAuthen.nqa, this.mLt, this.qma, bool);
      if (!paramBoolean) {
        break label638;
      }
      this.mLt.put("brief_reg", "1");
      label276:
      this.qwW = paramOrders.qwW;
      this.mLt.put("default_favorcomposedid", paramAuthen.qsT);
      this.mLt.put("favorcomposedid", paramAuthen.qsU);
      this.mLt.put("arrive_type", paramAuthen.qsQ);
      this.mLt.put("sms_flag", paramAuthen.qsV);
      this.mLt.put("ban_sms_bind_serial", paramAuthen.qsW);
      this.mLt.put("ban_sms_bank_type", paramAuthen.qsX);
      this.mLt.put("busi_sms_flag", paramAuthen.qsY);
      this.mLt.put("buttontype", paramAuthen.nqa.sod);
      this.mLt.put("mobile_area", paramAuthen.qsZ);
      y.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", new Object[] { Integer.valueOf(paramAuthen.nqa.sod), Integer.valueOf(this.qwW), paramAuthen.qsZ });
      switch (paramAuthen.bcw)
      {
      }
    }
    for (;;)
    {
      P(this.mLt);
      D(this.mLt);
      paramAuthen = ((com.tencent.mm.pluginsdk.k)g.r(com.tencent.mm.pluginsdk.k.class)).aSQ();
      if (paramAuthen != null) {
        this.qma.putAll(paramAuthen);
      }
      if (v.cMA())
      {
        this.qma.put("uuid_for_bindcard", v.cMC());
        this.qma.put("bindcard_scene", v.cMB());
      }
      aC(this.qma);
      return;
      bool = false;
      break;
      label638:
      this.mLt.put("passwd", paramAuthen.qsI);
      break label276;
      this.mLt.put("flag", "1");
      this.mLt.put("bank_type", paramAuthen.mOb);
      this.mLt.put("true_name", paramAuthen.qsJ);
      this.mLt.put("identify_card", paramAuthen.qsK);
      if (paramAuthen.qsL > 0) {
        this.mLt.put("cre_type", paramAuthen.qsL);
      }
      this.mLt.put("mobile_no", paramAuthen.qqU);
      this.mLt.put("bank_card_id", paramAuthen.qsM);
      if (!bk.bl(paramAuthen.qsN)) {
        this.mLt.put("cvv2", paramAuthen.qsN);
      }
      if (!bk.bl(paramAuthen.qsO)) {
        this.mLt.put("valid_thru", paramAuthen.qsO);
      }
      this.mLt.put("creid_renewal", String.valueOf(paramAuthen.qta));
      this.mLt.put("birth_date", paramAuthen.qtb);
      this.mLt.put("cre_expire_date", paramAuthen.qtc);
      continue;
      this.mLt.put("flag", "2");
      this.mLt.put("bank_type", paramAuthen.mOb);
      this.mLt.put("h_bind_serial", paramAuthen.mOc);
      this.mLt.put("card_tail", paramAuthen.qsP);
      if (!bk.bl(paramAuthen.qsJ)) {
        this.mLt.put("true_name", paramAuthen.qsJ);
      }
      if (!bk.bl(paramAuthen.qsK)) {
        this.mLt.put("identify_card", paramAuthen.qsK);
      }
      this.mLt.put("cre_type", paramAuthen.qsL);
      this.mLt.put("mobile_no", paramAuthen.qqU);
      this.mLt.put("bank_card_id", paramAuthen.qsM);
      if (!bk.bl(paramAuthen.qsN)) {
        this.mLt.put("cvv2", paramAuthen.qsN);
      }
      if (!bk.bl(paramAuthen.qsO)) {
        this.mLt.put("valid_thru", paramAuthen.qsO);
      }
      this.mLt.put("creid_renewal", String.valueOf(paramAuthen.qta));
      this.mLt.put("birth_date", paramAuthen.qtb);
      this.mLt.put("cre_expire_date", paramAuthen.qtc);
      continue;
      if (paramAuthen.qsH == 1)
      {
        this.mLt.put("reset_flag", "1");
        if (!bk.bl(paramAuthen.qqU)) {
          this.mLt.put("mobile_no", paramAuthen.qqU);
        }
        if (!bk.bl(paramAuthen.qsN)) {
          this.mLt.put("cvv2", paramAuthen.qsN);
        }
        if (!bk.bl(paramAuthen.qsO)) {
          this.mLt.put("valid_thru", paramAuthen.qsO);
        }
      }
      this.mLt.put("flag", "3");
      this.mLt.put("bank_type", paramAuthen.mOb);
      this.mLt.put("bind_serial", paramAuthen.mOc);
      continue;
      this.mLt.put("flag", "4");
      this.mLt.put("bank_type", paramAuthen.mOb);
      this.mLt.put("first_name", paramAuthen.qsR);
      this.mLt.put("last_name", paramAuthen.qsS);
      this.mLt.put("country", paramAuthen.country);
      this.mLt.put("area", paramAuthen.cCA);
      this.mLt.put("city", paramAuthen.cCB);
      this.mLt.put("address", paramAuthen.ekZ);
      this.mLt.put("phone_number", paramAuthen.lnV);
      this.mLt.put("zip_code", paramAuthen.ftq);
      this.mLt.put("email", paramAuthen.cCt);
      this.mLt.put("bank_card_id", paramAuthen.qsM);
      if (!bk.bl(paramAuthen.qsN)) {
        this.mLt.put("cvv2", paramAuthen.qsN);
      }
      if (!bk.bl(paramAuthen.qsO))
      {
        this.mLt.put("valid_thru", paramAuthen.qsO);
        continue;
        this.mLt.put("flag", "5");
        this.mLt.put("bank_type", paramAuthen.mOb);
        this.mLt.put("first_name", paramAuthen.qsR);
        this.mLt.put("last_name", paramAuthen.qsS);
        this.mLt.put("country", paramAuthen.country);
        this.mLt.put("area", paramAuthen.cCA);
        this.mLt.put("city", paramAuthen.cCB);
        this.mLt.put("address", paramAuthen.ekZ);
        this.mLt.put("phone_number", paramAuthen.lnV);
        this.mLt.put("zip_code", paramAuthen.ftq);
        this.mLt.put("email", paramAuthen.cCt);
        this.mLt.put("bank_card_id", paramAuthen.qsM);
        if (!bk.bl(paramAuthen.qsN)) {
          this.mLt.put("cvv2", paramAuthen.qsN);
        }
        if (!bk.bl(paramAuthen.qsO)) {
          this.mLt.put("valid_thru", paramAuthen.qsO);
        }
        this.mLt.put("h_bind_serial", paramAuthen.mOc);
        this.mLt.put("card_tail", paramAuthen.qsP);
        continue;
        if (paramAuthen.qsH == 1)
        {
          this.mLt.put("reset_flag", "1");
          if (!bk.bl(paramAuthen.qsN)) {
            this.mLt.put("cvv2", paramAuthen.qsN);
          }
          if (!bk.bl(paramAuthen.qsO)) {
            this.mLt.put("valid_thru", paramAuthen.qsO);
          }
        }
        this.mLt.put("phone_number", paramAuthen.qqU);
        this.mLt.put("flag", "6");
        this.mLt.put("bank_type", paramAuthen.mOb);
        this.mLt.put("bind_serial", paramAuthen.mOc);
      }
    }
  }
  
  public int HH()
  {
    if (this.qmd.nqa.bUV == 11) {
      return 1610;
    }
    if (this.qmd.nqa.bUV == 21) {
      return 1605;
    }
    return 461;
  }
  
  protected void P(Map<String, String> paramMap) {}
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramString, paramJSONObject);
    y.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + paramInt + " errMsg :" + paramString);
    y.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[] { this.qme });
    this.qmb = "1".equals(paramJSONObject.optString("is_free_sms"));
    this.token = paramJSONObject.optString("token");
    this.qme = paramJSONObject.optString("balance_mobile");
    this.qmf = paramJSONObject.optString("balance_help_url");
    this.qmg = paramJSONObject.optString("modify_mobile_url");
    paramString = paramJSONObject.optString("bind_serial");
    if (!bk.bl(paramString)) {
      y.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:" + paramString);
    }
    if ("1".equals(paramJSONObject.optString("pay_flag")))
    {
      this.qno = true;
      this.qmc = Orders.a(paramJSONObject, this.qmc);
    }
    for (;;)
    {
      paramString = paramJSONObject.optJSONObject("verify_cre_tail_info");
      if (paramString != null)
      {
        this.qmh = paramString.optInt("is_can_verify_tail", 0);
        this.qmi = paramString.optString("verify_tail_wording");
      }
      this.qmj = paramJSONObject.optInt("no_reset_mobile", 0);
      y.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.qmd.nqa.bUV);
      if ((paramInt != 0) || (this.qmd.nqa.bUV != 39)) {
        break;
      }
      y.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
      com.tencent.mm.plugin.wallet_core.e.b.aw(paramJSONObject);
      return;
      this.qno = false;
    }
    y.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:" + paramInt);
  }
  
  public int aEC()
  {
    return 0;
  }
  
  public final boolean bTQ()
  {
    return this.qmd.nqa.qFX == 1;
  }
  
  public final boolean bTR()
  {
    return (this.qmd.nqa.bUV == 11) || (this.qmd.nqa.bUV == 21);
  }
  
  public final boolean bqc()
  {
    super.bqc();
    this.mLt.put("is_repeat_send", "1");
    D(this.mLt);
    return true;
  }
  
  public final String getToken()
  {
    return this.token;
  }
  
  public String getUri()
  {
    if (this.qmd.nqa.bUV == 11) {
      return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
    }
    if (this.qmd.nqa.bUV == 21) {
      return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
    }
    return "/cgi-bin/mmpay-bin/tenpay/authen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.a.b
 * JD-Core Version:    0.7.0.1
 */