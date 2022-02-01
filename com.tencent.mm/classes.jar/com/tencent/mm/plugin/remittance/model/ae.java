package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ae
  extends m
{
  public c KBw;
  public c KtV;
  public String KuK;
  public String KuN;
  public String OjA;
  
  public ae(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    this(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, "", paramString5);
  }
  
  public ae(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6)
  {
    AppMethodBeat.i(288793);
    this.OjA = null;
    this.KuN = "";
    this.KuK = "";
    this.OjA = paramString3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString2);
    localHashMap.put("transaction_id", paramString1);
    localHashMap.put("op", paramString3);
    localHashMap.put("username", paramString4);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    localHashMap.put("total_fee", String.valueOf(paramInt1));
    localHashMap.put("left_button_continue", paramString5);
    localHashMap.put("group_username", paramString6);
    Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + paramString2 + ";transaction_id=" + paramString1 + ";total_fee=" + paramInt1);
    setRequestData(localHashMap);
    AppMethodBeat.o(288793);
  }
  
  public final int getFuncId()
  {
    return 1691;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transferoperation";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67884);
    Log.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(67884);
      return;
    }
    paramString = paramJSONObject.optJSONObject("real_name_info");
    if (paramString != null) {
      this.KuN = paramString.optString("guide_flag", "0");
    }
    if (paramJSONObject.has("intercept_win")) {
      this.KtV = c.cC(paramJSONObject.optJSONObject("intercept_win"));
    }
    if (paramJSONObject.has("intercept_win_after")) {
      this.KBw = c.cC(paramJSONObject.optJSONObject("intercept_win_after"));
    }
    if (paramJSONObject.has("left_button_continue")) {
      this.KuK = paramJSONObject.optString("left_button_continue");
    }
    AppMethodBeat.o(67884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ae
 * JD-Core Version:    0.7.0.1
 */