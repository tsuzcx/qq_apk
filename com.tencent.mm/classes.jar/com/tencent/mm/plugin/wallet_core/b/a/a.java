package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  private Map<String, String> AJV;
  public boolean HFE;
  private Map<String, String> HFF;
  public u HPz;
  public String mReqKey;
  private String token;
  
  public a(Authen paramAuthen, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69882);
    this.mReqKey = null;
    this.token = null;
    this.AJV = new HashMap();
    this.HFF = new HashMap();
    setPayInfo(paramAuthen.BDB, this.AJV, this.HFF);
    this.AJV.put("flag", paramAuthen.cSx);
    this.AJV.put("bank_type", paramAuthen.dDj);
    this.AJV.put("mobile_area", paramAuthen.HVd);
    this.AJV.put("session_id", paramString2);
    if (!Util.isNullOrNil(paramAuthen.HUO)) {
      this.AJV.put("passwd", paramAuthen.HUO);
    }
    if (!Util.isNullOrNil(paramAuthen.token)) {
      this.AJV.put("token", paramAuthen.token);
    }
    if (!Util.isNullOrNil(paramAuthen.HCy))
    {
      g.aAi();
      paramString2 = new p(Util.nullAs((Integer)g.aAh().azQ().get(9, null), 0));
      this.AJV.put("import_code", paramAuthen.HCy);
      this.AJV.put("qqid", paramString2.toString());
      if (paramAuthen.HUQ > 0) {
        this.AJV.put("cre_type", paramAuthen.HUQ);
      }
      this.AJV.put("bind_serailno", paramAuthen.ANo);
    }
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
      this.AJV.put("language", LocaleUtil.getApplicationLanguage());
    }
    if (!Util.isNullOrNil(paramAuthen.HTZ)) {
      this.AJV.put("true_name", paramAuthen.HTZ);
    }
    if (!Util.isNullOrNil(paramAuthen.HUP)) {
      this.AJV.put("identify_card", paramAuthen.HUP);
    }
    if (paramAuthen.HUQ > 0) {
      this.AJV.put("cre_type", paramAuthen.HUQ);
    }
    if (!Util.isNullOrNil(paramAuthen.HQc)) {
      this.AJV.put("mobile_no", paramAuthen.HQc);
    }
    this.AJV.put("bank_card_id", paramAuthen.HUR);
    if (!Util.isNullOrNil(paramAuthen.HUS)) {
      this.AJV.put("cvv2", paramAuthen.HUS);
    }
    if (!Util.isNullOrNil(paramAuthen.HUT)) {
      this.AJV.put("valid_thru", paramAuthen.HUT);
    }
    if ((paramAuthen.cSx == 1) || (paramAuthen.cSx == 2))
    {
      this.AJV.put("creid_renewal", String.valueOf(paramAuthen.HUj));
      this.AJV.put("birth_date", paramAuthen.HUo);
      this.AJV.put("cre_expire_date", paramAuthen.HUk);
    }
    if (((paramAuthen.cSx == 2) || (paramAuthen.cSx == 5)) && (paramAuthen.HVe == 1) && (!Util.isNullOrNil(paramAuthen.HQm)))
    {
      this.AJV.put("verify_user_token", "1");
      this.AJV.put("usertoken", paramAuthen.HQm);
    }
    if ((!Util.isNullOrNil(paramAuthen.HVf)) && (paramAuthen.HVf.isEmpty())) {
      this.AJV.put("checkpayjsapi_token", paramAuthen.HVf);
    }
    if (z.hhq())
    {
      this.HFF.put("uuid_for_bindcard", z.getBindCardUuid());
      this.HFF.put("bindcard_scene", z.hhr());
    }
    if (!Util.isNullOrNil(paramString1)) {
      this.AJV.put("has_underage_alert", paramString1);
    }
    setRequestData(this.AJV);
    setWXRequestData(this.HFF);
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
      this.HPz = u.bM(paramJSONObject);
    }
    AppMethodBeat.o(69884);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(69883);
    super.resend();
    this.AJV.put("is_repeat_send", "1");
    setRequestData(this.AJV);
    this.HFE = true;
    AppMethodBeat.o(69883);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */