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
  private Map<String, String> Kvm;
  public boolean XHu;
  public String hRk;
  public boolean igv;
  public String token;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(72296);
    this.igv = true;
    this.XHu = false;
    this.Kvm = new HashMap();
    this.Kvm.put("session_key", paramString3);
    this.Kvm.put("bank_type", paramString4);
    this.Kvm.put("name", paramString1);
    this.Kvm.put("cre_id", paramString2);
    setRequestData(this.Kvm);
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
      this.igv = "1".equals(paramJSONObject.getString("need_bind"));
      this.XHu = "1".equals(paramJSONObject.getString("bank_user"));
      this.hRk = paramJSONObject.optString("mobile_no");
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
    this.Kvm.put("retry", "1");
    setRequestData(this.Kvm);
    AppMethodBeat.o(72297);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.a
 * JD-Core Version:    0.7.0.1
 */