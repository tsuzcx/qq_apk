package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  public String mReqKey;
  private String token;
  private Map<String, String> ukq;
  public boolean zPC;
  private Map<String, String> zPD;
  public t zVS;
  
  public a(Authen paramAuthen, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69882);
    this.mReqKey = null;
    this.token = null;
    this.ukq = new HashMap();
    this.zPD = new HashMap();
    setPayInfo(paramAuthen.uXi, this.ukq, this.zPD);
    this.ukq.put("flag", paramAuthen.dtM);
    this.ukq.put("bank_type", paramAuthen.dca);
    this.ukq.put("mobile_area", paramAuthen.Abv);
    this.ukq.put("session_id", paramString2);
    if (!bt.isNullOrNil(paramAuthen.Abg)) {
      this.ukq.put("passwd", paramAuthen.Abg);
    }
    if (!bt.isNullOrNil(paramAuthen.token)) {
      this.ukq.put("token", paramAuthen.token);
    }
    if (!bt.isNullOrNil(paramAuthen.zMD))
    {
      g.afC();
      paramString2 = new p(bt.a((Integer)g.afB().afk().get(9, null), 0));
      this.ukq.put("import_code", paramAuthen.zMD);
      this.ukq.put("qqid", paramString2.toString());
      if (paramAuthen.Abi > 0) {
        this.ukq.put("cre_type", paramAuthen.Abi);
      }
      this.ukq.put("bind_serailno", paramAuthen.uns);
    }
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
      this.ukq.put("language", ac.eFu());
    }
    if (!bt.isNullOrNil(paramAuthen.Aar)) {
      this.ukq.put("true_name", paramAuthen.Aar);
    }
    if (!bt.isNullOrNil(paramAuthen.Abh)) {
      this.ukq.put("identify_card", paramAuthen.Abh);
    }
    if (paramAuthen.Abi > 0) {
      this.ukq.put("cre_type", paramAuthen.Abi);
    }
    if (!bt.isNullOrNil(paramAuthen.zWw)) {
      this.ukq.put("mobile_no", paramAuthen.zWw);
    }
    this.ukq.put("bank_card_id", paramAuthen.Abj);
    if (!bt.isNullOrNil(paramAuthen.Abk)) {
      this.ukq.put("cvv2", paramAuthen.Abk);
    }
    if (!bt.isNullOrNil(paramAuthen.Abl)) {
      this.ukq.put("valid_thru", paramAuthen.Abl);
    }
    if ((paramAuthen.dtM == 1) || (paramAuthen.dtM == 2))
    {
      this.ukq.put("creid_renewal", String.valueOf(paramAuthen.AaB));
      this.ukq.put("birth_date", paramAuthen.AaG);
      this.ukq.put("cre_expire_date", paramAuthen.AaC);
    }
    if (((paramAuthen.dtM == 2) || (paramAuthen.dtM == 5)) && (paramAuthen.Abw == 1) && (!bt.isNullOrNil(paramAuthen.zWG)))
    {
      this.ukq.put("verify_user_token", "1");
      this.ukq.put("usertoken", paramAuthen.zWG);
    }
    if ((!bt.isNullOrNil(paramAuthen.Abx)) && (paramAuthen.Abx.isEmpty())) {
      this.ukq.put("checkpayjsapi_token", paramAuthen.Abx);
    }
    if (z.fjX())
    {
      this.zPD.put("uuid_for_bindcard", z.getBindCardUuid());
      this.zPD.put("bindcard_scene", z.fjY());
    }
    if (!bt.isNullOrNil(paramString1)) {
      this.ukq.put("has_underage_alert", paramString1);
    }
    setRequestData(this.ukq);
    setWXRequestData(this.zPD);
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
      this.zVS = t.bc(paramJSONObject);
    }
    AppMethodBeat.o(69884);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(69883);
    super.resend();
    this.ukq.put("is_repeat_send", "1");
    setRequestData(this.ukq);
    this.zPC = true;
    AppMethodBeat.o(69883);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */