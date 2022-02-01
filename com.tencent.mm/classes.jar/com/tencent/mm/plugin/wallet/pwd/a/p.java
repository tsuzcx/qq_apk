package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends m
{
  private Map<String, String> ECl;
  public boolean Oxx;
  private String token;
  
  public p(Authen paramAuthen, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(69567);
    this.token = null;
    this.ECl = new HashMap();
    this.ECl.put("flag", paramAuthen.cUP);
    if (!Util.isNullOrNil(paramAuthen.OMW))
    {
      this.ECl.put("first_name", paramAuthen.OMW);
      this.ECl.put("last_name", paramAuthen.OMX);
      this.ECl.put("country", paramAuthen.country);
      this.ECl.put("area", paramAuthen.province);
      this.ECl.put("city", paramAuthen.city);
      this.ECl.put("address", paramAuthen.lLg);
      this.ECl.put("phone_number", paramAuthen.DNX);
      this.ECl.put("zip_code", paramAuthen.nkC);
      this.ECl.put("email", paramAuthen.hDf);
    }
    this.ECl.put("business_source", String.valueOf(paramInt));
    this.ECl.put("bank_type", paramAuthen.fvP);
    if (paramAuthen.OMR > 0) {
      this.ECl.put("cre_type", paramAuthen.OMR);
    }
    if (!Util.isNullOrNil(paramAuthen.OMa)) {
      this.ECl.put("true_name", paramAuthen.OMa);
    }
    if (!Util.isNullOrNil(paramAuthen.OMQ)) {
      this.ECl.put("identify_card", paramAuthen.OMQ);
    }
    this.ECl.put("mobile_no", paramAuthen.OIl);
    this.ECl.put("bank_card_id", paramAuthen.OMS);
    if (!Util.isNullOrNil(paramAuthen.OMT)) {
      this.ECl.put("cvv2", paramAuthen.OMT);
    }
    if (!Util.isNullOrNil(paramAuthen.OMU)) {
      this.ECl.put("valid_thru", paramAuthen.OMU);
    }
    Map localMap = this.ECl;
    if (paramBoolean) {}
    for (paramAuthen = "1";; paramAuthen = "0")
    {
      localMap.put("new_card_reset_pwd", paramAuthen);
      setRequestData(this.ECl);
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
    this.ECl.put("is_repeat_send", "1");
    setRequestData(this.ECl);
    this.Oxx = true;
    AppMethodBeat.o(69568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.p
 * JD-Core Version:    0.7.0.1
 */