package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o
  extends m
{
  private Map<String, String> Kvm;
  public boolean VmI;
  private String token;
  
  public o(Authen paramAuthen, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(69567);
    this.token = null;
    this.Kvm = new HashMap();
    this.Kvm.put("flag", paramAuthen.eQp);
    if (!Util.isNullOrNil(paramAuthen.VCH))
    {
      this.Kvm.put("first_name", paramAuthen.VCH);
      this.Kvm.put("last_name", paramAuthen.VCI);
      this.Kvm.put("country", paramAuthen.country);
      this.Kvm.put("area", paramAuthen.province);
      this.Kvm.put("city", paramAuthen.city);
      this.Kvm.put("address", paramAuthen.oDI);
      this.Kvm.put("phone_number", paramAuthen.JFm);
      this.Kvm.put("zip_code", paramAuthen.qhL);
      this.Kvm.put("email", paramAuthen.kab);
    }
    this.Kvm.put("business_source", String.valueOf(paramInt));
    this.Kvm.put("bank_type", paramAuthen.hAk);
    if (paramAuthen.VCC > 0) {
      this.Kvm.put("cre_type", paramAuthen.VCC);
    }
    if (!Util.isNullOrNil(paramAuthen.VBL)) {
      this.Kvm.put("true_name", paramAuthen.VBL);
    }
    if (!Util.isNullOrNil(paramAuthen.VCB)) {
      this.Kvm.put("identify_card", paramAuthen.VCB);
    }
    this.Kvm.put("mobile_no", paramAuthen.VxX);
    this.Kvm.put("bank_card_id", paramAuthen.VCD);
    if (!Util.isNullOrNil(paramAuthen.VCE)) {
      this.Kvm.put("cvv2", paramAuthen.VCE);
    }
    if (!Util.isNullOrNil(paramAuthen.VCF)) {
      this.Kvm.put("valid_thru", paramAuthen.VCF);
    }
    Map localMap = this.Kvm;
    if (paramBoolean) {}
    for (paramAuthen = "1";; paramAuthen = "0")
    {
      localMap.put("new_card_reset_pwd", paramAuthen);
      setRequestData(this.Kvm);
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
    this.Kvm.put("is_repeat_send", "1");
    setRequestData(this.Kvm);
    this.VmI = true;
    AppMethodBeat.o(69568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.o
 * JD-Core Version:    0.7.0.1
 */