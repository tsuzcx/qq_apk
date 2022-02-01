package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.v;
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
  private Map<String, String> ECl;
  public v OHH;
  public boolean Oxx;
  private Map<String, String> Oxy;
  public String mReqKey;
  private String token;
  
  public a(Authen paramAuthen, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69882);
    this.mReqKey = null;
    this.token = null;
    this.ECl = new HashMap();
    this.Oxy = new HashMap();
    setPayInfo(paramAuthen.HzF, this.ECl, this.Oxy);
    this.ECl.put("flag", paramAuthen.cUP);
    this.ECl.put("bank_type", paramAuthen.fvP);
    this.ECl.put("mobile_area", paramAuthen.ONe);
    this.ECl.put("session_id", paramString2);
    if (!Util.isNullOrNil(paramAuthen.OMP)) {
      this.ECl.put("passwd", paramAuthen.OMP);
    }
    if (!Util.isNullOrNil(paramAuthen.token)) {
      this.ECl.put("token", paramAuthen.token);
    }
    if (!Util.isNullOrNil(paramAuthen.Our))
    {
      h.aHH();
      paramString2 = new p(Util.nullAs((Integer)h.aHG().aHp().b(9, null), 0));
      this.ECl.put("import_code", paramAuthen.Our);
      this.ECl.put("qqid", paramString2.toString());
      if (paramAuthen.OMR > 0) {
        this.ECl.put("cre_type", paramAuthen.OMR);
      }
      this.ECl.put("bind_serailno", paramAuthen.GGC);
    }
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
      this.ECl.put("language", LocaleUtil.getApplicationLanguage());
    }
    if (!Util.isNullOrNil(paramAuthen.OMa)) {
      this.ECl.put("true_name", paramAuthen.OMa);
    }
    if (!Util.isNullOrNil(paramAuthen.OMQ)) {
      this.ECl.put("identify_card", paramAuthen.OMQ);
    }
    if (paramAuthen.OMR > 0) {
      this.ECl.put("cre_type", paramAuthen.OMR);
    }
    if (!Util.isNullOrNil(paramAuthen.OIl)) {
      this.ECl.put("mobile_no", paramAuthen.OIl);
    }
    this.ECl.put("bank_card_id", paramAuthen.OMS);
    if (!Util.isNullOrNil(paramAuthen.OMT)) {
      this.ECl.put("cvv2", paramAuthen.OMT);
    }
    if (!Util.isNullOrNil(paramAuthen.OMU)) {
      this.ECl.put("valid_thru", paramAuthen.OMU);
    }
    if ((paramAuthen.cUP == 1) || (paramAuthen.cUP == 2))
    {
      this.ECl.put("creid_renewal", String.valueOf(paramAuthen.OMk));
      this.ECl.put("birth_date", paramAuthen.OMp);
      this.ECl.put("cre_expire_date", paramAuthen.OMl);
    }
    if (((paramAuthen.cUP == 2) || (paramAuthen.cUP == 5)) && (paramAuthen.ONf == 1) && (!Util.isNullOrNil(paramAuthen.OIv)))
    {
      this.ECl.put("verify_user_token", "1");
      this.ECl.put("usertoken", paramAuthen.OIv);
    }
    if ((!Util.isNullOrNil(paramAuthen.ONg)) && (paramAuthen.ONg.isEmpty())) {
      this.ECl.put("checkpayjsapi_token", paramAuthen.ONg);
    }
    if (z.iiS())
    {
      this.Oxy.put("uuid_for_bindcard", z.getBindCardUuid());
      this.Oxy.put("bindcard_scene", z.iiT());
    }
    if (!Util.isNullOrNil(paramString1)) {
      this.ECl.put("has_underage_alert", paramString1);
    }
    setRequestData(this.ECl);
    setWXRequestData(this.Oxy);
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
      this.OHH = v.bX(paramJSONObject);
    }
    AppMethodBeat.o(69884);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(69883);
    super.resend();
    this.ECl.put("is_repeat_send", "1");
    setRequestData(this.ECl);
    this.Oxx = true;
    AppMethodBeat.o(69883);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */