package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  public String mReqKey;
  private Map<String, String> plK;
  private Map<String, String> tVp;
  private String token;
  
  public a(Authen paramAuthen)
  {
    AppMethodBeat.i(46483);
    this.mReqKey = null;
    this.token = null;
    this.plK = new HashMap();
    this.tVp = new HashMap();
    setPayInfo(paramAuthen.pVo, this.plK, this.tVp);
    this.plK.put("flag", paramAuthen.bsY);
    this.plK.put("bank_type", paramAuthen.poq);
    this.plK.put("mobile_area", paramAuthen.ufm);
    if (!bo.isNullOrNil(paramAuthen.ueW)) {
      this.plK.put("passwd", paramAuthen.ueW);
    }
    if (!bo.isNullOrNil(paramAuthen.token)) {
      this.plK.put("token", paramAuthen.token);
    }
    if (!bo.isNullOrNil(paramAuthen.tSv))
    {
      g.RM();
      p localp = new p(bo.a((Integer)g.RL().Ru().get(9, null), 0));
      this.plK.put("import_code", paramAuthen.tSv);
      this.plK.put("qqid", localp.toString());
      if (paramAuthen.ueY > 0) {
        this.plK.put("cre_type", paramAuthen.ueY);
      }
      this.plK.put("bind_serailno", paramAuthen.por);
    }
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
      this.plK.put("language", aa.dsG());
    }
    if (!bo.isNullOrNil(paramAuthen.ueu)) {
      this.plK.put("true_name", paramAuthen.ueu);
    }
    if (!bo.isNullOrNil(paramAuthen.ueX)) {
      this.plK.put("identify_card", paramAuthen.ueX);
    }
    if (paramAuthen.ueY > 0) {
      this.plK.put("cre_type", paramAuthen.ueY);
    }
    if (!bo.isNullOrNil(paramAuthen.ubQ)) {
      this.plK.put("mobile_no", paramAuthen.ubQ);
    }
    this.plK.put("bank_card_id", paramAuthen.ueZ);
    if (!bo.isNullOrNil(paramAuthen.ufa)) {
      this.plK.put("cvv2", paramAuthen.ufa);
    }
    if (!bo.isNullOrNil(paramAuthen.ufb)) {
      this.plK.put("valid_thru", paramAuthen.ufb);
    }
    if ((paramAuthen.bsY == 1) || (paramAuthen.bsY == 2))
    {
      this.plK.put("creid_renewal", String.valueOf(paramAuthen.ueC));
      this.plK.put("birth_date", paramAuthen.ueE);
      this.plK.put("cre_expire_date", paramAuthen.ufn);
    }
    if (x.dSp())
    {
      this.tVp.put("uuid_for_bindcard", x.dSr());
      this.tVp.put("bindcard_scene", x.dSq());
    }
    setRequestData(this.plK);
    setWXRequestData(this.tVp);
    AppMethodBeat.o(46483);
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
    AppMethodBeat.i(46485);
    if (paramJSONObject != null)
    {
      this.mReqKey = paramJSONObject.optString("req_key");
      this.token = paramJSONObject.optString("token");
    }
    AppMethodBeat.o(46485);
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(46484);
    super.resend();
    this.plK.put("is_repeat_send", "1");
    setRequestData(this.plK);
    AppMethodBeat.o(46484);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.a
 * JD-Core Version:    0.7.0.1
 */