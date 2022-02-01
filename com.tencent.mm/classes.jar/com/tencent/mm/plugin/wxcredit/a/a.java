package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends m
{
  public boolean BKi;
  public boolean dCM;
  public String dpO;
  public String token;
  private Map<String, String> ukq;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(72296);
    this.dCM = true;
    this.BKi = false;
    this.ukq = new HashMap();
    this.ukq.put("session_key", paramString3);
    this.ukq.put("bank_type", paramString4);
    this.ukq.put("name", paramString1);
    this.ukq.put("cre_id", paramString2);
    setRequestData(this.ukq);
    AppMethodBeat.o(72296);
  }
  
  public final int getTenpayCgicmd()
  {
    return 64;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72298);
    ad.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72298);
      return;
    }
    try
    {
      this.token = paramJSONObject.optString("session_key");
      this.dCM = "1".equals(paramJSONObject.getString("need_bind"));
      this.BKi = "1".equals(paramJSONObject.getString("bank_user"));
      this.dpO = paramJSONObject.optString("mobile_no");
      AppMethodBeat.o(72298);
      return;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
      AppMethodBeat.o(72298);
    }
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(72297);
    super.resend();
    this.ukq.put("retry", "1");
    setRequestData(this.ukq);
    AppMethodBeat.o(72297);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.a
 * JD-Core Version:    0.7.0.1
 */