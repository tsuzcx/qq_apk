package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends m
{
  public boolean CIk;
  private String token;
  private Map<String, String> wyE;
  
  public p(Authen paramAuthen, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(69567);
    this.token = null;
    this.wyE = new HashMap();
    this.wyE.put("flag", paramAuthen.dDp);
    if (!bt.isNullOrNil(paramAuthen.CTW))
    {
      this.wyE.put("first_name", paramAuthen.CTW);
      this.wyE.put("last_name", paramAuthen.CTX);
      this.wyE.put("country", paramAuthen.country);
      this.wyE.put("area", paramAuthen.ePu);
      this.wyE.put("city", paramAuthen.ePv);
      this.wyE.put("address", paramAuthen.hWY);
      this.wyE.put("phone_number", paramAuthen.uJH);
      this.wyE.put("zip_code", paramAuthen.jrN);
      this.wyE.put("email", paramAuthen.ePn);
    }
    this.wyE.put("business_source", String.valueOf(paramInt));
    this.wyE.put("bank_type", paramAuthen.dkR);
    if (paramAuthen.CTR > 0) {
      this.wyE.put("cre_type", paramAuthen.CTR);
    }
    if (!bt.isNullOrNil(paramAuthen.CTa)) {
      this.wyE.put("true_name", paramAuthen.CTa);
    }
    if (!bt.isNullOrNil(paramAuthen.CTQ)) {
      this.wyE.put("identify_card", paramAuthen.CTQ);
    }
    this.wyE.put("mobile_no", paramAuthen.CPf);
    this.wyE.put("bank_card_id", paramAuthen.CTS);
    if (!bt.isNullOrNil(paramAuthen.CTT)) {
      this.wyE.put("cvv2", paramAuthen.CTT);
    }
    if (!bt.isNullOrNil(paramAuthen.CTU)) {
      this.wyE.put("valid_thru", paramAuthen.CTU);
    }
    Map localMap = this.wyE;
    if (paramBoolean) {}
    for (paramAuthen = "1";; paramAuthen = "0")
    {
      localMap.put("new_card_reset_pwd", paramAuthen);
      setRequestData(this.wyE);
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
    this.wyE.put("is_repeat_send", "1");
    setRequestData(this.wyE);
    this.CIk = true;
    AppMethodBeat.o(69568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.p
 * JD-Core Version:    0.7.0.1
 */