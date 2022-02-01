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
  private String token;
  private Map<String, String> ukq;
  public boolean zPC;
  
  public p(Authen paramAuthen, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(69567);
    this.token = null;
    this.ukq = new HashMap();
    this.ukq.put("flag", paramAuthen.dtM);
    if (!bt.isNullOrNil(paramAuthen.Abn))
    {
      this.ukq.put("first_name", paramAuthen.Abn);
      this.ukq.put("last_name", paramAuthen.Abo);
      this.ukq.put("country", paramAuthen.country);
      this.ukq.put("area", paramAuthen.evz);
      this.ukq.put("city", paramAuthen.evA);
      this.ukq.put("address", paramAuthen.hdQ);
      this.ukq.put("phone_number", paramAuthen.szk);
      this.ukq.put("zip_code", paramAuthen.iyB);
      this.ukq.put("email", paramAuthen.evs);
    }
    this.ukq.put("business_source", String.valueOf(paramInt));
    this.ukq.put("bank_type", paramAuthen.dca);
    if (paramAuthen.Abi > 0) {
      this.ukq.put("cre_type", paramAuthen.Abi);
    }
    if (!bt.isNullOrNil(paramAuthen.Aar)) {
      this.ukq.put("true_name", paramAuthen.Aar);
    }
    if (!bt.isNullOrNil(paramAuthen.Abh)) {
      this.ukq.put("identify_card", paramAuthen.Abh);
    }
    this.ukq.put("mobile_no", paramAuthen.zWw);
    this.ukq.put("bank_card_id", paramAuthen.Abj);
    if (!bt.isNullOrNil(paramAuthen.Abk)) {
      this.ukq.put("cvv2", paramAuthen.Abk);
    }
    if (!bt.isNullOrNil(paramAuthen.Abl)) {
      this.ukq.put("valid_thru", paramAuthen.Abl);
    }
    Map localMap = this.ukq;
    if (paramBoolean) {}
    for (paramAuthen = "1";; paramAuthen = "0")
    {
      localMap.put("new_card_reset_pwd", paramAuthen);
      setRequestData(this.ukq);
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
    this.ukq.put("is_repeat_send", "1");
    setRequestData(this.ukq);
    this.zPC = true;
    AppMethodBeat.o(69568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.p
 * JD-Core Version:    0.7.0.1
 */