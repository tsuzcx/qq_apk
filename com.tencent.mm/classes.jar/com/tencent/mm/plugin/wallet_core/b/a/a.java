package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  public boolean BhW;
  private Map<String, String> BhX;
  public t Bom;
  public String mReqKey;
  private String token;
  private Map<String, String> vtm;
  
  public a(Authen paramAuthen, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69882);
    this.mReqKey = null;
    this.token = null;
    this.vtm = new HashMap();
    this.BhX = new HashMap();
    setPayInfo(paramAuthen.wfX, this.vtm, this.BhX);
    this.vtm.put("flag", paramAuthen.drx);
    this.vtm.put("bank_type", paramAuthen.cZz);
    this.vtm.put("mobile_area", paramAuthen.BtP);
    this.vtm.put("session_id", paramString2);
    if (!bs.isNullOrNil(paramAuthen.BtA)) {
      this.vtm.put("passwd", paramAuthen.BtA);
    }
    if (!bs.isNullOrNil(paramAuthen.token)) {
      this.vtm.put("token", paramAuthen.token);
    }
    if (!bs.isNullOrNil(paramAuthen.BeX))
    {
      g.agS();
      paramString2 = new p(bs.a((Integer)g.agR().agA().get(9, null), 0));
      this.vtm.put("import_code", paramAuthen.BeX);
      this.vtm.put("qqid", paramString2.toString());
      if (paramAuthen.BtC > 0) {
        this.vtm.put("cre_type", paramAuthen.BtC);
      }
      this.vtm.put("bind_serailno", paramAuthen.vwo);
    }
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
      this.vtm.put("language", ab.eUO());
    }
    if (!bs.isNullOrNil(paramAuthen.BsL)) {
      this.vtm.put("true_name", paramAuthen.BsL);
    }
    if (!bs.isNullOrNil(paramAuthen.BtB)) {
      this.vtm.put("identify_card", paramAuthen.BtB);
    }
    if (paramAuthen.BtC > 0) {
      this.vtm.put("cre_type", paramAuthen.BtC);
    }
    if (!bs.isNullOrNil(paramAuthen.BoQ)) {
      this.vtm.put("mobile_no", paramAuthen.BoQ);
    }
    this.vtm.put("bank_card_id", paramAuthen.BtD);
    if (!bs.isNullOrNil(paramAuthen.BtE)) {
      this.vtm.put("cvv2", paramAuthen.BtE);
    }
    if (!bs.isNullOrNil(paramAuthen.BtF)) {
      this.vtm.put("valid_thru", paramAuthen.BtF);
    }
    if ((paramAuthen.drx == 1) || (paramAuthen.drx == 2))
    {
      this.vtm.put("creid_renewal", String.valueOf(paramAuthen.BsV));
      this.vtm.put("birth_date", paramAuthen.Bta);
      this.vtm.put("cre_expire_date", paramAuthen.BsW);
    }
    if (((paramAuthen.drx == 2) || (paramAuthen.drx == 5)) && (paramAuthen.BtQ == 1) && (!bs.isNullOrNil(paramAuthen.Bpa)))
    {
      this.vtm.put("verify_user_token", "1");
      this.vtm.put("usertoken", paramAuthen.Bpa);
    }
    if ((!bs.isNullOrNil(paramAuthen.BtR)) && (paramAuthen.BtR.isEmpty())) {
      this.vtm.put("checkpayjsapi_token", paramAuthen.BtR);
    }
    if (z.fAn())
    {
      this.BhX.put("uuid_for_bindcard", z.getBindCardUuid());
      this.BhX.put("bindcard_scene", z.fAo());
    }
    if (!bs.isNullOrNil(paramString1)) {
      this.vtm.put("has_underage_alert", paramString1);
    }
    setRequestData(this.vtm);
    setWXRequestData(this.BhX);
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
      this.Bom = t.bd(paramJSONObject);
    }
    AppMethodBeat.o(69884);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(69883);
    super.resend();
    this.vtm.put("is_repeat_send", "1");
    setRequestData(this.vtm);
    this.BhW = true;
    AppMethodBeat.o(69883);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */