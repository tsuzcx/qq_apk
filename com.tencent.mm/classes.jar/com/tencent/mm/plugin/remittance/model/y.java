package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y
  extends j
{
  public y(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("receiver_name", paramString2);
    localHashMap.put("from", String.valueOf(paramInt2));
    localHashMap.put("invalid_time", String.valueOf(paramInt1));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1545;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.y.d("Micromsg.NetSceneTenpayRemittanceResendMsg", "errCode " + paramInt + " errMsg: " + paramString);
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transferresendmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.y
 * JD-Core Version:    0.7.0.1
 */