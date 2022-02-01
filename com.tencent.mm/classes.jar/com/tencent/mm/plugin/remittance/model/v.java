package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v
  extends m
{
  public String vqA;
  public b vqy;
  public String xYm;
  
  public v(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(67883);
    this.xYm = null;
    this.vqA = "";
    this.xYm = paramString3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString2);
    localHashMap.put("transaction_id", paramString1);
    localHashMap.put("op", paramString3);
    localHashMap.put("username", paramString4);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    localHashMap.put("total_fee", String.valueOf(paramInt1));
    ad.i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + paramString2 + ";transaction_id=" + paramString1 + ";total_fee=" + paramInt1);
    setRequestData(localHashMap);
    AppMethodBeat.o(67883);
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
    ad.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(67884);
      return;
    }
    paramString = paramJSONObject.optJSONObject("real_name_info");
    if (paramString != null) {
      this.vqA = paramString.optString("guide_flag", "0");
    }
    if (paramJSONObject.has("intercept_win")) {
      this.vqy = b.bw(paramJSONObject.optJSONObject("intercept_win"));
    }
    AppMethodBeat.o(67884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.v
 * JD-Core Version:    0.7.0.1
 */