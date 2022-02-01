package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends m
{
  public boolean BhW;
  private String token;
  private Map<String, String> vtm;
  
  public p(Authen paramAuthen, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(69567);
    this.token = null;
    this.vtm = new HashMap();
    this.vtm.put("flag", paramAuthen.drx);
    if (!bs.isNullOrNil(paramAuthen.BtH))
    {
      this.vtm.put("first_name", paramAuthen.BtH);
      this.vtm.put("last_name", paramAuthen.BtI);
      this.vtm.put("country", paramAuthen.country);
      this.vtm.put("area", paramAuthen.exV);
      this.vtm.put("city", paramAuthen.exW);
      this.vtm.put("address", paramAuthen.hEt);
      this.vtm.put("phone_number", paramAuthen.tGU);
      this.vtm.put("zip_code", paramAuthen.iYE);
      this.vtm.put("email", paramAuthen.exO);
    }
    this.vtm.put("business_source", String.valueOf(paramInt));
    this.vtm.put("bank_type", paramAuthen.cZz);
    if (paramAuthen.BtC > 0) {
      this.vtm.put("cre_type", paramAuthen.BtC);
    }
    if (!bs.isNullOrNil(paramAuthen.BsL)) {
      this.vtm.put("true_name", paramAuthen.BsL);
    }
    if (!bs.isNullOrNil(paramAuthen.BtB)) {
      this.vtm.put("identify_card", paramAuthen.BtB);
    }
    this.vtm.put("mobile_no", paramAuthen.BoQ);
    this.vtm.put("bank_card_id", paramAuthen.BtD);
    if (!bs.isNullOrNil(paramAuthen.BtE)) {
      this.vtm.put("cvv2", paramAuthen.BtE);
    }
    if (!bs.isNullOrNil(paramAuthen.BtF)) {
      this.vtm.put("valid_thru", paramAuthen.BtF);
    }
    Map localMap = this.vtm;
    if (paramBoolean) {}
    for (paramAuthen = "1";; paramAuthen = "0")
    {
      localMap.put("new_card_reset_pwd", paramAuthen);
      setRequestData(this.vtm);
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
    this.vtm.put("is_repeat_send", "1");
    setRequestData(this.vtm);
    this.BhW = true;
    AppMethodBeat.o(69568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.p
 * JD-Core Version:    0.7.0.1
 */