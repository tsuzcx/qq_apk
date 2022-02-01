package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends m
{
  private Map<String, String> AJV;
  public boolean JPE;
  public String dSf;
  public boolean efW;
  public String token;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(72296);
    this.efW = true;
    this.JPE = false;
    this.AJV = new HashMap();
    this.AJV.put("session_key", paramString3);
    this.AJV.put("bank_type", paramString4);
    this.AJV.put("name", paramString1);
    this.AJV.put("cre_id", paramString2);
    setRequestData(this.AJV);
    AppMethodBeat.o(72296);
  }
  
  public final int getTenpayCgicmd()
  {
    return 64;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72298);
    Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72298);
      return;
    }
    try
    {
      this.token = paramJSONObject.optString("session_key");
      this.efW = "1".equals(paramJSONObject.getString("need_bind"));
      this.JPE = "1".equals(paramJSONObject.getString("bank_user"));
      this.dSf = paramJSONObject.optString("mobile_no");
      AppMethodBeat.o(72298);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
      AppMethodBeat.o(72298);
    }
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(72297);
    super.resend();
    this.AJV.put("retry", "1");
    setRequestData(this.AJV);
    AppMethodBeat.o(72297);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.a
 * JD-Core Version:    0.7.0.1
 */