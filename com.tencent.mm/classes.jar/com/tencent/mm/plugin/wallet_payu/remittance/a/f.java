package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends a
{
  public f(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("total_fee", String.valueOf(paramInt1));
    localHashMap.put("fee_type", paramString2);
    localHashMap.put("receiver_name", paramString3);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetScenePayURemitttanceRetry", "errCode " + paramInt + " errMsg: " + paramString);
  }
  
  public final int bUM()
  {
    return 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.f
 * JD-Core Version:    0.7.0.1
 */