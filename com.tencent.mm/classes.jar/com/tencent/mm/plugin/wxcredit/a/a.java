package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends m
{
  public boolean cLO;
  public String czF;
  private Map<String, String> plK;
  public String token;
  public boolean vHw;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48652);
    this.cLO = true;
    this.vHw = false;
    this.plK = new HashMap();
    this.plK.put("session_key", paramString3);
    this.plK.put("bank_type", paramString4);
    this.plK.put("name", paramString1);
    this.plK.put("cre_id", paramString2);
    setRequestData(this.plK);
    AppMethodBeat.o(48652);
  }
  
  public final int getTenpayCgicmd()
  {
    return 64;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48654);
    ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(48654);
      return;
    }
    try
    {
      this.token = paramJSONObject.optString("session_key");
      this.cLO = "1".equals(paramJSONObject.getString("need_bind"));
      this.vHw = "1".equals(paramJSONObject.getString("bank_user"));
      this.czF = paramJSONObject.optString("mobile_no");
      AppMethodBeat.o(48654);
      return;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
      AppMethodBeat.o(48654);
    }
  }
  
  public final boolean resend()
  {
    AppMethodBeat.i(48653);
    super.resend();
    this.plK.put("retry", "1");
    setRequestData(this.plK);
    AppMethodBeat.o(48653);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.a
 * JD-Core Version:    0.7.0.1
 */