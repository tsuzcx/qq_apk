package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  public boolean CIk;
  private Map<String, String> CIl;
  public u COB;
  public String mReqKey;
  private String token;
  private Map<String, String> wyE;
  
  public a(Authen paramAuthen, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69882);
    this.mReqKey = null;
    this.token = null;
    this.wyE = new HashMap();
    this.CIl = new HashMap();
    setPayInfo(paramAuthen.xnF, this.wyE, this.CIl);
    this.wyE.put("flag", paramAuthen.dDp);
    this.wyE.put("bank_type", paramAuthen.dkR);
    this.wyE.put("mobile_area", paramAuthen.CUe);
    this.wyE.put("session_id", paramString2);
    if (!bt.isNullOrNil(paramAuthen.CTP)) {
      this.wyE.put("passwd", paramAuthen.CTP);
    }
    if (!bt.isNullOrNil(paramAuthen.token)) {
      this.wyE.put("token", paramAuthen.token);
    }
    if (!bt.isNullOrNil(paramAuthen.CFm))
    {
      g.ajD();
      paramString2 = new p(bt.a((Integer)g.ajC().ajl().get(9, null), 0));
      this.wyE.put("import_code", paramAuthen.CFm);
      this.wyE.put("qqid", paramString2.toString());
      if (paramAuthen.CTR > 0) {
        this.wyE.put("cre_type", paramAuthen.CTR);
      }
      this.wyE.put("bind_serailno", paramAuthen.wBI);
    }
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
      this.wyE.put("language", ac.fks());
    }
    if (!bt.isNullOrNil(paramAuthen.CTa)) {
      this.wyE.put("true_name", paramAuthen.CTa);
    }
    if (!bt.isNullOrNil(paramAuthen.CTQ)) {
      this.wyE.put("identify_card", paramAuthen.CTQ);
    }
    if (paramAuthen.CTR > 0) {
      this.wyE.put("cre_type", paramAuthen.CTR);
    }
    if (!bt.isNullOrNil(paramAuthen.CPf)) {
      this.wyE.put("mobile_no", paramAuthen.CPf);
    }
    this.wyE.put("bank_card_id", paramAuthen.CTS);
    if (!bt.isNullOrNil(paramAuthen.CTT)) {
      this.wyE.put("cvv2", paramAuthen.CTT);
    }
    if (!bt.isNullOrNil(paramAuthen.CTU)) {
      this.wyE.put("valid_thru", paramAuthen.CTU);
    }
    if ((paramAuthen.dDp == 1) || (paramAuthen.dDp == 2))
    {
      this.wyE.put("creid_renewal", String.valueOf(paramAuthen.CTk));
      this.wyE.put("birth_date", paramAuthen.CTp);
      this.wyE.put("cre_expire_date", paramAuthen.CTl);
    }
    if (((paramAuthen.dDp == 2) || (paramAuthen.dDp == 5)) && (paramAuthen.CUf == 1) && (!bt.isNullOrNil(paramAuthen.CPp)))
    {
      this.wyE.put("verify_user_token", "1");
      this.wyE.put("usertoken", paramAuthen.CPp);
    }
    if ((!bt.isNullOrNil(paramAuthen.CUg)) && (paramAuthen.CUg.isEmpty())) {
      this.wyE.put("checkpayjsapi_token", paramAuthen.CUg);
    }
    if (z.fRx())
    {
      this.CIl.put("uuid_for_bindcard", z.getBindCardUuid());
      this.CIl.put("bindcard_scene", z.fRy());
    }
    if (!bt.isNullOrNil(paramString1)) {
      this.wyE.put("has_underage_alert", paramString1);
    }
    setRequestData(this.wyE);
    setWXRequestData(this.CIl);
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
      this.COB = u.bm(paramJSONObject);
    }
    AppMethodBeat.o(69884);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(69883);
    super.resend();
    this.wyE.put("is_repeat_send", "1");
    setRequestData(this.wyE);
    this.CIk = true;
    AppMethodBeat.o(69883);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */