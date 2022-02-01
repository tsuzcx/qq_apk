package com.tencent.mm.plugin.wallet_core.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class a
  extends m
{
  private int CPN;
  public Orders CPO;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69979);
    Log.i("MicroMsg.NetSceneGetPaidOrderDetail", "do NetSceneGetPaidOrderDetail");
    this.CPN = paramInt;
    HashMap localHashMap = new HashMap();
    if (bt.isNullOrNil(paramString1))
    {
      localHashMap.put("appId", paramString1);
      if (!bt.isNullOrNil(paramString2)) {
        break label203;
      }
      label56:
      localHashMap.put("timeStamp", paramString2);
      if (!bt.isNullOrNil(paramString3)) {
        break label211;
      }
      label74:
      localHashMap.put("nonceStr", paramString3);
      if (!bt.isNullOrNil(paramString4)) {
        break label219;
      }
      label93:
      localHashMap.put("package", paramString4);
      if (!bt.isNullOrNil(paramString5)) {
        break label229;
      }
      label113:
      localHashMap.put("reqKey", paramString5);
      localHashMap.put("payScene", q.encode(String.valueOf(paramInt)));
      if (!bt.isNullOrNil(paramString6)) {
        break label239;
      }
      label151:
      localHashMap.put("signType", paramString6);
      if (!bt.isNullOrNil(paramString7)) {
        break label249;
      }
    }
    for (;;)
    {
      localHashMap.put("paySign", paramString7);
      setRequestData(localHashMap);
      AppMethodBeat.o(69979);
      return;
      paramString1 = q.encode(paramString1);
      break;
      label203:
      paramString2 = q.encode(paramString2);
      break label56;
      label211:
      paramString3 = q.encode(paramString3);
      break label74;
      label219:
      paramString4 = q.encode(paramString4);
      break label93;
      label229:
      paramString5 = q.encode(paramString5);
      break label113;
      label239:
      paramString6 = q.encode(paramString6);
      break label151;
      label249:
      paramString7 = q.encode(paramString7);
    }
  }
  
  private Orders aY(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69981);
    if (this.CPO == null) {
      this.CPO = new Orders();
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("payresult");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        Orders.Commodity localCommodity = new Orders.Commodity();
        localCommodity.dlv = localJSONObject.getString("transaction_id");
        localCommodity.wCu = localJSONObject.optString("sp_name");
        if (bt.isNullOrNil(this.CPO.wCF)) {
          this.CPO.wCF = localJSONObject.optString("fee_type");
        }
        this.CPO.CYk.add(localCommodity);
        i += 1;
      }
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject = this.CPO;
      AppMethodBeat.o(69981);
    }
  }
  
  public final int getFuncId()
  {
    int i = 2570;
    if (this.CPN == 2) {
      i = 2516;
    }
    return i;
  }
  
  public final int getTenpayCgicmd()
  {
    int i = 2570;
    if (this.CPN == 2) {
      i = 2516;
    }
    return i;
  }
  
  public final String getUri()
  {
    String str = "/cgi-bin/mmpay-bin/tenpay/getpaidorderdetail";
    if (this.CPN == 2) {
      str = "/cgi-bin/mmpay-bin/tenpay/offlinegetpaidorderdetail";
    }
    return str;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69980);
    Log.i("MicroMsg.NetSceneGetPaidOrderDetail", "errCode: " + paramInt + " errMsg: " + paramString);
    if ((paramJSONObject != null) && (isPayEnd()))
    {
      this.CPO = aY(paramJSONObject);
      this.CPO = Orders.a(paramJSONObject, this.CPO);
    }
    AppMethodBeat.o(69980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c.a
 * JD-Core Version:    0.7.0.1
 */