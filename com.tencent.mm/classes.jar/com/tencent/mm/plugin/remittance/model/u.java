package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u
  extends j
{
  public String lRC = "";
  public String nyy = null;
  
  public u(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2)
  {
    this.nyy = paramString3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString2);
    localHashMap.put("transaction_id", paramString1);
    localHashMap.put("op", paramString3);
    localHashMap.put("username", paramString4);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    localHashMap.put("total_fee", String.valueOf(paramInt1));
    y.i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + paramString2 + ";transaction_id=" + paramString1 + ";total_fee=" + paramInt1);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1691;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {}
    do
    {
      return;
      paramString = paramJSONObject.optJSONObject("real_name_info");
    } while (paramString == null);
    this.lRC = paramString.optString("guide_flag", "0");
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transferoperation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.u
 * JD-Core Version:    0.7.0.1
 */