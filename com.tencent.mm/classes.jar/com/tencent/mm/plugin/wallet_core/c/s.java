package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends m
{
  public String DgC;
  public String DgD;
  public Orders.Promotions DgF;
  public String fMT;
  
  public s(Orders.Promotions paramPromotions, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(69930);
    this.DgF = paramPromotions;
    HashMap localHashMap = new HashMap();
    localHashMap.put("activity_id", paramPromotions.vlr);
    localHashMap.put("award_id", paramPromotions.JhS);
    localHashMap.put("send_record_id", paramPromotions.Dpo);
    localHashMap.put("user_record_id", paramPromotions.Dpp);
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
    ae.i("MicroMsg.NetSenceTenPayBase", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if ((paramJSONObject != null) && (paramInt == 0))
    {
      this.DgC = paramJSONObject.optString("result_code");
      this.fMT = paramJSONObject.optString("result_msg");
      this.DgD = paramJSONObject.optString("alert_wording");
    }
    AppMethodBeat.o(69931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.s
 * JD-Core Version:    0.7.0.1
 */