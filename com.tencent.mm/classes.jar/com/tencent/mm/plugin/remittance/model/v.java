package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v
  extends m
{
  public String CoU;
  public b yXE;
  public String yXG;
  public String yXI;
  public b zdG;
  
  public v(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2)
  {
    this(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, "");
    AppMethodBeat.i(67883);
    AppMethodBeat.o(67883);
  }
  
  public v(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    AppMethodBeat.i(213733);
    this.CoU = null;
    this.yXI = "";
    this.yXG = "";
    this.CoU = paramString3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString2);
    localHashMap.put("transaction_id", paramString1);
    localHashMap.put("op", paramString3);
    localHashMap.put("username", paramString4);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    localHashMap.put("total_fee", String.valueOf(paramInt1));
    localHashMap.put("left_button_continue", paramString5);
    Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + paramString2 + ";transaction_id=" + paramString1 + ";total_fee=" + paramInt1);
    setRequestData(localHashMap);
    AppMethodBeat.o(213733);
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
      this.yXI = paramString.optString("guide_flag", "0");
    }
    if (paramJSONObject.has("intercept_win")) {
      this.yXE = b.bV(paramJSONObject.optJSONObject("intercept_win"));
    }
    if (paramJSONObject.has("intercept_win_after")) {
      this.zdG = b.bV(paramJSONObject.optJSONObject("intercept_win_after"));
    }
    if (paramJSONObject.has("left_button_continue")) {
      this.yXG = paramJSONObject.optString("left_button_continue");
    }
    AppMethodBeat.o(67884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.v
 * JD-Core Version:    0.7.0.1
 */