package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends j
{
  public String dmU;
  public String qqN;
  public String qqO;
  public Orders.Promotions qqQ;
  
  public n(Orders.Promotions paramPromotions, String paramString1, String paramString2, long paramLong)
  {
    this.qqQ = paramPromotions;
    HashMap localHashMap = new HashMap();
    localHashMap.put("activity_id", paramPromotions.qqG);
    localHashMap.put("award_id", paramPromotions.qxC);
    localHashMap.put("send_record_id", paramPromotions.qwm);
    localHashMap.put("user_record_id", paramPromotions.qwn);
    localHashMap.put("req_key", paramString1);
    localHashMap.put("transaction_id", paramString2);
    localHashMap.put("activity_mch_id", String.valueOf(paramLong));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1589;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSenceTenPayBase", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if ((paramJSONObject != null) && (paramInt == 0))
    {
      this.qqN = paramJSONObject.optString("result_code");
      this.dmU = paramJSONObject.optString("result_msg");
      this.qqO = paramJSONObject.optString("alert_wording");
    }
  }
  
  public final int aEC()
  {
    return 1589;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/sendpayaward";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */