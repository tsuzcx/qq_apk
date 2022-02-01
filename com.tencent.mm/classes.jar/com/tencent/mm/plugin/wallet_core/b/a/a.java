package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  public boolean CZQ;
  private Map<String, String> CZR;
  public u Dgg;
  public String mReqKey;
  private String token;
  private Map<String, String> wOp;
  
  public a(Authen paramAuthen, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69882);
    this.mReqKey = null;
    this.token = null;
    this.wOp = new HashMap();
    this.CZR = new HashMap();
    setPayInfo(paramAuthen.xDC, this.wOp, this.CZR);
    this.wOp.put("flag", paramAuthen.dEu);
    this.wOp.put("bank_type", paramAuthen.dlT);
    this.wOp.put("mobile_area", paramAuthen.DlK);
    this.wOp.put("session_id", paramString2);
    if (!bu.isNullOrNil(paramAuthen.Dlv)) {
      this.wOp.put("passwd", paramAuthen.Dlv);
    }
    if (!bu.isNullOrNil(paramAuthen.token)) {
      this.wOp.put("token", paramAuthen.token);
    }
    if (!bu.isNullOrNil(paramAuthen.CWS))
    {
      g.ajS();
      paramString2 = new p(bu.a((Integer)g.ajR().ajA().get(9, null), 0));
      this.wOp.put("import_code", paramAuthen.CWS);
      this.wOp.put("qqid", paramString2.toString());
      if (paramAuthen.Dlx > 0) {
        this.wOp.put("cre_type", paramAuthen.Dlx);
      }
      this.wOp.put("bind_serailno", paramAuthen.wRt);
    }
    if (!bu.isNullOrNil(paramAuthen.DlC))
    {
      this.wOp.put("first_name", paramAuthen.DlC);
      this.wOp.put("last_name", paramAuthen.DlD);
      this.wOp.put("country", paramAuthen.country);
      this.wOp.put("area", paramAuthen.eRf);
      this.wOp.put("city", paramAuthen.eRg);
      this.wOp.put("address", paramAuthen.hZQ);
      this.wOp.put("phone_number", paramAuthen.uVu);
      this.wOp.put("zip_code", paramAuthen.juG);
      this.wOp.put("email", paramAuthen.eQY);
      this.wOp.put("language", ad.fom());
    }
    if (!bu.isNullOrNil(paramAuthen.DkG)) {
      this.wOp.put("true_name", paramAuthen.DkG);
    }
    if (!bu.isNullOrNil(paramAuthen.Dlw)) {
      this.wOp.put("identify_card", paramAuthen.Dlw);
    }
    if (paramAuthen.Dlx > 0) {
      this.wOp.put("cre_type", paramAuthen.Dlx);
    }
    if (!bu.isNullOrNil(paramAuthen.DgJ)) {
      this.wOp.put("mobile_no", paramAuthen.DgJ);
    }
    this.wOp.put("bank_card_id", paramAuthen.Dly);
    if (!bu.isNullOrNil(paramAuthen.Dlz)) {
      this.wOp.put("cvv2", paramAuthen.Dlz);
    }
    if (!bu.isNullOrNil(paramAuthen.DlA)) {
      this.wOp.put("valid_thru", paramAuthen.DlA);
    }
    if ((paramAuthen.dEu == 1) || (paramAuthen.dEu == 2))
    {
      this.wOp.put("creid_renewal", String.valueOf(paramAuthen.DkQ));
      this.wOp.put("birth_date", paramAuthen.DkV);
      this.wOp.put("cre_expire_date", paramAuthen.DkR);
    }
    if (((paramAuthen.dEu == 2) || (paramAuthen.dEu == 5)) && (paramAuthen.DlL == 1) && (!bu.isNullOrNil(paramAuthen.DgT)))
    {
      this.wOp.put("verify_user_token", "1");
      this.wOp.put("usertoken", paramAuthen.DgT);
    }
    if ((!bu.isNullOrNil(paramAuthen.DlM)) && (paramAuthen.DlM.isEmpty())) {
      this.wOp.put("checkpayjsapi_token", paramAuthen.DlM);
    }
    if (z.fVT())
    {
      this.CZR.put("uuid_for_bindcard", z.getBindCardUuid());
      this.CZR.put("bindcard_scene", z.fVU());
    }
    if (!bu.isNullOrNil(paramString1)) {
      this.wOp.put("has_underage_alert", paramString1);
    }
    setRequestData(this.wOp);
    setWXRequestData(this.CZR);
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
      this.Dgg = u.bm(paramJSONObject);
    }
    AppMethodBeat.o(69884);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(69883);
    super.resend();
    this.wOp.put("is_repeat_send", "1");
    setRequestData(this.wOp);
    this.CZQ = true;
    AppMethodBeat.o(69883);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */