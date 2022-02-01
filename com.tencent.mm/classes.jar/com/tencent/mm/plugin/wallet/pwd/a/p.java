package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends m
{
  public boolean CZQ;
  private String token;
  private Map<String, String> wOp;
  
  public p(Authen paramAuthen, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(69567);
    this.token = null;
    this.wOp = new HashMap();
    this.wOp.put("flag", paramAuthen.dEu);
    if (!bu.isNullOrNil(paramAuthen.DlC))
    {
      this.wOp.put("first_name", paramAuthen.DlC);
      this.wOp.put("last_name", paramAuthen.DlD);
      this.wOp.put("country", paramAuthen.country);
      this.wOp.put("area", paramAuthen.eRf);
      this.wOp.put("city", paramAuthen.eRg);
      this.wOp.put("address", paramAuthen.hZQ);
      this.wOp.put("phone_number", paramAuthen.uVu);
      this.wOp.put("zip_code", paramAuthen.juG);
      this.wOp.put("email", paramAuthen.eQY);
    }
    this.wOp.put("business_source", String.valueOf(paramInt));
    this.wOp.put("bank_type", paramAuthen.dlT);
    if (paramAuthen.Dlx > 0) {
      this.wOp.put("cre_type", paramAuthen.Dlx);
    }
    if (!bu.isNullOrNil(paramAuthen.DkG)) {
      this.wOp.put("true_name", paramAuthen.DkG);
    }
    if (!bu.isNullOrNil(paramAuthen.Dlw)) {
      this.wOp.put("identify_card", paramAuthen.Dlw);
    }
    this.wOp.put("mobile_no", paramAuthen.DgJ);
    this.wOp.put("bank_card_id", paramAuthen.Dly);
    if (!bu.isNullOrNil(paramAuthen.Dlz)) {
      this.wOp.put("cvv2", paramAuthen.Dlz);
    }
    if (!bu.isNullOrNil(paramAuthen.DlA)) {
      this.wOp.put("valid_thru", paramAuthen.DlA);
    }
    Map localMap = this.wOp;
    if (paramBoolean) {}
    for (paramAuthen = "1";; paramAuthen = "0")
    {
      localMap.put("new_card_reset_pwd", paramAuthen);
      setRequestData(this.wOp);
      AppMethodBeat.o(69567);
      return;
    }
  }
  
  public final int getFuncId()
  {
    return 469;
  }
  
  public final int getTenpayCgicmd()
  {
    return 10;
  }
  
  public final String getToken()
  {
    return this.token;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69569);
    if (paramJSONObject != null) {
      this.token = paramJSONObject.optString("token");
    }
    AppMethodBeat.o(69569);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(69568);
    super.resend();
    this.wOp.put("is_repeat_send", "1");
    setRequestData(this.wOp);
    this.CZQ = true;
    AppMethodBeat.o(69568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.p
 * JD-Core Version:    0.7.0.1
 */