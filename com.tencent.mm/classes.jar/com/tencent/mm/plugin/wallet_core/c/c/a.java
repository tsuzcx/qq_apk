package com.tencent.mm.plugin.wallet_core.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bo;
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
  private int ucp;
  public Orders ucq;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    AppMethodBeat.i(46572);
    this.ucp = paramInt;
    HashMap localHashMap = new HashMap();
    if (bo.isNullOrNil(paramString1))
    {
      localHashMap.put("appId", paramString1);
      if (!bo.isNullOrNil(paramString2)) {
        break label196;
      }
      label49:
      localHashMap.put("timeStamp", paramString2);
      if (!bo.isNullOrNil(paramString3)) {
        break label204;
      }
      label67:
      localHashMap.put("nonceStr", paramString3);
      if (!bo.isNullOrNil(paramString4)) {
        break label212;
      }
      label86:
      localHashMap.put("package", paramString4);
      if (!bo.isNullOrNil(paramString5)) {
        break label222;
      }
      label106:
      localHashMap.put("reqKey", paramString5);
      localHashMap.put("payScene", q.encode(String.valueOf(paramInt)));
      if (!bo.isNullOrNil(paramString6)) {
        break label232;
      }
      label144:
      localHashMap.put("signType", paramString6);
      if (!bo.isNullOrNil(paramString7)) {
        break label242;
      }
    }
    for (;;)
    {
      localHashMap.put("paySign", paramString7);
      setRequestData(localHashMap);
      AppMethodBeat.o(46572);
      return;
      paramString1 = q.encode(paramString1);
      break;
      label196:
      paramString2 = q.encode(paramString2);
      break label49;
      label204:
      paramString3 = q.encode(paramString3);
      break label67;
      label212:
      paramString4 = q.encode(paramString4);
      break label86;
      label222:
      paramString5 = q.encode(paramString5);
      break label106;
      label232:
      paramString6 = q.encode(paramString6);
      break label144;
      label242:
      paramString7 = q.encode(paramString7);
    }
  }
  
  private Orders au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46574);
    if (this.ucq == null) {
      this.ucq = new Orders();
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("payresult");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        Orders.Commodity localCommodity = new Orders.Commodity();
        localCommodity.cnJ = localJSONObject.getString("transaction_id");
        localCommodity.ppe = localJSONObject.optString("sp_name");
        if (bo.isNullOrNil(this.ucq.ppp)) {
          this.ucq.ppp = localJSONObject.optString("fee_type");
        }
        this.ucq.ujl.add(localCommodity);
        i += 1;
      }
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject = this.ucq;
      AppMethodBeat.o(46574);
    }
  }
  
  public final int getFuncId()
  {
    int i = 2570;
    if (this.ucp == 2) {
      i = 2516;
    }
    return i;
  }
  
  public final int getTenpayCgicmd()
  {
    int i = 2570;
    if (this.ucp == 2) {
      i = 2516;
    }
    return i;
  }
  
  public final String getUri()
  {
    String str = "/cgi-bin/mmpay-bin/tenpay/getpaidorderdetail";
    if (this.ucp == 2) {
      str = "/cgi-bin/mmpay-bin/tenpay/offlinegetpaidorderdetail";
    }
    return str;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46573);
    Log.i("MicroMsg.NetSceneGetPaidOrderDetail", "errCode: " + paramInt + " errMsg: " + paramString);
    if ((paramJSONObject != null) && (isPayEnd()))
    {
      this.ucq = au(paramJSONObject);
      this.ucq = Orders.a(paramJSONObject, this.ucq);
    }
    AppMethodBeat.o(46573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c.a
 * JD-Core Version:    0.7.0.1
 */