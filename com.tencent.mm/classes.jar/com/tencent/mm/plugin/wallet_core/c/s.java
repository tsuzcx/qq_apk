package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends m
{
  public String HPV;
  public String HPW;
  public Orders.Promotions HPY;
  public String resultMsg;
  
  public s(Orders.Promotions paramPromotions, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(69930);
    this.HPY = paramPromotions;
    HashMap localHashMap = new HashMap();
    localHashMap.put("activity_id", paramPromotions.crw);
    localHashMap.put("award_id", paramPromotions.Utw);
    localHashMap.put("send_record_id", paramPromotions.HYC);
    localHashMap.put("user_record_id", paramPromotions.HYD);
    localHashMap.put("req_key", paramString1);
    localHashMap.put("transaction_id", paramString2);
    localHashMap.put("activity_mch_id", String.valueOf(paramLong));
    setRequestData(localHashMap);
    AppMethodBeat.o(69930);
  }
  
  public final int getFuncId()
  {
    return 1589;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1589;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/sendpayaward";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69931);
    Log.i("MicroMsg.NetSenceTenPayBase", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if ((paramJSONObject != null) && (paramInt == 0))
    {
      this.HPV = paramJSONObject.optString("result_code");
      this.resultMsg = paramJSONObject.optString("result_msg");
      this.HPW = paramJSONObject.optString("alert_wording");
    }
    AppMethodBeat.o(69931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.s
 * JD-Core Version:    0.7.0.1
 */