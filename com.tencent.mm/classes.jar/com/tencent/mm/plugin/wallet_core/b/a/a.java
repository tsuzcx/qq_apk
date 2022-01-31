package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends j
{
  private Map<String, String> mLt = new HashMap();
  private Map<String, String> qma = new HashMap();
  public String qmm = null;
  public String token = null;
  
  public a(Authen paramAuthen)
  {
    a(paramAuthen.nqa, this.mLt, this.qma);
    this.mLt.put("flag", paramAuthen.bcw);
    this.mLt.put("bank_type", paramAuthen.mOb);
    this.mLt.put("mobile_area", paramAuthen.qsZ);
    if (!bk.bl(paramAuthen.qsI)) {
      this.mLt.put("passwd", paramAuthen.qsI);
    }
    if (!bk.bl(paramAuthen.token)) {
      this.mLt.put("token", paramAuthen.token);
    }
    if (!bk.bl(paramAuthen.qjv))
    {
      g.DQ();
      o localo = new o(bk.a((Integer)g.DP().Dz().get(9, null), 0));
      this.mLt.put("import_code", paramAuthen.qjv);
      this.mLt.put("qqid", localo.toString());
      if (paramAuthen.qsL > 0) {
        this.mLt.put("cre_type", paramAuthen.qsL);
      }
      this.mLt.put("bind_serailno", paramAuthen.mOc);
    }
    if (!bk.bl(paramAuthen.qsR))
    {
      this.mLt.put("first_name", paramAuthen.qsR);
      this.mLt.put("last_name", paramAuthen.qsS);
      this.mLt.put("country", paramAuthen.country);
      this.mLt.put("area", paramAuthen.cCA);
      this.mLt.put("city", paramAuthen.cCB);
      this.mLt.put("address", paramAuthen.ekZ);
      this.mLt.put("phone_number", paramAuthen.lnV);
      this.mLt.put("zip_code", paramAuthen.ftq);
      this.mLt.put("email", paramAuthen.cCt);
      this.mLt.put("language", x.cqJ());
    }
    if (!bk.bl(paramAuthen.qsJ)) {
      this.mLt.put("true_name", paramAuthen.qsJ);
    }
    if (!bk.bl(paramAuthen.qsK)) {
      this.mLt.put("identify_card", paramAuthen.qsK);
    }
    if (paramAuthen.qsL > 0) {
      this.mLt.put("cre_type", paramAuthen.qsL);
    }
    if (!bk.bl(paramAuthen.qqU)) {
      this.mLt.put("mobile_no", paramAuthen.qqU);
    }
    this.mLt.put("bank_card_id", paramAuthen.qsM);
    if (!bk.bl(paramAuthen.qsN)) {
      this.mLt.put("cvv2", paramAuthen.qsN);
    }
    if (!bk.bl(paramAuthen.qsO)) {
      this.mLt.put("valid_thru", paramAuthen.qsO);
    }
    if ((paramAuthen.bcw == 1) || (paramAuthen.bcw == 2))
    {
      this.mLt.put("creid_renewal", String.valueOf(paramAuthen.qta));
      this.mLt.put("birth_date", paramAuthen.qtb);
      this.mLt.put("cre_expire_date", paramAuthen.qtc);
    }
    if (v.cMA())
    {
      this.qma.put("uuid_for_bindcard", v.cMC());
      this.qma.put("bindcard_scene", v.cMB());
    }
    D(this.mLt);
    aC(this.qma);
  }
  
  public final int HH()
  {
    return 471;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.qmm = paramJSONObject.optString("req_key");
      this.token = paramJSONObject.optString("token");
    }
  }
  
  public final int aEC()
  {
    return 12;
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
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */