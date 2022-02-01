package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends m
{
  public boolean Dcr;
  public boolean dAy;
  public String dnz;
  public String token;
  private Map<String, String> vtm;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(72296);
    this.dAy = true;
    this.Dcr = false;
    this.vtm = new HashMap();
    this.vtm.put("session_key", paramString3);
    this.vtm.put("bank_type", paramString4);
    this.vtm.put("name", paramString1);
    this.vtm.put("cre_id", paramString2);
    setRequestData(this.vtm);
    AppMethodBeat.o(72296);
  }
  
  public final int getTenpayCgicmd()
  {
    return 64;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72298);
    ac.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72298);
      return;
    }
    try
    {
      this.token = paramJSONObject.optString("session_key");
      this.dAy = "1".equals(paramJSONObject.getString("need_bind"));
      this.Dcr = "1".equals(paramJSONObject.getString("bank_user"));
      this.dnz = paramJSONObject.optString("mobile_no");
      AppMethodBeat.o(72298);
      return;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
      AppMethodBeat.o(72298);
    }
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(72297);
    super.resend();
    this.vtm.put("retry", "1");
    setRequestData(this.vtm);
    AppMethodBeat.o(72297);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.a
 * JD-Core Version:    0.7.0.1
 */