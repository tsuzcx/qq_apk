package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  private Map<String, String> Kvm;
  public boolean VmI;
  private Map<String, String> VmJ;
  public v Vxt;
  public String mReqKey;
  private String token;
  
  public a(Authen paramAuthen, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69882);
    this.mReqKey = null;
    this.token = null;
    this.Kvm = new HashMap();
    this.VmJ = new HashMap();
    setPayInfo(paramAuthen.Nxi, this.Kvm, this.VmJ);
    this.Kvm.put("flag", paramAuthen.eQp);
    this.Kvm.put("bank_type", paramAuthen.hAk);
    this.Kvm.put("mobile_area", paramAuthen.VCP);
    this.Kvm.put("session_id", paramString2);
    if (!Util.isNullOrNil(paramAuthen.VCA)) {
      this.Kvm.put("passwd", paramAuthen.VCA);
    }
    if (!Util.isNullOrNil(paramAuthen.token)) {
      this.Kvm.put("token", paramAuthen.token);
    }
    if (!Util.isNullOrNil(paramAuthen.VjF))
    {
      h.baF();
      paramString2 = new p(Util.nullAs((Integer)h.baE().ban().d(9, null), 0));
      this.Kvm.put("import_code", paramAuthen.VjF);
      this.Kvm.put("qqid", paramString2.toString());
      if (paramAuthen.VCC > 0) {
        this.Kvm.put("cre_type", paramAuthen.VCC);
      }
      this.Kvm.put("bind_serailno", paramAuthen.MDt);
    }
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
      this.Kvm.put("language", LocaleUtil.getApplicationLanguage());
    }
    if (!Util.isNullOrNil(paramAuthen.VBL)) {
      this.Kvm.put("true_name", paramAuthen.VBL);
    }
    if (!Util.isNullOrNil(paramAuthen.VCB)) {
      this.Kvm.put("identify_card", paramAuthen.VCB);
    }
    if (paramAuthen.VCC > 0) {
      this.Kvm.put("cre_type", paramAuthen.VCC);
    }
    if (!Util.isNullOrNil(paramAuthen.VxX)) {
      this.Kvm.put("mobile_no", paramAuthen.VxX);
    }
    this.Kvm.put("bank_card_id", paramAuthen.VCD);
    if (!Util.isNullOrNil(paramAuthen.VCE)) {
      this.Kvm.put("cvv2", paramAuthen.VCE);
    }
    if (!Util.isNullOrNil(paramAuthen.VCF)) {
      this.Kvm.put("valid_thru", paramAuthen.VCF);
    }
    if ((paramAuthen.eQp == 1) || (paramAuthen.eQp == 2))
    {
      this.Kvm.put("creid_renewal", String.valueOf(paramAuthen.VBV));
      this.Kvm.put("birth_date", paramAuthen.VCa);
      this.Kvm.put("cre_expire_date", paramAuthen.VBW);
    }
    if (((paramAuthen.eQp == 2) || (paramAuthen.eQp == 5)) && (paramAuthen.VCQ == 1) && (!Util.isNullOrNil(paramAuthen.Vyh)))
    {
      this.Kvm.put("verify_user_token", "1");
      this.Kvm.put("usertoken", paramAuthen.Vyh);
    }
    if ((!Util.isNullOrNil(paramAuthen.VCR)) && (paramAuthen.VCR.isEmpty())) {
      this.Kvm.put("checkpayjsapi_token", paramAuthen.VCR);
    }
    if (aa.jOO())
    {
      this.VmJ.put("uuid_for_bindcard", aa.getBindCardUuid());
      this.VmJ.put("bindcard_scene", aa.jOP());
    }
    if (!Util.isNullOrNil(paramString1)) {
      this.Kvm.put("has_underage_alert", paramString1);
    }
    setRequestData(this.Kvm);
    setWXRequestData(this.VmJ);
    AppMethodBeat.o(69882);
  }
  
  public final int getFuncId()
  {
    return 471;
  }
  
  public final int getTenpayCgicmd()
  {
    return 12;
  }
  
  public final String getToken()
  {
    return this.token;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69884);
    if (paramJSONObject != null)
    {
      this.mReqKey = paramJSONObject.optString("req_key");
      this.token = paramJSONObject.optString("token");
      this.Vxt = v.ct(paramJSONObject);
    }
    AppMethodBeat.o(69884);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(69883);
    super.resend();
    this.Kvm.put("is_repeat_send", "1");
    setRequestData(this.Kvm);
    this.VmI = true;
    AppMethodBeat.o(69883);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */