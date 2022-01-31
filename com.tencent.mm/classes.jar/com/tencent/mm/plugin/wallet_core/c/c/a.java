package com.tencent.mm.plugin.wallet_core.c.c;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class a
  extends j
{
  private int qrr;
  public Orders qrs;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    this.qrr = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramString1);
    localHashMap.put("timeStamp", paramString2);
    localHashMap.put("nonceStr", paramString3);
    localHashMap.put("package", paramString4);
    localHashMap.put("reqKey", paramString5);
    localHashMap.put("payScene", String.valueOf(paramInt));
    localHashMap.put("signType", paramString6);
    localHashMap.put("paySign", paramString7);
    D(localHashMap);
  }
  
  private Orders ak(JSONObject paramJSONObject)
  {
    if (this.qrs == null) {
      this.qrs = new Orders();
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("payresult");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        Orders.Commodity localCommodity = new Orders.Commodity();
        localCommodity.bMY = localJSONObject.getString("transaction_id");
        localCommodity.mOO = localJSONObject.optString("sp_name");
        if (bk.bl(this.qrs.mOZ)) {
          this.qrs.mOZ = localJSONObject.optString("fee_type");
        }
        this.qrs.qwN.add(localCommodity);
        i += 1;
      }
      return this.qrs;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public final int HH()
  {
    int i = 2570;
    if (this.qrr == 2) {
      i = 2516;
    }
    return i;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    Log.i("MicroMsg.NetSceneGetPaidOrderDetail", "errCode: " + paramInt + " errMsg: " + paramString);
    if ((paramJSONObject != null) && (cMw()))
    {
      this.qrs = ak(paramJSONObject);
      this.qrs = Orders.a(paramJSONObject, this.qrs);
    }
  }
  
  public final int aEC()
  {
    int i = 2570;
    if (this.qrr == 2) {
      i = 2516;
    }
    return i;
  }
  
  public final String getUri()
  {
    String str = "/cgi-bin/mmpay-bin/tenpay/getpaidorderdetail";
    if (this.qrr == 2) {
      str = "/cgi-bin/mmpay-bin/tenpay/offlinegetpaidorderdetail";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c.a
 * JD-Core Version:    0.7.0.1
 */