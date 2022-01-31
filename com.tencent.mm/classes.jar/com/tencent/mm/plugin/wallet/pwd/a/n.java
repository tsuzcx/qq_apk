package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends m
{
  private Map<String, String> plK;
  private String token;
  
  public n(Authen paramAuthen, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(46193);
    this.token = null;
    this.plK = new HashMap();
    this.plK.put("flag", paramAuthen.bsY);
    if (!bo.isNullOrNil(paramAuthen.ufe))
    {
      this.plK.put("first_name", paramAuthen.ufe);
      this.plK.put("last_name", paramAuthen.uff);
      this.plK.put("country", paramAuthen.country);
      this.plK.put("area", paramAuthen.province);
      this.plK.put("city", paramAuthen.city);
      this.plK.put("address", paramAuthen.fBq);
      this.plK.put("phone_number", paramAuthen.nLs);
      this.plK.put("zip_code", paramAuthen.gKS);
      this.plK.put("email", paramAuthen.dqF);
    }
    this.plK.put("business_source", String.valueOf(paramInt));
    this.plK.put("bank_type", paramAuthen.poq);
    if (paramAuthen.ueY > 0) {
      this.plK.put("cre_type", paramAuthen.ueY);
    }
    if (!bo.isNullOrNil(paramAuthen.ueu)) {
      this.plK.put("true_name", paramAuthen.ueu);
    }
    if (!bo.isNullOrNil(paramAuthen.ueX)) {
      this.plK.put("identify_card", paramAuthen.ueX);
    }
    this.plK.put("mobile_no", paramAuthen.ubQ);
    this.plK.put("bank_card_id", paramAuthen.ueZ);
    if (!bo.isNullOrNil(paramAuthen.ufa)) {
      this.plK.put("cvv2", paramAuthen.ufa);
    }
    if (!bo.isNullOrNil(paramAuthen.ufb)) {
      this.plK.put("valid_thru", paramAuthen.ufb);
    }
    Map localMap = this.plK;
    if (paramBoolean) {}
    for (paramAuthen = "1";; paramAuthen = "0")
    {
      localMap.put("new_card_reset_pwd", paramAuthen);
      setRequestData(this.plK);
      AppMethodBeat.o(46193);
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
    AppMethodBeat.i(46195);
    if (paramJSONObject != null) {
      this.token = paramJSONObject.optString("token");
    }
    AppMethodBeat.o(46195);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(46194);
    super.resend();
    this.plK.put("is_repeat_send", "1");
    setRequestData(this.plK);
    AppMethodBeat.o(46194);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.n
 * JD-Core Version:    0.7.0.1
 */