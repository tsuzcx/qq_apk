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
  private Map<String, String> AJV;
  public boolean HFE;
  private String token;
  
  public p(Authen paramAuthen, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(69567);
    this.token = null;
    this.AJV = new HashMap();
    this.AJV.put("flag", paramAuthen.cSx);
    if (!Util.isNullOrNil(paramAuthen.HUV))
    {
      this.AJV.put("first_name", paramAuthen.HUV);
      this.AJV.put("last_name", paramAuthen.HUW);
      this.AJV.put("country", paramAuthen.country);
      this.AJV.put("area", paramAuthen.fuJ);
      this.AJV.put("city", paramAuthen.fuK);
      this.AJV.put("address", paramAuthen.iUO);
      this.AJV.put("phone_number", paramAuthen.ynV);
      this.AJV.put("zip_code", paramAuthen.ksV);
      this.AJV.put("email", paramAuthen.fuD);
    }
    this.AJV.put("business_source", String.valueOf(paramInt));
    this.AJV.put("bank_type", paramAuthen.dDj);
    if (paramAuthen.HUQ > 0) {
      this.AJV.put("cre_type", paramAuthen.HUQ);
    }
    if (!Util.isNullOrNil(paramAuthen.HTZ)) {
      this.AJV.put("true_name", paramAuthen.HTZ);
    }
    if (!Util.isNullOrNil(paramAuthen.HUP)) {
      this.AJV.put("identify_card", paramAuthen.HUP);
    }
    this.AJV.put("mobile_no", paramAuthen.HQc);
    this.AJV.put("bank_card_id", paramAuthen.HUR);
    if (!Util.isNullOrNil(paramAuthen.HUS)) {
      this.AJV.put("cvv2", paramAuthen.HUS);
    }
    if (!Util.isNullOrNil(paramAuthen.HUT)) {
      this.AJV.put("valid_thru", paramAuthen.HUT);
    }
    Map localMap = this.AJV;
    if (paramBoolean) {}
    for (paramAuthen = "1";; paramAuthen = "0")
    {
      localMap.put("new_card_reset_pwd", paramAuthen);
      setRequestData(this.AJV);
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
    this.AJV.put("is_repeat_send", "1");
    setRequestData(this.AJV);
    this.HFE = true;
    AppMethodBeat.o(69568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.p
 * JD-Core Version:    0.7.0.1
 */