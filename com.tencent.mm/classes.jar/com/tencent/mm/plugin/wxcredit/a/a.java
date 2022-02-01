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
  public boolean EGr;
  public boolean dML;
  public String dzn;
  public String token;
  private Map<String, String> wyE;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(72296);
    this.dML = true;
    this.EGr = false;
    this.wyE = new HashMap();
    this.wyE.put("session_key", paramString3);
    this.wyE.put("bank_type", paramString4);
    this.wyE.put("name", paramString1);
    this.wyE.put("cre_id", paramString2);
    setRequestData(this.wyE);
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
      this.dML = "1".equals(paramJSONObject.getString("need_bind"));
      this.EGr = "1".equals(paramJSONObject.getString("bank_user"));
      this.dzn = paramJSONObject.optString("mobile_no");
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
    this.wyE.put("retry", "1");
    setRequestData(this.wyE);
    AppMethodBeat.o(72297);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.a
 * JD-Core Version:    0.7.0.1
 */