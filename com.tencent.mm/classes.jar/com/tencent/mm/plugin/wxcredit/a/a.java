package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends j
{
  public String bSe;
  public boolean cde = true;
  private Map<String, String> mLt = new HashMap();
  public boolean rQF = false;
  public String token;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mLt.put("session_key", paramString3);
    this.mLt.put("bank_type", paramString4);
    this.mLt.put("name", paramString1);
    this.mLt.put("cre_id", paramString2);
    D(this.mLt);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    try
    {
      this.token = paramJSONObject.optString("session_key");
      this.cde = "1".equals(paramJSONObject.getString("need_bind"));
      this.rQF = "1".equals(paramJSONObject.getString("bank_user"));
      this.bSe = paramJSONObject.optString("mobile_no");
      return;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
    }
  }
  
  public final int aEC()
  {
    return 64;
  }
  
  public final boolean bqc()
  {
    super.bqc();
    this.mLt.put("retry", "1");
    D(this.mLt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.a
 * JD-Core Version:    0.7.0.1
 */