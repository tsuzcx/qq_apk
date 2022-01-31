package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends j
{
  private Map<String, String> mLt = new HashMap();
  public String token = null;
  
  public g(Authen paramAuthen, boolean paramBoolean, int paramInt)
  {
    this.mLt.put("flag", paramAuthen.bcw);
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
    }
    this.mLt.put("business_source", String.valueOf(paramInt));
    this.mLt.put("bank_type", paramAuthen.mOb);
    if (paramAuthen.qsL > 0) {
      this.mLt.put("cre_type", paramAuthen.qsL);
    }
    if (!bk.bl(paramAuthen.qsJ)) {
      this.mLt.put("true_name", paramAuthen.qsJ);
    }
    if (!bk.bl(paramAuthen.qsK)) {
      this.mLt.put("identify_card", paramAuthen.qsK);
    }
    this.mLt.put("mobile_no", paramAuthen.qqU);
    this.mLt.put("bank_card_id", paramAuthen.qsM);
    if (!bk.bl(paramAuthen.qsN)) {
      this.mLt.put("cvv2", paramAuthen.qsN);
    }
    if (!bk.bl(paramAuthen.qsO)) {
      this.mLt.put("valid_thru", paramAuthen.qsO);
    }
    Map localMap = this.mLt;
    if (paramBoolean) {}
    for (paramAuthen = "1";; paramAuthen = "0")
    {
      localMap.put("new_card_reset_pwd", paramAuthen);
      D(this.mLt);
      return;
    }
  }
  
  public final int HH()
  {
    return 469;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.token = paramJSONObject.optString("token");
    }
  }
  
  public final int aEC()
  {
    return 10;
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
    return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */